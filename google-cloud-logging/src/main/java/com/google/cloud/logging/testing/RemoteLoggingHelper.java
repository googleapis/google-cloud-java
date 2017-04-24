/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.logging.testing;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.logging.LoggingOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Duration;

/**
 * Utility to create a remote logging configuration for testing. Logging options can be obtained via
 * the {@link #getOptions()} method. Returned options have custom
 * {@link LoggingOptions#getRetrySettings()}: {@link RetrySettings#getMaxRetryDelay()} is
 * {@code 30000}, {@link RetrySettings#getTotalTimeout()} is {@code 120000} and
 * {@link RetrySettings#getInitialRetryDelay()} is {@code 250}.
 */
public class RemoteLoggingHelper {

  private static final Logger log = Logger.getLogger(RemoteLoggingHelper.class.getName());
  private final LoggingOptions options;

  private RemoteLoggingHelper(LoggingOptions options) {
    this.options = options;
  }


  /**
   * Returns a {@link LoggingOptions} object to be used for testing.
   */
  public LoggingOptions getOptions() {
    return options;
  }

  /**
   * Creates a {@code RemoteLoggingHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteLoggingHelper} object for the provided options
   * @throws com.google.cloud.logging.testing.RemoteLoggingHelper.LoggingHelperException if
   *     {@code keyStream} is not a valid JSON key stream
   */
  public static RemoteLoggingHelper create(String projectId, InputStream keyStream)
      throws LoggingHelperException {
    try {
      GrpcTransportOptions transportOptions = LoggingOptions.getDefaultGrpcTransportOptions();
      LoggingOptions storageOptions = LoggingOptions.newBuilder()
          .setCredentials(ServiceAccountCredentials.fromStream(keyStream))
          .setProjectId(projectId)
          .setRetrySettings(retrySettings())
          .setTransportOptions(transportOptions)
          .build();
      return new RemoteLoggingHelper(storageOptions);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw LoggingHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteLoggingHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteLoggingHelper create() throws LoggingHelperException {
    GrpcTransportOptions transportOptions = LoggingOptions.getDefaultGrpcTransportOptions();
    LoggingOptions loggingOptions = LoggingOptions.newBuilder()
        .setRetrySettings(retrySettings())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteLoggingHelper(loggingOptions);
  }

  /**
   * Formats a resource name for testing purpose. This method appends a random UUID to the provided
   * name.
   */
  public static String formatForTest(String name) {
    return name + "-" + UUID.randomUUID().toString();
  }

  private static RetrySettings retrySettings() {
    return RetrySettings.newBuilder()
        .setMaxRetryDelay(Duration.millis(30000L))
        .setTotalTimeout(Duration.millis(120000L))
        .setInitialRetryDelay(Duration.millis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.millis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.millis(120000L))
        .build();
  }

  public static class LoggingHelperException extends RuntimeException {

    private static final long serialVersionUID = 2617749404172557196L;

    public LoggingHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static LoggingHelperException translate(Exception ex) {
      return new LoggingHelperException(ex.getMessage(), ex);
    }
  }
}
