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
package com.google.api.gax.httpjson;

import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.Callables;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LongRunningClient;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.SpanName;
import com.google.api.gax.tracing.TracedUnaryCallable;
import com.google.common.base.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/** Class with utility methods to create http/json-based direct callables. */
public class HttpJsonCallableFactory {
  // Used to extract service and method name from a grpc MethodDescriptor.
  // fullMethodName has the format: service.resource.action
  // For example: compute.instances.addAccessConfig
  private static final Pattern FULL_METHOD_NAME_REGEX = Pattern.compile("^(.+)\\.(.+)$");

  private HttpJsonCallableFactory() {}

  private static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createDirectUnaryCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings) {
    UnaryCallable<RequestT, ResponseT> callable =
        new HttpJsonDirectCallable<>(
            httpJsonCallSettings.getMethodDescriptor(), httpJsonCallSettings.getTypeRegistry());

    if (httpJsonCallSettings.getParamsExtractor() != null) {
      callable =
          new HttpJsonUnaryRequestParamCallable<>(
              callable, httpJsonCallSettings.getParamsExtractor());
    }
    return callable;
  }

  /** Create httpJson UnaryCallable with request mutator. */
  static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      UnaryCallSettings<?, ?> callSettings,
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable =
        new HttpJsonExceptionCallable<>(innerCallable, callSettings.getRetryableCodes());
    callable =
        Callables.retrying(
            callable, callSettings, clientContext, httpJsonCallSettings.getRequestMutator());
    callable =
        new TracedUnaryCallable<>(
            callable,
            clientContext.getTracerFactory(),
            getSpanName(httpJsonCallSettings.getMethodDescriptor()));
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /** Use {@link #createUnaryCallable createUnaryCallable} method instead. */
  @ObsoleteApi("Please use other httpJson UnaryCallable method instead")
  static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      UnaryCallable<RequestT, ResponseT> innerCallable,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable =
        new HttpJsonExceptionCallable<>(innerCallable, callSettings.getRetryableCodes());
    callable = Callables.retrying(callable, callSettings, clientContext);
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a Unary callable object with minimal http/json-specific functionality. Designed for use
   * by generated code.
   *
   * @param httpJsonCallSettings the gRPC call settings
   * @param callSettings the unary call settings
   * @param clientContext {@link ClientContext} to use to connect to the service.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBaseUnaryCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      UnaryCallSettings<?, ?> callSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable = createDirectUnaryCallable(httpJsonCallSettings);
    callable = new HttpJsonExceptionCallable<>(callable, callSettings.getRetryableCodes());
    callable =
        Callables.retrying(
            callable, callSettings, clientContext, httpJsonCallSettings.getRequestMutator());

    return callable;
  }

  /**
   * Create a callable object with http/json-specific functionality. Designed for use by generated
   * code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param callSettings {@link UnaryCallSettings} to configure the method-level settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createUnaryCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      UnaryCallSettings<RequestT, ResponseT> callSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> innerCallable =
        createDirectUnaryCallable(httpJsonCallSettings);

    return createUnaryCallable(innerCallable, callSettings, httpJsonCallSettings, clientContext);
  }

  /**
   * Create a paged callable object that represents a paged API method. Designed for use by
   * generated code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param pagedCallSettings {@link PagedCallSettings} to configure the paged settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT, PagedListResponseT>
      UnaryCallable<RequestT, PagedListResponseT> createPagedCallable(
          HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
          PagedCallSettings<RequestT, ResponseT, PagedListResponseT> pagedCallSettings,
          ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable = createDirectUnaryCallable(httpJsonCallSettings);
    callable =
        createUnaryCallable(callable, pagedCallSettings, httpJsonCallSettings, clientContext);
    UnaryCallable<RequestT, PagedListResponseT> pagedCallable =
        Callables.paged(callable, pagedCallSettings);
    return pagedCallable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * Create a callable object that represents a batching API method. Designed for use by generated
   * code.
   *
   * @param httpJsonCallSettings the http/json call settings
   * @param batchingCallSettings {@link BatchingCallSettings} to configure the batching related
   *     settings with.
   * @param clientContext {@link ClientContext} to use to connect to the service.
   * @return {@link UnaryCallable} callable object.
   */
  public static <RequestT, ResponseT> UnaryCallable<RequestT, ResponseT> createBatchingCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      BatchingCallSettings<RequestT, ResponseT> batchingCallSettings,
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResponseT> callable = createDirectUnaryCallable(httpJsonCallSettings);
    callable =
        createUnaryCallable(callable, batchingCallSettings, httpJsonCallSettings, clientContext);
    callable = Callables.batching(callable, batchingCallSettings, clientContext);
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  public static <RequestT, ResponseT, MetadataT>
      OperationCallable<RequestT, ResponseT, MetadataT> createOperationCallable(
          OperationCallSettings<RequestT, ResponseT, MetadataT> operationCallSettings,
          ClientContext clientContext,
          LongRunningClient longRunningClient,
          UnaryCallable<RequestT, OperationSnapshot> operationSnapshotCallable) {
    OperationCallable<RequestT, ResponseT, MetadataT> operationCallable =
        Callables.longRunningOperation(
            operationSnapshotCallable, operationCallSettings, clientContext, longRunningClient);
    return operationCallable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  public static <RequestT, ResponseT>
      ServerStreamingCallable<RequestT, ResponseT> createServerStreamingCallable(
          HttpJsonCallSettings<RequestT, ResponseT> httpJsoncallSettings,
          ServerStreamingCallSettings<RequestT, ResponseT> streamingCallSettings,
          ClientContext clientContext) {

    ServerStreamingCallable<RequestT, ResponseT> callable =
        new HttpJsonDirectServerStreamingCallable<>(httpJsoncallSettings.getMethodDescriptor());

    if (httpJsoncallSettings.getParamsExtractor() != null) {
      callable =
          new HttpJsonServerStreamingRequestParamCallable<>(
              callable, httpJsoncallSettings.getParamsExtractor());
    }

    callable =
        new HttpJsonExceptionServerStreamingCallable<>(
            callable, streamingCallSettings.getRetryableCodes());

    if (clientContext.getStreamWatchdog() != null) {
      callable = Callables.watched(callable, streamingCallSettings, clientContext);
    }

    callable = Callables.retrying(callable, streamingCallSettings, clientContext);
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  @InternalApi("Visible for testing")
  static SpanName getSpanName(@Nonnull ApiMethodDescriptor<?, ?> methodDescriptor) {
    Matcher matcher = FULL_METHOD_NAME_REGEX.matcher(methodDescriptor.getFullMethodName());

    Preconditions.checkArgument(matcher.matches(), "Invalid fullMethodName");
    return SpanName.of(matcher.group(1), matcher.group(2));
  }
}
