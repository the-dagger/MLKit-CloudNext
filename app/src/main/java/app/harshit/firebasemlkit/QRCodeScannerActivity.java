package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;

public class QRCodeScannerActivity extends BaseCameraActivity {

    private void getCodeFromImage(Bitmap bitmap) {
        //TODO : Create a FirebaseVisionImage

        //TODO : Get access to a FirebaseBarcodeDetector

        //TODO : Use the detector to detect the QR code inside the image
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getCodeFromImage(cameraKitImage.getBitmap());
            }
        });
    }
}
