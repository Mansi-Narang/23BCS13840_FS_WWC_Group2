package com.example.wwc.Controller;

import java.util.ArrayList;
import java.util.List;
import com.example.wwc.Model.Event;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/events")

public class EventController {
    private List<Event> events = new ArrayList<>();

    @GetMapping
    public List<Event> getAllEvents(){
        return events;
    }

    @PostMapping
    public String addEvent(@RequestBody Event event){
        events.add(event);
        return "Event added successfully";
    }

    @GetMapping("/{id}")
    public String getEvent(@PathVariable int id){
        return events.get(id).getName();
    }

    @DeleteMapping
    public String deleteEvent(@RequestParam String id){
        events.remove(Integer.parseInt(id));
        return "Event deleted successfully";
    }

}
