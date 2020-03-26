/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.redis.v1;

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
 * Note that location_id must be referring to a GCP `region`; for example:
 * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/redis/v1/cloud_redis.proto")
public final class CloudRedisGrpc {

  private CloudRedisGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.redis.v1.CloudRedis";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ListInstancesRequest,
          com.google.cloud.redis.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.redis.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.redis.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ListInstancesRequest,
          com.google.cloud.redis.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.ListInstancesRequest,
            com.google.cloud.redis.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = CloudRedisGrpc.getListInstancesMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getListInstancesMethod = CloudRedisGrpc.getListInstancesMethod) == null) {
          CloudRedisGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.ListInstancesRequest,
                          com.google.cloud.redis.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.ListInstancesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.ListInstancesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.GetInstanceRequest, com.google.cloud.redis.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.redis.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.redis.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.GetInstanceRequest, com.google.cloud.redis.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.GetInstanceRequest, com.google.cloud.redis.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = CloudRedisGrpc.getGetInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getGetInstanceMethod = CloudRedisGrpc.getGetInstanceMethod) == null) {
          CloudRedisGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.GetInstanceRequest,
                          com.google.cloud.redis.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.redis.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = CloudRedisGrpc.getCreateInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getCreateInstanceMethod = CloudRedisGrpc.getCreateInstanceMethod) == null) {
          CloudRedisGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.CreateInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.redis.v1.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = CloudRedisGrpc.getUpdateInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getUpdateInstanceMethod = CloudRedisGrpc.getUpdateInstanceMethod) == null) {
          CloudRedisGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.UpdateInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ImportInstanceRequest, com.google.longrunning.Operation>
      getImportInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportInstance",
      requestType = com.google.cloud.redis.v1.ImportInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ImportInstanceRequest, com.google.longrunning.Operation>
      getImportInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.ImportInstanceRequest, com.google.longrunning.Operation>
        getImportInstanceMethod;
    if ((getImportInstanceMethod = CloudRedisGrpc.getImportInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getImportInstanceMethod = CloudRedisGrpc.getImportInstanceMethod) == null) {
          CloudRedisGrpc.getImportInstanceMethod =
              getImportInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.ImportInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.ImportInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("ImportInstance"))
                      .build();
        }
      }
    }
    return getImportInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ExportInstanceRequest, com.google.longrunning.Operation>
      getExportInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportInstance",
      requestType = com.google.cloud.redis.v1.ExportInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.ExportInstanceRequest, com.google.longrunning.Operation>
      getExportInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.ExportInstanceRequest, com.google.longrunning.Operation>
        getExportInstanceMethod;
    if ((getExportInstanceMethod = CloudRedisGrpc.getExportInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getExportInstanceMethod = CloudRedisGrpc.getExportInstanceMethod) == null) {
          CloudRedisGrpc.getExportInstanceMethod =
              getExportInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.ExportInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.ExportInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("ExportInstance"))
                      .build();
        }
      }
    }
    return getExportInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.FailoverInstanceRequest, com.google.longrunning.Operation>
      getFailoverInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FailoverInstance",
      requestType = com.google.cloud.redis.v1.FailoverInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.FailoverInstanceRequest, com.google.longrunning.Operation>
      getFailoverInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.FailoverInstanceRequest, com.google.longrunning.Operation>
        getFailoverInstanceMethod;
    if ((getFailoverInstanceMethod = CloudRedisGrpc.getFailoverInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getFailoverInstanceMethod = CloudRedisGrpc.getFailoverInstanceMethod) == null) {
          CloudRedisGrpc.getFailoverInstanceMethod =
              getFailoverInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.FailoverInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FailoverInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.FailoverInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudRedisMethodDescriptorSupplier("FailoverInstance"))
                      .build();
        }
      }
    }
    return getFailoverInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.redis.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.redis.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.redis.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = CloudRedisGrpc.getDeleteInstanceMethod) == null) {
      synchronized (CloudRedisGrpc.class) {
        if ((getDeleteInstanceMethod = CloudRedisGrpc.getDeleteInstanceMethod) == null) {
          CloudRedisGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.redis.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.redis.v1.DeleteInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudRedisMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudRedisStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisStub>() {
          @java.lang.Override
          public CloudRedisStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisStub(channel, callOptions);
          }
        };
    return CloudRedisStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudRedisBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisBlockingStub>() {
          @java.lang.Override
          public CloudRedisBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisBlockingStub(channel, callOptions);
          }
        };
    return CloudRedisBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudRedisFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudRedisFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudRedisFutureStub>() {
          @java.lang.Override
          public CloudRedisFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudRedisFutureStub(channel, callOptions);
          }
        };
    return CloudRedisFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
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
   * Note that location_id must be referring to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public abstract static class CloudRedisImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.redis.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.redis.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance> responseObserver) {
      asyncUnimplementedUnaryCall(getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
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
    public void createInstance(
        com.google.cloud.redis.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.redis.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
     * Redis may stop serving during this operation. Instance state will be
     * IMPORTING for entire operation. When complete, the instance will contain
     * only data from the imported file.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public void importInstance(
        com.google.cloud.redis.v1.ImportInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getImportInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export Redis instance data into a Redis RDB format file in Cloud Storage.
     * Redis will continue serving during this operation.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public void exportInstance(
        com.google.cloud.redis.v1.ExportInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getExportInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover of the master node to current replica node for a
     * specific STANDARD tier Cloud Memorystore for Redis instance.
     * </pre>
     */
    public void failoverInstance(
        com.google.cloud.redis.v1.FailoverInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getFailoverInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.redis.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteInstanceMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListInstancesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.ListInstancesRequest,
                      com.google.cloud.redis.v1.ListInstancesResponse>(
                      this, METHODID_LIST_INSTANCES)))
          .addMethod(
              getGetInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.GetInstanceRequest,
                      com.google.cloud.redis.v1.Instance>(this, METHODID_GET_INSTANCE)))
          .addMethod(
              getCreateInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.CreateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INSTANCE)))
          .addMethod(
              getUpdateInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.UpdateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
              getImportInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.ImportInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_INSTANCE)))
          .addMethod(
              getExportInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.ExportInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_INSTANCE)))
          .addMethod(
              getFailoverInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.FailoverInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_FAILOVER_INSTANCE)))
          .addMethod(
              getDeleteInstanceMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.redis.v1.DeleteInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_INSTANCE)))
          .build();
    }
  }

  /**
   *
   *
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
   * Note that location_id must be referring to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisStub extends io.grpc.stub.AbstractAsyncStub<CloudRedisStub> {
    private CloudRedisStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.redis.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.redis.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
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
    public void createInstance(
        com.google.cloud.redis.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.redis.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
     * Redis may stop serving during this operation. Instance state will be
     * IMPORTING for entire operation. When complete, the instance will contain
     * only data from the imported file.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public void importInstance(
        com.google.cloud.redis.v1.ImportInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getImportInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export Redis instance data into a Redis RDB format file in Cloud Storage.
     * Redis will continue serving during this operation.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public void exportInstance(
        com.google.cloud.redis.v1.ExportInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getExportInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover of the master node to current replica node for a
     * specific STANDARD tier Cloud Memorystore for Redis instance.
     * </pre>
     */
    public void failoverInstance(
        com.google.cloud.redis.v1.FailoverInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFailoverInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.redis.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
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
   * Note that location_id must be referring to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudRedisBlockingStub> {
    private CloudRedisBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.cloud.redis.v1.ListInstancesResponse listInstances(
        com.google.cloud.redis.v1.ListInstancesRequest request) {
      return blockingUnaryCall(getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public com.google.cloud.redis.v1.Instance getInstance(
        com.google.cloud.redis.v1.GetInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
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
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.redis.v1.CreateInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.redis.v1.UpdateInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
     * Redis may stop serving during this operation. Instance state will be
     * IMPORTING for entire operation. When complete, the instance will contain
     * only data from the imported file.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation importInstance(
        com.google.cloud.redis.v1.ImportInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getImportInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export Redis instance data into a Redis RDB format file in Cloud Storage.
     * Redis will continue serving during this operation.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.longrunning.Operation exportInstance(
        com.google.cloud.redis.v1.ExportInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getExportInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover of the master node to current replica node for a
     * specific STANDARD tier Cloud Memorystore for Redis instance.
     * </pre>
     */
    public com.google.longrunning.Operation failoverInstance(
        com.google.cloud.redis.v1.FailoverInstanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getFailoverInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.redis.v1.DeleteInstanceRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
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
   * Note that location_id must be referring to a GCP `region`; for example:
   * * `projects/redpepper-1290/locations/us-central1/instances/my-redis`
   * </pre>
   */
  public static final class CloudRedisFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudRedisFutureStub> {
    private CloudRedisFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudRedisFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudRedisFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all Redis instances owned by a project in either the specified
     * location (region) or all locations.
     * The location should have the following format:
     * * `projects/{project_id}/locations/{location_id}`
     * If `location_id` is specified as `-` (wildcard), then all regions
     * available to the project are queried, and the results are aggregated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.redis.v1.ListInstancesResponse>
        listInstances(com.google.cloud.redis.v1.ListInstancesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific Redis instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.redis.v1.Instance>
        getInstance(com.google.cloud.redis.v1.GetInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.redis.v1.CreateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata and configuration of a specific Redis instance.
     * Completed longrunning.Operation will contain the new instance object
     * in the response field. The returned operation is automatically deleted
     * after a few hours, so there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.redis.v1.UpdateInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Import a Redis RDB snapshot file from Cloud Storage into a Redis instance.
     * Redis may stop serving during this operation. Instance state will be
     * IMPORTING for entire operation. When complete, the instance will contain
     * only data from the imported file.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importInstance(com.google.cloud.redis.v1.ImportInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getImportInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export Redis instance data into a Redis RDB format file in Cloud Storage.
     * Redis will continue serving during this operation.
     * The returned operation is automatically deleted after a few hours, so
     * there is no need to call DeleteOperation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportInstance(com.google.cloud.redis.v1.ExportInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getExportInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initiates a failover of the master node to current replica node for a
     * specific STANDARD tier Cloud Memorystore for Redis instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        failoverInstance(com.google.cloud.redis.v1.FailoverInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getFailoverInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific Redis instance.  Instance stops serving and data is
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.redis.v1.DeleteInstanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_IMPORT_INSTANCE = 4;
  private static final int METHODID_EXPORT_INSTANCE = 5;
  private static final int METHODID_FAILOVER_INSTANCE = 6;
  private static final int METHODID_DELETE_INSTANCE = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listInstances(
              (com.google.cloud.redis.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.redis.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.redis.v1.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.redis.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.redis.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_INSTANCE:
          serviceImpl.importInstance(
              (com.google.cloud.redis.v1.ImportInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_INSTANCE:
          serviceImpl.exportInstance(
              (com.google.cloud.redis.v1.ExportInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FAILOVER_INSTANCE:
          serviceImpl.failoverInstance(
              (com.google.cloud.redis.v1.FailoverInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.redis.v1.DeleteInstanceRequest) request,
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

  private abstract static class CloudRedisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudRedisFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getImportInstanceMethod())
                      .addMethod(getExportInstanceMethod())
                      .addMethod(getFailoverInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
