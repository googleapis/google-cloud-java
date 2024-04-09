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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for managing Vertex AI's machine learning PersistentResource.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/persistent_resource_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PersistentResourceServiceGrpc {

  private PersistentResourceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.PersistentResourceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest,
          com.google.longrunning.Operation>
      getCreatePersistentResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePersistentResource",
      requestType = com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest,
          com.google.longrunning.Operation>
      getCreatePersistentResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest,
            com.google.longrunning.Operation>
        getCreatePersistentResourceMethod;
    if ((getCreatePersistentResourceMethod =
            PersistentResourceServiceGrpc.getCreatePersistentResourceMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getCreatePersistentResourceMethod =
                PersistentResourceServiceGrpc.getCreatePersistentResourceMethod)
            == null) {
          PersistentResourceServiceGrpc.getCreatePersistentResourceMethod =
              getCreatePersistentResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePersistentResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "CreatePersistentResource"))
                      .build();
        }
      }
    }
    return getCreatePersistentResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest,
          com.google.cloud.aiplatform.v1beta1.PersistentResource>
      getGetPersistentResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPersistentResource",
      requestType = com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.PersistentResource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest,
          com.google.cloud.aiplatform.v1beta1.PersistentResource>
      getGetPersistentResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest,
            com.google.cloud.aiplatform.v1beta1.PersistentResource>
        getGetPersistentResourceMethod;
    if ((getGetPersistentResourceMethod =
            PersistentResourceServiceGrpc.getGetPersistentResourceMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getGetPersistentResourceMethod =
                PersistentResourceServiceGrpc.getGetPersistentResourceMethod)
            == null) {
          PersistentResourceServiceGrpc.getGetPersistentResourceMethod =
              getGetPersistentResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest,
                          com.google.cloud.aiplatform.v1beta1.PersistentResource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPersistentResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.PersistentResource
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "GetPersistentResource"))
                      .build();
        }
      }
    }
    return getGetPersistentResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest,
          com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
      getListPersistentResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPersistentResources",
      requestType = com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest,
          com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
      getListPersistentResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest,
            com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
        getListPersistentResourcesMethod;
    if ((getListPersistentResourcesMethod =
            PersistentResourceServiceGrpc.getListPersistentResourcesMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getListPersistentResourcesMethod =
                PersistentResourceServiceGrpc.getListPersistentResourcesMethod)
            == null) {
          PersistentResourceServiceGrpc.getListPersistentResourcesMethod =
              getListPersistentResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPersistentResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "ListPersistentResources"))
                      .build();
        }
      }
    }
    return getListPersistentResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest,
          com.google.longrunning.Operation>
      getDeletePersistentResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePersistentResource",
      requestType = com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest,
          com.google.longrunning.Operation>
      getDeletePersistentResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest,
            com.google.longrunning.Operation>
        getDeletePersistentResourceMethod;
    if ((getDeletePersistentResourceMethod =
            PersistentResourceServiceGrpc.getDeletePersistentResourceMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getDeletePersistentResourceMethod =
                PersistentResourceServiceGrpc.getDeletePersistentResourceMethod)
            == null) {
          PersistentResourceServiceGrpc.getDeletePersistentResourceMethod =
              getDeletePersistentResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePersistentResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "DeletePersistentResource"))
                      .build();
        }
      }
    }
    return getDeletePersistentResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest,
          com.google.longrunning.Operation>
      getUpdatePersistentResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePersistentResource",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest,
          com.google.longrunning.Operation>
      getUpdatePersistentResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest,
            com.google.longrunning.Operation>
        getUpdatePersistentResourceMethod;
    if ((getUpdatePersistentResourceMethod =
            PersistentResourceServiceGrpc.getUpdatePersistentResourceMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getUpdatePersistentResourceMethod =
                PersistentResourceServiceGrpc.getUpdatePersistentResourceMethod)
            == null) {
          PersistentResourceServiceGrpc.getUpdatePersistentResourceMethod =
              getUpdatePersistentResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePersistentResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "UpdatePersistentResource"))
                      .build();
        }
      }
    }
    return getUpdatePersistentResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest,
          com.google.longrunning.Operation>
      getRebootPersistentResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RebootPersistentResource",
      requestType = com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest,
          com.google.longrunning.Operation>
      getRebootPersistentResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest,
            com.google.longrunning.Operation>
        getRebootPersistentResourceMethod;
    if ((getRebootPersistentResourceMethod =
            PersistentResourceServiceGrpc.getRebootPersistentResourceMethod)
        == null) {
      synchronized (PersistentResourceServiceGrpc.class) {
        if ((getRebootPersistentResourceMethod =
                PersistentResourceServiceGrpc.getRebootPersistentResourceMethod)
            == null) {
          PersistentResourceServiceGrpc.getRebootPersistentResourceMethod =
              getRebootPersistentResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RebootPersistentResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PersistentResourceServiceMethodDescriptorSupplier(
                              "RebootPersistentResource"))
                      .build();
        }
      }
    }
    return getRebootPersistentResourceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PersistentResourceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceStub>() {
          @java.lang.Override
          public PersistentResourceServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PersistentResourceServiceStub(channel, callOptions);
          }
        };
    return PersistentResourceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PersistentResourceServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceBlockingStub>() {
          @java.lang.Override
          public PersistentResourceServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PersistentResourceServiceBlockingStub(channel, callOptions);
          }
        };
    return PersistentResourceServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PersistentResourceServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PersistentResourceServiceFutureStub>() {
          @java.lang.Override
          public PersistentResourceServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PersistentResourceServiceFutureStub(channel, callOptions);
          }
        };
    return PersistentResourceServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for managing Vertex AI's machine learning PersistentResource.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a PersistentResource.
     * </pre>
     */
    default void createPersistentResource(
        com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePersistentResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a PersistentResource.
     * </pre>
     */
    default void getPersistentResource(
        com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PersistentResource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPersistentResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PersistentResources in a Location.
     * </pre>
     */
    default void listPersistentResources(
        com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPersistentResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PersistentResource.
     * </pre>
     */
    default void deletePersistentResource(
        com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePersistentResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a PersistentResource.
     * </pre>
     */
    default void updatePersistentResource(
        com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePersistentResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reboots a PersistentResource.
     * </pre>
     */
    default void rebootPersistentResource(
        com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRebootPersistentResourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PersistentResourceService.
   *
   * <pre>
   * A service for managing Vertex AI's machine learning PersistentResource.
   * </pre>
   */
  public abstract static class PersistentResourceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PersistentResourceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PersistentResourceService.
   *
   * <pre>
   * A service for managing Vertex AI's machine learning PersistentResource.
   * </pre>
   */
  public static final class PersistentResourceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PersistentResourceServiceStub> {
    private PersistentResourceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersistentResourceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersistentResourceServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a PersistentResource.
     * </pre>
     */
    public void createPersistentResource(
        com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePersistentResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a PersistentResource.
     * </pre>
     */
    public void getPersistentResource(
        com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PersistentResource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPersistentResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists PersistentResources in a Location.
     * </pre>
     */
    public void listPersistentResources(
        com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPersistentResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PersistentResource.
     * </pre>
     */
    public void deletePersistentResource(
        com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePersistentResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a PersistentResource.
     * </pre>
     */
    public void updatePersistentResource(
        com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePersistentResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reboots a PersistentResource.
     * </pre>
     */
    public void rebootPersistentResource(
        com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRebootPersistentResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PersistentResourceService.
   *
   * <pre>
   * A service for managing Vertex AI's machine learning PersistentResource.
   * </pre>
   */
  public static final class PersistentResourceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PersistentResourceServiceBlockingStub> {
    private PersistentResourceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersistentResourceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersistentResourceServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a PersistentResource.
     * </pre>
     */
    public com.google.longrunning.Operation createPersistentResource(
        com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePersistentResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a PersistentResource.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.PersistentResource getPersistentResource(
        com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPersistentResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PersistentResources in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse
        listPersistentResources(
            com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPersistentResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PersistentResource.
     * </pre>
     */
    public com.google.longrunning.Operation deletePersistentResource(
        com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePersistentResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a PersistentResource.
     * </pre>
     */
    public com.google.longrunning.Operation updatePersistentResource(
        com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePersistentResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reboots a PersistentResource.
     * </pre>
     */
    public com.google.longrunning.Operation rebootPersistentResource(
        com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRebootPersistentResourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * PersistentResourceService.
   *
   * <pre>
   * A service for managing Vertex AI's machine learning PersistentResource.
   * </pre>
   */
  public static final class PersistentResourceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PersistentResourceServiceFutureStub> {
    private PersistentResourceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PersistentResourceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PersistentResourceServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a PersistentResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPersistentResource(
            com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePersistentResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a PersistentResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.PersistentResource>
        getPersistentResource(
            com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPersistentResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists PersistentResources in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>
        listPersistentResources(
            com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPersistentResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a PersistentResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePersistentResource(
            com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePersistentResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a PersistentResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePersistentResource(
            com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePersistentResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reboots a PersistentResource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rebootPersistentResource(
            com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRebootPersistentResourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PERSISTENT_RESOURCE = 0;
  private static final int METHODID_GET_PERSISTENT_RESOURCE = 1;
  private static final int METHODID_LIST_PERSISTENT_RESOURCES = 2;
  private static final int METHODID_DELETE_PERSISTENT_RESOURCE = 3;
  private static final int METHODID_UPDATE_PERSISTENT_RESOURCE = 4;
  private static final int METHODID_REBOOT_PERSISTENT_RESOURCE = 5;

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
        case METHODID_CREATE_PERSISTENT_RESOURCE:
          serviceImpl.createPersistentResource(
              (com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PERSISTENT_RESOURCE:
          serviceImpl.getPersistentResource(
              (com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.PersistentResource>)
                  responseObserver);
          break;
        case METHODID_LIST_PERSISTENT_RESOURCES:
          serviceImpl.listPersistentResources(
              (com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PERSISTENT_RESOURCE:
          serviceImpl.deletePersistentResource(
              (com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PERSISTENT_RESOURCE:
          serviceImpl.updatePersistentResource(
              (com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REBOOT_PERSISTENT_RESOURCE:
          serviceImpl.rebootPersistentResource(
              (com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest) request,
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
            getCreatePersistentResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreatePersistentResourceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_PERSISTENT_RESOURCE)))
        .addMethod(
            getGetPersistentResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetPersistentResourceRequest,
                    com.google.cloud.aiplatform.v1beta1.PersistentResource>(
                    service, METHODID_GET_PERSISTENT_RESOURCE)))
        .addMethod(
            getListPersistentResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListPersistentResourcesResponse>(
                    service, METHODID_LIST_PERSISTENT_RESOURCES)))
        .addMethod(
            getDeletePersistentResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeletePersistentResourceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_PERSISTENT_RESOURCE)))
        .addMethod(
            getUpdatePersistentResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdatePersistentResourceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_PERSISTENT_RESOURCE)))
        .addMethod(
            getRebootPersistentResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.RebootPersistentResourceRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_REBOOT_PERSISTENT_RESOURCE)))
        .build();
  }

  private abstract static class PersistentResourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PersistentResourceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.PersistentResourceServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PersistentResourceService");
    }
  }

  private static final class PersistentResourceServiceFileDescriptorSupplier
      extends PersistentResourceServiceBaseDescriptorSupplier {
    PersistentResourceServiceFileDescriptorSupplier() {}
  }

  private static final class PersistentResourceServiceMethodDescriptorSupplier
      extends PersistentResourceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PersistentResourceServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PersistentResourceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PersistentResourceServiceFileDescriptorSupplier())
                      .addMethod(getCreatePersistentResourceMethod())
                      .addMethod(getGetPersistentResourceMethod())
                      .addMethod(getListPersistentResourcesMethod())
                      .addMethod(getDeletePersistentResourceMethod())
                      .addMethod(getUpdatePersistentResourceMethod())
                      .addMethod(getRebootPersistentResourceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
