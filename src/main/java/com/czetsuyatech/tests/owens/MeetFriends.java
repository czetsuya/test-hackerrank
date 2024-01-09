package com.czetsuyatech.tests.owens;

import java.util.Arrays;

public class MeetFriends {

  public static int meetFriends(int N, int[] A, int[] D) {

    //this is default OUTPUT. You can change it.
    int result = -404;

    Arrays.sort(A);
    Arrays.sort(D);

    //write your Logic here:
    int noOfMeetings = 0;
    for (int i = 0; i < N; i++) {
      noOfMeetings++;
      if (noOfMeetings > result) {
        result = noOfMeetings;
      }
      for (int j = 0; j < N; j++) {
        if (A[i] == D[j]) {
          noOfMeetings--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int N = 3;
    int[] A = {1, 2, 3};
    int[] D = {2, 4, 5};

    // 2
    System.out.println(MeetFriends.meetFriends(N, A, D));

    // 3
    N = 5;
    int[] A1 = {1, 2, 3, 4, 5};
    int[] D1 = {2, 4, 5, 6, 7};

    System.out.println(MeetFriends.meetFriends(N, A1, D1));

    // 3
    N = 5;
    int[] A2 = {1, 5, 3, 4, 2};
    int[] D2 = {2, 4, 7, 6, 7};

    System.out.println(MeetFriends.meetFriends(N, A2, D2));
  }
}
