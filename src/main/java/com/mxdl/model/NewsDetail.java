package com.mxdl.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Description: <NewsDetail><br>
 * Author:    mxdl<br>
 * Date:      2019/6/11<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Entity
@Table(name = "news_detail")
public class NewsDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "typeid")
    private int typeid;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @CreatedDate
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "addtime", updatable = false, nullable = false)
    private Date addtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
