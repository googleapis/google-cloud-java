/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.redis.cluster.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Configures and manages Cloud Memorystore for Redis clusters
 * Google Cloud Memorystore for Redis Cluster
 * The `redis.googleapis.com` service implements the Google Cloud Memorystore
 * for Redis API and defines the following resource model for managing Redis
 * clusters:
 * * The service works with a collection of cloud projects, named: `/projects/&#42;`
 * * Each project has a collection of available locations, named: `/locations/&#42;`
 * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
 * * As such, Redis clusters are resources of the form:
 *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
 * Note that location_id must be a GCP `region`; for example:
 * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/redis/cluster/v1beta1/cloud_redis_cluster.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudRedisClusterGrpc {

  private CloudRedisClusterGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.redis.cluster.v1beta1.CloudRedisCluster";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListClustersRequest,
          com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.redis.cluster.v1beta1.ListClustersRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListClustersRequest,
          com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.ListClustersRequest,
            com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = CloudRedisClusterGrpc.getListClustersMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getListClustersMethod = CloudRedisClusterGrpc.getListClustersMethod) == null) {
          CloudRedisClusterGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.ListClustersRequest,
                          com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetClusterRequest,
          com.google.cloud.redis.cluster.v1beta1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.redis.cluster.v1beta1.GetClusterRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetClusterRequest,
          com.google.cloud.redis.cluster.v1beta1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.GetClusterRequest,
            com.google.cloud.redis.cluster.v1beta1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = CloudRedisClusterGrpc.getGetClusterMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getGetClusterMethod = CloudRedisClusterGrpc.getGetClusterMethod) == null) {
          CloudRedisClusterGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.GetClusterRequest,
                          com.google.cloud.redis.cluster.v1beta1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest,
          com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest,
          com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest,
            com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = CloudRedisClusterGrpc.getUpdateClusterMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getUpdateClusterMethod = CloudRedisClusterGrpc.getUpdateClusterMethod) == null) {
          CloudRedisClusterGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest,
          com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest,
          com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest,
            com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = CloudRedisClusterGrpc.getDeleteClusterMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getDeleteClusterMethod = CloudRedisClusterGrpc.getDeleteClusterMethod) == null) {
          CloudRedisClusterGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest,
          com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest,
          com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest,
            com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = CloudRedisClusterGrpc.getCreateClusterMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getCreateClusterMethod = CloudRedisClusterGrpc.getCreateClusterMethod) == null) {
          CloudRedisClusterGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest,
          com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
      getGetClusterCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetClusterCertificateAuthority",
      requestType =
          com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.CertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest,
          com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
      getGetClusterCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest,
            com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
        getGetClusterCertificateAuthorityMethod;
    if ((getGetClusterCertificateAuthorityMethod =
            CloudRedisClusterGrpc.getGetClusterCertificateAuthorityMethod)
        == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getGetClusterCertificateAuthorityMethod =
                CloudRedisClusterGrpc.getGetClusterCertificateAuthorityMethod)
            == null) {
          CloudRedisClusterGrpc.getGetClusterCertificateAuthorityMethod =
              getGetClusterCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1
                              .GetClusterCertificateAuthorityRequest,
                          com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetClusterCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1
                                  .GetClusterCertificateAuthorityRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.CertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier(
                              "GetClusterCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetClusterCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest,
          com.google.longrunning.Operation>
      getRescheduleClusterMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RescheduleClusterMaintenance",
      requestType =
          com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest,
          com.google.longrunning.Operation>
      getRescheduleClusterMaintenanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest,
            com.google.longrunning.Operation>
        getRescheduleClusterMaintenanceMethod;
    if ((getRescheduleClusterMaintenanceMethod =
            CloudRedisClusterGrpc.getRescheduleClusterMaintenanceMethod)
        == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getRescheduleClusterMaintenanceMethod =
                CloudRedisClusterGrpc.getRescheduleClusterMaintenanceMethod)
            == null) {
          CloudRedisClusterGrpc.getRescheduleClusterMaintenanceMethod =
              getRescheduleClusterMaintenanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RescheduleClusterMaintenance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1
                                  .RescheduleClusterMaintenanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier(
                              "RescheduleClusterMaintenance"))
                      .build();
        }
      }
    }
    return getRescheduleClusterMaintenanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest,
          com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
      getListBackupCollectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupCollections",
      requestType = com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest,
          com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
      getListBackupCollectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest,
            com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
        getListBackupCollectionsMethod;
    if ((getListBackupCollectionsMethod = CloudRedisClusterGrpc.getListBackupCollectionsMethod)
        == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getListBackupCollectionsMethod = CloudRedisClusterGrpc.getListBackupCollectionsMethod)
            == null) {
          CloudRedisClusterGrpc.getListBackupCollectionsMethod =
              getListBackupCollectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest,
                          com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupCollections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("ListBackupCollections"))
                      .build();
        }
      }
    }
    return getListBackupCollectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest,
          com.google.cloud.redis.cluster.v1beta1.BackupCollection>
      getGetBackupCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupCollection",
      requestType = com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.BackupCollection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest,
          com.google.cloud.redis.cluster.v1beta1.BackupCollection>
      getGetBackupCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest,
            com.google.cloud.redis.cluster.v1beta1.BackupCollection>
        getGetBackupCollectionMethod;
    if ((getGetBackupCollectionMethod = CloudRedisClusterGrpc.getGetBackupCollectionMethod)
        == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getGetBackupCollectionMethod = CloudRedisClusterGrpc.getGetBackupCollectionMethod)
            == null) {
          CloudRedisClusterGrpc.getGetBackupCollectionMethod =
              getGetBackupCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest,
                          com.google.cloud.redis.cluster.v1beta1.BackupCollection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.BackupCollection
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("GetBackupCollection"))
                      .build();
        }
      }
    }
    return getGetBackupCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest,
          com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest,
          com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest,
            com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = CloudRedisClusterGrpc.getListBackupsMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getListBackupsMethod = CloudRedisClusterGrpc.getListBackupsMethod) == null) {
          CloudRedisClusterGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest,
                          com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetBackupRequest,
          com.google.cloud.redis.cluster.v1beta1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.redis.cluster.v1beta1.GetBackupRequest.class,
      responseType = com.google.cloud.redis.cluster.v1beta1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.GetBackupRequest,
          com.google.cloud.redis.cluster.v1beta1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.GetBackupRequest,
            com.google.cloud.redis.cluster.v1beta1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = CloudRedisClusterGrpc.getGetBackupMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getGetBackupMethod = CloudRedisClusterGrpc.getGetBackupMethod) == null) {
          CloudRedisClusterGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.GetBackupRequest,
                          com.google.cloud.redis.cluster.v1beta1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest,
          com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest,
          com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest,
            com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = CloudRedisClusterGrpc.getDeleteBackupMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getDeleteBackupMethod = CloudRedisClusterGrpc.getDeleteBackupMethod) == null) {
          CloudRedisClusterGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest,
          com.google.longrunning.Operation>
      getExportBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportBackup",
      requestType = com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest,
          com.google.longrunning.Operation>
      getExportBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest,
            com.google.longrunning.Operation>
        getExportBackupMethod;
    if ((getExportBackupMethod = CloudRedisClusterGrpc.getExportBackupMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getExportBackupMethod = CloudRedisClusterGrpc.getExportBackupMethod) == null) {
          CloudRedisClusterGrpc.getExportBackupMethod =
              getExportBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("ExportBackup"))
                      .build();
        }
      }
    }
    return getExportBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest,
          com.google.longrunning.Operation>
      getBackupClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BackupCluster",
      requestType = com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest,
          com.google.longrunning.Operation>
      getBackupClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest,
            com.google.longrunning.Operation>
        getBackupClusterMethod;
    if ((getBackupClusterMethod = CloudRedisClusterGrpc.getBackupClusterMethod) == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        if ((getBackupClusterMethod = CloudRedisClusterGrpc.getBackupClusterMethod) == null) {
          CloudRedisClusterGrpc.getBackupClusterMethod =
              getBackupClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BackupCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisClusterMethodDescriptorSupplier("BackupCluster"))
                      .build();
        }
      }
    }
    return getBackupClusterMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudRedisClusterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterStub>() {
          @java.lang.Override
          public CloudRedisClusterStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisClusterStub(channel, callOptions);
          }
        };
    return CloudRedisClusterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudRedisClusterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterBlockingStub>() {
          @java.lang.Override
          public CloudRedisClusterBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisClusterBlockingStub(channel, callOptions);
          }
        };
    return CloudRedisClusterBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudRedisClusterFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisClusterFutureStub>() {
          @java.lang.Override
          public CloudRedisClusterFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisClusterFutureStub(channel, callOptions);
          }
        };
    return CloudRedisClusterFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Configures and manages Cloud Memorystore for Redis clusters
   * Google Cloud Memorystore for Redis Cluster
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * clusters:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
   * * As such, Redis clusters are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all Redis clusters owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.redis.cluster.v1beta1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis cluster.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.redis.cluster.v1beta1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Cluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis cluster.
     * Completed longrunning.Operation will contain the new cluster object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis cluster. Cluster stops serving and data is
     * deleted.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Redis cluster based on the specified properties.
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * cluster will be fully functional. The completed longrunning.Operation will
     * contain the new cluster object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    default void createCluster(
        com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of certificate authority information for Redis cluster.
     * </pre>
     */
    default void getClusterCertificateAuthority(
        com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetClusterCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    default void rescheduleClusterMaintenance(
        com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRescheduleClusterMaintenanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup collections owned by a consumer project in either the
     * specified location (region) or all locations.
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    default void listBackupCollections(
        com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupCollectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a backup collection.
     * </pre>
     */
    default void getBackupCollection(
        com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.BackupCollection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups owned by a backup collection.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific backup.
     * </pre>
     */
    default void getBackup(
        com.google.cloud.redis.cluster.v1beta1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Backup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a specific backup to a customer target Cloud Storage URI.
     * </pre>
     */
    default void exportBackup(
        com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Backup Redis Cluster.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the cluster's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    default void backupCluster(
        com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBackupClusterMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudRedisCluster.
   *
   * <pre>
   * Configures and manages Cloud Memorystore for Redis clusters
   * Google Cloud Memorystore for Redis Cluster
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * clusters:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
   * * As such, Redis clusters are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
   * </pre>
   */
  public abstract static class CloudRedisClusterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudRedisClusterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudRedisCluster.
   *
   * <pre>
   * Configures and manages Cloud Memorystore for Redis clusters
   * Google Cloud Memorystore for Redis Cluster
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * clusters:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
   * * As such, Redis clusters are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
   * </pre>
   */
  public static final class CloudRedisClusterStub
      extends io.grpc.stub.AbstractAsyncStub<CloudRedisClusterStub> {
    private CloudRedisClusterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisClusterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisClusterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis clusters owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.redis.cluster.v1beta1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis cluster.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.redis.cluster.v1beta1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Cluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis cluster.
     * Completed longrunning.Operation will contain the new cluster object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis cluster. Cluster stops serving and data is
     * deleted.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Redis cluster based on the specified properties.
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * cluster will be fully functional. The completed longrunning.Operation will
     * contain the new cluster object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public void createCluster(
        com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of certificate authority information for Redis cluster.
     * </pre>
     */
    public void getClusterCertificateAuthority(
        com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    public void rescheduleClusterMaintenance(
        com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRescheduleClusterMaintenanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup collections owned by a consumer project in either the
     * specified location (region) or all locations.
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listBackupCollections(
        com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupCollectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a backup collection.
     * </pre>
     */
    public void getBackupCollection(
        com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.BackupCollection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups owned by a backup collection.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific backup.
     * </pre>
     */
    public void getBackup(
        com.google.cloud.redis.cluster.v1beta1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Backup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports a specific backup to a customer target Cloud Storage URI.
     * </pre>
     */
    public void exportBackup(
        com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Backup Redis Cluster.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the cluster's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public void backupCluster(
        com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBackupClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudRedisCluster.
   *
   * <pre>
   * Configures and manages Cloud Memorystore for Redis clusters
   * Google Cloud Memorystore for Redis Cluster
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * clusters:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
   * * As such, Redis clusters are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
   * </pre>
   */
  public static final class CloudRedisClusterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudRedisClusterBlockingStub> {
    private CloudRedisClusterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisClusterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisClusterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis clusters owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.ListClustersResponse listClusters(
        com.google.cloud.redis.cluster.v1beta1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis cluster.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.Cluster getCluster(
        com.google.cloud.redis.cluster.v1beta1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis cluster.
     * Completed longrunning.Operation will contain the new cluster object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis cluster. Cluster stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Redis cluster based on the specified properties.
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * cluster will be fully functional. The completed longrunning.Operation will
     * contain the new cluster object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of certificate authority information for Redis cluster.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.CertificateAuthority
        getClusterCertificateAuthority(
            com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    public com.google.longrunning.Operation rescheduleClusterMaintenance(
        com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRescheduleClusterMaintenanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup collections owned by a consumer project in either the
     * specified location (region) or all locations.
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse
        listBackupCollections(
            com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupCollectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a backup collection.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.BackupCollection getBackupCollection(
        com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups owned by a backup collection.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse listBackups(
        com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific backup.
     * </pre>
     */
    public com.google.cloud.redis.cluster.v1beta1.Backup getBackup(
        com.google.cloud.redis.cluster.v1beta1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a specific backup to a customer target Cloud Storage URI.
     * </pre>
     */
    public com.google.longrunning.Operation exportBackup(
        com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Backup Redis Cluster.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the cluster's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public com.google.longrunning.Operation backupCluster(
        com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBackupClusterMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudRedisCluster.
   *
   * <pre>
   * Configures and manages Cloud Memorystore for Redis clusters
   * Google Cloud Memorystore for Redis Cluster
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * clusters:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis clusters, named: `/clusters/&#42;`
   * * As such, Redis clusters are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/clusters/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/clusters/my-redis`
   * </pre>
   */
  public static final class CloudRedisClusterFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudRedisClusterFutureStub> {
    private CloudRedisClusterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisClusterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisClusterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis clusters owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>
        listClusters(com.google.cloud.redis.cluster.v1beta1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.Cluster>
        getCluster(com.google.cloud.redis.cluster.v1beta1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis cluster.
     * Completed longrunning.Operation will contain the new cluster object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis cluster. Cluster stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Redis cluster based on the specified properties.
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * cluster will be fully functional. The completed longrunning.Operation will
     * contain the new cluster object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of certificate authority information for Redis cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>
        getClusterCertificateAuthority(
            com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterCertificateAuthorityMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rescheduleClusterMaintenance(
            com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRescheduleClusterMaintenanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backup collections owned by a consumer project in either the
     * specified location (region) or all locations.
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>
        listBackupCollections(
            com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupCollectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a backup collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.BackupCollection>
        getBackupCollection(
            com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups owned by a backup collection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>
        listBackups(com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.cluster.v1beta1.Backup>
        getBackup(com.google.cloud.redis.cluster.v1beta1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports a specific backup to a customer target Cloud Storage URI.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportBackup(com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Backup Redis Cluster.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the cluster's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        backupCluster(com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBackupClusterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_UPDATE_CLUSTER = 2;
  private static final int METHODID_DELETE_CLUSTER = 3;
  private static final int METHODID_CREATE_CLUSTER = 4;
  private static final int METHODID_GET_CLUSTER_CERTIFICATE_AUTHORITY = 5;
  private static final int METHODID_RESCHEDULE_CLUSTER_MAINTENANCE = 6;
  private static final int METHODID_LIST_BACKUP_COLLECTIONS = 7;
  private static final int METHODID_GET_BACKUP_COLLECTION = 8;
  private static final int METHODID_LIST_BACKUPS = 9;
  private static final int METHODID_GET_BACKUP = 10;
  private static final int METHODID_DELETE_BACKUP = 11;
  private static final int METHODID_EXPORT_BACKUP = 12;
  private static final int METHODID_BACKUP_CLUSTER = 13;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.redis.cluster.v1beta1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.redis.cluster.v1beta1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Cluster>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CLUSTER_CERTIFICATE_AUTHORITY:
          serviceImpl.getClusterCertificateAuthority(
              (com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_RESCHEDULE_CLUSTER_MAINTENANCE:
          serviceImpl.rescheduleClusterMaintenance(
              (com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_COLLECTIONS:
          serviceImpl.listBackupCollections(
              (com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_COLLECTION:
          serviceImpl.getBackupCollection(
              (com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.BackupCollection>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.redis.cluster.v1beta1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.cluster.v1beta1.Backup>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_BACKUP:
          serviceImpl.exportBackup(
              (com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BACKUP_CLUSTER:
          serviceImpl.backupCluster(
              (com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.ListClustersRequest,
                    com.google.cloud.redis.cluster.v1beta1.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.GetClusterRequest,
                    com.google.cloud.redis.cluster.v1beta1.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getGetClusterCertificateAuthorityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.GetClusterCertificateAuthorityRequest,
                    com.google.cloud.redis.cluster.v1beta1.CertificateAuthority>(
                    service, METHODID_GET_CLUSTER_CERTIFICATE_AUTHORITY)))
        .addMethod(
            getRescheduleClusterMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.RescheduleClusterMaintenanceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_RESCHEDULE_CLUSTER_MAINTENANCE)))
        .addMethod(
            getListBackupCollectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsRequest,
                    com.google.cloud.redis.cluster.v1beta1.ListBackupCollectionsResponse>(
                    service, METHODID_LIST_BACKUP_COLLECTIONS)))
        .addMethod(
            getGetBackupCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.GetBackupCollectionRequest,
                    com.google.cloud.redis.cluster.v1beta1.BackupCollection>(
                    service, METHODID_GET_BACKUP_COLLECTION)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.ListBackupsRequest,
                    com.google.cloud.redis.cluster.v1beta1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.GetBackupRequest,
                    com.google.cloud.redis.cluster.v1beta1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getExportBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.ExportBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_BACKUP)))
        .addMethod(
            getBackupClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.redis.cluster.v1beta1.BackupClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_BACKUP_CLUSTER)))
        .build();
  }

  private abstract static class CloudRedisClusterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudRedisClusterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.redis.cluster.v1beta1.CloudRedisClusterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudRedisCluster");
    }
  }

  private static final class CloudRedisClusterFileDescriptorSupplier
      extends CloudRedisClusterBaseDescriptorSupplier {
    CloudRedisClusterFileDescriptorSupplier() {}
  }

  private static final class CloudRedisClusterMethodDescriptorSupplier
      extends CloudRedisClusterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudRedisClusterMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CloudRedisClusterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudRedisClusterFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getGetClusterCertificateAuthorityMethod())
                      .addMethod(getRescheduleClusterMaintenanceMethod())
                      .addMethod(getListBackupCollectionsMethod())
                      .addMethod(getGetBackupCollectionMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getExportBackupMethod())
                      .addMethod(getBackupClusterMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
