package com.library.library_app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LibInfo {
    @Value("${library.name}")
    private String name ;
    @Value("${library.capacity}")
    private int number;

    public String getSummary() {
        return name + "Capacity : " + number;
    }
}
