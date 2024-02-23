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
package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Allow users to create and manage TagHolds for TagValues. TagHolds represent
 * the use of a Tag Value that is not captured by TagBindings but
 * should still block TagValue deletion (such as a reference in a policy
 * condition). This service provides isolated failure domains by cloud location
 * so that TagHolds can be managed in the same location as their usage.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/tag_holds.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TagHoldsGrpc {

  private TagHoldsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.resourcemanager.v3.TagHolds";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagHoldRequest,
          com.google.longrunning.Operation>
      getCreateTagHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTagHold",
      requestType = com.google.cloud.resourcemanager.v3.CreateTagHoldRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateTagHoldRequest,
          com.google.longrunning.Operation>
      getCreateTagHoldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.CreateTagHoldRequest,
            com.google.longrunning.Operation>
        getCreateTagHoldMethod;
    if ((getCreateTagHoldMethod = TagHoldsGrpc.getCreateTagHoldMethod) == null) {
      synchronized (TagHoldsGrpc.class) {
        if ((getCreateTagHoldMethod = TagHoldsGrpc.getCreateTagHoldMethod) == null) {
          TagHoldsGrpc.getCreateTagHoldMethod =
              getCreateTagHoldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.CreateTagHoldRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTagHold"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.CreateTagHoldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TagHoldsMethodDescriptorSupplier("CreateTagHold"))
                      .build();
        }
      }
    }
    return getCreateTagHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest,
          com.google.longrunning.Operation>
      getDeleteTagHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTagHold",
      requestType = com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest,
          com.google.longrunning.Operation>
      getDeleteTagHoldMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest,
            com.google.longrunning.Operation>
        getDeleteTagHoldMethod;
    if ((getDeleteTagHoldMethod = TagHoldsGrpc.getDeleteTagHoldMethod) == null) {
      synchronized (TagHoldsGrpc.class) {
        if ((getDeleteTagHoldMethod = TagHoldsGrpc.getDeleteTagHoldMethod) == null) {
          TagHoldsGrpc.getDeleteTagHoldMethod =
              getDeleteTagHoldMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTagHold"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TagHoldsMethodDescriptorSupplier("DeleteTagHold"))
                      .build();
        }
      }
    }
    return getDeleteTagHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagHoldsRequest,
          com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
      getListTagHoldsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTagHolds",
      requestType = com.google.cloud.resourcemanager.v3.ListTagHoldsRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListTagHoldsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListTagHoldsRequest,
          com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
      getListTagHoldsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.ListTagHoldsRequest,
            com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
        getListTagHoldsMethod;
    if ((getListTagHoldsMethod = TagHoldsGrpc.getListTagHoldsMethod) == null) {
      synchronized (TagHoldsGrpc.class) {
        if ((getListTagHoldsMethod = TagHoldsGrpc.getListTagHoldsMethod) == null) {
          TagHoldsGrpc.getListTagHoldsMethod =
              getListTagHoldsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.ListTagHoldsRequest,
                          com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTagHolds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagHoldsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListTagHoldsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TagHoldsMethodDescriptorSupplier("ListTagHolds"))
                      .build();
        }
      }
    }
    return getListTagHoldsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TagHoldsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagHoldsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagHoldsStub>() {
          @java.lang.Override
          public TagHoldsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagHoldsStub(channel, callOptions);
          }
        };
    return TagHoldsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TagHoldsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagHoldsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagHoldsBlockingStub>() {
          @java.lang.Override
          public TagHoldsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagHoldsBlockingStub(channel, callOptions);
          }
        };
    return TagHoldsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TagHoldsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TagHoldsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TagHoldsFutureStub>() {
          @java.lang.Override
          public TagHoldsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TagHoldsFutureStub(channel, callOptions);
          }
        };
    return TagHoldsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Allow users to create and manage TagHolds for TagValues. TagHolds represent
   * the use of a Tag Value that is not captured by TagBindings but
   * should still block TagValue deletion (such as a reference in a policy
   * condition). This service provides isolated failure domains by cloud location
   * so that TagHolds can be managed in the same location as their usage.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same
     * resource and origin exists under the same TagValue.
     * </pre>
     */
    default void createTagHold(
        com.google.cloud.resourcemanager.v3.CreateTagHoldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTagHoldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagHold.
     * </pre>
     */
    default void deleteTagHold(
        com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTagHoldMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TagHolds under a TagValue.
     * </pre>
     */
    default void listTagHolds(
        com.google.cloud.resourcemanager.v3.ListTagHoldsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTagHoldsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TagHolds.
   *
   * <pre>
   * Allow users to create and manage TagHolds for TagValues. TagHolds represent
   * the use of a Tag Value that is not captured by TagBindings but
   * should still block TagValue deletion (such as a reference in a policy
   * condition). This service provides isolated failure domains by cloud location
   * so that TagHolds can be managed in the same location as their usage.
   * </pre>
   */
  public abstract static class TagHoldsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return TagHoldsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TagHolds.
   *
   * <pre>
   * Allow users to create and manage TagHolds for TagValues. TagHolds represent
   * the use of a Tag Value that is not captured by TagBindings but
   * should still block TagValue deletion (such as a reference in a policy
   * condition). This service provides isolated failure domains by cloud location
   * so that TagHolds can be managed in the same location as their usage.
   * </pre>
   */
  public static final class TagHoldsStub extends io.grpc.stub.AbstractAsyncStub<TagHoldsStub> {
    private TagHoldsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagHoldsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagHoldsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same
     * resource and origin exists under the same TagValue.
     * </pre>
     */
    public void createTagHold(
        com.google.cloud.resourcemanager.v3.CreateTagHoldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagHoldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagHold.
     * </pre>
     */
    public void deleteTagHold(
        com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagHoldMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists TagHolds under a TagValue.
     * </pre>
     */
    public void listTagHolds(
        com.google.cloud.resourcemanager.v3.ListTagHoldsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagHoldsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TagHolds.
   *
   * <pre>
   * Allow users to create and manage TagHolds for TagValues. TagHolds represent
   * the use of a Tag Value that is not captured by TagBindings but
   * should still block TagValue deletion (such as a reference in a policy
   * condition). This service provides isolated failure domains by cloud location
   * so that TagHolds can be managed in the same location as their usage.
   * </pre>
   */
  public static final class TagHoldsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TagHoldsBlockingStub> {
    private TagHoldsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagHoldsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagHoldsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same
     * resource and origin exists under the same TagValue.
     * </pre>
     */
    public com.google.longrunning.Operation createTagHold(
        com.google.cloud.resourcemanager.v3.CreateTagHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagHoldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagHold.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTagHold(
        com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagHoldMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TagHolds under a TagValue.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListTagHoldsResponse listTagHolds(
        com.google.cloud.resourcemanager.v3.ListTagHoldsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagHoldsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TagHolds.
   *
   * <pre>
   * Allow users to create and manage TagHolds for TagValues. TagHolds represent
   * the use of a Tag Value that is not captured by TagBindings but
   * should still block TagValue deletion (such as a reference in a policy
   * condition). This service provides isolated failure domains by cloud location
   * so that TagHolds can be managed in the same location as their usage.
   * </pre>
   */
  public static final class TagHoldsFutureStub
      extends io.grpc.stub.AbstractFutureStub<TagHoldsFutureStub> {
    private TagHoldsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TagHoldsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TagHoldsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a TagHold. Returns ALREADY_EXISTS if a TagHold with the same
     * resource and origin exists under the same TagValue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTagHold(com.google.cloud.resourcemanager.v3.CreateTagHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagHoldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a TagHold.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTagHold(com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagHoldMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists TagHolds under a TagValue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>
        listTagHolds(com.google.cloud.resourcemanager.v3.ListTagHoldsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagHoldsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TAG_HOLD = 0;
  private static final int METHODID_DELETE_TAG_HOLD = 1;
  private static final int METHODID_LIST_TAG_HOLDS = 2;

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
        case METHODID_CREATE_TAG_HOLD:
          serviceImpl.createTagHold(
              (com.google.cloud.resourcemanager.v3.CreateTagHoldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TAG_HOLD:
          serviceImpl.deleteTagHold(
              (com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TAG_HOLDS:
          serviceImpl.listTagHolds(
              (com.google.cloud.resourcemanager.v3.ListTagHoldsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>)
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
            getCreateTagHoldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.resourcemanager.v3.CreateTagHoldRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TAG_HOLD)))
        .addMethod(
            getDeleteTagHoldMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.resourcemanager.v3.DeleteTagHoldRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TAG_HOLD)))
        .addMethod(
            getListTagHoldsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.resourcemanager.v3.ListTagHoldsRequest,
                    com.google.cloud.resourcemanager.v3.ListTagHoldsResponse>(
                    service, METHODID_LIST_TAG_HOLDS)))
        .build();
  }

  private abstract static class TagHoldsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TagHoldsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.TagHoldsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TagHolds");
    }
  }

  private static final class TagHoldsFileDescriptorSupplier extends TagHoldsBaseDescriptorSupplier {
    TagHoldsFileDescriptorSupplier() {}
  }

  private static final class TagHoldsMethodDescriptorSupplier extends TagHoldsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TagHoldsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TagHoldsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TagHoldsFileDescriptorSupplier())
                      .addMethod(getCreateTagHoldMethod())
                      .addMethod(getDeleteTagHoldMethod())
                      .addMethod(getListTagHoldsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
