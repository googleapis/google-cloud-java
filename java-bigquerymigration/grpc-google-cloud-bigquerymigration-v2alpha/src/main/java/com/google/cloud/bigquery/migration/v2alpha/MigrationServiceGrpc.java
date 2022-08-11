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
package com.google.cloud.bigquery.migration.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to handle EDW migrations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/migration/v2alpha/migration_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MigrationServiceGrpc {

  private MigrationServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.bigquery.migration.v2alpha.MigrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
      getCreateMigrationWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMigrationWorkflow",
      requestType =
          com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest.class,
      responseType = com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
      getCreateMigrationWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest,
            com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
        getCreateMigrationWorkflowMethod;
    if ((getCreateMigrationWorkflowMethod = MigrationServiceGrpc.getCreateMigrationWorkflowMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getCreateMigrationWorkflowMethod =
                MigrationServiceGrpc.getCreateMigrationWorkflowMethod)
            == null) {
          MigrationServiceGrpc.getCreateMigrationWorkflowMethod =
              getCreateMigrationWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest,
                          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateMigrationWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .CreateMigrationWorkflowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("CreateMigrationWorkflow"))
                      .build();
        }
      }
    }
    return getCreateMigrationWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
      getGetMigrationWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMigrationWorkflow",
      requestType = com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest.class,
      responseType = com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
      getGetMigrationWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest,
            com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
        getGetMigrationWorkflowMethod;
    if ((getGetMigrationWorkflowMethod = MigrationServiceGrpc.getGetMigrationWorkflowMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getGetMigrationWorkflowMethod = MigrationServiceGrpc.getGetMigrationWorkflowMethod)
            == null) {
          MigrationServiceGrpc.getGetMigrationWorkflowMethod =
              getGetMigrationWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest,
                          com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMigrationWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .GetMigrationWorkflowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("GetMigrationWorkflow"))
                      .build();
        }
      }
    }
    return getGetMigrationWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest,
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
      getListMigrationWorkflowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMigrationWorkflows",
      requestType = com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest.class,
      responseType =
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest,
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
      getListMigrationWorkflowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest,
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
        getListMigrationWorkflowsMethod;
    if ((getListMigrationWorkflowsMethod = MigrationServiceGrpc.getListMigrationWorkflowsMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getListMigrationWorkflowsMethod = MigrationServiceGrpc.getListMigrationWorkflowsMethod)
            == null) {
          MigrationServiceGrpc.getListMigrationWorkflowsMethod =
              getListMigrationWorkflowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest,
                          com.google.cloud.bigquery.migration.v2alpha
                              .ListMigrationWorkflowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMigrationWorkflows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .ListMigrationWorkflowsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .ListMigrationWorkflowsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("ListMigrationWorkflows"))
                      .build();
        }
      }
    }
    return getListMigrationWorkflowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest,
          com.google.protobuf.Empty>
      getDeleteMigrationWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMigrationWorkflow",
      requestType =
          com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest,
          com.google.protobuf.Empty>
      getDeleteMigrationWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest,
            com.google.protobuf.Empty>
        getDeleteMigrationWorkflowMethod;
    if ((getDeleteMigrationWorkflowMethod = MigrationServiceGrpc.getDeleteMigrationWorkflowMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getDeleteMigrationWorkflowMethod =
                MigrationServiceGrpc.getDeleteMigrationWorkflowMethod)
            == null) {
          MigrationServiceGrpc.getDeleteMigrationWorkflowMethod =
              getDeleteMigrationWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteMigrationWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .DeleteMigrationWorkflowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("DeleteMigrationWorkflow"))
                      .build();
        }
      }
    }
    return getDeleteMigrationWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest,
          com.google.protobuf.Empty>
      getStartMigrationWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartMigrationWorkflow",
      requestType = com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest,
          com.google.protobuf.Empty>
      getStartMigrationWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest,
            com.google.protobuf.Empty>
        getStartMigrationWorkflowMethod;
    if ((getStartMigrationWorkflowMethod = MigrationServiceGrpc.getStartMigrationWorkflowMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getStartMigrationWorkflowMethod = MigrationServiceGrpc.getStartMigrationWorkflowMethod)
            == null) {
          MigrationServiceGrpc.getStartMigrationWorkflowMethod =
              getStartMigrationWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StartMigrationWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .StartMigrationWorkflowRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("StartMigrationWorkflow"))
                      .build();
        }
      }
    }
    return getStartMigrationWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
      getGetMigrationSubtaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMigrationSubtask",
      requestType = com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest.class,
      responseType = com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest,
          com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
      getGetMigrationSubtaskMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest,
            com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
        getGetMigrationSubtaskMethod;
    if ((getGetMigrationSubtaskMethod = MigrationServiceGrpc.getGetMigrationSubtaskMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getGetMigrationSubtaskMethod = MigrationServiceGrpc.getGetMigrationSubtaskMethod)
            == null) {
          MigrationServiceGrpc.getGetMigrationSubtaskMethod =
              getGetMigrationSubtaskMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest,
                          com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetMigrationSubtask"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("GetMigrationSubtask"))
                      .build();
        }
      }
    }
    return getGetMigrationSubtaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest,
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
      getListMigrationSubtasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMigrationSubtasks",
      requestType = com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest.class,
      responseType =
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest,
          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
      getListMigrationSubtasksMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest,
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
        getListMigrationSubtasksMethod;
    if ((getListMigrationSubtasksMethod = MigrationServiceGrpc.getListMigrationSubtasksMethod)
        == null) {
      synchronized (MigrationServiceGrpc.class) {
        if ((getListMigrationSubtasksMethod = MigrationServiceGrpc.getListMigrationSubtasksMethod)
            == null) {
          MigrationServiceGrpc.getListMigrationSubtasksMethod =
              getListMigrationSubtasksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest,
                          com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMigrationSubtasks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .ListMigrationSubtasksRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha
                                  .ListMigrationSubtasksResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new MigrationServiceMethodDescriptorSupplier("ListMigrationSubtasks"))
                      .build();
        }
      }
    }
    return getListMigrationSubtasksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static MigrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceStub>() {
          @java.lang.Override
          public MigrationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationServiceStub(channel, callOptions);
          }
        };
    return MigrationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MigrationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceBlockingStub>() {
          @java.lang.Override
          public MigrationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationServiceBlockingStub(channel, callOptions);
          }
        };
    return MigrationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static MigrationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MigrationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<MigrationServiceFutureStub>() {
          @java.lang.Override
          public MigrationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MigrationServiceFutureStub(channel, callOptions);
          }
        };
    return MigrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to handle EDW migrations.
   * </pre>
   */
  public abstract static class MigrationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a migration workflow.
     * </pre>
     */
    public void createMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMigrationWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration workflow.
     * </pre>
     */
    public void getMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMigrationWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration workflow.
     * </pre>
     */
    public void listMigrationWorkflows(
        com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMigrationWorkflowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a migration workflow by name.
     * </pre>
     */
    public void deleteMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMigrationWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a previously created migration workflow. I.e., the state transitions
     * from DRAFT to RUNNING. This is a no-op if the state is already RUNNING.
     * An error will be signaled if the state is anything other than DRAFT or
     * RUNNING.
     * </pre>
     */
    public void startMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStartMigrationWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration subtask.
     * </pre>
     */
    public void getMigrationSubtask(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMigrationSubtaskMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration subtasks.
     * </pre>
     */
    public void listMigrationSubtasks(
        com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMigrationSubtasksMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateMigrationWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest,
                      com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>(
                      this, METHODID_CREATE_MIGRATION_WORKFLOW)))
          .addMethod(
              getGetMigrationWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest,
                      com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>(
                      this, METHODID_GET_MIGRATION_WORKFLOW)))
          .addMethod(
              getListMigrationWorkflowsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest,
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>(
                      this, METHODID_LIST_MIGRATION_WORKFLOWS)))
          .addMethod(
              getDeleteMigrationWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_MIGRATION_WORKFLOW)))
          .addMethod(
              getStartMigrationWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest,
                      com.google.protobuf.Empty>(this, METHODID_START_MIGRATION_WORKFLOW)))
          .addMethod(
              getGetMigrationSubtaskMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest,
                      com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>(
                      this, METHODID_GET_MIGRATION_SUBTASK)))
          .addMethod(
              getListMigrationSubtasksMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest,
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>(
                      this, METHODID_LIST_MIGRATION_SUBTASKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to handle EDW migrations.
   * </pre>
   */
  public static final class MigrationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MigrationServiceStub> {
    private MigrationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a migration workflow.
     * </pre>
     */
    public void createMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMigrationWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration workflow.
     * </pre>
     */
    public void getMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMigrationWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration workflow.
     * </pre>
     */
    public void listMigrationWorkflows(
        com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMigrationWorkflowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a migration workflow by name.
     * </pre>
     */
    public void deleteMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMigrationWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Starts a previously created migration workflow. I.e., the state transitions
     * from DRAFT to RUNNING. This is a no-op if the state is already RUNNING.
     * An error will be signaled if the state is anything other than DRAFT or
     * RUNNING.
     * </pre>
     */
    public void startMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartMigrationWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration subtask.
     * </pre>
     */
    public void getMigrationSubtask(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMigrationSubtaskMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration subtasks.
     * </pre>
     */
    public void listMigrationSubtasks(
        com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMigrationSubtasksMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to handle EDW migrations.
   * </pre>
   */
  public static final class MigrationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MigrationServiceBlockingStub> {
    private MigrationServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a migration workflow.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow createMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMigrationWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration workflow.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow getMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMigrationWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration workflow.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse
        listMigrationWorkflows(
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMigrationWorkflowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a migration workflow by name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMigrationWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a previously created migration workflow. I.e., the state transitions
     * from DRAFT to RUNNING. This is a no-op if the state is already RUNNING.
     * An error will be signaled if the state is anything other than DRAFT or
     * RUNNING.
     * </pre>
     */
    public com.google.protobuf.Empty startMigrationWorkflow(
        com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartMigrationWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration subtask.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask getMigrationSubtask(
        com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMigrationSubtaskMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration subtasks.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse
        listMigrationSubtasks(
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMigrationSubtasksMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to handle EDW migrations.
   * </pre>
   */
  public static final class MigrationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MigrationServiceFutureStub> {
    private MigrationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MigrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MigrationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a migration workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
        createMigrationWorkflow(
            com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMigrationWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>
        getMigrationWorkflow(
            com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMigrationWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>
        listMigrationWorkflows(
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMigrationWorkflowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a migration workflow by name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMigrationWorkflow(
            com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMigrationWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Starts a previously created migration workflow. I.e., the state transitions
     * from DRAFT to RUNNING. This is a no-op if the state is already RUNNING.
     * An error will be signaled if the state is anything other than DRAFT or
     * RUNNING.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        startMigrationWorkflow(
            com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartMigrationWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a previously created migration subtask.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>
        getMigrationSubtask(
            com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMigrationSubtaskMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously created migration subtasks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>
        listMigrationSubtasks(
            com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMigrationSubtasksMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MIGRATION_WORKFLOW = 0;
  private static final int METHODID_GET_MIGRATION_WORKFLOW = 1;
  private static final int METHODID_LIST_MIGRATION_WORKFLOWS = 2;
  private static final int METHODID_DELETE_MIGRATION_WORKFLOW = 3;
  private static final int METHODID_START_MIGRATION_WORKFLOW = 4;
  private static final int METHODID_GET_MIGRATION_SUBTASK = 5;
  private static final int METHODID_LIST_MIGRATION_SUBTASKS = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MigrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MigrationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_MIGRATION_WORKFLOW:
          serviceImpl.createMigrationWorkflow(
              (com.google.cloud.bigquery.migration.v2alpha.CreateMigrationWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>)
                  responseObserver);
          break;
        case METHODID_GET_MIGRATION_WORKFLOW:
          serviceImpl.getMigrationWorkflow(
              (com.google.cloud.bigquery.migration.v2alpha.GetMigrationWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.MigrationWorkflow>)
                  responseObserver);
          break;
        case METHODID_LIST_MIGRATION_WORKFLOWS:
          serviceImpl.listMigrationWorkflows(
              (com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationWorkflowsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MIGRATION_WORKFLOW:
          serviceImpl.deleteMigrationWorkflow(
              (com.google.cloud.bigquery.migration.v2alpha.DeleteMigrationWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_START_MIGRATION_WORKFLOW:
          serviceImpl.startMigrationWorkflow(
              (com.google.cloud.bigquery.migration.v2alpha.StartMigrationWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_MIGRATION_SUBTASK:
          serviceImpl.getMigrationSubtask(
              (com.google.cloud.bigquery.migration.v2alpha.GetMigrationSubtaskRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.MigrationSubtask>)
                  responseObserver);
          break;
        case METHODID_LIST_MIGRATION_SUBTASKS:
          serviceImpl.listMigrationSubtasks(
              (com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.ListMigrationSubtasksResponse>)
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

  private abstract static class MigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MigrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.migration.v2alpha.MigrationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MigrationService");
    }
  }

  private static final class MigrationServiceFileDescriptorSupplier
      extends MigrationServiceBaseDescriptorSupplier {
    MigrationServiceFileDescriptorSupplier() {}
  }

  private static final class MigrationServiceMethodDescriptorSupplier
      extends MigrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MigrationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MigrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new MigrationServiceFileDescriptorSupplier())
                      .addMethod(getCreateMigrationWorkflowMethod())
                      .addMethod(getGetMigrationWorkflowMethod())
                      .addMethod(getListMigrationWorkflowsMethod())
                      .addMethod(getDeleteMigrationWorkflowMethod())
                      .addMethod(getStartMigrationWorkflowMethod())
                      .addMethod(getGetMigrationSubtaskMethod())
                      .addMethod(getListMigrationSubtasksMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
