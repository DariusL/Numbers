package com.pixelhead.numbers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class HoloTextView extends TextView {
	
	public HoloTextView(Context context) {
		super(context);
		setup(context, null);
	}

	public HoloTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setup(context, attrs);
	}
	
	public HoloTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setup(context, attrs);
	}
	
	private void setup(Context context, AttributeSet attrs){
		int type = FontUtils.THIN;
		/*
		if(attrs != null){
			TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.HoloTextView);
			
			type = a.getInt(R.styleable.HoloTextView_holoTextStyle, FontUtils.NORMAL);
			a.recycle();
		}
		*/
		FontUtils.setRobotoFont(context, this, type);
	}
}
