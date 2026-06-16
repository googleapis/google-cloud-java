/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.networksecurity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SSERealmServiceGrpc {

  private SSERealmServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networksecurity.v1.SSERealmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSACRealmsRequest,
          com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
      getListSACRealmsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSACRealms",
      requestType = com.google.cloud.networksecurity.v1.ListSACRealmsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListSACRealmsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSACRealmsRequest,
          com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
      getListSACRealmsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListSACRealmsRequest,
            com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
        getListSACRealmsMethod;
    if ((getListSACRealmsMethod = SSERealmServiceGrpc.getListSACRealmsMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getListSACRealmsMethod = SSERealmServiceGrpc.getListSACRealmsMethod) == null) {
          SSERealmServiceGrpc.getListSACRealmsMethod =
              getListSACRealmsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListSACRealmsRequest,
                          com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSACRealms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSACRealmsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSACRealmsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("ListSACRealms"))
                      .build();
        }
      }
    }
    return getListSACRealmsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSACRealmRequest,
          com.google.cloud.networksecurity.v1.SACRealm>
      getGetSACRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSACRealm",
      requestType = com.google.cloud.networksecurity.v1.GetSACRealmRequest.class,
      responseType = com.google.cloud.networksecurity.v1.SACRealm.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSACRealmRequest,
          com.google.cloud.networksecurity.v1.SACRealm>
      getGetSACRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetSACRealmRequest,
            com.google.cloud.networksecurity.v1.SACRealm>
        getGetSACRealmMethod;
    if ((getGetSACRealmMethod = SSERealmServiceGrpc.getGetSACRealmMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getGetSACRealmMethod = SSERealmServiceGrpc.getGetSACRealmMethod) == null) {
          SSERealmServiceGrpc.getGetSACRealmMethod =
              getGetSACRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetSACRealmRequest,
                          com.google.cloud.networksecurity.v1.SACRealm>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSACRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetSACRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.SACRealm.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("GetSACRealm"))
                      .build();
        }
      }
    }
    return getGetSACRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSACRealmRequest,
          com.google.longrunning.Operation>
      getCreateSACRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSACRealm",
      requestType = com.google.cloud.networksecurity.v1.CreateSACRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSACRealmRequest,
          com.google.longrunning.Operation>
      getCreateSACRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateSACRealmRequest,
            com.google.longrunning.Operation>
        getCreateSACRealmMethod;
    if ((getCreateSACRealmMethod = SSERealmServiceGrpc.getCreateSACRealmMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getCreateSACRealmMethod = SSERealmServiceGrpc.getCreateSACRealmMethod) == null) {
          SSERealmServiceGrpc.getCreateSACRealmMethod =
              getCreateSACRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateSACRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSACRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateSACRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("CreateSACRealm"))
                      .build();
        }
      }
    }
    return getCreateSACRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSACRealmRequest,
          com.google.longrunning.Operation>
      getDeleteSACRealmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSACRealm",
      requestType = com.google.cloud.networksecurity.v1.DeleteSACRealmRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSACRealmRequest,
          com.google.longrunning.Operation>
      getDeleteSACRealmMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteSACRealmRequest,
            com.google.longrunning.Operation>
        getDeleteSACRealmMethod;
    if ((getDeleteSACRealmMethod = SSERealmServiceGrpc.getDeleteSACRealmMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getDeleteSACRealmMethod = SSERealmServiceGrpc.getDeleteSACRealmMethod) == null) {
          SSERealmServiceGrpc.getDeleteSACRealmMethod =
              getDeleteSACRealmMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteSACRealmRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSACRealm"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteSACRealmRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("DeleteSACRealm"))
                      .build();
        }
      }
    }
    return getDeleteSACRealmMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest,
          com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
      getListSACAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSACAttachments",
      requestType = com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest.class,
      responseType = com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest,
          com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
      getListSACAttachmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest,
            com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
        getListSACAttachmentsMethod;
    if ((getListSACAttachmentsMethod = SSERealmServiceGrpc.getListSACAttachmentsMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getListSACAttachmentsMethod = SSERealmServiceGrpc.getListSACAttachmentsMethod)
            == null) {
          SSERealmServiceGrpc.getListSACAttachmentsMethod =
              getListSACAttachmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest,
                          com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSACAttachments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("ListSACAttachments"))
                      .build();
        }
      }
    }
    return getListSACAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSACAttachmentRequest,
          com.google.cloud.networksecurity.v1.SACAttachment>
      getGetSACAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSACAttachment",
      requestType = com.google.cloud.networksecurity.v1.GetSACAttachmentRequest.class,
      responseType = com.google.cloud.networksecurity.v1.SACAttachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.GetSACAttachmentRequest,
          com.google.cloud.networksecurity.v1.SACAttachment>
      getGetSACAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.GetSACAttachmentRequest,
            com.google.cloud.networksecurity.v1.SACAttachment>
        getGetSACAttachmentMethod;
    if ((getGetSACAttachmentMethod = SSERealmServiceGrpc.getGetSACAttachmentMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getGetSACAttachmentMethod = SSERealmServiceGrpc.getGetSACAttachmentMethod) == null) {
          SSERealmServiceGrpc.getGetSACAttachmentMethod =
              getGetSACAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.GetSACAttachmentRequest,
                          com.google.cloud.networksecurity.v1.SACAttachment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSACAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.GetSACAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.SACAttachment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("GetSACAttachment"))
                      .build();
        }
      }
    }
    return getGetSACAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest,
          com.google.longrunning.Operation>
      getCreateSACAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSACAttachment",
      requestType = com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest,
          com.google.longrunning.Operation>
      getCreateSACAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest,
            com.google.longrunning.Operation>
        getCreateSACAttachmentMethod;
    if ((getCreateSACAttachmentMethod = SSERealmServiceGrpc.getCreateSACAttachmentMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getCreateSACAttachmentMethod = SSERealmServiceGrpc.getCreateSACAttachmentMethod)
            == null) {
          SSERealmServiceGrpc.getCreateSACAttachmentMethod =
              getCreateSACAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateSACAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("CreateSACAttachment"))
                      .build();
        }
      }
    }
    return getCreateSACAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest,
          com.google.longrunning.Operation>
      getDeleteSACAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSACAttachment",
      requestType = com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest,
          com.google.longrunning.Operation>
      getDeleteSACAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest,
            com.google.longrunning.Operation>
        getDeleteSACAttachmentMethod;
    if ((getDeleteSACAttachmentMethod = SSERealmServiceGrpc.getDeleteSACAttachmentMethod) == null) {
      synchronized (SSERealmServiceGrpc.class) {
        if ((getDeleteSACAttachmentMethod = SSERealmServiceGrpc.getDeleteSACAttachmentMethod)
            == null) {
          SSERealmServiceGrpc.getDeleteSACAttachmentMethod =
              getDeleteSACAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSACAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SSERealmServiceMethodDescriptorSupplier("DeleteSACAttachment"))
                      .build();
        }
      }
    }
    return getDeleteSACAttachmentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SSERealmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceStub>() {
          @java.lang.Override
          public SSERealmServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SSERealmServiceStub(channel, callOptions);
          }
        };
    return SSERealmServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SSERealmServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceBlockingV2Stub>() {
          @java.lang.Override
          public SSERealmServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SSERealmServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SSERealmServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SSERealmServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceBlockingStub>() {
          @java.lang.Override
          public SSERealmServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SSERealmServiceBlockingStub(channel, callOptions);
          }
        };
    return SSERealmServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SSERealmServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SSERealmServiceFutureStub>() {
          @java.lang.Override
          public SSERealmServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SSERealmServiceFutureStub(channel, callOptions);
          }
        };
    return SSERealmServiceFutureStub.newStub(factory, channel);
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
     * Lists SACRealms in a given project.
     * </pre>
     */
    default void listSACRealms(
        com.google.cloud.networksecurity.v1.ListSACRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSACRealmsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified realm.
     * </pre>
     */
    default void getSACRealm(
        com.google.cloud.networksecurity.v1.GetSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACRealm>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSACRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACRealm in a given project.
     * </pre>
     */
    default void createSACRealm(
        com.google.cloud.networksecurity.v1.CreateSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSACRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified realm.
     * </pre>
     */
    default void deleteSACRealm(
        com.google.cloud.networksecurity.v1.DeleteSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSACRealmMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SACAttachments in a given project and location.
     * </pre>
     */
    default void listSACAttachments(
        com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSACAttachmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified attachment.
     * </pre>
     */
    default void getSACAttachment(
        com.google.cloud.networksecurity.v1.GetSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACAttachment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSACAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACAttachment in a given project and location.
     * </pre>
     */
    default void createSACAttachment(
        com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSACAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified attachment.
     * </pre>
     */
    default void deleteSACAttachment(
        com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSACAttachmentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SSERealmService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class SSERealmServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SSERealmServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SSERealmService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SSERealmServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SSERealmServiceStub> {
    private SSERealmServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SSERealmServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SSERealmServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SACRealms in a given project.
     * </pre>
     */
    public void listSACRealms(
        com.google.cloud.networksecurity.v1.ListSACRealmsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSACRealmsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified realm.
     * </pre>
     */
    public void getSACRealm(
        com.google.cloud.networksecurity.v1.GetSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACRealm>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSACRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACRealm in a given project.
     * </pre>
     */
    public void createSACRealm(
        com.google.cloud.networksecurity.v1.CreateSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSACRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified realm.
     * </pre>
     */
    public void deleteSACRealm(
        com.google.cloud.networksecurity.v1.DeleteSACRealmRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSACRealmMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists SACAttachments in a given project and location.
     * </pre>
     */
    public void listSACAttachments(
        com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSACAttachmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified attachment.
     * </pre>
     */
    public void getSACAttachment(
        com.google.cloud.networksecurity.v1.GetSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACAttachment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSACAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACAttachment in a given project and location.
     * </pre>
     */
    public void createSACAttachment(
        com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSACAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified attachment.
     * </pre>
     */
    public void deleteSACAttachment(
        com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSACAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SSERealmService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SSERealmServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SSERealmServiceBlockingV2Stub> {
    private SSERealmServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SSERealmServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SSERealmServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SACRealms in a given project.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSACRealmsResponse listSACRealms(
        com.google.cloud.networksecurity.v1.ListSACRealmsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSACRealmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified realm.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SACRealm getSACRealm(
        com.google.cloud.networksecurity.v1.GetSACRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACRealm in a given project.
     * </pre>
     */
    public com.google.longrunning.Operation createSACRealm(
        com.google.cloud.networksecurity.v1.CreateSACRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSACRealm(
        com.google.cloud.networksecurity.v1.DeleteSACRealmRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SACAttachments in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse listSACAttachments(
        com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSACAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified attachment.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SACAttachment getSACAttachment(
        com.google.cloud.networksecurity.v1.GetSACAttachmentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSACAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACAttachment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSACAttachment(
        com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSACAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified attachment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSACAttachment(
        com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSACAttachmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SSERealmService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SSERealmServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SSERealmServiceBlockingStub> {
    private SSERealmServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SSERealmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SSERealmServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SACRealms in a given project.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSACRealmsResponse listSACRealms(
        com.google.cloud.networksecurity.v1.ListSACRealmsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSACRealmsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified realm.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SACRealm getSACRealm(
        com.google.cloud.networksecurity.v1.GetSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACRealm in a given project.
     * </pre>
     */
    public com.google.longrunning.Operation createSACRealm(
        com.google.cloud.networksecurity.v1.CreateSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified realm.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSACRealm(
        com.google.cloud.networksecurity.v1.DeleteSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSACRealmMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SACAttachments in a given project and location.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse listSACAttachments(
        com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSACAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified attachment.
     * </pre>
     */
    public com.google.cloud.networksecurity.v1.SACAttachment getSACAttachment(
        com.google.cloud.networksecurity.v1.GetSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSACAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACAttachment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSACAttachment(
        com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSACAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified attachment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSACAttachment(
        com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSACAttachmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SSERealmService.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class SSERealmServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SSERealmServiceFutureStub> {
    private SSERealmServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SSERealmServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SSERealmServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists SACRealms in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListSACRealmsResponse>
        listSACRealms(com.google.cloud.networksecurity.v1.ListSACRealmsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSACRealmsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.SACRealm>
        getSACRealm(com.google.cloud.networksecurity.v1.GetSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSACRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACRealm in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSACRealm(com.google.cloud.networksecurity.v1.CreateSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSACRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified realm.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSACRealm(com.google.cloud.networksecurity.v1.DeleteSACRealmRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSACRealmMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists SACAttachments in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>
        listSACAttachments(com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSACAttachmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified attachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networksecurity.v1.SACAttachment>
        getSACAttachment(com.google.cloud.networksecurity.v1.GetSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSACAttachmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new SACAttachment in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSACAttachment(
            com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSACAttachmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified attachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSACAttachment(
            com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSACAttachmentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SACREALMS = 0;
  private static final int METHODID_GET_SACREALM = 1;
  private static final int METHODID_CREATE_SACREALM = 2;
  private static final int METHODID_DELETE_SACREALM = 3;
  private static final int METHODID_LIST_SACATTACHMENTS = 4;
  private static final int METHODID_GET_SACATTACHMENT = 5;
  private static final int METHODID_CREATE_SACATTACHMENT = 6;
  private static final int METHODID_DELETE_SACATTACHMENT = 7;

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
        case METHODID_LIST_SACREALMS:
          serviceImpl.listSACRealms(
              (com.google.cloud.networksecurity.v1.ListSACRealmsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListSACRealmsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SACREALM:
          serviceImpl.getSACRealm(
              (com.google.cloud.networksecurity.v1.GetSACRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACRealm>)
                  responseObserver);
          break;
        case METHODID_CREATE_SACREALM:
          serviceImpl.createSACRealm(
              (com.google.cloud.networksecurity.v1.CreateSACRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SACREALM:
          serviceImpl.deleteSACRealm(
              (com.google.cloud.networksecurity.v1.DeleteSACRealmRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SACATTACHMENTS:
          serviceImpl.listSACAttachments(
              (com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SACATTACHMENT:
          serviceImpl.getSACAttachment(
              (com.google.cloud.networksecurity.v1.GetSACAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networksecurity.v1.SACAttachment>)
                  responseObserver);
          break;
        case METHODID_CREATE_SACATTACHMENT:
          serviceImpl.createSACAttachment(
              (com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SACATTACHMENT:
          serviceImpl.deleteSACAttachment(
              (com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest) request,
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
            getListSACRealmsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListSACRealmsRequest,
                    com.google.cloud.networksecurity.v1.ListSACRealmsResponse>(
                    service, METHODID_LIST_SACREALMS)))
        .addMethod(
            getGetSACRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetSACRealmRequest,
                    com.google.cloud.networksecurity.v1.SACRealm>(service, METHODID_GET_SACREALM)))
        .addMethod(
            getCreateSACRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateSACRealmRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SACREALM)))
        .addMethod(
            getDeleteSACRealmMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteSACRealmRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SACREALM)))
        .addMethod(
            getListSACAttachmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.ListSACAttachmentsRequest,
                    com.google.cloud.networksecurity.v1.ListSACAttachmentsResponse>(
                    service, METHODID_LIST_SACATTACHMENTS)))
        .addMethod(
            getGetSACAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.GetSACAttachmentRequest,
                    com.google.cloud.networksecurity.v1.SACAttachment>(
                    service, METHODID_GET_SACATTACHMENT)))
        .addMethod(
            getCreateSACAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.CreateSACAttachmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SACATTACHMENT)))
        .addMethod(
            getDeleteSACAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networksecurity.v1.DeleteSACAttachmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SACATTACHMENT)))
        .build();
  }

  private abstract static class SSERealmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SSERealmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networksecurity.v1.SSERealmProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SSERealmService");
    }
  }

  private static final class SSERealmServiceFileDescriptorSupplier
      extends SSERealmServiceBaseDescriptorSupplier {
    SSERealmServiceFileDescriptorSupplier() {}
  }

  private static final class SSERealmServiceMethodDescriptorSupplier
      extends SSERealmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SSERealmServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SSERealmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SSERealmServiceFileDescriptorSupplier())
                      .addMethod(getListSACRealmsMethod())
                      .addMethod(getGetSACRealmMethod())
                      .addMethod(getCreateSACRealmMethod())
                      .addMethod(getDeleteSACRealmMethod())
                      .addMethod(getListSACAttachmentsMethod())
                      .addMethod(getGetSACAttachmentMethod())
                      .addMethod(getCreateSACAttachmentMethod())
                      .addMethod(getDeleteSACAttachmentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
