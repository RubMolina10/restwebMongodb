package com.frmnetbot.restwebMongodb.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UsersDATA {
    @Id
    private String id;
    private String userName;
    private String clvPass;
    private String emailUser;
    private String nombres;
    private String aPaterno;
    private String aMaterno;
    private Instant fecRegistro = Instant.now(); 

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

    public String getclvPass() {
        return clvPass;
    }

    public void setclvPass(String clvPass) {
        this.clvPass = clvPass;
    }

    public String getemailUser() {
        return emailUser;
    }

    public void setemailUser(String emailUser) {
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
