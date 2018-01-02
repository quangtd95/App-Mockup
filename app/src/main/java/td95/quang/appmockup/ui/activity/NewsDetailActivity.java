package td95.quang.appmockup.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import td95.quang.appmockup.Constants;
import td95.quang.appmockup.R;
import td95.quang.appmockup.model.News;
import td95.quang.appmockup.ui.view.CustomButton;
import td95.quang.appmockup.ui.view.CustomTextView;
import td95.quang.appmockup.utils.CommonUtils;

/**
 * Quang_TD on 7/16/2017.
 */

public class NewsDetailActivity extends AppCompatActivity {
    private CustomTextView mTvTitle;
    private CustomTextView mTvTime;
    private CustomTextView mTvDetail;
    private CustomButton mBtnExit;
    private ImageView mImgAvatar;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        News news = bundle.getParcelable(Constants.KEY_DATA);
        addControl();
        addEvent();
        setData(news);
    }

    private void setData(News news) {
        if (news == null) return;
        mTvTitle.setText(news.getTitle());
        mTvTime.setText(CommonUtils.convertTime(news.getDate()));
        mTvDetail.setText(Html.fromHtml(news.getBody()));
        Picasso.with(this).load(news.getAvatar()).into(mImgAvatar);
    }

    private void addEvent() {
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });
    }

    private void addControl() {
        mTvTitle = (CustomTextView) findViewById(R.id.tvTitle);
        mTvTime = (CustomTextView) findViewById(R.id.tvTime);
        mImgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        mTvDetail = (CustomTextView) findViewById(R.id.tvDetail);
        mBtnExit = (CustomButton) findViewById(R.id.btnExit);
    }
}
