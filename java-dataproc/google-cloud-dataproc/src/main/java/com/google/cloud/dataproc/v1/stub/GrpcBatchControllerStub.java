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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.BatchControllerClient.ListBatchesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.Batch;
import com.google.cloud.dataproc.v1.BatchOperationMetadata;
import com.google.cloud.dataproc.v1.CreateBatchRequest;
import com.google.cloud.dataproc.v1.DeleteBatchRequest;
import com.google.cloud.dataproc.v1.GetBatchRequest;
import com.google.cloud.dataproc.v1.ListBatchesRequest;
import com.google.cloud.dataproc.v1.ListBatchesResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BatchController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBatchControllerStub extends BatchControllerStub {
  private static final MethodDescriptor<CreateBatchRequest, Operation> createBatchMethodDescriptor =
      MethodDescriptor.<CreateBatchRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.BatchController/CreateBatch")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateBatchRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetBatchRequest, Batch> getBatchMethodDescriptor =
      MethodDescriptor.<GetBatchRequest, Batch>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.BatchController/GetBatch")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBatchRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Batch.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListBatchesRequest, ListBatchesResponse>
      listBatchesMethodDescriptor =
          MethodDescriptor.<ListBatchesRequest, ListBatchesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1.BatchController/ListBatches")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBatchesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBatchesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteBatchRequest, Empty> deleteBatchMethodDescriptor =
      MethodDescriptor.<DeleteBatchRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1.BatchController/DeleteBatch")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteBatchRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateBatchRequest, Operation> createBatchCallable;
  private final OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable;
  private final UnaryCallable<GetBatchRequest, Batch> getBatchCallable;
  private final UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable;
  private final UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse>
      listBatchesPagedCallable;
  private final UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBatchControllerStub create(BatchControllerStubSettings settings)
      throws IOException {
    return new GrpcBatchControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBatchControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBatchControllerStub(
        BatchControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBatchControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBatchControllerStub(
        BatchControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBatchControllerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBatchControllerStub(
      BatchControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBatchControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBatchControllerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBatchControllerStub(
      BatchControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateBatchRequest, Operation> createBatchTransportSettings =
        GrpcCallSettings.<CreateBatchRequest, Operation>newBuilder()
            .setMethodDescriptor(createBatchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetBatchRequest, Batch> getBatchTransportSettings =
        GrpcCallSettings.<GetBatchRequest, Batch>newBuilder()
            .setMethodDescriptor(getBatchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListBatchesRequest, ListBatchesResponse> listBatchesTransportSettings =
        GrpcCallSettings.<ListBatchesRequest, ListBatchesResponse>newBuilder()
            .setMethodDescriptor(listBatchesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteBatchRequest, Empty> deleteBatchTransportSettings =
        GrpcCallSettings.<DeleteBatchRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteBatchMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createBatchCallable =
        callableFactory.createUnaryCallable(
            createBatchTransportSettings, settings.createBatchSettings(), clientContext);
    this.createBatchOperationCallable =
        callableFactory.createOperationCallable(
            createBatchTransportSettings,
            settings.createBatchOperationSettings(),
            clientContext,
            operationsStub);
    this.getBatchCallable =
        callableFactory.createUnaryCallable(
            getBatchTransportSettings, settings.getBatchSettings(), clientContext);
    this.listBatchesCallable =
        callableFactory.createUnaryCallable(
            listBatchesTransportSettings, settings.listBatchesSettings(), clientContext);
    this.listBatchesPagedCallable =
        callableFactory.createPagedCallable(
            listBatchesTransportSettings, settings.listBatchesSettings(), clientContext);
    this.deleteBatchCallable =
        callableFactory.createUnaryCallable(
            deleteBatchTransportSettings, settings.deleteBatchSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateBatchRequest, Operation> createBatchCallable() {
    return createBatchCallable;
  }

  @Override
  public OperationCallable<CreateBatchRequest, Batch, BatchOperationMetadata>
      createBatchOperationCallable() {
    return createBatchOperationCallable;
  }

  @Override
  public UnaryCallable<GetBatchRequest, Batch> getBatchCallable() {
    return getBatchCallable;
  }

  @Override
  public UnaryCallable<ListBatchesRequest, ListBatchesResponse> listBatchesCallable() {
    return listBatchesCallable;
  }

  @Override
  public UnaryCallable<ListBatchesRequest, ListBatchesPagedResponse> listBatchesPagedCallable() {
    return listBatchesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteBatchRequest, Empty> deleteBatchCallable() {
    return deleteBatchCallable;
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
