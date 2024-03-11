/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.ChunkServiceClient.ListChunksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.Chunk;
import com.google.cloud.discoveryengine.v1alpha.GetChunkRequest;
import com.google.cloud.discoveryengine.v1alpha.ListChunksRequest;
import com.google.cloud.discoveryengine.v1alpha.ListChunksResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ChunkService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcChunkServiceStub extends ChunkServiceStub {
  private static final MethodDescriptor<GetChunkRequest, Chunk> getChunkMethodDescriptor =
      MethodDescriptor.<GetChunkRequest, Chunk>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.ChunkService/GetChunk")
          .setRequestMarshaller(ProtoUtils.marshaller(GetChunkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Chunk.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListChunksRequest, ListChunksResponse>
      listChunksMethodDescriptor =
          MethodDescriptor.<ListChunksRequest, ListChunksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.ChunkService/ListChunks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListChunksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListChunksResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetChunkRequest, Chunk> getChunkCallable;
  private final UnaryCallable<ListChunksRequest, ListChunksResponse> listChunksCallable;
  private final UnaryCallable<ListChunksRequest, ListChunksPagedResponse> listChunksPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcChunkServiceStub create(ChunkServiceStubSettings settings)
      throws IOException {
    return new GrpcChunkServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcChunkServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcChunkServiceStub(ChunkServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcChunkServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcChunkServiceStub(
        ChunkServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcChunkServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcChunkServiceStub(ChunkServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcChunkServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcChunkServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcChunkServiceStub(
      ChunkServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetChunkRequest, Chunk> getChunkTransportSettings =
        GrpcCallSettings.<GetChunkRequest, Chunk>newBuilder()
            .setMethodDescriptor(getChunkMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListChunksRequest, ListChunksResponse> listChunksTransportSettings =
        GrpcCallSettings.<ListChunksRequest, ListChunksResponse>newBuilder()
            .setMethodDescriptor(listChunksMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getChunkCallable =
        callableFactory.createUnaryCallable(
            getChunkTransportSettings, settings.getChunkSettings(), clientContext);
    this.listChunksCallable =
        callableFactory.createUnaryCallable(
            listChunksTransportSettings, settings.listChunksSettings(), clientContext);
    this.listChunksPagedCallable =
        callableFactory.createPagedCallable(
            listChunksTransportSettings, settings.listChunksSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetChunkRequest, Chunk> getChunkCallable() {
    return getChunkCallable;
  }

  @Override
  public UnaryCallable<ListChunksRequest, ListChunksResponse> listChunksCallable() {
    return listChunksCallable;
  }

  @Override
  public UnaryCallable<ListChunksRequest, ListChunksPagedResponse> listChunksPagedCallable() {
    return listChunksPagedCallable;
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
