package com.google.cloud.redis.v1;

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
 * Configures and manages Cloud Memorystore for Redis instances
 * Google Cloud Memorystore for Redis v1
 * The `redis.googleapis.com` service implements the Google Cloud Memorystore
 * for Redis API and defines the following resource model for managing Redis
 * instances:
 * * The service works with a collection of cloud projects, named: `/projects/&#42;`
 * * Each project has a collection of available locations, named: `/locations/&#42;`
 * * Each location has a collection of Redis instances, named: `/instances/&#42;`
 * * As such, Redis instances are resources of the form:
 *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 * Note that location_id must be refering to a GCP `region`; for example:
 * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/redis/v1/cloud_redis.proto")
public final class CloudRedisGrpc {

  private CloudRedisGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.redis.v1.CloudRedis";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListInstancesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.redis.v1.ListInstancesRequest,
      com.google.cloud.redis.v1.ListInstancesResponse> METHOD_LIST_INSTANCES = getListInstancesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.redis.v1.ListInstancesRequest,
      com.google.cloud.redis.v1.ListInstancesResponse> getListInstancesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.ListInstancesRequest,
      com.google.cloud.redis.v1.ListInstancesResponse> getListInstancesMethod() {
    return getListInstancesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.ListInstancesRequest,
      com.google.cloud.redis.v1.ListInstancesResponse> getListInstancesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.redis.v1.ListInstancesRequest, com.google.cloud.redis.v1.ListInstancesResponse> getListInstancesMethod;
    if ((getListInstancesMethod = CloudRedisGrpc.getListInstancesMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getListInstancesMethod = CloudRedisGrpc.getListInstancesMethod) == null) {
          CloudRedisGrpc.getListInstancesMethod = getListInstancesMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.redis.v1.ListInstancesRequest, com.google.cloud.redis.v1.ListInstancesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.redis.v1.CloudRedis", "ListInstances"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.ListInstancesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.ListInstancesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("ListInstances"))
                  .build();
          }
        }
     }
     return getListInstancesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.redis.v1.GetInstanceRequest,
      com.google.cloud.redis.v1.Instance> METHOD_GET_INSTANCE = getGetInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.redis.v1.GetInstanceRequest,
      com.google.cloud.redis.v1.Instance> getGetInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.GetInstanceRequest,
      com.google.cloud.redis.v1.Instance> getGetInstanceMethod() {
    return getGetInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.GetInstanceRequest,
      com.google.cloud.redis.v1.Instance> getGetInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.redis.v1.GetInstanceRequest, com.google.cloud.redis.v1.Instance> getGetInstanceMethod;
    if ((getGetInstanceMethod = CloudRedisGrpc.getGetInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getGetInstanceMethod = CloudRedisGrpc.getGetInstanceMethod) == null) {
          CloudRedisGrpc.getGetInstanceMethod = getGetInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.redis.v1.GetInstanceRequest, com.google.cloud.redis.v1.Instance>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.redis.v1.CloudRedis", "GetInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.GetInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.Instance.getDefaultInstance()))
                  .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("GetInstance"))
                  .build();
          }
        }
     }
     return getGetInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.redis.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> METHOD_CREATE_INSTANCE = getCreateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.redis.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethod() {
    return getCreateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.CreateInstanceRequest,
      com.google.longrunning.Operation> getCreateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.redis.v1.CreateInstanceRequest, com.google.longrunning.Operation> getCreateInstanceMethod;
    if ((getCreateInstanceMethod = CloudRedisGrpc.getCreateInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getCreateInstanceMethod = CloudRedisGrpc.getCreateInstanceMethod) == null) {
          CloudRedisGrpc.getCreateInstanceMethod = getCreateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.redis.v1.CreateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.redis.v1.CloudRedis", "CreateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.CreateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("CreateInstance"))
                  .build();
          }
        }
     }
     return getCreateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.redis.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> METHOD_UPDATE_INSTANCE = getUpdateInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.redis.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethod() {
    return getUpdateInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.UpdateInstanceRequest,
      com.google.longrunning.Operation> getUpdateInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.redis.v1.UpdateInstanceRequest, com.google.longrunning.Operation> getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = CloudRedisGrpc.getUpdateInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getUpdateInstanceMethod = CloudRedisGrpc.getUpdateInstanceMethod) == null) {
          CloudRedisGrpc.getUpdateInstanceMethod = getUpdateInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.redis.v1.UpdateInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.redis.v1.CloudRedis", "UpdateInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.UpdateInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("UpdateInstance"))
                  .build();
          }
        }
     }
     return getUpdateInstanceMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteInstanceMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.cloud.redis.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> METHOD_DELETE_INSTANCE = getDeleteInstanceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.redis.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethod() {
    return getDeleteInstanceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.cloud.redis.v1.DeleteInstanceRequest,
      com.google.longrunning.Operation> getDeleteInstanceMethodHelper() {
    io.grpc.MethodDescriptor<com.google.cloud.redis.v1.DeleteInstanceRequest, com.google.longrunning.Operation> getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = CloudRedisGrpc.getDeleteInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getDeleteInstanceMethod = CloudRedisGrpc.getDeleteInstanceMethod) == null) {
          CloudRedisGrpc.getDeleteInstanceMethod = getDeleteInstanceMethod = 
              io.grpc.MethodDescriptor.<com.google.cloud.redis.v1.DeleteInstanceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.cloud.redis.v1.CloudRedis", "DeleteInstance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.redis.v1.DeleteInstanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
                  .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("DeleteInstance"))
                  .build();
          }
        }
     }
     return getDeleteInstanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudRedisStub newStub(io.grpc.Channel channel) {
    return new CloudRedisStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudRedisBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CloudRedisBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudRedisFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CloudRedisFutureStub(channel);
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Redis instances
   * Google Cloud Memorystore for Redis v1
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis instances, named: `/instances/&#42;`
   * * As such, Redis instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be refering to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static abstract class CloudRedisImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listInstances(com.google.cloud.redis.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListInstancesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.redis.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Redis instance based on the specified tier and memory size.
     * By default, the instance is accessible from the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * instance will be fully functional. Completed longrunning.Operation will
     * contain the new instance object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public void createInstance(com.google.cloud.redis.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public void updateInstance(com.google.cloud.redis.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInstanceMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.redis.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteInstanceMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListInstancesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.redis.v1.ListInstancesRequest,
                com.google.cloud.redis.v1.ListInstancesResponse>(
                  this, METHODID_LIST_INSTANCES)))
          .addMethod(
            getGetInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.redis.v1.GetInstanceRequest,
                com.google.cloud.redis.v1.Instance>(
                  this, METHODID_GET_INSTANCE)))
          .addMethod(
            getCreateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.redis.v1.CreateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_INSTANCE)))
          .addMethod(
            getUpdateInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.redis.v1.UpdateInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
            getDeleteInstanceMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.redis.v1.DeleteInstanceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_INSTANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Redis instances
   * Google Cloud Memorystore for Redis v1
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis instances, named: `/instances/&#42;`
   * * As such, Redis instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be refering to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisStub extends io.grpc.stub.AbstractStub<CloudRedisStub> {
    private CloudRedisStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudRedisStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CloudRedisStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listInstances(com.google.cloud.redis.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public void getInstance(com.google.cloud.redis.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Redis instance based on the specified tier and memory size.
     * By default, the instance is accessible from the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * instance will be fully functional. Completed longrunning.Operation will
     * contain the new instance object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public void createInstance(com.google.cloud.redis.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public void updateInstance(com.google.cloud.redis.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public void deleteInstance(com.google.cloud.redis.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Redis instances
   * Google Cloud Memorystore for Redis v1
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis instances, named: `/instances/&#42;`
   * * As such, Redis instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be refering to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisBlockingStub extends io.grpc.stub.AbstractStub<CloudRedisBlockingStub> {
    private CloudRedisBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudRedisBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CloudRedisBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.cloud.redis.v1.ListInstancesResponse listInstances(com.google.cloud.redis.v1.ListInstancesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListInstancesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public com.google.cloud.redis.v1.Instance getInstance(com.google.cloud.redis.v1.GetInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Redis instance based on the specified tier and memory size.
     * By default, the instance is accessible from the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * instance will be fully functional. Completed longrunning.Operation will
     * contain the new instance object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(com.google.cloud.redis.v1.CreateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(com.google.cloud.redis.v1.UpdateInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateInstanceMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(com.google.cloud.redis.v1.DeleteInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteInstanceMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Configures and manages Cloud Memorystore for Redis instances
   * Google Cloud Memorystore for Redis v1
   * The `redis.googleapis.com` service implements the Google Cloud Memorystore
   * for Redis API and defines the following resource model for managing Redis
   * instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of Redis instances, named: `/instances/&#42;`
   * * As such, Redis instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be refering to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisFutureStub extends io.grpc.stub.AbstractStub<CloudRedisFutureStub> {
    private CloudRedisFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudRedisFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CloudRedisFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.redis.v1.ListInstancesResponse> listInstances(
        com.google.cloud.redis.v1.ListInstancesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInstancesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.redis.v1.Instance> getInstance(
        com.google.cloud.redis.v1.GetInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Redis instance based on the specified tier and memory size.
     * By default, the instance is accessible from the project's
     * [default network](/compute/docs/networks-and-firewalls#networks).
     * The creation is executed asynchronously and callers may check the returned
     * operation to track its progress. Once the operation is completed the Redis
     * instance will be fully functional. Completed longrunning.Operation will
     * contain the new instance object in the response field.
     * The returned operation is automatically deleted after a few hours, so there
     * is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createInstance(
        com.google.cloud.redis.v1.CreateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateInstance(
        com.google.cloud.redis.v1.UpdateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteInstance(
        com.google.cloud.redis.v1.DeleteInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudRedisImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudRedisImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances((com.google.cloud.redis.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse>) responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance((com.google.cloud.redis.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance((com.google.cloud.redis.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance((com.google.cloud.redis.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance((com.google.cloud.redis.v1.DeleteInstanceRequest) request,
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

  private static abstract class CloudRedisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudRedisBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.redis.v1.CloudRedisServiceV1Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudRedis");
    }
  }

  private static final class CloudRedisFileDescriptorSupplier
      extends CloudRedisBaseDescriptorSupplier {
    CloudRedisFileDescriptorSupplier() {}
  }

  private static final class CloudRedisMethodDescriptorSupplier
      extends CloudRedisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudRedisMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudRedisGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudRedisFileDescriptorSupplier())
              .addMethod(getListInstancesMethodHelper())
              .addMethod(getGetInstanceMethodHelper())
              .addMethod(getCreateInstanceMethodHelper())
              .addMethod(getUpdateInstanceMethodHelper())
              .addMethod(getDeleteInstanceMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
