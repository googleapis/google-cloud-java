package com.google.cloud.dataproc.v1beta2;

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
 * The API interface for managing autoscaling policies in the
 * Google Cloud Dataproc API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dataproc/v1beta2/autoscaling_policies.proto")
public final class AutoscalingPolicyServiceGrpc {

  private AutoscalingPolicyServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.dataproc.v1beta2.AutoscalingPolicyService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAutoscalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      METHOD_CREATE_AUTOSCALING_POLICY = getCreateAutoscalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getCreateAutoscalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getCreateAutoscalingPolicyMethod() {
    return getCreateAutoscalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getCreateAutoscalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        getCreateAutoscalingPolicyMethod;
    if ((getCreateAutoscalingPolicyMethod =
            AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod)
        == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getCreateAutoscalingPolicyMethod =
                AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod)
            == null) {
          AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod =
              getCreateAutoscalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
                          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.AutoscalingPolicyService",
                              "CreateAutoscalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.AutoscalingPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoscalingPolicyServiceMethodDescriptorSupplier(
                              "CreateAutoscalingPolicy"))
                      .build();
        }
      }
    }
    return getCreateAutoscalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateAutoscalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      METHOD_UPDATE_AUTOSCALING_POLICY = getUpdateAutoscalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getUpdateAutoscalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getUpdateAutoscalingPolicyMethod() {
    return getUpdateAutoscalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getUpdateAutoscalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        getUpdateAutoscalingPolicyMethod;
    if ((getUpdateAutoscalingPolicyMethod =
            AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod)
        == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getUpdateAutoscalingPolicyMethod =
                AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod)
            == null) {
          AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod =
              getUpdateAutoscalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
                          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.AutoscalingPolicyService",
                              "UpdateAutoscalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.AutoscalingPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoscalingPolicyServiceMethodDescriptorSupplier(
                              "UpdateAutoscalingPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAutoscalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAutoscalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      METHOD_GET_AUTOSCALING_POLICY = getGetAutoscalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getGetAutoscalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getGetAutoscalingPolicyMethod() {
    return getGetAutoscalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
      getGetAutoscalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        getGetAutoscalingPolicyMethod;
    if ((getGetAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod)
        == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getGetAutoscalingPolicyMethod =
                AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod)
            == null) {
          AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod =
              getGetAutoscalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
                          com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.AutoscalingPolicyService",
                              "GetAutoscalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.AutoscalingPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoscalingPolicyServiceMethodDescriptorSupplier(
                              "GetAutoscalingPolicy"))
                      .build();
        }
      }
    }
    return getGetAutoscalingPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAutoscalingPoliciesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
      METHOD_LIST_AUTOSCALING_POLICIES = getListAutoscalingPoliciesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
      getListAutoscalingPoliciesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
      getListAutoscalingPoliciesMethod() {
    return getListAutoscalingPoliciesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
      getListAutoscalingPoliciesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
            com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
        getListAutoscalingPoliciesMethod;
    if ((getListAutoscalingPoliciesMethod =
            AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod)
        == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getListAutoscalingPoliciesMethod =
                AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod)
            == null) {
          AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod =
              getListAutoscalingPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
                          com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.AutoscalingPolicyService",
                              "ListAutoscalingPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoscalingPolicyServiceMethodDescriptorSupplier(
                              "ListAutoscalingPolicies"))
                      .build();
        }
      }
    }
    return getListAutoscalingPoliciesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAutoscalingPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
          com.google.protobuf.Empty>
      METHOD_DELETE_AUTOSCALING_POLICY = getDeleteAutoscalingPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
          com.google.protobuf.Empty>
      getDeleteAutoscalingPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
          com.google.protobuf.Empty>
      getDeleteAutoscalingPolicyMethod() {
    return getDeleteAutoscalingPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
          com.google.protobuf.Empty>
      getDeleteAutoscalingPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
            com.google.protobuf.Empty>
        getDeleteAutoscalingPolicyMethod;
    if ((getDeleteAutoscalingPolicyMethod =
            AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod)
        == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getDeleteAutoscalingPolicyMethod =
                AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod)
            == null) {
          AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod =
              getDeleteAutoscalingPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.AutoscalingPolicyService",
                              "DeleteAutoscalingPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AutoscalingPolicyServiceMethodDescriptorSupplier(
                              "DeleteAutoscalingPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAutoscalingPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AutoscalingPolicyServiceStub newStub(io.grpc.Channel channel) {
    return new AutoscalingPolicyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutoscalingPolicyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new AutoscalingPolicyServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AutoscalingPolicyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new AutoscalingPolicyServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Google Cloud Dataproc API.
   * </pre>
   */
  public abstract static class AutoscalingPolicyServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public void createAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAutoscalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public void updateAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAutoscalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public void getAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetAutoscalingPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public void listAutoscalingPolicies(
        com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAutoscalingPoliciesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public void deleteAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAutoscalingPolicyMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAutoscalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest,
                      com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>(
                      this, METHODID_CREATE_AUTOSCALING_POLICY)))
          .addMethod(
              getUpdateAutoscalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest,
                      com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>(
                      this, METHODID_UPDATE_AUTOSCALING_POLICY)))
          .addMethod(
              getGetAutoscalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest,
                      com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>(
                      this, METHODID_GET_AUTOSCALING_POLICY)))
          .addMethod(
              getListAutoscalingPoliciesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest,
                      com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>(
                      this, METHODID_LIST_AUTOSCALING_POLICIES)))
          .addMethod(
              getDeleteAutoscalingPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_AUTOSCALING_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Google Cloud Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceStub
      extends io.grpc.stub.AbstractStub<AutoscalingPolicyServiceStub> {
    private AutoscalingPolicyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutoscalingPolicyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoscalingPolicyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoscalingPolicyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public void createAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAutoscalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public void updateAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAutoscalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public void getAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAutoscalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public void listAutoscalingPolicies(
        com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAutoscalingPoliciesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public void deleteAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAutoscalingPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Google Cloud Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceBlockingStub
      extends io.grpc.stub.AbstractStub<AutoscalingPolicyServiceBlockingStub> {
    private AutoscalingPolicyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutoscalingPolicyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoscalingPolicyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoscalingPolicyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.AutoscalingPolicy createAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAutoscalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.AutoscalingPolicy updateAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAutoscalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.AutoscalingPolicy getAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAutoscalingPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse
        listAutoscalingPolicies(
            com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAutoscalingPoliciesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAutoscalingPolicy(
        com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAutoscalingPolicyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Google Cloud Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceFutureStub
      extends io.grpc.stub.AbstractStub<AutoscalingPolicyServiceFutureStub> {
    private AutoscalingPolicyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AutoscalingPolicyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoscalingPolicyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoscalingPolicyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        createAutoscalingPolicy(
            com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAutoscalingPolicyMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        updateAutoscalingPolicy(
            com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAutoscalingPolicyMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>
        getAutoscalingPolicy(
            com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAutoscalingPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>
        listAutoscalingPolicies(
            com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAutoscalingPoliciesMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAutoscalingPolicy(
            com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAutoscalingPolicyMethodHelper(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_AUTOSCALING_POLICY = 0;
  private static final int METHODID_UPDATE_AUTOSCALING_POLICY = 1;
  private static final int METHODID_GET_AUTOSCALING_POLICY = 2;
  private static final int METHODID_LIST_AUTOSCALING_POLICIES = 3;
  private static final int METHODID_DELETE_AUTOSCALING_POLICY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutoscalingPolicyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutoscalingPolicyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_AUTOSCALING_POLICY:
          serviceImpl.createAutoscalingPolicy(
              (com.google.cloud.dataproc.v1beta2.CreateAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_AUTOSCALING_POLICY:
          serviceImpl.updateAutoscalingPolicy(
              (com.google.cloud.dataproc.v1beta2.UpdateAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>)
                  responseObserver);
          break;
        case METHODID_GET_AUTOSCALING_POLICY:
          serviceImpl.getAutoscalingPolicy(
              (com.google.cloud.dataproc.v1beta2.GetAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.AutoscalingPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_AUTOSCALING_POLICIES:
          serviceImpl.listAutoscalingPolicies(
              (com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataproc.v1beta2.ListAutoscalingPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_AUTOSCALING_POLICY:
          serviceImpl.deleteAutoscalingPolicy(
              (com.google.cloud.dataproc.v1beta2.DeleteAutoscalingPolicyRequest) request,
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

  private abstract static class AutoscalingPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutoscalingPolicyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1beta2.AutoscalingPoliciesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutoscalingPolicyService");
    }
  }

  private static final class AutoscalingPolicyServiceFileDescriptorSupplier
      extends AutoscalingPolicyServiceBaseDescriptorSupplier {
    AutoscalingPolicyServiceFileDescriptorSupplier() {}
  }

  private static final class AutoscalingPolicyServiceMethodDescriptorSupplier
      extends AutoscalingPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutoscalingPolicyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AutoscalingPolicyServiceFileDescriptorSupplier())
                      .addMethod(getCreateAutoscalingPolicyMethodHelper())
                      .addMethod(getUpdateAutoscalingPolicyMethodHelper())
                      .addMethod(getGetAutoscalingPolicyMethodHelper())
                      .addMethod(getListAutoscalingPoliciesMethodHelper())
                      .addMethod(getDeleteAutoscalingPolicyMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
