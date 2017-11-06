/*
 * Copyright 2017, Google LLC All rights reserved.
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
package com.google.cloud.errorreporting.v1beta1;

import static com.google.cloud.errorreporting.v1beta1.PagedResponseWrappers.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.v1beta1.PagedResponseWrappers.ListGroupStatsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.stub.ErrorStatsServiceStub;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

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
 * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
 *   ProjectName projectName = ProjectName.of("[PROJECT]");
 *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(projectName);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the errorStatsServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ErrorStatsServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ErrorStatsServiceSettings errorStatsServiceSettings =
 *     ErrorStatsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ErrorStatsServiceClient errorStatsServiceClient =
 *     ErrorStatsServiceClient.create(errorStatsServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ErrorStatsServiceSettings errorStatsServiceSettings =
 *     ErrorStatsServiceSettings.newBuilder()
 *         .setTransportChannelProvider(ErrorStatsServiceSettings.defaultGrpcTransportProviderBuilder()
 *             .setEndpoint(myEndpoint)
 *             .build())
 *         .build();
 * ErrorStatsServiceClient errorStatsServiceClient =
 *     ErrorStatsServiceClient.create(errorStatsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class ErrorStatsServiceClient implements BackgroundResource {
  private final ErrorStatsServiceSettings settings;
  private final ErrorStatsServiceStub stub;

  /** Constructs an instance of ErrorStatsServiceClient with default settings. */
  public static final ErrorStatsServiceClient create() throws IOException {
    return create(ErrorStatsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ErrorStatsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ErrorStatsServiceClient create(ErrorStatsServiceSettings settings)
      throws IOException {
    return new ErrorStatsServiceClient(settings);
  }

  /**
   * Constructs an instance of ErrorStatsServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use ErrorStatsServiceSettings}.
   */
  @BetaApi
  public static final ErrorStatsServiceClient create(ErrorStatsServiceStub stub) {
    return new ErrorStatsServiceClient(stub);
  }

  /**
   * Constructs an instance of ErrorStatsServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ErrorStatsServiceClient(ErrorStatsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = settings.createStub();
  }

  protected ErrorStatsServiceClient(ErrorStatsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ErrorStatsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi
  public ErrorStatsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   for (ErrorGroupStats element : errorStatsServiceClient.listGroupStats(projectName, timeRange).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as &lt;code&gt;projects/&lt;/code&gt; plus the &lt;a
   *     href="https://support.google.com/cloud/answer/6158840"&gt;Google Cloud Platform project
   *     ID&lt;/a&gt;.
   *     <p>Example: &lt;code&gt;projects/my-project-123&lt;/code&gt;.
   * @param timeRange [Optional] List data for the given time range. If not set a default time range
   *     is used. The field time_range_begin in the response will specify the beginning of this time
   *     range. Only &lt;code&gt;ErrorGroupStats&lt;/code&gt; with a non-zero count in the given
   *     time range are returned, unless the request contains an explicit group_id list. If a
   *     group_id list is given, also &lt;code&gt;ErrorGroupStats&lt;/code&gt; with zero occurrences
   *     are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupStatsPagedResponse listGroupStats(
      ProjectName projectName, QueryTimeRange timeRange) {
    ListGroupStatsRequest request =
        ListGroupStatsRequest.newBuilder()
            .setProjectNameWithProjectName(projectName)
            .setTimeRange(timeRange)
            .build();
    return listGroupStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   for (ErrorGroupStats element : errorStatsServiceClient.listGroupStats(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupStatsPagedResponse listGroupStats(ListGroupStatsRequest request) {
    return listGroupStatsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   ApiFuture&lt;ListGroupStatsPagedResponse&gt; future = errorStatsServiceClient.listGroupStatsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorGroupStats element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable() {
    return stub.listGroupStatsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   while (true) {
   *     ListGroupStatsResponse response = errorStatsServiceClient.listGroupStatsCallable().call(request);
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
  public final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse>
      listGroupStatsCallable() {
    return stub.listGroupStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   String groupId = "";
   *   for (ErrorEvent element : errorStatsServiceClient.listEvents(projectName, groupId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param groupId [Required] The group for which events shall be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ProjectName projectName, String groupId) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder()
            .setProjectNameWithProjectName(projectName)
            .setGroupId(groupId)
            .build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setGroupId(groupId)
   *     .build();
   *   for (ErrorEvent element : errorStatsServiceClient.listEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setGroupId(groupId)
   *     .build();
   *   ApiFuture&lt;ListEventsPagedResponse&gt; future = errorStatsServiceClient.listEventsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return stub.listEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setGroupId(groupId)
   *     .build();
   *   while (true) {
   *     ListEventsResponse response = errorStatsServiceClient.listEventsCallable().call(request);
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
  public final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return stub.listEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(projectName);
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteEventsResponse deleteEvents(ProjectName projectName) {

    DeleteEventsRequest request =
        DeleteEventsRequest.newBuilder().setProjectNameWithProjectName(projectName).build();
    return deleteEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .build();
   *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final DeleteEventsResponse deleteEvents(DeleteEventsRequest request) {
    return deleteEventsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.of("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .build();
   *   ApiFuture&lt;DeleteEventsResponse&gt; future = errorStatsServiceClient.deleteEventsCallable().futureCall(request);
   *   // Do something
   *   DeleteEventsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
    return stub.deleteEventsCallable();
  }

  @Override
  public final void close() throws Exception {
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
}
