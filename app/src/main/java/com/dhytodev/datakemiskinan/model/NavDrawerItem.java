package com.dhytodev.datakemiskinan.model;

/**
 * Created by TRIPOD STUDIO on 6/4/2016.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private int icon;
    private String title;

    public NavDrawerItem() {

    }

    public NavDrawerItem(boolean showNotify, int icon, String title) {
        this.showNotify = showNotify;
        this.icon = icon;
        this.title = title;
    }

    public boolean isShowNotify() {
        return showNotify;
    }

    public void setShowNotify(boolean showNotify) {
        this.showNotify = showNotify;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
