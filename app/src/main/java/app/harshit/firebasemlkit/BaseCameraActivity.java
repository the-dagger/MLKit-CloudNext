package app.harshit.firebasemlkit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wonderkiln.camerakit.CameraView;

//base camera activity to handle camera preview and other things
public abstract class BaseCameraActivity extends AppCompatActivity implements View.OnClickListener {

    CameraView cameraView;
    Button btnCapture;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_camera);
        cameraView = findViewById(R.id.cameraView);
        btnCapture = findViewById(R.id.btnCapture);
        textView = findViewById(R.id.tView);
        btnCapture.setOnClickListener(this);
        progressBar = findViewById(R.id.pb);
    }

    @Override
    protected void onStart() {
        super.onStart();
        cameraView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cameraView.stop();
    }
}
