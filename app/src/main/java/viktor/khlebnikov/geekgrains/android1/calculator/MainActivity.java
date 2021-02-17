package viktor.khlebnikov.geekgrains.android1.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchButton = findViewById(R.id.switchButton);
        switchButton.setOnClickListener(view -> {
            setContentView(R.layout.second_activity);

            Button switchButton2 = findViewById(R.id.switchButton2);
            switchButton2.setOnClickListener(view2 -> {
                setContentView(R.layout.activity_main);
            });


        });




    }
}