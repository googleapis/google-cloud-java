package com.google.cloud.assuredworkloads.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service to manage AssuredWorkloads.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/assuredworkloads/v1beta1/assuredworkloads_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssuredWorkloadsServiceGrpc {

  private AssuredWorkloadsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest,
      com.google.longrunning.Operation> getCreateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkload",
      requestType = com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest,
      com.google.longrunning.Operation> getCreateWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest, com.google.longrunning.Operation> getCreateWorkloadMethod;
    if ((getCreateWorkloadMethod = AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getCreateWorkloadMethod = AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod) == null) {
          AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod = getCreateWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("CreateWorkload"))
              .build();
        }
      }
    }
    return getCreateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest,
      com.google.cloud.assuredworkloads.v1beta1.Workload> getUpdateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkload",
      requestType = com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1beta1.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest,
      com.google.cloud.assuredworkloads.v1beta1.Workload> getUpdateWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest, com.google.cloud.assuredworkloads.v1beta1.Workload> getUpdateWorkloadMethod;
    if ((getUpdateWorkloadMethod = AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getUpdateWorkloadMethod = AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod) == null) {
          AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod = getUpdateWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest, com.google.cloud.assuredworkloads.v1beta1.Workload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.Workload.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("UpdateWorkload"))
              .build();
        }
      }
    }
    return getUpdateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest,
      com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> getRestrictAllowedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestrictAllowedResources",
      requestType = com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest,
      com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> getRestrictAllowedResourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest, com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> getRestrictAllowedResourcesMethod;
    if ((getRestrictAllowedResourcesMethod = AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getRestrictAllowedResourcesMethod = AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod) == null) {
          AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod = getRestrictAllowedResourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest, com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestrictAllowedResources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("RestrictAllowedResources"))
              .build();
        }
      }
    }
    return getRestrictAllowedResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest,
      com.google.protobuf.Empty> getDeleteWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkload",
      requestType = com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest,
      com.google.protobuf.Empty> getDeleteWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest, com.google.protobuf.Empty> getDeleteWorkloadMethod;
    if ((getDeleteWorkloadMethod = AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getDeleteWorkloadMethod = AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod) == null) {
          AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod = getDeleteWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("DeleteWorkload"))
              .build();
        }
      }
    }
    return getDeleteWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest,
      com.google.cloud.assuredworkloads.v1beta1.Workload> getGetWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkload",
      requestType = com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1beta1.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest,
      com.google.cloud.assuredworkloads.v1beta1.Workload> getGetWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest, com.google.cloud.assuredworkloads.v1beta1.Workload> getGetWorkloadMethod;
    if ((getGetWorkloadMethod = AssuredWorkloadsServiceGrpc.getGetWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getGetWorkloadMethod = AssuredWorkloadsServiceGrpc.getGetWorkloadMethod) == null) {
          AssuredWorkloadsServiceGrpc.getGetWorkloadMethod = getGetWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest, com.google.cloud.assuredworkloads.v1beta1.Workload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.Workload.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("GetWorkload"))
              .build();
        }
      }
    }
    return getGetWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest,
      com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> getAnalyzeWorkloadMoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeWorkloadMove",
      requestType = com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest,
      com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> getAnalyzeWorkloadMoveMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest, com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> getAnalyzeWorkloadMoveMethod;
    if ((getAnalyzeWorkloadMoveMethod = AssuredWorkloadsServiceGrpc.getAnalyzeWorkloadMoveMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getAnalyzeWorkloadMoveMethod = AssuredWorkloadsServiceGrpc.getAnalyzeWorkloadMoveMethod) == null) {
          AssuredWorkloadsServiceGrpc.getAnalyzeWorkloadMoveMethod = getAnalyzeWorkloadMoveMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest, com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeWorkloadMove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("AnalyzeWorkloadMove"))
              .build();
        }
      }
    }
    return getAnalyzeWorkloadMoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest,
      com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloads",
      requestType = com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest,
      com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest, com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> getListWorkloadsMethod;
    if ((getListWorkloadsMethod = AssuredWorkloadsServiceGrpc.getListWorkloadsMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getListWorkloadsMethod = AssuredWorkloadsServiceGrpc.getListWorkloadsMethod) == null) {
          AssuredWorkloadsServiceGrpc.getListWorkloadsMethod = getListWorkloadsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest, com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloads"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AssuredWorkloadsServiceMethodDescriptorSupplier("ListWorkloads"))
              .build();
        }
      }
    }
    return getListWorkloadsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AssuredWorkloadsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceStub>() {
        @java.lang.Override
        public AssuredWorkloadsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssuredWorkloadsServiceStub(channel, callOptions);
        }
      };
    return AssuredWorkloadsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssuredWorkloadsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceBlockingStub>() {
        @java.lang.Override
        public AssuredWorkloadsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssuredWorkloadsServiceBlockingStub(channel, callOptions);
        }
      };
    return AssuredWorkloadsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AssuredWorkloadsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceFutureStub>() {
        @java.lang.Override
        public AssuredWorkloadsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AssuredWorkloadsServiceFutureStub(channel, callOptions);
        }
      };
    return AssuredWorkloadsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static abstract class AssuredWorkloadsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public void createWorkload(com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public void updateWorkload(com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public void restrictAllowedResources(com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestrictAllowedResourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * In addition to assuredworkloads.workload.delete permission, the user should
     * also have orgpolicy.policy.set permission on the deleted folder to remove
     * Assured Workloads OrgPolicies.
     * </pre>
     */
    public void deleteWorkload(com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public void getWorkload(com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Analyze if the source Assured Workloads can be moved to the target Assured
     * Workload
     * </pre>
     */
    public void analyzeWorkloadMove(com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAnalyzeWorkloadMoveMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public void listWorkloads(com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateWorkloadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_WORKLOAD)))
          .addMethod(
            getUpdateWorkloadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest,
                com.google.cloud.assuredworkloads.v1beta1.Workload>(
                  this, METHODID_UPDATE_WORKLOAD)))
          .addMethod(
            getRestrictAllowedResourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest,
                com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse>(
                  this, METHODID_RESTRICT_ALLOWED_RESOURCES)))
          .addMethod(
            getDeleteWorkloadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_WORKLOAD)))
          .addMethod(
            getGetWorkloadMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest,
                com.google.cloud.assuredworkloads.v1beta1.Workload>(
                  this, METHODID_GET_WORKLOAD)))
          .addMethod(
            getAnalyzeWorkloadMoveMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest,
                com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse>(
                  this, METHODID_ANALYZE_WORKLOAD_MOVE)))
          .addMethod(
            getListWorkloadsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest,
                com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse>(
                  this, METHODID_LIST_WORKLOADS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceStub extends io.grpc.stub.AbstractAsyncStub<AssuredWorkloadsServiceStub> {
    private AssuredWorkloadsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public void createWorkload(com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public void updateWorkload(com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public void restrictAllowedResources(com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestrictAllowedResourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * In addition to assuredworkloads.workload.delete permission, the user should
     * also have orgpolicy.policy.set permission on the deleted folder to remove
     * Assured Workloads OrgPolicies.
     * </pre>
     */
    public void deleteWorkload(com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public void getWorkload(com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Analyze if the source Assured Workloads can be moved to the target Assured
     * Workload
     * </pre>
     */
    public void analyzeWorkloadMove(com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeWorkloadMoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public void listWorkloads(com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AssuredWorkloadsServiceBlockingStub> {
    private AssuredWorkloadsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkload(com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1beta1.Workload updateWorkload(com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse restrictAllowedResources(com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestrictAllowedResourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * In addition to assuredworkloads.workload.delete permission, the user should
     * also have orgpolicy.policy.set permission on the deleted folder to remove
     * Assured Workloads OrgPolicies.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWorkload(com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1beta1.Workload getWorkload(com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Analyze if the source Assured Workloads can be moved to the target Assured
     * Workload
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse analyzeWorkloadMove(com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeWorkloadMoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse listWorkloads(com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AssuredWorkloadsServiceFutureStub> {
    private AssuredWorkloadsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createWorkload(
        com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.assuredworkloads.v1beta1.Workload> updateWorkload(
        com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse> restrictAllowedResources(
        com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestrictAllowedResourcesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * In addition to assuredworkloads.workload.delete permission, the user should
     * also have orgpolicy.policy.set permission on the deleted folder to remove
     * Assured Workloads OrgPolicies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteWorkload(
        com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.assuredworkloads.v1beta1.Workload> getWorkload(
        com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Analyze if the source Assured Workloads can be moved to the target Assured
     * Workload
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse> analyzeWorkloadMove(
        com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeWorkloadMoveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse> listWorkloads(
        com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKLOAD = 0;
  private static final int METHODID_UPDATE_WORKLOAD = 1;
  private static final int METHODID_RESTRICT_ALLOWED_RESOURCES = 2;
  private static final int METHODID_DELETE_WORKLOAD = 3;
  private static final int METHODID_GET_WORKLOAD = 4;
  private static final int METHODID_ANALYZE_WORKLOAD_MOVE = 5;
  private static final int METHODID_LIST_WORKLOADS = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssuredWorkloadsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssuredWorkloadsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WORKLOAD:
          serviceImpl.createWorkload((com.google.cloud.assuredworkloads.v1beta1.CreateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKLOAD:
          serviceImpl.updateWorkload((com.google.cloud.assuredworkloads.v1beta1.UpdateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload>) responseObserver);
          break;
        case METHODID_RESTRICT_ALLOWED_RESOURCES:
          serviceImpl.restrictAllowedResources((com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.RestrictAllowedResourcesResponse>) responseObserver);
          break;
        case METHODID_DELETE_WORKLOAD:
          serviceImpl.deleteWorkload((com.google.cloud.assuredworkloads.v1beta1.DeleteWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_WORKLOAD:
          serviceImpl.getWorkload((com.google.cloud.assuredworkloads.v1beta1.GetWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.Workload>) responseObserver);
          break;
        case METHODID_ANALYZE_WORKLOAD_MOVE:
          serviceImpl.analyzeWorkloadMove((com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.AnalyzeWorkloadMoveResponse>) responseObserver);
          break;
        case METHODID_LIST_WORKLOADS:
          serviceImpl.listWorkloads((com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1beta1.ListWorkloadsResponse>) responseObserver);
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

  private static abstract class AssuredWorkloadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssuredWorkloadsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.assuredworkloads.v1beta1.AssuredworkloadsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssuredWorkloadsService");
    }
  }

  private static final class AssuredWorkloadsServiceFileDescriptorSupplier
      extends AssuredWorkloadsServiceBaseDescriptorSupplier {
    AssuredWorkloadsServiceFileDescriptorSupplier() {}
  }

  private static final class AssuredWorkloadsServiceMethodDescriptorSupplier
      extends AssuredWorkloadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssuredWorkloadsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AssuredWorkloadsServiceFileDescriptorSupplier())
              .addMethod(getCreateWorkloadMethod())
              .addMethod(getUpdateWorkloadMethod())
              .addMethod(getRestrictAllowedResourcesMethod())
              .addMethod(getDeleteWorkloadMethod())
              .addMethod(getGetWorkloadMethod())
              .addMethod(getAnalyzeWorkloadMoveMethod())
              .addMethod(getListWorkloadsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
