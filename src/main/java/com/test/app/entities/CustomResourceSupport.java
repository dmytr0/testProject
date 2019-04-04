package com.test.app.entities;

import com.test.app.annotations.DeserializeLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

public abstract class CustomResourceSupport extends ResourceSupport {

    @DeserializeLinks
    public void setLinks(List<Link> links) {
        super.add(links);
    }
}
