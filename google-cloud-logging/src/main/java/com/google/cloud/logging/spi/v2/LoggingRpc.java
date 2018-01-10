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

package com.google.cloud.logging.spi.v2;

import com.google.api.core.ApiFuture;
import com.google.cloud.ServiceRpc;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;

public interface LoggingRpc extends AutoCloseable, ServiceRpc {

  /**
   * Sends a request to create a sink. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns the created sink.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogSink> create(CreateSinkRequest request);

  /**
   * Sends a request to update a sink. If the sink does not exist, it is created. This method
   * returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns the updated
   * or created sink.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogSink> update(UpdateSinkRequest request);

  /**
   * Sends a request to get a sink. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns the requested sink or {@code null} if not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogSink> get(GetSinkRequest request);

  /**
   * Sends a request to list the sinks in a project. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns a response object containing the listing
   * result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListSinksResponse> list(ListSinksRequest request);

  /**
   * Sends a request to delete a sink. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns {@link Empty#getDefaultInstance()} or {@code null} if the
   * sink was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> delete(DeleteSinkRequest request);

  /**
   * Sends a request to deletes a log. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns {@link Empty#getDefaultInstance()} or {@code null} if the
   * log was not found. The deleted log will reappear if it receives new log entries.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> delete(DeleteLogRequest request);

  /**
   * Sends a request to write log entries to Stackdriver Logging. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns a response object for
   * the write operation.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<WriteLogEntriesResponse> write(WriteLogEntriesRequest request);

  /**
   * Sends a request to list log entries. Use this method to retrieve log entries from Cloud
   * Logging. This method returns a {@code ApiFuture} object to consume the result.
   * {@link ApiFuture#get()} returns a response object containing the listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListLogEntriesResponse> list(ListLogEntriesRequest request);

  /**
   * Sends a request to list monitored resource descriptors. This method returns a {@code ApiFuture}
   * object to consume the result. {@link ApiFuture#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListMonitoredResourceDescriptorsResponse> list(
      ListMonitoredResourceDescriptorsRequest request);

  /**
   * Sends a request to create a log metric. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns the created metric.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogMetric> create(CreateLogMetricRequest request);

  /**
   * Sends a request to update a log metric. If the log metric does not exist, it is created. This
   * method returns a {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns the
   * updated or created log metric.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogMetric> update(UpdateLogMetricRequest request);

  /**
   * Sends a request to get a log metric. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns the requested log metric or {@code null} if not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<LogMetric> get(GetLogMetricRequest request);

  /**
   * Sends a request to list the log metrics in a project. This method returns a {@code ApiFuture}
   * object to consume the result. {@link ApiFuture#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListLogMetricsResponse> list(ListLogMetricsRequest request);

  /**
   * Sends a request to delete a log metric. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns {@link Empty#getDefaultInstance()} or {@code null} if
   * the log was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> delete(DeleteLogMetricRequest request);
}
