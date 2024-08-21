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
 * This service is used for managing the runtime project attachments.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/runtime_project_attachment_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RuntimeProjectAttachmentServiceGrpc {

  private RuntimeProjectAttachmentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.apihub.v1.RuntimeProjectAttachmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
      getCreateRuntimeProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRuntimeProjectAttachment",
      requestType = com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest.class,
      responseType = com.google.cloud.apihub.v1.RuntimeProjectAttachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
      getCreateRuntimeProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest,
            com.google.cloud.apihub.v1.RuntimeProjectAttachment>
        getCreateRuntimeProjectAttachmentMethod;
    if ((getCreateRuntimeProjectAttachmentMethod =
            RuntimeProjectAttachmentServiceGrpc.getCreateRuntimeProjectAttachmentMethod)
        == null) {
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        if ((getCreateRuntimeProjectAttachmentMethod =
                RuntimeProjectAttachmentServiceGrpc.getCreateRuntimeProjectAttachmentMethod)
            == null) {
          RuntimeProjectAttachmentServiceGrpc.getCreateRuntimeProjectAttachmentMethod =
              getCreateRuntimeProjectAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest,
                          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateRuntimeProjectAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.RuntimeProjectAttachment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceMethodDescriptorSupplier(
                              "CreateRuntimeProjectAttachment"))
                      .build();
        }
      }
    }
    return getCreateRuntimeProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
      getGetRuntimeProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRuntimeProjectAttachment",
      requestType = com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest.class,
      responseType = com.google.cloud.apihub.v1.RuntimeProjectAttachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
      getGetRuntimeProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest,
            com.google.cloud.apihub.v1.RuntimeProjectAttachment>
        getGetRuntimeProjectAttachmentMethod;
    if ((getGetRuntimeProjectAttachmentMethod =
            RuntimeProjectAttachmentServiceGrpc.getGetRuntimeProjectAttachmentMethod)
        == null) {
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        if ((getGetRuntimeProjectAttachmentMethod =
                RuntimeProjectAttachmentServiceGrpc.getGetRuntimeProjectAttachmentMethod)
            == null) {
          RuntimeProjectAttachmentServiceGrpc.getGetRuntimeProjectAttachmentMethod =
              getGetRuntimeProjectAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest,
                          com.google.cloud.apihub.v1.RuntimeProjectAttachment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetRuntimeProjectAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.RuntimeProjectAttachment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceMethodDescriptorSupplier(
                              "GetRuntimeProjectAttachment"))
                      .build();
        }
      }
    }
    return getGetRuntimeProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest,
          com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
      getListRuntimeProjectAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuntimeProjectAttachments",
      requestType = com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest,
          com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
      getListRuntimeProjectAttachmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest,
            com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
        getListRuntimeProjectAttachmentsMethod;
    if ((getListRuntimeProjectAttachmentsMethod =
            RuntimeProjectAttachmentServiceGrpc.getListRuntimeProjectAttachmentsMethod)
        == null) {
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        if ((getListRuntimeProjectAttachmentsMethod =
                RuntimeProjectAttachmentServiceGrpc.getListRuntimeProjectAttachmentsMethod)
            == null) {
          RuntimeProjectAttachmentServiceGrpc.getListRuntimeProjectAttachmentsMethod =
              getListRuntimeProjectAttachmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest,
                          com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListRuntimeProjectAttachments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceMethodDescriptorSupplier(
                              "ListRuntimeProjectAttachments"))
                      .build();
        }
      }
    }
    return getListRuntimeProjectAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest,
          com.google.protobuf.Empty>
      getDeleteRuntimeProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRuntimeProjectAttachment",
      requestType = com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest,
          com.google.protobuf.Empty>
      getDeleteRuntimeProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest,
            com.google.protobuf.Empty>
        getDeleteRuntimeProjectAttachmentMethod;
    if ((getDeleteRuntimeProjectAttachmentMethod =
            RuntimeProjectAttachmentServiceGrpc.getDeleteRuntimeProjectAttachmentMethod)
        == null) {
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        if ((getDeleteRuntimeProjectAttachmentMethod =
                RuntimeProjectAttachmentServiceGrpc.getDeleteRuntimeProjectAttachmentMethod)
            == null) {
          RuntimeProjectAttachmentServiceGrpc.getDeleteRuntimeProjectAttachmentMethod =
              getDeleteRuntimeProjectAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteRuntimeProjectAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceMethodDescriptorSupplier(
                              "DeleteRuntimeProjectAttachment"))
                      .build();
        }
      }
    }
    return getDeleteRuntimeProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
      getLookupRuntimeProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupRuntimeProjectAttachment",
      requestType = com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest.class,
      responseType = com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest,
          com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
      getLookupRuntimeProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest,
            com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
        getLookupRuntimeProjectAttachmentMethod;
    if ((getLookupRuntimeProjectAttachmentMethod =
            RuntimeProjectAttachmentServiceGrpc.getLookupRuntimeProjectAttachmentMethod)
        == null) {
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        if ((getLookupRuntimeProjectAttachmentMethod =
                RuntimeProjectAttachmentServiceGrpc.getLookupRuntimeProjectAttachmentMethod)
            == null) {
          RuntimeProjectAttachmentServiceGrpc.getLookupRuntimeProjectAttachmentMethod =
              getLookupRuntimeProjectAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest,
                          com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "LookupRuntimeProjectAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceMethodDescriptorSupplier(
                              "LookupRuntimeProjectAttachment"))
                      .build();
        }
      }
    }
    return getLookupRuntimeProjectAttachmentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RuntimeProjectAttachmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceStub>() {
          @java.lang.Override
          public RuntimeProjectAttachmentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuntimeProjectAttachmentServiceStub(channel, callOptions);
          }
        };
    return RuntimeProjectAttachmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuntimeProjectAttachmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceBlockingStub>() {
          @java.lang.Override
          public RuntimeProjectAttachmentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuntimeProjectAttachmentServiceBlockingStub(channel, callOptions);
          }
        };
    return RuntimeProjectAttachmentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RuntimeProjectAttachmentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuntimeProjectAttachmentServiceFutureStub>() {
          @java.lang.Override
          public RuntimeProjectAttachmentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuntimeProjectAttachmentServiceFutureStub(channel, callOptions);
          }
        };
    return RuntimeProjectAttachmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used for managing the runtime project attachments.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Attaches a runtime project to the host project.
     * </pre>
     */
    default void createRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRuntimeProjectAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime project attachment.
     * </pre>
     */
    default void getRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRuntimeProjectAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List runtime projects attached to the host project.
     * </pre>
     */
    default void listRuntimeProjectAttachments(
        com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuntimeProjectAttachmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a runtime project attachment in the API Hub. This call will detach
     * the runtime project from the host project.
     * </pre>
     */
    default void deleteRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRuntimeProjectAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up a runtime project attachment. This API can be called in the context
     * of any project.
     * </pre>
     */
    default void lookupRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLookupRuntimeProjectAttachmentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RuntimeProjectAttachmentService.
   *
   * <pre>
   * This service is used for managing the runtime project attachments.
   * </pre>
   */
  public abstract static class RuntimeProjectAttachmentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RuntimeProjectAttachmentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * RuntimeProjectAttachmentService.
   *
   * <pre>
   * This service is used for managing the runtime project attachments.
   * </pre>
   */
  public static final class RuntimeProjectAttachmentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RuntimeProjectAttachmentServiceStub> {
    private RuntimeProjectAttachmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeProjectAttachmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeProjectAttachmentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Attaches a runtime project to the host project.
     * </pre>
     */
    public void createRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRuntimeProjectAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime project attachment.
     * </pre>
     */
    public void getRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuntimeProjectAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List runtime projects attached to the host project.
     * </pre>
     */
    public void listRuntimeProjectAttachments(
        com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuntimeProjectAttachmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a runtime project attachment in the API Hub. This call will detach
     * the runtime project from the host project.
     * </pre>
     */
    public void deleteRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRuntimeProjectAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Look up a runtime project attachment. This API can be called in the context
     * of any project.
     * </pre>
     */
    public void lookupRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupRuntimeProjectAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RuntimeProjectAttachmentService.
   *
   * <pre>
   * This service is used for managing the runtime project attachments.
   * </pre>
   */
  public static final class RuntimeProjectAttachmentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RuntimeProjectAttachmentServiceBlockingStub> {
    private RuntimeProjectAttachmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeProjectAttachmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeProjectAttachmentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Attaches a runtime project to the host project.
     * </pre>
     */
    public com.google.cloud.apihub.v1.RuntimeProjectAttachment createRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRuntimeProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime project attachment.
     * </pre>
     */
    public com.google.cloud.apihub.v1.RuntimeProjectAttachment getRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuntimeProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List runtime projects attached to the host project.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse
        listRuntimeProjectAttachments(
            com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuntimeProjectAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a runtime project attachment in the API Hub. This call will detach
     * the runtime project from the host project.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRuntimeProjectAttachment(
        com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRuntimeProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Look up a runtime project attachment. This API can be called in the context
     * of any project.
     * </pre>
     */
    public com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse
        lookupRuntimeProjectAttachment(
            com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupRuntimeProjectAttachmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * RuntimeProjectAttachmentService.
   *
   * <pre>
   * This service is used for managing the runtime project attachments.
   * </pre>
   */
  public static final class RuntimeProjectAttachmentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RuntimeProjectAttachmentServiceFutureStub> {
    private RuntimeProjectAttachmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuntimeProjectAttachmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuntimeProjectAttachmentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Attaches a runtime project to the host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.RuntimeProjectAttachment>
        createRuntimeProjectAttachment(
            com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRuntimeProjectAttachmentMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a runtime project attachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.RuntimeProjectAttachment>
        getRuntimeProjectAttachment(
            com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuntimeProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List runtime projects attached to the host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>
        listRuntimeProjectAttachments(
            com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuntimeProjectAttachmentsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Delete a runtime project attachment in the API Hub. This call will detach
     * the runtime project from the host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRuntimeProjectAttachment(
            com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRuntimeProjectAttachmentMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Look up a runtime project attachment. This API can be called in the context
     * of any project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>
        lookupRuntimeProjectAttachment(
            com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupRuntimeProjectAttachmentMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_RUNTIME_PROJECT_ATTACHMENT = 0;
  private static final int METHODID_GET_RUNTIME_PROJECT_ATTACHMENT = 1;
  private static final int METHODID_LIST_RUNTIME_PROJECT_ATTACHMENTS = 2;
  private static final int METHODID_DELETE_RUNTIME_PROJECT_ATTACHMENT = 3;
  private static final int METHODID_LOOKUP_RUNTIME_PROJECT_ATTACHMENT = 4;

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
        case METHODID_CREATE_RUNTIME_PROJECT_ATTACHMENT:
          serviceImpl.createRuntimeProjectAttachment(
              (com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>)
                  responseObserver);
          break;
        case METHODID_GET_RUNTIME_PROJECT_ATTACHMENT:
          serviceImpl.getRuntimeProjectAttachment(
              (com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.RuntimeProjectAttachment>)
                  responseObserver);
          break;
        case METHODID_LIST_RUNTIME_PROJECT_ATTACHMENTS:
          serviceImpl.listRuntimeProjectAttachments(
              (com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_RUNTIME_PROJECT_ATTACHMENT:
          serviceImpl.deleteRuntimeProjectAttachment(
              (com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOOKUP_RUNTIME_PROJECT_ATTACHMENT:
          serviceImpl.lookupRuntimeProjectAttachment(
              (com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>)
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
            getCreateRuntimeProjectAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateRuntimeProjectAttachmentRequest,
                    com.google.cloud.apihub.v1.RuntimeProjectAttachment>(
                    service, METHODID_CREATE_RUNTIME_PROJECT_ATTACHMENT)))
        .addMethod(
            getGetRuntimeProjectAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetRuntimeProjectAttachmentRequest,
                    com.google.cloud.apihub.v1.RuntimeProjectAttachment>(
                    service, METHODID_GET_RUNTIME_PROJECT_ATTACHMENT)))
        .addMethod(
            getListRuntimeProjectAttachmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsRequest,
                    com.google.cloud.apihub.v1.ListRuntimeProjectAttachmentsResponse>(
                    service, METHODID_LIST_RUNTIME_PROJECT_ATTACHMENTS)))
        .addMethod(
            getDeleteRuntimeProjectAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.DeleteRuntimeProjectAttachmentRequest,
                    com.google.protobuf.Empty>(
                    service, METHODID_DELETE_RUNTIME_PROJECT_ATTACHMENT)))
        .addMethod(
            getLookupRuntimeProjectAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentRequest,
                    com.google.cloud.apihub.v1.LookupRuntimeProjectAttachmentResponse>(
                    service, METHODID_LOOKUP_RUNTIME_PROJECT_ATTACHMENT)))
        .build();
  }

  private abstract static class RuntimeProjectAttachmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuntimeProjectAttachmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.RuntimeProjectAttachmentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuntimeProjectAttachmentService");
    }
  }

  private static final class RuntimeProjectAttachmentServiceFileDescriptorSupplier
      extends RuntimeProjectAttachmentServiceBaseDescriptorSupplier {
    RuntimeProjectAttachmentServiceFileDescriptorSupplier() {}
  }

  private static final class RuntimeProjectAttachmentServiceMethodDescriptorSupplier
      extends RuntimeProjectAttachmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RuntimeProjectAttachmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RuntimeProjectAttachmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new RuntimeProjectAttachmentServiceFileDescriptorSupplier())
                      .addMethod(getCreateRuntimeProjectAttachmentMethod())
                      .addMethod(getGetRuntimeProjectAttachmentMethod())
                      .addMethod(getListRuntimeProjectAttachmentsMethod())
                      .addMethod(getDeleteRuntimeProjectAttachmentMethod())
                      .addMethod(getLookupRuntimeProjectAttachmentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
