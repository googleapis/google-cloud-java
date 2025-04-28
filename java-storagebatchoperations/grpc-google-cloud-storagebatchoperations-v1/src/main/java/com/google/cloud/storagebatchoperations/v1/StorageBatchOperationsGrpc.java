/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.storagebatchoperations.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Storage Batch Operations offers a managed experience to perform batch
 * operations on millions of Cloud Storage objects in a serverless fashion. With
 * this service, you can automate and simplify large scale API operations
 * performed on Cloud Storage objects.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/storagebatchoperations/v1/storage_batch_operations.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StorageBatchOperationsGrpc {

  private StorageBatchOperationsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.storagebatchoperations.v1.StorageBatchOperations";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.ListJobsRequest,
          com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.storagebatchoperations.v1.ListJobsRequest.class,
      responseType = com.google.cloud.storagebatchoperations.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.ListJobsRequest,
          com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
      getListJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storagebatchoperations.v1.ListJobsRequest,
            com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = StorageBatchOperationsGrpc.getListJobsMethod) == null) {
      synchronized (StorageBatchOperationsGrpc.class) {
        if ((getListJobsMethod = StorageBatchOperationsGrpc.getListJobsMethod) == null) {
          StorageBatchOperationsGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storagebatchoperations.v1.ListJobsRequest,
                          com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.ListJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.ListJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageBatchOperationsMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.GetJobRequest,
          com.google.cloud.storagebatchoperations.v1.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.storagebatchoperations.v1.GetJobRequest.class,
      responseType = com.google.cloud.storagebatchoperations.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.GetJobRequest,
          com.google.cloud.storagebatchoperations.v1.Job>
      getGetJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storagebatchoperations.v1.GetJobRequest,
            com.google.cloud.storagebatchoperations.v1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = StorageBatchOperationsGrpc.getGetJobMethod) == null) {
      synchronized (StorageBatchOperationsGrpc.class) {
        if ((getGetJobMethod = StorageBatchOperationsGrpc.getGetJobMethod) == null) {
          StorageBatchOperationsGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storagebatchoperations.v1.GetJobRequest,
                          com.google.cloud.storagebatchoperations.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.GetJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageBatchOperationsMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.CreateJobRequest,
          com.google.longrunning.Operation>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.storagebatchoperations.v1.CreateJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.CreateJobRequest,
          com.google.longrunning.Operation>
      getCreateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storagebatchoperations.v1.CreateJobRequest,
            com.google.longrunning.Operation>
        getCreateJobMethod;
    if ((getCreateJobMethod = StorageBatchOperationsGrpc.getCreateJobMethod) == null) {
      synchronized (StorageBatchOperationsGrpc.class) {
        if ((getCreateJobMethod = StorageBatchOperationsGrpc.getCreateJobMethod) == null) {
          StorageBatchOperationsGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storagebatchoperations.v1.CreateJobRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.CreateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageBatchOperationsMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.storagebatchoperations.v1.DeleteJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storagebatchoperations.v1.DeleteJobRequest, com.google.protobuf.Empty>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = StorageBatchOperationsGrpc.getDeleteJobMethod) == null) {
      synchronized (StorageBatchOperationsGrpc.class) {
        if ((getDeleteJobMethod = StorageBatchOperationsGrpc.getDeleteJobMethod) == null) {
          StorageBatchOperationsGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storagebatchoperations.v1.DeleteJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.DeleteJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageBatchOperationsMethodDescriptorSupplier("DeleteJob"))
                      .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.CancelJobRequest,
          com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
      getCancelJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelJob",
      requestType = com.google.cloud.storagebatchoperations.v1.CancelJobRequest.class,
      responseType = com.google.cloud.storagebatchoperations.v1.CancelJobResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.storagebatchoperations.v1.CancelJobRequest,
          com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
      getCancelJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.storagebatchoperations.v1.CancelJobRequest,
            com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
        getCancelJobMethod;
    if ((getCancelJobMethod = StorageBatchOperationsGrpc.getCancelJobMethod) == null) {
      synchronized (StorageBatchOperationsGrpc.class) {
        if ((getCancelJobMethod = StorageBatchOperationsGrpc.getCancelJobMethod) == null) {
          StorageBatchOperationsGrpc.getCancelJobMethod =
              getCancelJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.storagebatchoperations.v1.CancelJobRequest,
                          com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.CancelJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.storagebatchoperations.v1.CancelJobResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StorageBatchOperationsMethodDescriptorSupplier("CancelJob"))
                      .build();
        }
      }
    }
    return getCancelJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StorageBatchOperationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsStub>() {
          @java.lang.Override
          public StorageBatchOperationsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageBatchOperationsStub(channel, callOptions);
          }
        };
    return StorageBatchOperationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StorageBatchOperationsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsBlockingStub>() {
          @java.lang.Override
          public StorageBatchOperationsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageBatchOperationsBlockingStub(channel, callOptions);
          }
        };
    return StorageBatchOperationsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StorageBatchOperationsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StorageBatchOperationsFutureStub>() {
          @java.lang.Override
          public StorageBatchOperationsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StorageBatchOperationsFutureStub(channel, callOptions);
          }
        };
    return StorageBatchOperationsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Storage Batch Operations offers a managed experience to perform batch
   * operations on millions of Cloud Storage objects in a serverless fashion. With
   * this service, you can automate and simplify large scale API operations
   * performed on Cloud Storage objects.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Jobs in a given project and location.
     * </pre>
     */
    default void listJobs(
        com.google.cloud.storagebatchoperations.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a batch job.
     * </pre>
     */
    default void getJob(
        com.google.cloud.storagebatchoperations.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.Job>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch job.
     * </pre>
     */
    default void createJob(
        com.google.cloud.storagebatchoperations.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a batch job.
     * </pre>
     */
    default void deleteJob(
        com.google.cloud.storagebatchoperations.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a batch job.
     * </pre>
     */
    default void cancelJob(
        com.google.cloud.storagebatchoperations.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelJobMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StorageBatchOperations.
   *
   * <pre>
   * Storage Batch Operations offers a managed experience to perform batch
   * operations on millions of Cloud Storage objects in a serverless fashion. With
   * this service, you can automate and simplify large scale API operations
   * performed on Cloud Storage objects.
   * </pre>
   */
  public abstract static class StorageBatchOperationsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StorageBatchOperationsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StorageBatchOperations.
   *
   * <pre>
   * Storage Batch Operations offers a managed experience to perform batch
   * operations on millions of Cloud Storage objects in a serverless fashion. With
   * this service, you can automate and simplify large scale API operations
   * performed on Cloud Storage objects.
   * </pre>
   */
  public static final class StorageBatchOperationsStub
      extends io.grpc.stub.AbstractAsyncStub<StorageBatchOperationsStub> {
    private StorageBatchOperationsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBatchOperationsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageBatchOperationsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Jobs in a given project and location.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.storagebatchoperations.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a batch job.
     * </pre>
     */
    public void getJob(
        com.google.cloud.storagebatchoperations.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.Job>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch job.
     * </pre>
     */
    public void createJob(
        com.google.cloud.storagebatchoperations.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a batch job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.storagebatchoperations.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a batch job.
     * </pre>
     */
    public void cancelJob(
        com.google.cloud.storagebatchoperations.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StorageBatchOperations.
   *
   * <pre>
   * Storage Batch Operations offers a managed experience to perform batch
   * operations on millions of Cloud Storage objects in a serverless fashion. With
   * this service, you can automate and simplify large scale API operations
   * performed on Cloud Storage objects.
   * </pre>
   */
  public static final class StorageBatchOperationsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StorageBatchOperationsBlockingStub> {
    private StorageBatchOperationsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBatchOperationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageBatchOperationsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Jobs in a given project and location.
     * </pre>
     */
    public com.google.cloud.storagebatchoperations.v1.ListJobsResponse listJobs(
        com.google.cloud.storagebatchoperations.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a batch job.
     * </pre>
     */
    public com.google.cloud.storagebatchoperations.v1.Job getJob(
        com.google.cloud.storagebatchoperations.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch job.
     * </pre>
     */
    public com.google.longrunning.Operation createJob(
        com.google.cloud.storagebatchoperations.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a batch job.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(
        com.google.cloud.storagebatchoperations.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a batch job.
     * </pre>
     */
    public com.google.cloud.storagebatchoperations.v1.CancelJobResponse cancelJob(
        com.google.cloud.storagebatchoperations.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * StorageBatchOperations.
   *
   * <pre>
   * Storage Batch Operations offers a managed experience to perform batch
   * operations on millions of Cloud Storage objects in a serverless fashion. With
   * this service, you can automate and simplify large scale API operations
   * performed on Cloud Storage objects.
   * </pre>
   */
  public static final class StorageBatchOperationsFutureStub
      extends io.grpc.stub.AbstractFutureStub<StorageBatchOperationsFutureStub> {
    private StorageBatchOperationsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StorageBatchOperationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StorageBatchOperationsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Jobs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storagebatchoperations.v1.ListJobsResponse>
        listJobs(com.google.cloud.storagebatchoperations.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a batch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storagebatchoperations.v1.Job>
        getJob(com.google.cloud.storagebatchoperations.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a batch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createJob(com.google.cloud.storagebatchoperations.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a batch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.storagebatchoperations.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a batch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.storagebatchoperations.v1.CancelJobResponse>
        cancelJob(com.google.cloud.storagebatchoperations.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_JOBS = 0;
  private static final int METHODID_GET_JOB = 1;
  private static final int METHODID_CREATE_JOB = 2;
  private static final int METHODID_DELETE_JOB = 3;
  private static final int METHODID_CANCEL_JOB = 4;

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
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.storagebatchoperations.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.storagebatchoperations.v1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.storagebatchoperations.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.storagebatchoperations.v1.Job>)
                  responseObserver);
          break;
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.storagebatchoperations.v1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.storagebatchoperations.v1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CANCEL_JOB:
          serviceImpl.cancelJob(
              (com.google.cloud.storagebatchoperations.v1.CancelJobRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.storagebatchoperations.v1.CancelJobResponse>)
                  responseObserver);
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
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storagebatchoperations.v1.ListJobsRequest,
                    com.google.cloud.storagebatchoperations.v1.ListJobsResponse>(
                    service, METHODID_LIST_JOBS)))
        .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storagebatchoperations.v1.GetJobRequest,
                    com.google.cloud.storagebatchoperations.v1.Job>(service, METHODID_GET_JOB)))
        .addMethod(
            getCreateJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storagebatchoperations.v1.CreateJobRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_JOB)))
        .addMethod(
            getDeleteJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storagebatchoperations.v1.DeleteJobRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_JOB)))
        .addMethod(
            getCancelJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.storagebatchoperations.v1.CancelJobRequest,
                    com.google.cloud.storagebatchoperations.v1.CancelJobResponse>(
                    service, METHODID_CANCEL_JOB)))
        .build();
  }

  private abstract static class StorageBatchOperationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StorageBatchOperationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.storagebatchoperations.v1.StorageBatchOperationsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StorageBatchOperations");
    }
  }

  private static final class StorageBatchOperationsFileDescriptorSupplier
      extends StorageBatchOperationsBaseDescriptorSupplier {
    StorageBatchOperationsFileDescriptorSupplier() {}
  }

  private static final class StorageBatchOperationsMethodDescriptorSupplier
      extends StorageBatchOperationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StorageBatchOperationsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StorageBatchOperationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StorageBatchOperationsFileDescriptorSupplier())
                      .addMethod(getListJobsMethod())
                      .addMethod(getGetJobMethod())
                      .addMethod(getCreateJobMethod())
                      .addMethod(getDeleteJobMethod())
                      .addMethod(getCancelJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
