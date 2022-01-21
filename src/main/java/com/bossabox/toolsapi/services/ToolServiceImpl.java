package com.bossabox.toolsapi.services;

import java.util.List;
import java.util.Optional;

import com.bossabox.toolsapi.dtos.ToolRequest;
import com.bossabox.toolsapi.dtos.ToolResponse;
import com.bossabox.toolsapi.entitites.Tool;
import com.bossabox.toolsapi.exceptions.ToolNotFoundException;
import com.bossabox.toolsapi.repositories.ToolRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImpl implements ToolService {

  private ToolRepository toolRepository;
  Logger logger = LoggerFactory.getLogger(ToolServiceImpl.class);

  public ToolServiceImpl(ToolRepository toolRepository) {
    this.toolRepository = toolRepository;
  }

  @Override
  public List<ToolResponse> findAllTools() {
    List<Tool> tools = toolRepository.findAll();
    List<ToolResponse> responseTools = tools.stream().map(tool -> createToolResponse(tool))
        .toList();

    return responseTools;
  }

  private ToolResponse createToolResponse(Tool tool) {
    return new ToolResponse(tool.getId(), tool.getTitle(), tool.getLink(), tool.getDescription(), tool.getTags());
  }

  @Override
  public ToolResponse createTool(ToolRequest toolRequest) {
    Tool newTool = new Tool(toolRequest.getTitle(), toolRequest.getLink(), toolRequest.getDescription(),
        toolRequest.getTags());
    this.toolRepository.save(newTool);

    return new ToolResponse(newTool.getId(), newTool.getTitle(), newTool.getLink(), newTool.getDescription(),
        newTool.getTags());
  }

  @Override
  public List<ToolResponse> findToolsByTag(String tag) {
    List<Tool> toolsContainingTag = this.toolRepository.findByTags(tag);
    logger.error("llega a findByTag");
    logger.error(toolsContainingTag.toString());
    List<ToolResponse> toolResponses = toolsContainingTag.stream().map(tool -> createToolResponse(tool)).toList();
    return toolResponses;
  }

  @Override
  public void removeTool(int id) throws ToolNotFoundException {
    Optional<Tool> toolToDelete = this.toolRepository.findById(id);
    if (toolToDelete.isPresent()) {
      this.toolRepository.delete(toolToDelete.get());
      return;
    }
    throw new ToolNotFoundException("Tool not found: bad id");
  }
}
