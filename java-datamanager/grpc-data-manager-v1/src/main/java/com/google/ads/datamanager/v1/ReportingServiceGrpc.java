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
package com.google.ads.datamanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for querying reports.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ReportingServiceGrpc {

  private ReportingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.ads.datamanager.v1.ReportingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest,
          com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
      getRetrievePartnerMatchReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetrievePartnerMatchReport",
      requestType = com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest.class,
      responseType = com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest,
          com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
      getRetrievePartnerMatchReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest,
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
        getRetrievePartnerMatchReportMethod;
    if ((getRetrievePartnerMatchReportMethod =
            ReportingServiceGrpc.getRetrievePartnerMatchReportMethod)
        == null) {
      synchronized (ReportingServiceGrpc.class) {
        if ((getRetrievePartnerMatchReportMethod =
                ReportingServiceGrpc.getRetrievePartnerMatchReportMethod)
            == null) {
          ReportingServiceGrpc.getRetrievePartnerMatchReportMethod =
              getRetrievePartnerMatchReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest,
                          com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RetrievePartnerMatchReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ReportingServiceMethodDescriptorSupplier(
                              "RetrievePartnerMatchReport"))
                      .build();
        }
      }
    }
    return getRetrievePartnerMatchReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ReportingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportingServiceStub>() {
          @java.lang.Override
          public ReportingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportingServiceStub(channel, callOptions);
          }
        };
    return ReportingServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ReportingServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportingServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportingServiceBlockingV2Stub>() {
          @java.lang.Override
          public ReportingServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportingServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ReportingServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReportingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportingServiceBlockingStub>() {
          @java.lang.Override
          public ReportingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportingServiceBlockingStub(channel, callOptions);
          }
        };
    return ReportingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ReportingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReportingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ReportingServiceFutureStub>() {
          @java.lang.Override
          public ReportingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReportingServiceFutureStub(channel, callOptions);
          }
        };
    return ReportingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves a partner match report.
     * This feature is only available to data partners.
     * </pre>
     */
    default void retrievePartnerMatchReport(
        com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRetrievePartnerMatchReportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReportingService.
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public abstract static class ReportingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ReportingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReportingService.
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public static final class ReportingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReportingServiceStub> {
    private ReportingServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportingServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a partner match report.
     * This feature is only available to data partners.
     * </pre>
     */
    public void retrievePartnerMatchReport(
        com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetrievePartnerMatchReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReportingService.
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public static final class ReportingServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ReportingServiceBlockingV2Stub> {
    private ReportingServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportingServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportingServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a partner match report.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse
        retrievePartnerMatchReport(
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRetrievePartnerMatchReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ReportingService.
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public static final class ReportingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReportingServiceBlockingStub> {
    private ReportingServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a partner match report.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse
        retrievePartnerMatchReport(
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetrievePartnerMatchReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReportingService.
   *
   * <pre>
   * Service for querying reports.
   * </pre>
   */
  public static final class ReportingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReportingServiceFutureStub> {
    private ReportingServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReportingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReportingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a partner match report.
     * This feature is only available to data partners.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>
        retrievePartnerMatchReport(
            com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetrievePartnerMatchReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE_PARTNER_MATCH_REPORT = 0;

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
        case METHODID_RETRIEVE_PARTNER_MATCH_REPORT:
          serviceImpl.retrievePartnerMatchReport(
              (com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>)
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
            getRetrievePartnerMatchReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.ads.datamanager.v1.RetrievePartnerMatchReportRequest,
                    com.google.ads.datamanager.v1.RetrievePartnerMatchReportResponse>(
                    service, METHODID_RETRIEVE_PARTNER_MATCH_REPORT)))
        .build();
  }

  private abstract static class ReportingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReportingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.ads.datamanager.v1.ReportingServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReportingService");
    }
  }

  private static final class ReportingServiceFileDescriptorSupplier
      extends ReportingServiceBaseDescriptorSupplier {
    ReportingServiceFileDescriptorSupplier() {}
  }

  private static final class ReportingServiceMethodDescriptorSupplier
      extends ReportingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReportingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReportingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ReportingServiceFileDescriptorSupplier())
                      .addMethod(getRetrievePartnerMatchReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
