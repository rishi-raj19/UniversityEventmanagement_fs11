package com.example.UniversityEventManagement.service;

import com.example.UniversityEventManagement.model.Event;
import com.example.UniversityEventManagement.model.Student;
import com.example.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;


    public String addEvent(Event event) {
        eventRepo.save(event);
        return "Event Added";
    }

    public String UpdateEvent(Long eventId, String location) {
        if (eventRepo.existsById(eventId)) {
            Optional<Event> event = eventRepo.findById(eventId);
            Event myevent = event.get();
            myevent.setLocationOfEvent(location);
            eventRepo.save(myevent);
            return "Event Updated";
        } else {
            return "Event Id does not exist";
        }
    }

    public String DeleteEvent(Long eventId) {
        if (eventRepo.existsById(eventId)) {
            eventRepo.deleteById(eventId);
            return "Event Deleted";
        } else {
            return "Event Id does not exist";
        }
    }

//    public Iterable<Event> getAllEventByDate(LocalDate date) {
//        ArrayList<Event> original = new ArrayList<>();
//        for(Event event :eventRepo.findAll()){
//            if(event.getDate().isEqual(date)){
//                original.add(event);
//            }
//        }
//        return original;
//    }

    public Iterable<Event> getAllEventByDate(LocalDate date) {
        return eventRepo.getAllEventByDate(date);
    }

    public Iterable<Event> getAllEvents() {
        return eventRepo.findAll();
    }
}

