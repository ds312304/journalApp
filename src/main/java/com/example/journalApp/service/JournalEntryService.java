package com.example.journalApp.service;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalEntryRepo;
import com.example.journalApp.repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;


    @Transactional
    public void saveEntry(JournalEntry myEntry, String username){
        try{
            User user =  userService.findByUsername(username);
            JournalEntry saved = journalEntryRepo.save(myEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving entry: ",e);
        }

    }

    public void saveEntry(JournalEntry myEntry){
        journalEntryRepo.save(myEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId myid, String username){
        boolean removed = false;
        try{
            User user =  userService.findByUsername(username);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(myid));
            if(removed){
                userService.saveUser(user);
                journalEntryRepo.deleteById(myid);
            }
        }catch(Exception e){
            System.out.println(e);
            throw  new RuntimeException("An error occurred using deleting the entry by id: ", e);
        }
        return  removed;
    }

    public List<JournalEntry> findByUsername(String username){
        return null;
    }
}
