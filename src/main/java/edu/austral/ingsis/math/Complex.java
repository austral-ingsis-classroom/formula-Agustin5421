package edu.austral.ingsis.math;

import java.util.Map;

public interface Complex extends Function {
    Function solve (Map<String, Double> variablesMap);

}
