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

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

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
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureCluster;
import com.google.cloud.gkemulticloud.v1.AzureNodePool;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest;
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
 * REST stub implementation for the AzureClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonAzureClustersStub extends AzureClustersStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(AzureNodePool.getDescriptor())
          .add(AzureCluster.getDescriptor())
          .add(AzureClient.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateAzureClientRequest, Operation>
      createAzureClientMethodDescriptor =
          ApiMethodDescriptor.<CreateAzureClientRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureClient")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAzureClientRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/azureClients",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "azureClientId", request.getAzureClientId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("azureClient", request.getAzureClient(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAzureClientRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAzureClientRequest, AzureClient>
      getAzureClientMethodDescriptor =
          ApiMethodDescriptor.<GetAzureClientRequest, AzureClient>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureClient")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAzureClientRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClients/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AzureClient>newBuilder()
                      .setDefaultInstance(AzureClient.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsMethodDescriptor =
          ApiMethodDescriptor.<ListAzureClientsRequest, ListAzureClientsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureClients")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAzureClientsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/azureClients",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureClientsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAzureClientsResponse>newBuilder()
                      .setDefaultInstance(ListAzureClientsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAzureClientRequest, Operation>
      deleteAzureClientMethodDescriptor =
          ApiMethodDescriptor.<DeleteAzureClientRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureClient")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAzureClientRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClients/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureClientRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
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
                  (DeleteAzureClientRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateAzureClusterRequest, Operation>
      createAzureClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateAzureClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAzureClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/azureClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "azureClusterId", request.getAzureClusterId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("azureCluster", request.getAzureCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAzureClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAzureClusterRequest, Operation>
      updateAzureClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateAzureClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/UpdateAzureCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAzureClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{azureCluster.name=projects/*/locations/*/azureClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "azureCluster.name", request.getAzureCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("azureCluster", request.getAzureCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAzureClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAzureClusterRequest, AzureCluster>
      getAzureClusterMethodDescriptor =
          ApiMethodDescriptor.<GetAzureClusterRequest, AzureCluster>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAzureClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AzureCluster>newBuilder()
                      .setDefaultInstance(AzureCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersMethodDescriptor =
          ApiMethodDescriptor.<ListAzureClustersRequest, ListAzureClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAzureClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/azureClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAzureClustersResponse>newBuilder()
                      .setDefaultInstance(ListAzureClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAzureClusterRequest, Operation>
      deleteAzureClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteAzureClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAzureClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureClusterRequest> serializer =
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
                  (DeleteAzureClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenMethodDescriptor =
          ApiMethodDescriptor
              .<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.gkemulticloud.v1.AzureClusters/GenerateAzureAccessToken")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateAzureAccessTokenRequest>newBuilder()
                      .setPath(
                          "/v1/{azureCluster=projects/*/locations/*/azureClusters/*}:generateAzureAccessToken",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAzureAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "azureCluster", request.getAzureCluster());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateAzureAccessTokenRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateAzureAccessTokenResponse>newBuilder()
                      .setDefaultInstance(GenerateAzureAccessTokenResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAzureNodePoolRequest, Operation>
      createAzureNodePoolMethodDescriptor =
          ApiMethodDescriptor.<CreateAzureNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/CreateAzureNodePool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAzureNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/azureClusters/*}/azureNodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "azureNodePoolId", request.getAzureNodePoolId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("azureNodePool", request.getAzureNodePool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAzureNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateAzureNodePoolRequest, Operation>
      updateAzureNodePoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateAzureNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/UpdateAzureNodePool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAzureNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{azureNodePool.name=projects/*/locations/*/azureClusters/*/azureNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "azureNodePool.name", request.getAzureNodePool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("azureNodePool", request.getAzureNodePool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateAzureNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAzureNodePoolRequest, AzureNodePool>
      getAzureNodePoolMethodDescriptor =
          ApiMethodDescriptor.<GetAzureNodePoolRequest, AzureNodePool>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureNodePool")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAzureNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClusters/*/azureNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AzureNodePool>newBuilder()
                      .setDefaultInstance(AzureNodePool.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsMethodDescriptor =
          ApiMethodDescriptor.<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/ListAzureNodePools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAzureNodePoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/azureClusters/*}/azureNodePools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAzureNodePoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAzureNodePoolsResponse>newBuilder()
                      .setDefaultInstance(ListAzureNodePoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAzureNodePoolRequest, Operation>
      deleteAzureNodePoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteAzureNodePoolRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/DeleteAzureNodePool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAzureNodePoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureClusters/*/azureNodePools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureNodePoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAzureNodePoolRequest> serializer =
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
                  (DeleteAzureNodePoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigMethodDescriptor =
          ApiMethodDescriptor.<GetAzureServerConfigRequest, AzureServerConfig>newBuilder()
              .setFullMethodName("google.cloud.gkemulticloud.v1.AzureClusters/GetAzureServerConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAzureServerConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/azureServerConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAzureServerConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AzureServerConfig>newBuilder()
                      .setDefaultInstance(AzureServerConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable;
  private final OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable;
  private final UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable;
  private final UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable;
  private final UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable;
  private final UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable;
  private final OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable;
  private final UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable;
  private final OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable;
  private final UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable;
  private final OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable;
  private final UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable;
  private final UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable;
  private final UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable;
  private final UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable;
  private final OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable;
  private final UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable;
  private final UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable;
  private final OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable;
  private final UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable;
  private final OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable;
  private final UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable;
  private final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable;
  private final UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable;
  private final UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable;
  private final OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable;
  private final UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAzureClustersStub create(AzureClustersStubSettings settings)
      throws IOException {
    return new HttpJsonAzureClustersStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAzureClustersStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAzureClustersStub(
        AzureClustersStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAzureClustersStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAzureClustersStub(
        AzureClustersStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAzureClustersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAzureClustersStub(
      AzureClustersStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAzureClustersCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAzureClustersStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAzureClustersStub(
      AzureClustersStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateAzureClientRequest, Operation> createAzureClientTransportSettings =
        HttpJsonCallSettings.<CreateAzureClientRequest, Operation>newBuilder()
            .setMethodDescriptor(createAzureClientMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAzureClientRequest, AzureClient> getAzureClientTransportSettings =
        HttpJsonCallSettings.<GetAzureClientRequest, AzureClient>newBuilder()
            .setMethodDescriptor(getAzureClientMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAzureClientsRequest, ListAzureClientsResponse>
        listAzureClientsTransportSettings =
            HttpJsonCallSettings.<ListAzureClientsRequest, ListAzureClientsResponse>newBuilder()
                .setMethodDescriptor(listAzureClientsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAzureClientRequest, Operation> deleteAzureClientTransportSettings =
        HttpJsonCallSettings.<DeleteAzureClientRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAzureClientMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateAzureClusterRequest, Operation> createAzureClusterTransportSettings =
        HttpJsonCallSettings.<CreateAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createAzureClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateAzureClusterRequest, Operation> updateAzureClusterTransportSettings =
        HttpJsonCallSettings.<UpdateAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAzureClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAzureClusterRequest, AzureCluster> getAzureClusterTransportSettings =
        HttpJsonCallSettings.<GetAzureClusterRequest, AzureCluster>newBuilder()
            .setMethodDescriptor(getAzureClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAzureClustersRequest, ListAzureClustersResponse>
        listAzureClustersTransportSettings =
            HttpJsonCallSettings.<ListAzureClustersRequest, ListAzureClustersResponse>newBuilder()
                .setMethodDescriptor(listAzureClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAzureClusterRequest, Operation> deleteAzureClusterTransportSettings =
        HttpJsonCallSettings.<DeleteAzureClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAzureClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
        generateAzureAccessTokenTransportSettings =
            HttpJsonCallSettings
                .<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>newBuilder()
                .setMethodDescriptor(generateAzureAccessTokenMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateAzureNodePoolRequest, Operation>
        createAzureNodePoolTransportSettings =
            HttpJsonCallSettings.<CreateAzureNodePoolRequest, Operation>newBuilder()
                .setMethodDescriptor(createAzureNodePoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateAzureNodePoolRequest, Operation>
        updateAzureNodePoolTransportSettings =
            HttpJsonCallSettings.<UpdateAzureNodePoolRequest, Operation>newBuilder()
                .setMethodDescriptor(updateAzureNodePoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolTransportSettings =
        HttpJsonCallSettings.<GetAzureNodePoolRequest, AzureNodePool>newBuilder()
            .setMethodDescriptor(getAzureNodePoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
        listAzureNodePoolsTransportSettings =
            HttpJsonCallSettings.<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>newBuilder()
                .setMethodDescriptor(listAzureNodePoolsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteAzureNodePoolRequest, Operation>
        deleteAzureNodePoolTransportSettings =
            HttpJsonCallSettings.<DeleteAzureNodePoolRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteAzureNodePoolMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetAzureServerConfigRequest, AzureServerConfig>
        getAzureServerConfigTransportSettings =
            HttpJsonCallSettings.<GetAzureServerConfigRequest, AzureServerConfig>newBuilder()
                .setMethodDescriptor(getAzureServerConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.createAzureClientCallable =
        callableFactory.createUnaryCallable(
            createAzureClientTransportSettings,
            settings.createAzureClientSettings(),
            clientContext);
    this.createAzureClientOperationCallable =
        callableFactory.createOperationCallable(
            createAzureClientTransportSettings,
            settings.createAzureClientOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAzureClientCallable =
        callableFactory.createUnaryCallable(
            getAzureClientTransportSettings, settings.getAzureClientSettings(), clientContext);
    this.listAzureClientsCallable =
        callableFactory.createUnaryCallable(
            listAzureClientsTransportSettings, settings.listAzureClientsSettings(), clientContext);
    this.listAzureClientsPagedCallable =
        callableFactory.createPagedCallable(
            listAzureClientsTransportSettings, settings.listAzureClientsSettings(), clientContext);
    this.deleteAzureClientCallable =
        callableFactory.createUnaryCallable(
            deleteAzureClientTransportSettings,
            settings.deleteAzureClientSettings(),
            clientContext);
    this.deleteAzureClientOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureClientTransportSettings,
            settings.deleteAzureClientOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createAzureClusterCallable =
        callableFactory.createUnaryCallable(
            createAzureClusterTransportSettings,
            settings.createAzureClusterSettings(),
            clientContext);
    this.createAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            createAzureClusterTransportSettings,
            settings.createAzureClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAzureClusterCallable =
        callableFactory.createUnaryCallable(
            updateAzureClusterTransportSettings,
            settings.updateAzureClusterSettings(),
            clientContext);
    this.updateAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateAzureClusterTransportSettings,
            settings.updateAzureClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAzureClusterCallable =
        callableFactory.createUnaryCallable(
            getAzureClusterTransportSettings, settings.getAzureClusterSettings(), clientContext);
    this.listAzureClustersCallable =
        callableFactory.createUnaryCallable(
            listAzureClustersTransportSettings,
            settings.listAzureClustersSettings(),
            clientContext);
    this.listAzureClustersPagedCallable =
        callableFactory.createPagedCallable(
            listAzureClustersTransportSettings,
            settings.listAzureClustersSettings(),
            clientContext);
    this.deleteAzureClusterCallable =
        callableFactory.createUnaryCallable(
            deleteAzureClusterTransportSettings,
            settings.deleteAzureClusterSettings(),
            clientContext);
    this.deleteAzureClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureClusterTransportSettings,
            settings.deleteAzureClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.generateAzureAccessTokenCallable =
        callableFactory.createUnaryCallable(
            generateAzureAccessTokenTransportSettings,
            settings.generateAzureAccessTokenSettings(),
            clientContext);
    this.createAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            createAzureNodePoolTransportSettings,
            settings.createAzureNodePoolSettings(),
            clientContext);
    this.createAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            createAzureNodePoolTransportSettings,
            settings.createAzureNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            updateAzureNodePoolTransportSettings,
            settings.updateAzureNodePoolSettings(),
            clientContext);
    this.updateAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            updateAzureNodePoolTransportSettings,
            settings.updateAzureNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            getAzureNodePoolTransportSettings, settings.getAzureNodePoolSettings(), clientContext);
    this.listAzureNodePoolsCallable =
        callableFactory.createUnaryCallable(
            listAzureNodePoolsTransportSettings,
            settings.listAzureNodePoolsSettings(),
            clientContext);
    this.listAzureNodePoolsPagedCallable =
        callableFactory.createPagedCallable(
            listAzureNodePoolsTransportSettings,
            settings.listAzureNodePoolsSettings(),
            clientContext);
    this.deleteAzureNodePoolCallable =
        callableFactory.createUnaryCallable(
            deleteAzureNodePoolTransportSettings,
            settings.deleteAzureNodePoolSettings(),
            clientContext);
    this.deleteAzureNodePoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteAzureNodePoolTransportSettings,
            settings.deleteAzureNodePoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getAzureServerConfigCallable =
        callableFactory.createUnaryCallable(
            getAzureServerConfigTransportSettings,
            settings.getAzureServerConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createAzureClientMethodDescriptor);
    methodDescriptors.add(getAzureClientMethodDescriptor);
    methodDescriptors.add(listAzureClientsMethodDescriptor);
    methodDescriptors.add(deleteAzureClientMethodDescriptor);
    methodDescriptors.add(createAzureClusterMethodDescriptor);
    methodDescriptors.add(updateAzureClusterMethodDescriptor);
    methodDescriptors.add(getAzureClusterMethodDescriptor);
    methodDescriptors.add(listAzureClustersMethodDescriptor);
    methodDescriptors.add(deleteAzureClusterMethodDescriptor);
    methodDescriptors.add(generateAzureAccessTokenMethodDescriptor);
    methodDescriptors.add(createAzureNodePoolMethodDescriptor);
    methodDescriptors.add(updateAzureNodePoolMethodDescriptor);
    methodDescriptors.add(getAzureNodePoolMethodDescriptor);
    methodDescriptors.add(listAzureNodePoolsMethodDescriptor);
    methodDescriptors.add(deleteAzureNodePoolMethodDescriptor);
    methodDescriptors.add(getAzureServerConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable() {
    return createAzureClientCallable;
  }

  @Override
  public OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable() {
    return createAzureClientOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable() {
    return getAzureClientCallable;
  }

  @Override
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable() {
    return listAzureClientsCallable;
  }

  @Override
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable() {
    return listAzureClientsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable() {
    return deleteAzureClientCallable;
  }

  @Override
  public OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable() {
    return deleteAzureClientOperationCallable;
  }

  @Override
  public UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable() {
    return createAzureClusterCallable;
  }

  @Override
  public OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable() {
    return createAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable() {
    return updateAzureClusterCallable;
  }

  @Override
  public OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable() {
    return updateAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable() {
    return getAzureClusterCallable;
  }

  @Override
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable() {
    return listAzureClustersCallable;
  }

  @Override
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable() {
    return listAzureClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable() {
    return deleteAzureClusterCallable;
  }

  @Override
  public OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable() {
    return deleteAzureClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable() {
    return generateAzureAccessTokenCallable;
  }

  @Override
  public UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable() {
    return createAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable() {
    return createAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable() {
    return updateAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable() {
    return updateAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable() {
    return getAzureNodePoolCallable;
  }

  @Override
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable() {
    return listAzureNodePoolsCallable;
  }

  @Override
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable() {
    return listAzureNodePoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable() {
    return deleteAzureNodePoolCallable;
  }

  @Override
  public OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable() {
    return deleteAzureNodePoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable() {
    return getAzureServerConfigCallable;
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
