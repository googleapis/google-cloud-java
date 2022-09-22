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

package com.google.cloud.networkmanagement.v1.stub;

import static com.google.cloud.networkmanagement.v1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

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
import com.google.cloud.networkmanagement.v1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1.CreateConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.DeleteConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.GetConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.ListConnectivityTestsRequest;
import com.google.cloud.networkmanagement.v1.ListConnectivityTestsResponse;
import com.google.cloud.networkmanagement.v1.OperationMetadata;
import com.google.cloud.networkmanagement.v1.RerunConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.UpdateConnectivityTestRequest;
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
 * REST stub implementation for the ReachabilityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonReachabilityServiceStub extends ReachabilityServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(ConnectivityTest.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/ListConnectivityTests")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectivityTestsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/global}/connectivityTests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectivityTestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectivityTestsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectivityTestsResponse>newBuilder()
                      .setDefaultInstance(ListConnectivityTestsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/GetConnectivityTest")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectivityTest>newBuilder()
                      .setDefaultInstance(ConnectivityTest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectivityTestRequest, Operation>
      createConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/CreateConnectivityTest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/global}/connectivityTests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "testId", request.getTestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/UpdateConnectivityTest")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1/{resource.name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "resource.name", request.getResource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("resource", request.getResource(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<RerunConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/RerunConnectivityTest")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RerunConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/global/connectivityTests/*}:rerun",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RerunConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RerunConnectivityTestRequest> serializer =
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
                  (RerunConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectivityTestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.networkmanagement.v1.ReachabilityService/DeleteConnectivityTest")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectivityTestRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/global/connectivityTests/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectivityTestRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectivityTestRequest> serializer =
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
                  (DeleteConnectivityTestRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable;
  private final UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable;
  private final UnaryCallable<GetConnectivityTestRequest, ConnectivityTest>
      getConnectivityTestCallable;
  private final UnaryCallable<CreateConnectivityTestRequest, Operation>
      createConnectivityTestCallable;
  private final OperationCallable<
          CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable;
  private final UnaryCallable<UpdateConnectivityTestRequest, Operation>
      updateConnectivityTestCallable;
  private final OperationCallable<
          UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable;
  private final UnaryCallable<RerunConnectivityTestRequest, Operation>
      rerunConnectivityTestCallable;
  private final OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable;
  private final UnaryCallable<DeleteConnectivityTestRequest, Operation>
      deleteConnectivityTestCallable;
  private final OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonReachabilityServiceStub create(
      ReachabilityServiceStubSettings settings) throws IOException {
    return new HttpJsonReachabilityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonReachabilityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonReachabilityServiceStub(
        ReachabilityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonReachabilityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonReachabilityServiceStub(
        ReachabilityServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReachabilityServiceStub(
      ReachabilityServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonReachabilityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonReachabilityServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonReachabilityServiceStub(
      ReachabilityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
        listConnectivityTestsTransportSettings =
            HttpJsonCallSettings
                .<ListConnectivityTestsRequest, ListConnectivityTestsResponse>newBuilder()
                .setMethodDescriptor(listConnectivityTestsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConnectivityTestRequest, ConnectivityTest>
        getConnectivityTestTransportSettings =
            HttpJsonCallSettings.<GetConnectivityTestRequest, ConnectivityTest>newBuilder()
                .setMethodDescriptor(getConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateConnectivityTestRequest, Operation>
        createConnectivityTestTransportSettings =
            HttpJsonCallSettings.<CreateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateConnectivityTestRequest, Operation>
        updateConnectivityTestTransportSettings =
            HttpJsonCallSettings.<UpdateConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RerunConnectivityTestRequest, Operation>
        rerunConnectivityTestTransportSettings =
            HttpJsonCallSettings.<RerunConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(rerunConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConnectivityTestRequest, Operation>
        deleteConnectivityTestTransportSettings =
            HttpJsonCallSettings.<DeleteConnectivityTestRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectivityTestMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listConnectivityTestsCallable =
        callableFactory.createUnaryCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.listConnectivityTestsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectivityTestsTransportSettings,
            settings.listConnectivityTestsSettings(),
            clientContext);
    this.getConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            getConnectivityTestTransportSettings,
            settings.getConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestSettings(),
            clientContext);
    this.createConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            createConnectivityTestTransportSettings,
            settings.createConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestSettings(),
            clientContext);
    this.updateConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectivityTestTransportSettings,
            settings.updateConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.rerunConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestSettings(),
            clientContext);
    this.rerunConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            rerunConnectivityTestTransportSettings,
            settings.rerunConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConnectivityTestCallable =
        callableFactory.createUnaryCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestSettings(),
            clientContext);
    this.deleteConnectivityTestOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectivityTestTransportSettings,
            settings.deleteConnectivityTestOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConnectivityTestsMethodDescriptor);
    methodDescriptors.add(getConnectivityTestMethodDescriptor);
    methodDescriptors.add(createConnectivityTestMethodDescriptor);
    methodDescriptors.add(updateConnectivityTestMethodDescriptor);
    methodDescriptors.add(rerunConnectivityTestMethodDescriptor);
    methodDescriptors.add(deleteConnectivityTestMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable() {
    return listConnectivityTestsCallable;
  }

  @Override
  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable() {
    return listConnectivityTestsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectivityTestRequest, ConnectivityTest> getConnectivityTestCallable() {
    return getConnectivityTestCallable;
  }

  @Override
  public UnaryCallable<CreateConnectivityTestRequest, Operation> createConnectivityTestCallable() {
    return createConnectivityTestCallable;
  }

  @Override
  public OperationCallable<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable() {
    return createConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectivityTestRequest, Operation> updateConnectivityTestCallable() {
    return updateConnectivityTestCallable;
  }

  @Override
  public OperationCallable<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable() {
    return updateConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<RerunConnectivityTestRequest, Operation> rerunConnectivityTestCallable() {
    return rerunConnectivityTestCallable;
  }

  @Override
  public OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable() {
    return rerunConnectivityTestOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectivityTestRequest, Operation> deleteConnectivityTestCallable() {
    return deleteConnectivityTestCallable;
  }

  @Override
  public OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable() {
    return deleteConnectivityTestOperationCallable;
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
