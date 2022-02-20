package com.company;

import java.util.ArrayList;
import java.util.List;

public class Human implements ISentient {

    String identity;
    List<ISentient> likes;

    public Human(String identity)  {
        this.identity = identity;
        this.likes = new ArrayList<>();
    }

    @Override
    public boolean likes(ISentient other) {
        return this.likes.contains(other);
    }

    @Override
    public void setLikes(ISentient other) {
        this.likes.add(other);
    }

    @Override
    public String getIdentity() {
        return this.identity;
    }
}
