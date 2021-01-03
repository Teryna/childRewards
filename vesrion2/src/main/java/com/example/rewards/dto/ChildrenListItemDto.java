package com.example.rewards.dto;

import com.example.rewards.data.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildrenListItemDto {
    private String dayOfWeek;
    private int taskId;
    private int points;
    private Task task;
}
