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

import static com.google.cloud.dialogflow.v2.AgentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.AgentsClient.SearchAgentsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.Agent;
import com.google.cloud.dialogflow.v2.DeleteAgentRequest;
import com.google.cloud.dialogflow.v2.ExportAgentRequest;
import com.google.cloud.dialogflow.v2.ExportAgentResponse;
import com.google.cloud.dialogflow.v2.GetAgentRequest;
import com.google.cloud.dialogflow.v2.GetValidationResultRequest;
import com.google.cloud.dialogflow.v2.ImportAgentRequest;
import com.google.cloud.dialogflow.v2.RestoreAgentRequest;
import com.google.cloud.dialogflow.v2.SearchAgentsRequest;
import com.google.cloud.dialogflow.v2.SearchAgentsResponse;
import com.google.cloud.dialogflow.v2.SetAgentRequest;
import com.google.cloud.dialogflow.v2.TrainAgentRequest;
import com.google.cloud.dialogflow.v2.ValidationResult;
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
 * REST stub implementation for the Agents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAgentsStub extends AgentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ExportAgentResponse.getDescriptor())
          .add(Struct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      ApiMethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.v2.Agents/GetAgent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAgentRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*}/agent",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SetAgentRequest, Agent> setAgentMethodDescriptor =
      ApiMethodDescriptor.<SetAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.v2.Agents/SetAgent")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SetAgentRequest>newBuilder()
                  .setPath(
                      "/v2/{agent.parent=projects/*}/agent",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(
                            fields, "agent.parent", request.getAgent().getParent());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{agent.parent=projects/*/locations/*}/agent")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("agent", request.getAgent(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteAgentRequest, Empty> deleteAgentMethodDescriptor =
      ApiMethodDescriptor.<DeleteAgentRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.v2.Agents/DeleteAgent")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAgentRequest>newBuilder()
                  .setPath(
                      "/v2/{parent=projects/*}/agent",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
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

  private static final ApiMethodDescriptor<SearchAgentsRequest, SearchAgentsResponse>
      searchAgentsMethodDescriptor =
          ApiMethodDescriptor.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/SearchAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchAgentsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchAgentsResponse>newBuilder()
                      .setDefaultInstance(SearchAgentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TrainAgentRequest, Operation>
      trainAgentMethodDescriptor =
          ApiMethodDescriptor.<TrainAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/TrainAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TrainAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent:train",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TrainAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent:train")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TrainAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TrainAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportAgentRequest, Operation>
      exportAgentMethodDescriptor =
          ApiMethodDescriptor.<ExportAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/ExportAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent:export")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportAgentRequest, Operation>
      importAgentMethodDescriptor =
          ApiMethodDescriptor.<ImportAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/ImportAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent:import")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestoreAgentRequest, Operation>
      restoreAgentMethodDescriptor =
          ApiMethodDescriptor.<RestoreAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/RestoreAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreAgentRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v2/{parent=projects/*/locations/*}/agent:restore")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RestoreAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetValidationResultRequest, ValidationResult>
      getValidationResultMethodDescriptor =
          ApiMethodDescriptor.<GetValidationResultRequest, ValidationResult>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2.Agents/GetValidationResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetValidationResultRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*}/agent/validationResult",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2/{parent=projects/*/locations/*}/agent/validationResult")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ValidationResult>newBuilder()
                      .setDefaultInstance(ValidationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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

  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<SetAgentRequest, Agent> setAgentCallable;
  private final UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable;
  private final UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse>
      searchAgentsPagedCallable;
  private final UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable;
  private final OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable;
  private final UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable;
  private final OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable;
  private final UnaryCallable<ImportAgentRequest, Operation> importAgentCallable;
  private final OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable;
  private final UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable;
  private final OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable;
  private final UnaryCallable<GetValidationResultRequest, ValidationResult>
      getValidationResultCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAgentsStub create(AgentsStubSettings settings) throws IOException {
    return new HttpJsonAgentsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAgentsStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonAgentsStub(AgentsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAgentsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAgentsStub(
        AgentsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAgentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAgentsStub(AgentsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAgentsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAgentsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAgentsStub(
      AgentsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        HttpJsonCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetAgentRequest, Agent> setAgentTransportSettings =
        HttpJsonCallSettings.<SetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(setAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAgentRequest, Empty> deleteAgentTransportSettings =
        HttpJsonCallSettings.<DeleteAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SearchAgentsRequest, SearchAgentsResponse> searchAgentsTransportSettings =
        HttpJsonCallSettings.<SearchAgentsRequest, SearchAgentsResponse>newBuilder()
            .setMethodDescriptor(searchAgentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TrainAgentRequest, Operation> trainAgentTransportSettings =
        HttpJsonCallSettings.<TrainAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(trainAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportAgentRequest, Operation> exportAgentTransportSettings =
        HttpJsonCallSettings.<ExportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportAgentRequest, Operation> importAgentTransportSettings =
        HttpJsonCallSettings.<ImportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(importAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RestoreAgentRequest, Operation> restoreAgentTransportSettings =
        HttpJsonCallSettings.<RestoreAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetValidationResultRequest, ValidationResult>
        getValidationResultTransportSettings =
            HttpJsonCallSettings.<GetValidationResultRequest, ValidationResult>newBuilder()
                .setMethodDescriptor(getValidationResultMethodDescriptor)
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

    this.getAgentCallable =
        callableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.setAgentCallable =
        callableFactory.createUnaryCallable(
            setAgentTransportSettings, settings.setAgentSettings(), clientContext);
    this.deleteAgentCallable =
        callableFactory.createUnaryCallable(
            deleteAgentTransportSettings, settings.deleteAgentSettings(), clientContext);
    this.searchAgentsCallable =
        callableFactory.createUnaryCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.searchAgentsPagedCallable =
        callableFactory.createPagedCallable(
            searchAgentsTransportSettings, settings.searchAgentsSettings(), clientContext);
    this.trainAgentCallable =
        callableFactory.createUnaryCallable(
            trainAgentTransportSettings, settings.trainAgentSettings(), clientContext);
    this.trainAgentOperationCallable =
        callableFactory.createOperationCallable(
            trainAgentTransportSettings,
            settings.trainAgentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportAgentCallable =
        callableFactory.createUnaryCallable(
            exportAgentTransportSettings, settings.exportAgentSettings(), clientContext);
    this.exportAgentOperationCallable =
        callableFactory.createOperationCallable(
            exportAgentTransportSettings,
            settings.exportAgentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importAgentCallable =
        callableFactory.createUnaryCallable(
            importAgentTransportSettings, settings.importAgentSettings(), clientContext);
    this.importAgentOperationCallable =
        callableFactory.createOperationCallable(
            importAgentTransportSettings,
            settings.importAgentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restoreAgentCallable =
        callableFactory.createUnaryCallable(
            restoreAgentTransportSettings, settings.restoreAgentSettings(), clientContext);
    this.restoreAgentOperationCallable =
        callableFactory.createOperationCallable(
            restoreAgentTransportSettings,
            settings.restoreAgentOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getValidationResultCallable =
        callableFactory.createUnaryCallable(
            getValidationResultTransportSettings,
            settings.getValidationResultSettings(),
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAgentMethodDescriptor);
    methodDescriptors.add(setAgentMethodDescriptor);
    methodDescriptors.add(deleteAgentMethodDescriptor);
    methodDescriptors.add(searchAgentsMethodDescriptor);
    methodDescriptors.add(trainAgentMethodDescriptor);
    methodDescriptors.add(exportAgentMethodDescriptor);
    methodDescriptors.add(importAgentMethodDescriptor);
    methodDescriptors.add(restoreAgentMethodDescriptor);
    methodDescriptors.add(getValidationResultMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  @Override
  public UnaryCallable<SetAgentRequest, Agent> setAgentCallable() {
    return setAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    return deleteAgentCallable;
  }

  @Override
  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    return searchAgentsCallable;
  }

  @Override
  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    return searchAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable() {
    return trainAgentCallable;
  }

  @Override
  public OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable() {
    return trainAgentOperationCallable;
  }

  @Override
  public UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    return exportAgentCallable;
  }

  @Override
  public OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    return exportAgentOperationCallable;
  }

  @Override
  public UnaryCallable<ImportAgentRequest, Operation> importAgentCallable() {
    return importAgentCallable;
  }

  @Override
  public OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable() {
    return importAgentOperationCallable;
  }

  @Override
  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    return restoreAgentCallable;
  }

  @Override
  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    return restoreAgentOperationCallable;
  }

  @Override
  public UnaryCallable<GetValidationResultRequest, ValidationResult> getValidationResultCallable() {
    return getValidationResultCallable;
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
