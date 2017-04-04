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

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutureCallback;
import com.google.api.gax.core.ApiFutures;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;
import com.google.cloud.logging.spi.v2.LoggingSettings;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.*;

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

public class LoggingHelper {

  private static final ThreadLocal<Boolean> inPublishCall = new ThreadLocal<>();
  private volatile Logging logging;
  private LoggingOptions loggingOptions;
  private WriteOption[] writeOptions;
  private Severity flushSeverity;
  private Synchronicity synchronicity;
  private LoggingErrorHandler errorHandler;
  private List<Enhancer> resourceEnhancers;

  private final Object writeLock = new Object();
  private final Set<ApiFuture<Void>> pendingWrites =
          Collections.newSetFromMap(new IdentityHashMap<ApiFuture<Void>, Boolean>());

  private LoggingHelper() {}

  public void flush() {
    // BUG(1795): We should force batcher to issue RPC call for buffered messages,
    // so the code below doesn't wait uselessly.
    ArrayList<ApiFuture<Void>> writesToFlush = new ArrayList<>();
    synchronized(writeLock) {
      writesToFlush.addAll(pendingWrites);
    }
    for (ApiFuture<Void> write : writesToFlush) {
      try {
        Uninterruptibles.getUninterruptibly(write);
      } catch (Exception e) {
        // Ignore exceptions, they are propagated to the error manager.
      }
    }
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
        write(entry);
        if (entry.getSeverity().compareTo(flushSeverity) >= 0) {
          flush();
        }
    } finally{
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

  public synchronized void setSynchronicity(Synchronicity syncType) {
    synchronicity = syncType;
  }

  public Synchronicity getSynchronicity() {
    return synchronicity;
  }

  private void write(LogEntry entry) {
    List<LogEntry> logEntryList = Collections.singletonList(entry);
    switch (this.synchronicity) {
      case SYNC:
        try {
          getLogging().write(logEntryList, writeOptions);
        } catch (Exception ex) {
          errorHandler.handleWriteError(ex);
        }
        break;

      case ASYNC:
      default:
        final ApiFuture<Void> writeFuture = getLogging().writeAsync(logEntryList, writeOptions);
        ApiFutures.addCallback(
                writeFuture,
                new ApiFutureCallback<Void>() {
                  private void removeFromPending() {
                    synchronized(writeLock) {
                      pendingWrites.remove(writeFuture);
                    }
                  }
                  @Override
                  public void onSuccess(Void v) {
                    removeFromPending();
                  }

                  @Override
                  public void onFailure(Throwable t) {
                    try {
                      Exception ex = (t instanceof Exception) ? (Exception) t : new Exception(t);
                      errorHandler.handleFlushError(ex);
                    }
                    finally {
                      removeFromPending();
                    }
                }
                });
        pendingWrites.add(writeFuture);
        break;
    }
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
    private Synchronicity synchronicity;
    private WriteOption[] writeOptions;
    private LoggingErrorHandler errorHandler;

    BuilderImpl(LoggingOptions loggingOptions) {
      this.loggingOptions = loggingOptions;
    }

    BuilderImpl(LoggingHelper loggingHelper) {
      this.loggingOptions = loggingHelper.loggingOptions;
      this.flushSeverity = loggingHelper.flushSeverity;
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
    this.flushSeverity = firstNonNull(builder.flushSeverity, Severity.ERROR);
    this.synchronicity = firstNonNull(builder.synchronicity, Synchronicity.ASYNC);
    this.writeOptions = checkNotNull(builder.writeOptions);
    this.errorHandler = checkNotNull(builder.errorHandler);
    this.resourceEnhancers = MonitoredResourceUtil.getResourceEnhancers();
  }

}
