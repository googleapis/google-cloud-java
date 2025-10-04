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
package com.google.shopping.merchant.accounts.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to access Developer Registration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1/developerregistration.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DeveloperRegistrationServiceGrpc {

  private DeveloperRegistrationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1.DeveloperRegistrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.RegisterGcpRequest,
          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
      getRegisterGcpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterGcp",
      requestType = com.google.shopping.merchant.accounts.v1.RegisterGcpRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.DeveloperRegistration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.RegisterGcpRequest,
          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
      getRegisterGcpMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.RegisterGcpRequest,
            com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
        getRegisterGcpMethod;
    if ((getRegisterGcpMethod = DeveloperRegistrationServiceGrpc.getRegisterGcpMethod) == null) {
      synchronized (DeveloperRegistrationServiceGrpc.class) {
        if ((getRegisterGcpMethod = DeveloperRegistrationServiceGrpc.getRegisterGcpMethod)
            == null) {
          DeveloperRegistrationServiceGrpc.getRegisterGcpMethod =
              getRegisterGcpMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.RegisterGcpRequest,
                          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterGcp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.RegisterGcpRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.DeveloperRegistration
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperRegistrationServiceMethodDescriptorSupplier("RegisterGcp"))
                      .build();
        }
      }
    }
    return getRegisterGcpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest,
          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
      getGetDeveloperRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeveloperRegistration",
      requestType = com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1.DeveloperRegistration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest,
          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
      getGetDeveloperRegistrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest,
            com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
        getGetDeveloperRegistrationMethod;
    if ((getGetDeveloperRegistrationMethod =
            DeveloperRegistrationServiceGrpc.getGetDeveloperRegistrationMethod)
        == null) {
      synchronized (DeveloperRegistrationServiceGrpc.class) {
        if ((getGetDeveloperRegistrationMethod =
                DeveloperRegistrationServiceGrpc.getGetDeveloperRegistrationMethod)
            == null) {
          DeveloperRegistrationServiceGrpc.getGetDeveloperRegistrationMethod =
              getGetDeveloperRegistrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest,
                          com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDeveloperRegistration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1
                                  .GetDeveloperRegistrationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.DeveloperRegistration
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperRegistrationServiceMethodDescriptorSupplier(
                              "GetDeveloperRegistration"))
                      .build();
        }
      }
    }
    return getGetDeveloperRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest, com.google.protobuf.Empty>
      getUnregisterGcpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnregisterGcp",
      requestType = com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest, com.google.protobuf.Empty>
      getUnregisterGcpMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest,
            com.google.protobuf.Empty>
        getUnregisterGcpMethod;
    if ((getUnregisterGcpMethod = DeveloperRegistrationServiceGrpc.getUnregisterGcpMethod)
        == null) {
      synchronized (DeveloperRegistrationServiceGrpc.class) {
        if ((getUnregisterGcpMethod = DeveloperRegistrationServiceGrpc.getUnregisterGcpMethod)
            == null) {
          DeveloperRegistrationServiceGrpc.getUnregisterGcpMethod =
              getUnregisterGcpMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnregisterGcp"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DeveloperRegistrationServiceMethodDescriptorSupplier("UnregisterGcp"))
                      .build();
        }
      }
    }
    return getUnregisterGcpMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DeveloperRegistrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceStub>() {
          @java.lang.Override
          public DeveloperRegistrationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperRegistrationServiceStub(channel, callOptions);
          }
        };
    return DeveloperRegistrationServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static DeveloperRegistrationServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceBlockingV2Stub>() {
          @java.lang.Override
          public DeveloperRegistrationServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperRegistrationServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return DeveloperRegistrationServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeveloperRegistrationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceBlockingStub>() {
          @java.lang.Override
          public DeveloperRegistrationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperRegistrationServiceBlockingStub(channel, callOptions);
          }
        };
    return DeveloperRegistrationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DeveloperRegistrationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DeveloperRegistrationServiceFutureStub>() {
          @java.lang.Override
          public DeveloperRegistrationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DeveloperRegistrationServiceFutureStub(channel, callOptions);
          }
        };
    return DeveloperRegistrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Registers the GCP used for the API call to the shopping account passed in
     * the request. Will create a user with an "API developer" and add the
     * "developer_email" as a contact with "API notifications" email preference
     * on.
     * </pre>
     */
    default void registerGcp(
        com.google.shopping.merchant.accounts.v1.RegisterGcpRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterGcpMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a developer registration for a merchant.
     * </pre>
     */
    default void getDeveloperRegistration(
        com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDeveloperRegistrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unregister the calling GCP from the calling shopping account. Note that the
     * GCP will still be able to access the API for at most 1 day from the
     * unregister succussful call.
     * </pre>
     */
    default void unregisterGcp(
        com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUnregisterGcpMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DeveloperRegistrationService.
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public abstract static class DeveloperRegistrationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DeveloperRegistrationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DeveloperRegistrationService.
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public static final class DeveloperRegistrationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DeveloperRegistrationServiceStub> {
    private DeveloperRegistrationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperRegistrationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperRegistrationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the GCP used for the API call to the shopping account passed in
     * the request. Will create a user with an "API developer" and add the
     * "developer_email" as a contact with "API notifications" email preference
     * on.
     * </pre>
     */
    public void registerGcp(
        com.google.shopping.merchant.accounts.v1.RegisterGcpRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterGcpMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a developer registration for a merchant.
     * </pre>
     */
    public void getDeveloperRegistration(
        com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeveloperRegistrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Unregister the calling GCP from the calling shopping account. Note that the
     * GCP will still be able to access the API for at most 1 day from the
     * unregister succussful call.
     * </pre>
     */
    public void unregisterGcp(
        com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnregisterGcpMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DeveloperRegistrationService.
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public static final class DeveloperRegistrationServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperRegistrationServiceBlockingV2Stub> {
    private DeveloperRegistrationServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperRegistrationServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperRegistrationServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the GCP used for the API call to the shopping account passed in
     * the request. Will create a user with an "API developer" and add the
     * "developer_email" as a contact with "API notifications" email preference
     * on.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.DeveloperRegistration registerGcp(
        com.google.shopping.merchant.accounts.v1.RegisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterGcpMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a developer registration for a merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.DeveloperRegistration getDeveloperRegistration(
        com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeveloperRegistrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unregister the calling GCP from the calling shopping account. Note that the
     * GCP will still be able to access the API for at most 1 day from the
     * unregister succussful call.
     * </pre>
     */
    public com.google.protobuf.Empty unregisterGcp(
        com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnregisterGcpMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * DeveloperRegistrationService.
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public static final class DeveloperRegistrationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DeveloperRegistrationServiceBlockingStub> {
    private DeveloperRegistrationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperRegistrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperRegistrationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the GCP used for the API call to the shopping account passed in
     * the request. Will create a user with an "API developer" and add the
     * "developer_email" as a contact with "API notifications" email preference
     * on.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.DeveloperRegistration registerGcp(
        com.google.shopping.merchant.accounts.v1.RegisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterGcpMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a developer registration for a merchant.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1.DeveloperRegistration getDeveloperRegistration(
        com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeveloperRegistrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Unregister the calling GCP from the calling shopping account. Note that the
     * GCP will still be able to access the API for at most 1 day from the
     * unregister succussful call.
     * </pre>
     */
    public com.google.protobuf.Empty unregisterGcp(
        com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnregisterGcpMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * DeveloperRegistrationService.
   *
   * <pre>
   * Service to access Developer Registration.
   * </pre>
   */
  public static final class DeveloperRegistrationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DeveloperRegistrationServiceFutureStub> {
    private DeveloperRegistrationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeveloperRegistrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DeveloperRegistrationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Registers the GCP used for the API call to the shopping account passed in
     * the request. Will create a user with an "API developer" and add the
     * "developer_email" as a contact with "API notifications" email preference
     * on.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
        registerGcp(com.google.shopping.merchant.accounts.v1.RegisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterGcpMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a developer registration for a merchant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1.DeveloperRegistration>
        getDeveloperRegistration(
            com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeveloperRegistrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Unregister the calling GCP from the calling shopping account. Note that the
     * GCP will still be able to access the API for at most 1 day from the
     * unregister succussful call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        unregisterGcp(com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnregisterGcpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_GCP = 0;
  private static final int METHODID_GET_DEVELOPER_REGISTRATION = 1;
  private static final int METHODID_UNREGISTER_GCP = 2;

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
        case METHODID_REGISTER_GCP:
          serviceImpl.registerGcp(
              (com.google.shopping.merchant.accounts.v1.RegisterGcpRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.DeveloperRegistration>)
                  responseObserver);
          break;
        case METHODID_GET_DEVELOPER_REGISTRATION:
          serviceImpl.getDeveloperRegistration(
              (com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1.DeveloperRegistration>)
                  responseObserver);
          break;
        case METHODID_UNREGISTER_GCP:
          serviceImpl.unregisterGcp(
              (com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getRegisterGcpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.RegisterGcpRequest,
                    com.google.shopping.merchant.accounts.v1.DeveloperRegistration>(
                    service, METHODID_REGISTER_GCP)))
        .addMethod(
            getGetDeveloperRegistrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest,
                    com.google.shopping.merchant.accounts.v1.DeveloperRegistration>(
                    service, METHODID_GET_DEVELOPER_REGISTRATION)))
        .addMethod(
            getUnregisterGcpMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest,
                    com.google.protobuf.Empty>(service, METHODID_UNREGISTER_GCP)))
        .build();
  }

  private abstract static class DeveloperRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeveloperRegistrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1.DeveloperRegistrationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeveloperRegistrationService");
    }
  }

  private static final class DeveloperRegistrationServiceFileDescriptorSupplier
      extends DeveloperRegistrationServiceBaseDescriptorSupplier {
    DeveloperRegistrationServiceFileDescriptorSupplier() {}
  }

  private static final class DeveloperRegistrationServiceMethodDescriptorSupplier
      extends DeveloperRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DeveloperRegistrationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DeveloperRegistrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DeveloperRegistrationServiceFileDescriptorSupplier())
                      .addMethod(getRegisterGcpMethod())
                      .addMethod(getGetDeveloperRegistrationMethod())
                      .addMethod(getUnregisterGcpMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
