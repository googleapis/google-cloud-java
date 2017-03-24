package com.google.cloud.logging;

import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.cloud.MonitoredResource;
import com.google.cloud.ServiceOptions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.SimpleFormatter;

public class LoggingConfigHelper {

  private final LogManager manager = LogManager.getLogManager();

  Level getFlushLevel(String className) {
    return getLevelProperty(className + ".flushLevel", LoggingLevel.ERROR);
  }

  Long getFlushSize(String className) {
    return getLongProperty(className + ".flushSize", 1L);
  }

  String getLogName(String log, String className) {
    return firstNonNull(log, getProperty(className + ".log", "java.log"));
  }

  Level getLogLevel(String className) {
    return getLevelProperty(className + ".level", Level.INFO);
  }

  Filter getFilter(String className) {
    return getFilterProperty(className + ".filter", null);
  }

  Formatter getFormatter(String className) {
    return getFormatterProperty(className + ".formatter", new SimpleFormatter());
  }

  MonitoredResource getMonitoredResource(ServiceOptions options, String className) {
      String resourceType = getProperty(className + ".resourceType", "");
      return MonitoredResourceHelper.getResource(options, resourceType);
  }

  List<Enhancer> getEnhancers(String className) {
    String propertyName = className +".enhancers";
    String list = manager.getProperty(propertyName);
    try {
      List<Enhancer> enhancers = new ArrayList<>();
      if (list != null) {
        String[] items = list.split(",");
        for (String e_name : items) {
          Class<? extends Enhancer> clz = (Class<? extends Enhancer>) ClassLoader
              .getSystemClassLoader().loadClass(e_name);
          enhancers.add((Enhancer) clz.newInstance());
        }
      }
      return enhancers;
    } catch (Exception ex) {
      // If we cannot create the enhancers we fall back to the default
    }
    return Collections.emptyList();
  }

  private String getProperty(String name, String defaultValue) {
    return firstNonNull(manager.getProperty(name), defaultValue);
  }

  private Level getLevelProperty(String name, Level defaultValue) {
    String stringLevel = manager.getProperty(name);
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

  private long getLongProperty(String name, long defaultValue) {
    try {
      return Long.parseLong(manager.getProperty(name));
    } catch (NumberFormatException ex) {
      // If the level does not exist we fall back to default value
    }
    return defaultValue;
  }

  private Filter getFilterProperty(String name, Filter defaultValue) {
    String stringFilter = manager.getProperty(name);
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
    String stringFilter = manager.getProperty(name);
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
}


