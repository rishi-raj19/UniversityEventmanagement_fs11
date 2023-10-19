package com.example.UniversityEventManagement.repository;

import com.example.UniversityEventManagement.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEventRepo extends CrudRepository <Event,Long> {

    Iterable<Event> getAllEventByDate(LocalDate date);

}