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
package com.google.shopping.merchant.datasources.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage data source file uploads.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/datasources/v1beta/fileuploads.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FileUploadsServiceGrpc {

  private FileUploadsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.datasources.v1beta.FileUploadsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest,
          com.google.shopping.merchant.datasources.v1beta.FileUpload>
      getGetFileUploadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFileUpload",
      requestType = com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest.class,
      responseType = com.google.shopping.merchant.datasources.v1beta.FileUpload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest,
          com.google.shopping.merchant.datasources.v1beta.FileUpload>
      getGetFileUploadMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest,
            com.google.shopping.merchant.datasources.v1beta.FileUpload>
        getGetFileUploadMethod;
    if ((getGetFileUploadMethod = FileUploadsServiceGrpc.getGetFileUploadMethod) == null) {
      synchronized (FileUploadsServiceGrpc.class) {
        if ((getGetFileUploadMethod = FileUploadsServiceGrpc.getGetFileUploadMethod) == null) {
          FileUploadsServiceGrpc.getGetFileUploadMethod =
              getGetFileUploadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest,
                          com.google.shopping.merchant.datasources.v1beta.FileUpload>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFileUpload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.datasources.v1beta.FileUpload
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FileUploadsServiceMethodDescriptorSupplier("GetFileUpload"))
                      .build();
        }
      }
    }
    return getGetFileUploadMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FileUploadsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceStub>() {
          @java.lang.Override
          public FileUploadsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FileUploadsServiceStub(channel, callOptions);
          }
        };
    return FileUploadsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileUploadsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceBlockingStub>() {
          @java.lang.Override
          public FileUploadsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FileUploadsServiceBlockingStub(channel, callOptions);
          }
        };
    return FileUploadsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FileUploadsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FileUploadsServiceFutureStub>() {
          @java.lang.Override
          public FileUploadsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FileUploadsServiceFutureStub(channel, callOptions);
          }
        };
    return FileUploadsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage data source file uploads.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the latest data source file upload. Only the `latest` alias is
     * accepted for a file upload.
     * </pre>
     */
    default void getFileUpload(
        com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.FileUpload>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFileUploadMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FileUploadsService.
   *
   * <pre>
   * Service to manage data source file uploads.
   * </pre>
   */
  public abstract static class FileUploadsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FileUploadsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FileUploadsService.
   *
   * <pre>
   * Service to manage data source file uploads.
   * </pre>
   */
  public static final class FileUploadsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FileUploadsServiceStub> {
    private FileUploadsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileUploadsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileUploadsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest data source file upload. Only the `latest` alias is
     * accepted for a file upload.
     * </pre>
     */
    public void getFileUpload(
        com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.datasources.v1beta.FileUpload>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileUploadMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FileUploadsService.
   *
   * <pre>
   * Service to manage data source file uploads.
   * </pre>
   */
  public static final class FileUploadsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FileUploadsServiceBlockingStub> {
    private FileUploadsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileUploadsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileUploadsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest data source file upload. Only the `latest` alias is
     * accepted for a file upload.
     * </pre>
     */
    public com.google.shopping.merchant.datasources.v1beta.FileUpload getFileUpload(
        com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFileUploadMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FileUploadsService.
   *
   * <pre>
   * Service to manage data source file uploads.
   * </pre>
   */
  public static final class FileUploadsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FileUploadsServiceFutureStub> {
    private FileUploadsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FileUploadsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FileUploadsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the latest data source file upload. Only the `latest` alias is
     * accepted for a file upload.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.datasources.v1beta.FileUpload>
        getFileUpload(
            com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFileUploadMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FILE_UPLOAD = 0;

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
        case METHODID_GET_FILE_UPLOAD:
          serviceImpl.getFileUpload(
              (com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.datasources.v1beta.FileUpload>)
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
            getGetFileUploadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.datasources.v1beta.GetFileUploadRequest,
                    com.google.shopping.merchant.datasources.v1beta.FileUpload>(
                    service, METHODID_GET_FILE_UPLOAD)))
        .build();
  }

  private abstract static class FileUploadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileUploadsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.datasources.v1beta.FileUploadsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileUploadsService");
    }
  }

  private static final class FileUploadsServiceFileDescriptorSupplier
      extends FileUploadsServiceBaseDescriptorSupplier {
    FileUploadsServiceFileDescriptorSupplier() {}
  }

  private static final class FileUploadsServiceMethodDescriptorSupplier
      extends FileUploadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FileUploadsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FileUploadsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FileUploadsServiceFileDescriptorSupplier())
                      .addMethod(getGetFileUploadMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
