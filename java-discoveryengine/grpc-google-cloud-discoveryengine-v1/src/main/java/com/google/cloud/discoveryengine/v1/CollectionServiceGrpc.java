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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing
 * [Collection][google.cloud.discoveryengine.v1.Collection]s.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CollectionServiceGrpc {

  private CollectionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.CollectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteCollectionRequest,
          com.google.longrunning.Operation>
      getDeleteCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCollection",
      requestType = com.google.cloud.discoveryengine.v1.DeleteCollectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteCollectionRequest,
          com.google.longrunning.Operation>
      getDeleteCollectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.DeleteCollectionRequest,
            com.google.longrunning.Operation>
        getDeleteCollectionMethod;
    if ((getDeleteCollectionMethod = CollectionServiceGrpc.getDeleteCollectionMethod) == null) {
      synchronized (CollectionServiceGrpc.class) {
        if ((getDeleteCollectionMethod = CollectionServiceGrpc.getDeleteCollectionMethod) == null) {
          CollectionServiceGrpc.getDeleteCollectionMethod =
              getDeleteCollectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.DeleteCollectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCollection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DeleteCollectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CollectionServiceMethodDescriptorSupplier("DeleteCollection"))
                      .build();
        }
      }
    }
    return getDeleteCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = CollectionServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (CollectionServiceGrpc.class) {
        if ((getGetIamPolicyMethod = CollectionServiceGrpc.getGetIamPolicyMethod) == null) {
          CollectionServiceGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CollectionServiceMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = CollectionServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (CollectionServiceGrpc.class) {
        if ((getSetIamPolicyMethod = CollectionServiceGrpc.getSetIamPolicyMethod) == null) {
          CollectionServiceGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CollectionServiceMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CollectionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CollectionServiceStub>() {
          @java.lang.Override
          public CollectionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CollectionServiceStub(channel, callOptions);
          }
        };
    return CollectionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CollectionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CollectionServiceBlockingV2Stub>() {
          @java.lang.Override
          public CollectionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CollectionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CollectionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CollectionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CollectionServiceBlockingStub>() {
          @java.lang.Override
          public CollectionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CollectionServiceBlockingStub(channel, callOptions);
          }
        };
    return CollectionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CollectionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CollectionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CollectionServiceFutureStub>() {
          @java.lang.Override
          public CollectionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CollectionServiceFutureStub(channel, callOptions);
          }
        };
    return CollectionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    default void deleteCollection(
        com.google.cloud.discoveryengine.v1.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCollectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist.
     * **Important:** When setting a policy directly on a Collection resource,
     * the only recommended roles in the bindings are:
     * `roles/discoveryengine.admin`
     * `roles/discoveryengine.agentspaceAdmin`
     * `roles/discoveryengine.viewer`
     * `roles/discoveryengine.agentspaceViewer`
     * `roles/discoveryengine.user`
     * `roles/discoveryengine.agentspaceUser`
     * Attempting to grant any other role will result in a warning in logging.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CollectionService.
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public abstract static class CollectionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CollectionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CollectionService.
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public static final class CollectionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CollectionServiceStub> {
    private CollectionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public void deleteCollection(
        com.google.cloud.discoveryengine.v1.DeleteCollectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist.
     * **Important:** When setting a policy directly on a Collection resource,
     * the only recommended roles in the bindings are:
     * `roles/discoveryengine.admin`
     * `roles/discoveryengine.agentspaceAdmin`
     * `roles/discoveryengine.viewer`
     * `roles/discoveryengine.agentspaceViewer`
     * `roles/discoveryengine.user`
     * `roles/discoveryengine.agentspaceUser`
     * Attempting to grant any other role will result in a warning in logging.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CollectionService.
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public static final class CollectionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CollectionServiceBlockingV2Stub> {
    private CollectionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollection(
        com.google.cloud.discoveryengine.v1.DeleteCollectionRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist.
     * **Important:** When setting a policy directly on a Collection resource,
     * the only recommended roles in the bindings are:
     * `roles/discoveryengine.admin`
     * `roles/discoveryengine.agentspaceAdmin`
     * `roles/discoveryengine.viewer`
     * `roles/discoveryengine.agentspaceViewer`
     * `roles/discoveryengine.user`
     * `roles/discoveryengine.agentspaceUser`
     * Attempting to grant any other role will result in a warning in logging.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CollectionService.
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public static final class CollectionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CollectionServiceBlockingStub> {
    private CollectionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollection(
        com.google.cloud.discoveryengine.v1.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCollectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist.
     * **Important:** When setting a policy directly on a Collection resource,
     * the only recommended roles in the bindings are:
     * `roles/discoveryengine.admin`
     * `roles/discoveryengine.agentspaceAdmin`
     * `roles/discoveryengine.viewer`
     * `roles/discoveryengine.agentspaceViewer`
     * `roles/discoveryengine.user`
     * `roles/discoveryengine.agentspaceUser`
     * Attempting to grant any other role will result in a warning in logging.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CollectionService.
   *
   * <pre>
   * Service for managing
   * [Collection][google.cloud.discoveryengine.v1.Collection]s.
   * </pre>
   */
  public static final class CollectionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CollectionServiceFutureStub> {
    private CollectionServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CollectionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCollection(com.google.cloud.discoveryengine.v1.DeleteCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCollectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist. An empty policy is
     * returned if the resource exists but does not have a policy set on it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for a
     * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND`
     * error is returned if the resource does not exist.
     * **Important:** When setting a policy directly on a Collection resource,
     * the only recommended roles in the bindings are:
     * `roles/discoveryengine.admin`
     * `roles/discoveryengine.agentspaceAdmin`
     * `roles/discoveryengine.viewer`
     * `roles/discoveryengine.agentspaceViewer`
     * `roles/discoveryengine.user`
     * `roles/discoveryengine.agentspaceUser`
     * Attempting to grant any other role will result in a warning in logging.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DELETE_COLLECTION = 0;
  private static final int METHODID_GET_IAM_POLICY = 1;
  private static final int METHODID_SET_IAM_POLICY = 2;

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
        case METHODID_DELETE_COLLECTION:
          serviceImpl.deleteCollection(
              (com.google.cloud.discoveryengine.v1.DeleteCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
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
            getDeleteCollectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.DeleteCollectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_COLLECTION)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .build();
  }

  private abstract static class CollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CollectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.CollectionServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CollectionService");
    }
  }

  private static final class CollectionServiceFileDescriptorSupplier
      extends CollectionServiceBaseDescriptorSupplier {
    CollectionServiceFileDescriptorSupplier() {}
  }

  private static final class CollectionServiceMethodDescriptorSupplier
      extends CollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CollectionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CollectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CollectionServiceFileDescriptorSupplier())
                      .addMethod(getDeleteCollectionMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
