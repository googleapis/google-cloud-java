/*
 * Copyright 2015 Google LLC
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/** An immutable object containing settings for a {@link DatastoreEmulator}. */
public class DatastoreEmulatorOptions {
  private final Map<String, String> envVars;
  private final String cmd;
  private final List<String> cmdLineOptions;
  private final String projectId;

  DatastoreEmulatorOptions(
      Map<String, String> envVars, String cmd, List<String> cmdLineOptions, String projectId) {
    this.envVars = envVars;
    this.cmd = cmd;
    this.cmdLineOptions = cmdLineOptions;
    this.projectId = projectId;
  }

  /** Builder for {@link DatastoreEmulatorOptions}. */
  public static class Builder {
    private final Map<String, String> envVars = new HashMap<>();
    private final List<String> cmdLineOptions = new ArrayList<>();
    private String cmd = "./cloud_datastore_emulator";
    private String projectId;

    public DatastoreEmulatorOptions build() {
      return new DatastoreEmulatorOptions(envVars, cmd, cmdLineOptions, projectId);
    }

    /** Adds an environment variable to pass to the emulator. */
    public Builder addEnvVar(String var, String value) {
      envVars.put(var, value);
      return this;
    }

    public Builder addCmdLineOption(String option) {
      cmdLineOptions.add(option);
      return this;
    }

    public Builder addCmdLineOptions(Collection<String> options) {
      cmdLineOptions.addAll(options);
      return this;
    }

    public Builder setCommand(String cmd) {
      this.cmd = cmd;
      return this;
    }

    public Builder setProjectId(String projectId) {
      this.projectId = projectId;
      return this;
    }
  }

  public Map<String, String> getEnvVars() {
    return envVars;
  }

  public List<String> getCmdLineOptions() {
    return cmdLineOptions;
  }

  public String getCmd() {
    return cmd;
  }

  @Nullable
  public String getProjectId() {
    return projectId;
  }
}
