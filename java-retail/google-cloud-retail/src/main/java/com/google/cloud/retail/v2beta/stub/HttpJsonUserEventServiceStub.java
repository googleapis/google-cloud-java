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

package com.google.cloud.retail.v2beta.stub;

import com.google.api.HttpBody;
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
import com.google.cloud.retail.v2beta.CollectUserEventRequest;
import com.google.cloud.retail.v2beta.ImportMetadata;
import com.google.cloud.retail.v2beta.ImportUserEventsRequest;
import com.google.cloud.retail.v2beta.ImportUserEventsResponse;
import com.google.cloud.retail.v2beta.PurgeMetadata;
import com.google.cloud.retail.v2beta.PurgeUserEventsRequest;
import com.google.cloud.retail.v2beta.PurgeUserEventsResponse;
import com.google.cloud.retail.v2beta.RejoinUserEventsMetadata;
import com.google.cloud.retail.v2beta.RejoinUserEventsRequest;
import com.google.cloud.retail.v2beta.RejoinUserEventsResponse;
import com.google.cloud.retail.v2beta.UserEvent;
import com.google.cloud.retail.v2beta.WriteUserEventRequest;
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
          .add(ImportMetadata.getDescriptor())
          .add(PurgeMetadata.getDescriptor())
          .add(ImportUserEventsResponse.getDescriptor())
          .add(RejoinUserEventsMetadata.getDescriptor())
          .add(RejoinUserEventsResponse.getDescriptor())
          .add(PurgeUserEventsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<WriteUserEventRequest, UserEvent>
      writeUserEventMethodDescriptor =
          ApiMethodDescriptor.<WriteUserEventRequest, UserEvent>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.UserEventService/WriteUserEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<WriteUserEventRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/userEvents:write",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<WriteUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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
              .setFullMethodName("google.cloud.retail.v2beta.UserEventService/CollectUserEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CollectUserEventRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/userEvents:collect",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CollectUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CollectUserEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "ets", request.getEts());
                            serializer.putQueryParam(fields, "uri", request.getUri());
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
              .setFullMethodName("google.cloud.retail.v2beta.UserEventService/PurgeUserEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PurgeUserEventsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/userEvents:purge",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PurgeUserEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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
              .setFullMethodName("google.cloud.retail.v2beta.UserEventService/ImportUserEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportUserEventsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/userEvents:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportUserEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<RejoinUserEventsRequest, Operation>
      rejoinUserEventsMethodDescriptor =
          ApiMethodDescriptor.<RejoinUserEventsRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.retail.v2beta.UserEventService/RejoinUserEvents")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RejoinUserEventsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=projects/*/locations/*/catalogs/*}/userEvents:rejoin",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RejoinUserEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RejoinUserEventsRequest> serializer =
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
                  (RejoinUserEventsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable;
  private final UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable;
  private final UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable;
  private final OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeMetadata>
      purgeUserEventsOperationCallable;
  private final UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable;
  private final OperationCallable<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationCallable;
  private final UnaryCallable<RejoinUserEventsRequest, Operation> rejoinUserEventsCallable;
  private final OperationCallable<
          RejoinUserEventsRequest, RejoinUserEventsResponse, RejoinUserEventsMetadata>
      rejoinUserEventsOperationCallable;

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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<WriteUserEventRequest, UserEvent> writeUserEventTransportSettings =
        HttpJsonCallSettings.<WriteUserEventRequest, UserEvent>newBuilder()
            .setMethodDescriptor(writeUserEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CollectUserEventRequest, HttpBody> collectUserEventTransportSettings =
        HttpJsonCallSettings.<CollectUserEventRequest, HttpBody>newBuilder()
            .setMethodDescriptor(collectUserEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PurgeUserEventsRequest, Operation> purgeUserEventsTransportSettings =
        HttpJsonCallSettings.<PurgeUserEventsRequest, Operation>newBuilder()
            .setMethodDescriptor(purgeUserEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ImportUserEventsRequest, Operation> importUserEventsTransportSettings =
        HttpJsonCallSettings.<ImportUserEventsRequest, Operation>newBuilder()
            .setMethodDescriptor(importUserEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RejoinUserEventsRequest, Operation> rejoinUserEventsTransportSettings =
        HttpJsonCallSettings.<RejoinUserEventsRequest, Operation>newBuilder()
            .setMethodDescriptor(rejoinUserEventsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.rejoinUserEventsCallable =
        callableFactory.createUnaryCallable(
            rejoinUserEventsTransportSettings, settings.rejoinUserEventsSettings(), clientContext);
    this.rejoinUserEventsOperationCallable =
        callableFactory.createOperationCallable(
            rejoinUserEventsTransportSettings,
            settings.rejoinUserEventsOperationSettings(),
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
    methodDescriptors.add(rejoinUserEventsMethodDescriptor);
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
  public OperationCallable<PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeMetadata>
      purgeUserEventsOperationCallable() {
    return purgeUserEventsOperationCallable;
  }

  @Override
  public UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    return importUserEventsCallable;
  }

  @Override
  public OperationCallable<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationCallable() {
    return importUserEventsOperationCallable;
  }

  @Override
  public UnaryCallable<RejoinUserEventsRequest, Operation> rejoinUserEventsCallable() {
    return rejoinUserEventsCallable;
  }

  @Override
  public OperationCallable<
          RejoinUserEventsRequest, RejoinUserEventsResponse, RejoinUserEventsMetadata>
      rejoinUserEventsOperationCallable() {
    return rejoinUserEventsOperationCallable;
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
