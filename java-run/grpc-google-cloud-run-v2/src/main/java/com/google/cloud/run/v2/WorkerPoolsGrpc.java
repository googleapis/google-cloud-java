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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Run WorkerPool Control Plane API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/worker_pool.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkerPoolsGrpc {

  private WorkerPoolsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.run.v2.WorkerPools";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateWorkerPoolRequest, com.google.longrunning.Operation>
      getCreateWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkerPool",
      requestType = com.google.cloud.run.v2.CreateWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateWorkerPoolRequest, com.google.longrunning.Operation>
      getCreateWorkerPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.CreateWorkerPoolRequest, com.google.longrunning.Operation>
        getCreateWorkerPoolMethod;
    if ((getCreateWorkerPoolMethod = WorkerPoolsGrpc.getCreateWorkerPoolMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getCreateWorkerPoolMethod = WorkerPoolsGrpc.getCreateWorkerPoolMethod) == null) {
          WorkerPoolsGrpc.getCreateWorkerPoolMethod =
              getCreateWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.CreateWorkerPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.CreateWorkerPoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkerPoolsMethodDescriptorSupplier("CreateWorkerPool"))
                      .build();
        }
      }
    }
    return getCreateWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetWorkerPoolRequest, com.google.cloud.run.v2.WorkerPool>
      getGetWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkerPool",
      requestType = com.google.cloud.run.v2.GetWorkerPoolRequest.class,
      responseType = com.google.cloud.run.v2.WorkerPool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetWorkerPoolRequest, com.google.cloud.run.v2.WorkerPool>
      getGetWorkerPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.GetWorkerPoolRequest, com.google.cloud.run.v2.WorkerPool>
        getGetWorkerPoolMethod;
    if ((getGetWorkerPoolMethod = WorkerPoolsGrpc.getGetWorkerPoolMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getGetWorkerPoolMethod = WorkerPoolsGrpc.getGetWorkerPoolMethod) == null) {
          WorkerPoolsGrpc.getGetWorkerPoolMethod =
              getGetWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetWorkerPoolRequest,
                          com.google.cloud.run.v2.WorkerPool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetWorkerPoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.WorkerPool.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkerPoolsMethodDescriptorSupplier("GetWorkerPool"))
                      .build();
        }
      }
    }
    return getGetWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListWorkerPoolsRequest,
          com.google.cloud.run.v2.ListWorkerPoolsResponse>
      getListWorkerPoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkerPools",
      requestType = com.google.cloud.run.v2.ListWorkerPoolsRequest.class,
      responseType = com.google.cloud.run.v2.ListWorkerPoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListWorkerPoolsRequest,
          com.google.cloud.run.v2.ListWorkerPoolsResponse>
      getListWorkerPoolsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListWorkerPoolsRequest,
            com.google.cloud.run.v2.ListWorkerPoolsResponse>
        getListWorkerPoolsMethod;
    if ((getListWorkerPoolsMethod = WorkerPoolsGrpc.getListWorkerPoolsMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getListWorkerPoolsMethod = WorkerPoolsGrpc.getListWorkerPoolsMethod) == null) {
          WorkerPoolsGrpc.getListWorkerPoolsMethod =
              getListWorkerPoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListWorkerPoolsRequest,
                          com.google.cloud.run.v2.ListWorkerPoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkerPools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListWorkerPoolsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListWorkerPoolsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkerPoolsMethodDescriptorSupplier("ListWorkerPools"))
                      .build();
        }
      }
    }
    return getListWorkerPoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UpdateWorkerPoolRequest, com.google.longrunning.Operation>
      getUpdateWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkerPool",
      requestType = com.google.cloud.run.v2.UpdateWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UpdateWorkerPoolRequest, com.google.longrunning.Operation>
      getUpdateWorkerPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.UpdateWorkerPoolRequest, com.google.longrunning.Operation>
        getUpdateWorkerPoolMethod;
    if ((getUpdateWorkerPoolMethod = WorkerPoolsGrpc.getUpdateWorkerPoolMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getUpdateWorkerPoolMethod = WorkerPoolsGrpc.getUpdateWorkerPoolMethod) == null) {
          WorkerPoolsGrpc.getUpdateWorkerPoolMethod =
              getUpdateWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.UpdateWorkerPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.UpdateWorkerPoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkerPoolsMethodDescriptorSupplier("UpdateWorkerPool"))
                      .build();
        }
      }
    }
    return getUpdateWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteWorkerPoolRequest, com.google.longrunning.Operation>
      getDeleteWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkerPool",
      requestType = com.google.cloud.run.v2.DeleteWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteWorkerPoolRequest, com.google.longrunning.Operation>
      getDeleteWorkerPoolMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.DeleteWorkerPoolRequest, com.google.longrunning.Operation>
        getDeleteWorkerPoolMethod;
    if ((getDeleteWorkerPoolMethod = WorkerPoolsGrpc.getDeleteWorkerPoolMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getDeleteWorkerPoolMethod = WorkerPoolsGrpc.getDeleteWorkerPoolMethod) == null) {
          WorkerPoolsGrpc.getDeleteWorkerPoolMethod =
              getDeleteWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.DeleteWorkerPoolRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.DeleteWorkerPoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkerPoolsMethodDescriptorSupplier("DeleteWorkerPool"))
                      .build();
        }
      }
    }
    return getDeleteWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = WorkerPoolsGrpc.getGetIamPolicyMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getGetIamPolicyMethod = WorkerPoolsGrpc.getGetIamPolicyMethod) == null) {
          WorkerPoolsGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkerPoolsMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = WorkerPoolsGrpc.getSetIamPolicyMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getSetIamPolicyMethod = WorkerPoolsGrpc.getSetIamPolicyMethod) == null) {
          WorkerPoolsGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkerPoolsMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = WorkerPoolsGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (WorkerPoolsGrpc.class) {
        if ((getTestIamPermissionsMethod = WorkerPoolsGrpc.getTestIamPermissionsMethod) == null) {
          WorkerPoolsGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkerPoolsMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkerPoolsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsStub>() {
          @java.lang.Override
          public WorkerPoolsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkerPoolsStub(channel, callOptions);
          }
        };
    return WorkerPoolsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static WorkerPoolsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsBlockingV2Stub>() {
          @java.lang.Override
          public WorkerPoolsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkerPoolsBlockingV2Stub(channel, callOptions);
          }
        };
    return WorkerPoolsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkerPoolsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsBlockingStub>() {
          @java.lang.Override
          public WorkerPoolsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkerPoolsBlockingStub(channel, callOptions);
          }
        };
    return WorkerPoolsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkerPoolsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkerPoolsFutureStub>() {
          @java.lang.Override
          public WorkerPoolsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkerPoolsFutureStub(channel, callOptions);
          }
        };
    return WorkerPoolsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new WorkerPool in a given project and location.
     * </pre>
     */
    default void createWorkerPool(
        com.google.cloud.run.v2.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkerPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a WorkerPool.
     * </pre>
     */
    default void getWorkerPool(
        com.google.cloud.run.v2.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.WorkerPool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkerPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists WorkerPools. Results are sorted by creation time, descending.
     * </pre>
     */
    default void listWorkerPools(
        com.google.cloud.run.v2.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListWorkerPoolsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkerPoolsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a WorkerPool.
     * </pre>
     */
    default void updateWorkerPool(
        com.google.cloud.run.v2.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkerPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a WorkerPool.
     * </pre>
     */
    default void deleteWorkerPool(
        com.google.cloud.run.v2.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkerPoolMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Access Control policy currently in effect for the given
     * Cloud Run WorkerPool. This result does not include any inherited policies.
     * </pre>
     */
    default void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Access control policy for the specified WorkerPool. Overwrites
     * any existing policy.
     * </pre>
     */
    default void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    default void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkerPools.
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public abstract static class WorkerPoolsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return WorkerPoolsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkerPools.
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public static final class WorkerPoolsStub
      extends io.grpc.stub.AbstractAsyncStub<WorkerPoolsStub> {
    private WorkerPoolsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerPoolsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerPoolsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new WorkerPool in a given project and location.
     * </pre>
     */
    public void createWorkerPool(
        com.google.cloud.run.v2.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a WorkerPool.
     * </pre>
     */
    public void getWorkerPool(
        com.google.cloud.run.v2.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.WorkerPool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists WorkerPools. Results are sorted by creation time, descending.
     * </pre>
     */
    public void listWorkerPools(
        com.google.cloud.run.v2.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListWorkerPoolsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a WorkerPool.
     * </pre>
     */
    public void updateWorkerPool(
        com.google.cloud.run.v2.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a WorkerPool.
     * </pre>
     */
    public void deleteWorkerPool(
        com.google.cloud.run.v2.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Access Control policy currently in effect for the given
     * Cloud Run WorkerPool. This result does not include any inherited policies.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Access control policy for the specified WorkerPool. Overwrites
     * any existing policy.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkerPools.
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public static final class WorkerPoolsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WorkerPoolsBlockingV2Stub> {
    private WorkerPoolsBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerPoolsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerPoolsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new WorkerPool in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkerPool(
        com.google.cloud.run.v2.CreateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a WorkerPool.
     * </pre>
     */
    public com.google.cloud.run.v2.WorkerPool getWorkerPool(
        com.google.cloud.run.v2.GetWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists WorkerPools. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.cloud.run.v2.ListWorkerPoolsResponse listWorkerPools(
        com.google.cloud.run.v2.ListWorkerPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkerPoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a WorkerPool.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkerPool(
        com.google.cloud.run.v2.UpdateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a WorkerPool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkerPool(
        com.google.cloud.run.v2.DeleteWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Access Control policy currently in effect for the given
     * Cloud Run WorkerPool. This result does not include any inherited policies.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Access control policy for the specified WorkerPool. Overwrites
     * any existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WorkerPools.
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public static final class WorkerPoolsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkerPoolsBlockingStub> {
    private WorkerPoolsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerPoolsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerPoolsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new WorkerPool in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkerPool(
        com.google.cloud.run.v2.CreateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a WorkerPool.
     * </pre>
     */
    public com.google.cloud.run.v2.WorkerPool getWorkerPool(
        com.google.cloud.run.v2.GetWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists WorkerPools. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.cloud.run.v2.ListWorkerPoolsResponse listWorkerPools(
        com.google.cloud.run.v2.ListWorkerPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkerPoolsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a WorkerPool.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkerPool(
        com.google.cloud.run.v2.UpdateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a WorkerPool.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkerPool(
        com.google.cloud.run.v2.DeleteWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Access Control policy currently in effect for the given
     * Cloud Run WorkerPool. This result does not include any inherited policies.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Access control policy for the specified WorkerPool. Overwrites
     * any existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkerPools.
   *
   * <pre>
   * Cloud Run WorkerPool Control Plane API.
   * </pre>
   */
  public static final class WorkerPoolsFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkerPoolsFutureStub> {
    private WorkerPoolsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerPoolsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerPoolsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new WorkerPool in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkerPool(com.google.cloud.run.v2.CreateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a WorkerPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.WorkerPool>
        getWorkerPool(com.google.cloud.run.v2.GetWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists WorkerPools. Results are sorted by creation time, descending.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListWorkerPoolsResponse>
        listWorkerPools(com.google.cloud.run.v2.ListWorkerPoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a WorkerPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateWorkerPool(com.google.cloud.run.v2.UpdateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a WorkerPool.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteWorkerPool(com.google.cloud.run.v2.DeleteWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Access Control policy currently in effect for the given
     * Cloud Run WorkerPool. This result does not include any inherited policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Access control policy for the specified WorkerPool. Overwrites
     * any existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKER_POOL = 0;
  private static final int METHODID_GET_WORKER_POOL = 1;
  private static final int METHODID_LIST_WORKER_POOLS = 2;
  private static final int METHODID_UPDATE_WORKER_POOL = 3;
  private static final int METHODID_DELETE_WORKER_POOL = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;

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
        case METHODID_CREATE_WORKER_POOL:
          serviceImpl.createWorkerPool(
              (com.google.cloud.run.v2.CreateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_WORKER_POOL:
          serviceImpl.getWorkerPool(
              (com.google.cloud.run.v2.GetWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.WorkerPool>) responseObserver);
          break;
        case METHODID_LIST_WORKER_POOLS:
          serviceImpl.listWorkerPools(
              (com.google.cloud.run.v2.ListWorkerPoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListWorkerPoolsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_WORKER_POOL:
          serviceImpl.updateWorkerPool(
              (com.google.cloud.run.v2.UpdateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKER_POOL:
          serviceImpl.deleteWorkerPool(
              (com.google.cloud.run.v2.DeleteWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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
            getCreateWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.CreateWorkerPoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_WORKER_POOL)))
        .addMethod(
            getGetWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.GetWorkerPoolRequest,
                    com.google.cloud.run.v2.WorkerPool>(service, METHODID_GET_WORKER_POOL)))
        .addMethod(
            getListWorkerPoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.ListWorkerPoolsRequest,
                    com.google.cloud.run.v2.ListWorkerPoolsResponse>(
                    service, METHODID_LIST_WORKER_POOLS)))
        .addMethod(
            getUpdateWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.UpdateWorkerPoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_WORKER_POOL)))
        .addMethod(
            getDeleteWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.run.v2.DeleteWorkerPoolRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_WORKER_POOL)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .build();
  }

  private abstract static class WorkerPoolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkerPoolsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.WorkerPoolProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkerPools");
    }
  }

  private static final class WorkerPoolsFileDescriptorSupplier
      extends WorkerPoolsBaseDescriptorSupplier {
    WorkerPoolsFileDescriptorSupplier() {}
  }

  private static final class WorkerPoolsMethodDescriptorSupplier
      extends WorkerPoolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkerPoolsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WorkerPoolsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkerPoolsFileDescriptorSupplier())
                      .addMethod(getCreateWorkerPoolMethod())
                      .addMethod(getGetWorkerPoolMethod())
                      .addMethod(getListWorkerPoolsMethod())
                      .addMethod(getUpdateWorkerPoolMethod())
                      .addMethod(getDeleteWorkerPoolMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
