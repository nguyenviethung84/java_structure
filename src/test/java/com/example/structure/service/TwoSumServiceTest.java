package com.example.structure.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TwoSumServiceTest {

    @Autowired
    private TwoSumService twoSumService;

    public TwoSumServiceTest(TwoSumService twoSumService) {
        this.twoSumService = twoSumService;
    }

    @Test
    public void testBruteForce_Success() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumService.twoSumBruteForce(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testBruteForce_NoSolution() {
        int[] nums = {1, 2, 3};
        int target = 7;
        assertThrows(IllegalArgumentException.class, () -> {
            twoSumService.twoSumBruteForce(nums, target);
        });
    }

    @Test
    public void testHashMap_Success() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSumService.twoSumHashMap(nums, target);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    public void testHashMap_NoSolution() {
        int[] nums = {1, 2, 3};
        int target = 7;
        assertThrows(IllegalArgumentException.class, () -> {
            twoSumService.twoSumHashMap(nums, target);
        });
    }
}
