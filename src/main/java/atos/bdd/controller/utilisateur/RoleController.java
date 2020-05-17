package atos.bdd.controller.utilisateur;

import atos.bdd.dao.utilisateur.IRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    IRoleDao iRoleDao;

    @Autowired
    public RoleController(IRoleDao iRoleDao) {
        this.iRoleDao = iRoleDao;
    }
}
