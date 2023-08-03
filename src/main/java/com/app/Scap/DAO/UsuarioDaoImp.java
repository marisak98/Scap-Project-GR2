package com.app.Scap.DAO;

import com.app.Scap.model.Usuarios;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import de.mkammerer.argon2.Argon2;

import java.util.List;


@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @FXML
    private TextField loginUsernameTextField;
    @FXML
    private TextField loginPasswordPasswordField;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuarios> getUsarios() {
        String query = "FROM Usuarios";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public void isertarUsuarios(Usuarios usuarios) {
            entityManager.merge(usuarios);
    }

    @Override
    public Usuarios credencialesValidar(String usuarios, String clave) {

        String query = "FROM usuarios WHERE USUARIO = :USUARIO";
        List<Usuarios> listaUsuarios = entityManager.createQuery(query).
                setParameter("USUARIO", usuarios)
                .getResultList();

        if (listaUsuarios.isEmpty()){
            return null;
        }

        String listaHashed = listaUsuarios.get(0).getClave();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(listaHashed, clave)){
            return listaUsuarios.get(0);
        }
        return null;
    }

}
