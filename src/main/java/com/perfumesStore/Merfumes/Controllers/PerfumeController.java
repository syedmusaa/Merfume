package com.perfumesStore.Merfumes.Controllers;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumesStore.Merfumes.Entities.Perfume;
import com.perfumesStore.Merfumes.Services.PerfumeService;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {

    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public ResponseEntity<List<Perfume>> getAllPerfumes() {
        return new ResponseEntity<>(perfumeService.getAllPerfumes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable Long id) {
        Optional<Perfume> perfume = perfumeService.getPerfumeById(id);
        return perfume.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Perfume> createPerfume(@RequestBody Perfume perfume) {
        return new ResponseEntity<>(perfumeService.savePerfume(perfume), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Perfume> updatePerfume(@PathVariable Long id, @RequestBody Perfume perfumeDetails) {
        return perfumeService.getPerfumeById(id)
                .map(perfume -> {
                    perfume.setName(perfumeDetails.getName());
                    perfume.setBrand(perfumeDetails.getBrand());
                    perfume.setPrice(perfumeDetails.getPrice());
                    perfume.setDescription(perfumeDetails.getDescription());
                    return ResponseEntity.ok(perfumeService.savePerfume(perfume));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<Perfume> updatePerfume(@PathVariable Long id, @RequestBody Perfume perfume) {
//        Optional<Perfume> existingPerfume = perfumeService.getPerfumeById(id);
//        if (existingPerfume.isPresent()) {
//            perfume.setId(id);
//            return new ResponseEntity<>(perfumeService.savePerfume(perfume), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Perfume> deletePerfume(@PathVariable Long id) {
        return perfumeService.getPerfumeById(id)
                .map(perfume -> {
                    perfumeService.deletePerfume(id);
                    return ResponseEntity.ok().<Perfume>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Perfume> deletePerfume(@PathVariable Long id) {
//        Optional<Perfume> perfume = perfumeService.getPerfumeById(id);
//        if (perfume.isPresent()) {
//            perfumeService.deletePerfume(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}