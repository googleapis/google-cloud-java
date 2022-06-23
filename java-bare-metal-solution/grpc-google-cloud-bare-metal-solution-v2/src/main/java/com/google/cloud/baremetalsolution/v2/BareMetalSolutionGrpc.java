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
          com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest,
          com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
      getListSnapshotSchedulePoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSnapshotSchedulePolicies",
      requestType = com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest.class,
      responseType =
          com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest,
          com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
      getListSnapshotSchedulePoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest,
            com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
        getListSnapshotSchedulePoliciesMethod;
    if ((getListSnapshotSchedulePoliciesMethod =
            BareMetalSolutionGrpc.getListSnapshotSchedulePoliciesMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListSnapshotSchedulePoliciesMethod =
                BareMetalSolutionGrpc.getListSnapshotSchedulePoliciesMethod)
            == null) {
          BareMetalSolutionGrpc.getListSnapshotSchedulePoliciesMethod =
              getListSnapshotSchedulePoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest,
                          com.google.cloud.baremetalsolution.v2
                              .ListSnapshotSchedulePoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSnapshotSchedulePolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .ListSnapshotSchedulePoliciesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .ListSnapshotSchedulePoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "ListSnapshotSchedulePolicies"))
                      .build();
        }
      }
    }
    return getListSnapshotSchedulePoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getGetSnapshotSchedulePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSnapshotSchedulePolicy",
      requestType = com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getGetSnapshotSchedulePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest,
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        getGetSnapshotSchedulePolicyMethod;
    if ((getGetSnapshotSchedulePolicyMethod =
            BareMetalSolutionGrpc.getGetSnapshotSchedulePolicyMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetSnapshotSchedulePolicyMethod =
                BareMetalSolutionGrpc.getGetSnapshotSchedulePolicyMethod)
            == null) {
          BareMetalSolutionGrpc.getGetSnapshotSchedulePolicyMethod =
              getGetSnapshotSchedulePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest,
                          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetSnapshotSchedulePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "GetSnapshotSchedulePolicy"))
                      .build();
        }
      }
    }
    return getGetSnapshotSchedulePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getCreateSnapshotSchedulePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSnapshotSchedulePolicy",
      requestType = com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getCreateSnapshotSchedulePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest,
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        getCreateSnapshotSchedulePolicyMethod;
    if ((getCreateSnapshotSchedulePolicyMethod =
            BareMetalSolutionGrpc.getCreateSnapshotSchedulePolicyMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getCreateSnapshotSchedulePolicyMethod =
                BareMetalSolutionGrpc.getCreateSnapshotSchedulePolicyMethod)
            == null) {
          BareMetalSolutionGrpc.getCreateSnapshotSchedulePolicyMethod =
              getCreateSnapshotSchedulePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest,
                          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSnapshotSchedulePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .CreateSnapshotSchedulePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "CreateSnapshotSchedulePolicy"))
                      .build();
        }
      }
    }
    return getCreateSnapshotSchedulePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getUpdateSnapshotSchedulePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSnapshotSchedulePolicy",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest,
          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
      getUpdateSnapshotSchedulePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest,
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        getUpdateSnapshotSchedulePolicyMethod;
    if ((getUpdateSnapshotSchedulePolicyMethod =
            BareMetalSolutionGrpc.getUpdateSnapshotSchedulePolicyMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateSnapshotSchedulePolicyMethod =
                BareMetalSolutionGrpc.getUpdateSnapshotSchedulePolicyMethod)
            == null) {
          BareMetalSolutionGrpc.getUpdateSnapshotSchedulePolicyMethod =
              getUpdateSnapshotSchedulePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest,
                          com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSnapshotSchedulePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .UpdateSnapshotSchedulePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "UpdateSnapshotSchedulePolicy"))
                      .build();
        }
      }
    }
    return getUpdateSnapshotSchedulePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest,
          com.google.protobuf.Empty>
      getDeleteSnapshotSchedulePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSnapshotSchedulePolicy",
      requestType = com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest,
          com.google.protobuf.Empty>
      getDeleteSnapshotSchedulePolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest,
            com.google.protobuf.Empty>
        getDeleteSnapshotSchedulePolicyMethod;
    if ((getDeleteSnapshotSchedulePolicyMethod =
            BareMetalSolutionGrpc.getDeleteSnapshotSchedulePolicyMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDeleteSnapshotSchedulePolicyMethod =
                BareMetalSolutionGrpc.getDeleteSnapshotSchedulePolicyMethod)
            == null) {
          BareMetalSolutionGrpc.getDeleteSnapshotSchedulePolicyMethod =
              getDeleteSnapshotSchedulePolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSnapshotSchedulePolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .DeleteSnapshotSchedulePolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "DeleteSnapshotSchedulePolicy"))
                      .build();
        }
      }
    }
    return getDeleteSnapshotSchedulePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
      getCreateVolumeSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVolumeSnapshot",
      requestType = com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.VolumeSnapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
      getCreateVolumeSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
            com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
        getCreateVolumeSnapshotMethod;
    if ((getCreateVolumeSnapshotMethod = BareMetalSolutionGrpc.getCreateVolumeSnapshotMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getCreateVolumeSnapshotMethod = BareMetalSolutionGrpc.getCreateVolumeSnapshotMethod)
            == null) {
          BareMetalSolutionGrpc.getCreateVolumeSnapshotMethod =
              getCreateVolumeSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
                          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateVolumeSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.VolumeSnapshot
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("CreateVolumeSnapshot"))
                      .build();
        }
      }
    }
    return getCreateVolumeSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
          com.google.longrunning.Operation>
      getRestoreVolumeSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestoreVolumeSnapshot",
      requestType = com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
          com.google.longrunning.Operation>
      getRestoreVolumeSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
            com.google.longrunning.Operation>
        getRestoreVolumeSnapshotMethod;
    if ((getRestoreVolumeSnapshotMethod = BareMetalSolutionGrpc.getRestoreVolumeSnapshotMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getRestoreVolumeSnapshotMethod = BareMetalSolutionGrpc.getRestoreVolumeSnapshotMethod)
            == null) {
          BareMetalSolutionGrpc.getRestoreVolumeSnapshotMethod =
              getRestoreVolumeSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestoreVolumeSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("RestoreVolumeSnapshot"))
                      .build();
        }
      }
    }
    return getRestoreVolumeSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
          com.google.protobuf.Empty>
      getDeleteVolumeSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVolumeSnapshot",
      requestType = com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
          com.google.protobuf.Empty>
      getDeleteVolumeSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
            com.google.protobuf.Empty>
        getDeleteVolumeSnapshotMethod;
    if ((getDeleteVolumeSnapshotMethod = BareMetalSolutionGrpc.getDeleteVolumeSnapshotMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDeleteVolumeSnapshotMethod = BareMetalSolutionGrpc.getDeleteVolumeSnapshotMethod)
            == null) {
          BareMetalSolutionGrpc.getDeleteVolumeSnapshotMethod =
              getDeleteVolumeSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteVolumeSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("DeleteVolumeSnapshot"))
                      .build();
        }
      }
    }
    return getDeleteVolumeSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
      getGetVolumeSnapshotMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVolumeSnapshot",
      requestType = com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.VolumeSnapshot.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
      getGetVolumeSnapshotMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
            com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
        getGetVolumeSnapshotMethod;
    if ((getGetVolumeSnapshotMethod = BareMetalSolutionGrpc.getGetVolumeSnapshotMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetVolumeSnapshotMethod = BareMetalSolutionGrpc.getGetVolumeSnapshotMethod)
            == null) {
          BareMetalSolutionGrpc.getGetVolumeSnapshotMethod =
              getGetVolumeSnapshotMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
                          com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVolumeSnapshot"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.VolumeSnapshot
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetVolumeSnapshot"))
                      .build();
        }
      }
    }
    return getGetVolumeSnapshotMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
          com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
      getListVolumeSnapshotsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVolumeSnapshots",
      requestType = com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
          com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
      getListVolumeSnapshotsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
            com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
        getListVolumeSnapshotsMethod;
    if ((getListVolumeSnapshotsMethod = BareMetalSolutionGrpc.getListVolumeSnapshotsMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListVolumeSnapshotsMethod = BareMetalSolutionGrpc.getListVolumeSnapshotsMethod)
            == null) {
          BareMetalSolutionGrpc.getListVolumeSnapshotsMethod =
              getListVolumeSnapshotsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
                          com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVolumeSnapshots"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListVolumeSnapshots"))
                      .build();
        }
      }
    }
    return getListVolumeSnapshotsMethod;
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
     * List snapshot schedule policies in a given project and location.
     * </pre>
     */
    public void listSnapshotSchedulePolicies(
        com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSnapshotSchedulePoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single snapshot schedule policy.
     * </pre>
     */
    public void getSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSnapshotSchedulePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a snapshot schedule policy in the specified project.
     * </pre>
     */
    public void createSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSnapshotSchedulePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a snapshot schedule policy in the specified project.
     * </pre>
     */
    public void updateSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSnapshotSchedulePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a named snapshot schedule policy.
     * </pre>
     */
    public void deleteSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSnapshotSchedulePolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a storage volume snapshot in a containing volume.
     * </pre>
     */
    public void createVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restore a storage volume snapshot to its containing volume.
     * </pre>
     */
    public void restoreVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a storage volume snapshot for a given volume.
     * </pre>
     */
    public void deleteVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume snapshot.
     * </pre>
     */
    public void getVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volume snapshots for given storage volume.
     * </pre>
     */
    public void listVolumeSnapshots(
        com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVolumeSnapshotsMethod(), responseObserver);
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
              getResetInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESET_INSTANCE)))
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
              getListNetworksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
                      com.google.cloud.baremetalsolution.v2.ListNetworksResponse>(
                      this, METHODID_LIST_NETWORKS)))
          .addMethod(
              getGetNetworkMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
                      com.google.cloud.baremetalsolution.v2.Network>(this, METHODID_GET_NETWORK)))
          .addMethod(
              getListSnapshotSchedulePoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest,
                      com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>(
                      this, METHODID_LIST_SNAPSHOT_SCHEDULE_POLICIES)))
          .addMethod(
              getGetSnapshotSchedulePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest,
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>(
                      this, METHODID_GET_SNAPSHOT_SCHEDULE_POLICY)))
          .addMethod(
              getCreateSnapshotSchedulePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest,
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>(
                      this, METHODID_CREATE_SNAPSHOT_SCHEDULE_POLICY)))
          .addMethod(
              getUpdateSnapshotSchedulePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest,
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>(
                      this, METHODID_UPDATE_SNAPSHOT_SCHEDULE_POLICY)))
          .addMethod(
              getDeleteSnapshotSchedulePolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SNAPSHOT_SCHEDULE_POLICY)))
          .addMethod(
              getCreateVolumeSnapshotMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
                      com.google.cloud.baremetalsolution.v2.VolumeSnapshot>(
                      this, METHODID_CREATE_VOLUME_SNAPSHOT)))
          .addMethod(
              getRestoreVolumeSnapshotMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTORE_VOLUME_SNAPSHOT)))
          .addMethod(
              getDeleteVolumeSnapshotMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_VOLUME_SNAPSHOT)))
          .addMethod(
              getGetVolumeSnapshotMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
                      com.google.cloud.baremetalsolution.v2.VolumeSnapshot>(
                      this, METHODID_GET_VOLUME_SNAPSHOT)))
          .addMethod(
              getListVolumeSnapshotsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
                      com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>(
                      this, METHODID_LIST_VOLUME_SNAPSHOTS)))
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
     * List snapshot schedule policies in a given project and location.
     * </pre>
     */
    public void listSnapshotSchedulePolicies(
        com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSnapshotSchedulePoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single snapshot schedule policy.
     * </pre>
     */
    public void getSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSnapshotSchedulePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a snapshot schedule policy in the specified project.
     * </pre>
     */
    public void createSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSnapshotSchedulePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a snapshot schedule policy in the specified project.
     * </pre>
     */
    public void updateSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSnapshotSchedulePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a named snapshot schedule policy.
     * </pre>
     */
    public void deleteSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSnapshotSchedulePolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a storage volume snapshot in a containing volume.
     * </pre>
     */
    public void createVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVolumeSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restore a storage volume snapshot to its containing volume.
     * </pre>
     */
    public void restoreVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreVolumeSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a storage volume snapshot for a given volume.
     * </pre>
     */
    public void deleteVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVolumeSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume snapshot.
     * </pre>
     */
    public void getVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVolumeSnapshotMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volume snapshots for given storage volume.
     * </pre>
     */
    public void listVolumeSnapshots(
        com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVolumeSnapshotsMethod(), getCallOptions()),
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
     * List snapshot schedule policies in a given project and location.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse
        listSnapshotSchedulePolicies(
            com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSnapshotSchedulePoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single snapshot schedule policy.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy getSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSnapshotSchedulePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a snapshot schedule policy in the specified project.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy
        createSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSnapshotSchedulePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a snapshot schedule policy in the specified project.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy
        updateSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSnapshotSchedulePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a named snapshot schedule policy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSnapshotSchedulePolicy(
        com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSnapshotSchedulePolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a storage volume snapshot in a containing volume.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.VolumeSnapshot createVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVolumeSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restore a storage volume snapshot to its containing volume.
     * </pre>
     */
    public com.google.longrunning.Operation restoreVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreVolumeSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a storage volume snapshot for a given volume.
     * </pre>
     */
    public com.google.protobuf.Empty deleteVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVolumeSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume snapshot.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.VolumeSnapshot getVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVolumeSnapshotMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volume snapshots for given storage volume.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse listVolumeSnapshots(
        com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVolumeSnapshotsMethod(), getCallOptions(), request);
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
     * List snapshot schedule policies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>
        listSnapshotSchedulePolicies(
            com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSnapshotSchedulePoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single snapshot schedule policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        getSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSnapshotSchedulePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a snapshot schedule policy in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        createSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSnapshotSchedulePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a snapshot schedule policy in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>
        updateSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSnapshotSchedulePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a named snapshot schedule policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSnapshotSchedulePolicy(
            com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSnapshotSchedulePolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a storage volume snapshot in a containing volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
        createVolumeSnapshot(
            com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVolumeSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restore a storage volume snapshot to its containing volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restoreVolumeSnapshot(
            com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreVolumeSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a storage volume snapshot for a given volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteVolumeSnapshot(
            com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVolumeSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single storage volume snapshot.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.VolumeSnapshot>
        getVolumeSnapshot(com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVolumeSnapshotMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List storage volume snapshots for given storage volume.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>
        listVolumeSnapshots(
            com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVolumeSnapshotsMethod(), getCallOptions()), request);
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
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_RESET_INSTANCE = 2;
  private static final int METHODID_LIST_VOLUMES = 3;
  private static final int METHODID_GET_VOLUME = 4;
  private static final int METHODID_UPDATE_VOLUME = 5;
  private static final int METHODID_LIST_NETWORKS = 6;
  private static final int METHODID_GET_NETWORK = 7;
  private static final int METHODID_LIST_SNAPSHOT_SCHEDULE_POLICIES = 8;
  private static final int METHODID_GET_SNAPSHOT_SCHEDULE_POLICY = 9;
  private static final int METHODID_CREATE_SNAPSHOT_SCHEDULE_POLICY = 10;
  private static final int METHODID_UPDATE_SNAPSHOT_SCHEDULE_POLICY = 11;
  private static final int METHODID_DELETE_SNAPSHOT_SCHEDULE_POLICY = 12;
  private static final int METHODID_CREATE_VOLUME_SNAPSHOT = 13;
  private static final int METHODID_RESTORE_VOLUME_SNAPSHOT = 14;
  private static final int METHODID_DELETE_VOLUME_SNAPSHOT = 15;
  private static final int METHODID_GET_VOLUME_SNAPSHOT = 16;
  private static final int METHODID_LIST_VOLUME_SNAPSHOTS = 17;
  private static final int METHODID_GET_LUN = 18;
  private static final int METHODID_LIST_LUNS = 19;

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
        case METHODID_RESET_INSTANCE:
          serviceImpl.resetInstance(
              (com.google.cloud.baremetalsolution.v2.ResetInstanceRequest) request,
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
        case METHODID_LIST_NETWORKS:
          serviceImpl.listNetworks(
              (com.google.cloud.baremetalsolution.v2.ListNetworksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListNetworksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NETWORK:
          serviceImpl.getNetwork(
              (com.google.cloud.baremetalsolution.v2.GetNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>)
                  responseObserver);
          break;
        case METHODID_LIST_SNAPSHOT_SCHEDULE_POLICIES:
          serviceImpl.listSnapshotSchedulePolicies(
              (com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SNAPSHOT_SCHEDULE_POLICY:
          serviceImpl.getSnapshotSchedulePolicy(
              (com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_SNAPSHOT_SCHEDULE_POLICY:
          serviceImpl.createSnapshotSchedulePolicy(
              (com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SNAPSHOT_SCHEDULE_POLICY:
          serviceImpl.updateSnapshotSchedulePolicy(
              (com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy>)
                  responseObserver);
          break;
        case METHODID_DELETE_SNAPSHOT_SCHEDULE_POLICY:
          serviceImpl.deleteSnapshotSchedulePolicy(
              (com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_VOLUME_SNAPSHOT:
          serviceImpl.createVolumeSnapshot(
              (com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>)
                  responseObserver);
          break;
        case METHODID_RESTORE_VOLUME_SNAPSHOT:
          serviceImpl.restoreVolumeSnapshot(
              (com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VOLUME_SNAPSHOT:
          serviceImpl.deleteVolumeSnapshot(
              (com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_VOLUME_SNAPSHOT:
          serviceImpl.getVolumeSnapshot(
              (com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.VolumeSnapshot>)
                  responseObserver);
          break;
        case METHODID_LIST_VOLUME_SNAPSHOTS:
          serviceImpl.listVolumeSnapshots(
              (com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>)
                  responseObserver);
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
      return com.google.cloud.baremetalsolution.v2.BaremetalsolutionProto.getDescriptor();
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
                      .addMethod(getResetInstanceMethod())
                      .addMethod(getListVolumesMethod())
                      .addMethod(getGetVolumeMethod())
                      .addMethod(getUpdateVolumeMethod())
                      .addMethod(getListNetworksMethod())
                      .addMethod(getGetNetworkMethod())
                      .addMethod(getListSnapshotSchedulePoliciesMethod())
                      .addMethod(getGetSnapshotSchedulePolicyMethod())
                      .addMethod(getCreateSnapshotSchedulePolicyMethod())
                      .addMethod(getUpdateSnapshotSchedulePolicyMethod())
                      .addMethod(getDeleteSnapshotSchedulePolicyMethod())
                      .addMethod(getCreateVolumeSnapshotMethod())
                      .addMethod(getRestoreVolumeSnapshotMethod())
                      .addMethod(getDeleteVolumeSnapshotMethod())
                      .addMethod(getGetVolumeSnapshotMethod())
                      .addMethod(getListVolumeSnapshotsMethod())
                      .addMethod(getGetLunMethod())
                      .addMethod(getListLunsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
