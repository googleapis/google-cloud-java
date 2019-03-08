package com.google.cloud.dataproc.v1beta2;

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
 * The API interface for managing Workflow Templates in the
 * Cloud Dataproc API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/dataproc/v1beta2/workflow_templates.proto")
public final class WorkflowTemplateServiceGrpc {

  private WorkflowTemplateServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataproc.v1beta2.WorkflowTemplateService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      METHOD_CREATE_WORKFLOW_TEMPLATE = getCreateWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getCreateWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getCreateWorkflowTemplateMethod() {
    return getCreateWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getCreateWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
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
                      .<com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "CreateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.WorkflowTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "CreateWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getCreateWorkflowTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      METHOD_GET_WORKFLOW_TEMPLATE = getGetWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getGetWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getGetWorkflowTemplateMethod() {
    return getGetWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getGetWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
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
                      .<com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "GetWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.WorkflowTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "GetWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getGetWorkflowTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInstantiateWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      METHOD_INSTANTIATE_WORKFLOW_TEMPLATE = getInstantiateWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateWorkflowTemplateMethod() {
    return getInstantiateWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
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
                      .<com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "InstantiateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getInstantiateInlineWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      METHOD_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE =
          getInstantiateInlineWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateInlineWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateInlineWorkflowTemplateMethod() {
    return getInstantiateInlineWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
          com.google.longrunning.Operation>
      getInstantiateInlineWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
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
                      .<com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "InstantiateInlineWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2
                                  .InstantiateInlineWorkflowTemplateRequest.getDefaultInstance()))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      METHOD_UPDATE_WORKFLOW_TEMPLATE = getUpdateWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getUpdateWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getUpdateWorkflowTemplateMethod() {
    return getUpdateWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
      getUpdateWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
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
                      .<com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
                          com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "UpdateWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.WorkflowTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WorkflowTemplateServiceMethodDescriptorSupplier(
                              "UpdateWorkflowTemplate"))
                      .build();
        }
      }
    }
    return getUpdateWorkflowTemplateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListWorkflowTemplatesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
      METHOD_LIST_WORKFLOW_TEMPLATES = getListWorkflowTemplatesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
      getListWorkflowTemplatesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
      getListWorkflowTemplatesMethod() {
    return getListWorkflowTemplatesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
      getListWorkflowTemplatesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
            com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
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
                      .<com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
                          com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "ListWorkflowTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteWorkflowTemplateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
          com.google.protobuf.Empty>
      METHOD_DELETE_WORKFLOW_TEMPLATE = getDeleteWorkflowTemplateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteWorkflowTemplateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteWorkflowTemplateMethod() {
    return getDeleteWorkflowTemplateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
          com.google.protobuf.Empty>
      getDeleteWorkflowTemplateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
            com.google.protobuf.Empty>
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
                      .<com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.dataproc.v1beta2.WorkflowTemplateService",
                              "DeleteWorkflowTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest
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
    return new WorkflowTemplateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkflowTemplateServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new WorkflowTemplateServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WorkflowTemplateServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new WorkflowTemplateServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Cloud Dataproc API.
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
        com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateWorkflowTemplateMethodHelper(), responseObserver);
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
        com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetWorkflowTemplateMethodHelper(), responseObserver);
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
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getInstantiateWorkflowTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.CreateWorkflowTemplate],
     * [InstantiateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(
          getInstantiateInlineWorkflowTemplateMethodHelper(), responseObserver);
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
        com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateWorkflowTemplateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public void listWorkflowTemplates(
        com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListWorkflowTemplatesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public void deleteWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteWorkflowTemplateMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1beta2.WorkflowTemplate>(
                      this, METHODID_CREATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getGetWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1beta2.WorkflowTemplate>(
                      this, METHODID_GET_WORKFLOW_TEMPLATE)))
          .addMethod(
              getInstantiateWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_INSTANTIATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getInstantiateInlineWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getUpdateWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest,
                      com.google.cloud.dataproc.v1beta2.WorkflowTemplate>(
                      this, METHODID_UPDATE_WORKFLOW_TEMPLATE)))
          .addMethod(
              getListWorkflowTemplatesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest,
                      com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>(
                      this, METHODID_LIST_WORKFLOW_TEMPLATES)))
          .addMethod(
              getDeleteWorkflowTemplateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_WORKFLOW_TEMPLATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Cloud Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceStub
      extends io.grpc.stub.AbstractStub<WorkflowTemplateServiceStub> {
    private WorkflowTemplateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

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
        com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateWorkflowTemplateMethodHelper(), getCallOptions()),
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
        com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWorkflowTemplateMethodHelper(), getCallOptions()),
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
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInstantiateWorkflowTemplateMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.CreateWorkflowTemplate],
     * [InstantiateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public void instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel()
              .newCall(getInstantiateInlineWorkflowTemplateMethodHelper(), getCallOptions()),
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
        com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateWorkflowTemplateMethodHelper(), getCallOptions()),
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
        com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListWorkflowTemplatesMethodHelper(), getCallOptions()),
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
        com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteWorkflowTemplateMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Cloud Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceBlockingStub
      extends io.grpc.stub.AbstractStub<WorkflowTemplateServiceBlockingStub> {
    private WorkflowTemplateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
    public com.google.cloud.dataproc.v1beta2.WorkflowTemplate createWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateWorkflowTemplateMethodHelper(), getCallOptions(), request);
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
    public com.google.cloud.dataproc.v1beta2.WorkflowTemplate getWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWorkflowTemplateMethodHelper(), getCallOptions(), request);
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
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.longrunning.Operation instantiateWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getInstantiateWorkflowTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.CreateWorkflowTemplate],
     * [InstantiateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.longrunning.Operation instantiateInlineWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(),
          getInstantiateInlineWorkflowTemplateMethodHelper(),
          getCallOptions(),
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
    public com.google.cloud.dataproc.v1beta2.WorkflowTemplate updateWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateWorkflowTemplateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse listWorkflowTemplates(
        com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListWorkflowTemplatesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWorkflowTemplate(
        com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteWorkflowTemplateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The API interface for managing Workflow Templates in the
   * Cloud Dataproc API.
   * </pre>
   */
  public static final class WorkflowTemplateServiceFutureStub
      extends io.grpc.stub.AbstractStub<WorkflowTemplateServiceFutureStub> {
    private WorkflowTemplateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
        createWorkflowTemplate(
            com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateWorkflowTemplateMethodHelper(), getCallOptions()), request);
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
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
        getWorkflowTemplate(com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWorkflowTemplateMethodHelper(), getCallOptions()), request);
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
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        instantiateWorkflowTemplate(
            com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getInstantiateWorkflowTemplateMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Instantiates a template and begins execution.
     * This method is equivalent to executing the sequence
     * [CreateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.CreateWorkflowTemplate],
     * [InstantiateWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.InstantiateWorkflowTemplate],
     * [DeleteWorkflowTemplate][google.cloud.dataproc.v1beta2.WorkflowTemplateService.DeleteWorkflowTemplate].
     * The returned Operation can be used to track execution of
     * workflow by polling
     * [operations.get][google.longrunning.Operations.GetOperation].
     * The Operation will complete when entire workflow is finished.
     * The running workflow can be aborted via
     * [operations.cancel][google.longrunning.Operations.CancelOperation].
     * This will cause any inflight jobs to be cancelled and workflow-owned
     * clusters to be deleted.
     * The [Operation.metadata][google.longrunning.Operation.metadata] will be
     * [WorkflowMetadata][google.cloud.dataproc.v1beta2.WorkflowMetadata].
     * On successful completion,
     * [Operation.response][google.longrunning.Operation.response] will be
     * [Empty][google.protobuf.Empty].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        instantiateInlineWorkflowTemplate(
            com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel()
              .newCall(getInstantiateInlineWorkflowTemplateMethodHelper(), getCallOptions()),
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
            com.google.cloud.dataproc.v1beta2.WorkflowTemplate>
        updateWorkflowTemplate(
            com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateWorkflowTemplateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists workflows that match the specified filter in the request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>
        listWorkflowTemplates(
            com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListWorkflowTemplatesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a workflow template. It does not cancel in-progress workflows.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWorkflowTemplate(
            com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteWorkflowTemplateMethodHelper(), getCallOptions()), request);
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
              (com.google.cloud.dataproc.v1beta2.CreateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_GET_WORKFLOW_TEMPLATE:
          serviceImpl.getWorkflowTemplate(
              (com.google.cloud.dataproc.v1beta2.GetWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_INSTANTIATE_WORKFLOW_TEMPLATE:
          serviceImpl.instantiateWorkflowTemplate(
              (com.google.cloud.dataproc.v1beta2.InstantiateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INSTANTIATE_INLINE_WORKFLOW_TEMPLATE:
          serviceImpl.instantiateInlineWorkflowTemplate(
              (com.google.cloud.dataproc.v1beta2.InstantiateInlineWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKFLOW_TEMPLATE:
          serviceImpl.updateWorkflowTemplate(
              (com.google.cloud.dataproc.v1beta2.UpdateWorkflowTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataproc.v1beta2.WorkflowTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKFLOW_TEMPLATES:
          serviceImpl.listWorkflowTemplates(
              (com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataproc.v1beta2.ListWorkflowTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_WORKFLOW_TEMPLATE:
          serviceImpl.deleteWorkflowTemplate(
              (com.google.cloud.dataproc.v1beta2.DeleteWorkflowTemplateRequest) request,
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
      return com.google.cloud.dataproc.v1beta2.WorkflowTemplatesProto.getDescriptor();
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
                      .addMethod(getCreateWorkflowTemplateMethodHelper())
                      .addMethod(getGetWorkflowTemplateMethodHelper())
                      .addMethod(getInstantiateWorkflowTemplateMethodHelper())
                      .addMethod(getInstantiateInlineWorkflowTemplateMethodHelper())
                      .addMethod(getUpdateWorkflowTemplateMethodHelper())
                      .addMethod(getListWorkflowTemplatesMethodHelper())
                      .addMethod(getDeleteWorkflowTemplateMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
