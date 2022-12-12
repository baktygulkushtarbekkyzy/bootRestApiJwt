package com.example.bootrestapi.repository;

import com.example.bootrestapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("select y from Course y where y.company.id=:companyId")
    List<Course> getAll(Long companyId);
}
