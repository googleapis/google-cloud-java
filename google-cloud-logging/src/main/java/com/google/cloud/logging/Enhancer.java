package com.google.cloud.logging;

import com.google.cloud.MonitoredResource;

/**
 * A Log Enhancer.
 * May be used to enhance the {@link MonitoredResource} and/or the {@link LogEntry}
 */
public interface Enhancer {
  void enhanceLogEntry(LogEntry.Builder builder);
}
