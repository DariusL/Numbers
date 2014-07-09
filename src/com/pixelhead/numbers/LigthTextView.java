package com.pixelhead.numbers;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LigthTextView extends TextView {
	
	private static Typeface typeface = null;
	
	public LigthTextView(Context context) {
		super(context);
		setup(context);
	}

	public LigthTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setup(context);
	}
	
	public LigthTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setup(context);
	}
	
	protected Typeface getFont(Context context){
		if(typeface == null)
			typeface = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
		return typeface;
	}
	
	private void setup(Context context){
		if(!isInEditMode())
			setTypeface(getFont(context));
	}
}
