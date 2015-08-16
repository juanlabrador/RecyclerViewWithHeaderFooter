package com.juanlabrador.recyclerviewwithheaderfooter;

/**
 * Created by juanlabrador on 31/07/15.
 */
public class Item {

    private String mContent;
    private int mIcon;
    private int mImage;
    private String mTime;

    private boolean isHeader = false;
    private boolean withoutImage = false;
    private boolean withImage = false;
    private boolean isFooter = false;

    public Item(String mContent, int mIcon, int mImage, String mTime) {
        this.mContent = mContent;
        this.mIcon = mIcon;
        this.mImage = mImage;
        this.mTime = mTime;

        withImage = true;
    }

    public Item(String mContent, int mIcon, String mTime) {
        this.mContent = mContent;
        this.mIcon = mIcon;
        this.mTime = mTime;

        withoutImage = true;
    }

    public Item(String mTime) {
        this.mContent = null;
        this.mIcon = -1;
        this.mImage = -1;
        this.mTime = mTime;

        isHeader = true;
    }

    public Item() {
        this.mContent = null;
        this.mIcon = -1;
        this.mImage = -1;
        this.mTime = null;

        isFooter = true;
    }

    public String getContent() {
        return mContent;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getImage() {
        return mImage;
    }

    public String getTime() {
        return mTime;
    }

    public String getmContent() {
        return mContent;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public boolean isWithoutImage() {
        return withoutImage;
    }

    public boolean isWithImage() {
        return withImage;
    }

    public boolean isFooter() {
        return isFooter;
    }
}
