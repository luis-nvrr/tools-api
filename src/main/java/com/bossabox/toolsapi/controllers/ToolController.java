package com.bossabox.toolsapi.controllers;

import java.util.List;

import com.bossabox.toolsapi.dtos.EmptyJsonResponse;
import com.bossabox.toolsapi.dtos.ToolRequest;
import com.bossabox.toolsapi.dtos.ToolResponse;
import com.bossabox.toolsapi.exceptions.ToolNotFoundException;
import com.bossabox.toolsapi.services.ToolService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools")
public class ToolController {
  private ToolService toolService;

  public ToolController(ToolService toolService) {
    this.toolService = toolService;
  }

  @GetMapping
  public ResponseEntity<List<ToolResponse>> getAllTools() {
    return ResponseEntity.ok(toolService.findAllTools());
  }

  @GetMapping(params = { "tag" })
  public ResponseEntity<List<ToolResponse>> getToolsByTag(@RequestParam("tag") String tag) {
    return ResponseEntity.ok(toolService.findToolsByTag(tag));
  }

  @PostMapping
  public ResponseEntity<ToolResponse> createTools(@RequestBody ToolRequest toolRequest) {
    return new ResponseEntity<ToolResponse>(toolService.createTool(toolRequest), HttpStatus.CREATED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<EmptyJsonResponse> removeTool(@PathVariable("id") int id) throws ToolNotFoundException {
    toolService.removeTool(id);
    return ResponseEntity.ok(new EmptyJsonResponse());
  }
}
