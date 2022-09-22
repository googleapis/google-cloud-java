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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.v2.ConversationModel;
import com.google.cloud.dialogflow.v2.ConversationModelEvaluation;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeployConversationModelRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse;
import com.google.cloud.dialogflow.v2.ListConversationModelsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelsResponse;
import com.google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.UndeployConversationModelRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the ConversationModels service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonConversationModelsStub extends ConversationModelsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DeployConversationModelOperationMetadata.getDescriptor())
          .add(ConversationModel.getDescriptor())
          .add(CreateConversationModelEvaluationOperationMetadata.getDescriptor())
          .add(DeleteConversationModelOperationMetadata.getDescriptor())
          .add(ConversationModelEvaluation.getDescriptor())
          .add(CreateConversationModelOperationMetadata.getDescriptor())
          .add(UndeployConversationModelOperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateConversationModelRequest, Operation>
      createConversationModelMethodDescriptor =
          ApiMethodDescriptor.<CreateConversationModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/CreateConversationModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversationModelRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/conversationModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/conversationModels")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "conversationModel", request.getConversationModel(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConversationModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetConversationModelRequest, ConversationModel>
      getConversationModelMethodDescriptor =
          ApiMethodDescriptor.<GetConversationModelRequest, ConversationModel>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/GetConversationModel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationModelRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{name=projects/*/locations/*/conversationModels/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationModel>newBuilder()
                      .setDefaultInstance(ConversationModel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversationModelsRequest, ListConversationModelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/ListConversationModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationModelsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/conversationModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/conversationModels")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationModelsResponse>newBuilder()
                      .setDefaultInstance(ListConversationModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversationModelRequest, Operation>
      deleteConversationModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversationModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/DeleteConversationModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversationModelRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{name=projects/*/locations/*/conversationModels/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteConversationModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployConversationModelRequest, Operation>
      deployConversationModelMethodDescriptor =
          ApiMethodDescriptor.<DeployConversationModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/DeployConversationModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployConversationModelRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationModels/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationModels/*}:deploy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeployConversationModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeployConversationModelRequest, Operation>
      undeployConversationModelMethodDescriptor =
          ApiMethodDescriptor.<UndeployConversationModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/UndeployConversationModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployConversationModelRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationModels/*}:undeploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationModels/*}:undeploy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployConversationModelRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeployConversationModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationMethodDescriptor =
          ApiMethodDescriptor
              .<GetConversationModelEvaluationRequest, ConversationModelEvaluation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/GetConversationModelEvaluation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationModelEvaluationRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/conversationModels/*/evaluations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationModelEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{name=projects/*/locations/*/conversationModels/*/evaluations/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationModelEvaluationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConversationModelEvaluation>newBuilder()
                      .setDefaultInstance(ConversationModelEvaluation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/ListConversationModelEvaluations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationModelEvaluationsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/conversationModels/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationModelEvaluationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*/conversationModels/*}/evaluations")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationModelEvaluationsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationModelEvaluationsResponse>newBuilder()
                      .setDefaultInstance(
                          ListConversationModelEvaluationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationMethodDescriptor =
          ApiMethodDescriptor.<CreateConversationModelEvaluationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.v2.ConversationModels/CreateConversationModelEvaluation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateConversationModelEvaluationRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/conversationModels/*}/evaluations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationModelEvaluationRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationModelEvaluationRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConversationModelEvaluationRequest request, Operation response) ->
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
                          "/v2/{name=projects/*}/locations",
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
                          "/v2/{name=projects/*/locations/*}",
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

  private final UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable;
  private final OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable;
  private final UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable;
  private final UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable;
  private final UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable;
  private final UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable;
  private final OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable;
  private final UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable;
  private final OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable;
  private final UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable;
  private final OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable;
  private final UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable;
  private final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable;
  private final UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable;
  private final UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable;
  private final OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConversationModelsStub create(ConversationModelsStubSettings settings)
      throws IOException {
    return new HttpJsonConversationModelsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConversationModelsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConversationModelsStub(
        ConversationModelsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConversationModelsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConversationModelsStub(
        ConversationModelsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConversationModelsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationModelsStub(
      ConversationModelsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonConversationModelsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConversationModelsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConversationModelsStub(
      ConversationModelsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateConversationModelRequest, Operation>
        createConversationModelTransportSettings =
            HttpJsonCallSettings.<CreateConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationModelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversationModelRequest, ConversationModel>
        getConversationModelTransportSettings =
            HttpJsonCallSettings.<GetConversationModelRequest, ConversationModel>newBuilder()
                .setMethodDescriptor(getConversationModelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListConversationModelsRequest, ListConversationModelsResponse>
        listConversationModelsTransportSettings =
            HttpJsonCallSettings
                .<ListConversationModelsRequest, ListConversationModelsResponse>newBuilder()
                .setMethodDescriptor(listConversationModelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConversationModelRequest, Operation>
        deleteConversationModelTransportSettings =
            HttpJsonCallSettings.<DeleteConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConversationModelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeployConversationModelRequest, Operation>
        deployConversationModelTransportSettings =
            HttpJsonCallSettings.<DeployConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(deployConversationModelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UndeployConversationModelRequest, Operation>
        undeployConversationModelTransportSettings =
            HttpJsonCallSettings.<UndeployConversationModelRequest, Operation>newBuilder()
                .setMethodDescriptor(undeployConversationModelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
        getConversationModelEvaluationTransportSettings =
            HttpJsonCallSettings
                .<GetConversationModelEvaluationRequest, ConversationModelEvaluation>newBuilder()
                .setMethodDescriptor(getConversationModelEvaluationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
        listConversationModelEvaluationsTransportSettings =
            HttpJsonCallSettings
                .<ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
                    newBuilder()
                .setMethodDescriptor(listConversationModelEvaluationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConversationModelEvaluationRequest, Operation>
        createConversationModelEvaluationTransportSettings =
            HttpJsonCallSettings.<CreateConversationModelEvaluationRequest, Operation>newBuilder()
                .setMethodDescriptor(createConversationModelEvaluationMethodDescriptor)
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

    this.createConversationModelCallable =
        callableFactory.createUnaryCallable(
            createConversationModelTransportSettings,
            settings.createConversationModelSettings(),
            clientContext);
    this.createConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            createConversationModelTransportSettings,
            settings.createConversationModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getConversationModelCallable =
        callableFactory.createUnaryCallable(
            getConversationModelTransportSettings,
            settings.getConversationModelSettings(),
            clientContext);
    this.listConversationModelsCallable =
        callableFactory.createUnaryCallable(
            listConversationModelsTransportSettings,
            settings.listConversationModelsSettings(),
            clientContext);
    this.listConversationModelsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationModelsTransportSettings,
            settings.listConversationModelsSettings(),
            clientContext);
    this.deleteConversationModelCallable =
        callableFactory.createUnaryCallable(
            deleteConversationModelTransportSettings,
            settings.deleteConversationModelSettings(),
            clientContext);
    this.deleteConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteConversationModelTransportSettings,
            settings.deleteConversationModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deployConversationModelCallable =
        callableFactory.createUnaryCallable(
            deployConversationModelTransportSettings,
            settings.deployConversationModelSettings(),
            clientContext);
    this.deployConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            deployConversationModelTransportSettings,
            settings.deployConversationModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.undeployConversationModelCallable =
        callableFactory.createUnaryCallable(
            undeployConversationModelTransportSettings,
            settings.undeployConversationModelSettings(),
            clientContext);
    this.undeployConversationModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployConversationModelTransportSettings,
            settings.undeployConversationModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getConversationModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            getConversationModelEvaluationTransportSettings,
            settings.getConversationModelEvaluationSettings(),
            clientContext);
    this.listConversationModelEvaluationsCallable =
        callableFactory.createUnaryCallable(
            listConversationModelEvaluationsTransportSettings,
            settings.listConversationModelEvaluationsSettings(),
            clientContext);
    this.listConversationModelEvaluationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationModelEvaluationsTransportSettings,
            settings.listConversationModelEvaluationsSettings(),
            clientContext);
    this.createConversationModelEvaluationCallable =
        callableFactory.createUnaryCallable(
            createConversationModelEvaluationTransportSettings,
            settings.createConversationModelEvaluationSettings(),
            clientContext);
    this.createConversationModelEvaluationOperationCallable =
        callableFactory.createOperationCallable(
            createConversationModelEvaluationTransportSettings,
            settings.createConversationModelEvaluationOperationSettings(),
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
    methodDescriptors.add(createConversationModelMethodDescriptor);
    methodDescriptors.add(getConversationModelMethodDescriptor);
    methodDescriptors.add(listConversationModelsMethodDescriptor);
    methodDescriptors.add(deleteConversationModelMethodDescriptor);
    methodDescriptors.add(deployConversationModelMethodDescriptor);
    methodDescriptors.add(undeployConversationModelMethodDescriptor);
    methodDescriptors.add(getConversationModelEvaluationMethodDescriptor);
    methodDescriptors.add(listConversationModelEvaluationsMethodDescriptor);
    methodDescriptors.add(createConversationModelEvaluationMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable() {
    return createConversationModelCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable() {
    return createConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable() {
    return getConversationModelCallable;
  }

  @Override
  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable() {
    return listConversationModelsCallable;
  }

  @Override
  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable() {
    return listConversationModelsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable() {
    return deleteConversationModelCallable;
  }

  @Override
  public OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable() {
    return deleteConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable() {
    return deployConversationModelCallable;
  }

  @Override
  public OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable() {
    return deployConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable() {
    return undeployConversationModelCallable;
  }

  @Override
  public OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable() {
    return undeployConversationModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable() {
    return getConversationModelEvaluationCallable;
  }

  @Override
  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable() {
    return listConversationModelEvaluationsCallable;
  }

  @Override
  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable() {
    return listConversationModelEvaluationsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable() {
    return createConversationModelEvaluationCallable;
  }

  @Override
  public OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable() {
    return createConversationModelEvaluationOperationCallable;
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
