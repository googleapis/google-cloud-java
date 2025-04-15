/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.ConnectCluster;
import com.google.cloud.managedkafka.v1.Connector;
import com.google.cloud.managedkafka.v1.CreateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.CreateConnectorRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectorRequest;
import com.google.cloud.managedkafka.v1.GetConnectClusterRequest;
import com.google.cloud.managedkafka.v1.GetConnectorRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersResponse;
import com.google.cloud.managedkafka.v1.ListConnectorsRequest;
import com.google.cloud.managedkafka.v1.ListConnectorsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.PauseConnectorRequest;
import com.google.cloud.managedkafka.v1.PauseConnectorResponse;
import com.google.cloud.managedkafka.v1.RestartConnectorRequest;
import com.google.cloud.managedkafka.v1.RestartConnectorResponse;
import com.google.cloud.managedkafka.v1.ResumeConnectorRequest;
import com.google.cloud.managedkafka.v1.ResumeConnectorResponse;
import com.google.cloud.managedkafka.v1.StopConnectorRequest;
import com.google.cloud.managedkafka.v1.StopConnectorResponse;
import com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConnectorRequest;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the ManagedKafkaConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonManagedKafkaConnectStub extends ManagedKafkaConnectStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(ConnectCluster.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersMethodDescriptor =
          ApiMethodDescriptor.<ListConnectClustersRequest, ListConnectClustersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/ListConnectClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectClustersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connectClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectClustersResponse>newBuilder()
                      .setDefaultInstance(ListConnectClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectClusterRequest, ConnectCluster>
      getConnectClusterMethodDescriptor =
          ApiMethodDescriptor.<GetConnectClusterRequest, ConnectCluster>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/GetConnectCluster")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConnectCluster>newBuilder()
                      .setDefaultInstance(ConnectCluster.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectClusterRequest, Operation>
      createConnectClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/CreateConnectCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/connectClusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectClusterId", request.getConnectClusterId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connectCluster", request.getConnectCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateConnectClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConnectClusterRequest, Operation>
      updateConnectClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/UpdateConnectCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{connectCluster.name=projects/*/locations/*/connectClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "connectCluster.name",
                                request.getConnectCluster().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connectCluster", request.getConnectCluster(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateConnectClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteConnectClusterRequest, Operation>
      deleteConnectClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectClusterRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/DeleteConnectCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectClusterRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                  (DeleteConnectClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListConnectorsRequest, ListConnectorsResponse>
      listConnectorsMethodDescriptor =
          ApiMethodDescriptor.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/ListConnectors")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConnectorsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/connectClusters/*}/connectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConnectorsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConnectorsResponse>newBuilder()
                      .setDefaultInstance(ListConnectorsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConnectorRequest, Connector>
      getConnectorMethodDescriptor =
          ApiMethodDescriptor.<GetConnectorRequest, Connector>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/GetConnector")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connector>newBuilder()
                      .setDefaultInstance(Connector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateConnectorRequest, Connector>
      createConnectorMethodDescriptor =
          ApiMethodDescriptor.<CreateConnectorRequest, Connector>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/CreateConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/connectClusters/*}/connectors",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "connectorId", request.getConnectorId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connector", request.getConnector(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connector>newBuilder()
                      .setDefaultInstance(Connector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateConnectorRequest, Connector>
      updateConnectorMethodDescriptor =
          ApiMethodDescriptor.<UpdateConnectorRequest, Connector>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/UpdateConnector")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{connector.name=projects/*/locations/*/connectClusters/*/connectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "connector.name", request.getConnector().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("connector", request.getConnector(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Connector>newBuilder()
                      .setDefaultInstance(Connector.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConnectorRequest, Empty>
      deleteConnectorMethodDescriptor =
          ApiMethodDescriptor.<DeleteConnectorRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/DeleteConnector")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<PauseConnectorRequest, PauseConnectorResponse>
      pauseConnectorMethodDescriptor =
          ApiMethodDescriptor.<PauseConnectorRequest, PauseConnectorResponse>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/PauseConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PauseConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}:pause",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PauseConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PauseConnectorRequest> serializer =
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
                  ProtoMessageResponseParser.<PauseConnectorResponse>newBuilder()
                      .setDefaultInstance(PauseConnectorResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorMethodDescriptor =
          ApiMethodDescriptor.<ResumeConnectorRequest, ResumeConnectorResponse>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/ResumeConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResumeConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}:resume",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ResumeConnectorRequest> serializer =
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
                  ProtoMessageResponseParser.<ResumeConnectorResponse>newBuilder()
                      .setDefaultInstance(ResumeConnectorResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorMethodDescriptor =
          ApiMethodDescriptor.<RestartConnectorRequest, RestartConnectorResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.managedkafka.v1.ManagedKafkaConnect/RestartConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestartConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}:restart",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestartConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestartConnectorRequest> serializer =
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
                  ProtoMessageResponseParser.<RestartConnectorResponse>newBuilder()
                      .setDefaultInstance(RestartConnectorResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StopConnectorRequest, StopConnectorResponse>
      stopConnectorMethodDescriptor =
          ApiMethodDescriptor.<StopConnectorRequest, StopConnectorResponse>newBuilder()
              .setFullMethodName("google.cloud.managedkafka.v1.ManagedKafkaConnect/StopConnector")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopConnectorRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/connectClusters/*/connectors/*}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopConnectorRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopConnectorRequest> serializer =
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
                  ProtoMessageResponseParser.<StopConnectorResponse>newBuilder()
                      .setDefaultInstance(StopConnectorResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable;
  private final UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable;
  private final UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable;
  private final UnaryCallable<CreateConnectClusterRequest, Operation> createConnectClusterCallable;
  private final OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable;
  private final UnaryCallable<UpdateConnectClusterRequest, Operation> updateConnectClusterCallable;
  private final OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable;
  private final UnaryCallable<DeleteConnectClusterRequest, Operation> deleteConnectClusterCallable;
  private final OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable;
  private final UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable;
  private final UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable;
  private final UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable;
  private final UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable;
  private final UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable;
  private final UnaryCallable<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorCallable;
  private final UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorCallable;
  private final UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable;
  private final UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonManagedKafkaConnectStub create(
      ManagedKafkaConnectStubSettings settings) throws IOException {
    return new HttpJsonManagedKafkaConnectStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonManagedKafkaConnectStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonManagedKafkaConnectStub(
        ManagedKafkaConnectStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonManagedKafkaConnectStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonManagedKafkaConnectStub(
        ManagedKafkaConnectStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonManagedKafkaConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonManagedKafkaConnectStub(
      ManagedKafkaConnectStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonManagedKafkaConnectCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonManagedKafkaConnectStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonManagedKafkaConnectStub(
      ManagedKafkaConnectStubSettings settings,
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
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListConnectClustersRequest, ListConnectClustersResponse>
        listConnectClustersTransportSettings =
            HttpJsonCallSettings
                .<ListConnectClustersRequest, ListConnectClustersResponse>newBuilder()
                .setMethodDescriptor(listConnectClustersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConnectClusterRequest, ConnectCluster>
        getConnectClusterTransportSettings =
            HttpJsonCallSettings.<GetConnectClusterRequest, ConnectCluster>newBuilder()
                .setMethodDescriptor(getConnectClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateConnectClusterRequest, Operation>
        createConnectClusterTransportSettings =
            HttpJsonCallSettings.<CreateConnectClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(createConnectClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateConnectClusterRequest, Operation>
        updateConnectClusterTransportSettings =
            HttpJsonCallSettings.<UpdateConnectClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConnectClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "connect_cluster.name",
                          String.valueOf(request.getConnectCluster().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConnectClusterRequest, Operation>
        deleteConnectClusterTransportSettings =
            HttpJsonCallSettings.<DeleteConnectClusterRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConnectClusterMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListConnectorsRequest, ListConnectorsResponse>
        listConnectorsTransportSettings =
            HttpJsonCallSettings.<ListConnectorsRequest, ListConnectorsResponse>newBuilder()
                .setMethodDescriptor(listConnectorsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConnectorRequest, Connector> getConnectorTransportSettings =
        HttpJsonCallSettings.<GetConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(getConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateConnectorRequest, Connector> createConnectorTransportSettings =
        HttpJsonCallSettings.<CreateConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(createConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateConnectorRequest, Connector> updateConnectorTransportSettings =
        HttpJsonCallSettings.<UpdateConnectorRequest, Connector>newBuilder()
            .setMethodDescriptor(updateConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connector.name", String.valueOf(request.getConnector().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteConnectorRequest, Empty> deleteConnectorTransportSettings =
        HttpJsonCallSettings.<DeleteConnectorRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConnectorMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PauseConnectorRequest, PauseConnectorResponse>
        pauseConnectorTransportSettings =
            HttpJsonCallSettings.<PauseConnectorRequest, PauseConnectorResponse>newBuilder()
                .setMethodDescriptor(pauseConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ResumeConnectorRequest, ResumeConnectorResponse>
        resumeConnectorTransportSettings =
            HttpJsonCallSettings.<ResumeConnectorRequest, ResumeConnectorResponse>newBuilder()
                .setMethodDescriptor(resumeConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RestartConnectorRequest, RestartConnectorResponse>
        restartConnectorTransportSettings =
            HttpJsonCallSettings.<RestartConnectorRequest, RestartConnectorResponse>newBuilder()
                .setMethodDescriptor(restartConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StopConnectorRequest, StopConnectorResponse>
        stopConnectorTransportSettings =
            HttpJsonCallSettings.<StopConnectorRequest, StopConnectorResponse>newBuilder()
                .setMethodDescriptor(stopConnectorMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listConnectClustersCallable =
        callableFactory.createUnaryCallable(
            listConnectClustersTransportSettings,
            settings.listConnectClustersSettings(),
            clientContext);
    this.listConnectClustersPagedCallable =
        callableFactory.createPagedCallable(
            listConnectClustersTransportSettings,
            settings.listConnectClustersSettings(),
            clientContext);
    this.getConnectClusterCallable =
        callableFactory.createUnaryCallable(
            getConnectClusterTransportSettings,
            settings.getConnectClusterSettings(),
            clientContext);
    this.createConnectClusterCallable =
        callableFactory.createUnaryCallable(
            createConnectClusterTransportSettings,
            settings.createConnectClusterSettings(),
            clientContext);
    this.createConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            createConnectClusterTransportSettings,
            settings.createConnectClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateConnectClusterCallable =
        callableFactory.createUnaryCallable(
            updateConnectClusterTransportSettings,
            settings.updateConnectClusterSettings(),
            clientContext);
    this.updateConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectClusterTransportSettings,
            settings.updateConnectClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteConnectClusterCallable =
        callableFactory.createUnaryCallable(
            deleteConnectClusterTransportSettings,
            settings.deleteConnectClusterSettings(),
            clientContext);
    this.deleteConnectClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectClusterTransportSettings,
            settings.deleteConnectClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listConnectorsCallable =
        callableFactory.createUnaryCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.listConnectorsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectorsTransportSettings, settings.listConnectorsSettings(), clientContext);
    this.getConnectorCallable =
        callableFactory.createUnaryCallable(
            getConnectorTransportSettings, settings.getConnectorSettings(), clientContext);
    this.createConnectorCallable =
        callableFactory.createUnaryCallable(
            createConnectorTransportSettings, settings.createConnectorSettings(), clientContext);
    this.updateConnectorCallable =
        callableFactory.createUnaryCallable(
            updateConnectorTransportSettings, settings.updateConnectorSettings(), clientContext);
    this.deleteConnectorCallable =
        callableFactory.createUnaryCallable(
            deleteConnectorTransportSettings, settings.deleteConnectorSettings(), clientContext);
    this.pauseConnectorCallable =
        callableFactory.createUnaryCallable(
            pauseConnectorTransportSettings, settings.pauseConnectorSettings(), clientContext);
    this.resumeConnectorCallable =
        callableFactory.createUnaryCallable(
            resumeConnectorTransportSettings, settings.resumeConnectorSettings(), clientContext);
    this.restartConnectorCallable =
        callableFactory.createUnaryCallable(
            restartConnectorTransportSettings, settings.restartConnectorSettings(), clientContext);
    this.stopConnectorCallable =
        callableFactory.createUnaryCallable(
            stopConnectorTransportSettings, settings.stopConnectorSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listConnectClustersMethodDescriptor);
    methodDescriptors.add(getConnectClusterMethodDescriptor);
    methodDescriptors.add(createConnectClusterMethodDescriptor);
    methodDescriptors.add(updateConnectClusterMethodDescriptor);
    methodDescriptors.add(deleteConnectClusterMethodDescriptor);
    methodDescriptors.add(listConnectorsMethodDescriptor);
    methodDescriptors.add(getConnectorMethodDescriptor);
    methodDescriptors.add(createConnectorMethodDescriptor);
    methodDescriptors.add(updateConnectorMethodDescriptor);
    methodDescriptors.add(deleteConnectorMethodDescriptor);
    methodDescriptors.add(pauseConnectorMethodDescriptor);
    methodDescriptors.add(resumeConnectorMethodDescriptor);
    methodDescriptors.add(restartConnectorMethodDescriptor);
    methodDescriptors.add(stopConnectorMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable() {
    return listConnectClustersCallable;
  }

  @Override
  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable() {
    return listConnectClustersPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable() {
    return getConnectClusterCallable;
  }

  @Override
  public UnaryCallable<CreateConnectClusterRequest, Operation> createConnectClusterCallable() {
    return createConnectClusterCallable;
  }

  @Override
  public OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable() {
    return createConnectClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectClusterRequest, Operation> updateConnectClusterCallable() {
    return updateConnectClusterCallable;
  }

  @Override
  public OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable() {
    return updateConnectClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectClusterRequest, Operation> deleteConnectClusterCallable() {
    return deleteConnectClusterCallable;
  }

  @Override
  public OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable() {
    return deleteConnectClusterOperationCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable() {
    return listConnectorsCallable;
  }

  @Override
  public UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    return listConnectorsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    return getConnectorCallable;
  }

  @Override
  public UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable() {
    return createConnectorCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable() {
    return updateConnectorCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable() {
    return deleteConnectorCallable;
  }

  @Override
  public UnaryCallable<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorCallable() {
    return pauseConnectorCallable;
  }

  @Override
  public UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse> resumeConnectorCallable() {
    return resumeConnectorCallable;
  }

  @Override
  public UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable() {
    return restartConnectorCallable;
  }

  @Override
  public UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable() {
    return stopConnectorCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
