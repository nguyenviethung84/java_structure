package com.example.structure.controller;

import com.example.structure.service.TwoSumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/two-sum")
public class TwoSumController {

    @Autowired
    private TwoSumService twoSumService;

    @PostMapping("/brute-force")
    public int[] solveWithBruteForce(@RequestBody TwoSumRequest request) {
        return twoSumService.twoSumBruteForce(request.getNums(), request.getTarget());
    }

    @PostMapping("/hash-map")
    public int[] solveWithHashMap(@RequestBody TwoSumRequest request) {
        return twoSumService.twoSumHashMap(request.getNums(), request.getTarget());
    }

    // Request DTO
    static class TwoSumRequest {
        private int[] nums;
        private int target;

        // Getters and Setters
        public int[] getNums() { return nums; }
        public void setNums(int[] nums) { this.nums = nums; }
        public int getTarget() { return target; }
        public void setTarget(int target) { this.target = target; }
    }
}
