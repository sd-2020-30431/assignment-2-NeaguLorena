package com.assignment2.wasteless.Presentation.Model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity(name = "GOAL")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String username;
    @Positive
    private int numberOfCaloriesADay;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day;

    public Goal() {

    }

    public Goal(String username, int numberOfCaloriesADay, Date day) {
        this.username = username;
        this.numberOfCaloriesADay = numberOfCaloriesADay;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfCaloriesADay() {
        return numberOfCaloriesADay;
    }

    public void setNumberOfCaloriesADay(int numberOfCaloriesADay) {
        this.numberOfCaloriesADay = numberOfCaloriesADay;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", numberOfCaloriesADay=" + numberOfCaloriesADay +
                '}';
    }
}
