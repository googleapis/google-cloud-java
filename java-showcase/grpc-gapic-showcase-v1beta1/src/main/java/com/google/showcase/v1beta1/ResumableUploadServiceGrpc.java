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
package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service showcasing universal resumable upload protocol support.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ResumableUploadServiceGrpc {

  private ResumableUploadServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.showcase.v1beta1.ResumableUploadService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.UploadMediaRequest,
          com.google.showcase.v1beta1.UploadMediaResponse>
      getUploadMediaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadMedia",
      requestType = com.google.showcase.v1beta1.UploadMediaRequest.class,
      responseType = com.google.showcase.v1beta1.UploadMediaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.UploadMediaRequest,
          com.google.showcase.v1beta1.UploadMediaResponse>
      getUploadMediaMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.UploadMediaRequest,
            com.google.showcase.v1beta1.UploadMediaResponse>
        getUploadMediaMethod;
    if ((getUploadMediaMethod = ResumableUploadServiceGrpc.getUploadMediaMethod) == null) {
      synchronized (ResumableUploadServiceGrpc.class) {
        if ((getUploadMediaMethod = ResumableUploadServiceGrpc.getUploadMediaMethod) == null) {
          ResumableUploadServiceGrpc.getUploadMediaMethod =
              getUploadMediaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.UploadMediaRequest,
                          com.google.showcase.v1beta1.UploadMediaResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadMedia"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.UploadMediaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.UploadMediaResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ResumableUploadServiceMethodDescriptorSupplier("UploadMedia"))
                      .build();
        }
      }
    }
    return getUploadMediaMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ResumableUploadServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceStub>() {
          @java.lang.Override
          public ResumableUploadServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResumableUploadServiceStub(channel, callOptions);
          }
        };
    return ResumableUploadServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ResumableUploadServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceBlockingV2Stub>() {
          @java.lang.Override
          public ResumableUploadServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResumableUploadServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ResumableUploadServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResumableUploadServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceBlockingStub>() {
          @java.lang.Override
          public ResumableUploadServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResumableUploadServiceBlockingStub(channel, callOptions);
          }
        };
    return ResumableUploadServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ResumableUploadServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ResumableUploadServiceFutureStub>() {
          @java.lang.Override
          public ResumableUploadServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ResumableUploadServiceFutureStub(channel, callOptions);
          }
        };
    return ResumableUploadServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * A method with media_upload annotation enabled.
     * </pre>
     */
    default void uploadMedia(
        com.google.showcase.v1beta1.UploadMediaRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.UploadMediaResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadMediaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ResumableUploadService.
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public abstract static class ResumableUploadServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ResumableUploadServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ResumableUploadService.
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public static final class ResumableUploadServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ResumableUploadServiceStub> {
    private ResumableUploadServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumableUploadServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumableUploadServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A method with media_upload annotation enabled.
     * </pre>
     */
    public void uploadMedia(
        com.google.showcase.v1beta1.UploadMediaRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.UploadMediaResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadMediaMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ResumableUploadService.
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public static final class ResumableUploadServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ResumableUploadServiceBlockingV2Stub> {
    private ResumableUploadServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumableUploadServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumableUploadServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A method with media_upload annotation enabled.
     * </pre>
     */
    public com.google.showcase.v1beta1.UploadMediaResponse uploadMedia(
        com.google.showcase.v1beta1.UploadMediaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUploadMediaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ResumableUploadService.
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public static final class ResumableUploadServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ResumableUploadServiceBlockingStub> {
    private ResumableUploadServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumableUploadServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumableUploadServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A method with media_upload annotation enabled.
     * </pre>
     */
    public com.google.showcase.v1beta1.UploadMediaResponse uploadMedia(
        com.google.showcase.v1beta1.UploadMediaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadMediaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ResumableUploadService.
   *
   * <pre>
   * A service showcasing universal resumable upload protocol support.
   * </pre>
   */
  public static final class ResumableUploadServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ResumableUploadServiceFutureStub> {
    private ResumableUploadServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ResumableUploadServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ResumableUploadServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * A method with media_upload annotation enabled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.UploadMediaResponse>
        uploadMedia(com.google.showcase.v1beta1.UploadMediaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadMediaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPLOAD_MEDIA = 0;

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
        case METHODID_UPLOAD_MEDIA:
          serviceImpl.uploadMedia(
              (com.google.showcase.v1beta1.UploadMediaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.UploadMediaResponse>)
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
            getUploadMediaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.UploadMediaRequest,
                    com.google.showcase.v1beta1.UploadMediaResponse>(
                    service, METHODID_UPLOAD_MEDIA)))
        .build();
  }

  private abstract static class ResumableUploadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ResumableUploadServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.ResumableUpload.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ResumableUploadService");
    }
  }

  private static final class ResumableUploadServiceFileDescriptorSupplier
      extends ResumableUploadServiceBaseDescriptorSupplier {
    ResumableUploadServiceFileDescriptorSupplier() {}
  }

  private static final class ResumableUploadServiceMethodDescriptorSupplier
      extends ResumableUploadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ResumableUploadServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ResumableUploadServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ResumableUploadServiceFileDescriptorSupplier())
                      .addMethod(getUploadMediaMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
