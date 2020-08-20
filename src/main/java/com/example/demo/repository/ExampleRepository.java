package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Example;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Long>{

	@Query("SELECT ex FROM example ex WHERE active=:flag")
	public Example changestate(@Param("flag") boolean flag);
}
