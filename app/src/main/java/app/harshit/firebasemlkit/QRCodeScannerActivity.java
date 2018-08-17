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
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcode;
import com.google.firebase.ml.vision.barcode.FirebaseVisionBarcodeDetector;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.otaliastudios.cameraview.CameraListener;

import java.util.List;

public class QRCodeScannerActivity extends BaseCameraActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cameraView.addCameraListener(new CameraListener() {
            @Override
            public void onPictureTaken(byte[] jpeg) {
                //Convert ByteArray to a Bitmap
                getCodeFromImage(BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length));
            }
        });
    }

    private void getCodeFromImage(Bitmap bitmap) {
        //Create a FirebaseVisionImage
        FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(bitmap);
        //Get access to a FirebaseBarcodeDetector
        FirebaseVisionBarcodeDetector detector = FirebaseVision.getInstance()
                .getVisionBarcodeDetector();
        //Use the detector to detect the QR code inside the image
        detector.detectInImage(image)
                .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onSuccess(List<FirebaseVisionBarcode> firebaseVisionBarcodes) {
                        textView.setText("");
                        for (FirebaseVisionBarcode barcode : firebaseVisionBarcodes) {
                            textView.append(barcode.getDisplayValue() + "\n");
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getBaseContext(), "Failed to read QR code", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<List<FirebaseVisionBarcode>>() {
                    @Override
                    public void onComplete(@NonNull Task<List<FirebaseVisionBarcode>> task) {
                        progressBar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        cameraView.capturePicture();
    }
}
