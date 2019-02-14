/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.logging;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.cloud.MonitoredResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;

class LoggingConfig {

  private final LogManager manager = LogManager.getLogManager();
  private final String className;
  private static final String FLUSH_LEVEL_TAG = "flushLevel";
  private static final String LOG_FILENAME_TAG = "log";
  private static final String LOG_LEVEL_TAG = "level";
  private static final String FILTER_TAG = "filter";
  private static final String FORMATTER_TAG = "formatter";
  private static final String SYNCHRONICITY_TAG = "synchronicity";
  private static final String RESOURCE_TYPE_TAG = "resourceType";
  private static final String ENHANCERS_TAG = "enhancers";

  public LoggingConfig(String className) {
    this.className = className;
  }

  Level getFlushLevel() {
    return getLevelProperty(FLUSH_LEVEL_TAG, LoggingLevel.ERROR);
  }

  String getLogName() {
    return getProperty(LOG_FILENAME_TAG, "java.log");
  }

  Level getLogLevel() {
    return getLevelProperty(LOG_LEVEL_TAG, LoggingLevel.INFO);
  }

  Filter getFilter() {
    return getFilterProperty(FILTER_TAG, null);
  }

  Synchronicity getSynchronicity() {
    String synchronicityStr = getProperty(SYNCHRONICITY_TAG);
    try {
      return Synchronicity.valueOf(synchronicityStr);
    } catch (Exception ex) {
      // If we cannot create the Synchronicity we fall back to default value
    }
    return Synchronicity.ASYNC;
  }

  Formatter getFormatter() {
    return getFormatterProperty(FORMATTER_TAG, new SimpleFormatter());
  }

  MonitoredResource getMonitoredResource(String projectId) {
    String resourceType = getProperty(RESOURCE_TYPE_TAG, "");
    return MonitoredResourceUtil.getResource(projectId, resourceType);
  }

  List<LoggingEnhancer> getEnhancers() {
    String list = getProperty(ENHANCERS_TAG);
    try {
      List<LoggingEnhancer> enhancers = new ArrayList<>();
      if (list != null) {
        String[] items = list.split(",");
        for (String e_name : items) {
          Class<? extends LoggingEnhancer> clz =
              (Class<? extends LoggingEnhancer>)
                  ClassLoader.getSystemClassLoader().loadClass(e_name);
          enhancers.add(clz.newInstance());
        }
      }
      return enhancers;
    } catch (Exception ex) {
      // If we cannot create the enhancers we fall back to the default
    }
    return Collections.emptyList();
  }

  private String getProperty(String name, String defaultValue) {
    return firstNonNull(getProperty(name), defaultValue);
  }

  private Level getLevelProperty(String name, Level defaultValue) {
    String stringLevel = getProperty(name);
    if (stringLevel == null) {
      return defaultValue;
    }
    try {
      return Level.parse(stringLevel);
    } catch (IllegalArgumentException ex) {
      // If the level does not exist we fall back to default value
    }
    return defaultValue;
  }

  private Filter getFilterProperty(String name, Filter defaultValue) {
    String stringFilter = getProperty(name);
    try {
      if (stringFilter != null) {
        Class clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
        return (Filter) clz.newInstance();
      }
    } catch (Exception ex) {
      // If we cannot create the filter we fall back to default value
    }
    return defaultValue;
  }

  private Formatter getFormatterProperty(String name, Formatter defaultValue) {
    String stringFilter = getProperty(name);
    try {
      if (stringFilter != null) {
        Class clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
        return (Formatter) clz.newInstance();
      }
    } catch (Exception ex) {
      // If we cannot create the filter we fall back to default value
    }
    return defaultValue;
  }

  private String getProperty(String propertyName) {
    return manager.getProperty(className + "." + propertyName);
  }
}
