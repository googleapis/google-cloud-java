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
package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages services of an application.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServicesGrpc {

  private ServicesGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.Services";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListServicesRequest, com.google.appengine.v1.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.appengine.v1.ListServicesRequest.class,
      responseType = com.google.appengine.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.ListServicesRequest, com.google.appengine.v1.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.ListServicesRequest,
            com.google.appengine.v1.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = ServicesGrpc.getListServicesMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getListServicesMethod = ServicesGrpc.getListServicesMethod) == null) {
          ServicesGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.ListServicesRequest,
                          com.google.appengine.v1.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListServicesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.ListServicesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.GetServiceRequest, com.google.appengine.v1.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.appengine.v1.GetServiceRequest.class,
      responseType = com.google.appengine.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.GetServiceRequest, com.google.appengine.v1.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.GetServiceRequest, com.google.appengine.v1.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = ServicesGrpc.getGetServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getGetServiceMethod = ServicesGrpc.getGetServiceMethod) == null) {
          ServicesGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.GetServiceRequest, com.google.appengine.v1.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.GetServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.Service.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.appengine.v1.UpdateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.UpdateServiceRequest, com.google.longrunning.Operation>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = ServicesGrpc.getUpdateServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getUpdateServiceMethod = ServicesGrpc.getUpdateServiceMethod) == null) {
          ServicesGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.UpdateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.UpdateServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.appengine.v1.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.appengine.v1.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.appengine.v1.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.appengine.v1.DeleteServiceRequest, com.google.longrunning.Operation>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServicesGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getDeleteServiceMethod = ServicesGrpc.getDeleteServiceMethod) == null) {
          ServicesGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.appengine.v1.DeleteServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.appengine.v1.DeleteServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesStub>() {
          @java.lang.Override
          public ServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesStub(channel, callOptions);
          }
        };
    return ServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServicesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesBlockingStub>() {
          @java.lang.Override
          public ServicesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesBlockingStub(channel, callOptions);
          }
        };
    return ServicesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServicesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesFutureStub>() {
          @java.lang.Override
          public ServicesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesFutureStub(channel, callOptions);
          }
        };
    return ServicesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages services of an application.
   * </pre>
   */
  public abstract static class ServicesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all the services in the application.
     * </pre>
     */
    public void listServices(
        com.google.appengine.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the current configuration of the specified service.
     * </pre>
     */
    public void getService(
        com.google.appengine.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of the specified service.
     * </pre>
     */
    public void updateService(
        com.google.appengine.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified service and all enclosed versions.
     * </pre>
     */
    public void deleteService(
        com.google.appengine.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.ListServicesRequest,
                      com.google.appengine.v1.ListServicesResponse>(this, METHODID_LIST_SERVICES)))
          .addMethod(
              getGetServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.GetServiceRequest, com.google.appengine.v1.Service>(
                      this, METHODID_GET_SERVICE)))
          .addMethod(
              getUpdateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.UpdateServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.appengine.v1.DeleteServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_SERVICE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages services of an application.
   * </pre>
   */
  public static final class ServicesStub extends io.grpc.stub.AbstractAsyncStub<ServicesStub> {
    private ServicesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the services in the application.
     * </pre>
     */
    public void listServices(
        com.google.appengine.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the current configuration of the specified service.
     * </pre>
     */
    public void getService(
        com.google.appengine.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of the specified service.
     * </pre>
     */
    public void updateService(
        com.google.appengine.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified service and all enclosed versions.
     * </pre>
     */
    public void deleteService(
        com.google.appengine.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages services of an application.
   * </pre>
   */
  public static final class ServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServicesBlockingStub> {
    private ServicesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the services in the application.
     * </pre>
     */
    public com.google.appengine.v1.ListServicesResponse listServices(
        com.google.appengine.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the current configuration of the specified service.
     * </pre>
     */
    public com.google.appengine.v1.Service getService(
        com.google.appengine.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of the specified service.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(
        com.google.appengine.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified service and all enclosed versions.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(
        com.google.appengine.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages services of an application.
   * </pre>
   */
  public static final class ServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServicesFutureStub> {
    private ServicesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all the services in the application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.appengine.v1.ListServicesResponse>
        listServices(com.google.appengine.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the current configuration of the specified service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.Service>
        getService(com.google.appengine.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the configuration of the specified service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateService(com.google.appengine.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified service and all enclosed versions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteService(com.google.appengine.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICES = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_UPDATE_SERVICE = 2;
  private static final int METHODID_DELETE_SERVICE = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.appengine.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.appengine.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.Service>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.appengine.v1.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.appengine.v1.DeleteServiceRequest) request,
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

  private abstract static class ServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Services");
    }
  }

  private static final class ServicesFileDescriptorSupplier extends ServicesBaseDescriptorSupplier {
    ServicesFileDescriptorSupplier() {}
  }

  private static final class ServicesMethodDescriptorSupplier extends ServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServicesFileDescriptorSupplier())
                      .addMethod(getListServicesMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
