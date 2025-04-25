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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/changelog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChangelogsGrpc {

  private ChangelogsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.cx.v3beta1.Changelogs";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
      getListChangelogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChangelogs",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
      getListChangelogsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
        getListChangelogsMethod;
    if ((getListChangelogsMethod = ChangelogsGrpc.getListChangelogsMethod) == null) {
      synchronized (ChangelogsGrpc.class) {
        if ((getListChangelogsMethod = ChangelogsGrpc.getListChangelogsMethod) == null) {
          ChangelogsGrpc.getListChangelogsMethod =
              getListChangelogsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChangelogs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ChangelogsMethodDescriptorSupplier("ListChangelogs"))
                      .build();
        }
      }
    }
    return getListChangelogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Changelog>
      getGetChangelogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChangelog",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.Changelog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest,
          com.google.cloud.dialogflow.cx.v3beta1.Changelog>
      getGetChangelogMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest,
            com.google.cloud.dialogflow.cx.v3beta1.Changelog>
        getGetChangelogMethod;
    if ((getGetChangelogMethod = ChangelogsGrpc.getGetChangelogMethod) == null) {
      synchronized (ChangelogsGrpc.class) {
        if ((getGetChangelogMethod = ChangelogsGrpc.getGetChangelogMethod) == null) {
          ChangelogsGrpc.getGetChangelogMethod =
              getGetChangelogMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.Changelog>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChangelog"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.Changelog
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ChangelogsMethodDescriptorSupplier("GetChangelog"))
                      .build();
        }
      }
    }
    return getGetChangelogMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ChangelogsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChangelogsStub>() {
          @java.lang.Override
          public ChangelogsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChangelogsStub(channel, callOptions);
          }
        };
    return ChangelogsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChangelogsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChangelogsBlockingStub>() {
          @java.lang.Override
          public ChangelogsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChangelogsBlockingStub(channel, callOptions);
          }
        };
    return ChangelogsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ChangelogsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChangelogsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChangelogsFutureStub>() {
          @java.lang.Override
          public ChangelogsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChangelogsFutureStub(channel, callOptions);
          }
        };
    return ChangelogsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    default void listChangelogs(
        com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChangelogsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    default void getChangelog(
        com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Changelog>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetChangelogMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Changelogs.
   *
   * <pre>
   * Service for managing
   * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
   * </pre>
   */
  public abstract static class ChangelogsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ChangelogsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Changelogs.
   *
   * <pre>
   * Service for managing
   * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
   * </pre>
   */
  public static final class ChangelogsStub extends io.grpc.stub.AbstractAsyncStub<ChangelogsStub> {
    private ChangelogsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public void listChangelogs(
        com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public void getChangelog(
        com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Changelog>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Changelogs.
   *
   * <pre>
   * Service for managing
   * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
   * </pre>
   */
  public static final class ChangelogsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ChangelogsBlockingStub> {
    private ChangelogsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse listChangelogs(
        com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChangelogsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.Changelog getChangelog(
        com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChangelogMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Changelogs.
   *
   * <pre>
   * Service for managing
   * [Changelogs][google.cloud.dialogflow.cx.v3beta1.Changelog].
   * </pre>
   */
  public static final class ChangelogsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ChangelogsFutureStub> {
    private ChangelogsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChangelogsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChangelogsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of Changelogs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>
        listChangelogs(com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChangelogsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified Changelog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.Changelog>
        getChangelog(com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChangelogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CHANGELOGS = 0;
  private static final int METHODID_GET_CHANGELOG = 1;

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
        case METHODID_LIST_CHANGELOGS:
          serviceImpl.listChangelogs(
              (com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CHANGELOG:
          serviceImpl.getChangelog(
              (com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.Changelog>)
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
            getListChangelogsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.ListChangelogsResponse>(
                    service, METHODID_LIST_CHANGELOGS)))
        .addMethod(
            getGetChangelogMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.cx.v3beta1.GetChangelogRequest,
                    com.google.cloud.dialogflow.cx.v3beta1.Changelog>(
                    service, METHODID_GET_CHANGELOG)))
        .build();
  }

  private abstract static class ChangelogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChangelogsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.ChangelogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Changelogs");
    }
  }

  private static final class ChangelogsFileDescriptorSupplier
      extends ChangelogsBaseDescriptorSupplier {
    ChangelogsFileDescriptorSupplier() {}
  }

  private static final class ChangelogsMethodDescriptorSupplier
      extends ChangelogsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ChangelogsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ChangelogsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ChangelogsFileDescriptorSupplier())
                      .addMethod(getListChangelogsMethod())
                      .addMethod(getGetChangelogMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
