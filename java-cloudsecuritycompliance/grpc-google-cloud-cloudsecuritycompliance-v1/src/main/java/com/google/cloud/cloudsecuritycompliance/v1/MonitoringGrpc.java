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
package com.google.cloud.cloudsecuritycompliance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/cloudsecuritycompliance/v1/monitoring.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MonitoringGrpc {

  private MonitoringGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudsecuritycompliance.v1.Monitoring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse>
      getListFrameworkComplianceSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFrameworkComplianceSummaries",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest.class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse>
      getListFrameworkComplianceSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse>
        getListFrameworkComplianceSummariesMethod;
    if ((getListFrameworkComplianceSummariesMethod =
            MonitoringGrpc.getListFrameworkComplianceSummariesMethod)
        == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getListFrameworkComplianceSummariesMethod =
                MonitoringGrpc.getListFrameworkComplianceSummariesMethod)
            == null) {
          MonitoringGrpc.getListFrameworkComplianceSummariesMethod =
              getListFrameworkComplianceSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .ListFrameworkComplianceSummariesRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .ListFrameworkComplianceSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFrameworkComplianceSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFrameworkComplianceSummariesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFrameworkComplianceSummariesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MonitoringMethodDescriptorSupplier(
                              "ListFrameworkComplianceSummaries"))
                      .build();
        }
      }
    }
    return getListFrameworkComplianceSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
      getListFindingSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindingSummaries",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
      getListFindingSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
        getListFindingSummariesMethod;
    if ((getListFindingSummariesMethod = MonitoringGrpc.getListFindingSummariesMethod) == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getListFindingSummariesMethod = MonitoringGrpc.getListFindingSummariesMethod)
            == null) {
          MonitoringGrpc.getListFindingSummariesMethod =
              getListFindingSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFindingSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFindingSummariesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListFindingSummariesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MonitoringMethodDescriptorSupplier("ListFindingSummaries"))
                      .build();
        }
      }
    }
    return getListFindingSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
      getFetchFrameworkComplianceReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchFrameworkComplianceReport",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
      getFetchFrameworkComplianceReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest,
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
        getFetchFrameworkComplianceReportMethod;
    if ((getFetchFrameworkComplianceReportMethod =
            MonitoringGrpc.getFetchFrameworkComplianceReportMethod)
        == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getFetchFrameworkComplianceReportMethod =
                MonitoringGrpc.getFetchFrameworkComplianceReportMethod)
            == null) {
          MonitoringGrpc.getFetchFrameworkComplianceReportMethod =
              getFetchFrameworkComplianceReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .FetchFrameworkComplianceReportRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchFrameworkComplianceReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .FetchFrameworkComplianceReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MonitoringMethodDescriptorSupplier("FetchFrameworkComplianceReport"))
                      .build();
        }
      }
    }
    return getFetchFrameworkComplianceReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
      getListControlComplianceSummariesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListControlComplianceSummaries",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest.class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest,
          com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
      getListControlComplianceSummariesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest,
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
        getListControlComplianceSummariesMethod;
    if ((getListControlComplianceSummariesMethod =
            MonitoringGrpc.getListControlComplianceSummariesMethod)
        == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getListControlComplianceSummariesMethod =
                MonitoringGrpc.getListControlComplianceSummariesMethod)
            == null) {
          MonitoringGrpc.getListControlComplianceSummariesMethod =
              getListControlComplianceSummariesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .ListControlComplianceSummariesRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .ListControlComplianceSummariesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListControlComplianceSummaries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListControlComplianceSummariesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .ListControlComplianceSummariesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MonitoringMethodDescriptorSupplier("ListControlComplianceSummaries"))
                      .build();
        }
      }
    }
    return getListControlComplianceSummariesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse>
      getAggregateFrameworkComplianceReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregateFrameworkComplianceReport",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
              .class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse
              .class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest,
          com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse>
      getAggregateFrameworkComplianceReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest,
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse>
        getAggregateFrameworkComplianceReportMethod;
    if ((getAggregateFrameworkComplianceReportMethod =
            MonitoringGrpc.getAggregateFrameworkComplianceReportMethod)
        == null) {
      synchronized (MonitoringGrpc.class) {
        if ((getAggregateFrameworkComplianceReportMethod =
                MonitoringGrpc.getAggregateFrameworkComplianceReportMethod)
            == null) {
          MonitoringGrpc.getAggregateFrameworkComplianceReportMethod =
              getAggregateFrameworkComplianceReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .AggregateFrameworkComplianceReportRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .AggregateFrameworkComplianceReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "AggregateFrameworkComplianceReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .AggregateFrameworkComplianceReportRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .AggregateFrameworkComplianceReportResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MonitoringMethodDescriptorSupplier(
                              "AggregateFrameworkComplianceReport"))
                      .build();
        }
      }
    }
    return getAggregateFrameworkComplianceReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MonitoringStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MonitoringStub>() {
          @java.lang.Override
          public MonitoringStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MonitoringStub(channel, callOptions);
          }
        };
    return MonitoringStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static MonitoringBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingV2Stub>() {
          @java.lang.Override
          public MonitoringBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MonitoringBlockingV2Stub(channel, callOptions);
          }
        };
    return MonitoringBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MonitoringBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MonitoringBlockingStub>() {
          @java.lang.Override
          public MonitoringBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MonitoringBlockingStub(channel, callOptions);
          }
        };
    return MonitoringBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MonitoringFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MonitoringFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MonitoringFutureStub>() {
          @java.lang.Override
          public MonitoringFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MonitoringFutureStub(channel, callOptions);
          }
        };
    return MonitoringFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the framework compliance summary for a given scope.
     * </pre>
     */
    default void listFrameworkComplianceSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .ListFrameworkComplianceSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFrameworkComplianceSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the finding summary by category for a given scope.
     * </pre>
     */
    default void listFindingSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the framework compliance report for a given scope.
     * </pre>
     */
    default void fetchFrameworkComplianceReport(
        com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchFrameworkComplianceReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the control compliance summary for a given scope.
     * </pre>
     */
    default void listControlComplianceSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListControlComplianceSummariesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the aggregated compliance report over time for a given scope.
     * </pre>
     */
    default void aggregateFrameworkComplianceReport(
        com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .AggregateFrameworkComplianceReportResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAggregateFrameworkComplianceReportMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Monitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class MonitoringImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return MonitoringGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Monitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MonitoringStub extends io.grpc.stub.AbstractAsyncStub<MonitoringStub> {
    private MonitoringStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework compliance summary for a given scope.
     * </pre>
     */
    public void listFrameworkComplianceSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .ListFrameworkComplianceSummariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFrameworkComplianceSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the finding summary by category for a given scope.
     * </pre>
     */
    public void listFindingSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches the framework compliance report for a given scope.
     * </pre>
     */
    public void fetchFrameworkComplianceReport(
        com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchFrameworkComplianceReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the control compliance summary for a given scope.
     * </pre>
     */
    public void listControlComplianceSummaries(
        com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListControlComplianceSummariesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the aggregated compliance report over time for a given scope.
     * </pre>
     */
    public void aggregateFrameworkComplianceReport(
        com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1
                    .AggregateFrameworkComplianceReportResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregateFrameworkComplianceReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Monitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MonitoringBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<MonitoringBlockingV2Stub> {
    private MonitoringBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework compliance summary for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse
        listFrameworkComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkComplianceSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the finding summary by category for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse
        listFindingSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the framework compliance report for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport
        fetchFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchFrameworkComplianceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the control compliance summary for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse
        listControlComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListControlComplianceSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the aggregated compliance report over time for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse
        aggregateFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateFrameworkComplianceReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Monitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MonitoringBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MonitoringBlockingStub> {
    private MonitoringBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework compliance summary for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse
        listFrameworkComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFrameworkComplianceSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the finding summary by category for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse
        listFindingSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the framework compliance report for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport
        fetchFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchFrameworkComplianceReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the control compliance summary for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse
        listControlComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListControlComplianceSummariesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the aggregated compliance report over time for a given scope.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse
        aggregateFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateFrameworkComplianceReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Monitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class MonitoringFutureStub
      extends io.grpc.stub.AbstractFutureStub<MonitoringFutureStub> {
    private MonitoringFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MonitoringFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MonitoringFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the framework compliance summary for a given scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesResponse>
        listFrameworkComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFrameworkComplianceSummariesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the finding summary by category for a given scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>
        listFindingSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingSummariesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches the framework compliance report for a given scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>
        fetchFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchFrameworkComplianceReportMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists the control compliance summary for a given scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesResponse>
        listControlComplianceSummaries(
            com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListControlComplianceSummariesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets the aggregated compliance report over time for a given scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportResponse>
        aggregateFrameworkComplianceReport(
            com.google.cloud.cloudsecuritycompliance.v1.AggregateFrameworkComplianceReportRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregateFrameworkComplianceReportMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_LIST_FRAMEWORK_COMPLIANCE_SUMMARIES = 0;
  private static final int METHODID_LIST_FINDING_SUMMARIES = 1;
  private static final int METHODID_FETCH_FRAMEWORK_COMPLIANCE_REPORT = 2;
  private static final int METHODID_LIST_CONTROL_COMPLIANCE_SUMMARIES = 3;
  private static final int METHODID_AGGREGATE_FRAMEWORK_COMPLIANCE_REPORT = 4;

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
        case METHODID_LIST_FRAMEWORK_COMPLIANCE_SUMMARIES:
          serviceImpl.listFrameworkComplianceSummaries(
              (com.google.cloud.cloudsecuritycompliance.v1.ListFrameworkComplianceSummariesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .ListFrameworkComplianceSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDING_SUMMARIES:
          serviceImpl.listFindingSummaries(
              (com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_FETCH_FRAMEWORK_COMPLIANCE_REPORT:
          serviceImpl.fetchFrameworkComplianceReport(
              (com.google.cloud.cloudsecuritycompliance.v1.FetchFrameworkComplianceReportRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>)
                  responseObserver);
          break;
        case METHODID_LIST_CONTROL_COMPLIANCE_SUMMARIES:
          serviceImpl.listControlComplianceSummaries(
              (com.google.cloud.cloudsecuritycompliance.v1.ListControlComplianceSummariesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .ListControlComplianceSummariesResponse>)
                  responseObserver);
          break;
        case METHODID_AGGREGATE_FRAMEWORK_COMPLIANCE_REPORT:
          serviceImpl.aggregateFrameworkComplianceReport(
              (com.google.cloud.cloudsecuritycompliance.v1
                      .AggregateFrameworkComplianceReportRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .AggregateFrameworkComplianceReportResponse>)
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
            getListFrameworkComplianceSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .ListFrameworkComplianceSummariesRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .ListFrameworkComplianceSummariesResponse>(
                    service, METHODID_LIST_FRAMEWORK_COMPLIANCE_SUMMARIES)))
        .addMethod(
            getListFindingSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.ListFindingSummariesResponse>(
                    service, METHODID_LIST_FINDING_SUMMARIES)))
        .addMethod(
            getFetchFrameworkComplianceReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .FetchFrameworkComplianceReportRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.FrameworkComplianceReport>(
                    service, METHODID_FETCH_FRAMEWORK_COMPLIANCE_REPORT)))
        .addMethod(
            getListControlComplianceSummariesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .ListControlComplianceSummariesRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .ListControlComplianceSummariesResponse>(
                    service, METHODID_LIST_CONTROL_COMPLIANCE_SUMMARIES)))
        .addMethod(
            getAggregateFrameworkComplianceReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .AggregateFrameworkComplianceReportRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .AggregateFrameworkComplianceReportResponse>(
                    service, METHODID_AGGREGATE_FRAMEWORK_COMPLIANCE_REPORT)))
        .build();
  }

  private abstract static class MonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MonitoringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudsecuritycompliance.v1.MonitoringProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Monitoring");
    }
  }

  private static final class MonitoringFileDescriptorSupplier
      extends MonitoringBaseDescriptorSupplier {
    MonitoringFileDescriptorSupplier() {}
  }

  private static final class MonitoringMethodDescriptorSupplier
      extends MonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MonitoringMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (MonitoringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MonitoringFileDescriptorSupplier())
                      .addMethod(getListFrameworkComplianceSummariesMethod())
                      .addMethod(getListFindingSummariesMethod())
                      .addMethod(getFetchFrameworkComplianceReportMethod())
                      .addMethod(getListControlComplianceSummariesMethod())
                      .addMethod(getAggregateFrameworkComplianceReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
