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

package com.google.cloud.dataproc.v1.stub;

import static com.google.cloud.dataproc.v1.ClusterControllerClient.ListClustersPagedResponse;

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
import com.google.cloud.dataproc.v1.Cluster;
import com.google.cloud.dataproc.v1.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1.CreateClusterRequest;
import com.google.cloud.dataproc.v1.DeleteClusterRequest;
import com.google.cloud.dataproc.v1.DiagnoseClusterRequest;
import com.google.cloud.dataproc.v1.DiagnoseClusterResults;
import com.google.cloud.dataproc.v1.GetClusterRequest;
import com.google.cloud.dataproc.v1.ListClustersRequest;
import com.google.cloud.dataproc.v1.ListClustersResponse;
import com.google.cloud.dataproc.v1.StartClusterRequest;
import com.google.cloud.dataproc.v1.StopClusterRequest;
import com.google.cloud.dataproc.v1.UpdateClusterRequest;
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
 * REST stub implementation for the ClusterController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonClusterControllerStub extends ClusterControllerStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(ClusterOperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Cluster.getDescriptor())
          .add(DiagnoseClusterResults.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          ApiMethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/CreateCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "actionOnFailedPrimaryWorkers",
                                request.getActionOnFailedPrimaryWorkersValue());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          ApiMethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/UpdateCluster")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "gracefulDecommissionTimeout",
                                request.getGracefulDecommissionTimeout());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cluster", request.getCluster(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StopClusterRequest, Operation>
      stopClusterMethodDescriptor =
          ApiMethodDescriptor.<StopClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/StopCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StopClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:stop",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StopClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StopClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterName()
                                          .clearProjectId()
                                          .clearRegion()
                                          .build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StopClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<StartClusterRequest, Operation>
      startClusterMethodDescriptor =
          ApiMethodDescriptor.<StartClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/StartCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StartClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:start",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StartClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StartClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterName()
                                          .clearProjectId()
                                          .clearRegion()
                                          .build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (StartClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          ApiMethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/DeleteCluster")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "clusterUuid", request.getClusterUuid());
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
                  (DeleteClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      ApiMethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setFullMethodName("google.cloud.dataproc.v1.ClusterController/GetCluster")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetClusterRequest>newBuilder()
                  .setPath(
                      "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "clusterName", request.getClusterName());
                        serializer.putPathParam(fields, "projectId", request.getProjectId());
                        serializer.putPathParam(fields, "region", request.getRegion());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetClusterRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Cluster>newBuilder()
                  .setDefaultInstance(Cluster.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          ApiMethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/ListClusters")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListClustersRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListClustersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListClustersResponse>newBuilder()
                      .setDefaultInstance(ListClustersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DiagnoseClusterRequest, Operation>
      diagnoseClusterMethodDescriptor =
          ApiMethodDescriptor.<DiagnoseClusterRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataproc.v1.ClusterController/DiagnoseCluster")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DiagnoseClusterRequest>newBuilder()
                      .setPath(
                          "/v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:diagnose",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "clusterName", request.getClusterName());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DiagnoseClusterRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*",
                                      request
                                          .toBuilder()
                                          .clearClusterName()
                                          .clearProjectId()
                                          .clearRegion()
                                          .build(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DiagnoseClusterRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<StopClusterRequest, Operation> stopClusterCallable;
  private final OperationCallable<StopClusterRequest, Cluster, ClusterOperationMetadata>
      stopClusterOperationCallable;
  private final UnaryCallable<StartClusterRequest, Operation> startClusterCallable;
  private final OperationCallable<StartClusterRequest, Cluster, ClusterOperationMetadata>
      startClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable;
  private final OperationCallable<
          DiagnoseClusterRequest, DiagnoseClusterResults, ClusterOperationMetadata>
      diagnoseClusterOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonClusterControllerStub create(ClusterControllerStubSettings settings)
      throws IOException {
    return new HttpJsonClusterControllerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonClusterControllerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonClusterControllerStub(
        ClusterControllerStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonClusterControllerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonClusterControllerStub(
        ClusterControllerStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonClusterControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonClusterControllerStub(
      ClusterControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonClusterControllerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonClusterControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonClusterControllerStub(
      ClusterControllerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        HttpJsonCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        HttpJsonCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StopClusterRequest, Operation> stopClusterTransportSettings =
        HttpJsonCallSettings.<StopClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(stopClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<StartClusterRequest, Operation> startClusterTransportSettings =
        HttpJsonCallSettings.<StartClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(startClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        HttpJsonCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        HttpJsonCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        HttpJsonCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DiagnoseClusterRequest, Operation> diagnoseClusterTransportSettings =
        HttpJsonCallSettings.<DiagnoseClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(diagnoseClusterMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.stopClusterCallable =
        callableFactory.createUnaryCallable(
            stopClusterTransportSettings, settings.stopClusterSettings(), clientContext);
    this.stopClusterOperationCallable =
        callableFactory.createOperationCallable(
            stopClusterTransportSettings,
            settings.stopClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.startClusterCallable =
        callableFactory.createUnaryCallable(
            startClusterTransportSettings, settings.startClusterSettings(), clientContext);
    this.startClusterOperationCallable =
        callableFactory.createOperationCallable(
            startClusterTransportSettings,
            settings.startClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.diagnoseClusterCallable =
        callableFactory.createUnaryCallable(
            diagnoseClusterTransportSettings, settings.diagnoseClusterSettings(), clientContext);
    this.diagnoseClusterOperationCallable =
        callableFactory.createOperationCallable(
            diagnoseClusterTransportSettings,
            settings.diagnoseClusterOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createClusterMethodDescriptor);
    methodDescriptors.add(updateClusterMethodDescriptor);
    methodDescriptors.add(stopClusterMethodDescriptor);
    methodDescriptors.add(startClusterMethodDescriptor);
    methodDescriptors.add(deleteClusterMethodDescriptor);
    methodDescriptors.add(getClusterMethodDescriptor);
    methodDescriptors.add(listClustersMethodDescriptor);
    methodDescriptors.add(diagnoseClusterMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<StopClusterRequest, Operation> stopClusterCallable() {
    return stopClusterCallable;
  }

  @Override
  public OperationCallable<StopClusterRequest, Cluster, ClusterOperationMetadata>
      stopClusterOperationCallable() {
    return stopClusterOperationCallable;
  }

  @Override
  public UnaryCallable<StartClusterRequest, Operation> startClusterCallable() {
    return startClusterCallable;
  }

  @Override
  public OperationCallable<StartClusterRequest, Cluster, ClusterOperationMetadata>
      startClusterOperationCallable() {
    return startClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  @Override
  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  @Override
  public UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable() {
    return diagnoseClusterCallable;
  }

  @Override
  public OperationCallable<DiagnoseClusterRequest, DiagnoseClusterResults, ClusterOperationMetadata>
      diagnoseClusterOperationCallable() {
    return diagnoseClusterOperationCallable;
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
