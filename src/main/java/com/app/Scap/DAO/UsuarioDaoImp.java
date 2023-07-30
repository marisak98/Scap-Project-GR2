package com.app.Scap.DAO;

import com.app.Scap.model.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Usuarios> getUsarios() {
        String query = "FROM Usuarios";
        return entityManager.createQuery(query).getResultList();
    }
}
