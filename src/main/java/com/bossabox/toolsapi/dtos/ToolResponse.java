package com.bossabox.toolsapi.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ToolResponse {
  private int id;
  private String title;
  private String link;
  private String description;
  private List<String> tags;
}
