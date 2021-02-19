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

package com.google.cloud.trace.v1;

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
import com.google.cloud.trace.v1.stub.TraceServiceStub;
import com.google.cloud.trace.v1.stub.TraceServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This file describes an API for collecting and viewing traces and spans
 * within a trace. A Trace is a collection of spans corresponding to a single operation or set of
 * operations for an application. A span is an individual timed event which forms a node of the
 * trace tree. Spans for a single trace may span multiple services.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
 *   String projectId = "projectId-894832108";
 *   String traceId = "traceId-1067401920";
 *   Trace response = traceServiceClient.getTrace(projectId, traceId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TraceServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of TraceServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TraceServiceClient traceServiceClient = TraceServiceClient.create(traceServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TraceServiceClient traceServiceClient = TraceServiceClient.create(traceServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TraceServiceClient implements BackgroundResource {
  private final TraceServiceSettings settings;
  private final TraceServiceStub stub;

  /** Constructs an instance of TraceServiceClient with default settings. */
  public static final TraceServiceClient create() throws IOException {
    return create(TraceServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TraceServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TraceServiceClient create(TraceServiceSettings settings) throws IOException {
    return new TraceServiceClient(settings);
  }

  /**
   * Constructs an instance of TraceServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TraceServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TraceServiceClient create(TraceServiceStub stub) {
    return new TraceServiceClient(stub);
  }

  /**
   * Constructs an instance of TraceServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TraceServiceClient(TraceServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TraceServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TraceServiceClient(TraceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TraceServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TraceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "projectId-894832108";
   *   for (Trace element : traceServiceClient.listTraces(projectId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param projectId Required. ID of the Cloud project where the trace data is stored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTracesPagedResponse listTraces(String projectId) {
    ListTracesRequest request = ListTracesRequest.newBuilder().setProjectId(projectId).build();
    return listTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   ListTracesRequest request =
   *       ListTracesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Trace element : traceServiceClient.listTraces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTracesPagedResponse listTraces(ListTracesRequest request) {
    return listTracesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   ListTracesRequest request =
   *       ListTracesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Trace> future = traceServiceClient.listTracesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Trace element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    return stub.listTracesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   while (true) {
   *     ListTracesResponse response = traceServiceClient.listTracesCallable().call(request);
   *     for (Trace element : response.getResponsesList()) {
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
  public final UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    return stub.listTracesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "projectId-894832108";
   *   String traceId = "traceId-1067401920";
   *   Trace response = traceServiceClient.getTrace(projectId, traceId);
   * }
   * }</pre>
   *
   * @param projectId Required. ID of the Cloud project where the trace data is stored.
   * @param traceId Required. ID of the trace to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trace getTrace(String projectId, String traceId) {
    GetTraceRequest request =
        GetTraceRequest.newBuilder().setProjectId(projectId).setTraceId(traceId).build();
    return getTrace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   GetTraceRequest request =
   *       GetTraceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setTraceId("traceId-1067401920")
   *           .build();
   *   Trace response = traceServiceClient.getTrace(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trace getTrace(GetTraceRequest request) {
    return getTraceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   GetTraceRequest request =
   *       GetTraceRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setTraceId("traceId-1067401920")
   *           .build();
   *   ApiFuture<Trace> future = traceServiceClient.getTraceCallable().futureCall(request);
   *   // Do something.
   *   Trace response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    return stub.getTraceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "projectId-894832108";
   *   Traces traces = Traces.newBuilder().build();
   *   traceServiceClient.patchTraces(projectId, traces);
   * }
   * }</pre>
   *
   * @param projectId Required. ID of the Cloud project where the trace data is stored.
   * @param traces Required. The body of the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void patchTraces(String projectId, Traces traces) {
    PatchTracesRequest request =
        PatchTracesRequest.newBuilder().setProjectId(projectId).setTraces(traces).build();
    patchTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   PatchTracesRequest request =
   *       PatchTracesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setTraces(Traces.newBuilder().build())
   *           .build();
   *   traceServiceClient.patchTraces(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void patchTraces(PatchTracesRequest request) {
    patchTracesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   PatchTracesRequest request =
   *       PatchTracesRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setTraces(Traces.newBuilder().build())
   *           .build();
   *   ApiFuture<Empty> future = traceServiceClient.patchTracesCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return stub.patchTracesCallable();
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

  public static class ListTracesPagedResponse
      extends AbstractPagedListResponse<
          ListTracesRequest,
          ListTracesResponse,
          Trace,
          ListTracesPage,
          ListTracesFixedSizeCollection> {

    public static ApiFuture<ListTracesPagedResponse> createAsync(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ApiFuture<ListTracesResponse> futureResponse) {
      ApiFuture<ListTracesPage> futurePage =
          ListTracesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTracesPage, ListTracesPagedResponse>() {
            @Override
            public ListTracesPagedResponse apply(ListTracesPage input) {
              return new ListTracesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTracesPagedResponse(ListTracesPage page) {
      super(page, ListTracesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTracesPage
      extends AbstractPage<ListTracesRequest, ListTracesResponse, Trace, ListTracesPage> {

    private ListTracesPage(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ListTracesResponse response) {
      super(context, response);
    }

    private static ListTracesPage createEmptyPage() {
      return new ListTracesPage(null, null);
    }

    @Override
    protected ListTracesPage createPage(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ListTracesResponse response) {
      return new ListTracesPage(context, response);
    }

    @Override
    public ApiFuture<ListTracesPage> createPageAsync(
        PageContext<ListTracesRequest, ListTracesResponse, Trace> context,
        ApiFuture<ListTracesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTracesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTracesRequest,
          ListTracesResponse,
          Trace,
          ListTracesPage,
          ListTracesFixedSizeCollection> {

    private ListTracesFixedSizeCollection(List<ListTracesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTracesFixedSizeCollection createEmptyCollection() {
      return new ListTracesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTracesFixedSizeCollection createCollection(
        List<ListTracesPage> pages, int collectionSize) {
      return new ListTracesFixedSizeCollection(pages, collectionSize);
    }
  }
}
