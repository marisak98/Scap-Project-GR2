package com.app.Scap.controllers;

import com.app.Scap.DAO.UsuarioDao;
import com.app.Scap.model.Usuarios;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import com.app.Scap.model.Usuarios;



public class AuthController {

    private UsuarioDao usuarioDao;

    public boolean loginUsuarios(String usuarios, String clave) {

        Usuarios usuariosAutenticado = usuarioDao.credencialesValidar(usuarios, clave);
       return usuariosAutenticado != null;

    }

}
