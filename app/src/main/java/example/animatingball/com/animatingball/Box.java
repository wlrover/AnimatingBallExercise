package example.animatingball.com.animatingball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by avijeet on 07/07/15.
 */
public class Box {

    int xMin, xMax, yMin, yMax;
    private Paint paint;
    private Rect bounds;

    public Box(int color) {
        paint = new Paint();
        paint.setColor(color);paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        bounds = new Rect();
    }

    public void set(int x, int y, int width, int height) {
        xMin = x;
        xMax = x + width - 1;
        yMin = y;
        yMax = y + height - 1;
        bounds.set(xMin, yMin, xMax, yMax);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(bounds, paint);
    }
}
