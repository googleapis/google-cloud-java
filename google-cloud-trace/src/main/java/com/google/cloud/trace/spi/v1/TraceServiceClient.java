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
package com.google.cloud.trace.spi.v1;

import static com.google.cloud.trace.spi.v1.PagedResponseWrappers.ListTracesPagedResponse;

import com.google.api.gax.grpc.ChannelAndExecutor;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.devtools.cloudtrace.v1.GetTraceRequest;
import com.google.devtools.cloudtrace.v1.ListTracesRequest;
import com.google.devtools.cloudtrace.v1.ListTracesResponse;
import com.google.devtools.cloudtrace.v1.PatchTracesRequest;
import com.google.devtools.cloudtrace.v1.Trace;
import com.google.devtools.cloudtrace.v1.Traces;
import com.google.protobuf.Empty;
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
 * <pre>
 * <code>
 * InstantiatingChannelProvider channelProvider =
 *     TraceServiceSettings.defaultChannelProviderBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.defaultBuilder().setChannelProvider(channelProvider).build();
 * TraceServiceClient traceServiceClient =
 *     TraceServiceClient.create(traceServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC")
@ExperimentalApi
public class TraceServiceClient implements AutoCloseable {
  private final TraceServiceSettings settings;
  private final ScheduledExecutorService executor;
  private final ManagedChannel channel;
  private final List<AutoCloseable> closeables = new ArrayList<>();

  private final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable;
  private final UnaryCallable<GetTraceRequest, Trace> getTraceCallable;
  private final UnaryCallable<ListTracesRequest, ListTracesResponse> listTracesCallable;
  private final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable;

  /** Constructs an instance of TraceServiceClient with default settings. */
  public static final TraceServiceClient create() throws IOException {
    return create(TraceServiceSettings.defaultBuilder().build());
  }

  /**
   * Constructs an instance of TraceServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TraceServiceClient create(TraceServiceSettings settings) throws IOException {
    return new TraceServiceClient(settings);
  }

  /**
   * Constructs an instance of TraceServiceClient, using the given settings. This is protected so
   * that it easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TraceServiceClient(TraceServiceSettings settings) throws IOException {
    this.settings = settings;
    ChannelAndExecutor channelAndExecutor = settings.getChannelAndExecutor();
    this.executor = channelAndExecutor.getExecutor();
    this.channel = channelAndExecutor.getChannel();

    this.patchTracesCallable =
        UnaryCallable.create(settings.patchTracesSettings(), this.channel, this.executor);
    this.getTraceCallable =
        UnaryCallable.create(settings.getTraceSettings(), this.channel, this.executor);
    this.listTracesCallable =
        UnaryCallable.create(settings.listTracesSettings(), this.channel, this.executor);
    this.listTracesPagedCallable =
        UnaryCallable.createPagedVariant(
            settings.listTracesSettings(), this.channel, this.executor);

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

  public final TraceServiceSettings getSettings() {
    return settings;
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   RpcFuture&lt;Void&gt; future = traceServiceClient.patchTracesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchTracesRequest, Empty> patchTracesCallable() {
    return patchTracesCallable;
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
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   RpcFuture&lt;Trace&gt; future = traceServiceClient.getTraceCallable().futureCall(request);
   *   // Do something
   *   Trace response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetTraceRequest, Trace> getTraceCallable() {
    return getTraceCallable;
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
   *   for (Trace element : traceServiceClient.listTraces(projectId).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param projectId ID of the Cloud project where the trace data is stored.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   for (Trace element : traceServiceClient.listTraces(request).iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.grpc.ApiException if the remote call fails
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
   *   RpcFuture&lt;ListTracesPagedResponse&gt; future = traceServiceClient.listTracesPagedCallable().futureCall(request);
   *   // Do something
   *   for (Trace element : future.get().iterateAllElements()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListTracesRequest, ListTracesPagedResponse> listTracesPagedCallable() {
    return listTracesPagedCallable;
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
