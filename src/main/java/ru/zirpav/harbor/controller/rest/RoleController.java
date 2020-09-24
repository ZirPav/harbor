package ru.zirpav.harbor.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.zirpav.harbor.model.Role;
import ru.zirpav.harbor.service.RoleService;
import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/listRoles")
    public List<Role> listRoles(){
        return roleService.allRoles();
    }
}
