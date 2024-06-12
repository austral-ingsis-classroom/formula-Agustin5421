package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Variable implements Function {
  private final String name;
  private Double value;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Function solve(Map<String, Double> variablesMap) {
    Double value = variablesMap.get(name);
    setValue(value);
    return this;
  }

  @Override
  public String getString() {
    return name;
  }

  private void setValue(Double value) {
    this.value = value;
  }

  @Override
  public Double value() {
    return value;
  }

  @Override
  public Set<String> getVariables() {
    return Collections.singleton(name);
  }
}
