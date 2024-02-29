package org.team4.upcomingevents.events;

import java.util.Set;

import org.team4.upcomingevents.users.User;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "events")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long id; 

    private String title;
    private String date;
    private String hour;
    private String place;
    @Column(columnDefinition = "TEXT")
    private String description;
    private int capacity;
    @Builder.Default
    @Column(name = "is_outstanding")
    private boolean isOutstanding = false;
    private String img;

    @JsonIgnore
    @ManyToMany(mappedBy = "events")
    Set<User> users;

}


