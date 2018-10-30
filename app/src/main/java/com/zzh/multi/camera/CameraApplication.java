package com.zzh.multi.camera;

import android.app.Application;
import android.util.Log;

/**
 * @date: 2018/10/30
 * @email: zzh_hz@126.com
 * @QQ: 1299234582
 * @author: zzh
 * @description: CameraApplication.java
 */
public class CameraApplication extends Application {
    private final static String TAG = "FocalApp";
    private Thread.UncaughtExceptionHandler mDefaultExHandler;
    private CameraManager mCamManager;

    private Thread.UncaughtExceptionHandler mExHandler = new Thread.UncaughtExceptionHandler() {
        public void uncaughtException(Thread thread, Throwable ex) {
            if (mCamManager != null) {
                Log.e(TAG, "Uncaught exception! Closing down camera safely firsthand");
                mCamManager.forceCloseCamera();
            }

            mDefaultExHandler.uncaughtException(thread, ex);
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();

        mDefaultExHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(mExHandler);
    }

    public void setCameraManager(CameraManager camMan) {
        mCamManager = camMan;
    }
}
