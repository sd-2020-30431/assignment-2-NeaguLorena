package com.assignment2.wasteless.Presentation.Controller;

import com.assignment2.wasteless.Data.Repository.GoalRepository;
import com.assignment2.wasteless.Presentation.Model.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GoalController {

    @Autowired
    GoalRepository goalRepository;

    @PostMapping("/set-goal")
    public Goal createGoal(@Valid @RequestBody Goal goal, Principal principal) {
        goal.setUsername(principal.getName());
        goal.setDay(new Date());
        return goalRepository.save(goal);
//        return "redirect:/groceryLists-user";
    }

}
