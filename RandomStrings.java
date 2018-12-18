import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;

import com.example.micka.drinkgame.R;

/**
 * Helper class to convert random Strings to ints by using defined constants.
 */
public class RandomStrings extends AppCompatActivity {

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
     * Helper method to convert random Strings to ints.
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


