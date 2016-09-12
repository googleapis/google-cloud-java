/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import java.util.HashMap;
import java.util.Map;

/** An immutable object containing settings for a {@link DatastoreEmulator}. */
public class DatastoreEmulatorOptions {
  private final Map<String, String> envVars;

  DatastoreEmulatorOptions(Map<String, String> envVars) {
    this.envVars = envVars;
  }

  /** Builder for {@link DatastoreEmulatorOptions}. */
  public static class Builder {
    private final Map<String, String> envVars = new HashMap<String, String>();

    public DatastoreEmulatorOptions build() {
      return new DatastoreEmulatorOptions(envVars);
    }

    /** Adds an environment variable to pass to the emulator. */
    public Builder addEnvVar(String var, String value) {
      envVars.put(var, value);
      return this;
    }
  }

  public Map<String, String> getEnvVars() {
    return envVars;
  }
}
