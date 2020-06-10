package app.doctor.demo_app.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Collection;

import app.doctor.demo_app.DemoApp;

/**
 * Created by luonglc on 7/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
public class Utils {


    public static void savePreference(String key, String value) {
        SharedPreferences.Editor editor = DemoApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void savePreference(String key, Boolean value) {
        SharedPreferences.Editor editor = DemoApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void savePreference(String key, long value) {
        SharedPreferences.Editor editor = DemoApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static void hideSoftKeyboard(Activity activity) {
        View v = activity.getCurrentFocus();
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            v.setFocusableInTouchMode(true);
        }
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private static void hideSoftKeyboardWhenClickOutsideDialogFragment(Dialog dialog) {
        View v = dialog.getWindow().getCurrentFocus();
        if (v != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) dialog.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
            v.setFocusableInTouchMode(true);
        }
    }

    public static String getStringValue(String key) {
        SharedPreferences settings = DemoApp.getInstance().getSharedPreferences(
                Constants.SHARED_PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        return settings.getString(key, Constants.BLANK);
    }

    public static <T> boolean checkListIsEmpty(Collection<T> list) {
        return list == null || list.isEmpty();
    }
}

