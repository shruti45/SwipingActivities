package com.example.user.swipingactivities;

/**
 * Created by user on 4/9/2016.
 */
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity {

    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView text2ndActivity = new TextView(this);
        text2ndActivity.setText("Second Activity");
        setContentView(R.layout.layout2);

        gestureDetectorCompat = new GestureDetectorCompat(this, new My2ndGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class My2ndGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe right' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

         /*
         Toast.makeText(getBaseContext(),
          event1.toString() + "\n\n" +event2.toString(),
          Toast.LENGTH_SHORT).show();
         */

            if(event2.getX() > event1.getX()){
                Toast.makeText(getBaseContext(),
                        "Swipe right - finish()",
                        Toast.LENGTH_SHORT).show();

                finish();
                overridePendingTransition(R.anim.pull_in_left, R.anim.exit_out_right);

            }

            return true;
        }
    }

}