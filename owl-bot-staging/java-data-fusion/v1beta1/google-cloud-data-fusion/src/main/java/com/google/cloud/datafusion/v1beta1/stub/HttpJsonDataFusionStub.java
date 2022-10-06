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

package com.google.cloud.datafusion.v1beta1.stub;

import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListDnsPeeringsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListInstancesPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListNamespacesPagedResponse;

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
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.CreateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.DeleteInstanceRequest;
import com.google.cloud.datafusion.v1beta1.GetInstanceRequest;
import com.google.cloud.datafusion.v1beta1.Instance;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsRequest;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsResponse;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsRequest;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsResponse;
import com.google.cloud.datafusion.v1beta1.ListInstancesRequest;
import com.google.cloud.datafusion.v1beta1.ListInstancesResponse;
import com.google.cloud.datafusion.v1beta1.ListNamespacesRequest;
import com.google.cloud.datafusion.v1beta1.ListNamespacesResponse;
import com.google.cloud.datafusion.v1beta1.OperationMetadata;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyRequest;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyResponse;
import com.google.cloud.datafusion.v1beta1.RestartInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpdateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpgradeInstanceRequest;
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
 * REST stub implementation for the DataFusion service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataFusionStub extends DataFusionStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(Instance.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAvailableVersionsRequest, ListAvailableVersionsResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListAvailableVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAvailableVersionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/versions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAvailableVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAvailableVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "latestPatchOnly", request.getLatestPatchOnly());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAvailableVersionsResponse>newBuilder()
                      .setDefaultInstance(ListAvailableVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListInstancesRequest, ListInstancesResponse>
      listInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListInstancesRequest, ListInstancesResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListInstances")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInstancesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/instances",
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
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/GetInstance")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/instances/*}",
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
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/CreateInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/instances",
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
                                  .toBody("instance", request.getInstance(), false))
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

  private static final ApiMethodDescriptor<DeleteInstanceRequest, Operation>
      deleteInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/DeleteInstance")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/instances/*}",
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

  private static final ApiMethodDescriptor<UpdateInstanceRequest, Operation>
      updateInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpdateInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/UpdateInstance")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{instance.name=projects/*/locations/*/instances/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instance.name", request.getInstance().getName());
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
                                  .toBody("instance", request.getInstance(), false))
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

  private static final ApiMethodDescriptor<RestartInstanceRequest, Operation>
      restartInstanceMethodDescriptor =
          ApiMethodDescriptor.<RestartInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RestartInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestartInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/instances/*}:restart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestartInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestartInstanceRequest> serializer =
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
                  (RestartInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpgradeInstanceRequest, Operation>
      upgradeInstanceMethodDescriptor =
          ApiMethodDescriptor.<UpgradeInstanceRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/UpgradeInstance")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpgradeInstanceRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/instances/*}:upgrade",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeInstanceRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpgradeInstanceRequest> serializer =
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
                  (UpgradeInstanceRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RemoveIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/**}:removeIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveIamPolicyResponse>newBuilder()
                      .setDefaultInstance(RemoveIamPolicyResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListNamespacesRequest, ListNamespacesResponse>
      listNamespacesMethodDescriptor =
          ApiMethodDescriptor.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListNamespaces")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNamespacesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/instances/*}/namespaces",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNamespacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNamespacesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNamespacesResponse>newBuilder()
                      .setDefaultInstance(ListNamespacesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AddDnsPeeringRequest, AddDnsPeeringResponse>
      addDnsPeeringMethodDescriptor =
          ApiMethodDescriptor.<AddDnsPeeringRequest, AddDnsPeeringResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/AddDnsPeering")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddDnsPeeringRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/instances/*}/dnsPeerings:add",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddDnsPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddDnsPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AddDnsPeeringResponse>newBuilder()
                      .setDefaultInstance(AddDnsPeeringResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringMethodDescriptor =
          ApiMethodDescriptor.<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/RemoveDnsPeering")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveDnsPeeringRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/instances/*}/dnsPeerings:remove",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDnsPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveDnsPeeringRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RemoveDnsPeeringResponse>newBuilder()
                      .setDefaultInstance(RemoveDnsPeeringResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
      listDnsPeeringsMethodDescriptor =
          ApiMethodDescriptor.<ListDnsPeeringsRequest, ListDnsPeeringsResponse>newBuilder()
              .setFullMethodName("google.cloud.datafusion.v1beta1.DataFusion/ListDnsPeerings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListDnsPeeringsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/instances/*}/dnsPeerings:list",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListDnsPeeringsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListDnsPeeringsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListDnsPeeringsResponse>newBuilder()
                      .setDefaultInstance(ListDnsPeeringsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable;
  private final UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable;
  private final UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable;
  private final OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable;
  private final UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable;
  private final OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable;
  private final UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable;
  private final OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable;
  private final UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable;
  private final OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable;
  private final UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicyCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable;
  private final UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable;
  private final UnaryCallable<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringCallable;
  private final UnaryCallable<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringCallable;
  private final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
      listDnsPeeringsCallable;
  private final UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsPagedResponse>
      listDnsPeeringsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataFusionStub create(DataFusionStubSettings settings)
      throws IOException {
    return new HttpJsonDataFusionStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataFusionStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataFusionStub(
        DataFusionStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataFusionStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataFusionStub(
        DataFusionStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataFusionStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataFusionStub(DataFusionStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataFusionCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataFusionStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonDataFusionStub(
      DataFusionStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
        listAvailableVersionsTransportSettings =
            HttpJsonCallSettings
                .<ListAvailableVersionsRequest, ListAvailableVersionsResponse>newBuilder()
                .setMethodDescriptor(listAvailableVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
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
    HttpJsonCallSettings<DeleteInstanceRequest, Operation> deleteInstanceTransportSettings =
        HttpJsonCallSettings.<DeleteInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateInstanceRequest, Operation> updateInstanceTransportSettings =
        HttpJsonCallSettings.<UpdateInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(updateInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RestartInstanceRequest, Operation> restartInstanceTransportSettings =
        HttpJsonCallSettings.<RestartInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(restartInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceTransportSettings =
        HttpJsonCallSettings.<UpgradeInstanceRequest, Operation>newBuilder()
            .setMethodDescriptor(upgradeInstanceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicyTransportSettings =
            HttpJsonCallSettings.<RemoveIamPolicyRequest, RemoveIamPolicyResponse>newBuilder()
                .setMethodDescriptor(removeIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListNamespacesRequest, ListNamespacesResponse>
        listNamespacesTransportSettings =
            HttpJsonCallSettings.<ListNamespacesRequest, ListNamespacesResponse>newBuilder()
                .setMethodDescriptor(listNamespacesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddDnsPeeringRequest, AddDnsPeeringResponse>
        addDnsPeeringTransportSettings =
            HttpJsonCallSettings.<AddDnsPeeringRequest, AddDnsPeeringResponse>newBuilder()
                .setMethodDescriptor(addDnsPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
        removeDnsPeeringTransportSettings =
            HttpJsonCallSettings.<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>newBuilder()
                .setMethodDescriptor(removeDnsPeeringMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListDnsPeeringsRequest, ListDnsPeeringsResponse>
        listDnsPeeringsTransportSettings =
            HttpJsonCallSettings.<ListDnsPeeringsRequest, ListDnsPeeringsResponse>newBuilder()
                .setMethodDescriptor(listDnsPeeringsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.listAvailableVersionsCallable =
        callableFactory.createUnaryCallable(
            listAvailableVersionsTransportSettings,
            settings.listAvailableVersionsSettings(),
            clientContext);
    this.listAvailableVersionsPagedCallable =
        callableFactory.createPagedCallable(
            listAvailableVersionsTransportSettings,
            settings.listAvailableVersionsSettings(),
            clientContext);
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
    this.deleteInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceTransportSettings, settings.deleteInstanceSettings(), clientContext);
    this.deleteInstanceOperationCallable =
        callableFactory.createOperationCallable(
            deleteInstanceTransportSettings,
            settings.deleteInstanceOperationSettings(),
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
    this.restartInstanceCallable =
        callableFactory.createUnaryCallable(
            restartInstanceTransportSettings, settings.restartInstanceSettings(), clientContext);
    this.restartInstanceOperationCallable =
        callableFactory.createOperationCallable(
            restartInstanceTransportSettings,
            settings.restartInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.upgradeInstanceCallable =
        callableFactory.createUnaryCallable(
            upgradeInstanceTransportSettings, settings.upgradeInstanceSettings(), clientContext);
    this.upgradeInstanceOperationCallable =
        callableFactory.createOperationCallable(
            upgradeInstanceTransportSettings,
            settings.upgradeInstanceOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            removeIamPolicyTransportSettings, settings.removeIamPolicySettings(), clientContext);
    this.listNamespacesCallable =
        callableFactory.createUnaryCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.listNamespacesPagedCallable =
        callableFactory.createPagedCallable(
            listNamespacesTransportSettings, settings.listNamespacesSettings(), clientContext);
    this.addDnsPeeringCallable =
        callableFactory.createUnaryCallable(
            addDnsPeeringTransportSettings, settings.addDnsPeeringSettings(), clientContext);
    this.removeDnsPeeringCallable =
        callableFactory.createUnaryCallable(
            removeDnsPeeringTransportSettings, settings.removeDnsPeeringSettings(), clientContext);
    this.listDnsPeeringsCallable =
        callableFactory.createUnaryCallable(
            listDnsPeeringsTransportSettings, settings.listDnsPeeringsSettings(), clientContext);
    this.listDnsPeeringsPagedCallable =
        callableFactory.createPagedCallable(
            listDnsPeeringsTransportSettings, settings.listDnsPeeringsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listAvailableVersionsMethodDescriptor);
    methodDescriptors.add(listInstancesMethodDescriptor);
    methodDescriptors.add(getInstanceMethodDescriptor);
    methodDescriptors.add(createInstanceMethodDescriptor);
    methodDescriptors.add(deleteInstanceMethodDescriptor);
    methodDescriptors.add(updateInstanceMethodDescriptor);
    methodDescriptors.add(restartInstanceMethodDescriptor);
    methodDescriptors.add(upgradeInstanceMethodDescriptor);
    methodDescriptors.add(removeIamPolicyMethodDescriptor);
    methodDescriptors.add(listNamespacesMethodDescriptor);
    methodDescriptors.add(addDnsPeeringMethodDescriptor);
    methodDescriptors.add(removeDnsPeeringMethodDescriptor);
    methodDescriptors.add(listDnsPeeringsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable() {
    return listAvailableVersionsCallable;
  }

  @Override
  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable() {
    return listAvailableVersionsPagedCallable;
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
  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    return deleteInstanceOperationCallable;
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
  public UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    return restartInstanceCallable;
  }

  @Override
  public OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    return restartInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    return upgradeInstanceCallable;
  }

  @Override
  public OperationCallable<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationCallable() {
    return upgradeInstanceOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse> removeIamPolicyCallable() {
    return removeIamPolicyCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> listNamespacesCallable() {
    return listNamespacesCallable;
  }

  @Override
  public UnaryCallable<ListNamespacesRequest, ListNamespacesPagedResponse>
      listNamespacesPagedCallable() {
    return listNamespacesPagedCallable;
  }

  @Override
  public UnaryCallable<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringCallable() {
    return addDnsPeeringCallable;
  }

  @Override
  public UnaryCallable<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringCallable() {
    return removeDnsPeeringCallable;
  }

  @Override
  public UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse> listDnsPeeringsCallable() {
    return listDnsPeeringsCallable;
  }

  @Override
  public UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsPagedResponse>
      listDnsPeeringsPagedCallable() {
    return listDnsPeeringsPagedCallable;
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
