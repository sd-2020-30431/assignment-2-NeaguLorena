package com.assignment2.wasteless.Data.Repository;

import com.assignment2.wasteless.Presentation.Model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {
    List<Goal> getAllByUsername(String username);
    Goal getTopByDay(Date day);
}
