package ru.zirpav.harbor.dao;

import org.springframework.stereotype.Repository;
import ru.zirpav.harbor.model.Role;
import ru.zirpav.harbor.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> allRoles() {
        List<Role> roleList = entityManager.createQuery("SELECT r FROM Role r").getResultList();
        return roleList;
    }
}
