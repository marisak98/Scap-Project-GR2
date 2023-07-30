package com.app.Scap.model;

import com.app.Scap.DAO.UsuarioDao;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuarios {
    @Id
    @Column(name = "IDUSUARIO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long idUsuario;

    @Column(name = "IDEMPLEADO")
    @Getter @Setter
    private Integer idEmpleado;

    @Column (name = "USUARIO")
    @Getter @Setter
    private String  usuario;

    @Column (name = "CLAVE")
    @Getter @Setter
    private String  clave;

    @Column (name = "USUDESCRIPCION")
    @Getter @Setter
    private String  usuDescripcion;

    @Column (name = "USUROL")
    @Getter @Setter
    private String  usuRol;



}
