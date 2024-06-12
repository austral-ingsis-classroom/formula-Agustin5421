package edu.austral.ingsis.math;

import java.util.Map;
import java.util.Set;

public interface Function {
  Function solve(Map<String, Double> variablesMap);

  String getString();

  Double value();

  Set<String> getVariables();
}
