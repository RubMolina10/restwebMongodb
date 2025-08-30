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
   // Actualizar usuario
    public UsersDATA actualizarUsuario(UsersDATA usuario) {
        if (usuario.getId() == null || usuario.getId().isEmpty()) {
            throw new IllegalArgumentException("El id no puede ser null para actualizar");
        }

        // Busca si existe el usuario
        UsersDATA existente = usersRepository.findById(usuario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuario con id " + usuario.getId() + " no existe"));

     
        existente.setUserName(usuario.getUserName());
        existente.setclvPass(usuario.getclvPass());
        existente.setemailUser(usuario.getemailUser());
        existente.setNombres(usuario.getNombres());
        existente.setaPaterno(usuario.getaPaterno());
        existente.setaMaterno(usuario.getaMaterno());

        return usersRepository.save(existente);
    }

    public List<UsersDATA> listarUsuarios() {
        return usersRepository.findAll();
    }
  public void eliminarUsuario(String id) {
    UsersDATA usuario = usersRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Usuario con id " + id + " no existe"));
    usersRepository.delete(usuario);
}

}
    