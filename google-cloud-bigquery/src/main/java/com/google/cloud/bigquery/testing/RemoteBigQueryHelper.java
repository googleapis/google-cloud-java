/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud.bigquery.testing;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.HttpTransportOptions;
import com.google.api.gax.core.RetrySettings;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Duration;

/**
 * Utility to create a remote BigQuery configuration for testing. BigQuery options can be obtained
 * via the {@link #getOptions()} method. Returned options have custom
 * {@link BigQueryOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is
 * {@code 10},
 * {@link RetrySettings#getMaxRetryDelay()} is {@code 30000},
 * {@link RetrySettings#getTotalTimeout()} is {@code 120000} and
 * {@link RetrySettings#getInitialRetryDelay()} is {@code 250}.
 * {@link HttpTransportOptions#getConnectTimeout()} and
 * {@link HttpTransportOptions#getReadTimeout()} are both
 * set to {@code 60000}.
 */
public class RemoteBigQueryHelper {

  private static final Logger log = Logger.getLogger(RemoteBigQueryHelper.class.getName());
  private static final String DATASET_NAME_PREFIX = "gcloud_test_dataset_temp_";
  private final BigQueryOptions options;

  private RemoteBigQueryHelper(BigQueryOptions options) {
    this.options = options;
  }


  /**
   * Returns a {@link BigQueryOptions} object to be used for testing.
   */
  public BigQueryOptions getOptions() {
    return options;
  }

  /**
   * Deletes a dataset, even if non-empty.
   *
   * @param bigquery the BigQuery service to be used to issue the delete request
   * @param dataset the dataset to be deleted
   * @return {@code true} if deletion succeeded, {@code false} if the dataset was not found
   * @throws BigQueryException upon failure
   */
  public static boolean forceDelete(BigQuery bigquery, String dataset) {
    return bigquery.delete(dataset, BigQuery.DatasetDeleteOption.deleteContents());
  }

  /**
   * Returns a dataset name generated using a random UUID.
   */
  public static String generateDatasetName() {
    return DATASET_NAME_PREFIX + UUID.randomUUID().toString().replace('-', '_');
  }

  /**
   * Creates a {@code RemoteBigQueryHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteBigQueryHelper} object for the provided options
   * @throws BigQueryHelperException if {@code keyStream} is not a valid JSON key stream
   */
  public static RemoteBigQueryHelper create(String projectId, InputStream keyStream)
      throws BigQueryHelperException {
    try {
      HttpTransportOptions transportOptions = BigQueryOptions.getDefaultHttpTransportOptions();
      transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
          .build();
      BigQueryOptions bigqueryOptions = BigQueryOptions.newBuilder()
          .setCredentials(ServiceAccountCredentials.fromStream(keyStream))
          .setProjectId(projectId)
          .setRetrySettings(retrySettings())
          .setTransportOptions(transportOptions)
          .build();
      return new RemoteBigQueryHelper(bigqueryOptions);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw BigQueryHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteBigQueryHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteBigQueryHelper create() {
    HttpTransportOptions transportOptions = BigQueryOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    BigQueryOptions bigqueryOptions = BigQueryOptions.newBuilder()
        .setRetrySettings(retrySettings())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteBigQueryHelper(bigqueryOptions);
  }

  private static RetrySettings retrySettings() {
    return RetrySettings.newBuilder().setMaxAttempts(10)
        .setMaxRetryDelay(Duration.millis(30000L))
        .setTotalTimeout(Duration.millis(120000L))
        .setInitialRetryDelay(Duration.millis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.millis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.millis(120000L))
        .build();
  }

  public static class BigQueryHelperException extends RuntimeException {

    private static final long serialVersionUID = 3984993496060055562L;

    public BigQueryHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static BigQueryHelperException translate(Exception ex) {
      return new BigQueryHelperException(ex.getMessage(), ex);
    }
  }
}
