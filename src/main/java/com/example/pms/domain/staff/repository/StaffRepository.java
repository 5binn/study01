package com.example.pms.domain.staff.repository;

import com.example.pms.domain.staff.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("SELECT s FROM Staff s WHERE s.name LIKE '%' || :name || '%'")
    Page<Staff> findByName(@Param("name") String name, Pageable pageable);

    @Query("SELECT s FROM Staff s WHERE s.name LIKE '%' || :name || '%' AND s.endDate IS NOT NULL")
    Page<Staff> findByNameAndEndDateNotNull(@Param("name") String name, Pageable pageable);

    @Query("SELECT s FROM Staff s WHERE s.name LIKE '%' || :name || '%' AND s.endDate IS NULL")
    Page<Staff> findByNameAndEndDateIsNull(@Param("name") String name, Pageable pageable);

    Page<Staff> findAll(Pageable pageable);

}
