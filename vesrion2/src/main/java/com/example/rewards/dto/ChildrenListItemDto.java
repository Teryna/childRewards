package com.example.rewards.dto;

import com.example.rewards.data.Child;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildrenListItemDto {
    private Child child;
    private int childNumber;
}
