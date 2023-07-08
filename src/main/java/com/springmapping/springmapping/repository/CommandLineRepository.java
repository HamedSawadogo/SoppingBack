package com.springmapping.springmapping.repository;

import com.springmapping.springmapping.entities.CommandLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLine,Long> {
}
