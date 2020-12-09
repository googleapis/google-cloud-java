/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.errorreporting.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.stub.ErrorStatsServiceStub;
import com.google.cloud.errorreporting.v1beta1.stub.ErrorStatsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorEvent;
import com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupStats;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.QueryTimeRange;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: An API for retrieving and managing error statistics as well as data for
 * individual events.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the ErrorStatsServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
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
 * <pre>{@code
 * ErrorStatsServiceSettings errorStatsServiceSettings =
 *     ErrorStatsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ErrorStatsServiceClient errorStatsServiceClient =
 *     ErrorStatsServiceClient.create(errorStatsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ErrorStatsServiceSettings errorStatsServiceSettings =
 *     ErrorStatsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ErrorStatsServiceClient errorStatsServiceClient =
 *     ErrorStatsServiceClient.create(errorStatsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
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
   * is for advanced usage - prefer using create(ErrorStatsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.stub = ((ErrorStatsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ErrorStatsServiceClient(ErrorStatsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ErrorStatsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ErrorStatsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified groups.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as &lt;code&gt;projects/&lt;/code&gt; plus the &lt;a
   *     href="https://support.google.com/cloud/answer/6158840"&gt;Google Cloud Platform project
   *     ID&lt;/a&gt;.
   *     <p>Example: &lt;code&gt;projects/my-project-123&lt;/code&gt;.
   * @param time_range Optional. List data for the given time range. If not set, a default time
   *     range is used. The field &lt;code&gt;time_range_begin&lt;/code&gt; in the response will
   *     specify the beginning of this time range. Only &lt;code&gt;ErrorGroupStats&lt;/code&gt;
   *     with a non-zero count in the given time range are returned, unless the request contains an
   *     explicit &lt;code&gt;group_id&lt;/code&gt; list. If a &lt;code&gt;group_id&lt;/code&gt;
   *     list is given, also &lt;code&gt;ErrorGroupStats&lt;/code&gt; with zero occurrences are
   *     returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupStatsPagedResponse listGroupStats(
      ProjectName projectName, QueryTimeRange timeRange) {
    ListGroupStatsRequest request =
        ListGroupStatsRequest.newBuilder()
            .setProjectName(projectName == null ? null : projectName.toString())
            .setTimeRange(timeRange)
            .build();
    return listGroupStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified groups.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as &lt;code&gt;projects/&lt;/code&gt; plus the &lt;a
   *     href="https://support.google.com/cloud/answer/6158840"&gt;Google Cloud Platform project
   *     ID&lt;/a&gt;.
   *     <p>Example: &lt;code&gt;projects/my-project-123&lt;/code&gt;.
   * @param time_range Optional. List data for the given time range. If not set, a default time
   *     range is used. The field &lt;code&gt;time_range_begin&lt;/code&gt; in the response will
   *     specify the beginning of this time range. Only &lt;code&gt;ErrorGroupStats&lt;/code&gt;
   *     with a non-zero count in the given time range are returned, unless the request contains an
   *     explicit &lt;code&gt;group_id&lt;/code&gt; list. If a &lt;code&gt;group_id&lt;/code&gt;
   *     list is given, also &lt;code&gt;ErrorGroupStats&lt;/code&gt; with zero occurrences are
   *     returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupStatsPagedResponse listGroupStats(
      String projectName, QueryTimeRange timeRange) {
    ListGroupStatsRequest request =
        ListGroupStatsRequest.newBuilder()
            .setProjectName(projectName)
            .setTimeRange(timeRange)
            .build();
    return listGroupStats(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified groups.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGroupStatsPagedResponse listGroupStats(ListGroupStatsRequest request) {
    return listGroupStatsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable() {
    return stub.listGroupStatsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified groups.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse>
      listGroupStatsCallable() {
    return stub.listGroupStatsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified events.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param group_id Required. The group for which events shall be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ProjectName projectName, String groupId) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder()
            .setProjectName(projectName == null ? null : projectName.toString())
            .setGroupId(groupId)
            .build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified events.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param group_id Required. The group for which events shall be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(String projectName, String groupId) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setProjectName(projectName).setGroupId(groupId).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified events.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return stub.listEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the specified events.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return stub.listEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all error events of a given project.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteEventsResponse deleteEvents(ProjectName projectName) {
    DeleteEventsRequest request =
        DeleteEventsRequest.newBuilder()
            .setProjectName(projectName == null ? null : projectName.toString())
            .build();
    return deleteEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all error events of a given project.
   *
   * @param project_name Required. The resource name of the Google Cloud Platform project. Written
   *     as `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteEventsResponse deleteEvents(String projectName) {
    DeleteEventsRequest request =
        DeleteEventsRequest.newBuilder().setProjectName(projectName).build();
    return deleteEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all error events of a given project.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DeleteEventsResponse deleteEvents(DeleteEventsRequest request) {
    return deleteEventsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes all error events of a given project.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
    return stub.deleteEventsCallable();
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

  public static class ListGroupStatsPagedResponse
      extends AbstractPagedListResponse<
          ListGroupStatsRequest,
          ListGroupStatsResponse,
          ErrorGroupStats,
          ListGroupStatsPage,
          ListGroupStatsFixedSizeCollection> {

    public static ApiFuture<ListGroupStatsPagedResponse> createAsync(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ApiFuture<ListGroupStatsResponse> futureResponse) {
      ApiFuture<ListGroupStatsPage> futurePage =
          ListGroupStatsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListGroupStatsPage, ListGroupStatsPagedResponse>() {
            @Override
            public ListGroupStatsPagedResponse apply(ListGroupStatsPage input) {
              return new ListGroupStatsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListGroupStatsPagedResponse(ListGroupStatsPage page) {
      super(page, ListGroupStatsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGroupStatsPage
      extends AbstractPage<
          ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats, ListGroupStatsPage> {

    private ListGroupStatsPage(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ListGroupStatsResponse response) {
      super(context, response);
    }

    private static ListGroupStatsPage createEmptyPage() {
      return new ListGroupStatsPage(null, null);
    }

    @Override
    protected ListGroupStatsPage createPage(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ListGroupStatsResponse response) {
      return new ListGroupStatsPage(context, response);
    }

    @Override
    public ApiFuture<ListGroupStatsPage> createPageAsync(
        PageContext<ListGroupStatsRequest, ListGroupStatsResponse, ErrorGroupStats> context,
        ApiFuture<ListGroupStatsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGroupStatsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGroupStatsRequest,
          ListGroupStatsResponse,
          ErrorGroupStats,
          ListGroupStatsPage,
          ListGroupStatsFixedSizeCollection> {

    private ListGroupStatsFixedSizeCollection(List<ListGroupStatsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGroupStatsFixedSizeCollection createEmptyCollection() {
      return new ListGroupStatsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGroupStatsFixedSizeCollection createCollection(
        List<ListGroupStatsPage> pages, int collectionSize) {
      return new ListGroupStatsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEventsPagedResponse
      extends AbstractPagedListResponse<
          ListEventsRequest,
          ListEventsResponse,
          ErrorEvent,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    public static ApiFuture<ListEventsPagedResponse> createAsync(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      ApiFuture<ListEventsPage> futurePage =
          ListEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEventsPage, ListEventsPagedResponse>() {
            @Override
            public ListEventsPagedResponse apply(ListEventsPage input) {
              return new ListEventsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEventsPagedResponse(ListEventsPage page) {
      super(page, ListEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventsPage
      extends AbstractPage<ListEventsRequest, ListEventsResponse, ErrorEvent, ListEventsPage> {

    private ListEventsPage(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ListEventsResponse response) {
      super(context, response);
    }

    private static ListEventsPage createEmptyPage() {
      return new ListEventsPage(null, null);
    }

    @Override
    protected ListEventsPage createPage(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ListEventsResponse response) {
      return new ListEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListEventsPage> createPageAsync(
        PageContext<ListEventsRequest, ListEventsResponse, ErrorEvent> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventsRequest,
          ListEventsResponse,
          ErrorEvent,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    private ListEventsFixedSizeCollection(List<ListEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventsFixedSizeCollection createEmptyCollection() {
      return new ListEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventsFixedSizeCollection createCollection(
        List<ListEventsPage> pages, int collectionSize) {
      return new ListEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
