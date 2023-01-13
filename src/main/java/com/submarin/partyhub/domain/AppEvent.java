package com.submarin.partyhub.domain;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppEvent {
    private Long id;
    private String name;
    private String location;
    private LocalDateTime date;
    private String shortDescription;
    private String description;
    private String image;
    private int ticketPrice;
}
