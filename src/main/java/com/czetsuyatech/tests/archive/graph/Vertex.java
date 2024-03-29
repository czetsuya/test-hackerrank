package com.czetsuyatech.tests.archive.graph;

import java.util.Objects;

public class Vertex {

  public String label;

  public Vertex(String label) {
    this.label = label;
  }

  @Override
  public String toString() {
    return label;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vertex vertex = (Vertex) o;
    return label.equals(vertex.label);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label);
  }
}
