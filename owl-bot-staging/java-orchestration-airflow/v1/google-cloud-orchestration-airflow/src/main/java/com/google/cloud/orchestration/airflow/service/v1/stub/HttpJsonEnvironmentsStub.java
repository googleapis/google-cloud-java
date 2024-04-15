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

package com.google.cloud.orchestration.airflow.service.v1.stub;

import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsConfigMapsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListUserWorkloadsSecretsPagedResponse;
import static com.google.cloud.orchestration.airflow.service.v1.EnvironmentsClient.ListWorkloadsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.orchestration.airflow.service.v1.CreateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1.CreateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1.CreateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1.DatabaseFailoverRequest;
import com.google.cloud.orchestration.airflow.service.v1.DatabaseFailoverResponse;
import com.google.cloud.orchestration.airflow.service.v1.DeleteEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1.DeleteUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1.DeleteUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1.Environment;
import com.google.cloud.orchestration.airflow.service.v1.ExecuteAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1.ExecuteAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1.FetchDatabasePropertiesRequest;
import com.google.cloud.orchestration.airflow.service.v1.FetchDatabasePropertiesResponse;
import com.google.cloud.orchestration.airflow.service.v1.GetEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1.GetUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1.GetUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListEnvironmentsResponse;
import com.google.cloud.orchestration.airflow.service.v1.ListUserWorkloadsConfigMapsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListUserWorkloadsConfigMapsResponse;
import com.google.cloud.orchestration.airflow.service.v1.ListUserWorkloadsSecretsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListUserWorkloadsSecretsResponse;
import com.google.cloud.orchestration.airflow.service.v1.ListWorkloadsRequest;
import com.google.cloud.orchestration.airflow.service.v1.ListWorkloadsResponse;
import com.google.cloud.orchestration.airflow.service.v1.LoadSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1.LoadSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1.OperationMetadata;
import com.google.cloud.orchestration.airflow.service.v1.PollAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1.PollAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1.SaveSnapshotRequest;
import com.google.cloud.orchestration.airflow.service.v1.SaveSnapshotResponse;
import com.google.cloud.orchestration.airflow.service.v1.StopAirflowCommandRequest;
import com.google.cloud.orchestration.airflow.service.v1.StopAirflowCommandResponse;
import com.google.cloud.orchestration.airflow.service.v1.UpdateEnvironmentRequest;
import com.google.cloud.orchestration.airflow.service.v1.UpdateUserWorkloadsConfigMapRequest;
import com.google.cloud.orchestration.airflow.service.v1.UpdateUserWorkloadsSecretRequest;
import com.google.cloud.orchestration.airflow.service.v1.UserWorkloadsConfigMap;
import com.google.cloud.orchestration.airflow.service.v1.UserWorkloadsSecret;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonEnvironmentsStub extends EnvironmentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DatabaseFailoverResponse.getDescriptor())
          .add(Environment.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(LoadSnapshotResponse.getDescriptor())
          .add(SaveSnapshotResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/CreateEnvironment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/environments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("environment", request.getEnvironment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEnvironmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/GetEnvironment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Environment>newBuilder()
                      .setDefaultInstance(Environment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          ApiMethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/ListEnvironments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEnvironmentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/environments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnvironmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnvironmentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListEnvironmentsResponse>newBuilder()
                      .setDefaultInstance(ListEnvironmentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateEnvironmentRequest, Operation>
      updateEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/UpdateEnvironment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("environment", request.getEnvironment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEnvironmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEnvironmentRequest, Operation>
      deleteEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/DeleteEnvironment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteEnvironmentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
      executeAirflowCommandMethodDescriptor =
          ApiMethodDescriptor
              .<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/ExecuteAirflowCommand")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExecuteAirflowCommandRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:executeAirflowCommand",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExecuteAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExecuteAirflowCommandResponse>newBuilder()
                      .setDefaultInstance(ExecuteAirflowCommandResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StopAirflowCommandRequest, StopAirflowCommandResponse>
      stopAirflowCommandMethodDescriptor =
          ApiMethodDescriptor.<StopAirflowCommandRequest, StopAirflowCommandResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/StopAirflowCommand")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopAirflowCommandRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:stopAirflowCommand",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StopAirflowCommandResponse>newBuilder()
                      .setDefaultInstance(StopAirflowCommandResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PollAirflowCommandRequest, PollAirflowCommandResponse>
      pollAirflowCommandMethodDescriptor =
          ApiMethodDescriptor.<PollAirflowCommandRequest, PollAirflowCommandResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/PollAirflowCommand")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PollAirflowCommandRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:pollAirflowCommand",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PollAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PollAirflowCommandRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PollAirflowCommandResponse>newBuilder()
                      .setDefaultInstance(PollAirflowCommandResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListWorkloadsRequest, ListWorkloadsResponse>
      listWorkloadsMethodDescriptor =
          ApiMethodDescriptor.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/ListWorkloads")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWorkloadsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/environments/*}/workloads",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWorkloadsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWorkloadsResponse>newBuilder()
                      .setDefaultInstance(ListWorkloadsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      createUserWorkloadsSecretMethodDescriptor =
          ApiMethodDescriptor.<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/CreateUserWorkloadsSecret")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserWorkloadsSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/environments/*}/userWorkloadsSecrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userWorkloadsSecret",
                                      request.getUserWorkloadsSecret(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsSecret>newBuilder()
                      .setDefaultInstance(UserWorkloadsSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
      getUserWorkloadsSecretMethodDescriptor =
          ApiMethodDescriptor.<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/GetUserWorkloadsSecret")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserWorkloadsSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*/userWorkloadsSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsSecret>newBuilder()
                      .setDefaultInstance(UserWorkloadsSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
      listUserWorkloadsSecretsMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/ListUserWorkloadsSecrets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserWorkloadsSecretsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/environments/*}/userWorkloadsSecrets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserWorkloadsSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserWorkloadsSecretsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserWorkloadsSecretsResponse>newBuilder()
                      .setDefaultInstance(ListUserWorkloadsSecretsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
      updateUserWorkloadsSecretMethodDescriptor =
          ApiMethodDescriptor.<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/UpdateUserWorkloadsSecret")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserWorkloadsSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{userWorkloadsSecret.name=projects/*/locations/*/environments/*/userWorkloadsSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "userWorkloadsSecret.name",
                                request.getUserWorkloadsSecret().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userWorkloadsSecret",
                                      request.getUserWorkloadsSecret(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsSecret>newBuilder()
                      .setDefaultInstance(UserWorkloadsSecret.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserWorkloadsSecretRequest, Empty>
      deleteUserWorkloadsSecretMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserWorkloadsSecretRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/DeleteUserWorkloadsSecret")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserWorkloadsSecretRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*/userWorkloadsSecrets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserWorkloadsSecretRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      createUserWorkloadsConfigMapMethodDescriptor =
          ApiMethodDescriptor
              .<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/CreateUserWorkloadsConfigMap")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateUserWorkloadsConfigMapRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/environments/*}/userWorkloadsConfigMaps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userWorkloadsConfigMap",
                                      request.getUserWorkloadsConfigMap(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsConfigMap>newBuilder()
                      .setDefaultInstance(UserWorkloadsConfigMap.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      getUserWorkloadsConfigMapMethodDescriptor =
          ApiMethodDescriptor.<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/GetUserWorkloadsConfigMap")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetUserWorkloadsConfigMapRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*/userWorkloadsConfigMaps/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsConfigMap>newBuilder()
                      .setDefaultInstance(UserWorkloadsConfigMap.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
      listUserWorkloadsConfigMapsMethodDescriptor =
          ApiMethodDescriptor
              .<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/ListUserWorkloadsConfigMaps")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListUserWorkloadsConfigMapsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/environments/*}/userWorkloadsConfigMaps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserWorkloadsConfigMapsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListUserWorkloadsConfigMapsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListUserWorkloadsConfigMapsResponse>newBuilder()
                      .setDefaultInstance(ListUserWorkloadsConfigMapsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
      updateUserWorkloadsConfigMapMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/UpdateUserWorkloadsConfigMap")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateUserWorkloadsConfigMapRequest>newBuilder()
                      .setPath(
                          "/v1/{userWorkloadsConfigMap.name=projects/*/locations/*/environments/*/userWorkloadsConfigMaps/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "userWorkloadsConfigMap.name",
                                request.getUserWorkloadsConfigMap().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "userWorkloadsConfigMap",
                                      request.getUserWorkloadsConfigMap(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserWorkloadsConfigMap>newBuilder()
                      .setDefaultInstance(UserWorkloadsConfigMap.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteUserWorkloadsConfigMapRequest, Empty>
      deleteUserWorkloadsConfigMapMethodDescriptor =
          ApiMethodDescriptor.<DeleteUserWorkloadsConfigMapRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/DeleteUserWorkloadsConfigMap")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteUserWorkloadsConfigMapRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/environments/*/userWorkloadsConfigMaps/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteUserWorkloadsConfigMapRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SaveSnapshotRequest, Operation>
      saveSnapshotMethodDescriptor =
          ApiMethodDescriptor.<SaveSnapshotRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/SaveSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SaveSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:saveSnapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SaveSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SaveSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (SaveSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<LoadSnapshotRequest, Operation>
      loadSnapshotMethodDescriptor =
          ApiMethodDescriptor.<LoadSnapshotRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/LoadSnapshot")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LoadSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:loadSnapshot",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LoadSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LoadSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (LoadSnapshotRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DatabaseFailoverRequest, Operation>
      databaseFailoverMethodDescriptor =
          ApiMethodDescriptor.<DatabaseFailoverRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/DatabaseFailover")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DatabaseFailoverRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:databaseFailover",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DatabaseFailoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DatabaseFailoverRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearEnvironment().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DatabaseFailoverRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
      fetchDatabasePropertiesMethodDescriptor =
          ApiMethodDescriptor
              .<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.orchestration.airflow.service.v1.Environments/FetchDatabaseProperties")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchDatabasePropertiesRequest>newBuilder()
                      .setPath(
                          "/v1/{environment=projects/*/locations/*/environments/*}:fetchDatabaseProperties",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDatabasePropertiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchDatabasePropertiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchDatabasePropertiesResponse>newBuilder()
                      .setDefaultInstance(FetchDatabasePropertiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEnvironmentsStub create(EnvironmentsStubSettings settings)
      throws IOException {
    return new HttpJsonEnvironmentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEnvironmentsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEnvironmentsStub(
        EnvironmentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEnvironmentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEnvironmentsStub(
        EnvironmentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEnvironmentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEnvironmentsStub(EnvironmentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonEnvironmentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEnvironmentsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonEnvironmentsStub(
      EnvironmentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentTransportSettings =
        HttpJsonCallSettings.<CreateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        HttpJsonCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            HttpJsonCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        HttpJsonCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentTransportSettings =
        HttpJsonCallSettings.<DeleteEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>
        executeAirflowCommandTransportSettings =
            HttpJsonCallSettings
                .<ExecuteAirflowCommandRequest, ExecuteAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(executeAirflowCommandMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StopAirflowCommandRequest, StopAirflowCommandResponse>
        stopAirflowCommandTransportSettings =
            HttpJsonCallSettings.<StopAirflowCommandRequest, StopAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(stopAirflowCommandMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PollAirflowCommandRequest, PollAirflowCommandResponse>
        pollAirflowCommandTransportSettings =
            HttpJsonCallSettings.<PollAirflowCommandRequest, PollAirflowCommandResponse>newBuilder()
                .setMethodDescriptor(pollAirflowCommandMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("environment", String.valueOf(request.getEnvironment()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListWorkloadsRequest, ListWorkloadsResponse>
        listWorkloadsTransportSettings =
            HttpJsonCallSettings.<ListWorkloadsRequest, ListWorkloadsResponse>newBuilder()
                .setMethodDescriptor(listWorkloadsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        createUserWorkloadsSecretTransportSettings =
            HttpJsonCallSettings.<CreateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(createUserWorkloadsSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>
        getUserWorkloadsSecretTransportSettings =
            HttpJsonCallSettings.<GetUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(getUserWorkloadsSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>
        listUserWorkloadsSecretsTransportSettings =
            HttpJsonCallSettings
                .<ListUserWorkloadsSecretsRequest, ListUserWorkloadsSecretsResponse>newBuilder()
                .setMethodDescriptor(listUserWorkloadsSecretsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>
        updateUserWorkloadsSecretTransportSettings =
            HttpJsonCallSettings.<UpdateUserWorkloadsSecretRequest, UserWorkloadsSecret>newBuilder()
                .setMethodDescriptor(updateUserWorkloadsSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_workloads_secret.name",
                          String.valueOf(request.getUserWorkloadsSecret().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteUserWorkloadsSecretRequest, Empty>
        deleteUserWorkloadsSecretTransportSettings =
            HttpJsonCallSettings.<DeleteUserWorkloadsSecretRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUserWorkloadsSecretMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        createUserWorkloadsConfigMapTransportSettings =
            HttpJsonCallSettings
                .<CreateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(createUserWorkloadsConfigMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        getUserWorkloadsConfigMapTransportSettings =
            HttpJsonCallSettings
                .<GetUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(getUserWorkloadsConfigMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
        listUserWorkloadsConfigMapsTransportSettings =
            HttpJsonCallSettings
                .<ListUserWorkloadsConfigMapsRequest, ListUserWorkloadsConfigMapsResponse>
                    newBuilder()
                .setMethodDescriptor(listUserWorkloadsConfigMapsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>
        updateUserWorkloadsConfigMapTransportSettings =
            HttpJsonCallSettings
                .<UpdateUserWorkloadsConfigMapRequest, UserWorkloadsConfigMap>newBuilder()
                .setMethodDescriptor(updateUserWorkloadsConfigMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "user_workloads_config_map.name",
                          String.valueOf(request.getUserWorkloadsConfigMap().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteUserWorkloadsConfigMapRequest, Empty>
        deleteUserWorkloadsConfigMapTransportSettings =
            HttpJsonCallSettings.<DeleteUserWorkloadsConfigMapRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUserWorkloadsConfigMapMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SaveSnapshotRequest, Operation> saveSnapshotTransportSettings =
        HttpJsonCallSettings.<SaveSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(saveSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<LoadSnapshotRequest, Operation> loadSnapshotTransportSettings =
        HttpJsonCallSettings.<LoadSnapshotRequest, Operation>newBuilder()
            .setMethodDescriptor(loadSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DatabaseFailoverRequest, Operation> databaseFailoverTransportSettings =
        HttpJsonCallSettings.<DatabaseFailoverRequest, Operation>newBuilder()
            .setMethodDescriptor(databaseFailoverMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("environment", String.valueOf(request.getEnvironment()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>
        fetchDatabasePropertiesTransportSettings =
            HttpJsonCallSettings
                .<FetchDatabasePropertiesRequest, FetchDatabasePropertiesResponse>newBuilder()
                .setMethodDescriptor(fetchDatabasePropertiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.loadSnapshotCallable =
        callableFactory.createUnaryCallable(
            loadSnapshotTransportSettings, settings.loadSnapshotSettings(), clientContext);
    this.loadSnapshotOperationCallable =
        callableFactory.createOperationCallable(
            loadSnapshotTransportSettings,
            settings.loadSnapshotOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.databaseFailoverCallable =
        callableFactory.createUnaryCallable(
            databaseFailoverTransportSettings, settings.databaseFailoverSettings(), clientContext);
    this.databaseFailoverOperationCallable =
        callableFactory.createOperationCallable(
            databaseFailoverTransportSettings,
            settings.databaseFailoverOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.fetchDatabasePropertiesCallable =
        callableFactory.createUnaryCallable(
            fetchDatabasePropertiesTransportSettings,
            settings.fetchDatabasePropertiesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createEnvironmentMethodDescriptor);
    methodDescriptors.add(getEnvironmentMethodDescriptor);
    methodDescriptors.add(listEnvironmentsMethodDescriptor);
    methodDescriptors.add(updateEnvironmentMethodDescriptor);
    methodDescriptors.add(deleteEnvironmentMethodDescriptor);
    methodDescriptors.add(executeAirflowCommandMethodDescriptor);
    methodDescriptors.add(stopAirflowCommandMethodDescriptor);
    methodDescriptors.add(pollAirflowCommandMethodDescriptor);
    methodDescriptors.add(listWorkloadsMethodDescriptor);
    methodDescriptors.add(createUserWorkloadsSecretMethodDescriptor);
    methodDescriptors.add(getUserWorkloadsSecretMethodDescriptor);
    methodDescriptors.add(listUserWorkloadsSecretsMethodDescriptor);
    methodDescriptors.add(updateUserWorkloadsSecretMethodDescriptor);
    methodDescriptors.add(deleteUserWorkloadsSecretMethodDescriptor);
    methodDescriptors.add(createUserWorkloadsConfigMapMethodDescriptor);
    methodDescriptors.add(getUserWorkloadsConfigMapMethodDescriptor);
    methodDescriptors.add(listUserWorkloadsConfigMapsMethodDescriptor);
    methodDescriptors.add(updateUserWorkloadsConfigMapMethodDescriptor);
    methodDescriptors.add(deleteUserWorkloadsConfigMapMethodDescriptor);
    methodDescriptors.add(saveSnapshotMethodDescriptor);
    methodDescriptors.add(loadSnapshotMethodDescriptor);
    methodDescriptors.add(databaseFailoverMethodDescriptor);
    methodDescriptors.add(fetchDatabasePropertiesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
