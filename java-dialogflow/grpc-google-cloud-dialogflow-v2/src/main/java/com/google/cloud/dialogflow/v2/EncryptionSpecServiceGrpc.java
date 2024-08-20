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
package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages encryption spec settings for Dialogflow and Agent Assist.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/encryption_spec.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EncryptionSpecServiceGrpc {

  private EncryptionSpecServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dialogflow.v2.EncryptionSpecService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest,
          com.google.cloud.dialogflow.v2.EncryptionSpec>
      getGetEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEncryptionSpec",
      requestType = com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest.class,
      responseType = com.google.cloud.dialogflow.v2.EncryptionSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest,
          com.google.cloud.dialogflow.v2.EncryptionSpec>
      getGetEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest,
            com.google.cloud.dialogflow.v2.EncryptionSpec>
        getGetEncryptionSpecMethod;
    if ((getGetEncryptionSpecMethod = EncryptionSpecServiceGrpc.getGetEncryptionSpecMethod)
        == null) {
      synchronized (EncryptionSpecServiceGrpc.class) {
        if ((getGetEncryptionSpecMethod = EncryptionSpecServiceGrpc.getGetEncryptionSpecMethod)
            == null) {
          EncryptionSpecServiceGrpc.getGetEncryptionSpecMethod =
              getGetEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest,
                          com.google.cloud.dialogflow.v2.EncryptionSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.EncryptionSpec.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EncryptionSpecServiceMethodDescriptorSupplier("GetEncryptionSpec"))
                      .build();
        }
      }
    }
    return getGetEncryptionSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getInitializeEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeEncryptionSpec",
      requestType = com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getInitializeEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest,
            com.google.longrunning.Operation>
        getInitializeEncryptionSpecMethod;
    if ((getInitializeEncryptionSpecMethod =
            EncryptionSpecServiceGrpc.getInitializeEncryptionSpecMethod)
        == null) {
      synchronized (EncryptionSpecServiceGrpc.class) {
        if ((getInitializeEncryptionSpecMethod =
                EncryptionSpecServiceGrpc.getInitializeEncryptionSpecMethod)
            == null) {
          EncryptionSpecServiceGrpc.getInitializeEncryptionSpecMethod =
              getInitializeEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InitializeEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EncryptionSpecServiceMethodDescriptorSupplier(
                              "InitializeEncryptionSpec"))
                      .build();
        }
      }
    }
    return getInitializeEncryptionSpecMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EncryptionSpecServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceStub>() {
          @java.lang.Override
          public EncryptionSpecServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EncryptionSpecServiceStub(channel, callOptions);
          }
        };
    return EncryptionSpecServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EncryptionSpecServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceBlockingStub>() {
          @java.lang.Override
          public EncryptionSpecServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EncryptionSpecServiceBlockingStub(channel, callOptions);
          }
        };
    return EncryptionSpecServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EncryptionSpecServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EncryptionSpecServiceFutureStub>() {
          @java.lang.Override
          public EncryptionSpecServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EncryptionSpecServiceFutureStub(channel, callOptions);
          }
        };
    return EncryptionSpecServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages encryption spec settings for Dialogflow and Agent Assist.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    default void getEncryptionSpec(
        com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EncryptionSpec>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEncryptionSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification.  An error will
     * be thrown if the location has resources already created before the
     * initialization. Once the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    default void initializeEncryptionSpec(
        com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInitializeEncryptionSpecMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EncryptionSpecService.
   *
   * <pre>
   * Manages encryption spec settings for Dialogflow and Agent Assist.
   * </pre>
   */
  public abstract static class EncryptionSpecServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EncryptionSpecServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EncryptionSpecService.
   *
   * <pre>
   * Manages encryption spec settings for Dialogflow and Agent Assist.
   * </pre>
   */
  public static final class EncryptionSpecServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EncryptionSpecServiceStub> {
    private EncryptionSpecServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionSpecServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionSpecServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public void getEncryptionSpec(
        com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EncryptionSpec>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification.  An error will
     * be thrown if the location has resources already created before the
     * initialization. Once the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public void initializeEncryptionSpec(
        com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EncryptionSpecService.
   *
   * <pre>
   * Manages encryption spec settings for Dialogflow and Agent Assist.
   * </pre>
   */
  public static final class EncryptionSpecServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EncryptionSpecServiceBlockingStub> {
    private EncryptionSpecServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionSpecServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionSpecServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.EncryptionSpec getEncryptionSpec(
        com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification.  An error will
     * be thrown if the location has resources already created before the
     * initialization. Once the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public com.google.longrunning.Operation initializeEncryptionSpec(
        com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeEncryptionSpecMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * EncryptionSpecService.
   *
   * <pre>
   * Manages encryption spec settings for Dialogflow and Agent Assist.
   * </pre>
   */
  public static final class EncryptionSpecServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EncryptionSpecServiceFutureStub> {
    private EncryptionSpecServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EncryptionSpecServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EncryptionSpecServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.EncryptionSpec>
        getEncryptionSpec(com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEncryptionSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification.  An error will
     * be thrown if the location has resources already created before the
     * initialization. Once the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        initializeEncryptionSpec(
            com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeEncryptionSpecMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ENCRYPTION_SPEC = 0;
  private static final int METHODID_INITIALIZE_ENCRYPTION_SPEC = 1;

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
        case METHODID_GET_ENCRYPTION_SPEC:
          serviceImpl.getEncryptionSpec(
              (com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.EncryptionSpec>)
                  responseObserver);
          break;
        case METHODID_INITIALIZE_ENCRYPTION_SPEC:
          serviceImpl.initializeEncryptionSpec(
              (com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest) request,
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
            getGetEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetEncryptionSpecRequest,
                    com.google.cloud.dialogflow.v2.EncryptionSpec>(
                    service, METHODID_GET_ENCRYPTION_SPEC)))
        .addMethod(
            getInitializeEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.InitializeEncryptionSpecRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_INITIALIZE_ENCRYPTION_SPEC)))
        .build();
  }

  private abstract static class EncryptionSpecServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EncryptionSpecServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.EncryptionSpecProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EncryptionSpecService");
    }
  }

  private static final class EncryptionSpecServiceFileDescriptorSupplier
      extends EncryptionSpecServiceBaseDescriptorSupplier {
    EncryptionSpecServiceFileDescriptorSupplier() {}
  }

  private static final class EncryptionSpecServiceMethodDescriptorSupplier
      extends EncryptionSpecServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EncryptionSpecServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EncryptionSpecServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EncryptionSpecServiceFileDescriptorSupplier())
                      .addMethod(getGetEncryptionSpecMethod())
                      .addMethod(getInitializeEncryptionSpecMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
