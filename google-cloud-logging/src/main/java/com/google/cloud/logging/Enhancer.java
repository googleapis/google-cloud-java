package com.google.cloud.logging;

import com.google.cloud.MonitoredResource;

/**
 * A Log Enhancer.
 * Used to enhance the {@link LogEntry}
 */
public interface Enhancer {
  void enhanceLogEntry(LogEntry.Builder builder);
}
