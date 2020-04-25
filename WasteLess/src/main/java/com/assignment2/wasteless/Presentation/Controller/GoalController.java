package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Bussiness.Service.ReminderService;
import com.assignment2.wasteless.Bussiness.Service.UserService;
import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Presentation.Model.Goal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GoalController {

    private final GoalRepository goalRepository;
    private final ReminderService reminderService;

    public GoalController(GoalRepository goalRepository, ReminderService reminderService) {
        this.goalRepository = goalRepository;
        this.reminderService = reminderService;
    }

    @PostMapping("/goal")
    public Goal createGoal(@RequestBody Goal goal ) {
        goal.setUsername(UserService.getLoggedUser().getUsername());
        goal.setDay(new Date());
        return goalRepository.save(goal);
//        return "redirect:/groceryLists-user";
    }

    @GetMapping("/goal")
    public List<Goal> getAllGoals(){
        List<Goal> goals = goalRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
        return goals;
    }

    @GetMapping("/reminder")
    public String getReminderMessage(){
        String message;
        List<Goal> goals = goalRepository.getAllByUsername(UserService.getLoggedUser().getUsername());
        Goal g = goals.get(goals.size() - 1);
        if (g != null)
            message = reminderService.getReminder(UserService.getLoggedUser().getUsername(), g);
        else message = "No goal set yet!";
        return message;
    }
}
