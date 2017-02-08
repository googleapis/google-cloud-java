/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.logging.spi.v2;

import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListLogsPagedResponse;
import static com.google.cloud.logging.spi.v2.PagedResponseWrappers.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.MonitoredResource;
import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogNameOneof;
import com.google.logging.v2.ParentNameOneof;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for ingesting and querying logs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
 *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
 *   loggingServiceV2Client.deleteLog(logName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the loggingServiceV2Client object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of LoggingServiceV2Settings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     LoggingServiceV2Settings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LoggingServiceV2Settings loggingServiceV2Settings =
 *     LoggingServiceV2Settings.defaultBuilder().setChannelProvider(channelProvider).build();
 * LoggingServiceV2Client loggingServiceV2Client =
 *     LoggingServiceV2Client.create(loggingServiceV2Settings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
public class LoggingServiceV2Client implements AutoCloseable {
  private final LoggingServiceV2Settings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable;
  private final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable;
  private final UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable;
  private final UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable;
  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable;
  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable;
  private final UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable;
  private final UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable;

  /** Constructs an instance of LoggingServiceV2Client with default settings. */
  public static final LoggingServiceV2Client create() throws IOException {
    return create(LoggingServiceV2Settings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of LoggingServiceV2Client, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LoggingServiceV2Client create(LoggingServiceV2Settings settings)
      throws IOException {
    return new LoggingServiceV2Client(settings);
  }

  /**
   * Constructs an instance of LoggingServiceV2Client, using the given settings. This is protected
   * so that it easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LoggingServiceV2Client(LoggingServiceV2Settings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.deleteLogCallable =
        UnaryCallable.create(settings.deleteLogSettings(), this.channel, this.executor);
    this.writeLogEntriesCallable =
        UnaryCallable.create(settings.writeLogEntriesSettings(), this.channel, this.executor);
    if (settings.writeLogEntriesSettings().getBundlerFactory() != null) {
      closeables.add(settings.writeLogEntriesSettings().getBundlerFactory());
    }
    this.listLogEntriesCallable =
        UnaryCallable.create(settings.listLogEntriesSettings(), this.channel, this.executor);
    this.listLogEntriesPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listLogEntriesSettings(), this.channel, this.executor);
    this.listMonitoredResourceDescriptorsCallable =
        UnaryCallable.create(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);
    this.listMonitoredResourceDescriptorsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listMonitoredResourceDescriptorsSettings(), this.channel, this.executor);
    this.listLogsCallable =
        UnaryCallable.create(settings.listLogsSettings(), this.channel, this.executor);
    this.listLogsPagedCallable =
        UnaryCallable.createPagedVariant(settings.listLogsSettings(), this.channel, this.executor);

    if (settings.getChannelProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              channel.shutdown();
            }
          });
    }
    if (settings.getExecutorProvider().shouldAutoClose()) {
      closeables.add(
          new Closeable() {
            @Override
            public void close() throws IOException {
              executor.shutdown();
            }
          });
    }
  }

  public final LoggingServiceV2Settings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all the log entries in a log. The log reappears if it receives new entries.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
   *   loggingServiceV2Client.deleteLog(logName);
   * }
   * </code></pre>
   *
   * @param logName Required. The resource name of the log to delete:
   *     <p>"projects/[PROJECT_ID]/logs/[LOG_ID]" "organizations/[ORGANIZATION_ID]/logs/[LOG_ID]"
   *     <p>`[LOG_ID]` must be URL-encoded. For example, `"projects/my-project-id/logs/syslog"`,
   *     `"organizations/1234567890/logs/cloudresourcemanager.googleapis.com%2Factivity"`. For more
   *     information about log names, see [LogEntry][google.logging.v2.LogEntry].
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void deleteLog(LogNameOneof logName) {

    DeleteLogRequest request =
        DeleteLogRequest.newBuilder().setLogNameWithLogNameOneof(logName).build();
    deleteLog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all the log entries in a log. The log reappears if it receives new entries.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
   *   DeleteLogRequest request = DeleteLogRequest.newBuilder()
   *     .setLogNameWithLogNameOneof(logName)
   *     .build();
   *   loggingServiceV2Client.deleteLog(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final void deleteLog(DeleteLogRequest request) {
    deleteLogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all the log entries in a log. The log reappears if it receives new entries.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
   *   DeleteLogRequest request = DeleteLogRequest.newBuilder()
   *     .setLogNameWithLogNameOneof(logName)
   *     .build();
   *   RpcFuture&lt;Void&gt; future = loggingServiceV2Client.deleteLogCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    return deleteLogCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging. All log entries are written by this method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   LogNameOneof logName = LogNameOneof.from(LogName.create("[PROJECT]", "[LOG]"));
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   Map&lt;String, String&gt; labels = new HashMap&lt;&gt;();
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesResponse response = loggingServiceV2Client.writeLogEntries(logName, resource, labels, entries);
   * }
   * </code></pre>
   *
   * @param logName Optional. A default log resource name that is assigned to all log entries in
   *     `entries` that do not specify a value for `log_name`:
   *     <p>"projects/[PROJECT_ID]/logs/[LOG_ID]" "organizations/[ORGANIZATION_ID]/logs/[LOG_ID]"
   *     <p>`[LOG_ID]` must be URL-encoded. For example, `"projects/my-project-id/logs/syslog"` or
   *     `"organizations/1234567890/logs/cloudresourcemanager.googleapis.com%2Factivity"`. For more
   *     information about log names, see [LogEntry][google.logging.v2.LogEntry].
   * @param resource Optional. A default monitored resource object that is assigned to all log
   *     entries in `entries` that do not specify a value for `resource`. Example:
   *     <p>{ "type": "gce_instance", "labels": { "zone": "us-central1-a", "instance_id":
   *     "00000000000000000000" }}
   *     <p>See [LogEntry][google.logging.v2.LogEntry].
   * @param labels Optional. Default labels that are added to the `labels` field of all log entries
   *     in `entries`. If a log entry already has a label with the same key as a label in this
   *     parameter, then the log entry's label is not changed. See
   *     [LogEntry][google.logging.v2.LogEntry].
   * @param entries Required. The log entries to write. Values supplied for the fields `log_name`,
   *     `resource`, and `labels` in this `entries.write` request are added to those log entries
   *     that do not provide their own values for the fields.
   *     <p>To improve throughput and to avoid exceeding the [quota limit](/logging/quota-policy)
   *     for calls to `entries.write`, you should write multiple log entries at once rather than
   *     calling this method for each individual log entry.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(
      LogNameOneof logName,
      MonitoredResource resource,
      Map<String, String> labels,
      List<LogEntry> entries) {

    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .setLogNameWithLogNameOneof(logName)
            .setResource(resource)
            .putAllLabels(labels)
            .addAllEntries(entries)
            .build();
    return writeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging. All log entries are written by this method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesRequest request = WriteLogEntriesRequest.newBuilder()
   *     .addAllEntries(entries)
   *     .build();
   *   WriteLogEntriesResponse response = loggingServiceV2Client.writeLogEntries(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(WriteLogEntriesRequest request) {
    return writeLogEntriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes log entries to Stackdriver Logging. All log entries are written by this method.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;LogEntry&gt; entries = new ArrayList&lt;&gt;();
   *   WriteLogEntriesRequest request = WriteLogEntriesRequest.newBuilder()
   *     .addAllEntries(entries)
   *     .build();
   *   RpcFuture&lt;WriteLogEntriesResponse&gt; future = loggingServiceV2Client.writeLogEntriesCallable().futureCall(request);
   *   // Do something
   *   WriteLogEntriesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable() {
    return writeLogEntriesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries. Use this method to retrieve log entries from Stackdriver Logging. For ways
   * to export log entries, see [Exporting Logs](/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;String&gt; resourceNames = new ArrayList&lt;&gt;();
   *   String filter = "";
   *   String orderBy = "";
   *   for (LogEntry element : loggingServiceV2Client.listLogEntries(resourceNames, filter, orderBy).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param resourceNames Required. Names of one or more resources from which to retrieve log
   *     entries:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   *     <p>Projects listed in the `project_ids` field are added to this list.
   * @param filter Optional. A filter that chooses which log entries to return. See [Advanced Logs
   *     Filters](/logging/docs/view/advanced_filters). Only log entries that match the filter are
   *     returned. An empty filter matches all log entries in the resources listed in
   *     `resource_names`. Referencing a parent resource that is not listed in `resource_names` will
   *     cause the filter to return no results. The maximum length of the filter is 20000
   *     characters.
   * @param orderBy Optional. How the results should be sorted. Presently, the only permitted values
   *     are `"timestamp asc"` (default) and `"timestamp desc"`. The first option returns entries in
   *     order of increasing values of `LogEntry.timestamp` (oldest first), and the second option
   *     returns entries in order of decreasing timestamps (newest first). Entries with equal
   *     timestamps are returned in order of `LogEntry.insertId`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogEntriesPagedResponse listLogEntries(
      List<String> resourceNames, String filter, String orderBy) {
    ListLogEntriesRequest request =
        ListLogEntriesRequest.newBuilder()
            .addAllResourceNames(resourceNames)
            .setFilter(filter)
            .setOrderBy(orderBy)
            .build();
    return listLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries. Use this method to retrieve log entries from Stackdriver Logging. For ways
   * to export log entries, see [Exporting Logs](/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;String&gt; resourceNames = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllResourceNames(resourceNames)
   *     .build();
   *   for (LogEntry element : loggingServiceV2Client.listLogEntries(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogEntriesPagedResponse listLogEntries(ListLogEntriesRequest request) {
    return listLogEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries. Use this method to retrieve log entries from Stackdriver Logging. For ways
   * to export log entries, see [Exporting Logs](/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;String&gt; resourceNames = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllResourceNames(resourceNames)
   *     .build();
   *   RpcFuture&lt;ListLogEntriesPagedResponse&gt; future = loggingServiceV2Client.listLogEntriesPagedCallable().futureCall(request);
   *   // Do something
   *   for (LogEntry element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable() {
    return listLogEntriesPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists log entries. Use this method to retrieve log entries from Stackdriver Logging. For ways
   * to export log entries, see [Exporting Logs](/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   List&lt;String&gt; resourceNames = new ArrayList&lt;&gt;();
   *   ListLogEntriesRequest request = ListLogEntriesRequest.newBuilder()
   *     .addAllResourceNames(resourceNames)
   *     .build();
   *   while (true) {
   *     ListLogEntriesResponse response = loggingServiceV2Client.listLogEntriesCallable().call(request);
   *     for (LogEntry element : response.getEntriesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse>
      listLogEntriesCallable() {
    return listLogEntriesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the descriptors for monitored resource types used by Stackdriver Logging.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder().build();
   *   for (MonitoredResourceDescriptor element : loggingServiceV2Client.listMonitoredResourceDescriptors(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListMonitoredResourceDescriptorsPagedResponse listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request) {
    return listMonitoredResourceDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the descriptors for monitored resource types used by Stackdriver Logging.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder().build();
   *   RpcFuture&lt;ListMonitoredResourceDescriptorsPagedResponse&gt; future = loggingServiceV2Client.listMonitoredResourceDescriptorsPagedCallable().futureCall(request);
   *   // Do something
   *   for (MonitoredResourceDescriptor element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the descriptors for monitored resource types used by Stackdriver Logging.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ListMonitoredResourceDescriptorsRequest request = ListMonitoredResourceDescriptorsRequest.newBuilder().build();
   *   while (true) {
   *     ListMonitoredResourceDescriptorsResponse response = loggingServiceV2Client.listMonitoredResourceDescriptorsCallable().call(request);
   *     for (MonitoredResourceDescriptor element : response.getResourceDescriptorsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the logs in projects or organizations. Only logs that have entries are listed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   for (String element : loggingServiceV2Client.listLogs(parent).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name that owns the logs:
   *     <p>"projects/[PROJECT_ID]" "organizations/[ORGANIZATION_ID]"
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(ParentNameOneof parent) {
    ListLogsRequest request =
        ListLogsRequest.newBuilder().setParentWithParentNameOneof(parent).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the logs in projects or organizations. Only logs that have entries are listed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogsRequest request = ListLogsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   for (String element : loggingServiceV2Client.listLogs(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(ListLogsRequest request) {
    return listLogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the logs in projects or organizations. Only logs that have entries are listed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogsRequest request = ListLogsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   RpcFuture&lt;ListLogsPagedResponse&gt; future = loggingServiceV2Client.listLogsPagedCallable().futureCall(request);
   *   // Do something
   *   for (String element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable() {
    return listLogsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the logs in projects or organizations. Only logs that have entries are listed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (LoggingServiceV2Client loggingServiceV2Client = LoggingServiceV2Client.create()) {
   *   ParentNameOneof parent = ParentNameOneof.from(ProjectName.create("[PROJECT]"));
   *   ListLogsRequest request = ListLogsRequest.newBuilder()
   *     .setParentWithParentNameOneof(parent)
   *     .build();
   *   while (true) {
   *     ListLogsResponse response = loggingServiceV2Client.listLogsCallable().call(request);
   *     for (String element : response.getLogNamesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable() {
    return listLogsCallable;
  }

  /**
   * Initiates an orderly shutdown in which preexisting calls continue but new calls are immediately
   * cancelled.
   */
  @Override
  public final void close() throws Exception {
    for (AutoCloseable closeable : closeables) {
      closeable.close();
    }
  }
}
