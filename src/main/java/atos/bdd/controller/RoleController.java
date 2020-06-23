package atos.bdd.controller;

import atos.bdd.dao.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class RoleController {

    IRoleDao iRoleDao;

    @Autowired
    public RoleController(IRoleDao iRoleDao) {
        this.iRoleDao = iRoleDao;
    }
}
