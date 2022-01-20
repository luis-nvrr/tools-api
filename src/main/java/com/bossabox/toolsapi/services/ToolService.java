package com.bossabox.toolsapi.services;

import java.util.List;

import com.bossabox.toolsapi.dtos.ToolRequest;
import com.bossabox.toolsapi.dtos.ToolResponse;
import com.bossabox.toolsapi.exceptions.ToolNotFoundException;

public interface ToolService {
  List<ToolResponse> findAllTools();

  ToolResponse createTool(ToolRequest toolRequest);

  List<ToolResponse> findToolsByTag(String tag);

  void removeTool(int id) throws ToolNotFoundException;
}
