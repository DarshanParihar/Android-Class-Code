package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {
	Paint paint;
	int color, radius;

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();

		TypedArray typedArray = context.getTheme().obtainStyledAttributes(
				attrs, R.styleable.MyCustomView, 0, 0);

		color = Integer.parseInt(typedArray
				.getString(R.styleable.MyCustomView_color));
		radius = Integer.parseInt(typedArray
				.getString(R.styleable.MyCustomView_radius));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		switch (color) {
		case 0:
			paint.setColor(Color.RED);
			break;
		case 1:
			paint.setColor(Color.GREEN);
			break;
		case 2:
			paint.setColor(Color.BLUE);
			break;
		}

		paint.setStrokeWidth(5);
		canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
	}
}
