/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.baremetalsolution.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Performs management operations on Bare Metal Solution servers.
 * The `baremetalsolution.googleapis.com` service provides management
 * capabilities for Bare Metal Solution servers. To access the API methods, you
 * must assign Bare Metal Solution IAM roles containing the desired permissions
 * to your staff in your Google Cloud project. You must also enable the Bare
 * Metal Solution API. Once enabled, the methods act
 * upon specific servers in your Bare Metal Solution environment.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/baremetalsolution/v2/baremetalsolution.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BareMetalSolutionGrpc {

  private BareMetalSolutionGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.baremetalsolution.v2.BareMetalSolution";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
          com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.baremetalsolution.v2.ListInstancesRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
          com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
            com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = BareMetalSolutionGrpc.getListInstancesMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListInstancesMethod = BareMetalSolutionGrpc.getListInstancesMethod) == null) {
          BareMetalSolutionGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
                          com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
          com.google.cloud.baremetalsolution.v2.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.baremetalsolution.v2.GetInstanceRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
          com.google.cloud.baremetalsolution.v2.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
            com.google.cloud.baremetalsolution.v2.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = BareMetalSolutionGrpc.getGetInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetInstanceMethod = BareMetalSolutionGrpc.getGetInstanceMethod) == null) {
          BareMetalSolutionGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
                          com.google.cloud.baremetalsolution.v2.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = BareMetalSolutionGrpc.getUpdateInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateInstanceMethod = BareMetalSolutionGrpc.getUpdateInstanceMethod) == null) {
          BareMetalSolutionGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
          com.google.longrunning.Operation>
      getResetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetInstance",
      requestType = com.google.cloud.baremetalsolution.v2.ResetInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
          com.google.longrunning.Operation>
      getResetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
            com.google.longrunning.Operation>
        getResetInstanceMethod;
    if ((getResetInstanceMethod = BareMetalSolutionGrpc.getResetInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getResetInstanceMethod = BareMetalSolutionGrpc.getResetInstanceMethod) == null) {
          BareMetalSolutionGrpc.getResetInstanceMethod =
              getResetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ResetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ResetInstance"))
                      .build();
        }
      }
    }
    return getResetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
          com.google.longrunning.Operation>
      getStartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartInstance",
      requestType = com.google.cloud.baremetalsolution.v2.StartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
          com.google.longrunning.Operation>
      getStartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
            com.google.longrunning.Operation>
        getStartInstanceMethod;
    if ((getStartInstanceMethod = BareMetalSolutionGrpc.getStartInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getStartInstanceMethod = BareMetalSolutionGrpc.getStartInstanceMethod) == null) {
          BareMetalSolutionGrpc.getStartInstanceMethod =
              getStartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.StartInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("StartInstance"))
                      .build();
        }
      }
    }
    return getStartInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
          com.google.longrunning.Operation>
      getStopInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopInstance",
      requestType = com.google.cloud.baremetalsolution.v2.StopInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
          com.google.longrunning.Operation>
      getStopInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
            com.google.longrunning.Operation>
        getStopInstanceMethod;
    if ((getStopInstanceMethod = BareMetalSolutionGrpc.getStopInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getStopInstanceMethod = BareMetalSolutionGrpc.getStopInstanceMethod) == null) {
          BareMetalSolutionGrpc.getStopInstanceMethod =
              getStopInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.StopInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("StopInstance"))
                      .build();
        }
      }
    }
    return getStopInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DetachLunRequest, com.google.longrunning.Operation>
      getDetachLunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetachLun",
      requestType = com.google.cloud.baremetalsolution.v2.DetachLunRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DetachLunRequest, com.google.longrunning.Operation>
      getDetachLunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DetachLunRequest,
            com.google.longrunning.Operation>
        getDetachLunMethod;
    if ((getDetachLunMethod = BareMetalSolutionGrpc.getDetachLunMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDetachLunMethod = BareMetalSolutionGrpc.getDetachLunMethod) == null) {
          BareMetalSolutionGrpc.getDetachLunMethod =
              getDetachLunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.DetachLunRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetachLun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.DetachLunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("DetachLun"))
                      .build();
        }
      }
    }
    return getDetachLunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
          com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
      getListVolumesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVolumes",
      requestType = com.google.cloud.baremetalsolution.v2.ListVolumesRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListVolumesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
          com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
      getListVolumesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
            com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
        getListVolumesMethod;
    if ((getListVolumesMethod = BareMetalSolutionGrpc.getListVolumesMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListVolumesMethod = BareMetalSolutionGrpc.getListVolumesMethod) == null) {
          BareMetalSolutionGrpc.getListVolumesMethod =
              getListVolumesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
                          com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVolumes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListVolumesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListVolumesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListVolumes"))
                      .build();
        }
      }
    }
    return getListVolumesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
          com.google.cloud.baremetalsolution.v2.Volume>
      getGetVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVolume",
      requestType = com.google.cloud.baremetalsolution.v2.GetVolumeRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Volume.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
          com.google.cloud.baremetalsolution.v2.Volume>
      getGetVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
            com.google.cloud.baremetalsolution.v2.Volume>
        getGetVolumeMethod;
    if ((getGetVolumeMethod = BareMetalSolutionGrpc.getGetVolumeMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetVolumeMethod = BareMetalSolutionGrpc.getGetVolumeMethod) == null) {
          BareMetalSolutionGrpc.getGetVolumeMethod =
              getGetVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
                          com.google.cloud.baremetalsolution.v2.Volume>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetVolumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Volume.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetVolume"))
                      .build();
        }
      }
    }
    return getGetVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
          com.google.longrunning.Operation>
      getUpdateVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVolume",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
          com.google.longrunning.Operation>
      getUpdateVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
            com.google.longrunning.Operation>
        getUpdateVolumeMethod;
    if ((getUpdateVolumeMethod = BareMetalSolutionGrpc.getUpdateVolumeMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateVolumeMethod = BareMetalSolutionGrpc.getUpdateVolumeMethod) == null) {
          BareMetalSolutionGrpc.getUpdateVolumeMethod =
              getUpdateVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("UpdateVolume"))
                      .build();
        }
      }
    }
    return getUpdateVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
          com.google.longrunning.Operation>
      getResizeVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResizeVolume",
      requestType = com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
          com.google.longrunning.Operation>
      getResizeVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
            com.google.longrunning.Operation>
        getResizeVolumeMethod;
    if ((getResizeVolumeMethod = BareMetalSolutionGrpc.getResizeVolumeMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getResizeVolumeMethod = BareMetalSolutionGrpc.getResizeVolumeMethod) == null) {
          BareMetalSolutionGrpc.getResizeVolumeMethod =
              getResizeVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResizeVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ResizeVolume"))
                      .build();
        }
      }
    }
    return getResizeVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
          com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
      getListNetworksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworks",
      requestType = com.google.cloud.baremetalsolution.v2.ListNetworksRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListNetworksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
          com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
      getListNetworksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
            com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
        getListNetworksMethod;
    if ((getListNetworksMethod = BareMetalSolutionGrpc.getListNetworksMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListNetworksMethod = BareMetalSolutionGrpc.getListNetworksMethod) == null) {
          BareMetalSolutionGrpc.getListNetworksMethod =
              getListNetworksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
                          com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNetworks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNetworksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNetworksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListNetworks"))
                      .build();
        }
      }
    }
    return getListNetworksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
          com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
      getListNetworkUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNetworkUsage",
      requestType = com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
          com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
      getListNetworkUsageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
            com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
        getListNetworkUsageMethod;
    if ((getListNetworkUsageMethod = BareMetalSolutionGrpc.getListNetworkUsageMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListNetworkUsageMethod = BareMetalSolutionGrpc.getListNetworkUsageMethod) == null) {
          BareMetalSolutionGrpc.getListNetworkUsageMethod =
              getListNetworkUsageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
                          com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNetworkUsage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListNetworkUsage"))
                      .build();
        }
      }
    }
    return getListNetworkUsageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
          com.google.cloud.baremetalsolution.v2.Network>
      getGetNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNetwork",
      requestType = com.google.cloud.baremetalsolution.v2.GetNetworkRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Network.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
          com.google.cloud.baremetalsolution.v2.Network>
      getGetNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
            com.google.cloud.baremetalsolution.v2.Network>
        getGetNetworkMethod;
    if ((getGetNetworkMethod = BareMetalSolutionGrpc.getGetNetworkMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetNetworkMethod = BareMetalSolutionGrpc.getGetNetworkMethod) == null) {
          BareMetalSolutionGrpc.getGetNetworkMethod =
              getGetNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
                          com.google.cloud.baremetalsolution.v2.Network>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Network.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetNetwork"))
                      .build();
        }
      }
    }
    return getGetNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNetwork",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
          com.google.longrunning.Operation>
      getUpdateNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
            com.google.longrunning.Operation>
        getUpdateNetworkMethod;
    if ((getUpdateNetworkMethod = BareMetalSolutionGrpc.getUpdateNetworkMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateNetworkMethod = BareMetalSolutionGrpc.getUpdateNetworkMethod) == null) {
          BareMetalSolutionGrpc.getUpdateNetworkMethod =
              getUpdateNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("UpdateNetwork"))
                      .build();
        }
      }
    }
    return getUpdateNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetLunRequest,
          com.google.cloud.baremetalsolution.v2.Lun>
      getGetLunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLun",
      requestType = com.google.cloud.baremetalsolution.v2.GetLunRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Lun.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetLunRequest,
          com.google.cloud.baremetalsolution.v2.Lun>
      getGetLunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetLunRequest,
            com.google.cloud.baremetalsolution.v2.Lun>
        getGetLunMethod;
    if ((getGetLunMethod = BareMetalSolutionGrpc.getGetLunMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetLunMethod = BareMetalSolutionGrpc.getGetLunMethod) == null) {
          BareMetalSolutionGrpc.getGetLunMethod =
              getGetLunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetLunRequest,
                          com.google.cloud.baremetalsolution.v2.Lun>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetLunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Lun.getDefaultInstance()))
                      .setSchemaDescriptor(new BareMetalSolutionMethodDescriptorSupplier("GetLun"))
                      .build();
        }
      }
    }
    return getGetLunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListLunsRequest,
          com.google.cloud.baremetalsolution.v2.ListLunsResponse>
      getListLunsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLuns",
      requestType = com.google.cloud.baremetalsolution.v2.ListLunsRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListLunsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListLunsRequest,
          com.google.cloud.baremetalsolution.v2.ListLunsResponse>
      getListLunsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListLunsRequest,
            com.google.cloud.baremetalsolution.v2.ListLunsResponse>
        getListLunsMethod;
    if ((getListLunsMethod = BareMetalSolutionGrpc.getListLunsMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListLunsMethod = BareMetalSolutionGrpc.getListLunsMethod) == null) {
          BareMetalSolutionGrpc.getListLunsMethod =
              getListLunsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListLunsRequest,
                          com.google.cloud.baremetalsolution.v2.ListLunsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLuns"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListLunsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListLunsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListLuns"))
                      .build();
        }
      }
    }
    return getListLunsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
          com.google.cloud.baremetalsolution.v2.NfsShare>
      getGetNfsShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNfsShare",
      requestType = com.google.cloud.baremetalsolution.v2.GetNfsShareRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.NfsShare.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
          com.google.cloud.baremetalsolution.v2.NfsShare>
      getGetNfsShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
            com.google.cloud.baremetalsolution.v2.NfsShare>
        getGetNfsShareMethod;
    if ((getGetNfsShareMethod = BareMetalSolutionGrpc.getGetNfsShareMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetNfsShareMethod = BareMetalSolutionGrpc.getGetNfsShareMethod) == null) {
          BareMetalSolutionGrpc.getGetNfsShareMethod =
              getGetNfsShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
                          com.google.cloud.baremetalsolution.v2.NfsShare>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNfsShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetNfsShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.NfsShare.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetNfsShare"))
                      .build();
        }
      }
    }
    return getGetNfsShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
          com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
      getListNfsSharesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNfsShares",
      requestType = com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
          com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
      getListNfsSharesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
            com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
        getListNfsSharesMethod;
    if ((getListNfsSharesMethod = BareMetalSolutionGrpc.getListNfsSharesMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListNfsSharesMethod = BareMetalSolutionGrpc.getListNfsSharesMethod) == null) {
          BareMetalSolutionGrpc.getListNfsSharesMethod =
              getListNfsSharesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
                          com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNfsShares"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListNfsShares"))
                      .build();
        }
      }
    }
    return getListNfsSharesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
          com.google.longrunning.Operation>
      getUpdateNfsShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNfsShare",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
          com.google.longrunning.Operation>
      getUpdateNfsShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
            com.google.longrunning.Operation>
        getUpdateNfsShareMethod;
    if ((getUpdateNfsShareMethod = BareMetalSolutionGrpc.getUpdateNfsShareMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateNfsShareMethod = BareMetalSolutionGrpc.getUpdateNfsShareMethod) == null) {
          BareMetalSolutionGrpc.getUpdateNfsShareMethod =
              getUpdateNfsShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNfsShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("UpdateNfsShare"))
                      .build();
        }
      }
    }
    return getUpdateNfsShareMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BareMetalSolutionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionStub>() {
          @java.lang.Override
          public BareMetalSolutionStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BareMetalSolutionStub(channel, callOptions);
          }
        };
    return BareMetalSolutionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BareMetalSolutionBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionBlockingStub>() {
          @java.lang.Override
          public BareMetalSolutionBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BareMetalSolutionBlockingStub(channel, callOptions);
          }
        };
    return BareMetalSolutionBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BareMetalSolutionFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BareMetalSolutionFutureStub>() {
          @java.lang.Override
          public BareMetalSolutionFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BareMetalSolutionFutureStub(channel, callOptions);
          }
        };
    return BareMetalSolutionFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Performs management operations on Bare Metal Solution servers.
   * The `baremetalsolution.googleapis.com` service provides management
   * capabilities for Bare Metal Solution servers. To access the API methods, you
   * must assign Bare Metal Solution IAM roles containing the desired permissions
   * to your staff in your Google Cloud project. You must also enable the Bare
   * Metal Solution API. Once enabled, the methods act
   * upon specific servers in your Bare Metal Solution environment.
   * </pre>
   */
  public abstract static class BareMetalSolutionImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * List servers in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.baremetalsolution.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a single server.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.baremetalsolution.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single server.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform an ungraceful, hard reset on a server. Equivalent to shutting the
     * power off and then turning it back on.
     * </pre>
     */
    public void resetInstance(
        com.google.cloud.baremetalsolution.v2.ResetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a server that was shutdown.
     * </pre>
     */
    public void startInstance(
        com.google.cloud.baremetalsolution.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stop a running server.
     * </pre>
     */
    public void stopInstance(
        com.google.cloud.baremetalsolution.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detach LUN from Instance.
     * </pre>
     */
    public void detachLun(
        com.google.cloud.baremetalsolution.v2.DetachLunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetachLunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volumes in a given project and location.
     * </pre>
     */
    public void listVolumes(
        com.google.cloud.baremetalsolution.v2.ListVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVolumesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume.
     * </pre>
     */
    public void getVolume(
        com.google.cloud.baremetalsolution.v2.GetVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single storage volume.
     * </pre>
     */
    public void updateVolume(
        com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Emergency Volume resize.
     * </pre>
     */
    public void resizeVolume(
        com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResizeVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List network in a given project and location.
     * </pre>
     */
    public void listNetworks(
        com.google.cloud.baremetalsolution.v2.ListNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNetworksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Networks (and used IPs for each Network) in the vendor account
     * associated with the specified project.
     * </pre>
     */
    public void listNetworkUsage(
        com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNetworkUsageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single network.
     * </pre>
     */
    public void getNetwork(
        com.google.cloud.baremetalsolution.v2.GetNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single network.
     * </pre>
     */
    public void updateNetwork(
        com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage logical unit number(LUN).
     * </pre>
     */
    public void getLun(
        com.google.cloud.baremetalsolution.v2.GetLunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Lun> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volume luns for given storage volume.
     * </pre>
     */
    public void listLuns(
        com.google.cloud.baremetalsolution.v2.ListLunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListLunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single NFS share.
     * </pre>
     */
    public void getNfsShare(
        com.google.cloud.baremetalsolution.v2.GetNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNfsShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List NFS shares.
     * </pre>
     */
    public void listNfsShares(
        com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNfsSharesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single NFS share.
     * </pre>
     */
    public void updateNfsShare(
        com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNfsShareMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListInstancesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
                      com.google.cloud.baremetalsolution.v2.ListInstancesResponse>(
                      this, METHODID_LIST_INSTANCES)))
          .addMethod(
              getGetInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
                      com.google.cloud.baremetalsolution.v2.Instance>(this, METHODID_GET_INSTANCE)))
          .addMethod(
              getUpdateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
              getResetInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESET_INSTANCE)))
          .addMethod(
              getStartInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_START_INSTANCE)))
          .addMethod(
              getStopInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_STOP_INSTANCE)))
          .addMethod(
              getDetachLunMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.DetachLunRequest,
                      com.google.longrunning.Operation>(this, METHODID_DETACH_LUN)))
          .addMethod(
              getListVolumesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
                      com.google.cloud.baremetalsolution.v2.ListVolumesResponse>(
                      this, METHODID_LIST_VOLUMES)))
          .addMethod(
              getGetVolumeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
                      com.google.cloud.baremetalsolution.v2.Volume>(this, METHODID_GET_VOLUME)))
          .addMethod(
              getUpdateVolumeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_VOLUME)))
          .addMethod(
              getResizeVolumeMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESIZE_VOLUME)))
          .addMethod(
              getListNetworksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
                      com.google.cloud.baremetalsolution.v2.ListNetworksResponse>(
                      this, METHODID_LIST_NETWORKS)))
          .addMethod(
              getListNetworkUsageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
                      com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>(
                      this, METHODID_LIST_NETWORK_USAGE)))
          .addMethod(
              getGetNetworkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
                      com.google.cloud.baremetalsolution.v2.Network>(this, METHODID_GET_NETWORK)))
          .addMethod(
              getUpdateNetworkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_NETWORK)))
          .addMethod(
              getGetLunMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetLunRequest,
                      com.google.cloud.baremetalsolution.v2.Lun>(this, METHODID_GET_LUN)))
          .addMethod(
              getListLunsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListLunsRequest,
                      com.google.cloud.baremetalsolution.v2.ListLunsResponse>(
                      this, METHODID_LIST_LUNS)))
          .addMethod(
              getGetNfsShareMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
                      com.google.cloud.baremetalsolution.v2.NfsShare>(
                      this, METHODID_GET_NFS_SHARE)))
          .addMethod(
              getListNfsSharesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
                      com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>(
                      this, METHODID_LIST_NFS_SHARES)))
          .addMethod(
              getUpdateNfsShareMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_NFS_SHARE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Performs management operations on Bare Metal Solution servers.
   * The `baremetalsolution.googleapis.com` service provides management
   * capabilities for Bare Metal Solution servers. To access the API methods, you
   * must assign Bare Metal Solution IAM roles containing the desired permissions
   * to your staff in your Google Cloud project. You must also enable the Bare
   * Metal Solution API. Once enabled, the methods act
   * upon specific servers in your Bare Metal Solution environment.
   * </pre>
   */
  public static final class BareMetalSolutionStub
      extends io.grpc.stub.AbstractAsyncStub<BareMetalSolutionStub> {
    private BareMetalSolutionStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BareMetalSolutionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BareMetalSolutionStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List servers in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.baremetalsolution.v2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
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
     * Get details about a single server.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.baremetalsolution.v2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single server.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest request,
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
     * Perform an ungraceful, hard reset on a server. Equivalent to shutting the
     * power off and then turning it back on.
     * </pre>
     */
    public void resetInstance(
        com.google.cloud.baremetalsolution.v2.ResetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a server that was shutdown.
     * </pre>
     */
    public void startInstance(
        com.google.cloud.baremetalsolution.v2.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stop a running server.
     * </pre>
     */
    public void stopInstance(
        com.google.cloud.baremetalsolution.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detach LUN from Instance.
     * </pre>
     */
    public void detachLun(
        com.google.cloud.baremetalsolution.v2.DetachLunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetachLunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volumes in a given project and location.
     * </pre>
     */
    public void listVolumes(
        com.google.cloud.baremetalsolution.v2.ListVolumesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
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
     * Get details of a single storage volume.
     * </pre>
     */
    public void getVolume(
        com.google.cloud.baremetalsolution.v2.GetVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVolumeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single storage volume.
     * </pre>
     */
    public void updateVolume(
        com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest request,
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
     * Emergency Volume resize.
     * </pre>
     */
    public void resizeVolume(
        com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResizeVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List network in a given project and location.
     * </pre>
     */
    public void listNetworks(
        com.google.cloud.baremetalsolution.v2.ListNetworksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworksMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all Networks (and used IPs for each Network) in the vendor account
     * associated with the specified project.
     * </pre>
     */
    public void listNetworkUsage(
        com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNetworkUsageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single network.
     * </pre>
     */
    public void getNetwork(
        com.google.cloud.baremetalsolution.v2.GetNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNetworkMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single network.
     * </pre>
     */
    public void updateNetwork(
        com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage logical unit number(LUN).
     * </pre>
     */
    public void getLun(
        com.google.cloud.baremetalsolution.v2.GetLunRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Lun> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volume luns for given storage volume.
     * </pre>
     */
    public void listLuns(
        com.google.cloud.baremetalsolution.v2.ListLunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListLunsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLunsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single NFS share.
     * </pre>
     */
    public void getNfsShare(
        com.google.cloud.baremetalsolution.v2.GetNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNfsShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List NFS shares.
     * </pre>
     */
    public void listNfsShares(
        com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNfsSharesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single NFS share.
     * </pre>
     */
    public void updateNfsShare(
        com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNfsShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Performs management operations on Bare Metal Solution servers.
   * The `baremetalsolution.googleapis.com` service provides management
   * capabilities for Bare Metal Solution servers. To access the API methods, you
   * must assign Bare Metal Solution IAM roles containing the desired permissions
   * to your staff in your Google Cloud project. You must also enable the Bare
   * Metal Solution API. Once enabled, the methods act
   * upon specific servers in your Bare Metal Solution environment.
   * </pre>
   */
  public static final class BareMetalSolutionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BareMetalSolutionBlockingStub> {
    private BareMetalSolutionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BareMetalSolutionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BareMetalSolutionBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List servers in a given project and location.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListInstancesResponse listInstances(
        com.google.cloud.baremetalsolution.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a single server.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Instance getInstance(
        com.google.cloud.baremetalsolution.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single server.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Perform an ungraceful, hard reset on a server. Equivalent to shutting the
     * power off and then turning it back on.
     * </pre>
     */
    public com.google.longrunning.Operation resetInstance(
        com.google.cloud.baremetalsolution.v2.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a server that was shutdown.
     * </pre>
     */
    public com.google.longrunning.Operation startInstance(
        com.google.cloud.baremetalsolution.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stop a running server.
     * </pre>
     */
    public com.google.longrunning.Operation stopInstance(
        com.google.cloud.baremetalsolution.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Detach LUN from Instance.
     * </pre>
     */
    public com.google.longrunning.Operation detachLun(
        com.google.cloud.baremetalsolution.v2.DetachLunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetachLunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volumes in a given project and location.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListVolumesResponse listVolumes(
        com.google.cloud.baremetalsolution.v2.ListVolumesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVolumesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Volume getVolume(
        com.google.cloud.baremetalsolution.v2.GetVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single storage volume.
     * </pre>
     */
    public com.google.longrunning.Operation updateVolume(
        com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Emergency Volume resize.
     * </pre>
     */
    public com.google.longrunning.Operation resizeVolume(
        com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResizeVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List network in a given project and location.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListNetworksResponse listNetworks(
        com.google.cloud.baremetalsolution.v2.ListNetworksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all Networks (and used IPs for each Network) in the vendor account
     * associated with the specified project.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse listNetworkUsage(
        com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNetworkUsageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single network.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Network getNetwork(
        com.google.cloud.baremetalsolution.v2.GetNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single network.
     * </pre>
     */
    public com.google.longrunning.Operation updateNetwork(
        com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage logical unit number(LUN).
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Lun getLun(
        com.google.cloud.baremetalsolution.v2.GetLunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLunMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volume luns for given storage volume.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListLunsResponse listLuns(
        com.google.cloud.baremetalsolution.v2.ListLunsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLunsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single NFS share.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.NfsShare getNfsShare(
        com.google.cloud.baremetalsolution.v2.GetNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNfsShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List NFS shares.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse listNfsShares(
        com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNfsSharesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single NFS share.
     * </pre>
     */
    public com.google.longrunning.Operation updateNfsShare(
        com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNfsShareMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Performs management operations on Bare Metal Solution servers.
   * The `baremetalsolution.googleapis.com` service provides management
   * capabilities for Bare Metal Solution servers. To access the API methods, you
   * must assign Bare Metal Solution IAM roles containing the desired permissions
   * to your staff in your Google Cloud project. You must also enable the Bare
   * Metal Solution API. Once enabled, the methods act
   * upon specific servers in your Bare Metal Solution environment.
   * </pre>
   */
  public static final class BareMetalSolutionFutureStub
      extends io.grpc.stub.AbstractFutureStub<BareMetalSolutionFutureStub> {
    private BareMetalSolutionFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BareMetalSolutionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BareMetalSolutionFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List servers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListInstancesResponse>
        listInstances(com.google.cloud.baremetalsolution.v2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a single server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Instance>
        getInstance(com.google.cloud.baremetalsolution.v2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Perform an ungraceful, hard reset on a server. Equivalent to shutting the
     * power off and then turning it back on.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resetInstance(com.google.cloud.baremetalsolution.v2.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a server that was shutdown.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startInstance(com.google.cloud.baremetalsolution.v2.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stop a running server.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopInstance(com.google.cloud.baremetalsolution.v2.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Detach LUN from Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        detachLun(com.google.cloud.baremetalsolution.v2.DetachLunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetachLunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volumes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListVolumesResponse>
        listVolumes(com.google.cloud.baremetalsolution.v2.ListVolumesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVolumesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Volume>
        getVolume(com.google.cloud.baremetalsolution.v2.GetVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single storage volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateVolume(com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Emergency Volume resize.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resizeVolume(com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResizeVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List network in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListNetworksResponse>
        listNetworks(com.google.cloud.baremetalsolution.v2.ListNetworksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all Networks (and used IPs for each Network) in the vendor account
     * associated with the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>
        listNetworkUsage(com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNetworkUsageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Network>
        getNetwork(com.google.cloud.baremetalsolution.v2.GetNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single network.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateNetwork(com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage logical unit number(LUN).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Lun>
        getLun(com.google.cloud.baremetalsolution.v2.GetLunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLunMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volume luns for given storage volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListLunsResponse>
        listLuns(com.google.cloud.baremetalsolution.v2.ListLunsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLunsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single NFS share.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.NfsShare>
        getNfsShare(com.google.cloud.baremetalsolution.v2.GetNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNfsShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List NFS shares.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>
        listNfsShares(com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNfsSharesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update details of a single NFS share.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateNfsShare(com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNfsShareMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_UPDATE_INSTANCE = 2;
  private static final int METHODID_RESET_INSTANCE = 3;
  private static final int METHODID_START_INSTANCE = 4;
  private static final int METHODID_STOP_INSTANCE = 5;
  private static final int METHODID_DETACH_LUN = 6;
  private static final int METHODID_LIST_VOLUMES = 7;
  private static final int METHODID_GET_VOLUME = 8;
  private static final int METHODID_UPDATE_VOLUME = 9;
  private static final int METHODID_RESIZE_VOLUME = 10;
  private static final int METHODID_LIST_NETWORKS = 11;
  private static final int METHODID_LIST_NETWORK_USAGE = 12;
  private static final int METHODID_GET_NETWORK = 13;
  private static final int METHODID_UPDATE_NETWORK = 14;
  private static final int METHODID_GET_LUN = 15;
  private static final int METHODID_LIST_LUNS = 16;
  private static final int METHODID_GET_NFS_SHARE = 17;
  private static final int METHODID_LIST_NFS_SHARES = 18;
  private static final int METHODID_UPDATE_NFS_SHARE = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BareMetalSolutionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BareMetalSolutionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.baremetalsolution.v2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.baremetalsolution.v2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>)
                  responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_INSTANCE:
          serviceImpl.resetInstance(
              (com.google.cloud.baremetalsolution.v2.ResetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_INSTANCE:
          serviceImpl.startInstance(
              (com.google.cloud.baremetalsolution.v2.StartInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_INSTANCE:
          serviceImpl.stopInstance(
              (com.google.cloud.baremetalsolution.v2.StopInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DETACH_LUN:
          serviceImpl.detachLun(
              (com.google.cloud.baremetalsolution.v2.DetachLunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VOLUMES:
          serviceImpl.listVolumes(
              (com.google.cloud.baremetalsolution.v2.ListVolumesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListVolumesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOLUME:
          serviceImpl.getVolume(
              (com.google.cloud.baremetalsolution.v2.GetVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VOLUME:
          serviceImpl.updateVolume(
              (com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESIZE_VOLUME:
          serviceImpl.resizeVolume(
              (com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_NETWORKS:
          serviceImpl.listNetworks(
              (com.google.cloud.baremetalsolution.v2.ListNetworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListNetworksResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_NETWORK_USAGE:
          serviceImpl.listNetworkUsage(
              (com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NETWORK:
          serviceImpl.getNetwork(
              (com.google.cloud.baremetalsolution.v2.GetNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NETWORK:
          serviceImpl.updateNetwork(
              (com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_LUN:
          serviceImpl.getLun(
              (com.google.cloud.baremetalsolution.v2.GetLunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Lun>)
                  responseObserver);
          break;
        case METHODID_LIST_LUNS:
          serviceImpl.listLuns(
              (com.google.cloud.baremetalsolution.v2.ListLunsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListLunsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NFS_SHARE:
          serviceImpl.getNfsShare(
              (com.google.cloud.baremetalsolution.v2.GetNfsShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>)
                  responseObserver);
          break;
        case METHODID_LIST_NFS_SHARES:
          serviceImpl.listNfsShares(
              (com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NFS_SHARE:
          serviceImpl.updateNfsShare(
              (com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest) request,
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

  private abstract static class BareMetalSolutionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BareMetalSolutionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.baremetalsolution.v2.BareMetalSolutionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BareMetalSolution");
    }
  }

  private static final class BareMetalSolutionFileDescriptorSupplier
      extends BareMetalSolutionBaseDescriptorSupplier {
    BareMetalSolutionFileDescriptorSupplier() {}
  }

  private static final class BareMetalSolutionMethodDescriptorSupplier
      extends BareMetalSolutionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BareMetalSolutionMethodDescriptorSupplier(String methodName) {
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
      synchronized (BareMetalSolutionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BareMetalSolutionFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getResetInstanceMethod())
                      .addMethod(getStartInstanceMethod())
                      .addMethod(getStopInstanceMethod())
                      .addMethod(getDetachLunMethod())
                      .addMethod(getListVolumesMethod())
                      .addMethod(getGetVolumeMethod())
                      .addMethod(getUpdateVolumeMethod())
                      .addMethod(getResizeVolumeMethod())
                      .addMethod(getListNetworksMethod())
                      .addMethod(getListNetworkUsageMethod())
                      .addMethod(getGetNetworkMethod())
                      .addMethod(getUpdateNetworkMethod())
                      .addMethod(getGetLunMethod())
                      .addMethod(getListLunsMethod())
                      .addMethod(getGetNfsShareMethod())
                      .addMethod(getListNfsSharesMethod())
                      .addMethod(getUpdateNfsShareMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
