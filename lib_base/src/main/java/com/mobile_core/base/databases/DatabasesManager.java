package com.mobile_core.base.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.mobile_core.base.bean.personal.DaoMaster;
import com.mobile_core.base.bean.personal.DaoSession;

/**
 * Created by picher on 2018/7/19.
 * Describe：数据库工厂
 */

public class DatabasesManager {
    public static final String DATABASES_NAME = "databases_exam";
    private static DaoSession daoSession;

    private MotherAppDataHandler dataHandler;

    public MotherAppDataHandler getDataBasesHandler() {
        if(dataHandler == null){
            dataHandler = new MotherAppDataHandler();
        }
        return dataHandler;
    }

    public static void init(Context applicationContext) {
        /*RoomDemoDatabase database = Room.databaseBuilder(applicationContext,
                RoomDemoDatabase.class, DATABASES_NAME)
                .build();*/
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(applicationContext, DATABASES_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
