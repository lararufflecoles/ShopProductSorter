package es.rufflecol.lara.shopproductsorter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.support.v7.widget.Toolbar;

public class ToolbarLRC extends Toolbar {

    public ToolbarLRC(Context context) {
        super(context);
        initialise(context);
    }

    public ToolbarLRC(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialise(context);
    }

    public ToolbarLRC(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialise(context);
    }

    private void initialise(Context context) {
        setTitleTextAppearance(context, R.style.ToolbarAppearance);
    }
}