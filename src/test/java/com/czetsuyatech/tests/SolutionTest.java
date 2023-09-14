package com.czetsuyatech.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.czetsuyatech.tests.test1.Profile;
import com.czetsuyatech.tests.test1.Solution;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void mergeByUsernameSimple() {

    List<Profile> profiles = List.of(
        getProfile("user1", new HashSet<>(Arrays.asList("email1", "email2"))),
        getProfile("user2", new HashSet<>(Arrays.asList("email2", "email3"))),
        getProfile("user3", new HashSet<>(Arrays.asList("email4", "email5")))
    );

    Solution s = new Solution();
    List<Profile> result = s.mergeByUsername(profiles);

    assertEquals(2, result.size());
  }

  private Profile getProfile(String username, Set<String> emails) {

    Profile profile = new Profile(username);
    profile.setEmails(emails);

    return profile;
  }
}
