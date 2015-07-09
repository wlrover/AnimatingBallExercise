package example.animatingball.com.animatingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by avijeet on 07/07/15.
 */
public class AnimatingBallsView  extends View {
    private Box mBox;
    private final int mAnimTime=20;
    private final ArrayList<Ball> mBalls = new ArrayList<Ball>();
    private boolean mShouldPlayAnim=true;

    public AnimatingBallsView(Context context) {
        super(context);
        mBox = new Box(Color.RED);
        this.setFocusableInTouchMode(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBox.draw(canvas);
        for (Ball ball:mBalls) {
            ball.draw(canvas);
            ball.move(mBox);
        }
        if (mShouldPlayAnim) {
            try {
                Thread.sleep(mAnimTime);
            } catch (InterruptedException e) {
                Log.d("Error:", e.toString());
            }
            invalidate();
        }
    }

    @Override
    public void onSizeChanged(int w, int h, int oldW, int oldH) {
        mBox.set(w / 6, h / 6, (2 * w) / 3, (2 * h) / 3);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mShouldPlayAnim && event.getAction() == MotionEvent.ACTION_DOWN) {
            addBall(event.getX(), event.getY());
            return true;
        }
        return false;
    }

    private void addBall(float x, float y) {
        Ball ball = new Ball(Color.GREEN);
        ball.setX(x);
        ball.setY(y);
        mBalls.add(ball);
    }

    public void pasue() {
        mShouldPlayAnim = false;
    }

    public void resume() {
        mShouldPlayAnim = true;
        invalidate();
    }
}
