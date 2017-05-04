package cn.gitstars.gitstars.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jiangsiyu on 2016/6/6.
 * <p>
 * 目录项
 */
public class DirectoryEntry {

    /**
     * "path": ".babelrc",
     * "mode": "100644",
     * "type": "blob",
     * "sha": "3554dc78e426ff7758fd8f273309cd94bedbf524",
     * "size": 102,
     * "url": "https://api.github.com/repos/FreeCodeCamp/FreeCodeCamp/git/blobs/3554dc78e426ff7758fd8f273309cd94bedbf524"
     */

    @SerializedName("path")
    private String path;
    @SerializedName("mode")
    private String mode;
    @SerializedName("type")
    private String type;
    @SerializedName("sha")
    private String sha;
    @SerializedName("size")
    private String size;
    @SerializedName("url")
    private String url;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
