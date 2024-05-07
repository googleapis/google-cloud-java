/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.visionai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/platform.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppPlatformGrpc {

  private AppPlatformGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.AppPlatform";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListApplicationsRequest,
          com.google.cloud.visionai.v1.ListApplicationsResponse>
      getListApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplications",
      requestType = com.google.cloud.visionai.v1.ListApplicationsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListApplicationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListApplicationsRequest,
          com.google.cloud.visionai.v1.ListApplicationsResponse>
      getListApplicationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListApplicationsRequest,
            com.google.cloud.visionai.v1.ListApplicationsResponse>
        getListApplicationsMethod;
    if ((getListApplicationsMethod = AppPlatformGrpc.getListApplicationsMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getListApplicationsMethod = AppPlatformGrpc.getListApplicationsMethod) == null) {
          AppPlatformGrpc.getListApplicationsMethod =
              getListApplicationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListApplicationsRequest,
                          com.google.cloud.visionai.v1.ListApplicationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApplications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListApplicationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListApplicationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("ListApplications"))
                      .build();
        }
      }
    }
    return getListApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetApplicationRequest,
          com.google.cloud.visionai.v1.Application>
      getGetApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplication",
      requestType = com.google.cloud.visionai.v1.GetApplicationRequest.class,
      responseType = com.google.cloud.visionai.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetApplicationRequest,
          com.google.cloud.visionai.v1.Application>
      getGetApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetApplicationRequest,
            com.google.cloud.visionai.v1.Application>
        getGetApplicationMethod;
    if ((getGetApplicationMethod = AppPlatformGrpc.getGetApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getGetApplicationMethod = AppPlatformGrpc.getGetApplicationMethod) == null) {
          AppPlatformGrpc.getGetApplicationMethod =
              getGetApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetApplicationRequest,
                          com.google.cloud.visionai.v1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("GetApplication"))
                      .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateApplicationRequest, com.google.longrunning.Operation>
      getCreateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplication",
      requestType = com.google.cloud.visionai.v1.CreateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateApplicationRequest, com.google.longrunning.Operation>
      getCreateApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateApplicationRequest, com.google.longrunning.Operation>
        getCreateApplicationMethod;
    if ((getCreateApplicationMethod = AppPlatformGrpc.getCreateApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getCreateApplicationMethod = AppPlatformGrpc.getCreateApplicationMethod) == null) {
          AppPlatformGrpc.getCreateApplicationMethod =
              getCreateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("CreateApplication"))
                      .build();
        }
      }
    }
    return getCreateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationRequest, com.google.longrunning.Operation>
      getUpdateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplication",
      requestType = com.google.cloud.visionai.v1.UpdateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationRequest, com.google.longrunning.Operation>
      getUpdateApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateApplicationRequest, com.google.longrunning.Operation>
        getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = AppPlatformGrpc.getUpdateApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUpdateApplicationMethod = AppPlatformGrpc.getUpdateApplicationMethod) == null) {
          AppPlatformGrpc.getUpdateApplicationMethod =
              getUpdateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("UpdateApplication"))
                      .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteApplicationRequest, com.google.longrunning.Operation>
      getDeleteApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplication",
      requestType = com.google.cloud.visionai.v1.DeleteApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteApplicationRequest, com.google.longrunning.Operation>
      getDeleteApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteApplicationRequest, com.google.longrunning.Operation>
        getDeleteApplicationMethod;
    if ((getDeleteApplicationMethod = AppPlatformGrpc.getDeleteApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getDeleteApplicationMethod = AppPlatformGrpc.getDeleteApplicationMethod) == null) {
          AppPlatformGrpc.getDeleteApplicationMethod =
              getDeleteApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("DeleteApplication"))
                      .build();
        }
      }
    }
    return getDeleteApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeployApplicationRequest, com.google.longrunning.Operation>
      getDeployApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployApplication",
      requestType = com.google.cloud.visionai.v1.DeployApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeployApplicationRequest, com.google.longrunning.Operation>
      getDeployApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeployApplicationRequest, com.google.longrunning.Operation>
        getDeployApplicationMethod;
    if ((getDeployApplicationMethod = AppPlatformGrpc.getDeployApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getDeployApplicationMethod = AppPlatformGrpc.getDeployApplicationMethod) == null) {
          AppPlatformGrpc.getDeployApplicationMethod =
              getDeployApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeployApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeployApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("DeployApplication"))
                      .build();
        }
      }
    }
    return getDeployApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UndeployApplicationRequest, com.google.longrunning.Operation>
      getUndeployApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployApplication",
      requestType = com.google.cloud.visionai.v1.UndeployApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UndeployApplicationRequest, com.google.longrunning.Operation>
      getUndeployApplicationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UndeployApplicationRequest,
            com.google.longrunning.Operation>
        getUndeployApplicationMethod;
    if ((getUndeployApplicationMethod = AppPlatformGrpc.getUndeployApplicationMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUndeployApplicationMethod = AppPlatformGrpc.getUndeployApplicationMethod) == null) {
          AppPlatformGrpc.getUndeployApplicationMethod =
              getUndeployApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UndeployApplicationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeployApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UndeployApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("UndeployApplication"))
                      .build();
        }
      }
    }
    return getUndeployApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AddApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getAddApplicationStreamInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddApplicationStreamInput",
      requestType = com.google.cloud.visionai.v1.AddApplicationStreamInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.AddApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getAddApplicationStreamInputMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.AddApplicationStreamInputRequest,
            com.google.longrunning.Operation>
        getAddApplicationStreamInputMethod;
    if ((getAddApplicationStreamInputMethod = AppPlatformGrpc.getAddApplicationStreamInputMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getAddApplicationStreamInputMethod =
                AppPlatformGrpc.getAddApplicationStreamInputMethod)
            == null) {
          AppPlatformGrpc.getAddApplicationStreamInputMethod =
              getAddApplicationStreamInputMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.AddApplicationStreamInputRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddApplicationStreamInput"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.AddApplicationStreamInputRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("AddApplicationStreamInput"))
                      .build();
        }
      }
    }
    return getAddApplicationStreamInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getRemoveApplicationStreamInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveApplicationStreamInput",
      requestType = com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getRemoveApplicationStreamInputMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest,
            com.google.longrunning.Operation>
        getRemoveApplicationStreamInputMethod;
    if ((getRemoveApplicationStreamInputMethod =
            AppPlatformGrpc.getRemoveApplicationStreamInputMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getRemoveApplicationStreamInputMethod =
                AppPlatformGrpc.getRemoveApplicationStreamInputMethod)
            == null) {
          AppPlatformGrpc.getRemoveApplicationStreamInputMethod =
              getRemoveApplicationStreamInputMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RemoveApplicationStreamInput"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("RemoveApplicationStreamInput"))
                      .build();
        }
      }
    }
    return getRemoveApplicationStreamInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getUpdateApplicationStreamInputMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplicationStreamInput",
      requestType = com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest,
          com.google.longrunning.Operation>
      getUpdateApplicationStreamInputMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest,
            com.google.longrunning.Operation>
        getUpdateApplicationStreamInputMethod;
    if ((getUpdateApplicationStreamInputMethod =
            AppPlatformGrpc.getUpdateApplicationStreamInputMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUpdateApplicationStreamInputMethod =
                AppPlatformGrpc.getUpdateApplicationStreamInputMethod)
            == null) {
          AppPlatformGrpc.getUpdateApplicationStreamInputMethod =
              getUpdateApplicationStreamInputMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateApplicationStreamInput"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("UpdateApplicationStreamInput"))
                      .build();
        }
      }
    }
    return getUpdateApplicationStreamInputMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListInstancesRequest,
          com.google.cloud.visionai.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.visionai.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.visionai.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListInstancesRequest,
          com.google.cloud.visionai.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListInstancesRequest,
            com.google.cloud.visionai.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = AppPlatformGrpc.getListInstancesMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getListInstancesMethod = AppPlatformGrpc.getListInstancesMethod) == null) {
          AppPlatformGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListInstancesRequest,
                          com.google.cloud.visionai.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetInstanceRequest, com.google.cloud.visionai.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.visionai.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.visionai.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetInstanceRequest, com.google.cloud.visionai.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetInstanceRequest, com.google.cloud.visionai.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = AppPlatformGrpc.getGetInstanceMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getGetInstanceMethod = AppPlatformGrpc.getGetInstanceMethod) == null) {
          AppPlatformGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetInstanceRequest,
                          com.google.cloud.visionai.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getCreateApplicationInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplicationInstances",
      requestType = com.google.cloud.visionai.v1.CreateApplicationInstancesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getCreateApplicationInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateApplicationInstancesRequest,
            com.google.longrunning.Operation>
        getCreateApplicationInstancesMethod;
    if ((getCreateApplicationInstancesMethod = AppPlatformGrpc.getCreateApplicationInstancesMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getCreateApplicationInstancesMethod =
                AppPlatformGrpc.getCreateApplicationInstancesMethod)
            == null) {
          AppPlatformGrpc.getCreateApplicationInstancesMethod =
              getCreateApplicationInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateApplicationInstancesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateApplicationInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateApplicationInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("CreateApplicationInstances"))
                      .build();
        }
      }
    }
    return getCreateApplicationInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getDeleteApplicationInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplicationInstances",
      requestType = com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getDeleteApplicationInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest,
            com.google.longrunning.Operation>
        getDeleteApplicationInstancesMethod;
    if ((getDeleteApplicationInstancesMethod = AppPlatformGrpc.getDeleteApplicationInstancesMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getDeleteApplicationInstancesMethod =
                AppPlatformGrpc.getDeleteApplicationInstancesMethod)
            == null) {
          AppPlatformGrpc.getDeleteApplicationInstancesMethod =
              getDeleteApplicationInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteApplicationInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("DeleteApplicationInstances"))
                      .build();
        }
      }
    }
    return getDeleteApplicationInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getUpdateApplicationInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplicationInstances",
      requestType = com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest,
          com.google.longrunning.Operation>
      getUpdateApplicationInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest,
            com.google.longrunning.Operation>
        getUpdateApplicationInstancesMethod;
    if ((getUpdateApplicationInstancesMethod = AppPlatformGrpc.getUpdateApplicationInstancesMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUpdateApplicationInstancesMethod =
                AppPlatformGrpc.getUpdateApplicationInstancesMethod)
            == null) {
          AppPlatformGrpc.getUpdateApplicationInstancesMethod =
              getUpdateApplicationInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateApplicationInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("UpdateApplicationInstances"))
                      .build();
        }
      }
    }
    return getUpdateApplicationInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListDraftsRequest,
          com.google.cloud.visionai.v1.ListDraftsResponse>
      getListDraftsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDrafts",
      requestType = com.google.cloud.visionai.v1.ListDraftsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListDraftsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListDraftsRequest,
          com.google.cloud.visionai.v1.ListDraftsResponse>
      getListDraftsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListDraftsRequest,
            com.google.cloud.visionai.v1.ListDraftsResponse>
        getListDraftsMethod;
    if ((getListDraftsMethod = AppPlatformGrpc.getListDraftsMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getListDraftsMethod = AppPlatformGrpc.getListDraftsMethod) == null) {
          AppPlatformGrpc.getListDraftsMethod =
              getListDraftsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListDraftsRequest,
                          com.google.cloud.visionai.v1.ListDraftsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDrafts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListDraftsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListDraftsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("ListDrafts"))
                      .build();
        }
      }
    }
    return getListDraftsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetDraftRequest, com.google.cloud.visionai.v1.Draft>
      getGetDraftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDraft",
      requestType = com.google.cloud.visionai.v1.GetDraftRequest.class,
      responseType = com.google.cloud.visionai.v1.Draft.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetDraftRequest, com.google.cloud.visionai.v1.Draft>
      getGetDraftMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetDraftRequest, com.google.cloud.visionai.v1.Draft>
        getGetDraftMethod;
    if ((getGetDraftMethod = AppPlatformGrpc.getGetDraftMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getGetDraftMethod = AppPlatformGrpc.getGetDraftMethod) == null) {
          AppPlatformGrpc.getGetDraftMethod =
              getGetDraftMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetDraftRequest,
                          com.google.cloud.visionai.v1.Draft>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDraft"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetDraftRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Draft.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("GetDraft"))
                      .build();
        }
      }
    }
    return getGetDraftMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateDraftRequest, com.google.longrunning.Operation>
      getCreateDraftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDraft",
      requestType = com.google.cloud.visionai.v1.CreateDraftRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateDraftRequest, com.google.longrunning.Operation>
      getCreateDraftMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateDraftRequest, com.google.longrunning.Operation>
        getCreateDraftMethod;
    if ((getCreateDraftMethod = AppPlatformGrpc.getCreateDraftMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getCreateDraftMethod = AppPlatformGrpc.getCreateDraftMethod) == null) {
          AppPlatformGrpc.getCreateDraftMethod =
              getCreateDraftMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateDraftRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDraft"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateDraftRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("CreateDraft"))
                      .build();
        }
      }
    }
    return getCreateDraftMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateDraftRequest, com.google.longrunning.Operation>
      getUpdateDraftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDraft",
      requestType = com.google.cloud.visionai.v1.UpdateDraftRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateDraftRequest, com.google.longrunning.Operation>
      getUpdateDraftMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateDraftRequest, com.google.longrunning.Operation>
        getUpdateDraftMethod;
    if ((getUpdateDraftMethod = AppPlatformGrpc.getUpdateDraftMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUpdateDraftMethod = AppPlatformGrpc.getUpdateDraftMethod) == null) {
          AppPlatformGrpc.getUpdateDraftMethod =
              getUpdateDraftMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateDraftRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDraft"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateDraftRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("UpdateDraft"))
                      .build();
        }
      }
    }
    return getUpdateDraftMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteDraftRequest, com.google.longrunning.Operation>
      getDeleteDraftMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDraft",
      requestType = com.google.cloud.visionai.v1.DeleteDraftRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteDraftRequest, com.google.longrunning.Operation>
      getDeleteDraftMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteDraftRequest, com.google.longrunning.Operation>
        getDeleteDraftMethod;
    if ((getDeleteDraftMethod = AppPlatformGrpc.getDeleteDraftMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getDeleteDraftMethod = AppPlatformGrpc.getDeleteDraftMethod) == null) {
          AppPlatformGrpc.getDeleteDraftMethod =
              getDeleteDraftMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteDraftRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDraft"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteDraftRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("DeleteDraft"))
                      .build();
        }
      }
    }
    return getDeleteDraftMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListProcessorsRequest,
          com.google.cloud.visionai.v1.ListProcessorsResponse>
      getListProcessorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcessors",
      requestType = com.google.cloud.visionai.v1.ListProcessorsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListProcessorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListProcessorsRequest,
          com.google.cloud.visionai.v1.ListProcessorsResponse>
      getListProcessorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListProcessorsRequest,
            com.google.cloud.visionai.v1.ListProcessorsResponse>
        getListProcessorsMethod;
    if ((getListProcessorsMethod = AppPlatformGrpc.getListProcessorsMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getListProcessorsMethod = AppPlatformGrpc.getListProcessorsMethod) == null) {
          AppPlatformGrpc.getListProcessorsMethod =
              getListProcessorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListProcessorsRequest,
                          com.google.cloud.visionai.v1.ListProcessorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProcessors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListProcessorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListProcessorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("ListProcessors"))
                      .build();
        }
      }
    }
    return getListProcessorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest,
          com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
      getListPrebuiltProcessorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrebuiltProcessors",
      requestType = com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest,
          com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
      getListPrebuiltProcessorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest,
            com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
        getListPrebuiltProcessorsMethod;
    if ((getListPrebuiltProcessorsMethod = AppPlatformGrpc.getListPrebuiltProcessorsMethod)
        == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getListPrebuiltProcessorsMethod = AppPlatformGrpc.getListPrebuiltProcessorsMethod)
            == null) {
          AppPlatformGrpc.getListPrebuiltProcessorsMethod =
              getListPrebuiltProcessorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest,
                          com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPrebuiltProcessors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("ListPrebuiltProcessors"))
                      .build();
        }
      }
    }
    return getListPrebuiltProcessorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetProcessorRequest, com.google.cloud.visionai.v1.Processor>
      getGetProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProcessor",
      requestType = com.google.cloud.visionai.v1.GetProcessorRequest.class,
      responseType = com.google.cloud.visionai.v1.Processor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetProcessorRequest, com.google.cloud.visionai.v1.Processor>
      getGetProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetProcessorRequest,
            com.google.cloud.visionai.v1.Processor>
        getGetProcessorMethod;
    if ((getGetProcessorMethod = AppPlatformGrpc.getGetProcessorMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getGetProcessorMethod = AppPlatformGrpc.getGetProcessorMethod) == null) {
          AppPlatformGrpc.getGetProcessorMethod =
              getGetProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetProcessorRequest,
                          com.google.cloud.visionai.v1.Processor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Processor.getDefaultInstance()))
                      .setSchemaDescriptor(new AppPlatformMethodDescriptorSupplier("GetProcessor"))
                      .build();
        }
      }
    }
    return getGetProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateProcessorRequest, com.google.longrunning.Operation>
      getCreateProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProcessor",
      requestType = com.google.cloud.visionai.v1.CreateProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateProcessorRequest, com.google.longrunning.Operation>
      getCreateProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateProcessorRequest, com.google.longrunning.Operation>
        getCreateProcessorMethod;
    if ((getCreateProcessorMethod = AppPlatformGrpc.getCreateProcessorMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getCreateProcessorMethod = AppPlatformGrpc.getCreateProcessorMethod) == null) {
          AppPlatformGrpc.getCreateProcessorMethod =
              getCreateProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("CreateProcessor"))
                      .build();
        }
      }
    }
    return getCreateProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateProcessorRequest, com.google.longrunning.Operation>
      getUpdateProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProcessor",
      requestType = com.google.cloud.visionai.v1.UpdateProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateProcessorRequest, com.google.longrunning.Operation>
      getUpdateProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateProcessorRequest, com.google.longrunning.Operation>
        getUpdateProcessorMethod;
    if ((getUpdateProcessorMethod = AppPlatformGrpc.getUpdateProcessorMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getUpdateProcessorMethod = AppPlatformGrpc.getUpdateProcessorMethod) == null) {
          AppPlatformGrpc.getUpdateProcessorMethod =
              getUpdateProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("UpdateProcessor"))
                      .build();
        }
      }
    }
    return getUpdateProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
      getDeleteProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProcessor",
      requestType = com.google.cloud.visionai.v1.DeleteProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
      getDeleteProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
        getDeleteProcessorMethod;
    if ((getDeleteProcessorMethod = AppPlatformGrpc.getDeleteProcessorMethod) == null) {
      synchronized (AppPlatformGrpc.class) {
        if ((getDeleteProcessorMethod = AppPlatformGrpc.getDeleteProcessorMethod) == null) {
          AppPlatformGrpc.getDeleteProcessorMethod =
              getDeleteProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AppPlatformMethodDescriptorSupplier("DeleteProcessor"))
                      .build();
        }
      }
    }
    return getDeleteProcessorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AppPlatformStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppPlatformStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppPlatformStub>() {
          @java.lang.Override
          public AppPlatformStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppPlatformStub(channel, callOptions);
          }
        };
    return AppPlatformStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppPlatformBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppPlatformBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppPlatformBlockingStub>() {
          @java.lang.Override
          public AppPlatformBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppPlatformBlockingStub(channel, callOptions);
          }
        };
    return AppPlatformBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AppPlatformFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppPlatformFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AppPlatformFutureStub>() {
          @java.lang.Override
          public AppPlatformFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AppPlatformFutureStub(channel, callOptions);
          }
        };
    return AppPlatformFutureStub.newStub(factory, channel);
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
     * Lists Applications in a given project and location.
     * </pre>
     */
    default void listApplications(
        com.google.cloud.visionai.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListApplicationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Application.
     * </pre>
     */
    default void getApplication(
        com.google.cloud.visionai.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Application in a given project and location.
     * </pre>
     */
    default void createApplication(
        com.google.cloud.visionai.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Application.
     * </pre>
     */
    default void updateApplication(
        com.google.cloud.visionai.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Application.
     * </pre>
     */
    default void deleteApplication(
        com.google.cloud.visionai.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a single Application.
     * </pre>
     */
    default void deployApplication(
        com.google.cloud.visionai.v1.DeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a single Application.
     * </pre>
     */
    default void undeployApplication(
        com.google.cloud.visionai.v1.UndeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployApplicationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    default void addApplicationStreamInput(
        com.google.cloud.visionai.v1.AddApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddApplicationStreamInputMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    default void removeApplicationStreamInput(
        com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveApplicationStreamInputMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deployed. For
     * CreateOrUpdate behavior, set allow_missing to true.
     * </pre>
     */
    default void updateApplicationStreamInput(
        com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApplicationStreamInputMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.visionai.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListInstancesResponse>
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
        com.google.cloud.visionai.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    default void createApplicationInstances(
        com.google.cloud.visionai.v1.CreateApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApplicationInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    default void deleteApplicationInstances(
        com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteApplicationInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    default void updateApplicationInstances(
        com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateApplicationInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Drafts in a given project and location.
     * </pre>
     */
    default void listDrafts(
        com.google.cloud.visionai.v1.ListDraftsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDraftsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDraftsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Draft.
     * </pre>
     */
    default void getDraft(
        com.google.cloud.visionai.v1.GetDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Draft> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDraftMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Draft in a given project and location.
     * </pre>
     */
    default void createDraft(
        com.google.cloud.visionai.v1.CreateDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDraftMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Draft.
     * </pre>
     */
    default void updateDraft(
        com.google.cloud.visionai.v1.UpdateDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDraftMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Draft.
     * </pre>
     */
    default void deleteDraft(
        com.google.cloud.visionai.v1.DeleteDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDraftMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Processors in a given project and location.
     * </pre>
     */
    default void listProcessors(
        com.google.cloud.visionai.v1.ListProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt
     * Processors.
     * </pre>
     */
    default void listPrebuiltProcessors(
        com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPrebuiltProcessorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Processor.
     * </pre>
     */
    default void getProcessor(
        com.google.cloud.visionai.v1.GetProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Processor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Processor in a given project and location.
     * </pre>
     */
    default void createProcessor(
        com.google.cloud.visionai.v1.CreateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Processor.
     * </pre>
     */
    default void updateProcessor(
        com.google.cloud.visionai.v1.UpdateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Processor.
     * </pre>
     */
    default void deleteProcessor(
        com.google.cloud.visionai.v1.DeleteProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProcessorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AppPlatform.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AppPlatformImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AppPlatformGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AppPlatform.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppPlatformStub
      extends io.grpc.stub.AbstractAsyncStub<AppPlatformStub> {
    private AppPlatformStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppPlatformStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppPlatformStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Applications in a given project and location.
     * </pre>
     */
    public void listApplications(
        com.google.cloud.visionai.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListApplicationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Application.
     * </pre>
     */
    public void getApplication(
        com.google.cloud.visionai.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Application in a given project and location.
     * </pre>
     */
    public void createApplication(
        com.google.cloud.visionai.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Application.
     * </pre>
     */
    public void updateApplication(
        com.google.cloud.visionai.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Application.
     * </pre>
     */
    public void deleteApplication(
        com.google.cloud.visionai.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys a single Application.
     * </pre>
     */
    public void deployApplication(
        com.google.cloud.visionai.v1.DeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a single Application.
     * </pre>
     */
    public void undeployApplication(
        com.google.cloud.visionai.v1.UndeployApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployApplicationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public void addApplicationStreamInput(
        com.google.cloud.visionai.v1.AddApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddApplicationStreamInputMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public void removeApplicationStreamInput(
        com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveApplicationStreamInputMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deployed. For
     * CreateOrUpdate behavior, set allow_missing to true.
     * </pre>
     */
    public void updateApplicationStreamInput(
        com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationStreamInputMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.visionai.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListInstancesResponse>
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
        com.google.cloud.visionai.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public void createApplicationInstances(
        com.google.cloud.visionai.v1.CreateApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public void deleteApplicationInstances(
        com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public void updateApplicationInstances(
        com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Drafts in a given project and location.
     * </pre>
     */
    public void listDrafts(
        com.google.cloud.visionai.v1.ListDraftsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDraftsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDraftsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Draft.
     * </pre>
     */
    public void getDraft(
        com.google.cloud.visionai.v1.GetDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Draft> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDraftMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Draft in a given project and location.
     * </pre>
     */
    public void createDraft(
        com.google.cloud.visionai.v1.CreateDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDraftMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Draft.
     * </pre>
     */
    public void updateDraft(
        com.google.cloud.visionai.v1.UpdateDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDraftMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Draft.
     * </pre>
     */
    public void deleteDraft(
        com.google.cloud.visionai.v1.DeleteDraftRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDraftMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Processors in a given project and location.
     * </pre>
     */
    public void listProcessors(
        com.google.cloud.visionai.v1.ListProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt
     * Processors.
     * </pre>
     */
    public void listPrebuiltProcessors(
        com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPrebuiltProcessorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Processor.
     * </pre>
     */
    public void getProcessor(
        com.google.cloud.visionai.v1.GetProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Processor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Processor in a given project and location.
     * </pre>
     */
    public void createProcessor(
        com.google.cloud.visionai.v1.CreateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Processor.
     * </pre>
     */
    public void updateProcessor(
        com.google.cloud.visionai.v1.UpdateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Processor.
     * </pre>
     */
    public void deleteProcessor(
        com.google.cloud.visionai.v1.DeleteProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AppPlatform.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppPlatformBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppPlatformBlockingStub> {
    private AppPlatformBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppPlatformBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppPlatformBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Applications in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListApplicationsResponse listApplications(
        com.google.cloud.visionai.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApplicationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Application.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Application getApplication(
        com.google.cloud.visionai.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Application in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApplication(
        com.google.cloud.visionai.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Application.
     * </pre>
     */
    public com.google.longrunning.Operation updateApplication(
        com.google.cloud.visionai.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Application.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApplication(
        com.google.cloud.visionai.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a single Application.
     * </pre>
     */
    public com.google.longrunning.Operation deployApplication(
        com.google.cloud.visionai.v1.DeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a single Application.
     * </pre>
     */
    public com.google.longrunning.Operation undeployApplication(
        com.google.cloud.visionai.v1.UndeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployApplicationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.longrunning.Operation addApplicationStreamInput(
        com.google.cloud.visionai.v1.AddApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddApplicationStreamInputMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public com.google.longrunning.Operation removeApplicationStreamInput(
        com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveApplicationStreamInputMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deployed. For
     * CreateOrUpdate behavior, set allow_missing to true.
     * </pre>
     */
    public com.google.longrunning.Operation updateApplicationStreamInput(
        com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationStreamInputMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListInstancesResponse listInstances(
        com.google.cloud.visionai.v1.ListInstancesRequest request) {
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
    public com.google.cloud.visionai.v1.Instance getInstance(
        com.google.cloud.visionai.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.longrunning.Operation createApplicationInstances(
        com.google.cloud.visionai.v1.CreateApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApplicationInstances(
        com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.longrunning.Operation updateApplicationInstances(
        com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Drafts in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListDraftsResponse listDrafts(
        com.google.cloud.visionai.v1.ListDraftsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDraftsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Draft.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Draft getDraft(
        com.google.cloud.visionai.v1.GetDraftRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDraftMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Draft in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createDraft(
        com.google.cloud.visionai.v1.CreateDraftRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDraftMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Draft.
     * </pre>
     */
    public com.google.longrunning.Operation updateDraft(
        com.google.cloud.visionai.v1.UpdateDraftRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDraftMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Draft.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDraft(
        com.google.cloud.visionai.v1.DeleteDraftRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDraftMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Processors in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListProcessorsResponse listProcessors(
        com.google.cloud.visionai.v1.ListProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt
     * Processors.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse listPrebuiltProcessors(
        com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPrebuiltProcessorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Processor.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Processor getProcessor(
        com.google.cloud.visionai.v1.GetProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Processor in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createProcessor(
        com.google.cloud.visionai.v1.CreateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Processor.
     * </pre>
     */
    public com.google.longrunning.Operation updateProcessor(
        com.google.cloud.visionai.v1.UpdateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Processor.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProcessor(
        com.google.cloud.visionai.v1.DeleteProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProcessorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AppPlatform.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AppPlatformFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppPlatformFutureStub> {
    private AppPlatformFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppPlatformFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppPlatformFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Applications in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListApplicationsResponse>
        listApplications(com.google.cloud.visionai.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Application>
        getApplication(com.google.cloud.visionai.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Application in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createApplication(com.google.cloud.visionai.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateApplication(com.google.cloud.visionai.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteApplication(com.google.cloud.visionai.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys a single Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployApplication(com.google.cloud.visionai.v1.DeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys a single Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployApplication(com.google.cloud.visionai.v1.UndeployApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployApplicationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        addApplicationStreamInput(
            com.google.cloud.visionai.v1.AddApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddApplicationStreamInputMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        removeApplicationStreamInput(
            com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveApplicationStreamInputMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deployed. For
     * CreateOrUpdate behavior, set allow_missing to true.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateApplicationStreamInput(
            com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationStreamInputMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListInstancesResponse>
        listInstances(com.google.cloud.visionai.v1.ListInstancesRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Instance>
        getInstance(com.google.cloud.visionai.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createApplicationInstances(
            com.google.cloud.visionai.v1.CreateApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Remove target stream input to the Application, if the Application is
     * deployed, the corresponding instance based will be deleted. If the stream
     * is not in the Application, the RPC will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteApplicationInstances(
            com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds target stream input to the Application.
     * If the Application is deployed, the corresponding new Application instance
     * will be created. If the stream has already been in the Application, the RPC
     * will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateApplicationInstances(
            com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Drafts in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListDraftsResponse>
        listDrafts(com.google.cloud.visionai.v1.ListDraftsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDraftsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Draft.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Draft>
        getDraft(com.google.cloud.visionai.v1.GetDraftRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDraftMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Draft in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDraft(com.google.cloud.visionai.v1.CreateDraftRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDraftMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Draft.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDraft(com.google.cloud.visionai.v1.UpdateDraftRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDraftMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Draft.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDraft(com.google.cloud.visionai.v1.DeleteDraftRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDraftMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Processors in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListProcessorsResponse>
        listProcessors(com.google.cloud.visionai.v1.ListProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * ListPrebuiltProcessors is a custom pass-through verb that Lists Prebuilt
     * Processors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>
        listPrebuiltProcessors(com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPrebuiltProcessorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.Processor>
        getProcessor(com.google.cloud.visionai.v1.GetProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Processor in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createProcessor(com.google.cloud.visionai.v1.CreateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateProcessor(com.google.cloud.visionai.v1.UpdateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProcessor(com.google.cloud.visionai.v1.DeleteProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProcessorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_APPLICATIONS = 0;
  private static final int METHODID_GET_APPLICATION = 1;
  private static final int METHODID_CREATE_APPLICATION = 2;
  private static final int METHODID_UPDATE_APPLICATION = 3;
  private static final int METHODID_DELETE_APPLICATION = 4;
  private static final int METHODID_DEPLOY_APPLICATION = 5;
  private static final int METHODID_UNDEPLOY_APPLICATION = 6;
  private static final int METHODID_ADD_APPLICATION_STREAM_INPUT = 7;
  private static final int METHODID_REMOVE_APPLICATION_STREAM_INPUT = 8;
  private static final int METHODID_UPDATE_APPLICATION_STREAM_INPUT = 9;
  private static final int METHODID_LIST_INSTANCES = 10;
  private static final int METHODID_GET_INSTANCE = 11;
  private static final int METHODID_CREATE_APPLICATION_INSTANCES = 12;
  private static final int METHODID_DELETE_APPLICATION_INSTANCES = 13;
  private static final int METHODID_UPDATE_APPLICATION_INSTANCES = 14;
  private static final int METHODID_LIST_DRAFTS = 15;
  private static final int METHODID_GET_DRAFT = 16;
  private static final int METHODID_CREATE_DRAFT = 17;
  private static final int METHODID_UPDATE_DRAFT = 18;
  private static final int METHODID_DELETE_DRAFT = 19;
  private static final int METHODID_LIST_PROCESSORS = 20;
  private static final int METHODID_LIST_PREBUILT_PROCESSORS = 21;
  private static final int METHODID_GET_PROCESSOR = 22;
  private static final int METHODID_CREATE_PROCESSOR = 23;
  private static final int METHODID_UPDATE_PROCESSOR = 24;
  private static final int METHODID_DELETE_PROCESSOR = 25;

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
        case METHODID_LIST_APPLICATIONS:
          serviceImpl.listApplications(
              (com.google.cloud.visionai.v1.ListApplicationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListApplicationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication(
              (com.google.cloud.visionai.v1.GetApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Application>)
                  responseObserver);
          break;
        case METHODID_CREATE_APPLICATION:
          serviceImpl.createApplication(
              (com.google.cloud.visionai.v1.CreateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication(
              (com.google.cloud.visionai.v1.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APPLICATION:
          serviceImpl.deleteApplication(
              (com.google.cloud.visionai.v1.DeleteApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_APPLICATION:
          serviceImpl.deployApplication(
              (com.google.cloud.visionai.v1.DeployApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_APPLICATION:
          serviceImpl.undeployApplication(
              (com.google.cloud.visionai.v1.UndeployApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ADD_APPLICATION_STREAM_INPUT:
          serviceImpl.addApplicationStreamInput(
              (com.google.cloud.visionai.v1.AddApplicationStreamInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REMOVE_APPLICATION_STREAM_INPUT:
          serviceImpl.removeApplicationStreamInput(
              (com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION_STREAM_INPUT:
          serviceImpl.updateApplicationStreamInput(
              (com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.visionai.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.visionai.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_APPLICATION_INSTANCES:
          serviceImpl.createApplicationInstances(
              (com.google.cloud.visionai.v1.CreateApplicationInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APPLICATION_INSTANCES:
          serviceImpl.deleteApplicationInstances(
              (com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION_INSTANCES:
          serviceImpl.updateApplicationInstances(
              (com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DRAFTS:
          serviceImpl.listDrafts(
              (com.google.cloud.visionai.v1.ListDraftsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListDraftsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DRAFT:
          serviceImpl.getDraft(
              (com.google.cloud.visionai.v1.GetDraftRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Draft>) responseObserver);
          break;
        case METHODID_CREATE_DRAFT:
          serviceImpl.createDraft(
              (com.google.cloud.visionai.v1.CreateDraftRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DRAFT:
          serviceImpl.updateDraft(
              (com.google.cloud.visionai.v1.UpdateDraftRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DRAFT:
          serviceImpl.deleteDraft(
              (com.google.cloud.visionai.v1.DeleteDraftRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PROCESSORS:
          serviceImpl.listProcessors(
              (com.google.cloud.visionai.v1.ListProcessorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListProcessorsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PREBUILT_PROCESSORS:
          serviceImpl.listPrebuiltProcessors(
              (com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROCESSOR:
          serviceImpl.getProcessor(
              (com.google.cloud.visionai.v1.GetProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Processor>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROCESSOR:
          serviceImpl.createProcessor(
              (com.google.cloud.visionai.v1.CreateProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PROCESSOR:
          serviceImpl.updateProcessor(
              (com.google.cloud.visionai.v1.UpdateProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PROCESSOR:
          serviceImpl.deleteProcessor(
              (com.google.cloud.visionai.v1.DeleteProcessorRequest) request,
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
            getListApplicationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListApplicationsRequest,
                    com.google.cloud.visionai.v1.ListApplicationsResponse>(
                    service, METHODID_LIST_APPLICATIONS)))
        .addMethod(
            getGetApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetApplicationRequest,
                    com.google.cloud.visionai.v1.Application>(service, METHODID_GET_APPLICATION)))
        .addMethod(
            getCreateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_APPLICATION)))
        .addMethod(
            getUpdateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_APPLICATION)))
        .addMethod(
            getDeleteApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_APPLICATION)))
        .addMethod(
            getDeployApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeployApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_APPLICATION)))
        .addMethod(
            getUndeployApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UndeployApplicationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNDEPLOY_APPLICATION)))
        .addMethod(
            getAddApplicationStreamInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.AddApplicationStreamInputRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_ADD_APPLICATION_STREAM_INPUT)))
        .addMethod(
            getRemoveApplicationStreamInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.RemoveApplicationStreamInputRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REMOVE_APPLICATION_STREAM_INPUT)))
        .addMethod(
            getUpdateApplicationStreamInputMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateApplicationStreamInputRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_APPLICATION_STREAM_INPUT)))
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListInstancesRequest,
                    com.google.cloud.visionai.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetInstanceRequest,
                    com.google.cloud.visionai.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateApplicationInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateApplicationInstancesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_APPLICATION_INSTANCES)))
        .addMethod(
            getDeleteApplicationInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteApplicationInstancesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_APPLICATION_INSTANCES)))
        .addMethod(
            getUpdateApplicationInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateApplicationInstancesRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_APPLICATION_INSTANCES)))
        .addMethod(
            getListDraftsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListDraftsRequest,
                    com.google.cloud.visionai.v1.ListDraftsResponse>(
                    service, METHODID_LIST_DRAFTS)))
        .addMethod(
            getGetDraftMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetDraftRequest,
                    com.google.cloud.visionai.v1.Draft>(service, METHODID_GET_DRAFT)))
        .addMethod(
            getCreateDraftMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateDraftRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DRAFT)))
        .addMethod(
            getUpdateDraftMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateDraftRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DRAFT)))
        .addMethod(
            getDeleteDraftMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteDraftRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DRAFT)))
        .addMethod(
            getListProcessorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListProcessorsRequest,
                    com.google.cloud.visionai.v1.ListProcessorsResponse>(
                    service, METHODID_LIST_PROCESSORS)))
        .addMethod(
            getListPrebuiltProcessorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListPrebuiltProcessorsRequest,
                    com.google.cloud.visionai.v1.ListPrebuiltProcessorsResponse>(
                    service, METHODID_LIST_PREBUILT_PROCESSORS)))
        .addMethod(
            getGetProcessorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetProcessorRequest,
                    com.google.cloud.visionai.v1.Processor>(service, METHODID_GET_PROCESSOR)))
        .addMethod(
            getCreateProcessorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateProcessorRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PROCESSOR)))
        .addMethod(
            getUpdateProcessorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateProcessorRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PROCESSOR)))
        .addMethod(
            getDeleteProcessorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteProcessorRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PROCESSOR)))
        .build();
  }

  private abstract static class AppPlatformBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppPlatformBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.PlatformProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppPlatform");
    }
  }

  private static final class AppPlatformFileDescriptorSupplier
      extends AppPlatformBaseDescriptorSupplier {
    AppPlatformFileDescriptorSupplier() {}
  }

  private static final class AppPlatformMethodDescriptorSupplier
      extends AppPlatformBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AppPlatformMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AppPlatformGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AppPlatformFileDescriptorSupplier())
                      .addMethod(getListApplicationsMethod())
                      .addMethod(getGetApplicationMethod())
                      .addMethod(getCreateApplicationMethod())
                      .addMethod(getUpdateApplicationMethod())
                      .addMethod(getDeleteApplicationMethod())
                      .addMethod(getDeployApplicationMethod())
                      .addMethod(getUndeployApplicationMethod())
                      .addMethod(getAddApplicationStreamInputMethod())
                      .addMethod(getRemoveApplicationStreamInputMethod())
                      .addMethod(getUpdateApplicationStreamInputMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateApplicationInstancesMethod())
                      .addMethod(getDeleteApplicationInstancesMethod())
                      .addMethod(getUpdateApplicationInstancesMethod())
                      .addMethod(getListDraftsMethod())
                      .addMethod(getGetDraftMethod())
                      .addMethod(getCreateDraftMethod())
                      .addMethod(getUpdateDraftMethod())
                      .addMethod(getDeleteDraftMethod())
                      .addMethod(getListProcessorsMethod())
                      .addMethod(getListPrebuiltProcessorsMethod())
                      .addMethod(getGetProcessorMethod())
                      .addMethod(getCreateProcessorMethod())
                      .addMethod(getUpdateProcessorMethod())
                      .addMethod(getDeleteProcessorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
