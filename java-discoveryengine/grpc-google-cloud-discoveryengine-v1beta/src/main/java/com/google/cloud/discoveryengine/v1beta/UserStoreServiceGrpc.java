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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing User Stores.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class UserStoreServiceGrpc {

  private UserStoreServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.UserStoreService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest,
          com.google.cloud.discoveryengine.v1beta.UserStore>
      getGetUserStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserStore",
      requestType = com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.UserStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest,
          com.google.cloud.discoveryengine.v1beta.UserStore>
      getGetUserStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest,
            com.google.cloud.discoveryengine.v1beta.UserStore>
        getGetUserStoreMethod;
    if ((getGetUserStoreMethod = UserStoreServiceGrpc.getGetUserStoreMethod) == null) {
      synchronized (UserStoreServiceGrpc.class) {
        if ((getGetUserStoreMethod = UserStoreServiceGrpc.getGetUserStoreMethod) == null) {
          UserStoreServiceGrpc.getGetUserStoreMethod =
              getGetUserStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest,
                          com.google.cloud.discoveryengine.v1beta.UserStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UserStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserStoreServiceMethodDescriptorSupplier("GetUserStore"))
                      .build();
        }
      }
    }
    return getGetUserStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest,
          com.google.cloud.discoveryengine.v1beta.UserStore>
      getUpdateUserStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateUserStore",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.UserStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest,
          com.google.cloud.discoveryengine.v1beta.UserStore>
      getUpdateUserStoreMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest,
            com.google.cloud.discoveryengine.v1beta.UserStore>
        getUpdateUserStoreMethod;
    if ((getUpdateUserStoreMethod = UserStoreServiceGrpc.getUpdateUserStoreMethod) == null) {
      synchronized (UserStoreServiceGrpc.class) {
        if ((getUpdateUserStoreMethod = UserStoreServiceGrpc.getUpdateUserStoreMethod) == null) {
          UserStoreServiceGrpc.getUpdateUserStoreMethod =
              getUpdateUserStoreMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest,
                          com.google.cloud.discoveryengine.v1beta.UserStore>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateUserStore"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UserStore
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new UserStoreServiceMethodDescriptorSupplier("UpdateUserStore"))
                      .build();
        }
      }
    }
    return getUpdateUserStoreMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static UserStoreServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceStub>() {
          @java.lang.Override
          public UserStoreServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserStoreServiceStub(channel, callOptions);
          }
        };
    return UserStoreServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static UserStoreServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceBlockingV2Stub>() {
          @java.lang.Override
          public UserStoreServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserStoreServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return UserStoreServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserStoreServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceBlockingStub>() {
          @java.lang.Override
          public UserStoreServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserStoreServiceBlockingStub(channel, callOptions);
          }
        };
    return UserStoreServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static UserStoreServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<UserStoreServiceFutureStub>() {
          @java.lang.Override
          public UserStoreServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new UserStoreServiceFutureStub(channel, callOptions);
          }
        };
    return UserStoreServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the User Store.
     * </pre>
     */
    default void getUserStore(
        com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetUserStoreMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the User Store.
     * </pre>
     */
    default void updateUserStore(
        com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateUserStoreMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserStoreService.
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public abstract static class UserStoreServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return UserStoreServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserStoreService.
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public static final class UserStoreServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserStoreServiceStub> {
    private UserStoreServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStoreServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStoreServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the User Store.
     * </pre>
     */
    public void getUserStore(
        com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the User Store.
     * </pre>
     */
    public void updateUserStore(
        com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateUserStoreMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserStoreService.
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public static final class UserStoreServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserStoreServiceBlockingV2Stub> {
    private UserStoreServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStoreServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStoreServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the User Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.UserStore getUserStore(
        com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetUserStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.UserStore updateUserStore(
        com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateUserStoreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UserStoreService.
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public static final class UserStoreServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserStoreServiceBlockingStub> {
    private UserStoreServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStoreServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStoreServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the User Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.UserStore getUserStore(
        com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserStoreMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User Store.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.UserStore updateUserStore(
        com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateUserStoreMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserStoreService.
   *
   * <pre>
   * Service for managing User Stores.
   * </pre>
   */
  public static final class UserStoreServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserStoreServiceFutureStub> {
    private UserStoreServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStoreServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStoreServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the User Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.UserStore>
        getUserStore(com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserStoreMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the User Store.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.UserStore>
        updateUserStore(com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateUserStoreMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_STORE = 0;
  private static final int METHODID_UPDATE_USER_STORE = 1;

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
        case METHODID_GET_USER_STORE:
          serviceImpl.getUserStore(
              (com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>)
                  responseObserver);
          break;
        case METHODID_UPDATE_USER_STORE:
          serviceImpl.updateUserStore(
              (com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.UserStore>)
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
            getGetUserStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetUserStoreRequest,
                    com.google.cloud.discoveryengine.v1beta.UserStore>(
                    service, METHODID_GET_USER_STORE)))
        .addMethod(
            getUpdateUserStoreMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateUserStoreRequest,
                    com.google.cloud.discoveryengine.v1beta.UserStore>(
                    service, METHODID_UPDATE_USER_STORE)))
        .build();
  }

  private abstract static class UserStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserStoreServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.UserStoreServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserStoreService");
    }
  }

  private static final class UserStoreServiceFileDescriptorSupplier
      extends UserStoreServiceBaseDescriptorSupplier {
    UserStoreServiceFileDescriptorSupplier() {}
  }

  private static final class UserStoreServiceMethodDescriptorSupplier
      extends UserStoreServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserStoreServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (UserStoreServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new UserStoreServiceFileDescriptorSupplier())
                      .addMethod(getGetUserStoreMethod())
                      .addMethod(getUpdateUserStoreMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
