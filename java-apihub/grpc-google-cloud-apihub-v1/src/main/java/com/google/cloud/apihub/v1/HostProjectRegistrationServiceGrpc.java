/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.apihub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service is used for managing the host project registrations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/host_project_registration_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HostProjectRegistrationServiceGrpc {

  private HostProjectRegistrationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.apihub.v1.HostProjectRegistrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest,
          com.google.cloud.apihub.v1.HostProjectRegistration>
      getCreateHostProjectRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHostProjectRegistration",
      requestType = com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest.class,
      responseType = com.google.cloud.apihub.v1.HostProjectRegistration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest,
          com.google.cloud.apihub.v1.HostProjectRegistration>
      getCreateHostProjectRegistrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest,
            com.google.cloud.apihub.v1.HostProjectRegistration>
        getCreateHostProjectRegistrationMethod;
    if ((getCreateHostProjectRegistrationMethod =
            HostProjectRegistrationServiceGrpc.getCreateHostProjectRegistrationMethod)
        == null) {
      synchronized (HostProjectRegistrationServiceGrpc.class) {
        if ((getCreateHostProjectRegistrationMethod =
                HostProjectRegistrationServiceGrpc.getCreateHostProjectRegistrationMethod)
            == null) {
          HostProjectRegistrationServiceGrpc.getCreateHostProjectRegistrationMethod =
              getCreateHostProjectRegistrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest,
                          com.google.cloud.apihub.v1.HostProjectRegistration>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateHostProjectRegistration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.HostProjectRegistration
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HostProjectRegistrationServiceMethodDescriptorSupplier(
                              "CreateHostProjectRegistration"))
                      .build();
        }
      }
    }
    return getCreateHostProjectRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest,
          com.google.cloud.apihub.v1.HostProjectRegistration>
      getGetHostProjectRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHostProjectRegistration",
      requestType = com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest.class,
      responseType = com.google.cloud.apihub.v1.HostProjectRegistration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest,
          com.google.cloud.apihub.v1.HostProjectRegistration>
      getGetHostProjectRegistrationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest,
            com.google.cloud.apihub.v1.HostProjectRegistration>
        getGetHostProjectRegistrationMethod;
    if ((getGetHostProjectRegistrationMethod =
            HostProjectRegistrationServiceGrpc.getGetHostProjectRegistrationMethod)
        == null) {
      synchronized (HostProjectRegistrationServiceGrpc.class) {
        if ((getGetHostProjectRegistrationMethod =
                HostProjectRegistrationServiceGrpc.getGetHostProjectRegistrationMethod)
            == null) {
          HostProjectRegistrationServiceGrpc.getGetHostProjectRegistrationMethod =
              getGetHostProjectRegistrationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest,
                          com.google.cloud.apihub.v1.HostProjectRegistration>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetHostProjectRegistration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.HostProjectRegistration
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HostProjectRegistrationServiceMethodDescriptorSupplier(
                              "GetHostProjectRegistration"))
                      .build();
        }
      }
    }
    return getGetHostProjectRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest,
          com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
      getListHostProjectRegistrationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHostProjectRegistrations",
      requestType = com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest.class,
      responseType = com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest,
          com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
      getListHostProjectRegistrationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest,
            com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
        getListHostProjectRegistrationsMethod;
    if ((getListHostProjectRegistrationsMethod =
            HostProjectRegistrationServiceGrpc.getListHostProjectRegistrationsMethod)
        == null) {
      synchronized (HostProjectRegistrationServiceGrpc.class) {
        if ((getListHostProjectRegistrationsMethod =
                HostProjectRegistrationServiceGrpc.getListHostProjectRegistrationsMethod)
            == null) {
          HostProjectRegistrationServiceGrpc.getListHostProjectRegistrationsMethod =
              getListHostProjectRegistrationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest,
                          com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListHostProjectRegistrations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HostProjectRegistrationServiceMethodDescriptorSupplier(
                              "ListHostProjectRegistrations"))
                      .build();
        }
      }
    }
    return getListHostProjectRegistrationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HostProjectRegistrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceStub>() {
          @java.lang.Override
          public HostProjectRegistrationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HostProjectRegistrationServiceStub(channel, callOptions);
          }
        };
    return HostProjectRegistrationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HostProjectRegistrationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceBlockingStub>() {
          @java.lang.Override
          public HostProjectRegistrationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HostProjectRegistrationServiceBlockingStub(channel, callOptions);
          }
        };
    return HostProjectRegistrationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HostProjectRegistrationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HostProjectRegistrationServiceFutureStub>() {
          @java.lang.Override
          public HostProjectRegistrationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HostProjectRegistrationServiceFutureStub(channel, callOptions);
          }
        };
    return HostProjectRegistrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used for managing the host project registrations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a host project registration.
     * A Google cloud project can be registered as a host project if it is not
     * attached as a runtime project to another host project.
     * A project can be registered as a host project only once. Subsequent
     * register calls for the same project will fail.
     * </pre>
     */
    default void createHostProjectRegistration(
        com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateHostProjectRegistrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a host project registration.
     * </pre>
     */
    default void getHostProjectRegistration(
        com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetHostProjectRegistrationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists host project registrations.
     * </pre>
     */
    default void listHostProjectRegistrations(
        com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHostProjectRegistrationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HostProjectRegistrationService.
   *
   * <pre>
   * This service is used for managing the host project registrations.
   * </pre>
   */
  public abstract static class HostProjectRegistrationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HostProjectRegistrationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HostProjectRegistrationService.
   *
   * <pre>
   * This service is used for managing the host project registrations.
   * </pre>
   */
  public static final class HostProjectRegistrationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<HostProjectRegistrationServiceStub> {
    private HostProjectRegistrationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostProjectRegistrationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostProjectRegistrationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a host project registration.
     * A Google cloud project can be registered as a host project if it is not
     * attached as a runtime project to another host project.
     * A project can be registered as a host project only once. Subsequent
     * register calls for the same project will fail.
     * </pre>
     */
    public void createHostProjectRegistration(
        com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHostProjectRegistrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a host project registration.
     * </pre>
     */
    public void getHostProjectRegistration(
        com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHostProjectRegistrationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists host project registrations.
     * </pre>
     */
    public void listHostProjectRegistrations(
        com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHostProjectRegistrationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HostProjectRegistrationService.
   *
   * <pre>
   * This service is used for managing the host project registrations.
   * </pre>
   */
  public static final class HostProjectRegistrationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HostProjectRegistrationServiceBlockingStub> {
    private HostProjectRegistrationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostProjectRegistrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostProjectRegistrationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a host project registration.
     * A Google cloud project can be registered as a host project if it is not
     * attached as a runtime project to another host project.
     * A project can be registered as a host project only once. Subsequent
     * register calls for the same project will fail.
     * </pre>
     */
    public com.google.cloud.apihub.v1.HostProjectRegistration createHostProjectRegistration(
        com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHostProjectRegistrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a host project registration.
     * </pre>
     */
    public com.google.cloud.apihub.v1.HostProjectRegistration getHostProjectRegistration(
        com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHostProjectRegistrationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists host project registrations.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse
        listHostProjectRegistrations(
            com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHostProjectRegistrationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * HostProjectRegistrationService.
   *
   * <pre>
   * This service is used for managing the host project registrations.
   * </pre>
   */
  public static final class HostProjectRegistrationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HostProjectRegistrationServiceFutureStub> {
    private HostProjectRegistrationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HostProjectRegistrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HostProjectRegistrationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a host project registration.
     * A Google cloud project can be registered as a host project if it is not
     * attached as a runtime project to another host project.
     * A project can be registered as a host project only once. Subsequent
     * register calls for the same project will fail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.HostProjectRegistration>
        createHostProjectRegistration(
            com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHostProjectRegistrationMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Get a host project registration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.HostProjectRegistration>
        getHostProjectRegistration(
            com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHostProjectRegistrationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists host project registrations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>
        listHostProjectRegistrations(
            com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHostProjectRegistrationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_HOST_PROJECT_REGISTRATION = 0;
  private static final int METHODID_GET_HOST_PROJECT_REGISTRATION = 1;
  private static final int METHODID_LIST_HOST_PROJECT_REGISTRATIONS = 2;

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
        case METHODID_CREATE_HOST_PROJECT_REGISTRATION:
          serviceImpl.createHostProjectRegistration(
              (com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>)
                  responseObserver);
          break;
        case METHODID_GET_HOST_PROJECT_REGISTRATION:
          serviceImpl.getHostProjectRegistration(
              (com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.HostProjectRegistration>)
                  responseObserver);
          break;
        case METHODID_LIST_HOST_PROJECT_REGISTRATIONS:
          serviceImpl.listHostProjectRegistrations(
              (com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>)
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
            getCreateHostProjectRegistrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest,
                    com.google.cloud.apihub.v1.HostProjectRegistration>(
                    service, METHODID_CREATE_HOST_PROJECT_REGISTRATION)))
        .addMethod(
            getGetHostProjectRegistrationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest,
                    com.google.cloud.apihub.v1.HostProjectRegistration>(
                    service, METHODID_GET_HOST_PROJECT_REGISTRATION)))
        .addMethod(
            getListHostProjectRegistrationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest,
                    com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse>(
                    service, METHODID_LIST_HOST_PROJECT_REGISTRATIONS)))
        .build();
  }

  private abstract static class HostProjectRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HostProjectRegistrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.HostProjectRegistrationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HostProjectRegistrationService");
    }
  }

  private static final class HostProjectRegistrationServiceFileDescriptorSupplier
      extends HostProjectRegistrationServiceBaseDescriptorSupplier {
    HostProjectRegistrationServiceFileDescriptorSupplier() {}
  }

  private static final class HostProjectRegistrationServiceMethodDescriptorSupplier
      extends HostProjectRegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HostProjectRegistrationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HostProjectRegistrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new HostProjectRegistrationServiceFileDescriptorSupplier())
                      .addMethod(getCreateHostProjectRegistrationMethod())
                      .addMethod(getGetHostProjectRegistrationMethod())
                      .addMethod(getListHostProjectRegistrationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
