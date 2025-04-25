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
package com.google.cloud.notebooks.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * API v1 service for Cloud AI Platform Notebooks.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/notebooks/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class NotebookServiceGrpc {

  private NotebookServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.notebooks.v1.NotebookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListInstancesRequest,
          com.google.cloud.notebooks.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.notebooks.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.notebooks.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListInstancesRequest,
          com.google.cloud.notebooks.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ListInstancesRequest,
            com.google.cloud.notebooks.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = NotebookServiceGrpc.getListInstancesMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListInstancesMethod = NotebookServiceGrpc.getListInstancesMethod) == null) {
          NotebookServiceGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ListInstancesRequest,
                          com.google.cloud.notebooks.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetInstanceRequest, com.google.cloud.notebooks.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.notebooks.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.notebooks.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetInstanceRequest, com.google.cloud.notebooks.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.GetInstanceRequest,
            com.google.cloud.notebooks.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = NotebookServiceGrpc.getGetInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetInstanceMethod = NotebookServiceGrpc.getGetInstanceMethod) == null) {
          NotebookServiceGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.GetInstanceRequest,
                          com.google.cloud.notebooks.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.notebooks.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = NotebookServiceGrpc.getCreateInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateInstanceMethod = NotebookServiceGrpc.getCreateInstanceMethod) == null) {
          NotebookServiceGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.RegisterInstanceRequest, com.google.longrunning.Operation>
      getRegisterInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterInstance",
      requestType = com.google.cloud.notebooks.v1.RegisterInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.RegisterInstanceRequest, com.google.longrunning.Operation>
      getRegisterInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.RegisterInstanceRequest, com.google.longrunning.Operation>
        getRegisterInstanceMethod;
    if ((getRegisterInstanceMethod = NotebookServiceGrpc.getRegisterInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getRegisterInstanceMethod = NotebookServiceGrpc.getRegisterInstanceMethod) == null) {
          NotebookServiceGrpc.getRegisterInstanceMethod =
              getRegisterInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.RegisterInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.RegisterInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("RegisterInstance"))
                      .build();
        }
      }
    }
    return getRegisterInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest,
          com.google.longrunning.Operation>
      getSetInstanceAcceleratorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetInstanceAccelerator",
      requestType = com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest,
          com.google.longrunning.Operation>
      getSetInstanceAcceleratorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest,
            com.google.longrunning.Operation>
        getSetInstanceAcceleratorMethod;
    if ((getSetInstanceAcceleratorMethod = NotebookServiceGrpc.getSetInstanceAcceleratorMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getSetInstanceAcceleratorMethod = NotebookServiceGrpc.getSetInstanceAcceleratorMethod)
            == null) {
          NotebookServiceGrpc.getSetInstanceAcceleratorMethod =
              getSetInstanceAcceleratorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetInstanceAccelerator"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("SetInstanceAccelerator"))
                      .build();
        }
      }
    }
    return getSetInstanceAcceleratorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest,
          com.google.longrunning.Operation>
      getSetInstanceMachineTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetInstanceMachineType",
      requestType = com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest,
          com.google.longrunning.Operation>
      getSetInstanceMachineTypeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest,
            com.google.longrunning.Operation>
        getSetInstanceMachineTypeMethod;
    if ((getSetInstanceMachineTypeMethod = NotebookServiceGrpc.getSetInstanceMachineTypeMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getSetInstanceMachineTypeMethod = NotebookServiceGrpc.getSetInstanceMachineTypeMethod)
            == null) {
          NotebookServiceGrpc.getSetInstanceMachineTypeMethod =
              getSetInstanceMachineTypeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetInstanceMachineType"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("SetInstanceMachineType"))
                      .build();
        }
      }
    }
    return getSetInstanceMachineTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstanceConfig",
      requestType = com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceConfigMethod;
    if ((getUpdateInstanceConfigMethod = NotebookServiceGrpc.getUpdateInstanceConfigMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpdateInstanceConfigMethod = NotebookServiceGrpc.getUpdateInstanceConfigMethod)
            == null) {
          NotebookServiceGrpc.getUpdateInstanceConfigMethod =
              getUpdateInstanceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInstanceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("UpdateInstanceConfig"))
                      .build();
        }
      }
    }
    return getUpdateInstanceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest,
          com.google.longrunning.Operation>
      getUpdateShieldedInstanceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateShieldedInstanceConfig",
      requestType = com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest,
          com.google.longrunning.Operation>
      getUpdateShieldedInstanceConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest,
            com.google.longrunning.Operation>
        getUpdateShieldedInstanceConfigMethod;
    if ((getUpdateShieldedInstanceConfigMethod =
            NotebookServiceGrpc.getUpdateShieldedInstanceConfigMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpdateShieldedInstanceConfigMethod =
                NotebookServiceGrpc.getUpdateShieldedInstanceConfigMethod)
            == null) {
          NotebookServiceGrpc.getUpdateShieldedInstanceConfigMethod =
              getUpdateShieldedInstanceConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateShieldedInstanceConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier(
                              "UpdateShieldedInstanceConfig"))
                      .build();
        }
      }
    }
    return getUpdateShieldedInstanceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceLabelsRequest, com.google.longrunning.Operation>
      getSetInstanceLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetInstanceLabels",
      requestType = com.google.cloud.notebooks.v1.SetInstanceLabelsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.SetInstanceLabelsRequest, com.google.longrunning.Operation>
      getSetInstanceLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.SetInstanceLabelsRequest,
            com.google.longrunning.Operation>
        getSetInstanceLabelsMethod;
    if ((getSetInstanceLabelsMethod = NotebookServiceGrpc.getSetInstanceLabelsMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getSetInstanceLabelsMethod = NotebookServiceGrpc.getSetInstanceLabelsMethod) == null) {
          NotebookServiceGrpc.getSetInstanceLabelsMethod =
              getSetInstanceLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.SetInstanceLabelsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetInstanceLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.SetInstanceLabelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("SetInstanceLabels"))
                      .build();
        }
      }
    }
    return getSetInstanceLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest,
          com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
      getUpdateInstanceMetadataItemsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstanceMetadataItems",
      requestType = com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest.class,
      responseType = com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest,
          com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
      getUpdateInstanceMetadataItemsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest,
            com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
        getUpdateInstanceMetadataItemsMethod;
    if ((getUpdateInstanceMetadataItemsMethod =
            NotebookServiceGrpc.getUpdateInstanceMetadataItemsMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpdateInstanceMetadataItemsMethod =
                NotebookServiceGrpc.getUpdateInstanceMetadataItemsMethod)
            == null) {
          NotebookServiceGrpc.getUpdateInstanceMetadataItemsMethod =
              getUpdateInstanceMetadataItemsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest,
                          com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInstanceMetadataItems"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier(
                              "UpdateInstanceMetadataItems"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMetadataItemsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.notebooks.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = NotebookServiceGrpc.getDeleteInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteInstanceMethod = NotebookServiceGrpc.getDeleteInstanceMethod) == null) {
          NotebookServiceGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.StartInstanceRequest, com.google.longrunning.Operation>
      getStartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartInstance",
      requestType = com.google.cloud.notebooks.v1.StartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.StartInstanceRequest, com.google.longrunning.Operation>
      getStartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.StartInstanceRequest, com.google.longrunning.Operation>
        getStartInstanceMethod;
    if ((getStartInstanceMethod = NotebookServiceGrpc.getStartInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getStartInstanceMethod = NotebookServiceGrpc.getStartInstanceMethod) == null) {
          NotebookServiceGrpc.getStartInstanceMethod =
              getStartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.StartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.StartInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("StartInstance"))
                      .build();
        }
      }
    }
    return getStartInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.StopInstanceRequest, com.google.longrunning.Operation>
      getStopInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopInstance",
      requestType = com.google.cloud.notebooks.v1.StopInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.StopInstanceRequest, com.google.longrunning.Operation>
      getStopInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.StopInstanceRequest, com.google.longrunning.Operation>
        getStopInstanceMethod;
    if ((getStopInstanceMethod = NotebookServiceGrpc.getStopInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getStopInstanceMethod = NotebookServiceGrpc.getStopInstanceMethod) == null) {
          NotebookServiceGrpc.getStopInstanceMethod =
              getStopInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.StopInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.StopInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("StopInstance"))
                      .build();
        }
      }
    }
    return getStopInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ResetInstanceRequest, com.google.longrunning.Operation>
      getResetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetInstance",
      requestType = com.google.cloud.notebooks.v1.ResetInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ResetInstanceRequest, com.google.longrunning.Operation>
      getResetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ResetInstanceRequest, com.google.longrunning.Operation>
        getResetInstanceMethod;
    if ((getResetInstanceMethod = NotebookServiceGrpc.getResetInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getResetInstanceMethod = NotebookServiceGrpc.getResetInstanceMethod) == null) {
          NotebookServiceGrpc.getResetInstanceMethod =
              getResetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ResetInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ResetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ResetInstance"))
                      .build();
        }
      }
    }
    return getResetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ReportInstanceInfoRequest, com.google.longrunning.Operation>
      getReportInstanceInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportInstanceInfo",
      requestType = com.google.cloud.notebooks.v1.ReportInstanceInfoRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ReportInstanceInfoRequest, com.google.longrunning.Operation>
      getReportInstanceInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ReportInstanceInfoRequest,
            com.google.longrunning.Operation>
        getReportInstanceInfoMethod;
    if ((getReportInstanceInfoMethod = NotebookServiceGrpc.getReportInstanceInfoMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getReportInstanceInfoMethod = NotebookServiceGrpc.getReportInstanceInfoMethod)
            == null) {
          NotebookServiceGrpc.getReportInstanceInfoMethod =
              getReportInstanceInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ReportInstanceInfoRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportInstanceInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ReportInstanceInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ReportInstanceInfo"))
                      .build();
        }
      }
    }
    return getReportInstanceInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest,
          com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
      getIsInstanceUpgradeableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IsInstanceUpgradeable",
      requestType = com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest.class,
      responseType = com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest,
          com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
      getIsInstanceUpgradeableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest,
            com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
        getIsInstanceUpgradeableMethod;
    if ((getIsInstanceUpgradeableMethod = NotebookServiceGrpc.getIsInstanceUpgradeableMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getIsInstanceUpgradeableMethod = NotebookServiceGrpc.getIsInstanceUpgradeableMethod)
            == null) {
          NotebookServiceGrpc.getIsInstanceUpgradeableMethod =
              getIsInstanceUpgradeableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest,
                          com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "IsInstanceUpgradeable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("IsInstanceUpgradeable"))
                      .build();
        }
      }
    }
    return getIsInstanceUpgradeableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetInstanceHealthRequest,
          com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
      getGetInstanceHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstanceHealth",
      requestType = com.google.cloud.notebooks.v1.GetInstanceHealthRequest.class,
      responseType = com.google.cloud.notebooks.v1.GetInstanceHealthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetInstanceHealthRequest,
          com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
      getGetInstanceHealthMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.GetInstanceHealthRequest,
            com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
        getGetInstanceHealthMethod;
    if ((getGetInstanceHealthMethod = NotebookServiceGrpc.getGetInstanceHealthMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetInstanceHealthMethod = NotebookServiceGrpc.getGetInstanceHealthMethod) == null) {
          NotebookServiceGrpc.getGetInstanceHealthMethod =
              getGetInstanceHealthMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.GetInstanceHealthRequest,
                          com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstanceHealth"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetInstanceHealthRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetInstanceHealthResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetInstanceHealth"))
                      .build();
        }
      }
    }
    return getGetInstanceHealthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpgradeInstanceRequest, com.google.longrunning.Operation>
      getUpgradeInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeInstance",
      requestType = com.google.cloud.notebooks.v1.UpgradeInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpgradeInstanceRequest, com.google.longrunning.Operation>
      getUpgradeInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.UpgradeInstanceRequest, com.google.longrunning.Operation>
        getUpgradeInstanceMethod;
    if ((getUpgradeInstanceMethod = NotebookServiceGrpc.getUpgradeInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpgradeInstanceMethod = NotebookServiceGrpc.getUpgradeInstanceMethod) == null) {
          NotebookServiceGrpc.getUpgradeInstanceMethod =
              getUpgradeInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.UpgradeInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpgradeInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpgradeInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("UpgradeInstance"))
                      .build();
        }
      }
    }
    return getUpgradeInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.RollbackInstanceRequest, com.google.longrunning.Operation>
      getRollbackInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackInstance",
      requestType = com.google.cloud.notebooks.v1.RollbackInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.RollbackInstanceRequest, com.google.longrunning.Operation>
      getRollbackInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.RollbackInstanceRequest, com.google.longrunning.Operation>
        getRollbackInstanceMethod;
    if ((getRollbackInstanceMethod = NotebookServiceGrpc.getRollbackInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getRollbackInstanceMethod = NotebookServiceGrpc.getRollbackInstanceMethod) == null) {
          NotebookServiceGrpc.getRollbackInstanceMethod =
              getRollbackInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.RollbackInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.RollbackInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("RollbackInstance"))
                      .build();
        }
      }
    }
    return getRollbackInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DiagnoseInstanceRequest, com.google.longrunning.Operation>
      getDiagnoseInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiagnoseInstance",
      requestType = com.google.cloud.notebooks.v1.DiagnoseInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DiagnoseInstanceRequest, com.google.longrunning.Operation>
      getDiagnoseInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.DiagnoseInstanceRequest, com.google.longrunning.Operation>
        getDiagnoseInstanceMethod;
    if ((getDiagnoseInstanceMethod = NotebookServiceGrpc.getDiagnoseInstanceMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDiagnoseInstanceMethod = NotebookServiceGrpc.getDiagnoseInstanceMethod) == null) {
          NotebookServiceGrpc.getDiagnoseInstanceMethod =
              getDiagnoseInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.DiagnoseInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DiagnoseInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.DiagnoseInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DiagnoseInstance"))
                      .build();
        }
      }
    }
    return getDiagnoseInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest,
          com.google.longrunning.Operation>
      getUpgradeInstanceInternalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpgradeInstanceInternal",
      requestType = com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest,
          com.google.longrunning.Operation>
      getUpgradeInstanceInternalMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest,
            com.google.longrunning.Operation>
        getUpgradeInstanceInternalMethod;
    if ((getUpgradeInstanceInternalMethod = NotebookServiceGrpc.getUpgradeInstanceInternalMethod)
        == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getUpgradeInstanceInternalMethod =
                NotebookServiceGrpc.getUpgradeInstanceInternalMethod)
            == null) {
          NotebookServiceGrpc.getUpgradeInstanceInternalMethod =
              getUpgradeInstanceInternalMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpgradeInstanceInternal"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("UpgradeInstanceInternal"))
                      .build();
        }
      }
    }
    return getUpgradeInstanceInternalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListEnvironmentsRequest,
          com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
      getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.notebooks.v1.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.notebooks.v1.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListEnvironmentsRequest,
          com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
      getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ListEnvironmentsRequest,
            com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
        getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = NotebookServiceGrpc.getListEnvironmentsMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListEnvironmentsMethod = NotebookServiceGrpc.getListEnvironmentsMethod) == null) {
          NotebookServiceGrpc.getListEnvironmentsMethod =
              getListEnvironmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ListEnvironmentsRequest,
                          com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListEnvironmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListEnvironmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListEnvironments"))
                      .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetEnvironmentRequest,
          com.google.cloud.notebooks.v1.Environment>
      getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.notebooks.v1.GetEnvironmentRequest.class,
      responseType = com.google.cloud.notebooks.v1.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetEnvironmentRequest,
          com.google.cloud.notebooks.v1.Environment>
      getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.GetEnvironmentRequest,
            com.google.cloud.notebooks.v1.Environment>
        getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = NotebookServiceGrpc.getGetEnvironmentMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetEnvironmentMethod = NotebookServiceGrpc.getGetEnvironmentMethod) == null) {
          NotebookServiceGrpc.getGetEnvironmentMethod =
              getGetEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.GetEnvironmentRequest,
                          com.google.cloud.notebooks.v1.Environment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.Environment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetEnvironment"))
                      .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateEnvironmentRequest, com.google.longrunning.Operation>
      getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType = com.google.cloud.notebooks.v1.CreateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateEnvironmentRequest, com.google.longrunning.Operation>
      getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.CreateEnvironmentRequest,
            com.google.longrunning.Operation>
        getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = NotebookServiceGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateEnvironmentMethod = NotebookServiceGrpc.getCreateEnvironmentMethod) == null) {
          NotebookServiceGrpc.getCreateEnvironmentMethod =
              getCreateEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.CreateEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.CreateEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("CreateEnvironment"))
                      .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteEnvironmentRequest, com.google.longrunning.Operation>
      getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType = com.google.cloud.notebooks.v1.DeleteEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteEnvironmentRequest, com.google.longrunning.Operation>
      getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.DeleteEnvironmentRequest,
            com.google.longrunning.Operation>
        getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = NotebookServiceGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteEnvironmentMethod = NotebookServiceGrpc.getDeleteEnvironmentMethod) == null) {
          NotebookServiceGrpc.getDeleteEnvironmentMethod =
              getDeleteEnvironmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.DeleteEnvironmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.DeleteEnvironmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteEnvironment"))
                      .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListSchedulesRequest,
          com.google.cloud.notebooks.v1.ListSchedulesResponse>
      getListSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSchedules",
      requestType = com.google.cloud.notebooks.v1.ListSchedulesRequest.class,
      responseType = com.google.cloud.notebooks.v1.ListSchedulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListSchedulesRequest,
          com.google.cloud.notebooks.v1.ListSchedulesResponse>
      getListSchedulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ListSchedulesRequest,
            com.google.cloud.notebooks.v1.ListSchedulesResponse>
        getListSchedulesMethod;
    if ((getListSchedulesMethod = NotebookServiceGrpc.getListSchedulesMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListSchedulesMethod = NotebookServiceGrpc.getListSchedulesMethod) == null) {
          NotebookServiceGrpc.getListSchedulesMethod =
              getListSchedulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ListSchedulesRequest,
                          com.google.cloud.notebooks.v1.ListSchedulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSchedules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListSchedulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListSchedulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListSchedules"))
                      .build();
        }
      }
    }
    return getListSchedulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetScheduleRequest, com.google.cloud.notebooks.v1.Schedule>
      getGetScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchedule",
      requestType = com.google.cloud.notebooks.v1.GetScheduleRequest.class,
      responseType = com.google.cloud.notebooks.v1.Schedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetScheduleRequest, com.google.cloud.notebooks.v1.Schedule>
      getGetScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.GetScheduleRequest,
            com.google.cloud.notebooks.v1.Schedule>
        getGetScheduleMethod;
    if ((getGetScheduleMethod = NotebookServiceGrpc.getGetScheduleMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetScheduleMethod = NotebookServiceGrpc.getGetScheduleMethod) == null) {
          NotebookServiceGrpc.getGetScheduleMethod =
              getGetScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.GetScheduleRequest,
                          com.google.cloud.notebooks.v1.Schedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.Schedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetSchedule"))
                      .build();
        }
      }
    }
    return getGetScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
      getDeleteScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSchedule",
      requestType = com.google.cloud.notebooks.v1.DeleteScheduleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
      getDeleteScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
        getDeleteScheduleMethod;
    if ((getDeleteScheduleMethod = NotebookServiceGrpc.getDeleteScheduleMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteScheduleMethod = NotebookServiceGrpc.getDeleteScheduleMethod) == null) {
          NotebookServiceGrpc.getDeleteScheduleMethod =
              getDeleteScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.DeleteScheduleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.DeleteScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteSchedule"))
                      .build();
        }
      }
    }
    return getDeleteScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateScheduleRequest, com.google.longrunning.Operation>
      getCreateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSchedule",
      requestType = com.google.cloud.notebooks.v1.CreateScheduleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateScheduleRequest, com.google.longrunning.Operation>
      getCreateScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.CreateScheduleRequest, com.google.longrunning.Operation>
        getCreateScheduleMethod;
    if ((getCreateScheduleMethod = NotebookServiceGrpc.getCreateScheduleMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateScheduleMethod = NotebookServiceGrpc.getCreateScheduleMethod) == null) {
          NotebookServiceGrpc.getCreateScheduleMethod =
              getCreateScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.CreateScheduleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.CreateScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("CreateSchedule"))
                      .build();
        }
      }
    }
    return getCreateScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.TriggerScheduleRequest, com.google.longrunning.Operation>
      getTriggerScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerSchedule",
      requestType = com.google.cloud.notebooks.v1.TriggerScheduleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.TriggerScheduleRequest, com.google.longrunning.Operation>
      getTriggerScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.TriggerScheduleRequest, com.google.longrunning.Operation>
        getTriggerScheduleMethod;
    if ((getTriggerScheduleMethod = NotebookServiceGrpc.getTriggerScheduleMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getTriggerScheduleMethod = NotebookServiceGrpc.getTriggerScheduleMethod) == null) {
          NotebookServiceGrpc.getTriggerScheduleMethod =
              getTriggerScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.TriggerScheduleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.TriggerScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("TriggerSchedule"))
                      .build();
        }
      }
    }
    return getTriggerScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListExecutionsRequest,
          com.google.cloud.notebooks.v1.ListExecutionsResponse>
      getListExecutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListExecutions",
      requestType = com.google.cloud.notebooks.v1.ListExecutionsRequest.class,
      responseType = com.google.cloud.notebooks.v1.ListExecutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.ListExecutionsRequest,
          com.google.cloud.notebooks.v1.ListExecutionsResponse>
      getListExecutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.ListExecutionsRequest,
            com.google.cloud.notebooks.v1.ListExecutionsResponse>
        getListExecutionsMethod;
    if ((getListExecutionsMethod = NotebookServiceGrpc.getListExecutionsMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getListExecutionsMethod = NotebookServiceGrpc.getListExecutionsMethod) == null) {
          NotebookServiceGrpc.getListExecutionsMethod =
              getListExecutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.ListExecutionsRequest,
                          com.google.cloud.notebooks.v1.ListExecutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListExecutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListExecutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.ListExecutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("ListExecutions"))
                      .build();
        }
      }
    }
    return getListExecutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetExecutionRequest,
          com.google.cloud.notebooks.v1.Execution>
      getGetExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExecution",
      requestType = com.google.cloud.notebooks.v1.GetExecutionRequest.class,
      responseType = com.google.cloud.notebooks.v1.Execution.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.GetExecutionRequest,
          com.google.cloud.notebooks.v1.Execution>
      getGetExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.GetExecutionRequest,
            com.google.cloud.notebooks.v1.Execution>
        getGetExecutionMethod;
    if ((getGetExecutionMethod = NotebookServiceGrpc.getGetExecutionMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getGetExecutionMethod = NotebookServiceGrpc.getGetExecutionMethod) == null) {
          NotebookServiceGrpc.getGetExecutionMethod =
              getGetExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.GetExecutionRequest,
                          com.google.cloud.notebooks.v1.Execution>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.GetExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.Execution.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("GetExecution"))
                      .build();
        }
      }
    }
    return getGetExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteExecutionRequest, com.google.longrunning.Operation>
      getDeleteExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteExecution",
      requestType = com.google.cloud.notebooks.v1.DeleteExecutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.DeleteExecutionRequest, com.google.longrunning.Operation>
      getDeleteExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.DeleteExecutionRequest, com.google.longrunning.Operation>
        getDeleteExecutionMethod;
    if ((getDeleteExecutionMethod = NotebookServiceGrpc.getDeleteExecutionMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getDeleteExecutionMethod = NotebookServiceGrpc.getDeleteExecutionMethod) == null) {
          NotebookServiceGrpc.getDeleteExecutionMethod =
              getDeleteExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.DeleteExecutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.DeleteExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("DeleteExecution"))
                      .build();
        }
      }
    }
    return getDeleteExecutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateExecutionRequest, com.google.longrunning.Operation>
      getCreateExecutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExecution",
      requestType = com.google.cloud.notebooks.v1.CreateExecutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.notebooks.v1.CreateExecutionRequest, com.google.longrunning.Operation>
      getCreateExecutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.notebooks.v1.CreateExecutionRequest, com.google.longrunning.Operation>
        getCreateExecutionMethod;
    if ((getCreateExecutionMethod = NotebookServiceGrpc.getCreateExecutionMethod) == null) {
      synchronized (NotebookServiceGrpc.class) {
        if ((getCreateExecutionMethod = NotebookServiceGrpc.getCreateExecutionMethod) == null) {
          NotebookServiceGrpc.getCreateExecutionMethod =
              getCreateExecutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.notebooks.v1.CreateExecutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateExecution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.notebooks.v1.CreateExecutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NotebookServiceMethodDescriptorSupplier("CreateExecution"))
                      .build();
        }
      }
    }
    return getCreateExecutionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NotebookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceStub>() {
          @java.lang.Override
          public NotebookServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceStub(channel, callOptions);
          }
        };
    return NotebookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NotebookServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceBlockingStub>() {
          @java.lang.Override
          public NotebookServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceBlockingStub(channel, callOptions);
          }
        };
    return NotebookServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NotebookServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NotebookServiceFutureStub>() {
          @java.lang.Override
          public NotebookServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NotebookServiceFutureStub(channel, callOptions);
          }
        };
    return NotebookServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * API v1 service for Cloud AI Platform Notebooks.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.notebooks.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListInstancesResponse>
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
        com.google.cloud.notebooks.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Instance> responseObserver) {
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
        com.google.cloud.notebooks.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Registers an existing legacy notebook instance to the Notebooks API server.
     * Legacy instances are instances created with the legacy Compute Engine
     * calls. They are not manageable by the Notebooks API out of the box. This
     * call makes these instances manageable by the Notebooks API.
     * </pre>
     */
    default void registerInstance(
        com.google.cloud.notebooks.v1.RegisterInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the guest accelerators of a single Instance.
     * </pre>
     */
    default void setInstanceAccelerator(
        com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetInstanceAcceleratorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the machine type of a single Instance.
     * </pre>
     */
    default void setInstanceMachineType(
        com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetInstanceMachineTypeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update Notebook Instance configurations.
     * </pre>
     */
    default void updateInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Shielded instance configuration of a single Instance.
     * </pre>
     */
    default void updateShieldedInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateShieldedInstanceConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replaces all the labels of an Instance.
     * </pre>
     */
    default void setInstanceLabels(
        com.google.cloud.notebooks.v1.SetInstanceLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetInstanceLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add/update metadata items for an instance.
     * </pre>
     */
    default void updateInstanceMetadataItems(
        com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMetadataItemsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.notebooks.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    default void startInstance(
        com.google.cloud.notebooks.v1.StartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    default void stopInstance(
        com.google.cloud.notebooks.v1.StopInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    default void resetInstance(
        com.google.cloud.notebooks.v1.ResetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * report their latest instance information to the Notebooks
     * API server. The server will merge the reported information to
     * the instance metadata store. Do not use this method directly.
     * </pre>
     */
    default void reportInstanceInfo(
        com.google.cloud.notebooks.v1.ReportInstanceInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportInstanceInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is upgradable.
     * </pre>
     */
    default void isInstanceUpgradeable(
        com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getIsInstanceUpgradeableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is healthy.
     * </pre>
     */
    default void getInstanceHealth(
        com.google.cloud.notebooks.v1.GetInstanceHealthRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceHealthMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    default void upgradeInstance(
        com.google.cloud.notebooks.v1.UpgradeInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpgradeInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    default void rollbackInstance(
        com.google.cloud.notebooks.v1.RollbackInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    default void diagnoseInstance(
        com.google.cloud.notebooks.v1.DiagnoseInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDiagnoseInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * call this endpoint to upgrade themselves. Do not use this method directly.
     * </pre>
     */
    default void upgradeInstanceInternal(
        com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpgradeInstanceInternalMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists environments in a project.
     * </pre>
     */
    default void listEnvironments(
        com.google.cloud.notebooks.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnvironmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Environment.
     * </pre>
     */
    default void getEnvironment(
        com.google.cloud.notebooks.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Environment.
     * </pre>
     */
    default void createEnvironment(
        com.google.cloud.notebooks.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Environment.
     * </pre>
     */
    default void deleteEnvironment(
        com.google.cloud.notebooks.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEnvironmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists schedules in a given project and location.
     * </pre>
     */
    default void listSchedules(
        com.google.cloud.notebooks.v1.ListSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSchedulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of schedule
     * </pre>
     */
    default void getSchedule(
        com.google.cloud.notebooks.v1.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Schedule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes schedule and all underlying jobs
     * </pre>
     */
    default void deleteSchedule(
        com.google.cloud.notebooks.v1.DeleteScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Scheduled Notebook in a given project and location.
     * </pre>
     */
    default void createSchedule(
        com.google.cloud.notebooks.v1.CreateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers execution of an existing schedule.
     * </pre>
     */
    default void triggerSchedule(
        com.google.cloud.notebooks.v1.TriggerScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTriggerScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists executions in a given project and location
     * </pre>
     */
    default void listExecutions(
        com.google.cloud.notebooks.v1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListExecutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of executions
     * </pre>
     */
    default void getExecution(
        com.google.cloud.notebooks.v1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Execution> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes execution
     * </pre>
     */
    default void deleteExecution(
        com.google.cloud.notebooks.v1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteExecutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    default void createExecution(
        com.google.cloud.notebooks.v1.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExecutionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NotebookService.
   *
   * <pre>
   * API v1 service for Cloud AI Platform Notebooks.
   * </pre>
   */
  public abstract static class NotebookServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NotebookServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NotebookService.
   *
   * <pre>
   * API v1 service for Cloud AI Platform Notebooks.
   * </pre>
   */
  public static final class NotebookServiceStub
      extends io.grpc.stub.AbstractAsyncStub<NotebookServiceStub> {
    private NotebookServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.notebooks.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListInstancesResponse>
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
        com.google.cloud.notebooks.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Instance> responseObserver) {
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
        com.google.cloud.notebooks.v1.CreateInstanceRequest request,
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
     * Registers an existing legacy notebook instance to the Notebooks API server.
     * Legacy instances are instances created with the legacy Compute Engine
     * calls. They are not manageable by the Notebooks API out of the box. This
     * call makes these instances manageable by the Notebooks API.
     * </pre>
     */
    public void registerInstance(
        com.google.cloud.notebooks.v1.RegisterInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the guest accelerators of a single Instance.
     * </pre>
     */
    public void setInstanceAccelerator(
        com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetInstanceAcceleratorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the machine type of a single Instance.
     * </pre>
     */
    public void setInstanceMachineType(
        com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetInstanceMachineTypeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update Notebook Instance configurations.
     * </pre>
     */
    public void updateInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Shielded instance configuration of a single Instance.
     * </pre>
     */
    public void updateShieldedInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateShieldedInstanceConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Replaces all the labels of an Instance.
     * </pre>
     */
    public void setInstanceLabels(
        com.google.cloud.notebooks.v1.SetInstanceLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetInstanceLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Add/update metadata items for an instance.
     * </pre>
     */
    public void updateInstanceMetadataItems(
        com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMetadataItemsMethod(), getCallOptions()),
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
        com.google.cloud.notebooks.v1.DeleteInstanceRequest request,
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
     * Starts a notebook instance.
     * </pre>
     */
    public void startInstance(
        com.google.cloud.notebooks.v1.StartInstanceRequest request,
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
     * Stops a notebook instance.
     * </pre>
     */
    public void stopInstance(
        com.google.cloud.notebooks.v1.StopInstanceRequest request,
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
     * Resets a notebook instance.
     * </pre>
     */
    public void resetInstance(
        com.google.cloud.notebooks.v1.ResetInstanceRequest request,
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
     * Allows notebook instances to
     * report their latest instance information to the Notebooks
     * API server. The server will merge the reported information to
     * the instance metadata store. Do not use this method directly.
     * </pre>
     */
    public void reportInstanceInfo(
        com.google.cloud.notebooks.v1.ReportInstanceInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportInstanceInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is upgradable.
     * </pre>
     */
    public void isInstanceUpgradeable(
        com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsInstanceUpgradeableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is healthy.
     * </pre>
     */
    public void getInstanceHealth(
        com.google.cloud.notebooks.v1.GetInstanceHealthRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceHealthMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public void upgradeInstance(
        com.google.cloud.notebooks.v1.UpgradeInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public void rollbackInstance(
        com.google.cloud.notebooks.v1.RollbackInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public void diagnoseInstance(
        com.google.cloud.notebooks.v1.DiagnoseInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDiagnoseInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * call this endpoint to upgrade themselves. Do not use this method directly.
     * </pre>
     */
    public void upgradeInstanceInternal(
        com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpgradeInstanceInternalMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists environments in a project.
     * </pre>
     */
    public void listEnvironments(
        com.google.cloud.notebooks.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Environment.
     * </pre>
     */
    public void getEnvironment(
        com.google.cloud.notebooks.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Environment.
     * </pre>
     */
    public void createEnvironment(
        com.google.cloud.notebooks.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Environment.
     * </pre>
     */
    public void deleteEnvironment(
        com.google.cloud.notebooks.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists schedules in a given project and location.
     * </pre>
     */
    public void listSchedules(
        com.google.cloud.notebooks.v1.ListSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSchedulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of schedule
     * </pre>
     */
    public void getSchedule(
        com.google.cloud.notebooks.v1.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Schedule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes schedule and all underlying jobs
     * </pre>
     */
    public void deleteSchedule(
        com.google.cloud.notebooks.v1.DeleteScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Scheduled Notebook in a given project and location.
     * </pre>
     */
    public void createSchedule(
        com.google.cloud.notebooks.v1.CreateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Triggers execution of an existing schedule.
     * </pre>
     */
    public void triggerSchedule(
        com.google.cloud.notebooks.v1.TriggerScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists executions in a given project and location
     * </pre>
     */
    public void listExecutions(
        com.google.cloud.notebooks.v1.ListExecutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListExecutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of executions
     * </pre>
     */
    public void getExecution(
        com.google.cloud.notebooks.v1.GetExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Execution> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes execution
     * </pre>
     */
    public void deleteExecution(
        com.google.cloud.notebooks.v1.DeleteExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public void createExecution(
        com.google.cloud.notebooks.v1.CreateExecutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NotebookService.
   *
   * <pre>
   * API v1 service for Cloud AI Platform Notebooks.
   * </pre>
   */
  public static final class NotebookServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NotebookServiceBlockingStub> {
    private NotebookServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.ListInstancesResponse listInstances(
        com.google.cloud.notebooks.v1.ListInstancesRequest request) {
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
    public com.google.cloud.notebooks.v1.Instance getInstance(
        com.google.cloud.notebooks.v1.GetInstanceRequest request) {
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
        com.google.cloud.notebooks.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Registers an existing legacy notebook instance to the Notebooks API server.
     * Legacy instances are instances created with the legacy Compute Engine
     * calls. They are not manageable by the Notebooks API out of the box. This
     * call makes these instances manageable by the Notebooks API.
     * </pre>
     */
    public com.google.longrunning.Operation registerInstance(
        com.google.cloud.notebooks.v1.RegisterInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the guest accelerators of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation setInstanceAccelerator(
        com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetInstanceAcceleratorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the machine type of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation setInstanceMachineType(
        com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetInstanceMachineTypeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update Notebook Instance configurations.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Shielded instance configuration of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateShieldedInstanceConfig(
        com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateShieldedInstanceConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Replaces all the labels of an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation setInstanceLabels(
        com.google.cloud.notebooks.v1.SetInstanceLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetInstanceLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Add/update metadata items for an instance.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse
        updateInstanceMetadataItems(
            com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMetadataItemsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.notebooks.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation startInstance(
        com.google.cloud.notebooks.v1.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation stopInstance(
        com.google.cloud.notebooks.v1.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    public com.google.longrunning.Operation resetInstance(
        com.google.cloud.notebooks.v1.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * report their latest instance information to the Notebooks
     * API server. The server will merge the reported information to
     * the instance metadata store. Do not use this method directly.
     * </pre>
     */
    public com.google.longrunning.Operation reportInstanceInfo(
        com.google.cloud.notebooks.v1.ReportInstanceInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportInstanceInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is upgradable.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse isInstanceUpgradeable(
        com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsInstanceUpgradeableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is healthy.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.GetInstanceHealthResponse getInstanceHealth(
        com.google.cloud.notebooks.v1.GetInstanceHealthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceHealthMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeInstance(
        com.google.cloud.notebooks.v1.UpgradeInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public com.google.longrunning.Operation rollbackInstance(
        com.google.cloud.notebooks.v1.RollbackInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public com.google.longrunning.Operation diagnoseInstance(
        com.google.cloud.notebooks.v1.DiagnoseInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDiagnoseInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * call this endpoint to upgrade themselves. Do not use this method directly.
     * </pre>
     */
    public com.google.longrunning.Operation upgradeInstanceInternal(
        com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpgradeInstanceInternalMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists environments in a project.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.ListEnvironmentsResponse listEnvironments(
        com.google.cloud.notebooks.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Environment.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.Environment getEnvironment(
        com.google.cloud.notebooks.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Environment.
     * </pre>
     */
    public com.google.longrunning.Operation createEnvironment(
        com.google.cloud.notebooks.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Environment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEnvironment(
        com.google.cloud.notebooks.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists schedules in a given project and location.
     * </pre>
     */
    public com.google.cloud.notebooks.v1.ListSchedulesResponse listSchedules(
        com.google.cloud.notebooks.v1.ListSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of schedule
     * </pre>
     */
    public com.google.cloud.notebooks.v1.Schedule getSchedule(
        com.google.cloud.notebooks.v1.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes schedule and all underlying jobs
     * </pre>
     */
    public com.google.longrunning.Operation deleteSchedule(
        com.google.cloud.notebooks.v1.DeleteScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Scheduled Notebook in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSchedule(
        com.google.cloud.notebooks.v1.CreateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers execution of an existing schedule.
     * </pre>
     */
    public com.google.longrunning.Operation triggerSchedule(
        com.google.cloud.notebooks.v1.TriggerScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists executions in a given project and location
     * </pre>
     */
    public com.google.cloud.notebooks.v1.ListExecutionsResponse listExecutions(
        com.google.cloud.notebooks.v1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListExecutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of executions
     * </pre>
     */
    public com.google.cloud.notebooks.v1.Execution getExecution(
        com.google.cloud.notebooks.v1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes execution
     * </pre>
     */
    public com.google.longrunning.Operation deleteExecution(
        com.google.cloud.notebooks.v1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteExecutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createExecution(
        com.google.cloud.notebooks.v1.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExecutionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NotebookService.
   *
   * <pre>
   * API v1 service for Cloud AI Platform Notebooks.
   * </pre>
   */
  public static final class NotebookServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<NotebookServiceFutureStub> {
    private NotebookServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NotebookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NotebookServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.ListInstancesResponse>
        listInstances(com.google.cloud.notebooks.v1.ListInstancesRequest request) {
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
            com.google.cloud.notebooks.v1.Instance>
        getInstance(com.google.cloud.notebooks.v1.GetInstanceRequest request) {
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
        createInstance(com.google.cloud.notebooks.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Registers an existing legacy notebook instance to the Notebooks API server.
     * Legacy instances are instances created with the legacy Compute Engine
     * calls. They are not manageable by the Notebooks API out of the box. This
     * call makes these instances manageable by the Notebooks API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        registerInstance(com.google.cloud.notebooks.v1.RegisterInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the guest accelerators of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setInstanceAccelerator(
            com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetInstanceAcceleratorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the machine type of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setInstanceMachineType(
            com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetInstanceMachineTypeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update Notebook Instance configurations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstanceConfig(com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Shielded instance configuration of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateShieldedInstanceConfig(
            com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateShieldedInstanceConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Replaces all the labels of an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setInstanceLabels(com.google.cloud.notebooks.v1.SetInstanceLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetInstanceLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Add/update metadata items for an instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>
        updateInstanceMetadataItems(
            com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMetadataItemsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.notebooks.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        startInstance(com.google.cloud.notebooks.v1.StartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        stopInstance(com.google.cloud.notebooks.v1.StopInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resets a notebook instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resetInstance(com.google.cloud.notebooks.v1.ResetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * report their latest instance information to the Notebooks
     * API server. The server will merge the reported information to
     * the instance metadata store. Do not use this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reportInstanceInfo(com.google.cloud.notebooks.v1.ReportInstanceInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportInstanceInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is upgradable.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>
        isInstanceUpgradeable(com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsInstanceUpgradeableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Check if a notebook instance is healthy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.GetInstanceHealthResponse>
        getInstanceHealth(com.google.cloud.notebooks.v1.GetInstanceHealthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceHealthMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upgrades a notebook instance to the latest version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        upgradeInstance(com.google.cloud.notebooks.v1.UpgradeInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rollbacks a notebook instance to the previous version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rollbackInstance(com.google.cloud.notebooks.v1.RollbackInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Diagnostic File and runs Diagnostic Tool given an Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        diagnoseInstance(com.google.cloud.notebooks.v1.DiagnoseInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDiagnoseInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Allows notebook instances to
     * call this endpoint to upgrade themselves. Do not use this method directly.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        upgradeInstanceInternal(
            com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpgradeInstanceInternalMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists environments in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.ListEnvironmentsResponse>
        listEnvironments(com.google.cloud.notebooks.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.Environment>
        getEnvironment(com.google.cloud.notebooks.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEnvironment(com.google.cloud.notebooks.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEnvironment(com.google.cloud.notebooks.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists schedules in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.ListSchedulesResponse>
        listSchedules(com.google.cloud.notebooks.v1.ListSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSchedulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of schedule
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.Schedule>
        getSchedule(com.google.cloud.notebooks.v1.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes schedule and all underlying jobs
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSchedule(com.google.cloud.notebooks.v1.DeleteScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Scheduled Notebook in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSchedule(com.google.cloud.notebooks.v1.CreateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Triggers execution of an existing schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        triggerSchedule(com.google.cloud.notebooks.v1.TriggerScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists executions in a given project and location
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.ListExecutionsResponse>
        listExecutions(com.google.cloud.notebooks.v1.ListExecutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListExecutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of executions
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.notebooks.v1.Execution>
        getExecution(com.google.cloud.notebooks.v1.GetExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes execution
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteExecution(com.google.cloud.notebooks.v1.DeleteExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteExecutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Execution in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createExecution(com.google.cloud.notebooks.v1.CreateExecutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExecutionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_REGISTER_INSTANCE = 3;
  private static final int METHODID_SET_INSTANCE_ACCELERATOR = 4;
  private static final int METHODID_SET_INSTANCE_MACHINE_TYPE = 5;
  private static final int METHODID_UPDATE_INSTANCE_CONFIG = 6;
  private static final int METHODID_UPDATE_SHIELDED_INSTANCE_CONFIG = 7;
  private static final int METHODID_SET_INSTANCE_LABELS = 8;
  private static final int METHODID_UPDATE_INSTANCE_METADATA_ITEMS = 9;
  private static final int METHODID_DELETE_INSTANCE = 10;
  private static final int METHODID_START_INSTANCE = 11;
  private static final int METHODID_STOP_INSTANCE = 12;
  private static final int METHODID_RESET_INSTANCE = 13;
  private static final int METHODID_REPORT_INSTANCE_INFO = 14;
  private static final int METHODID_IS_INSTANCE_UPGRADEABLE = 15;
  private static final int METHODID_GET_INSTANCE_HEALTH = 16;
  private static final int METHODID_UPGRADE_INSTANCE = 17;
  private static final int METHODID_ROLLBACK_INSTANCE = 18;
  private static final int METHODID_DIAGNOSE_INSTANCE = 19;
  private static final int METHODID_UPGRADE_INSTANCE_INTERNAL = 20;
  private static final int METHODID_LIST_ENVIRONMENTS = 21;
  private static final int METHODID_GET_ENVIRONMENT = 22;
  private static final int METHODID_CREATE_ENVIRONMENT = 23;
  private static final int METHODID_DELETE_ENVIRONMENT = 24;
  private static final int METHODID_LIST_SCHEDULES = 25;
  private static final int METHODID_GET_SCHEDULE = 26;
  private static final int METHODID_DELETE_SCHEDULE = 27;
  private static final int METHODID_CREATE_SCHEDULE = 28;
  private static final int METHODID_TRIGGER_SCHEDULE = 29;
  private static final int METHODID_LIST_EXECUTIONS = 30;
  private static final int METHODID_GET_EXECUTION = 31;
  private static final int METHODID_DELETE_EXECUTION = 32;
  private static final int METHODID_CREATE_EXECUTION = 33;

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
              (com.google.cloud.notebooks.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.notebooks.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.notebooks.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REGISTER_INSTANCE:
          serviceImpl.registerInstance(
              (com.google.cloud.notebooks.v1.RegisterInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_INSTANCE_ACCELERATOR:
          serviceImpl.setInstanceAccelerator(
              (com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_INSTANCE_MACHINE_TYPE:
          serviceImpl.setInstanceMachineType(
              (com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE_CONFIG:
          serviceImpl.updateInstanceConfig(
              (com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SHIELDED_INSTANCE_CONFIG:
          serviceImpl.updateShieldedInstanceConfig(
              (com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_INSTANCE_LABELS:
          serviceImpl.setInstanceLabels(
              (com.google.cloud.notebooks.v1.SetInstanceLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE_METADATA_ITEMS:
          serviceImpl.updateInstanceMetadataItems(
              (com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.notebooks.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_START_INSTANCE:
          serviceImpl.startInstance(
              (com.google.cloud.notebooks.v1.StartInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_INSTANCE:
          serviceImpl.stopInstance(
              (com.google.cloud.notebooks.v1.StopInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESET_INSTANCE:
          serviceImpl.resetInstance(
              (com.google.cloud.notebooks.v1.ResetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPORT_INSTANCE_INFO:
          serviceImpl.reportInstanceInfo(
              (com.google.cloud.notebooks.v1.ReportInstanceInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IS_INSTANCE_UPGRADEABLE:
          serviceImpl.isInstanceUpgradeable(
              (com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE_HEALTH:
          serviceImpl.getInstanceHealth(
              (com.google.cloud.notebooks.v1.GetInstanceHealthRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.GetInstanceHealthResponse>)
                  responseObserver);
          break;
        case METHODID_UPGRADE_INSTANCE:
          serviceImpl.upgradeInstance(
              (com.google.cloud.notebooks.v1.UpgradeInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ROLLBACK_INSTANCE:
          serviceImpl.rollbackInstance(
              (com.google.cloud.notebooks.v1.RollbackInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DIAGNOSE_INSTANCE:
          serviceImpl.diagnoseInstance(
              (com.google.cloud.notebooks.v1.DiagnoseInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPGRADE_INSTANCE_INTERNAL:
          serviceImpl.upgradeInstanceInternal(
              (com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments(
              (com.google.cloud.notebooks.v1.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListEnvironmentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment(
              (com.google.cloud.notebooks.v1.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Environment>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment(
              (com.google.cloud.notebooks.v1.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment(
              (com.google.cloud.notebooks.v1.DeleteEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SCHEDULES:
          serviceImpl.listSchedules(
              (com.google.cloud.notebooks.v1.ListSchedulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListSchedulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCHEDULE:
          serviceImpl.getSchedule(
              (com.google.cloud.notebooks.v1.GetScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Schedule>)
                  responseObserver);
          break;
        case METHODID_DELETE_SCHEDULE:
          serviceImpl.deleteSchedule(
              (com.google.cloud.notebooks.v1.DeleteScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SCHEDULE:
          serviceImpl.createSchedule(
              (com.google.cloud.notebooks.v1.CreateScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_TRIGGER_SCHEDULE:
          serviceImpl.triggerSchedule(
              (com.google.cloud.notebooks.v1.TriggerScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_EXECUTIONS:
          serviceImpl.listExecutions(
              (com.google.cloud.notebooks.v1.ListExecutionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.ListExecutionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EXECUTION:
          serviceImpl.getExecution(
              (com.google.cloud.notebooks.v1.GetExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.notebooks.v1.Execution>)
                  responseObserver);
          break;
        case METHODID_DELETE_EXECUTION:
          serviceImpl.deleteExecution(
              (com.google.cloud.notebooks.v1.DeleteExecutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_EXECUTION:
          serviceImpl.createExecution(
              (com.google.cloud.notebooks.v1.CreateExecutionRequest) request,
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
                    com.google.cloud.notebooks.v1.ListInstancesRequest,
                    com.google.cloud.notebooks.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.GetInstanceRequest,
                    com.google.cloud.notebooks.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getRegisterInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.RegisterInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_REGISTER_INSTANCE)))
        .addMethod(
            getSetInstanceAcceleratorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.SetInstanceAcceleratorRequest,
                    com.google.longrunning.Operation>(service, METHODID_SET_INSTANCE_ACCELERATOR)))
        .addMethod(
            getSetInstanceMachineTypeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.SetInstanceMachineTypeRequest,
                    com.google.longrunning.Operation>(service, METHODID_SET_INSTANCE_MACHINE_TYPE)))
        .addMethod(
            getUpdateInstanceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.UpdateInstanceConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE_CONFIG)))
        .addMethod(
            getUpdateShieldedInstanceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.UpdateShieldedInstanceConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_SHIELDED_INSTANCE_CONFIG)))
        .addMethod(
            getSetInstanceLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.SetInstanceLabelsRequest,
                    com.google.longrunning.Operation>(service, METHODID_SET_INSTANCE_LABELS)))
        .addMethod(
            getUpdateInstanceMetadataItemsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsRequest,
                    com.google.cloud.notebooks.v1.UpdateInstanceMetadataItemsResponse>(
                    service, METHODID_UPDATE_INSTANCE_METADATA_ITEMS)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getStartInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.StartInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_START_INSTANCE)))
        .addMethod(
            getStopInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.StopInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_STOP_INSTANCE)))
        .addMethod(
            getResetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.ResetInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESET_INSTANCE)))
        .addMethod(
            getReportInstanceInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.ReportInstanceInfoRequest,
                    com.google.longrunning.Operation>(service, METHODID_REPORT_INSTANCE_INFO)))
        .addMethod(
            getIsInstanceUpgradeableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.IsInstanceUpgradeableRequest,
                    com.google.cloud.notebooks.v1.IsInstanceUpgradeableResponse>(
                    service, METHODID_IS_INSTANCE_UPGRADEABLE)))
        .addMethod(
            getGetInstanceHealthMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.GetInstanceHealthRequest,
                    com.google.cloud.notebooks.v1.GetInstanceHealthResponse>(
                    service, METHODID_GET_INSTANCE_HEALTH)))
        .addMethod(
            getUpgradeInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.UpgradeInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_INSTANCE)))
        .addMethod(
            getRollbackInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.RollbackInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_ROLLBACK_INSTANCE)))
        .addMethod(
            getDiagnoseInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.DiagnoseInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DIAGNOSE_INSTANCE)))
        .addMethod(
            getUpgradeInstanceInternalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.UpgradeInstanceInternalRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPGRADE_INSTANCE_INTERNAL)))
        .addMethod(
            getListEnvironmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.ListEnvironmentsRequest,
                    com.google.cloud.notebooks.v1.ListEnvironmentsResponse>(
                    service, METHODID_LIST_ENVIRONMENTS)))
        .addMethod(
            getGetEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.GetEnvironmentRequest,
                    com.google.cloud.notebooks.v1.Environment>(service, METHODID_GET_ENVIRONMENT)))
        .addMethod(
            getCreateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.CreateEnvironmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENVIRONMENT)))
        .addMethod(
            getDeleteEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.DeleteEnvironmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENVIRONMENT)))
        .addMethod(
            getListSchedulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.ListSchedulesRequest,
                    com.google.cloud.notebooks.v1.ListSchedulesResponse>(
                    service, METHODID_LIST_SCHEDULES)))
        .addMethod(
            getGetScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.GetScheduleRequest,
                    com.google.cloud.notebooks.v1.Schedule>(service, METHODID_GET_SCHEDULE)))
        .addMethod(
            getDeleteScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.DeleteScheduleRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SCHEDULE)))
        .addMethod(
            getCreateScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.CreateScheduleRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SCHEDULE)))
        .addMethod(
            getTriggerScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.TriggerScheduleRequest,
                    com.google.longrunning.Operation>(service, METHODID_TRIGGER_SCHEDULE)))
        .addMethod(
            getListExecutionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.ListExecutionsRequest,
                    com.google.cloud.notebooks.v1.ListExecutionsResponse>(
                    service, METHODID_LIST_EXECUTIONS)))
        .addMethod(
            getGetExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.GetExecutionRequest,
                    com.google.cloud.notebooks.v1.Execution>(service, METHODID_GET_EXECUTION)))
        .addMethod(
            getDeleteExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.DeleteExecutionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EXECUTION)))
        .addMethod(
            getCreateExecutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.notebooks.v1.CreateExecutionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EXECUTION)))
        .build();
  }

  private abstract static class NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NotebookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.notebooks.v1.NotebooksProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NotebookService");
    }
  }

  private static final class NotebookServiceFileDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier {
    NotebookServiceFileDescriptorSupplier() {}
  }

  private static final class NotebookServiceMethodDescriptorSupplier
      extends NotebookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NotebookServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NotebookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NotebookServiceFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getRegisterInstanceMethod())
                      .addMethod(getSetInstanceAcceleratorMethod())
                      .addMethod(getSetInstanceMachineTypeMethod())
                      .addMethod(getUpdateInstanceConfigMethod())
                      .addMethod(getUpdateShieldedInstanceConfigMethod())
                      .addMethod(getSetInstanceLabelsMethod())
                      .addMethod(getUpdateInstanceMetadataItemsMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getStartInstanceMethod())
                      .addMethod(getStopInstanceMethod())
                      .addMethod(getResetInstanceMethod())
                      .addMethod(getReportInstanceInfoMethod())
                      .addMethod(getIsInstanceUpgradeableMethod())
                      .addMethod(getGetInstanceHealthMethod())
                      .addMethod(getUpgradeInstanceMethod())
                      .addMethod(getRollbackInstanceMethod())
                      .addMethod(getDiagnoseInstanceMethod())
                      .addMethod(getUpgradeInstanceInternalMethod())
                      .addMethod(getListEnvironmentsMethod())
                      .addMethod(getGetEnvironmentMethod())
                      .addMethod(getCreateEnvironmentMethod())
                      .addMethod(getDeleteEnvironmentMethod())
                      .addMethod(getListSchedulesMethod())
                      .addMethod(getGetScheduleMethod())
                      .addMethod(getDeleteScheduleMethod())
                      .addMethod(getCreateScheduleMethod())
                      .addMethod(getTriggerScheduleMethod())
                      .addMethod(getListExecutionsMethod())
                      .addMethod(getGetExecutionMethod())
                      .addMethod(getDeleteExecutionMethod())
                      .addMethod(getCreateExecutionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
