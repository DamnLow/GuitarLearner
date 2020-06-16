package container.LearningScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guitarlearner.R;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class LearningScreen extends AppCompatActivity {

    //TODO load settings & render image view according to settings

    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    String pathSave = "";

    final int REQUEST_PERMISSION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_screen);

        //Request Runtime permission
        if(!checkPermissionFromDevice()) {
            System.out.println("Permissions");
            requestPermission();
        }

        // init View
        final Button record = (Button) findViewById(R.id.record);
        final Button stopRecord = (Button) findViewById(R.id.stopRecord);
        final Button play = (Button) findViewById(R.id.play);
        final Button stop = (Button) findViewById(R.id.stop);

        stop.setEnabled(false);
        stopRecord.setEnabled(false);

        record.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if(checkPermissionFromDevice()) {
                    pathSave = getApplicationContext().getFilesDir().getPath() + "/"
                            + "_audio_record.3gp";
                    File file = new File(pathSave);

                    setupMediaRecorder();
                    try{
                        mediaRecorder.prepare();
                        System.out.println("Prepared...");
                        mediaRecorder.start();
                        System.out.println("Recording...");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    play.setEnabled(false);
                    stopRecord.setEnabled(true);

                    Toast.makeText(LearningScreen.this, "Recording...", Toast.LENGTH_SHORT).show();
                } else{
                    requestPermission();
                }
            }
        });

        stopRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(mediaRecorder);
                mediaRecorder.stop();
                mediaRecorder.release();
                stop.setEnabled(false);
                stopRecord.setEnabled(false);
                play.setEnabled(true);
                record.setEnabled(true);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop.setEnabled(true);
                stopRecord.setEnabled(false);
                record.setEnabled(false);
                play.setEnabled(false);

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(pathSave);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
                Toast.makeText(LearningScreen.this, "Playing...", Toast.LENGTH_SHORT).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopRecord.setEnabled(false);
                record.setEnabled(true);
                stop.setEnabled(false);
                play.setEnabled(true);

                if(mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    setupMediaRecorder();
                }
            }
        });

    }

    private void setupMediaRecorder() {
        mediaRecorder = new MediaRecorder();
        System.out.println("Initialized...");
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        System.out.println("Data source configured...");
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        System.out.println(pathSave);
        mediaRecorder.setOutputFile(pathSave);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT);
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO,
        }, REQUEST_PERMISSION_CODE);
    }

    private boolean checkPermissionFromDevice() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO );

        return write_external_storage_result == PackageManager.PERMISSION_GRANTED &&
                record_audio_result == PackageManager.PERMISSION_GRANTED;
    }
}
