package com.davioooh.superrubrica.user;

public class UserStats {
    private String username;
    private int contactsCount;

    public UserStats(String username, int contactsCount) {
        this.username = username;
        this.contactsCount = contactsCount;
    }

    public String getUsername() {
        return username;
    }

    public int getContactsCount() {
        return contactsCount;
    }

}
