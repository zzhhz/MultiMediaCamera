package com.zzh.multi.camera.feats;

import com.zzh.multi.camera.CameraManager;
import com.zzh.multi.camera.SnapshotManager;
import com.zzh.multi.camera.ui.ShutterButton;

/**
 * @date: 2018/10/30
 * @email: zzh_hz@126.com
 * @QQ: 1299234582
 * @author: zzh
 * @description: CaptureTransformer.java
 */
public abstract class CaptureTransformer implements SnapshotManager.SnapshotListener {
    protected CameraManager mCamManager;
    protected SnapshotManager mSnapManager;

    public CaptureTransformer(CameraManager camMan, SnapshotManager snapshotMan) {
        mCamManager = camMan;
        mSnapManager = snapshotMan;
    }

    /**
     * Triggers the logic of the CaptureTransformer, when the user
     * pressed the shutter button.
     */
    public abstract void onShutterButtonClicked(ShutterButton button);

    /**
     * Triggers a secondary action when the shutter button is long-pressed
     * (optional)
     */
    public void onShutterButtonLongPressed(ShutterButton button) { }

}
