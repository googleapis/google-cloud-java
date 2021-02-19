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
package com.google.analytics.data.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Google Analytics reporting data service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/analytics/data/v1alpha/analytics_data_api.proto")
public final class AlphaAnalyticsDataGrpc {

  private AlphaAnalyticsDataGrpc() {}

  public static final String SERVICE_NAME = "google.analytics.data.v1alpha.AlphaAnalyticsData";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunReportRequest,
          com.google.analytics.data.v1alpha.RunReportResponse>
      getRunReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunReport",
      requestType = com.google.analytics.data.v1alpha.RunReportRequest.class,
      responseType = com.google.analytics.data.v1alpha.RunReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunReportRequest,
          com.google.analytics.data.v1alpha.RunReportResponse>
      getRunReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.RunReportRequest,
            com.google.analytics.data.v1alpha.RunReportResponse>
        getRunReportMethod;
    if ((getRunReportMethod = AlphaAnalyticsDataGrpc.getRunReportMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getRunReportMethod = AlphaAnalyticsDataGrpc.getRunReportMethod) == null) {
          AlphaAnalyticsDataGrpc.getRunReportMethod =
              getRunReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.RunReportRequest,
                          com.google.analytics.data.v1alpha.RunReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("RunReport"))
                      .build();
        }
      }
    }
    return getRunReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunPivotReportRequest,
          com.google.analytics.data.v1alpha.RunPivotReportResponse>
      getRunPivotReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunPivotReport",
      requestType = com.google.analytics.data.v1alpha.RunPivotReportRequest.class,
      responseType = com.google.analytics.data.v1alpha.RunPivotReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunPivotReportRequest,
          com.google.analytics.data.v1alpha.RunPivotReportResponse>
      getRunPivotReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.RunPivotReportRequest,
            com.google.analytics.data.v1alpha.RunPivotReportResponse>
        getRunPivotReportMethod;
    if ((getRunPivotReportMethod = AlphaAnalyticsDataGrpc.getRunPivotReportMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getRunPivotReportMethod = AlphaAnalyticsDataGrpc.getRunPivotReportMethod) == null) {
          AlphaAnalyticsDataGrpc.getRunPivotReportMethod =
              getRunPivotReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.RunPivotReportRequest,
                          com.google.analytics.data.v1alpha.RunPivotReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunPivotReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunPivotReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunPivotReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("RunPivotReport"))
                      .build();
        }
      }
    }
    return getRunPivotReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.BatchRunReportsRequest,
          com.google.analytics.data.v1alpha.BatchRunReportsResponse>
      getBatchRunReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunReports",
      requestType = com.google.analytics.data.v1alpha.BatchRunReportsRequest.class,
      responseType = com.google.analytics.data.v1alpha.BatchRunReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.BatchRunReportsRequest,
          com.google.analytics.data.v1alpha.BatchRunReportsResponse>
      getBatchRunReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.BatchRunReportsRequest,
            com.google.analytics.data.v1alpha.BatchRunReportsResponse>
        getBatchRunReportsMethod;
    if ((getBatchRunReportsMethod = AlphaAnalyticsDataGrpc.getBatchRunReportsMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getBatchRunReportsMethod = AlphaAnalyticsDataGrpc.getBatchRunReportsMethod) == null) {
          AlphaAnalyticsDataGrpc.getBatchRunReportsMethod =
              getBatchRunReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.BatchRunReportsRequest,
                          com.google.analytics.data.v1alpha.BatchRunReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRunReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.BatchRunReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.BatchRunReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("BatchRunReports"))
                      .build();
        }
      }
    }
    return getBatchRunReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest,
          com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
      getBatchRunPivotReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunPivotReports",
      requestType = com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest.class,
      responseType = com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest,
          com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
      getBatchRunPivotReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest,
            com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
        getBatchRunPivotReportsMethod;
    if ((getBatchRunPivotReportsMethod = AlphaAnalyticsDataGrpc.getBatchRunPivotReportsMethod)
        == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getBatchRunPivotReportsMethod = AlphaAnalyticsDataGrpc.getBatchRunPivotReportsMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getBatchRunPivotReportsMethod =
              getBatchRunPivotReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest,
                          com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchRunPivotReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("BatchRunPivotReports"))
                      .build();
        }
      }
    }
    return getBatchRunPivotReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetMetadataRequest,
          com.google.analytics.data.v1alpha.Metadata>
      getGetMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetadata",
      requestType = com.google.analytics.data.v1alpha.GetMetadataRequest.class,
      responseType = com.google.analytics.data.v1alpha.Metadata.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.GetMetadataRequest,
          com.google.analytics.data.v1alpha.Metadata>
      getGetMetadataMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.GetMetadataRequest,
            com.google.analytics.data.v1alpha.Metadata>
        getGetMetadataMethod;
    if ((getGetMetadataMethod = AlphaAnalyticsDataGrpc.getGetMetadataMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getGetMetadataMethod = AlphaAnalyticsDataGrpc.getGetMetadataMethod) == null) {
          AlphaAnalyticsDataGrpc.getGetMetadataMethod =
              getGetMetadataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.GetMetadataRequest,
                          com.google.analytics.data.v1alpha.Metadata>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetadata"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.GetMetadataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.Metadata.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("GetMetadata"))
                      .build();
        }
      }
    }
    return getGetMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunRealtimeReportRequest,
          com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
      getRunRealtimeReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunRealtimeReport",
      requestType = com.google.analytics.data.v1alpha.RunRealtimeReportRequest.class,
      responseType = com.google.analytics.data.v1alpha.RunRealtimeReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.analytics.data.v1alpha.RunRealtimeReportRequest,
          com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
      getRunRealtimeReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.analytics.data.v1alpha.RunRealtimeReportRequest,
            com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
        getRunRealtimeReportMethod;
    if ((getRunRealtimeReportMethod = AlphaAnalyticsDataGrpc.getRunRealtimeReportMethod) == null) {
      synchronized (AlphaAnalyticsDataGrpc.class) {
        if ((getRunRealtimeReportMethod = AlphaAnalyticsDataGrpc.getRunRealtimeReportMethod)
            == null) {
          AlphaAnalyticsDataGrpc.getRunRealtimeReportMethod =
              getRunRealtimeReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.analytics.data.v1alpha.RunRealtimeReportRequest,
                          com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunRealtimeReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunRealtimeReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.analytics.data.v1alpha.RunRealtimeReportResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlphaAnalyticsDataMethodDescriptorSupplier("RunRealtimeReport"))
                      .build();
        }
      }
    }
    return getRunRealtimeReportMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AlphaAnalyticsDataStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlphaAnalyticsDataBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataBlockingStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AlphaAnalyticsDataFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlphaAnalyticsDataFutureStub>() {
          @java.lang.Override
          public AlphaAnalyticsDataFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlphaAnalyticsDataFutureStub(channel, callOptions);
          }
        };
    return AlphaAnalyticsDataFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public abstract static class AlphaAnalyticsDataImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * </pre>
     */
    public void runReport(
        com.google.analytics.data.v1alpha.RunReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunReportResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getRunReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public void runPivotReport(
        com.google.analytics.data.v1alpha.RunPivotReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunPivotReportResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getRunPivotReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public void batchRunReports(
        com.google.analytics.data.v1alpha.BatchRunReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.BatchRunReportsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchRunReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public void batchRunPivotReports(
        com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getBatchRunPivotReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics GA4 Property Identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public void getMetadata(
        com.google.analytics.data.v1alpha.GetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.Metadata> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMetadataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * The Google Analytics Realtime API returns a customized report of realtime
     * event data for your property. These reports show events and usage from the
     * last 30 minutes.
     * </pre>
     */
    public void runRealtimeReport(
        com.google.analytics.data.v1alpha.RunRealtimeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getRunRealtimeReportMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getRunReportMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.RunReportRequest,
                      com.google.analytics.data.v1alpha.RunReportResponse>(
                      this, METHODID_RUN_REPORT)))
          .addMethod(
              getRunPivotReportMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.RunPivotReportRequest,
                      com.google.analytics.data.v1alpha.RunPivotReportResponse>(
                      this, METHODID_RUN_PIVOT_REPORT)))
          .addMethod(
              getBatchRunReportsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.BatchRunReportsRequest,
                      com.google.analytics.data.v1alpha.BatchRunReportsResponse>(
                      this, METHODID_BATCH_RUN_REPORTS)))
          .addMethod(
              getBatchRunPivotReportsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest,
                      com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>(
                      this, METHODID_BATCH_RUN_PIVOT_REPORTS)))
          .addMethod(
              getGetMetadataMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.GetMetadataRequest,
                      com.google.analytics.data.v1alpha.Metadata>(this, METHODID_GET_METADATA)))
          .addMethod(
              getRunRealtimeReportMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.analytics.data.v1alpha.RunRealtimeReportRequest,
                      com.google.analytics.data.v1alpha.RunRealtimeReportResponse>(
                      this, METHODID_RUN_REALTIME_REPORT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataStub
      extends io.grpc.stub.AbstractAsyncStub<AlphaAnalyticsDataStub> {
    private AlphaAnalyticsDataStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * </pre>
     */
    public void runReport(
        com.google.analytics.data.v1alpha.RunReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunReportResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public void runPivotReport(
        com.google.analytics.data.v1alpha.RunPivotReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunPivotReportResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunPivotReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public void batchRunReports(
        com.google.analytics.data.v1alpha.BatchRunReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.BatchRunReportsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchRunReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public void batchRunPivotReports(
        com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchRunPivotReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics GA4 Property Identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public void getMetadata(
        com.google.analytics.data.v1alpha.GetMetadataRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.Metadata> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMetadataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * The Google Analytics Realtime API returns a customized report of realtime
     * event data for your property. These reports show events and usage from the
     * last 30 minutes.
     * </pre>
     */
    public void runRealtimeReport(
        com.google.analytics.data.v1alpha.RunRealtimeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunRealtimeReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AlphaAnalyticsDataBlockingStub> {
    private AlphaAnalyticsDataBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RunReportResponse runReport(
        com.google.analytics.data.v1alpha.RunReportRequest request) {
      return blockingUnaryCall(getChannel(), getRunReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RunPivotReportResponse runPivotReport(
        com.google.analytics.data.v1alpha.RunPivotReportRequest request) {
      return blockingUnaryCall(getChannel(), getRunPivotReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.BatchRunReportsResponse batchRunReports(
        com.google.analytics.data.v1alpha.BatchRunReportsRequest request) {
      return blockingUnaryCall(getChannel(), getBatchRunReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse batchRunPivotReports(
        com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchRunPivotReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics GA4 Property Identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.Metadata getMetadata(
        com.google.analytics.data.v1alpha.GetMetadataRequest request) {
      return blockingUnaryCall(getChannel(), getGetMetadataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * The Google Analytics Realtime API returns a customized report of realtime
     * event data for your property. These reports show events and usage from the
     * last 30 minutes.
     * </pre>
     */
    public com.google.analytics.data.v1alpha.RunRealtimeReportResponse runRealtimeReport(
        com.google.analytics.data.v1alpha.RunRealtimeReportRequest request) {
      return blockingUnaryCall(
          getChannel(), getRunRealtimeReportMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Analytics reporting data service.
   * </pre>
   */
  public static final class AlphaAnalyticsDataFutureStub
      extends io.grpc.stub.AbstractFutureStub<AlphaAnalyticsDataFutureStub> {
    private AlphaAnalyticsDataFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlphaAnalyticsDataFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlphaAnalyticsDataFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized report of your Google Analytics event data. Reports
     * contain statistics derived from data collected by the Google Analytics
     * tracking code. The data returned from the API is as a table with columns
     * for the requested dimensions and metrics. Metrics are individual
     * measurements of user activity on your property, such as active users or
     * event count. Dimensions break down metrics across some common criteria,
     * such as country or event name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RunReportResponse>
        runReport(com.google.analytics.data.v1alpha.RunReportRequest request) {
      return futureUnaryCall(getChannel().newCall(getRunReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a customized pivot report of your Google Analytics event data.
     * Pivot reports are more advanced and expressive formats than regular
     * reports. In a pivot report, dimensions are only visible if they are
     * included in a pivot. Multiple pivots can be specified to further dissect
     * your data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RunPivotReportResponse>
        runPivotReport(com.google.analytics.data.v1alpha.RunPivotReportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunPivotReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.BatchRunReportsResponse>
        batchRunReports(com.google.analytics.data.v1alpha.BatchRunReportsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchRunReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns multiple pivot reports in a batch. All reports must be for the same
     * Entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>
        batchRunPivotReports(
            com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchRunPivotReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for dimensions and metrics available in reporting methods.
     * Used to explore the dimensions and metrics. In this method, a Google
     * Analytics GA4 Property Identifier is specified in the request, and
     * the metadata response includes Custom dimensions and metrics as well as
     * Universal metadata.
     * For example if a custom metric with parameter name `levels_unlocked` is
     * registered to a property, the Metadata response will contain
     * `customEvent:levels_unlocked`. Universal metadata are dimensions and
     * metrics applicable to any property such as `country` and `totalUsers`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.Metadata>
        getMetadata(com.google.analytics.data.v1alpha.GetMetadataRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMetadataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * The Google Analytics Realtime API returns a customized report of realtime
     * event data for your property. These reports show events and usage from the
     * last 30 minutes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.analytics.data.v1alpha.RunRealtimeReportResponse>
        runRealtimeReport(com.google.analytics.data.v1alpha.RunRealtimeReportRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunRealtimeReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_REPORT = 0;
  private static final int METHODID_RUN_PIVOT_REPORT = 1;
  private static final int METHODID_BATCH_RUN_REPORTS = 2;
  private static final int METHODID_BATCH_RUN_PIVOT_REPORTS = 3;
  private static final int METHODID_GET_METADATA = 4;
  private static final int METHODID_RUN_REALTIME_REPORT = 5;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlphaAnalyticsDataImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlphaAnalyticsDataImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN_REPORT:
          serviceImpl.runReport(
              (com.google.analytics.data.v1alpha.RunReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.RunReportResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_PIVOT_REPORT:
          serviceImpl.runPivotReport(
              (com.google.analytics.data.v1alpha.RunPivotReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.RunPivotReportResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_RUN_REPORTS:
          serviceImpl.batchRunReports(
              (com.google.analytics.data.v1alpha.BatchRunReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.BatchRunReportsResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_RUN_PIVOT_REPORTS:
          serviceImpl.batchRunPivotReports(
              (com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_METADATA:
          serviceImpl.getMetadata(
              (com.google.analytics.data.v1alpha.GetMetadataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.analytics.data.v1alpha.Metadata>)
                  responseObserver);
          break;
        case METHODID_RUN_REALTIME_REPORT:
          serviceImpl.runRealtimeReport(
              (com.google.analytics.data.v1alpha.RunRealtimeReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.analytics.data.v1alpha.RunRealtimeReportResponse>)
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

  private abstract static class AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlphaAnalyticsDataBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.analytics.data.v1alpha.AnalyticsDataApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlphaAnalyticsData");
    }
  }

  private static final class AlphaAnalyticsDataFileDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier {
    AlphaAnalyticsDataFileDescriptorSupplier() {}
  }

  private static final class AlphaAnalyticsDataMethodDescriptorSupplier
      extends AlphaAnalyticsDataBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlphaAnalyticsDataMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlphaAnalyticsDataGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AlphaAnalyticsDataFileDescriptorSupplier())
                      .addMethod(getRunReportMethod())
                      .addMethod(getRunPivotReportMethod())
                      .addMethod(getBatchRunReportsMethod())
                      .addMethod(getBatchRunPivotReportsMethod())
                      .addMethod(getGetMetadataMethod())
                      .addMethod(getRunRealtimeReportMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
