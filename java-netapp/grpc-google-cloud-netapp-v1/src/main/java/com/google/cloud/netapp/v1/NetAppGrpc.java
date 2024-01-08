/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.netapp.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * NetApp Files Google Cloud Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/netapp/v1/cloud_netapp_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NetAppGrpc {

  private NetAppGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.netapp.v1.NetApp";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListStoragePoolsRequest,
          com.google.cloud.netapp.v1.ListStoragePoolsResponse>
      getListStoragePoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStoragePools",
      requestType = com.google.cloud.netapp.v1.ListStoragePoolsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListStoragePoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListStoragePoolsRequest,
          com.google.cloud.netapp.v1.ListStoragePoolsResponse>
      getListStoragePoolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListStoragePoolsRequest,
            com.google.cloud.netapp.v1.ListStoragePoolsResponse>
        getListStoragePoolsMethod;
    if ((getListStoragePoolsMethod = NetAppGrpc.getListStoragePoolsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListStoragePoolsMethod = NetAppGrpc.getListStoragePoolsMethod) == null) {
          NetAppGrpc.getListStoragePoolsMethod =
              getListStoragePoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListStoragePoolsRequest,
                          com.google.cloud.netapp.v1.ListStoragePoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStoragePools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListStoragePoolsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListStoragePoolsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListStoragePools"))
                      .build();
        }
      }
    }
    return getListStoragePoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateStoragePoolRequest, com.google.longrunning.Operation>
      getCreateStoragePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStoragePool",
      requestType = com.google.cloud.netapp.v1.CreateStoragePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateStoragePoolRequest, com.google.longrunning.Operation>
      getCreateStoragePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateStoragePoolRequest, com.google.longrunning.Operation>
        getCreateStoragePoolMethod;
    if ((getCreateStoragePoolMethod = NetAppGrpc.getCreateStoragePoolMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateStoragePoolMethod = NetAppGrpc.getCreateStoragePoolMethod) == null) {
          NetAppGrpc.getCreateStoragePoolMethod =
              getCreateStoragePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateStoragePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStoragePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateStoragePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateStoragePool"))
                      .build();
        }
      }
    }
    return getCreateStoragePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetStoragePoolRequest, com.google.cloud.netapp.v1.StoragePool>
      getGetStoragePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStoragePool",
      requestType = com.google.cloud.netapp.v1.GetStoragePoolRequest.class,
      responseType = com.google.cloud.netapp.v1.StoragePool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetStoragePoolRequest, com.google.cloud.netapp.v1.StoragePool>
      getGetStoragePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetStoragePoolRequest,
            com.google.cloud.netapp.v1.StoragePool>
        getGetStoragePoolMethod;
    if ((getGetStoragePoolMethod = NetAppGrpc.getGetStoragePoolMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetStoragePoolMethod = NetAppGrpc.getGetStoragePoolMethod) == null) {
          NetAppGrpc.getGetStoragePoolMethod =
              getGetStoragePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetStoragePoolRequest,
                          com.google.cloud.netapp.v1.StoragePool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStoragePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetStoragePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.StoragePool.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetStoragePool"))
                      .build();
        }
      }
    }
    return getGetStoragePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateStoragePoolRequest, com.google.longrunning.Operation>
      getUpdateStoragePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStoragePool",
      requestType = com.google.cloud.netapp.v1.UpdateStoragePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateStoragePoolRequest, com.google.longrunning.Operation>
      getUpdateStoragePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateStoragePoolRequest, com.google.longrunning.Operation>
        getUpdateStoragePoolMethod;
    if ((getUpdateStoragePoolMethod = NetAppGrpc.getUpdateStoragePoolMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateStoragePoolMethod = NetAppGrpc.getUpdateStoragePoolMethod) == null) {
          NetAppGrpc.getUpdateStoragePoolMethod =
              getUpdateStoragePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateStoragePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStoragePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateStoragePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateStoragePool"))
                      .build();
        }
      }
    }
    return getUpdateStoragePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteStoragePoolRequest, com.google.longrunning.Operation>
      getDeleteStoragePoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStoragePool",
      requestType = com.google.cloud.netapp.v1.DeleteStoragePoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteStoragePoolRequest, com.google.longrunning.Operation>
      getDeleteStoragePoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteStoragePoolRequest, com.google.longrunning.Operation>
        getDeleteStoragePoolMethod;
    if ((getDeleteStoragePoolMethod = NetAppGrpc.getDeleteStoragePoolMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteStoragePoolMethod = NetAppGrpc.getDeleteStoragePoolMethod) == null) {
          NetAppGrpc.getDeleteStoragePoolMethod =
              getDeleteStoragePoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteStoragePoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStoragePool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteStoragePoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteStoragePool"))
                      .build();
        }
      }
    }
    return getDeleteStoragePoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListVolumesRequest,
          com.google.cloud.netapp.v1.ListVolumesResponse>
      getListVolumesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVolumes",
      requestType = com.google.cloud.netapp.v1.ListVolumesRequest.class,
      responseType = com.google.cloud.netapp.v1.ListVolumesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListVolumesRequest,
          com.google.cloud.netapp.v1.ListVolumesResponse>
      getListVolumesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListVolumesRequest,
            com.google.cloud.netapp.v1.ListVolumesResponse>
        getListVolumesMethod;
    if ((getListVolumesMethod = NetAppGrpc.getListVolumesMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListVolumesMethod = NetAppGrpc.getListVolumesMethod) == null) {
          NetAppGrpc.getListVolumesMethod =
              getListVolumesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListVolumesRequest,
                          com.google.cloud.netapp.v1.ListVolumesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVolumes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListVolumesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListVolumesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListVolumes"))
                      .build();
        }
      }
    }
    return getListVolumesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetVolumeRequest, com.google.cloud.netapp.v1.Volume>
      getGetVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVolume",
      requestType = com.google.cloud.netapp.v1.GetVolumeRequest.class,
      responseType = com.google.cloud.netapp.v1.Volume.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetVolumeRequest, com.google.cloud.netapp.v1.Volume>
      getGetVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetVolumeRequest, com.google.cloud.netapp.v1.Volume>
        getGetVolumeMethod;
    if ((getGetVolumeMethod = NetAppGrpc.getGetVolumeMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetVolumeMethod = NetAppGrpc.getGetVolumeMethod) == null) {
          NetAppGrpc.getGetVolumeMethod =
              getGetVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetVolumeRequest,
                          com.google.cloud.netapp.v1.Volume>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetVolumeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.Volume.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetVolume"))
                      .build();
        }
      }
    }
    return getGetVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateVolumeRequest, com.google.longrunning.Operation>
      getCreateVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVolume",
      requestType = com.google.cloud.netapp.v1.CreateVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateVolumeRequest, com.google.longrunning.Operation>
      getCreateVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateVolumeRequest, com.google.longrunning.Operation>
        getCreateVolumeMethod;
    if ((getCreateVolumeMethod = NetAppGrpc.getCreateVolumeMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateVolumeMethod = NetAppGrpc.getCreateVolumeMethod) == null) {
          NetAppGrpc.getCreateVolumeMethod =
              getCreateVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateVolumeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateVolume"))
                      .build();
        }
      }
    }
    return getCreateVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateVolumeRequest, com.google.longrunning.Operation>
      getUpdateVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVolume",
      requestType = com.google.cloud.netapp.v1.UpdateVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateVolumeRequest, com.google.longrunning.Operation>
      getUpdateVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateVolumeRequest, com.google.longrunning.Operation>
        getUpdateVolumeMethod;
    if ((getUpdateVolumeMethod = NetAppGrpc.getUpdateVolumeMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateVolumeMethod = NetAppGrpc.getUpdateVolumeMethod) == null) {
          NetAppGrpc.getUpdateVolumeMethod =
              getUpdateVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateVolumeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateVolume"))
                      .build();
        }
      }
    }
    return getUpdateVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteVolumeRequest, com.google.longrunning.Operation>
      getDeleteVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVolume",
      requestType = com.google.cloud.netapp.v1.DeleteVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteVolumeRequest, com.google.longrunning.Operation>
      getDeleteVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteVolumeRequest, com.google.longrunning.Operation>
        getDeleteVolumeMethod;
    if ((getDeleteVolumeMethod = NetAppGrpc.getDeleteVolumeMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteVolumeMethod = NetAppGrpc.getDeleteVolumeMethod) == null) {
          NetAppGrpc.getDeleteVolumeMethod =
              getDeleteVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteVolumeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteVolume"))
                      .build();
        }
      }
    }
    return getDeleteVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.RevertVolumeRequest, com.google.longrunning.Operation>
      getRevertVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RevertVolume",
      requestType = com.google.cloud.netapp.v1.RevertVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.RevertVolumeRequest, com.google.longrunning.Operation>
      getRevertVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.RevertVolumeRequest, com.google.longrunning.Operation>
        getRevertVolumeMethod;
    if ((getRevertVolumeMethod = NetAppGrpc.getRevertVolumeMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getRevertVolumeMethod = NetAppGrpc.getRevertVolumeMethod) == null) {
          NetAppGrpc.getRevertVolumeMethod =
              getRevertVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.RevertVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RevertVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.RevertVolumeRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("RevertVolume"))
                      .build();
        }
      }
    }
    return getRevertVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListSnapshotsRequest,
          com.google.cloud.netapp.v1.ListSnapshotsResponse>
      getListSnapshotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSnapshots",
      requestType = com.google.cloud.netapp.v1.ListSnapshotsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListSnapshotsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListSnapshotsRequest,
          com.google.cloud.netapp.v1.ListSnapshotsResponse>
      getListSnapshotsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListSnapshotsRequest,
            com.google.cloud.netapp.v1.ListSnapshotsResponse>
        getListSnapshotsMethod;
    if ((getListSnapshotsMethod = NetAppGrpc.getListSnapshotsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListSnapshotsMethod = NetAppGrpc.getListSnapshotsMethod) == null) {
          NetAppGrpc.getListSnapshotsMethod =
              getListSnapshotsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListSnapshotsRequest,
                          com.google.cloud.netapp.v1.ListSnapshotsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSnapshots"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListSnapshotsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListSnapshotsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListSnapshots"))
                      .build();
        }
      }
    }
    return getListSnapshotsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetSnapshotRequest, com.google.cloud.netapp.v1.Snapshot>
      getGetSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSnapshot",
      requestType = com.google.cloud.netapp.v1.GetSnapshotRequest.class,
      responseType = com.google.cloud.netapp.v1.Snapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetSnapshotRequest, com.google.cloud.netapp.v1.Snapshot>
      getGetSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetSnapshotRequest, com.google.cloud.netapp.v1.Snapshot>
        getGetSnapshotMethod;
    if ((getGetSnapshotMethod = NetAppGrpc.getGetSnapshotMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetSnapshotMethod = NetAppGrpc.getGetSnapshotMethod) == null) {
          NetAppGrpc.getGetSnapshotMethod =
              getGetSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetSnapshotRequest,
                          com.google.cloud.netapp.v1.Snapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetSnapshotRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.Snapshot.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetSnapshot"))
                      .build();
        }
      }
    }
    return getGetSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateSnapshotRequest, com.google.longrunning.Operation>
      getCreateSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSnapshot",
      requestType = com.google.cloud.netapp.v1.CreateSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateSnapshotRequest, com.google.longrunning.Operation>
      getCreateSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateSnapshotRequest, com.google.longrunning.Operation>
        getCreateSnapshotMethod;
    if ((getCreateSnapshotMethod = NetAppGrpc.getCreateSnapshotMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateSnapshotMethod = NetAppGrpc.getCreateSnapshotMethod) == null) {
          NetAppGrpc.getCreateSnapshotMethod =
              getCreateSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateSnapshotRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateSnapshot"))
                      .build();
        }
      }
    }
    return getCreateSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteSnapshotRequest, com.google.longrunning.Operation>
      getDeleteSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSnapshot",
      requestType = com.google.cloud.netapp.v1.DeleteSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteSnapshotRequest, com.google.longrunning.Operation>
      getDeleteSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteSnapshotRequest, com.google.longrunning.Operation>
        getDeleteSnapshotMethod;
    if ((getDeleteSnapshotMethod = NetAppGrpc.getDeleteSnapshotMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteSnapshotMethod = NetAppGrpc.getDeleteSnapshotMethod) == null) {
          NetAppGrpc.getDeleteSnapshotMethod =
              getDeleteSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteSnapshotRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteSnapshot"))
                      .build();
        }
      }
    }
    return getDeleteSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateSnapshotRequest, com.google.longrunning.Operation>
      getUpdateSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSnapshot",
      requestType = com.google.cloud.netapp.v1.UpdateSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateSnapshotRequest, com.google.longrunning.Operation>
      getUpdateSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateSnapshotRequest, com.google.longrunning.Operation>
        getUpdateSnapshotMethod;
    if ((getUpdateSnapshotMethod = NetAppGrpc.getUpdateSnapshotMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateSnapshotMethod = NetAppGrpc.getUpdateSnapshotMethod) == null) {
          NetAppGrpc.getUpdateSnapshotMethod =
              getUpdateSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateSnapshotRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateSnapshot"))
                      .build();
        }
      }
    }
    return getUpdateSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListActiveDirectoriesRequest,
          com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
      getListActiveDirectoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListActiveDirectories",
      requestType = com.google.cloud.netapp.v1.ListActiveDirectoriesRequest.class,
      responseType = com.google.cloud.netapp.v1.ListActiveDirectoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListActiveDirectoriesRequest,
          com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
      getListActiveDirectoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListActiveDirectoriesRequest,
            com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
        getListActiveDirectoriesMethod;
    if ((getListActiveDirectoriesMethod = NetAppGrpc.getListActiveDirectoriesMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListActiveDirectoriesMethod = NetAppGrpc.getListActiveDirectoriesMethod) == null) {
          NetAppGrpc.getListActiveDirectoriesMethod =
              getListActiveDirectoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListActiveDirectoriesRequest,
                          com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListActiveDirectories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListActiveDirectoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListActiveDirectoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetAppMethodDescriptorSupplier("ListActiveDirectories"))
                      .build();
        }
      }
    }
    return getListActiveDirectoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetActiveDirectoryRequest,
          com.google.cloud.netapp.v1.ActiveDirectory>
      getGetActiveDirectoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetActiveDirectory",
      requestType = com.google.cloud.netapp.v1.GetActiveDirectoryRequest.class,
      responseType = com.google.cloud.netapp.v1.ActiveDirectory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetActiveDirectoryRequest,
          com.google.cloud.netapp.v1.ActiveDirectory>
      getGetActiveDirectoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetActiveDirectoryRequest,
            com.google.cloud.netapp.v1.ActiveDirectory>
        getGetActiveDirectoryMethod;
    if ((getGetActiveDirectoryMethod = NetAppGrpc.getGetActiveDirectoryMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetActiveDirectoryMethod = NetAppGrpc.getGetActiveDirectoryMethod) == null) {
          NetAppGrpc.getGetActiveDirectoryMethod =
              getGetActiveDirectoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetActiveDirectoryRequest,
                          com.google.cloud.netapp.v1.ActiveDirectory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetActiveDirectory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetActiveDirectoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ActiveDirectory.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetActiveDirectory"))
                      .build();
        }
      }
    }
    return getGetActiveDirectoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateActiveDirectoryRequest, com.google.longrunning.Operation>
      getCreateActiveDirectoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateActiveDirectory",
      requestType = com.google.cloud.netapp.v1.CreateActiveDirectoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateActiveDirectoryRequest, com.google.longrunning.Operation>
      getCreateActiveDirectoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateActiveDirectoryRequest,
            com.google.longrunning.Operation>
        getCreateActiveDirectoryMethod;
    if ((getCreateActiveDirectoryMethod = NetAppGrpc.getCreateActiveDirectoryMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateActiveDirectoryMethod = NetAppGrpc.getCreateActiveDirectoryMethod) == null) {
          NetAppGrpc.getCreateActiveDirectoryMethod =
              getCreateActiveDirectoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateActiveDirectoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateActiveDirectory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateActiveDirectoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetAppMethodDescriptorSupplier("CreateActiveDirectory"))
                      .build();
        }
      }
    }
    return getCreateActiveDirectoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest, com.google.longrunning.Operation>
      getUpdateActiveDirectoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateActiveDirectory",
      requestType = com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest, com.google.longrunning.Operation>
      getUpdateActiveDirectoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest,
            com.google.longrunning.Operation>
        getUpdateActiveDirectoryMethod;
    if ((getUpdateActiveDirectoryMethod = NetAppGrpc.getUpdateActiveDirectoryMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateActiveDirectoryMethod = NetAppGrpc.getUpdateActiveDirectoryMethod) == null) {
          NetAppGrpc.getUpdateActiveDirectoryMethod =
              getUpdateActiveDirectoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateActiveDirectory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetAppMethodDescriptorSupplier("UpdateActiveDirectory"))
                      .build();
        }
      }
    }
    return getUpdateActiveDirectoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest, com.google.longrunning.Operation>
      getDeleteActiveDirectoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteActiveDirectory",
      requestType = com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest, com.google.longrunning.Operation>
      getDeleteActiveDirectoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest,
            com.google.longrunning.Operation>
        getDeleteActiveDirectoryMethod;
    if ((getDeleteActiveDirectoryMethod = NetAppGrpc.getDeleteActiveDirectoryMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteActiveDirectoryMethod = NetAppGrpc.getDeleteActiveDirectoryMethod) == null) {
          NetAppGrpc.getDeleteActiveDirectoryMethod =
              getDeleteActiveDirectoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteActiveDirectory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetAppMethodDescriptorSupplier("DeleteActiveDirectory"))
                      .build();
        }
      }
    }
    return getDeleteActiveDirectoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListKmsConfigsRequest,
          com.google.cloud.netapp.v1.ListKmsConfigsResponse>
      getListKmsConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKmsConfigs",
      requestType = com.google.cloud.netapp.v1.ListKmsConfigsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListKmsConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListKmsConfigsRequest,
          com.google.cloud.netapp.v1.ListKmsConfigsResponse>
      getListKmsConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListKmsConfigsRequest,
            com.google.cloud.netapp.v1.ListKmsConfigsResponse>
        getListKmsConfigsMethod;
    if ((getListKmsConfigsMethod = NetAppGrpc.getListKmsConfigsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListKmsConfigsMethod = NetAppGrpc.getListKmsConfigsMethod) == null) {
          NetAppGrpc.getListKmsConfigsMethod =
              getListKmsConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListKmsConfigsRequest,
                          com.google.cloud.netapp.v1.ListKmsConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKmsConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListKmsConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListKmsConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListKmsConfigs"))
                      .build();
        }
      }
    }
    return getListKmsConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateKmsConfigRequest, com.google.longrunning.Operation>
      getCreateKmsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKmsConfig",
      requestType = com.google.cloud.netapp.v1.CreateKmsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateKmsConfigRequest, com.google.longrunning.Operation>
      getCreateKmsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateKmsConfigRequest, com.google.longrunning.Operation>
        getCreateKmsConfigMethod;
    if ((getCreateKmsConfigMethod = NetAppGrpc.getCreateKmsConfigMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateKmsConfigMethod = NetAppGrpc.getCreateKmsConfigMethod) == null) {
          NetAppGrpc.getCreateKmsConfigMethod =
              getCreateKmsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateKmsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKmsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateKmsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateKmsConfig"))
                      .build();
        }
      }
    }
    return getCreateKmsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetKmsConfigRequest, com.google.cloud.netapp.v1.KmsConfig>
      getGetKmsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKmsConfig",
      requestType = com.google.cloud.netapp.v1.GetKmsConfigRequest.class,
      responseType = com.google.cloud.netapp.v1.KmsConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetKmsConfigRequest, com.google.cloud.netapp.v1.KmsConfig>
      getGetKmsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetKmsConfigRequest, com.google.cloud.netapp.v1.KmsConfig>
        getGetKmsConfigMethod;
    if ((getGetKmsConfigMethod = NetAppGrpc.getGetKmsConfigMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetKmsConfigMethod = NetAppGrpc.getGetKmsConfigMethod) == null) {
          NetAppGrpc.getGetKmsConfigMethod =
              getGetKmsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetKmsConfigRequest,
                          com.google.cloud.netapp.v1.KmsConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKmsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetKmsConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.KmsConfig.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetKmsConfig"))
                      .build();
        }
      }
    }
    return getGetKmsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateKmsConfigRequest, com.google.longrunning.Operation>
      getUpdateKmsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKmsConfig",
      requestType = com.google.cloud.netapp.v1.UpdateKmsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateKmsConfigRequest, com.google.longrunning.Operation>
      getUpdateKmsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateKmsConfigRequest, com.google.longrunning.Operation>
        getUpdateKmsConfigMethod;
    if ((getUpdateKmsConfigMethod = NetAppGrpc.getUpdateKmsConfigMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateKmsConfigMethod = NetAppGrpc.getUpdateKmsConfigMethod) == null) {
          NetAppGrpc.getUpdateKmsConfigMethod =
              getUpdateKmsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateKmsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateKmsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateKmsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateKmsConfig"))
                      .build();
        }
      }
    }
    return getUpdateKmsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.EncryptVolumesRequest, com.google.longrunning.Operation>
      getEncryptVolumesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EncryptVolumes",
      requestType = com.google.cloud.netapp.v1.EncryptVolumesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.EncryptVolumesRequest, com.google.longrunning.Operation>
      getEncryptVolumesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.EncryptVolumesRequest, com.google.longrunning.Operation>
        getEncryptVolumesMethod;
    if ((getEncryptVolumesMethod = NetAppGrpc.getEncryptVolumesMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getEncryptVolumesMethod = NetAppGrpc.getEncryptVolumesMethod) == null) {
          NetAppGrpc.getEncryptVolumesMethod =
              getEncryptVolumesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.EncryptVolumesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EncryptVolumes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.EncryptVolumesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("EncryptVolumes"))
                      .build();
        }
      }
    }
    return getEncryptVolumesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.VerifyKmsConfigRequest,
          com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
      getVerifyKmsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyKmsConfig",
      requestType = com.google.cloud.netapp.v1.VerifyKmsConfigRequest.class,
      responseType = com.google.cloud.netapp.v1.VerifyKmsConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.VerifyKmsConfigRequest,
          com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
      getVerifyKmsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.VerifyKmsConfigRequest,
            com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
        getVerifyKmsConfigMethod;
    if ((getVerifyKmsConfigMethod = NetAppGrpc.getVerifyKmsConfigMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getVerifyKmsConfigMethod = NetAppGrpc.getVerifyKmsConfigMethod) == null) {
          NetAppGrpc.getVerifyKmsConfigMethod =
              getVerifyKmsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.VerifyKmsConfigRequest,
                          com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyKmsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.VerifyKmsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.VerifyKmsConfigResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("VerifyKmsConfig"))
                      .build();
        }
      }
    }
    return getVerifyKmsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteKmsConfigRequest, com.google.longrunning.Operation>
      getDeleteKmsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKmsConfig",
      requestType = com.google.cloud.netapp.v1.DeleteKmsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteKmsConfigRequest, com.google.longrunning.Operation>
      getDeleteKmsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteKmsConfigRequest, com.google.longrunning.Operation>
        getDeleteKmsConfigMethod;
    if ((getDeleteKmsConfigMethod = NetAppGrpc.getDeleteKmsConfigMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteKmsConfigMethod = NetAppGrpc.getDeleteKmsConfigMethod) == null) {
          NetAppGrpc.getDeleteKmsConfigMethod =
              getDeleteKmsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteKmsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteKmsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteKmsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteKmsConfig"))
                      .build();
        }
      }
    }
    return getDeleteKmsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListReplicationsRequest,
          com.google.cloud.netapp.v1.ListReplicationsResponse>
      getListReplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReplications",
      requestType = com.google.cloud.netapp.v1.ListReplicationsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListReplicationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListReplicationsRequest,
          com.google.cloud.netapp.v1.ListReplicationsResponse>
      getListReplicationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListReplicationsRequest,
            com.google.cloud.netapp.v1.ListReplicationsResponse>
        getListReplicationsMethod;
    if ((getListReplicationsMethod = NetAppGrpc.getListReplicationsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListReplicationsMethod = NetAppGrpc.getListReplicationsMethod) == null) {
          NetAppGrpc.getListReplicationsMethod =
              getListReplicationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListReplicationsRequest,
                          com.google.cloud.netapp.v1.ListReplicationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReplications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListReplicationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListReplicationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListReplications"))
                      .build();
        }
      }
    }
    return getListReplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetReplicationRequest, com.google.cloud.netapp.v1.Replication>
      getGetReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReplication",
      requestType = com.google.cloud.netapp.v1.GetReplicationRequest.class,
      responseType = com.google.cloud.netapp.v1.Replication.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetReplicationRequest, com.google.cloud.netapp.v1.Replication>
      getGetReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetReplicationRequest,
            com.google.cloud.netapp.v1.Replication>
        getGetReplicationMethod;
    if ((getGetReplicationMethod = NetAppGrpc.getGetReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetReplicationMethod = NetAppGrpc.getGetReplicationMethod) == null) {
          NetAppGrpc.getGetReplicationMethod =
              getGetReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetReplicationRequest,
                          com.google.cloud.netapp.v1.Replication>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.Replication.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetReplication"))
                      .build();
        }
      }
    }
    return getGetReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateReplicationRequest, com.google.longrunning.Operation>
      getCreateReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReplication",
      requestType = com.google.cloud.netapp.v1.CreateReplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateReplicationRequest, com.google.longrunning.Operation>
      getCreateReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateReplicationRequest, com.google.longrunning.Operation>
        getCreateReplicationMethod;
    if ((getCreateReplicationMethod = NetAppGrpc.getCreateReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateReplicationMethod = NetAppGrpc.getCreateReplicationMethod) == null) {
          NetAppGrpc.getCreateReplicationMethod =
              getCreateReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateReplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateReplication"))
                      .build();
        }
      }
    }
    return getCreateReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteReplicationRequest, com.google.longrunning.Operation>
      getDeleteReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReplication",
      requestType = com.google.cloud.netapp.v1.DeleteReplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteReplicationRequest, com.google.longrunning.Operation>
      getDeleteReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteReplicationRequest, com.google.longrunning.Operation>
        getDeleteReplicationMethod;
    if ((getDeleteReplicationMethod = NetAppGrpc.getDeleteReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteReplicationMethod = NetAppGrpc.getDeleteReplicationMethod) == null) {
          NetAppGrpc.getDeleteReplicationMethod =
              getDeleteReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteReplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteReplication"))
                      .build();
        }
      }
    }
    return getDeleteReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateReplicationRequest, com.google.longrunning.Operation>
      getUpdateReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateReplication",
      requestType = com.google.cloud.netapp.v1.UpdateReplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateReplicationRequest, com.google.longrunning.Operation>
      getUpdateReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateReplicationRequest, com.google.longrunning.Operation>
        getUpdateReplicationMethod;
    if ((getUpdateReplicationMethod = NetAppGrpc.getUpdateReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateReplicationMethod = NetAppGrpc.getUpdateReplicationMethod) == null) {
          NetAppGrpc.getUpdateReplicationMethod =
              getUpdateReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateReplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateReplication"))
                      .build();
        }
      }
    }
    return getUpdateReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.StopReplicationRequest, com.google.longrunning.Operation>
      getStopReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopReplication",
      requestType = com.google.cloud.netapp.v1.StopReplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.StopReplicationRequest, com.google.longrunning.Operation>
      getStopReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.StopReplicationRequest, com.google.longrunning.Operation>
        getStopReplicationMethod;
    if ((getStopReplicationMethod = NetAppGrpc.getStopReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getStopReplicationMethod = NetAppGrpc.getStopReplicationMethod) == null) {
          NetAppGrpc.getStopReplicationMethod =
              getStopReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.StopReplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.StopReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("StopReplication"))
                      .build();
        }
      }
    }
    return getStopReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ResumeReplicationRequest, com.google.longrunning.Operation>
      getResumeReplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeReplication",
      requestType = com.google.cloud.netapp.v1.ResumeReplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ResumeReplicationRequest, com.google.longrunning.Operation>
      getResumeReplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ResumeReplicationRequest, com.google.longrunning.Operation>
        getResumeReplicationMethod;
    if ((getResumeReplicationMethod = NetAppGrpc.getResumeReplicationMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getResumeReplicationMethod = NetAppGrpc.getResumeReplicationMethod) == null) {
          NetAppGrpc.getResumeReplicationMethod =
              getResumeReplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ResumeReplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeReplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ResumeReplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ResumeReplication"))
                      .build();
        }
      }
    }
    return getResumeReplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest,
          com.google.longrunning.Operation>
      getReverseReplicationDirectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReverseReplicationDirection",
      requestType = com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest,
          com.google.longrunning.Operation>
      getReverseReplicationDirectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest,
            com.google.longrunning.Operation>
        getReverseReplicationDirectionMethod;
    if ((getReverseReplicationDirectionMethod = NetAppGrpc.getReverseReplicationDirectionMethod)
        == null) {
      synchronized (NetAppGrpc.class) {
        if ((getReverseReplicationDirectionMethod = NetAppGrpc.getReverseReplicationDirectionMethod)
            == null) {
          NetAppGrpc.getReverseReplicationDirectionMethod =
              getReverseReplicationDirectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReverseReplicationDirection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetAppMethodDescriptorSupplier("ReverseReplicationDirection"))
                      .build();
        }
      }
    }
    return getReverseReplicationDirectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
      getCreateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupVault",
      requestType = com.google.cloud.netapp.v1.CreateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
      getCreateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateBackupVaultRequest, com.google.longrunning.Operation>
        getCreateBackupVaultMethod;
    if ((getCreateBackupVaultMethod = NetAppGrpc.getCreateBackupVaultMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateBackupVaultMethod = NetAppGrpc.getCreateBackupVaultMethod) == null) {
          NetAppGrpc.getCreateBackupVaultMethod =
              getCreateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateBackupVault"))
                      .build();
        }
      }
    }
    return getCreateBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupVaultRequest, com.google.cloud.netapp.v1.BackupVault>
      getGetBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupVault",
      requestType = com.google.cloud.netapp.v1.GetBackupVaultRequest.class,
      responseType = com.google.cloud.netapp.v1.BackupVault.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupVaultRequest, com.google.cloud.netapp.v1.BackupVault>
      getGetBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetBackupVaultRequest,
            com.google.cloud.netapp.v1.BackupVault>
        getGetBackupVaultMethod;
    if ((getGetBackupVaultMethod = NetAppGrpc.getGetBackupVaultMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetBackupVaultMethod = NetAppGrpc.getGetBackupVaultMethod) == null) {
          NetAppGrpc.getGetBackupVaultMethod =
              getGetBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetBackupVaultRequest,
                          com.google.cloud.netapp.v1.BackupVault>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.BackupVault.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetBackupVault"))
                      .build();
        }
      }
    }
    return getGetBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupVaultsRequest,
          com.google.cloud.netapp.v1.ListBackupVaultsResponse>
      getListBackupVaultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupVaults",
      requestType = com.google.cloud.netapp.v1.ListBackupVaultsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListBackupVaultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupVaultsRequest,
          com.google.cloud.netapp.v1.ListBackupVaultsResponse>
      getListBackupVaultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListBackupVaultsRequest,
            com.google.cloud.netapp.v1.ListBackupVaultsResponse>
        getListBackupVaultsMethod;
    if ((getListBackupVaultsMethod = NetAppGrpc.getListBackupVaultsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListBackupVaultsMethod = NetAppGrpc.getListBackupVaultsMethod) == null) {
          NetAppGrpc.getListBackupVaultsMethod =
              getListBackupVaultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListBackupVaultsRequest,
                          com.google.cloud.netapp.v1.ListBackupVaultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupVaults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupVaultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupVaultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListBackupVaults"))
                      .build();
        }
      }
    }
    return getListBackupVaultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
      getUpdateBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupVault",
      requestType = com.google.cloud.netapp.v1.UpdateBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
      getUpdateBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateBackupVaultRequest, com.google.longrunning.Operation>
        getUpdateBackupVaultMethod;
    if ((getUpdateBackupVaultMethod = NetAppGrpc.getUpdateBackupVaultMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateBackupVaultMethod = NetAppGrpc.getUpdateBackupVaultMethod) == null) {
          NetAppGrpc.getUpdateBackupVaultMethod =
              getUpdateBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateBackupVault"))
                      .build();
        }
      }
    }
    return getUpdateBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
      getDeleteBackupVaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupVault",
      requestType = com.google.cloud.netapp.v1.DeleteBackupVaultRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
      getDeleteBackupVaultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteBackupVaultRequest, com.google.longrunning.Operation>
        getDeleteBackupVaultMethod;
    if ((getDeleteBackupVaultMethod = NetAppGrpc.getDeleteBackupVaultMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteBackupVaultMethod = NetAppGrpc.getDeleteBackupVaultMethod) == null) {
          NetAppGrpc.getDeleteBackupVaultMethod =
              getDeleteBackupVaultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteBackupVaultRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupVault"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteBackupVaultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteBackupVault"))
                      .build();
        }
      }
    }
    return getDeleteBackupVaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackup",
      requestType = com.google.cloud.netapp.v1.CreateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupRequest, com.google.longrunning.Operation>
      getCreateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateBackupRequest, com.google.longrunning.Operation>
        getCreateBackupMethod;
    if ((getCreateBackupMethod = NetAppGrpc.getCreateBackupMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateBackupMethod = NetAppGrpc.getCreateBackupMethod) == null) {
          NetAppGrpc.getCreateBackupMethod =
              getCreateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateBackup"))
                      .build();
        }
      }
    }
    return getCreateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupRequest, com.google.cloud.netapp.v1.Backup>
      getGetBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackup",
      requestType = com.google.cloud.netapp.v1.GetBackupRequest.class,
      responseType = com.google.cloud.netapp.v1.Backup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupRequest, com.google.cloud.netapp.v1.Backup>
      getGetBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetBackupRequest, com.google.cloud.netapp.v1.Backup>
        getGetBackupMethod;
    if ((getGetBackupMethod = NetAppGrpc.getGetBackupMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetBackupMethod = NetAppGrpc.getGetBackupMethod) == null) {
          NetAppGrpc.getGetBackupMethod =
              getGetBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetBackupRequest,
                          com.google.cloud.netapp.v1.Backup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.Backup.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetBackup"))
                      .build();
        }
      }
    }
    return getGetBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupsRequest,
          com.google.cloud.netapp.v1.ListBackupsResponse>
      getListBackupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackups",
      requestType = com.google.cloud.netapp.v1.ListBackupsRequest.class,
      responseType = com.google.cloud.netapp.v1.ListBackupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupsRequest,
          com.google.cloud.netapp.v1.ListBackupsResponse>
      getListBackupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListBackupsRequest,
            com.google.cloud.netapp.v1.ListBackupsResponse>
        getListBackupsMethod;
    if ((getListBackupsMethod = NetAppGrpc.getListBackupsMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListBackupsMethod = NetAppGrpc.getListBackupsMethod) == null) {
          NetAppGrpc.getListBackupsMethod =
              getListBackupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListBackupsRequest,
                          com.google.cloud.netapp.v1.ListBackupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListBackups"))
                      .build();
        }
      }
    }
    return getListBackupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackup",
      requestType = com.google.cloud.netapp.v1.DeleteBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupRequest, com.google.longrunning.Operation>
      getDeleteBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteBackupRequest, com.google.longrunning.Operation>
        getDeleteBackupMethod;
    if ((getDeleteBackupMethod = NetAppGrpc.getDeleteBackupMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteBackupMethod = NetAppGrpc.getDeleteBackupMethod) == null) {
          NetAppGrpc.getDeleteBackupMethod =
              getDeleteBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteBackup"))
                      .build();
        }
      }
    }
    return getDeleteBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackup",
      requestType = com.google.cloud.netapp.v1.UpdateBackupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupRequest, com.google.longrunning.Operation>
      getUpdateBackupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateBackupRequest, com.google.longrunning.Operation>
        getUpdateBackupMethod;
    if ((getUpdateBackupMethod = NetAppGrpc.getUpdateBackupMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateBackupMethod = NetAppGrpc.getUpdateBackupMethod) == null) {
          NetAppGrpc.getUpdateBackupMethod =
              getUpdateBackupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateBackupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateBackupRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateBackup"))
                      .build();
        }
      }
    }
    return getUpdateBackupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupPolicyRequest, com.google.longrunning.Operation>
      getCreateBackupPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackupPolicy",
      requestType = com.google.cloud.netapp.v1.CreateBackupPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.CreateBackupPolicyRequest, com.google.longrunning.Operation>
      getCreateBackupPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.CreateBackupPolicyRequest, com.google.longrunning.Operation>
        getCreateBackupPolicyMethod;
    if ((getCreateBackupPolicyMethod = NetAppGrpc.getCreateBackupPolicyMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getCreateBackupPolicyMethod = NetAppGrpc.getCreateBackupPolicyMethod) == null) {
          NetAppGrpc.getCreateBackupPolicyMethod =
              getCreateBackupPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.CreateBackupPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackupPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.CreateBackupPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("CreateBackupPolicy"))
                      .build();
        }
      }
    }
    return getCreateBackupPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupPolicyRequest,
          com.google.cloud.netapp.v1.BackupPolicy>
      getGetBackupPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBackupPolicy",
      requestType = com.google.cloud.netapp.v1.GetBackupPolicyRequest.class,
      responseType = com.google.cloud.netapp.v1.BackupPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.GetBackupPolicyRequest,
          com.google.cloud.netapp.v1.BackupPolicy>
      getGetBackupPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.GetBackupPolicyRequest,
            com.google.cloud.netapp.v1.BackupPolicy>
        getGetBackupPolicyMethod;
    if ((getGetBackupPolicyMethod = NetAppGrpc.getGetBackupPolicyMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getGetBackupPolicyMethod = NetAppGrpc.getGetBackupPolicyMethod) == null) {
          NetAppGrpc.getGetBackupPolicyMethod =
              getGetBackupPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.GetBackupPolicyRequest,
                          com.google.cloud.netapp.v1.BackupPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBackupPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.GetBackupPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.BackupPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("GetBackupPolicy"))
                      .build();
        }
      }
    }
    return getGetBackupPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupPoliciesRequest,
          com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
      getListBackupPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBackupPolicies",
      requestType = com.google.cloud.netapp.v1.ListBackupPoliciesRequest.class,
      responseType = com.google.cloud.netapp.v1.ListBackupPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.ListBackupPoliciesRequest,
          com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
      getListBackupPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.ListBackupPoliciesRequest,
            com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
        getListBackupPoliciesMethod;
    if ((getListBackupPoliciesMethod = NetAppGrpc.getListBackupPoliciesMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getListBackupPoliciesMethod = NetAppGrpc.getListBackupPoliciesMethod) == null) {
          NetAppGrpc.getListBackupPoliciesMethod =
              getListBackupPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.ListBackupPoliciesRequest,
                          com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBackupPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.ListBackupPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("ListBackupPolicies"))
                      .build();
        }
      }
    }
    return getListBackupPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupPolicyRequest, com.google.longrunning.Operation>
      getUpdateBackupPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBackupPolicy",
      requestType = com.google.cloud.netapp.v1.UpdateBackupPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.UpdateBackupPolicyRequest, com.google.longrunning.Operation>
      getUpdateBackupPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.UpdateBackupPolicyRequest, com.google.longrunning.Operation>
        getUpdateBackupPolicyMethod;
    if ((getUpdateBackupPolicyMethod = NetAppGrpc.getUpdateBackupPolicyMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getUpdateBackupPolicyMethod = NetAppGrpc.getUpdateBackupPolicyMethod) == null) {
          NetAppGrpc.getUpdateBackupPolicyMethod =
              getUpdateBackupPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.UpdateBackupPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBackupPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.UpdateBackupPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("UpdateBackupPolicy"))
                      .build();
        }
      }
    }
    return getUpdateBackupPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupPolicyRequest, com.google.longrunning.Operation>
      getDeleteBackupPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBackupPolicy",
      requestType = com.google.cloud.netapp.v1.DeleteBackupPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.netapp.v1.DeleteBackupPolicyRequest, com.google.longrunning.Operation>
      getDeleteBackupPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.netapp.v1.DeleteBackupPolicyRequest, com.google.longrunning.Operation>
        getDeleteBackupPolicyMethod;
    if ((getDeleteBackupPolicyMethod = NetAppGrpc.getDeleteBackupPolicyMethod) == null) {
      synchronized (NetAppGrpc.class) {
        if ((getDeleteBackupPolicyMethod = NetAppGrpc.getDeleteBackupPolicyMethod) == null) {
          NetAppGrpc.getDeleteBackupPolicyMethod =
              getDeleteBackupPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.netapp.v1.DeleteBackupPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBackupPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.netapp.v1.DeleteBackupPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new NetAppMethodDescriptorSupplier("DeleteBackupPolicy"))
                      .build();
        }
      }
    }
    return getDeleteBackupPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NetAppStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetAppStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetAppStub>() {
          @java.lang.Override
          public NetAppStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetAppStub(channel, callOptions);
          }
        };
    return NetAppStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetAppBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetAppBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetAppBlockingStub>() {
          @java.lang.Override
          public NetAppBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetAppBlockingStub(channel, callOptions);
          }
        };
    return NetAppBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NetAppFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetAppFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetAppFutureStub>() {
          @java.lang.Override
          public NetAppFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetAppFutureStub(channel, callOptions);
          }
        };
    return NetAppFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * NetApp Files Google Cloud Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns descriptions of all storage pools owned by the caller.
     * </pre>
     */
    default void listStoragePools(
        com.google.cloud.netapp.v1.ListStoragePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListStoragePoolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStoragePoolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new storage pool.
     * </pre>
     */
    default void createStoragePool(
        com.google.cloud.netapp.v1.CreateStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStoragePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified storage pool by poolId.
     * </pre>
     */
    default void getStoragePool(
        com.google.cloud.netapp.v1.GetStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.StoragePool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStoragePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the storage pool properties with the full spec
     * </pre>
     */
    default void updateStoragePool(
        com.google.cloud.netapp.v1.UpdateStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateStoragePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the storage pool.
     * </pre>
     */
    default void deleteStoragePool(
        com.google.cloud.netapp.v1.DeleteStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteStoragePoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Volumes in a given project.
     * </pre>
     */
    default void listVolumes(
        com.google.cloud.netapp.v1.ListVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListVolumesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVolumesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Volume.
     * </pre>
     */
    default void getVolume(
        com.google.cloud.netapp.v1.GetVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Volume> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Volume in a given project and location.
     * </pre>
     */
    default void createVolume(
        com.google.cloud.netapp.v1.CreateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Volume.
     * </pre>
     */
    default void updateVolume(
        com.google.cloud.netapp.v1.UpdateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Volume.
     * </pre>
     */
    default void deleteVolume(
        com.google.cloud.netapp.v1.DeleteVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revert an existing volume to a specified snapshot.
     * Warning! This operation will permanently revert all changes made after the
     * snapshot was created.
     * </pre>
     */
    default void revertVolume(
        com.google.cloud.netapp.v1.RevertVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRevertVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all snapshots for a volume.
     * </pre>
     */
    default void listSnapshots(
        com.google.cloud.netapp.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSnapshotsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describe a snapshot for a volume.
     * </pre>
     */
    default void getSnapshot(
        com.google.cloud.netapp.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Snapshot> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new snapshot for a volume.
     * </pre>
     */
    default void createSnapshot(
        com.google.cloud.netapp.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    default void deleteSnapshot(
        com.google.cloud.netapp.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific snapshot.
     * </pre>
     */
    default void updateSnapshot(
        com.google.cloud.netapp.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists active directories.
     * </pre>
     */
    default void listActiveDirectories(
        com.google.cloud.netapp.v1.ListActiveDirectoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListActiveDirectoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specified active directory.
     * </pre>
     */
    default void getActiveDirectory(
        com.google.cloud.netapp.v1.GetActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ActiveDirectory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetActiveDirectoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateActiveDirectory
     * Creates the active directory specified in the request.
     * </pre>
     */
    default void createActiveDirectory(
        com.google.cloud.netapp.v1.CreateActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateActiveDirectoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the parameters of an active directories.
     * </pre>
     */
    default void updateActiveDirectory(
        com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateActiveDirectoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the active directory specified in the request.
     * </pre>
     */
    default void deleteActiveDirectory(
        com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteActiveDirectoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all KMS configs owned by the caller.
     * </pre>
     */
    default void listKmsConfigs(
        com.google.cloud.netapp.v1.ListKmsConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListKmsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListKmsConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new KMS config.
     * </pre>
     */
    default void createKmsConfig(
        com.google.cloud.netapp.v1.CreateKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateKmsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified KMS config by kms_config_id.
     * </pre>
     */
    default void getKmsConfig(
        com.google.cloud.netapp.v1.GetKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.KmsConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetKmsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Kms config properties with the full spec
     * </pre>
     */
    default void updateKmsConfig(
        com.google.cloud.netapp.v1.UpdateKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateKmsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Encrypt the existing volumes without CMEK encryption with the desired the
     * KMS config for the whole region.
     * </pre>
     */
    default void encryptVolumes(
        com.google.cloud.netapp.v1.EncryptVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEncryptVolumesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verifies KMS config reachability.
     * </pre>
     */
    default void verifyKmsConfig(
        com.google.cloud.netapp.v1.VerifyKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getVerifyKmsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the Kms config.
     * </pre>
     */
    default void deleteKmsConfig(
        com.google.cloud.netapp.v1.DeleteKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteKmsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all replications for a volume.
     * </pre>
     */
    default void listReplications(
        com.google.cloud.netapp.v1.ListReplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListReplicationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReplicationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describe a replication for a volume.
     * </pre>
     */
    default void getReplication(
        com.google.cloud.netapp.v1.GetReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Replication> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new replication for a volume.
     * </pre>
     */
    default void createReplication(
        com.google.cloud.netapp.v1.CreateReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a replication.
     * </pre>
     */
    default void deleteReplication(
        com.google.cloud.netapp.v1.DeleteReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific replication.
     * </pre>
     */
    default void updateReplication(
        com.google.cloud.netapp.v1.UpdateReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stop Cross Region Replication.
     * </pre>
     */
    default void stopReplication(
        com.google.cloud.netapp.v1.StopReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume Cross Region Replication.
     * </pre>
     */
    default void resumeReplication(
        com.google.cloud.netapp.v1.ResumeReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeReplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reverses direction of replication. Source becomes destination and
     * destination becomes source.
     * </pre>
     */
    default void reverseReplicationDirection(
        com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReverseReplicationDirectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup vault
     * </pre>
     */
    default void createBackupVault(
        com.google.cloud.netapp.v1.CreateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup vault
     * </pre>
     */
    default void getBackupVault(
        com.google.cloud.netapp.v1.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupVault> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup vaults.
     * </pre>
     */
    default void listBackupVaults(
        com.google.cloud.netapp.v1.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupVaultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific backup vault.
     * </pre>
     */
    default void updateBackupVault(
        com.google.cloud.netapp.v1.UpdateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup vault.
     * </pre>
     */
    default void deleteBackupVault(
        com.google.cloud.netapp.v1.DeleteBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupVaultMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup from the volume specified in the request
     * The backup can be created from the given snapshot if specified in the
     * request. If no snapshot specified, there'll be a new snapshot taken to
     * initiate the backup creation.
     * </pre>
     */
    default void createBackup(
        com.google.cloud.netapp.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup
     * </pre>
     */
    default void getBackup(
        com.google.cloud.netapp.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Backup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all backups for a backupVault.
     * </pre>
     */
    default void listBackups(
        com.google.cloud.netapp.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup.
     * </pre>
     */
    default void deleteBackup(
        com.google.cloud.netapp.v1.DeleteBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update backup with full spec.
     * </pre>
     */
    default void updateBackup(
        com.google.cloud.netapp.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup policy
     * </pre>
     */
    default void createBackupPolicy(
        com.google.cloud.netapp.v1.CreateBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBackupPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup policy by backup_policy_id.
     * </pre>
     */
    default void getBackupPolicy(
        com.google.cloud.netapp.v1.GetBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBackupPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup policies.
     * </pre>
     */
    default void listBackupPolicies(
        com.google.cloud.netapp.v1.ListBackupPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBackupPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a specific backup policy.
     * </pre>
     */
    default void updateBackupPolicy(
        com.google.cloud.netapp.v1.UpdateBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBackupPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup policy.
     * </pre>
     */
    default void deleteBackupPolicy(
        com.google.cloud.netapp.v1.DeleteBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBackupPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NetApp.
   *
   * <pre>
   * NetApp Files Google Cloud Service
   * </pre>
   */
  public abstract static class NetAppImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NetAppGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NetApp.
   *
   * <pre>
   * NetApp Files Google Cloud Service
   * </pre>
   */
  public static final class NetAppStub extends io.grpc.stub.AbstractAsyncStub<NetAppStub> {
    private NetAppStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetAppStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetAppStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all storage pools owned by the caller.
     * </pre>
     */
    public void listStoragePools(
        com.google.cloud.netapp.v1.ListStoragePoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListStoragePoolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStoragePoolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new storage pool.
     * </pre>
     */
    public void createStoragePool(
        com.google.cloud.netapp.v1.CreateStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStoragePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified storage pool by poolId.
     * </pre>
     */
    public void getStoragePool(
        com.google.cloud.netapp.v1.GetStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.StoragePool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStoragePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the storage pool properties with the full spec
     * </pre>
     */
    public void updateStoragePool(
        com.google.cloud.netapp.v1.UpdateStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStoragePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the storage pool.
     * </pre>
     */
    public void deleteStoragePool(
        com.google.cloud.netapp.v1.DeleteStoragePoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStoragePoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Volumes in a given project.
     * </pre>
     */
    public void listVolumes(
        com.google.cloud.netapp.v1.ListVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListVolumesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVolumesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Volume.
     * </pre>
     */
    public void getVolume(
        com.google.cloud.netapp.v1.GetVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Volume> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVolumeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Volume in a given project and location.
     * </pre>
     */
    public void createVolume(
        com.google.cloud.netapp.v1.CreateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Volume.
     * </pre>
     */
    public void updateVolume(
        com.google.cloud.netapp.v1.UpdateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Volume.
     * </pre>
     */
    public void deleteVolume(
        com.google.cloud.netapp.v1.DeleteVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Revert an existing volume to a specified snapshot.
     * Warning! This operation will permanently revert all changes made after the
     * snapshot was created.
     * </pre>
     */
    public void revertVolume(
        com.google.cloud.netapp.v1.RevertVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRevertVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all snapshots for a volume.
     * </pre>
     */
    public void listSnapshots(
        com.google.cloud.netapp.v1.ListSnapshotsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describe a snapshot for a volume.
     * </pre>
     */
    public void getSnapshot(
        com.google.cloud.netapp.v1.GetSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Snapshot> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new snapshot for a volume.
     * </pre>
     */
    public void createSnapshot(
        com.google.cloud.netapp.v1.CreateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public void deleteSnapshot(
        com.google.cloud.netapp.v1.DeleteSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific snapshot.
     * </pre>
     */
    public void updateSnapshot(
        com.google.cloud.netapp.v1.UpdateSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists active directories.
     * </pre>
     */
    public void listActiveDirectories(
        com.google.cloud.netapp.v1.ListActiveDirectoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListActiveDirectoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specified active directory.
     * </pre>
     */
    public void getActiveDirectory(
        com.google.cloud.netapp.v1.GetActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ActiveDirectory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetActiveDirectoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateActiveDirectory
     * Creates the active directory specified in the request.
     * </pre>
     */
    public void createActiveDirectory(
        com.google.cloud.netapp.v1.CreateActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateActiveDirectoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the parameters of an active directories.
     * </pre>
     */
    public void updateActiveDirectory(
        com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateActiveDirectoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the active directory specified in the request.
     * </pre>
     */
    public void deleteActiveDirectory(
        com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteActiveDirectoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all KMS configs owned by the caller.
     * </pre>
     */
    public void listKmsConfigs(
        com.google.cloud.netapp.v1.ListKmsConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListKmsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKmsConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new KMS config.
     * </pre>
     */
    public void createKmsConfig(
        com.google.cloud.netapp.v1.CreateKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKmsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified KMS config by kms_config_id.
     * </pre>
     */
    public void getKmsConfig(
        com.google.cloud.netapp.v1.GetKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.KmsConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKmsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Kms config properties with the full spec
     * </pre>
     */
    public void updateKmsConfig(
        com.google.cloud.netapp.v1.UpdateKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateKmsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Encrypt the existing volumes without CMEK encryption with the desired the
     * KMS config for the whole region.
     * </pre>
     */
    public void encryptVolumes(
        com.google.cloud.netapp.v1.EncryptVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEncryptVolumesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verifies KMS config reachability.
     * </pre>
     */
    public void verifyKmsConfig(
        com.google.cloud.netapp.v1.VerifyKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyKmsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the Kms config.
     * </pre>
     */
    public void deleteKmsConfig(
        com.google.cloud.netapp.v1.DeleteKmsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteKmsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all replications for a volume.
     * </pre>
     */
    public void listReplications(
        com.google.cloud.netapp.v1.ListReplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListReplicationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReplicationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describe a replication for a volume.
     * </pre>
     */
    public void getReplication(
        com.google.cloud.netapp.v1.GetReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Replication> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new replication for a volume.
     * </pre>
     */
    public void createReplication(
        com.google.cloud.netapp.v1.CreateReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a replication.
     * </pre>
     */
    public void deleteReplication(
        com.google.cloud.netapp.v1.DeleteReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific replication.
     * </pre>
     */
    public void updateReplication(
        com.google.cloud.netapp.v1.UpdateReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stop Cross Region Replication.
     * </pre>
     */
    public void stopReplication(
        com.google.cloud.netapp.v1.StopReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume Cross Region Replication.
     * </pre>
     */
    public void resumeReplication(
        com.google.cloud.netapp.v1.ResumeReplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeReplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reverses direction of replication. Source becomes destination and
     * destination becomes source.
     * </pre>
     */
    public void reverseReplicationDirection(
        com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReverseReplicationDirectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup vault
     * </pre>
     */
    public void createBackupVault(
        com.google.cloud.netapp.v1.CreateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup vault
     * </pre>
     */
    public void getBackupVault(
        com.google.cloud.netapp.v1.GetBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupVault> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup vaults.
     * </pre>
     */
    public void listBackupVaults(
        com.google.cloud.netapp.v1.ListBackupVaultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupVaultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupVaultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific backup vault.
     * </pre>
     */
    public void updateBackupVault(
        com.google.cloud.netapp.v1.UpdateBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup vault.
     * </pre>
     */
    public void deleteBackupVault(
        com.google.cloud.netapp.v1.DeleteBackupVaultRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupVaultMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup from the volume specified in the request
     * The backup can be created from the given snapshot if specified in the
     * request. If no snapshot specified, there'll be a new snapshot taken to
     * initiate the backup creation.
     * </pre>
     */
    public void createBackup(
        com.google.cloud.netapp.v1.CreateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup
     * </pre>
     */
    public void getBackup(
        com.google.cloud.netapp.v1.GetBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Backup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all backups for a backupVault.
     * </pre>
     */
    public void listBackups(
        com.google.cloud.netapp.v1.ListBackupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupsResponse>
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
     * Warning! This operation will permanently delete the backup.
     * </pre>
     */
    public void deleteBackup(
        com.google.cloud.netapp.v1.DeleteBackupRequest request,
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
     * Update backup with full spec.
     * </pre>
     */
    public void updateBackup(
        com.google.cloud.netapp.v1.UpdateBackupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup policy
     * </pre>
     */
    public void createBackupPolicy(
        com.google.cloud.netapp.v1.CreateBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackupPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup policy by backup_policy_id.
     * </pre>
     */
    public void getBackupPolicy(
        com.google.cloud.netapp.v1.GetBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBackupPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup policies.
     * </pre>
     */
    public void listBackupPolicies(
        com.google.cloud.netapp.v1.ListBackupPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBackupPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a specific backup policy.
     * </pre>
     */
    public void updateBackupPolicy(
        com.google.cloud.netapp.v1.UpdateBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBackupPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup policy.
     * </pre>
     */
    public void deleteBackupPolicy(
        com.google.cloud.netapp.v1.DeleteBackupPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBackupPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NetApp.
   *
   * <pre>
   * NetApp Files Google Cloud Service
   * </pre>
   */
  public static final class NetAppBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NetAppBlockingStub> {
    private NetAppBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetAppBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetAppBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all storage pools owned by the caller.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListStoragePoolsResponse listStoragePools(
        com.google.cloud.netapp.v1.ListStoragePoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStoragePoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new storage pool.
     * </pre>
     */
    public com.google.longrunning.Operation createStoragePool(
        com.google.cloud.netapp.v1.CreateStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStoragePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified storage pool by poolId.
     * </pre>
     */
    public com.google.cloud.netapp.v1.StoragePool getStoragePool(
        com.google.cloud.netapp.v1.GetStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStoragePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the storage pool properties with the full spec
     * </pre>
     */
    public com.google.longrunning.Operation updateStoragePool(
        com.google.cloud.netapp.v1.UpdateStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStoragePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the storage pool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteStoragePool(
        com.google.cloud.netapp.v1.DeleteStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStoragePoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Volumes in a given project.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListVolumesResponse listVolumes(
        com.google.cloud.netapp.v1.ListVolumesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVolumesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Volume.
     * </pre>
     */
    public com.google.cloud.netapp.v1.Volume getVolume(
        com.google.cloud.netapp.v1.GetVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Volume in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createVolume(
        com.google.cloud.netapp.v1.CreateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Volume.
     * </pre>
     */
    public com.google.longrunning.Operation updateVolume(
        com.google.cloud.netapp.v1.UpdateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Volume.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVolume(
        com.google.cloud.netapp.v1.DeleteVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Revert an existing volume to a specified snapshot.
     * Warning! This operation will permanently revert all changes made after the
     * snapshot was created.
     * </pre>
     */
    public com.google.longrunning.Operation revertVolume(
        com.google.cloud.netapp.v1.RevertVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRevertVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all snapshots for a volume.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListSnapshotsResponse listSnapshots(
        com.google.cloud.netapp.v1.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnapshotsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describe a snapshot for a volume.
     * </pre>
     */
    public com.google.cloud.netapp.v1.Snapshot getSnapshot(
        com.google.cloud.netapp.v1.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new snapshot for a volume.
     * </pre>
     */
    public com.google.longrunning.Operation createSnapshot(
        com.google.cloud.netapp.v1.CreateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSnapshot(
        com.google.cloud.netapp.v1.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific snapshot.
     * </pre>
     */
    public com.google.longrunning.Operation updateSnapshot(
        com.google.cloud.netapp.v1.UpdateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists active directories.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListActiveDirectoriesResponse listActiveDirectories(
        com.google.cloud.netapp.v1.ListActiveDirectoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListActiveDirectoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specified active directory.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ActiveDirectory getActiveDirectory(
        com.google.cloud.netapp.v1.GetActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetActiveDirectoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateActiveDirectory
     * Creates the active directory specified in the request.
     * </pre>
     */
    public com.google.longrunning.Operation createActiveDirectory(
        com.google.cloud.netapp.v1.CreateActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateActiveDirectoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the parameters of an active directories.
     * </pre>
     */
    public com.google.longrunning.Operation updateActiveDirectory(
        com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateActiveDirectoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the active directory specified in the request.
     * </pre>
     */
    public com.google.longrunning.Operation deleteActiveDirectory(
        com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteActiveDirectoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all KMS configs owned by the caller.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListKmsConfigsResponse listKmsConfigs(
        com.google.cloud.netapp.v1.ListKmsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKmsConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new KMS config.
     * </pre>
     */
    public com.google.longrunning.Operation createKmsConfig(
        com.google.cloud.netapp.v1.CreateKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKmsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified KMS config by kms_config_id.
     * </pre>
     */
    public com.google.cloud.netapp.v1.KmsConfig getKmsConfig(
        com.google.cloud.netapp.v1.GetKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKmsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Kms config properties with the full spec
     * </pre>
     */
    public com.google.longrunning.Operation updateKmsConfig(
        com.google.cloud.netapp.v1.UpdateKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateKmsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Encrypt the existing volumes without CMEK encryption with the desired the
     * KMS config for the whole region.
     * </pre>
     */
    public com.google.longrunning.Operation encryptVolumes(
        com.google.cloud.netapp.v1.EncryptVolumesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEncryptVolumesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Verifies KMS config reachability.
     * </pre>
     */
    public com.google.cloud.netapp.v1.VerifyKmsConfigResponse verifyKmsConfig(
        com.google.cloud.netapp.v1.VerifyKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyKmsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the Kms config.
     * </pre>
     */
    public com.google.longrunning.Operation deleteKmsConfig(
        com.google.cloud.netapp.v1.DeleteKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteKmsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all replications for a volume.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListReplicationsResponse listReplications(
        com.google.cloud.netapp.v1.ListReplicationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describe a replication for a volume.
     * </pre>
     */
    public com.google.cloud.netapp.v1.Replication getReplication(
        com.google.cloud.netapp.v1.GetReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new replication for a volume.
     * </pre>
     */
    public com.google.longrunning.Operation createReplication(
        com.google.cloud.netapp.v1.CreateReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a replication.
     * </pre>
     */
    public com.google.longrunning.Operation deleteReplication(
        com.google.cloud.netapp.v1.DeleteReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific replication.
     * </pre>
     */
    public com.google.longrunning.Operation updateReplication(
        com.google.cloud.netapp.v1.UpdateReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stop Cross Region Replication.
     * </pre>
     */
    public com.google.longrunning.Operation stopReplication(
        com.google.cloud.netapp.v1.StopReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume Cross Region Replication.
     * </pre>
     */
    public com.google.longrunning.Operation resumeReplication(
        com.google.cloud.netapp.v1.ResumeReplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeReplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reverses direction of replication. Source becomes destination and
     * destination becomes source.
     * </pre>
     */
    public com.google.longrunning.Operation reverseReplicationDirection(
        com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReverseReplicationDirectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup vault
     * </pre>
     */
    public com.google.longrunning.Operation createBackupVault(
        com.google.cloud.netapp.v1.CreateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup vault
     * </pre>
     */
    public com.google.cloud.netapp.v1.BackupVault getBackupVault(
        com.google.cloud.netapp.v1.GetBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup vaults.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListBackupVaultsResponse listBackupVaults(
        com.google.cloud.netapp.v1.ListBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupVaultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific backup vault.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupVault(
        com.google.cloud.netapp.v1.UpdateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup vault.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupVault(
        com.google.cloud.netapp.v1.DeleteBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupVaultMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup from the volume specified in the request
     * The backup can be created from the given snapshot if specified in the
     * request. If no snapshot specified, there'll be a new snapshot taken to
     * initiate the backup creation.
     * </pre>
     */
    public com.google.longrunning.Operation createBackup(
        com.google.cloud.netapp.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup
     * </pre>
     */
    public com.google.cloud.netapp.v1.Backup getBackup(
        com.google.cloud.netapp.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all backups for a backupVault.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListBackupsResponse listBackups(
        com.google.cloud.netapp.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackup(
        com.google.cloud.netapp.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update backup with full spec.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackup(
        com.google.cloud.netapp.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup policy
     * </pre>
     */
    public com.google.longrunning.Operation createBackupPolicy(
        com.google.cloud.netapp.v1.CreateBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackupPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup policy by backup_policy_id.
     * </pre>
     */
    public com.google.cloud.netapp.v1.BackupPolicy getBackupPolicy(
        com.google.cloud.netapp.v1.GetBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBackupPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup policies.
     * </pre>
     */
    public com.google.cloud.netapp.v1.ListBackupPoliciesResponse listBackupPolicies(
        com.google.cloud.netapp.v1.ListBackupPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBackupPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a specific backup policy.
     * </pre>
     */
    public com.google.longrunning.Operation updateBackupPolicy(
        com.google.cloud.netapp.v1.UpdateBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBackupPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBackupPolicy(
        com.google.cloud.netapp.v1.DeleteBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBackupPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NetApp.
   *
   * <pre>
   * NetApp Files Google Cloud Service
   * </pre>
   */
  public static final class NetAppFutureStub
      extends io.grpc.stub.AbstractFutureStub<NetAppFutureStub> {
    private NetAppFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetAppFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetAppFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all storage pools owned by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListStoragePoolsResponse>
        listStoragePools(com.google.cloud.netapp.v1.ListStoragePoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStoragePoolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new storage pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createStoragePool(com.google.cloud.netapp.v1.CreateStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStoragePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified storage pool by poolId.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.StoragePool>
        getStoragePool(com.google.cloud.netapp.v1.GetStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStoragePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the storage pool properties with the full spec
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateStoragePool(com.google.cloud.netapp.v1.UpdateStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStoragePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the storage pool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteStoragePool(com.google.cloud.netapp.v1.DeleteStoragePoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStoragePoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Volumes in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListVolumesResponse>
        listVolumes(com.google.cloud.netapp.v1.ListVolumesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVolumesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.netapp.v1.Volume>
        getVolume(com.google.cloud.netapp.v1.GetVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Volume in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createVolume(com.google.cloud.netapp.v1.CreateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateVolume(com.google.cloud.netapp.v1.UpdateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteVolume(com.google.cloud.netapp.v1.DeleteVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Revert an existing volume to a specified snapshot.
     * Warning! This operation will permanently revert all changes made after the
     * snapshot was created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        revertVolume(com.google.cloud.netapp.v1.RevertVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRevertVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all snapshots for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListSnapshotsResponse>
        listSnapshots(com.google.cloud.netapp.v1.ListSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSnapshotsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describe a snapshot for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.netapp.v1.Snapshot>
        getSnapshot(com.google.cloud.netapp.v1.GetSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new snapshot for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSnapshot(com.google.cloud.netapp.v1.CreateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSnapshot(com.google.cloud.netapp.v1.DeleteSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSnapshot(com.google.cloud.netapp.v1.UpdateSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists active directories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>
        listActiveDirectories(com.google.cloud.netapp.v1.ListActiveDirectoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListActiveDirectoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specified active directory.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ActiveDirectory>
        getActiveDirectory(com.google.cloud.netapp.v1.GetActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetActiveDirectoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * CreateActiveDirectory
     * Creates the active directory specified in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createActiveDirectory(com.google.cloud.netapp.v1.CreateActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateActiveDirectoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the parameters of an active directories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateActiveDirectory(com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateActiveDirectoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the active directory specified in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteActiveDirectory(com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteActiveDirectoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all KMS configs owned by the caller.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListKmsConfigsResponse>
        listKmsConfigs(com.google.cloud.netapp.v1.ListKmsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKmsConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new KMS config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createKmsConfig(com.google.cloud.netapp.v1.CreateKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKmsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified KMS config by kms_config_id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.netapp.v1.KmsConfig>
        getKmsConfig(com.google.cloud.netapp.v1.GetKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKmsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Kms config properties with the full spec
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateKmsConfig(com.google.cloud.netapp.v1.UpdateKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateKmsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Encrypt the existing volumes without CMEK encryption with the desired the
     * KMS config for the whole region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        encryptVolumes(com.google.cloud.netapp.v1.EncryptVolumesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEncryptVolumesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Verifies KMS config reachability.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.VerifyKmsConfigResponse>
        verifyKmsConfig(com.google.cloud.netapp.v1.VerifyKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyKmsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the Kms config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteKmsConfig(com.google.cloud.netapp.v1.DeleteKmsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteKmsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all replications for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListReplicationsResponse>
        listReplications(com.google.cloud.netapp.v1.ListReplicationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReplicationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describe a replication for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.Replication>
        getReplication(com.google.cloud.netapp.v1.GetReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new replication for a volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createReplication(com.google.cloud.netapp.v1.CreateReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a replication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteReplication(com.google.cloud.netapp.v1.DeleteReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific replication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateReplication(com.google.cloud.netapp.v1.UpdateReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stop Cross Region Replication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopReplication(com.google.cloud.netapp.v1.StopReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resume Cross Region Replication.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resumeReplication(com.google.cloud.netapp.v1.ResumeReplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeReplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reverses direction of replication. Source becomes destination and
     * destination becomes source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reverseReplicationDirection(
            com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReverseReplicationDirectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup vault
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupVault(com.google.cloud.netapp.v1.CreateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup vault
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.BackupVault>
        getBackupVault(com.google.cloud.netapp.v1.GetBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup vaults.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListBackupVaultsResponse>
        listBackupVaults(com.google.cloud.netapp.v1.ListBackupVaultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupVaultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the settings of a specific backup vault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupVault(com.google.cloud.netapp.v1.UpdateBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup vault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupVault(com.google.cloud.netapp.v1.DeleteBackupVaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupVaultMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a backup from the volume specified in the request
     * The backup can be created from the given snapshot if specified in the
     * request. If no snapshot specified, there'll be a new snapshot taken to
     * initiate the backup creation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackup(com.google.cloud.netapp.v1.CreateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.netapp.v1.Backup>
        getBackup(com.google.cloud.netapp.v1.GetBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns descriptions of all backups for a backupVault.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListBackupsResponse>
        listBackups(com.google.cloud.netapp.v1.ListBackupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackup(com.google.cloud.netapp.v1.DeleteBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update backup with full spec.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackup(com.google.cloud.netapp.v1.UpdateBackupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates new backup policy
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBackupPolicy(com.google.cloud.netapp.v1.CreateBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackupPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the description of the specified backup policy by backup_policy_id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.BackupPolicy>
        getBackupPolicy(com.google.cloud.netapp.v1.GetBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBackupPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns list of all available backup policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.netapp.v1.ListBackupPoliciesResponse>
        listBackupPolicies(com.google.cloud.netapp.v1.ListBackupPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBackupPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates settings of a specific backup policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBackupPolicy(com.google.cloud.netapp.v1.UpdateBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBackupPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Warning! This operation will permanently delete the backup policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBackupPolicy(com.google.cloud.netapp.v1.DeleteBackupPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBackupPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_STORAGE_POOLS = 0;
  private static final int METHODID_CREATE_STORAGE_POOL = 1;
  private static final int METHODID_GET_STORAGE_POOL = 2;
  private static final int METHODID_UPDATE_STORAGE_POOL = 3;
  private static final int METHODID_DELETE_STORAGE_POOL = 4;
  private static final int METHODID_LIST_VOLUMES = 5;
  private static final int METHODID_GET_VOLUME = 6;
  private static final int METHODID_CREATE_VOLUME = 7;
  private static final int METHODID_UPDATE_VOLUME = 8;
  private static final int METHODID_DELETE_VOLUME = 9;
  private static final int METHODID_REVERT_VOLUME = 10;
  private static final int METHODID_LIST_SNAPSHOTS = 11;
  private static final int METHODID_GET_SNAPSHOT = 12;
  private static final int METHODID_CREATE_SNAPSHOT = 13;
  private static final int METHODID_DELETE_SNAPSHOT = 14;
  private static final int METHODID_UPDATE_SNAPSHOT = 15;
  private static final int METHODID_LIST_ACTIVE_DIRECTORIES = 16;
  private static final int METHODID_GET_ACTIVE_DIRECTORY = 17;
  private static final int METHODID_CREATE_ACTIVE_DIRECTORY = 18;
  private static final int METHODID_UPDATE_ACTIVE_DIRECTORY = 19;
  private static final int METHODID_DELETE_ACTIVE_DIRECTORY = 20;
  private static final int METHODID_LIST_KMS_CONFIGS = 21;
  private static final int METHODID_CREATE_KMS_CONFIG = 22;
  private static final int METHODID_GET_KMS_CONFIG = 23;
  private static final int METHODID_UPDATE_KMS_CONFIG = 24;
  private static final int METHODID_ENCRYPT_VOLUMES = 25;
  private static final int METHODID_VERIFY_KMS_CONFIG = 26;
  private static final int METHODID_DELETE_KMS_CONFIG = 27;
  private static final int METHODID_LIST_REPLICATIONS = 28;
  private static final int METHODID_GET_REPLICATION = 29;
  private static final int METHODID_CREATE_REPLICATION = 30;
  private static final int METHODID_DELETE_REPLICATION = 31;
  private static final int METHODID_UPDATE_REPLICATION = 32;
  private static final int METHODID_STOP_REPLICATION = 33;
  private static final int METHODID_RESUME_REPLICATION = 34;
  private static final int METHODID_REVERSE_REPLICATION_DIRECTION = 35;
  private static final int METHODID_CREATE_BACKUP_VAULT = 36;
  private static final int METHODID_GET_BACKUP_VAULT = 37;
  private static final int METHODID_LIST_BACKUP_VAULTS = 38;
  private static final int METHODID_UPDATE_BACKUP_VAULT = 39;
  private static final int METHODID_DELETE_BACKUP_VAULT = 40;
  private static final int METHODID_CREATE_BACKUP = 41;
  private static final int METHODID_GET_BACKUP = 42;
  private static final int METHODID_LIST_BACKUPS = 43;
  private static final int METHODID_DELETE_BACKUP = 44;
  private static final int METHODID_UPDATE_BACKUP = 45;
  private static final int METHODID_CREATE_BACKUP_POLICY = 46;
  private static final int METHODID_GET_BACKUP_POLICY = 47;
  private static final int METHODID_LIST_BACKUP_POLICIES = 48;
  private static final int METHODID_UPDATE_BACKUP_POLICY = 49;
  private static final int METHODID_DELETE_BACKUP_POLICY = 50;

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
        case METHODID_LIST_STORAGE_POOLS:
          serviceImpl.listStoragePools(
              (com.google.cloud.netapp.v1.ListStoragePoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListStoragePoolsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_STORAGE_POOL:
          serviceImpl.createStoragePool(
              (com.google.cloud.netapp.v1.CreateStoragePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_STORAGE_POOL:
          serviceImpl.getStoragePool(
              (com.google.cloud.netapp.v1.GetStoragePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.StoragePool>)
                  responseObserver);
          break;
        case METHODID_UPDATE_STORAGE_POOL:
          serviceImpl.updateStoragePool(
              (com.google.cloud.netapp.v1.UpdateStoragePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_STORAGE_POOL:
          serviceImpl.deleteStoragePool(
              (com.google.cloud.netapp.v1.DeleteStoragePoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VOLUMES:
          serviceImpl.listVolumes(
              (com.google.cloud.netapp.v1.ListVolumesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListVolumesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOLUME:
          serviceImpl.getVolume(
              (com.google.cloud.netapp.v1.GetVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Volume>) responseObserver);
          break;
        case METHODID_CREATE_VOLUME:
          serviceImpl.createVolume(
              (com.google.cloud.netapp.v1.CreateVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VOLUME:
          serviceImpl.updateVolume(
              (com.google.cloud.netapp.v1.UpdateVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VOLUME:
          serviceImpl.deleteVolume(
              (com.google.cloud.netapp.v1.DeleteVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REVERT_VOLUME:
          serviceImpl.revertVolume(
              (com.google.cloud.netapp.v1.RevertVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SNAPSHOTS:
          serviceImpl.listSnapshots(
              (com.google.cloud.netapp.v1.ListSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListSnapshotsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SNAPSHOT:
          serviceImpl.getSnapshot(
              (com.google.cloud.netapp.v1.GetSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Snapshot>) responseObserver);
          break;
        case METHODID_CREATE_SNAPSHOT:
          serviceImpl.createSnapshot(
              (com.google.cloud.netapp.v1.CreateSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SNAPSHOT:
          serviceImpl.deleteSnapshot(
              (com.google.cloud.netapp.v1.DeleteSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SNAPSHOT:
          serviceImpl.updateSnapshot(
              (com.google.cloud.netapp.v1.UpdateSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ACTIVE_DIRECTORIES:
          serviceImpl.listActiveDirectories(
              (com.google.cloud.netapp.v1.ListActiveDirectoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ACTIVE_DIRECTORY:
          serviceImpl.getActiveDirectory(
              (com.google.cloud.netapp.v1.GetActiveDirectoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ActiveDirectory>)
                  responseObserver);
          break;
        case METHODID_CREATE_ACTIVE_DIRECTORY:
          serviceImpl.createActiveDirectory(
              (com.google.cloud.netapp.v1.CreateActiveDirectoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ACTIVE_DIRECTORY:
          serviceImpl.updateActiveDirectory(
              (com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ACTIVE_DIRECTORY:
          serviceImpl.deleteActiveDirectory(
              (com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_KMS_CONFIGS:
          serviceImpl.listKmsConfigs(
              (com.google.cloud.netapp.v1.ListKmsConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListKmsConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_KMS_CONFIG:
          serviceImpl.createKmsConfig(
              (com.google.cloud.netapp.v1.CreateKmsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_KMS_CONFIG:
          serviceImpl.getKmsConfig(
              (com.google.cloud.netapp.v1.GetKmsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.KmsConfig>) responseObserver);
          break;
        case METHODID_UPDATE_KMS_CONFIG:
          serviceImpl.updateKmsConfig(
              (com.google.cloud.netapp.v1.UpdateKmsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ENCRYPT_VOLUMES:
          serviceImpl.encryptVolumes(
              (com.google.cloud.netapp.v1.EncryptVolumesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_VERIFY_KMS_CONFIG:
          serviceImpl.verifyKmsConfig(
              (com.google.cloud.netapp.v1.VerifyKmsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.VerifyKmsConfigResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_KMS_CONFIG:
          serviceImpl.deleteKmsConfig(
              (com.google.cloud.netapp.v1.DeleteKmsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPLICATIONS:
          serviceImpl.listReplications(
              (com.google.cloud.netapp.v1.ListReplicationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListReplicationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPLICATION:
          serviceImpl.getReplication(
              (com.google.cloud.netapp.v1.GetReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Replication>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPLICATION:
          serviceImpl.createReplication(
              (com.google.cloud.netapp.v1.CreateReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REPLICATION:
          serviceImpl.deleteReplication(
              (com.google.cloud.netapp.v1.DeleteReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REPLICATION:
          serviceImpl.updateReplication(
              (com.google.cloud.netapp.v1.UpdateReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_REPLICATION:
          serviceImpl.stopReplication(
              (com.google.cloud.netapp.v1.StopReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESUME_REPLICATION:
          serviceImpl.resumeReplication(
              (com.google.cloud.netapp.v1.ResumeReplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REVERSE_REPLICATION_DIRECTION:
          serviceImpl.reverseReplicationDirection(
              (com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_VAULT:
          serviceImpl.createBackupVault(
              (com.google.cloud.netapp.v1.CreateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_VAULT:
          serviceImpl.getBackupVault(
              (com.google.cloud.netapp.v1.GetBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupVault>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_VAULTS:
          serviceImpl.listBackupVaults(
              (com.google.cloud.netapp.v1.ListBackupVaultsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupVaultsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_VAULT:
          serviceImpl.updateBackupVault(
              (com.google.cloud.netapp.v1.UpdateBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP_VAULT:
          serviceImpl.deleteBackupVault(
              (com.google.cloud.netapp.v1.DeleteBackupVaultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP:
          serviceImpl.createBackup(
              (com.google.cloud.netapp.v1.CreateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP:
          serviceImpl.getBackup(
              (com.google.cloud.netapp.v1.GetBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.Backup>) responseObserver);
          break;
        case METHODID_LIST_BACKUPS:
          serviceImpl.listBackups(
              (com.google.cloud.netapp.v1.ListBackupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BACKUP:
          serviceImpl.deleteBackup(
              (com.google.cloud.netapp.v1.DeleteBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_BACKUP:
          serviceImpl.updateBackup(
              (com.google.cloud.netapp.v1.UpdateBackupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BACKUP_POLICY:
          serviceImpl.createBackupPolicy(
              (com.google.cloud.netapp.v1.CreateBackupPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BACKUP_POLICY:
          serviceImpl.getBackupPolicy(
              (com.google.cloud.netapp.v1.GetBackupPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.BackupPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_BACKUP_POLICIES:
          serviceImpl.listBackupPolicies(
              (com.google.cloud.netapp.v1.ListBackupPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.netapp.v1.ListBackupPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BACKUP_POLICY:
          serviceImpl.updateBackupPolicy(
              (com.google.cloud.netapp.v1.UpdateBackupPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BACKUP_POLICY:
          serviceImpl.deleteBackupPolicy(
              (com.google.cloud.netapp.v1.DeleteBackupPolicyRequest) request,
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
            getListStoragePoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListStoragePoolsRequest,
                    com.google.cloud.netapp.v1.ListStoragePoolsResponse>(
                    service, METHODID_LIST_STORAGE_POOLS)))
        .addMethod(
            getCreateStoragePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateStoragePoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_STORAGE_POOL)))
        .addMethod(
            getGetStoragePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetStoragePoolRequest,
                    com.google.cloud.netapp.v1.StoragePool>(service, METHODID_GET_STORAGE_POOL)))
        .addMethod(
            getUpdateStoragePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateStoragePoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_STORAGE_POOL)))
        .addMethod(
            getDeleteStoragePoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteStoragePoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_STORAGE_POOL)))
        .addMethod(
            getListVolumesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListVolumesRequest,
                    com.google.cloud.netapp.v1.ListVolumesResponse>(
                    service, METHODID_LIST_VOLUMES)))
        .addMethod(
            getGetVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetVolumeRequest, com.google.cloud.netapp.v1.Volume>(
                    service, METHODID_GET_VOLUME)))
        .addMethod(
            getCreateVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_VOLUME)))
        .addMethod(
            getUpdateVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_VOLUME)))
        .addMethod(
            getDeleteVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_VOLUME)))
        .addMethod(
            getRevertVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.RevertVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_REVERT_VOLUME)))
        .addMethod(
            getListSnapshotsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListSnapshotsRequest,
                    com.google.cloud.netapp.v1.ListSnapshotsResponse>(
                    service, METHODID_LIST_SNAPSHOTS)))
        .addMethod(
            getGetSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetSnapshotRequest,
                    com.google.cloud.netapp.v1.Snapshot>(service, METHODID_GET_SNAPSHOT)))
        .addMethod(
            getCreateSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateSnapshotRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SNAPSHOT)))
        .addMethod(
            getDeleteSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteSnapshotRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SNAPSHOT)))
        .addMethod(
            getUpdateSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateSnapshotRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SNAPSHOT)))
        .addMethod(
            getListActiveDirectoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListActiveDirectoriesRequest,
                    com.google.cloud.netapp.v1.ListActiveDirectoriesResponse>(
                    service, METHODID_LIST_ACTIVE_DIRECTORIES)))
        .addMethod(
            getGetActiveDirectoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetActiveDirectoryRequest,
                    com.google.cloud.netapp.v1.ActiveDirectory>(
                    service, METHODID_GET_ACTIVE_DIRECTORY)))
        .addMethod(
            getCreateActiveDirectoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateActiveDirectoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ACTIVE_DIRECTORY)))
        .addMethod(
            getUpdateActiveDirectoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateActiveDirectoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ACTIVE_DIRECTORY)))
        .addMethod(
            getDeleteActiveDirectoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteActiveDirectoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ACTIVE_DIRECTORY)))
        .addMethod(
            getListKmsConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListKmsConfigsRequest,
                    com.google.cloud.netapp.v1.ListKmsConfigsResponse>(
                    service, METHODID_LIST_KMS_CONFIGS)))
        .addMethod(
            getCreateKmsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateKmsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_KMS_CONFIG)))
        .addMethod(
            getGetKmsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetKmsConfigRequest,
                    com.google.cloud.netapp.v1.KmsConfig>(service, METHODID_GET_KMS_CONFIG)))
        .addMethod(
            getUpdateKmsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateKmsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_KMS_CONFIG)))
        .addMethod(
            getEncryptVolumesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.EncryptVolumesRequest,
                    com.google.longrunning.Operation>(service, METHODID_ENCRYPT_VOLUMES)))
        .addMethod(
            getVerifyKmsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.VerifyKmsConfigRequest,
                    com.google.cloud.netapp.v1.VerifyKmsConfigResponse>(
                    service, METHODID_VERIFY_KMS_CONFIG)))
        .addMethod(
            getDeleteKmsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteKmsConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_KMS_CONFIG)))
        .addMethod(
            getListReplicationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListReplicationsRequest,
                    com.google.cloud.netapp.v1.ListReplicationsResponse>(
                    service, METHODID_LIST_REPLICATIONS)))
        .addMethod(
            getGetReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetReplicationRequest,
                    com.google.cloud.netapp.v1.Replication>(service, METHODID_GET_REPLICATION)))
        .addMethod(
            getCreateReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateReplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPLICATION)))
        .addMethod(
            getDeleteReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteReplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REPLICATION)))
        .addMethod(
            getUpdateReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateReplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_REPLICATION)))
        .addMethod(
            getStopReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.StopReplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_REPLICATION)))
        .addMethod(
            getResumeReplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ResumeReplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESUME_REPLICATION)))
        .addMethod(
            getReverseReplicationDirectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ReverseReplicationDirectionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REVERSE_REPLICATION_DIRECTION)))
        .addMethod(
            getCreateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_VAULT)))
        .addMethod(
            getGetBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetBackupVaultRequest,
                    com.google.cloud.netapp.v1.BackupVault>(service, METHODID_GET_BACKUP_VAULT)))
        .addMethod(
            getListBackupVaultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListBackupVaultsRequest,
                    com.google.cloud.netapp.v1.ListBackupVaultsResponse>(
                    service, METHODID_LIST_BACKUP_VAULTS)))
        .addMethod(
            getUpdateBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_VAULT)))
        .addMethod(
            getDeleteBackupVaultMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteBackupVaultRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_VAULT)))
        .addMethod(
            getCreateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP)))
        .addMethod(
            getGetBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetBackupRequest, com.google.cloud.netapp.v1.Backup>(
                    service, METHODID_GET_BACKUP)))
        .addMethod(
            getListBackupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListBackupsRequest,
                    com.google.cloud.netapp.v1.ListBackupsResponse>(
                    service, METHODID_LIST_BACKUPS)))
        .addMethod(
            getDeleteBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP)))
        .addMethod(
            getUpdateBackupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateBackupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP)))
        .addMethod(
            getCreateBackupPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.CreateBackupPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BACKUP_POLICY)))
        .addMethod(
            getGetBackupPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.GetBackupPolicyRequest,
                    com.google.cloud.netapp.v1.BackupPolicy>(service, METHODID_GET_BACKUP_POLICY)))
        .addMethod(
            getListBackupPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.ListBackupPoliciesRequest,
                    com.google.cloud.netapp.v1.ListBackupPoliciesResponse>(
                    service, METHODID_LIST_BACKUP_POLICIES)))
        .addMethod(
            getUpdateBackupPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.UpdateBackupPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BACKUP_POLICY)))
        .addMethod(
            getDeleteBackupPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.netapp.v1.DeleteBackupPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BACKUP_POLICY)))
        .build();
  }

  private abstract static class NetAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetAppBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.netapp.v1.CloudNetappServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetApp");
    }
  }

  private static final class NetAppFileDescriptorSupplier extends NetAppBaseDescriptorSupplier {
    NetAppFileDescriptorSupplier() {}
  }

  private static final class NetAppMethodDescriptorSupplier extends NetAppBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NetAppMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NetAppGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NetAppFileDescriptorSupplier())
                      .addMethod(getListStoragePoolsMethod())
                      .addMethod(getCreateStoragePoolMethod())
                      .addMethod(getGetStoragePoolMethod())
                      .addMethod(getUpdateStoragePoolMethod())
                      .addMethod(getDeleteStoragePoolMethod())
                      .addMethod(getListVolumesMethod())
                      .addMethod(getGetVolumeMethod())
                      .addMethod(getCreateVolumeMethod())
                      .addMethod(getUpdateVolumeMethod())
                      .addMethod(getDeleteVolumeMethod())
                      .addMethod(getRevertVolumeMethod())
                      .addMethod(getListSnapshotsMethod())
                      .addMethod(getGetSnapshotMethod())
                      .addMethod(getCreateSnapshotMethod())
                      .addMethod(getDeleteSnapshotMethod())
                      .addMethod(getUpdateSnapshotMethod())
                      .addMethod(getListActiveDirectoriesMethod())
                      .addMethod(getGetActiveDirectoryMethod())
                      .addMethod(getCreateActiveDirectoryMethod())
                      .addMethod(getUpdateActiveDirectoryMethod())
                      .addMethod(getDeleteActiveDirectoryMethod())
                      .addMethod(getListKmsConfigsMethod())
                      .addMethod(getCreateKmsConfigMethod())
                      .addMethod(getGetKmsConfigMethod())
                      .addMethod(getUpdateKmsConfigMethod())
                      .addMethod(getEncryptVolumesMethod())
                      .addMethod(getVerifyKmsConfigMethod())
                      .addMethod(getDeleteKmsConfigMethod())
                      .addMethod(getListReplicationsMethod())
                      .addMethod(getGetReplicationMethod())
                      .addMethod(getCreateReplicationMethod())
                      .addMethod(getDeleteReplicationMethod())
                      .addMethod(getUpdateReplicationMethod())
                      .addMethod(getStopReplicationMethod())
                      .addMethod(getResumeReplicationMethod())
                      .addMethod(getReverseReplicationDirectionMethod())
                      .addMethod(getCreateBackupVaultMethod())
                      .addMethod(getGetBackupVaultMethod())
                      .addMethod(getListBackupVaultsMethod())
                      .addMethod(getUpdateBackupVaultMethod())
                      .addMethod(getDeleteBackupVaultMethod())
                      .addMethod(getCreateBackupMethod())
                      .addMethod(getGetBackupMethod())
                      .addMethod(getListBackupsMethod())
                      .addMethod(getDeleteBackupMethod())
                      .addMethod(getUpdateBackupMethod())
                      .addMethod(getCreateBackupPolicyMethod())
                      .addMethod(getGetBackupPolicyMethod())
                      .addMethod(getListBackupPoliciesMethod())
                      .addMethod(getUpdateBackupPolicyMethod())
                      .addMethod(getDeleteBackupPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
