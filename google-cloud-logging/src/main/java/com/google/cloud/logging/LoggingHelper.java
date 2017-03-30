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

package com.google.cloud.logging;

import com.google.api.gax.core.ApiFutureCallback;
import com.google.api.gax.core.ApiFutures;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

public class LoggingHelper {

  private static final ThreadLocal<Boolean> inPublishCall = new ThreadLocal<>();
  private List<LogEntry> buffer = new LinkedList<>();
  private volatile Logging logging;
  private LoggingOptions loggingOptions;
  private WriteOption[] writeOptions;
  private Severity flushSeverity;
  private Long flushSize;
  private Synchronicity synchronicity;
  private LoggingErrorHandler errorHandler;
  private List<Enhancer> resourceEnhancers;

  private LoggingHelper() {}

  public void flush() {
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

  public void flush(List<LogEntry> flushBuffer, WriteOption[] flushWriteOptions) {
    // BUG(1795): flush is broken, need support from batching implementation.
    if (flushBuffer == null) {
      return;
    }
    write(flushBuffer, flushWriteOptions);
  }

  private void enhanceLogEntry(LogEntry.Builder entryBuilder) {
    for (Enhancer enhancer : resourceEnhancers) {
      enhancer.enhanceLogEntry(entryBuilder);
    }
  }

  public void publish(LogEntry.Builder entryBuilder) {
    enhanceLogEntry(entryBuilder);
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

  public synchronized void setSynchronicity(Synchronicity syncType) {
    synchronicity = syncType;
  }

  public Long getFlushSize() {
    return flushSize;
  }

  public Synchronicity getSynchronicity() {
    return synchronicity;
  }

  private void write(List<LogEntry> entries, WriteOption[] options) {
    switch (this.synchronicity) {
      case SYNC:
        try {
          getLogging().write(entries, options);
        } catch (Exception ex) {
          errorHandler.handleWriteError(ex);
        }
        break;
      case ASYNC:
      default:
        ApiFutures.addCallback(getLogging().writeAsync(entries, options), new ApiFutureCallback<Void>() {
        @Override
        public void onSuccess(Void v) {}

        @Override
        public void onFailure(Throwable t) {
          Exception ex = (t instanceof Exception) ? (Exception) t : new Exception(t);
          errorHandler.handleFlushError(ex);
        }}
        );         
    };
  }

  /**
   * Returns an instance of the logging service.
   */
  private Logging getLogging() {
    if (logging == null) {
      synchronized (this) {
        if (logging == null) {
          logging = loggingOptions.getService();
        }
      }
    }
    return logging;
  }

  /**
   * Returns a builder for this {@code LoggingHelper} object.
   */
  public LoggingHelper.Builder toBuilder() {
    return new LoggingHelper.BuilderImpl(this);
  }

  /**
   * Returns a builder for {@code LoggingHelper} objects given the name of the sink and its destination.
   */
  public static LoggingHelper.Builder newBuilder(LoggingOptions loggingOptions) {
    return new LoggingHelper.BuilderImpl(loggingOptions);
  }

  public abstract static class Builder {
    /**
     * Service configuration of the cloud logging service
     */
    public abstract LoggingHelper.Builder setLoggingOptions(LoggingOptions loggingOptions);

    /**
     * Set the synchronicity of logging : {@link Synchronicity}, defaults to async
     */
    public abstract LoggingHelper.Builder setSynchronicity(Synchronicity synchronicity);

    /**
     * Allow for logs to be buffered in memory till a certain size is reached, default = 1, ie, logs immediately
     */
    public abstract LoggingHelper.Builder setFlushSize(long flushSize);


    /**
     * Minimum severity of log message to not buffer but immediately write out to cloud logging.
     * Default : Error
     * @param flushSeverity : minimum logging severity
     */
    public abstract LoggingHelper.Builder setFlushSeverity(Severity flushSeverity);

    /**
     * Sets the default write options for log entries
     */
    public abstract LoggingHelper.Builder  setWriteOptions(String logName, MonitoredResource resource,
                                                           WriteOption[] labelOptions);

    /**
     * Sets the error log handler
     */
    public abstract LoggingHelper.Builder setErrorHandler(LoggingErrorHandler errorHandler);
    /**
     * Creates a {@code LoggingHelper} object for this builder.
     */
    public abstract LoggingHelper build();
  }

  static final class BuilderImpl extends LoggingHelper.Builder {

    private LoggingOptions loggingOptions;
    private Severity flushSeverity;
    private Long flushSize;
    private Synchronicity synchronicity;
    private WriteOption[] writeOptions;
    private LoggingErrorHandler errorHandler;

    BuilderImpl(LoggingOptions loggingOptions) {
      this.loggingOptions = loggingOptions;
    }

    BuilderImpl(LoggingHelper loggingHelper) {
      this.loggingOptions = loggingHelper.loggingOptions;
      this.flushSeverity = loggingHelper.flushSeverity;
      this.flushSize = loggingHelper.flushSize;
      this.synchronicity = loggingHelper.synchronicity;
      this.writeOptions = loggingHelper.writeOptions;
      this.errorHandler = loggingHelper.errorHandler;
    }

    @Override
    public LoggingHelper.Builder setLoggingOptions(LoggingOptions loggingOptions) {
      this.loggingOptions = loggingOptions;
      return this;
    }

    @Override
    public LoggingHelper.Builder setFlushSeverity(Severity flushSeverity) {
      this.flushSeverity = flushSeverity;
      return this;
    }

    @Override
    public LoggingHelper.Builder setFlushSize(long flushSize) {
      this.flushSize = flushSize;
      return this;
    }

    @Override
    public LoggingHelper.Builder setSynchronicity(Synchronicity synchronicity) {
      this.synchronicity = synchronicity;
      return this;
    }

    @Override
    public LoggingHelper.Builder setWriteOptions(String logName, MonitoredResource resource,
                                                 WriteOption[] labelOptions) {
      List<WriteOption> writeOptionsList = new ArrayList<>();
      writeOptionsList.add(WriteOption.logName(logName));
      writeOptionsList.add(WriteOption.resource(resource));
      if (labelOptions != null) {
        Collections.addAll(writeOptionsList, labelOptions);
      }
      this.writeOptions = new WriteOption[writeOptionsList.size()];
      writeOptionsList.toArray(this.writeOptions);
      return this;
    }

    @Override
    public LoggingHelper.Builder setErrorHandler(LoggingErrorHandler errorHandler) {
      this.errorHandler = errorHandler;
      return this;
    }

    @Override
    public LoggingHelper build() {
      return new LoggingHelper(this);
    }
  }

  LoggingHelper(LoggingHelper.BuilderImpl builder) {
    this.loggingOptions = checkNotNull(firstNonNull(builder.loggingOptions, LoggingOptions.getDefaultInstance()));
    this.flushSize = firstNonNull(builder.flushSize, 1L);
    this.flushSeverity = firstNonNull(builder.flushSeverity, Severity.ERROR);
    this.synchronicity = firstNonNull(builder.synchronicity, Synchronicity.ASYNC);
    this.writeOptions = checkNotNull(builder.writeOptions);
    this.errorHandler = checkNotNull(builder.errorHandler);
    this.resourceEnhancers = MonitoredResourceHelper.getResourceEnhancers();
  }

}
