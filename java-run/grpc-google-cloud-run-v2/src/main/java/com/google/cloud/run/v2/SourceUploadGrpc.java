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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Run Source Upload API allows you to upload source code to deploy
 * Cloud Run resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SourceUploadGrpc {

  private SourceUploadGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.run.v2.SourceUpload";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UploadSourceRequest, com.google.cloud.run.v2.UploadSourceResponse>
      getUploadSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadSource",
      requestType = com.google.cloud.run.v2.UploadSourceRequest.class,
      responseType = com.google.cloud.run.v2.UploadSourceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UploadSourceRequest, com.google.cloud.run.v2.UploadSourceResponse>
      getUploadSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.UploadSourceRequest,
            com.google.cloud.run.v2.UploadSourceResponse>
        getUploadSourceMethod;
    if ((getUploadSourceMethod = SourceUploadGrpc.getUploadSourceMethod) == null) {
      synchronized (SourceUploadGrpc.class) {
        if ((getUploadSourceMethod = SourceUploadGrpc.getUploadSourceMethod) == null) {
          SourceUploadGrpc.getUploadSourceMethod =
              getUploadSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.UploadSourceRequest,
                          com.google.cloud.run.v2.UploadSourceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.UploadSourceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.UploadSourceResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SourceUploadMethodDescriptorSupplier("UploadSource"))
                      .build();
        }
      }
    }
    return getUploadSourceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SourceUploadStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceUploadStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SourceUploadStub>() {
          @java.lang.Override
          public SourceUploadStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SourceUploadStub(channel, callOptions);
          }
        };
    return SourceUploadStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SourceUploadBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceUploadBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SourceUploadBlockingV2Stub>() {
          @java.lang.Override
          public SourceUploadBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SourceUploadBlockingV2Stub(channel, callOptions);
          }
        };
    return SourceUploadBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SourceUploadBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceUploadBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SourceUploadBlockingStub>() {
          @java.lang.Override
          public SourceUploadBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SourceUploadBlockingStub(channel, callOptions);
          }
        };
    return SourceUploadBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SourceUploadFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SourceUploadFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SourceUploadFutureStub>() {
          @java.lang.Override
          public SourceUploadFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SourceUploadFutureStub(channel, callOptions);
          }
        };
    return SourceUploadFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Uploads a source archive to a Google Cloud Storage bucket through Cloud
     * Run. The uploaded source object should be used for Cloud Run resource
     * deployments. User is responsible for managing the lifecycle of the uploaded
     * object.
     * If uploading through the Cloud Run API to Cloud Storage is not desired, you
     * can use the IAM Deny Policy to deny the `run.locations.uploadSource`
     * permission for all principals.
     * </pre>
     */
    default void uploadSource(
        com.google.cloud.run.v2.UploadSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.UploadSourceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadSourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SourceUpload.
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public abstract static class SourceUploadImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SourceUploadGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SourceUpload.
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public static final class SourceUploadStub
      extends io.grpc.stub.AbstractAsyncStub<SourceUploadStub> {
    private SourceUploadStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceUploadStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceUploadStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a source archive to a Google Cloud Storage bucket through Cloud
     * Run. The uploaded source object should be used for Cloud Run resource
     * deployments. User is responsible for managing the lifecycle of the uploaded
     * object.
     * If uploading through the Cloud Run API to Cloud Storage is not desired, you
     * can use the IAM Deny Policy to deny the `run.locations.uploadSource`
     * permission for all principals.
     * </pre>
     */
    public void uploadSource(
        com.google.cloud.run.v2.UploadSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.UploadSourceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SourceUpload.
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public static final class SourceUploadBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SourceUploadBlockingV2Stub> {
    private SourceUploadBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceUploadBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceUploadBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a source archive to a Google Cloud Storage bucket through Cloud
     * Run. The uploaded source object should be used for Cloud Run resource
     * deployments. User is responsible for managing the lifecycle of the uploaded
     * object.
     * If uploading through the Cloud Run API to Cloud Storage is not desired, you
     * can use the IAM Deny Policy to deny the `run.locations.uploadSource`
     * permission for all principals.
     * </pre>
     */
    public com.google.cloud.run.v2.UploadSourceResponse uploadSource(
        com.google.cloud.run.v2.UploadSourceRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUploadSourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SourceUpload.
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public static final class SourceUploadBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SourceUploadBlockingStub> {
    private SourceUploadBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceUploadBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceUploadBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a source archive to a Google Cloud Storage bucket through Cloud
     * Run. The uploaded source object should be used for Cloud Run resource
     * deployments. User is responsible for managing the lifecycle of the uploaded
     * object.
     * If uploading through the Cloud Run API to Cloud Storage is not desired, you
     * can use the IAM Deny Policy to deny the `run.locations.uploadSource`
     * permission for all principals.
     * </pre>
     */
    public com.google.cloud.run.v2.UploadSourceResponse uploadSource(
        com.google.cloud.run.v2.UploadSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadSourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SourceUpload.
   *
   * <pre>
   * The Cloud Run Source Upload API allows you to upload source code to deploy
   * Cloud Run resources.
   * </pre>
   */
  public static final class SourceUploadFutureStub
      extends io.grpc.stub.AbstractFutureStub<SourceUploadFutureStub> {
    private SourceUploadFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SourceUploadFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SourceUploadFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Uploads a source archive to a Google Cloud Storage bucket through Cloud
     * Run. The uploaded source object should be used for Cloud Run resource
     * deployments. User is responsible for managing the lifecycle of the uploaded
     * object.
     * If uploading through the Cloud Run API to Cloud Storage is not desired, you
     * can use the IAM Deny Policy to deny the `run.locations.uploadSource`
     * permission for all principals.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.UploadSourceResponse>
        uploadSource(com.google.cloud.run.v2.UploadSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadSourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD_SOURCE = 0;

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
        case METHODID_UPLOAD_SOURCE:
          serviceImpl.uploadSource(
              (com.google.cloud.run.v2.UploadSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.UploadSourceResponse>)
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
            getUploadSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.UploadSourceRequest,
                    com.google.cloud.run.v2.UploadSourceResponse>(service, METHODID_UPLOAD_SOURCE)))
        .build();
  }

  private abstract static class SourceUploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SourceUploadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.SourceUploadProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SourceUpload");
    }
  }

  private static final class SourceUploadFileDescriptorSupplier
      extends SourceUploadBaseDescriptorSupplier {
    SourceUploadFileDescriptorSupplier() {}
  }

  private static final class SourceUploadMethodDescriptorSupplier
      extends SourceUploadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SourceUploadMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SourceUploadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SourceUploadFileDescriptorSupplier())
                      .addMethod(getUploadSourceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
