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
package com.google.cloud.networkconnectivity.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Policy-Based Routing allows GCP customers to specify flexibile routing
 * policies for Layer 4 traffic traversing through the connected service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkconnectivity/v1/policy_based_routing.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PolicyBasedRoutingServiceGrpc {

  private PolicyBasedRoutingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1.PolicyBasedRoutingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest,
          com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
      getListPolicyBasedRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPolicyBasedRoutes",
      requestType = com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest,
          com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
      getListPolicyBasedRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest,
            com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
        getListPolicyBasedRoutesMethod;
    if ((getListPolicyBasedRoutesMethod =
            PolicyBasedRoutingServiceGrpc.getListPolicyBasedRoutesMethod)
        == null) {
      synchronized (PolicyBasedRoutingServiceGrpc.class) {
        if ((getListPolicyBasedRoutesMethod =
                PolicyBasedRoutingServiceGrpc.getListPolicyBasedRoutesMethod)
            == null) {
          PolicyBasedRoutingServiceGrpc.getListPolicyBasedRoutesMethod =
              getListPolicyBasedRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest,
                          com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListPolicyBasedRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBasedRoutingServiceMethodDescriptorSupplier(
                              "ListPolicyBasedRoutes"))
                      .build();
        }
      }
    }
    return getListPolicyBasedRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest,
          com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
      getGetPolicyBasedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicyBasedRoute",
      requestType = com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1.PolicyBasedRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest,
          com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
      getGetPolicyBasedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest,
            com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
        getGetPolicyBasedRouteMethod;
    if ((getGetPolicyBasedRouteMethod = PolicyBasedRoutingServiceGrpc.getGetPolicyBasedRouteMethod)
        == null) {
      synchronized (PolicyBasedRoutingServiceGrpc.class) {
        if ((getGetPolicyBasedRouteMethod =
                PolicyBasedRoutingServiceGrpc.getGetPolicyBasedRouteMethod)
            == null) {
          PolicyBasedRoutingServiceGrpc.getGetPolicyBasedRouteMethod =
              getGetPolicyBasedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest,
                          com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetPolicyBasedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.PolicyBasedRoute
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBasedRoutingServiceMethodDescriptorSupplier(
                              "GetPolicyBasedRoute"))
                      .build();
        }
      }
    }
    return getGetPolicyBasedRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest,
          com.google.longrunning.Operation>
      getCreatePolicyBasedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePolicyBasedRoute",
      requestType = com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest,
          com.google.longrunning.Operation>
      getCreatePolicyBasedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest,
            com.google.longrunning.Operation>
        getCreatePolicyBasedRouteMethod;
    if ((getCreatePolicyBasedRouteMethod =
            PolicyBasedRoutingServiceGrpc.getCreatePolicyBasedRouteMethod)
        == null) {
      synchronized (PolicyBasedRoutingServiceGrpc.class) {
        if ((getCreatePolicyBasedRouteMethod =
                PolicyBasedRoutingServiceGrpc.getCreatePolicyBasedRouteMethod)
            == null) {
          PolicyBasedRoutingServiceGrpc.getCreatePolicyBasedRouteMethod =
              getCreatePolicyBasedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePolicyBasedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBasedRoutingServiceMethodDescriptorSupplier(
                              "CreatePolicyBasedRoute"))
                      .build();
        }
      }
    }
    return getCreatePolicyBasedRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest,
          com.google.longrunning.Operation>
      getDeletePolicyBasedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePolicyBasedRoute",
      requestType = com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest,
          com.google.longrunning.Operation>
      getDeletePolicyBasedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest,
            com.google.longrunning.Operation>
        getDeletePolicyBasedRouteMethod;
    if ((getDeletePolicyBasedRouteMethod =
            PolicyBasedRoutingServiceGrpc.getDeletePolicyBasedRouteMethod)
        == null) {
      synchronized (PolicyBasedRoutingServiceGrpc.class) {
        if ((getDeletePolicyBasedRouteMethod =
                PolicyBasedRoutingServiceGrpc.getDeletePolicyBasedRouteMethod)
            == null) {
          PolicyBasedRoutingServiceGrpc.getDeletePolicyBasedRouteMethod =
              getDeletePolicyBasedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePolicyBasedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyBasedRoutingServiceMethodDescriptorSupplier(
                              "DeletePolicyBasedRoute"))
                      .build();
        }
      }
    }
    return getDeletePolicyBasedRouteMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PolicyBasedRoutingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceStub>() {
          @java.lang.Override
          public PolicyBasedRoutingServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBasedRoutingServiceStub(channel, callOptions);
          }
        };
    return PolicyBasedRoutingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyBasedRoutingServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceBlockingStub>() {
          @java.lang.Override
          public PolicyBasedRoutingServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBasedRoutingServiceBlockingStub(channel, callOptions);
          }
        };
    return PolicyBasedRoutingServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PolicyBasedRoutingServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PolicyBasedRoutingServiceFutureStub>() {
          @java.lang.Override
          public PolicyBasedRoutingServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PolicyBasedRoutingServiceFutureStub(channel, callOptions);
          }
        };
    return PolicyBasedRoutingServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Policy-Based Routing allows GCP customers to specify flexibile routing
   * policies for Layer 4 traffic traversing through the connected service.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists policy-based routes in a given project and location.
     * </pre>
     */
    default void listPolicyBasedRoutes(
        com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPolicyBasedRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single policy-based route.
     * </pre>
     */
    default void getPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPolicyBasedRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new policy-based route in a given project and location.
     * </pre>
     */
    default void createPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePolicyBasedRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single policy-based route.
     * </pre>
     */
    default void deletePolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePolicyBasedRouteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PolicyBasedRoutingService.
   *
   * <pre>
   * Policy-Based Routing allows GCP customers to specify flexibile routing
   * policies for Layer 4 traffic traversing through the connected service.
   * </pre>
   */
  public abstract static class PolicyBasedRoutingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return PolicyBasedRoutingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PolicyBasedRoutingService.
   *
   * <pre>
   * Policy-Based Routing allows GCP customers to specify flexibile routing
   * policies for Layer 4 traffic traversing through the connected service.
   * </pre>
   */
  public static final class PolicyBasedRoutingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PolicyBasedRoutingServiceStub> {
    private PolicyBasedRoutingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBasedRoutingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBasedRoutingServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists policy-based routes in a given project and location.
     * </pre>
     */
    public void listPolicyBasedRoutes(
        com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPolicyBasedRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single policy-based route.
     * </pre>
     */
    public void getPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyBasedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new policy-based route in a given project and location.
     * </pre>
     */
    public void createPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePolicyBasedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single policy-based route.
     * </pre>
     */
    public void deletePolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePolicyBasedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PolicyBasedRoutingService.
   *
   * <pre>
   * Policy-Based Routing allows GCP customers to specify flexibile routing
   * policies for Layer 4 traffic traversing through the connected service.
   * </pre>
   */
  public static final class PolicyBasedRoutingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PolicyBasedRoutingServiceBlockingStub> {
    private PolicyBasedRoutingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBasedRoutingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBasedRoutingServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists policy-based routes in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse
        listPolicyBasedRoutes(
            com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPolicyBasedRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single policy-based route.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1.PolicyBasedRoute getPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyBasedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new policy-based route in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createPolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePolicyBasedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single policy-based route.
     * </pre>
     */
    public com.google.longrunning.Operation deletePolicyBasedRoute(
        com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePolicyBasedRouteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * PolicyBasedRoutingService.
   *
   * <pre>
   * Policy-Based Routing allows GCP customers to specify flexibile routing
   * policies for Layer 4 traffic traversing through the connected service.
   * </pre>
   */
  public static final class PolicyBasedRoutingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PolicyBasedRoutingServiceFutureStub> {
    private PolicyBasedRoutingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyBasedRoutingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyBasedRoutingServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists policy-based routes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>
        listPolicyBasedRoutes(
            com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPolicyBasedRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single policy-based route.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>
        getPolicyBasedRoute(
            com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyBasedRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new policy-based route in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPolicyBasedRoute(
            com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePolicyBasedRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single policy-based route.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePolicyBasedRoute(
            com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePolicyBasedRouteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_POLICY_BASED_ROUTES = 0;
  private static final int METHODID_GET_POLICY_BASED_ROUTE = 1;
  private static final int METHODID_CREATE_POLICY_BASED_ROUTE = 2;
  private static final int METHODID_DELETE_POLICY_BASED_ROUTE = 3;

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
        case METHODID_LIST_POLICY_BASED_ROUTES:
          serviceImpl.listPolicyBasedRoutes(
              (com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_POLICY_BASED_ROUTE:
          serviceImpl.getPolicyBasedRoute(
              (com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>)
                  responseObserver);
          break;
        case METHODID_CREATE_POLICY_BASED_ROUTE:
          serviceImpl.createPolicyBasedRoute(
              (com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_POLICY_BASED_ROUTE:
          serviceImpl.deletePolicyBasedRoute(
              (com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest) request,
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
            getListPolicyBasedRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesRequest,
                    com.google.cloud.networkconnectivity.v1.ListPolicyBasedRoutesResponse>(
                    service, METHODID_LIST_POLICY_BASED_ROUTES)))
        .addMethod(
            getGetPolicyBasedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.GetPolicyBasedRouteRequest,
                    com.google.cloud.networkconnectivity.v1.PolicyBasedRoute>(
                    service, METHODID_GET_POLICY_BASED_ROUTE)))
        .addMethod(
            getCreatePolicyBasedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.CreatePolicyBasedRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_POLICY_BASED_ROUTE)))
        .addMethod(
            getDeletePolicyBasedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1.DeletePolicyBasedRouteRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_POLICY_BASED_ROUTE)))
        .build();
  }

  private abstract static class PolicyBasedRoutingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyBasedRoutingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyBasedRoutingService");
    }
  }

  private static final class PolicyBasedRoutingServiceFileDescriptorSupplier
      extends PolicyBasedRoutingServiceBaseDescriptorSupplier {
    PolicyBasedRoutingServiceFileDescriptorSupplier() {}
  }

  private static final class PolicyBasedRoutingServiceMethodDescriptorSupplier
      extends PolicyBasedRoutingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PolicyBasedRoutingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PolicyBasedRoutingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PolicyBasedRoutingServiceFileDescriptorSupplier())
                      .addMethod(getListPolicyBasedRoutesMethod())
                      .addMethod(getGetPolicyBasedRouteMethod())
                      .addMethod(getCreatePolicyBasedRouteMethod())
                      .addMethod(getDeletePolicyBasedRouteMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
