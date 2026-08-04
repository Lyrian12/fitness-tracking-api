package com.booking.demo.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
private final JdbcClient  JdbcClient;

public RunRepository(JdbcClient jdbcClient){
    this.JdbcClient= jdbcClient;
}

public List<Run> FindAll(){
 return    JdbcClient.sql("SELECT * FROM Run")
            .query(Run.class)
            .list();
}
public Optional<Run> findById(Integer id){
    return JdbcClient.sql("SELECT * FROM Run WHERE id = :id")
            .param("id",id)
            .query(Run.class)
            .optional();
}
public void create(Run run){
        var updated = JdbcClient.sql("INSERT INTO Run (id,title,started_on,completed_on,miles,location) VALUES (?,?,?,?,?,?)")
            .params (List.of(run.getTitle(),run.getTitle(),run.getStartedOn(),run.getCompletedOn(),run.getMiles(),run.getLocation().toString()))
            .update();
    Assert.state(updated ==1,"failed to create run" + run.getTitle());
}


}
