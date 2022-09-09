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

import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListAgentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.AgentsClient.ListLocationsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3beta1.Agent;
import com.google.cloud.dialogflow.cx.v3beta1.AgentValidationResult;
import com.google.cloud.dialogflow.cx.v3beta1.CreateAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportAgentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetAgentValidationResultRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListAgentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListAgentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RestoreAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateAgentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ValidateAgentRequest;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAgentsStub extends AgentsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ExportAgentResponse.getDescriptor())
          .add(Struct.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListAgentsRequest, ListAgentsResponse>
      listAgentsMethodDescriptor =
          ApiMethodDescriptor.<ListAgentsRequest, ListAgentsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ListAgents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAgentsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*}/agents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAgentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAgentsResponse>newBuilder()
                      .setDefaultInstance(ListAgentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAgentRequest, Agent> getAgentMethodDescriptor =
      ApiMethodDescriptor.<GetAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/GetAgent")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAgentRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{name=projects/*/locations/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAgentRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<CreateAgentRequest, Agent> createAgentMethodDescriptor =
      ApiMethodDescriptor.<CreateAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/CreateAgent")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateAgentRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{parent=projects/*/locations/*}/agents",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("agent", request.getAgent(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateAgentRequest, Agent> updateAgentMethodDescriptor =
      ApiMethodDescriptor.<UpdateAgentRequest, Agent>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/UpdateAgent")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateAgentRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{agent.name=projects/*/locations/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "agent.name", request.getAgent().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("agent", request.getAgent(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Agent>newBuilder()
                  .setDefaultInstance(Agent.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteAgentRequest, Empty> deleteAgentMethodDescriptor =
      ApiMethodDescriptor.<DeleteAgentRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/DeleteAgent")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteAgentRequest>newBuilder()
                  .setPath(
                      "/v3beta1/{name=projects/*/locations/*/agents/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteAgentRequest> serializer =
                            ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<ExportAgentRequest, Operation>
      exportAgentMethodDescriptor =
          ApiMethodDescriptor.<ExportAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ExportAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportAgentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportAgentRequest> serializer =
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
                  (ExportAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RestoreAgentRequest, Operation>
      restoreAgentMethodDescriptor =
          ApiMethodDescriptor.<RestoreAgentRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/RestoreAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreAgentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreAgentRequest> serializer =
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
                  (RestoreAgentRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ValidateAgentRequest, AgentValidationResult>
      validateAgentMethodDescriptor =
          ApiMethodDescriptor.<ValidateAgentRequest, AgentValidationResult>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Agents/ValidateAgent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ValidateAgentRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*}:validate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateAgentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AgentValidationResult>newBuilder()
                      .setDefaultInstance(AgentValidationResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultMethodDescriptor =
          ApiMethodDescriptor.<GetAgentValidationResultRequest, AgentValidationResult>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Agents/GetAgentValidationResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAgentValidationResultRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/validationResult}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAgentValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAgentValidationResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AgentValidationResult>newBuilder()
                      .setDefaultInstance(AgentValidationResult.getDefaultInstance())
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

  private final UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable;
  private final UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable;
  private final UnaryCallable<GetAgentRequest, Agent> getAgentCallable;
  private final UnaryCallable<CreateAgentRequest, Agent> createAgentCallable;
  private final UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable;
  private final UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable;
  private final UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable;
  private final OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable;
  private final UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable;
  private final OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable;
  private final UnaryCallable<ValidateAgentRequest, AgentValidationResult> validateAgentCallable;
  private final UnaryCallable<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultCallable;
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

    HttpJsonCallSettings<ListAgentsRequest, ListAgentsResponse> listAgentsTransportSettings =
        HttpJsonCallSettings.<ListAgentsRequest, ListAgentsResponse>newBuilder()
            .setMethodDescriptor(listAgentsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAgentRequest, Agent> getAgentTransportSettings =
        HttpJsonCallSettings.<GetAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(getAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateAgentRequest, Agent> createAgentTransportSettings =
        HttpJsonCallSettings.<CreateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(createAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAgentRequest, Agent> updateAgentTransportSettings =
        HttpJsonCallSettings.<UpdateAgentRequest, Agent>newBuilder()
            .setMethodDescriptor(updateAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAgentRequest, Empty> deleteAgentTransportSettings =
        HttpJsonCallSettings.<DeleteAgentRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportAgentRequest, Operation> exportAgentTransportSettings =
        HttpJsonCallSettings.<ExportAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(exportAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RestoreAgentRequest, Operation> restoreAgentTransportSettings =
        HttpJsonCallSettings.<RestoreAgentRequest, Operation>newBuilder()
            .setMethodDescriptor(restoreAgentMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ValidateAgentRequest, AgentValidationResult>
        validateAgentTransportSettings =
            HttpJsonCallSettings.<ValidateAgentRequest, AgentValidationResult>newBuilder()
                .setMethodDescriptor(validateAgentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAgentValidationResultRequest, AgentValidationResult>
        getAgentValidationResultTransportSettings =
            HttpJsonCallSettings
                .<GetAgentValidationResultRequest, AgentValidationResult>newBuilder()
                .setMethodDescriptor(getAgentValidationResultMethodDescriptor)
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

    this.listAgentsCallable =
        callableFactory.createUnaryCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.listAgentsPagedCallable =
        callableFactory.createPagedCallable(
            listAgentsTransportSettings, settings.listAgentsSettings(), clientContext);
    this.getAgentCallable =
        callableFactory.createUnaryCallable(
            getAgentTransportSettings, settings.getAgentSettings(), clientContext);
    this.createAgentCallable =
        callableFactory.createUnaryCallable(
            createAgentTransportSettings, settings.createAgentSettings(), clientContext);
    this.updateAgentCallable =
        callableFactory.createUnaryCallable(
            updateAgentTransportSettings, settings.updateAgentSettings(), clientContext);
    this.deleteAgentCallable =
        callableFactory.createUnaryCallable(
            deleteAgentTransportSettings, settings.deleteAgentSettings(), clientContext);
    this.exportAgentCallable =
        callableFactory.createUnaryCallable(
            exportAgentTransportSettings, settings.exportAgentSettings(), clientContext);
    this.exportAgentOperationCallable =
        callableFactory.createOperationCallable(
            exportAgentTransportSettings,
            settings.exportAgentOperationSettings(),
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
    this.validateAgentCallable =
        callableFactory.createUnaryCallable(
            validateAgentTransportSettings, settings.validateAgentSettings(), clientContext);
    this.getAgentValidationResultCallable =
        callableFactory.createUnaryCallable(
            getAgentValidationResultTransportSettings,
            settings.getAgentValidationResultSettings(),
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
    methodDescriptors.add(listAgentsMethodDescriptor);
    methodDescriptors.add(getAgentMethodDescriptor);
    methodDescriptors.add(createAgentMethodDescriptor);
    methodDescriptors.add(updateAgentMethodDescriptor);
    methodDescriptors.add(deleteAgentMethodDescriptor);
    methodDescriptors.add(exportAgentMethodDescriptor);
    methodDescriptors.add(restoreAgentMethodDescriptor);
    methodDescriptors.add(validateAgentMethodDescriptor);
    methodDescriptors.add(getAgentValidationResultMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    return listAgentsCallable;
  }

  @Override
  public UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    return listAgentsPagedCallable;
  }

  @Override
  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return getAgentCallable;
  }

  @Override
  public UnaryCallable<CreateAgentRequest, Agent> createAgentCallable() {
    return createAgentCallable;
  }

  @Override
  public UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable() {
    return updateAgentCallable;
  }

  @Override
  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    return deleteAgentCallable;
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
  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    return restoreAgentCallable;
  }

  @Override
  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    return restoreAgentOperationCallable;
  }

  @Override
  public UnaryCallable<ValidateAgentRequest, AgentValidationResult> validateAgentCallable() {
    return validateAgentCallable;
  }

  @Override
  public UnaryCallable<GetAgentValidationResultRequest, AgentValidationResult>
      getAgentValidationResultCallable() {
    return getAgentValidationResultCallable;
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
