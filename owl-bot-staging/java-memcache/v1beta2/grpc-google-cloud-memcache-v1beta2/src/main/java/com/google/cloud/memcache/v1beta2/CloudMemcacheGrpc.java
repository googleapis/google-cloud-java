package com.google.cloud.memcache.v1beta2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Configures and manages Cloud Memorystore for Memcached instances.
 * The `memcache.googleapis.com` service implements the Google Cloud Memorystore
 * for Memcached API and defines the following resource model for managing
 * Memorystore Memcached (also called Memcached below) instances:
 * * The service works with a collection of cloud projects, named: `/projects/&#42;`
 * * Each project has a collection of available locations, named: `/locations/&#42;`
 * * Each location has a collection of Memcached instances, named:
 * `/instances/&#42;`
 * * As such, Memcached instances are resources of the form:
 *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 * Note that location_id must be a GCP `region`; for example:
 * * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/memcache/v1beta2/cloud_memcache.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudMemcacheGrpc {

  private CloudMemcacheGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.memcache.v1beta2.CloudMemcache";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ListInstancesRequest,
      com.google.cloud.memcache.v1beta2.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.memcache.v1beta2.ListInstancesRequest.class,
      responseType = com.google.cloud.memcache.v1beta2.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ListInstancesRequest,
      com.google.cloud.memcache.v1beta2.ListInstancesResponse> getListInstancesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ListInstancesRequest, com.google.cloud.memcache.v1beta2.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = CloudMemcacheGrpc.getListInstancesMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getListInstancesMethod = CloudMemcacheGrpc.getListInstancesMethod) == null) {
          CloudMemcacheGrpc.getListInstancesMethod = getListInstancesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.ListInstancesRequest, com.google.cloud.memcache.v1beta2.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.ListInstancesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("ListInstances"))
              .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.GetInstanceRequest,
      com.google.cloud.memcache.v1beta2.Instance> getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.memcache.v1beta2.GetInstanceRequest.class,
      responseType = com.google.cloud.memcache.v1beta2.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.GetInstanceRequest,
      com.google.cloud.memcache.v1beta2.Instance> getGetInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.GetInstanceRequest, com.google.cloud.memcache.v1beta2.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = CloudMemcacheGrpc.getGetInstanceMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getGetInstanceMethod = CloudMemcacheGrpc.getGetInstanceMethod) == null) {
          CloudMemcacheGrpc.getGetInstanceMethod = getGetInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.GetInstanceRequest, com.google.cloud.memcache.v1beta2.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.Instance.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("GetInstance"))
              .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.memcache.v1beta2.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = CloudMemcacheGrpc.getCreateInstanceMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getCreateInstanceMethod = CloudMemcacheGrpc.getCreateInstanceMethod) == null) {
          CloudMemcacheGrpc.getCreateInstanceMethod = getCreateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("CreateInstance"))
              .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.memcache.v1beta2.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateInstanceRequest, com.google.longrunning.Operation> getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = CloudMemcacheGrpc.getUpdateInstanceMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getUpdateInstanceMethod = CloudMemcacheGrpc.getUpdateInstanceMethod) == null) {
          CloudMemcacheGrpc.getUpdateInstanceMethod = getUpdateInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.UpdateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("UpdateInstance"))
              .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateParametersRequest,
      com.google.longrunning.Operation> getUpdateParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateParameters",
      requestType = com.google.cloud.memcache.v1beta2.UpdateParametersRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateParametersRequest,
      com.google.longrunning.Operation> getUpdateParametersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.UpdateParametersRequest, com.google.longrunning.Operation> getUpdateParametersMethod;
    if ((getUpdateParametersMethod = CloudMemcacheGrpc.getUpdateParametersMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getUpdateParametersMethod = CloudMemcacheGrpc.getUpdateParametersMethod) == null) {
          CloudMemcacheGrpc.getUpdateParametersMethod = getUpdateParametersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.UpdateParametersRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateParameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.UpdateParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("UpdateParameters"))
              .build();
        }
      }
    }
    return getUpdateParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.memcache.v1beta2.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = CloudMemcacheGrpc.getDeleteInstanceMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getDeleteInstanceMethod = CloudMemcacheGrpc.getDeleteInstanceMethod) == null) {
          CloudMemcacheGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("DeleteInstance"))
              .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplyParametersRequest,
      com.google.longrunning.Operation> getApplyParametersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyParameters",
      requestType = com.google.cloud.memcache.v1beta2.ApplyParametersRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplyParametersRequest,
      com.google.longrunning.Operation> getApplyParametersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplyParametersRequest, com.google.longrunning.Operation> getApplyParametersMethod;
    if ((getApplyParametersMethod = CloudMemcacheGrpc.getApplyParametersMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getApplyParametersMethod = CloudMemcacheGrpc.getApplyParametersMethod) == null) {
          CloudMemcacheGrpc.getApplyParametersMethod = getApplyParametersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.ApplyParametersRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyParameters"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.ApplyParametersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("ApplyParameters"))
              .build();
        }
      }
    }
    return getApplyParametersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest,
      com.google.longrunning.Operation> getApplySoftwareUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplySoftwareUpdate",
      requestType = com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest,
      com.google.longrunning.Operation> getApplySoftwareUpdateMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest, com.google.longrunning.Operation> getApplySoftwareUpdateMethod;
    if ((getApplySoftwareUpdateMethod = CloudMemcacheGrpc.getApplySoftwareUpdateMethod) == null) {
      synchronized (CloudMemcacheGrpc.class) {
        if ((getApplySoftwareUpdateMethod = CloudMemcacheGrpc.getApplySoftwareUpdateMethod) == null) {
          CloudMemcacheGrpc.getApplySoftwareUpdateMethod = getApplySoftwareUpdateMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplySoftwareUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudMemcacheMethodDescriptorSupplier("ApplySoftwareUpdate"))
              .build();
        }
      }
    }
    return getApplySoftwareUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudMemcacheStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheStub>() {
        @java.lang.Override
        public CloudMemcacheStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudMemcacheStub(channel, callOptions);
        }
      };
    return CloudMemcacheStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudMemcacheBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheBlockingStub>() {
        @java.lang.Override
        public CloudMemcacheBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudMemcacheBlockingStub(channel, callOptions);
        }
      };
    return CloudMemcacheBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudMemcacheFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudMemcacheFutureStub>() {
        @java.lang.Override
        public CloudMemcacheFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudMemcacheFutureStub(channel, callOptions);
        }
      };
    return CloudMemcacheFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Memcached instances.
   * The `memcache.googleapis.com` service implements the Google Cloud Memorystore
   * for Memcached API and defines the following resource model for managing
   * Memorystore Memcached (also called Memcached below) instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Memcached instances, named:
   * `/instances/&#42;`
   * * As such, Memcached instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
   * </pre>
   */
  public static abstract class CloudMemcacheImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Instances in a given location.
     * </pre>
     */
    public void listInstances(com.google.cloud.memcache.v1beta2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListInstancesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.memcache.v1beta2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Instance in a given location.
     * </pre>
     */
    public void createInstance(com.google.cloud.memcache.v1beta2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Instance in a given project and location.
     * </pre>
     */
    public void updateInstance(com.google.cloud.memcache.v1beta2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the defined Memcached parameters for an existing instance.
     * This method only stages the parameters, it must be followed by
     * `ApplyParameters` to apply the parameters to nodes of the Memcached
     * instance.
     * </pre>
     */
    public void updateParameters(com.google.cloud.memcache.v1beta2.UpdateParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateParametersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.memcache.v1beta2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * `ApplyParameters` restarts the set of specified nodes in order to update
     * them to the current set of parameters for the Memcached Instance.
     * </pre>
     */
    public void applyParameters(com.google.cloud.memcache.v1beta2.ApplyParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplyParametersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates software on the selected nodes of the Instance.
     * </pre>
     */
    public void applySoftwareUpdate(com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplySoftwareUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.ListInstancesRequest,
                com.google.cloud.memcache.v1beta2.ListInstancesResponse>(
                  this, METHODID_LIST_INSTANCES)))
          .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.GetInstanceRequest,
                com.google.cloud.memcache.v1beta2.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.CreateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.UpdateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
            getUpdateParametersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.UpdateParametersRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_PARAMETERS)))
          .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.DeleteInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_INSTANCE)))
          .addMethod(
            getApplyParametersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.ApplyParametersRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_APPLY_PARAMETERS)))
          .addMethod(
            getApplySoftwareUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_APPLY_SOFTWARE_UPDATE)))
          .build();
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Memcached instances.
   * The `memcache.googleapis.com` service implements the Google Cloud Memorystore
   * for Memcached API and defines the following resource model for managing
   * Memorystore Memcached (also called Memcached below) instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Memcached instances, named:
   * `/instances/&#42;`
   * * As such, Memcached instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
   * </pre>
   */
  public static final class CloudMemcacheStub extends io.grpc.stub.AbstractAsyncStub<CloudMemcacheStub> {
    private CloudMemcacheStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudMemcacheStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudMemcacheStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given location.
     * </pre>
     */
    public void listInstances(com.google.cloud.memcache.v1beta2.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.ListInstancesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.memcache.v1beta2.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Instance in a given location.
     * </pre>
     */
    public void createInstance(com.google.cloud.memcache.v1beta2.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Instance in a given project and location.
     * </pre>
     */
    public void updateInstance(com.google.cloud.memcache.v1beta2.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the defined Memcached parameters for an existing instance.
     * This method only stages the parameters, it must be followed by
     * `ApplyParameters` to apply the parameters to nodes of the Memcached
     * instance.
     * </pre>
     */
    public void updateParameters(com.google.cloud.memcache.v1beta2.UpdateParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateParametersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.memcache.v1beta2.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * `ApplyParameters` restarts the set of specified nodes in order to update
     * them to the current set of parameters for the Memcached Instance.
     * </pre>
     */
    public void applyParameters(com.google.cloud.memcache.v1beta2.ApplyParametersRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyParametersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates software on the selected nodes of the Instance.
     * </pre>
     */
    public void applySoftwareUpdate(com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplySoftwareUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Memcached instances.
   * The `memcache.googleapis.com` service implements the Google Cloud Memorystore
   * for Memcached API and defines the following resource model for managing
   * Memorystore Memcached (also called Memcached below) instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Memcached instances, named:
   * `/instances/&#42;`
   * * As such, Memcached instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
   * </pre>
   */
  public static final class CloudMemcacheBlockingStub extends io.grpc.stub.AbstractBlockingStub<CloudMemcacheBlockingStub> {
    private CloudMemcacheBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudMemcacheBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudMemcacheBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given location.
     * </pre>
     */
    public com.google.cloud.memcache.v1beta2.ListInstancesResponse listInstances(com.google.cloud.memcache.v1beta2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.memcache.v1beta2.Instance getInstance(com.google.cloud.memcache.v1beta2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Instance in a given location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.cloud.memcache.v1beta2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(com.google.cloud.memcache.v1beta2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the defined Memcached parameters for an existing instance.
     * This method only stages the parameters, it must be followed by
     * `ApplyParameters` to apply the parameters to nodes of the Memcached
     * instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateParameters(com.google.cloud.memcache.v1beta2.UpdateParametersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateParametersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.cloud.memcache.v1beta2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * `ApplyParameters` restarts the set of specified nodes in order to update
     * them to the current set of parameters for the Memcached Instance.
     * </pre>
     */
    public com.google.longrunning.Operation applyParameters(com.google.cloud.memcache.v1beta2.ApplyParametersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyParametersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates software on the selected nodes of the Instance.
     * </pre>
     */
    public com.google.longrunning.Operation applySoftwareUpdate(com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplySoftwareUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Memcached instances.
   * The `memcache.googleapis.com` service implements the Google Cloud Memorystore
   * for Memcached API and defines the following resource model for managing
   * Memorystore Memcached (also called Memcached below) instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Memcached instances, named:
   * `/instances/&#42;`
   * * As such, Memcached instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a GCP `region`; for example:
   * * `projects/my-memcached-project/locations/us-central1/instances/my-memcached`
   * </pre>
   */
  public static final class CloudMemcacheFutureStub extends io.grpc.stub.AbstractFutureStub<CloudMemcacheFutureStub> {
    private CloudMemcacheFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudMemcacheFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudMemcacheFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Instances in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.memcache.v1beta2.ListInstancesResponse> listInstances(
        com.google.cloud.memcache.v1beta2.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.memcache.v1beta2.Instance> getInstance(
        com.google.cloud.memcache.v1beta2.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Instance in a given location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.cloud.memcache.v1beta2.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateInstance(
        com.google.cloud.memcache.v1beta2.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the defined Memcached parameters for an existing instance.
     * This method only stages the parameters, it must be followed by
     * `ApplyParameters` to apply the parameters to nodes of the Memcached
     * instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateParameters(
        com.google.cloud.memcache.v1beta2.UpdateParametersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateParametersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.cloud.memcache.v1beta2.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * `ApplyParameters` restarts the set of specified nodes in order to update
     * them to the current set of parameters for the Memcached Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> applyParameters(
        com.google.cloud.memcache.v1beta2.ApplyParametersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyParametersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates software on the selected nodes of the Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> applySoftwareUpdate(
        com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplySoftwareUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_UPDATE_PARAMETERS = 4;
  private static final int METHODID_DELETE_INSTANCE = 5;
  private static final int METHODID_APPLY_PARAMETERS = 6;
  private static final int METHODID_APPLY_SOFTWARE_UPDATE = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudMemcacheImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudMemcacheImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.cloud.memcache.v1beta2.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.cloud.memcache.v1beta2.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.memcache.v1beta2.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.cloud.memcache.v1beta2.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance((com.google.cloud.memcache.v1beta2.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PARAMETERS:
          serviceImpl.updateParameters((com.google.cloud.memcache.v1beta2.UpdateParametersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.cloud.memcache.v1beta2.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_APPLY_PARAMETERS:
          serviceImpl.applyParameters((com.google.cloud.memcache.v1beta2.ApplyParametersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_APPLY_SOFTWARE_UPDATE:
          serviceImpl.applySoftwareUpdate((com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest) request,
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

  private static abstract class CloudMemcacheBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudMemcacheBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.memcache.v1beta2.CloudMemcacheProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudMemcache");
    }
  }

  private static final class CloudMemcacheFileDescriptorSupplier
      extends CloudMemcacheBaseDescriptorSupplier {
    CloudMemcacheFileDescriptorSupplier() {}
  }

  private static final class CloudMemcacheMethodDescriptorSupplier
      extends CloudMemcacheBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudMemcacheMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudMemcacheGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudMemcacheFileDescriptorSupplier())
              .addMethod(getListInstancesMethod())
              .addMethod(getGetInstanceMethod())
              .addMethod(getCreateInstanceMethod())
              .addMethod(getUpdateInstanceMethod())
              .addMethod(getUpdateParametersMethod())
              .addMethod(getDeleteInstanceMethod())
              .addMethod(getApplyParametersMethod())
              .addMethod(getApplySoftwareUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
