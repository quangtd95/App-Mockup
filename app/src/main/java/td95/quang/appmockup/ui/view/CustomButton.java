package td95.quang.appmockup.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Quang_TD on 7/16/2017.
 */

public class CustomButton extends android.support.v7.widget.AppCompatButton {
    private Typeface typeface;

    public CustomButton(Context context) {
        super(context);
        initFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context);
    }

    private void initFont(Context context) {
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/cambria.ttf");
        this.setTypeface(typeface);
    }
}
