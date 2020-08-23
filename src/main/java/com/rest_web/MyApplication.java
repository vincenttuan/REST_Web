package com.rest_web;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("v1")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return super.getClasses();
    }
}
