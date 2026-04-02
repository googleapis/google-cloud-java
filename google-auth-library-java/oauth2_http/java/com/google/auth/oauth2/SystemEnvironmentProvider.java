package com.google.auth.oauth2;

import java.io.Serializable;

/** Represents the default system environment provider. */
class SystemEnvironmentProvider implements EnvironmentProvider, Serializable {
  static final SystemEnvironmentProvider INSTANCE = new SystemEnvironmentProvider();
  private static final long serialVersionUID = -4698164985883575244L;

  private SystemEnvironmentProvider() {}

  @Override
  public String getEnv(String name) {
    return System.getenv(name);
  }

  public static SystemEnvironmentProvider getInstance() {
    return INSTANCE;
  }
}
