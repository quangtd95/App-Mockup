package td95.quang.appmockup.ui.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import td95.quang.appmockup.R;
import td95.quang.appmockup.listener.OnClickInInfoDialogListener;

/**
 * Quang_TD on 7/16/2017.
 */

public class InfoPopupFragment extends DialogFragment {
    private static InfoPopupFragment instance;
    private ImageView mBtnDismiss;
    private CardView mCvLastestNews;

    private OnClickInInfoDialogListener listener;

    public void setListener(OnClickInInfoDialogListener listener) {
        this.listener = listener;
    }

    public OnClickInInfoDialogListener getListener() {
        return listener;
    }

    public static InfoPopupFragment getInstance() {
        if (instance == null) instance = new InfoPopupFragment();
        return instance;
    }


    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_info, null);
        initView(view);
        addEvent();
        return view;
    }

    private void initView(View view) {
        mBtnDismiss = (ImageView) view.findViewById(R.id.btnDismiss);
        mCvLastestNews = (CardView) view.findViewById(R.id.cvLastestNews);
    }

    private void addEvent() {
        mBtnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null) {
                    listener.onClickDismiss();
                }
            }
        });
        mCvLastestNews.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null) {
                    listener.onChooseLastestNews();
                }
            }
        });
    }

    @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animationDialog;
        return dialog;
    }

    @Override public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

}
