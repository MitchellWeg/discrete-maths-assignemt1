package com.company;

public interface ISentient {
    boolean likes(ISentient other);
    void setLikes(ISentient other);
    String getIdentity();
}
