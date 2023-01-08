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
package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The QueryService API is used to manage time series data in Stackdriver
 * Monitoring. Time series data is a collection of data points that describes
 * the time-varying values of a metric.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/query_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class QueryServiceGrpc {

  private QueryServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.QueryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.QueryTimeSeriesRequest,
          com.google.monitoring.v3.QueryTimeSeriesResponse>
      getQueryTimeSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryTimeSeries",
      requestType = com.google.monitoring.v3.QueryTimeSeriesRequest.class,
      responseType = com.google.monitoring.v3.QueryTimeSeriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.QueryTimeSeriesRequest,
          com.google.monitoring.v3.QueryTimeSeriesResponse>
      getQueryTimeSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.QueryTimeSeriesRequest,
            com.google.monitoring.v3.QueryTimeSeriesResponse>
        getQueryTimeSeriesMethod;
    if ((getQueryTimeSeriesMethod = QueryServiceGrpc.getQueryTimeSeriesMethod) == null) {
      synchronized (QueryServiceGrpc.class) {
        if ((getQueryTimeSeriesMethod = QueryServiceGrpc.getQueryTimeSeriesMethod) == null) {
          QueryServiceGrpc.getQueryTimeSeriesMethod =
              getQueryTimeSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.QueryTimeSeriesRequest,
                          com.google.monitoring.v3.QueryTimeSeriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryTimeSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.QueryTimeSeriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.QueryTimeSeriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new QueryServiceMethodDescriptorSupplier("QueryTimeSeries"))
                      .build();
        }
      }
    }
    return getQueryTimeSeriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static QueryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QueryServiceStub>() {
          @java.lang.Override
          public QueryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QueryServiceStub(channel, callOptions);
          }
        };
    return QueryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QueryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QueryServiceBlockingStub>() {
          @java.lang.Override
          public QueryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QueryServiceBlockingStub(channel, callOptions);
          }
        };
    return QueryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static QueryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<QueryServiceFutureStub>() {
          @java.lang.Override
          public QueryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new QueryServiceFutureStub(channel, callOptions);
          }
        };
    return QueryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The QueryService API is used to manage time series data in Stackdriver
   * Monitoring. Time series data is a collection of data points that describes
   * the time-varying values of a metric.
   * </pre>
   */
  public abstract static class QueryServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Queries time series using Monitoring Query Language. This method does not require a Workspace.
     * </pre>
     */
    public void queryTimeSeries(
        com.google.monitoring.v3.QueryTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.QueryTimeSeriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryTimeSeriesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getQueryTimeSeriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.QueryTimeSeriesRequest,
                      com.google.monitoring.v3.QueryTimeSeriesResponse>(
                      this, METHODID_QUERY_TIME_SERIES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The QueryService API is used to manage time series data in Stackdriver
   * Monitoring. Time series data is a collection of data points that describes
   * the time-varying values of a metric.
   * </pre>
   */
  public static final class QueryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<QueryServiceStub> {
    private QueryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Queries time series using Monitoring Query Language. This method does not require a Workspace.
     * </pre>
     */
    public void queryTimeSeries(
        com.google.monitoring.v3.QueryTimeSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.QueryTimeSeriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryTimeSeriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The QueryService API is used to manage time series data in Stackdriver
   * Monitoring. Time series data is a collection of data points that describes
   * the time-varying values of a metric.
   * </pre>
   */
  public static final class QueryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<QueryServiceBlockingStub> {
    private QueryServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Queries time series using Monitoring Query Language. This method does not require a Workspace.
     * </pre>
     */
    public com.google.monitoring.v3.QueryTimeSeriesResponse queryTimeSeries(
        com.google.monitoring.v3.QueryTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryTimeSeriesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The QueryService API is used to manage time series data in Stackdriver
   * Monitoring. Time series data is a collection of data points that describes
   * the time-varying values of a metric.
   * </pre>
   */
  public static final class QueryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<QueryServiceFutureStub> {
    private QueryServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Queries time series using Monitoring Query Language. This method does not require a Workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.QueryTimeSeriesResponse>
        queryTimeSeries(com.google.monitoring.v3.QueryTimeSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryTimeSeriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY_TIME_SERIES = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final QueryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(QueryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY_TIME_SERIES:
          serviceImpl.queryTimeSeries(
              (com.google.monitoring.v3.QueryTimeSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.QueryTimeSeriesResponse>)
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

  private abstract static class QueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QueryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.QueryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QueryService");
    }
  }

  private static final class QueryServiceFileDescriptorSupplier
      extends QueryServiceBaseDescriptorSupplier {
    QueryServiceFileDescriptorSupplier() {}
  }

  private static final class QueryServiceMethodDescriptorSupplier
      extends QueryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    QueryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (QueryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new QueryServiceFileDescriptorSupplier())
                      .addMethod(getQueryTimeSeriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
