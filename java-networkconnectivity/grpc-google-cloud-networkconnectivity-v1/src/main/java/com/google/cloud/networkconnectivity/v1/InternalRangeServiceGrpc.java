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
package com.google.cloud.networkconnectivity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The CLH-based service for internal range resources used to perform IPAM
 * operations within a VPC network.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkconnectivity/v1/internal_range.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InternalRangeServiceGrpc {

  private InternalRangeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1.InternalRangeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest,
          com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
      getListInternalRangesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInternalRanges",
      requestType = com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest,
          com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
      getListInternalRangesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest,
            com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
        getListInternalRangesMethod;
    if ((getListInternalRangesMethod = InternalRangeServiceGrpc.getListInternalRangesMethod)
        == null) {
      synchronized (InternalRangeServiceGrpc.class) {
        if ((getListInternalRangesMethod = InternalRangeServiceGrpc.getListInternalRangesMethod)
            == null) {
          InternalRangeServiceGrpc.getListInternalRangesMethod =
              getListInternalRangesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest,
                          com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInternalRanges"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InternalRangeServiceMethodDescriptorSupplier("ListInternalRanges"))
                      .build();
        }
      }
    }
    return getListInternalRangesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest,
          com.google.cloud.networkconnectivity.v1.InternalRange>
      getGetInternalRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInternalRange",
      requestType = com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.InternalRange.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest,
          com.google.cloud.networkconnectivity.v1.InternalRange>
      getGetInternalRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest,
            com.google.cloud.networkconnectivity.v1.InternalRange>
        getGetInternalRangeMethod;
    if ((getGetInternalRangeMethod = InternalRangeServiceGrpc.getGetInternalRangeMethod) == null) {
      synchronized (InternalRangeServiceGrpc.class) {
        if ((getGetInternalRangeMethod = InternalRangeServiceGrpc.getGetInternalRangeMethod)
            == null) {
          InternalRangeServiceGrpc.getGetInternalRangeMethod =
              getGetInternalRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest,
                          com.google.cloud.networkconnectivity.v1.InternalRange>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInternalRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.InternalRange
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InternalRangeServiceMethodDescriptorSupplier("GetInternalRange"))
                      .build();
        }
      }
    }
    return getGetInternalRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest,
          com.google.longrunning.Operation>
      getCreateInternalRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInternalRange",
      requestType = com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest,
          com.google.longrunning.Operation>
      getCreateInternalRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest,
            com.google.longrunning.Operation>
        getCreateInternalRangeMethod;
    if ((getCreateInternalRangeMethod = InternalRangeServiceGrpc.getCreateInternalRangeMethod)
        == null) {
      synchronized (InternalRangeServiceGrpc.class) {
        if ((getCreateInternalRangeMethod = InternalRangeServiceGrpc.getCreateInternalRangeMethod)
            == null) {
          InternalRangeServiceGrpc.getCreateInternalRangeMethod =
              getCreateInternalRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateInternalRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InternalRangeServiceMethodDescriptorSupplier("CreateInternalRange"))
                      .build();
        }
      }
    }
    return getCreateInternalRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest,
          com.google.longrunning.Operation>
      getUpdateInternalRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInternalRange",
      requestType = com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest,
          com.google.longrunning.Operation>
      getUpdateInternalRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest,
            com.google.longrunning.Operation>
        getUpdateInternalRangeMethod;
    if ((getUpdateInternalRangeMethod = InternalRangeServiceGrpc.getUpdateInternalRangeMethod)
        == null) {
      synchronized (InternalRangeServiceGrpc.class) {
        if ((getUpdateInternalRangeMethod = InternalRangeServiceGrpc.getUpdateInternalRangeMethod)
            == null) {
          InternalRangeServiceGrpc.getUpdateInternalRangeMethod =
              getUpdateInternalRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateInternalRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InternalRangeServiceMethodDescriptorSupplier("UpdateInternalRange"))
                      .build();
        }
      }
    }
    return getUpdateInternalRangeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest,
          com.google.longrunning.Operation>
      getDeleteInternalRangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInternalRange",
      requestType = com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest,
          com.google.longrunning.Operation>
      getDeleteInternalRangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest,
            com.google.longrunning.Operation>
        getDeleteInternalRangeMethod;
    if ((getDeleteInternalRangeMethod = InternalRangeServiceGrpc.getDeleteInternalRangeMethod)
        == null) {
      synchronized (InternalRangeServiceGrpc.class) {
        if ((getDeleteInternalRangeMethod = InternalRangeServiceGrpc.getDeleteInternalRangeMethod)
            == null) {
          InternalRangeServiceGrpc.getDeleteInternalRangeMethod =
              getDeleteInternalRangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteInternalRange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new InternalRangeServiceMethodDescriptorSupplier("DeleteInternalRange"))
                      .build();
        }
      }
    }
    return getDeleteInternalRangeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static InternalRangeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceStub>() {
          @java.lang.Override
          public InternalRangeServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InternalRangeServiceStub(channel, callOptions);
          }
        };
    return InternalRangeServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static InternalRangeServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceBlockingV2Stub>() {
          @java.lang.Override
          public InternalRangeServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InternalRangeServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return InternalRangeServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InternalRangeServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceBlockingStub>() {
          @java.lang.Override
          public InternalRangeServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InternalRangeServiceBlockingStub(channel, callOptions);
          }
        };
    return InternalRangeServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static InternalRangeServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<InternalRangeServiceFutureStub>() {
          @java.lang.Override
          public InternalRangeServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new InternalRangeServiceFutureStub(channel, callOptions);
          }
        };
    return InternalRangeServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists internal ranges in a given project and location.
     * </pre>
     */
    default void listInternalRanges(
        com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInternalRangesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single internal range.
     * </pre>
     */
    default void getInternalRange(
        com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.InternalRange>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInternalRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new internal range in a given project and location.
     * </pre>
     */
    default void createInternalRange(
        com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInternalRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single internal range.
     * </pre>
     */
    default void updateInternalRange(
        com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInternalRangeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single internal range.
     * </pre>
     */
    default void deleteInternalRange(
        com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInternalRangeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InternalRangeService.
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public abstract static class InternalRangeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return InternalRangeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InternalRangeService.
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public static final class InternalRangeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InternalRangeServiceStub> {
    private InternalRangeServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InternalRangeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InternalRangeServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists internal ranges in a given project and location.
     * </pre>
     */
    public void listInternalRanges(
        com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInternalRangesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single internal range.
     * </pre>
     */
    public void getInternalRange(
        com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.InternalRange>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInternalRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new internal range in a given project and location.
     * </pre>
     */
    public void createInternalRange(
        com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInternalRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single internal range.
     * </pre>
     */
    public void updateInternalRange(
        com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInternalRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single internal range.
     * </pre>
     */
    public void deleteInternalRange(
        com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInternalRangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InternalRangeService.
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public static final class InternalRangeServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<InternalRangeServiceBlockingV2Stub> {
    private InternalRangeServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InternalRangeServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InternalRangeServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists internal ranges in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse listInternalRanges(
        com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInternalRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single internal range.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.InternalRange getInternalRange(
        com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new internal range in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInternalRange(
        com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single internal range.
     * </pre>
     */
    public com.google.longrunning.Operation updateInternalRange(
        com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single internal range.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInternalRange(
        com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInternalRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service InternalRangeService.
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public static final class InternalRangeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InternalRangeServiceBlockingStub> {
    private InternalRangeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InternalRangeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InternalRangeServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists internal ranges in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse listInternalRanges(
        com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInternalRangesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single internal range.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.InternalRange getInternalRange(
        com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new internal range in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInternalRange(
        com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single internal range.
     * </pre>
     */
    public com.google.longrunning.Operation updateInternalRange(
        com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInternalRangeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single internal range.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInternalRange(
        com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInternalRangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InternalRangeService.
   *
   * <pre>
   * The CLH-based service for internal range resources used to perform IPAM
   * operations within a VPC network.
   * </pre>
   */
  public static final class InternalRangeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InternalRangeServiceFutureStub> {
    private InternalRangeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InternalRangeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InternalRangeServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists internal ranges in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>
        listInternalRanges(
            com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInternalRangesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single internal range.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.InternalRange>
        getInternalRange(com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInternalRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new internal range in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInternalRange(
            com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInternalRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single internal range.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInternalRange(
            com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInternalRangeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single internal range.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInternalRange(
            com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInternalRangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INTERNAL_RANGES = 0;
  private static final int METHODID_GET_INTERNAL_RANGE = 1;
  private static final int METHODID_CREATE_INTERNAL_RANGE = 2;
  private static final int METHODID_UPDATE_INTERNAL_RANGE = 3;
  private static final int METHODID_DELETE_INTERNAL_RANGE = 4;

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
        case METHODID_LIST_INTERNAL_RANGES:
          serviceImpl.listInternalRanges(
              (com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INTERNAL_RANGE:
          serviceImpl.getInternalRange(
              (com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.InternalRange>)
                  responseObserver);
          break;
        case METHODID_CREATE_INTERNAL_RANGE:
          serviceImpl.createInternalRange(
              (com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INTERNAL_RANGE:
          serviceImpl.updateInternalRange(
              (com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INTERNAL_RANGE:
          serviceImpl.deleteInternalRange(
              (com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest) request,
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
            getListInternalRangesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListInternalRangesRequest,
                    com.google.cloud.networkconnectivity.v1.ListInternalRangesResponse>(
                    service, METHODID_LIST_INTERNAL_RANGES)))
        .addMethod(
            getGetInternalRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetInternalRangeRequest,
                    com.google.cloud.networkconnectivity.v1.InternalRange>(
                    service, METHODID_GET_INTERNAL_RANGE)))
        .addMethod(
            getCreateInternalRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreateInternalRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INTERNAL_RANGE)))
        .addMethod(
            getUpdateInternalRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.UpdateInternalRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INTERNAL_RANGE)))
        .addMethod(
            getDeleteInternalRangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeleteInternalRangeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INTERNAL_RANGE)))
        .build();
  }

  private abstract static class InternalRangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InternalRangeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1.InternalRangeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InternalRangeService");
    }
  }

  private static final class InternalRangeServiceFileDescriptorSupplier
      extends InternalRangeServiceBaseDescriptorSupplier {
    InternalRangeServiceFileDescriptorSupplier() {}
  }

  private static final class InternalRangeServiceMethodDescriptorSupplier
      extends InternalRangeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InternalRangeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InternalRangeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new InternalRangeServiceFileDescriptorSupplier())
                      .addMethod(getListInternalRangesMethod())
                      .addMethod(getGetInternalRangeMethod())
                      .addMethod(getCreateInternalRangeMethod())
                      .addMethod(getUpdateInternalRangeMethod())
                      .addMethod(getDeleteInternalRangeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
