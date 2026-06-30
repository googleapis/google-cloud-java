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
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
  private static final String USE_INHERITED_CONTEXT = "useInheritedContext";
  private static final String AUTO_POPULATE_METADATA = "autoPopulateMetadata";
  private static final String REDIRECT_TO_STDOUT = "redirectToStdout";
  private static final String LOG_TARGET = "logTarget";

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
    } catch (RuntimeException ex) {
      // If we cannot create the Synchronicity we fall back to default value
    }
    return Synchronicity.ASYNC;
  }

  Formatter getFormatter() {
    return getFormatterProperty(FORMATTER_TAG, new SimpleFormatter());
  }

  Boolean getAutoPopulateMetadata() {
    return getBooleanProperty(AUTO_POPULATE_METADATA, null);
  }

  Boolean getRedirectToStdout() {
    return getBooleanProperty(REDIRECT_TO_STDOUT, null);
  }

  Optional<LoggingHandler.LogTarget> getLogTarget() {
    return Optional.ofNullable(getProperty(LOG_TARGET)).map(LoggingHandler.LogTarget::valueOf);
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
        Iterable<String> items = Splitter.on(',').split(list);
        for (String eName : items) {
          Class<? extends LoggingEnhancer> clazz =
              ClassLoader.getSystemClassLoader().loadClass(eName).asSubclass(LoggingEnhancer.class);
          enhancers.add(clazz.getDeclaredConstructor().newInstance());
        }
      }
      return ImmutableList.copyOf(enhancers);
    } catch (Exception ex) {
      // If we cannot create the enhancers we fall back to the default
    }
    return ImmutableList.of();
  }

  /**
   * Returns boolean value of the property {@code
   * com.google.cloud.logging.context.ContextHandler.useInheritedContext}. If no value is defined or
   * the property does not represent a valid boolean value returns {@code false}.
   *
   * @return {@code true} or {@code false}
   */
  boolean getUseInheritedContext() {
    String flag = getProperty(USE_INHERITED_CONTEXT, "FALSE");
    return Boolean.parseBoolean(flag);
  }

  private String getProperty(String name, String defaultValue) {
    return firstNonNull(getProperty(name), defaultValue);
  }

  private String getProperty(String propertyName) {
    return manager.getProperty(className + "." + propertyName);
  }

  private Boolean getBooleanProperty(String name, Boolean defaultValue) {
    String flag = getProperty(name);
    if (flag != null) {
      return Boolean.parseBoolean(flag);
    }
    return defaultValue;
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
        Class<?> clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
        return (Filter) clz.getDeclaredConstructor().newInstance();
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
        Class<?> clz = ClassLoader.getSystemClassLoader().loadClass(stringFilter);
        return (Formatter) clz.getDeclaredConstructor().newInstance();
      }
    } catch (Exception ex) {
      // If we cannot create the filter we fall back to default value
    }
    return defaultValue;
  }
}
