package com.example.tanaydey.tutorial34_animation_transition;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    /// ViewGroup contains all the layouts, so we can use ViewGroup tanaysLayout.. viewgroup is the base class of the layout
    RelativeLayout tanaysLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanaysLayout=(RelativeLayout) findViewById(R.id.tanaysLayout);

        tanaysLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener()
                {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                         moveButton();

                        return true;
                    }
                }

        );
    }


public void moveButton(){

   //View tanaysButton= (View) findViewById(R.id.tanaysButton);

    /*This class represents the basic building block for user interface components.
    A View occupies a rectangular area on the screen and is responsible for drawing and event handling.
    View is the base class for widgets, which are used to create interactive UI components (buttons, text fields, etc.).
    */

    Button tanaysButton= (Button) findViewById(R.id.tanaysButton);


    TransitionManager.beginDelayedTransition(tanaysLayout);


    // Change the position of the button

    RelativeLayout.LayoutParams positionRules=new RelativeLayout.LayoutParams(
             RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
    );

     positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
     positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,RelativeLayout.TRUE);

     tanaysButton.setLayoutParams(positionRules);

    // change the size of the button
     ViewGroup.LayoutParams sizeRules=tanaysButton.getLayoutParams();

      // since viewgroup is the base class for the all the layout so instead of using the viewgroup we can use the
      // RelativeLayout and typecast it
      // RelativeLayout.LayoutParams sizeRules=(RelativeLayout.LayoutParams)tanaysButton.getLayoutParams();
      sizeRules.height=400;
      sizeRules.width=300;

     tanaysButton.setLayoutParams(sizeRules);




}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
