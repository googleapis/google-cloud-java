/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.parallelstore.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * Configures and manages parallelstore resources.
 * Parallelstore service.
 * The `parallelstore.googleapis.com` service implements the parallelstore API
 * and defines the following resource model for managing instances:
 * * The service works with a collection of cloud projects, named: `/projects/&#42;`
 * * Each project has a collection of available locations, named: `/locations/&#42;`
 * * Each location has a collection of instances named `/instances/&#42;`.
 * * Parallelstore instances are resources of the form:
 *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
 * Note that location_id must be a Google Cloud `zone`; for example:
 * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/parallelstore/v1beta/parallelstore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ParallelstoreGrpc {

  private ParallelstoreGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.parallelstore.v1beta.Parallelstore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ListInstancesRequest,
          com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.parallelstore.v1beta.ListInstancesRequest.class,
      responseType = com.google.cloud.parallelstore.v1beta.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ListInstancesRequest,
          com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.ListInstancesRequest,
            com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = ParallelstoreGrpc.getListInstancesMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getListInstancesMethod = ParallelstoreGrpc.getListInstancesMethod) == null) {
          ParallelstoreGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.ListInstancesRequest,
                          com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParallelstoreMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.GetInstanceRequest,
          com.google.cloud.parallelstore.v1beta.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.parallelstore.v1beta.GetInstanceRequest.class,
      responseType = com.google.cloud.parallelstore.v1beta.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.GetInstanceRequest,
          com.google.cloud.parallelstore.v1beta.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.GetInstanceRequest,
            com.google.cloud.parallelstore.v1beta.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = ParallelstoreGrpc.getGetInstanceMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getGetInstanceMethod = ParallelstoreGrpc.getGetInstanceMethod) == null) {
          ParallelstoreGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.GetInstanceRequest,
                          com.google.cloud.parallelstore.v1beta.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new ParallelstoreMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.parallelstore.v1beta.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.CreateInstanceRequest,
          com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.CreateInstanceRequest,
            com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = ParallelstoreGrpc.getCreateInstanceMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getCreateInstanceMethod = ParallelstoreGrpc.getCreateInstanceMethod) == null) {
          ParallelstoreGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParallelstoreMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest,
          com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest,
            com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = ParallelstoreGrpc.getUpdateInstanceMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getUpdateInstanceMethod = ParallelstoreGrpc.getUpdateInstanceMethod) == null) {
          ParallelstoreGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParallelstoreMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest,
          com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest,
            com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = ParallelstoreGrpc.getDeleteInstanceMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getDeleteInstanceMethod = ParallelstoreGrpc.getDeleteInstanceMethod) == null) {
          ParallelstoreGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParallelstoreMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.parallelstore.v1beta.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.ImportDataRequest,
            com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = ParallelstoreGrpc.getImportDataMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getImportDataMethod = ParallelstoreGrpc.getImportDataMethod) == null) {
          ParallelstoreGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.ImportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ParallelstoreMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.parallelstore.v1beta.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.parallelstore.v1beta.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.parallelstore.v1beta.ExportDataRequest,
            com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = ParallelstoreGrpc.getExportDataMethod) == null) {
      synchronized (ParallelstoreGrpc.class) {
        if ((getExportDataMethod = ParallelstoreGrpc.getExportDataMethod) == null) {
          ParallelstoreGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.parallelstore.v1beta.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.parallelstore.v1beta.ExportDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ParallelstoreMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ParallelstoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParallelstoreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParallelstoreStub>() {
          @java.lang.Override
          public ParallelstoreStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParallelstoreStub(channel, callOptions);
          }
        };
    return ParallelstoreStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParallelstoreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParallelstoreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParallelstoreBlockingStub>() {
          @java.lang.Override
          public ParallelstoreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParallelstoreBlockingStub(channel, callOptions);
          }
        };
    return ParallelstoreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ParallelstoreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParallelstoreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParallelstoreFutureStub>() {
          @java.lang.Override
          public ParallelstoreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParallelstoreFutureStub(channel, callOptions);
          }
        };
    return ParallelstoreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * Configures and manages parallelstore resources.
   * Parallelstore service.
   * The `parallelstore.googleapis.com` service implements the parallelstore API
   * and defines the following resource model for managing instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of instances named `/instances/&#42;`.
   * * Parallelstore instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a Google Cloud `zone`; for example:
   * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.parallelstore.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.parallelstore.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parallelstore.v1beta.Instance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Parallelstore instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.parallelstore.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ImportData copies data from Cloud Storage to Parallelstore.
     * </pre>
     */
    default void importData(
        com.google.cloud.parallelstore.v1beta.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ExportData copies data from Parallelstore to Cloud Storage
     * </pre>
     */
    default void exportData(
        com.google.cloud.parallelstore.v1beta.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Parallelstore.
   *
   * <pre>
   * Service describing handlers for resources
   * Configures and manages parallelstore resources.
   * Parallelstore service.
   * The `parallelstore.googleapis.com` service implements the parallelstore API
   * and defines the following resource model for managing instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of instances named `/instances/&#42;`.
   * * Parallelstore instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a Google Cloud `zone`; for example:
   * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
   * </pre>
   */
  public abstract static class ParallelstoreImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ParallelstoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Parallelstore.
   *
   * <pre>
   * Service describing handlers for resources
   * Configures and manages parallelstore resources.
   * Parallelstore service.
   * The `parallelstore.googleapis.com` service implements the parallelstore API
   * and defines the following resource model for managing instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of instances named `/instances/&#42;`.
   * * Parallelstore instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a Google Cloud `zone`; for example:
   * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
   * </pre>
   */
  public static final class ParallelstoreStub
      extends io.grpc.stub.AbstractAsyncStub<ParallelstoreStub> {
    private ParallelstoreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParallelstoreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParallelstoreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.parallelstore.v1beta.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.parallelstore.v1beta.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.parallelstore.v1beta.Instance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Parallelstore instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.parallelstore.v1beta.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ImportData copies data from Cloud Storage to Parallelstore.
     * </pre>
     */
    public void importData(
        com.google.cloud.parallelstore.v1beta.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ExportData copies data from Parallelstore to Cloud Storage
     * </pre>
     */
    public void exportData(
        com.google.cloud.parallelstore.v1beta.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Parallelstore.
   *
   * <pre>
   * Service describing handlers for resources
   * Configures and manages parallelstore resources.
   * Parallelstore service.
   * The `parallelstore.googleapis.com` service implements the parallelstore API
   * and defines the following resource model for managing instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of instances named `/instances/&#42;`.
   * * Parallelstore instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a Google Cloud `zone`; for example:
   * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
   * </pre>
   */
  public static final class ParallelstoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ParallelstoreBlockingStub> {
    private ParallelstoreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParallelstoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParallelstoreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.parallelstore.v1beta.ListInstancesResponse listInstances(
        com.google.cloud.parallelstore.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.parallelstore.v1beta.Instance getInstance(
        com.google.cloud.parallelstore.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Parallelstore instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.parallelstore.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ImportData copies data from Cloud Storage to Parallelstore.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.parallelstore.v1beta.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ExportData copies data from Parallelstore to Cloud Storage
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.parallelstore.v1beta.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Parallelstore.
   *
   * <pre>
   * Service describing handlers for resources
   * Configures and manages parallelstore resources.
   * Parallelstore service.
   * The `parallelstore.googleapis.com` service implements the parallelstore API
   * and defines the following resource model for managing instances:
   * * The service works with a collection of cloud projects, named: `/projects/&#42;`
   * * Each project has a collection of available locations, named: `/locations/&#42;`
   * * Each location has a collection of instances named `/instances/&#42;`.
   * * Parallelstore instances are resources of the form:
   *   `/projects/{project_id}/locations/{location_id}/instances/{instance_id}`
   * Note that location_id must be a Google Cloud `zone`; for example:
   * * `projects/12345/locations/us-central1-c/instances/my-parallelstore-share`
   * </pre>
   */
  public static final class ParallelstoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<ParallelstoreFutureStub> {
    private ParallelstoreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParallelstoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParallelstoreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parallelstore.v1beta.ListInstancesResponse>
        listInstances(com.google.cloud.parallelstore.v1beta.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.parallelstore.v1beta.Instance>
        getInstance(com.google.cloud.parallelstore.v1beta.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Parallelstore instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.parallelstore.v1beta.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * ImportData copies data from Cloud Storage to Parallelstore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.parallelstore.v1beta.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * ExportData copies data from Parallelstore to Cloud Storage
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.parallelstore.v1beta.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_IMPORT_DATA = 5;
  private static final int METHODID_EXPORT_DATA = 6;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.parallelstore.v1beta.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.parallelstore.v1beta.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.parallelstore.v1beta.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.parallelstore.v1beta.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.parallelstore.v1beta.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.parallelstore.v1beta.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.parallelstore.v1beta.ExportDataRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.ListInstancesRequest,
                    com.google.cloud.parallelstore.v1beta.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.GetInstanceRequest,
                    com.google.cloud.parallelstore.v1beta.Instance>(
                    service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getImportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.ImportDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_DATA)))
        .addMethod(
            getExportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.parallelstore.v1beta.ExportDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_DATA)))
        .build();
  }

  private abstract static class ParallelstoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParallelstoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.parallelstore.v1beta.ParallelstoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Parallelstore");
    }
  }

  private static final class ParallelstoreFileDescriptorSupplier
      extends ParallelstoreBaseDescriptorSupplier {
    ParallelstoreFileDescriptorSupplier() {}
  }

  private static final class ParallelstoreMethodDescriptorSupplier
      extends ParallelstoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ParallelstoreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ParallelstoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ParallelstoreFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
