package com.perfumesStore.Merfumes.Services;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.perfumesStore.Merfumes.Entities.Perfume;

import com.perfumesStore.Merfumes.Repositories.PerfumeRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;
    
//    @Autowired
//    private UserRepository userRepository;

    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }
    
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
    
    public Perfume savePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }
	
    public Optional<Perfume> getPerfumeById(Long id) {
        return perfumeRepository.findById(id);
    }
    
    public Optional<List<Perfume>> getPerfumeByName(String name) {
        return perfumeRepository.findByName(name);
    }
    
    public Optional<List<Perfume>> getPerfumeByBrand(String brand) {
        return perfumeRepository.findByBrand(brand);
    }
    
    public Optional<List<Perfume>> getPerfumeByPrice(BigDecimal price) {
        return perfumeRepository.findByPrice(price);
    }
    
    public Optional<List<Perfume>> getPerfumeByRating(float rating) {
        return perfumeRepository.findByRating(rating);
    }

//    @Autowired
//    private PerfumeRepository perfumeRepository;
//
//    public List<Perfume> getAllPerfumes() {
//        return perfumeRepository.findAll();
//    }
//
//    public Optional<Perfume> getPerfumeById(Long id) {
//        return perfumeRepository.findById(id);
//    }
//
//    public Perfume savePerfume(Perfume perfume) {
//        return perfumeRepository.save(perfume);
//    }
//
    public void deletePerfume(Long id) {
        perfumeRepository.deleteById(id);
    }
}