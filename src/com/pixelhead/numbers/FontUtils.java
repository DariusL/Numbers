package com.pixelhead.numbers;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class FontUtils {
	public static final int NORMAL = 0;
	public static final int BOLD = 1;
	public static final int LIGHT = 2;
	public static final int MEDIUM = 3;
	public static final int THIN = 4;

    public enum FontType{
    	LIGHT, REGULAR, BOLD, MEDIUM, THIN
    }

    private static Map<FontType, String> fontMap = new EnumMap<FontType, String>(FontType.class);

    static {
        fontMap.put(FontType.LIGHT, "Roboto-Light.ttf");
        fontMap.put(FontType.REGULAR, "Roboto-Regular.ttf");
        fontMap.put(FontType.BOLD, "Roboto-Bold.ttf");
        fontMap.put(FontType.MEDIUM, "Roboto-Medium.ttf");
        fontMap.put(FontType.THIN, "Roboto-Thin.ttf");
    }

    private static Map<FontType, Typeface> typefaceCache = new HashMap<FontType, Typeface>();

    private static Typeface getRobotoTypeface(Context context, FontType type) {
        if (!typefaceCache.containsKey(type)){
            String fontPath = fontMap.get(type);
            typefaceCache.put(type, Typeface.createFromAsset(context.getAssets(), fontPath));
        }
        return typefaceCache.get(type);
    }

    public static void setRobotoFont(Context context, TextView view, FontType type) {
    	if(view.isInEditMode())
    		return;

    	if(type == null){
    		type = FontType.REGULAR;
    	}
        view.setTypeface(getRobotoTypeface(context, type));
    }
    
    public static void setRobotoFont(Context context, TextView view, int type){
    	setRobotoFont(context, view, getType(type));
    }
    
    private static FontType getType(int type){
    	switch (type) {
    	default:
		case NORMAL:
			return FontType.REGULAR;
		case LIGHT:
			return FontType.LIGHT;
		case BOLD:
			return FontType.BOLD;
		case MEDIUM:
			return FontType.MEDIUM;
		case THIN:
			return FontType.THIN;
		}
    }
}