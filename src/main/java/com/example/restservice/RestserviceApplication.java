package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class RestserviceApplication {

    class Estado {

        private Long id;
        private String nome;

        private Estado(long id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        private void setId(long id) {
            this.id = id;
        }

        private String getNome() {
            return nome;
        }

        private void setNome(String nome) {
            this.nome = nome;
        }

        private long getId() {
            return id;
        }
    }

    class Cidade {

        private Long id;
        private String nome;
        private Estado estado;

        
        private Cidade(long id, String nome,Estado estado) {
            this.id = id;
            this.nome = nome;
            this.estado = estado;
        }

        private void setId(long id) {
            this.id = id;
        }

        private String getNome() {
            return nome;
        }

        private void setNome(String nome) {
            this.nome = nome;
        }

        private long getId() {
            return id;
        }

        private Estado getEstado() {
            return estado;
        }

        private void setEstado(Estado estado) {
            this.estado = estado;
        }
        
        
    }

    class DAOEstado {

        private final List<Estado> estados = new ArrayList<>();

        Estado est1 = new Estado(1, "North Carolina");
        Estado est2 = new Estado(2, "South Carolina");

        private List<Estado> getAllEstados() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return estados;
        }

        private Estado addEstado(Estado estado) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Random random = new Random();
            int nextId = random.nextInt(1000) + 10;

            estado.setId(nextId);
            estados.add(estado);

            return estado;
        }

        private void updateEstado(Estado estado) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            for (Estado oldEstado : estados) {
                if (oldEstado.getId() == estado.getId()) {
                    oldEstado.setNome(estado.getNome());
                }
            }
        }

        private void delete(long id) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            for (Estado estado : estados) {
                if (estado.getId() == id) {
                    // TO DO;
                    break;
                }
            }
        }

    }
    class DAOCidade {

        private final List<Cidade> cidades = new ArrayList<>();

        Cidade c1;

        DAOCidade(Estado estado,Cidade cidade) {
            this.c1 = new Cidade(0, "Cameron", estado);
        }
        

        public List<Cidade> getAllCidades() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return cidades;
        }

        public Cidade addCidade(Cidade cidade) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Random random = new Random();
            int nextId = random.nextInt(1000) + 10;

            cidade.setId(nextId);
            cidades.add(cidade);

            return cidade;
        }

        public void updateCidade(Cidade cidade) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            for (Cidade oldCidade : cidades) {
                if (oldCidade.getId() == cidade.getId()) {
                    oldCidade.setNome(cidade.getNome());
                    //oldCidade.setEstado(estado.getNome());
                }
            }
        }

        public void delete(long id) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            for (Cidade cidade : cidades) {
                if (cidade.getId() == id) {
                    //TO DO;
                    break;
                }
            }
        }

    }
    
    @RestController
    class UserController {


    @GetMapping("/cidade/")
    public List<Cidade> getAllCidades() {
        return getAllCidades();
    }

    @PostMapping("/cidade/")
    public ResponseEntity<Void> addCidade(@RequestBody Cidade newCidade, UriComponentsBuilder builder) {
        ResponseEntity<Void> Cidade = addCidade(newCidade, builder);
        //TO DO
        return Cidade;
    }

    @PutMapping("/cidade/")
    public ResponseEntity<Cidade> updateCidade(@RequestBody Cidade cidade) {
        Cidade c = cidade;
        //TO DO
        return updateCidade(cidade);
    }

    @DeleteMapping("/cidade/{cidadeId}")
    public int delete(@PathVariable long cidadeId) {
        
        //TO DO
        return 200;
    }


    }
    public static void main(String[] args) {
        SpringApplication.run(RestserviceApplication.class, args);
    }
}
