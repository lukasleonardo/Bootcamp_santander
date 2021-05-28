package com.project.bootcamp.controller;


import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/stock") //para chamar esta classe direto na URL
public class StockController {
        @Autowired
        private StockService service;

    //ending point (save = metodo para insert na base de dados)
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
        public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
            return ResponseEntity.ok(service.save(dto));
        }
        //atualiza ações no banco de dados
        @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
            return ResponseEntity.ok(service.update(dto));
        }

        //responde todas as ações do banco de dados
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<StockDTO>> findAll(){
            return ResponseEntity.ok(service.findAll());
        }

        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
        public ResponseEntity<StockDTO> findById(@PathVariable Long id){

            return ResponseEntity.ok(service.findById(id));

        }


        @DeleteMapping(value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<StockDTO> delete(@PathVariable Long id){
            return ResponseEntity.ok(service.delete(id));
        }
        @GetMapping(value = "/today" , produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<StockDTO>> findByToday(){
            return ResponseEntity.ok(service.findByToday());
        }

}
