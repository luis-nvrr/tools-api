package com.bossabox.toolsapi.entitites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tools")
@NoArgsConstructor
@Data
public class Tool {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "link")
  private String link;

  @Column(name = "description")
  private String description;

  @Column(name = "tags")
  @ElementCollection
  private List<String> tags;

  public Tool(String title, String link, String description, List<String> tags) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.tags = tags;
  }
}
