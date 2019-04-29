package com.qddx.domain;

import java.io.Serializable;

/**
 * @Description:
 * @Author: HUOHENGTONG
 * @CreateDate: 2019/4/27 23:37
 */
public class Email implements Serializable {
    private String from;

    private String to;

    private String theme;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
