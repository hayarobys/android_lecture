package com.model.choong.chap07_adapterview;

/**
 * Created by Administrator on 2017-06-29.
 */

public class CustomDTO {
    String title;
    String contents;
    int imgIcon;

    public CustomDTO(String title, String contents, int imgIcon){
        this.title = title;
        this.contents = contents;
        this.imgIcon = imgIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }

    @Override
    public String toString() {
        return "제목: "+title+", 내용: "+contents;
    }
}
