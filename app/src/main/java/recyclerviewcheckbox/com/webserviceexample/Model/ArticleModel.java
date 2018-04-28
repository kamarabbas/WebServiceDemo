package recyclerviewcheckbox.com.webserviceexample.Model;

import java.util.List;

/**
 * Created by ombharti on 28-Apr-18.
 */

public class ArticleModel {

    private List<ArticleListBean> articleList;

    public List<ArticleListBean> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleListBean> articleList) {
        this.articleList = articleList;
    }

    public static class ArticleListBean {
        /**
         * title : Android Internet Connection Using HTTP GET (HttpClient)
         * url : http://hmkcode.com/android-internet-connection-using-http-get-httpclient/
         * categories : ["Android"]
         * tags : ["android","httpclient","internet"]
         */

        private String title;
        private String url;
        private List<String> categories;
        private List<String> tags;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getCategories() {
            return categories;
        }

        public void setCategories(List<String> categories) {
            this.categories = categories;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
