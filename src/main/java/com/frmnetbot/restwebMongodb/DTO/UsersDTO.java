package com.frmnetbot.restwebMongodb.DTO;

import java.time.Instant; // o java.util.Date, depende de tu modelo

public class UsersDTO {

    String id;
    private String userName;
    private String clvPass;
    private String emailUser;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private Instant fecRegistro; // usa Date si en tu entidad es Date

    // 🔹 Constructor con todos los campos (el que usas en el servicio)
    public UsersDTO(String id,String userName, String clvPass, String emailUser,
                    String nombres, String aPaterno, String aMaterno,
                    Instant fecRegistro) {
        this.id = id;
        this.userName = userName;
        this.clvPass = clvPass;
        this.emailUser = emailUser;
        this.nombres = nombres;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.fecRegistro = fecRegistro;
    }

   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClvPass() {
        return clvPass;
    }

    public void setClvPass(String clvPass) {
        this.clvPass = clvPass;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public Instant getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Instant fecRegistro) {
        this.fecRegistro = fecRegistro;
    }
}
