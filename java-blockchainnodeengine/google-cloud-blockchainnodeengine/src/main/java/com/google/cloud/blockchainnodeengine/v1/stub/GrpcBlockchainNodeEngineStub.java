/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.blockchainnodeengine.v1.stub;

import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListBlockchainNodesPagedResponse;
import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.blockchainnodeengine.v1.BlockchainNode;
import com.google.cloud.blockchainnodeengine.v1.CreateBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.DeleteBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.GetBlockchainNodeRequest;
import com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesRequest;
import com.google.cloud.blockchainnodeengine.v1.ListBlockchainNodesResponse;
import com.google.cloud.blockchainnodeengine.v1.OperationMetadata;
import com.google.cloud.blockchainnodeengine.v1.UpdateBlockchainNodeRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BlockchainNodeEngine service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcBlockchainNodeEngineStub extends BlockchainNodeEngineStub {
  private static final MethodDescriptor<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesMethodDescriptor =
          MethodDescriptor.<ListBlockchainNodesRequest, ListBlockchainNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/ListBlockchainNodes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBlockchainNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBlockchainNodesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetBlockchainNodeRequest, BlockchainNode>
      getBlockchainNodeMethodDescriptor =
          MethodDescriptor.<GetBlockchainNodeRequest, BlockchainNode>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/GetBlockchainNode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBlockchainNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BlockchainNode.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateBlockchainNodeRequest, Operation>
      createBlockchainNodeMethodDescriptor =
          MethodDescriptor.<CreateBlockchainNodeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/CreateBlockchainNode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateBlockchainNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateBlockchainNodeRequest, Operation>
      updateBlockchainNodeMethodDescriptor =
          MethodDescriptor.<UpdateBlockchainNodeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/UpdateBlockchainNode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateBlockchainNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteBlockchainNodeRequest, Operation>
      deleteBlockchainNodeMethodDescriptor =
          MethodDescriptor.<DeleteBlockchainNodeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.blockchainnodeengine.v1.BlockchainNodeEngine/DeleteBlockchainNode")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteBlockchainNodeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesCallable;
  private final UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesPagedResponse>
      listBlockchainNodesPagedCallable;
  private final UnaryCallable<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeCallable;
  private final UnaryCallable<CreateBlockchainNodeRequest, Operation> createBlockchainNodeCallable;
  private final OperationCallable<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationCallable;
  private final UnaryCallable<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeCallable;
  private final OperationCallable<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationCallable;
  private final UnaryCallable<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeCallable;
  private final OperationCallable<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBlockchainNodeEngineStub create(BlockchainNodeEngineStubSettings settings)
      throws IOException {
    return new GrpcBlockchainNodeEngineStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBlockchainNodeEngineStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBlockchainNodeEngineStub(
        BlockchainNodeEngineStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBlockchainNodeEngineStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBlockchainNodeEngineStub(
        BlockchainNodeEngineStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBlockchainNodeEngineStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBlockchainNodeEngineStub(
      BlockchainNodeEngineStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBlockchainNodeEngineCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBlockchainNodeEngineStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBlockchainNodeEngineStub(
      BlockchainNodeEngineStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
        listBlockchainNodesTransportSettings =
            GrpcCallSettings.<ListBlockchainNodesRequest, ListBlockchainNodesResponse>newBuilder()
                .setMethodDescriptor(listBlockchainNodesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    GrpcCallSettings<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeTransportSettings =
        GrpcCallSettings.<GetBlockchainNodeRequest, BlockchainNode>newBuilder()
            .setMethodDescriptor(getBlockchainNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<CreateBlockchainNodeRequest, Operation> createBlockchainNodeTransportSettings =
        GrpcCallSettings.<CreateBlockchainNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(createBlockchainNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    GrpcCallSettings<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeTransportSettings =
        GrpcCallSettings.<UpdateBlockchainNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(updateBlockchainNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "blockchain_node.name",
                      String.valueOf(request.getBlockchainNode().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeTransportSettings =
        GrpcCallSettings.<DeleteBlockchainNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBlockchainNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listBlockchainNodesCallable =
        callableFactory.createUnaryCallable(
            listBlockchainNodesTransportSettings,
            settings.listBlockchainNodesSettings(),
            clientContext);
    this.listBlockchainNodesPagedCallable =
        callableFactory.createPagedCallable(
            listBlockchainNodesTransportSettings,
            settings.listBlockchainNodesSettings(),
            clientContext);
    this.getBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            getBlockchainNodeTransportSettings,
            settings.getBlockchainNodeSettings(),
            clientContext);
    this.createBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            createBlockchainNodeTransportSettings,
            settings.createBlockchainNodeSettings(),
            clientContext);
    this.createBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            createBlockchainNodeTransportSettings,
            settings.createBlockchainNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.updateBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            updateBlockchainNodeTransportSettings,
            settings.updateBlockchainNodeSettings(),
            clientContext);
    this.updateBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            updateBlockchainNodeTransportSettings,
            settings.updateBlockchainNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteBlockchainNodeCallable =
        callableFactory.createUnaryCallable(
            deleteBlockchainNodeTransportSettings,
            settings.deleteBlockchainNodeSettings(),
            clientContext);
    this.deleteBlockchainNodeOperationCallable =
        callableFactory.createOperationCallable(
            deleteBlockchainNodeTransportSettings,
            settings.deleteBlockchainNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesResponse>
      listBlockchainNodesCallable() {
    return listBlockchainNodesCallable;
  }

  @Override
  public UnaryCallable<ListBlockchainNodesRequest, ListBlockchainNodesPagedResponse>
      listBlockchainNodesPagedCallable() {
    return listBlockchainNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetBlockchainNodeRequest, BlockchainNode> getBlockchainNodeCallable() {
    return getBlockchainNodeCallable;
  }

  @Override
  public UnaryCallable<CreateBlockchainNodeRequest, Operation> createBlockchainNodeCallable() {
    return createBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<CreateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      createBlockchainNodeOperationCallable() {
    return createBlockchainNodeOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateBlockchainNodeRequest, Operation> updateBlockchainNodeCallable() {
    return updateBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<UpdateBlockchainNodeRequest, BlockchainNode, OperationMetadata>
      updateBlockchainNodeOperationCallable() {
    return updateBlockchainNodeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteBlockchainNodeRequest, Operation> deleteBlockchainNodeCallable() {
    return deleteBlockchainNodeCallable;
  }

  @Override
  public OperationCallable<DeleteBlockchainNodeRequest, Empty, OperationMetadata>
      deleteBlockchainNodeOperationCallable() {
    return deleteBlockchainNodeOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
