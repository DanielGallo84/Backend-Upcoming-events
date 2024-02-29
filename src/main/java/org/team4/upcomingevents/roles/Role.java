package org.team4.upcomingevents.roles;

import java.util.Set;

import org.team4.upcomingevents.users.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_role")
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    Set<User> users;

}
