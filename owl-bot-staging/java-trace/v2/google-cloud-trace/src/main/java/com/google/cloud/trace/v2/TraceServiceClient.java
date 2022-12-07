/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.trace.v2;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.trace.v2.stub.TraceServiceStub;
import com.google.cloud.trace.v2.stub.TraceServiceStubSettings;
import com.google.devtools.cloudtrace.v2.BatchWriteSpansRequest;
import com.google.devtools.cloudtrace.v2.ProjectName;
import com.google.devtools.cloudtrace.v2.Span;
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
 * trace tree. A single trace may contain span(s) from multiple services.
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
 * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   List<Span> spans = new ArrayList<>();
 *   traceServiceClient.batchWriteSpans(name, spans);
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TraceServiceSettings traceServiceSettings =
 *     TraceServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TraceServiceClient traceServiceClient = TraceServiceClient.create(traceServiceSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TraceServiceSettings traceServiceSettings = TraceServiceSettings.newHttpJsonBuilder().build();
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

  protected TraceServiceClient(TraceServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TraceServiceSettings getSettings() {
    return settings;
  }

  public TraceServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new spans to new or existing traces. You cannot update existing spans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   List<Span> spans = new ArrayList<>();
   *   traceServiceClient.batchWriteSpans(name, spans);
   * }
   * }</pre>
   *
   * @param name Required. The name of the project where the spans belong. The format is
   *     `projects/[PROJECT_ID]`.
   * @param spans Required. A list of new spans. The span names must not match existing spans, or
   *     the results are undefined.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchWriteSpans(ProjectName name, List<Span> spans) {
    BatchWriteSpansRequest request =
        BatchWriteSpansRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .addAllSpans(spans)
            .build();
    batchWriteSpans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new spans to new or existing traces. You cannot update existing spans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   List<Span> spans = new ArrayList<>();
   *   traceServiceClient.batchWriteSpans(name, spans);
   * }
   * }</pre>
   *
   * @param name Required. The name of the project where the spans belong. The format is
   *     `projects/[PROJECT_ID]`.
   * @param spans Required. A list of new spans. The span names must not match existing spans, or
   *     the results are undefined.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchWriteSpans(String name, List<Span> spans) {
    BatchWriteSpansRequest request =
        BatchWriteSpansRequest.newBuilder().setName(name).addAllSpans(spans).build();
    batchWriteSpans(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new spans to new or existing traces. You cannot update existing spans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   BatchWriteSpansRequest request =
   *       BatchWriteSpansRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .addAllSpans(new ArrayList<Span>())
   *           .build();
   *   traceServiceClient.batchWriteSpans(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchWriteSpans(BatchWriteSpansRequest request) {
    batchWriteSpansCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sends new spans to new or existing traces. You cannot update existing spans.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   BatchWriteSpansRequest request =
   *       BatchWriteSpansRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .addAllSpans(new ArrayList<Span>())
   *           .build();
   *   ApiFuture<Empty> future = traceServiceClient.batchWriteSpansCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchWriteSpansRequest, Empty> batchWriteSpansCallable() {
    return stub.batchWriteSpansCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new span.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   Span request =
   *       Span.newBuilder()
   *           .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
   *           .setSpanId("spanId-896182779")
   *           .setParentSpanId("parentSpanId1059234639")
   *           .setDisplayName(TruncatableString.newBuilder().build())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setAttributes(Span.Attributes.newBuilder().build())
   *           .setStackTrace(StackTrace.newBuilder().build())
   *           .setTimeEvents(Span.TimeEvents.newBuilder().build())
   *           .setLinks(Span.Links.newBuilder().build())
   *           .setStatus(Status.newBuilder().build())
   *           .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
   *           .setChildSpanCount(Int32Value.newBuilder().build())
   *           .build();
   *   Span response = traceServiceClient.createSpan(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Span createSpan(Span request) {
    return createSpanCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new span.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TraceServiceClient traceServiceClient = TraceServiceClient.create()) {
   *   Span request =
   *       Span.newBuilder()
   *           .setName(SpanName.of("[PROJECT]", "[TRACE]", "[SPAN]").toString())
   *           .setSpanId("spanId-896182779")
   *           .setParentSpanId("parentSpanId1059234639")
   *           .setDisplayName(TruncatableString.newBuilder().build())
   *           .setStartTime(Timestamp.newBuilder().build())
   *           .setEndTime(Timestamp.newBuilder().build())
   *           .setAttributes(Span.Attributes.newBuilder().build())
   *           .setStackTrace(StackTrace.newBuilder().build())
   *           .setTimeEvents(Span.TimeEvents.newBuilder().build())
   *           .setLinks(Span.Links.newBuilder().build())
   *           .setStatus(Status.newBuilder().build())
   *           .setSameProcessAsParentSpan(BoolValue.newBuilder().build())
   *           .setChildSpanCount(Int32Value.newBuilder().build())
   *           .build();
   *   ApiFuture<Span> future = traceServiceClient.createSpanCallable().futureCall(request);
   *   // Do something.
   *   Span response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<Span, Span> createSpanCallable() {
    return stub.createSpanCallable();
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
}
