package com.example.rewards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildrenListItemDto {
    private String dayOfWeek;
    private String task;
    private int points;
}
