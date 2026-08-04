package com.booking.demo.run;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository =  runRepository;
    }
//get {ressort les instances disponibles }
    @GetMapping()
List<Run> findAll(){
    return runRepository.FindAll();
}
    @ GetMapping("{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty())
            throw new RunNotFoundException();
        else {
            return run.get();
        }
    }
//
////post {cree de nouvelles instances}
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void  create (@Valid @RequestBody  Run run){
        runRepository.create(run);
    }
//
////mettre a jour {permet de mettre a jour une nouvelle instances}
//    @PutMapping("/{id}")
//void update(@RequestBody Run run, @PathVariable Integer id ){
//        runRepository.update(run,id);
//}
//
//// supprimer un champ
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("{id}")
//void delete(@PathVariable Integer id){
//        runRepository.delete(id);
//}
}
