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

package com.google.cloud.orchestration.airflow.service.v1beta1.stub;

import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.Environment;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.OperationMetadata;
import com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest;
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
 * gRPC stub implementation for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEnvironmentsStub extends EnvironmentsStub {
  private static final MethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          MethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/CreateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          MethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/GetEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Environment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          MethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/ListEnvironments")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListEnvironmentsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateEnvironmentRequest, Operation>
      updateEnvironmentMethodDescriptor =
          MethodDescriptor.<UpdateEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/UpdateEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteEnvironmentRequest, Operation>
      deleteEnvironmentMethodDescriptor =
          MethodDescriptor.<DeleteEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/DeleteEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestartWebServerRequest, Operation>
      restartWebServerMethodDescriptor =
          MethodDescriptor.<RestartWebServerRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/RestartWebServer")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestartWebServerRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckUpgradeRequest, Operation>
      checkUpgradeMethodDescriptor =
          MethodDescriptor.<CheckUpgradeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/CheckUpgrade")
              .setRequestMarshaller(ProtoUtils.marshaller(CheckUpgradeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable;
  private final OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable;
  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable;
  private final UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable;
  private final UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable;
  private final OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable;
  private final UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable;
  private final OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable;
  private final UnaryCallable<RestartWebServerRequest, Operation> restartWebServerCallable;
  private final OperationCallable<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationCallable;
  private final UnaryCallable<CheckUpgradeRequest, Operation> checkUpgradeCallable;
  private final OperationCallable<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationCallable;

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
    GrpcCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        GrpcCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentTransportSettings =
        GrpcCallSettings.<DeleteEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RestartWebServerRequest, Operation> restartWebServerTransportSettings =
        GrpcCallSettings.<RestartWebServerRequest, Operation>newBuilder()
            .setMethodDescriptor(restartWebServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CheckUpgradeRequest, Operation> checkUpgradeTransportSettings =
        GrpcCallSettings.<CheckUpgradeRequest, Operation>newBuilder()
            .setMethodDescriptor(checkUpgradeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("environment", String.valueOf(request.getEnvironment()));
                  return params.build();
                })
            .build();

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
    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.listEnvironmentsCallable =
        callableFactory.createUnaryCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
    this.listEnvironmentsPagedCallable =
        callableFactory.createPagedCallable(
            listEnvironmentsTransportSettings, settings.listEnvironmentsSettings(), clientContext);
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
    this.deleteEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            deleteEnvironmentTransportSettings,
            settings.deleteEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.restartWebServerCallable =
        callableFactory.createUnaryCallable(
            restartWebServerTransportSettings, settings.restartWebServerSettings(), clientContext);
    this.restartWebServerOperationCallable =
        callableFactory.createOperationCallable(
            restartWebServerTransportSettings,
            settings.restartWebServerOperationSettings(),
            clientContext,
            operationsStub);
    this.checkUpgradeCallable =
        callableFactory.createUnaryCallable(
            checkUpgradeTransportSettings, settings.checkUpgradeSettings(), clientContext);
    this.checkUpgradeOperationCallable =
        callableFactory.createOperationCallable(
            checkUpgradeTransportSettings,
            settings.checkUpgradeOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    return createEnvironmentCallable;
  }

  @Override
  public OperationCallable<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationCallable() {
    return createEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
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
  public UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    return updateEnvironmentCallable;
  }

  @Override
  public OperationCallable<UpdateEnvironmentRequest, Environment, OperationMetadata>
      updateEnvironmentOperationCallable() {
    return updateEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEnvironmentRequest, Operation> deleteEnvironmentCallable() {
    return deleteEnvironmentCallable;
  }

  @Override
  public OperationCallable<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationCallable() {
    return deleteEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<RestartWebServerRequest, Operation> restartWebServerCallable() {
    return restartWebServerCallable;
  }

  @Override
  public OperationCallable<RestartWebServerRequest, Environment, OperationMetadata>
      restartWebServerOperationCallable() {
    return restartWebServerOperationCallable;
  }

  @Override
  public UnaryCallable<CheckUpgradeRequest, Operation> checkUpgradeCallable() {
    return checkUpgradeCallable;
  }

  @Override
  public OperationCallable<CheckUpgradeRequest, CheckUpgradeResponse, OperationMetadata>
      checkUpgradeOperationCallable() {
    return checkUpgradeOperationCallable;
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
