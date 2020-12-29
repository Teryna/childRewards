package com.example.rewards.dto;

import lombok.Data;

@Data
public class TaskUpdateDto {
    private String title;
    private int points;
    private boolean isItDone;
}
