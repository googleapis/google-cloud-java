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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.EntityServiceClient.ListWatchlistsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateWatchlistRequest;
import com.google.cloud.chronicle.v1.DeleteWatchlistRequest;
import com.google.cloud.chronicle.v1.GetWatchlistRequest;
import com.google.cloud.chronicle.v1.ListWatchlistsRequest;
import com.google.cloud.chronicle.v1.ListWatchlistsResponse;
import com.google.cloud.chronicle.v1.UpdateWatchlistRequest;
import com.google.cloud.chronicle.v1.Watchlist;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EntityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEntityServiceStub extends EntityServiceStub {
  private static final MethodDescriptor<GetWatchlistRequest, Watchlist>
      getWatchlistMethodDescriptor =
          MethodDescriptor.<GetWatchlistRequest, Watchlist>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/GetWatchlist")
              .setRequestMarshaller(ProtoUtils.marshaller(GetWatchlistRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Watchlist.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListWatchlistsRequest, ListWatchlistsResponse>
      listWatchlistsMethodDescriptor =
          MethodDescriptor.<ListWatchlistsRequest, ListWatchlistsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/ListWatchlists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWatchlistsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWatchlistsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateWatchlistRequest, Watchlist>
      createWatchlistMethodDescriptor =
          MethodDescriptor.<CreateWatchlistRequest, Watchlist>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/CreateWatchlist")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWatchlistRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Watchlist.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateWatchlistRequest, Watchlist>
      updateWatchlistMethodDescriptor =
          MethodDescriptor.<UpdateWatchlistRequest, Watchlist>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/UpdateWatchlist")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWatchlistRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Watchlist.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteWatchlistRequest, Empty>
      deleteWatchlistMethodDescriptor =
          MethodDescriptor.<DeleteWatchlistRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.chronicle.v1.EntityService/DeleteWatchlist")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteWatchlistRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable;
  private final UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> listWatchlistsCallable;
  private final UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable;
  private final UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable;
  private final UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable;
  private final UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEntityServiceStub create(EntityServiceStubSettings settings)
      throws IOException {
    return new GrpcEntityServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEntityServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcEntityServiceStub(EntityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEntityServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEntityServiceStub(
        EntityServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEntityServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEntityServiceStub(EntityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEntityServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEntityServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEntityServiceStub(
      EntityServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetWatchlistRequest, Watchlist> getWatchlistTransportSettings =
        GrpcCallSettings.<GetWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(getWatchlistMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListWatchlistsRequest, ListWatchlistsResponse>
        listWatchlistsTransportSettings =
            GrpcCallSettings.<ListWatchlistsRequest, ListWatchlistsResponse>newBuilder()
                .setMethodDescriptor(listWatchlistsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateWatchlistRequest, Watchlist> createWatchlistTransportSettings =
        GrpcCallSettings.<CreateWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(createWatchlistMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateWatchlistRequest, Watchlist> updateWatchlistTransportSettings =
        GrpcCallSettings.<UpdateWatchlistRequest, Watchlist>newBuilder()
            .setMethodDescriptor(updateWatchlistMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("watchlist.name", String.valueOf(request.getWatchlist().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteWatchlistRequest, Empty> deleteWatchlistTransportSettings =
        GrpcCallSettings.<DeleteWatchlistRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWatchlistMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.getWatchlistCallable =
        callableFactory.createUnaryCallable(
            getWatchlistTransportSettings, settings.getWatchlistSettings(), clientContext);
    this.listWatchlistsCallable =
        callableFactory.createUnaryCallable(
            listWatchlistsTransportSettings, settings.listWatchlistsSettings(), clientContext);
    this.listWatchlistsPagedCallable =
        callableFactory.createPagedCallable(
            listWatchlistsTransportSettings, settings.listWatchlistsSettings(), clientContext);
    this.createWatchlistCallable =
        callableFactory.createUnaryCallable(
            createWatchlistTransportSettings, settings.createWatchlistSettings(), clientContext);
    this.updateWatchlistCallable =
        callableFactory.createUnaryCallable(
            updateWatchlistTransportSettings, settings.updateWatchlistSettings(), clientContext);
    this.deleteWatchlistCallable =
        callableFactory.createUnaryCallable(
            deleteWatchlistTransportSettings, settings.deleteWatchlistSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetWatchlistRequest, Watchlist> getWatchlistCallable() {
    return getWatchlistCallable;
  }

  @Override
  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsResponse> listWatchlistsCallable() {
    return listWatchlistsCallable;
  }

  @Override
  public UnaryCallable<ListWatchlistsRequest, ListWatchlistsPagedResponse>
      listWatchlistsPagedCallable() {
    return listWatchlistsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateWatchlistRequest, Watchlist> createWatchlistCallable() {
    return createWatchlistCallable;
  }

  @Override
  public UnaryCallable<UpdateWatchlistRequest, Watchlist> updateWatchlistCallable() {
    return updateWatchlistCallable;
  }

  @Override
  public UnaryCallable<DeleteWatchlistRequest, Empty> deleteWatchlistCallable() {
    return deleteWatchlistCallable;
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
