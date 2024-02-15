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

package com.google.cloud.orchestration.airflow.service.v1beta1.stub;

import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListUserWorkloadsConfigMapsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListUserWorkloadsSecretsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1beta1.EnvironmentsClient.ListWorkloadsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CheckUpgradeResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.CreateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DatabaseFailoverResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.DeleteUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.Environment;
import com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ExecuteAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.FetchDatabasePropertiesResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.GetUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListEnvironmentsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsConfigMapsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListUserWorkloadsSecretsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.ListWorkloadsResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.LoadSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.OperationMetadata;
import com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.PollAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.RestartWebServerRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.SaveSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.StopAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UpdateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsConfigMap;
import com.google.cloud.orchestration.airflow.service.v1beta1.UserWorkloadsSecret;
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

  private static final MethodDescriptor<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandMethodDescriptor =
          MethodDescriptor.<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/ExecuteAirflowCommand")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExecuteAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ExecuteAirflowCommandResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandMethodDescriptor =
          MethodDescriptor.<StopAirflowCommandRequest, StopAirflowCommandResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/StopAirflowCommand")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StopAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StopAirflowCommandResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandMethodDescriptor =
          MethodDescriptor.<PollAirflowCommandRequest, PollAirflowCommandResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/PollAirflowCommand")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PollAirflowCommandRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PollAirflowCommandResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          MethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/ListWorkloads")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListWorkloadsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretMethodDescriptor =
          MethodDescriptor.<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/CreateUserWorkloadsSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretMethodDescriptor =
          MethodDescriptor.<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/GetUserWorkloadsSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
      listUserWorkloadsSecretsMethodDescriptor =
          MethodDescriptor
              .<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/ListUserWorkloadsSecrets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserWorkloadsSecretsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserWorkloadsSecretsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretMethodDescriptor =
          MethodDescriptor.<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/UpdateUserWorkloadsSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsSecret.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretMethodDescriptor =
          MethodDescriptor.<DeleteUserWorkloadsSecretRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/DeleteUserWorkloadsSecret")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserWorkloadsSecretRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapMethodDescriptor =
          MethodDescriptor.<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/CreateUserWorkloadsConfigMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsConfigMap.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapMethodDescriptor =
          MethodDescriptor.<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/GetUserWorkloadsConfigMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsConfigMap.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
      listUserWorkloadsConfigMapsMethodDescriptor =
          MethodDescriptor
              .<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/ListUserWorkloadsConfigMaps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUserWorkloadsConfigMapsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUserWorkloadsConfigMapsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapMethodDescriptor =
          MethodDescriptor.<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/UpdateUserWorkloadsConfigMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(UserWorkloadsConfigMap.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapMethodDescriptor =
          MethodDescriptor.<DeleteUserWorkloadsConfigMapRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/DeleteUserWorkloadsConfigMap")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUserWorkloadsConfigMapRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SaveSnapshotRequest, Operation>
      saveSnapshotMethodDescriptor =
          MethodDescriptor.<SaveSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/SaveSnapshot")
              .setRequestMarshaller(ProtoUtils.marshaller(SaveSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<LoadSnapshotRequest, Operation>
      loadSnapshotMethodDescriptor =
          MethodDescriptor.<LoadSnapshotRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/LoadSnapshot")
              .setRequestMarshaller(ProtoUtils.marshaller(LoadSnapshotRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DatabaseFailoverRequest, Operation>
      databaseFailoverMethodDescriptor =
          MethodDescriptor.<DatabaseFailoverRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/DatabaseFailover")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DatabaseFailoverRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesMethodDescriptor =
          MethodDescriptor
              .<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1beta1.Environments/FetchDatabaseProperties")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchDatabasePropertiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchDatabasePropertiesResponse.getDefaultInstance()))
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
  private final UnaryCallable<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandCallable;
  private final UnaryCallable<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandCallable;
  private final UnaryCallable<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable;
  private final UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable;
  private final UnaryCallable<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretCallable;
  private final UnaryCallable<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretCallable;
  private final UnaryCallable<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
      listUserWorkloadsSecretsCallable;
  private final UnaryCallable<
          ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsPagedResponse>
      listUserWorkloadsSecretsPagedCallable;
  private final UnaryCallable<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretCallable;
  private final UnaryCallable<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretCallable;
  private final UnaryCallable<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapCallable;
  private final UnaryCallable<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapCallable;
  private final UnaryCallable<
          ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
      listUserWorkloadsConfigMapsCallable;
  private final UnaryCallable<
          ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsPagedResponse>
      listUserWorkloadsConfigMapsPagedCallable;
  private final UnaryCallable<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapCallable;
  private final UnaryCallable<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapCallable;
  private final UnaryCallable<SaveSnapshotRequest, Operation> saveSnapshotCallable;
  private final OperationCallable<SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
      saveSnapshotOperationCallable;
  private final UnaryCallable<LoadSnapshotRequest, Operation> loadSnapshotCallable;
  private final OperationCallable<LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
      loadSnapshotOperationCallable;
  private final UnaryCallable<DatabaseFailoverRequest, Operation> databaseFailoverCallable;
  private final OperationCallable<
          DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
      databaseFailoverOperationCallable;
  private final UnaryCallable<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesCallable;

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
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        GrpcCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            GrpcCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        GrpcCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentTransportSettings =
        GrpcCallSettings.<DeleteEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RestartWebServerRequest, Operation> restartWebServerTransportSettings =
        GrpcCallSettings.<RestartWebServerRequest, Operation>newBuilder()
            .setMethodDescriptor(restartWebServerMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CheckUpgradeRequest, Operation> checkUpgradeTransportSettings =
        GrpcCallSettings.<CheckUpgradeRequest, Operation>newBuilder()
            .setMethodDescriptor(checkUpgradeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
        executeAirflowCommandTransportSettings =
            GrpcCallSettings
                .<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(executeAirflowCommandMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StopAirflowCommandRequest, StopAirflowCommandResponse>
        stopAirflowCommandTransportSettings =
            GrpcCallSettings.<StopAirflowCommandRequest, StopAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(stopAirflowCommandMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PollAirflowCommandRequest, PollAirflowCommandResponse>
        pollAirflowCommandTransportSettings =
            GrpcCallSettings.<PollAirflowCommandRequest, PollAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(pollAirflowCommandMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsTransportSettings =
        GrpcCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
            .setMethodDescriptor(listWorkloadsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        createUserWorkloadsSecretTransportSettings =
            GrpcCallSettings.<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(createUserWorkloadsSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
        getUserWorkloadsSecretTransportSettings =
            GrpcCallSettings.<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(getUserWorkloadsSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
        listUserWorkloadsSecretsTransportSettings =
            GrpcCallSettings
                .<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>newBuilder()
                .setMethodDescriptor(listUserWorkloadsSecretsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        updateUserWorkloadsSecretTransportSettings =
            GrpcCallSettings.<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(updateUserWorkloadsSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_workloads_secret.name",
                          String.valueOf(request.getUserWorkloadsSecret().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteUserWorkloadsSecretRequest, Empty>
        deleteUserWorkloadsSecretTransportSettings =
            GrpcCallSettings.<DeleteUserWorkloadsSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUserWorkloadsSecretMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        createUserWorkloadsConfigMapTransportSettings =
            GrpcCallSettings
                .<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(createUserWorkloadsConfigMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        getUserWorkloadsConfigMapTransportSettings =
            GrpcCallSettings.<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(getUserWorkloadsConfigMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
        listUserWorkloadsConfigMapsTransportSettings =
            GrpcCallSettings
                .<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
                    newBuilder()
                .setMethodDescriptor(listUserWorkloadsConfigMapsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        updateUserWorkloadsConfigMapTransportSettings =
            GrpcCallSettings
                .<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(updateUserWorkloadsConfigMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_workloads_config_map.name",
                          String.valueOf(request.getUserWorkloadsConfigMap().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteUserWorkloadsConfigMapRequest, Empty>
        deleteUserWorkloadsConfigMapTransportSettings =
            GrpcCallSettings.<DeleteUserWorkloadsConfigMapRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUserWorkloadsConfigMapMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SaveSnapshotRequest, Operation> saveSnapshotTransportSettings =
        GrpcCallSettings.<SaveSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(saveSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<LoadSnapshotRequest, Operation> loadSnapshotTransportSettings =
        GrpcCallSettings.<LoadSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(loadSnapshotMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DatabaseFailoverRequest, Operation> databaseFailoverTransportSettings =
        GrpcCallSettings.<DatabaseFailoverRequest, Operation>newBuilder()
            .setMethodDescriptor(databaseFailoverMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
        fetchDatabasePropertiesTransportSettings =
            GrpcCallSettings
                .<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>newBuilder()
                .setMethodDescriptor(fetchDatabasePropertiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
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
    this.executeAirflowCommandCallable =
        callableFactory.createUnaryCallable(
            executeAirflowCommandTransportSettings,
            settings.executeAirflowCommandSettings(),
            clientContext);
    this.stopAirflowCommandCallable =
        callableFactory.createUnaryCallable(
            stopAirflowCommandTransportSettings,
            settings.stopAirflowCommandSettings(),
            clientContext);
    this.pollAirflowCommandCallable =
        callableFactory.createUnaryCallable(
            pollAirflowCommandTransportSettings,
            settings.pollAirflowCommandSettings(),
            clientContext);
    this.listWorkloadsCallable =
        callableFactory.createUnaryCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.listWorkloadsPagedCallable =
        callableFactory.createPagedCallable(
            listWorkloadsTransportSettings, settings.listWorkloadsSettings(), clientContext);
    this.createUserWorkloadsSecretCallable =
        callableFactory.createUnaryCallable(
            createUserWorkloadsSecretTransportSettings,
            settings.createUserWorkloadsSecretSettings(),
            clientContext);
    this.getUserWorkloadsSecretCallable =
        callableFactory.createUnaryCallable(
            getUserWorkloadsSecretTransportSettings,
            settings.getUserWorkloadsSecretSettings(),
            clientContext);
    this.listUserWorkloadsSecretsCallable =
        callableFactory.createUnaryCallable(
            listUserWorkloadsSecretsTransportSettings,
            settings.listUserWorkloadsSecretsSettings(),
            clientContext);
    this.listUserWorkloadsSecretsPagedCallable =
        callableFactory.createPagedCallable(
            listUserWorkloadsSecretsTransportSettings,
            settings.listUserWorkloadsSecretsSettings(),
            clientContext);
    this.updateUserWorkloadsSecretCallable =
        callableFactory.createUnaryCallable(
            updateUserWorkloadsSecretTransportSettings,
            settings.updateUserWorkloadsSecretSettings(),
            clientContext);
    this.deleteUserWorkloadsSecretCallable =
        callableFactory.createUnaryCallable(
            deleteUserWorkloadsSecretTransportSettings,
            settings.deleteUserWorkloadsSecretSettings(),
            clientContext);
    this.createUserWorkloadsConfigMapCallable =
        callableFactory.createUnaryCallable(
            createUserWorkloadsConfigMapTransportSettings,
            settings.createUserWorkloadsConfigMapSettings(),
            clientContext);
    this.getUserWorkloadsConfigMapCallable =
        callableFactory.createUnaryCallable(
            getUserWorkloadsConfigMapTransportSettings,
            settings.getUserWorkloadsConfigMapSettings(),
            clientContext);
    this.listUserWorkloadsConfigMapsCallable =
        callableFactory.createUnaryCallable(
            listUserWorkloadsConfigMapsTransportSettings,
            settings.listUserWorkloadsConfigMapsSettings(),
            clientContext);
    this.listUserWorkloadsConfigMapsPagedCallable =
        callableFactory.createPagedCallable(
            listUserWorkloadsConfigMapsTransportSettings,
            settings.listUserWorkloadsConfigMapsSettings(),
            clientContext);
    this.updateUserWorkloadsConfigMapCallable =
        callableFactory.createUnaryCallable(
            updateUserWorkloadsConfigMapTransportSettings,
            settings.updateUserWorkloadsConfigMapSettings(),
            clientContext);
    this.deleteUserWorkloadsConfigMapCallable =
        callableFactory.createUnaryCallable(
            deleteUserWorkloadsConfigMapTransportSettings,
            settings.deleteUserWorkloadsConfigMapSettings(),
            clientContext);
    this.saveSnapshotCallable =
        callableFactory.createUnaryCallable(
            saveSnapshotTransportSettings, settings.saveSnapshotSettings(), clientContext);
    this.saveSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            saveSnapshotTransportSettings,
            settings.saveSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.loadSnapshotCallable =
        callableFactory.createUnaryCallable(
            loadSnapshotTransportSettings, settings.loadSnapshotSettings(), clientContext);
    this.loadSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            loadSnapshotTransportSettings,
            settings.loadSnapshotOperationSettings(),
            clientContext,
            operationsStub);
    this.databaseFailoverCallable =
        callableFactory.createUnaryCallable(
            databaseFailoverTransportSettings, settings.databaseFailoverSettings(), clientContext);
    this.databaseFailoverOperationCallable =
        callableFactory.createOperationCallable(
            databaseFailoverTransportSettings,
            settings.databaseFailoverOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchDatabasePropertiesCallable =
        callableFactory.createUnaryCallable(
            fetchDatabasePropertiesTransportSettings,
            settings.fetchDatabasePropertiesSettings(),
            clientContext);

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
  public UnaryCallable<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandCallable() {
    return executeAirflowCommandCallable;
  }

  @Override
  public UnaryCallable<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandCallable() {
    return stopAirflowCommandCallable;
  }

  @Override
  public UnaryCallable<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandCallable() {
    return pollAirflowCommandCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsResponse> listWorkloadsCallable() {
    return listWorkloadsCallable;
  }

  @Override
  public UnaryCallable<ListWorkloadsRequest, ListWorkloadsPagedResponse>
      listWorkloadsPagedCallable() {
    return listWorkloadsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretCallable() {
    return createUserWorkloadsSecretCallable;
  }

  @Override
  public UnaryCallable<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretCallable() {
    return getUserWorkloadsSecretCallable;
  }

  @Override
  public UnaryCallable<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
      listUserWorkloadsSecretsCallable() {
    return listUserWorkloadsSecretsCallable;
  }

  @Override
  public UnaryCallable<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsPagedResponse>
      listUserWorkloadsSecretsPagedCallable() {
    return listUserWorkloadsSecretsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretCallable() {
    return updateUserWorkloadsSecretCallable;
  }

  @Override
  public UnaryCallable<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretCallable() {
    return deleteUserWorkloadsSecretCallable;
  }

  @Override
  public UnaryCallable<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapCallable() {
    return createUserWorkloadsConfigMapCallable;
  }

  @Override
  public UnaryCallable<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapCallable() {
    return getUserWorkloadsConfigMapCallable;
  }

  @Override
  public UnaryCallable<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
      listUserWorkloadsConfigMapsCallable() {
    return listUserWorkloadsConfigMapsCallable;
  }

  @Override
  public UnaryCallable<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsPagedResponse>
      listUserWorkloadsConfigMapsPagedCallable() {
    return listUserWorkloadsConfigMapsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapCallable() {
    return updateUserWorkloadsConfigMapCallable;
  }

  @Override
  public UnaryCallable<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapCallable() {
    return deleteUserWorkloadsConfigMapCallable;
  }

  @Override
  public UnaryCallable<SaveSnapshotRequest, Operation> saveSnapshotCallable() {
    return saveSnapshotCallable;
  }

  @Override
  public OperationCallable<SaveSnapshotRequest, SaveSnapshotResponse, OperationMetadata>
      saveSnapshotOperationCallable() {
    return saveSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<LoadSnapshotRequest, Operation> loadSnapshotCallable() {
    return loadSnapshotCallable;
  }

  @Override
  public OperationCallable<LoadSnapshotRequest, LoadSnapshotResponse, OperationMetadata>
      loadSnapshotOperationCallable() {
    return loadSnapshotOperationCallable;
  }

  @Override
  public UnaryCallable<DatabaseFailoverRequest, Operation> databaseFailoverCallable() {
    return databaseFailoverCallable;
  }

  @Override
  public OperationCallable<DatabaseFailoverRequest, DatabaseFailoverResponse, OperationMetadata>
      databaseFailoverOperationCallable() {
    return databaseFailoverOperationCallable;
  }

  @Override
  public UnaryCallable<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesCallable() {
    return fetchDatabasePropertiesCallable;
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
