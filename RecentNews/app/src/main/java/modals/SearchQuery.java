package modals;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by deepmetha on 9/24/17.
 */

public class SearchQuery implements Parcelable {
    String dateString;
    String searchText;
    String sortOrder;
    String articleType;

    public SearchQuery() {

    }
    public SearchQuery(Parcel in) {
        dateString = in.readString();
        searchText = in.readString();
        sortOrder = in.readString();
        articleType = in.readString();
    }

    public static final Creator<SearchQuery> CREATOR = new Creator<SearchQuery>() {
        @Override
        public SearchQuery createFromParcel(Parcel in) {
            return new SearchQuery(in);
        }

        @Override
        public SearchQuery[] newArray(int size) {
            return new SearchQuery[size];
        }
    };

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dateString);
        parcel.writeString(searchText);
        parcel.writeString(sortOrder);
        parcel.writeString(articleType);
    }
}
