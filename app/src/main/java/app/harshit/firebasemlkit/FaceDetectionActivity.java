package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;


public class FaceDetectionActivity extends BaseCameraActivity {

    private void getFaceFromImage(Bitmap bitmap) {
        //TODO  : Create a FirebaseVisionImage from the provided bitmap

        //TODO : Get access to the firebase Face detector

        //TODO : Run the detector over the provided FirebaseVisionImage
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getFaceFromImage(cameraKitImage.getBitmap());
            }
        });
    }
}