/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dataproc.v1beta2.stub;

import static com.google.cloud.dataproc.v1beta2.ClusterControllerClient.ListClustersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1beta2.Cluster;
import com.google.cloud.dataproc.v1beta2.ClusterOperationMetadata;
import com.google.cloud.dataproc.v1beta2.CreateClusterRequest;
import com.google.cloud.dataproc.v1beta2.DeleteClusterRequest;
import com.google.cloud.dataproc.v1beta2.DiagnoseClusterRequest;
import com.google.cloud.dataproc.v1beta2.GetClusterRequest;
import com.google.cloud.dataproc.v1beta2.ListClustersRequest;
import com.google.cloud.dataproc.v1beta2.ListClustersResponse;
import com.google.cloud.dataproc.v1beta2.UpdateClusterRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ClusterController service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcClusterControllerStub extends ClusterControllerStub {
  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DiagnoseClusterRequest, Operation>
      diagnoseClusterMethodDescriptor =
          MethodDescriptor.<DiagnoseClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dataproc.v1beta2.ClusterController/DiagnoseCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DiagnoseClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable;
  private final OperationCallable<DiagnoseClusterRequest, Empty, ClusterOperationMetadata>
      diagnoseClusterOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcClusterControllerStub create(ClusterControllerStubSettings settings)
      throws IOException {
    return new GrpcClusterControllerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcClusterControllerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcClusterControllerStub(
        ClusterControllerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcClusterControllerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcClusterControllerStub(
        ClusterControllerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcClusterControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcClusterControllerStub(
      ClusterControllerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcClusterControllerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcClusterControllerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcClusterControllerStub(
      ClusterControllerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateClusterRequest>() {
                  @Override
                  public Map<String, String> extract(CreateClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateClusterRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_name", String.valueOf(request.getClusterName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteClusterRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_name", String.valueOf(request.getClusterName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetClusterRequest>() {
                  @Override
                  public Map<String, String> extract(GetClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_name", String.valueOf(request.getClusterName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListClustersRequest>() {
                  @Override
                  public Map<String, String> extract(ListClustersRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DiagnoseClusterRequest, Operation> diagnoseClusterTransportSettings =
        GrpcCallSettings.<DiagnoseClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(diagnoseClusterMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DiagnoseClusterRequest>() {
                  @Override
                  public Map<String, String> extract(DiagnoseClusterRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("cluster_name", String.valueOf(request.getClusterName()));
                    params.put("project_id", String.valueOf(request.getProjectId()));
                    params.put("region", String.valueOf(request.getRegion()));
                    return params.build();
                  }
                })
            .build();

    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.updateClusterCallable =
        callableFactory.createUnaryCallable(
            updateClusterTransportSettings, settings.updateClusterSettings(), clientContext);
    this.updateClusterOperationCallable =
        callableFactory.createOperationCallable(
            updateClusterTransportSettings,
            settings.updateClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteClusterCallable =
        callableFactory.createUnaryCallable(
            deleteClusterTransportSettings, settings.deleteClusterSettings(), clientContext);
    this.deleteClusterOperationCallable =
        callableFactory.createOperationCallable(
            deleteClusterTransportSettings,
            settings.deleteClusterOperationSettings(),
            clientContext,
            operationsStub);
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
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  public OperationCallable<CreateClusterRequest, Cluster, ClusterOperationMetadata>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  public OperationCallable<UpdateClusterRequest, Cluster, ClusterOperationMetadata>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  public OperationCallable<DeleteClusterRequest, Empty, ClusterOperationMetadata>
      deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  public UnaryCallable<ListClustersRequest, ListClustersPagedResponse> listClustersPagedCallable() {
    return listClustersPagedCallable;
  }

  public UnaryCallable<DiagnoseClusterRequest, Operation> diagnoseClusterCallable() {
    return diagnoseClusterCallable;
  }

  public OperationCallable<DiagnoseClusterRequest, Empty, ClusterOperationMetadata>
      diagnoseClusterOperationCallable() {
    return diagnoseClusterOperationCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
