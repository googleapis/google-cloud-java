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
package com.google.maps.areainsights.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service definition for the Places Insights API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/maps/areainsights/v1/area_insights_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AreaInsightsGrpc {

  private AreaInsightsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.maps.areainsights.v1.AreaInsights";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.maps.areainsights.v1.ComputeInsightsRequest,
          com.google.maps.areainsights.v1.ComputeInsightsResponse>
      getComputeInsightsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeInsights",
      requestType = com.google.maps.areainsights.v1.ComputeInsightsRequest.class,
      responseType = com.google.maps.areainsights.v1.ComputeInsightsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.maps.areainsights.v1.ComputeInsightsRequest,
          com.google.maps.areainsights.v1.ComputeInsightsResponse>
      getComputeInsightsMethod() {
    io.grpc.MethodDescriptor<
            com.google.maps.areainsights.v1.ComputeInsightsRequest,
            com.google.maps.areainsights.v1.ComputeInsightsResponse>
        getComputeInsightsMethod;
    if ((getComputeInsightsMethod = AreaInsightsGrpc.getComputeInsightsMethod) == null) {
      synchronized (AreaInsightsGrpc.class) {
        if ((getComputeInsightsMethod = AreaInsightsGrpc.getComputeInsightsMethod) == null) {
          AreaInsightsGrpc.getComputeInsightsMethod =
              getComputeInsightsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.maps.areainsights.v1.ComputeInsightsRequest,
                          com.google.maps.areainsights.v1.ComputeInsightsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeInsights"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.areainsights.v1.ComputeInsightsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.maps.areainsights.v1.ComputeInsightsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AreaInsightsMethodDescriptorSupplier("ComputeInsights"))
                      .build();
        }
      }
    }
    return getComputeInsightsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AreaInsightsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AreaInsightsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AreaInsightsStub>() {
          @java.lang.Override
          public AreaInsightsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AreaInsightsStub(channel, callOptions);
          }
        };
    return AreaInsightsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AreaInsightsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AreaInsightsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AreaInsightsBlockingStub>() {
          @java.lang.Override
          public AreaInsightsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AreaInsightsBlockingStub(channel, callOptions);
          }
        };
    return AreaInsightsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AreaInsightsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AreaInsightsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AreaInsightsFutureStub>() {
          @java.lang.Override
          public AreaInsightsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AreaInsightsFutureStub(channel, callOptions);
          }
        };
    return AreaInsightsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service definition for the Places Insights API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Compute Insights RPC
     * This method lets you retrieve insights about areas using a variaty of
     * filter such as: area, place type, operating status, price level
     * and ratings. Currently "count" and "places" insights are supported. With
     * "count" insights you can answer questions such as "How many restaurant are
     * located in California that are operational, are inexpensive and have an
     * average rating of at least 4 stars" (see `insight` enum for more details).
     * With "places" insights, you can determine which places match the
     * requested filter. Clients can then use those place resource names to fetch
     * more details about each individual place using the Places API.
     * </pre>
     */
    default void computeInsights(
        com.google.maps.areainsights.v1.ComputeInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.areainsights.v1.ComputeInsightsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeInsightsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AreaInsights.
   *
   * <pre>
   * Service definition for the Places Insights API.
   * </pre>
   */
  public abstract static class AreaInsightsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AreaInsightsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AreaInsights.
   *
   * <pre>
   * Service definition for the Places Insights API.
   * </pre>
   */
  public static final class AreaInsightsStub
      extends io.grpc.stub.AbstractAsyncStub<AreaInsightsStub> {
    private AreaInsightsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AreaInsightsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AreaInsightsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Compute Insights RPC
     * This method lets you retrieve insights about areas using a variaty of
     * filter such as: area, place type, operating status, price level
     * and ratings. Currently "count" and "places" insights are supported. With
     * "count" insights you can answer questions such as "How many restaurant are
     * located in California that are operational, are inexpensive and have an
     * average rating of at least 4 stars" (see `insight` enum for more details).
     * With "places" insights, you can determine which places match the
     * requested filter. Clients can then use those place resource names to fetch
     * more details about each individual place using the Places API.
     * </pre>
     */
    public void computeInsights(
        com.google.maps.areainsights.v1.ComputeInsightsRequest request,
        io.grpc.stub.StreamObserver<com.google.maps.areainsights.v1.ComputeInsightsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeInsightsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AreaInsights.
   *
   * <pre>
   * Service definition for the Places Insights API.
   * </pre>
   */
  public static final class AreaInsightsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AreaInsightsBlockingStub> {
    private AreaInsightsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AreaInsightsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AreaInsightsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Compute Insights RPC
     * This method lets you retrieve insights about areas using a variaty of
     * filter such as: area, place type, operating status, price level
     * and ratings. Currently "count" and "places" insights are supported. With
     * "count" insights you can answer questions such as "How many restaurant are
     * located in California that are operational, are inexpensive and have an
     * average rating of at least 4 stars" (see `insight` enum for more details).
     * With "places" insights, you can determine which places match the
     * requested filter. Clients can then use those place resource names to fetch
     * more details about each individual place using the Places API.
     * </pre>
     */
    public com.google.maps.areainsights.v1.ComputeInsightsResponse computeInsights(
        com.google.maps.areainsights.v1.ComputeInsightsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeInsightsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AreaInsights.
   *
   * <pre>
   * Service definition for the Places Insights API.
   * </pre>
   */
  public static final class AreaInsightsFutureStub
      extends io.grpc.stub.AbstractFutureStub<AreaInsightsFutureStub> {
    private AreaInsightsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AreaInsightsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AreaInsightsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Compute Insights RPC
     * This method lets you retrieve insights about areas using a variaty of
     * filter such as: area, place type, operating status, price level
     * and ratings. Currently "count" and "places" insights are supported. With
     * "count" insights you can answer questions such as "How many restaurant are
     * located in California that are operational, are inexpensive and have an
     * average rating of at least 4 stars" (see `insight` enum for more details).
     * With "places" insights, you can determine which places match the
     * requested filter. Clients can then use those place resource names to fetch
     * more details about each individual place using the Places API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.maps.areainsights.v1.ComputeInsightsResponse>
        computeInsights(com.google.maps.areainsights.v1.ComputeInsightsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeInsightsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_INSIGHTS = 0;

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
        case METHODID_COMPUTE_INSIGHTS:
          serviceImpl.computeInsights(
              (com.google.maps.areainsights.v1.ComputeInsightsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.maps.areainsights.v1.ComputeInsightsResponse>)
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
            getComputeInsightsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.maps.areainsights.v1.ComputeInsightsRequest,
                    com.google.maps.areainsights.v1.ComputeInsightsResponse>(
                    service, METHODID_COMPUTE_INSIGHTS)))
        .build();
  }

  private abstract static class AreaInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AreaInsightsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.maps.areainsights.v1.AreaInsightsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AreaInsights");
    }
  }

  private static final class AreaInsightsFileDescriptorSupplier
      extends AreaInsightsBaseDescriptorSupplier {
    AreaInsightsFileDescriptorSupplier() {}
  }

  private static final class AreaInsightsMethodDescriptorSupplier
      extends AreaInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AreaInsightsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AreaInsightsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AreaInsightsFileDescriptorSupplier())
                      .addMethod(getComputeInsightsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
