package com.tudy.Crud.app.backend.sevice;

import com.tudy.Crud.app.backend.model.Project;
import com.tudy.Crud.app.backend.model.Trainer;
import com.tudy.Crud.app.backend.repo.ProjectRepo;
import com.tudy.Crud.app.backend.repo.TrainerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TrainerService {
    @Autowired
    private TrainerRepo trainerRepo;
    @Autowired
    private ProjectRepo projectRepo;


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


    public void deleteTrainer(long id){
        trainerRepo.deleteById(id);
    }


    public Trainer assignProjectToTrainer(long trainerId, long projectId) {
        Set<Project> projectSet =null;
        Trainer trainer = trainerRepo.findById(trainerId).get();
        Project project = projectRepo.findById(projectId).get();
        projectSet = trainer.getAssignedProjects();
        projectSet.add(project);
        trainer.setAssignedProjects(projectSet);
        System.out.println(trainer.getAssignedProjects());
        return trainerRepo.save(trainer);
    }

    public Trainer removeProjectFromTrainer(long trainerId, long projectId) {
        Set<Project> projectSet =null;
        Trainer trainer = trainerRepo.findById(trainerId).get();
        Project project = projectRepo.findById(projectId).get();
        projectSet = trainer.getAssignedProjects();
        projectSet.remove(project);
        trainer.setAssignedProjects(projectSet);
        System.out.println(trainer.getAssignedProjects());
        return trainerRepo.save(trainer);
    }
}
