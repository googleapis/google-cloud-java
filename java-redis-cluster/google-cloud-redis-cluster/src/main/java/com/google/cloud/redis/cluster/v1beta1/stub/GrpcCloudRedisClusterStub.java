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

package com.google.cloud.redis.cluster.v1beta1.stub;

import static com.google.cloud.redis.cluster.v1beta1.CloudRedisClusterClient.ListBackupCollectionsPagedResponse;
import static com.google.cloud.redis.cluster.v1beta1.CloudRedisClusterClient.ListBackupsPagedResponse;
import static com.google.cloud.redis.cluster.v1beta1.CloudRedisClusterClient.ListClustersPagedResponse;
import static com.google.cloud.redis.cluster.v1beta1.CloudRedisClusterClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.redis.cluster.v1beta1.Backup;
import com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest;
import com.google.cloud.redis.cluster.v1beta1.BackupCollection;
import com.google.cloud.redis.cluster.v1beta1.CertificateAuthority;
import com.google.cloud.redis.cluster.v1beta1.Cluster;
import com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest;
import com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest;
import com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest;
import com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest;
import com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest;
import com.google.cloud.redis.cluster.v1beta1.GetBackupRequest;
import com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest;
import com.google.cloud.redis.cluster.v1beta1.GetClusterRequest;
import com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest;
import com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse;
import com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest;
import com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse;
import com.google.cloud.redis.cluster.v1beta1.ListClustersRequest;
import com.google.cloud.redis.cluster.v1beta1.ListClustersResponse;
import com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest;
import com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CloudRedisCluster service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCloudRedisClusterStub extends CloudRedisClusterStub {
  private static final MethodDescriptor<ListClustersRequest, ListClustersResponse>
      listClustersMethodDescriptor =
          MethodDescriptor.<ListClustersRequest, ListClustersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/ListClusters")
              .setRequestMarshaller(ProtoUtils.marshaller(ListClustersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListClustersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterRequest, Cluster> getClusterMethodDescriptor =
      MethodDescriptor.<GetClusterRequest, Cluster>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.redis.cluster.v1beta1.CloudRedisCluster/GetCluster")
          .setRequestMarshaller(ProtoUtils.marshaller(GetClusterRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Cluster.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateClusterRequest, Operation>
      updateClusterMethodDescriptor =
          MethodDescriptor.<UpdateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/UpdateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteClusterRequest, Operation>
      deleteClusterMethodDescriptor =
          MethodDescriptor.<DeleteClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/DeleteCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateClusterRequest, Operation>
      createClusterMethodDescriptor =
          MethodDescriptor.<CreateClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/CreateCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetClusterCertificateAuthorityRequest, CertificateAuthority>
      getClusterCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<GetClusterCertificateAuthorityRequest, CertificateAuthority>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/GetClusterCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetClusterCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateAuthority.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RescheduleClusterMaintenanceRequest, Operation>
      rescheduleClusterMaintenanceMethodDescriptor =
          MethodDescriptor.<RescheduleClusterMaintenanceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/RescheduleClusterMaintenance")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RescheduleClusterMaintenanceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsMethodDescriptor =
          MethodDescriptor.<ListBackupCollectionsRequest, ListBackupCollectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/ListBackupCollections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListBackupCollectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupCollectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionMethodDescriptor =
          MethodDescriptor.<GetBackupCollectionRequest, BackupCollection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/GetBackupCollection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetBackupCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(BackupCollection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListBackupsRequest, ListBackupsResponse>
      listBackupsMethodDescriptor =
          MethodDescriptor.<ListBackupsRequest, ListBackupsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.redis.cluster.v1beta1.CloudRedisCluster/ListBackups")
              .setRequestMarshaller(ProtoUtils.marshaller(ListBackupsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListBackupsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetBackupRequest, Backup> getBackupMethodDescriptor =
      MethodDescriptor.<GetBackupRequest, Backup>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.redis.cluster.v1beta1.CloudRedisCluster/GetBackup")
          .setRequestMarshaller(ProtoUtils.marshaller(GetBackupRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Backup.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteBackupRequest, Operation>
      deleteBackupMethodDescriptor =
          MethodDescriptor.<DeleteBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/DeleteBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportBackupRequest, Operation>
      exportBackupMethodDescriptor =
          MethodDescriptor.<ExportBackupRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/ExportBackup")
              .setRequestMarshaller(ProtoUtils.marshaller(ExportBackupRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BackupClusterRequest, Operation>
      backupClusterMethodDescriptor =
          MethodDescriptor.<BackupClusterRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.redis.cluster.v1beta1.CloudRedisCluster/BackupCluster")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BackupClusterRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListClustersRequest, ListClustersResponse> listClustersCallable;
  private final UnaryCallable<ListClustersRequest, ListClustersPagedResponse>
      listClustersPagedCallable;
  private final UnaryCallable<GetClusterRequest, Cluster> getClusterCallable;
  private final UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable;
  private final OperationCallable<UpdateClusterRequest, Cluster, Any>
      updateClusterOperationCallable;
  private final UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable;
  private final OperationCallable<DeleteClusterRequest, Empty, Any> deleteClusterOperationCallable;
  private final UnaryCallable<CreateClusterRequest, Operation> createClusterCallable;
  private final OperationCallable<CreateClusterRequest, Cluster, Any>
      createClusterOperationCallable;
  private final UnaryCallable<GetClusterCertificateAuthorityRequest, CertificateAuthority>
      getClusterCertificateAuthorityCallable;
  private final UnaryCallable<RescheduleClusterMaintenanceRequest, Operation>
      rescheduleClusterMaintenanceCallable;
  private final OperationCallable<RescheduleClusterMaintenanceRequest, Cluster, Any>
      rescheduleClusterMaintenanceOperationCallable;
  private final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable;
  private final UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable;
  private final UnaryCallable<GetBackupCollectionRequest, BackupCollection>
      getBackupCollectionCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable;
  private final UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse>
      listBackupsPagedCallable;
  private final UnaryCallable<GetBackupRequest, Backup> getBackupCallable;
  private final UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable;
  private final OperationCallable<DeleteBackupRequest, Empty, Any> deleteBackupOperationCallable;
  private final UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable;
  private final OperationCallable<ExportBackupRequest, Backup, Any> exportBackupOperationCallable;
  private final UnaryCallable<BackupClusterRequest, Operation> backupClusterCallable;
  private final OperationCallable<BackupClusterRequest, Cluster, Any>
      backupClusterOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudRedisClusterStub create(CloudRedisClusterStubSettings settings)
      throws IOException {
    return new GrpcCloudRedisClusterStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudRedisClusterStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudRedisClusterStub(
        CloudRedisClusterStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudRedisClusterStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudRedisClusterStub(
        CloudRedisClusterStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudRedisClusterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudRedisClusterStub(
      CloudRedisClusterStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudRedisClusterCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudRedisClusterStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudRedisClusterStub(
      CloudRedisClusterStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListClustersRequest, ListClustersResponse> listClustersTransportSettings =
        GrpcCallSettings.<ListClustersRequest, ListClustersResponse>newBuilder()
            .setMethodDescriptor(listClustersMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetClusterRequest, Cluster> getClusterTransportSettings =
        GrpcCallSettings.<GetClusterRequest, Cluster>newBuilder()
            .setMethodDescriptor(getClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateClusterRequest, Operation> updateClusterTransportSettings =
        GrpcCallSettings.<UpdateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(updateClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cluster.name", String.valueOf(request.getCluster().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteClusterRequest, Operation> deleteClusterTransportSettings =
        GrpcCallSettings.<DeleteClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateClusterRequest, Operation> createClusterTransportSettings =
        GrpcCallSettings.<CreateClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(createClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetClusterCertificateAuthorityRequest, CertificateAuthority>
        getClusterCertificateAuthorityTransportSettings =
            GrpcCallSettings
                .<GetClusterCertificateAuthorityRequest, CertificateAuthority>newBuilder()
                .setMethodDescriptor(getClusterCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<RescheduleClusterMaintenanceRequest, Operation>
        rescheduleClusterMaintenanceTransportSettings =
            GrpcCallSettings.<RescheduleClusterMaintenanceRequest, Operation>newBuilder()
                .setMethodDescriptor(rescheduleClusterMaintenanceMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
        listBackupCollectionsTransportSettings =
            GrpcCallSettings
                .<ListBackupCollectionsRequest, ListBackupCollectionsResponse>newBuilder()
                .setMethodDescriptor(listBackupCollectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetBackupCollectionRequest, BackupCollection>
        getBackupCollectionTransportSettings =
            GrpcCallSettings.<GetBackupCollectionRequest, BackupCollection>newBuilder()
                .setMethodDescriptor(getBackupCollectionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListBackupsRequest, ListBackupsResponse> listBackupsTransportSettings =
        GrpcCallSettings.<ListBackupsRequest, ListBackupsResponse>newBuilder()
            .setMethodDescriptor(listBackupsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetBackupRequest, Backup> getBackupTransportSettings =
        GrpcCallSettings.<GetBackupRequest, Backup>newBuilder()
            .setMethodDescriptor(getBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteBackupRequest, Operation> deleteBackupTransportSettings =
        GrpcCallSettings.<DeleteBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportBackupRequest, Operation> exportBackupTransportSettings =
        GrpcCallSettings.<ExportBackupRequest, Operation>newBuilder()
            .setMethodDescriptor(exportBackupMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BackupClusterRequest, Operation> backupClusterTransportSettings =
        GrpcCallSettings.<BackupClusterRequest, Operation>newBuilder()
            .setMethodDescriptor(backupClusterMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listClustersCallable =
        callableFactory.createUnaryCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.listClustersPagedCallable =
        callableFactory.createPagedCallable(
            listClustersTransportSettings, settings.listClustersSettings(), clientContext);
    this.getClusterCallable =
        callableFactory.createUnaryCallable(
            getClusterTransportSettings, settings.getClusterSettings(), clientContext);
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
    this.createClusterCallable =
        callableFactory.createUnaryCallable(
            createClusterTransportSettings, settings.createClusterSettings(), clientContext);
    this.createClusterOperationCallable =
        callableFactory.createOperationCallable(
            createClusterTransportSettings,
            settings.createClusterOperationSettings(),
            clientContext,
            operationsStub);
    this.getClusterCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            getClusterCertificateAuthorityTransportSettings,
            settings.getClusterCertificateAuthoritySettings(),
            clientContext);
    this.rescheduleClusterMaintenanceCallable =
        callableFactory.createUnaryCallable(
            rescheduleClusterMaintenanceTransportSettings,
            settings.rescheduleClusterMaintenanceSettings(),
            clientContext);
    this.rescheduleClusterMaintenanceOperationCallable =
        callableFactory.createOperationCallable(
            rescheduleClusterMaintenanceTransportSettings,
            settings.rescheduleClusterMaintenanceOperationSettings(),
            clientContext,
            operationsStub);
    this.listBackupCollectionsCallable =
        callableFactory.createUnaryCallable(
            listBackupCollectionsTransportSettings,
            settings.listBackupCollectionsSettings(),
            clientContext);
    this.listBackupCollectionsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupCollectionsTransportSettings,
            settings.listBackupCollectionsSettings(),
            clientContext);
    this.getBackupCollectionCallable =
        callableFactory.createUnaryCallable(
            getBackupCollectionTransportSettings,
            settings.getBackupCollectionSettings(),
            clientContext);
    this.listBackupsCallable =
        callableFactory.createUnaryCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.listBackupsPagedCallable =
        callableFactory.createPagedCallable(
            listBackupsTransportSettings, settings.listBackupsSettings(), clientContext);
    this.getBackupCallable =
        callableFactory.createUnaryCallable(
            getBackupTransportSettings, settings.getBackupSettings(), clientContext);
    this.deleteBackupCallable =
        callableFactory.createUnaryCallable(
            deleteBackupTransportSettings, settings.deleteBackupSettings(), clientContext);
    this.deleteBackupOperationCallable =
        callableFactory.createOperationCallable(
            deleteBackupTransportSettings,
            settings.deleteBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.exportBackupCallable =
        callableFactory.createUnaryCallable(
            exportBackupTransportSettings, settings.exportBackupSettings(), clientContext);
    this.exportBackupOperationCallable =
        callableFactory.createOperationCallable(
            exportBackupTransportSettings,
            settings.exportBackupOperationSettings(),
            clientContext,
            operationsStub);
    this.backupClusterCallable =
        callableFactory.createUnaryCallable(
            backupClusterTransportSettings, settings.backupClusterSettings(), clientContext);
    this.backupClusterOperationCallable =
        callableFactory.createOperationCallable(
            backupClusterTransportSettings,
            settings.backupClusterOperationSettings(),
            clientContext,
            operationsStub);
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<GetClusterRequest, Cluster> getClusterCallable() {
    return getClusterCallable;
  }

  @Override
  public UnaryCallable<UpdateClusterRequest, Operation> updateClusterCallable() {
    return updateClusterCallable;
  }

  @Override
  public OperationCallable<UpdateClusterRequest, Cluster, Any> updateClusterOperationCallable() {
    return updateClusterOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteClusterRequest, Operation> deleteClusterCallable() {
    return deleteClusterCallable;
  }

  @Override
  public OperationCallable<DeleteClusterRequest, Empty, Any> deleteClusterOperationCallable() {
    return deleteClusterOperationCallable;
  }

  @Override
  public UnaryCallable<CreateClusterRequest, Operation> createClusterCallable() {
    return createClusterCallable;
  }

  @Override
  public OperationCallable<CreateClusterRequest, Cluster, Any> createClusterOperationCallable() {
    return createClusterOperationCallable;
  }

  @Override
  public UnaryCallable<GetClusterCertificateAuthorityRequest, CertificateAuthority>
      getClusterCertificateAuthorityCallable() {
    return getClusterCertificateAuthorityCallable;
  }

  @Override
  public UnaryCallable<RescheduleClusterMaintenanceRequest, Operation>
      rescheduleClusterMaintenanceCallable() {
    return rescheduleClusterMaintenanceCallable;
  }

  @Override
  public OperationCallable<RescheduleClusterMaintenanceRequest, Cluster, Any>
      rescheduleClusterMaintenanceOperationCallable() {
    return rescheduleClusterMaintenanceOperationCallable;
  }

  @Override
  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsResponse>
      listBackupCollectionsCallable() {
    return listBackupCollectionsCallable;
  }

  @Override
  public UnaryCallable<ListBackupCollectionsRequest, ListBackupCollectionsPagedResponse>
      listBackupCollectionsPagedCallable() {
    return listBackupCollectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupCollectionRequest, BackupCollection> getBackupCollectionCallable() {
    return getBackupCollectionCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    return listBackupsCallable;
  }

  @Override
  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    return listBackupsPagedCallable;
  }

  @Override
  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    return getBackupCallable;
  }

  @Override
  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    return deleteBackupCallable;
  }

  @Override
  public OperationCallable<DeleteBackupRequest, Empty, Any> deleteBackupOperationCallable() {
    return deleteBackupOperationCallable;
  }

  @Override
  public UnaryCallable<ExportBackupRequest, Operation> exportBackupCallable() {
    return exportBackupCallable;
  }

  @Override
  public OperationCallable<ExportBackupRequest, Backup, Any> exportBackupOperationCallable() {
    return exportBackupOperationCallable;
  }

  @Override
  public UnaryCallable<BackupClusterRequest, Operation> backupClusterCallable() {
    return backupClusterCallable;
  }

  @Override
  public OperationCallable<BackupClusterRequest, Cluster, Any> backupClusterOperationCallable() {
    return backupClusterOperationCallable;
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
