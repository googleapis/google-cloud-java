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

package com.google.cloud.assuredworkloads.v1beta1.stub;

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
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadOperationMetadata;
import com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest;
import com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest;
import com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse;
import com.google.cloud.assuredworkloads.v1beta1.Workload;
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
 * REST stub implementation for the AssuredWorkloadsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonAssuredWorkloadsServiceStub extends AssuredWorkloadsServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CreateWorkloadOperationMetadata.getDescriptor())
          .add(Workload.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateWorkloadRequest, Operation>
      createWorkloadMethodDescriptor =
          ApiMethodDescriptor.<CreateWorkloadRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/CreateWorkload")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWorkloadRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=organizations/*/locations/*}/workloads",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "externalId", request.getExternalId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("workload", request.getWorkload(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateWorkloadRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesMethodDescriptor =
          ApiMethodDescriptor
              .<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/RestrictAllowedResources")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestrictAllowedResourcesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=organizations/*/locations/*/workloads/*}:restrictAllowedResources",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestrictAllowedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestrictAllowedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RestrictAllowedResourcesResponse>newBuilder()
                      .setDefaultInstance(RestrictAllowedResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWorkloadRequest, Empty>
      deleteWorkloadMethodDescriptor =
          ApiMethodDescriptor.<DeleteWorkloadRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService/DeleteWorkload")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWorkloadRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=organizations/*/locations/*/workloads/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWorkloadRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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

  private final UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable;
  private final OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable;
  private final UnaryCallable<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesCallable;
  private final UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAssuredWorkloadsServiceStub create(
      AssuredWorkloadsServiceStubSettings settings) throws IOException {
    return new HttpJsonAssuredWorkloadsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAssuredWorkloadsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAssuredWorkloadsServiceStub(
        AssuredWorkloadsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAssuredWorkloadsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAssuredWorkloadsServiceStub(
        AssuredWorkloadsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAssuredWorkloadsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAssuredWorkloadsServiceStub(
      AssuredWorkloadsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAssuredWorkloadsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAssuredWorkloadsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAssuredWorkloadsServiceStub(
      AssuredWorkloadsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateWorkloadRequest, Operation> createWorkloadTransportSettings =
        HttpJsonCallSettings.<CreateWorkloadRequest, Operation>newBuilder()
            .setMethodDescriptor(createWorkloadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
        restrictAllowedResourcesTransportSettings =
            HttpJsonCallSettings
                .<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>newBuilder()
                .setMethodDescriptor(restrictAllowedResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteWorkloadRequest, Empty> deleteWorkloadTransportSettings =
        HttpJsonCallSettings.<DeleteWorkloadRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWorkloadMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createWorkloadCallable =
        callableFactory.createUnaryCallable(
            createWorkloadTransportSettings, settings.createWorkloadSettings(), clientContext);
    this.createWorkloadOperationCallable =
        callableFactory.createOperationCallable(
            createWorkloadTransportSettings,
            settings.createWorkloadOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.restrictAllowedResourcesCallable =
        callableFactory.createUnaryCallable(
            restrictAllowedResourcesTransportSettings,
            settings.restrictAllowedResourcesSettings(),
            clientContext);
    this.deleteWorkloadCallable =
        callableFactory.createUnaryCallable(
            deleteWorkloadTransportSettings, settings.deleteWorkloadSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createWorkloadMethodDescriptor);
    methodDescriptors.add(restrictAllowedResourcesMethodDescriptor);
    methodDescriptors.add(deleteWorkloadMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateWorkloadRequest, Operation> createWorkloadCallable() {
    return createWorkloadCallable;
  }

  @Override
  public OperationCallable<CreateWorkloadRequest, Workload, CreateWorkloadOperationMetadata>
      createWorkloadOperationCallable() {
    return createWorkloadOperationCallable;
  }

  @Override
  public UnaryCallable<RestrictAllowedResourcesRequest, RestrictAllowedResourcesResponse>
      restrictAllowedResourcesCallable() {
    return restrictAllowedResourcesCallable;
  }

  @Override
  public UnaryCallable<DeleteWorkloadRequest, Empty> deleteWorkloadCallable() {
    return deleteWorkloadCallable;
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
