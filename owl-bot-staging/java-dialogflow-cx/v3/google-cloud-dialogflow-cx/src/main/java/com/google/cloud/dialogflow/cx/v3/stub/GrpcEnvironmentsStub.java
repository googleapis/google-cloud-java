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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.ListContinuousTestResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.LookupEnvironmentHistoryPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.DeployFlowMetadata;
import com.google.cloud.dialogflow.cx.v3.DeployFlowRequest;
import com.google.cloud.dialogflow.cx.v3.DeployFlowResponse;
import com.google.cloud.dialogflow.cx.v3.Environment;
import com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest;
import com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse;
import com.google.cloud.dialogflow.cx.v3.RunContinuousTestMetadata;
import com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest;
import com.google.cloud.dialogflow.cx.v3.RunContinuousTestResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcEnvironmentsStub extends EnvironmentsStub {
  private static final MethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          MethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/ListEnvironments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          MethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/GetEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Environment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          MethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/CreateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEnvironmentRequest, Operation>
      updateEnvironmentMethodDescriptor =
          MethodDescriptor.<UpdateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/UpdateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEnvironmentRequest, Empty>
      deleteEnvironmentMethodDescriptor =
          MethodDescriptor.<DeleteEnvironmentRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/DeleteEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryMethodDescriptor =
          MethodDescriptor
              .<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.Environments/LookupEnvironmentHistory")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(LookupEnvironmentHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(LookupEnvironmentHistoryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RunContinuousTestRequest, Operation>
      runContinuousTestMethodDescriptor =
          MethodDescriptor.<RunContinuousTestRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/RunContinuousTest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RunContinuousTestRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsMethodDescriptor =
          MethodDescriptor
              .<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3.Environments/ListContinuousTestResults")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListContinuousTestResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListContinuousTestResultsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeployFlowRequest, Operation> deployFlowMethodDescriptor =
      MethodDescriptor.<DeployFlowRequest, Operation>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Environments/DeployFlow")
          .setRequestMarshaller(ProtoUtils.marshaller(DeployFlowRequest.getDefaultInstance()))
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

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable;
  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable;
  private final OperationCallable<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationCallable;
  private final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable;
  private final OperationCallable<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationCallable;
  private final UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable;
  private final UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryCallable;
  private final UnaryCallable<
          LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistoryPagedCallable;
  private final UnaryCallable<RunContinuousTestRequest, Operation> runContinuousTestCallable;
  private final OperationCallable<
          RunContinuousTestRequest, RunContinuousTestResponse, RunContinuousTestMetadata>
      runContinuousTestOperationCallable;
  private final UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsCallable;
  private final UnaryCallable<
          ListContinuousTestResultsRequest, ListContinuousTestResultsPagedResponse>
      listContinuousTestResultsPagedCallable;
  private final UnaryCallable<DeployFlowRequest, Operation> deployFlowCallable;
  private final OperationCallable<DeployFlowRequest, DeployFlowResponse, DeployFlowMetadata>
      deployFlowOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEnvironmentsStub create(EnvironmentsStubSettings settings)
      throws IOException {
    return new GrpcEnvironmentsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEnvironmentsStub create(ClientContext clientContext) throws IOException {
    return new GrpcEnvironmentsStub(EnvironmentsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEnvironmentsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEnvironmentsStub(
        EnvironmentsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEnvironmentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEnvironmentsStub(EnvironmentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcEnvironmentsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEnvironmentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcEnvironmentsStub(
      EnvironmentsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            GrpcCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        GrpcCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentTransportSettings =
        GrpcCallSettings.<CreateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        GrpcCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "environment.name", String.valueOf(request.getEnvironment().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEnvironmentRequest, Empty> deleteEnvironmentTransportSettings =
        GrpcCallSettings.<DeleteEnvironmentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
        lookupEnvironmentHistoryTransportSettings =
            GrpcCallSettings
                .<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>newBuilder()
                .setMethodDescriptor(lookupEnvironmentHistoryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RunContinuousTestRequest, Operation> runContinuousTestTransportSettings =
        GrpcCallSettings.<RunContinuousTestRequest, Operation>newBuilder()
            .setMethodDescriptor(runContinuousTestMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("environment", String.valueOf(request.getEnvironment()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
        listContinuousTestResultsTransportSettings =
            GrpcCallSettings
                .<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>newBuilder()
                .setMethodDescriptor(listContinuousTestResultsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeployFlowRequest, Operation> deployFlowTransportSettings =
        GrpcCallSettings.<DeployFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(deployFlowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("environment", String.valueOf(request.getEnvironment()));
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

    this.listEnvironmentsCallable =
        callableFactory.createUnaryCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.listEnvironmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.createEnvironmentCallable =
        callableFactory.createUnaryCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentSettings(),
            clientContext);
    this.createEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            createEnvironmentTransportSettings,
            settings.createEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.updateEnvironmentCallable =
        callableFactory.createUnaryCallable(
            updateEnvironmentTransportSettings,
            settings.updateEnvironmentSettings(),
            clientContext);
    this.updateEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            updateEnvironmentTransportSettings,
            settings.updateEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteEnvironmentCallable =
        callableFactory.createUnaryCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentSettings(),
            clientContext);
    this.lookupEnvironmentHistoryCallable =
        callableFactory.createUnaryCallable(
            lookupEnvironmentHistoryTransportSettings,
            settings.lookupEnvironmentHistorySettings(),
            clientContext);
    this.lookupEnvironmentHistoryPagedCallable =
        callableFactory.createPagedCallable(
            lookupEnvironmentHistoryTransportSettings,
            settings.lookupEnvironmentHistorySettings(),
            clientContext);
    this.runContinuousTestCallable =
        callableFactory.createUnaryCallable(
            runContinuousTestTransportSettings,
            settings.runContinuousTestSettings(),
            clientContext);
    this.runContinuousTestOperationCallable =
        callableFactory.createOperationCallable(
            runContinuousTestTransportSettings,
            settings.runContinuousTestOperationSettings(),
            clientContext,
            operationsStub);
    this.listContinuousTestResultsCallable =
        callableFactory.createUnaryCallable(
            listContinuousTestResultsTransportSettings,
            settings.listContinuousTestResultsSettings(),
            clientContext);
    this.listContinuousTestResultsPagedCallable =
        callableFactory.createPagedCallable(
            listContinuousTestResultsTransportSettings,
            settings.listContinuousTestResultsSettings(),
            clientContext);
    this.deployFlowCallable =
        callableFactory.createUnaryCallable(
            deployFlowTransportSettings, settings.deployFlowSettings(), clientContext);
    this.deployFlowOperationCallable =
        callableFactory.createOperationCallable(
            deployFlowTransportSettings,
            settings.deployFlowOperationSettings(),
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
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    return listEnvironmentsCallable;
  }

  @Override
  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    return listEnvironmentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
  }

  @Override
  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return createEnvironmentCallable;
  }

  @Override
  public OperationCallable<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationCallable() {
    return createEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return updateEnvironmentCallable;
  }

  @Override
  public OperationCallable<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationCallable() {
    return updateEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable() {
    return deleteEnvironmentCallable;
  }

  @Override
  public UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryCallable() {
    return lookupEnvironmentHistoryCallable;
  }

  @Override
  public UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistoryPagedCallable() {
    return lookupEnvironmentHistoryPagedCallable;
  }

  @Override
  public UnaryCallable<RunContinuousTestRequest, Operation> runContinuousTestCallable() {
    return runContinuousTestCallable;
  }

  @Override
  public OperationCallable<
          RunContinuousTestRequest, RunContinuousTestResponse, RunContinuousTestMetadata>
      runContinuousTestOperationCallable() {
    return runContinuousTestOperationCallable;
  }

  @Override
  public UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsCallable() {
    return listContinuousTestResultsCallable;
  }

  @Override
  public UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsPagedResponse>
      listContinuousTestResultsPagedCallable() {
    return listContinuousTestResultsPagedCallable;
  }

  @Override
  public UnaryCallable<DeployFlowRequest, Operation> deployFlowCallable() {
    return deployFlowCallable;
  }

  @Override
  public OperationCallable<DeployFlowRequest, DeployFlowResponse, DeployFlowMetadata>
      deployFlowOperationCallable() {
    return deployFlowOperationCallable;
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
