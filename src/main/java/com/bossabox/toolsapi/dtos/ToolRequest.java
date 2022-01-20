package com.bossabox.toolsapi.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToolRequest {
  private String title;
  private String link;
  private String description;
  private List<String> tags;
}
