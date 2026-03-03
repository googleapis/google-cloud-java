/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import com.google.api.core.InternalApi;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientStreamingCallable;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedBatchingCallable;
import com.google.api.gax.tracing.TracedBidiCallable;
import com.google.api.gax.tracing.TracedClientStreamingCallable;
import com.google.api.gax.tracing.TracedOperationCallable;
import com.google.api.gax.tracing.TracedOperationInitialCallable;
import com.google.api.gax.tracing.TracedServerStreamingCallable;
import com.google.api.gax.tracing.TracedUnaryCallable;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import io.grpc.MethodDescriptor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/** Class with utility methods to create grpc-based direct callables. */
public class GrpcCallableFactory {
  // Used to extract service and method name from a grpc MethodDescriptor.
  private static final Pattern FULL_METHOD_NAME_REGEX = Pattern.compile("^.*?([^./]+)/([^./]+)$");

  private GrpcCallableFactory() {}

  /**
   * Create a Unary callable object with minimal grpc-specific functionality.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param callSettings the Unary call settings
   * @param clientContext {@link ClientContext} to use to connect to the service.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBaseUnaryCallable(
      GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable =
        GrpcRawCallableFactory.createUnaryCallable(
            grpcCallSettings, callSettings.getRetryableCodes());

    if (grpcCallSettings.getRequestMutator() != null) {
      callable =
          Callables.retrying(
              callable, callSettings, clientContext, grpcCallSettings.getRequestMutator());
    } else {
      callable = Callables.retrying(callable, callSettings, clientContext);
    }

    return callable;
  }

  /**
   * Create a callable object with grpc-specific functionality. Designed for use by generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
      UnaryCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable =
        createBaseUnaryCallable(grpcCallSettings, callSettings, clientContext);

    callable =
        new TracedUnaryCallable<>(
            callable,
            clientContext.getTracerFactory(),
            getSpanName(grpcCallSettings.getMethodDescriptor()));

    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a paged callable object that represents a paged API method. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param pagedCallSettings {@link PagedCallSettings} to configure the paged settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT, PagedListResponseT>
      UnaryCallable<RequestT, PagedListResponseT> createPagedCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          PagedCallSettings<RequestT, ResponseT, PagedListResponseT> pagedCallSettings,
          ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> innerCallable =
        createBaseUnaryCallable(grpcCallSettings, pagedCallSettings, clientContext);
    UnaryCallable<RequestT, PagedListResponseT> pagedCallable =
        Callables.paged(innerCallable, pagedCallSettings);
    return pagedCallable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a callable object that represents a batching API method. Designed for use by generated
   * code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param batchingCallSettings {@link BatchingCallSettings} to configure the batching related
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBatchingCallable(
      GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> baseCallable =
        createBaseUnaryCallable(grpcCallSettings, batchingCallSettings, clientContext);

    // NOTE: Since batching happens asynchronously and the outermost callable simply buffers the
    // request. Tracing will only start on the inner callable that accepts the batch.
    UnaryCallable<RequestT, ResponseT> tracedCallable =
        new TracedBatchingCallable<>(
            baseCallable,
            clientContext.getTracerFactory(),
            getSpanName(grpcCallSettings.getMethodDescriptor()),
            batchingCallSettings.getBatchingDescriptor());

    UnaryCallable<RequestT, ResponseT> batchingCallable =
        Callables.batching(tracedCallable, batchingCallSettings, clientContext);
    return batchingCallable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Creates a callable object that represents a long-running operation. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param operationCallSettings {@link OperationCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @param operationsStub {@link OperationsStub} to use to poll for updates on the Operation.
   * @return {@link com.google.api.gax.rpc.OperationCallable} callable object.
   */
  public static <RequestT, ResponseT, MetadataT>
      OperationCallable<RequestT, ResponseT, MetadataT> createOperationCallable(
          GrpcCallSettings<RequestT, Operation> grpcCallSettings,
          OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings,
          ClientContext clientContext,
          OperationsStub operationsStub) {

    SpanName initialSpanName = getSpanName(grpcCallSettings.getMethodDescriptor());
    SpanName operationSpanName =
        SpanName.of(initialSpanName.getClientName(), initialSpanName.getMethodName() + "Operation");

    UnaryCallable<RequestT, Operation> initialGrpcCallable =
        createBaseUnaryCallable(
            grpcCallSettings, operationCallSettings.getInitialCallSettings(), clientContext);
    UnaryCallable<RequestT, OperationSnapshot> initialCallable =
        new GrpcOperationSnapshotCallable<>(initialGrpcCallable);

    // Create a sub-trace for the initial RPC that starts the operation.
    UnaryCallable<RequestT, OperationSnapshot> tracedInitialCallable =
        new TracedOperationInitialCallable<>(
            initialCallable, clientContext.getTracerFactory(), initialSpanName);

    LongRunningClient longRunningClient = new GrpcLongRunningClient(operationsStub);
    OperationCallable<RequestT, ResponseT, MetadataT> operationCallable =
        Callables.longRunningOperation(
            tracedInitialCallable, operationCallSettings, clientContext, longRunningClient);

    OperationCallable<RequestT, ResponseT, MetadataT> tracedOperationCallable =
        new TracedOperationCallable<>(
            operationCallable, clientContext.getTracerFactory(), operationSpanName);

    return tracedOperationCallable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a bidirectional streaming callable object with grpc-specific functionality. Designed for
   * use by generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param streamingCallSettings {@link StreamingCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link BidiStreamingCallable} callable object.
   */
  public static <RequestT, ResponseT>
      BidiStreamingCallable<RequestT, ResponseT> createBidiStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          StreamingCallSettings<RequestT, ResponseT> streamingCallSettings,
          ClientContext clientContext) {
    BidiStreamingCallable<RequestT, ResponseT> callable =
        GrpcRawCallableFactory.createBidiStreamingCallable(
            grpcCallSettings, ImmutableSet.<StatusCode.Code>of());

    callable =
        new TracedBidiCallable<>(
            callable,
            clientContext.getTracerFactory(),
            getSpanName(grpcCallSettings.getMethodDescriptor()));

    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a server-streaming callable with grpc-specific functionality. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param streamingCallSettings {@link StreamingCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @deprecated Please use ServerStreamingCallSettings
   */
  @Deprecated
  public static <RequestT, ResponseT>
      ServerStreamingCallable<RequestT, ResponseT> createServerStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          StreamingCallSettings<RequestT, ResponseT> streamingCallSettings,
          ClientContext clientContext) {

    // up convert to new settings
    ServerStreamingCallSettings<RequestT, ResponseT> serverStreamingCallSettings =
        ServerStreamingCallSettings.<RequestT, ResponseT>newBuilder().build();

    return createServerStreamingCallable(
        grpcCallSettings, serverStreamingCallSettings, clientContext);
  }

  /**
   * Create a server-streaming callable with grpc-specific functionality. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param streamingCallSettings {@link StreamingCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   */
  public static <RequestT, ResponseT>
      ServerStreamingCallable<RequestT, ResponseT> createServerStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          ServerStreamingCallSettings<RequestT, ResponseT> streamingCallSettings,
          ClientContext clientContext) {
    ServerStreamingCallable<RequestT, ResponseT> callable =
        GrpcRawCallableFactory.createServerStreamingCallable(
            grpcCallSettings, streamingCallSettings.getRetryableCodes());

    if (clientContext.getStreamWatchdog() != null) {
      callable = Callables.watched(callable, streamingCallSettings, clientContext);
    }

    callable = Callables.retrying(callable, streamingCallSettings, clientContext);

    callable =
        new TracedServerStreamingCallable<>(
            callable,
            clientContext.getTracerFactory(),
            getSpanName(grpcCallSettings.getMethodDescriptor()));

    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a client-streaming callable object with grpc-specific functionality. Designed for use by
   * generated code.
   *
   * @param grpcCallSettings the gRPC call settings
   * @param streamingCallSettings {@link StreamingCallSettings} to configure the method-level
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link ClientStreamingCallable} callable object.
   */
  public static <RequestT, ResponseT>
      ClientStreamingCallable<RequestT, ResponseT> createClientStreamingCallable(
          GrpcCallSettings<RequestT, ResponseT> grpcCallSettings,
          StreamingCallSettings<RequestT, ResponseT> streamingCallSettings,
          ClientContext clientContext) {
    ClientStreamingCallable<RequestT, ResponseT> callable =
        GrpcRawCallableFactory.createClientStreamingCallable(
            grpcCallSettings, ImmutableSet.<StatusCode.Code>of());

    callable =
        new TracedClientStreamingCallable<>(
            callable,
            clientContext.getTracerFactory(),
            getSpanName(grpcCallSettings.getMethodDescriptor()));

    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  @InternalApi("Visible for testing")
  static SpanName getSpanName(@Nonnull MethodDescriptor<?, ?> methodDescriptor) {
    Matcher matcher = FULL_METHOD_NAME_REGEX.matcher(methodDescriptor.getFullMethodName());

    Preconditions.checkArgument(matcher.matches(), "Invalid fullMethodName");
    return SpanName.of(matcher.group(1), matcher.group(2));
  }
}
