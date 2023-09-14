package com.czetsuyatech.tests.test1;

import java.util.Set;

public class Profile {

  private String username;
  private Set<String> emails;

  public Profile(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<String> getEmails() {
    return emails;
  }

  public void setEmails(Set<String> emails) {
    this.emails = emails;
  }

  @Override
  public String toString() {
    return "Profile{" +
        "username='" + username + '\'' +
        ", emails=" + emails +
        '}';
  }
}
