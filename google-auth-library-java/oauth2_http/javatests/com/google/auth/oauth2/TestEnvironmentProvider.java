package com.google.auth.oauth2;

import java.util.HashMap;
import java.util.Map;

final class TestEnvironmentProvider implements EnvironmentProvider {

  private final Map<String, String> environmentVariables = new HashMap<>();

  @Override
  public String getEnv(String name) {
    return environmentVariables.get(name);
  }

  public TestEnvironmentProvider setEnv(String name, String value) {
    environmentVariables.put(name, value);
    return this;
  }
}
