package com.zzh.multi.camera.ui.splash;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.zzh.multi.camera.CameraActivity;
import com.zzh.multi.camera.R;
import com.zzh.multi.camera.Util;

/**
 * Created by Administrator.
 *
 * @date: 2018/10/30
 * @email: zzh_hz@126.com
 * @QQ: 1299234582
 * @author: zzh
 * @description: MultiMediaCamera
 * @since 1.0
 */
public class SplashActivity extends Activity {

    private static final int REQUEST_CODE_READ_PERMISSION = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int run = Util.getRun(this);
        /**
         * 已经授予程序相应的权限
         */
        if (run == 1) {
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE
            }, REQUEST_CODE_READ_PERMISSION);
        } else {
            Util.saveRun(this, 1);
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (verifyPermissions(grantResults)) {
            Util.saveRun(this, 1);
            Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "请授予程序读写存储，相机，获取手机信息权限", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 检查权限
     *
     * @param grantResults
     * @return
     */
    public static boolean verifyPermissions(int[] grantResults) {
        if (grantResults.length < 1) {
            return false;
        } else {
            int[] var1 = grantResults;
            int var2 = grantResults.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                int result = var1[var3];
                if (result != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
