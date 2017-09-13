/*
 * Copyright 2017, Google Inc. All rights reserved.
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
package com.google.cloud.trace.v1;

import static com.google.cloud.trace.v1.PagedResponseWrappers.ListTracesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.trace.v1.stub.TraceServiceStub;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: This file describes an API for collecting and viewing traces and spans
 * within a trace. A Trace is a collection of spans corresponding to a single operation or set of
 * operations for an application. A span is an individual timed event which forms a node of the
 * trace tree. Spans for a single trace may span multiple services.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
 *   String projectId = "";
 *   Traces traces = Traces.newBuilder().build();
 *   traceServiceClient.patchTraces(projectId, traces);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the traceServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of TraceServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TraceServiceClient traceServiceClient =
 *     TraceServiceClient.create(traceServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.newBuilder()
 *         .setTransportProvider(TraceServiceSettings.defaultGrpcTransportProviderBuilder()
 *             .setChannelProvider(TraceServiceSettings.defaultGrpcChannelProviderBuilder()
 *                 .setEndpoint(myEndpoint)
 *                 .build())
 *             .build())
 *         .build();
 * TraceServiceClient traceServiceClient =
 *     TraceServiceClient.create(traceServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
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
   * for advanced usage - prefer to use TraceServiceSettings}.
   */
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
    this.stub = settings.createStub();
  }

  protected TraceServiceClient(TraceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TraceServiceSettings getSettings() {
    return settings;
  }

  @BetaApi
  public TraceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   traceServiceClient.patchTraces(projectId, traces);
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @param traces The body of the message.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void patchTraces(String projectId, Traces traces) {

    PatchTracesRequest request =
        PatchTracesRequest.newBuilder().setProjectId(projectId).setTraces(traces).build();
    patchTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   PatchTracesRequest request = PatchTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraces(traces)
   *     .build();
   *   traceServiceClient.patchTraces(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void patchTraces(PatchTracesRequest request) {
    patchTracesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sends new traces to Stackdriver Trace or updates existing traces. If the ID of a trace that you
   * send matches that of an existing trace, any fields in the existing trace and its spans are
   * overwritten by the provided values, and any new fields provided are merged with the existing
   * trace data. If the ID does not match, a new trace is created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   PatchTracesRequest request = PatchTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraces(traces)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = traceServiceClient.patchTracesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return stub.patchTracesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   Trace response = traceServiceClient.getTrace(projectId, traceId);
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @param traceId ID of the trace to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trace getTrace(String projectId, String traceId) {

    GetTraceRequest request =
        GetTraceRequest.newBuilder().setProjectId(projectId).setTraceId(traceId).build();
    return getTrace(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   GetTraceRequest request = GetTraceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraceId(traceId)
   *     .build();
   *   Trace response = traceServiceClient.getTrace(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Trace getTrace(GetTraceRequest request) {
    return getTraceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single trace by its ID.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   GetTraceRequest request = GetTraceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraceId(traceId)
   *     .build();
   *   ApiFuture&lt;Trace&gt; future = traceServiceClient.getTraceCallable().futureCall(request);
   *   // Do something
   *   Trace response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    return stub.getTraceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   for (Trace element : traceServiceClient.listTraces(projectId).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTracesPagedResponse listTraces(String projectId) {
    ListTracesRequest request = ListTracesRequest.newBuilder().setProjectId(projectId).build();
    return listTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   for (Trace element : traceServiceClient.listTraces(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTracesPagedResponse listTraces(ListTracesRequest request) {
    return listTracesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ApiFuture&lt;ListTracesPagedResponse&gt; future = traceServiceClient.listTracesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Trace element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    return stub.listTracesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   while (true) {
   *     ListTracesResponse response = traceServiceClient.listTracesCallable().call(request);
   *     for (Trace element : response.getTracesList()) {
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
  public final UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    return stub.listTracesCallable();
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
