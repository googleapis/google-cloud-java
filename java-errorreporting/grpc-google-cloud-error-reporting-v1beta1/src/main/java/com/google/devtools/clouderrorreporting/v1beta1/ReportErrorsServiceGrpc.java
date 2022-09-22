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
package com.google.devtools.clouderrorreporting.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An API for reporting error events.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/clouderrorreporting/v1beta1/report_errors_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReportErrorsServiceGrpc {

  private ReportErrorsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.devtools.clouderrorreporting.v1beta1.ReportErrorsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      getReportErrorEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportErrorEvent",
      requestType = com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest.class,
      responseType = com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
      getReportErrorEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
        getReportErrorEventMethod;
    if ((getReportErrorEventMethod = ReportErrorsServiceGrpc.getReportErrorEventMethod) == null) {
      synchronized (ReportErrorsServiceGrpc.class) {
        if ((getReportErrorEventMethod = ReportErrorsServiceGrpc.getReportErrorEventMethod)
            == null) {
          ReportErrorsServiceGrpc.getReportErrorEventMethod =
              getReportErrorEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
                          com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportErrorEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouderrorreporting.v1beta1
                                  .ReportErrorEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.clouderrorreporting.v1beta1
                                  .ReportErrorEventResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReportErrorsServiceMethodDescriptorSupplier("ReportErrorEvent"))
                      .build();
        }
      }
    }
    return getReportErrorEventMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReportErrorsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceStub>() {
          @java.lang.Override
          public ReportErrorsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportErrorsServiceStub(channel, callOptions);
          }
        };
    return ReportErrorsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportErrorsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceBlockingStub>() {
          @java.lang.Override
          public ReportErrorsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportErrorsServiceBlockingStub(channel, callOptions);
          }
        };
    return ReportErrorsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReportErrorsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportErrorsServiceFutureStub>() {
          @java.lang.Override
          public ReportErrorsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportErrorsServiceFutureStub(channel, callOptions);
          }
        };
    return ReportErrorsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public abstract static class ReportErrorsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Report an individual error event and record the event to a log.
     * This endpoint accepts **either** an OAuth token,
     * **or** an [API key](https://support.google.com/cloud/answer/6158862)
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * `POST
     * https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`
     * **Note:** [Error Reporting](/error-reporting) is a global service built
     * on Cloud Logging and doesn't analyze logs stored
     * in regional log buckets or logs routed to other Google Cloud projects.
     * For more information, see
     * [Using Error Reporting with regionalized
     * logs](/error-reporting/docs/regionalization).
     * </pre>
     */
    public void reportErrorEvent(
        com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportErrorEventMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getReportErrorEventMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest,
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>(
                      this, METHODID_REPORT_ERROR_EVENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReportErrorsServiceStub> {
    private ReportErrorsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event and record the event to a log.
     * This endpoint accepts **either** an OAuth token,
     * **or** an [API key](https://support.google.com/cloud/answer/6158862)
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * `POST
     * https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`
     * **Note:** [Error Reporting](/error-reporting) is a global service built
     * on Cloud Logging and doesn't analyze logs stored
     * in regional log buckets or logs routed to other Google Cloud projects.
     * For more information, see
     * [Using Error Reporting with regionalized
     * logs](/error-reporting/docs/regionalization).
     * </pre>
     */
    public void reportErrorEvent(
        com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportErrorEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReportErrorsServiceBlockingStub> {
    private ReportErrorsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event and record the event to a log.
     * This endpoint accepts **either** an OAuth token,
     * **or** an [API key](https://support.google.com/cloud/answer/6158862)
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * `POST
     * https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`
     * **Note:** [Error Reporting](/error-reporting) is a global service built
     * on Cloud Logging and doesn't analyze logs stored
     * in regional log buckets or logs routed to other Google Cloud projects.
     * For more information, see
     * [Using Error Reporting with regionalized
     * logs](/error-reporting/docs/regionalization).
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse
        reportErrorEvent(
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportErrorEventMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * An API for reporting error events.
   * </pre>
   */
  public static final class ReportErrorsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReportErrorsServiceFutureStub> {
    private ReportErrorsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportErrorsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportErrorsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Report an individual error event and record the event to a log.
     * This endpoint accepts **either** an OAuth token,
     * **or** an [API key](https://support.google.com/cloud/answer/6158862)
     * for authentication. To use an API key, append it to the URL as the value of
     * a `key` parameter. For example:
     * `POST
     * https://clouderrorreporting.googleapis.com/v1beta1/{projectName}/events:report?key=123ABC456`
     * **Note:** [Error Reporting](/error-reporting) is a global service built
     * on Cloud Logging and doesn't analyze logs stored
     * in regional log buckets or logs routed to other Google Cloud projects.
     * For more information, see
     * [Using Error Reporting with regionalized
     * logs](/error-reporting/docs/regionalization).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>
        reportErrorEvent(
            com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportErrorEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_ERROR_EVENT = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReportErrorsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReportErrorsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_ERROR_EVENT:
          serviceImpl.reportErrorEvent(
              (com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse>)
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

  private abstract static class ReportErrorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportErrorsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouderrorreporting.v1beta1.ReportErrorsServiceProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportErrorsService");
    }
  }

  private static final class ReportErrorsServiceFileDescriptorSupplier
      extends ReportErrorsServiceBaseDescriptorSupplier {
    ReportErrorsServiceFileDescriptorSupplier() {}
  }

  private static final class ReportErrorsServiceMethodDescriptorSupplier
      extends ReportErrorsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReportErrorsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReportErrorsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReportErrorsServiceFileDescriptorSupplier())
                      .addMethod(getReportErrorEventMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
