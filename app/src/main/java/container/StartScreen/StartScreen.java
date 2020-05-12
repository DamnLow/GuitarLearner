package container.StartScreen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guitarlearner.R;

public class StartScreen extends AppCompatActivity {

    public void startOnClickHandler() {
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
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
