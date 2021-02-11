package co.wordbe.springwebmvc.event;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event model3 = Event.builder()
                .name("모델3 시승 체험")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2021,2,11,10,0,0))
                .endDateTime(LocalDateTime.of(2021,2,11,12,0,0))
                .build();

        Event cybertruck = Event.builder()
                .name("사이버트럭 시승 체험")
                .limitOfEnrollment(10)
                .startDateTime(LocalDateTime.of(2021,2,12,10,0,0))
                .endDateTime(LocalDateTime.of(2021,2,12,12,0,0))
                .build();

        return List.of(model3, cybertruck);
    }
}
