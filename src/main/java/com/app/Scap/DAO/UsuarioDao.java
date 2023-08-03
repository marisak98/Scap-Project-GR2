package com.app.Scap.DAO;

import com.app.Scap.model.Usuarios;

import java.util.List;

public interface UsuarioDao {
    List<Usuarios> getUsarios();

    void eliminar(Long id);

    void isertarUsuarios(Usuarios usuarios);

    Usuarios credencialesValidar(String usuarios, String clave);
}
