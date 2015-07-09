package example.animatingball.com.animatingball;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 *Created by avijeet on 07/07/15.
 */

public class AnimatingBalls extends Activity {

    private AnimatingBallsView mAnimatingBallsView;
    private boolean mIsAnimResume=true;
    private Button mState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animating_balls);
        mAnimatingBallsView =new AnimatingBallsView(this);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        container.addView(mAnimatingBallsView);
        mState=(Button)findViewById(R.id.state_btn);
        mState .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsAnimResume) {
                    mIsAnimResume = false;
                    mAnimatingBallsView.pasue();
                    mState.setText(R.string.txt_resume);
                } else {
                    mIsAnimResume = true;
                    mAnimatingBallsView.resume();
                    mState.setText(R.string.txt_pause);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.animating_balls, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
