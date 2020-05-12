package container.MainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guitarlearner.Example;
import com.example.guitarlearner.R;

public class MainMenu extends AppCompatActivity {

    public void navigateToExample() {
        startActivity(new Intent(MainMenu.this, Example.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button example = (Button) findViewById(R.id.example);

        example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToExample();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
