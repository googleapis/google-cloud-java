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

import com.google.cloud.logging.Severity;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class ConfigLoader {

  private static final String DEFAULT_LOGGER_NAME = "default";
  private Map<String, LoggerConfig> loggerConfigs;
  private String destination;

  public ConfigLoader(String fileName) {
    this.loggerConfigs = new HashMap<>();
    LoggerConfig defaultConfig = new LoggerConfig(DEFAULT_LOGGER_NAME);
    loggerConfigs.put(DEFAULT_LOGGER_NAME, defaultConfig);
    loadConfiguration(fileName);
  }

  public static String getValue(String name, String defaultValue) {
    String value = System.getProperty(name);
    if (value == null || value.length() == 0) {
      value = System.getenv(name);
    }
    if (value == null || value.length() == 0) {
      value = defaultValue;
    }
    return value;
  }

  @SuppressWarnings("unchecked")
  private void loadConfiguration(String fileName) {
    try {
      InputStream inputStream = getInputStream(fileName);
      Constructor constructor = new Constructor(CloudLoggingConfig.class);
      TypeDescription listDescription = new TypeDescription(CloudLoggingConfig.class);
      listDescription.putListPropertyType("loggers", LoggerConfig.class);
      constructor.addTypeDescription(listDescription);
      Yaml yaml = new Yaml(constructor);
      CloudLoggingConfig cloudLoggingConfig = yaml.loadAs(inputStream, CloudLoggingConfig.class);
      for (LoggerConfig config : cloudLoggingConfig.getLoggers()) {
        loggerConfigs.put(config.getName(), config);
      }
      destination = cloudLoggingConfig.getDestination();
    } catch (Exception e) {
      System.err.println(
          "Error loading configuration from " + fileName + ":" + e.getLocalizedMessage());
    }
  }

  private InputStream getInputStream(String fileName) {
    InputStream inputStream = null;
    try {
      inputStream = new FileInputStream(fileName);
    } catch (IOException e) {
      System.err.println(
          "Error loading configuration from " + fileName + ":" + e.getLocalizedMessage());
    }
    return inputStream;
  }

  private LoggerConfig getLoggerConfig(String loggerName) {
    LoggerConfig config = loggerConfigs.get(loggerName);
    int packageDelimiter;
    while (config == null) {
      packageDelimiter = loggerName.lastIndexOf('.');
      if (packageDelimiter > 0 && packageDelimiter < loggerName.length() - 1) {
        loggerName = loggerName.substring(0, packageDelimiter);
        config = loggerConfigs.get(loggerName);
      } else {
        break;
      }
    }
    return (config != null) ? config : loggerConfigs.get(DEFAULT_LOGGER_NAME);
  }

  public Map<String, String> getLabels(String loggerName) {
    LoggerConfig config = getLoggerConfig(loggerName);
    return (config != null) ? config.getLabels() : null;
  }

  public String getFileName(String loggerName) {
    LoggerConfig config = getLoggerConfig(loggerName);
    return (config != null && config.getLog_name() != null)
        ? config.getLog_name()
        : getResource(loggerName);
  }

  public Severity getSeverity(String loggerName) {
    LoggerConfig config = getLoggerConfig(loggerName);
    return (config != null && config.getLevel() != null)
        ? Severity.valueOf(config.getLevel().toUpperCase())
        : ConfigDefaults.severity;
  }

  public String getResource(String loggerName) {
    LoggerConfig config = getLoggerConfig(loggerName);
    return (config != null && config.getResource() != null) ? config.getResource() : loggerName;
  }

  public boolean isEnabled(String loggerName) {
    LoggerConfig config = getLoggerConfig(loggerName);
    return (config != null) ? config.isEnable() : ConfigDefaults.enable;
  }

  public String getDestination() {
    return (destination != null) ? destination : ConfigDefaults.destination;
  }
}
