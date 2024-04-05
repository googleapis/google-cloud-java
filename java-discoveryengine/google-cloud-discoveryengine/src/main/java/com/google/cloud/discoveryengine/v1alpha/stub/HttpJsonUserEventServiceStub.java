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

import com.google.api.HttpBody;
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
import com.google.cloud.discoveryengine.v1alpha.CollectUserEventRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsMetadata;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsRequest;
import com.google.cloud.discoveryengine.v1alpha.ImportUserEventsResponse;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsMetadata;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsRequest;
import com.google.cloud.discoveryengine.v1alpha.PurgeUserEventsResponse;
import com.google.cloud.discoveryengine.v1alpha.UserEvent;
import com.google.cloud.discoveryengine.v1alpha.WriteUserEventRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
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
 * REST stub implementation for the UserEventService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonUserEventServiceStub extends UserEventServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ImportUserEventsResponse.getDescriptor())
          .add(PurgeUserEventsResponse.getDescriptor())
          .add(PurgeUserEventsMetadata.getDescriptor())
          .add(ImportUserEventsMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<WriteUserEventRequest, UserEvent>
      writeUserEventMethodDescriptor =
          ApiMethodDescriptor.<WriteUserEventRequest, UserEvent>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.UserEventService/WriteUserEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WriteUserEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/userEvents:write",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WriteUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/userEvents:write")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<WriteUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("userEvent", request.getUserEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<UserEvent>newBuilder()
                      .setDefaultInstance(UserEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CollectUserEventRequest, HttpBody>
      collectUserEventMethodDescriptor =
          ApiMethodDescriptor.<CollectUserEventRequest, HttpBody>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.UserEventService/CollectUserEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CollectUserEventRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/userEvents:collect",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CollectUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/userEvents:collect")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CollectUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasEts()) {
                              serializer.putQueryParam(fields, "ets", request.getEts());
                            }
                            if (request.hasUri()) {
                              serializer.putQueryParam(fields, "uri", request.getUri());
                            }
                            serializer.putQueryParam(fields, "userEvent", request.getUserEvent());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<HttpBody>newBuilder()
                      .setDefaultInstance(HttpBody.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PurgeUserEventsRequest, Operation>
      purgeUserEventsMethodDescriptor =
          ApiMethodDescriptor.<PurgeUserEventsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.UserEventService/PurgeUserEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeUserEventsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/userEvents:purge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeUserEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/userEvents:purge")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeUserEventsRequest> serializer =
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
                  (PurgeUserEventsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportUserEventsRequest, Operation>
      importUserEventsMethodDescriptor =
          ApiMethodDescriptor.<ImportUserEventsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.UserEventService/ImportUserEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportUserEventsRequest>newBuilder()
                      .setPath(
                          "/v1alpha/{parent=projects/*/locations/*/dataStores/*}/userEvents:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportUserEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1alpha/{parent=projects/*/locations/*/collections/*/dataStores/*}/userEvents:import")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportUserEventsRequest> serializer =
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
                  (ImportUserEventsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable;
  private final UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable;
  private final UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable;
  private final OperationCallable<
          PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationCallable;
  private final UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable;
  private final OperationCallable<
          ImportUserEventsRequest, ImportUserEventsResponse, ImportUserEventsMetadata>
      importUserEventsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUserEventServiceStub create(UserEventServiceStubSettings settings)
      throws IOException {
    return new HttpJsonUserEventServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUserEventServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonUserEventServiceStub(
        UserEventServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonUserEventServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUserEventServiceStub(
        UserEventServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUserEventServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserEventServiceStub(
      UserEventServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonUserEventServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUserEventServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonUserEventServiceStub(
      UserEventServiceStubSettings settings,
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

    HttpJsonCallSettings<WriteUserEventRequest, UserEvent> writeUserEventTransportSettings =
        HttpJsonCallSettings.<WriteUserEventRequest, UserEvent>newBuilder()
            .setMethodDescriptor(writeUserEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CollectUserEventRequest, HttpBody> collectUserEventTransportSettings =
        HttpJsonCallSettings.<CollectUserEventRequest, HttpBody>newBuilder()
            .setMethodDescriptor(collectUserEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PurgeUserEventsRequest, Operation> purgeUserEventsTransportSettings =
        HttpJsonCallSettings.<PurgeUserEventsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeUserEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportUserEventsRequest, Operation> importUserEventsTransportSettings =
        HttpJsonCallSettings.<ImportUserEventsRequest, Operation>newBuilder()
            .setMethodDescriptor(importUserEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.writeUserEventCallable =
        callableFactory.createUnaryCallable(
            writeUserEventTransportSettings, settings.writeUserEventSettings(), clientContext);
    this.collectUserEventCallable =
        callableFactory.createUnaryCallable(
            collectUserEventTransportSettings, settings.collectUserEventSettings(), clientContext);
    this.purgeUserEventsCallable =
        callableFactory.createUnaryCallable(
            purgeUserEventsTransportSettings, settings.purgeUserEventsSettings(), clientContext);
    this.purgeUserEventsOperationCallable =
        callableFactory.createOperationCallable(
            purgeUserEventsTransportSettings,
            settings.purgeUserEventsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importUserEventsCallable =
        callableFactory.createUnaryCallable(
            importUserEventsTransportSettings, settings.importUserEventsSettings(), clientContext);
    this.importUserEventsOperationCallable =
        callableFactory.createOperationCallable(
            importUserEventsTransportSettings,
            settings.importUserEventsOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(writeUserEventMethodDescriptor);
    methodDescriptors.add(collectUserEventMethodDescriptor);
    methodDescriptors.add(purgeUserEventsMethodDescriptor);
    methodDescriptors.add(importUserEventsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable() {
    return writeUserEventCallable;
  }

  @Override
  public UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable() {
    return collectUserEventCallable;
  }

  @Override
  public UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable() {
    return purgeUserEventsCallable;
  }

  @Override
  public OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationCallable() {
    return purgeUserEventsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    return importUserEventsCallable;
  }

  @Override
  public OperationCallable<
          ImportUserEventsRequest, ImportUserEventsResponse, ImportUserEventsMetadata>
      importUserEventsOperationCallable() {
    return importUserEventsOperationCallable;
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
