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

        for (var results :
                childResults) {
            items.add(mapChildResult(results, childResults));
        }

        return items;
    }


    private ChildrenListItemDto mapChildResult(Schedule schedule, Iterable<Schedule> childResults) {

        List<Schedule> items = new ArrayList<>();

        for (var result :
                childResults) {
            items.add(result);
        }
        var dayOfWeek = schedule.getDayOfWeek();
        var task = schedule.getTaskTitle();
        var points = schedule.getPoints();

        return new ChildrenListItemDto(dayOfWeek, task, points);
    }

}
