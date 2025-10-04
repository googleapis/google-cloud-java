/*
 * Copyright 2025 Google LLC
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

package com.google.spanner.adapter.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.spanner.adapter.v1.AdaptMessageRequest;
import com.google.spanner.adapter.v1.AdaptMessageResponse;
import com.google.spanner.adapter.v1.CreateSessionRequest;
import com.google.spanner.adapter.v1.Session;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Adapter service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAdapterStub extends AdapterStub {
  private static final MethodDescriptor<CreateSessionRequest, Session>
      createSessionMethodDescriptor =
          MethodDescriptor.<CreateSessionRequest, Session>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.spanner.adapter.v1.Adapter/CreateSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Session.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AdaptMessageRequest, AdaptMessageResponse>
      adaptMessageMethodDescriptor =
          MethodDescriptor.<AdaptMessageRequest, AdaptMessageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.spanner.adapter.v1.Adapter/AdaptMessage")
              .setRequestMarshaller(ProtoUtils.marshaller(AdaptMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AdaptMessageResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateSessionRequest, Session> createSessionCallable;
  private final ServerStreamingCallable<AdaptMessageRequest, AdaptMessageResponse>
      adaptMessageCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAdapterStub create(AdapterStubSettings settings) throws IOException {
    return new GrpcAdapterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAdapterStub create(ClientContext clientContext) throws IOException {
    return new GrpcAdapterStub(AdapterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAdapterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAdapterStub(
        AdapterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAdapterStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAdapterStub(AdapterStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAdapterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAdapterStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcAdapterStub(
      AdapterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateSessionRequest, Session> createSessionTransportSettings =
        GrpcCallSettings.<CreateSessionRequest, Session>newBuilder()
            .setMethodDescriptor(createSessionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<AdaptMessageRequest, AdaptMessageResponse> adaptMessageTransportSettings =
        GrpcCallSettings.<AdaptMessageRequest, AdaptMessageResponse>newBuilder()
            .setMethodDescriptor(adaptMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createSessionCallable =
        callableFactory.createUnaryCallable(
            createSessionTransportSettings, settings.createSessionSettings(), clientContext);
    this.adaptMessageCallable =
        callableFactory.createServerStreamingCallable(
            adaptMessageTransportSettings, settings.adaptMessageSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateSessionRequest, Session> createSessionCallable() {
    return createSessionCallable;
  }

  @Override
  public ServerStreamingCallable<AdaptMessageRequest, AdaptMessageResponse> adaptMessageCallable() {
    return adaptMessageCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
