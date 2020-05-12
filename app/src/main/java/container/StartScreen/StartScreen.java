package container.StartScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guitarlearner.Example;
import com.example.guitarlearner.R;

import container.MainMenu.MainMenu;

public class StartScreen extends AppCompatActivity {

    public void startOnClickHandler() {
        startActivity(new Intent(StartScreen.this, MainMenu.class));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.start_activity);

        // components
        Button start = (Button) findViewById(R.id.start);

        // define on click handling
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.start:
                        startOnClickHandler();
                }
            }
        });
    }
}
