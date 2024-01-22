/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.retail.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing &amp; accessing retail search business metric.
 * Retail recommendation business metric is currently not available.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2beta/analytics_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AnalyticsServiceGrpc {

  private AnalyticsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.retail.v2beta.AnalyticsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest,
          com.google.longrunning.Operation>
      getExportAnalyticsMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportAnalyticsMetrics",
      requestType = com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest,
          com.google.longrunning.Operation>
      getExportAnalyticsMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest,
            com.google.longrunning.Operation>
        getExportAnalyticsMetricsMethod;
    if ((getExportAnalyticsMetricsMethod = AnalyticsServiceGrpc.getExportAnalyticsMetricsMethod)
        == null) {
      synchronized (AnalyticsServiceGrpc.class) {
        if ((getExportAnalyticsMetricsMethod = AnalyticsServiceGrpc.getExportAnalyticsMetricsMethod)
            == null) {
          AnalyticsServiceGrpc.getExportAnalyticsMetricsMethod =
              getExportAnalyticsMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ExportAnalyticsMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AnalyticsServiceMethodDescriptorSupplier("ExportAnalyticsMetrics"))
                      .build();
        }
      }
    }
    return getExportAnalyticsMetricsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AnalyticsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceStub>() {
          @java.lang.Override
          public AnalyticsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsServiceStub(channel, callOptions);
          }
        };
    return AnalyticsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnalyticsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceBlockingStub>() {
          @java.lang.Override
          public AnalyticsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsServiceBlockingStub(channel, callOptions);
          }
        };
    return AnalyticsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AnalyticsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AnalyticsServiceFutureStub>() {
          @java.lang.Override
          public AnalyticsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AnalyticsServiceFutureStub(channel, callOptions);
          }
        };
    return AnalyticsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing &amp; accessing retail search business metric.
   * Retail recommendation business metric is currently not available.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Exports analytics metrics.
     * `Operation.response` is of type `ExportAnalyticsMetricsResponse`.
     * `Operation.metadata` is of type `ExportMetadata`.
     * </pre>
     */
    default void exportAnalyticsMetrics(
        com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportAnalyticsMetricsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AnalyticsService.
   *
   * <pre>
   * Service for managing &amp; accessing retail search business metric.
   * Retail recommendation business metric is currently not available.
   * </pre>
   */
  public abstract static class AnalyticsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AnalyticsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AnalyticsService.
   *
   * <pre>
   * Service for managing &amp; accessing retail search business metric.
   * Retail recommendation business metric is currently not available.
   * </pre>
   */
  public static final class AnalyticsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AnalyticsServiceStub> {
    private AnalyticsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports analytics metrics.
     * `Operation.response` is of type `ExportAnalyticsMetricsResponse`.
     * `Operation.metadata` is of type `ExportMetadata`.
     * </pre>
     */
    public void exportAnalyticsMetrics(
        com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportAnalyticsMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AnalyticsService.
   *
   * <pre>
   * Service for managing &amp; accessing retail search business metric.
   * Retail recommendation business metric is currently not available.
   * </pre>
   */
  public static final class AnalyticsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AnalyticsServiceBlockingStub> {
    private AnalyticsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports analytics metrics.
     * `Operation.response` is of type `ExportAnalyticsMetricsResponse`.
     * `Operation.metadata` is of type `ExportMetadata`.
     * </pre>
     */
    public com.google.longrunning.Operation exportAnalyticsMetrics(
        com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportAnalyticsMetricsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AnalyticsService.
   *
   * <pre>
   * Service for managing &amp; accessing retail search business metric.
   * Retail recommendation business metric is currently not available.
   * </pre>
   */
  public static final class AnalyticsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AnalyticsServiceFutureStub> {
    private AnalyticsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnalyticsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnalyticsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Exports analytics metrics.
     * `Operation.response` is of type `ExportAnalyticsMetricsResponse`.
     * `Operation.metadata` is of type `ExportMetadata`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportAnalyticsMetrics(
            com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportAnalyticsMetricsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXPORT_ANALYTICS_METRICS = 0;

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
        case METHODID_EXPORT_ANALYTICS_METRICS:
          serviceImpl.exportAnalyticsMetrics(
              (com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest) request,
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
            getExportAnalyticsMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2beta.ExportAnalyticsMetricsRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_ANALYTICS_METRICS)))
        .build();
  }

  private abstract static class AnalyticsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnalyticsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2beta.AnalyticsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnalyticsService");
    }
  }

  private static final class AnalyticsServiceFileDescriptorSupplier
      extends AnalyticsServiceBaseDescriptorSupplier {
    AnalyticsServiceFileDescriptorSupplier() {}
  }

  private static final class AnalyticsServiceMethodDescriptorSupplier
      extends AnalyticsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AnalyticsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AnalyticsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AnalyticsServiceFileDescriptorSupplier())
                      .addMethod(getExportAnalyticsMetricsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
