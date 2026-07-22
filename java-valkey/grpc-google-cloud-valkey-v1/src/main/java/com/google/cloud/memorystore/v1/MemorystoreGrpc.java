/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.memorystore.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class MemorystoreGrpc {

  private MemorystoreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.memorystore.v1.Memorystore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListInstancesRequest,
          com.google.cloud.memorystore.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.memorystore.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.memorystore.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListInstancesRequest,
          com.google.cloud.memorystore.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ListInstancesRequest,
            com.google.cloud.memorystore.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = MemorystoreGrpc.getListInstancesMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListInstancesMethod = MemorystoreGrpc.getListInstancesMethod) == null) {
          MemorystoreGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ListInstancesRequest,
                          com.google.cloud.memorystore.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetInstanceRequest,
          com.google.cloud.memorystore.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.memorystore.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.memorystore.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetInstanceRequest,
          com.google.cloud.memorystore.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetInstanceRequest,
            com.google.cloud.memorystore.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = MemorystoreGrpc.getGetInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetInstanceMethod = MemorystoreGrpc.getGetInstanceMethod) == null) {
          MemorystoreGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetInstanceRequest,
                          com.google.cloud.memorystore.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.memorystore.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = MemorystoreGrpc.getCreateInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getCreateInstanceMethod = MemorystoreGrpc.getCreateInstanceMethod) == null) {
          MemorystoreGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.memorystore.v1.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = MemorystoreGrpc.getUpdateInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getUpdateInstanceMethod = MemorystoreGrpc.getUpdateInstanceMethod) == null) {
          MemorystoreGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.memorystore.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = MemorystoreGrpc.getDeleteInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getDeleteInstanceMethod = MemorystoreGrpc.getDeleteInstanceMethod) == null) {
          MemorystoreGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1.CertificateAuthority>
      getGetCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCertificateAuthority",
      requestType = com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest.class,
      responseType = com.google.cloud.memorystore.v1.CertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1.CertificateAuthority>
      getGetCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest,
            com.google.cloud.memorystore.v1.CertificateAuthority>
        getGetCertificateAuthorityMethod;
    if ((getGetCertificateAuthorityMethod = MemorystoreGrpc.getGetCertificateAuthorityMethod)
        == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetCertificateAuthorityMethod = MemorystoreGrpc.getGetCertificateAuthorityMethod)
            == null) {
          MemorystoreGrpc.getGetCertificateAuthorityMethod =
              getGetCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest,
                          com.google.cloud.memorystore.v1.CertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.CertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("GetCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
      getGetSharedRegionalCertificateAuthorityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSharedRegionalCertificateAuthority",
      requestType =
          com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest.class,
      responseType = com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest,
          com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
      getGetSharedRegionalCertificateAuthorityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest,
            com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
        getGetSharedRegionalCertificateAuthorityMethod;
    if ((getGetSharedRegionalCertificateAuthorityMethod =
            MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod)
        == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetSharedRegionalCertificateAuthorityMethod =
                MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod)
            == null) {
          MemorystoreGrpc.getGetSharedRegionalCertificateAuthorityMethod =
              getGetSharedRegionalCertificateAuthorityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1
                              .GetSharedRegionalCertificateAuthorityRequest,
                          com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GetSharedRegionalCertificateAuthority"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1
                                  .GetSharedRegionalCertificateAuthorityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier(
                              "GetSharedRegionalCertificateAuthority"))
                      .build();
        }
      }
    }
    return getGetSharedRegionalCertificateAuthorityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest,
          com.google.longrunning.Operation>
      getRescheduleMaintenanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RescheduleMaintenance",
      requestType = com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest,
          com.google.longrunning.Operation>
      getRescheduleMaintenanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest,
            com.google.longrunning.Operation>
        getRescheduleMaintenanceMethod;
    if ((getRescheduleMaintenanceMethod = MemorystoreGrpc.getRescheduleMaintenanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getRescheduleMaintenanceMethod = MemorystoreGrpc.getRescheduleMaintenanceMethod)
            == null) {
          MemorystoreGrpc.getRescheduleMaintenanceMethod =
              getRescheduleMaintenanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RescheduleMaintenance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("RescheduleMaintenance"))
                      .build();
        }
      }
    }
    return getRescheduleMaintenanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListBackupCollectionsRequest,
          com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
      getListBackupCollectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupCollections",
      requestType = com.google.cloud.memorystore.v1.ListBackupCollectionsRequest.class,
      responseType = com.google.cloud.memorystore.v1.ListBackupCollectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListBackupCollectionsRequest,
          com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
      getListBackupCollectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ListBackupCollectionsRequest,
            com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
        getListBackupCollectionsMethod;
    if ((getListBackupCollectionsMethod = MemorystoreGrpc.getListBackupCollectionsMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListBackupCollectionsMethod = MemorystoreGrpc.getListBackupCollectionsMethod)
            == null) {
          MemorystoreGrpc.getListBackupCollectionsMethod =
              getListBackupCollectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ListBackupCollectionsRequest,
                          com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListBackupCollections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListBackupCollectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListBackupCollectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("ListBackupCollections"))
                      .build();
        }
      }
    }
    return getListBackupCollectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetBackupCollectionRequest,
          com.google.cloud.memorystore.v1.BackupCollection>
      getGetBackupCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupCollection",
      requestType = com.google.cloud.memorystore.v1.GetBackupCollectionRequest.class,
      responseType = com.google.cloud.memorystore.v1.BackupCollection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetBackupCollectionRequest,
          com.google.cloud.memorystore.v1.BackupCollection>
      getGetBackupCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetBackupCollectionRequest,
            com.google.cloud.memorystore.v1.BackupCollection>
        getGetBackupCollectionMethod;
    if ((getGetBackupCollectionMethod = MemorystoreGrpc.getGetBackupCollectionMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetBackupCollectionMethod = MemorystoreGrpc.getGetBackupCollectionMethod) == null) {
          MemorystoreGrpc.getGetBackupCollectionMethod =
              getGetBackupCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetBackupCollectionRequest,
                          com.google.cloud.memorystore.v1.BackupCollection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetBackupCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetBackupCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.BackupCollection
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("GetBackupCollection"))
                      .build();
        }
      }
    }
    return getGetBackupCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListBackupsRequest,
          com.google.cloud.memorystore.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.memorystore.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.memorystore.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListBackupsRequest,
          com.google.cloud.memorystore.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ListBackupsRequest,
            com.google.cloud.memorystore.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = MemorystoreGrpc.getListBackupsMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListBackupsMethod = MemorystoreGrpc.getListBackupsMethod) == null) {
          MemorystoreGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ListBackupsRequest,
                          com.google.cloud.memorystore.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListBackupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListBackupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetBackupRequest, com.google.cloud.memorystore.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.memorystore.v1.GetBackupRequest.class,
      responseType = com.google.cloud.memorystore.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetBackupRequest, com.google.cloud.memorystore.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetBackupRequest,
            com.google.cloud.memorystore.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = MemorystoreGrpc.getGetBackupMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetBackupMethod = MemorystoreGrpc.getGetBackupMethod) == null) {
          MemorystoreGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetBackupRequest,
                          com.google.cloud.memorystore.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.memorystore.v1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = MemorystoreGrpc.getDeleteBackupMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getDeleteBackupMethod = MemorystoreGrpc.getDeleteBackupMethod) == null) {
          MemorystoreGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.DeleteBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ExportBackupRequest, com.google.longrunning.Operation>
      getExportBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportBackup",
      requestType = com.google.cloud.memorystore.v1.ExportBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ExportBackupRequest, com.google.longrunning.Operation>
      getExportBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ExportBackupRequest, com.google.longrunning.Operation>
        getExportBackupMethod;
    if ((getExportBackupMethod = MemorystoreGrpc.getExportBackupMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getExportBackupMethod = MemorystoreGrpc.getExportBackupMethod) == null) {
          MemorystoreGrpc.getExportBackupMethod =
              getExportBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ExportBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ExportBackupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("ExportBackup"))
                      .build();
        }
      }
    }
    return getExportBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.BackupInstanceRequest, com.google.longrunning.Operation>
      getBackupInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BackupInstance",
      requestType = com.google.cloud.memorystore.v1.BackupInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.BackupInstanceRequest, com.google.longrunning.Operation>
      getBackupInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.BackupInstanceRequest, com.google.longrunning.Operation>
        getBackupInstanceMethod;
    if ((getBackupInstanceMethod = MemorystoreGrpc.getBackupInstanceMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getBackupInstanceMethod = MemorystoreGrpc.getBackupInstanceMethod) == null) {
          MemorystoreGrpc.getBackupInstanceMethod =
              getBackupInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.BackupInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BackupInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.BackupInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("BackupInstance"))
                      .build();
        }
      }
    }
    return getBackupInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.StartMigrationRequest, com.google.longrunning.Operation>
      getStartMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartMigration",
      requestType = com.google.cloud.memorystore.v1.StartMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.StartMigrationRequest, com.google.longrunning.Operation>
      getStartMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.StartMigrationRequest, com.google.longrunning.Operation>
        getStartMigrationMethod;
    if ((getStartMigrationMethod = MemorystoreGrpc.getStartMigrationMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getStartMigrationMethod = MemorystoreGrpc.getStartMigrationMethod) == null) {
          MemorystoreGrpc.getStartMigrationMethod =
              getStartMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.StartMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.StartMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("StartMigration"))
                      .build();
        }
      }
    }
    return getStartMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.FinishMigrationRequest, com.google.longrunning.Operation>
      getFinishMigrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FinishMigration",
      requestType = com.google.cloud.memorystore.v1.FinishMigrationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.FinishMigrationRequest, com.google.longrunning.Operation>
      getFinishMigrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.FinishMigrationRequest,
            com.google.longrunning.Operation>
        getFinishMigrationMethod;
    if ((getFinishMigrationMethod = MemorystoreGrpc.getFinishMigrationMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getFinishMigrationMethod = MemorystoreGrpc.getFinishMigrationMethod) == null) {
          MemorystoreGrpc.getFinishMigrationMethod =
              getFinishMigrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.FinishMigrationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FinishMigration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.FinishMigrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("FinishMigration"))
                      .build();
        }
      }
    }
    return getFinishMigrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest,
          com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
      getListTokenAuthUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTokenAuthUsers",
      requestType = com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest.class,
      responseType = com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest,
          com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
      getListTokenAuthUsersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest,
            com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
        getListTokenAuthUsersMethod;
    if ((getListTokenAuthUsersMethod = MemorystoreGrpc.getListTokenAuthUsersMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListTokenAuthUsersMethod = MemorystoreGrpc.getListTokenAuthUsersMethod) == null) {
          MemorystoreGrpc.getListTokenAuthUsersMethod =
              getListTokenAuthUsersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest,
                          com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTokenAuthUsers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("ListTokenAuthUsers"))
                      .build();
        }
      }
    }
    return getListTokenAuthUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetTokenAuthUserRequest,
          com.google.cloud.memorystore.v1.TokenAuthUser>
      getGetTokenAuthUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTokenAuthUser",
      requestType = com.google.cloud.memorystore.v1.GetTokenAuthUserRequest.class,
      responseType = com.google.cloud.memorystore.v1.TokenAuthUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetTokenAuthUserRequest,
          com.google.cloud.memorystore.v1.TokenAuthUser>
      getGetTokenAuthUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetTokenAuthUserRequest,
            com.google.cloud.memorystore.v1.TokenAuthUser>
        getGetTokenAuthUserMethod;
    if ((getGetTokenAuthUserMethod = MemorystoreGrpc.getGetTokenAuthUserMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetTokenAuthUserMethod = MemorystoreGrpc.getGetTokenAuthUserMethod) == null) {
          MemorystoreGrpc.getGetTokenAuthUserMethod =
              getGetTokenAuthUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetTokenAuthUserRequest,
                          com.google.cloud.memorystore.v1.TokenAuthUser>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTokenAuthUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetTokenAuthUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.TokenAuthUser.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("GetTokenAuthUser"))
                      .build();
        }
      }
    }
    return getGetTokenAuthUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListAuthTokensRequest,
          com.google.cloud.memorystore.v1.ListAuthTokensResponse>
      getListAuthTokensMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuthTokens",
      requestType = com.google.cloud.memorystore.v1.ListAuthTokensRequest.class,
      responseType = com.google.cloud.memorystore.v1.ListAuthTokensResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.ListAuthTokensRequest,
          com.google.cloud.memorystore.v1.ListAuthTokensResponse>
      getListAuthTokensMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.ListAuthTokensRequest,
            com.google.cloud.memorystore.v1.ListAuthTokensResponse>
        getListAuthTokensMethod;
    if ((getListAuthTokensMethod = MemorystoreGrpc.getListAuthTokensMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getListAuthTokensMethod = MemorystoreGrpc.getListAuthTokensMethod) == null) {
          MemorystoreGrpc.getListAuthTokensMethod =
              getListAuthTokensMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.ListAuthTokensRequest,
                          com.google.cloud.memorystore.v1.ListAuthTokensResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuthTokens"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListAuthTokensRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.ListAuthTokensResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("ListAuthTokens"))
                      .build();
        }
      }
    }
    return getListAuthTokensMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetAuthTokenRequest,
          com.google.cloud.memorystore.v1.AuthToken>
      getGetAuthTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthToken",
      requestType = com.google.cloud.memorystore.v1.GetAuthTokenRequest.class,
      responseType = com.google.cloud.memorystore.v1.AuthToken.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.GetAuthTokenRequest,
          com.google.cloud.memorystore.v1.AuthToken>
      getGetAuthTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.GetAuthTokenRequest,
            com.google.cloud.memorystore.v1.AuthToken>
        getGetAuthTokenMethod;
    if ((getGetAuthTokenMethod = MemorystoreGrpc.getGetAuthTokenMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getGetAuthTokenMethod = MemorystoreGrpc.getGetAuthTokenMethod) == null) {
          MemorystoreGrpc.getGetAuthTokenMethod =
              getGetAuthTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.GetAuthTokenRequest,
                          com.google.cloud.memorystore.v1.AuthToken>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.GetAuthTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.AuthToken.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("GetAuthToken"))
                      .build();
        }
      }
    }
    return getGetAuthTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.AddTokenAuthUserRequest, com.google.longrunning.Operation>
      getAddTokenAuthUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTokenAuthUser",
      requestType = com.google.cloud.memorystore.v1.AddTokenAuthUserRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.AddTokenAuthUserRequest, com.google.longrunning.Operation>
      getAddTokenAuthUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.AddTokenAuthUserRequest,
            com.google.longrunning.Operation>
        getAddTokenAuthUserMethod;
    if ((getAddTokenAuthUserMethod = MemorystoreGrpc.getAddTokenAuthUserMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getAddTokenAuthUserMethod = MemorystoreGrpc.getAddTokenAuthUserMethod) == null) {
          MemorystoreGrpc.getAddTokenAuthUserMethod =
              getAddTokenAuthUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.AddTokenAuthUserRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddTokenAuthUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.AddTokenAuthUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("AddTokenAuthUser"))
                      .build();
        }
      }
    }
    return getAddTokenAuthUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest,
          com.google.longrunning.Operation>
      getDeleteTokenAuthUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTokenAuthUser",
      requestType = com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest,
          com.google.longrunning.Operation>
      getDeleteTokenAuthUserMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest,
            com.google.longrunning.Operation>
        getDeleteTokenAuthUserMethod;
    if ((getDeleteTokenAuthUserMethod = MemorystoreGrpc.getDeleteTokenAuthUserMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getDeleteTokenAuthUserMethod = MemorystoreGrpc.getDeleteTokenAuthUserMethod) == null) {
          MemorystoreGrpc.getDeleteTokenAuthUserMethod =
              getDeleteTokenAuthUserMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteTokenAuthUser"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("DeleteTokenAuthUser"))
                      .build();
        }
      }
    }
    return getDeleteTokenAuthUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.AddAuthTokenRequest, com.google.longrunning.Operation>
      getAddAuthTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddAuthToken",
      requestType = com.google.cloud.memorystore.v1.AddAuthTokenRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.AddAuthTokenRequest, com.google.longrunning.Operation>
      getAddAuthTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.AddAuthTokenRequest, com.google.longrunning.Operation>
        getAddAuthTokenMethod;
    if ((getAddAuthTokenMethod = MemorystoreGrpc.getAddAuthTokenMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getAddAuthTokenMethod = MemorystoreGrpc.getAddAuthTokenMethod) == null) {
          MemorystoreGrpc.getAddAuthTokenMethod =
              getAddAuthTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.AddAuthTokenRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddAuthToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.AddAuthTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new MemorystoreMethodDescriptorSupplier("AddAuthToken"))
                      .build();
        }
      }
    }
    return getAddAuthTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteAuthTokenRequest, com.google.longrunning.Operation>
      getDeleteAuthTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAuthToken",
      requestType = com.google.cloud.memorystore.v1.DeleteAuthTokenRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.memorystore.v1.DeleteAuthTokenRequest, com.google.longrunning.Operation>
      getDeleteAuthTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.memorystore.v1.DeleteAuthTokenRequest,
            com.google.longrunning.Operation>
        getDeleteAuthTokenMethod;
    if ((getDeleteAuthTokenMethod = MemorystoreGrpc.getDeleteAuthTokenMethod) == null) {
      synchronized (MemorystoreGrpc.class) {
        if ((getDeleteAuthTokenMethod = MemorystoreGrpc.getDeleteAuthTokenMethod) == null) {
          MemorystoreGrpc.getDeleteAuthTokenMethod =
              getDeleteAuthTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.memorystore.v1.DeleteAuthTokenRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAuthToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.memorystore.v1.DeleteAuthTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MemorystoreMethodDescriptorSupplier("DeleteAuthToken"))
                      .build();
        }
      }
    }
    return getDeleteAuthTokenMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MemorystoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreStub>() {
          @java.lang.Override
          public MemorystoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreStub(channel, callOptions);
          }
        };
    return MemorystoreStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MemorystoreBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingV2Stub>() {
          @java.lang.Override
          public MemorystoreBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreBlockingV2Stub(channel, callOptions);
          }
        };
    return MemorystoreBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MemorystoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreBlockingStub>() {
          @java.lang.Override
          public MemorystoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreBlockingStub(channel, callOptions);
          }
        };
    return MemorystoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MemorystoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MemorystoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MemorystoreFutureStub>() {
          @java.lang.Override
          public MemorystoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MemorystoreFutureStub(channel, callOptions);
          }
        };
    return MemorystoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.memorystore.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.memorystore.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.memorystore.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.memorystore.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.memorystore.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    default void getCertificateAuthority(
        com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    default void getSharedRegionalCertificateAuthority(
        com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSharedRegionalCertificateAuthorityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    default void rescheduleMaintenance(
        com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRescheduleMaintenanceMethod(), responseObserver);
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
        com.google.cloud.memorystore.v1.ListBackupCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
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
        com.google.cloud.memorystore.v1.GetBackupCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.BackupCollection>
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
        com.google.cloud.memorystore.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListBackupsResponse>
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
        com.google.cloud.memorystore.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Backup> responseObserver) {
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
        com.google.cloud.memorystore.v1.DeleteBackupRequest request,
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
        com.google.cloud.memorystore.v1.ExportBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Backup Instance.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the instance's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    default void backupInstance(
        com.google.cloud.memorystore.v1.BackupInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBackupInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the migration of a source instance to the target Memorystore
     * instance.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Set up replication with the source instance and replicate any writes to
     * the source instance.
     * 2. Only allow reads.
     * </pre>
     */
    default void startMigration(
        com.google.cloud.memorystore.v1.StartMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finalizes the migration process.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Stop replicating from the source instance.
     * 2. Allow both reads and writes.
     * </pre>
     */
    default void finishMigration(
        com.google.cloud.memorystore.v1.FinishMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFinishMigrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the token auth users for a token based auth enabled instance.
     * </pre>
     */
    default void listTokenAuthUsers(
        com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTokenAuthUsersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific token auth user for a token based auth enabled instance.
     * </pre>
     */
    default void getTokenAuthUser(
        com.google.cloud.memorystore.v1.GetTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.TokenAuthUser>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTokenAuthUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the auth tokens for a specific token auth user.
     * </pre>
     */
    default void listAuthTokens(
        com.google.cloud.memorystore.v1.ListAuthTokensRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListAuthTokensResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuthTokensMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a token based auth enabled instance's auth token for a given user.
     * </pre>
     */
    default void getAuthToken(
        com.google.cloud.memorystore.v1.GetAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.AuthToken> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuthTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a token auth user for a token based auth enabled instance.
     * </pre>
     */
    default void addTokenAuthUser(
        com.google.cloud.memorystore.v1.AddTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddTokenAuthUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token auth user for a token based auth enabled instance.
     * </pre>
     */
    default void deleteTokenAuthUser(
        com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTokenAuthUserMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a token for a user of a token based auth enabled instance.
     * </pre>
     */
    default void addAuthToken(
        com.google.cloud.memorystore.v1.AddAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddAuthTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token for a user of a token based auth enabled instance.
     * </pre>
     */
    default void deleteAuthToken(
        com.google.cloud.memorystore.v1.DeleteAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAuthTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class MemorystoreImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MemorystoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreStub
      extends io.grpc.stub.AbstractAsyncStub<MemorystoreStub> {
    private MemorystoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.memorystore.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.memorystore.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.memorystore.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.memorystore.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.memorystore.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public void getCertificateAuthority(
        com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.CertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public void getSharedRegionalCertificateAuthority(
        com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSharedRegionalCertificateAuthorityMethod(), getCallOptions()),
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
    public void rescheduleMaintenance(
        com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRescheduleMaintenanceMethod(), getCallOptions()),
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
        com.google.cloud.memorystore.v1.ListBackupCollectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
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
        com.google.cloud.memorystore.v1.GetBackupCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.BackupCollection>
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
        com.google.cloud.memorystore.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListBackupsResponse>
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
        com.google.cloud.memorystore.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Backup> responseObserver) {
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
        com.google.cloud.memorystore.v1.DeleteBackupRequest request,
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
        com.google.cloud.memorystore.v1.ExportBackupRequest request,
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
     * Backup Instance.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the instance's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public void backupInstance(
        com.google.cloud.memorystore.v1.BackupInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBackupInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates the migration of a source instance to the target Memorystore
     * instance.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Set up replication with the source instance and replicate any writes to
     * the source instance.
     * 2. Only allow reads.
     * </pre>
     */
    public void startMigration(
        com.google.cloud.memorystore.v1.StartMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Finalizes the migration process.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Stop replicating from the source instance.
     * 2. Allow both reads and writes.
     * </pre>
     */
    public void finishMigration(
        com.google.cloud.memorystore.v1.FinishMigrationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFinishMigrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the token auth users for a token based auth enabled instance.
     * </pre>
     */
    public void listTokenAuthUsers(
        com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTokenAuthUsersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific token auth user for a token based auth enabled instance.
     * </pre>
     */
    public void getTokenAuthUser(
        com.google.cloud.memorystore.v1.GetTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.TokenAuthUser>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTokenAuthUserMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the auth tokens for a specific token auth user.
     * </pre>
     */
    public void listAuthTokens(
        com.google.cloud.memorystore.v1.ListAuthTokensRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListAuthTokensResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuthTokensMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a token based auth enabled instance's auth token for a given user.
     * </pre>
     */
    public void getAuthToken(
        com.google.cloud.memorystore.v1.GetAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.AuthToken> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public void addTokenAuthUser(
        com.google.cloud.memorystore.v1.AddTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTokenAuthUserMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public void deleteTokenAuthUser(
        com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTokenAuthUserMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public void addAuthToken(
        com.google.cloud.memorystore.v1.AddAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddAuthTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public void deleteAuthToken(
        com.google.cloud.memorystore.v1.DeleteAuthTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAuthTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MemorystoreBlockingV2Stub> {
    private MemorystoreBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListInstancesResponse listInstances(
        com.google.cloud.memorystore.v1.ListInstancesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.Instance getInstance(
        com.google.cloud.memorystore.v1.GetInstanceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.memorystore.v1.CreateInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.memorystore.v1.UpdateInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.memorystore.v1.DeleteInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.CertificateAuthority getCertificateAuthority(
        com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getGetSharedRegionalCertificateAuthorityMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    public com.google.longrunning.Operation rescheduleMaintenance(
        com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRescheduleMaintenanceMethod(), getCallOptions(), request);
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
    public com.google.cloud.memorystore.v1.ListBackupCollectionsResponse listBackupCollections(
        com.google.cloud.memorystore.v1.ListBackupCollectionsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupCollectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a backup collection.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.BackupCollection getBackupCollection(
        com.google.cloud.memorystore.v1.GetBackupCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetBackupCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all backups owned by a backup collection.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListBackupsResponse listBackups(
        com.google.cloud.memorystore.v1.ListBackupsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific backup.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.Backup getBackup(
        com.google.cloud.memorystore.v1.GetBackupRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.memorystore.v1.DeleteBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
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
        com.google.cloud.memorystore.v1.ExportBackupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExportBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Backup Instance.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the instance's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public com.google.longrunning.Operation backupInstance(
        com.google.cloud.memorystore.v1.BackupInstanceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getBackupInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the migration of a source instance to the target Memorystore
     * instance.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Set up replication with the source instance and replicate any writes to
     * the source instance.
     * 2. Only allow reads.
     * </pre>
     */
    public com.google.longrunning.Operation startMigration(
        com.google.cloud.memorystore.v1.StartMigrationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getStartMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finalizes the migration process.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Stop replicating from the source instance.
     * 2. Allow both reads and writes.
     * </pre>
     */
    public com.google.longrunning.Operation finishMigration(
        com.google.cloud.memorystore.v1.FinishMigrationRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getFinishMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the token auth users for a token based auth enabled instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse listTokenAuthUsers(
        com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListTokenAuthUsersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.TokenAuthUser getTokenAuthUser(
        com.google.cloud.memorystore.v1.GetTokenAuthUserRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the auth tokens for a specific token auth user.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListAuthTokensResponse listAuthTokens(
        com.google.cloud.memorystore.v1.ListAuthTokensRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuthTokensMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a token based auth enabled instance's auth token for a given user.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.AuthToken getAuthToken(
        com.google.cloud.memorystore.v1.GetAuthTokenRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuthTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation addTokenAuthUser(
        com.google.cloud.memorystore.v1.AddTokenAuthUserRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTokenAuthUser(
        com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation addAuthToken(
        com.google.cloud.memorystore.v1.AddAuthTokenRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAddAuthTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthToken(
        com.google.cloud.memorystore.v1.DeleteAuthTokenRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteAuthTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MemorystoreBlockingStub> {
    private MemorystoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListInstancesResponse listInstances(
        com.google.cloud.memorystore.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.Instance getInstance(
        com.google.cloud.memorystore.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.memorystore.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.memorystore.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.memorystore.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.CertificateAuthority getCertificateAuthority(
        com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCertificateAuthorityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGetSharedRegionalCertificateAuthorityMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Reschedules upcoming maintenance event.
     * </pre>
     */
    public com.google.longrunning.Operation rescheduleMaintenance(
        com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRescheduleMaintenanceMethod(), getCallOptions(), request);
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
    public com.google.cloud.memorystore.v1.ListBackupCollectionsResponse listBackupCollections(
        com.google.cloud.memorystore.v1.ListBackupCollectionsRequest request) {
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
    public com.google.cloud.memorystore.v1.BackupCollection getBackupCollection(
        com.google.cloud.memorystore.v1.GetBackupCollectionRequest request) {
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
    public com.google.cloud.memorystore.v1.ListBackupsResponse listBackups(
        com.google.cloud.memorystore.v1.ListBackupsRequest request) {
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
    public com.google.cloud.memorystore.v1.Backup getBackup(
        com.google.cloud.memorystore.v1.GetBackupRequest request) {
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
        com.google.cloud.memorystore.v1.DeleteBackupRequest request) {
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
        com.google.cloud.memorystore.v1.ExportBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Backup Instance.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the instance's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public com.google.longrunning.Operation backupInstance(
        com.google.cloud.memorystore.v1.BackupInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBackupInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the migration of a source instance to the target Memorystore
     * instance.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Set up replication with the source instance and replicate any writes to
     * the source instance.
     * 2. Only allow reads.
     * </pre>
     */
    public com.google.longrunning.Operation startMigration(
        com.google.cloud.memorystore.v1.StartMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Finalizes the migration process.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Stop replicating from the source instance.
     * 2. Allow both reads and writes.
     * </pre>
     */
    public com.google.longrunning.Operation finishMigration(
        com.google.cloud.memorystore.v1.FinishMigrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFinishMigrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the token auth users for a token based auth enabled instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse listTokenAuthUsers(
        com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTokenAuthUsersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.TokenAuthUser getTokenAuthUser(
        com.google.cloud.memorystore.v1.GetTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the auth tokens for a specific token auth user.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.ListAuthTokensResponse listAuthTokens(
        com.google.cloud.memorystore.v1.ListAuthTokensRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuthTokensMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a token based auth enabled instance's auth token for a given user.
     * </pre>
     */
    public com.google.cloud.memorystore.v1.AuthToken getAuthToken(
        com.google.cloud.memorystore.v1.GetAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation addTokenAuthUser(
        com.google.cloud.memorystore.v1.AddTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTokenAuthUser(
        com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTokenAuthUserMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation addAuthToken(
        com.google.cloud.memorystore.v1.AddAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddAuthTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAuthToken(
        com.google.cloud.memorystore.v1.DeleteAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAuthTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Memorystore.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MemorystoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<MemorystoreFutureStub> {
    private MemorystoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MemorystoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MemorystoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.ListInstancesResponse>
        listInstances(com.google.cloud.memorystore.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.Instance>
        getInstance(com.google.cloud.memorystore.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.memorystore.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.memorystore.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.memorystore.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the certificate authority for an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.CertificateAuthority>
        getCertificateAuthority(
            com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCertificateAuthorityMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of shared regional certificate authority information for
     * Memorystore instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>
        getSharedRegionalCertificateAuthority(
            com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSharedRegionalCertificateAuthorityMethod(), getCallOptions()),
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
        rescheduleMaintenance(
            com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRescheduleMaintenanceMethod(), getCallOptions()), request);
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
            com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>
        listBackupCollections(
            com.google.cloud.memorystore.v1.ListBackupCollectionsRequest request) {
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
            com.google.cloud.memorystore.v1.BackupCollection>
        getBackupCollection(com.google.cloud.memorystore.v1.GetBackupCollectionRequest request) {
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
            com.google.cloud.memorystore.v1.ListBackupsResponse>
        listBackups(com.google.cloud.memorystore.v1.ListBackupsRequest request) {
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
            com.google.cloud.memorystore.v1.Backup>
        getBackup(com.google.cloud.memorystore.v1.GetBackupRequest request) {
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
        deleteBackup(com.google.cloud.memorystore.v1.DeleteBackupRequest request) {
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
        exportBackup(com.google.cloud.memorystore.v1.ExportBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Backup Instance.
     * If this is the first time a backup is being created, a backup collection
     * will be created at the backend, and this backup belongs to this collection.
     * Both collection and backup will have a resource name. Backup will be
     * executed for each shard. A replica (primary if nonHA) will be selected to
     * perform the execution. Backup call will be rejected if there is an ongoing
     * backup or update operation. Be aware that during preview, if the instance's
     * internal software version is too old, critical update will be performed
     * before actual backup. Once the internal software version is updated to the
     * minimum version required by the backup feature, subsequent backups will not
     * require critical update. After preview, there will be no critical update
     * needed for backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        backupInstance(com.google.cloud.memorystore.v1.BackupInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBackupInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates the migration of a source instance to the target Memorystore
     * instance.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Set up replication with the source instance and replicate any writes to
     * the source instance.
     * 2. Only allow reads.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startMigration(com.google.cloud.memorystore.v1.StartMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Finalizes the migration process.
     * After the successful completion of this operation, the target instance
     * will:
     * 1. Stop replicating from the source instance.
     * 2. Allow both reads and writes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        finishMigration(com.google.cloud.memorystore.v1.FinishMigrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFinishMigrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the token auth users for a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>
        listTokenAuthUsers(com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTokenAuthUsersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a specific token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.TokenAuthUser>
        getTokenAuthUser(com.google.cloud.memorystore.v1.GetTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTokenAuthUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the auth tokens for a specific token auth user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.ListAuthTokensResponse>
        listAuthTokens(com.google.cloud.memorystore.v1.ListAuthTokensRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuthTokensMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a token based auth enabled instance's auth token for a given user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.memorystore.v1.AuthToken>
        getAuthToken(com.google.cloud.memorystore.v1.GetAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addTokenAuthUser(com.google.cloud.memorystore.v1.AddTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTokenAuthUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token auth user for a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTokenAuthUser(com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTokenAuthUserMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addAuthToken(com.google.cloud.memorystore.v1.AddAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddAuthTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a token for a user of a token based auth enabled instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAuthToken(com.google.cloud.memorystore.v1.DeleteAuthTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAuthTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_GET_CERTIFICATE_AUTHORITY = 5;
  private static final int METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY = 6;
  private static final int METHODID_RESCHEDULE_MAINTENANCE = 7;
  private static final int METHODID_LIST_BACKUP_COLLECTIONS = 8;
  private static final int METHODID_GET_BACKUP_COLLECTION = 9;
  private static final int METHODID_LIST_BACKUPS = 10;
  private static final int METHODID_GET_BACKUP = 11;
  private static final int METHODID_DELETE_BACKUP = 12;
  private static final int METHODID_EXPORT_BACKUP = 13;
  private static final int METHODID_BACKUP_INSTANCE = 14;
  private static final int METHODID_START_MIGRATION = 15;
  private static final int METHODID_FINISH_MIGRATION = 16;
  private static final int METHODID_LIST_TOKEN_AUTH_USERS = 17;
  private static final int METHODID_GET_TOKEN_AUTH_USER = 18;
  private static final int METHODID_LIST_AUTH_TOKENS = 19;
  private static final int METHODID_GET_AUTH_TOKEN = 20;
  private static final int METHODID_ADD_TOKEN_AUTH_USER = 21;
  private static final int METHODID_DELETE_TOKEN_AUTH_USER = 22;
  private static final int METHODID_ADD_AUTH_TOKEN = 23;
  private static final int METHODID_DELETE_AUTH_TOKEN = 24;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.memorystore.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.memorystore.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.memorystore.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.memorystore.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.memorystore.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CERTIFICATE_AUTHORITY:
          serviceImpl.getCertificateAuthority(
              (com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.CertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY:
          serviceImpl.getSharedRegionalCertificateAuthority(
              (com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>)
                  responseObserver);
          break;
        case METHODID_RESCHEDULE_MAINTENANCE:
          serviceImpl.rescheduleMaintenance(
              (com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BACKUP_COLLECTIONS:
          serviceImpl.listBackupCollections(
              (com.google.cloud.memorystore.v1.ListBackupCollectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP_COLLECTION:
          serviceImpl.getBackupCollection(
              (com.google.cloud.memorystore.v1.GetBackupCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.BackupCollection>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.memorystore.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.memorystore.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.Backup>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.memorystore.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_BACKUP:
          serviceImpl.exportBackup(
              (com.google.cloud.memorystore.v1.ExportBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BACKUP_INSTANCE:
          serviceImpl.backupInstance(
              (com.google.cloud.memorystore.v1.BackupInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_MIGRATION:
          serviceImpl.startMigration(
              (com.google.cloud.memorystore.v1.StartMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FINISH_MIGRATION:
          serviceImpl.finishMigration(
              (com.google.cloud.memorystore.v1.FinishMigrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TOKEN_AUTH_USERS:
          serviceImpl.listTokenAuthUsers(
              (com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TOKEN_AUTH_USER:
          serviceImpl.getTokenAuthUser(
              (com.google.cloud.memorystore.v1.GetTokenAuthUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.TokenAuthUser>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTH_TOKENS:
          serviceImpl.listAuthTokens(
              (com.google.cloud.memorystore.v1.ListAuthTokensRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.ListAuthTokensResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUTH_TOKEN:
          serviceImpl.getAuthToken(
              (com.google.cloud.memorystore.v1.GetAuthTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memorystore.v1.AuthToken>)
                  responseObserver);
          break;
        case METHODID_ADD_TOKEN_AUTH_USER:
          serviceImpl.addTokenAuthUser(
              (com.google.cloud.memorystore.v1.AddTokenAuthUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TOKEN_AUTH_USER:
          serviceImpl.deleteTokenAuthUser(
              (com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_AUTH_TOKEN:
          serviceImpl.addAuthToken(
              (com.google.cloud.memorystore.v1.AddAuthTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_AUTH_TOKEN:
          serviceImpl.deleteAuthToken(
              (com.google.cloud.memorystore.v1.DeleteAuthTokenRequest) request,
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
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ListInstancesRequest,
                    com.google.cloud.memorystore.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetInstanceRequest,
                    com.google.cloud.memorystore.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getGetCertificateAuthorityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetCertificateAuthorityRequest,
                    com.google.cloud.memorystore.v1.CertificateAuthority>(
                    service, METHODID_GET_CERTIFICATE_AUTHORITY)))
        .addMethod(
            getGetSharedRegionalCertificateAuthorityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetSharedRegionalCertificateAuthorityRequest,
                    com.google.cloud.memorystore.v1.SharedRegionalCertificateAuthority>(
                    service, METHODID_GET_SHARED_REGIONAL_CERTIFICATE_AUTHORITY)))
        .addMethod(
            getRescheduleMaintenanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.RescheduleMaintenanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESCHEDULE_MAINTENANCE)))
        .addMethod(
            getListBackupCollectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ListBackupCollectionsRequest,
                    com.google.cloud.memorystore.v1.ListBackupCollectionsResponse>(
                    service, METHODID_LIST_BACKUP_COLLECTIONS)))
        .addMethod(
            getGetBackupCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetBackupCollectionRequest,
                    com.google.cloud.memorystore.v1.BackupCollection>(
                    service, METHODID_GET_BACKUP_COLLECTION)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ListBackupsRequest,
                    com.google.cloud.memorystore.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetBackupRequest,
                    com.google.cloud.memorystore.v1.Backup>(service, METHODID_GET_BACKUP)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getExportBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ExportBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_BACKUP)))
        .addMethod(
            getBackupInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.BackupInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_BACKUP_INSTANCE)))
        .addMethod(
            getStartMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.StartMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_MIGRATION)))
        .addMethod(
            getFinishMigrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.FinishMigrationRequest,
                    com.google.longrunning.Operation>(service, METHODID_FINISH_MIGRATION)))
        .addMethod(
            getListTokenAuthUsersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ListTokenAuthUsersRequest,
                    com.google.cloud.memorystore.v1.ListTokenAuthUsersResponse>(
                    service, METHODID_LIST_TOKEN_AUTH_USERS)))
        .addMethod(
            getGetTokenAuthUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetTokenAuthUserRequest,
                    com.google.cloud.memorystore.v1.TokenAuthUser>(
                    service, METHODID_GET_TOKEN_AUTH_USER)))
        .addMethod(
            getListAuthTokensMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.ListAuthTokensRequest,
                    com.google.cloud.memorystore.v1.ListAuthTokensResponse>(
                    service, METHODID_LIST_AUTH_TOKENS)))
        .addMethod(
            getGetAuthTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.GetAuthTokenRequest,
                    com.google.cloud.memorystore.v1.AuthToken>(service, METHODID_GET_AUTH_TOKEN)))
        .addMethod(
            getAddTokenAuthUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.AddTokenAuthUserRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_TOKEN_AUTH_USER)))
        .addMethod(
            getDeleteTokenAuthUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.DeleteTokenAuthUserRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TOKEN_AUTH_USER)))
        .addMethod(
            getAddAuthTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.AddAuthTokenRequest,
                    com.google.longrunning.Operation>(service, METHODID_ADD_AUTH_TOKEN)))
        .addMethod(
            getDeleteAuthTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.memorystore.v1.DeleteAuthTokenRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_AUTH_TOKEN)))
        .build();
  }

  private abstract static class MemorystoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MemorystoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.memorystore.v1.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Memorystore");
    }
  }

  private static final class MemorystoreFileDescriptorSupplier
      extends MemorystoreBaseDescriptorSupplier {
    MemorystoreFileDescriptorSupplier() {}
  }

  private static final class MemorystoreMethodDescriptorSupplier
      extends MemorystoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MemorystoreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MemorystoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MemorystoreFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getGetCertificateAuthorityMethod())
                      .addMethod(getGetSharedRegionalCertificateAuthorityMethod())
                      .addMethod(getRescheduleMaintenanceMethod())
                      .addMethod(getListBackupCollectionsMethod())
                      .addMethod(getGetBackupCollectionMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getExportBackupMethod())
                      .addMethod(getBackupInstanceMethod())
                      .addMethod(getStartMigrationMethod())
                      .addMethod(getFinishMigrationMethod())
                      .addMethod(getListTokenAuthUsersMethod())
                      .addMethod(getGetTokenAuthUserMethod())
                      .addMethod(getListAuthTokensMethod())
                      .addMethod(getGetAuthTokenMethod())
                      .addMethod(getAddTokenAuthUserMethod())
                      .addMethod(getDeleteTokenAuthUserMethod())
                      .addMethod(getAddAuthTokenMethod())
                      .addMethod(getDeleteAuthTokenMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
