package me.nidalone.uniplatform;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EXAM")
public class Exam {
  @Id //
  private String name;

  private int cfu;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCfu() {
    return cfu;
  }

  public void setCfu(int cfu) {
    this.cfu = cfu;
  }
}
