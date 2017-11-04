package inducesmile.com.safar.Models;


import com.google.gson.annotations.SerializedName;

public class TableElements {
    @SerializedName("TypeID")
    int typeID;

    @SerializedName("DisplayNameRu")
    private String tableName;


    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
