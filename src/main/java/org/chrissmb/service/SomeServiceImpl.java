package org.chrissmb.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SomeServiceImpl implements SomeService {

    @Override
    public String getContent() {
        return "My service Content";
    }
}
