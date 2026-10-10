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
package com.google.cloud.networkservices.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class NetworkServicesGrpc {

  private NetworkServicesGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkservices.v1beta1.NetworkServices";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest,
          com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
      getListEndpointPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpointPolicies",
      requestType = com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest.class,
      responseType = com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest,
          com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
      getListEndpointPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest,
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
        getListEndpointPoliciesMethod;
    if ((getListEndpointPoliciesMethod = NetworkServicesGrpc.getListEndpointPoliciesMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getListEndpointPoliciesMethod = NetworkServicesGrpc.getListEndpointPoliciesMethod)
            == null) {
          NetworkServicesGrpc.getListEndpointPoliciesMethod =
              getListEndpointPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest,
                          com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEndpointPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("ListEndpointPolicies"))
                      .build();
        }
      }
    }
    return getListEndpointPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest,
          com.google.cloud.networkservices.v1beta1.EndpointPolicy>
      getGetEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest.class,
      responseType = com.google.cloud.networkservices.v1beta1.EndpointPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest,
          com.google.cloud.networkservices.v1beta1.EndpointPolicy>
      getGetEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest,
            com.google.cloud.networkservices.v1beta1.EndpointPolicy>
        getGetEndpointPolicyMethod;
    if ((getGetEndpointPolicyMethod = NetworkServicesGrpc.getGetEndpointPolicyMethod) == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getGetEndpointPolicyMethod = NetworkServicesGrpc.getGetEndpointPolicyMethod) == null) {
          NetworkServicesGrpc.getGetEndpointPolicyMethod =
              getGetEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest,
                          com.google.cloud.networkservices.v1beta1.EndpointPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.EndpointPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("GetEndpointPolicy"))
                      .build();
        }
      }
    }
    return getGetEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getCreateEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getCreateEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getCreateEndpointPolicyMethod;
    if ((getCreateEndpointPolicyMethod = NetworkServicesGrpc.getCreateEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getCreateEndpointPolicyMethod = NetworkServicesGrpc.getCreateEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getCreateEndpointPolicyMethod =
              getCreateEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("CreateEndpointPolicy"))
                      .build();
        }
      }
    }
    return getCreateEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateEndpointPolicyMethod;
    if ((getUpdateEndpointPolicyMethod = NetworkServicesGrpc.getUpdateEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getUpdateEndpointPolicyMethod = NetworkServicesGrpc.getUpdateEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getUpdateEndpointPolicyMethod =
              getUpdateEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("UpdateEndpointPolicy"))
                      .build();
        }
      }
    }
    return getUpdateEndpointPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpointPolicy",
      requestType = com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteEndpointPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteEndpointPolicyMethod;
    if ((getDeleteEndpointPolicyMethod = NetworkServicesGrpc.getDeleteEndpointPolicyMethod)
        == null) {
      synchronized (NetworkServicesGrpc.class) {
        if ((getDeleteEndpointPolicyMethod = NetworkServicesGrpc.getDeleteEndpointPolicyMethod)
            == null) {
          NetworkServicesGrpc.getDeleteEndpointPolicyMethod =
              getDeleteEndpointPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEndpointPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new NetworkServicesMethodDescriptorSupplier("DeleteEndpointPolicy"))
                      .build();
        }
      }
    }
    return getDeleteEndpointPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static NetworkServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesStub>() {
          @java.lang.Override
          public NetworkServicesStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesStub(channel, callOptions);
          }
        };
    return NetworkServicesStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static NetworkServicesBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingV2Stub>() {
          @java.lang.Override
          public NetworkServicesBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesBlockingV2Stub(channel, callOptions);
          }
        };
    return NetworkServicesBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NetworkServicesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesBlockingStub>() {
          @java.lang.Override
          public NetworkServicesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesBlockingStub(channel, callOptions);
          }
        };
    return NetworkServicesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static NetworkServicesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<NetworkServicesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<NetworkServicesFutureStub>() {
          @java.lang.Override
          public NetworkServicesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new NetworkServicesFutureStub(channel, callOptions);
          }
        };
    return NetworkServicesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    default void listEndpointPolicies(
        com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEndpointPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    default void getEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1beta1.EndpointPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    default void createEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    default void updateEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    default void deleteEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEndpointPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service NetworkServices.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public abstract static class NetworkServicesImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return NetworkServicesGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service NetworkServices.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class NetworkServicesStub
      extends io.grpc.stub.AbstractAsyncStub<NetworkServicesStub> {
    private NetworkServicesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public void listEndpointPolicies(
        com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public void getEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1beta1.EndpointPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public void createEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public void updateEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public void deleteEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEndpointPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service NetworkServices.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class NetworkServicesBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<NetworkServicesBlockingV2Stub> {
    private NetworkServicesBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse
        listEndpointPolicies(
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListEndpointPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public com.google.cloud.networkservices.v1beta1.EndpointPolicy getEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteEndpointPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service NetworkServices.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class NetworkServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<NetworkServicesBlockingStub> {
    private NetworkServicesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse
        listEndpointPolicies(
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public com.google.cloud.networkservices.v1beta1.EndpointPolicy getEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation updateEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEndpointPolicy(
        com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEndpointPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service NetworkServices.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class NetworkServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<NetworkServicesFutureStub> {
    private NetworkServicesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NetworkServicesFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new NetworkServicesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists EndpointPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>
        listEndpointPolicies(
            com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkservices.v1beta1.EndpointPolicy>
        getEndpointPolicy(
            com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new EndpointPolicy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEndpointPolicy(
            com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEndpointPolicy(
            com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single EndpointPolicy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEndpointPolicy(
            com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEndpointPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENDPOINT_POLICIES = 0;
  private static final int METHODID_GET_ENDPOINT_POLICY = 1;
  private static final int METHODID_CREATE_ENDPOINT_POLICY = 2;
  private static final int METHODID_UPDATE_ENDPOINT_POLICY = 3;
  private static final int METHODID_DELETE_ENDPOINT_POLICY = 4;

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
        case METHODID_LIST_ENDPOINT_POLICIES:
          serviceImpl.listEndpointPolicies(
              (com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENDPOINT_POLICY:
          serviceImpl.getEndpointPolicy(
              (com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkservices.v1beta1.EndpointPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENDPOINT_POLICY:
          serviceImpl.createEndpointPolicy(
              (com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT_POLICY:
          serviceImpl.updateEndpointPolicy(
              (com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT_POLICY:
          serviceImpl.deleteEndpointPolicy(
              (com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest) request,
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
            getListEndpointPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesRequest,
                    com.google.cloud.networkservices.v1beta1.ListEndpointPoliciesResponse>(
                    service, METHODID_LIST_ENDPOINT_POLICIES)))
        .addMethod(
            getGetEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1beta1.GetEndpointPolicyRequest,
                    com.google.cloud.networkservices.v1beta1.EndpointPolicy>(
                    service, METHODID_GET_ENDPOINT_POLICY)))
        .addMethod(
            getCreateEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1beta1.CreateEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENDPOINT_POLICY)))
        .addMethod(
            getUpdateEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1beta1.UpdateEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENDPOINT_POLICY)))
        .addMethod(
            getDeleteEndpointPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkservices.v1beta1.DeleteEndpointPolicyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENDPOINT_POLICY)))
        .build();
  }

  private abstract static class NetworkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NetworkServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkservices.v1beta1.NetworkServicesOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NetworkServices");
    }
  }

  private static final class NetworkServicesFileDescriptorSupplier
      extends NetworkServicesBaseDescriptorSupplier {
    NetworkServicesFileDescriptorSupplier() {}
  }

  private static final class NetworkServicesMethodDescriptorSupplier
      extends NetworkServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    NetworkServicesMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (NetworkServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new NetworkServicesFileDescriptorSupplier())
                      .addMethod(getListEndpointPoliciesMethod())
                      .addMethod(getGetEndpointPolicyMethod())
                      .addMethod(getCreateEndpointPolicyMethod())
                      .addMethod(getUpdateEndpointPolicyMethod())
                      .addMethod(getDeleteEndpointPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
