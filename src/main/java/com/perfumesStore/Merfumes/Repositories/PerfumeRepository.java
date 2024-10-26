package com.perfumesStore.Merfumes.Repositories;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perfumesStore.Merfumes.Entities.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
	Optional<Perfume> findById(Long id);
	Optional<List<Perfume>> findByName(String name);
    Optional<List<Perfume>> findByBrand(String brand);
    Optional<List<Perfume>> findByPrice(BigDecimal price);
    Optional<List<Perfume>> findByRating(float rating);
}