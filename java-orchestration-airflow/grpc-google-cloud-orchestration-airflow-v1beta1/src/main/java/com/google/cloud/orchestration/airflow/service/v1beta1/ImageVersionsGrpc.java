/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.orchestration.airflow.service.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Readonly service to query available ImageVersions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/orchestration/airflow/service/v1beta1/image_versions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ImageVersionsGrpc {

  private ImageVersionsGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.orchestration.airflow.service.v1beta1.ImageVersions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest,
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
      getListImageVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListImageVersions",
      requestType =
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest.class,
      responseType =
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest,
          com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
      getListImageVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest,
            com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
        getListImageVersionsMethod;
    if ((getListImageVersionsMethod = ImageVersionsGrpc.getListImageVersionsMethod) == null) {
      synchronized (ImageVersionsGrpc.class) {
        if ((getListImageVersionsMethod = ImageVersionsGrpc.getListImageVersionsMethod) == null) {
          ImageVersionsGrpc.getListImageVersionsMethod =
              getListImageVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.orchestration.airflow.service.v1beta1
                              .ListImageVersionsRequest,
                          com.google.cloud.orchestration.airflow.service.v1beta1
                              .ListImageVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListImageVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1beta1
                                  .ListImageVersionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.orchestration.airflow.service.v1beta1
                                  .ListImageVersionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageVersionsMethodDescriptorSupplier("ListImageVersions"))
                      .build();
        }
      }
    }
    return getListImageVersionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ImageVersionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageVersionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageVersionsStub>() {
          @java.lang.Override
          public ImageVersionsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageVersionsStub(channel, callOptions);
          }
        };
    return ImageVersionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImageVersionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageVersionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageVersionsBlockingStub>() {
          @java.lang.Override
          public ImageVersionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageVersionsBlockingStub(channel, callOptions);
          }
        };
    return ImageVersionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ImageVersionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageVersionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageVersionsFutureStub>() {
          @java.lang.Override
          public ImageVersionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageVersionsFutureStub(channel, callOptions);
          }
        };
    return ImageVersionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Readonly service to query available ImageVersions.
   * </pre>
   */
  public abstract static class ImageVersionsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * List ImageVersions for provided location.
     * </pre>
     */
    public void listImageVersions(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListImageVersionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListImageVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.orchestration.airflow.service.v1beta1
                          .ListImageVersionsRequest,
                      com.google.cloud.orchestration.airflow.service.v1beta1
                          .ListImageVersionsResponse>(this, METHODID_LIST_IMAGE_VERSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Readonly service to query available ImageVersions.
   * </pre>
   */
  public static final class ImageVersionsStub
      extends io.grpc.stub.AbstractAsyncStub<ImageVersionsStub> {
    private ImageVersionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageVersionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageVersionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List ImageVersions for provided location.
     * </pre>
     */
    public void listImageVersions(
        com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListImageVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Readonly service to query available ImageVersions.
   * </pre>
   */
  public static final class ImageVersionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ImageVersionsBlockingStub> {
    private ImageVersionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageVersionsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageVersionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List ImageVersions for provided location.
     * </pre>
     */
    public com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse
        listImageVersions(
            com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListImageVersionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Readonly service to query available ImageVersions.
   * </pre>
   */
  public static final class ImageVersionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ImageVersionsFutureStub> {
    private ImageVersionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageVersionsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageVersionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List ImageVersions for provided location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsResponse>
        listImageVersions(
            com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListImageVersionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_IMAGE_VERSIONS = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImageVersionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImageVersionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_IMAGE_VERSIONS:
          serviceImpl.listImageVersions(
              (com.google.cloud.orchestration.airflow.service.v1beta1.ListImageVersionsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.orchestration.airflow.service.v1beta1
                          .ListImageVersionsResponse>)
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

  private abstract static class ImageVersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImageVersionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.orchestration.airflow.service.v1beta1.ImageVersionsOuterClass
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImageVersions");
    }
  }

  private static final class ImageVersionsFileDescriptorSupplier
      extends ImageVersionsBaseDescriptorSupplier {
    ImageVersionsFileDescriptorSupplier() {}
  }

  private static final class ImageVersionsMethodDescriptorSupplier
      extends ImageVersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImageVersionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ImageVersionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ImageVersionsFileDescriptorSupplier())
                      .addMethod(getListImageVersionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
