package td95.quang.appmockup.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import td95.quang.appmockup.R;
import td95.quang.appmockup.listener.OnClickInInfoDialogListener;
import td95.quang.appmockup.listener.OnClickInListNewsListener;
import td95.quang.appmockup.model.News;
import td95.quang.appmockup.ui.view.CustomTextView;
import td95.quang.appmockup.utils.CommonUtils;

/**
 * Quang_TD on 7/16/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {
    private List<News> mNewses;
    private OnClickInListNewsListener listener;

    public void setListener(OnClickInListNewsListener listener) {
        this.listener = listener;
    }

    public NewsAdapter(List<News> newses) {
        this.mNewses = newses;
    }

    @Override public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override public void onBindViewHolder(NewsHolder holder, final int position) {
        holder.setData(mNewses.get(position));
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                if (listener != null)
                    listener.onClickAtPosition(position);
            }
        });
    }

    @Override public int getItemCount() {
        return mNewses != null ? mNewses.size() : 0;
    }

    class NewsHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        CustomTextView mTvTitle;
        CustomTextView mTvTime;
        CustomTextView mTvDetail;

        NewsHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.cvNews);
            mTvTitle = (CustomTextView) itemView.findViewById(R.id.tvTitle);
            mTvTime = (CustomTextView) itemView.findViewById(R.id.tvTime);
            mTvDetail = (CustomTextView) itemView.findViewById(R.id.tvDetail);
        }

        void setData(News news) {
            mTvTitle.setText(news.getTitle());
            mTvTime.setText(CommonUtils.convertTime(news.getDate()));
        }
    }
}
