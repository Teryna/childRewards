package com.example.rewards.dto;
import com.example.rewards.data.Child;
import lombok.Data;

@Data
public class TaskUpdateDto {
    private String title;
    private int points;
    private byte isItDone;
    private int childId;
}
