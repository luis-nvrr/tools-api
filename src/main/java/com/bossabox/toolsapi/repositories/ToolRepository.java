package com.bossabox.toolsapi.repositories;

import java.util.List;

import com.bossabox.toolsapi.entitites.Tool;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Integer> {

  List<Tool> findByTags(String tag);
}
