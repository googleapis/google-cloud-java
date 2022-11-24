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

package com.google.cloud.metastore.v1.stub;

import static com.google.cloud.metastore.v1.DataprocMetastoreFederationClient.ListFederationsPagedResponse;

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
import com.google.cloud.metastore.v1.CreateFederationRequest;
import com.google.cloud.metastore.v1.DeleteFederationRequest;
import com.google.cloud.metastore.v1.Federation;
import com.google.cloud.metastore.v1.GetFederationRequest;
import com.google.cloud.metastore.v1.ListFederationsRequest;
import com.google.cloud.metastore.v1.ListFederationsResponse;
import com.google.cloud.metastore.v1.OperationMetadata;
import com.google.cloud.metastore.v1.UpdateFederationRequest;
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
 * REST stub implementation for the DataprocMetastoreFederation service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonDataprocMetastoreFederationStub extends DataprocMetastoreFederationStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(Federation.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListFederationsRequest, ListFederationsResponse>
      listFederationsMethodDescriptor =
          ApiMethodDescriptor.<ListFederationsRequest, ListFederationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/ListFederations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFederationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/federations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFederationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFederationsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListFederationsResponse>newBuilder()
                      .setDefaultInstance(ListFederationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFederationRequest, Federation>
      getFederationMethodDescriptor =
          ApiMethodDescriptor.<GetFederationRequest, Federation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/GetFederation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFederationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/federations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Federation>newBuilder()
                      .setDefaultInstance(Federation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFederationRequest, Operation>
      createFederationMethodDescriptor =
          ApiMethodDescriptor.<CreateFederationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/CreateFederation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFederationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/federations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "federationId", request.getFederationId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("federation", request.getFederation(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateFederationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateFederationRequest, Operation>
      updateFederationMethodDescriptor =
          ApiMethodDescriptor.<UpdateFederationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/UpdateFederation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFederationRequest>newBuilder()
                      .setPath(
                          "/v1/{federation.name=projects/*/locations/*/federations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "federation.name", request.getFederation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("federation", request.getFederation(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateFederationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteFederationRequest, Operation>
      deleteFederationMethodDescriptor =
          ApiMethodDescriptor.<DeleteFederationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.metastore.v1.DataprocMetastoreFederation/DeleteFederation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFederationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/federations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFederationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  (DeleteFederationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListFederationsRequest, ListFederationsResponse>
      listFederationsCallable;
  private final UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable;
  private final UnaryCallable<GetFederationRequest, Federation> getFederationCallable;
  private final UnaryCallable<CreateFederationRequest, Operation> createFederationCallable;
  private final OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable;
  private final UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable;
  private final OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable;
  private final UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable;
  private final OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataprocMetastoreFederationStub create(
      DataprocMetastoreFederationStubSettings settings) throws IOException {
    return new HttpJsonDataprocMetastoreFederationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataprocMetastoreFederationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataprocMetastoreFederationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataprocMetastoreFederationStub(
        DataprocMetastoreFederationStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataprocMetastoreFederationStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataprocMetastoreFederationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataprocMetastoreFederationStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonDataprocMetastoreFederationStub(
      DataprocMetastoreFederationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListFederationsRequest, ListFederationsResponse>
        listFederationsTransportSettings =
            HttpJsonCallSettings.<ListFederationsRequest, ListFederationsResponse>newBuilder()
                .setMethodDescriptor(listFederationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetFederationRequest, Federation> getFederationTransportSettings =
        HttpJsonCallSettings.<GetFederationRequest, Federation>newBuilder()
            .setMethodDescriptor(getFederationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateFederationRequest, Operation> createFederationTransportSettings =
        HttpJsonCallSettings.<CreateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(createFederationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateFederationRequest, Operation> updateFederationTransportSettings =
        HttpJsonCallSettings.<UpdateFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateFederationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteFederationRequest, Operation> deleteFederationTransportSettings =
        HttpJsonCallSettings.<DeleteFederationRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteFederationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listFederationsCallable =
        callableFactory.createUnaryCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.listFederationsPagedCallable =
        callableFactory.createPagedCallable(
            listFederationsTransportSettings, settings.listFederationsSettings(), clientContext);
    this.getFederationCallable =
        callableFactory.createUnaryCallable(
            getFederationTransportSettings, settings.getFederationSettings(), clientContext);
    this.createFederationCallable =
        callableFactory.createUnaryCallable(
            createFederationTransportSettings, settings.createFederationSettings(), clientContext);
    this.createFederationOperationCallable =
        callableFactory.createOperationCallable(
            createFederationTransportSettings,
            settings.createFederationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateFederationCallable =
        callableFactory.createUnaryCallable(
            updateFederationTransportSettings, settings.updateFederationSettings(), clientContext);
    this.updateFederationOperationCallable =
        callableFactory.createOperationCallable(
            updateFederationTransportSettings,
            settings.updateFederationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteFederationCallable =
        callableFactory.createUnaryCallable(
            deleteFederationTransportSettings, settings.deleteFederationSettings(), clientContext);
    this.deleteFederationOperationCallable =
        callableFactory.createOperationCallable(
            deleteFederationTransportSettings,
            settings.deleteFederationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listFederationsMethodDescriptor);
    methodDescriptors.add(getFederationMethodDescriptor);
    methodDescriptors.add(createFederationMethodDescriptor);
    methodDescriptors.add(updateFederationMethodDescriptor);
    methodDescriptors.add(deleteFederationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListFederationsRequest, ListFederationsResponse> listFederationsCallable() {
    return listFederationsCallable;
  }

  @Override
  public UnaryCallable<ListFederationsRequest, ListFederationsPagedResponse>
      listFederationsPagedCallable() {
    return listFederationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFederationRequest, Federation> getFederationCallable() {
    return getFederationCallable;
  }

  @Override
  public UnaryCallable<CreateFederationRequest, Operation> createFederationCallable() {
    return createFederationCallable;
  }

  @Override
  public OperationCallable<CreateFederationRequest, Federation, OperationMetadata>
      createFederationOperationCallable() {
    return createFederationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateFederationRequest, Operation> updateFederationCallable() {
    return updateFederationCallable;
  }

  @Override
  public OperationCallable<UpdateFederationRequest, Federation, OperationMetadata>
      updateFederationOperationCallable() {
    return updateFederationOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteFederationRequest, Operation> deleteFederationCallable() {
    return deleteFederationCallable;
  }

  @Override
  public OperationCallable<DeleteFederationRequest, Empty, OperationMetadata>
      deleteFederationOperationCallable() {
    return deleteFederationOperationCallable;
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
