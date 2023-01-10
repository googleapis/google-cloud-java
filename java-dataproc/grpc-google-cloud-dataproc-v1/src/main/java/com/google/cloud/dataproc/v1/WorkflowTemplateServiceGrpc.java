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
package com.google.cloud.dataproc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The API interface for managing Workflow Templates in the
 * Dataproc API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataproc/v1/workflow_templates.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkflowTemplateServiceGrpc {

  private WorkflowTemplateServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1.WorkflowTemplateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getCreateWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.WorkflowTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getCreateWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        getCreateWorkflowTemplateMethod;
    if ((getCreateWorkflowTemplateMethod =
            WorkflowTemplateServiceGrpc.getCreateWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getCreateWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getCreateWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getCreateWorkflowTemplateMethod =
              getCreateWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.WorkflowTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "CreateWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getCreateWorkflowTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getGetWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.WorkflowTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getGetWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        getGetWorkflowTemplateMethod;
    if ((getGetWorkflowTemplateMethod = WorkflowTemplateServiceGrpc.getGetWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getGetWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getGetWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getGetWorkflowTemplateMethod =
              getGetWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.WorkflowTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "GetWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getGetWorkflowTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InstantiateWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest,
            com.google.longrunning.Operation>
        getInstantiateWorkflowTemplateMethod;
    if ((getInstantiateWorkflowTemplateMethod =
            WorkflowTemplateServiceGrpc.getInstantiateWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getInstantiateWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getInstantiateWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getInstantiateWorkflowTemplateMethod =
              getInstantiateWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InstantiateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "InstantiateWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getInstantiateWorkflowTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateInlineWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InstantiateInlineWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateInlineWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest,
            com.google.longrunning.Operation>
        getInstantiateInlineWorkflowTemplateMethod;
    if ((getInstantiateInlineWorkflowTemplateMethod =
            WorkflowTemplateServiceGrpc.getInstantiateInlineWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getInstantiateInlineWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getInstantiateInlineWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getInstantiateInlineWorkflowTemplateMethod =
              getInstantiateInlineWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InstantiateInlineWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "InstantiateInlineWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getInstantiateInlineWorkflowTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getUpdateWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest.class,
      responseType = com.google.cloud.dataproc.v1.WorkflowTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1.WorkflowTemplate>
      getUpdateWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        getUpdateWorkflowTemplateMethod;
    if ((getUpdateWorkflowTemplateMethod =
            WorkflowTemplateServiceGrpc.getUpdateWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getUpdateWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getUpdateWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getUpdateWorkflowTemplateMethod =
              getUpdateWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.WorkflowTemplate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "UpdateWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getUpdateWorkflowTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
      getListWorkflowTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkflowTemplates",
      requestType = com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest.class,
      responseType = com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
      getListWorkflowTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest,
            com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
        getListWorkflowTemplatesMethod;
    if ((getListWorkflowTemplatesMethod =
            WorkflowTemplateServiceGrpc.getListWorkflowTemplatesMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getListWorkflowTemplatesMethod =
                WorkflowTemplateServiceGrpc.getListWorkflowTemplatesMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getListWorkflowTemplatesMethod =
              getListWorkflowTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest,
                          com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListWorkflowTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "ListWorkflowTemplates"))
                      .build();
        }
      }
    }
    return getListWorkflowTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest, com.google.protobuf.Empty>
      getDeleteWorkflowTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkflowTemplate",
      requestType = com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest, com.google.protobuf.Empty>
      getDeleteWorkflowTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest, com.google.protobuf.Empty>
        getDeleteWorkflowTemplateMethod;
    if ((getDeleteWorkflowTemplateMethod =
            WorkflowTemplateServiceGrpc.getDeleteWorkflowTemplateMethod)
        == null) {
      synchronized (WorkflowTemplateServiceGrpc.class) {
        if ((getDeleteWorkflowTemplateMethod =
                WorkflowTemplateServiceGrpc.getDeleteWorkflowTemplateMethod)
            == null) {
          WorkflowTemplateServiceGrpc.getDeleteWorkflowTemplateMethod =
              getDeleteWorkflowTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "DeleteWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getDeleteWorkflowTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WorkflowTemplateServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceStub>() {
          @java.lang.Override
          public WorkflowTemplateServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowTemplateServiceStub(channel, callOptions);
          }
        };
    return WorkflowTemplateServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkflowTemplateServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceBlockingStub>() {
          @java.lang.Override
          public WorkflowTemplateServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowTemplateServiceBlockingStub(channel, callOptions);
          }
        };
    return WorkflowTemplateServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkflowTemplateServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WorkflowTemplateServiceFutureStub>() {
          @java.lang.Override
          public WorkflowTemplateServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WorkflowTemplateServiceFutureStub(channel, callOptions);
          }
        };
    return WorkflowTemplateServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Dataproc API.
   * </pre>
   */
  public abstract static class WorkflowTemplateServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates new workflow template.
     * </pre>
     */
    public void createWorkflowTemplate(
        com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkflowTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest workflow template.
     * Can retrieve previously instantiated template by specifying optional
     * version parameter.
     * </pre>
     */
    public void getWorkflowTemplate(
        com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkflowTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInstantiateWorkflowTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.CreateWorkflowTemplate], [InstantiateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInstantiateInlineWorkflowTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) workflow template. The updated template
     * must contain version that matches the current server version.
     * </pre>
     */
    public void updateWorkflowTemplate(
        com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkflowTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public void listWorkflowTemplates(
        com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkflowTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public void deleteWorkflowTemplate(
        com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkflowTemplateMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1.WorkflowTemplate>(
                      this, METHODID_CREATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getGetWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1.WorkflowTemplate>(
                      this, METHODID_GET_WORKFLOW_TEMPLATE)))
          .addMethod(
              getInstantiateWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_INSTANTIATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getInstantiateInlineWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getUpdateWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1.WorkflowTemplate>(
                      this, METHODID_UPDATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getListWorkflowTemplatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest,
                      com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>(
                      this, METHODID_LIST_WORKFLOW_TEMPLATES)))
          .addMethod(
              getDeleteWorkflowTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_WORKFLOW_TEMPLATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WorkflowTemplateServiceStub> {
    private WorkflowTemplateServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowTemplateServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowTemplateServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new workflow template.
     * </pre>
     */
    public void createWorkflowTemplate(
        com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest workflow template.
     * Can retrieve previously instantiated template by specifying optional
     * version parameter.
     * </pre>
     */
    public void getWorkflowTemplate(
        com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInstantiateWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.CreateWorkflowTemplate], [InstantiateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInstantiateInlineWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) workflow template. The updated template
     * must contain version that matches the current server version.
     * </pre>
     */
    public void updateWorkflowTemplate(
        com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public void listWorkflowTemplates(
        com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkflowTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public void deleteWorkflowTemplate(
        com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkflowTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkflowTemplateServiceBlockingStub> {
    private WorkflowTemplateServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowTemplateServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowTemplateServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new workflow template.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.WorkflowTemplate createWorkflowTemplate(
        com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkflowTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest workflow template.
     * Can retrieve previously instantiated template by specifying optional
     * version parameter.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.WorkflowTemplate getWorkflowTemplate(
        com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkflowTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.longrunning.Operation instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInstantiateWorkflowTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.CreateWorkflowTemplate], [InstantiateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.longrunning.Operation instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInstantiateInlineWorkflowTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) workflow template. The updated template
     * must contain version that matches the current server version.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.WorkflowTemplate updateWorkflowTemplate(
        com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkflowTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse listWorkflowTemplates(
        com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkflowTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWorkflowTemplate(
        com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkflowTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkflowTemplateServiceFutureStub> {
    private WorkflowTemplateServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkflowTemplateServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkflowTemplateServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates new workflow template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        createWorkflowTemplate(com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkflowTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the latest workflow template.
     * Can retrieve previously instantiated template by specifying optional
     * version parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        getWorkflowTemplate(com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkflowTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        instantiateWorkflowTemplate(
            com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInstantiateWorkflowTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.CreateWorkflowTemplate], [InstantiateWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata](https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata).
     * Also see [Using
     * WorkflowMetadata](https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        instantiateInlineWorkflowTemplate(
            com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInstantiateInlineWorkflowTemplateMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates (replaces) workflow template. The updated template
     * must contain version that matches the current server version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.WorkflowTemplate>
        updateWorkflowTemplate(com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkflowTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>
        listWorkflowTemplates(com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkflowTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWorkflowTemplate(com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkflowTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKFLOW_TEMPLATE = 0;
  private static final int METHODID_GET_WORKFLOW_TEMPLATE = 1;
  private static final int METHODID_INSTANTIATE_WORKFLOW_TEMPLATE = 2;
  private static final int METHODID_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE = 3;
  private static final int METHODID_UPDATE_WORKFLOW_TEMPLATE = 4;
  private static final int METHODID_LIST_WORKFLOW_TEMPLATES = 5;
  private static final int METHODID_DELETE_WORKFLOW_TEMPLATE = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WorkflowTemplateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WorkflowTemplateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WORKFLOW_TEMPLATE:
          serviceImpl.createWorkflowTemplate(
              (com.google.cloud.dataproc.v1.CreateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_WORKFLOW_TEMPLATE:
          serviceImpl.getWorkflowTemplate(
              (com.google.cloud.dataproc.v1.GetWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_INSTANTIATE_WORKFLOW_TEMPLATE:
          serviceImpl.instantiateWorkflowTemplate(
              (com.google.cloud.dataproc.v1.InstantiateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE:
          serviceImpl.instantiateInlineWorkflowTemplate(
              (com.google.cloud.dataproc.v1.InstantiateInlineWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKFLOW_TEMPLATE:
          serviceImpl.updateWorkflowTemplate(
              (com.google.cloud.dataproc.v1.UpdateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKFLOW_TEMPLATES:
          serviceImpl.listWorkflowTemplates(
              (com.google.cloud.dataproc.v1.ListWorkflowTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataproc.v1.ListWorkflowTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_WORKFLOW_TEMPLATE:
          serviceImpl.deleteWorkflowTemplate(
              (com.google.cloud.dataproc.v1.DeleteWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class WorkflowTemplateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkflowTemplateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataproc.v1.WorkflowTemplatesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkflowTemplateService");
    }
  }

  private static final class WorkflowTemplateServiceFileDescriptorSupplier
      extends WorkflowTemplateServiceBaseDescriptorSupplier {
    WorkflowTemplateServiceFileDescriptorSupplier() {}
  }

  private static final class WorkflowTemplateServiceMethodDescriptorSupplier
      extends WorkflowTemplateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WorkflowTemplateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WorkflowTemplateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WorkflowTemplateServiceFileDescriptorSupplier())
                      .addMethod(getCreateWorkflowTemplateMethod())
                      .addMethod(getGetWorkflowTemplateMethod())
                      .addMethod(getInstantiateWorkflowTemplateMethod())
                      .addMethod(getInstantiateInlineWorkflowTemplateMethod())
                      .addMethod(getUpdateWorkflowTemplateMethod())
                      .addMethod(getListWorkflowTemplatesMethod())
                      .addMethod(getDeleteWorkflowTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
