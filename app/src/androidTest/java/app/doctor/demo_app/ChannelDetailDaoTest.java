package app.doctor.demo_app;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import app.doctor.demo_app.data.local.DemoAppDatabase;
import app.doctor.demo_app.data.remote.model.ChannelDetail;
import app.doctor.demo_app.data.remote.model.ChannelItem;

import static org.junit.Assert.assertNotNull;

/**
 * Created by luonglc on 10/6/2020
 * E: lecongluong94@gmail.com
 * C: ANTS Programmatic Company
 * A: HCMC, VN
 */
@RunWith(AndroidJUnit4.class)
public class ChannelDetailDaoTest {
    private DemoAppDatabase database;

    @Before
    public void init() {
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), DemoAppDatabase.class).build();
    }

    @After
    public void unit() {
        database.close();
    }

    @Test
    public void testLoadChannelDetail() {
        ChannelDetail entity = new ChannelDetail();
        entity.setBoardIdx("17");
        entity.setCategoryIdx("1");
        entity.setCategory("오늘뭐먹지");
        entity.setBoarType("board");
        entity.setInsDate("2020.05.05");
        entity.setContentsYn("Y");
        entity.setLikeCnt("0");
        entity.setTitle("5월 제철식재료 딸기");
        entity.setImgPath("http://dev-admin.martjangbogo.com/media/commonfile/202005/08/f891bab61fabf768e98b6d1f95ab7d41.png");
        entity.setContents("<!DOCTYPE html>\\r\\n\\t\\t\\t\\t\\t<html lang=\\\"ko\\\" style=\\\"width:100%\\\">\\r\\n\\t\\t\\t\\t\\t<head>\\" +
                "r\\n\\t\\t\\t\\t\\t<meta name=\\\"viewport\\\" content=\\\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\\\">\\r\\n\\t\\t\\t\\t\\t<meta http-equiv=\\\"X-UA-Compatible\\\" content=\\\"IE=edge,chrome=1\\\" />\\r\\n\\t\\t\\t\\t\\t<link rel=\\\"stylesheet\\\" href=\\\"/css/style.css\\\">\\r\\n\\t\\t\\t\\t\\t<link href=\\\"http://www.jqueryscript.net/css/jquerysctipttop.css\\\" rel=\\\"stylesheet\\\" type=\\\"text/css\\\">\\r\\n\\t\\t\\t\\t\\t<style>\\r\\n\\t\\t\\t\\t\\t\\t.video_wrap {position: relative; height:0; padding-bottom: 56.25%; margin: 0px 0px;}\\r\\n\\t\\t\\t\\t\\t\\t.video_wrap > iframe { position: absolute; width:100%; height:100%; }\\r\\n\\t\\t\\t\\t\\t\\t.instagram_wrap {position: relative; height:0; padding-bottom: 128%; }\\r\\n\\t\\t\\t\\t\\t\\t.instagram_wrap > iframe { position: absolute; width:100%; height:100%; }\\r\\n\\t\\t\\t\\t\\t</style>\\r\\n\\t\\t\\t\\t\\t</head>\\r\\n\\t\\t\\t\\t\\t<body style=\\\"width:100%\\\">\\r\\n\\t\\t\\t\\t\\t\\t<div id=\\\"container\\\" style=\\\"max-width:100%\\\"><p><img src=\\\"http://dev-admin.martjangbogo.com/media/commonfile/202005/08/35822b3f90d6a2cea6e86de98ca02f1a.jpg\\\" style=\\\"max-width: 100%; width: 100%;\\\"><br></p></div>\\r\\n\\t\\t\\t\\t\\t</body></html>");
        entity.setReplyCnt("0");
        entity.setMyLikeYn("N");
        entity.setCorpIdx("0");

        database.chanelDetailDao().saveChannelDetail(entity);
        LiveData<ChannelDetail> data = database.chanelDetailDao().loadChannelDetail("17");
        assertNotNull(data);
    }

}
