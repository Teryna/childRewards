package com.example.rewards.data;

import com.example.rewards.dto.ChildrenListItemDto;

import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private RewardsRepository repo;

    public ScheduleManager() {
        repo = new RewardsRepository();
    }

    public Iterable<ChildrenListItemDto> getChildResults(int childId) {
        var child = repo.getChild(childId);
        var childResults = repo.getSchedule(childId);

        List<ChildrenListItemDto> items = new ArrayList<>();

        return items;
    }

}
