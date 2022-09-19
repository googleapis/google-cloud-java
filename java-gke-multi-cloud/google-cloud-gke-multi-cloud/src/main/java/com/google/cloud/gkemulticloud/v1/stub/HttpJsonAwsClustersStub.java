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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.AwsServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest;
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
 * REST stub implementation for the AwsClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAwsClustersStub extends AwsClustersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(AwsCluster.getDescriptor())
          .add(AwsNodePool.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateAwsClusterRequest, Operation>
      createAwsClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateAwsClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/CreateAwsCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAwsClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/awsClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "awsClusterId", request.getAwsClusterId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("awsCluster", request.getAwsCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAwsClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAwsClusterRequest, Operation>
      updateAwsClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateAwsClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/UpdateAwsCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAwsClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{awsCluster.name=projects/*/locations/*/awsClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "awsCluster.name", request.getAwsCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("awsCluster", request.getAwsCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAwsClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAwsClusterRequest, AwsCluster>
      getAwsClusterMethodDescriptor =
          ApiMethodDescriptor.<GetAwsClusterRequest, AwsCluster>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAwsClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/awsClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AwsCluster>newBuilder()
                      .setDefaultInstance(AwsCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAwsClustersRequest, ListAwsClustersResponse>
      listAwsClustersMethodDescriptor =
          ApiMethodDescriptor.<ListAwsClustersRequest, ListAwsClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/ListAwsClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAwsClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/awsClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAwsClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAwsClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAwsClustersResponse>newBuilder()
                      .setDefaultInstance(ListAwsClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAwsClusterRequest, Operation>
      deleteAwsClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteAwsClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/DeleteAwsCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAwsClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/awsClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAwsClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteAwsClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GenerateAwsAccessToken")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAwsAccessTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{awsCluster=projects/*/locations/*/awsClusters/*}:generateAwsAccessToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAwsAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "awsCluster", request.getAwsCluster());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAwsAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAwsAccessTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateAwsAccessTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAwsNodePoolRequest, Operation>
      createAwsNodePoolMethodDescriptor =
          ApiMethodDescriptor.<CreateAwsNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/CreateAwsNodePool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAwsNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/awsClusters/*}/awsNodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "awsNodePoolId", request.getAwsNodePoolId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("awsNodePool", request.getAwsNodePool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAwsNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAwsNodePoolRequest, Operation>
      updateAwsNodePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateAwsNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/UpdateAwsNodePool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAwsNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{awsNodePool.name=projects/*/locations/*/awsClusters/*/awsNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "awsNodePool.name", request.getAwsNodePool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("awsNodePool", request.getAwsNodePool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAwsNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAwsNodePoolRequest, AwsNodePool>
      getAwsNodePoolMethodDescriptor =
          ApiMethodDescriptor.<GetAwsNodePoolRequest, AwsNodePool>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsNodePool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAwsNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/awsClusters/*/awsNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AwsNodePool>newBuilder()
                      .setDefaultInstance(AwsNodePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsMethodDescriptor =
          ApiMethodDescriptor.<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/ListAwsNodePools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAwsNodePoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/awsClusters/*}/awsNodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAwsNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAwsNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAwsNodePoolsResponse>newBuilder()
                      .setDefaultInstance(ListAwsNodePoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAwsNodePoolRequest, Operation>
      deleteAwsNodePoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteAwsNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/DeleteAwsNodePool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAwsNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/awsClusters/*/awsNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAwsNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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
                  (DeleteAwsNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigMethodDescriptor =
          ApiMethodDescriptor.<GetAwsServerConfigRequest, AwsServerConfig>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AwsClusters/GetAwsServerConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAwsServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/awsServerConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAwsServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AwsServerConfig>newBuilder()
                      .setDefaultInstance(AwsServerConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable;
  private final OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable;
  private final UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable;
  private final OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable;
  private final UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable;
  private final UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse>
      listAwsClustersCallable;
  private final UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable;
  private final UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable;
  private final OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable;
  private final UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable;
  private final UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable;
  private final OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable;
  private final UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable;
  private final OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable;
  private final UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable;
  private final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable;
  private final UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable;
  private final UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable;
  private final OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable;
  private final UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig>
      getAwsServerConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAwsClustersStub create(AwsClustersStubSettings settings)
      throws IOException {
    return new HttpJsonAwsClustersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAwsClustersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAwsClustersStub(
        AwsClustersStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAwsClustersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAwsClustersStub(
        AwsClustersStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAwsClustersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAwsClustersStub(AwsClustersStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAwsClustersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAwsClustersStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAwsClustersStub(
      AwsClustersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateAwsClusterRequest, Operation> createAwsClusterTransportSettings =
        HttpJsonCallSettings.<CreateAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createAwsClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAwsClusterRequest, Operation> updateAwsClusterTransportSettings =
        HttpJsonCallSettings.<UpdateAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAwsClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAwsClusterRequest, AwsCluster> getAwsClusterTransportSettings =
        HttpJsonCallSettings.<GetAwsClusterRequest, AwsCluster>newBuilder()
            .setMethodDescriptor(getAwsClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAwsClustersRequest, ListAwsClustersResponse>
        listAwsClustersTransportSettings =
            HttpJsonCallSettings.<ListAwsClustersRequest, ListAwsClustersResponse>newBuilder()
                .setMethodDescriptor(listAwsClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAwsClusterRequest, Operation> deleteAwsClusterTransportSettings =
        HttpJsonCallSettings.<DeleteAwsClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAwsClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
        generateAwsAccessTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAwsAccessTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAwsNodePoolRequest, Operation> createAwsNodePoolTransportSettings =
        HttpJsonCallSettings.<CreateAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createAwsNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolTransportSettings =
        HttpJsonCallSettings.<UpdateAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAwsNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolTransportSettings =
        HttpJsonCallSettings.<GetAwsNodePoolRequest, AwsNodePool>newBuilder()
            .setMethodDescriptor(getAwsNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
        listAwsNodePoolsTransportSettings =
            HttpJsonCallSettings.<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listAwsNodePoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolTransportSettings =
        HttpJsonCallSettings.<DeleteAwsNodePoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAwsNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAwsServerConfigRequest, AwsServerConfig>
        getAwsServerConfigTransportSettings =
            HttpJsonCallSettings.<GetAwsServerConfigRequest, AwsServerConfig>newBuilder()
                .setMethodDescriptor(getAwsServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createAwsClusterCallable =
        callableFactory.createUnaryCallable(
            createAwsClusterTransportSettings, settings.createAwsClusterSettings(), clientContext);
    this.createAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAwsClusterTransportSettings,
            settings.createAwsClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAwsClusterCallable =
        callableFactory.createUnaryCallable(
            updateAwsClusterTransportSettings, settings.updateAwsClusterSettings(), clientContext);
    this.updateAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAwsClusterTransportSettings,
            settings.updateAwsClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAwsClusterCallable =
        callableFactory.createUnaryCallable(
            getAwsClusterTransportSettings, settings.getAwsClusterSettings(), clientContext);
    this.listAwsClustersCallable =
        callableFactory.createUnaryCallable(
            listAwsClustersTransportSettings, settings.listAwsClustersSettings(), clientContext);
    this.listAwsClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAwsClustersTransportSettings, settings.listAwsClustersSettings(), clientContext);
    this.deleteAwsClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAwsClusterTransportSettings, settings.deleteAwsClusterSettings(), clientContext);
    this.deleteAwsClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAwsClusterTransportSettings,
            settings.deleteAwsClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAwsAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAwsAccessTokenTransportSettings,
            settings.generateAwsAccessTokenSettings(),
            clientContext);
    this.createAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            createAwsNodePoolTransportSettings,
            settings.createAwsNodePoolSettings(),
            clientContext);
    this.createAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createAwsNodePoolTransportSettings,
            settings.createAwsNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateAwsNodePoolTransportSettings,
            settings.updateAwsNodePoolSettings(),
            clientContext);
    this.updateAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateAwsNodePoolTransportSettings,
            settings.updateAwsNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            getAwsNodePoolTransportSettings, settings.getAwsNodePoolSettings(), clientContext);
    this.listAwsNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listAwsNodePoolsTransportSettings, settings.listAwsNodePoolsSettings(), clientContext);
    this.listAwsNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listAwsNodePoolsTransportSettings, settings.listAwsNodePoolsSettings(), clientContext);
    this.deleteAwsNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteAwsNodePoolTransportSettings,
            settings.deleteAwsNodePoolSettings(),
            clientContext);
    this.deleteAwsNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteAwsNodePoolTransportSettings,
            settings.deleteAwsNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAwsServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAwsServerConfigTransportSettings,
            settings.getAwsServerConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAwsClusterMethodDescriptor);
    methodDescriptors.add(updateAwsClusterMethodDescriptor);
    methodDescriptors.add(getAwsClusterMethodDescriptor);
    methodDescriptors.add(listAwsClustersMethodDescriptor);
    methodDescriptors.add(deleteAwsClusterMethodDescriptor);
    methodDescriptors.add(generateAwsAccessTokenMethodDescriptor);
    methodDescriptors.add(createAwsNodePoolMethodDescriptor);
    methodDescriptors.add(updateAwsNodePoolMethodDescriptor);
    methodDescriptors.add(getAwsNodePoolMethodDescriptor);
    methodDescriptors.add(listAwsNodePoolsMethodDescriptor);
    methodDescriptors.add(deleteAwsNodePoolMethodDescriptor);
    methodDescriptors.add(getAwsServerConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable() {
    return createAwsClusterCallable;
  }

  @Override
  public OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable() {
    return createAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable() {
    return updateAwsClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable() {
    return updateAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable() {
    return getAwsClusterCallable;
  }

  @Override
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse> listAwsClustersCallable() {
    return listAwsClustersCallable;
  }

  @Override
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable() {
    return listAwsClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable() {
    return deleteAwsClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable() {
    return deleteAwsClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable() {
    return generateAwsAccessTokenCallable;
  }

  @Override
  public UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable() {
    return createAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable() {
    return createAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable() {
    return updateAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable() {
    return updateAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable() {
    return getAwsNodePoolCallable;
  }

  @Override
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable() {
    return listAwsNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable() {
    return listAwsNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable() {
    return deleteAwsNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable() {
    return deleteAwsNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig> getAwsServerConfigCallable() {
    return getAwsServerConfigCallable;
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
