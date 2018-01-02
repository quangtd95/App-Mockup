package td95.quang.appmockup.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Quang_TD on 7/16/2017.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView{
    private Typeface typeface;
    public CustomTextView(Context context) {
        super(context);
        initFont(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context);
    }
    private void initFont(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/cambria.ttf");
        this.setTypeface(typeface);
    }
}
