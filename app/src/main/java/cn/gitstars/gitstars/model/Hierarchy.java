package cn.gitstars.gitstars.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;

import cn.gitstars.gitstars.utils.CommonUtil;

/**
 * Created by jiangsiyu on 2016/6/30.
 */
public class Hierarchy implements BaseRecyclerItem {

    private String path;
    private String mode;
    private String type;
    private String sha;
    private String size;
    private String url;
    private HashMap<String, Hierarchy> childrenMap;
    private ArrayList<Hierarchy> children;

    private String name;
    private String parentName;
    private int depth;
    private String[] structure;
    public static final String ROOT = "root";
    private ArrayList<Structure> parentStructure;

    public Hierarchy() {
        childrenMap = new HashMap<>();
    }

    public Hierarchy(DirectoryEntry directoryEntry) {
        childrenMap = new HashMap<>();
        if (null != directoryEntry) {
            setMode(directoryEntry.getMode());
            setPath(directoryEntry.getPath());
            setSha(directoryEntry.getSha());
            setSize(directoryEntry.getSize());
            setType(directoryEntry.getType());
            setUrl(directoryEntry.getUrl());
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        structure = path.split("/");
        depth = structure.length;
        name = structure[depth - 1];
        if (depth > 1) {
            parentName = structure[depth - 2];
        } else {
            parentName = ROOT;
        }
        updateParentStructure(structure);
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

    public ArrayList<Hierarchy> getChildren() {
        children = new ArrayList<>();
        children.addAll(childrenMap.values());
        return children;
    }

    public void addChild(String name, Hierarchy hierarchy) {
        if (null != hierarchy && !TextUtils.isEmpty(name)) {
            childrenMap.put(name, hierarchy);
        }
    }

    public Hierarchy getChild(String name) {
        if (!TextUtils.isEmpty(name) && childrenMap.containsKey(name)) {
            return childrenMap.get(name);
        } else {
            return null;
        }
    }

    public void updateParentStructure(String[] structure) {
        parentStructure = new ArrayList<>();
        Structure root = new Structure();
        root.setName(ROOT);
        root.setPosition(0);
        parentStructure.add(root);
        if (!CommonUtil.isEmpty(structure)) {
            for (int i = 0; i < structure.length; i++) {
                Structure s = new Structure();
                s.setName(structure[i]);
                s.setPosition(i + 1);
                parentStructure.add(s);
            }
        }
    }

    public ArrayList<Structure> getParentStructure() {
        return parentStructure;
    }

    @Override
    public int getDataType() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String getParentName() {
        return parentName;
    }

    public int getDepth() {
        return depth;
    }

    public String[] getStructure() {
        return structure;
    }
}
