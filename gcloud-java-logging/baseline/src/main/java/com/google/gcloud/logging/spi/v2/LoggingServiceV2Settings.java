/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/logging/v2/logging.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */

package com.google.gcloud.logging.spi.v2;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.BackoffParams;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetryParams;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.ApiCallable.ApiCallableBuilder;
import com.google.api.gax.grpc.ApiCallable.PageStreamingApiCallableBuilder;
import com.google.api.gax.grpc.PageDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LoggingServiceV2Grpc;
import com.google.logging.v2.ReadLogEntriesRequest;
import com.google.logging.v2.ReadLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import io.grpc.Status;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
@javax.annotation.Generated("by GAPIC")
public class LoggingServiceV2Settings extends ServiceApiSettings {

  // =========
  // Constants
  // =========

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  public static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/logging.write")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

  static {
    ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
    definitions.put(
        "idempotent",
        Sets.immutableEnumSet(
            Lists.<Status.Code>newArrayList(
                Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
    definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
    RETRYABLE_CODE_DEFINITIONS = definitions.build();
  }

  private static final ImmutableMap<String, RetryParams> RETRY_PARAM_DEFINITIONS;

  static {
    ImmutableMap.Builder<String, RetryParams> definitions = ImmutableMap.builder();
    RetryParams params = null;
    params =
        RetryParams.newBuilder()
            .setRetryBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(100L)
                    .setDelayMultiplier(1.2)
                    .setMaxDelayMillis(1000L)
                    .build())
            .setTimeoutBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(300L)
                    .setDelayMultiplier(1.3)
                    .setMaxDelayMillis(3000L)
                    .build())
            .setTotalTimeout(30000L)
            .build();
    definitions.put("default", params);
    RETRY_PARAM_DEFINITIONS = definitions.build();
  }

  private static class MethodBuilders {
    private final ApiCallableBuilder<DeleteLogRequest, Empty> deleteLogMethod;
    private final ApiCallableBuilder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesMethod;
    private final PageStreamingApiCallableBuilder<
            ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        listLogEntriesMethod;
    private final PageStreamingApiCallableBuilder<
            ReadLogEntriesRequest, ReadLogEntriesResponse, LogEntry>
        readLogEntriesMethod;
    private final PageStreamingApiCallableBuilder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        listMonitoredResourceDescriptorsMethod;
    private final ImmutableList<? extends ApiCallSettings> allMethods;

    public MethodBuilders() {
      deleteLogMethod = new ApiCallableBuilder<>(LoggingServiceV2Grpc.METHOD_DELETE_LOG);
      deleteLogMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      deleteLogMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      writeLogEntriesMethod =
          new ApiCallableBuilder<>(LoggingServiceV2Grpc.METHOD_WRITE_LOG_ENTRIES);
      writeLogEntriesMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      writeLogEntriesMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      listLogEntriesMethod =
          new PageStreamingApiCallableBuilder<>(
              LoggingServiceV2Grpc.METHOD_LIST_LOG_ENTRIES, LIST_LOG_ENTRIES_PAGE_STR_DESC);
      listLogEntriesMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listLogEntriesMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      readLogEntriesMethod =
          new PageStreamingApiCallableBuilder<>(
              LoggingServiceV2Grpc.METHOD_READ_LOG_ENTRIES, READ_LOG_ENTRIES_PAGE_STR_DESC);
      readLogEntriesMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      readLogEntriesMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      listMonitoredResourceDescriptorsMethod =
          new PageStreamingApiCallableBuilder<>(
              LoggingServiceV2Grpc.METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
              LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC);
      listMonitoredResourceDescriptorsMethod.setRetryableCodes(
          RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listMonitoredResourceDescriptorsMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      allMethods =
          ImmutableList.<ApiCallSettings>builder()
              .add(
                  deleteLogMethod,
                  writeLogEntriesMethod,
                  listLogEntriesMethod,
                  readLogEntriesMethod,
                  listMonitoredResourceDescriptorsMethod)
              .build();
    }
  }

  private final MethodBuilders methods;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of LoggingServiceV2Settings with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static LoggingServiceV2Settings create() {
    LoggingServiceV2Settings settings = new LoggingServiceV2Settings(new MethodBuilders());
    settings.provideChannelWith(
        ConnectionSettings.builder()
            .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
            .setPort(DEFAULT_SERVICE_PORT)
            .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
            .build());
    return settings;
  }

  /**
   * Constructs an instance of LoggingServiceV2Settings with default settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected LoggingServiceV2Settings(MethodBuilders methods) {
    super(methods.allMethods);
    this.methods = methods;
  }

  /**
   * Returns the ApiCallableBuilder for the API method deleteLog.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<DeleteLogRequest, Empty> deleteLogMethod() {
    return methods.deleteLogMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method writeLogEntries.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesMethod() {
    return methods.writeLogEntriesMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method listLogEntries.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      listLogEntriesMethod() {
    return methods.listLogEntriesMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method readLogEntries.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<ReadLogEntriesRequest, ReadLogEntriesResponse, LogEntry>
      readLogEntriesMethod() {
    return methods.readLogEntriesMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method
   * listMonitoredResourceDescriptors.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsMethod() {
    return methods.listMonitoredResourceDescriptorsMethod;
  }

  private static PageDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      LIST_LOG_ENTRIES_PAGE_STR_DESC =
          new PageDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListLogEntriesRequest injectToken(ListLogEntriesRequest payload, Object token) {
              return ListLogEntriesRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public Object extractNextToken(ListLogEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogEntry> extractResources(ListLogEntriesResponse payload) {
              return payload.getEntriesList();
            }
          };

  private static PageDescriptor<ReadLogEntriesRequest, ReadLogEntriesResponse, LogEntry>
      READ_LOG_ENTRIES_PAGE_STR_DESC =
          new PageDescriptor<ReadLogEntriesRequest, ReadLogEntriesResponse, LogEntry>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ReadLogEntriesRequest injectToken(ReadLogEntriesRequest payload, Object token) {
              return ReadLogEntriesRequest.newBuilder(payload)
                  .setResumeToken((String) token)
                  .build();
            }

            @Override
            public Object extractNextToken(ReadLogEntriesResponse payload) {
              return payload.getResumeToken();
            }

            @Override
            public Iterable<LogEntry> extractResources(ReadLogEntriesResponse payload) {
              return payload.getEntriesList();
            }
          };

  private static PageDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC =
          new PageDescriptor<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectToken(
                ListMonitoredResourceDescriptorsRequest payload, Object token) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public Object extractNextToken(ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResourceDescriptor> extractResources(
                ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getResourceDescriptorsList();
            }
          };
}
