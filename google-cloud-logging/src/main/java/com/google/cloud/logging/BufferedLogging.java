package com.google.cloud.logging;

import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class BufferedLogging {

  private static final ThreadLocal<Boolean> inPublishCall = new ThreadLocal<>();
  private List<LogEntry> buffer = new LinkedList<>();
  private volatile Logging logging;
  private LoggingOptions options;
  private WriteOption[] writeOptions;
  private Severity flushSeverity;
  private long flushSize;
  private List<Enhancer> resourceEnhancers;

  public BufferedLogging(String logName, LoggingOptions options, MonitoredResource resource,
                         Level flushLevel, long flushSize) {
    this.options = (options != null) ? options : LoggingOptions.getDefaultInstance();
    writeOptions = new WriteOption[]{WriteOption.logName(logName), WriteOption.resource(resource)};
    this.flushSeverity = LoggingUtil.severityFor(flushLevel);
    this.flushSize = flushSize;
    this.resourceEnhancers = MonitoredResourceHelper.getResourceEnhancers();
  }

  /**
   * Writes the provided list of log entries to Stackdriver Logging. Override this method to change
   * how entries should be written.
   */
  void write(List<LogEntry> entries, WriteOption... options) {
    getLogging().writeAsync(entries, options);
  }

  public void flush() throws Exception {
    List<LogEntry> flushBuffer;
    WriteOption[] flushWriteOptions;

    synchronized (this) {
      if (buffer.isEmpty()) {
        return;
      }
      flushBuffer = buffer;
      flushWriteOptions = writeOptions;
      buffer = new LinkedList<>();
    }

    flush(flushBuffer, flushWriteOptions);
  }

  private void flush(List<LogEntry> flushBuffer, WriteOption[] flushWriteOptions) throws Exception {
    if (flushBuffer == null) {
      return;
    }
    write(flushBuffer, flushWriteOptions);
  }

  private void enhanceLogEntry(LogEntry.Builder entryBuilder, List<Enhancer> enhancers) {
    for (Enhancer enhancer : resourceEnhancers) {
      enhancer.enhanceLogEntry(entryBuilder);
    }
    for (Enhancer enhancer : enhancers) {
      enhancer.enhanceLogEntry(entryBuilder);
    }
  }

  public void publish(LogEntry.Builder entryBuilder, List<Enhancer> enhancers) throws Exception {
    enhanceLogEntry(entryBuilder, enhancers);
    LogEntry entry = entryBuilder.build();

    if (inPublishCall.get() != null) {
      // ignore all logs generated in the course of logging through this handler
      return;
    }
    inPublishCall.set(true);

    try {

      List<LogEntry> flushBuffer = null;
      WriteOption[] flushWriteOptions = null;

      synchronized (this) {
        if (entry != null) {
          buffer.add(entry);
          if (buffer.size() >= flushSize || (entry.getSeverity().compareTo(flushSeverity) >= 0)) {
            flushBuffer = buffer;
            flushWriteOptions = writeOptions;
            buffer = new LinkedList<>();
          }
        }

        flush(flushBuffer, flushWriteOptions);
      }
    } finally {
      inPublishCall.remove();
    }
  }

  /**
   * Returns an instance of the logging service.
   */
  Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = options.getService();
        }
      }
    }
    return logging;
  }

  /**
   * Closes the handler and the associated {@link Logging} object.
   */
  public synchronized void close() throws SecurityException {

    if (logging != null) {
      try {
        logging.close();
      } catch (Exception ex) {
        // ignore
      }
    }
    logging = null;
  }

  public synchronized void setFlushSeverity(Severity severity) {
    flushSeverity = severity;
  }

  public synchronized void setFlushSize(long size) {
    flushSize = size;
  }
}
