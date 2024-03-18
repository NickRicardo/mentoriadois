package com.mentoriadois.demo.controller;

import com.mentoriadois.demo.Dto.UserDto;
import com.mentoriadois.demo.mapper.UserMapper;
import com.mentoriadois.demo.model.UserModel;
import com.mentoriadois.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
public class UserController {

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "salvar") /* MAPEIA A URL */
    @ResponseBody /* Descrição da respota */
    public ResponseEntity<UserModel> salvar(@RequestBody UserDto userDto) {
        UserModel usuario = UserMapper.toEntity(userDto);
        UserModel usuarioSalvo = userRepository.save(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUser) {

        userRepository.deleteById(idUser);

        return new ResponseEntity<String>("Usuário excluido com sucesso!", HttpStatus.OK);
    }

    @PostMapping(value = "/atualizar")
    @ResponseBody
    public ResponseEntity<UserModel> atualizar(@RequestBody UserModel usuario) {

        UserModel user = userRepository.saveAndFlush(usuario);

        return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "listartodos")
    @ResponseBody
    public ResponseEntity<List<UserModel>> listartodos() {

        List<UserModel> usuarios = userRepository.findAll();

        return new ResponseEntity<List<UserModel>>(usuarios, HttpStatus.OK);
    }

}
