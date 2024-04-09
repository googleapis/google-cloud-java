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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.EngineServiceClient.ListEnginesPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateEngineMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.DeleteEngineMetadata;
import com.google.cloud.discoveryengine.v1alpha.DeleteEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.Engine;
import com.google.cloud.discoveryengine.v1alpha.GetEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEnginesRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEnginesResponse;
import com.google.cloud.discoveryengine.v1alpha.PauseEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.ResumeEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.TuneEngineMetadata;
import com.google.cloud.discoveryengine.v1alpha.TuneEngineRequest;
import com.google.cloud.discoveryengine.v1alpha.TuneEngineResponse;
import com.google.cloud.discoveryengine.v1alpha.UpdateEngineRequest;
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
 * REST stub implementation for the EngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonEngineServiceStub extends EngineServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(CreateEngineMetadata.getDescriptor())
          .add(DeleteEngineMetadata.getDescriptor())
          .add(Engine.getDescriptor())
          .add(TuneEngineResponse.getDescriptor())
          .add(TuneEngineMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateEngineRequest, Operation>
      createEngineMethodDescriptor =
          ApiMethodDescriptor.<CreateEngineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/CreateEngine")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*}/engines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "engineId", request.getEngineId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("engine", request.getEngine(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEngineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEngineRequest, Operation>
      deleteEngineMethodDescriptor =
          ApiMethodDescriptor.<DeleteEngineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/DeleteEngine")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEngineRequest> serializer =
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
                  (DeleteEngineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEngineRequest, Engine>
      updateEngineMethodDescriptor =
          ApiMethodDescriptor.<UpdateEngineRequest, Engine>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/UpdateEngine")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{engine.name=projects/*/locations/*/collections/*/engines/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "engine.name", request.getEngine().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("engine", request.getEngine(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Engine>newBuilder()
                      .setDefaultInstance(Engine.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEngineRequest, Engine> getEngineMethodDescriptor =
      ApiMethodDescriptor.<GetEngineRequest, Engine>newBuilder()
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/GetEngine")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetEngineRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetEngineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetEngineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Engine>newBuilder()
                  .setDefaultInstance(Engine.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListEnginesRequest, ListEnginesResponse>
      listEnginesMethodDescriptor =
          ApiMethodDescriptor.<ListEnginesRequest, ListEnginesResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/ListEngines")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEnginesRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*}/engines",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnginesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEnginesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEnginesResponse>newBuilder()
                      .setDefaultInstance(ListEnginesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PauseEngineRequest, Engine> pauseEngineMethodDescriptor =
      ApiMethodDescriptor.<PauseEngineRequest, Engine>newBuilder()
          .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/PauseEngine")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<PauseEngineRequest>newBuilder()
                  .setPath(
                      "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}:pause",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<PauseEngineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<PauseEngineRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearName().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Engine>newBuilder()
                  .setDefaultInstance(Engine.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ResumeEngineRequest, Engine>
      resumeEngineMethodDescriptor =
          ApiMethodDescriptor.<ResumeEngineRequest, Engine>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/ResumeEngine")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Engine>newBuilder()
                      .setDefaultInstance(Engine.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TuneEngineRequest, Operation>
      tuneEngineMethodDescriptor =
          ApiMethodDescriptor.<TuneEngineRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1alpha.EngineService/TuneEngine")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TuneEngineRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}:tune",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TuneEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TuneEngineRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TuneEngineRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateEngineRequest, Operation> createEngineCallable;
  private final OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable;
  private final UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable;
  private final OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable;
  private final UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable;
  private final UnaryCallable<GetEngineRequest, Engine> getEngineCallable;
  private final UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable;
  private final UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse>
      listEnginesPagedCallable;
  private final UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable;
  private final UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable;
  private final UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable;
  private final OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonEngineServiceStub create(EngineServiceStubSettings settings)
      throws IOException {
    return new HttpJsonEngineServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonEngineServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonEngineServiceStub(
        EngineServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonEngineServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonEngineServiceStub(
        EngineServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEngineServiceStub(
      EngineServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonEngineServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonEngineServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonEngineServiceStub(
      EngineServiceStubSettings settings,
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
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/evaluations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet(
                            "/v1alpha/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1alpha/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1alpha/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateEngineRequest, Operation> createEngineTransportSettings =
        HttpJsonCallSettings.<CreateEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(createEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteEngineRequest, Operation> deleteEngineTransportSettings =
        HttpJsonCallSettings.<DeleteEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateEngineRequest, Engine> updateEngineTransportSettings =
        HttpJsonCallSettings.<UpdateEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(updateEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("engine.name", String.valueOf(request.getEngine().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEngineRequest, Engine> getEngineTransportSettings =
        HttpJsonCallSettings.<GetEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(getEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListEnginesRequest, ListEnginesResponse> listEnginesTransportSettings =
        HttpJsonCallSettings.<ListEnginesRequest, ListEnginesResponse>newBuilder()
            .setMethodDescriptor(listEnginesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PauseEngineRequest, Engine> pauseEngineTransportSettings =
        HttpJsonCallSettings.<PauseEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(pauseEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ResumeEngineRequest, Engine> resumeEngineTransportSettings =
        HttpJsonCallSettings.<ResumeEngineRequest, Engine>newBuilder()
            .setMethodDescriptor(resumeEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TuneEngineRequest, Operation> tuneEngineTransportSettings =
        HttpJsonCallSettings.<TuneEngineRequest, Operation>newBuilder()
            .setMethodDescriptor(tuneEngineMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.createEngineCallable =
        callableFactory.createUnaryCallable(
            createEngineTransportSettings, settings.createEngineSettings(), clientContext);
    this.createEngineOperationCallable =
        callableFactory.createOperationCallable(
            createEngineTransportSettings,
            settings.createEngineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEngineCallable =
        callableFactory.createUnaryCallable(
            deleteEngineTransportSettings, settings.deleteEngineSettings(), clientContext);
    this.deleteEngineOperationCallable =
        callableFactory.createOperationCallable(
            deleteEngineTransportSettings,
            settings.deleteEngineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEngineCallable =
        callableFactory.createUnaryCallable(
            updateEngineTransportSettings, settings.updateEngineSettings(), clientContext);
    this.getEngineCallable =
        callableFactory.createUnaryCallable(
            getEngineTransportSettings, settings.getEngineSettings(), clientContext);
    this.listEnginesCallable =
        callableFactory.createUnaryCallable(
            listEnginesTransportSettings, settings.listEnginesSettings(), clientContext);
    this.listEnginesPagedCallable =
        callableFactory.createPagedCallable(
            listEnginesTransportSettings, settings.listEnginesSettings(), clientContext);
    this.pauseEngineCallable =
        callableFactory.createUnaryCallable(
            pauseEngineTransportSettings, settings.pauseEngineSettings(), clientContext);
    this.resumeEngineCallable =
        callableFactory.createUnaryCallable(
            resumeEngineTransportSettings, settings.resumeEngineSettings(), clientContext);
    this.tuneEngineCallable =
        callableFactory.createUnaryCallable(
            tuneEngineTransportSettings, settings.tuneEngineSettings(), clientContext);
    this.tuneEngineOperationCallable =
        callableFactory.createOperationCallable(
            tuneEngineTransportSettings,
            settings.tuneEngineOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createEngineMethodDescriptor);
    methodDescriptors.add(deleteEngineMethodDescriptor);
    methodDescriptors.add(updateEngineMethodDescriptor);
    methodDescriptors.add(getEngineMethodDescriptor);
    methodDescriptors.add(listEnginesMethodDescriptor);
    methodDescriptors.add(pauseEngineMethodDescriptor);
    methodDescriptors.add(resumeEngineMethodDescriptor);
    methodDescriptors.add(tuneEngineMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateEngineRequest, Operation> createEngineCallable() {
    return createEngineCallable;
  }

  @Override
  public OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable() {
    return createEngineOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable() {
    return deleteEngineCallable;
  }

  @Override
  public OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable() {
    return deleteEngineOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable() {
    return updateEngineCallable;
  }

  @Override
  public UnaryCallable<GetEngineRequest, Engine> getEngineCallable() {
    return getEngineCallable;
  }

  @Override
  public UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable() {
    return listEnginesCallable;
  }

  @Override
  public UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse> listEnginesPagedCallable() {
    return listEnginesPagedCallable;
  }

  @Override
  public UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable() {
    return pauseEngineCallable;
  }

  @Override
  public UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable() {
    return resumeEngineCallable;
  }

  @Override
  public UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable() {
    return tuneEngineCallable;
  }

  @Override
  public OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable() {
    return tuneEngineOperationCallable;
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
