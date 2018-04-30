package com.google.devtools.clouderrorreporting.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service for retrieving and updating individual error groups.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/clouderrorreporting/v1beta1/error_group_service.proto")
public final class ErrorGroupServiceGrpc {

  private ErrorGroupServiceGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.clouderrorreporting.v1beta1.ErrorGroupService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetGroupMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> METHOD_GET_GROUP = getGetGroupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getGetGroupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getGetGroupMethod() {
    return getGetGroupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getGetGroupMethodHelper() {
    io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest, com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getGetGroupMethod;
    if ((getGetGroupMethod = ErrorGroupServiceGrpc.getGetGroupMethod) == null) {
      synchronized (ErrorGroupServiceGrpc.class) {
        if ((getGetGroupMethod = ErrorGroupServiceGrpc.getGetGroupMethod) == null) {
          ErrorGroupServiceGrpc.getGetGroupMethod = getGetGroupMethod = 
              io.grpc.MethodDescriptor.<com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest, com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorGroupService", "GetGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup.getDefaultInstance()))
                  .setSchemaDescriptor(new ErrorGroupServiceMethodDescriptorSupplier("GetGroup"))
                  .build();
          }
        }
     }
     return getGetGroupMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateGroupMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> METHOD_UPDATE_GROUP = getUpdateGroupMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getUpdateGroupMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getUpdateGroupMethod() {
    return getUpdateGroupMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest,
      com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getUpdateGroupMethodHelper() {
    io.grpc.MethodDescriptor<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest, com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getUpdateGroupMethod;
    if ((getUpdateGroupMethod = ErrorGroupServiceGrpc.getUpdateGroupMethod) == null) {
      synchronized (ErrorGroupServiceGrpc.class) {
        if ((getUpdateGroupMethod = ErrorGroupServiceGrpc.getUpdateGroupMethod) == null) {
          ErrorGroupServiceGrpc.getUpdateGroupMethod = getUpdateGroupMethod = 
              io.grpc.MethodDescriptor.<com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest, com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.devtools.clouderrorreporting.v1beta1.ErrorGroupService", "UpdateGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup.getDefaultInstance()))
                  .setSchemaDescriptor(new ErrorGroupServiceMethodDescriptorSupplier("UpdateGroup"))
                  .build();
          }
        }
     }
     return getUpdateGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ErrorGroupServiceStub newStub(io.grpc.Channel channel) {
    return new ErrorGroupServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ErrorGroupServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ErrorGroupServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ErrorGroupServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ErrorGroupServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Service for retrieving and updating individual error groups.
   * </pre>
   */
  public static abstract class ErrorGroupServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get the specified group.
     * </pre>
     */
    public void getGroup(com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getGetGroupMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Replace the data for the specified group.
     * Fails if the group does not exist.
     * </pre>
     */
    public void updateGroup(com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateGroupMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetGroupMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest,
                com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>(
                  this, METHODID_GET_GROUP)))
          .addMethod(
            getUpdateGroupMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest,
                com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>(
                  this, METHODID_UPDATE_GROUP)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for retrieving and updating individual error groups.
   * </pre>
   */
  public static final class ErrorGroupServiceStub extends io.grpc.stub.AbstractStub<ErrorGroupServiceStub> {
    private ErrorGroupServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorGroupServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorGroupServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorGroupServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the specified group.
     * </pre>
     */
    public void getGroup(com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetGroupMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Replace the data for the specified group.
     * Fails if the group does not exist.
     * </pre>
     */
    public void updateGroup(com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for retrieving and updating individual error groups.
   * </pre>
   */
  public static final class ErrorGroupServiceBlockingStub extends io.grpc.stub.AbstractStub<ErrorGroupServiceBlockingStub> {
    private ErrorGroupServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorGroupServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorGroupServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorGroupServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the specified group.
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup getGroup(com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetGroupMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Replace the data for the specified group.
     * Fails if the group does not exist.
     * </pre>
     */
    public com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup updateGroup(com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateGroupMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for retrieving and updating individual error groups.
   * </pre>
   */
  public static final class ErrorGroupServiceFutureStub extends io.grpc.stub.AbstractStub<ErrorGroupServiceFutureStub> {
    private ErrorGroupServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ErrorGroupServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ErrorGroupServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ErrorGroupServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the specified group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> getGroup(
        com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetGroupMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Replace the data for the specified group.
     * Fails if the group does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup> updateGroup(
        com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateGroupMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_GROUP = 0;
  private static final int METHODID_UPDATE_GROUP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ErrorGroupServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ErrorGroupServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_GROUP:
          serviceImpl.getGroup((com.google.devtools.clouderrorreporting.v1beta1.GetGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>) responseObserver);
          break;
        case METHODID_UPDATE_GROUP:
          serviceImpl.updateGroup((com.google.devtools.clouderrorreporting.v1beta1.UpdateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.clouderrorreporting.v1beta1.ErrorGroup>) responseObserver);
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

  private static abstract class ErrorGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ErrorGroupServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.clouderrorreporting.v1beta1.ErrorGroupServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ErrorGroupService");
    }
  }

  private static final class ErrorGroupServiceFileDescriptorSupplier
      extends ErrorGroupServiceBaseDescriptorSupplier {
    ErrorGroupServiceFileDescriptorSupplier() {}
  }

  private static final class ErrorGroupServiceMethodDescriptorSupplier
      extends ErrorGroupServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ErrorGroupServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ErrorGroupServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ErrorGroupServiceFileDescriptorSupplier())
              .addMethod(getGetGroupMethodHelper())
              .addMethod(getUpdateGroupMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
