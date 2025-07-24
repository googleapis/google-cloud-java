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
package com.google.cloud.securesourcemanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Secure Source Manager API
 * Access Secure Source Manager instances, resources, and repositories.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securesourcemanager/v1/secure_source_manager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecureSourceManagerGrpc {

  private SecureSourceManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.securesourcemanager.v1.SecureSourceManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
          com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.securesourcemanager.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
          com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
            com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = SecureSourceManagerGrpc.getListInstancesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListInstancesMethod = SecureSourceManagerGrpc.getListInstancesMethod) == null) {
          SecureSourceManagerGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
                          com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
          com.google.cloud.securesourcemanager.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.securesourcemanager.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
          com.google.cloud.securesourcemanager.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
            com.google.cloud.securesourcemanager.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = SecureSourceManagerGrpc.getGetInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetInstanceMethod = SecureSourceManagerGrpc.getGetInstanceMethod) == null) {
          SecureSourceManagerGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
                          com.google.cloud.securesourcemanager.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.Instance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.securesourcemanager.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
            com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = SecureSourceManagerGrpc.getCreateInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateInstanceMethod = SecureSourceManagerGrpc.getCreateInstanceMethod) == null) {
          SecureSourceManagerGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
            com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = SecureSourceManagerGrpc.getDeleteInstanceMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteInstanceMethod = SecureSourceManagerGrpc.getDeleteInstanceMethod) == null) {
          SecureSourceManagerGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
          com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
      getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
          com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
      getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
            com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
        getListRepositoriesMethod;
    if ((getListRepositoriesMethod = SecureSourceManagerGrpc.getListRepositoriesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListRepositoriesMethod = SecureSourceManagerGrpc.getListRepositoriesMethod)
            == null) {
          SecureSourceManagerGrpc.getListRepositoriesMethod =
              getListRepositoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
                          com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListRepositories"))
                      .build();
        }
      }
    }
    return getListRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
          com.google.cloud.securesourcemanager.v1.Repository>
      getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.cloud.securesourcemanager.v1.GetRepositoryRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
          com.google.cloud.securesourcemanager.v1.Repository>
      getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
            com.google.cloud.securesourcemanager.v1.Repository>
        getGetRepositoryMethod;
    if ((getGetRepositoryMethod = SecureSourceManagerGrpc.getGetRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetRepositoryMethod = SecureSourceManagerGrpc.getGetRepositoryMethod) == null) {
          SecureSourceManagerGrpc.getGetRepositoryMethod =
              getGetRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
                          com.google.cloud.securesourcemanager.v1.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.Repository
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetRepository"))
                      .build();
        }
      }
    }
    return getGetRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRepository",
      requestType = com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
            com.google.longrunning.Operation>
        getCreateRepositoryMethod;
    if ((getCreateRepositoryMethod = SecureSourceManagerGrpc.getCreateRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateRepositoryMethod = SecureSourceManagerGrpc.getCreateRepositoryMethod)
            == null) {
          SecureSourceManagerGrpc.getCreateRepositoryMethod =
              getCreateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateRepository"))
                      .build();
        }
      }
    }
    return getCreateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest,
          com.google.longrunning.Operation>
      getUpdateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRepository",
      requestType = com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest,
          com.google.longrunning.Operation>
      getUpdateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest,
            com.google.longrunning.Operation>
        getUpdateRepositoryMethod;
    if ((getUpdateRepositoryMethod = SecureSourceManagerGrpc.getUpdateRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdateRepositoryMethod = SecureSourceManagerGrpc.getUpdateRepositoryMethod)
            == null) {
          SecureSourceManagerGrpc.getUpdateRepositoryMethod =
              getUpdateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdateRepository"))
                      .build();
        }
      }
    }
    return getUpdateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRepository",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
            com.google.longrunning.Operation>
        getDeleteRepositoryMethod;
    if ((getDeleteRepositoryMethod = SecureSourceManagerGrpc.getDeleteRepositoryMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteRepositoryMethod = SecureSourceManagerGrpc.getDeleteRepositoryMethod)
            == null) {
          SecureSourceManagerGrpc.getDeleteRepositoryMethod =
              getDeleteRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteRepository"))
                      .build();
        }
      }
    }
    return getDeleteRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListHooksRequest,
          com.google.cloud.securesourcemanager.v1.ListHooksResponse>
      getListHooksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHooks",
      requestType = com.google.cloud.securesourcemanager.v1.ListHooksRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListHooksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListHooksRequest,
          com.google.cloud.securesourcemanager.v1.ListHooksResponse>
      getListHooksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListHooksRequest,
            com.google.cloud.securesourcemanager.v1.ListHooksResponse>
        getListHooksMethod;
    if ((getListHooksMethod = SecureSourceManagerGrpc.getListHooksMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListHooksMethod = SecureSourceManagerGrpc.getListHooksMethod) == null) {
          SecureSourceManagerGrpc.getListHooksMethod =
              getListHooksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListHooksRequest,
                          com.google.cloud.securesourcemanager.v1.ListHooksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHooks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListHooksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListHooksResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListHooks"))
                      .build();
        }
      }
    }
    return getListHooksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetHookRequest,
          com.google.cloud.securesourcemanager.v1.Hook>
      getGetHookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHook",
      requestType = com.google.cloud.securesourcemanager.v1.GetHookRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Hook.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetHookRequest,
          com.google.cloud.securesourcemanager.v1.Hook>
      getGetHookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetHookRequest,
            com.google.cloud.securesourcemanager.v1.Hook>
        getGetHookMethod;
    if ((getGetHookMethod = SecureSourceManagerGrpc.getGetHookMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetHookMethod = SecureSourceManagerGrpc.getGetHookMethod) == null) {
          SecureSourceManagerGrpc.getGetHookMethod =
              getGetHookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetHookRequest,
                          com.google.cloud.securesourcemanager.v1.Hook>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetHookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.Hook.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetHook"))
                      .build();
        }
      }
    }
    return getGetHookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateHookRequest,
          com.google.longrunning.Operation>
      getCreateHookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHook",
      requestType = com.google.cloud.securesourcemanager.v1.CreateHookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateHookRequest,
          com.google.longrunning.Operation>
      getCreateHookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateHookRequest,
            com.google.longrunning.Operation>
        getCreateHookMethod;
    if ((getCreateHookMethod = SecureSourceManagerGrpc.getCreateHookMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateHookMethod = SecureSourceManagerGrpc.getCreateHookMethod) == null) {
          SecureSourceManagerGrpc.getCreateHookMethod =
              getCreateHookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateHookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateHookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateHook"))
                      .build();
        }
      }
    }
    return getCreateHookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateHookRequest,
          com.google.longrunning.Operation>
      getUpdateHookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHook",
      requestType = com.google.cloud.securesourcemanager.v1.UpdateHookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateHookRequest,
          com.google.longrunning.Operation>
      getUpdateHookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdateHookRequest,
            com.google.longrunning.Operation>
        getUpdateHookMethod;
    if ((getUpdateHookMethod = SecureSourceManagerGrpc.getUpdateHookMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdateHookMethod = SecureSourceManagerGrpc.getUpdateHookMethod) == null) {
          SecureSourceManagerGrpc.getUpdateHookMethod =
              getUpdateHookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdateHookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdateHookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdateHook"))
                      .build();
        }
      }
    }
    return getUpdateHookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteHookRequest,
          com.google.longrunning.Operation>
      getDeleteHookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHook",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteHookRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteHookRequest,
          com.google.longrunning.Operation>
      getDeleteHookMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteHookRequest,
            com.google.longrunning.Operation>
        getDeleteHookMethod;
    if ((getDeleteHookMethod = SecureSourceManagerGrpc.getDeleteHookMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteHookMethod = SecureSourceManagerGrpc.getDeleteHookMethod) == null) {
          SecureSourceManagerGrpc.getDeleteHookMethod =
              getDeleteHookMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteHookRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHook"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteHookRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteHook"))
                      .build();
        }
      }
    }
    return getDeleteHookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicyRepo",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyRepoMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyRepoMethod;
    if ((getGetIamPolicyRepoMethod = SecureSourceManagerGrpc.getGetIamPolicyRepoMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetIamPolicyRepoMethod = SecureSourceManagerGrpc.getGetIamPolicyRepoMethod)
            == null) {
          SecureSourceManagerGrpc.getGetIamPolicyRepoMethod =
              getGetIamPolicyRepoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicyRepo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetIamPolicyRepo"))
                      .build();
        }
      }
    }
    return getGetIamPolicyRepoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicyRepo",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyRepoMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyRepoMethod;
    if ((getSetIamPolicyRepoMethod = SecureSourceManagerGrpc.getSetIamPolicyRepoMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getSetIamPolicyRepoMethod = SecureSourceManagerGrpc.getSetIamPolicyRepoMethod)
            == null) {
          SecureSourceManagerGrpc.getSetIamPolicyRepoMethod =
              getSetIamPolicyRepoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicyRepo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("SetIamPolicyRepo"))
                      .build();
        }
      }
    }
    return getSetIamPolicyRepoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsRepoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissionsRepo",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsRepoMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsRepoMethod;
    if ((getTestIamPermissionsRepoMethod = SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getTestIamPermissionsRepoMethod =
                SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod)
            == null) {
          SecureSourceManagerGrpc.getTestIamPermissionsRepoMethod =
              getTestIamPermissionsRepoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TestIamPermissionsRepo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("TestIamPermissionsRepo"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsRepoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest,
          com.google.longrunning.Operation>
      getCreateBranchRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBranchRule",
      requestType = com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest,
          com.google.longrunning.Operation>
      getCreateBranchRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest,
            com.google.longrunning.Operation>
        getCreateBranchRuleMethod;
    if ((getCreateBranchRuleMethod = SecureSourceManagerGrpc.getCreateBranchRuleMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateBranchRuleMethod = SecureSourceManagerGrpc.getCreateBranchRuleMethod)
            == null) {
          SecureSourceManagerGrpc.getCreateBranchRuleMethod =
              getCreateBranchRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBranchRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateBranchRule"))
                      .build();
        }
      }
    }
    return getCreateBranchRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest,
          com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
      getListBranchRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBranchRules",
      requestType = com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest,
          com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
      getListBranchRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest,
            com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
        getListBranchRulesMethod;
    if ((getListBranchRulesMethod = SecureSourceManagerGrpc.getListBranchRulesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListBranchRulesMethod = SecureSourceManagerGrpc.getListBranchRulesMethod) == null) {
          SecureSourceManagerGrpc.getListBranchRulesMethod =
              getListBranchRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest,
                          com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBranchRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListBranchRules"))
                      .build();
        }
      }
    }
    return getListBranchRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest,
          com.google.cloud.securesourcemanager.v1.BranchRule>
      getGetBranchRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBranchRule",
      requestType = com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.BranchRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest,
          com.google.cloud.securesourcemanager.v1.BranchRule>
      getGetBranchRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest,
            com.google.cloud.securesourcemanager.v1.BranchRule>
        getGetBranchRuleMethod;
    if ((getGetBranchRuleMethod = SecureSourceManagerGrpc.getGetBranchRuleMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetBranchRuleMethod = SecureSourceManagerGrpc.getGetBranchRuleMethod) == null) {
          SecureSourceManagerGrpc.getGetBranchRuleMethod =
              getGetBranchRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest,
                          com.google.cloud.securesourcemanager.v1.BranchRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBranchRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.BranchRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetBranchRule"))
                      .build();
        }
      }
    }
    return getGetBranchRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest,
          com.google.longrunning.Operation>
      getUpdateBranchRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBranchRule",
      requestType = com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest,
          com.google.longrunning.Operation>
      getUpdateBranchRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest,
            com.google.longrunning.Operation>
        getUpdateBranchRuleMethod;
    if ((getUpdateBranchRuleMethod = SecureSourceManagerGrpc.getUpdateBranchRuleMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdateBranchRuleMethod = SecureSourceManagerGrpc.getUpdateBranchRuleMethod)
            == null) {
          SecureSourceManagerGrpc.getUpdateBranchRuleMethod =
              getUpdateBranchRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBranchRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdateBranchRule"))
                      .build();
        }
      }
    }
    return getUpdateBranchRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest,
          com.google.longrunning.Operation>
      getDeleteBranchRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBranchRule",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest,
          com.google.longrunning.Operation>
      getDeleteBranchRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest,
            com.google.longrunning.Operation>
        getDeleteBranchRuleMethod;
    if ((getDeleteBranchRuleMethod = SecureSourceManagerGrpc.getDeleteBranchRuleMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteBranchRuleMethod = SecureSourceManagerGrpc.getDeleteBranchRuleMethod)
            == null) {
          SecureSourceManagerGrpc.getDeleteBranchRuleMethod =
              getDeleteBranchRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBranchRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteBranchRule"))
                      .build();
        }
      }
    }
    return getDeleteBranchRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest,
          com.google.longrunning.Operation>
      getCreatePullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest,
          com.google.longrunning.Operation>
      getCreatePullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest,
            com.google.longrunning.Operation>
        getCreatePullRequestMethod;
    if ((getCreatePullRequestMethod = SecureSourceManagerGrpc.getCreatePullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreatePullRequestMethod = SecureSourceManagerGrpc.getCreatePullRequestMethod)
            == null) {
          SecureSourceManagerGrpc.getCreatePullRequestMethod =
              getCreatePullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreatePullRequest"))
                      .build();
        }
      }
    }
    return getCreatePullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetPullRequestRequest,
          com.google.cloud.securesourcemanager.v1.PullRequest>
      getGetPullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.GetPullRequestRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.PullRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetPullRequestRequest,
          com.google.cloud.securesourcemanager.v1.PullRequest>
      getGetPullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetPullRequestRequest,
            com.google.cloud.securesourcemanager.v1.PullRequest>
        getGetPullRequestMethod;
    if ((getGetPullRequestMethod = SecureSourceManagerGrpc.getGetPullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetPullRequestMethod = SecureSourceManagerGrpc.getGetPullRequestMethod) == null) {
          SecureSourceManagerGrpc.getGetPullRequestMethod =
              getGetPullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetPullRequestRequest,
                          com.google.cloud.securesourcemanager.v1.PullRequest>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetPullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.PullRequest
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetPullRequest"))
                      .build();
        }
      }
    }
    return getGetPullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
      getListPullRequestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPullRequests",
      requestType = com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
      getListPullRequestsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest,
            com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
        getListPullRequestsMethod;
    if ((getListPullRequestsMethod = SecureSourceManagerGrpc.getListPullRequestsMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListPullRequestsMethod = SecureSourceManagerGrpc.getListPullRequestsMethod)
            == null) {
          SecureSourceManagerGrpc.getListPullRequestsMethod =
              getListPullRequestsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest,
                          com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPullRequests"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListPullRequests"))
                      .build();
        }
      }
    }
    return getListPullRequestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest,
          com.google.longrunning.Operation>
      getUpdatePullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest,
          com.google.longrunning.Operation>
      getUpdatePullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest,
            com.google.longrunning.Operation>
        getUpdatePullRequestMethod;
    if ((getUpdatePullRequestMethod = SecureSourceManagerGrpc.getUpdatePullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdatePullRequestMethod = SecureSourceManagerGrpc.getUpdatePullRequestMethod)
            == null) {
          SecureSourceManagerGrpc.getUpdatePullRequestMethod =
              getUpdatePullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdatePullRequest"))
                      .build();
        }
      }
    }
    return getUpdatePullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.MergePullRequestRequest,
          com.google.longrunning.Operation>
      getMergePullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MergePullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.MergePullRequestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.MergePullRequestRequest,
          com.google.longrunning.Operation>
      getMergePullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.MergePullRequestRequest,
            com.google.longrunning.Operation>
        getMergePullRequestMethod;
    if ((getMergePullRequestMethod = SecureSourceManagerGrpc.getMergePullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getMergePullRequestMethod = SecureSourceManagerGrpc.getMergePullRequestMethod)
            == null) {
          SecureSourceManagerGrpc.getMergePullRequestMethod =
              getMergePullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.MergePullRequestRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MergePullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.MergePullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("MergePullRequest"))
                      .build();
        }
      }
    }
    return getMergePullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest,
          com.google.longrunning.Operation>
      getOpenPullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenPullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest,
          com.google.longrunning.Operation>
      getOpenPullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest,
            com.google.longrunning.Operation>
        getOpenPullRequestMethod;
    if ((getOpenPullRequestMethod = SecureSourceManagerGrpc.getOpenPullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getOpenPullRequestMethod = SecureSourceManagerGrpc.getOpenPullRequestMethod) == null) {
          SecureSourceManagerGrpc.getOpenPullRequestMethod =
              getOpenPullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenPullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("OpenPullRequest"))
                      .build();
        }
      }
    }
    return getOpenPullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest,
          com.google.longrunning.Operation>
      getClosePullRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ClosePullRequest",
      requestType = com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest,
          com.google.longrunning.Operation>
      getClosePullRequestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest,
            com.google.longrunning.Operation>
        getClosePullRequestMethod;
    if ((getClosePullRequestMethod = SecureSourceManagerGrpc.getClosePullRequestMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getClosePullRequestMethod = SecureSourceManagerGrpc.getClosePullRequestMethod)
            == null) {
          SecureSourceManagerGrpc.getClosePullRequestMethod =
              getClosePullRequestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ClosePullRequest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ClosePullRequest"))
                      .build();
        }
      }
    }
    return getClosePullRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
      getListPullRequestFileDiffsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPullRequestFileDiffs",
      requestType = com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
      getListPullRequestFileDiffsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest,
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
        getListPullRequestFileDiffsMethod;
    if ((getListPullRequestFileDiffsMethod =
            SecureSourceManagerGrpc.getListPullRequestFileDiffsMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListPullRequestFileDiffsMethod =
                SecureSourceManagerGrpc.getListPullRequestFileDiffsMethod)
            == null) {
          SecureSourceManagerGrpc.getListPullRequestFileDiffsMethod =
              getListPullRequestFileDiffsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest,
                          com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPullRequestFileDiffs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .ListPullRequestFileDiffsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .ListPullRequestFileDiffsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "ListPullRequestFileDiffs"))
                      .build();
        }
      }
    }
    return getListPullRequestFileDiffsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.FetchTreeRequest,
          com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
      getFetchTreeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchTree",
      requestType = com.google.cloud.securesourcemanager.v1.FetchTreeRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.FetchTreeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.FetchTreeRequest,
          com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
      getFetchTreeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.FetchTreeRequest,
            com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
        getFetchTreeMethod;
    if ((getFetchTreeMethod = SecureSourceManagerGrpc.getFetchTreeMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getFetchTreeMethod = SecureSourceManagerGrpc.getFetchTreeMethod) == null) {
          SecureSourceManagerGrpc.getFetchTreeMethod =
              getFetchTreeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.FetchTreeRequest,
                          com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchTree"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.FetchTreeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.FetchTreeResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("FetchTree"))
                      .build();
        }
      }
    }
    return getFetchTreeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.FetchBlobRequest,
          com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
      getFetchBlobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchBlob",
      requestType = com.google.cloud.securesourcemanager.v1.FetchBlobRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.FetchBlobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.FetchBlobRequest,
          com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
      getFetchBlobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.FetchBlobRequest,
            com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
        getFetchBlobMethod;
    if ((getFetchBlobMethod = SecureSourceManagerGrpc.getFetchBlobMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getFetchBlobMethod = SecureSourceManagerGrpc.getFetchBlobMethod) == null) {
          SecureSourceManagerGrpc.getFetchBlobMethod =
              getFetchBlobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.FetchBlobRequest,
                          com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchBlob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.FetchBlobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.FetchBlobResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("FetchBlob"))
                      .build();
        }
      }
    }
    return getFetchBlobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateIssueRequest,
          com.google.longrunning.Operation>
      getCreateIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIssue",
      requestType = com.google.cloud.securesourcemanager.v1.CreateIssueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateIssueRequest,
          com.google.longrunning.Operation>
      getCreateIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateIssueRequest,
            com.google.longrunning.Operation>
        getCreateIssueMethod;
    if ((getCreateIssueMethod = SecureSourceManagerGrpc.getCreateIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateIssueMethod = SecureSourceManagerGrpc.getCreateIssueMethod) == null) {
          SecureSourceManagerGrpc.getCreateIssueMethod =
              getCreateIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateIssueRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateIssue"))
                      .build();
        }
      }
    }
    return getCreateIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetIssueRequest,
          com.google.cloud.securesourcemanager.v1.Issue>
      getGetIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIssue",
      requestType = com.google.cloud.securesourcemanager.v1.GetIssueRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.Issue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetIssueRequest,
          com.google.cloud.securesourcemanager.v1.Issue>
      getGetIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetIssueRequest,
            com.google.cloud.securesourcemanager.v1.Issue>
        getGetIssueMethod;
    if ((getGetIssueMethod = SecureSourceManagerGrpc.getGetIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetIssueMethod = SecureSourceManagerGrpc.getGetIssueMethod) == null) {
          SecureSourceManagerGrpc.getGetIssueMethod =
              getGetIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetIssueRequest,
                          com.google.cloud.securesourcemanager.v1.Issue>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.Issue.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetIssue"))
                      .build();
        }
      }
    }
    return getGetIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListIssuesRequest,
          com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
      getListIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIssues",
      requestType = com.google.cloud.securesourcemanager.v1.ListIssuesRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListIssuesRequest,
          com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
      getListIssuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListIssuesRequest,
            com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
        getListIssuesMethod;
    if ((getListIssuesMethod = SecureSourceManagerGrpc.getListIssuesMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListIssuesMethod = SecureSourceManagerGrpc.getListIssuesMethod) == null) {
          SecureSourceManagerGrpc.getListIssuesMethod =
              getListIssuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListIssuesRequest,
                          com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIssues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListIssuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListIssuesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListIssues"))
                      .build();
        }
      }
    }
    return getListIssuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateIssueRequest,
          com.google.longrunning.Operation>
      getUpdateIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIssue",
      requestType = com.google.cloud.securesourcemanager.v1.UpdateIssueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateIssueRequest,
          com.google.longrunning.Operation>
      getUpdateIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdateIssueRequest,
            com.google.longrunning.Operation>
        getUpdateIssueMethod;
    if ((getUpdateIssueMethod = SecureSourceManagerGrpc.getUpdateIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdateIssueMethod = SecureSourceManagerGrpc.getUpdateIssueMethod) == null) {
          SecureSourceManagerGrpc.getUpdateIssueMethod =
              getUpdateIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdateIssueRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdateIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdateIssue"))
                      .build();
        }
      }
    }
    return getUpdateIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteIssueRequest,
          com.google.longrunning.Operation>
      getDeleteIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIssue",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteIssueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteIssueRequest,
          com.google.longrunning.Operation>
      getDeleteIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteIssueRequest,
            com.google.longrunning.Operation>
        getDeleteIssueMethod;
    if ((getDeleteIssueMethod = SecureSourceManagerGrpc.getDeleteIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteIssueMethod = SecureSourceManagerGrpc.getDeleteIssueMethod) == null) {
          SecureSourceManagerGrpc.getDeleteIssueMethod =
              getDeleteIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteIssueRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteIssue"))
                      .build();
        }
      }
    }
    return getDeleteIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.OpenIssueRequest,
          com.google.longrunning.Operation>
      getOpenIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenIssue",
      requestType = com.google.cloud.securesourcemanager.v1.OpenIssueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.OpenIssueRequest,
          com.google.longrunning.Operation>
      getOpenIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.OpenIssueRequest,
            com.google.longrunning.Operation>
        getOpenIssueMethod;
    if ((getOpenIssueMethod = SecureSourceManagerGrpc.getOpenIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getOpenIssueMethod = SecureSourceManagerGrpc.getOpenIssueMethod) == null) {
          SecureSourceManagerGrpc.getOpenIssueMethod =
              getOpenIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.OpenIssueRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.OpenIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("OpenIssue"))
                      .build();
        }
      }
    }
    return getOpenIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CloseIssueRequest,
          com.google.longrunning.Operation>
      getCloseIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseIssue",
      requestType = com.google.cloud.securesourcemanager.v1.CloseIssueRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CloseIssueRequest,
          com.google.longrunning.Operation>
      getCloseIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CloseIssueRequest,
            com.google.longrunning.Operation>
        getCloseIssueMethod;
    if ((getCloseIssueMethod = SecureSourceManagerGrpc.getCloseIssueMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCloseIssueMethod = SecureSourceManagerGrpc.getCloseIssueMethod) == null) {
          SecureSourceManagerGrpc.getCloseIssueMethod =
              getCloseIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CloseIssueRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CloseIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CloseIssue"))
                      .build();
        }
      }
    }
    return getCloseIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest,
          com.google.cloud.securesourcemanager.v1.PullRequestComment>
      getGetPullRequestCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPullRequestComment",
      requestType = com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.PullRequestComment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest,
          com.google.cloud.securesourcemanager.v1.PullRequestComment>
      getGetPullRequestCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest,
            com.google.cloud.securesourcemanager.v1.PullRequestComment>
        getGetPullRequestCommentMethod;
    if ((getGetPullRequestCommentMethod = SecureSourceManagerGrpc.getGetPullRequestCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetPullRequestCommentMethod =
                SecureSourceManagerGrpc.getGetPullRequestCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getGetPullRequestCommentMethod =
              getGetPullRequestCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest,
                          com.google.cloud.securesourcemanager.v1.PullRequestComment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPullRequestComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.PullRequestComment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetPullRequestComment"))
                      .build();
        }
      }
    }
    return getGetPullRequestCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
      getListPullRequestCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPullRequestComments",
      requestType = com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest,
          com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
      getListPullRequestCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest,
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
        getListPullRequestCommentsMethod;
    if ((getListPullRequestCommentsMethod =
            SecureSourceManagerGrpc.getListPullRequestCommentsMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListPullRequestCommentsMethod =
                SecureSourceManagerGrpc.getListPullRequestCommentsMethod)
            == null) {
          SecureSourceManagerGrpc.getListPullRequestCommentsMethod =
              getListPullRequestCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest,
                          com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPullRequestComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .ListPullRequestCommentsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "ListPullRequestComments"))
                      .build();
        }
      }
    }
    return getListPullRequestCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getCreatePullRequestCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePullRequestComment",
      requestType = com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getCreatePullRequestCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest,
            com.google.longrunning.Operation>
        getCreatePullRequestCommentMethod;
    if ((getCreatePullRequestCommentMethod =
            SecureSourceManagerGrpc.getCreatePullRequestCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreatePullRequestCommentMethod =
                SecureSourceManagerGrpc.getCreatePullRequestCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getCreatePullRequestCommentMethod =
              getCreatePullRequestCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePullRequestComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .CreatePullRequestCommentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "CreatePullRequestComment"))
                      .build();
        }
      }
    }
    return getCreatePullRequestCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getUpdatePullRequestCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePullRequestComment",
      requestType = com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getUpdatePullRequestCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest,
            com.google.longrunning.Operation>
        getUpdatePullRequestCommentMethod;
    if ((getUpdatePullRequestCommentMethod =
            SecureSourceManagerGrpc.getUpdatePullRequestCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdatePullRequestCommentMethod =
                SecureSourceManagerGrpc.getUpdatePullRequestCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getUpdatePullRequestCommentMethod =
              getUpdatePullRequestCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePullRequestComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .UpdatePullRequestCommentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "UpdatePullRequestComment"))
                      .build();
        }
      }
    }
    return getUpdatePullRequestCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getDeletePullRequestCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePullRequestComment",
      requestType = com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest,
          com.google.longrunning.Operation>
      getDeletePullRequestCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest,
            com.google.longrunning.Operation>
        getDeletePullRequestCommentMethod;
    if ((getDeletePullRequestCommentMethod =
            SecureSourceManagerGrpc.getDeletePullRequestCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeletePullRequestCommentMethod =
                SecureSourceManagerGrpc.getDeletePullRequestCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getDeletePullRequestCommentMethod =
              getDeletePullRequestCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePullRequestComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .DeletePullRequestCommentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "DeletePullRequestComment"))
                      .build();
        }
      }
    }
    return getDeletePullRequestCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getBatchCreatePullRequestCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchCreatePullRequestComments",
      requestType =
          com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getBatchCreatePullRequestCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest,
            com.google.longrunning.Operation>
        getBatchCreatePullRequestCommentsMethod;
    if ((getBatchCreatePullRequestCommentsMethod =
            SecureSourceManagerGrpc.getBatchCreatePullRequestCommentsMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getBatchCreatePullRequestCommentsMethod =
                SecureSourceManagerGrpc.getBatchCreatePullRequestCommentsMethod)
            == null) {
          SecureSourceManagerGrpc.getBatchCreatePullRequestCommentsMethod =
              getBatchCreatePullRequestCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1
                              .BatchCreatePullRequestCommentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchCreatePullRequestComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .BatchCreatePullRequestCommentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "BatchCreatePullRequestComments"))
                      .build();
        }
      }
    }
    return getBatchCreatePullRequestCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getResolvePullRequestCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResolvePullRequestComments",
      requestType = com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getResolvePullRequestCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest,
            com.google.longrunning.Operation>
        getResolvePullRequestCommentsMethod;
    if ((getResolvePullRequestCommentsMethod =
            SecureSourceManagerGrpc.getResolvePullRequestCommentsMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getResolvePullRequestCommentsMethod =
                SecureSourceManagerGrpc.getResolvePullRequestCommentsMethod)
            == null) {
          SecureSourceManagerGrpc.getResolvePullRequestCommentsMethod =
              getResolvePullRequestCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ResolvePullRequestComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .ResolvePullRequestCommentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "ResolvePullRequestComments"))
                      .build();
        }
      }
    }
    return getResolvePullRequestCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getUnresolvePullRequestCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnresolvePullRequestComments",
      requestType =
          com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest,
          com.google.longrunning.Operation>
      getUnresolvePullRequestCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest,
            com.google.longrunning.Operation>
        getUnresolvePullRequestCommentsMethod;
    if ((getUnresolvePullRequestCommentsMethod =
            SecureSourceManagerGrpc.getUnresolvePullRequestCommentsMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUnresolvePullRequestCommentsMethod =
                SecureSourceManagerGrpc.getUnresolvePullRequestCommentsMethod)
            == null) {
          SecureSourceManagerGrpc.getUnresolvePullRequestCommentsMethod =
              getUnresolvePullRequestCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UnresolvePullRequestComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1
                                  .UnresolvePullRequestCommentsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier(
                              "UnresolvePullRequestComments"))
                      .build();
        }
      }
    }
    return getUnresolvePullRequestCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest,
          com.google.longrunning.Operation>
      getCreateIssueCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIssueComment",
      requestType = com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest,
          com.google.longrunning.Operation>
      getCreateIssueCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest,
            com.google.longrunning.Operation>
        getCreateIssueCommentMethod;
    if ((getCreateIssueCommentMethod = SecureSourceManagerGrpc.getCreateIssueCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getCreateIssueCommentMethod = SecureSourceManagerGrpc.getCreateIssueCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getCreateIssueCommentMethod =
              getCreateIssueCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIssueComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("CreateIssueComment"))
                      .build();
        }
      }
    }
    return getCreateIssueCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest,
          com.google.cloud.securesourcemanager.v1.IssueComment>
      getGetIssueCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIssueComment",
      requestType = com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.IssueComment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest,
          com.google.cloud.securesourcemanager.v1.IssueComment>
      getGetIssueCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest,
            com.google.cloud.securesourcemanager.v1.IssueComment>
        getGetIssueCommentMethod;
    if ((getGetIssueCommentMethod = SecureSourceManagerGrpc.getGetIssueCommentMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getGetIssueCommentMethod = SecureSourceManagerGrpc.getGetIssueCommentMethod) == null) {
          SecureSourceManagerGrpc.getGetIssueCommentMethod =
              getGetIssueCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest,
                          com.google.cloud.securesourcemanager.v1.IssueComment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIssueComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.IssueComment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("GetIssueComment"))
                      .build();
        }
      }
    }
    return getGetIssueCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest,
          com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
      getListIssueCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIssueComments",
      requestType = com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest.class,
      responseType = com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest,
          com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
      getListIssueCommentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest,
            com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
        getListIssueCommentsMethod;
    if ((getListIssueCommentsMethod = SecureSourceManagerGrpc.getListIssueCommentsMethod) == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getListIssueCommentsMethod = SecureSourceManagerGrpc.getListIssueCommentsMethod)
            == null) {
          SecureSourceManagerGrpc.getListIssueCommentsMethod =
              getListIssueCommentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest,
                          com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIssueComments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("ListIssueComments"))
                      .build();
        }
      }
    }
    return getListIssueCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest,
          com.google.longrunning.Operation>
      getUpdateIssueCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIssueComment",
      requestType = com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest,
          com.google.longrunning.Operation>
      getUpdateIssueCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest,
            com.google.longrunning.Operation>
        getUpdateIssueCommentMethod;
    if ((getUpdateIssueCommentMethod = SecureSourceManagerGrpc.getUpdateIssueCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getUpdateIssueCommentMethod = SecureSourceManagerGrpc.getUpdateIssueCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getUpdateIssueCommentMethod =
              getUpdateIssueCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIssueComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("UpdateIssueComment"))
                      .build();
        }
      }
    }
    return getUpdateIssueCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest,
          com.google.longrunning.Operation>
      getDeleteIssueCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIssueComment",
      requestType = com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest,
          com.google.longrunning.Operation>
      getDeleteIssueCommentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest,
            com.google.longrunning.Operation>
        getDeleteIssueCommentMethod;
    if ((getDeleteIssueCommentMethod = SecureSourceManagerGrpc.getDeleteIssueCommentMethod)
        == null) {
      synchronized (SecureSourceManagerGrpc.class) {
        if ((getDeleteIssueCommentMethod = SecureSourceManagerGrpc.getDeleteIssueCommentMethod)
            == null) {
          SecureSourceManagerGrpc.getDeleteIssueCommentMethod =
              getDeleteIssueCommentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIssueComment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecureSourceManagerMethodDescriptorSupplier("DeleteIssueComment"))
                      .build();
        }
      }
    }
    return getDeleteIssueCommentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecureSourceManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerStub>() {
          @java.lang.Override
          public SecureSourceManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecureSourceManagerStub(channel, callOptions);
          }
        };
    return SecureSourceManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SecureSourceManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingV2Stub>() {
          @java.lang.Override
          public SecureSourceManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecureSourceManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return SecureSourceManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecureSourceManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerBlockingStub>() {
          @java.lang.Override
          public SecureSourceManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecureSourceManagerBlockingStub(channel, callOptions);
          }
        };
    return SecureSourceManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecureSourceManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SecureSourceManagerFutureStub>() {
          @java.lang.Override
          public SecureSourceManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SecureSourceManagerFutureStub(channel, callOptions);
          }
        };
    return SecureSourceManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
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
        com.google.cloud.securesourcemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.securesourcemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Repositories in a given project and location.
     * The instance field is required in the query parameter for requests using
     * the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    default void listRepositories(
        com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRepositoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a repository.
     * </pre>
     */
    default void getRepository(
        com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new repository in a given project and location.
     * The Repository.Instance field is required in the request body for requests
     * using the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    default void createRepository(
        com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a repository.
     * </pre>
     */
    default void updateRepository(
        com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Repository.
     * </pre>
     */
    default void deleteRepository(
        com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hooks in a given repository.
     * </pre>
     */
    default void listHooks(
        com.google.cloud.securesourcemanager.v1.ListHooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListHooksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListHooksMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a hook.
     * </pre>
     */
    default void getHook(
        com.google.cloud.securesourcemanager.v1.GetHookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Hook>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hook in a given repository.
     * </pre>
     */
    default void createHook(
        com.google.cloud.securesourcemanager.v1.CreateHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a hook.
     * </pre>
     */
    default void updateHook(
        com.google.cloud.securesourcemanager.v1.UpdateHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Hook.
     * </pre>
     */
    default void deleteHook(
        com.google.cloud.securesourcemanager.v1.DeleteHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHookMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    default void getIamPolicyRepo(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyRepoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    default void setIamPolicyRepo(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyRepoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    default void testIamPermissionsRepo(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsRepoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateBranchRule creates a branch rule in a given repository.
     * </pre>
     */
    default void createBranchRule(
        com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateBranchRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListBranchRules lists branch rules in a given repository.
     * </pre>
     */
    default void listBranchRules(
        com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListBranchRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetBranchRule gets a branch rule.
     * </pre>
     */
    default void getBranchRule(
        com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.BranchRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetBranchRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpdateBranchRule updates a branch rule.
     * </pre>
     */
    default void updateBranchRule(
        com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateBranchRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteBranchRule deletes a branch rule.
     * </pre>
     */
    default void deleteBranchRule(
        com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteBranchRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request.
     * </pre>
     */
    default void createPullRequest(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request.
     * </pre>
     */
    default void getPullRequest(
        com.google.cloud.securesourcemanager.v1.GetPullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.PullRequest>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists pull requests in a repository.
     * </pre>
     */
    default void listPullRequests(
        com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPullRequestsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request.
     * </pre>
     */
    default void updatePullRequest(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges a pull request.
     * </pre>
     */
    default void mergePullRequest(
        com.google.cloud.securesourcemanager.v1.MergePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMergePullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Opens a pull request.
     * </pre>
     */
    default void openPullRequest(
        com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getOpenPullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Closes a pull request without merging.
     * </pre>
     */
    default void closePullRequest(
        com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getClosePullRequestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a pull request's file diffs.
     * </pre>
     */
    default void listPullRequestFileDiffs(
        com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPullRequestFileDiffsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a tree from a repository.
     * </pre>
     */
    default void fetchTree(
        com.google.cloud.securesourcemanager.v1.FetchTreeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchTreeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a blob from a repository.
     * </pre>
     */
    default void fetchBlob(
        com.google.cloud.securesourcemanager.v1.FetchBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchBlobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue.
     * </pre>
     */
    default void createIssue(
        com.google.cloud.securesourcemanager.v1.CreateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    default void getIssue(
        com.google.cloud.securesourcemanager.v1.GetIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Issue>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issues in a repository.
     * </pre>
     */
    default void listIssues(
        com.google.cloud.securesourcemanager.v1.ListIssuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListIssuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a issue.
     * </pre>
     */
    default void updateIssue(
        com.google.cloud.securesourcemanager.v1.UpdateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    default void deleteIssue(
        com.google.cloud.securesourcemanager.v1.DeleteIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Opens an issue.
     * </pre>
     */
    default void openIssue(
        com.google.cloud.securesourcemanager.v1.OpenIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Closes an issue.
     * </pre>
     */
    default void closeIssue(
        com.google.cloud.securesourcemanager.v1.CloseIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request comment.
     * </pre>
     */
    default void getPullRequestComment(
        com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.PullRequestComment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPullRequestCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists pull request comments.
     * </pre>
     */
    default void listPullRequestComments(
        com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPullRequestCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request comment.
     * </pre>
     */
    default void createPullRequestComment(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePullRequestCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request comment.
     * </pre>
     */
    default void updatePullRequestComment(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePullRequestCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pull request comment.
     * </pre>
     */
    default void deletePullRequestComment(
        com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePullRequestCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch creates pull request comments.
     * </pre>
     */
    default void batchCreatePullRequestComments(
        com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchCreatePullRequestCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resolves pull request comments.
     * </pre>
     */
    default void resolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResolvePullRequestCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unresolves pull request comment.
     * </pre>
     */
    default void unresolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnresolvePullRequestCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue comment.
     * </pre>
     */
    default void createIssueComment(
        com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIssueCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue comment.
     * </pre>
     */
    default void getIssueComment(
        com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.IssueComment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIssueCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists comments in an issue.
     * </pre>
     */
    default void listIssueComments(
        com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIssueCommentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue comment.
     * </pre>
     */
    default void updateIssueComment(
        com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIssueCommentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue comment.
     * </pre>
     */
    default void deleteIssueComment(
        com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIssueCommentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecureSourceManager.
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * </pre>
   */
  public abstract static class SecureSourceManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SecureSourceManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecureSourceManager.
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * </pre>
   */
  public static final class SecureSourceManagerStub
      extends io.grpc.stub.AbstractAsyncStub<SecureSourceManagerStub> {
    private SecureSourceManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.securesourcemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
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
     * Gets details of a single instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.securesourcemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance>
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
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request,
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
     * Deletes a single instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request,
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
     * Lists Repositories in a given project and location.
     * The instance field is required in the query parameter for requests using
     * the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public void listRepositories(
        com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a repository.
     * </pre>
     */
    public void getRepository(
        com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new repository in a given project and location.
     * The Repository.Instance field is required in the request body for requests
     * using the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public void createRepository(
        com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a repository.
     * </pre>
     */
    public void updateRepository(
        com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Repository.
     * </pre>
     */
    public void deleteRepository(
        com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists hooks in a given repository.
     * </pre>
     */
    public void listHooks(
        com.google.cloud.securesourcemanager.v1.ListHooksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListHooksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHooksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a hook.
     * </pre>
     */
    public void getHook(
        com.google.cloud.securesourcemanager.v1.GetHookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Hook>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hook in a given repository.
     * </pre>
     */
    public void createHook(
        com.google.cloud.securesourcemanager.v1.CreateHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a hook.
     * </pre>
     */
    public void updateHook(
        com.google.cloud.securesourcemanager.v1.UpdateHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Hook.
     * </pre>
     */
    public void deleteHook(
        com.google.cloud.securesourcemanager.v1.DeleteHookRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public void getIamPolicyRepo(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyRepoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public void setIamPolicyRepo(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyRepoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public void testIamPermissionsRepo(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsRepoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateBranchRule creates a branch rule in a given repository.
     * </pre>
     */
    public void createBranchRule(
        com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBranchRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListBranchRules lists branch rules in a given repository.
     * </pre>
     */
    public void listBranchRules(
        com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBranchRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetBranchRule gets a branch rule.
     * </pre>
     */
    public void getBranchRule(
        com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.BranchRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBranchRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * UpdateBranchRule updates a branch rule.
     * </pre>
     */
    public void updateBranchRule(
        com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBranchRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * DeleteBranchRule deletes a branch rule.
     * </pre>
     */
    public void deleteBranchRule(
        com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBranchRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request.
     * </pre>
     */
    public void createPullRequest(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request.
     * </pre>
     */
    public void getPullRequest(
        com.google.cloud.securesourcemanager.v1.GetPullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.PullRequest>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists pull requests in a repository.
     * </pre>
     */
    public void listPullRequests(
        com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPullRequestsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request.
     * </pre>
     */
    public void updatePullRequest(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Merges a pull request.
     * </pre>
     */
    public void mergePullRequest(
        com.google.cloud.securesourcemanager.v1.MergePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergePullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Opens a pull request.
     * </pre>
     */
    public void openPullRequest(
        com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenPullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Closes a pull request without merging.
     * </pre>
     */
    public void closePullRequest(
        com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClosePullRequestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a pull request's file diffs.
     * </pre>
     */
    public void listPullRequestFileDiffs(
        com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPullRequestFileDiffsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a tree from a repository.
     * </pre>
     */
    public void fetchTree(
        com.google.cloud.securesourcemanager.v1.FetchTreeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchTreeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a blob from a repository.
     * </pre>
     */
    public void fetchBlob(
        com.google.cloud.securesourcemanager.v1.FetchBlobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchBlobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue.
     * </pre>
     */
    public void createIssue(
        com.google.cloud.securesourcemanager.v1.CreateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIssueMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public void getIssue(
        com.google.cloud.securesourcemanager.v1.GetIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Issue>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIssueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issues in a repository.
     * </pre>
     */
    public void listIssues(
        com.google.cloud.securesourcemanager.v1.ListIssuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIssuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a issue.
     * </pre>
     */
    public void updateIssue(
        com.google.cloud.securesourcemanager.v1.UpdateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIssueMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public void deleteIssue(
        com.google.cloud.securesourcemanager.v1.DeleteIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIssueMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Opens an issue.
     * </pre>
     */
    public void openIssue(
        com.google.cloud.securesourcemanager.v1.OpenIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOpenIssueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Closes an issue.
     * </pre>
     */
    public void closeIssue(
        com.google.cloud.securesourcemanager.v1.CloseIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseIssueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request comment.
     * </pre>
     */
    public void getPullRequestComment(
        com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.PullRequestComment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPullRequestCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists pull request comments.
     * </pre>
     */
    public void listPullRequestComments(
        com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPullRequestCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request comment.
     * </pre>
     */
    public void createPullRequestComment(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePullRequestCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request comment.
     * </pre>
     */
    public void updatePullRequestComment(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePullRequestCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pull request comment.
     * </pre>
     */
    public void deletePullRequestComment(
        com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePullRequestCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch creates pull request comments.
     * </pre>
     */
    public void batchCreatePullRequestComments(
        com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchCreatePullRequestCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resolves pull request comments.
     * </pre>
     */
    public void resolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResolvePullRequestCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unresolves pull request comment.
     * </pre>
     */
    public void unresolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnresolvePullRequestCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue comment.
     * </pre>
     */
    public void createIssueComment(
        com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIssueCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue comment.
     * </pre>
     */
    public void getIssueComment(
        com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.IssueComment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIssueCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists comments in an issue.
     * </pre>
     */
    public void listIssueComments(
        com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIssueCommentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue comment.
     * </pre>
     */
    public void updateIssueComment(
        com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIssueCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue comment.
     * </pre>
     */
    public void deleteIssueComment(
        com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIssueCommentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecureSourceManager.
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * </pre>
   */
  public static final class SecureSourceManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SecureSourceManagerBlockingV2Stub> {
    private SecureSourceManagerBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListInstancesResponse listInstances(
        com.google.cloud.securesourcemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Instance getInstance(
        com.google.cloud.securesourcemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Repositories in a given project and location.
     * The instance field is required in the query parameter for requests using
     * the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse listRepositories(
        com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Repository getRepository(
        com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new repository in a given project and location.
     * The Repository.Instance field is required in the request body for requests
     * using the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation createRepository(
        com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a repository.
     * </pre>
     */
    public com.google.longrunning.Operation updateRepository(
        com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Repository.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRepository(
        com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hooks in a given repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListHooksResponse listHooks(
        com.google.cloud.securesourcemanager.v1.ListHooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a hook.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Hook getHook(
        com.google.cloud.securesourcemanager.v1.GetHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hook in a given repository.
     * </pre>
     */
    public com.google.longrunning.Operation createHook(
        com.google.cloud.securesourcemanager.v1.CreateHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a hook.
     * </pre>
     */
    public com.google.longrunning.Operation updateHook(
        com.google.cloud.securesourcemanager.v1.UpdateHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Hook.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHook(
        com.google.cloud.securesourcemanager.v1.DeleteHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicyRepo(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicyRepo(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissionsRepo(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateBranchRule creates a branch rule in a given repository.
     * </pre>
     */
    public com.google.longrunning.Operation createBranchRule(
        com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ListBranchRules lists branch rules in a given repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse listBranchRules(
        com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBranchRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetBranchRule gets a branch rule.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.BranchRule getBranchRule(
        com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * UpdateBranchRule updates a branch rule.
     * </pre>
     */
    public com.google.longrunning.Operation updateBranchRule(
        com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteBranchRule deletes a branch rule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBranchRule(
        com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation createPullRequest(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.PullRequest getPullRequest(
        com.google.cloud.securesourcemanager.v1.GetPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull requests in a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse listPullRequests(
        com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation updatePullRequest(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Merges a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation mergePullRequest(
        com.google.cloud.securesourcemanager.v1.MergePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Opens a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation openPullRequest(
        com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenPullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Closes a pull request without merging.
     * </pre>
     */
    public com.google.longrunning.Operation closePullRequest(
        com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClosePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a pull request's file diffs.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse
        listPullRequestFileDiffs(
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestFileDiffsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a tree from a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.FetchTreeResponse fetchTree(
        com.google.cloud.securesourcemanager.v1.FetchTreeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchTreeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a blob from a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.FetchBlobResponse fetchBlob(
        com.google.cloud.securesourcemanager.v1.FetchBlobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchBlobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue.
     * </pre>
     */
    public com.google.longrunning.Operation createIssue(
        com.google.cloud.securesourcemanager.v1.CreateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Issue getIssue(
        com.google.cloud.securesourcemanager.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues in a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListIssuesResponse listIssues(
        com.google.cloud.securesourcemanager.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a issue.
     * </pre>
     */
    public com.google.longrunning.Operation updateIssue(
        com.google.cloud.securesourcemanager.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssue(
        com.google.cloud.securesourcemanager.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Opens an issue.
     * </pre>
     */
    public com.google.longrunning.Operation openIssue(
        com.google.cloud.securesourcemanager.v1.OpenIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Closes an issue.
     * </pre>
     */
    public com.google.longrunning.Operation closeIssue(
        com.google.cloud.securesourcemanager.v1.CloseIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request comment.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.PullRequestComment getPullRequestComment(
        com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull request comments.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse
        listPullRequestComments(
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation createPullRequestComment(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation updatePullRequestComment(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation deletePullRequestComment(
        com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch creates pull request comments.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreatePullRequestComments(
        com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreatePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resolves pull request comments.
     * </pre>
     */
    public com.google.longrunning.Operation resolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolvePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unresolves pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation unresolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnresolvePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation createIssueComment(
        com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue comment.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.IssueComment getIssueComment(
        com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists comments in an issue.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse listIssueComments(
        com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssueCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation updateIssueComment(
        com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssueComment(
        com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueCommentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SecureSourceManager.
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * </pre>
   */
  public static final class SecureSourceManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecureSourceManagerBlockingStub> {
    private SecureSourceManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListInstancesResponse listInstances(
        com.google.cloud.securesourcemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Instance getInstance(
        com.google.cloud.securesourcemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Repositories in a given project and location.
     * The instance field is required in the query parameter for requests using
     * the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse listRepositories(
        com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Repository getRepository(
        com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new repository in a given project and location.
     * The Repository.Instance field is required in the request body for requests
     * using the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.longrunning.Operation createRepository(
        com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a repository.
     * </pre>
     */
    public com.google.longrunning.Operation updateRepository(
        com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Repository.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRepository(
        com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hooks in a given repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListHooksResponse listHooks(
        com.google.cloud.securesourcemanager.v1.ListHooksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHooksMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a hook.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Hook getHook(
        com.google.cloud.securesourcemanager.v1.GetHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hook in a given repository.
     * </pre>
     */
    public com.google.longrunning.Operation createHook(
        com.google.cloud.securesourcemanager.v1.CreateHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a hook.
     * </pre>
     */
    public com.google.longrunning.Operation updateHook(
        com.google.cloud.securesourcemanager.v1.UpdateHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Hook.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHook(
        com.google.cloud.securesourcemanager.v1.DeleteHookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHookMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicyRepo(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicyRepo(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissionsRepo(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsRepoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateBranchRule creates a branch rule in a given repository.
     * </pre>
     */
    public com.google.longrunning.Operation createBranchRule(
        com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ListBranchRules lists branch rules in a given repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse listBranchRules(
        com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBranchRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetBranchRule gets a branch rule.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.BranchRule getBranchRule(
        com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * UpdateBranchRule updates a branch rule.
     * </pre>
     */
    public com.google.longrunning.Operation updateBranchRule(
        com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteBranchRule deletes a branch rule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteBranchRule(
        com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBranchRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation createPullRequest(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.PullRequest getPullRequest(
        com.google.cloud.securesourcemanager.v1.GetPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull requests in a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse listPullRequests(
        com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation updatePullRequest(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Merges a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation mergePullRequest(
        com.google.cloud.securesourcemanager.v1.MergePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Opens a pull request.
     * </pre>
     */
    public com.google.longrunning.Operation openPullRequest(
        com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenPullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Closes a pull request without merging.
     * </pre>
     */
    public com.google.longrunning.Operation closePullRequest(
        com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClosePullRequestMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a pull request's file diffs.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse
        listPullRequestFileDiffs(
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestFileDiffsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a tree from a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.FetchTreeResponse fetchTree(
        com.google.cloud.securesourcemanager.v1.FetchTreeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchTreeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a blob from a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.FetchBlobResponse fetchBlob(
        com.google.cloud.securesourcemanager.v1.FetchBlobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchBlobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue.
     * </pre>
     */
    public com.google.longrunning.Operation createIssue(
        com.google.cloud.securesourcemanager.v1.CreateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.Issue getIssue(
        com.google.cloud.securesourcemanager.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues in a repository.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListIssuesResponse listIssues(
        com.google.cloud.securesourcemanager.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a issue.
     * </pre>
     */
    public com.google.longrunning.Operation updateIssue(
        com.google.cloud.securesourcemanager.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssue(
        com.google.cloud.securesourcemanager.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Opens an issue.
     * </pre>
     */
    public com.google.longrunning.Operation openIssue(
        com.google.cloud.securesourcemanager.v1.OpenIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOpenIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Closes an issue.
     * </pre>
     */
    public com.google.longrunning.Operation closeIssue(
        com.google.cloud.securesourcemanager.v1.CloseIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request comment.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.PullRequestComment getPullRequestComment(
        com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull request comments.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse
        listPullRequestComments(
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation createPullRequestComment(
        com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation updatePullRequestComment(
        com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation deletePullRequestComment(
        com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePullRequestCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch creates pull request comments.
     * </pre>
     */
    public com.google.longrunning.Operation batchCreatePullRequestComments(
        com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchCreatePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resolves pull request comments.
     * </pre>
     */
    public com.google.longrunning.Operation resolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResolvePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unresolves pull request comment.
     * </pre>
     */
    public com.google.longrunning.Operation unresolvePullRequestComments(
        com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnresolvePullRequestCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation createIssueComment(
        com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue comment.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.IssueComment getIssueComment(
        com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists comments in an issue.
     * </pre>
     */
    public com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse listIssueComments(
        com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssueCommentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation updateIssueComment(
        com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueCommentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue comment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssueComment(
        com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueCommentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SecureSourceManager.
   *
   * <pre>
   * Secure Source Manager API
   * Access Secure Source Manager instances, resources, and repositories.
   * </pre>
   */
  public static final class SecureSourceManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecureSourceManagerFutureStub> {
    private SecureSourceManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecureSourceManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecureSourceManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListInstancesResponse>
        listInstances(com.google.cloud.securesourcemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.Instance>
        getInstance(com.google.cloud.securesourcemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.securesourcemanager.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Repositories in a given project and location.
     * The instance field is required in the query parameter for requests using
     * the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>
        listRepositories(com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.Repository>
        getRepository(com.google.cloud.securesourcemanager.v1.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new repository in a given project and location.
     * The Repository.Instance field is required in the request body for requests
     * using the securesourcemanager.googleapis.com endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRepository(com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRepository(com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRepository(com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists hooks in a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListHooksResponse>
        listHooks(com.google.cloud.securesourcemanager.v1.ListHooksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHooksMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets metadata of a hook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.Hook>
        getHook(com.google.cloud.securesourcemanager.v1.GetHookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new hook in a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHook(com.google.cloud.securesourcemanager.v1.CreateHookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata of a hook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHook(com.google.cloud.securesourcemanager.v1.UpdateHookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Hook.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHook(com.google.cloud.securesourcemanager.v1.DeleteHookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHookMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get IAM policy for a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicyRepo(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyRepoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Set IAM policy on a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicyRepo(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyRepoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Test IAM permissions on a repository.
     * IAM permission checks are not required on this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissionsRepo(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsRepoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * CreateBranchRule creates a branch rule in a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBranchRule(com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBranchRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * ListBranchRules lists branch rules in a given repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>
        listBranchRules(com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBranchRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * GetBranchRule gets a branch rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.BranchRule>
        getBranchRule(com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBranchRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * UpdateBranchRule updates a branch rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateBranchRule(com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBranchRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * DeleteBranchRule deletes a branch rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteBranchRule(com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBranchRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPullRequest(
            com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.PullRequest>
        getPullRequest(com.google.cloud.securesourcemanager.v1.GetPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull requests in a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>
        listPullRequests(com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPullRequestsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePullRequest(
            com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Merges a pull request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        mergePullRequest(com.google.cloud.securesourcemanager.v1.MergePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergePullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Opens a pull request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        openPullRequest(com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenPullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Closes a pull request without merging.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        closePullRequest(com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClosePullRequestMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a pull request's file diffs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>
        listPullRequestFileDiffs(
            com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPullRequestFileDiffsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a tree from a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.FetchTreeResponse>
        fetchTree(com.google.cloud.securesourcemanager.v1.FetchTreeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchTreeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a blob from a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.FetchBlobResponse>
        fetchBlob(com.google.cloud.securesourcemanager.v1.FetchBlobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchBlobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIssue(com.google.cloud.securesourcemanager.v1.CreateIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.Issue>
        getIssue(com.google.cloud.securesourcemanager.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues in a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListIssuesResponse>
        listIssues(com.google.cloud.securesourcemanager.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIssuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateIssue(com.google.cloud.securesourcemanager.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIssue(com.google.cloud.securesourcemanager.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Opens an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        openIssue(com.google.cloud.securesourcemanager.v1.OpenIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOpenIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Closes an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        closeIssue(com.google.cloud.securesourcemanager.v1.CloseIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a pull request comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.PullRequestComment>
        getPullRequestComment(
            com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPullRequestCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists pull request comments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>
        listPullRequestComments(
            com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPullRequestCommentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a pull request comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPullRequestComment(
            com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePullRequestCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a pull request comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePullRequestComment(
            com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePullRequestCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a pull request comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePullRequestComment(
            com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePullRequestCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch creates pull request comments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchCreatePullRequestComments(
            com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchCreatePullRequestCommentsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Resolves pull request comments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resolvePullRequestComments(
            com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResolvePullRequestCommentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Unresolves pull request comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        unresolvePullRequestComments(
            com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnresolvePullRequestCommentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIssueComment(
            com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIssueCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.IssueComment>
        getIssueComment(com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIssueCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists comments in an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>
        listIssueComments(
            com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIssueCommentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateIssueComment(
            com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIssueCommentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue comment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIssueComment(
            com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIssueCommentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_DELETE_INSTANCE = 3;
  private static final int METHODID_LIST_REPOSITORIES = 4;
  private static final int METHODID_GET_REPOSITORY = 5;
  private static final int METHODID_CREATE_REPOSITORY = 6;
  private static final int METHODID_UPDATE_REPOSITORY = 7;
  private static final int METHODID_DELETE_REPOSITORY = 8;
  private static final int METHODID_LIST_HOOKS = 9;
  private static final int METHODID_GET_HOOK = 10;
  private static final int METHODID_CREATE_HOOK = 11;
  private static final int METHODID_UPDATE_HOOK = 12;
  private static final int METHODID_DELETE_HOOK = 13;
  private static final int METHODID_GET_IAM_POLICY_REPO = 14;
  private static final int METHODID_SET_IAM_POLICY_REPO = 15;
  private static final int METHODID_TEST_IAM_PERMISSIONS_REPO = 16;
  private static final int METHODID_CREATE_BRANCH_RULE = 17;
  private static final int METHODID_LIST_BRANCH_RULES = 18;
  private static final int METHODID_GET_BRANCH_RULE = 19;
  private static final int METHODID_UPDATE_BRANCH_RULE = 20;
  private static final int METHODID_DELETE_BRANCH_RULE = 21;
  private static final int METHODID_CREATE_PULL_REQUEST = 22;
  private static final int METHODID_GET_PULL_REQUEST = 23;
  private static final int METHODID_LIST_PULL_REQUESTS = 24;
  private static final int METHODID_UPDATE_PULL_REQUEST = 25;
  private static final int METHODID_MERGE_PULL_REQUEST = 26;
  private static final int METHODID_OPEN_PULL_REQUEST = 27;
  private static final int METHODID_CLOSE_PULL_REQUEST = 28;
  private static final int METHODID_LIST_PULL_REQUEST_FILE_DIFFS = 29;
  private static final int METHODID_FETCH_TREE = 30;
  private static final int METHODID_FETCH_BLOB = 31;
  private static final int METHODID_CREATE_ISSUE = 32;
  private static final int METHODID_GET_ISSUE = 33;
  private static final int METHODID_LIST_ISSUES = 34;
  private static final int METHODID_UPDATE_ISSUE = 35;
  private static final int METHODID_DELETE_ISSUE = 36;
  private static final int METHODID_OPEN_ISSUE = 37;
  private static final int METHODID_CLOSE_ISSUE = 38;
  private static final int METHODID_GET_PULL_REQUEST_COMMENT = 39;
  private static final int METHODID_LIST_PULL_REQUEST_COMMENTS = 40;
  private static final int METHODID_CREATE_PULL_REQUEST_COMMENT = 41;
  private static final int METHODID_UPDATE_PULL_REQUEST_COMMENT = 42;
  private static final int METHODID_DELETE_PULL_REQUEST_COMMENT = 43;
  private static final int METHODID_BATCH_CREATE_PULL_REQUEST_COMMENTS = 44;
  private static final int METHODID_RESOLVE_PULL_REQUEST_COMMENTS = 45;
  private static final int METHODID_UNRESOLVE_PULL_REQUEST_COMMENTS = 46;
  private static final int METHODID_CREATE_ISSUE_COMMENT = 47;
  private static final int METHODID_GET_ISSUE_COMMENT = 48;
  private static final int METHODID_LIST_ISSUE_COMMENTS = 49;
  private static final int METHODID_UPDATE_ISSUE_COMMENT = 50;
  private static final int METHODID_DELETE_ISSUE_COMMENT = 51;

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
              (com.google.cloud.securesourcemanager.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.securesourcemanager.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.securesourcemanager.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories(
              (com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository(
              (com.google.cloud.securesourcemanager.v1.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Repository>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPOSITORY:
          serviceImpl.createRepository(
              (com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REPOSITORY:
          serviceImpl.updateRepository(
              (com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_REPOSITORY:
          serviceImpl.deleteRepository(
              (com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HOOKS:
          serviceImpl.listHooks(
              (com.google.cloud.securesourcemanager.v1.ListHooksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListHooksResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HOOK:
          serviceImpl.getHook(
              (com.google.cloud.securesourcemanager.v1.GetHookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Hook>)
                  responseObserver);
          break;
        case METHODID_CREATE_HOOK:
          serviceImpl.createHook(
              (com.google.cloud.securesourcemanager.v1.CreateHookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HOOK:
          serviceImpl.updateHook(
              (com.google.cloud.securesourcemanager.v1.UpdateHookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HOOK:
          serviceImpl.deleteHook(
              (com.google.cloud.securesourcemanager.v1.DeleteHookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY_REPO:
          serviceImpl.getIamPolicyRepo(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY_REPO:
          serviceImpl.setIamPolicyRepo(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS_REPO:
          serviceImpl.testIamPermissionsRepo(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_BRANCH_RULE:
          serviceImpl.createBranchRule(
              (com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_BRANCH_RULES:
          serviceImpl.listBranchRules(
              (com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_BRANCH_RULE:
          serviceImpl.getBranchRule(
              (com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.BranchRule>)
                  responseObserver);
          break;
        case METHODID_UPDATE_BRANCH_RULE:
          serviceImpl.updateBranchRule(
              (com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_BRANCH_RULE:
          serviceImpl.deleteBranchRule(
              (com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_PULL_REQUEST:
          serviceImpl.createPullRequest(
              (com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PULL_REQUEST:
          serviceImpl.getPullRequest(
              (com.google.cloud.securesourcemanager.v1.GetPullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.PullRequest>)
                  responseObserver);
          break;
        case METHODID_LIST_PULL_REQUESTS:
          serviceImpl.listPullRequests(
              (com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PULL_REQUEST:
          serviceImpl.updatePullRequest(
              (com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MERGE_PULL_REQUEST:
          serviceImpl.mergePullRequest(
              (com.google.cloud.securesourcemanager.v1.MergePullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_OPEN_PULL_REQUEST:
          serviceImpl.openPullRequest(
              (com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CLOSE_PULL_REQUEST:
          serviceImpl.closePullRequest(
              (com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PULL_REQUEST_FILE_DIFFS:
          serviceImpl.listPullRequestFileDiffs(
              (com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_TREE:
          serviceImpl.fetchTree(
              (com.google.cloud.securesourcemanager.v1.FetchTreeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.FetchTreeResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_BLOB:
          serviceImpl.fetchBlob(
              (com.google.cloud.securesourcemanager.v1.FetchBlobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.FetchBlobResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ISSUE:
          serviceImpl.createIssue(
              (com.google.cloud.securesourcemanager.v1.CreateIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ISSUE:
          serviceImpl.getIssue(
              (com.google.cloud.securesourcemanager.v1.GetIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.Issue>)
                  responseObserver);
          break;
        case METHODID_LIST_ISSUES:
          serviceImpl.listIssues(
              (com.google.cloud.securesourcemanager.v1.ListIssuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListIssuesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ISSUE:
          serviceImpl.updateIssue(
              (com.google.cloud.securesourcemanager.v1.UpdateIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ISSUE:
          serviceImpl.deleteIssue(
              (com.google.cloud.securesourcemanager.v1.DeleteIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_OPEN_ISSUE:
          serviceImpl.openIssue(
              (com.google.cloud.securesourcemanager.v1.OpenIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CLOSE_ISSUE:
          serviceImpl.closeIssue(
              (com.google.cloud.securesourcemanager.v1.CloseIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PULL_REQUEST_COMMENT:
          serviceImpl.getPullRequestComment(
              (com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.PullRequestComment>)
                  responseObserver);
          break;
        case METHODID_LIST_PULL_REQUEST_COMMENTS:
          serviceImpl.listPullRequestComments(
              (com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PULL_REQUEST_COMMENT:
          serviceImpl.createPullRequestComment(
              (com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PULL_REQUEST_COMMENT:
          serviceImpl.updatePullRequestComment(
              (com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PULL_REQUEST_COMMENT:
          serviceImpl.deletePullRequestComment(
              (com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_CREATE_PULL_REQUEST_COMMENTS:
          serviceImpl.batchCreatePullRequestComments(
              (com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESOLVE_PULL_REQUEST_COMMENTS:
          serviceImpl.resolvePullRequestComments(
              (com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNRESOLVE_PULL_REQUEST_COMMENTS:
          serviceImpl.unresolvePullRequestComments(
              (com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ISSUE_COMMENT:
          serviceImpl.createIssueComment(
              (com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ISSUE_COMMENT:
          serviceImpl.getIssueComment(
              (com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securesourcemanager.v1.IssueComment>)
                  responseObserver);
          break;
        case METHODID_LIST_ISSUE_COMMENTS:
          serviceImpl.listIssueComments(
              (com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ISSUE_COMMENT:
          serviceImpl.updateIssueComment(
              (com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ISSUE_COMMENT:
          serviceImpl.deleteIssueComment(
              (com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest) request,
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
                    com.google.cloud.securesourcemanager.v1.ListInstancesRequest,
                    com.google.cloud.securesourcemanager.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetInstanceRequest,
                    com.google.cloud.securesourcemanager.v1.Instance>(
                    service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getListRepositoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListRepositoriesRequest,
                    com.google.cloud.securesourcemanager.v1.ListRepositoriesResponse>(
                    service, METHODID_LIST_REPOSITORIES)))
        .addMethod(
            getGetRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetRepositoryRequest,
                    com.google.cloud.securesourcemanager.v1.Repository>(
                    service, METHODID_GET_REPOSITORY)))
        .addMethod(
            getCreateRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateRepositoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPOSITORY)))
        .addMethod(
            getUpdateRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdateRepositoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_REPOSITORY)))
        .addMethod(
            getDeleteRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteRepositoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REPOSITORY)))
        .addMethod(
            getListHooksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListHooksRequest,
                    com.google.cloud.securesourcemanager.v1.ListHooksResponse>(
                    service, METHODID_LIST_HOOKS)))
        .addMethod(
            getGetHookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetHookRequest,
                    com.google.cloud.securesourcemanager.v1.Hook>(service, METHODID_GET_HOOK)))
        .addMethod(
            getCreateHookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateHookRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HOOK)))
        .addMethod(
            getUpdateHookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdateHookRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_HOOK)))
        .addMethod(
            getDeleteHookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteHookRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_HOOK)))
        .addMethod(
            getGetIamPolicyRepoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY_REPO)))
        .addMethod(
            getSetIamPolicyRepoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY_REPO)))
        .addMethod(
            getTestIamPermissionsRepoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS_REPO)))
        .addMethod(
            getCreateBranchRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateBranchRuleRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_BRANCH_RULE)))
        .addMethod(
            getListBranchRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListBranchRulesRequest,
                    com.google.cloud.securesourcemanager.v1.ListBranchRulesResponse>(
                    service, METHODID_LIST_BRANCH_RULES)))
        .addMethod(
            getGetBranchRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetBranchRuleRequest,
                    com.google.cloud.securesourcemanager.v1.BranchRule>(
                    service, METHODID_GET_BRANCH_RULE)))
        .addMethod(
            getUpdateBranchRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdateBranchRuleRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_BRANCH_RULE)))
        .addMethod(
            getDeleteBranchRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteBranchRuleRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_BRANCH_RULE)))
        .addMethod(
            getCreatePullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreatePullRequestRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PULL_REQUEST)))
        .addMethod(
            getGetPullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetPullRequestRequest,
                    com.google.cloud.securesourcemanager.v1.PullRequest>(
                    service, METHODID_GET_PULL_REQUEST)))
        .addMethod(
            getListPullRequestsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListPullRequestsRequest,
                    com.google.cloud.securesourcemanager.v1.ListPullRequestsResponse>(
                    service, METHODID_LIST_PULL_REQUESTS)))
        .addMethod(
            getUpdatePullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdatePullRequestRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PULL_REQUEST)))
        .addMethod(
            getMergePullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.MergePullRequestRequest,
                    com.google.longrunning.Operation>(service, METHODID_MERGE_PULL_REQUEST)))
        .addMethod(
            getOpenPullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.OpenPullRequestRequest,
                    com.google.longrunning.Operation>(service, METHODID_OPEN_PULL_REQUEST)))
        .addMethod(
            getClosePullRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ClosePullRequestRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLOSE_PULL_REQUEST)))
        .addMethod(
            getListPullRequestFileDiffsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsRequest,
                    com.google.cloud.securesourcemanager.v1.ListPullRequestFileDiffsResponse>(
                    service, METHODID_LIST_PULL_REQUEST_FILE_DIFFS)))
        .addMethod(
            getFetchTreeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.FetchTreeRequest,
                    com.google.cloud.securesourcemanager.v1.FetchTreeResponse>(
                    service, METHODID_FETCH_TREE)))
        .addMethod(
            getFetchBlobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.FetchBlobRequest,
                    com.google.cloud.securesourcemanager.v1.FetchBlobResponse>(
                    service, METHODID_FETCH_BLOB)))
        .addMethod(
            getCreateIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateIssueRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ISSUE)))
        .addMethod(
            getGetIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetIssueRequest,
                    com.google.cloud.securesourcemanager.v1.Issue>(service, METHODID_GET_ISSUE)))
        .addMethod(
            getListIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListIssuesRequest,
                    com.google.cloud.securesourcemanager.v1.ListIssuesResponse>(
                    service, METHODID_LIST_ISSUES)))
        .addMethod(
            getUpdateIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdateIssueRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ISSUE)))
        .addMethod(
            getDeleteIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteIssueRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ISSUE)))
        .addMethod(
            getOpenIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.OpenIssueRequest,
                    com.google.longrunning.Operation>(service, METHODID_OPEN_ISSUE)))
        .addMethod(
            getCloseIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CloseIssueRequest,
                    com.google.longrunning.Operation>(service, METHODID_CLOSE_ISSUE)))
        .addMethod(
            getGetPullRequestCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetPullRequestCommentRequest,
                    com.google.cloud.securesourcemanager.v1.PullRequestComment>(
                    service, METHODID_GET_PULL_REQUEST_COMMENT)))
        .addMethod(
            getListPullRequestCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsRequest,
                    com.google.cloud.securesourcemanager.v1.ListPullRequestCommentsResponse>(
                    service, METHODID_LIST_PULL_REQUEST_COMMENTS)))
        .addMethod(
            getCreatePullRequestCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreatePullRequestCommentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_PULL_REQUEST_COMMENT)))
        .addMethod(
            getUpdatePullRequestCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdatePullRequestCommentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_PULL_REQUEST_COMMENT)))
        .addMethod(
            getDeletePullRequestCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeletePullRequestCommentRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_PULL_REQUEST_COMMENT)))
        .addMethod(
            getBatchCreatePullRequestCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.BatchCreatePullRequestCommentsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BATCH_CREATE_PULL_REQUEST_COMMENTS)))
        .addMethod(
            getResolvePullRequestCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ResolvePullRequestCommentsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_RESOLVE_PULL_REQUEST_COMMENTS)))
        .addMethod(
            getUnresolvePullRequestCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UnresolvePullRequestCommentsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UNRESOLVE_PULL_REQUEST_COMMENTS)))
        .addMethod(
            getCreateIssueCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.CreateIssueCommentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ISSUE_COMMENT)))
        .addMethod(
            getGetIssueCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.GetIssueCommentRequest,
                    com.google.cloud.securesourcemanager.v1.IssueComment>(
                    service, METHODID_GET_ISSUE_COMMENT)))
        .addMethod(
            getListIssueCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.ListIssueCommentsRequest,
                    com.google.cloud.securesourcemanager.v1.ListIssueCommentsResponse>(
                    service, METHODID_LIST_ISSUE_COMMENTS)))
        .addMethod(
            getUpdateIssueCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.UpdateIssueCommentRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ISSUE_COMMENT)))
        .addMethod(
            getDeleteIssueCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.securesourcemanager.v1.DeleteIssueCommentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ISSUE_COMMENT)))
        .build();
  }

  private abstract static class SecureSourceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecureSourceManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securesourcemanager.v1.SecureSourceManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecureSourceManager");
    }
  }

  private static final class SecureSourceManagerFileDescriptorSupplier
      extends SecureSourceManagerBaseDescriptorSupplier {
    SecureSourceManagerFileDescriptorSupplier() {}
  }

  private static final class SecureSourceManagerMethodDescriptorSupplier
      extends SecureSourceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecureSourceManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecureSourceManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecureSourceManagerFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getListRepositoriesMethod())
                      .addMethod(getGetRepositoryMethod())
                      .addMethod(getCreateRepositoryMethod())
                      .addMethod(getUpdateRepositoryMethod())
                      .addMethod(getDeleteRepositoryMethod())
                      .addMethod(getListHooksMethod())
                      .addMethod(getGetHookMethod())
                      .addMethod(getCreateHookMethod())
                      .addMethod(getUpdateHookMethod())
                      .addMethod(getDeleteHookMethod())
                      .addMethod(getGetIamPolicyRepoMethod())
                      .addMethod(getSetIamPolicyRepoMethod())
                      .addMethod(getTestIamPermissionsRepoMethod())
                      .addMethod(getCreateBranchRuleMethod())
                      .addMethod(getListBranchRulesMethod())
                      .addMethod(getGetBranchRuleMethod())
                      .addMethod(getUpdateBranchRuleMethod())
                      .addMethod(getDeleteBranchRuleMethod())
                      .addMethod(getCreatePullRequestMethod())
                      .addMethod(getGetPullRequestMethod())
                      .addMethod(getListPullRequestsMethod())
                      .addMethod(getUpdatePullRequestMethod())
                      .addMethod(getMergePullRequestMethod())
                      .addMethod(getOpenPullRequestMethod())
                      .addMethod(getClosePullRequestMethod())
                      .addMethod(getListPullRequestFileDiffsMethod())
                      .addMethod(getFetchTreeMethod())
                      .addMethod(getFetchBlobMethod())
                      .addMethod(getCreateIssueMethod())
                      .addMethod(getGetIssueMethod())
                      .addMethod(getListIssuesMethod())
                      .addMethod(getUpdateIssueMethod())
                      .addMethod(getDeleteIssueMethod())
                      .addMethod(getOpenIssueMethod())
                      .addMethod(getCloseIssueMethod())
                      .addMethod(getGetPullRequestCommentMethod())
                      .addMethod(getListPullRequestCommentsMethod())
                      .addMethod(getCreatePullRequestCommentMethod())
                      .addMethod(getUpdatePullRequestCommentMethod())
                      .addMethod(getDeletePullRequestCommentMethod())
                      .addMethod(getBatchCreatePullRequestCommentsMethod())
                      .addMethod(getResolvePullRequestCommentsMethod())
                      .addMethod(getUnresolvePullRequestCommentsMethod())
                      .addMethod(getCreateIssueCommentMethod())
                      .addMethod(getGetIssueCommentMethod())
                      .addMethod(getListIssueCommentsMethod())
                      .addMethod(getUpdateIssueCommentMethod())
                      .addMethod(getDeleteIssueCommentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
