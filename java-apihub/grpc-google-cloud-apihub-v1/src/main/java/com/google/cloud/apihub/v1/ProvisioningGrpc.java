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
 * This service is used for managing the data plane provisioning of the API hub.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apihub/v1/provisioning_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProvisioningGrpc {

  private ProvisioningGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apihub.v1.Provisioning";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateApiHubInstanceRequest, com.google.longrunning.Operation>
      getCreateApiHubInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApiHubInstance",
      requestType = com.google.cloud.apihub.v1.CreateApiHubInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.CreateApiHubInstanceRequest, com.google.longrunning.Operation>
      getCreateApiHubInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.CreateApiHubInstanceRequest,
            com.google.longrunning.Operation>
        getCreateApiHubInstanceMethod;
    if ((getCreateApiHubInstanceMethod = ProvisioningGrpc.getCreateApiHubInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getCreateApiHubInstanceMethod = ProvisioningGrpc.getCreateApiHubInstanceMethod)
            == null) {
          ProvisioningGrpc.getCreateApiHubInstanceMethod =
              getCreateApiHubInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.CreateApiHubInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateApiHubInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.CreateApiHubInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProvisioningMethodDescriptorSupplier("CreateApiHubInstance"))
                      .build();
        }
      }
    }
    return getCreateApiHubInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiHubInstanceRequest,
          com.google.cloud.apihub.v1.ApiHubInstance>
      getGetApiHubInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiHubInstance",
      requestType = com.google.cloud.apihub.v1.GetApiHubInstanceRequest.class,
      responseType = com.google.cloud.apihub.v1.ApiHubInstance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.GetApiHubInstanceRequest,
          com.google.cloud.apihub.v1.ApiHubInstance>
      getGetApiHubInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.GetApiHubInstanceRequest,
            com.google.cloud.apihub.v1.ApiHubInstance>
        getGetApiHubInstanceMethod;
    if ((getGetApiHubInstanceMethod = ProvisioningGrpc.getGetApiHubInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getGetApiHubInstanceMethod = ProvisioningGrpc.getGetApiHubInstanceMethod) == null) {
          ProvisioningGrpc.getGetApiHubInstanceMethod =
              getGetApiHubInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.GetApiHubInstanceRequest,
                          com.google.cloud.apihub.v1.ApiHubInstance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiHubInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.GetApiHubInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.ApiHubInstance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProvisioningMethodDescriptorSupplier("GetApiHubInstance"))
                      .build();
        }
      }
    }
    return getGetApiHubInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LookupApiHubInstanceRequest,
          com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
      getLookupApiHubInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupApiHubInstance",
      requestType = com.google.cloud.apihub.v1.LookupApiHubInstanceRequest.class,
      responseType = com.google.cloud.apihub.v1.LookupApiHubInstanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.apihub.v1.LookupApiHubInstanceRequest,
          com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
      getLookupApiHubInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.apihub.v1.LookupApiHubInstanceRequest,
            com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
        getLookupApiHubInstanceMethod;
    if ((getLookupApiHubInstanceMethod = ProvisioningGrpc.getLookupApiHubInstanceMethod) == null) {
      synchronized (ProvisioningGrpc.class) {
        if ((getLookupApiHubInstanceMethod = ProvisioningGrpc.getLookupApiHubInstanceMethod)
            == null) {
          ProvisioningGrpc.getLookupApiHubInstanceMethod =
              getLookupApiHubInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.apihub.v1.LookupApiHubInstanceRequest,
                          com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "LookupApiHubInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.LookupApiHubInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.apihub.v1.LookupApiHubInstanceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProvisioningMethodDescriptorSupplier("LookupApiHubInstance"))
                      .build();
        }
      }
    }
    return getLookupApiHubInstanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProvisioningStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProvisioningStub>() {
          @java.lang.Override
          public ProvisioningStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProvisioningStub(channel, callOptions);
          }
        };
    return ProvisioningStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProvisioningBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProvisioningBlockingStub>() {
          @java.lang.Override
          public ProvisioningBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProvisioningBlockingStub(channel, callOptions);
          }
        };
    return ProvisioningBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProvisioningFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProvisioningFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProvisioningFutureStub>() {
          @java.lang.Override
          public ProvisioningFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProvisioningFutureStub(channel, callOptions);
          }
        };
    return ProvisioningFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used for managing the data plane provisioning of the API hub.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Provisions instance resources for the API Hub.
     * </pre>
     */
    default void createApiHubInstance(
        com.google.cloud.apihub.v1.CreateApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateApiHubInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single API Hub instance.
     * </pre>
     */
    default void getApiHubInstance(
        com.google.cloud.apihub.v1.GetApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiHubInstance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetApiHubInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up an Api Hub instance in a given GCP project. There will always be
     * only one Api Hub instance for a GCP project across all locations.
     * </pre>
     */
    default void lookupApiHubInstance(
        com.google.cloud.apihub.v1.LookupApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLookupApiHubInstanceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Provisioning.
   *
   * <pre>
   * This service is used for managing the data plane provisioning of the API hub.
   * </pre>
   */
  public abstract static class ProvisioningImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProvisioningGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Provisioning.
   *
   * <pre>
   * This service is used for managing the data plane provisioning of the API hub.
   * </pre>
   */
  public static final class ProvisioningStub
      extends io.grpc.stub.AbstractAsyncStub<ProvisioningStub> {
    private ProvisioningStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions instance resources for the API Hub.
     * </pre>
     */
    public void createApiHubInstance(
        com.google.cloud.apihub.v1.CreateApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiHubInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single API Hub instance.
     * </pre>
     */
    public void getApiHubInstance(
        com.google.cloud.apihub.v1.GetApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiHubInstance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiHubInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks up an Api Hub instance in a given GCP project. There will always be
     * only one Api Hub instance for a GCP project across all locations.
     * </pre>
     */
    public void lookupApiHubInstance(
        com.google.cloud.apihub.v1.LookupApiHubInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupApiHubInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Provisioning.
   *
   * <pre>
   * This service is used for managing the data plane provisioning of the API hub.
   * </pre>
   */
  public static final class ProvisioningBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProvisioningBlockingStub> {
    private ProvisioningBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions instance resources for the API Hub.
     * </pre>
     */
    public com.google.longrunning.Operation createApiHubInstance(
        com.google.cloud.apihub.v1.CreateApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiHubInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single API Hub instance.
     * </pre>
     */
    public com.google.cloud.apihub.v1.ApiHubInstance getApiHubInstance(
        com.google.cloud.apihub.v1.GetApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiHubInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up an Api Hub instance in a given GCP project. There will always be
     * only one Api Hub instance for a GCP project across all locations.
     * </pre>
     */
    public com.google.cloud.apihub.v1.LookupApiHubInstanceResponse lookupApiHubInstance(
        com.google.cloud.apihub.v1.LookupApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupApiHubInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Provisioning.
   *
   * <pre>
   * This service is used for managing the data plane provisioning of the API hub.
   * </pre>
   */
  public static final class ProvisioningFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProvisioningFutureStub> {
    private ProvisioningFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProvisioningFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProvisioningFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions instance resources for the API Hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createApiHubInstance(com.google.cloud.apihub.v1.CreateApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiHubInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single API Hub instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.ApiHubInstance>
        getApiHubInstance(com.google.cloud.apihub.v1.GetApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiHubInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Looks up an Api Hub instance in a given GCP project. There will always be
     * only one Api Hub instance for a GCP project across all locations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>
        lookupApiHubInstance(com.google.cloud.apihub.v1.LookupApiHubInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupApiHubInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_API_HUB_INSTANCE = 0;
  private static final int METHODID_GET_API_HUB_INSTANCE = 1;
  private static final int METHODID_LOOKUP_API_HUB_INSTANCE = 2;

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
        case METHODID_CREATE_API_HUB_INSTANCE:
          serviceImpl.createApiHubInstance(
              (com.google.cloud.apihub.v1.CreateApiHubInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_API_HUB_INSTANCE:
          serviceImpl.getApiHubInstance(
              (com.google.cloud.apihub.v1.GetApiHubInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.ApiHubInstance>)
                  responseObserver);
          break;
        case METHODID_LOOKUP_API_HUB_INSTANCE:
          serviceImpl.lookupApiHubInstance(
              (com.google.cloud.apihub.v1.LookupApiHubInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>)
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
            getCreateApiHubInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.CreateApiHubInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_API_HUB_INSTANCE)))
        .addMethod(
            getGetApiHubInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.GetApiHubInstanceRequest,
                    com.google.cloud.apihub.v1.ApiHubInstance>(
                    service, METHODID_GET_API_HUB_INSTANCE)))
        .addMethod(
            getLookupApiHubInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.apihub.v1.LookupApiHubInstanceRequest,
                    com.google.cloud.apihub.v1.LookupApiHubInstanceResponse>(
                    service, METHODID_LOOKUP_API_HUB_INSTANCE)))
        .build();
  }

  private abstract static class ProvisioningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProvisioningBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apihub.v1.ProvisioningServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Provisioning");
    }
  }

  private static final class ProvisioningFileDescriptorSupplier
      extends ProvisioningBaseDescriptorSupplier {
    ProvisioningFileDescriptorSupplier() {}
  }

  private static final class ProvisioningMethodDescriptorSupplier
      extends ProvisioningBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProvisioningMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProvisioningGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProvisioningFileDescriptorSupplier())
                      .addMethod(getCreateApiHubInstanceMethod())
                      .addMethod(getGetApiHubInstanceMethod())
                      .addMethod(getLookupApiHubInstanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
