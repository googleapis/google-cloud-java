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
package com.google.cloud.apihub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service provides methods for various operations related to a
 * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/apihub_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiHubDependenciesGrpc {

  private ApiHubDependenciesGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apihub.v1.ApiHubDependencies";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getCreateDependencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDependency",
      requestType = com.google.cloud.apihub.v1.CreateDependencyRequest.class,
      responseType = com.google.cloud.apihub.v1.Dependency.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getCreateDependencyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateDependencyRequest,
            com.google.cloud.apihub.v1.Dependency>
        getCreateDependencyMethod;
    if ((getCreateDependencyMethod = ApiHubDependenciesGrpc.getCreateDependencyMethod) == null) {
      synchronized (ApiHubDependenciesGrpc.class) {
        if ((getCreateDependencyMethod = ApiHubDependenciesGrpc.getCreateDependencyMethod)
            == null) {
          ApiHubDependenciesGrpc.getCreateDependencyMethod =
              getCreateDependencyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateDependencyRequest,
                          com.google.cloud.apihub.v1.Dependency>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDependency"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateDependencyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Dependency.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubDependenciesMethodDescriptorSupplier("CreateDependency"))
                      .build();
        }
      }
    }
    return getCreateDependencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getGetDependencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDependency",
      requestType = com.google.cloud.apihub.v1.GetDependencyRequest.class,
      responseType = com.google.cloud.apihub.v1.Dependency.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getGetDependencyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetDependencyRequest, com.google.cloud.apihub.v1.Dependency>
        getGetDependencyMethod;
    if ((getGetDependencyMethod = ApiHubDependenciesGrpc.getGetDependencyMethod) == null) {
      synchronized (ApiHubDependenciesGrpc.class) {
        if ((getGetDependencyMethod = ApiHubDependenciesGrpc.getGetDependencyMethod) == null) {
          ApiHubDependenciesGrpc.getGetDependencyMethod =
              getGetDependencyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetDependencyRequest,
                          com.google.cloud.apihub.v1.Dependency>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDependency"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetDependencyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Dependency.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubDependenciesMethodDescriptorSupplier("GetDependency"))
                      .build();
        }
      }
    }
    return getGetDependencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getUpdateDependencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDependency",
      requestType = com.google.cloud.apihub.v1.UpdateDependencyRequest.class,
      responseType = com.google.cloud.apihub.v1.Dependency.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.UpdateDependencyRequest, com.google.cloud.apihub.v1.Dependency>
      getUpdateDependencyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.UpdateDependencyRequest,
            com.google.cloud.apihub.v1.Dependency>
        getUpdateDependencyMethod;
    if ((getUpdateDependencyMethod = ApiHubDependenciesGrpc.getUpdateDependencyMethod) == null) {
      synchronized (ApiHubDependenciesGrpc.class) {
        if ((getUpdateDependencyMethod = ApiHubDependenciesGrpc.getUpdateDependencyMethod)
            == null) {
          ApiHubDependenciesGrpc.getUpdateDependencyMethod =
              getUpdateDependencyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.UpdateDependencyRequest,
                          com.google.cloud.apihub.v1.Dependency>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDependency"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.UpdateDependencyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.Dependency.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubDependenciesMethodDescriptorSupplier("UpdateDependency"))
                      .build();
        }
      }
    }
    return getUpdateDependencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteDependencyRequest, com.google.protobuf.Empty>
      getDeleteDependencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDependency",
      requestType = com.google.cloud.apihub.v1.DeleteDependencyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteDependencyRequest, com.google.protobuf.Empty>
      getDeleteDependencyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteDependencyRequest, com.google.protobuf.Empty>
        getDeleteDependencyMethod;
    if ((getDeleteDependencyMethod = ApiHubDependenciesGrpc.getDeleteDependencyMethod) == null) {
      synchronized (ApiHubDependenciesGrpc.class) {
        if ((getDeleteDependencyMethod = ApiHubDependenciesGrpc.getDeleteDependencyMethod)
            == null) {
          ApiHubDependenciesGrpc.getDeleteDependencyMethod =
              getDeleteDependencyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteDependencyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDependency"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteDependencyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubDependenciesMethodDescriptorSupplier("DeleteDependency"))
                      .build();
        }
      }
    }
    return getDeleteDependencyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListDependenciesRequest,
          com.google.cloud.apihub.v1.ListDependenciesResponse>
      getListDependenciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDependencies",
      requestType = com.google.cloud.apihub.v1.ListDependenciesRequest.class,
      responseType = com.google.cloud.apihub.v1.ListDependenciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListDependenciesRequest,
          com.google.cloud.apihub.v1.ListDependenciesResponse>
      getListDependenciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListDependenciesRequest,
            com.google.cloud.apihub.v1.ListDependenciesResponse>
        getListDependenciesMethod;
    if ((getListDependenciesMethod = ApiHubDependenciesGrpc.getListDependenciesMethod) == null) {
      synchronized (ApiHubDependenciesGrpc.class) {
        if ((getListDependenciesMethod = ApiHubDependenciesGrpc.getListDependenciesMethod)
            == null) {
          ApiHubDependenciesGrpc.getListDependenciesMethod =
              getListDependenciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListDependenciesRequest,
                          com.google.cloud.apihub.v1.ListDependenciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDependencies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListDependenciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListDependenciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApiHubDependenciesMethodDescriptorSupplier("ListDependencies"))
                      .build();
        }
      }
    }
    return getListDependenciesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ApiHubDependenciesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesStub>() {
          @java.lang.Override
          public ApiHubDependenciesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubDependenciesStub(channel, callOptions);
          }
        };
    return ApiHubDependenciesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiHubDependenciesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesBlockingStub>() {
          @java.lang.Override
          public ApiHubDependenciesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubDependenciesBlockingStub(channel, callOptions);
          }
        };
    return ApiHubDependenciesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ApiHubDependenciesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ApiHubDependenciesFutureStub>() {
          @java.lang.Override
          public ApiHubDependenciesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ApiHubDependenciesFutureStub(channel, callOptions);
          }
        };
    return ApiHubDependenciesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service provides methods for various operations related to a
   * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a dependency between two entities in the API hub.
     * </pre>
     */
    default void createDependency(
        com.google.cloud.apihub.v1.CreateDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDependencyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a dependency resource in the API hub.
     * </pre>
     */
    default void getDependency(
        com.google.cloud.apihub.v1.GetDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDependencyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a dependency based on the
     * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask]
     * provided in the request.
     * The following fields in the [dependency][google.cloud.apihub.v1.Dependency]
     * can be updated:
     * * [description][google.cloud.apihub.v1.Dependency.description]
     * </pre>
     */
    default void updateDependency(
        com.google.cloud.apihub.v1.UpdateDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDependencyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the dependency resource.
     * </pre>
     */
    default void deleteDependency(
        com.google.cloud.apihub.v1.DeleteDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDependencyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List dependencies based on the provided filter and pagination parameters.
     * </pre>
     */
    default void listDependencies(
        com.google.cloud.apihub.v1.ListDependenciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDependenciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDependenciesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ApiHubDependencies.
   *
   * <pre>
   * This service provides methods for various operations related to a
   * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
   * </pre>
   */
  public abstract static class ApiHubDependenciesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ApiHubDependenciesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ApiHubDependencies.
   *
   * <pre>
   * This service provides methods for various operations related to a
   * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
   * </pre>
   */
  public static final class ApiHubDependenciesStub
      extends io.grpc.stub.AbstractAsyncStub<ApiHubDependenciesStub> {
    private ApiHubDependenciesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubDependenciesStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubDependenciesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dependency between two entities in the API hub.
     * </pre>
     */
    public void createDependency(
        com.google.cloud.apihub.v1.CreateDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDependencyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get details about a dependency resource in the API hub.
     * </pre>
     */
    public void getDependency(
        com.google.cloud.apihub.v1.GetDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDependencyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a dependency based on the
     * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask]
     * provided in the request.
     * The following fields in the [dependency][google.cloud.apihub.v1.Dependency]
     * can be updated:
     * * [description][google.cloud.apihub.v1.Dependency.description]
     * </pre>
     */
    public void updateDependency(
        com.google.cloud.apihub.v1.UpdateDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDependencyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the dependency resource.
     * </pre>
     */
    public void deleteDependency(
        com.google.cloud.apihub.v1.DeleteDependencyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDependencyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List dependencies based on the provided filter and pagination parameters.
     * </pre>
     */
    public void listDependencies(
        com.google.cloud.apihub.v1.ListDependenciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDependenciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDependenciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ApiHubDependencies.
   *
   * <pre>
   * This service provides methods for various operations related to a
   * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
   * </pre>
   */
  public static final class ApiHubDependenciesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ApiHubDependenciesBlockingStub> {
    private ApiHubDependenciesBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubDependenciesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubDependenciesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dependency between two entities in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Dependency createDependency(
        com.google.cloud.apihub.v1.CreateDependencyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDependencyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a dependency resource in the API hub.
     * </pre>
     */
    public com.google.cloud.apihub.v1.Dependency getDependency(
        com.google.cloud.apihub.v1.GetDependencyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDependencyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a dependency based on the
     * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask]
     * provided in the request.
     * The following fields in the [dependency][google.cloud.apihub.v1.Dependency]
     * can be updated:
     * * [description][google.cloud.apihub.v1.Dependency.description]
     * </pre>
     */
    public com.google.cloud.apihub.v1.Dependency updateDependency(
        com.google.cloud.apihub.v1.UpdateDependencyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDependencyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the dependency resource.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDependency(
        com.google.cloud.apihub.v1.DeleteDependencyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDependencyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List dependencies based on the provided filter and pagination parameters.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListDependenciesResponse listDependencies(
        com.google.cloud.apihub.v1.ListDependenciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDependenciesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ApiHubDependencies.
   *
   * <pre>
   * This service provides methods for various operations related to a
   * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
   * </pre>
   */
  public static final class ApiHubDependenciesFutureStub
      extends io.grpc.stub.AbstractFutureStub<ApiHubDependenciesFutureStub> {
    private ApiHubDependenciesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiHubDependenciesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiHubDependenciesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a dependency between two entities in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Dependency>
        createDependency(com.google.cloud.apihub.v1.CreateDependencyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDependencyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get details about a dependency resource in the API hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Dependency>
        getDependency(com.google.cloud.apihub.v1.GetDependencyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDependencyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a dependency based on the
     * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask]
     * provided in the request.
     * The following fields in the [dependency][google.cloud.apihub.v1.Dependency]
     * can be updated:
     * * [description][google.cloud.apihub.v1.Dependency.description]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apihub.v1.Dependency>
        updateDependency(com.google.cloud.apihub.v1.UpdateDependencyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDependencyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the dependency resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDependency(com.google.cloud.apihub.v1.DeleteDependencyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDependencyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List dependencies based on the provided filter and pagination parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListDependenciesResponse>
        listDependencies(com.google.cloud.apihub.v1.ListDependenciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDependenciesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DEPENDENCY = 0;
  private static final int METHODID_GET_DEPENDENCY = 1;
  private static final int METHODID_UPDATE_DEPENDENCY = 2;
  private static final int METHODID_DELETE_DEPENDENCY = 3;
  private static final int METHODID_LIST_DEPENDENCIES = 4;

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
        case METHODID_CREATE_DEPENDENCY:
          serviceImpl.createDependency(
              (com.google.cloud.apihub.v1.CreateDependencyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency>)
                  responseObserver);
          break;
        case METHODID_GET_DEPENDENCY:
          serviceImpl.getDependency(
              (com.google.cloud.apihub.v1.GetDependencyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DEPENDENCY:
          serviceImpl.updateDependency(
              (com.google.cloud.apihub.v1.UpdateDependencyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.Dependency>)
                  responseObserver);
          break;
        case METHODID_DELETE_DEPENDENCY:
          serviceImpl.deleteDependency(
              (com.google.cloud.apihub.v1.DeleteDependencyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DEPENDENCIES:
          serviceImpl.listDependencies(
              (com.google.cloud.apihub.v1.ListDependenciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListDependenciesResponse>)
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
            getCreateDependencyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateDependencyRequest,
                    com.google.cloud.apihub.v1.Dependency>(service, METHODID_CREATE_DEPENDENCY)))
        .addMethod(
            getGetDependencyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetDependencyRequest,
                    com.google.cloud.apihub.v1.Dependency>(service, METHODID_GET_DEPENDENCY)))
        .addMethod(
            getUpdateDependencyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.UpdateDependencyRequest,
                    com.google.cloud.apihub.v1.Dependency>(service, METHODID_UPDATE_DEPENDENCY)))
        .addMethod(
            getDeleteDependencyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteDependencyRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_DEPENDENCY)))
        .addMethod(
            getListDependenciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListDependenciesRequest,
                    com.google.cloud.apihub.v1.ListDependenciesResponse>(
                    service, METHODID_LIST_DEPENDENCIES)))
        .build();
  }

  private abstract static class ApiHubDependenciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiHubDependenciesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.ApiHubServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiHubDependencies");
    }
  }

  private static final class ApiHubDependenciesFileDescriptorSupplier
      extends ApiHubDependenciesBaseDescriptorSupplier {
    ApiHubDependenciesFileDescriptorSupplier() {}
  }

  private static final class ApiHubDependenciesMethodDescriptorSupplier
      extends ApiHubDependenciesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ApiHubDependenciesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ApiHubDependenciesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ApiHubDependenciesFileDescriptorSupplier())
                      .addMethod(getCreateDependencyMethod())
                      .addMethod(getGetDependencyMethod())
                      .addMethod(getUpdateDependencyMethod())
                      .addMethod(getDeleteDependencyMethod())
                      .addMethod(getListDependenciesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
