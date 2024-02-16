/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging.v2;

import com.google.api.MonitoredResource;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.stub.LoggingServiceV2Stub;
import com.google.cloud.logging.v2.stub.LoggingServiceV2StubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.logging.v2.BillingAccountName;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.FolderName;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LogName;
import com.google.logging.v2.OrganizationName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for ingesting and querying logs.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (LoggingClient loggingClient = LoggingClient.create()) {
 *   LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");
 *   loggingClient.deleteLog(logName);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LoggingClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteLog</td>
 *      <td><p> Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it receives new entries. Log entries written shortly before the delete operation might not be deleted. Entries received after the delete operation with a timestamp before the operation will be deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteLog(DeleteLogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteLog(LogName logName)
 *           <li><p> deleteLog(String logName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteLogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> WriteLogEntries</td>
 *      <td><p> Writes log entries to Logging. This API method is the only way to send log entries to Logging. This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging libraries configured to use Logging. A single request may contain log entries for a maximum of 1000 different resources (projects, organizations, billing accounts or folders)</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> writeLogEntries(WriteLogEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> writeLogEntries(LogName logName, MonitoredResource resource, Map&lt;String, String&gt; labels, List&lt;LogEntry&gt; entries)
 *           <li><p> writeLogEntries(String logName, MonitoredResource resource, Map&lt;String, String&gt; labels, List&lt;LogEntry&gt; entries)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> writeLogEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogEntries</td>
 *      <td><p> Lists log entries.  Use this method to retrieve log entries that originated from a project/folder/organization/billing account.  For ways to export log entries, see [Exporting Logs](https://cloud.google.com/logging/docs/export).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogEntries(ListLogEntriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLogEntries(List&lt;String&gt; resourceNames, String filter, String orderBy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogEntriesPagedCallable()
 *           <li><p> listLogEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMonitoredResourceDescriptors</td>
 *      <td><p> Lists the descriptors for monitored resource types used by Logging.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMonitoredResourceDescriptors(ListMonitoredResourceDescriptorsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMonitoredResourceDescriptorsPagedCallable()
 *           <li><p> listMonitoredResourceDescriptorsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogs</td>
 *      <td><p> Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have entries are listed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogs(ListLogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLogs(BillingAccountName parent)
 *           <li><p> listLogs(FolderName parent)
 *           <li><p> listLogs(OrganizationName parent)
 *           <li><p> listLogs(ProjectName parent)
 *           <li><p> listLogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogsPagedCallable()
 *           <li><p> listLogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TailLogEntries</td>
 *      <td><p> Streaming read of log entries as they are ingested. Until the stream is terminated, it will continue reading logs.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> tailLogEntriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of LoggingSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LoggingSettings loggingSettings =
 *     LoggingSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LoggingClient loggingClient = LoggingClient.create(loggingSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LoggingSettings loggingSettings = LoggingSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LoggingClient loggingClient = LoggingClient.create(loggingSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LoggingClient implements BackgroundResource {
  private final LoggingSettings settings;
  private final LoggingServiceV2Stub stub;

  /** Constructs an instance of LoggingClient with default settings. */
  public static final LoggingClient create() throws IOException {
    return create(LoggingSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LoggingClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LoggingClient create(LoggingSettings settings) throws IOException {
    return new LoggingClient(settings);
  }

  /**
   * Constructs an instance of LoggingClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(LoggingSettings).
   */
  public static final LoggingClient create(LoggingServiceV2Stub stub) {
    return new LoggingClient(stub);
  }

  /**
   * Constructs an instance of LoggingClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected LoggingClient(LoggingSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LoggingServiceV2StubSettings) settings.getStubSettings()).createStub();
  }

  protected LoggingClient(LoggingServiceV2Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LoggingSettings getSettings() {
    return settings;
  }

  public LoggingServiceV2Stub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it
   * receives new entries. Log entries written shortly before the delete operation might not be
   * deleted. Entries received after the delete operation with a timestamp before the operation will
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");
   *   loggingClient.deleteLog(logName);
   * }
   * }</pre>
   *
   * @param logName Required. The resource name of the log to delete:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]/logs/[LOG_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]/logs/[LOG_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]/logs/[LOG_ID]`
   *       <li>`folders/[FOLDER_ID]/logs/[LOG_ID]`
   *     </ul>
   *     <p>`[LOG_ID]` must be URL-encoded. For example, `"projects/my-project-id/logs/syslog"`,
   *     `"organizations/123/logs/cloudaudit.googleapis.com%2Factivity"`.
   *     <p>For more information about log names, see [LogEntry][google.logging.v2.LogEntry].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLog(LogName logName) {
    DeleteLogRequest request =
        DeleteLogRequest.newBuilder()
            .setLogName(logName == null ? null : logName.toString())
            .build();
    deleteLog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it
   * receives new entries. Log entries written shortly before the delete operation might not be
   * deleted. Entries received after the delete operation with a timestamp before the operation will
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   String logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString();
   *   loggingClient.deleteLog(logName);
   * }
   * }</pre>
   *
   * @param logName Required. The resource name of the log to delete:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]/logs/[LOG_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]/logs/[LOG_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]/logs/[LOG_ID]`
   *       <li>`folders/[FOLDER_ID]/logs/[LOG_ID]`
   *     </ul>
   *     <p>`[LOG_ID]` must be URL-encoded. For example, `"projects/my-project-id/logs/syslog"`,
   *     `"organizations/123/logs/cloudaudit.googleapis.com%2Factivity"`.
   *     <p>For more information about log names, see [LogEntry][google.logging.v2.LogEntry].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLog(String logName) {
    DeleteLogRequest request = DeleteLogRequest.newBuilder().setLogName(logName).build();
    deleteLog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it
   * receives new entries. Log entries written shortly before the delete operation might not be
   * deleted. Entries received after the delete operation with a timestamp before the operation will
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   DeleteLogRequest request =
   *       DeleteLogRequest.newBuilder()
   *           .setLogName(LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString())
   *           .build();
   *   loggingClient.deleteLog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteLog(DeleteLogRequest request) {
    deleteLogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it
   * receives new entries. Log entries written shortly before the delete operation might not be
   * deleted. Entries received after the delete operation with a timestamp before the operation will
   * be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   DeleteLogRequest request =
   *       DeleteLogRequest.newBuilder()
   *           .setLogName(LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString())
   *           .build();
   *   ApiFuture<Empty> future = loggingClient.deleteLogCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    return stub.deleteLogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes log entries to Logging. This API method is the only way to send log entries to Logging.
   * This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging
   * libraries configured to use Logging. A single request may contain log entries for a maximum of
   * 1000 different resources (projects, organizations, billing accounts or folders)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   LogName logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]");
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   Map<String, String> labels = new HashMap<>();
   *   List<LogEntry> entries = new ArrayList<>();
   *   WriteLogEntriesResponse response =
   *       loggingClient.writeLogEntries(logName, resource, labels, entries);
   * }
   * }</pre>
   *
   * @param logName Optional. A default log resource name that is assigned to all log entries in
   *     `entries` that do not specify a value for `log_name`:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]/logs/[LOG_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]/logs/[LOG_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]/logs/[LOG_ID]`
   *       <li>`folders/[FOLDER_ID]/logs/[LOG_ID]`
   *     </ul>
   *     <p>`[LOG_ID]` must be URL-encoded. For example:
   *     <p>"projects/my-project-id/logs/syslog"
   *     "organizations/123/logs/cloudaudit.googleapis.com%2Factivity"
   *     <p>The permission `logging.logEntries.create` is needed on each project, organization,
   *     billing account, or folder that is receiving new log entries, whether the resource is
   *     specified in `logName` or in an individual log entry.
   * @param resource Optional. A default monitored resource object that is assigned to all log
   *     entries in `entries` that do not specify a value for `resource`. Example:
   *     <p>{ "type": "gce_instance", "labels": { "zone": "us-central1-a", "instance_id":
   *     "00000000000000000000" }}
   *     <p>See [LogEntry][google.logging.v2.LogEntry].
   * @param labels Optional. Default labels that are added to the `labels` field of all log entries
   *     in `entries`. If a log entry already has a label with the same key as a label in this
   *     parameter, then the log entry's label is not changed. See
   *     [LogEntry][google.logging.v2.LogEntry].
   * @param entries Required. The log entries to send to Logging. The order of log entries in this
   *     list does not matter. Values supplied in this method's `log_name`, `resource`, and `labels`
   *     fields are copied into those log entries in this list that do not include values for their
   *     corresponding fields. For more information, see the [LogEntry][google.logging.v2.LogEntry]
   *     type.
   *     <p>If the `timestamp` or `insert_id` fields are missing in log entries, then this method
   *     supplies the current time or a unique identifier, respectively. The supplied values are
   *     chosen so that, among the log entries that did not supply their own values, the entries
   *     earlier in the list will sort before the entries later in the list. See the `entries.list`
   *     method.
   *     <p>Log entries with timestamps that are more than the [logs retention
   *     period](https://cloud.google.com/logging/quotas) in the past or more than 24 hours in the
   *     future will not be available when calling `entries.list`. However, those log entries can
   *     still be [exported with
   *     LogSinks](https://cloud.google.com/logging/docs/api/tasks/exporting-logs).
   *     <p>To improve throughput and to avoid exceeding the [quota
   *     limit](https://cloud.google.com/logging/quotas) for calls to `entries.write`, you should
   *     try to include several log entries in this list, rather than calling this method for each
   *     individual log entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(
      LogName logName,
      MonitoredResource resource,
      Map<String, String> labels,
      List<LogEntry> entries) {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .setLogName(logName == null ? null : logName.toString())
            .setResource(resource)
            .putAllLabels(labels)
            .addAllEntries(entries)
            .build();
    return writeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes log entries to Logging. This API method is the only way to send log entries to Logging.
   * This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging
   * libraries configured to use Logging. A single request may contain log entries for a maximum of
   * 1000 different resources (projects, organizations, billing accounts or folders)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   String logName = LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString();
   *   MonitoredResource resource = MonitoredResource.newBuilder().build();
   *   Map<String, String> labels = new HashMap<>();
   *   List<LogEntry> entries = new ArrayList<>();
   *   WriteLogEntriesResponse response =
   *       loggingClient.writeLogEntries(logName, resource, labels, entries);
   * }
   * }</pre>
   *
   * @param logName Optional. A default log resource name that is assigned to all log entries in
   *     `entries` that do not specify a value for `log_name`:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]/logs/[LOG_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]/logs/[LOG_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]/logs/[LOG_ID]`
   *       <li>`folders/[FOLDER_ID]/logs/[LOG_ID]`
   *     </ul>
   *     <p>`[LOG_ID]` must be URL-encoded. For example:
   *     <p>"projects/my-project-id/logs/syslog"
   *     "organizations/123/logs/cloudaudit.googleapis.com%2Factivity"
   *     <p>The permission `logging.logEntries.create` is needed on each project, organization,
   *     billing account, or folder that is receiving new log entries, whether the resource is
   *     specified in `logName` or in an individual log entry.
   * @param resource Optional. A default monitored resource object that is assigned to all log
   *     entries in `entries` that do not specify a value for `resource`. Example:
   *     <p>{ "type": "gce_instance", "labels": { "zone": "us-central1-a", "instance_id":
   *     "00000000000000000000" }}
   *     <p>See [LogEntry][google.logging.v2.LogEntry].
   * @param labels Optional. Default labels that are added to the `labels` field of all log entries
   *     in `entries`. If a log entry already has a label with the same key as a label in this
   *     parameter, then the log entry's label is not changed. See
   *     [LogEntry][google.logging.v2.LogEntry].
   * @param entries Required. The log entries to send to Logging. The order of log entries in this
   *     list does not matter. Values supplied in this method's `log_name`, `resource`, and `labels`
   *     fields are copied into those log entries in this list that do not include values for their
   *     corresponding fields. For more information, see the [LogEntry][google.logging.v2.LogEntry]
   *     type.
   *     <p>If the `timestamp` or `insert_id` fields are missing in log entries, then this method
   *     supplies the current time or a unique identifier, respectively. The supplied values are
   *     chosen so that, among the log entries that did not supply their own values, the entries
   *     earlier in the list will sort before the entries later in the list. See the `entries.list`
   *     method.
   *     <p>Log entries with timestamps that are more than the [logs retention
   *     period](https://cloud.google.com/logging/quotas) in the past or more than 24 hours in the
   *     future will not be available when calling `entries.list`. However, those log entries can
   *     still be [exported with
   *     LogSinks](https://cloud.google.com/logging/docs/api/tasks/exporting-logs).
   *     <p>To improve throughput and to avoid exceeding the [quota
   *     limit](https://cloud.google.com/logging/quotas) for calls to `entries.write`, you should
   *     try to include several log entries in this list, rather than calling this method for each
   *     individual log entry.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(
      String logName,
      MonitoredResource resource,
      Map<String, String> labels,
      List<LogEntry> entries) {
    WriteLogEntriesRequest request =
        WriteLogEntriesRequest.newBuilder()
            .setLogName(logName)
            .setResource(resource)
            .putAllLabels(labels)
            .addAllEntries(entries)
            .build();
    return writeLogEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes log entries to Logging. This API method is the only way to send log entries to Logging.
   * This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging
   * libraries configured to use Logging. A single request may contain log entries for a maximum of
   * 1000 different resources (projects, organizations, billing accounts or folders)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   WriteLogEntriesRequest request =
   *       WriteLogEntriesRequest.newBuilder()
   *           .setLogName(LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString())
   *           .setResource(MonitoredResource.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .addAllEntries(new ArrayList<LogEntry>())
   *           .setPartialSuccess(true)
   *           .setDryRun(true)
   *           .build();
   *   WriteLogEntriesResponse response = loggingClient.writeLogEntries(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WriteLogEntriesResponse writeLogEntries(WriteLogEntriesRequest request) {
    return writeLogEntriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Writes log entries to Logging. This API method is the only way to send log entries to Logging.
   * This method is used, directly or indirectly, by the Logging agent (fluentd) and all logging
   * libraries configured to use Logging. A single request may contain log entries for a maximum of
   * 1000 different resources (projects, organizations, billing accounts or folders)
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   WriteLogEntriesRequest request =
   *       WriteLogEntriesRequest.newBuilder()
   *           .setLogName(LogName.ofProjectLogName("[PROJECT]", "[LOG]").toString())
   *           .setResource(MonitoredResource.newBuilder().build())
   *           .putAllLabels(new HashMap<String, String>())
   *           .addAllEntries(new ArrayList<LogEntry>())
   *           .setPartialSuccess(true)
   *           .setDryRun(true)
   *           .build();
   *   ApiFuture<WriteLogEntriesResponse> future =
   *       loggingClient.writeLogEntriesCallable().futureCall(request);
   *   // Do something.
   *   WriteLogEntriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable() {
    return stub.writeLogEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log entries. Use this method to retrieve log entries that originated from a
   * project/folder/organization/billing account. For ways to export log entries, see [Exporting
   * Logs](https://cloud.google.com/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   List<String> resourceNames = new ArrayList<>();
   *   String filter = "filter-1274492040";
   *   String orderBy = "orderBy-1207110587";
   *   for (LogEntry element :
   *       loggingClient.listLogEntries(resourceNames, filter, orderBy).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param resourceNames Required. Names of one or more parent resources from which to retrieve log
   *     entries:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *     <p>May alternatively be one or more views:
   *     <p>&#42;
   *     `projects/[PROJECT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/views/[VIEW_ID]` &#42;
   *     `organizations/[ORGANIZATION_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/views/[VIEW_ID]`
   *     &#42;
   *     `billingAccounts/[BILLING_ACCOUNT_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/views/[VIEW_ID]`
   *     &#42; `folders/[FOLDER_ID]/locations/[LOCATION_ID]/buckets/[BUCKET_ID]/views/[VIEW_ID]`
   *     <p>Projects listed in the `project_ids` field are added to this list. A maximum of 100
   *     resources may be specified in a single request.
   * @param filter Optional. Only log entries that match the filter are returned. An empty filter
   *     matches all log entries in the resources listed in `resource_names`. Referencing a parent
   *     resource that is not listed in `resource_names` will cause the filter to return no results.
   *     The maximum length of a filter is 20,000 characters.
   * @param orderBy Optional. How the results should be sorted. Presently, the only permitted values
   *     are `"timestamp asc"` (default) and `"timestamp desc"`. The first option returns entries in
   *     order of increasing values of `LogEntry.timestamp` (oldest first), and the second option
   *     returns entries in order of decreasing timestamps (newest first). Entries with equal
   *     timestamps are returned in order of their `insert_id` values.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log entries. Use this method to retrieve log entries that originated from a
   * project/folder/organization/billing account. For ways to export log entries, see [Exporting
   * Logs](https://cloud.google.com/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogEntriesRequest request =
   *       ListLogEntriesRequest.newBuilder()
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LogEntry element : loggingClient.listLogEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogEntriesPagedResponse listLogEntries(ListLogEntriesRequest request) {
    return listLogEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log entries. Use this method to retrieve log entries that originated from a
   * project/folder/organization/billing account. For ways to export log entries, see [Exporting
   * Logs](https://cloud.google.com/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogEntriesRequest request =
   *       ListLogEntriesRequest.newBuilder()
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LogEntry> future = loggingClient.listLogEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogEntry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable() {
    return stub.listLogEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists log entries. Use this method to retrieve log entries that originated from a
   * project/folder/organization/billing account. For ways to export log entries, see [Exporting
   * Logs](https://cloud.google.com/logging/docs/export).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogEntriesRequest request =
   *       ListLogEntriesRequest.newBuilder()
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogEntriesResponse response = loggingClient.listLogEntriesCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse>
      listLogEntriesCallable() {
    return stub.listLogEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for monitored resource types used by Logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListMonitoredResourceDescriptorsRequest request =
   *       ListMonitoredResourceDescriptorsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MonitoredResourceDescriptor element :
   *       loggingClient.listMonitoredResourceDescriptors(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMonitoredResourceDescriptorsPagedResponse listMonitoredResourceDescriptors(
      ListMonitoredResourceDescriptorsRequest request) {
    return listMonitoredResourceDescriptorsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for monitored resource types used by Logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListMonitoredResourceDescriptorsRequest request =
   *       ListMonitoredResourceDescriptorsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MonitoredResourceDescriptor> future =
   *       loggingClient.listMonitoredResourceDescriptorsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MonitoredResourceDescriptor element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return stub.listMonitoredResourceDescriptorsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the descriptors for monitored resource types used by Logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListMonitoredResourceDescriptorsRequest request =
   *       ListMonitoredResourceDescriptorsRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMonitoredResourceDescriptorsResponse response =
   *         loggingClient.listMonitoredResourceDescriptorsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return stub.listMonitoredResourceDescriptorsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
   *   for (String element : loggingClient.listLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name to list logs for:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(BillingAccountName parent) {
    ListLogsRequest request =
        ListLogsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   FolderName parent = FolderName.of("[FOLDER]");
   *   for (String element : loggingClient.listLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name to list logs for:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(FolderName parent) {
    ListLogsRequest request =
        ListLogsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
   *   for (String element : loggingClient.listLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name to list logs for:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(OrganizationName parent) {
    ListLogsRequest request =
        ListLogsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (String element : loggingClient.listLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name to list logs for:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(ProjectName parent) {
    ListLogsRequest request =
        ListLogsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (String element : loggingClient.listLogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name to list logs for:
   *     <ul>
   *       <li>`projects/[PROJECT_ID]`
   *       <li>`organizations/[ORGANIZATION_ID]`
   *       <li>`billingAccounts/[BILLING_ACCOUNT_ID]`
   *       <li>`folders/[FOLDER_ID]`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(String parent) {
    ListLogsRequest request = ListLogsRequest.newBuilder().setParent(parent).build();
    return listLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogsRequest request =
   *       ListLogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (String element : loggingClient.listLogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogsPagedResponse listLogs(ListLogsRequest request) {
    return listLogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogsRequest request =
   *       ListLogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<String> future = loggingClient.listLogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (String element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable() {
    return stub.listLogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have
   * entries are listed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   ListLogsRequest request =
   *       ListLogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogsResponse response = loggingClient.listLogsCallable().call(request);
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
   * }</pre>
   */
  public final UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable() {
    return stub.listLogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Streaming read of log entries as they are ingested. Until the stream is terminated, it will
   * continue reading logs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LoggingClient loggingClient = LoggingClient.create()) {
   *   BidiStream<TailLogEntriesRequest, TailLogEntriesResponse> bidiStream =
   *       loggingClient.tailLogEntriesCallable().call();
   *   TailLogEntriesRequest request =
   *       TailLogEntriesRequest.newBuilder()
   *           .addAllResourceNames(new ArrayList<String>())
   *           .setFilter("filter-1274492040")
   *           .setBufferWindow(Duration.newBuilder().build())
   *           .build();
   *   bidiStream.send(request);
   *   for (TailLogEntriesResponse response : bidiStream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesCallable() {
    return stub.tailLogEntriesCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListLogEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListLogEntriesRequest,
          ListLogEntriesResponse,
          LogEntry,
          ListLogEntriesPage,
          ListLogEntriesFixedSizeCollection> {

    public static ApiFuture<ListLogEntriesPagedResponse> createAsync(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ApiFuture<ListLogEntriesResponse> futureResponse) {
      ApiFuture<ListLogEntriesPage> futurePage =
          ListLogEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogEntriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogEntriesPagedResponse(ListLogEntriesPage page) {
      super(page, ListLogEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogEntriesPage
      extends AbstractPage<
          ListLogEntriesRequest, ListLogEntriesResponse, LogEntry, ListLogEntriesPage> {

    private ListLogEntriesPage(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ListLogEntriesResponse response) {
      super(context, response);
    }

    private static ListLogEntriesPage createEmptyPage() {
      return new ListLogEntriesPage(null, null);
    }

    @Override
    protected ListLogEntriesPage createPage(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ListLogEntriesResponse response) {
      return new ListLogEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListLogEntriesPage> createPageAsync(
        PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> context,
        ApiFuture<ListLogEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogEntriesRequest,
          ListLogEntriesResponse,
          LogEntry,
          ListLogEntriesPage,
          ListLogEntriesFixedSizeCollection> {

    private ListLogEntriesFixedSizeCollection(List<ListLogEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogEntriesFixedSizeCollection createEmptyCollection() {
      return new ListLogEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogEntriesFixedSizeCollection createCollection(
        List<ListLogEntriesPage> pages, int collectionSize) {
      return new ListLogEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMonitoredResourceDescriptorsPagedResponse
      extends AbstractPagedListResponse<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor,
          ListMonitoredResourceDescriptorsPage,
          ListMonitoredResourceDescriptorsFixedSizeCollection> {

    public static ApiFuture<ListMonitoredResourceDescriptorsPagedResponse> createAsync(
        PageContext<
                ListMonitoredResourceDescriptorsRequest,
                ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse) {
      ApiFuture<ListMonitoredResourceDescriptorsPage> futurePage =
          ListMonitoredResourceDescriptorsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMonitoredResourceDescriptorsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMonitoredResourceDescriptorsPagedResponse(
        ListMonitoredResourceDescriptorsPage page) {
      super(page, ListMonitoredResourceDescriptorsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMonitoredResourceDescriptorsPage
      extends AbstractPage<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor,
          ListMonitoredResourceDescriptorsPage> {

    private ListMonitoredResourceDescriptorsPage(
        PageContext<
                ListMonitoredResourceDescriptorsRequest,
                ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ListMonitoredResourceDescriptorsResponse response) {
      super(context, response);
    }

    private static ListMonitoredResourceDescriptorsPage createEmptyPage() {
      return new ListMonitoredResourceDescriptorsPage(null, null);
    }

    @Override
    protected ListMonitoredResourceDescriptorsPage createPage(
        PageContext<
                ListMonitoredResourceDescriptorsRequest,
                ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ListMonitoredResourceDescriptorsResponse response) {
      return new ListMonitoredResourceDescriptorsPage(context, response);
    }

    @Override
    public ApiFuture<ListMonitoredResourceDescriptorsPage> createPageAsync(
        PageContext<
                ListMonitoredResourceDescriptorsRequest,
                ListMonitoredResourceDescriptorsResponse,
                MonitoredResourceDescriptor>
            context,
        ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMonitoredResourceDescriptorsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor,
          ListMonitoredResourceDescriptorsPage,
          ListMonitoredResourceDescriptorsFixedSizeCollection> {

    private ListMonitoredResourceDescriptorsFixedSizeCollection(
        List<ListMonitoredResourceDescriptorsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMonitoredResourceDescriptorsFixedSizeCollection createEmptyCollection() {
      return new ListMonitoredResourceDescriptorsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMonitoredResourceDescriptorsFixedSizeCollection createCollection(
        List<ListMonitoredResourceDescriptorsPage> pages, int collectionSize) {
      return new ListMonitoredResourceDescriptorsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogsPagedResponse
      extends AbstractPagedListResponse<
          ListLogsRequest, ListLogsResponse, String, ListLogsPage, ListLogsFixedSizeCollection> {

    public static ApiFuture<ListLogsPagedResponse> createAsync(
        PageContext<ListLogsRequest, ListLogsResponse, String> context,
        ApiFuture<ListLogsResponse> futureResponse) {
      ApiFuture<ListLogsPage> futurePage =
          ListLogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLogsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLogsPagedResponse(ListLogsPage page) {
      super(page, ListLogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogsPage
      extends AbstractPage<ListLogsRequest, ListLogsResponse, String, ListLogsPage> {

    private ListLogsPage(
        PageContext<ListLogsRequest, ListLogsResponse, String> context, ListLogsResponse response) {
      super(context, response);
    }

    private static ListLogsPage createEmptyPage() {
      return new ListLogsPage(null, null);
    }

    @Override
    protected ListLogsPage createPage(
        PageContext<ListLogsRequest, ListLogsResponse, String> context, ListLogsResponse response) {
      return new ListLogsPage(context, response);
    }

    @Override
    public ApiFuture<ListLogsPage> createPageAsync(
        PageContext<ListLogsRequest, ListLogsResponse, String> context,
        ApiFuture<ListLogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogsRequest, ListLogsResponse, String, ListLogsPage, ListLogsFixedSizeCollection> {

    private ListLogsFixedSizeCollection(List<ListLogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogsFixedSizeCollection createEmptyCollection() {
      return new ListLogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogsFixedSizeCollection createCollection(
        List<ListLogsPage> pages, int collectionSize) {
      return new ListLogsFixedSizeCollection(pages, collectionSize);
    }
  }
}
