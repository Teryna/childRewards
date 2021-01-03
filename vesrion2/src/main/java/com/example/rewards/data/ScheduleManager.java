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
        var task = repo.getChildTasks(childId);
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
        var taskId = schedule.getTaskId();
        var points = schedule.getPoints();
        var task = schedule.getTask();

        return new ChildrenListItemDto(dayOfWeek, taskId, points, task);
    }

}
