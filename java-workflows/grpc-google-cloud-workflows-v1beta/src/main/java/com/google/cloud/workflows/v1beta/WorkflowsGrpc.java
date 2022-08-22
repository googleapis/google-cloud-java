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
package com.google.cloud.workflows.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Workflows is used to deploy and execute workflow programs.
 * Workflows makes sure the program executes reliably, despite hardware and
 * networking interruptions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/workflows/v1beta/workflows.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkflowsGrpc {

  private WorkflowsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.workflows.v1beta.Workflows";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.ListWorkflowsRequest,
          com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
      getListWorkflowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkflows",
      requestType = com.google.cloud.workflows.v1beta.ListWorkflowsRequest.class,
      responseType = com.google.cloud.workflows.v1beta.ListWorkflowsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.ListWorkflowsRequest,
          com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
      getListWorkflowsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.v1beta.ListWorkflowsRequest,
            com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
        getListWorkflowsMethod;
    if ((getListWorkflowsMethod = WorkflowsGrpc.getListWorkflowsMethod) == null) {
      synchronized (WorkflowsGrpc.class) {
        if ((getListWorkflowsMethod = WorkflowsGrpc.getListWorkflowsMethod) == null) {
          WorkflowsGrpc.getListWorkflowsMethod =
              getListWorkflowsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.v1beta.ListWorkflowsRequest,
                          com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkflows"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.ListWorkflowsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.ListWorkflowsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new WorkflowsMethodDescriptorSupplier("ListWorkflows"))
                      .build();
        }
      }
    }
    return getListWorkflowsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.GetWorkflowRequest,
          com.google.cloud.workflows.v1beta.Workflow>
      getGetWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkflow",
      requestType = com.google.cloud.workflows.v1beta.GetWorkflowRequest.class,
      responseType = com.google.cloud.workflows.v1beta.Workflow.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.GetWorkflowRequest,
          com.google.cloud.workflows.v1beta.Workflow>
      getGetWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.v1beta.GetWorkflowRequest,
            com.google.cloud.workflows.v1beta.Workflow>
        getGetWorkflowMethod;
    if ((getGetWorkflowMethod = WorkflowsGrpc.getGetWorkflowMethod) == null) {
      synchronized (WorkflowsGrpc.class) {
        if ((getGetWorkflowMethod = WorkflowsGrpc.getGetWorkflowMethod) == null) {
          WorkflowsGrpc.getGetWorkflowMethod =
              getGetWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.v1beta.GetWorkflowRequest,
                          com.google.cloud.workflows.v1beta.Workflow>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.GetWorkflowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.Workflow.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkflowsMethodDescriptorSupplier("GetWorkflow"))
                      .build();
        }
      }
    }
    return getGetWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.CreateWorkflowRequest, com.google.longrunning.Operation>
      getCreateWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkflow",
      requestType = com.google.cloud.workflows.v1beta.CreateWorkflowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.CreateWorkflowRequest, com.google.longrunning.Operation>
      getCreateWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.v1beta.CreateWorkflowRequest,
            com.google.longrunning.Operation>
        getCreateWorkflowMethod;
    if ((getCreateWorkflowMethod = WorkflowsGrpc.getCreateWorkflowMethod) == null) {
      synchronized (WorkflowsGrpc.class) {
        if ((getCreateWorkflowMethod = WorkflowsGrpc.getCreateWorkflowMethod) == null) {
          WorkflowsGrpc.getCreateWorkflowMethod =
              getCreateWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.v1beta.CreateWorkflowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.CreateWorkflowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkflowsMethodDescriptorSupplier("CreateWorkflow"))
                      .build();
        }
      }
    }
    return getCreateWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.DeleteWorkflowRequest, com.google.longrunning.Operation>
      getDeleteWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkflow",
      requestType = com.google.cloud.workflows.v1beta.DeleteWorkflowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.DeleteWorkflowRequest, com.google.longrunning.Operation>
      getDeleteWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.v1beta.DeleteWorkflowRequest,
            com.google.longrunning.Operation>
        getDeleteWorkflowMethod;
    if ((getDeleteWorkflowMethod = WorkflowsGrpc.getDeleteWorkflowMethod) == null) {
      synchronized (WorkflowsGrpc.class) {
        if ((getDeleteWorkflowMethod = WorkflowsGrpc.getDeleteWorkflowMethod) == null) {
          WorkflowsGrpc.getDeleteWorkflowMethod =
              getDeleteWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.v1beta.DeleteWorkflowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.DeleteWorkflowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkflowsMethodDescriptorSupplier("DeleteWorkflow"))
                      .build();
        }
      }
    }
    return getDeleteWorkflowMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.UpdateWorkflowRequest, com.google.longrunning.Operation>
      getUpdateWorkflowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkflow",
      requestType = com.google.cloud.workflows.v1beta.UpdateWorkflowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.workflows.v1beta.UpdateWorkflowRequest, com.google.longrunning.Operation>
      getUpdateWorkflowMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.workflows.v1beta.UpdateWorkflowRequest,
            com.google.longrunning.Operation>
        getUpdateWorkflowMethod;
    if ((getUpdateWorkflowMethod = WorkflowsGrpc.getUpdateWorkflowMethod) == null) {
      synchronized (WorkflowsGrpc.class) {
        if ((getUpdateWorkflowMethod = WorkflowsGrpc.getUpdateWorkflowMethod) == null) {
          WorkflowsGrpc.getUpdateWorkflowMethod =
              getUpdateWorkflowMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.workflows.v1beta.UpdateWorkflowRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkflow"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.workflows.v1beta.UpdateWorkflowRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new WorkflowsMethodDescriptorSupplier("UpdateWorkflow"))
                      .build();
        }
      }
    }
    return getUpdateWorkflowMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkflowsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowsStub>() {
          @java.lang.Override
          public WorkflowsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowsStub(channel, callOptions);
          }
        };
    return WorkflowsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkflowsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowsBlockingStub>() {
          @java.lang.Override
          public WorkflowsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowsBlockingStub(channel, callOptions);
          }
        };
    return WorkflowsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkflowsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowsFutureStub>() {
          @java.lang.Override
          public WorkflowsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowsFutureStub(channel, callOptions);
          }
        };
    return WorkflowsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Workflows is used to deploy and execute workflow programs.
   * Workflows makes sure the program executes reliably, despite hardware and
   * networking interruptions.
   * </pre>
   */
  public abstract static class WorkflowsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists Workflows in a given project and location.
     * The default order is not specified.
     * </pre>
     */
    public void listWorkflows(
        com.google.cloud.workflows.v1beta.ListWorkflowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkflowsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Workflow.
     * </pre>
     */
    public void getWorkflow(
        com.google.cloud.workflows.v1beta.GetWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.Workflow> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workflow. If a workflow with the specified name already
     * exists in the specified project and location, the long running operation
     * will return [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public void createWorkflow(
        com.google.cloud.workflows.v1beta.CreateWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow with the specified name.
     * This method also cancels and deletes all running executions of the
     * workflow.
     * </pre>
     */
    public void deleteWorkflow(
        com.google.cloud.workflows.v1beta.DeleteWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkflowMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workflow.
     * Running this method has no impact on already running executions of the
     * workflow. A new revision of the workflow may be created as a result of a
     * successful update operation. In that case, such revision will be used
     * in new workflow executions.
     * </pre>
     */
    public void updateWorkflow(
        com.google.cloud.workflows.v1beta.UpdateWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkflowMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListWorkflowsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.v1beta.ListWorkflowsRequest,
                      com.google.cloud.workflows.v1beta.ListWorkflowsResponse>(
                      this, METHODID_LIST_WORKFLOWS)))
          .addMethod(
              getGetWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.v1beta.GetWorkflowRequest,
                      com.google.cloud.workflows.v1beta.Workflow>(this, METHODID_GET_WORKFLOW)))
          .addMethod(
              getCreateWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.v1beta.CreateWorkflowRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_WORKFLOW)))
          .addMethod(
              getDeleteWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.v1beta.DeleteWorkflowRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_WORKFLOW)))
          .addMethod(
              getUpdateWorkflowMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.workflows.v1beta.UpdateWorkflowRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_WORKFLOW)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Workflows is used to deploy and execute workflow programs.
   * Workflows makes sure the program executes reliably, despite hardware and
   * networking interruptions.
   * </pre>
   */
  public static final class WorkflowsStub extends io.grpc.stub.AbstractAsyncStub<WorkflowsStub> {
    private WorkflowsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Workflows in a given project and location.
     * The default order is not specified.
     * </pre>
     */
    public void listWorkflows(
        com.google.cloud.workflows.v1beta.ListWorkflowsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkflowsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Workflow.
     * </pre>
     */
    public void getWorkflow(
        com.google.cloud.workflows.v1beta.GetWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.Workflow> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workflow. If a workflow with the specified name already
     * exists in the specified project and location, the long running operation
     * will return [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public void createWorkflow(
        com.google.cloud.workflows.v1beta.CreateWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow with the specified name.
     * This method also cancels and deletes all running executions of the
     * workflow.
     * </pre>
     */
    public void deleteWorkflow(
        com.google.cloud.workflows.v1beta.DeleteWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workflow.
     * Running this method has no impact on already running executions of the
     * workflow. A new revision of the workflow may be created as a result of a
     * successful update operation. In that case, such revision will be used
     * in new workflow executions.
     * </pre>
     */
    public void updateWorkflow(
        com.google.cloud.workflows.v1beta.UpdateWorkflowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkflowMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Workflows is used to deploy and execute workflow programs.
   * Workflows makes sure the program executes reliably, despite hardware and
   * networking interruptions.
   * </pre>
   */
  public static final class WorkflowsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkflowsBlockingStub> {
    private WorkflowsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Workflows in a given project and location.
     * The default order is not specified.
     * </pre>
     */
    public com.google.cloud.workflows.v1beta.ListWorkflowsResponse listWorkflows(
        com.google.cloud.workflows.v1beta.ListWorkflowsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkflowsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Workflow.
     * </pre>
     */
    public com.google.cloud.workflows.v1beta.Workflow getWorkflow(
        com.google.cloud.workflows.v1beta.GetWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workflow. If a workflow with the specified name already
     * exists in the specified project and location, the long running operation
     * will return [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkflow(
        com.google.cloud.workflows.v1beta.CreateWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow with the specified name.
     * This method also cancels and deletes all running executions of the
     * workflow.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkflow(
        com.google.cloud.workflows.v1beta.DeleteWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkflowMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workflow.
     * Running this method has no impact on already running executions of the
     * workflow. A new revision of the workflow may be created as a result of a
     * successful update operation. In that case, such revision will be used
     * in new workflow executions.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkflow(
        com.google.cloud.workflows.v1beta.UpdateWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkflowMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Workflows is used to deploy and execute workflow programs.
   * Workflows makes sure the program executes reliably, despite hardware and
   * networking interruptions.
   * </pre>
   */
  public static final class WorkflowsFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkflowsFutureStub> {
    private WorkflowsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Workflows in a given project and location.
     * The default order is not specified.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.v1beta.ListWorkflowsResponse>
        listWorkflows(com.google.cloud.workflows.v1beta.ListWorkflowsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkflowsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.workflows.v1beta.Workflow>
        getWorkflow(com.google.cloud.workflows.v1beta.GetWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new workflow. If a workflow with the specified name already
     * exists in the specified project and location, the long running operation
     * will return [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkflow(com.google.cloud.workflows.v1beta.CreateWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow with the specified name.
     * This method also cancels and deletes all running executions of the
     * workflow.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteWorkflow(com.google.cloud.workflows.v1beta.DeleteWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkflowMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workflow.
     * Running this method has no impact on already running executions of the
     * workflow. A new revision of the workflow may be created as a result of a
     * successful update operation. In that case, such revision will be used
     * in new workflow executions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateWorkflow(com.google.cloud.workflows.v1beta.UpdateWorkflowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkflowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_WORKFLOWS = 0;
  private static final int METHODID_GET_WORKFLOW = 1;
  private static final int METHODID_CREATE_WORKFLOW = 2;
  private static final int METHODID_DELETE_WORKFLOW = 3;
  private static final int METHODID_UPDATE_WORKFLOW = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkflowsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkflowsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_WORKFLOWS:
          serviceImpl.listWorkflows(
              (com.google.cloud.workflows.v1beta.ListWorkflowsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.ListWorkflowsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_WORKFLOW:
          serviceImpl.getWorkflow(
              (com.google.cloud.workflows.v1beta.GetWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.workflows.v1beta.Workflow>)
                  responseObserver);
          break;
        case METHODID_CREATE_WORKFLOW:
          serviceImpl.createWorkflow(
              (com.google.cloud.workflows.v1beta.CreateWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKFLOW:
          serviceImpl.deleteWorkflow(
              (com.google.cloud.workflows.v1beta.DeleteWorkflowRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKFLOW:
          serviceImpl.updateWorkflow(
              (com.google.cloud.workflows.v1beta.UpdateWorkflowRequest) request,
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

  private abstract static class WorkflowsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkflowsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.workflows.v1beta.WorkflowsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Workflows");
    }
  }

  private static final class WorkflowsFileDescriptorSupplier
      extends WorkflowsBaseDescriptorSupplier {
    WorkflowsFileDescriptorSupplier() {}
  }

  private static final class WorkflowsMethodDescriptorSupplier
      extends WorkflowsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkflowsMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkflowsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkflowsFileDescriptorSupplier())
                      .addMethod(getListWorkflowsMethod())
                      .addMethod(getGetWorkflowMethod())
                      .addMethod(getCreateWorkflowMethod())
                      .addMethod(getDeleteWorkflowMethod())
                      .addMethod(getUpdateWorkflowMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
