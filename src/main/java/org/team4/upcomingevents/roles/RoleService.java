package org.team4.upcomingevents.roles;

import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class RoleService {

    RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role getById(@NonNull Long id) {
        Role role = repository.findById(id).orElseThrow( () -> new RoleNotFoundException("Role Not found") );
        return role;
    }
}
