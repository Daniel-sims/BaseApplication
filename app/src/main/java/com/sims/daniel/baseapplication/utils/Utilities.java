package com.sims.daniel.baseapplication.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.TypedValue;

public class Utilities {
    public static Drawable getAttributeTintedDrawable(@NonNull Context context,
                                                      @AttrRes int drawableAttrId, @AttrRes int colorAttrId) {

        TypedValue drawableValue = new TypedValue();
        context.getTheme().resolveAttribute(drawableAttrId, drawableValue, true);
        Drawable drawable = ContextCompat.getDrawable(context, drawableValue.resourceId);

        return getTintedDrawable(drawable, getAttributeColor(context, colorAttrId));
    }

    public static Drawable getTintedDrawable(Drawable drawable, @ColorInt int color) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        wrappedDrawable = wrappedDrawable.mutate();
        DrawableCompat.setTint(wrappedDrawable, color);

        return wrappedDrawable;
    }

    public static @ColorInt int getAttributeColor(@NonNull Context context, @AttrRes int colorAttrId) {
        TypedValue colorValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttrId, colorValue, true);
        return colorValue.data;
    }


}
