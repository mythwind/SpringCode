package com.vincent.springbootdemo.entity;

import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Auther: mythwind
 * @Date: 2019/02/21 19:44
 * @Description:
 */
@Mapper
public class VedioInfo implements Serializable {
    private long vedioId;
    private String vedioUrl;
    private String vedioDesc;
    private String vedioTitle;
    private int vedioStatus;
    private int vedioType;
    private int authorId;
    private String authorIdea;
    private String mainImage;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int userGoodThumbs;

    public long getVedioId() {
        return vedioId;
    }

    public void setVedioId(long vedioId) {
        this.vedioId = vedioId;
    }

    public String getVedioUrl() {
        return vedioUrl;
    }

    public void setVedioUrl(String vedioUrl) {
        this.vedioUrl = vedioUrl;
    }

    public String getVedioDesc() {
        return vedioDesc;
    }

    public void setVedioDesc(String vedioDesc) {
        this.vedioDesc = vedioDesc;
    }

    public String getVedioTitle() {
        return vedioTitle;
    }

    public void setVedioTitle(String vedioTitle) {
        this.vedioTitle = vedioTitle;
    }

    public int getVedioStatus() {
        return vedioStatus;
    }

    public void setVedioStatus(int vedioStatus) {
        this.vedioStatus = vedioStatus;
    }

    public int getVedioType() {
        return vedioType;
    }

    public void setVedioType(int vedioType) {
        this.vedioType = vedioType;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorIdea() {
        return authorIdea;
    }

    public void setAuthorIdea(String authorIdea) {
        this.authorIdea = authorIdea;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserGoodThumbs() {
        return userGoodThumbs;
    }

    public void setUserGoodThumbs(int userGoodThumbs) {
        this.userGoodThumbs = userGoodThumbs;
    }

    @Override
    public String toString() {
        return "================VedioInfo{" +
                "vedioId=" + vedioId +
                ", vedioUrl='" + vedioUrl + '\'' +
                ", vedioDesc='" + vedioDesc + '\'' +
                ", vedioTitle='" + vedioTitle + '\'' +
                ", vedioStatus=" + vedioStatus +
                ", vedioType=" + vedioType +
                ", authorId=" + authorId +
                ", authorIdea='" + authorIdea + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userGoodThumbs=" + userGoodThumbs +
                '}';
    }
}
