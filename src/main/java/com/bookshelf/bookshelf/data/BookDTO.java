package com.bookshelf.bookshelf.data;

import jakarta.annotation.Nonnull;

public class BookDTO {

    private long id;

    @Nonnull
    private String name;

    @Nonnull
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
