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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListContinuousTestResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.LookupEnvironmentHistoryPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Environment;
import com.google.cloud.dialogflow.cx.v3beta1.GetEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListContinuousTestResultsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListContinuousTestResultsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.LookupEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.cx.v3beta1.LookupEnvironmentHistoryResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestRequest;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateEnvironmentRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEnvironmentsStub extends EnvironmentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DeployFlowResponse.getDescriptor())
          .add(RunContinuousTestMetadata.getDescriptor())
          .add(RunContinuousTestResponse.getDescriptor())
          .add(Environment.getDescriptor())
          .add(DeployFlowMetadata.getDescriptor())
          .add(Struct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsMethodDescriptor =
          ApiMethodDescriptor.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Environments/ListEnvironments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEnvironmentsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/environments",
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

  private static final ApiMethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Environments/GetEnvironment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/environments/*}",
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

  private static final ApiMethodDescriptor<CreateEnvironmentRequest, Operation>
      createEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<CreateEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/CreateEnvironment")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/environments",
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

  private static final ApiMethodDescriptor<UpdateEnvironmentRequest, Operation>
      updateEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<UpdateEnvironmentRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/UpdateEnvironment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{environment.name=projects/*/locations/*/agents/*/environments/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEnvironmentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment.name", request.getEnvironment().getName());
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

  private static final ApiMethodDescriptor<DeleteEnvironmentRequest, Empty>
      deleteEnvironmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteEnvironmentRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/DeleteEnvironment")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEnvironmentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/environments/*}",
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryMethodDescriptor =
          ApiMethodDescriptor
              .<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/LookupEnvironmentHistory")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<LookupEnvironmentHistoryRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/environments/*}:lookupEnvironmentHistory",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<LookupEnvironmentHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<LookupEnvironmentHistoryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LookupEnvironmentHistoryResponse>newBuilder()
                      .setDefaultInstance(LookupEnvironmentHistoryResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunContinuousTestRequest, Operation>
      runContinuousTestMethodDescriptor =
          ApiMethodDescriptor.<RunContinuousTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/RunContinuousTest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunContinuousTestRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{environment=projects/*/locations/*/agents/*/environments/*}:runContinuousTest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunContinuousTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunContinuousTestRequest> serializer =
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
                  (RunContinuousTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsMethodDescriptor =
          ApiMethodDescriptor
              .<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Environments/ListContinuousTestResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListContinuousTestResultsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/environments/*}/continuousTestResults",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListContinuousTestResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListContinuousTestResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListContinuousTestResultsResponse>newBuilder()
                      .setDefaultInstance(ListContinuousTestResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeployFlowRequest, Operation>
      deployFlowMethodDescriptor =
          ApiMethodDescriptor.<DeployFlowRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Environments/DeployFlow")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployFlowRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{environment=projects/*/locations/*/agents/*/environments/*}:deployFlow",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployFlowRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "environment", request.getEnvironment());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployFlowRequest> serializer =
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
                  (DeployFlowRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListEnvironmentsRequest, ListEnvironmentsResponse>
        listEnvironmentsTransportSettings =
            HttpJsonCallSettings.<ListEnvironmentsRequest, ListEnvironmentsResponse>newBuilder()
                .setMethodDescriptor(listEnvironmentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        HttpJsonCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentTransportSettings =
        HttpJsonCallSettings.<CreateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(createEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateEnvironmentRequest, Operation> updateEnvironmentTransportSettings =
        HttpJsonCallSettings.<UpdateEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(updateEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteEnvironmentRequest, Empty> deleteEnvironmentTransportSettings =
        HttpJsonCallSettings.<DeleteEnvironmentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteEnvironmentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
        lookupEnvironmentHistoryTransportSettings =
            HttpJsonCallSettings
                .<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>newBuilder()
                .setMethodDescriptor(lookupEnvironmentHistoryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RunContinuousTestRequest, Operation> runContinuousTestTransportSettings =
        HttpJsonCallSettings.<RunContinuousTestRequest, Operation>newBuilder()
            .setMethodDescriptor(runContinuousTestMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
        listContinuousTestResultsTransportSettings =
            HttpJsonCallSettings
                .<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>newBuilder()
                .setMethodDescriptor(listContinuousTestResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeployFlowRequest, Operation> deployFlowTransportSettings =
        HttpJsonCallSettings.<DeployFlowRequest, Operation>newBuilder()
            .setMethodDescriptor(deployFlowMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listEnvironmentsMethodDescriptor);
    methodDescriptors.add(getEnvironmentMethodDescriptor);
    methodDescriptors.add(createEnvironmentMethodDescriptor);
    methodDescriptors.add(updateEnvironmentMethodDescriptor);
    methodDescriptors.add(deleteEnvironmentMethodDescriptor);
    methodDescriptors.add(lookupEnvironmentHistoryMethodDescriptor);
    methodDescriptors.add(runContinuousTestMethodDescriptor);
    methodDescriptors.add(listContinuousTestResultsMethodDescriptor);
    methodDescriptors.add(deployFlowMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
