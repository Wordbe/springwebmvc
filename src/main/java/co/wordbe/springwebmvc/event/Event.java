package co.wordbe.springwebmvc.event;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Event {

    private String name;

    private int LimitOfEnrollment;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;
}
