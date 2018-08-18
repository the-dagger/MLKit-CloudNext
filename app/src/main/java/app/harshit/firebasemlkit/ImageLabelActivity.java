package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;

public class ImageLabelActivity extends BaseCameraActivity {

    private void getLabelFromDevice(Bitmap bitmap) {

        //TODO : Create a FirebaseVisionImage

        //TODO : Get access to a FirebaseImageDetector

        //TODO : Use the detector to detect the labels inside the image

    }

    void getLabelFromCloud(Bitmap bitmap) {

    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getLabelFromDevice(cameraKitImage.getBitmap());
            }
        });
    }
}
