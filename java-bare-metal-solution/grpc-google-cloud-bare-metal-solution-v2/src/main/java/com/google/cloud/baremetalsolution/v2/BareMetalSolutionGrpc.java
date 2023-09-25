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

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.baremetalsolution.v2.BareMetalSolution";

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
          com.google.cloud.baremetalsolution.v2.RenameInstanceRequest,
          com.google.cloud.baremetalsolution.v2.Instance>
      getRenameInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameInstance",
      requestType = com.google.cloud.baremetalsolution.v2.RenameInstanceRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameInstanceRequest,
          com.google.cloud.baremetalsolution.v2.Instance>
      getRenameInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.RenameInstanceRequest,
            com.google.cloud.baremetalsolution.v2.Instance>
        getRenameInstanceMethod;
    if ((getRenameInstanceMethod = BareMetalSolutionGrpc.getRenameInstanceMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getRenameInstanceMethod = BareMetalSolutionGrpc.getRenameInstanceMethod) == null) {
          BareMetalSolutionGrpc.getRenameInstanceMethod =
              getRenameInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.RenameInstanceRequest,
                          com.google.cloud.baremetalsolution.v2.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.RenameInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("RenameInstance"))
                      .build();
        }
      }
    }
    return getRenameInstanceMethod;
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
          com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest,
          com.google.longrunning.Operation>
      getEnableInteractiveSerialConsoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableInteractiveSerialConsole",
      requestType =
          com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest,
          com.google.longrunning.Operation>
      getEnableInteractiveSerialConsoleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest,
            com.google.longrunning.Operation>
        getEnableInteractiveSerialConsoleMethod;
    if ((getEnableInteractiveSerialConsoleMethod =
            BareMetalSolutionGrpc.getEnableInteractiveSerialConsoleMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getEnableInteractiveSerialConsoleMethod =
                BareMetalSolutionGrpc.getEnableInteractiveSerialConsoleMethod)
            == null) {
          BareMetalSolutionGrpc.getEnableInteractiveSerialConsoleMethod =
              getEnableInteractiveSerialConsoleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EnableInteractiveSerialConsole"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .EnableInteractiveSerialConsoleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "EnableInteractiveSerialConsole"))
                      .build();
        }
      }
    }
    return getEnableInteractiveSerialConsoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest,
          com.google.longrunning.Operation>
      getDisableInteractiveSerialConsoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableInteractiveSerialConsole",
      requestType =
          com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest,
          com.google.longrunning.Operation>
      getDisableInteractiveSerialConsoleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest,
            com.google.longrunning.Operation>
        getDisableInteractiveSerialConsoleMethod;
    if ((getDisableInteractiveSerialConsoleMethod =
            BareMetalSolutionGrpc.getDisableInteractiveSerialConsoleMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDisableInteractiveSerialConsoleMethod =
                BareMetalSolutionGrpc.getDisableInteractiveSerialConsoleMethod)
            == null) {
          BareMetalSolutionGrpc.getDisableInteractiveSerialConsoleMethod =
              getDisableInteractiveSerialConsoleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2
                              .DisableInteractiveSerialConsoleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DisableInteractiveSerialConsole"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2
                                  .DisableInteractiveSerialConsoleRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier(
                              "DisableInteractiveSerialConsole"))
                      .build();
        }
      }
    }
    return getDisableInteractiveSerialConsoleMethod;
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
          com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest,
          com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
      getListSSHKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSSHKeys",
      requestType = com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest,
          com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
      getListSSHKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest,
            com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
        getListSSHKeysMethod;
    if ((getListSSHKeysMethod = BareMetalSolutionGrpc.getListSSHKeysMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListSSHKeysMethod = BareMetalSolutionGrpc.getListSSHKeysMethod) == null) {
          BareMetalSolutionGrpc.getListSSHKeysMethod =
              getListSSHKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest,
                          com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSSHKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListSSHKeys"))
                      .build();
        }
      }
    }
    return getListSSHKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest,
          com.google.cloud.baremetalsolution.v2.SSHKey>
      getCreateSSHKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSSHKey",
      requestType = com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.SSHKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest,
          com.google.cloud.baremetalsolution.v2.SSHKey>
      getCreateSSHKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest,
            com.google.cloud.baremetalsolution.v2.SSHKey>
        getCreateSSHKeyMethod;
    if ((getCreateSSHKeyMethod = BareMetalSolutionGrpc.getCreateSSHKeyMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getCreateSSHKeyMethod = BareMetalSolutionGrpc.getCreateSSHKeyMethod) == null) {
          BareMetalSolutionGrpc.getCreateSSHKeyMethod =
              getCreateSSHKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest,
                          com.google.cloud.baremetalsolution.v2.SSHKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSSHKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SSHKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("CreateSSHKey"))
                      .build();
        }
      }
    }
    return getCreateSSHKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest, com.google.protobuf.Empty>
      getDeleteSSHKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSSHKey",
      requestType = com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest, com.google.protobuf.Empty>
      getDeleteSSHKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest, com.google.protobuf.Empty>
        getDeleteSSHKeyMethod;
    if ((getDeleteSSHKeyMethod = BareMetalSolutionGrpc.getDeleteSSHKeyMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDeleteSSHKeyMethod = BareMetalSolutionGrpc.getDeleteSSHKeyMethod) == null) {
          BareMetalSolutionGrpc.getDeleteSSHKeyMethod =
              getDeleteSSHKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSSHKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("DeleteSSHKey"))
                      .build();
        }
      }
    }
    return getDeleteSSHKeyMethod;
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
          com.google.cloud.baremetalsolution.v2.RenameVolumeRequest,
          com.google.cloud.baremetalsolution.v2.Volume>
      getRenameVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameVolume",
      requestType = com.google.cloud.baremetalsolution.v2.RenameVolumeRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Volume.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameVolumeRequest,
          com.google.cloud.baremetalsolution.v2.Volume>
      getRenameVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.RenameVolumeRequest,
            com.google.cloud.baremetalsolution.v2.Volume>
        getRenameVolumeMethod;
    if ((getRenameVolumeMethod = BareMetalSolutionGrpc.getRenameVolumeMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getRenameVolumeMethod = BareMetalSolutionGrpc.getRenameVolumeMethod) == null) {
          BareMetalSolutionGrpc.getRenameVolumeMethod =
              getRenameVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.RenameVolumeRequest,
                          com.google.cloud.baremetalsolution.v2.Volume>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.RenameVolumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Volume.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("RenameVolume"))
                      .build();
        }
      }
    }
    return getRenameVolumeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.EvictVolumeRequest,
          com.google.longrunning.Operation>
      getEvictVolumeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EvictVolume",
      requestType = com.google.cloud.baremetalsolution.v2.EvictVolumeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.EvictVolumeRequest,
          com.google.longrunning.Operation>
      getEvictVolumeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.EvictVolumeRequest,
            com.google.longrunning.Operation>
        getEvictVolumeMethod;
    if ((getEvictVolumeMethod = BareMetalSolutionGrpc.getEvictVolumeMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getEvictVolumeMethod = BareMetalSolutionGrpc.getEvictVolumeMethod) == null) {
          BareMetalSolutionGrpc.getEvictVolumeMethod =
              getEvictVolumeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.EvictVolumeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EvictVolume"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.EvictVolumeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("EvictVolume"))
                      .build();
        }
      }
    }
    return getEvictVolumeMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.EvictLunRequest, com.google.longrunning.Operation>
      getEvictLunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EvictLun",
      requestType = com.google.cloud.baremetalsolution.v2.EvictLunRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.EvictLunRequest, com.google.longrunning.Operation>
      getEvictLunMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.EvictLunRequest, com.google.longrunning.Operation>
        getEvictLunMethod;
    if ((getEvictLunMethod = BareMetalSolutionGrpc.getEvictLunMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getEvictLunMethod = BareMetalSolutionGrpc.getEvictLunMethod) == null) {
          BareMetalSolutionGrpc.getEvictLunMethod =
              getEvictLunMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.EvictLunRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EvictLun"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.EvictLunRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("EvictLun"))
                      .build();
        }
      }
    }
    return getEvictLunMethod;
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest,
          com.google.longrunning.Operation>
      getCreateNfsShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNfsShare",
      requestType = com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest,
          com.google.longrunning.Operation>
      getCreateNfsShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest,
            com.google.longrunning.Operation>
        getCreateNfsShareMethod;
    if ((getCreateNfsShareMethod = BareMetalSolutionGrpc.getCreateNfsShareMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getCreateNfsShareMethod = BareMetalSolutionGrpc.getCreateNfsShareMethod) == null) {
          BareMetalSolutionGrpc.getCreateNfsShareMethod =
              getCreateNfsShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNfsShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("CreateNfsShare"))
                      .build();
        }
      }
    }
    return getCreateNfsShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest,
          com.google.cloud.baremetalsolution.v2.NfsShare>
      getRenameNfsShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameNfsShare",
      requestType = com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.NfsShare.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest,
          com.google.cloud.baremetalsolution.v2.NfsShare>
      getRenameNfsShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest,
            com.google.cloud.baremetalsolution.v2.NfsShare>
        getRenameNfsShareMethod;
    if ((getRenameNfsShareMethod = BareMetalSolutionGrpc.getRenameNfsShareMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getRenameNfsShareMethod = BareMetalSolutionGrpc.getRenameNfsShareMethod) == null) {
          BareMetalSolutionGrpc.getRenameNfsShareMethod =
              getRenameNfsShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest,
                          com.google.cloud.baremetalsolution.v2.NfsShare>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameNfsShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.NfsShare.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("RenameNfsShare"))
                      .build();
        }
      }
    }
    return getRenameNfsShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest,
          com.google.longrunning.Operation>
      getDeleteNfsShareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNfsShare",
      requestType = com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest,
          com.google.longrunning.Operation>
      getDeleteNfsShareMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest,
            com.google.longrunning.Operation>
        getDeleteNfsShareMethod;
    if ((getDeleteNfsShareMethod = BareMetalSolutionGrpc.getDeleteNfsShareMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getDeleteNfsShareMethod = BareMetalSolutionGrpc.getDeleteNfsShareMethod) == null) {
          BareMetalSolutionGrpc.getDeleteNfsShareMethod =
              getDeleteNfsShareMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNfsShare"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("DeleteNfsShare"))
                      .build();
        }
      }
    }
    return getDeleteNfsShareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest,
          com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
      getListProvisioningQuotasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProvisioningQuotas",
      requestType = com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest,
          com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
      getListProvisioningQuotasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest,
            com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
        getListProvisioningQuotasMethod;
    if ((getListProvisioningQuotasMethod = BareMetalSolutionGrpc.getListProvisioningQuotasMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListProvisioningQuotasMethod =
                BareMetalSolutionGrpc.getListProvisioningQuotasMethod)
            == null) {
          BareMetalSolutionGrpc.getListProvisioningQuotasMethod =
              getListProvisioningQuotasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest,
                          com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListProvisioningQuotas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListProvisioningQuotas"))
                      .build();
        }
      }
    }
    return getListProvisioningQuotasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
      getSubmitProvisioningConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitProvisioningConfig",
      requestType = com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
      getSubmitProvisioningConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest,
            com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
        getSubmitProvisioningConfigMethod;
    if ((getSubmitProvisioningConfigMethod =
            BareMetalSolutionGrpc.getSubmitProvisioningConfigMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getSubmitProvisioningConfigMethod =
                BareMetalSolutionGrpc.getSubmitProvisioningConfigMethod)
            == null) {
          BareMetalSolutionGrpc.getSubmitProvisioningConfigMethod =
              getSubmitProvisioningConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest,
                          com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SubmitProvisioningConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("SubmitProvisioningConfig"))
                      .build();
        }
      }
    }
    return getSubmitProvisioningConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getGetProvisioningConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProvisioningConfig",
      requestType = com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ProvisioningConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getGetProvisioningConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest,
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        getGetProvisioningConfigMethod;
    if ((getGetProvisioningConfigMethod = BareMetalSolutionGrpc.getGetProvisioningConfigMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getGetProvisioningConfigMethod = BareMetalSolutionGrpc.getGetProvisioningConfigMethod)
            == null) {
          BareMetalSolutionGrpc.getGetProvisioningConfigMethod =
              getGetProvisioningConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest,
                          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetProvisioningConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ProvisioningConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("GetProvisioningConfig"))
                      .build();
        }
      }
    }
    return getGetProvisioningConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getCreateProvisioningConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProvisioningConfig",
      requestType = com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ProvisioningConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getCreateProvisioningConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest,
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        getCreateProvisioningConfigMethod;
    if ((getCreateProvisioningConfigMethod =
            BareMetalSolutionGrpc.getCreateProvisioningConfigMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getCreateProvisioningConfigMethod =
                BareMetalSolutionGrpc.getCreateProvisioningConfigMethod)
            == null) {
          BareMetalSolutionGrpc.getCreateProvisioningConfigMethod =
              getCreateProvisioningConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest,
                          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateProvisioningConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ProvisioningConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("CreateProvisioningConfig"))
                      .build();
        }
      }
    }
    return getCreateProvisioningConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getUpdateProvisioningConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProvisioningConfig",
      requestType = com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ProvisioningConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest,
          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
      getUpdateProvisioningConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest,
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        getUpdateProvisioningConfigMethod;
    if ((getUpdateProvisioningConfigMethod =
            BareMetalSolutionGrpc.getUpdateProvisioningConfigMethod)
        == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getUpdateProvisioningConfigMethod =
                BareMetalSolutionGrpc.getUpdateProvisioningConfigMethod)
            == null) {
          BareMetalSolutionGrpc.getUpdateProvisioningConfigMethod =
              getUpdateProvisioningConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest,
                          com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateProvisioningConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ProvisioningConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("UpdateProvisioningConfig"))
                      .build();
        }
      }
    }
    return getUpdateProvisioningConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameNetworkRequest,
          com.google.cloud.baremetalsolution.v2.Network>
      getRenameNetworkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenameNetwork",
      requestType = com.google.cloud.baremetalsolution.v2.RenameNetworkRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.Network.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.RenameNetworkRequest,
          com.google.cloud.baremetalsolution.v2.Network>
      getRenameNetworkMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.RenameNetworkRequest,
            com.google.cloud.baremetalsolution.v2.Network>
        getRenameNetworkMethod;
    if ((getRenameNetworkMethod = BareMetalSolutionGrpc.getRenameNetworkMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getRenameNetworkMethod = BareMetalSolutionGrpc.getRenameNetworkMethod) == null) {
          BareMetalSolutionGrpc.getRenameNetworkMethod =
              getRenameNetworkMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.RenameNetworkRequest,
                          com.google.cloud.baremetalsolution.v2.Network>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RenameNetwork"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.RenameNetworkRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.Network.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("RenameNetwork"))
                      .build();
        }
      }
    }
    return getRenameNetworkMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListOSImagesRequest,
          com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
      getListOSImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOSImages",
      requestType = com.google.cloud.baremetalsolution.v2.ListOSImagesRequest.class,
      responseType = com.google.cloud.baremetalsolution.v2.ListOSImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.baremetalsolution.v2.ListOSImagesRequest,
          com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
      getListOSImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.baremetalsolution.v2.ListOSImagesRequest,
            com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
        getListOSImagesMethod;
    if ((getListOSImagesMethod = BareMetalSolutionGrpc.getListOSImagesMethod) == null) {
      synchronized (BareMetalSolutionGrpc.class) {
        if ((getListOSImagesMethod = BareMetalSolutionGrpc.getListOSImagesMethod) == null) {
          BareMetalSolutionGrpc.getListOSImagesMethod =
              getListOSImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.baremetalsolution.v2.ListOSImagesRequest,
                          com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOSImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListOSImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.baremetalsolution.v2.ListOSImagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BareMetalSolutionMethodDescriptorSupplier("ListOSImages"))
                      .build();
        }
      }
    }
    return getListOSImagesMethod;
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
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * List servers in a given project and location.
     * </pre>
     */
    default void listInstances(
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
    default void getInstance(
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
    default void updateInstance(
        com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameInstance sets a new name for an instance.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    default void renameInstance(
        com.google.cloud.baremetalsolution.v2.RenameInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Perform an ungraceful, hard reset on a server. Equivalent to shutting the
     * power off and then turning it back on.
     * </pre>
     */
    default void resetInstance(
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
    default void startInstance(
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
    default void stopInstance(
        com.google.cloud.baremetalsolution.v2.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable the interactive serial console feature on an instance.
     * </pre>
     */
    default void enableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableInteractiveSerialConsoleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable the interactive serial console feature on an instance.
     * </pre>
     */
    default void disableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableInteractiveSerialConsoleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Detach LUN from Instance.
     * </pre>
     */
    default void detachLun(
        com.google.cloud.baremetalsolution.v2.DetachLunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetachLunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the public SSH keys registered for the specified project.
     * These SSH keys are used only for the interactive serial console feature.
     * </pre>
     */
    default void listSSHKeys(
        com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSSHKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a public SSH key in the specified project for use with the
     * interactive serial console feature.
     * </pre>
     */
    default void createSSHKey(
        com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SSHKey>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSSHKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a public SSH key registered in the specified project.
     * </pre>
     */
    default void deleteSSHKey(
        com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSSHKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List storage volumes in a given project and location.
     * </pre>
     */
    default void listVolumes(
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
    default void getVolume(
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
    default void updateVolume(
        com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameVolume sets a new name for a volume.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    default void renameVolume(
        com.google.cloud.baremetalsolution.v2.RenameVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Skips volume's cooloff and deletes it now.
     * Volume must be in cooloff state.
     * </pre>
     */
    default void evictVolume(
        com.google.cloud.baremetalsolution.v2.EvictVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEvictVolumeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Emergency Volume resize.
     * </pre>
     */
    default void resizeVolume(
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
    default void listNetworks(
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
    default void listNetworkUsage(
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
    default void getNetwork(
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
    default void updateNetwork(
        com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Takes a snapshot of a boot volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
     * </pre>
     */
    default void createVolumeSnapshot(
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
     * Uses the specified snapshot to restore its parent volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
     * </pre>
     */
    default void restoreVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestoreVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a volume snapshot.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
     * </pre>
     */
    default void deleteVolumeSnapshot(
        com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVolumeSnapshotMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified snapshot resource.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
     * </pre>
     */
    default void getVolumeSnapshot(
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
     * Retrieves the list of snapshots for the specified volume.
     * Returns a response with an empty list of snapshots if called
     * for a non-boot volume.
     * </pre>
     */
    default void listVolumeSnapshots(
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
    default void getLun(
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
    default void listLuns(
        com.google.cloud.baremetalsolution.v2.ListLunsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListLunsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLunsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Skips lun's cooloff and deletes it now.
     * Lun must be in cooloff state.
     * </pre>
     */
    default void evictLun(
        com.google.cloud.baremetalsolution.v2.EvictLunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEvictLunMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details of a single NFS share.
     * </pre>
     */
    default void getNfsShare(
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
    default void listNfsShares(
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
    default void updateNfsShare(
        com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNfsShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create an NFS share.
     * </pre>
     */
    default void createNfsShare(
        com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNfsShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameNfsShare sets a new name for an nfsshare.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    default void renameNfsShare(
        com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameNfsShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an NFS share. The underlying volume is automatically deleted.
     * </pre>
     */
    default void deleteNfsShare(
        com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNfsShareMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the budget details to provision resources on a given project.
     * </pre>
     */
    default void listProvisioningQuotas(
        com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProvisioningQuotasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submit a provisiong configuration for a given project.
     * </pre>
     */
    default void submitProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSubmitProvisioningConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get ProvisioningConfig by name.
     * </pre>
     */
    default void getProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProvisioningConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create new ProvisioningConfig.
     * </pre>
     */
    default void createProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProvisioningConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update existing ProvisioningConfig.
     * </pre>
     */
    default void updateProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProvisioningConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameNetwork sets a new name for a network.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    default void renameNetwork(
        com.google.cloud.baremetalsolution.v2.RenameNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenameNetworkMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of OS images which are currently approved.
     * </pre>
     */
    default void listOSImages(
        com.google.cloud.baremetalsolution.v2.ListOSImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOSImagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BareMetalSolution.
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
  public abstract static class BareMetalSolutionImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BareMetalSolutionGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BareMetalSolution.
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
     * RenameInstance sets a new name for an instance.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public void renameInstance(
        com.google.cloud.baremetalsolution.v2.RenameInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameInstanceMethod(), getCallOptions()),
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
     * Enable the interactive serial console feature on an instance.
     * </pre>
     */
    public void enableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableInteractiveSerialConsoleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable the interactive serial console feature on an instance.
     * </pre>
     */
    public void disableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableInteractiveSerialConsoleMethod(), getCallOptions()),
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
     * Lists the public SSH keys registered for the specified project.
     * These SSH keys are used only for the interactive serial console feature.
     * </pre>
     */
    public void listSSHKeys(
        com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSSHKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register a public SSH key in the specified project for use with the
     * interactive serial console feature.
     * </pre>
     */
    public void createSSHKey(
        com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SSHKey>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSSHKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a public SSH key registered in the specified project.
     * </pre>
     */
    public void deleteSSHKey(
        com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSSHKeyMethod(), getCallOptions()),
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
     * RenameVolume sets a new name for a volume.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public void renameVolume(
        com.google.cloud.baremetalsolution.v2.RenameVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameVolumeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Skips volume's cooloff and deletes it now.
     * Volume must be in cooloff state.
     * </pre>
     */
    public void evictVolume(
        com.google.cloud.baremetalsolution.v2.EvictVolumeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEvictVolumeMethod(), getCallOptions()),
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
     * Takes a snapshot of a boot volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Uses the specified snapshot to restore its parent volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Deletes a volume snapshot.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Returns the specified snapshot resource.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Retrieves the list of snapshots for the specified volume.
     * Returns a response with an empty list of snapshots if called
     * for a non-boot volume.
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

    /**
     *
     *
     * <pre>
     * Skips lun's cooloff and deletes it now.
     * Lun must be in cooloff state.
     * </pre>
     */
    public void evictLun(
        com.google.cloud.baremetalsolution.v2.EvictLunRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEvictLunMethod(), getCallOptions()), request, responseObserver);
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

    /**
     *
     *
     * <pre>
     * Create an NFS share.
     * </pre>
     */
    public void createNfsShare(
        com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNfsShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameNfsShare sets a new name for an nfsshare.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public void renameNfsShare(
        com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameNfsShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an NFS share. The underlying volume is automatically deleted.
     * </pre>
     */
    public void deleteNfsShare(
        com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNfsShareMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the budget details to provision resources on a given project.
     * </pre>
     */
    public void listProvisioningQuotas(
        com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProvisioningQuotasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Submit a provisiong configuration for a given project.
     * </pre>
     */
    public void submitProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitProvisioningConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get ProvisioningConfig by name.
     * </pre>
     */
    public void getProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProvisioningConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create new ProvisioningConfig.
     * </pre>
     */
    public void createProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProvisioningConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update existing ProvisioningConfig.
     * </pre>
     */
    public void updateProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProvisioningConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * RenameNetwork sets a new name for a network.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public void renameNetwork(
        com.google.cloud.baremetalsolution.v2.RenameNetworkRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenameNetworkMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of OS images which are currently approved.
     * </pre>
     */
    public void listOSImages(
        com.google.cloud.baremetalsolution.v2.ListOSImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOSImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BareMetalSolution.
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
     * RenameInstance sets a new name for an instance.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Instance renameInstance(
        com.google.cloud.baremetalsolution.v2.RenameInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameInstanceMethod(), getCallOptions(), request);
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
     * Enable the interactive serial console feature on an instance.
     * </pre>
     */
    public com.google.longrunning.Operation enableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableInteractiveSerialConsoleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable the interactive serial console feature on an instance.
     * </pre>
     */
    public com.google.longrunning.Operation disableInteractiveSerialConsole(
        com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableInteractiveSerialConsoleMethod(), getCallOptions(), request);
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
     * Lists the public SSH keys registered for the specified project.
     * These SSH keys are used only for the interactive serial console feature.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse listSSHKeys(
        com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSSHKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register a public SSH key in the specified project for use with the
     * interactive serial console feature.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.SSHKey createSSHKey(
        com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSSHKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a public SSH key registered in the specified project.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSSHKey(
        com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSSHKeyMethod(), getCallOptions(), request);
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
     * RenameVolume sets a new name for a volume.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Volume renameVolume(
        com.google.cloud.baremetalsolution.v2.RenameVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameVolumeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Skips volume's cooloff and deletes it now.
     * Volume must be in cooloff state.
     * </pre>
     */
    public com.google.longrunning.Operation evictVolume(
        com.google.cloud.baremetalsolution.v2.EvictVolumeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEvictVolumeMethod(), getCallOptions(), request);
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
     * Takes a snapshot of a boot volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Uses the specified snapshot to restore its parent volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Deletes a volume snapshot.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Returns the specified snapshot resource.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Retrieves the list of snapshots for the specified volume.
     * Returns a response with an empty list of snapshots if called
     * for a non-boot volume.
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

    /**
     *
     *
     * <pre>
     * Skips lun's cooloff and deletes it now.
     * Lun must be in cooloff state.
     * </pre>
     */
    public com.google.longrunning.Operation evictLun(
        com.google.cloud.baremetalsolution.v2.EvictLunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEvictLunMethod(), getCallOptions(), request);
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

    /**
     *
     *
     * <pre>
     * Create an NFS share.
     * </pre>
     */
    public com.google.longrunning.Operation createNfsShare(
        com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNfsShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RenameNfsShare sets a new name for an nfsshare.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.NfsShare renameNfsShare(
        com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameNfsShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an NFS share. The underlying volume is automatically deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteNfsShare(
        com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNfsShareMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the budget details to provision resources on a given project.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse
        listProvisioningQuotas(
            com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProvisioningQuotasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Submit a provisiong configuration for a given project.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse
        submitProvisioningConfig(
            com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitProvisioningConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get ProvisioningConfig by name.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ProvisioningConfig getProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProvisioningConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create new ProvisioningConfig.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ProvisioningConfig createProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProvisioningConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update existing ProvisioningConfig.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ProvisioningConfig updateProvisioningConfig(
        com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProvisioningConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * RenameNetwork sets a new name for a network.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.Network renameNetwork(
        com.google.cloud.baremetalsolution.v2.RenameNetworkRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenameNetworkMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of OS images which are currently approved.
     * </pre>
     */
    public com.google.cloud.baremetalsolution.v2.ListOSImagesResponse listOSImages(
        com.google.cloud.baremetalsolution.v2.ListOSImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOSImagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BareMetalSolution.
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
     * RenameInstance sets a new name for an instance.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Instance>
        renameInstance(com.google.cloud.baremetalsolution.v2.RenameInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameInstanceMethod(), getCallOptions()), request);
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
     * Enable the interactive serial console feature on an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enableInteractiveSerialConsole(
            com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableInteractiveSerialConsoleMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Disable the interactive serial console feature on an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableInteractiveSerialConsole(
            com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableInteractiveSerialConsoleMethod(), getCallOptions()),
          request);
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
     * Lists the public SSH keys registered for the specified project.
     * These SSH keys are used only for the interactive serial console feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>
        listSSHKeys(com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSSHKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Register a public SSH key in the specified project for use with the
     * interactive serial console feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.SSHKey>
        createSSHKey(com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSSHKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a public SSH key registered in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSSHKey(com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSSHKeyMethod(), getCallOptions()), request);
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
     * RenameVolume sets a new name for a volume.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Volume>
        renameVolume(com.google.cloud.baremetalsolution.v2.RenameVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameVolumeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Skips volume's cooloff and deletes it now.
     * Volume must be in cooloff state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        evictVolume(com.google.cloud.baremetalsolution.v2.EvictVolumeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEvictVolumeMethod(), getCallOptions()), request);
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
     * Takes a snapshot of a boot volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Uses the specified snapshot to restore its parent volume.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Deletes a volume snapshot.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Returns the specified snapshot resource.
     * Returns INVALID_ARGUMENT if called for a non-boot volume.
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
     * Retrieves the list of snapshots for the specified volume.
     * Returns a response with an empty list of snapshots if called
     * for a non-boot volume.
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

    /**
     *
     *
     * <pre>
     * Skips lun's cooloff and deletes it now.
     * Lun must be in cooloff state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        evictLun(com.google.cloud.baremetalsolution.v2.EvictLunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEvictLunMethod(), getCallOptions()), request);
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

    /**
     *
     *
     * <pre>
     * Create an NFS share.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createNfsShare(com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNfsShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * RenameNfsShare sets a new name for an nfsshare.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.NfsShare>
        renameNfsShare(com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameNfsShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an NFS share. The underlying volume is automatically deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteNfsShare(com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNfsShareMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the budget details to provision resources on a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>
        listProvisioningQuotas(
            com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProvisioningQuotasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Submit a provisiong configuration for a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>
        submitProvisioningConfig(
            com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitProvisioningConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get ProvisioningConfig by name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        getProvisioningConfig(
            com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProvisioningConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create new ProvisioningConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        createProvisioningConfig(
            com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProvisioningConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update existing ProvisioningConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ProvisioningConfig>
        updateProvisioningConfig(
            com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProvisioningConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * RenameNetwork sets a new name for a network.
     * Use with caution, previous names become immediately invalidated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.Network>
        renameNetwork(com.google.cloud.baremetalsolution.v2.RenameNetworkRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenameNetworkMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the list of OS images which are currently approved.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>
        listOSImages(com.google.cloud.baremetalsolution.v2.ListOSImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOSImagesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_UPDATE_INSTANCE = 2;
  private static final int METHODID_RENAME_INSTANCE = 3;
  private static final int METHODID_RESET_INSTANCE = 4;
  private static final int METHODID_START_INSTANCE = 5;
  private static final int METHODID_STOP_INSTANCE = 6;
  private static final int METHODID_ENABLE_INTERACTIVE_SERIAL_CONSOLE = 7;
  private static final int METHODID_DISABLE_INTERACTIVE_SERIAL_CONSOLE = 8;
  private static final int METHODID_DETACH_LUN = 9;
  private static final int METHODID_LIST_SSHKEYS = 10;
  private static final int METHODID_CREATE_SSHKEY = 11;
  private static final int METHODID_DELETE_SSHKEY = 12;
  private static final int METHODID_LIST_VOLUMES = 13;
  private static final int METHODID_GET_VOLUME = 14;
  private static final int METHODID_UPDATE_VOLUME = 15;
  private static final int METHODID_RENAME_VOLUME = 16;
  private static final int METHODID_EVICT_VOLUME = 17;
  private static final int METHODID_RESIZE_VOLUME = 18;
  private static final int METHODID_LIST_NETWORKS = 19;
  private static final int METHODID_LIST_NETWORK_USAGE = 20;
  private static final int METHODID_GET_NETWORK = 21;
  private static final int METHODID_UPDATE_NETWORK = 22;
  private static final int METHODID_CREATE_VOLUME_SNAPSHOT = 23;
  private static final int METHODID_RESTORE_VOLUME_SNAPSHOT = 24;
  private static final int METHODID_DELETE_VOLUME_SNAPSHOT = 25;
  private static final int METHODID_GET_VOLUME_SNAPSHOT = 26;
  private static final int METHODID_LIST_VOLUME_SNAPSHOTS = 27;
  private static final int METHODID_GET_LUN = 28;
  private static final int METHODID_LIST_LUNS = 29;
  private static final int METHODID_EVICT_LUN = 30;
  private static final int METHODID_GET_NFS_SHARE = 31;
  private static final int METHODID_LIST_NFS_SHARES = 32;
  private static final int METHODID_UPDATE_NFS_SHARE = 33;
  private static final int METHODID_CREATE_NFS_SHARE = 34;
  private static final int METHODID_RENAME_NFS_SHARE = 35;
  private static final int METHODID_DELETE_NFS_SHARE = 36;
  private static final int METHODID_LIST_PROVISIONING_QUOTAS = 37;
  private static final int METHODID_SUBMIT_PROVISIONING_CONFIG = 38;
  private static final int METHODID_GET_PROVISIONING_CONFIG = 39;
  private static final int METHODID_CREATE_PROVISIONING_CONFIG = 40;
  private static final int METHODID_UPDATE_PROVISIONING_CONFIG = 41;
  private static final int METHODID_RENAME_NETWORK = 42;
  private static final int METHODID_LIST_OSIMAGES = 43;

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
        case METHODID_RENAME_INSTANCE:
          serviceImpl.renameInstance(
              (com.google.cloud.baremetalsolution.v2.RenameInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Instance>)
                  responseObserver);
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
        case METHODID_ENABLE_INTERACTIVE_SERIAL_CONSOLE:
          serviceImpl.enableInteractiveSerialConsole(
              (com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_INTERACTIVE_SERIAL_CONSOLE:
          serviceImpl.disableInteractiveSerialConsole(
              (com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DETACH_LUN:
          serviceImpl.detachLun(
              (com.google.cloud.baremetalsolution.v2.DetachLunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SSHKEYS:
          serviceImpl.listSSHKeys(
              (com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SSHKEY:
          serviceImpl.createSSHKey(
              (com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.SSHKey>)
                  responseObserver);
          break;
        case METHODID_DELETE_SSHKEY:
          serviceImpl.deleteSSHKey(
              (com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
        case METHODID_RENAME_VOLUME:
          serviceImpl.renameVolume(
              (com.google.cloud.baremetalsolution.v2.RenameVolumeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Volume>)
                  responseObserver);
          break;
        case METHODID_EVICT_VOLUME:
          serviceImpl.evictVolume(
              (com.google.cloud.baremetalsolution.v2.EvictVolumeRequest) request,
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
        case METHODID_EVICT_LUN:
          serviceImpl.evictLun(
              (com.google.cloud.baremetalsolution.v2.EvictLunRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
        case METHODID_CREATE_NFS_SHARE:
          serviceImpl.createNfsShare(
              (com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RENAME_NFS_SHARE:
          serviceImpl.renameNfsShare(
              (com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.NfsShare>)
                  responseObserver);
          break;
        case METHODID_DELETE_NFS_SHARE:
          serviceImpl.deleteNfsShare(
              (com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PROVISIONING_QUOTAS:
          serviceImpl.listProvisioningQuotas(
              (com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>)
                  responseObserver);
          break;
        case METHODID_SUBMIT_PROVISIONING_CONFIG:
          serviceImpl.submitProvisioningConfig(
              (com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROVISIONING_CONFIG:
          serviceImpl.getProvisioningConfig(
              (com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ProvisioningConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROVISIONING_CONFIG:
          serviceImpl.createProvisioningConfig(
              (com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ProvisioningConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROVISIONING_CONFIG:
          serviceImpl.updateProvisioningConfig(
              (com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ProvisioningConfig>)
                  responseObserver);
          break;
        case METHODID_RENAME_NETWORK:
          serviceImpl.renameNetwork(
              (com.google.cloud.baremetalsolution.v2.RenameNetworkRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.baremetalsolution.v2.Network>)
                  responseObserver);
          break;
        case METHODID_LIST_OSIMAGES:
          serviceImpl.listOSImages(
              (com.google.cloud.baremetalsolution.v2.ListOSImagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListInstancesRequest,
                    com.google.cloud.baremetalsolution.v2.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetInstanceRequest,
                    com.google.cloud.baremetalsolution.v2.Instance>(
                    service, METHODID_GET_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getRenameInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.RenameInstanceRequest,
                    com.google.cloud.baremetalsolution.v2.Instance>(
                    service, METHODID_RENAME_INSTANCE)))
        .addMethod(
            getResetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ResetInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESET_INSTANCE)))
        .addMethod(
            getStartInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.StartInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_INSTANCE)))
        .addMethod(
            getStopInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.StopInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_INSTANCE)))
        .addMethod(
            getEnableInteractiveSerialConsoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.EnableInteractiveSerialConsoleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_ENABLE_INTERACTIVE_SERIAL_CONSOLE)))
        .addMethod(
            getDisableInteractiveSerialConsoleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.DisableInteractiveSerialConsoleRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DISABLE_INTERACTIVE_SERIAL_CONSOLE)))
        .addMethod(
            getDetachLunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.DetachLunRequest,
                    com.google.longrunning.Operation>(service, METHODID_DETACH_LUN)))
        .addMethod(
            getListSSHKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListSSHKeysRequest,
                    com.google.cloud.baremetalsolution.v2.ListSSHKeysResponse>(
                    service, METHODID_LIST_SSHKEYS)))
        .addMethod(
            getCreateSSHKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.CreateSSHKeyRequest,
                    com.google.cloud.baremetalsolution.v2.SSHKey>(service, METHODID_CREATE_SSHKEY)))
        .addMethod(
            getDeleteSSHKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.DeleteSSHKeyRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SSHKEY)))
        .addMethod(
            getListVolumesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListVolumesRequest,
                    com.google.cloud.baremetalsolution.v2.ListVolumesResponse>(
                    service, METHODID_LIST_VOLUMES)))
        .addMethod(
            getGetVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetVolumeRequest,
                    com.google.cloud.baremetalsolution.v2.Volume>(service, METHODID_GET_VOLUME)))
        .addMethod(
            getUpdateVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_VOLUME)))
        .addMethod(
            getRenameVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.RenameVolumeRequest,
                    com.google.cloud.baremetalsolution.v2.Volume>(service, METHODID_RENAME_VOLUME)))
        .addMethod(
            getEvictVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.EvictVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_EVICT_VOLUME)))
        .addMethod(
            getResizeVolumeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESIZE_VOLUME)))
        .addMethod(
            getListNetworksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListNetworksRequest,
                    com.google.cloud.baremetalsolution.v2.ListNetworksResponse>(
                    service, METHODID_LIST_NETWORKS)))
        .addMethod(
            getListNetworkUsageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest,
                    com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse>(
                    service, METHODID_LIST_NETWORK_USAGE)))
        .addMethod(
            getGetNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetNetworkRequest,
                    com.google.cloud.baremetalsolution.v2.Network>(service, METHODID_GET_NETWORK)))
        .addMethod(
            getUpdateNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_NETWORK)))
        .addMethod(
            getCreateVolumeSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest,
                    com.google.cloud.baremetalsolution.v2.VolumeSnapshot>(
                    service, METHODID_CREATE_VOLUME_SNAPSHOT)))
        .addMethod(
            getRestoreVolumeSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESTORE_VOLUME_SNAPSHOT)))
        .addMethod(
            getDeleteVolumeSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_VOLUME_SNAPSHOT)))
        .addMethod(
            getGetVolumeSnapshotMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest,
                    com.google.cloud.baremetalsolution.v2.VolumeSnapshot>(
                    service, METHODID_GET_VOLUME_SNAPSHOT)))
        .addMethod(
            getListVolumeSnapshotsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest,
                    com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse>(
                    service, METHODID_LIST_VOLUME_SNAPSHOTS)))
        .addMethod(
            getGetLunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetLunRequest,
                    com.google.cloud.baremetalsolution.v2.Lun>(service, METHODID_GET_LUN)))
        .addMethod(
            getListLunsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListLunsRequest,
                    com.google.cloud.baremetalsolution.v2.ListLunsResponse>(
                    service, METHODID_LIST_LUNS)))
        .addMethod(
            getEvictLunMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.EvictLunRequest,
                    com.google.longrunning.Operation>(service, METHODID_EVICT_LUN)))
        .addMethod(
            getGetNfsShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetNfsShareRequest,
                    com.google.cloud.baremetalsolution.v2.NfsShare>(
                    service, METHODID_GET_NFS_SHARE)))
        .addMethod(
            getListNfsSharesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest,
                    com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse>(
                    service, METHODID_LIST_NFS_SHARES)))
        .addMethod(
            getUpdateNfsShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_NFS_SHARE)))
        .addMethod(
            getCreateNfsShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.CreateNfsShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_NFS_SHARE)))
        .addMethod(
            getRenameNfsShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.RenameNfsShareRequest,
                    com.google.cloud.baremetalsolution.v2.NfsShare>(
                    service, METHODID_RENAME_NFS_SHARE)))
        .addMethod(
            getDeleteNfsShareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.DeleteNfsShareRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_NFS_SHARE)))
        .addMethod(
            getListProvisioningQuotasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasRequest,
                    com.google.cloud.baremetalsolution.v2.ListProvisioningQuotasResponse>(
                    service, METHODID_LIST_PROVISIONING_QUOTAS)))
        .addMethod(
            getSubmitProvisioningConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigRequest,
                    com.google.cloud.baremetalsolution.v2.SubmitProvisioningConfigResponse>(
                    service, METHODID_SUBMIT_PROVISIONING_CONFIG)))
        .addMethod(
            getGetProvisioningConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.GetProvisioningConfigRequest,
                    com.google.cloud.baremetalsolution.v2.ProvisioningConfig>(
                    service, METHODID_GET_PROVISIONING_CONFIG)))
        .addMethod(
            getCreateProvisioningConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.CreateProvisioningConfigRequest,
                    com.google.cloud.baremetalsolution.v2.ProvisioningConfig>(
                    service, METHODID_CREATE_PROVISIONING_CONFIG)))
        .addMethod(
            getUpdateProvisioningConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.UpdateProvisioningConfigRequest,
                    com.google.cloud.baremetalsolution.v2.ProvisioningConfig>(
                    service, METHODID_UPDATE_PROVISIONING_CONFIG)))
        .addMethod(
            getRenameNetworkMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.RenameNetworkRequest,
                    com.google.cloud.baremetalsolution.v2.Network>(
                    service, METHODID_RENAME_NETWORK)))
        .addMethod(
            getListOSImagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.baremetalsolution.v2.ListOSImagesRequest,
                    com.google.cloud.baremetalsolution.v2.ListOSImagesResponse>(
                    service, METHODID_LIST_OSIMAGES)))
        .build();
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
    private final java.lang.String methodName;

    BareMetalSolutionMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getRenameInstanceMethod())
                      .addMethod(getResetInstanceMethod())
                      .addMethod(getStartInstanceMethod())
                      .addMethod(getStopInstanceMethod())
                      .addMethod(getEnableInteractiveSerialConsoleMethod())
                      .addMethod(getDisableInteractiveSerialConsoleMethod())
                      .addMethod(getDetachLunMethod())
                      .addMethod(getListSSHKeysMethod())
                      .addMethod(getCreateSSHKeyMethod())
                      .addMethod(getDeleteSSHKeyMethod())
                      .addMethod(getListVolumesMethod())
                      .addMethod(getGetVolumeMethod())
                      .addMethod(getUpdateVolumeMethod())
                      .addMethod(getRenameVolumeMethod())
                      .addMethod(getEvictVolumeMethod())
                      .addMethod(getResizeVolumeMethod())
                      .addMethod(getListNetworksMethod())
                      .addMethod(getListNetworkUsageMethod())
                      .addMethod(getGetNetworkMethod())
                      .addMethod(getUpdateNetworkMethod())
                      .addMethod(getCreateVolumeSnapshotMethod())
                      .addMethod(getRestoreVolumeSnapshotMethod())
                      .addMethod(getDeleteVolumeSnapshotMethod())
                      .addMethod(getGetVolumeSnapshotMethod())
                      .addMethod(getListVolumeSnapshotsMethod())
                      .addMethod(getGetLunMethod())
                      .addMethod(getListLunsMethod())
                      .addMethod(getEvictLunMethod())
                      .addMethod(getGetNfsShareMethod())
                      .addMethod(getListNfsSharesMethod())
                      .addMethod(getUpdateNfsShareMethod())
                      .addMethod(getCreateNfsShareMethod())
                      .addMethod(getRenameNfsShareMethod())
                      .addMethod(getDeleteNfsShareMethod())
                      .addMethod(getListProvisioningQuotasMethod())
                      .addMethod(getSubmitProvisioningConfigMethod())
                      .addMethod(getGetProvisioningConfigMethod())
                      .addMethod(getCreateProvisioningConfigMethod())
                      .addMethod(getUpdateProvisioningConfigMethod())
                      .addMethod(getRenameNetworkMethod())
                      .addMethod(getListOSImagesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
