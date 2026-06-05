package co.istad.kanhchana.elearninga01m1.features.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // ✅ FIX HERE
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsByName(String name);

    Page<Category> findAllByIsDeletedFalse(Pageable pageable);

    Optional<Category> findByIdAndIsDeletedFalse(Integer id);
}