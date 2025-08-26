package com.frmnetbot.restwebMongodb.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frmnetbot.restwebMongodb.Security.JwtTokenProvider;
import com.frmnetbot.restwebMongodb.model.UsersDATA;
import com.frmnetbot.restwebMongodb.repository.UsersRepository;
import com.frmnetbot.restwebMongodb.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final UsersRepository repository;
    private final JwtTokenProvider jwtUtil;


    @Autowired
    public UsersController(UsersService usersService, UsersRepository repository, JwtTokenProvider jwtUtil) {
        this.usersService = usersService;
        this.repository = repository; 
        this.jwtUtil = jwtUtil;  
    }

    // Insertar usuario
    @PostMapping
    public UsersDATA createUser(@RequestBody UsersDATA usuario) {

        String hashedPassword = md5(usuario.getclvPass());
        usuario.setclvPass(hashedPassword);
        return usersService.crearUsuario(usuario);
    }

   @GetMapping("/login")
   public Map<String, Object> login(
           @RequestParam("username") String userName,
           @RequestParam("password") String clvPass) {

       // Convertir la contraseña ingresada a hash MD5
       String hashedPassword = md5(clvPass);

       // Buscar por username y password en la base de datos
       Optional<UsersDATA> userOpt = repository.findByUserNameAndClvPass(userName, hashedPassword);

       Map<String, Object> response = new HashMap<>();
       if (userOpt.isPresent()) {
           response.put("status", "success");
           response.put("message", "Usuario encontrado");
           response.put("user", userOpt.get());
       } else {
           response.put("status", "error");
           response.put("message", "Usuario no encontrado");
       }

       return response;
   }

    // Obtener todos los usuarios
    @GetMapping
    public List<UsersDATA> listarUsuarios() {
        return usersService.listarUsuarios();
    }

    private String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Convertimos a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
