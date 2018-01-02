package td95.quang.appmockup.service.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import td95.quang.appmockup.model.News;

/**
 * Quang_TD on 7/16/2017.
 */

public class NewsResponse {
    @SerializedName("News")
    private List<News> newes;

    public List<News> getNewes() {
        return newes;
    }

    public void setNewes(List<News> newes) {
        this.newes = newes;
    }
}
