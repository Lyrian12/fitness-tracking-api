package com.booking.demo.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();
        //obtenir
        List<Run> findAll(){
            return runs;
        }
       Optional<Run> FindById(Integer id){
            return runs.stream()
                    .filter(run -> run.id == id)
                    .findFirst();


        }
        //creer
        void Create(Run run){
            runs.add(run);
        }
        //mettre a jour
        void update(Run run , Integer id ){
            Optional<Run> existingrun = FindById(id);
            if(existingrun.isPresent())
                runs.set(runs.indexOf(existingrun.get()),run);
        }

        //suprimer
        void delete(Integer id ){
            runs.removeIf(run -> run.id.equals(id));
        }




        @PostConstruct
    private void init(){
            runs.add(new Run(
               1,
               "Monday Morning Run",
               LocalDateTime.now(),
               LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
               3,
               Location.OUTDOOR
            ));

            runs.add(new Run(
                    2,
                    "Wednesday Evening Run",
                    LocalDateTime.now(),
                    LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                    3,
                    Location.OUTDOOR
            ));


            runs.add(new Run(
                    3,
                    "Friday Morning Run",
                    LocalDateTime.now(),
                    LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                    3,
                    Location.OUTDOOR
            ));


            runs.add(new Run(
                    4,
                    "Sunday Afternoon Run",
                    LocalDateTime.now(),
                    LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                    3,
                    Location.OUTDOOR
            ));

            runs.add(new Run(
                    5,
                    "Tuesday Morning Run",
                    LocalDateTime.now(),
                    LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
                    3,
                    Location.OUTDOOR
            ));


        }
}
