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

import com.google.api.gax.core.ApiFuture;
import com.google.api.gax.core.ApiFutureCallback;
import com.google.api.gax.core.ApiFutures;
import com.google.cloud.MonitoredResource;
import com.google.cloud.logging.Logging.WriteOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/** Configurable logging service with level-based flush and error handling */
public class LoggingService {

  private static final ThreadLocal<Boolean> inPublishCall = new ThreadLocal<>();
  private volatile Logging logging;
  private final LoggingOptions loggingOptions;
  private final ErrorHandler errorHandler;
  private WriteOption[] writeOptions;
  private Severity flushSeverity;
  private Synchronicity synchronicity;

  private final Object writeLock = new Object();
  private final Set<ApiFuture<Void>> pendingWrites =
      Collections.newSetFromMap(new IdentityHashMap<ApiFuture<Void>, Boolean>());

  public LoggingService(LoggingOptions options, ErrorHandler errorHandler,
      String logName, MonitoredResource resource, WriteOption... writeOptions) {
    this.loggingOptions = options;
    this.errorHandler = errorHandler;
    setWriteOptions(logName, resource, writeOptions);
  }

  /**
   * Sets the default write options for log entries.
   */
  private void setWriteOptions(
      String logName, MonitoredResource resource, WriteOption... writeOptions) {
    List<WriteOption> writeOptionsList = new ArrayList<>();
    writeOptionsList.add(WriteOption.logName(logName));
    writeOptionsList.add(WriteOption.resource(resource));
    if (writeOptions != null) {
      Collections.addAll(writeOptionsList, writeOptions);
    }
    this.writeOptions = new WriteOption[writeOptionsList.size()];
    writeOptionsList.toArray(this.writeOptions);
  }

  /**
   * Set the synchronicity of logging : {@link Synchronicity}, defaults to async
   */
  public synchronized void setSynchronicity(Synchronicity synchronicity) {
    this.synchronicity = synchronicity;
  }

  /**
   * Minimum severity of log message to not buffer but immediately write out to cloud logging.
   * Default : Error
   *
   * @param flushSeverity : minimum logging severity
   */
  public synchronized void setFlushSeverity(Severity flushSeverity) {
    this.flushSeverity = flushSeverity;
  }

  public void flush() {
    // BUG(1795): We should force batcher to issue RPC call for buffered messages,
    // so the code below doesn't wait uselessly.
    ArrayList<ApiFuture<Void>> writesToFlush = new ArrayList<>();
    synchronized (writeLock) {
      writesToFlush.addAll(pendingWrites);
    }

    try {
      ApiFutures.allAsList(writesToFlush).get();
    } catch (Exception e) {
      // Ignore exceptions, they are propagated to the error manager.
    }
  }

  public void publish(LogEntry entry) {
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
                synchronized (writeLock) {
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
                  Exception ex = t instanceof Exception ? (Exception) t : new Exception(t);
                  errorHandler.handleFlushError(ex);
                } finally {
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

  interface ErrorHandler {

    void handleWriteError(Exception e);

    void handleFormatError(Exception e);

    void handleFlushError(Exception e);
  }
}
