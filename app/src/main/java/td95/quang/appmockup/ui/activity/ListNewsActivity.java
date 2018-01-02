package td95.quang.appmockup.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import td95.quang.appmockup.Constants;
import td95.quang.appmockup.R;
import td95.quang.appmockup.listener.OnClickInListNewsListener;
import td95.quang.appmockup.model.News;
import td95.quang.appmockup.service.core.ApiClient;
import td95.quang.appmockup.service.core.DataCallBack;
import td95.quang.appmockup.service.response.NewsResponse;
import td95.quang.appmockup.ui.adapter.NewsAdapter;
import td95.quang.appmockup.utils.CommonUtils;
import td95.quang.appmockup.utils.HeaderUtils;
import td95.quang.appmockup.utils.SharePreferencesUtils;

/**
 * Quang_TD on 7/16/2017.
 */

public class ListNewsActivity extends AppCompatActivity implements OnClickInListNewsListener {
    private RecyclerView mRvLastestNews;
    private ProgressDialog progressDialog;
    private List<News> mNewses;
    private NewsAdapter mAdapter;
    private ImageView mImgClose;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        addView();
        addEvent();

    }

    private void addView() {
        mRvLastestNews = (RecyclerView) findViewById(R.id.rvListNews);
        mImgClose = (ImageView) findViewById(R.id.imgClose);
        mRvLastestNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mNewses = new ArrayList<>();
        mAdapter = new NewsAdapter(mNewses);
        mAdapter.setListener(this);
        mRvLastestNews.setAdapter(mAdapter);
        progressDialog = new ProgressDialog(this);
        showProgress();
        getData();
    }
    private void showProgress(){
        progressDialog.setMessage("please wait");
        progressDialog.show();
    }
    private void dismissProgress(){
        progressDialog.dismiss();
    }

    private void getData() {
        if (!CommonUtils.isNetworkOnline(this)) {
            Toast.makeText(this, "Check your connection", Toast.LENGTH_SHORT).show();
            return;
        }
        String token = SharePreferencesUtils.getInstance(this).getString(Constants.KEY_ACCESS_TOKEN, "");
        ApiClient.getService().getLastNews(HeaderUtils.buildHeaders(token), "", 1, 10).enqueue(new DataCallBack<NewsResponse>() {
            @Override public void onSuccess(NewsResponse response) {
                List<News> data = response.getNewes();
                mNewses.addAll(data);
                mAdapter.notifyDataSetChanged();
                dismissProgress();
            }

            @Override public void onError(String error) {
                Toast.makeText(ListNewsActivity.this, error, Toast.LENGTH_SHORT).show();
                dismissProgress();
            }
        });
    }

    private void addEvent() {
        mImgClose.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();
            }
        });
    }

    @Override public void onClickAtPosition(int position) {
        News news = mNewses.get(position);
        startDetailActivity(news);
    }

    private void startDetailActivity(News news) {
        Intent intent = new Intent(ListNewsActivity.this, NewsDetailActivity.class);
        Bundle bundle = new Bundle();
        news.setTime(news.getDate().getTime());
        Log.e("TAGG", news.getBody());
        if (news.getBody().startsWith("<img")) news.setBody("");
        bundle.putParcelable(Constants.KEY_DATA, news);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
