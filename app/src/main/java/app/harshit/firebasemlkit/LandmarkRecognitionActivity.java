package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;

public class LandmarkRecognitionActivity extends BaseCameraActivity {

    private void getLandmarkFromImage(Bitmap bitmap) {
        //TODO : Create a FirebaseVisionImage

        //TODO : Get access to a FirebaseCloudVisionLandmarkDetector

        //TODO : Use the detector to detect the landmarks inside the image
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getLandmarkFromImage(cameraKitImage.getBitmap());
            }
        });
    }
}
