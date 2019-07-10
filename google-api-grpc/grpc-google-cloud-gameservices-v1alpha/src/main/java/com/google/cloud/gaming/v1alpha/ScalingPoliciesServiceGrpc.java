package com.google.cloud.gaming.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The cloud gaming scaling policy is used to configure scaling parameters for
 * each fleet.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/scaling_policies.proto")
public final class ScalingPoliciesServiceGrpc {

  private ScalingPoliciesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1alpha.ScalingPoliciesService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListScalingPoliciesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
      METHOD_LIST_SCALING_POLICIES = getListScalingPoliciesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
      getListScalingPoliciesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
      getListScalingPoliciesMethod() {
    return getListScalingPoliciesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
      getListScalingPoliciesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
            com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
        getListScalingPoliciesMethod;
    if ((getListScalingPoliciesMethod = ScalingPoliciesServiceGrpc.getListScalingPoliciesMethod)
        == null) {
      synchronized (ScalingPoliciesServiceGrpc.class) {
        if ((getListScalingPoliciesMethod = ScalingPoliciesServiceGrpc.getListScalingPoliciesMethod)
            == null) {
          ScalingPoliciesServiceGrpc.getListScalingPoliciesMethod =
              getListScalingPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
                          com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.ScalingPoliciesService",
                              "ListScalingPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScalingPoliciesServiceMethodDescriptorSupplier("ListScalingPolicies"))
                      .build();
        }
      }
    }
    return getListScalingPoliciesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetScalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
          com.google.cloud.gaming.v1alpha.ScalingPolicy>
      METHOD_GET_SCALING_POLICY = getGetScalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
          com.google.cloud.gaming.v1alpha.ScalingPolicy>
      getGetScalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
          com.google.cloud.gaming.v1alpha.ScalingPolicy>
      getGetScalingPolicyMethod() {
    return getGetScalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
          com.google.cloud.gaming.v1alpha.ScalingPolicy>
      getGetScalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
            com.google.cloud.gaming.v1alpha.ScalingPolicy>
        getGetScalingPolicyMethod;
    if ((getGetScalingPolicyMethod = ScalingPoliciesServiceGrpc.getGetScalingPolicyMethod)
        == null) {
      synchronized (ScalingPoliciesServiceGrpc.class) {
        if ((getGetScalingPolicyMethod = ScalingPoliciesServiceGrpc.getGetScalingPolicyMethod)
            == null) {
          ScalingPoliciesServiceGrpc.getGetScalingPolicyMethod =
              getGetScalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
                          com.google.cloud.gaming.v1alpha.ScalingPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.ScalingPoliciesService",
                              "GetScalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ScalingPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScalingPoliciesServiceMethodDescriptorSupplier("GetScalingPolicy"))
                      .build();
        }
      }
    }
    return getGetScalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateScalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_SCALING_POLICY = getCreateScalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getCreateScalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getCreateScalingPolicyMethod() {
    return getCreateScalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getCreateScalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
            com.google.longrunning.Operation>
        getCreateScalingPolicyMethod;
    if ((getCreateScalingPolicyMethod = ScalingPoliciesServiceGrpc.getCreateScalingPolicyMethod)
        == null) {
      synchronized (ScalingPoliciesServiceGrpc.class) {
        if ((getCreateScalingPolicyMethod = ScalingPoliciesServiceGrpc.getCreateScalingPolicyMethod)
            == null) {
          ScalingPoliciesServiceGrpc.getCreateScalingPolicyMethod =
              getCreateScalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.ScalingPoliciesService",
                              "CreateScalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScalingPoliciesServiceMethodDescriptorSupplier("CreateScalingPolicy"))
                      .build();
        }
      }
    }
    return getCreateScalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteScalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_SCALING_POLICY = getDeleteScalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteScalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteScalingPolicyMethod() {
    return getDeleteScalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteScalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteScalingPolicyMethod;
    if ((getDeleteScalingPolicyMethod = ScalingPoliciesServiceGrpc.getDeleteScalingPolicyMethod)
        == null) {
      synchronized (ScalingPoliciesServiceGrpc.class) {
        if ((getDeleteScalingPolicyMethod = ScalingPoliciesServiceGrpc.getDeleteScalingPolicyMethod)
            == null) {
          ScalingPoliciesServiceGrpc.getDeleteScalingPolicyMethod =
              getDeleteScalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.ScalingPoliciesService",
                              "DeleteScalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScalingPoliciesServiceMethodDescriptorSupplier("DeleteScalingPolicy"))
                      .build();
        }
      }
    }
    return getDeleteScalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateScalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_SCALING_POLICY = getUpdateScalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateScalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateScalingPolicyMethod() {
    return getUpdateScalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateScalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateScalingPolicyMethod;
    if ((getUpdateScalingPolicyMethod = ScalingPoliciesServiceGrpc.getUpdateScalingPolicyMethod)
        == null) {
      synchronized (ScalingPoliciesServiceGrpc.class) {
        if ((getUpdateScalingPolicyMethod = ScalingPoliciesServiceGrpc.getUpdateScalingPolicyMethod)
            == null) {
          ScalingPoliciesServiceGrpc.getUpdateScalingPolicyMethod =
              getUpdateScalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.ScalingPoliciesService",
                              "UpdateScalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScalingPoliciesServiceMethodDescriptorSupplier("UpdateScalingPolicy"))
                      .build();
        }
      }
    }
    return getUpdateScalingPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ScalingPoliciesServiceStub newStub(io.grpc.Channel channel) {
    return new ScalingPoliciesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScalingPoliciesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ScalingPoliciesServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ScalingPoliciesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ScalingPoliciesServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming scaling policy is used to configure scaling parameters for
   * each fleet.
   * </pre>
   */
  public abstract static class ScalingPoliciesServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists ScalingPolicies in a given project and location.
     * </pre>
     */
    public void listScalingPolicies(
        com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListScalingPoliciesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single scaling policy.
     * </pre>
     */
    public void getScalingPolicy(
        com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ScalingPolicy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetScalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new scaling policy in a given project and location.
     * </pre>
     */
    public void createScalingPolicy(
        com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateScalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single scaling policy.
     * </pre>
     */
    public void deleteScalingPolicy(
        com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteScalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single scaling policy.
     * </pre>
     */
    public void updateScalingPolicy(
        com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateScalingPolicyMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListScalingPoliciesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest,
                      com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>(
                      this, METHODID_LIST_SCALING_POLICIES)))
          .addMethod(
              getGetScalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest,
                      com.google.cloud.gaming.v1alpha.ScalingPolicy>(
                      this, METHODID_GET_SCALING_POLICY)))
          .addMethod(
              getCreateScalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_SCALING_POLICY)))
          .addMethod(
              getDeleteScalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_SCALING_POLICY)))
          .addMethod(
              getUpdateScalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_SCALING_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming scaling policy is used to configure scaling parameters for
   * each fleet.
   * </pre>
   */
  public static final class ScalingPoliciesServiceStub
      extends io.grpc.stub.AbstractStub<ScalingPoliciesServiceStub> {
    private ScalingPoliciesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScalingPoliciesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalingPoliciesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalingPoliciesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ScalingPolicies in a given project and location.
     * </pre>
     */
    public void listScalingPolicies(
        com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListScalingPoliciesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single scaling policy.
     * </pre>
     */
    public void getScalingPolicy(
        com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ScalingPolicy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetScalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new scaling policy in a given project and location.
     * </pre>
     */
    public void createScalingPolicy(
        com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateScalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single scaling policy.
     * </pre>
     */
    public void deleteScalingPolicy(
        com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteScalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single scaling policy.
     * </pre>
     */
    public void updateScalingPolicy(
        com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateScalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming scaling policy is used to configure scaling parameters for
   * each fleet.
   * </pre>
   */
  public static final class ScalingPoliciesServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ScalingPoliciesServiceBlockingStub> {
    private ScalingPoliciesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScalingPoliciesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalingPoliciesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalingPoliciesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ScalingPolicies in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse listScalingPolicies(
        com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListScalingPoliciesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single scaling policy.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ScalingPolicy getScalingPolicy(
        com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetScalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new scaling policy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createScalingPolicy(
        com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateScalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single scaling policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteScalingPolicy(
        com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteScalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single scaling policy.
     * </pre>
     */
    public com.google.longrunning.Operation updateScalingPolicy(
        com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateScalingPolicyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming scaling policy is used to configure scaling parameters for
   * each fleet.
   * </pre>
   */
  public static final class ScalingPoliciesServiceFutureStub
      extends io.grpc.stub.AbstractStub<ScalingPoliciesServiceFutureStub> {
    private ScalingPoliciesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScalingPoliciesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScalingPoliciesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScalingPoliciesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ScalingPolicies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>
        listScalingPolicies(com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListScalingPoliciesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single scaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ScalingPolicy>
        getScalingPolicy(com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetScalingPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new scaling policy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createScalingPolicy(com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateScalingPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single scaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteScalingPolicy(com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteScalingPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single scaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateScalingPolicy(com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateScalingPolicyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SCALING_POLICIES = 0;
  private static final int METHODID_GET_SCALING_POLICY = 1;
  private static final int METHODID_CREATE_SCALING_POLICY = 2;
  private static final int METHODID_DELETE_SCALING_POLICY = 3;
  private static final int METHODID_UPDATE_SCALING_POLICY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScalingPoliciesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScalingPoliciesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SCALING_POLICIES:
          serviceImpl.listScalingPolicies(
              (com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SCALING_POLICY:
          serviceImpl.getScalingPolicy(
              (com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ScalingPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_SCALING_POLICY:
          serviceImpl.createScalingPolicy(
              (com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SCALING_POLICY:
          serviceImpl.deleteScalingPolicy(
              (com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SCALING_POLICY:
          serviceImpl.updateScalingPolicy(
              (com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest) request,
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

  private abstract static class ScalingPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScalingPoliciesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.ScalingPolicies.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScalingPoliciesService");
    }
  }

  private static final class ScalingPoliciesServiceFileDescriptorSupplier
      extends ScalingPoliciesServiceBaseDescriptorSupplier {
    ScalingPoliciesServiceFileDescriptorSupplier() {}
  }

  private static final class ScalingPoliciesServiceMethodDescriptorSupplier
      extends ScalingPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScalingPoliciesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ScalingPoliciesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ScalingPoliciesServiceFileDescriptorSupplier())
                      .addMethod(getListScalingPoliciesMethodHelper())
                      .addMethod(getGetScalingPolicyMethodHelper())
                      .addMethod(getCreateScalingPolicyMethodHelper())
                      .addMethod(getDeleteScalingPolicyMethodHelper())
                      .addMethod(getUpdateScalingPolicyMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
