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

package com.google.cloud.memcache.v1beta2.stub;

import static com.google.cloud.memcache.v1beta2.CloudMemcacheClient.ListInstancesPagedResponse;

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
import com.google.cloud.memcache.v1beta2.ApplyParametersRequest;
import com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest;
import com.google.cloud.memcache.v1beta2.CreateInstanceRequest;
import com.google.cloud.memcache.v1beta2.DeleteInstanceRequest;
import com.google.cloud.memcache.v1beta2.GetInstanceRequest;
import com.google.cloud.memcache.v1beta2.Instance;
import com.google.cloud.memcache.v1beta2.ListInstancesRequest;
import com.google.cloud.memcache.v1beta2.ListInstancesResponse;
import com.google.cloud.memcache.v1beta2.OperationMetadata;
import com.google.cloud.memcache.v1beta2.UpdateInstanceRequest;
import com.google.cloud.memcache.v1beta2.UpdateParametersRequest;
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
 * REST stub implementation for the CloudMemcache service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCloudMemcacheStub extends CloudMemcacheStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Instance.getDescriptor())
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstancesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInstancesResponse>newBuilder()
                      .setDefaultInstance(ListInstancesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetInstanceRequest, Instance>
      getInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceRequest, Instance>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Instance>newBuilder()
                      .setDefaultInstance(Instance.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInstanceRequest, Operation>
      createInstanceMethodDescriptor =
          ApiMethodDescriptor.<CreateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{parent=projects/*/locations/*}/instances",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "instanceId", request.getInstanceId());
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
                  (CreateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{resource.name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "resource.name", request.getResource().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
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
                  (UpdateInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateParametersRequest, Operation>
      updateParametersMethodDescriptor =
          ApiMethodDescriptor.<UpdateParametersRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/UpdateParameters")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateParametersRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{name=projects/*/locations/*/instances/*}:updateParameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParametersRequest> serializer =
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
                  (UpdateParametersRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceRequest> serializer =
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
                  (DeleteInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ApplyParametersRequest, Operation>
      applyParametersMethodDescriptor =
          ApiMethodDescriptor.<ApplyParametersRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/ApplyParameters")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApplyParametersRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{name=projects/*/locations/*/instances/*}:applyParameters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyParametersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApplyParametersRequest> serializer =
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
                  (ApplyParametersRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ApplySoftwareUpdateRequest, Operation>
      applySoftwareUpdateMethodDescriptor =
          ApiMethodDescriptor.<ApplySoftwareUpdateRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.memcache.v1beta2.CloudMemcache/ApplySoftwareUpdate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ApplySoftwareUpdateRequest>newBuilder()
                      .setPath(
                          "/v1beta2/{instance=projects/*/locations/*/instances/*}:applySoftwareUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ApplySoftwareUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "instance", request.getInstance());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ApplySoftwareUpdateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearInstance().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ApplySoftwareUpdateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<UpdateParametersRequest, Operation> updateParametersCallable;
  private final OperationCallable<UpdateParametersRequest, Instance, OperationMetadata>
      updateParametersOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<ApplyParametersRequest, Operation> applyParametersCallable;
  private final OperationCallable<ApplyParametersRequest, Instance, OperationMetadata>
      applyParametersOperationCallable;
  private final UnaryCallable<ApplySoftwareUpdateRequest, Operation> applySoftwareUpdateCallable;
  private final OperationCallable<ApplySoftwareUpdateRequest, Instance, OperationMetadata>
      applySoftwareUpdateOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudMemcacheStub create(CloudMemcacheStubSettings settings)
      throws IOException {
    return new HttpJsonCloudMemcacheStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudMemcacheStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudMemcacheStub(
        CloudMemcacheStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudMemcacheStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudMemcacheStub(
        CloudMemcacheStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudMemcacheStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudMemcacheStub(
      CloudMemcacheStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudMemcacheCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudMemcacheStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudMemcacheStub(
      CloudMemcacheStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListInstancesRequest, ListInstancesResponse>
        listInstancesTransportSettings =
            HttpJsonCallSettings.<ListInstancesRequest, ListInstancesResponse>newBuilder()
                .setMethodDescriptor(listInstancesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetInstanceRequest, Instance> getInstanceTransportSettings =
        HttpJsonCallSettings.<GetInstanceRequest, Instance>newBuilder()
            .setMethodDescriptor(getInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateInstanceRequest, Operation> createInstanceTransportSettings =
        HttpJsonCallSettings.<CreateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(createInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateParametersRequest, Operation> updateParametersTransportSettings =
        HttpJsonCallSettings.<UpdateParametersRequest, Operation>newBuilder()
            .setMethodDescriptor(updateParametersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ApplyParametersRequest, Operation> applyParametersTransportSettings =
        HttpJsonCallSettings.<ApplyParametersRequest, Operation>newBuilder()
            .setMethodDescriptor(applyParametersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ApplySoftwareUpdateRequest, Operation>
        applySoftwareUpdateTransportSettings =
            HttpJsonCallSettings.<ApplySoftwareUpdateRequest, Operation>newBuilder()
                .setMethodDescriptor(applySoftwareUpdateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listInstancesCallable =
        callableFactory.createUnaryCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.listInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesTransportSettings, settings.listInstancesSettings(), clientContext);
    this.getInstanceCallable =
        callableFactory.createUnaryCallable(
            getInstanceTransportSettings, settings.getInstanceSettings(), clientContext);
    this.createInstanceCallable =
        callableFactory.createUnaryCallable(
            createInstanceTransportSettings, settings.createInstanceSettings(), clientContext);
    this.createInstanceOperationCallable =
        callableFactory.createOperationCallable(
            createInstanceTransportSettings,
            settings.createInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateInstanceCallable =
        callableFactory.createUnaryCallable(
            updateInstanceTransportSettings, settings.updateInstanceSettings(), clientContext);
    this.updateInstanceOperationCallable =
        callableFactory.createOperationCallable(
            updateInstanceTransportSettings,
            settings.updateInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateParametersCallable =
        callableFactory.createUnaryCallable(
            updateParametersTransportSettings, settings.updateParametersSettings(), clientContext);
    this.updateParametersOperationCallable =
        callableFactory.createOperationCallable(
            updateParametersTransportSettings,
            settings.updateParametersOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.applyParametersCallable =
        callableFactory.createUnaryCallable(
            applyParametersTransportSettings, settings.applyParametersSettings(), clientContext);
    this.applyParametersOperationCallable =
        callableFactory.createOperationCallable(
            applyParametersTransportSettings,
            settings.applyParametersOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.applySoftwareUpdateCallable =
        callableFactory.createUnaryCallable(
            applySoftwareUpdateTransportSettings,
            settings.applySoftwareUpdateSettings(),
            clientContext);
    this.applySoftwareUpdateOperationCallable =
        callableFactory.createOperationCallable(
            applySoftwareUpdateTransportSettings,
            settings.applySoftwareUpdateOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(updateParametersMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(applyParametersMethodDescriptor);
    methodDescriptors.add(applySoftwareUpdateMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  @Override
  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    return listInstancesPagedCallable;
  }

  @Override
  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  @Override
  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  @Override
  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  @Override
  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    return updateInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateParametersRequest, Operation> updateParametersCallable() {
    return updateParametersCallable;
  }

  @Override
  public OperationCallable<UpdateParametersRequest, Instance, OperationMetadata>
      updateParametersOperationCallable() {
    return updateParametersOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<ApplyParametersRequest, Operation> applyParametersCallable() {
    return applyParametersCallable;
  }

  @Override
  public OperationCallable<ApplyParametersRequest, Instance, OperationMetadata>
      applyParametersOperationCallable() {
    return applyParametersOperationCallable;
  }

  @Override
  public UnaryCallable<ApplySoftwareUpdateRequest, Operation> applySoftwareUpdateCallable() {
    return applySoftwareUpdateCallable;
  }

  @Override
  public OperationCallable<ApplySoftwareUpdateRequest, Instance, OperationMetadata>
      applySoftwareUpdateOperationCallable() {
    return applySoftwareUpdateOperationCallable;
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
