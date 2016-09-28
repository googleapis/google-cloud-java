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
package com.google.cloud.trace.spi.v1;

import com.google.api.gax.core.PagedListResponse;
import com.google.api.gax.grpc.ApiCallable;
import com.google.api.gax.protobuf.PathTemplate;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: This file describes an API for collecting and viewing traces and spans
 * within a trace.  A Trace is a collection of spans corresponding to a single
 * operation or set of operations for an application. A span is an individual
 * timed event which forms a node of the trace tree. Spans for a single trace
 * may span multiple services.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
 *   String projectId = "";
 *   Traces traces = Traces.newBuilder().build();
 *   traceServiceApi.patchTraces(projectId, traces);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the traceServiceApi object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of TraceServiceSettings to
 * create(). For example:
 *
 * <pre>
 * <code>
 * TraceServiceSettings traceServiceSettings = TraceServiceSettings.defaultBuilder()
 *     .provideChannelWith(myCredentials)
 *     .build();
 * TraceServiceApi traceServiceApi = TraceServiceApi.create(traceServiceSettings);
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class TraceServiceApi implements AutoCloseable {
  private final TraceServiceSettings settings;
  private final ManagedChannel channel;
  private final ScheduledExecutorService executor;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final ApiCallable<PatchTracesRequest, Empty> patchTracesCallable;
  private final ApiCallable<GetTraceRequest, Trace> getTraceCallable;
  private final ApiCallable<ListTracesRequest, ListTracesResponse> listTracesCallable;
  private final ApiCallable<
          ListTracesRequest, PagedListResponse<ListTracesRequest, ListTracesResponse, Trace>>
      listTracesPagedCallable;

  public final TraceServiceSettings getSettings() {
    return settings;
  }

  /**
   * Constructs an instance of TraceServiceApi with default settings.
   */
  public static final TraceServiceApi create() throws IOException {
    return create(TraceServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of TraceServiceApi, using the given settings.
   * The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final TraceServiceApi create(TraceServiceSettings settings) throws IOException {
    return new TraceServiceApi(settings);
  }

  /**
   * Constructs an instance of TraceServiceApi, using the given settings.
   * This is protected so that it easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected TraceServiceApi(TraceServiceSettings settings) throws IOException {
    this.settings = settings;
    this.executor = settings.getExecutorProvider().getOrBuildExecutor();
    this.channel = settings.getChannelProvider().getOrBuildChannel(this.executor);

    this.patchTracesCallable =
        ApiCallable.create(settings.patchTracesSettings(), this.channel, this.executor);
    this.getTraceCallable =
        ApiCallable.create(settings.getTraceSettings(), this.channel, this.executor);
    this.listTracesCallable =
        ApiCallable.create(settings.listTracesSettings(), this.channel, this.executor);
    this.listTracesPagedCallable =
        ApiCallable.createPagedVariant(settings.listTracesSettings(), this.channel, this.executor);

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
   * Sends new traces to Cloud Trace or updates existing traces. If the ID of
   * a trace that you send matches that of an existing trace, any fields
   * in the existing trace and its spans are overwritten by the provided values,
   * and any new fields provided are merged with the existing trace data. If the
   * ID does not match, a new trace is created.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   traceServiceApi.patchTraces(projectId, traces);
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @param traces The body of the message.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void patchTraces(String projectId, Traces traces) {
    PatchTracesRequest request =
        PatchTracesRequest.newBuilder().setProjectId(projectId).setTraces(traces).build();
    patchTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sends new traces to Cloud Trace or updates existing traces. If the ID of
   * a trace that you send matches that of an existing trace, any fields
   * in the existing trace and its spans are overwritten by the provided values,
   * and any new fields provided are merged with the existing trace data. If the
   * ID does not match, a new trace is created.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   PatchTracesRequest request = PatchTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraces(traces)
   *     .build();
   *   traceServiceApi.patchTraces(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final void patchTraces(PatchTracesRequest request) {
    patchTracesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Sends new traces to Cloud Trace or updates existing traces. If the ID of
   * a trace that you send matches that of an existing trace, any fields
   * in the existing trace and its spans are overwritten by the provided values,
   * and any new fields provided are merged with the existing trace data. If the
   * ID does not match, a new trace is created.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   Traces traces = Traces.newBuilder().build();
   *   PatchTracesRequest request = PatchTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraces(traces)
   *     .build();
   *   ListenableFuture&lt;Void&gt; future = traceServiceApi.patchTracesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return patchTracesCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single trace by its ID.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   Trace response = traceServiceApi.getTrace(projectId, traceId);
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @param traceId ID of the trace to return.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   GetTraceRequest request = GetTraceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraceId(traceId)
   *     .build();
   *   Trace response = traceServiceApi.getTrace(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  private final Trace getTrace(GetTraceRequest request) {
    return getTraceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a single trace by its ID.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   String traceId = "";
   *   GetTraceRequest request = GetTraceRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .setTraceId(traceId)
   *     .build();
   *   ListenableFuture&lt;Trace&gt; future = traceServiceApi.getTraceCallable().futureCall(request);
   *   // Do something
   *   Trace response = future.get();
   * }
   * </code></pre>
   */
  public final ApiCallable<GetTraceRequest, Trace> getTraceCallable() {
    return getTraceCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   for (Trace element : traceServiceApi.listTraces(projectId).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<ListTracesRequest, ListTracesResponse, Trace> listTraces(
      String projectId) {
    ListTracesRequest request = ListTracesRequest.newBuilder().setProjectId(projectId).build();
    return listTraces(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   for (Trace element : traceServiceApi.listTraces(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
   */
  public final PagedListResponse<ListTracesRequest, ListTracesResponse, Trace> listTraces(
      ListTracesRequest request) {
    return listTracesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   ListenableFuture&lt;PagedListResponse&lt;ListTracesRequest,ListTracesResponse,Trace&gt;&gt; future = traceServiceApi.listTracesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Trace element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final ApiCallable<
          ListTracesRequest, PagedListResponse<ListTracesRequest, ListTracesResponse, Trace>>
      listTracesPagedCallable() {
    return listTracesPagedCallable;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns of a list of traces that match the specified filter conditions.
   *
   * Sample code:
   * <pre><code>
   * try (TraceServiceApi traceServiceApi = TraceServiceApi.create()) {
   *   String projectId = "";
   *   ListTracesRequest request = ListTracesRequest.newBuilder()
   *     .setProjectId(projectId)
   *     .build();
   *   while (true) {
   *     ListTracesResponse response = traceServiceApi.listTracesCallable().call(request);
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
  public final ApiCallable<ListTracesRequest, ListTracesResponse> listTracesCallable() {
    return listTracesCallable;
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
