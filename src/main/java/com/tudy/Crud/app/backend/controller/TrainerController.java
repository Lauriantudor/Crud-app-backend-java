package com.tudy.Crud.app.backend.controller;

import com.tudy.Crud.app.backend.model.Project;
import com.tudy.Crud.app.backend.model.Trainer;
import com.tudy.Crud.app.backend.sevice.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainers")
@CrossOrigin("http://localhost:4200/")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer saveTrainer(@RequestBody Trainer trainer){
        return trainerService.saveTrainer(trainer);
    }
    @GetMapping
    public List<Trainer> getTrainers(){
        return trainerService.getTrainers();
    }
   @GetMapping("{id}")
   public Trainer getTrainerById(@PathVariable long id){
       return trainerService.getTrainerById(id);
   }

    @PutMapping("{id}")
    public Trainer updateTrainer(@PathVariable long id, @RequestBody Trainer trainer){
       return trainerService.updateTrainer(id,trainer);
    }

    @PutMapping("addTo/{id}")
    public Trainer addProjectTo(@PathVariable long id, @RequestBody Project project){
        return trainerService.addProjectTo(id,project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable long id){
        trainerService.deleteTrainer(id);
    }

}
