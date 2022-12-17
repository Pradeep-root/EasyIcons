package com.example.easyicons;


import static com.example.easyicons.IconCodeDictionary.getIconRecords;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;

import com.example.garudaeasyicons.R;


public class EasyIcons extends AppCompatImageView {

    private Context context;

    public EasyIcons(@NonNull Context context) {
        super(context);
    }

    public EasyIcons(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupAttributes(attrs);
    }

    public EasyIcons(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setupAttributes(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.Options, 0, 0);
        String iconCode = "";
        try {
            iconCode = typedArray.getString(R.styleable.Options_setIconCode);
        } finally {
            typedArray.recycle();
        }
        setIcon(getIconName(iconCode));
    }

    private void setIcon(String iconName) {
        int imageResource = getResources().getIdentifier("@drawable/" + iconName, null, context.getPackageName());
        Drawable res = ResourcesCompat.getDrawable(getResources(), imageResource, null);
        this.setImageDrawable(res);
        invalidate();
        requestLayout();
    }

    public void setIconCode(String code) {
        setIcon(getIconName(code));
    }

    private String getIconName(String code) {
        String name = getIconRecords().get(code);
        if (name == null || name.isEmpty()) {
            // send default
            return "ic_launcher_background";
        } else {
            return name;
        }
    }

}
