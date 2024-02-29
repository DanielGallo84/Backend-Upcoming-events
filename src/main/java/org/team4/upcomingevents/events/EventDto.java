package org.team4.upcomingevents.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    
    private String title;
    private String date;
    private String hour;
    private String place;
    private String description;
    private int capacity;
    private boolean isOutstanding;

}
