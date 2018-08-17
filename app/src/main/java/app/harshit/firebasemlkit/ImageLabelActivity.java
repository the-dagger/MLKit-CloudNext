package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabel;
import com.google.firebase.ml.vision.cloud.label.FirebaseVisionCloudLabelDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.label.FirebaseVisionLabel;
import com.google.firebase.ml.vision.label.FirebaseVisionLabelDetector;
import com.otaliastudios.cameraview.CameraListener;

import java.util.List;

public class ImageLabelActivity extends BaseCameraActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] jpeg) {
                //Convert ByteArray to a Bitmap
                getLabelFromDevice(BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length));
            }
        });
    }

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
        cameraView.capturePicture();
    }
}
