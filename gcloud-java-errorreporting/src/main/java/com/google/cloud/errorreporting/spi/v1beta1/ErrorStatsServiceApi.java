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
package com.google.cloud.errorreporting.spi.v1beta1;

import com.google.api.gax.core.PageAccessor;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: An API for retrieving and managing error statistics as well as data for
 * individual events.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
 *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
 *   DeleteEventsResponse response = errorStatsServiceApi.deleteEvents(formattedProjectName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the errorStatsServiceApi object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's methods:
 *
 * <ol>
 * <li> A "flattened" method. With this type of method, the fields of the request type have been
 * converted into function parameters. It may be the case that not all fields are available
 * as parameters, and not every API method will have a flattened method entry point.
 * <li> A "request object" method. This type of method only takes one parameter, a request
 * object, which must be constructed before the call. Not every API method will have a request
 * object method.
 * <li> A "callable" method. This type of method takes no parameters and returns an immutable
 * ApiCallable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist
 * with these names, this class includes a format method for each type of name, and additionally
 * a parse method to extract the individual identifiers contained within names that are
 * returned.
 *
 * <p>This class can be customized by passing in a custom instance of ErrorStatsServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * ErrorStatsServiceSettings errorStatsServiceSettings = ErrorStatsServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create(errorStatsServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class ErrorStatsServiceApi implements AutoCloseable {
  private final ErrorStatsServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable;
  private final ApiCallable<ListGroupStatsRequest, PageAccessor<ErrorGroupStats>>
      listGroupStatsPagedCallable;
  private final ApiCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final ApiCallable<ListEventsRequest, PageAccessor<ErrorEvent>> listEventsPagedCallable;
  private final ApiCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable;

  public final ErrorStatsServiceSettings getSettings() {
    return settings;
  }

  private static final PathTemplate PROJECT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}");

  /**
   * Formats a string containing the fully-qualified path to represent
   * a project resource.
   */
  public static final String formatProjectName(String project) {
    return PROJECT_PATH_TEMPLATE.instantiate("project", project);
  }

  /**
   * Parses the project from the given fully-qualified path which
   * represents a project resource.
   */
  public static final String parseProjectFromProjectName(String projectName) {
    return PROJECT_PATH_TEMPLATE.parse(projectName).get("project");
  }

  /**
   * Constructs an instance of ErrorStatsServiceApi with default settings.
   */
  public static final ErrorStatsServiceApi create() throws IOException {
    return create(ErrorStatsServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of ErrorStatsServiceApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final ErrorStatsServiceApi create(ErrorStatsServiceSettings settings)
      throws IOException {
    return new ErrorStatsServiceApi(settings);
  }

  /**
   * Constructs an instance of ErrorStatsServiceApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected ErrorStatsServiceApi(ErrorStatsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.listGroupStatsCallable =
        ApiCallable.create(settings.listGroupStatsSettings(), this.channel, this.executor);
    this.listGroupStatsPagedCallable =
        ApiCallable.createPagedVariant(
            settings.listGroupStatsSettings(), this.channel, this.executor);
    this.listEventsCallable =
        ApiCallable.create(settings.listEventsSettings(), this.channel, this.executor);
    this.listEventsPagedCallable =
        ApiCallable.createPagedVariant(settings.listEventsSettings(), this.channel, this.executor);
    this.deleteEventsCallable =
        ApiCallable.create(settings.deleteEventsSettings(), this.channel, this.executor);

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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   for (ErrorGroupStats element : errorStatsServiceApi.listGroupStats(formattedProjectName, timeRange)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   * as &lt;code&gt;projects/&lt;/code&gt; plus the
   * &lt;a href="https://support.google.com/cloud/answer/6158840"&gt;Google Cloud
   * Platform project ID&lt;/a&gt;.
   *
   * Example: &lt;code&gt;projects/my-project-123&lt;/code&gt;.
   * @param timeRange [Required] List data for the given time range.
   * The service is tuned for retrieving data up to (approximately) 'now'.
   * Retrieving data for arbitrary time periods in the past can result in
   * higher response times or in returning incomplete results.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<ErrorGroupStats> listGroupStats(
      String projectName, QueryTimeRange timeRange) {
    PROJECT_PATH_TEMPLATE.validate(projectName, "listGroupStats");
    ListGroupStatsRequest request =
        ListGroupStatsRequest.newBuilder()
            .setProjectName(projectName)
            .setTimeRange(timeRange)
            .build();
    return listGroupStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   for (ErrorGroupStats element : errorStatsServiceApi.listGroupStats(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<ErrorGroupStats> listGroupStats(ListGroupStatsRequest request) {
    return listGroupStatsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;ErrorGroupStats&gt;&gt; future = errorStatsServiceApi.listGroupStatsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorGroupStats element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListGroupStatsRequest, PageAccessor<ErrorGroupStats>>
      listGroupStatsPagedCallable() {
    return listGroupStatsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   while (true) {
   *     ListGroupStatsResponse response = errorStatsServiceApi.listGroupStatsCallable().call(request);
   *     for (ErrorGroupStats element : response.getErrorGroupStatsList()) {
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
  public final ApiCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable() {
    return listGroupStatsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   String groupId = "";
   *   for (ErrorEvent element : errorStatsServiceApi.listEvents(formattedProjectName, groupId)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   * as `projects/` plus the
   * [Google Cloud Platform project ID](https://support.google.com/cloud/answer/6158840).
   * Example: `projects/my-project-123`.
   * @param groupId [Required] The group for which events shall be returned.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<ErrorEvent> listEvents(String projectName, String groupId) {
    PROJECT_PATH_TEMPLATE.validate(projectName, "listEvents");
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setProjectName(projectName).setGroupId(groupId).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setGroupId(groupId)
   *     .build();
   *   for (ErrorEvent element : errorStatsServiceApi.listEvents(request)) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PageAccessor<ErrorEvent> listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setGroupId(groupId)
   *     .build();
   *   ListenableFuture&lt;PageAccessor&lt;ErrorEvent&gt;&gt; future = errorStatsServiceApi.listEventsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorEvent element : future.get()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<ListEventsRequest, PageAccessor<ErrorEvent>> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .setGroupId(groupId)
   *     .build();
   *   while (true) {
   *     ListEventsResponse response = errorStatsServiceApi.listEventsCallable().call(request);
   *     for (ErrorEvent element : response.getErrorEventsList()) {
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
  public final ApiCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return listEventsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   DeleteEventsResponse response = errorStatsServiceApi.deleteEvents(formattedProjectName);
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   * as `projects/` plus the
   * [Google Cloud Platform project ID](https://support.google.com/cloud/answer/6158840).
   * Example: `projects/my-project-123`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final DeleteEventsResponse deleteEvents(String projectName) {
    PROJECT_PATH_TEMPLATE.validate(projectName, "deleteEvents");
    DeleteEventsRequest request =
        DeleteEventsRequest.newBuilder().setProjectName(projectName).build();
    return deleteEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   DeleteEventsResponse response = errorStatsServiceApi.deleteEvents(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final DeleteEventsResponse deleteEvents(DeleteEventsRequest request) {
    return deleteEventsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * Sample code:
   * <pre><code>
   * try (ErrorStatsServiceApi errorStatsServiceApi = ErrorStatsServiceApi.create()) {
   *   String formattedProjectName = ErrorStatsServiceApi.formatProjectName("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectName(formattedProjectName)
   *     .build();
   *   ListenableFuture&lt;DeleteEventsResponse&gt; future = errorStatsServiceApi.deleteEventsCallable().futureCall(request);
   *   // Do something
   *   DeleteEventsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
    return deleteEventsCallable;
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
