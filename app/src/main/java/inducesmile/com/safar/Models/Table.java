package inducesmile.com.safar.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Table {

    @SerializedName("Table")
    List<TableElements> results;

    public List<TableElements> getResults() {
        return results;
    }

    public void setResults(List<TableElements> results) {
        this.results = results;
    }
}
