package net.carProject.dao;

import net.carProject.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;


@Repository("RoleDao")
public  class RoleDao extends CRUDImpl<Role>{

    public RoleDao(){super(Role.class);}

    public Role getById(int id){
        TypedQuery<Role>query= entityManager.createQuery("SELECT r " +
                "FROM Role r " +
                "WHERE r.id=:id",Role.class);
        query.setParameter("id",id);
        Role role;
        try{
            role=query.getSingleResult();
        }catch (Exception e){
            return null;
        }
        return role;
    }
}
