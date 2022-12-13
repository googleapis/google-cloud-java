package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The API interface for managing autoscaling policies in the
 * Dataproc API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/autoscaling_policies.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutoscalingPolicyServiceGrpc {

  private AutoscalingPolicyServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.AutoscalingPolicyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getCreateAutoscalingPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAutoscalingPolicy",
      requestType = com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest.class,
      responseType = com.google.cloud.dataproc.v1.AutoscalingPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getCreateAutoscalingPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy> getCreateAutoscalingPolicyMethod;
    if ((getCreateAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod) == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getCreateAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod) == null) {
          AutoscalingPolicyServiceGrpc.getCreateAutoscalingPolicyMethod = getCreateAutoscalingPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAutoscalingPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.AutoscalingPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new AutoscalingPolicyServiceMethodDescriptorSupplier("CreateAutoscalingPolicy"))
              .build();
        }
      }
    }
    return getCreateAutoscalingPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getUpdateAutoscalingPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAutoscalingPolicy",
      requestType = com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest.class,
      responseType = com.google.cloud.dataproc.v1.AutoscalingPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getUpdateAutoscalingPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy> getUpdateAutoscalingPolicyMethod;
    if ((getUpdateAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod) == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getUpdateAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod) == null) {
          AutoscalingPolicyServiceGrpc.getUpdateAutoscalingPolicyMethod = getUpdateAutoscalingPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAutoscalingPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.AutoscalingPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new AutoscalingPolicyServiceMethodDescriptorSupplier("UpdateAutoscalingPolicy"))
              .build();
        }
      }
    }
    return getUpdateAutoscalingPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getGetAutoscalingPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAutoscalingPolicy",
      requestType = com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest.class,
      responseType = com.google.cloud.dataproc.v1.AutoscalingPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest,
      com.google.cloud.dataproc.v1.AutoscalingPolicy> getGetAutoscalingPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy> getGetAutoscalingPolicyMethod;
    if ((getGetAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod) == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getGetAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod) == null) {
          AutoscalingPolicyServiceGrpc.getGetAutoscalingPolicyMethod = getGetAutoscalingPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest, com.google.cloud.dataproc.v1.AutoscalingPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAutoscalingPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.AutoscalingPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new AutoscalingPolicyServiceMethodDescriptorSupplier("GetAutoscalingPolicy"))
              .build();
        }
      }
    }
    return getGetAutoscalingPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest,
      com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> getListAutoscalingPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAutoscalingPolicies",
      requestType = com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest,
      com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> getListAutoscalingPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest, com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> getListAutoscalingPoliciesMethod;
    if ((getListAutoscalingPoliciesMethod = AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod) == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getListAutoscalingPoliciesMethod = AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod) == null) {
          AutoscalingPolicyServiceGrpc.getListAutoscalingPoliciesMethod = getListAutoscalingPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest, com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAutoscalingPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AutoscalingPolicyServiceMethodDescriptorSupplier("ListAutoscalingPolicies"))
              .build();
        }
      }
    }
    return getListAutoscalingPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest,
      com.google.protobuf.Empty> getDeleteAutoscalingPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAutoscalingPolicy",
      requestType = com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest,
      com.google.protobuf.Empty> getDeleteAutoscalingPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest, com.google.protobuf.Empty> getDeleteAutoscalingPolicyMethod;
    if ((getDeleteAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod) == null) {
      synchronized (AutoscalingPolicyServiceGrpc.class) {
        if ((getDeleteAutoscalingPolicyMethod = AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod) == null) {
          AutoscalingPolicyServiceGrpc.getDeleteAutoscalingPolicyMethod = getDeleteAutoscalingPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAutoscalingPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AutoscalingPolicyServiceMethodDescriptorSupplier("DeleteAutoscalingPolicy"))
              .build();
        }
      }
    }
    return getDeleteAutoscalingPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutoscalingPolicyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceStub>() {
        @java.lang.Override
        public AutoscalingPolicyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoscalingPolicyServiceStub(channel, callOptions);
        }
      };
    return AutoscalingPolicyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutoscalingPolicyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceBlockingStub>() {
        @java.lang.Override
        public AutoscalingPolicyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoscalingPolicyServiceBlockingStub(channel, callOptions);
        }
      };
    return AutoscalingPolicyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutoscalingPolicyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutoscalingPolicyServiceFutureStub>() {
        @java.lang.Override
        public AutoscalingPolicyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutoscalingPolicyServiceFutureStub(channel, callOptions);
        }
      };
    return AutoscalingPolicyServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Dataproc API.
   * </pre>
   */
  public static abstract class AutoscalingPolicyServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public void createAutoscalingPolicy(com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAutoscalingPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public void updateAutoscalingPolicy(com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAutoscalingPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public void getAutoscalingPolicy(com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAutoscalingPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public void listAutoscalingPolicies(com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAutoscalingPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public void deleteAutoscalingPolicy(com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAutoscalingPolicyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateAutoscalingPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest,
                com.google.cloud.dataproc.v1.AutoscalingPolicy>(
                  this, METHODID_CREATE_AUTOSCALING_POLICY)))
          .addMethod(
            getUpdateAutoscalingPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest,
                com.google.cloud.dataproc.v1.AutoscalingPolicy>(
                  this, METHODID_UPDATE_AUTOSCALING_POLICY)))
          .addMethod(
            getGetAutoscalingPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest,
                com.google.cloud.dataproc.v1.AutoscalingPolicy>(
                  this, METHODID_GET_AUTOSCALING_POLICY)))
          .addMethod(
            getListAutoscalingPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest,
                com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse>(
                  this, METHODID_LIST_AUTOSCALING_POLICIES)))
          .addMethod(
            getDeleteAutoscalingPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_AUTOSCALING_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceStub extends io.grpc.stub.AbstractAsyncStub<AutoscalingPolicyServiceStub> {
    private AutoscalingPolicyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutoscalingPolicyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutoscalingPolicyServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public void createAutoscalingPolicy(com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAutoscalingPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public void updateAutoscalingPolicy(com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAutoscalingPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public void getAutoscalingPolicy(com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAutoscalingPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public void listAutoscalingPolicies(com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAutoscalingPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public void deleteAutoscalingPolicy(com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAutoscalingPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutoscalingPolicyServiceBlockingStub> {
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
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.AutoscalingPolicy createAutoscalingPolicy(com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAutoscalingPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.AutoscalingPolicy updateAutoscalingPolicy(com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAutoscalingPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.AutoscalingPolicy getAutoscalingPolicy(com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAutoscalingPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse listAutoscalingPolicies(com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAutoscalingPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAutoscalingPolicy(com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAutoscalingPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The API interface for managing autoscaling policies in the
   * Dataproc API.
   * </pre>
   */
  public static final class AutoscalingPolicyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AutoscalingPolicyServiceFutureStub> {
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
     * <pre>
     * Creates new autoscaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.AutoscalingPolicy> createAutoscalingPolicy(
        com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAutoscalingPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates (replaces) autoscaling policy.
     * Disabled check for update_mask, because all updates will be full
     * replacements.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.AutoscalingPolicy> updateAutoscalingPolicy(
        com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAutoscalingPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves autoscaling policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.AutoscalingPolicy> getAutoscalingPolicy(
        com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAutoscalingPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists autoscaling policies in the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse> listAutoscalingPolicies(
        com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAutoscalingPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an autoscaling policy. It is an error to delete an autoscaling
     * policy that is in use by one or more clusters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAutoscalingPolicy(
        com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAutoscalingPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_AUTOSCALING_POLICY = 0;
  private static final int METHODID_UPDATE_AUTOSCALING_POLICY = 1;
  private static final int METHODID_GET_AUTOSCALING_POLICY = 2;
  private static final int METHODID_LIST_AUTOSCALING_POLICIES = 3;
  private static final int METHODID_DELETE_AUTOSCALING_POLICY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.createAutoscalingPolicy((com.google.cloud.dataproc.v1.CreateAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy>) responseObserver);
          break;
        case METHODID_UPDATE_AUTOSCALING_POLICY:
          serviceImpl.updateAutoscalingPolicy((com.google.cloud.dataproc.v1.UpdateAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy>) responseObserver);
          break;
        case METHODID_GET_AUTOSCALING_POLICY:
          serviceImpl.getAutoscalingPolicy((com.google.cloud.dataproc.v1.GetAutoscalingPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.AutoscalingPolicy>) responseObserver);
          break;
        case METHODID_LIST_AUTOSCALING_POLICIES:
          serviceImpl.listAutoscalingPolicies((com.google.cloud.dataproc.v1.ListAutoscalingPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListAutoscalingPoliciesResponse>) responseObserver);
          break;
        case METHODID_DELETE_AUTOSCALING_POLICY:
          serviceImpl.deleteAutoscalingPolicy((com.google.cloud.dataproc.v1.DeleteAutoscalingPolicyRequest) request,
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

  private static abstract class AutoscalingPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutoscalingPolicyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.AutoscalingPoliciesProto.getDescriptor();
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutoscalingPolicyServiceFileDescriptorSupplier())
              .addMethod(getCreateAutoscalingPolicyMethod())
              .addMethod(getUpdateAutoscalingPolicyMethod())
              .addMethod(getGetAutoscalingPolicyMethod())
              .addMethod(getListAutoscalingPoliciesMethod())
              .addMethod(getDeleteAutoscalingPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
