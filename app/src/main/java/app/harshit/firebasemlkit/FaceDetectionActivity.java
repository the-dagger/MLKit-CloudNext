package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.face.FirebaseVisionFace;
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetector;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.Facing;

import java.util.List;

public class FaceDetectionActivity extends BaseCameraActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraView.setFacing(Facing.FRONT);
        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] jpeg) {
                //Convert ByteArray to a Bitmap
                getFaceFromImage(BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length));
            }
        });
    }

    private void getFaceFromImage(Bitmap bitmap) {
       //TODO  : Create a FirebaseVisionImage from the provided bitmap

        //TODO : Get access to the firebase Face detector

        //TODO : Run the detector over the provided FirebaseVisionImage

    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.capturePicture();
    }
}