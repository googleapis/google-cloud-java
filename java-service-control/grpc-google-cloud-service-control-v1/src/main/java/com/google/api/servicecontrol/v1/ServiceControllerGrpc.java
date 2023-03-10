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
package com.google.api.servicecontrol.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * [Google Service Control API](/service-control/overview)
 * Lets clients check and report operations against a [managed
 * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/servicecontrol/v1/service_controller.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceControllerGrpc {

  private ServiceControllerGrpc() {}

  public static final String SERVICE_NAME = "google.api.servicecontrol.v1.ServiceController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.api.servicecontrol.v1.CheckRequest,
          com.google.api.servicecontrol.v1.CheckResponse>
      getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Check",
      requestType = com.google.api.servicecontrol.v1.CheckRequest.class,
      responseType = com.google.api.servicecontrol.v1.CheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.servicecontrol.v1.CheckRequest,
          com.google.api.servicecontrol.v1.CheckResponse>
      getCheckMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.servicecontrol.v1.CheckRequest,
            com.google.api.servicecontrol.v1.CheckResponse>
        getCheckMethod;
    if ((getCheckMethod = ServiceControllerGrpc.getCheckMethod) == null) {
      synchronized (ServiceControllerGrpc.class) {
        if ((getCheckMethod = ServiceControllerGrpc.getCheckMethod) == null) {
          ServiceControllerGrpc.getCheckMethod =
              getCheckMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.servicecontrol.v1.CheckRequest,
                          com.google.api.servicecontrol.v1.CheckResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Check"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.servicecontrol.v1.CheckRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.servicecontrol.v1.CheckResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ServiceControllerMethodDescriptorSupplier("Check"))
                      .build();
        }
      }
    }
    return getCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.servicecontrol.v1.ReportRequest,
          com.google.api.servicecontrol.v1.ReportResponse>
      getReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Report",
      requestType = com.google.api.servicecontrol.v1.ReportRequest.class,
      responseType = com.google.api.servicecontrol.v1.ReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.servicecontrol.v1.ReportRequest,
          com.google.api.servicecontrol.v1.ReportResponse>
      getReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.servicecontrol.v1.ReportRequest,
            com.google.api.servicecontrol.v1.ReportResponse>
        getReportMethod;
    if ((getReportMethod = ServiceControllerGrpc.getReportMethod) == null) {
      synchronized (ServiceControllerGrpc.class) {
        if ((getReportMethod = ServiceControllerGrpc.getReportMethod) == null) {
          ServiceControllerGrpc.getReportMethod =
              getReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.servicecontrol.v1.ReportRequest,
                          com.google.api.servicecontrol.v1.ReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Report"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.servicecontrol.v1.ReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.servicecontrol.v1.ReportResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ServiceControllerMethodDescriptorSupplier("Report"))
                      .build();
        }
      }
    }
    return getReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServiceControllerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceControllerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceControllerStub>() {
          @java.lang.Override
          public ServiceControllerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceControllerStub(channel, callOptions);
          }
        };
    return ServiceControllerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceControllerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceControllerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceControllerBlockingStub>() {
          @java.lang.Override
          public ServiceControllerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceControllerBlockingStub(channel, callOptions);
          }
        };
    return ServiceControllerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServiceControllerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceControllerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceControllerFutureStub>() {
          @java.lang.Override
          public ServiceControllerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceControllerFutureStub(channel, callOptions);
          }
        };
    return ServiceControllerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * [Google Service Control API](/service-control/overview)
   * Lets clients check and report operations against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public abstract static class ServiceControllerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Checks whether an operation on a service should be allowed to proceed
     * based on the configuration of the service and related policies. It must be
     * called before the operation is executed.
     * If feasible, the client should cache the check results and reuse them for
     * 60 seconds. In case of any server errors, the client should rely on the
     * cached results for much longer time to avoid outage.
     * WARNING: There is general 60s delay for the configuration and policy
     * propagation, therefore callers MUST NOT depend on the `Check` method having
     * the latest policy information.
     * NOTE: the [CheckRequest][google.api.servicecontrol.v1.CheckRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.check` permission
     * on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public void check(
        com.google.api.servicecontrol.v1.CheckRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.CheckResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reports operation results to Google Service Control, such as logs and
     * metrics. It should be called after an operation is completed.
     * If feasible, the client should aggregate reporting data for up to 5
     * seconds to reduce API traffic. Limiting aggregation to 5 seconds is to
     * reduce data loss during client crashes. Clients should carefully choose
     * the aggregation time window to avoid data loss risk more than 0.01%
     * for business and compliance reasons.
     * NOTE: the [ReportRequest][google.api.servicecontrol.v1.ReportRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.report` permission
     * on the specified service. For more information, see
     * [Google Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public void report(
        com.google.api.servicecontrol.v1.ReportRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.ReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReportMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCheckMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.api.servicecontrol.v1.CheckRequest,
                      com.google.api.servicecontrol.v1.CheckResponse>(this, METHODID_CHECK)))
          .addMethod(
              getReportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.api.servicecontrol.v1.ReportRequest,
                      com.google.api.servicecontrol.v1.ReportResponse>(this, METHODID_REPORT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * [Google Service Control API](/service-control/overview)
   * Lets clients check and report operations against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class ServiceControllerStub
      extends io.grpc.stub.AbstractAsyncStub<ServiceControllerStub> {
    private ServiceControllerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceControllerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceControllerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Checks whether an operation on a service should be allowed to proceed
     * based on the configuration of the service and related policies. It must be
     * called before the operation is executed.
     * If feasible, the client should cache the check results and reuse them for
     * 60 seconds. In case of any server errors, the client should rely on the
     * cached results for much longer time to avoid outage.
     * WARNING: There is general 60s delay for the configuration and policy
     * propagation, therefore callers MUST NOT depend on the `Check` method having
     * the latest policy information.
     * NOTE: the [CheckRequest][google.api.servicecontrol.v1.CheckRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.check` permission
     * on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public void check(
        com.google.api.servicecontrol.v1.CheckRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.CheckResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reports operation results to Google Service Control, such as logs and
     * metrics. It should be called after an operation is completed.
     * If feasible, the client should aggregate reporting data for up to 5
     * seconds to reduce API traffic. Limiting aggregation to 5 seconds is to
     * reduce data loss during client crashes. Clients should carefully choose
     * the aggregation time window to avoid data loss risk more than 0.01%
     * for business and compliance reasons.
     * NOTE: the [ReportRequest][google.api.servicecontrol.v1.ReportRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.report` permission
     * on the specified service. For more information, see
     * [Google Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public void report(
        com.google.api.servicecontrol.v1.ReportRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.ReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * [Google Service Control API](/service-control/overview)
   * Lets clients check and report operations against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class ServiceControllerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServiceControllerBlockingStub> {
    private ServiceControllerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceControllerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceControllerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Checks whether an operation on a service should be allowed to proceed
     * based on the configuration of the service and related policies. It must be
     * called before the operation is executed.
     * If feasible, the client should cache the check results and reuse them for
     * 60 seconds. In case of any server errors, the client should rely on the
     * cached results for much longer time to avoid outage.
     * WARNING: There is general 60s delay for the configuration and policy
     * propagation, therefore callers MUST NOT depend on the `Check` method having
     * the latest policy information.
     * NOTE: the [CheckRequest][google.api.servicecontrol.v1.CheckRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.check` permission
     * on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.api.servicecontrol.v1.CheckResponse check(
        com.google.api.servicecontrol.v1.CheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reports operation results to Google Service Control, such as logs and
     * metrics. It should be called after an operation is completed.
     * If feasible, the client should aggregate reporting data for up to 5
     * seconds to reduce API traffic. Limiting aggregation to 5 seconds is to
     * reduce data loss during client crashes. Clients should carefully choose
     * the aggregation time window to avoid data loss risk more than 0.01%
     * for business and compliance reasons.
     * NOTE: the [ReportRequest][google.api.servicecontrol.v1.ReportRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.report` permission
     * on the specified service. For more information, see
     * [Google Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.api.servicecontrol.v1.ReportResponse report(
        com.google.api.servicecontrol.v1.ReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * [Google Service Control API](/service-control/overview)
   * Lets clients check and report operations against a [managed
   * service](https://cloud.google.com/service-management/reference/rpc/google.api/servicemanagement.v1#google.api.servicemanagement.v1.ManagedService).
   * </pre>
   */
  public static final class ServiceControllerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServiceControllerFutureStub> {
    private ServiceControllerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceControllerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceControllerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Checks whether an operation on a service should be allowed to proceed
     * based on the configuration of the service and related policies. It must be
     * called before the operation is executed.
     * If feasible, the client should cache the check results and reuse them for
     * 60 seconds. In case of any server errors, the client should rely on the
     * cached results for much longer time to avoid outage.
     * WARNING: There is general 60s delay for the configuration and policy
     * propagation, therefore callers MUST NOT depend on the `Check` method having
     * the latest policy information.
     * NOTE: the [CheckRequest][google.api.servicecontrol.v1.CheckRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.check` permission
     * on the specified service. For more information, see
     * [Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.servicecontrol.v1.CheckResponse>
        check(com.google.api.servicecontrol.v1.CheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reports operation results to Google Service Control, such as logs and
     * metrics. It should be called after an operation is completed.
     * If feasible, the client should aggregate reporting data for up to 5
     * seconds to reduce API traffic. Limiting aggregation to 5 seconds is to
     * reduce data loss during client crashes. Clients should carefully choose
     * the aggregation time window to avoid data loss risk more than 0.01%
     * for business and compliance reasons.
     * NOTE: the [ReportRequest][google.api.servicecontrol.v1.ReportRequest] has
     * the size limit (wire-format byte size) of 1MB.
     * This method requires the `servicemanagement.services.report` permission
     * on the specified service. For more information, see
     * [Google Cloud IAM](https://cloud.google.com/iam).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.servicecontrol.v1.ReportResponse>
        report(com.google.api.servicecontrol.v1.ReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK = 0;
  private static final int METHODID_REPORT = 1;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK:
          serviceImpl.check(
              (com.google.api.servicecontrol.v1.CheckRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.CheckResponse>)
                  responseObserver);
          break;
        case METHODID_REPORT:
          serviceImpl.report(
              (com.google.api.servicecontrol.v1.ReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicecontrol.v1.ReportResponse>)
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

  private abstract static class ServiceControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.servicecontrol.v1.ServiceControllerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceController");
    }
  }

  private static final class ServiceControllerFileDescriptorSupplier
      extends ServiceControllerBaseDescriptorSupplier {
    ServiceControllerFileDescriptorSupplier() {}
  }

  private static final class ServiceControllerMethodDescriptorSupplier
      extends ServiceControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServiceControllerFileDescriptorSupplier())
                      .addMethod(getCheckMethod())
                      .addMethod(getReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
