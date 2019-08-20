package com.hunter.blog.modules.article.model;

import org.springframework.stereotype.Component;

/**
 * @description 文章实体类
 * @author ChenLiang
 * @data: 2019/8/14 9:41
 * @version 1.0.0
 */
@Component
public class ArticleDo {
    private Integer artId;
    private String artChannel;
    private String artTitle;
    private String artCreateTime;
    private String artTitleImgURL;
    private String artContent;
    private String artStatus;
    private int artClickCount;
    private int isDeleted;
    private String artComment;

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getArtChannel() {
        return artChannel;
    }

    public void setArtChannel(String artChannel) {
        this.artChannel = artChannel;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtCreateTime() {
        return artCreateTime;
    }

    public void setArtCreateTime(String artCreateTime) {
        this.artCreateTime = artCreateTime;
    }

    public String getArtTitleImgURL() {
        return artTitleImgURL;
    }

    public void setArtTitleImgURL(String artTitleImgURL) {
        this.artTitleImgURL = artTitleImgURL;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    public String getArtStatus() {
        return artStatus;
    }

    public void setArtStatus(String artStatus) {
        this.artStatus = artStatus;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getArtClickCount() {
        return artClickCount;
    }

    public void setArtClickCount(int artClickCount) {
        this.artClickCount = artClickCount;
    }

    public String getArtComment() {
        return artComment;
    }

    public void setArtComment(String artComment) {
        this.artComment = artComment;
    }

    @Override
    public String toString() {
        return "ArticleDo{" +
                "artId=" + artId +
                ", artChannel='" + artChannel + '\'' +
                ", artTitle='" + artTitle + '\'' +
                ", artCreateTime='" + artCreateTime + '\'' +
                ", artTitleImgURL='" + artTitleImgURL + '\'' +
                ", artContent='" + artContent + '\'' +
                ", artStatus='" + artStatus + '\'' +
                ", artClickCount=" + artClickCount +
                ", isDeleted=" + isDeleted +
                ", artComment='" + artComment + '\'' +
                '}';
    }
}
