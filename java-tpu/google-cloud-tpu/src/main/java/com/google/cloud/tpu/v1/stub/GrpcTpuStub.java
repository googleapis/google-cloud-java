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

package com.google.cloud.tpu.v1.stub;

import static com.google.cloud.tpu.v1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListTensorFlowVersionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.tpu.v1.AcceleratorType;
import com.google.cloud.tpu.v1.CreateNodeRequest;
import com.google.cloud.tpu.v1.DeleteNodeRequest;
import com.google.cloud.tpu.v1.GetAcceleratorTypeRequest;
import com.google.cloud.tpu.v1.GetNodeRequest;
import com.google.cloud.tpu.v1.GetTensorFlowVersionRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesRequest;
import com.google.cloud.tpu.v1.ListAcceleratorTypesResponse;
import com.google.cloud.tpu.v1.ListNodesRequest;
import com.google.cloud.tpu.v1.ListNodesResponse;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsRequest;
import com.google.cloud.tpu.v1.ListTensorFlowVersionsResponse;
import com.google.cloud.tpu.v1.Node;
import com.google.cloud.tpu.v1.OperationMetadata;
import com.google.cloud.tpu.v1.ReimageNodeRequest;
import com.google.cloud.tpu.v1.StartNodeRequest;
import com.google.cloud.tpu.v1.StopNodeRequest;
import com.google.cloud.tpu.v1.TensorFlowVersion;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Tpu service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcTpuStub extends TpuStub {
  private static final MethodDescriptor<ListNodesRequest, ListNodesResponse>
      listNodesMethodDescriptor =
          MethodDescriptor.<ListNodesRequest, ListNodesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v1.Tpu/ListNodes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNodesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNodesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNodeRequest, Node> getNodeMethodDescriptor =
      MethodDescriptor.<GetNodeRequest, Node>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/GetNode")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Node.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNodeRequest, Operation> createNodeMethodDescriptor =
      MethodDescriptor.<CreateNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/CreateNode")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteNodeRequest, Operation> deleteNodeMethodDescriptor =
      MethodDescriptor.<DeleteNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/DeleteNode")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ReimageNodeRequest, Operation> reimageNodeMethodDescriptor =
      MethodDescriptor.<ReimageNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/ReimageNode")
          .setRequestMarshaller(ProtoUtils.marshaller(ReimageNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StopNodeRequest, Operation> stopNodeMethodDescriptor =
      MethodDescriptor.<StopNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/StopNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StopNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<StartNodeRequest, Operation> startNodeMethodDescriptor =
      MethodDescriptor.<StartNodeRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.tpu.v1.Tpu/StartNode")
          .setRequestMarshaller(ProtoUtils.marshaller(StartNodeRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<
          ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
      listTensorFlowVersionsMethodDescriptor =
          MethodDescriptor
              .<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v1.Tpu/ListTensorFlowVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTensorFlowVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTensorFlowVersionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionMethodDescriptor =
          MethodDescriptor.<GetTensorFlowVersionRequest, TensorFlowVersion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v1.Tpu/GetTensorFlowVersion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTensorFlowVersionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TensorFlowVersion.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesMethodDescriptor =
          MethodDescriptor.<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v1.Tpu/ListAcceleratorTypes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAcceleratorTypesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeMethodDescriptor =
          MethodDescriptor.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.tpu.v1.Tpu/GetAcceleratorType")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAcceleratorTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AcceleratorType.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable;
  private final UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable;
  private final UnaryCallable<GetNodeRequest, Node> getNodeCallable;
  private final UnaryCallable<CreateNodeRequest, Operation> createNodeCallable;
  private final OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable;
  private final UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable;
  private final OperationCallable<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationCallable;
  private final UnaryCallable<ReimageNodeRequest, Operation> reimageNodeCallable;
  private final OperationCallable<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationCallable;
  private final UnaryCallable<StopNodeRequest, Operation> stopNodeCallable;
  private final OperationCallable<StopNodeRequest, Node, OperationMetadata>
      stopNodeOperationCallable;
  private final UnaryCallable<StartNodeRequest, Operation> startNodeCallable;
  private final OperationCallable<StartNodeRequest, Node, OperationMetadata>
      startNodeOperationCallable;
  private final UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
      listTensorFlowVersionsCallable;
  private final UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsPagedCallable;
  private final UnaryCallable<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable;
  private final UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable;
  private final UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType>
      getAcceleratorTypeCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcTpuStub create(TpuStubSettings settings) throws IOException {
    return new GrpcTpuStub(settings, ClientContext.create(settings));
  }

  public static final GrpcTpuStub create(ClientContext clientContext) throws IOException {
    return new GrpcTpuStub(TpuStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcTpuStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcTpuStub(TpuStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcTpuStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTpuStub(TpuStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcTpuCallableFactory());
  }

  /**
   * Constructs an instance of GrpcTpuStub, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcTpuStub(
      TpuStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListNodesRequest, ListNodesResponse> listNodesTransportSettings =
        GrpcCallSettings.<ListNodesRequest, ListNodesResponse>newBuilder()
            .setMethodDescriptor(listNodesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNodeRequest, Node> getNodeTransportSettings =
        GrpcCallSettings.<GetNodeRequest, Node>newBuilder()
            .setMethodDescriptor(getNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNodeRequest, Operation> createNodeTransportSettings =
        GrpcCallSettings.<CreateNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(createNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNodeRequest, Operation> deleteNodeTransportSettings =
        GrpcCallSettings.<DeleteNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ReimageNodeRequest, Operation> reimageNodeTransportSettings =
        GrpcCallSettings.<ReimageNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(reimageNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StopNodeRequest, Operation> stopNodeTransportSettings =
        GrpcCallSettings.<StopNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(stopNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartNodeRequest, Operation> startNodeTransportSettings =
        GrpcCallSettings.<StartNodeRequest, Operation>newBuilder()
            .setMethodDescriptor(startNodeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
        listTensorFlowVersionsTransportSettings =
            GrpcCallSettings
                .<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>newBuilder()
                .setMethodDescriptor(listTensorFlowVersionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetTensorFlowVersionRequest, TensorFlowVersion>
        getTensorFlowVersionTransportSettings =
            GrpcCallSettings.<GetTensorFlowVersionRequest, TensorFlowVersion>newBuilder()
                .setMethodDescriptor(getTensorFlowVersionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
        listAcceleratorTypesTransportSettings =
            GrpcCallSettings.<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>newBuilder()
                .setMethodDescriptor(listAcceleratorTypesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetAcceleratorTypeRequest, AcceleratorType>
        getAcceleratorTypeTransportSettings =
            GrpcCallSettings.<GetAcceleratorTypeRequest, AcceleratorType>newBuilder()
                .setMethodDescriptor(getAcceleratorTypeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.listNodesCallable =
        callableFactory.createUnaryCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.listNodesPagedCallable =
        callableFactory.createPagedCallable(
            listNodesTransportSettings, settings.listNodesSettings(), clientContext);
    this.getNodeCallable =
        callableFactory.createUnaryCallable(
            getNodeTransportSettings, settings.getNodeSettings(), clientContext);
    this.createNodeCallable =
        callableFactory.createUnaryCallable(
            createNodeTransportSettings, settings.createNodeSettings(), clientContext);
    this.createNodeOperationCallable =
        callableFactory.createOperationCallable(
            createNodeTransportSettings,
            settings.createNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteNodeCallable =
        callableFactory.createUnaryCallable(
            deleteNodeTransportSettings, settings.deleteNodeSettings(), clientContext);
    this.deleteNodeOperationCallable =
        callableFactory.createOperationCallable(
            deleteNodeTransportSettings,
            settings.deleteNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.reimageNodeCallable =
        callableFactory.createUnaryCallable(
            reimageNodeTransportSettings, settings.reimageNodeSettings(), clientContext);
    this.reimageNodeOperationCallable =
        callableFactory.createOperationCallable(
            reimageNodeTransportSettings,
            settings.reimageNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.stopNodeCallable =
        callableFactory.createUnaryCallable(
            stopNodeTransportSettings, settings.stopNodeSettings(), clientContext);
    this.stopNodeOperationCallable =
        callableFactory.createOperationCallable(
            stopNodeTransportSettings,
            settings.stopNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.startNodeCallable =
        callableFactory.createUnaryCallable(
            startNodeTransportSettings, settings.startNodeSettings(), clientContext);
    this.startNodeOperationCallable =
        callableFactory.createOperationCallable(
            startNodeTransportSettings,
            settings.startNodeOperationSettings(),
            clientContext,
            operationsStub);
    this.listTensorFlowVersionsCallable =
        callableFactory.createUnaryCallable(
            listTensorFlowVersionsTransportSettings,
            settings.listTensorFlowVersionsSettings(),
            clientContext);
    this.listTensorFlowVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listTensorFlowVersionsTransportSettings,
            settings.listTensorFlowVersionsSettings(),
            clientContext);
    this.getTensorFlowVersionCallable =
        callableFactory.createUnaryCallable(
            getTensorFlowVersionTransportSettings,
            settings.getTensorFlowVersionSettings(),
            clientContext);
    this.listAcceleratorTypesCallable =
        callableFactory.createUnaryCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.listAcceleratorTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.getAcceleratorTypeCallable =
        callableFactory.createUnaryCallable(
            getAcceleratorTypeTransportSettings,
            settings.getAcceleratorTypeSettings(),
            clientContext);
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
  public UnaryCallable<ListNodesRequest, ListNodesResponse> listNodesCallable() {
    return listNodesCallable;
  }

  @Override
  public UnaryCallable<ListNodesRequest, ListNodesPagedResponse> listNodesPagedCallable() {
    return listNodesPagedCallable;
  }

  @Override
  public UnaryCallable<GetNodeRequest, Node> getNodeCallable() {
    return getNodeCallable;
  }

  @Override
  public UnaryCallable<CreateNodeRequest, Operation> createNodeCallable() {
    return createNodeCallable;
  }

  @Override
  public OperationCallable<CreateNodeRequest, Node, OperationMetadata>
      createNodeOperationCallable() {
    return createNodeOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNodeRequest, Operation> deleteNodeCallable() {
    return deleteNodeCallable;
  }

  @Override
  public OperationCallable<DeleteNodeRequest, Node, OperationMetadata>
      deleteNodeOperationCallable() {
    return deleteNodeOperationCallable;
  }

  @Override
  public UnaryCallable<ReimageNodeRequest, Operation> reimageNodeCallable() {
    return reimageNodeCallable;
  }

  @Override
  public OperationCallable<ReimageNodeRequest, Node, OperationMetadata>
      reimageNodeOperationCallable() {
    return reimageNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StopNodeRequest, Operation> stopNodeCallable() {
    return stopNodeCallable;
  }

  @Override
  public OperationCallable<StopNodeRequest, Node, OperationMetadata> stopNodeOperationCallable() {
    return stopNodeOperationCallable;
  }

  @Override
  public UnaryCallable<StartNodeRequest, Operation> startNodeCallable() {
    return startNodeCallable;
  }

  @Override
  public OperationCallable<StartNodeRequest, Node, OperationMetadata> startNodeOperationCallable() {
    return startNodeOperationCallable;
  }

  @Override
  public UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsResponse>
      listTensorFlowVersionsCallable() {
    return listTensorFlowVersionsCallable;
  }

  @Override
  public UnaryCallable<ListTensorFlowVersionsRequest, ListTensorFlowVersionsPagedResponse>
      listTensorFlowVersionsPagedCallable() {
    return listTensorFlowVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTensorFlowVersionRequest, TensorFlowVersion>
      getTensorFlowVersionCallable() {
    return getTensorFlowVersionCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesResponse>
      listAcceleratorTypesCallable() {
    return listAcceleratorTypesCallable;
  }

  @Override
  public UnaryCallable<ListAcceleratorTypesRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return listAcceleratorTypesPagedCallable;
  }

  @Override
  public UnaryCallable<GetAcceleratorTypeRequest, AcceleratorType> getAcceleratorTypeCallable() {
    return getAcceleratorTypeCallable;
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
