package com.mentoriadois.demo.controller;

import com.mentoriadois.demo.model.UserModel;
import com.mentoriadois.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping (value = "salvar") /*MAPEIA A URL*/
    @ResponseBody  /*Descrição da respota*/
    public ResponseEntity<UserModel>salvar(@RequestBody UserModel userModel){

        UserModel usuario = userRepository.save(userModel);

        return new ResponseEntity<UserModel>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idUser){

        userRepository.deleteById(idUser);

        return new ResponseEntity<String>("Usuário excluido com sucesso!", HttpStatus.OK);
    }

    @PutMapping (value = "atualizar")
    @ResponseBody
    public ResponseEntity<UserModel>atualizar(@RequestBody UserModel usuario){

        UserModel user = userRepository.saveAndFlush(usuario);

        return new ResponseEntity<UserModel>(user, HttpStatus.CREATED);
    }

    @GetMapping (value = "listartodos")
    @ResponseBody
    public ResponseEntity<List<UserModel>>listartodos(){

        List<UserModel> usuarios = userRepository.findAll();

        return new ResponseEntity<List<UserModel>>(usuarios, HttpStatus.OK);
    }



}
