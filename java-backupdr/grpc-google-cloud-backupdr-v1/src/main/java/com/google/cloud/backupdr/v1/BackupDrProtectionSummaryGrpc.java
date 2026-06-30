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
package com.google.cloud.backupdr.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Protection Summary service.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class BackupDrProtectionSummaryGrpc {

  private BackupDrProtectionSummaryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.backupdr.v1.BackupDrProtectionSummary";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest,
          com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
      getListResourceBackupConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceBackupConfigs",
      requestType = com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest,
          com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
      getListResourceBackupConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest,
            com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
        getListResourceBackupConfigsMethod;
    if ((getListResourceBackupConfigsMethod =
            BackupDrProtectionSummaryGrpc.getListResourceBackupConfigsMethod)
        == null) {
      synchronized (BackupDrProtectionSummaryGrpc.class) {
        if ((getListResourceBackupConfigsMethod =
                BackupDrProtectionSummaryGrpc.getListResourceBackupConfigsMethod)
            == null) {
          BackupDrProtectionSummaryGrpc.getListResourceBackupConfigsMethod =
              getListResourceBackupConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest,
                          com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceBackupConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDrProtectionSummaryMethodDescriptorSupplier(
                              "ListResourceBackupConfigs"))
                      .build();
        }
      }
    }
    return getListResourceBackupConfigsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BackupDrProtectionSummaryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryStub>() {
          @java.lang.Override
          public BackupDrProtectionSummaryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDrProtectionSummaryStub(channel, callOptions);
          }
        };
    return BackupDrProtectionSummaryStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static BackupDrProtectionSummaryBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryBlockingV2Stub>() {
          @java.lang.Override
          public BackupDrProtectionSummaryBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDrProtectionSummaryBlockingV2Stub(channel, callOptions);
          }
        };
    return BackupDrProtectionSummaryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackupDrProtectionSummaryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryBlockingStub>() {
          @java.lang.Override
          public BackupDrProtectionSummaryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDrProtectionSummaryBlockingStub(channel, callOptions);
          }
        };
    return BackupDrProtectionSummaryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BackupDrProtectionSummaryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDrProtectionSummaryFutureStub>() {
          @java.lang.Override
          public BackupDrProtectionSummaryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDrProtectionSummaryFutureStub(channel, callOptions);
          }
        };
    return BackupDrProtectionSummaryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ResourceBackupConfigs.
     * </pre>
     */
    default void listResourceBackupConfigs(
        com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceBackupConfigsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BackupDrProtectionSummary.
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public abstract static class BackupDrProtectionSummaryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BackupDrProtectionSummaryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BackupDrProtectionSummary.
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public static final class BackupDrProtectionSummaryStub
      extends io.grpc.stub.AbstractAsyncStub<BackupDrProtectionSummaryStub> {
    private BackupDrProtectionSummaryStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDrProtectionSummaryStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDrProtectionSummaryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBackupConfigs.
     * </pre>
     */
    public void listResourceBackupConfigs(
        com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceBackupConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BackupDrProtectionSummary.
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public static final class BackupDrProtectionSummaryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BackupDrProtectionSummaryBlockingV2Stub> {
    private BackupDrProtectionSummaryBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDrProtectionSummaryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDrProtectionSummaryBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBackupConfigs.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse listResourceBackupConfigs(
        com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListResourceBackupConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * BackupDrProtectionSummary.
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public static final class BackupDrProtectionSummaryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BackupDrProtectionSummaryBlockingStub> {
    private BackupDrProtectionSummaryBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDrProtectionSummaryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDrProtectionSummaryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBackupConfigs.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse listResourceBackupConfigs(
        com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceBackupConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * BackupDrProtectionSummary.
   *
   * <pre>
   * The Protection Summary service.
   * </pre>
   */
  public static final class BackupDrProtectionSummaryFutureStub
      extends io.grpc.stub.AbstractFutureStub<BackupDrProtectionSummaryFutureStub> {
    private BackupDrProtectionSummaryFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDrProtectionSummaryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDrProtectionSummaryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBackupConfigs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>
        listResourceBackupConfigs(
            com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceBackupConfigsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_RESOURCE_BACKUP_CONFIGS = 0;

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
        case METHODID_LIST_RESOURCE_BACKUP_CONFIGS:
          serviceImpl.listResourceBackupConfigs(
              (com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>)
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
            getListResourceBackupConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListResourceBackupConfigsRequest,
                    com.google.cloud.backupdr.v1.ListResourceBackupConfigsResponse>(
                    service, METHODID_LIST_RESOURCE_BACKUP_CONFIGS)))
        .build();
  }

  private abstract static class BackupDrProtectionSummaryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupDrProtectionSummaryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.backupdr.v1.ProtectionSummaryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackupDrProtectionSummary");
    }
  }

  private static final class BackupDrProtectionSummaryFileDescriptorSupplier
      extends BackupDrProtectionSummaryBaseDescriptorSupplier {
    BackupDrProtectionSummaryFileDescriptorSupplier() {}
  }

  private static final class BackupDrProtectionSummaryMethodDescriptorSupplier
      extends BackupDrProtectionSummaryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BackupDrProtectionSummaryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BackupDrProtectionSummaryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BackupDrProtectionSummaryFileDescriptorSupplier())
                      .addMethod(getListResourceBackupConfigsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
