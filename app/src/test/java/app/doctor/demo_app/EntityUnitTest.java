package app.doctor.demo_app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import app.doctor.demo_app.data.remote.model.UserItem;

import static org.junit.Assert.assertEquals;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(JUnit4.class)
public class EntityUnitTest {

    @Test
    public void testId() {
        UserItem userItem = new UserItem();
        userItem.setMemberIdx("test");
        assertEquals(userItem.getMemberIdx(), "test");
    }

}
