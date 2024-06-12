package edu.austral.ingsis.math;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public record Constant(Double value) implements Function {

  @Override
  public Function solve(Map<String, Double> variablesMap) {
    return this;
  }

  @Override
  public Set<String> getVariables() {
    return Collections.emptySet();
  }

  @Override
  public String getString() {
    if (value == value.intValue()) {
      return String.valueOf(value.intValue());
    }
    return value.toString();
  }
}
