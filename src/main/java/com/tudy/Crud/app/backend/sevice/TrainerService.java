package com.tudy.Crud.app.backend.sevice;

import com.tudy.Crud.app.backend.model.Project;
import com.tudy.Crud.app.backend.model.Trainer;
import com.tudy.Crud.app.backend.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerRepo trainerRepo;



    public Trainer saveTrainer(Trainer trainer){
        return trainerRepo.save(trainer);
    }

    public List<Trainer> getTrainers(){
        return trainerRepo.findAll();
    }
    public Trainer getTrainerById(long id){
        return trainerRepo.findById(id).orElse(null);
    }
    public Trainer updateTrainer(long id, Trainer trainer){
        Trainer exitingTrainer = trainerRepo.findById(id).orElse(null);
        exitingTrainer.setName(trainer.getName());
        exitingTrainer.setEmail(trainer.getEmail());
        exitingTrainer.setInstitution(trainer.getInstitution());
        exitingTrainer.setPhoneNumber(trainer.getPhoneNumber());


        return trainerRepo.save(exitingTrainer);
    }
    public Trainer addProjectTo(long id, Project project){
        Trainer toTrainer = trainerRepo.findById(id).orElse(null);
        toTrainer.setProject(project);
        return toTrainer;
    }

    public void deleteTrainer(long id){
        trainerRepo.deleteById(id);
    }




}
