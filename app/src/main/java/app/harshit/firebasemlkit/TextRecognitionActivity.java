package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;

public class TextRecognitionActivity extends BaseCameraActivity {


    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getTextFromDevice(cameraKitImage.getBitmap());
            }
        });
    }

    private void getTextFromDevice(Bitmap bitmap) {
        //TODO : Create a FirebaseVisionImage

        //TODO : Get access to a FirebaseTextDetector

        //TODO : Use the detector to detect the text inside the image
    }

    private void getTextFromCloud(Bitmap bitmap) {

    }
}
