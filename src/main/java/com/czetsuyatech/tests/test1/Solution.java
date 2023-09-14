package com.czetsuyatech.tests.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] args) {
    // you can write to stdout for debugging purposes, e.g.
    new Solution();
  }
  public Solution() {

    List<Profile> profiles = List.of(
        getProfile("user1", new HashSet<>(Arrays.asList("email1", "email2"))),
        getProfile("user2", new HashSet<>(Arrays.asList("email2", "email3"))),
        getProfile("user3", new HashSet<>(Arrays.asList("email4", "email5")))
    );

    mergeByUsername(profiles);
  }

  public List<Profile> mergeByUsername(List<Profile> profiles) {

    profiles.stream()
        .forEach(System.out::println);

    List<Profile> result = new ArrayList<>();

    var x = profiles.stream()
        .collect(Collectors.toMap(
            Profile::getUsername,
            Function.identity(),
            mergeProfiles()
        ));

    System.out.println("" + x);

//    for(int i = 0; i < profiles.size(); i++) {
//      for(int j = 1; j < profiles.size(); j++) {
//        if(profiles.get(i))
//      }
//    }

    return result;
  }

  private BinaryOperator<Profile> mergeProfiles() {

    return (p1, p2) -> {
      for (String email : p1.getEmails()) {
        if (p2.getEmails().contains(email)) {
          p1.getEmails().addAll(p2.getEmails());
          return p1;
        }
      }

      return p1;
    };
  }

  private Profile getProfile(String username, Set<String> emails) {

    Profile profile = new Profile(username);
    profile.setEmails(emails);

    return profile;
  }
}
