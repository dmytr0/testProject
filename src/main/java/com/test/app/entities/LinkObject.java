package com.test.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkObject {
    private String rel;
    private String href;

    public String getRel() {
        return this.rel;
    }

    public String getHref() {
        return this.href;
    }

    public LinkObject setRel(String rel) {
        this.rel = rel;
        return this;
    }

    public LinkObject setHref(String href) {
        this.href = href;
        return this;
    }
}
