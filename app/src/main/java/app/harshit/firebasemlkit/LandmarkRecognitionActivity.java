package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmark;
import com.google.firebase.ml.vision.cloud.landmark.FirebaseVisionCloudLandmarkDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.common.FirebaseVisionLatLng;
import com.otaliastudios.cameraview.CameraListener;

import java.util.List;

public class LandmarkRecognitionActivity extends BaseCameraActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] jpeg) {
                //Convert ByteArray to a Bitmap
                getLandmarkFromImage(BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length));
            }
        });
    }

    private void getLandmarkFromImage(Bitmap bitmap) {
        //Create a FirebaseVisionImage
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        //Get access to a FirebaseCloudVisionLandmarkDetector
        FirebaseVisionCloudLandmarkDetector detector = FirebaseVision.getInstance()
                .getVisionCloudLandmarkDetector();
        //Use the detector to detect the landmarks inside the image
        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionCloudLandmark>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionCloudLandmark> firebaseVisionCloudLandmarks) {
                        textView.setText("");
                        for (FirebaseVisionCloudLandmark landmark : firebaseVisionCloudLandmarks) {

                            textView.append("Landmark name  : " + landmark.getLandmark());
                            for (FirebaseVisionLatLng location : landmark.getLocations()) {
                                textView.append("Latitude : " + location.getLatitude());
                                textView.append("Longitude : " + location.getLongitude());
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LandmarkRecognitionActivity.this, "There was an error", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<List<FirebaseVisionCloudLandmark>>() {
                    @Override
                    public void onComplete(@NonNull Task<List<FirebaseVisionCloudLandmark>> task) {

                    }
                });
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.capturePicture();
    }
}
