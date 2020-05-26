package container.MainMenu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guitarlearner.R;

import SettingScreen.SettingScreen;
import container.LearningScreen.LearningScreen;

public class MainMenu extends AppCompatActivity {

    public void navigateToSettings() {
        startActivity(new Intent(MainMenu.this, SettingScreen.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button setting = (Button) findViewById(R.id.settings);
        Button learn = (Button) findViewById(R.id.learning);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSettings();
            }
        });


        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLearningScreen();
            }
        });
    }

    public void navigateToLearningScreen() {
        startActivity(new Intent(MainMenu.this, LearningScreen.class));
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if(hasFocus){
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            );
        }
    }
}
