package cn.gitstars.gitstars.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jiangsiyu on 2016/6/6.
 * <p>
 * 目录
 */
public class Directory {

    @SerializedName("sha")
    private String sha;
    @SerializedName("url")
    private String url;
    @SerializedName("truncated")
    private boolean truncated;
    @SerializedName("tree")
    private List<DirectoryEntry> tree;

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public List<DirectoryEntry> getTree() {
        return tree;
    }

    public void setTree(List<DirectoryEntry> tree) {
        this.tree = tree;
    }
}
