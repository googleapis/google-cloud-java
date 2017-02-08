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
package com.google.cloud.errorreporting.spi.v1beta1;

import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.spi.v1beta1.PagedResponseWrappers.ListGroupStatsPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import com.google.protobuf.ExperimentalApi;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
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
 *   ProjectName projectName = ProjectName.create("[PROJECT]");
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
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     ErrorStatsServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ErrorStatsServiceSettings errorStatsServiceSettings =
 *     ErrorStatsServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * ErrorStatsServiceClient errorStatsServiceClient =
 *     ErrorStatsServiceClient.create(errorStatsServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class ErrorStatsServiceClient implements AutoCloseable {
  private final ErrorStatsServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable;
  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable;

  /** Constructs an instance of ErrorStatsServiceClient with default settings. */
  public static final ErrorStatsServiceClient create() throws IOException {
    return create(ErrorStatsServiceSettings.defaultBuilder().build());
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
   * Constructs an instance of ErrorStatsServiceClient, using the given settings. This is protected
   * so that it easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ErrorStatsServiceClient(ErrorStatsServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.listGroupStatsCallable =
        UnaryCallable.create(settings.listGroupStatsSettings(), this.channel, this.executor);
    this.listGroupStatsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listGroupStatsSettings(), this.channel, this.executor);
    this.listEventsCallable =
        UnaryCallable.create(settings.listEventsSettings(), this.channel, this.executor);
    this.listEventsPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listEventsSettings(), this.channel, this.executor);
    this.deleteEventsCallable =
        UnaryCallable.create(settings.deleteEventsSettings(), this.channel, this.executor);

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

  public final ErrorStatsServiceSettings getSettings() {
    return settings;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   for (ErrorGroupStats element : errorStatsServiceClient.listGroupStats(projectName, timeRange).iterateAllElements()) {
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   for (ErrorGroupStats element : errorStatsServiceClient.listGroupStats(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   QueryTimeRange timeRange = QueryTimeRange.newBuilder().build();
   *   ListGroupStatsRequest request = ListGroupStatsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setTimeRange(timeRange)
   *     .build();
   *   RpcFuture&lt;ListGroupStatsPagedResponse&gt; future = errorStatsServiceClient.listGroupStatsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorGroupStats element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable() {
    return listGroupStatsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
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
    return listGroupStatsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   String groupId = "";
   *   for (ErrorEvent element : errorStatsServiceClient.listEvents(projectName, groupId).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param groupId [Required] The group for which events shall be returned.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setGroupId(groupId)
   *     .build();
   *   for (ErrorEvent element : errorStatsServiceClient.listEvents(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   String groupId = "";
   *   ListEventsRequest request = ListEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .setGroupId(groupId)
   *     .build();
   *   RpcFuture&lt;ListEventsPagedResponse&gt; future = errorStatsServiceClient.listEventsPagedCallable().futureCall(request);
   *   // Do something
   *   for (ErrorEvent element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
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
    return listEventsCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all error events of a given project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(projectName);
   * }
   * </code></pre>
   *
   * @param projectName [Required] The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .build();
   *   DeleteEventsResponse response = errorStatsServiceClient.deleteEvents(request);
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
   * <p>Sample code:
   *
   * <pre><code>
   * try (ErrorStatsServiceClient errorStatsServiceClient = ErrorStatsServiceClient.create()) {
   *   ProjectName projectName = ProjectName.create("[PROJECT]");
   *   DeleteEventsRequest request = DeleteEventsRequest.newBuilder()
   *     .setProjectNameWithProjectName(projectName)
   *     .build();
   *   RpcFuture&lt;DeleteEventsResponse&gt; future = errorStatsServiceClient.deleteEventsCallable().futureCall(request);
   *   // Do something
   *   DeleteEventsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
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
