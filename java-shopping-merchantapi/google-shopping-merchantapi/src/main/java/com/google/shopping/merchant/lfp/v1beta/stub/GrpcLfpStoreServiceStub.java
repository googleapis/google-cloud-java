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

package com.google.shopping.merchant.lfp.v1beta.stub;

import static com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceClient.ListLfpStoresPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.lfp.v1beta.DeleteLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.GetLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.InsertLfpStoreRequest;
import com.google.shopping.merchant.lfp.v1beta.LfpStore;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresRequest;
import com.google.shopping.merchant.lfp.v1beta.ListLfpStoresResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LfpStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcLfpStoreServiceStub extends LfpStoreServiceStub {
  private static final MethodDescriptor<GetLfpStoreRequest, LfpStore> getLfpStoreMethodDescriptor =
      MethodDescriptor.<GetLfpStoreRequest, LfpStore>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.shopping.merchant.lfp.v1beta.LfpStoreService/GetLfpStore")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLfpStoreRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LfpStore.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<InsertLfpStoreRequest, LfpStore>
      insertLfpStoreMethodDescriptor =
          MethodDescriptor.<InsertLfpStoreRequest, LfpStore>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/InsertLfpStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InsertLfpStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LfpStore.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteLfpStoreRequest, Empty>
      deleteLfpStoreMethodDescriptor =
          MethodDescriptor.<DeleteLfpStoreRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/DeleteLfpStore")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteLfpStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLfpStoresRequest, ListLfpStoresResponse>
      listLfpStoresMethodDescriptor =
          MethodDescriptor.<ListLfpStoresRequest, ListLfpStoresResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.lfp.v1beta.LfpStoreService/ListLfpStores")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLfpStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLfpStoresResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable;
  private final UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable;
  private final UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable;
  private final UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable;
  private final UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLfpStoreServiceStub create(LfpStoreServiceStubSettings settings)
      throws IOException {
    return new GrpcLfpStoreServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcLfpStoreServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLfpStoreServiceStub(
        LfpStoreServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLfpStoreServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLfpStoreServiceStub(
        LfpStoreServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLfpStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLfpStoreServiceStub(
      LfpStoreServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLfpStoreServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcLfpStoreServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLfpStoreServiceStub(
      LfpStoreServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetLfpStoreRequest, LfpStore> getLfpStoreTransportSettings =
        GrpcCallSettings.<GetLfpStoreRequest, LfpStore>newBuilder()
            .setMethodDescriptor(getLfpStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<InsertLfpStoreRequest, LfpStore> insertLfpStoreTransportSettings =
        GrpcCallSettings.<InsertLfpStoreRequest, LfpStore>newBuilder()
            .setMethodDescriptor(insertLfpStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteLfpStoreRequest, Empty> deleteLfpStoreTransportSettings =
        GrpcCallSettings.<DeleteLfpStoreRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLfpStoreMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresTransportSettings =
        GrpcCallSettings.<ListLfpStoresRequest, ListLfpStoresResponse>newBuilder()
            .setMethodDescriptor(listLfpStoresMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.getLfpStoreCallable =
        callableFactory.createUnaryCallable(
            getLfpStoreTransportSettings, settings.getLfpStoreSettings(), clientContext);
    this.insertLfpStoreCallable =
        callableFactory.createUnaryCallable(
            insertLfpStoreTransportSettings, settings.insertLfpStoreSettings(), clientContext);
    this.deleteLfpStoreCallable =
        callableFactory.createUnaryCallable(
            deleteLfpStoreTransportSettings, settings.deleteLfpStoreSettings(), clientContext);
    this.listLfpStoresCallable =
        callableFactory.createUnaryCallable(
            listLfpStoresTransportSettings, settings.listLfpStoresSettings(), clientContext);
    this.listLfpStoresPagedCallable =
        callableFactory.createPagedCallable(
            listLfpStoresTransportSettings, settings.listLfpStoresSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetLfpStoreRequest, LfpStore> getLfpStoreCallable() {
    return getLfpStoreCallable;
  }

  @Override
  public UnaryCallable<InsertLfpStoreRequest, LfpStore> insertLfpStoreCallable() {
    return insertLfpStoreCallable;
  }

  @Override
  public UnaryCallable<DeleteLfpStoreRequest, Empty> deleteLfpStoreCallable() {
    return deleteLfpStoreCallable;
  }

  @Override
  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresResponse> listLfpStoresCallable() {
    return listLfpStoresCallable;
  }

  @Override
  public UnaryCallable<ListLfpStoresRequest, ListLfpStoresPagedResponse>
      listLfpStoresPagedCallable() {
    return listLfpStoresPagedCallable;
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
