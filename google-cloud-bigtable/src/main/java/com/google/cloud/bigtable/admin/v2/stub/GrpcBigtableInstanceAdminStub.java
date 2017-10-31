/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.cloud.bigtable.admin.v2.BigtableInstanceAdminSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Bigtable Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcBigtableInstanceAdminStub extends BigtableInstanceAdminStub {
  private static final UnaryCallable<CreateInstanceRequest, Operation>
      directCreateInstanceCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.admin.v2.BigtableInstanceAdmin/CreateInstance",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CreateInstanceRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance())));
  private static final UnaryCallable<GetInstanceRequest, Instance> directGetInstanceCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/GetInstance",
              io.grpc.protobuf.ProtoUtils.marshaller(GetInstanceRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Instance.getDefaultInstance())));
  private static final UnaryCallable<ListInstancesRequest, ListInstancesResponse>
      directListInstancesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.admin.v2.BigtableInstanceAdmin/ListInstances",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListInstancesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListInstancesResponse.getDefaultInstance())));
  private static final UnaryCallable<Instance, Instance> directUpdateInstanceCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/UpdateInstance",
              io.grpc.protobuf.ProtoUtils.marshaller(Instance.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Instance.getDefaultInstance())));
  private static final UnaryCallable<DeleteInstanceRequest, Empty> directDeleteInstanceCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/DeleteInstance",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteInstanceRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<CreateClusterRequest, Operation> directCreateClusterCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/CreateCluster",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance())));
  private static final UnaryCallable<GetClusterRequest, Cluster> directGetClusterCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/GetCluster",
              io.grpc.protobuf.ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Cluster.getDefaultInstance())));
  private static final UnaryCallable<ListClustersRequest, ListClustersResponse>
      directListClustersCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.admin.v2.BigtableInstanceAdmin/ListClusters",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListClustersResponse.getDefaultInstance())));
  private static final UnaryCallable<Cluster, Operation> directUpdateClusterCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/UpdateCluster",
              io.grpc.protobuf.ProtoUtils.marshaller(Cluster.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Operation.getDefaultInstance())));
  private static final UnaryCallable<DeleteClusterRequest, Empty> directDeleteClusterCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.admin.v2.BigtableInstanceAdmin/DeleteCluster",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;

  private final UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable;
  private final OperationCallable<
          CreateInstanceRequest, Instance, CreateInstanceMetadata, Operation>
      createInstanceOperationCallable;
  private final UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable;
  private final UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable;
  private final UnaryCallable<Instance, Instance> updateInstanceCallable;
  private final UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata, Operation>
      createClusterOperationCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<Cluster, Operation> updateClusterCallable;
  private final OperationCallable<Cluster, Cluster, UpdateClusterMetadata, Operation>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable;

  public static final GrpcBigtableInstanceAdminStub create(BigtableInstanceAdminSettings settings)
      throws IOException {
    return new GrpcBigtableInstanceAdminStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableInstanceAdminStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigtableInstanceAdminStub(
        BigtableInstanceAdminSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcBigtableInstanceAdminStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcBigtableInstanceAdminStub(
      BigtableInstanceAdminSettings settings, ClientContext clientContext) throws IOException {
    this.operationsStub = GrpcOperationsStub.create(clientContext);

    this.createInstanceCallable =
        GrpcCallableFactory.create(
            directCreateInstanceCallable,
            settings.createInstanceSettings().getInitialCallSettings(),
            clientContext);
    this.createInstanceOperationCallable =
        GrpcCallableFactory.create(
            directCreateInstanceCallable,
            settings.createInstanceSettings(),
            clientContext,
            this.operationsStub);
    this.getInstanceCallable =
        GrpcCallableFactory.create(
            directGetInstanceCallable, settings.getInstanceSettings(), clientContext);
    this.listInstancesCallable =
        GrpcCallableFactory.create(
            directListInstancesCallable, settings.listInstancesSettings(), clientContext);
    this.updateInstanceCallable =
        GrpcCallableFactory.create(
            directUpdateInstanceCallable, settings.updateInstanceSettings(), clientContext);
    this.deleteInstanceCallable =
        GrpcCallableFactory.create(
            directDeleteInstanceCallable, settings.deleteInstanceSettings(), clientContext);
    this.createClusterCallable =
        GrpcCallableFactory.create(
            directCreateClusterCallable,
            settings.createClusterSettings().getInitialCallSettings(),
            clientContext);
    this.createClusterOperationCallable =
        GrpcCallableFactory.create(
            directCreateClusterCallable,
            settings.createClusterSettings(),
            clientContext,
            this.operationsStub);
    this.getClusterCallable =
        GrpcCallableFactory.create(
            directGetClusterCallable, settings.getClusterSettings(), clientContext);
    this.listClustersCallable =
        GrpcCallableFactory.create(
            directListClustersCallable, settings.listClustersSettings(), clientContext);
    this.updateClusterCallable =
        GrpcCallableFactory.create(
            directUpdateClusterCallable,
            settings.updateClusterSettings().getInitialCallSettings(),
            clientContext);
    this.updateClusterOperationCallable =
        GrpcCallableFactory.create(
            directUpdateClusterCallable,
            settings.updateClusterSettings(),
            clientContext,
            this.operationsStub);
    this.deleteClusterCallable =
        GrpcCallableFactory.create(
            directDeleteClusterCallable, settings.deleteClusterSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata, Operation>
      createInstanceOperationCallable() {
    return createInstanceOperationCallable;
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    return createInstanceCallable;
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    return getInstanceCallable;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    return listInstancesCallable;
  }

  public UnaryCallable<Instance, Instance> updateInstanceCallable() {
    return updateInstanceCallable;
  }

  public UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    return deleteInstanceCallable;
  }

  public OperationCallable<CreateClusterRequest, Cluster, CreateClusterMetadata, Operation>
      createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  public UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable() {
    return listClustersCallable;
  }

  public OperationCallable<Cluster, Cluster, UpdateClusterMetadata, Operation>
      updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  public UnaryCallable<Cluster, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  public UnaryCallable<DeleteClusterRequest, Empty> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public final void close() throws Exception {
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
