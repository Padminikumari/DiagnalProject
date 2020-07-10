package com.example.diagnal_project;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageClass {

    @SerializedName("page")
    @Expose
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

}