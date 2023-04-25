package com.czetsuyatech.tests;

import com.czetsuyatech.tests.archive.FindKthSmallestTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindKthSmallestTestTest {

    @Test
    void findKthSmallest() {

        int[] input = {};
        int k = 1;

        int result = FindKthSmallestTest.findKthSmallest(input, k);

        Assertions.assertEquals(1, result);
    }
}
