package app.harshit.firebasemlkit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.otaliastudios.cameraview.CameraListener;

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
