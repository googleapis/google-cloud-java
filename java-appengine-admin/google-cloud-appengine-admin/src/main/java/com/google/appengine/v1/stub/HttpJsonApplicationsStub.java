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

package com.google.appengine.v1.stub;

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
import com.google.appengine.v1.Application;
import com.google.appengine.v1.CreateApplicationRequest;
import com.google.appengine.v1.GetApplicationRequest;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.RepairApplicationRequest;
import com.google.appengine.v1.UpdateApplicationRequest;
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
 * REST stub implementation for the Applications service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonApplicationsStub extends ApplicationsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Application.getDescriptor())
          .add(OperationMetadataV1.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          ApiMethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setFullMethodName("google.appengine.v1.Applications/GetApplication")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Application>newBuilder()
                      .setDefaultInstance(Application.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateApplicationRequest, Operation>
      createApplicationMethodDescriptor =
          ApiMethodDescriptor.<CreateApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.Applications/CreateApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/apps",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateApplicationRequest, Operation>
      updateApplicationMethodDescriptor =
          ApiMethodDescriptor.<UpdateApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.Applications/UpdateApplication")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("application", request.getApplication(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RepairApplicationRequest, Operation>
      repairApplicationMethodDescriptor =
          ApiMethodDescriptor.<RepairApplicationRequest, Operation>newBuilder()
              .setFullMethodName("google.appengine.v1.Applications/RepairApplication")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepairApplicationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*}:repair",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepairApplicationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepairApplicationRequest> serializer =
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
                  (RepairApplicationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable;
  private final OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable;
  private final OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable;
  private final UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable;
  private final OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonApplicationsStub create(ApplicationsStubSettings settings)
      throws IOException {
    return new HttpJsonApplicationsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonApplicationsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonApplicationsStub(
        ApplicationsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonApplicationsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonApplicationsStub(
        ApplicationsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonApplicationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApplicationsStub(ApplicationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonApplicationsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonApplicationsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonApplicationsStub(
      ApplicationsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        HttpJsonCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateApplicationRequest, Operation> createApplicationTransportSettings =
        HttpJsonCallSettings.<CreateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateApplicationRequest, Operation> updateApplicationTransportSettings =
        HttpJsonCallSettings.<UpdateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RepairApplicationRequest, Operation> repairApplicationTransportSettings =
        HttpJsonCallSettings.<RepairApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(repairApplicationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.createApplicationOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationTransportSettings,
            settings.createApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.updateApplicationOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.repairApplicationCallable =
        callableFactory.createUnaryCallable(
            repairApplicationTransportSettings,
            settings.repairApplicationSettings(),
            clientContext);
    this.repairApplicationOperationCallable =
        callableFactory.createOperationCallable(
            repairApplicationTransportSettings,
            settings.repairApplicationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getApplicationMethodDescriptor);
    methodDescriptors.add(createApplicationMethodDescriptor);
    methodDescriptors.add(updateApplicationMethodDescriptor);
    methodDescriptors.add(repairApplicationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable() {
    return createApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable() {
    return updateApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable() {
    return repairApplicationCallable;
  }

  @Override
  public OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable() {
    return repairApplicationOperationCallable;
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
