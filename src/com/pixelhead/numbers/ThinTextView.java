package com.pixelhead.numbers;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class ThinTextView extends LigthTextView {
	
	private static Typeface typeface = null;

	public ThinTextView(Context context) {
		super(context);
	}

	public ThinTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ThinTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected Typeface getFont(Context context) {
		if(typeface == null)
			typeface = Typeface.createFromAsset(context.getAssets(), "Roboto-Thin.ttf");
		return typeface;
	}
}
