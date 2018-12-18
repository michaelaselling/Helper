package com.example.micka.drinkgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;


public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        Button drinkButton = findViewById(R.id.power_drink_button);
        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startPowerDrinkActivity();
            }
        });
    }

    /**
     * Starts {@link PowerDrinkActivity}.
     */
    void startPowerDrinkActivity() {
        Intent i = new Intent(LauncherActivity.this, PowerDrinkActivity.class);
        startActivity(i);
    }

    /**
     * Public interface.
     */
    @IntDef({Constants.CONSTANT_FIRST, Constants.CONSTANT_SECOND, Constants.CONSTANT_THIRD}) // Denotes that the annotated element is of integer type.
    public @interface Constants {
        int CONSTANT_FIRST = 1;
        int CONSTANT_SECOND = 2;
        int CONSTANT_THIRD = 3;
    }

    /**
     * Helper method to convert random strings to ints.
     *
     * @return The mapped int.
     */
    public int convertRandomStringToInt() {
        Spinner s = findViewById(R.id.spinner);
        String randomString = s.getSelectedItem().toString();

        int convertedInt = 0;

        switch (randomString) {
            case "First random" :
                convertedInt = Constants.CONSTANT_FIRST;
                break;
            case "Seconds random" :
                convertedInt = Constants.CONSTANT_SECOND;
                break;
            case "Third random" :
                convertedInt = Constants.CONSTANT_THIRD;
                break;
        }
        return convertedInt;
    }
}
