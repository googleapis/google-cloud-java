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
 * The cloud gaming allocation policy is used as the controller's recipe for the
 * allocating game servers from clusters. The policy has three modes:
 *   1. Default mode which is not limited to time.
 *   2. Time based mode which is temporary and overrides the default mode when
 *   effective.
 *   3. Periodic mode which follows the time base mode, but happens
 *   periodically using local time, identified by cron specs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/gaming/v1alpha/allocation_policies.proto")
public final class AllocationPoliciesServiceGrpc {

  private AllocationPoliciesServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gaming.v1alpha.AllocationPoliciesService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAllocationPoliciesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
      METHOD_LIST_ALLOCATION_POLICIES = getListAllocationPoliciesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
      getListAllocationPoliciesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
      getListAllocationPoliciesMethod() {
    return getListAllocationPoliciesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
      getListAllocationPoliciesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
            com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
        getListAllocationPoliciesMethod;
    if ((getListAllocationPoliciesMethod =
            AllocationPoliciesServiceGrpc.getListAllocationPoliciesMethod)
        == null) {
      synchronized (AllocationPoliciesServiceGrpc.class) {
        if ((getListAllocationPoliciesMethod =
                AllocationPoliciesServiceGrpc.getListAllocationPoliciesMethod)
            == null) {
          AllocationPoliciesServiceGrpc.getListAllocationPoliciesMethod =
              getListAllocationPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
                          com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.AllocationPoliciesService",
                              "ListAllocationPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AllocationPoliciesServiceMethodDescriptorSupplier(
                              "ListAllocationPolicies"))
                      .build();
        }
      }
    }
    return getListAllocationPoliciesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllocationPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
          com.google.cloud.gaming.v1alpha.AllocationPolicy>
      METHOD_GET_ALLOCATION_POLICY = getGetAllocationPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
          com.google.cloud.gaming.v1alpha.AllocationPolicy>
      getGetAllocationPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
          com.google.cloud.gaming.v1alpha.AllocationPolicy>
      getGetAllocationPolicyMethod() {
    return getGetAllocationPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
          com.google.cloud.gaming.v1alpha.AllocationPolicy>
      getGetAllocationPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
            com.google.cloud.gaming.v1alpha.AllocationPolicy>
        getGetAllocationPolicyMethod;
    if ((getGetAllocationPolicyMethod = AllocationPoliciesServiceGrpc.getGetAllocationPolicyMethod)
        == null) {
      synchronized (AllocationPoliciesServiceGrpc.class) {
        if ((getGetAllocationPolicyMethod =
                AllocationPoliciesServiceGrpc.getGetAllocationPolicyMethod)
            == null) {
          AllocationPoliciesServiceGrpc.getGetAllocationPolicyMethod =
              getGetAllocationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
                          com.google.cloud.gaming.v1alpha.AllocationPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.AllocationPoliciesService",
                              "GetAllocationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.AllocationPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AllocationPoliciesServiceMethodDescriptorSupplier(
                              "GetAllocationPolicy"))
                      .build();
        }
      }
    }
    return getGetAllocationPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAllocationPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_CREATE_ALLOCATION_POLICY = getCreateAllocationPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAllocationPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAllocationPolicyMethod() {
    return getCreateAllocationPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getCreateAllocationPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
            com.google.longrunning.Operation>
        getCreateAllocationPolicyMethod;
    if ((getCreateAllocationPolicyMethod =
            AllocationPoliciesServiceGrpc.getCreateAllocationPolicyMethod)
        == null) {
      synchronized (AllocationPoliciesServiceGrpc.class) {
        if ((getCreateAllocationPolicyMethod =
                AllocationPoliciesServiceGrpc.getCreateAllocationPolicyMethod)
            == null) {
          AllocationPoliciesServiceGrpc.getCreateAllocationPolicyMethod =
              getCreateAllocationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.AllocationPoliciesService",
                              "CreateAllocationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AllocationPoliciesServiceMethodDescriptorSupplier(
                              "CreateAllocationPolicy"))
                      .build();
        }
      }
    }
    return getCreateAllocationPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAllocationPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_DELETE_ALLOCATION_POLICY = getDeleteAllocationPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAllocationPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAllocationPolicyMethod() {
    return getDeleteAllocationPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getDeleteAllocationPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
            com.google.longrunning.Operation>
        getDeleteAllocationPolicyMethod;
    if ((getDeleteAllocationPolicyMethod =
            AllocationPoliciesServiceGrpc.getDeleteAllocationPolicyMethod)
        == null) {
      synchronized (AllocationPoliciesServiceGrpc.class) {
        if ((getDeleteAllocationPolicyMethod =
                AllocationPoliciesServiceGrpc.getDeleteAllocationPolicyMethod)
            == null) {
          AllocationPoliciesServiceGrpc.getDeleteAllocationPolicyMethod =
              getDeleteAllocationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.AllocationPoliciesService",
                              "DeleteAllocationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AllocationPoliciesServiceMethodDescriptorSupplier(
                              "DeleteAllocationPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAllocationPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateAllocationPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      METHOD_UPDATE_ALLOCATION_POLICY = getUpdateAllocationPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAllocationPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAllocationPolicyMethod() {
    return getUpdateAllocationPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
          com.google.longrunning.Operation>
      getUpdateAllocationPolicyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
            com.google.longrunning.Operation>
        getUpdateAllocationPolicyMethod;
    if ((getUpdateAllocationPolicyMethod =
            AllocationPoliciesServiceGrpc.getUpdateAllocationPolicyMethod)
        == null) {
      synchronized (AllocationPoliciesServiceGrpc.class) {
        if ((getUpdateAllocationPolicyMethod =
                AllocationPoliciesServiceGrpc.getUpdateAllocationPolicyMethod)
            == null) {
          AllocationPoliciesServiceGrpc.getUpdateAllocationPolicyMethod =
              getUpdateAllocationPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.gaming.v1alpha.AllocationPoliciesService",
                              "UpdateAllocationPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AllocationPoliciesServiceMethodDescriptorSupplier(
                              "UpdateAllocationPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAllocationPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AllocationPoliciesServiceStub newStub(io.grpc.Channel channel) {
    return new AllocationPoliciesServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AllocationPoliciesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new AllocationPoliciesServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AllocationPoliciesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new AllocationPoliciesServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming allocation policy is used as the controller's recipe for the
   * allocating game servers from clusters. The policy has three modes:
   *   1. Default mode which is not limited to time.
   *   2. Time based mode which is temporary and overrides the default mode when
   *   effective.
   *   3. Periodic mode which follows the time base mode, but happens
   *   periodically using local time, identified by cron specs.
   * </pre>
   */
  public abstract static class AllocationPoliciesServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * List allocation policies in a given project and location.
     * </pre>
     */
    public void listAllocationPolicies(
        com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAllocationPoliciesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single allocation policy.
     * </pre>
     */
    public void getAllocationPolicy(
        com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.AllocationPolicy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllocationPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new allocation policy in a given project and location.
     * </pre>
     */
    public void createAllocationPolicy(
        com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAllocationPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single allocation policy.
     * </pre>
     */
    public void deleteAllocationPolicy(
        com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAllocationPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single allocation policy.
     * </pre>
     */
    public void updateAllocationPolicy(
        com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAllocationPolicyMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAllocationPoliciesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest,
                      com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>(
                      this, METHODID_LIST_ALLOCATION_POLICIES)))
          .addMethod(
              getGetAllocationPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest,
                      com.google.cloud.gaming.v1alpha.AllocationPolicy>(
                      this, METHODID_GET_ALLOCATION_POLICY)))
          .addMethod(
              getCreateAllocationPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_ALLOCATION_POLICY)))
          .addMethod(
              getDeleteAllocationPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_ALLOCATION_POLICY)))
          .addMethod(
              getUpdateAllocationPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_ALLOCATION_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming allocation policy is used as the controller's recipe for the
   * allocating game servers from clusters. The policy has three modes:
   *   1. Default mode which is not limited to time.
   *   2. Time based mode which is temporary and overrides the default mode when
   *   effective.
   *   3. Periodic mode which follows the time base mode, but happens
   *   periodically using local time, identified by cron specs.
   * </pre>
   */
  public static final class AllocationPoliciesServiceStub
      extends io.grpc.stub.AbstractStub<AllocationPoliciesServiceStub> {
    private AllocationPoliciesServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocationPoliciesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocationPoliciesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AllocationPoliciesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List allocation policies in a given project and location.
     * </pre>
     */
    public void listAllocationPolicies(
        com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAllocationPoliciesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single allocation policy.
     * </pre>
     */
    public void getAllocationPolicy(
        com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.AllocationPolicy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllocationPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new allocation policy in a given project and location.
     * </pre>
     */
    public void createAllocationPolicy(
        com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAllocationPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single allocation policy.
     * </pre>
     */
    public void deleteAllocationPolicy(
        com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAllocationPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Patches a single allocation policy.
     * </pre>
     */
    public void updateAllocationPolicy(
        com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAllocationPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming allocation policy is used as the controller's recipe for the
   * allocating game servers from clusters. The policy has three modes:
   *   1. Default mode which is not limited to time.
   *   2. Time based mode which is temporary and overrides the default mode when
   *   effective.
   *   3. Periodic mode which follows the time base mode, but happens
   *   periodically using local time, identified by cron specs.
   * </pre>
   */
  public static final class AllocationPoliciesServiceBlockingStub
      extends io.grpc.stub.AbstractStub<AllocationPoliciesServiceBlockingStub> {
    private AllocationPoliciesServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocationPoliciesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocationPoliciesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AllocationPoliciesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List allocation policies in a given project and location.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse listAllocationPolicies(
        com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAllocationPoliciesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single allocation policy.
     * </pre>
     */
    public com.google.cloud.gaming.v1alpha.AllocationPolicy getAllocationPolicy(
        com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAllocationPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new allocation policy in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createAllocationPolicy(
        com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAllocationPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single allocation policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAllocationPolicy(
        com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAllocationPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single allocation policy.
     * </pre>
     */
    public com.google.longrunning.Operation updateAllocationPolicy(
        com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAllocationPolicyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The cloud gaming allocation policy is used as the controller's recipe for the
   * allocating game servers from clusters. The policy has three modes:
   *   1. Default mode which is not limited to time.
   *   2. Time based mode which is temporary and overrides the default mode when
   *   effective.
   *   3. Periodic mode which follows the time base mode, but happens
   *   periodically using local time, identified by cron specs.
   * </pre>
   */
  public static final class AllocationPoliciesServiceFutureStub
      extends io.grpc.stub.AbstractStub<AllocationPoliciesServiceFutureStub> {
    private AllocationPoliciesServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AllocationPoliciesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AllocationPoliciesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AllocationPoliciesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * List allocation policies in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>
        listAllocationPolicies(
            com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAllocationPoliciesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single allocation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gaming.v1alpha.AllocationPolicy>
        getAllocationPolicy(com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllocationPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new allocation policy in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAllocationPolicy(
            com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAllocationPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single allocation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAllocationPolicy(
            com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAllocationPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Patches a single allocation policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAllocationPolicy(
            com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAllocationPolicyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALLOCATION_POLICIES = 0;
  private static final int METHODID_GET_ALLOCATION_POLICY = 1;
  private static final int METHODID_CREATE_ALLOCATION_POLICY = 2;
  private static final int METHODID_DELETE_ALLOCATION_POLICY = 3;
  private static final int METHODID_UPDATE_ALLOCATION_POLICY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AllocationPoliciesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AllocationPoliciesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALLOCATION_POLICIES:
          serviceImpl.listAllocationPolicies(
              (com.google.cloud.gaming.v1alpha.ListAllocationPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gaming.v1alpha.ListAllocationPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ALLOCATION_POLICY:
          serviceImpl.getAllocationPolicy(
              (com.google.cloud.gaming.v1alpha.GetAllocationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gaming.v1alpha.AllocationPolicy>)
                  responseObserver);
          break;
        case METHODID_CREATE_ALLOCATION_POLICY:
          serviceImpl.createAllocationPolicy(
              (com.google.cloud.gaming.v1alpha.CreateAllocationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ALLOCATION_POLICY:
          serviceImpl.deleteAllocationPolicy(
              (com.google.cloud.gaming.v1alpha.DeleteAllocationPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ALLOCATION_POLICY:
          serviceImpl.updateAllocationPolicy(
              (com.google.cloud.gaming.v1alpha.UpdateAllocationPolicyRequest) request,
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

  private abstract static class AllocationPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AllocationPoliciesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gaming.v1alpha.AllocationPolicies.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AllocationPoliciesService");
    }
  }

  private static final class AllocationPoliciesServiceFileDescriptorSupplier
      extends AllocationPoliciesServiceBaseDescriptorSupplier {
    AllocationPoliciesServiceFileDescriptorSupplier() {}
  }

  private static final class AllocationPoliciesServiceMethodDescriptorSupplier
      extends AllocationPoliciesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AllocationPoliciesServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AllocationPoliciesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AllocationPoliciesServiceFileDescriptorSupplier())
                      .addMethod(getListAllocationPoliciesMethodHelper())
                      .addMethod(getGetAllocationPolicyMethodHelper())
                      .addMethod(getCreateAllocationPolicyMethodHelper())
                      .addMethod(getDeleteAllocationPolicyMethodHelper())
                      .addMethod(getUpdateAllocationPolicyMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
