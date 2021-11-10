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
package com.google.cloud.billing.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A catalog of Google Cloud Platform services and SKUs.
 * Provides pricing information and metadata on Google Cloud Platform services
 * and SKUs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/billing/v1/cloud_catalog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudCatalogGrpc {

  private CloudCatalogGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.billing.v1.CloudCatalog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.v1.ListServicesRequest,
          com.google.cloud.billing.v1.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.billing.v1.ListServicesRequest.class,
      responseType = com.google.cloud.billing.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.v1.ListServicesRequest,
          com.google.cloud.billing.v1.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.v1.ListServicesRequest,
            com.google.cloud.billing.v1.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = CloudCatalogGrpc.getListServicesMethod) == null) {
      synchronized (CloudCatalogGrpc.class) {
        if ((getListServicesMethod = CloudCatalogGrpc.getListServicesMethod) == null) {
          CloudCatalogGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.v1.ListServicesRequest,
                          com.google.cloud.billing.v1.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.v1.ListServicesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.v1.ListServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new CloudCatalogMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.billing.v1.ListSkusRequest, com.google.cloud.billing.v1.ListSkusResponse>
      getListSkusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSkus",
      requestType = com.google.cloud.billing.v1.ListSkusRequest.class,
      responseType = com.google.cloud.billing.v1.ListSkusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.billing.v1.ListSkusRequest, com.google.cloud.billing.v1.ListSkusResponse>
      getListSkusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.billing.v1.ListSkusRequest,
            com.google.cloud.billing.v1.ListSkusResponse>
        getListSkusMethod;
    if ((getListSkusMethod = CloudCatalogGrpc.getListSkusMethod) == null) {
      synchronized (CloudCatalogGrpc.class) {
        if ((getListSkusMethod = CloudCatalogGrpc.getListSkusMethod) == null) {
          CloudCatalogGrpc.getListSkusMethod =
              getListSkusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.billing.v1.ListSkusRequest,
                          com.google.cloud.billing.v1.ListSkusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSkus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.v1.ListSkusRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.billing.v1.ListSkusResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudCatalogMethodDescriptorSupplier("ListSkus"))
                      .build();
        }
      }
    }
    return getListSkusMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudCatalogStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudCatalogStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudCatalogStub>() {
          @java.lang.Override
          public CloudCatalogStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudCatalogStub(channel, callOptions);
          }
        };
    return CloudCatalogStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudCatalogBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudCatalogBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudCatalogBlockingStub>() {
          @java.lang.Override
          public CloudCatalogBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudCatalogBlockingStub(channel, callOptions);
          }
        };
    return CloudCatalogBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudCatalogFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudCatalogFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudCatalogFutureStub>() {
          @java.lang.Override
          public CloudCatalogFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudCatalogFutureStub(channel, callOptions);
          }
        };
    return CloudCatalogFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A catalog of Google Cloud Platform services and SKUs.
   * Provides pricing information and metadata on Google Cloud Platform services
   * and SKUs.
   * </pre>
   */
  public abstract static class CloudCatalogImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all public cloud services.
     * </pre>
     */
    public void listServices(
        com.google.cloud.billing.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all publicly available SKUs for a given cloud service.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.billing.v1.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSkusMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.v1.ListServicesRequest,
                      com.google.cloud.billing.v1.ListServicesResponse>(
                      this, METHODID_LIST_SERVICES)))
          .addMethod(
              getListSkusMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.billing.v1.ListSkusRequest,
                      com.google.cloud.billing.v1.ListSkusResponse>(this, METHODID_LIST_SKUS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A catalog of Google Cloud Platform services and SKUs.
   * Provides pricing information and metadata on Google Cloud Platform services
   * and SKUs.
   * </pre>
   */
  public static final class CloudCatalogStub
      extends io.grpc.stub.AbstractAsyncStub<CloudCatalogStub> {
    private CloudCatalogStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudCatalogStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudCatalogStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all public cloud services.
     * </pre>
     */
    public void listServices(
        com.google.cloud.billing.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all publicly available SKUs for a given cloud service.
     * </pre>
     */
    public void listSkus(
        com.google.cloud.billing.v1.ListSkusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListSkusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A catalog of Google Cloud Platform services and SKUs.
   * Provides pricing information and metadata on Google Cloud Platform services
   * and SKUs.
   * </pre>
   */
  public static final class CloudCatalogBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudCatalogBlockingStub> {
    private CloudCatalogBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudCatalogBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudCatalogBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all public cloud services.
     * </pre>
     */
    public com.google.cloud.billing.v1.ListServicesResponse listServices(
        com.google.cloud.billing.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all publicly available SKUs for a given cloud service.
     * </pre>
     */
    public com.google.cloud.billing.v1.ListSkusResponse listSkus(
        com.google.cloud.billing.v1.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSkusMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A catalog of Google Cloud Platform services and SKUs.
   * Provides pricing information and metadata on Google Cloud Platform services
   * and SKUs.
   * </pre>
   */
  public static final class CloudCatalogFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudCatalogFutureStub> {
    private CloudCatalogFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudCatalogFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudCatalogFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all public cloud services.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.v1.ListServicesResponse>
        listServices(com.google.cloud.billing.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all publicly available SKUs for a given cloud service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.billing.v1.ListSkusResponse>
        listSkus(com.google.cloud.billing.v1.ListSkusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSkusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICES = 0;
  private static final int METHODID_LIST_SKUS = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudCatalogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudCatalogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.billing.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SKUS:
          serviceImpl.listSkus(
              (com.google.cloud.billing.v1.ListSkusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.billing.v1.ListSkusResponse>)
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

  private abstract static class CloudCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudCatalogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.billing.v1.CloudCatalogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudCatalog");
    }
  }

  private static final class CloudCatalogFileDescriptorSupplier
      extends CloudCatalogBaseDescriptorSupplier {
    CloudCatalogFileDescriptorSupplier() {}
  }

  private static final class CloudCatalogMethodDescriptorSupplier
      extends CloudCatalogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudCatalogMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudCatalogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudCatalogFileDescriptorSupplier())
                      .addMethod(getListServicesMethod())
                      .addMethod(getListSkusMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
