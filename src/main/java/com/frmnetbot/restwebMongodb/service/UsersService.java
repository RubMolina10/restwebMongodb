package com.frmnetbot.restwebMongodb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frmnetbot.restwebMongodb.DTO.UsersDTO;
import com.frmnetbot.restwebMongodb.model.UsersDATA;
import com.frmnetbot.restwebMongodb.repository.UsersRepository;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
   
    public UsersService(UsersRepository repository) {
        this.usersRepository = repository;
    }
   
   public List<UsersDTO> getAll() {
    return usersRepository.findAll()
            .stream()
            .map(u -> new UsersDTO(
                    u.getId(),
                    u.getUserName(),
                    u.getclvPass(),
                    u.getemailUser(),
                    u.getNombres(),
                    u.getaPaterno(),
                    u.getaMaterno(),
                    u.getFecRegistro()
            ))
            .toList();
}



     public UsersDATA crearUsuario(UsersDATA usuario) {
        return usersRepository.save(usuario);
    }

    public List<UsersDATA> listarUsuarios() {
        return usersRepository.findAll();
    }
}
    