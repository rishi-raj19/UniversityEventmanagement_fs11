package com.example.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "event")
public class Event {
    @Id
    private Long eventId;

    @NotBlank(message = "userName cannot be blank")
    private String userName;

    @NotBlank(message = "eventName cannot be blank")
    @Pattern(regexp =  "[A-Z][a-zA-Z0-9]*")
    private String eventName;

    @NotBlank(message = "locationOfEvent cannot be blank")
    private String locationOfEvent;

    @NotNull
    private LocalDate date;

    private LocalTime startTime;
    private LocalTime endTime;



}