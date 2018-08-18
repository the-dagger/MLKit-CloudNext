package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabelDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionLabelDetector;
import com.wonderkiln.camerakit.CameraKitEventCallback;
import com.wonderkiln.camerakit.CameraKitImage;

import java.util.List;

public class ImageLabelActivity extends BaseCameraActivity {

    private void getLabelFromDevice(Bitmap bitmap) {

        //Create a FirebaseVisionImage
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);

        //Get access to a FirebaseImageDetector
        FirebaseVisionLabelDetector detector = FirebaseVision.getInstance()
                .getVisionLabelDetector();

        //Use the detector to detect the labels inside the image
        detector.detectInImage(image).addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionLabel>>() {
            @Override
            public void onSuccess(List<FirebaseVisionLabel> firebaseVisionLabels) {
                for (FirebaseVisionLabel firebaseVisionLabel : firebaseVisionLabels) {
                    progressBar.setVisibility(View.GONE);
                    //Get the label and its confidence
                    textView.append(firebaseVisionLabel.getLabel() + "  :  " + firebaseVisionLabel.getConfidence() * 100 + "% \n");
                }
            }
        });
    }

    void getLabelFromCloud(Bitmap bitmap) {
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        FirebaseVisionCloudLabelDetector detector = FirebaseVision.getInstance()
                .getVisionCloudLabelDetector();

        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionCloudLabel>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionCloudLabel> firebaseVisionCloudLabels) {
                        textView.setText("");
                        progressBar.setVisibility(View.GONE);
                        for (FirebaseVisionCloudLabel firebaseVisionLabel : firebaseVisionCloudLabels) {
                            textView.append(firebaseVisionLabel.getLabel() + "  :  " + firebaseVisionLabel.getConfidence() * 100 + "% \n");
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.captureImage(new CameraKitEventCallback<CameraKitImage>() {
            @Override
            public void callback(CameraKitImage cameraKitImage) {
                getLabelFromCloud(cameraKitImage.getBitmap());
            }
        });
    }
}
