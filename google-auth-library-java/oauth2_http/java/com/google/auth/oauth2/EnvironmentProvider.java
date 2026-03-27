package com.google.auth.oauth2;

/** Interface for an environment provider. */
interface EnvironmentProvider {
  String getEnv(String name);
}
