package Settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.guitarlearner.R;

public class Settings extends AppCompatActivity implements View.OnClickListener{
    //private boolean

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);

        //tabs
        Switch tab = (Switch) findViewById(R.id.settings_tab);

        // note
        Switch note = (Switch) findViewById(R.id.settings_note);

        // chords
        Switch chords = (Switch) findViewById(R.id.settings_chords);

        // save button
        Button save = (Button) findViewById(R.id.settings_save);

        // cancel button
        Button cancel = (Button) findViewById(R.id.settings_cancel);

        // title text view
        // mic calibration?
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.settings_save:
                break;
            case R.id.settings_cancel:
                break;
        }
    }
}
