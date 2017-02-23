/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.slf4j.impl.config;

import java.util.Map;

public class LoggerConfig {

  private String name;
  private String resource;
  private Map<String, String> labels;
  private String log_name;
  private String level;
  private Boolean enable;

  public LoggerConfig() {}

  public LoggerConfig(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getResource() {
    return (resource != null) ? resource : ConfigDefaults.resource;
  }

  public void setResource(String resource) {
    this.resource = resource;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public String getLog_name() {
    return (log_name != null) ? log_name : name;
  }

  public void setLog_name(String log_name) {
    this.log_name = log_name;
  }

  public String getLevel() {
    return (level != null) ? level : ConfigDefaults.severity.name();
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public Boolean isEnable() {
    return (enable != null) ? enable : ConfigDefaults.enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }
}
