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

package com.google.cloud.vpcaccess.v1.stub;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;
import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.CreateConnectorRequest;
import com.google.cloud.vpcaccess.v1.DeleteConnectorRequest;
import com.google.cloud.vpcaccess.v1.GetConnectorRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsResponse;
import com.google.cloud.vpcaccess.v1.OperationMetadata;
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
 * gRPC stub implementation for the VpcAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcVpcAccessServiceStub extends VpcAccessServiceStub {
  private static final MethodDescriptor<CreateConnectorRequest, Operation>
      createConnectorMethodDescriptor =
          MethodDescriptor.<CreateConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/CreateConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectorRequest, Connector>
      getConnectorMethodDescriptor =
          MethodDescriptor.<GetConnectorRequest, Connector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/GetConnector")
              .setRequestMarshaller(ProtoUtils.marshaller(GetConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsMethodDescriptor =
          MethodDescriptor.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/ListConnectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectorRequest, Operation>
      deleteConnectorMethodDescriptor =
          MethodDescriptor.<DeleteConnectorRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.vpcaccess.v1.VpcAccessService/DeleteConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
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

  private final UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable;
  private final OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable;
  private final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable;
  private final UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable;
  private final OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcVpcAccessServiceStub create(VpcAccessServiceStubSettings settings)
      throws IOException {
    return new GrpcVpcAccessServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcVpcAccessServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcVpcAccessServiceStub(
        VpcAccessServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcVpcAccessServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcVpcAccessServiceStub(
        VpcAccessServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcVpcAccessServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVpcAccessServiceStub(
      VpcAccessServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcVpcAccessServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcVpcAccessServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcVpcAccessServiceStub(
      VpcAccessServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConnectorRequest, Operation> createConnectorTransportSettings =
        GrpcCallSettings.<CreateConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(createConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetConnectorRequest, Connector> getConnectorTransportSettings =
        GrpcCallSettings.<GetConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(getConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListConnectorsRequest, ListConnectorsResponse>
        listConnectorsTransportSettings =
            GrpcCallSettings.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
                .setMethodDescriptor(listConnectorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConnectorRequest, Operation> deleteConnectorTransportSettings =
        GrpcCallSettings.<DeleteConnectorRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConnectorMethodDescriptor)
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

    this.createConnectorCallable =
        callableFactory.createUnaryCallable(
            createConnectorTransportSettings, settings.createConnectorSettings(), clientContext);
    this.createConnectorOperationCallable =
        callableFactory.createOperationCallable(
            createConnectorTransportSettings,
            settings.createConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.getConnectorCallable =
        callableFactory.createUnaryCallable(
            getConnectorTransportSettings, settings.getConnectorSettings(), clientContext);
    this.listConnectorsCallable =
        callableFactory.createUnaryCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.listConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.deleteConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteConnectorTransportSettings, settings.deleteConnectorSettings(), clientContext);
    this.deleteConnectorOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectorTransportSettings,
            settings.deleteConnectorOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable() {
    return createConnectorCallable;
  }

  @Override
  public OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable() {
    return createConnectorOperationCallable;
  }

  @Override
  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return getConnectorCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable() {
    return listConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    return listConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable() {
    return deleteConnectorCallable;
  }

  @Override
  public OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable() {
    return deleteConnectorOperationCallable;
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
