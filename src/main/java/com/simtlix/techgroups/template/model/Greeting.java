package com.simtlix.techgroups.template.model;

public class Greeting {

    private long id;
    private String greeting;

    public Greeting() {
    }

    public Greeting(long id, String greeting) {
        this.id = id;
        this.greeting = greeting;
    }

    public long getId() {
        return id;
    }

    public String getGreeting() {
        return greeting;
    }
}
