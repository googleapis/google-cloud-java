/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.compute.testing;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.compute.ComputeOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * Utility to create a remote Compute configuration for testing. Compute options can be obtained
 * via the {@link #getOptions()} method. Returned options have custom
 * {@link ComputeOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is {@code 10},
 * {@link RetrySettings#getMaxAttempts()} ()} is {@code 6},
 * {@link RetrySettings#getMaxRetryDelay()} is {@code 30000},
 * {@link RetrySettings#getTotalTimeout()} is {@code 120000} and
 * {@link RetrySettings#getInitialRetryDelay()} is {@code 250}.
 * {@link HttpTransportOptions#getConnectTimeout()} and
 * {@link HttpTransportOptions#getReadTimeout()} are both
 * set to {@code 60000}.
 */
public class RemoteComputeHelper {

  private static final Logger log = Logger.getLogger(RemoteComputeHelper.class.getName());
  private final ComputeOptions options;

  private RemoteComputeHelper(ComputeOptions options) {
    this.options = options;
  }

  /**
   * Returns a {@link ComputeOptions} object to be used for testing.
   */
  public ComputeOptions getOptions() {
    return options;
  }

  /**
   * Returns a base name for testing resources generated using a random UUID. This base name can be
   * prepended to resource names to prevent name clashes. This method always returns a 30 characters
   * long prefix. Since Compute Engine resource names can be at most 63 characters long your suffix
   * should be no longer than 33 characters.
   */
  public static String baseResourceName() {
    return "test-" + UUID.randomUUID().toString().replace("-", "").substring(0, 24) + "-";
  }

  /**
   * Creates a {@code RemoteComputeHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteComputeHelper} object for the provided options
   * @throws ComputeHelperException if {@code keyStream} is not a valid JSON key stream
   */
  public static RemoteComputeHelper create(String projectId, InputStream keyStream) {
    try {
      HttpTransportOptions transportOptions = ComputeOptions.getDefaultHttpTransportOptions();
      transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
          .build();
      ComputeOptions computeOptions = ComputeOptions.newBuilder()
          .setCredentials(ServiceAccountCredentials.fromStream(keyStream))
          .setProjectId(projectId)
          .setRetrySettings(retrySettings())
          .setTransportOptions(transportOptions)
          .build();
      return new RemoteComputeHelper(computeOptions);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw ComputeHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteComputeHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteComputeHelper create() {
    HttpTransportOptions transportOptions = ComputeOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    ComputeOptions computeOptions = ComputeOptions.newBuilder()
        .setRetrySettings(retrySettings())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteComputeHelper(computeOptions);
  }

  private static RetrySettings retrySettings() {
    return RetrySettings.newBuilder().setMaxAttempts(10)
        .setMaxRetryDelay(Duration.ofMillis(30000L))
        .setTotalTimeout(Duration.ofMillis(120000L))
        .setInitialRetryDelay(Duration.ofMillis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.ofMillis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.ofMillis(120000L))
        .build();
  }

  public static class ComputeHelperException extends RuntimeException {

    private static final long serialVersionUID = -5747977015007639912L;

    public ComputeHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static ComputeHelperException translate(Exception ex) {
      return new ComputeHelperException(ex.getMessage(), ex);
    }
  }
}
