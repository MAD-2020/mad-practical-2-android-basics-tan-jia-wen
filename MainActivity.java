package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    private Button buttonLeft;
    private Button buttonMiddle;
    private Button buttonRight;
    private TextView score;
    private static int points = 0;
    private static final String TAG = "Whack-A-Mole!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonMiddle = (Button) findViewById(R.id.buttonMiddle);
        buttonRight = (Button) findViewById(R.id.buttonRight);
        score = (TextView) findViewById(R.id.score);

        score.setText("Score: " + points);
    }

    public void setNewMole()
    {
        Button[] buttons = {buttonLeft, buttonMiddle, buttonRight};
        Random ran = new Random();
        int location = ran.nextInt(3);
        Button s = buttons[location];
        for (Button b : buttons){
            if (b == s){
                b.setText("*");
            }
            else{
                b.setText("O");
            }
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Starting GUI!");
        setNewMole();
    }

    public void OnClickButton(View v)
    {
        Button button = (Button) v;
        if (check(button) == true){
            points++;
            score.setText("Score: " + points);
            Log.v(TAG, "Hit, score added!");
        }
        else{
            if (points > 0) {
                points--;
                score.setText("Score: " + points);
                Log.v(TAG, "Missed, score added!");
            } else {
                points = 0;
                score.setText("Score: " + points);
                Log.v(TAG, "Missed, score added!");
            }
        }
        setNewMole();
    }

    public void text(Button b)
    {
        if (b == buttonLeft) {
            Log.v(TAG, "Button Left clicked!");
        }
        if (b == buttonMiddle){
            Log.v(TAG, "Button Middle clicked!");
        }
        if (b == buttonRight){
            Log.v(TAG, "Button Right clicked!");
        }
    }

    public boolean check(Button b)
    {
        if (b.getText() == "*"){
            return true;
        }
        else {
            return false;
        }
    }
}
