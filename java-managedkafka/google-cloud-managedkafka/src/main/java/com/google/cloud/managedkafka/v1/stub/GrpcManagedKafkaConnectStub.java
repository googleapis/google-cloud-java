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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.ConnectCluster;
import com.google.cloud.managedkafka.v1.Connector;
import com.google.cloud.managedkafka.v1.CreateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.CreateConnectorRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectorRequest;
import com.google.cloud.managedkafka.v1.GetConnectClusterRequest;
import com.google.cloud.managedkafka.v1.GetConnectorRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersResponse;
import com.google.cloud.managedkafka.v1.ListConnectorsRequest;
import com.google.cloud.managedkafka.v1.ListConnectorsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.PauseConnectorRequest;
import com.google.cloud.managedkafka.v1.PauseConnectorResponse;
import com.google.cloud.managedkafka.v1.RestartConnectorRequest;
import com.google.cloud.managedkafka.v1.RestartConnectorResponse;
import com.google.cloud.managedkafka.v1.ResumeConnectorRequest;
import com.google.cloud.managedkafka.v1.ResumeConnectorResponse;
import com.google.cloud.managedkafka.v1.StopConnectorRequest;
import com.google.cloud.managedkafka.v1.StopConnectorResponse;
import com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConnectorRequest;
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
 * gRPC stub implementation for the ManagedKafkaConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcManagedKafkaConnectStub extends ManagedKafkaConnectStub {
  private static final MethodDescriptor<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersMethodDescriptor =
          MethodDescriptor.<ListConnectClustersRequest, ListConnectClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/ListConnectClusters")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectClusterRequest, ConnectCluster>
      getConnectClusterMethodDescriptor =
          MethodDescriptor.<GetConnectClusterRequest, ConnectCluster>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/GetConnectCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectCluster.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectClusterRequest, Operation>
      createConnectClusterMethodDescriptor =
          MethodDescriptor.<CreateConnectClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/CreateConnectCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectClusterRequest, Operation>
      updateConnectClusterMethodDescriptor =
          MethodDescriptor.<UpdateConnectClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/UpdateConnectCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectClusterRequest, Operation>
      deleteConnectClusterMethodDescriptor =
          MethodDescriptor.<DeleteConnectClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/DeleteConnectCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsMethodDescriptor =
          MethodDescriptor.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/ListConnectors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectorRequest, Connector>
      getConnectorMethodDescriptor =
          MethodDescriptor.<GetConnectorRequest, Connector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/GetConnector")
              .setRequestMarshaller(ProtoUtils.marshaller(GetConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectorRequest, Connector>
      createConnectorMethodDescriptor =
          MethodDescriptor.<CreateConnectorRequest, Connector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/CreateConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectorRequest, Connector>
      updateConnectorMethodDescriptor =
          MethodDescriptor.<UpdateConnectorRequest, Connector>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/UpdateConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connector.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectorRequest, Empty>
      deleteConnectorMethodDescriptor =
          MethodDescriptor.<DeleteConnectorRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/DeleteConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PauseConnectorRequest, PauseConnectorResponse>
      pauseConnectorMethodDescriptor =
          MethodDescriptor.<PauseConnectorRequest, PauseConnectorResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/PauseConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PauseConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PauseConnectorResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorMethodDescriptor =
          MethodDescriptor.<ResumeConnectorRequest, ResumeConnectorResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/ResumeConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResumeConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ResumeConnectorResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorMethodDescriptor =
          MethodDescriptor.<RestartConnectorRequest, RestartConnectorResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/RestartConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RestartConnectorResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopConnectorRequest, StopConnectorResponse>
      stopConnectorMethodDescriptor =
          MethodDescriptor.<StopConnectorRequest, StopConnectorResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/StopConnector")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopConnectorRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StopConnectorResponse.getDefaultInstance()))
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

  private final UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable;
  private final UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable;
  private final UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable;
  private final UnaryCallable<CreateConnectClusterRequest, Operation> createConnectClusterCallable;
  private final OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable;
  private final UnaryCallable<UpdateConnectClusterRequest, Operation> updateConnectClusterCallable;
  private final OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable;
  private final UnaryCallable<DeleteConnectClusterRequest, Operation> deleteConnectClusterCallable;
  private final OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable;
  private final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable;
  private final UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable;
  private final UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable;
  private final UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable;
  private final UnaryCallable<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorCallable;
  private final UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorCallable;
  private final UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable;
  private final UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcManagedKafkaConnectStub create(ManagedKafkaConnectStubSettings settings)
      throws IOException {
    return new GrpcManagedKafkaConnectStub(settings, ClientContext.create(settings));
  }

  public static final GrpcManagedKafkaConnectStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcManagedKafkaConnectStub(
        ManagedKafkaConnectStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcManagedKafkaConnectStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcManagedKafkaConnectStub(
        ManagedKafkaConnectStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcManagedKafkaConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedKafkaConnectStub(
      ManagedKafkaConnectStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcManagedKafkaConnectCallableFactory());
  }

  /**
   * Constructs an instance of GrpcManagedKafkaConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcManagedKafkaConnectStub(
      ManagedKafkaConnectStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConnectClustersRequest, ListConnectClustersResponse>
        listConnectClustersTransportSettings =
            GrpcCallSettings.<ListConnectClustersRequest, ListConnectClustersResponse>newBuilder()
                .setMethodDescriptor(listConnectClustersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConnectClusterRequest, ConnectCluster> getConnectClusterTransportSettings =
        GrpcCallSettings.<GetConnectClusterRequest, ConnectCluster>newBuilder()
            .setMethodDescriptor(getConnectClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateConnectClusterRequest, Operation> createConnectClusterTransportSettings =
        GrpcCallSettings.<CreateConnectClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createConnectClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConnectClusterRequest, Operation> updateConnectClusterTransportSettings =
        GrpcCallSettings.<UpdateConnectClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateConnectClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "connect_cluster.name",
                      String.valueOf(request.getConnectCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConnectClusterRequest, Operation> deleteConnectClusterTransportSettings =
        GrpcCallSettings.<DeleteConnectClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConnectClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConnectorsRequest, ListConnectorsResponse>
        listConnectorsTransportSettings =
            GrpcCallSettings.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
                .setMethodDescriptor(listConnectorsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConnectorRequest, Connector> getConnectorTransportSettings =
        GrpcCallSettings.<GetConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(getConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateConnectorRequest, Connector> createConnectorTransportSettings =
        GrpcCallSettings.<CreateConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(createConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConnectorRequest, Connector> updateConnectorTransportSettings =
        GrpcCallSettings.<UpdateConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(updateConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connector.name", String.valueOf(request.getConnector().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConnectorRequest, Empty> deleteConnectorTransportSettings =
        GrpcCallSettings.<DeleteConnectorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PauseConnectorRequest, PauseConnectorResponse>
        pauseConnectorTransportSettings =
            GrpcCallSettings.<PauseConnectorRequest, PauseConnectorResponse>newBuilder()
                .setMethodDescriptor(pauseConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResumeConnectorRequest, ResumeConnectorResponse>
        resumeConnectorTransportSettings =
            GrpcCallSettings.<ResumeConnectorRequest, ResumeConnectorResponse>newBuilder()
                .setMethodDescriptor(resumeConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RestartConnectorRequest, RestartConnectorResponse>
        restartConnectorTransportSettings =
            GrpcCallSettings.<RestartConnectorRequest, RestartConnectorResponse>newBuilder()
                .setMethodDescriptor(restartConnectorMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StopConnectorRequest, StopConnectorResponse> stopConnectorTransportSettings =
        GrpcCallSettings.<StopConnectorRequest, StopConnectorResponse>newBuilder()
            .setMethodDescriptor(stopConnectorMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
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

    this.listConnectClustersCallable =
        callableFactory.createUnaryCallable(
            listConnectClustersTransportSettings,
            settings.listConnectClustersSettings(),
            clientContext);
    this.listConnectClustersPagedCallable =
        callableFactory.createPagedCallable(
            listConnectClustersTransportSettings,
            settings.listConnectClustersSettings(),
            clientContext);
    this.getConnectClusterCallable =
        callableFactory.createUnaryCallable(
            getConnectClusterTransportSettings,
            settings.getConnectClusterSettings(),
            clientContext);
    this.createConnectClusterCallable =
        callableFactory.createUnaryCallable(
            createConnectClusterTransportSettings,
            settings.createConnectClusterSettings(),
            clientContext);
    this.createConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            createConnectClusterTransportSettings,
            settings.createConnectClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConnectClusterCallable =
        callableFactory.createUnaryCallable(
            updateConnectClusterTransportSettings,
            settings.updateConnectClusterSettings(),
            clientContext);
    this.updateConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectClusterTransportSettings,
            settings.updateConnectClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConnectClusterCallable =
        callableFactory.createUnaryCallable(
            deleteConnectClusterTransportSettings,
            settings.deleteConnectClusterSettings(),
            clientContext);
    this.deleteConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectClusterTransportSettings,
            settings.deleteConnectClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.listConnectorsCallable =
        callableFactory.createUnaryCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.listConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.getConnectorCallable =
        callableFactory.createUnaryCallable(
            getConnectorTransportSettings, settings.getConnectorSettings(), clientContext);
    this.createConnectorCallable =
        callableFactory.createUnaryCallable(
            createConnectorTransportSettings, settings.createConnectorSettings(), clientContext);
    this.updateConnectorCallable =
        callableFactory.createUnaryCallable(
            updateConnectorTransportSettings, settings.updateConnectorSettings(), clientContext);
    this.deleteConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteConnectorTransportSettings, settings.deleteConnectorSettings(), clientContext);
    this.pauseConnectorCallable =
        callableFactory.createUnaryCallable(
            pauseConnectorTransportSettings, settings.pauseConnectorSettings(), clientContext);
    this.resumeConnectorCallable =
        callableFactory.createUnaryCallable(
            resumeConnectorTransportSettings, settings.resumeConnectorSettings(), clientContext);
    this.restartConnectorCallable =
        callableFactory.createUnaryCallable(
            restartConnectorTransportSettings, settings.restartConnectorSettings(), clientContext);
    this.stopConnectorCallable =
        callableFactory.createUnaryCallable(
            stopConnectorTransportSettings, settings.stopConnectorSettings(), clientContext);
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
  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable() {
    return listConnectClustersCallable;
  }

  @Override
  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable() {
    return listConnectClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable() {
    return getConnectClusterCallable;
  }

  @Override
  public UnaryCallable<CreateConnectClusterRequest, Operation> createConnectClusterCallable() {
    return createConnectClusterCallable;
  }

  @Override
  public OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable() {
    return createConnectClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectClusterRequest, Operation> updateConnectClusterCallable() {
    return updateConnectClusterCallable;
  }

  @Override
  public OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable() {
    return updateConnectClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectClusterRequest, Operation> deleteConnectClusterCallable() {
    return deleteConnectClusterCallable;
  }

  @Override
  public OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable() {
    return deleteConnectClusterOperationCallable;
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
  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return getConnectorCallable;
  }

  @Override
  public UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable() {
    return createConnectorCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable() {
    return updateConnectorCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable() {
    return deleteConnectorCallable;
  }

  @Override
  public UnaryCallable<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorCallable() {
    return pauseConnectorCallable;
  }

  @Override
  public UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse> resumeConnectorCallable() {
    return resumeConnectorCallable;
  }

  @Override
  public UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable() {
    return restartConnectorCallable;
  }

  @Override
  public UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable() {
    return stopConnectorCallable;
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
