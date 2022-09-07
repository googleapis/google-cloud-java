package com.google.cloudbuild.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Creates and manages builds on Google Cloud Platform.
 * The main concept used by this API is a `Build`, which describes the location
 * of the source to build, how to build the source, and where to store the
 * built artifacts, if any.
 * A user can list previously-requested builds or get builds by their ID to
 * determine the status of the build.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/cloudbuild/v1/cloudbuild.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudBuildGrpc {

  private CloudBuildGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudbuild.v1.CloudBuild";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildRequest,
      com.google.longrunning.Operation> getCreateBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBuild",
      requestType = com.google.cloudbuild.v1.CreateBuildRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildRequest,
      com.google.longrunning.Operation> getCreateBuildMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation> getCreateBuildMethod;
    if ((getCreateBuildMethod = CloudBuildGrpc.getCreateBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateBuildMethod = CloudBuildGrpc.getCreateBuildMethod) == null) {
          CloudBuildGrpc.getCreateBuildMethod = getCreateBuildMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBuild"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.CreateBuildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CreateBuild"))
              .build();
        }
      }
    }
    return getCreateBuildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildRequest,
      com.google.cloudbuild.v1.Build> getGetBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBuild",
      requestType = com.google.cloudbuild.v1.GetBuildRequest.class,
      responseType = com.google.cloudbuild.v1.Build.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildRequest,
      com.google.cloudbuild.v1.Build> getGetBuildMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build> getGetBuildMethod;
    if ((getGetBuildMethod = CloudBuildGrpc.getGetBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetBuildMethod = CloudBuildGrpc.getGetBuildMethod) == null) {
          CloudBuildGrpc.getGetBuildMethod = getGetBuildMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBuild"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.GetBuildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.Build.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("GetBuild"))
              .build();
        }
      }
    }
    return getGetBuildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildsRequest,
      com.google.cloudbuild.v1.ListBuildsResponse> getListBuildsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBuilds",
      requestType = com.google.cloudbuild.v1.ListBuildsRequest.class,
      responseType = com.google.cloudbuild.v1.ListBuildsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildsRequest,
      com.google.cloudbuild.v1.ListBuildsResponse> getListBuildsMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse> getListBuildsMethod;
    if ((getListBuildsMethod = CloudBuildGrpc.getListBuildsMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListBuildsMethod = CloudBuildGrpc.getListBuildsMethod) == null) {
          CloudBuildGrpc.getListBuildsMethod = getListBuildsMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBuilds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListBuildsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListBuildsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ListBuilds"))
              .build();
        }
      }
    }
    return getListBuildsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CancelBuildRequest,
      com.google.cloudbuild.v1.Build> getCancelBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelBuild",
      requestType = com.google.cloudbuild.v1.CancelBuildRequest.class,
      responseType = com.google.cloudbuild.v1.Build.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CancelBuildRequest,
      com.google.cloudbuild.v1.Build> getCancelBuildMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build> getCancelBuildMethod;
    if ((getCancelBuildMethod = CloudBuildGrpc.getCancelBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCancelBuildMethod = CloudBuildGrpc.getCancelBuildMethod) == null) {
          CloudBuildGrpc.getCancelBuildMethod = getCancelBuildMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelBuild"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.CancelBuildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.Build.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CancelBuild"))
              .build();
        }
      }
    }
    return getCancelBuildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RetryBuildRequest,
      com.google.longrunning.Operation> getRetryBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RetryBuild",
      requestType = com.google.cloudbuild.v1.RetryBuildRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RetryBuildRequest,
      com.google.longrunning.Operation> getRetryBuildMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation> getRetryBuildMethod;
    if ((getRetryBuildMethod = CloudBuildGrpc.getRetryBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getRetryBuildMethod = CloudBuildGrpc.getRetryBuildMethod) == null) {
          CloudBuildGrpc.getRetryBuildMethod = getRetryBuildMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RetryBuild"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.RetryBuildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("RetryBuild"))
              .build();
        }
      }
    }
    return getRetryBuildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ApproveBuildRequest,
      com.google.longrunning.Operation> getApproveBuildMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApproveBuild",
      requestType = com.google.cloudbuild.v1.ApproveBuildRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ApproveBuildRequest,
      com.google.longrunning.Operation> getApproveBuildMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ApproveBuildRequest, com.google.longrunning.Operation> getApproveBuildMethod;
    if ((getApproveBuildMethod = CloudBuildGrpc.getApproveBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getApproveBuildMethod = CloudBuildGrpc.getApproveBuildMethod) == null) {
          CloudBuildGrpc.getApproveBuildMethod = getApproveBuildMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.ApproveBuildRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApproveBuild"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ApproveBuildRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ApproveBuild"))
              .build();
        }
      }
    }
    return getApproveBuildMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getCreateBuildTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBuildTrigger",
      requestType = com.google.cloudbuild.v1.CreateBuildTriggerRequest.class,
      responseType = com.google.cloudbuild.v1.BuildTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getCreateBuildTriggerMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger> getCreateBuildTriggerMethod;
    if ((getCreateBuildTriggerMethod = CloudBuildGrpc.getCreateBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateBuildTriggerMethod = CloudBuildGrpc.getCreateBuildTriggerMethod) == null) {
          CloudBuildGrpc.getCreateBuildTriggerMethod = getCreateBuildTriggerMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBuildTrigger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.CreateBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CreateBuildTrigger"))
              .build();
        }
      }
    }
    return getCreateBuildTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getGetBuildTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBuildTrigger",
      requestType = com.google.cloudbuild.v1.GetBuildTriggerRequest.class,
      responseType = com.google.cloudbuild.v1.BuildTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getGetBuildTriggerMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger> getGetBuildTriggerMethod;
    if ((getGetBuildTriggerMethod = CloudBuildGrpc.getGetBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetBuildTriggerMethod = CloudBuildGrpc.getGetBuildTriggerMethod) == null) {
          CloudBuildGrpc.getGetBuildTriggerMethod = getGetBuildTriggerMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBuildTrigger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.GetBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("GetBuildTrigger"))
              .build();
        }
      }
    }
    return getGetBuildTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildTriggersRequest,
      com.google.cloudbuild.v1.ListBuildTriggersResponse> getListBuildTriggersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBuildTriggers",
      requestType = com.google.cloudbuild.v1.ListBuildTriggersRequest.class,
      responseType = com.google.cloudbuild.v1.ListBuildTriggersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildTriggersRequest,
      com.google.cloudbuild.v1.ListBuildTriggersResponse> getListBuildTriggersMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListBuildTriggersRequest, com.google.cloudbuild.v1.ListBuildTriggersResponse> getListBuildTriggersMethod;
    if ((getListBuildTriggersMethod = CloudBuildGrpc.getListBuildTriggersMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListBuildTriggersMethod = CloudBuildGrpc.getListBuildTriggersMethod) == null) {
          CloudBuildGrpc.getListBuildTriggersMethod = getListBuildTriggersMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.ListBuildTriggersRequest, com.google.cloudbuild.v1.ListBuildTriggersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBuildTriggers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListBuildTriggersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListBuildTriggersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ListBuildTriggers"))
              .build();
        }
      }
    }
    return getListBuildTriggersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteBuildTriggerRequest,
      com.google.protobuf.Empty> getDeleteBuildTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBuildTrigger",
      requestType = com.google.cloudbuild.v1.DeleteBuildTriggerRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteBuildTriggerRequest,
      com.google.protobuf.Empty> getDeleteBuildTriggerMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty> getDeleteBuildTriggerMethod;
    if ((getDeleteBuildTriggerMethod = CloudBuildGrpc.getDeleteBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getDeleteBuildTriggerMethod = CloudBuildGrpc.getDeleteBuildTriggerMethod) == null) {
          CloudBuildGrpc.getDeleteBuildTriggerMethod = getDeleteBuildTriggerMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBuildTrigger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.DeleteBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("DeleteBuildTrigger"))
              .build();
        }
      }
    }
    return getDeleteBuildTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getUpdateBuildTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBuildTrigger",
      requestType = com.google.cloudbuild.v1.UpdateBuildTriggerRequest.class,
      responseType = com.google.cloudbuild.v1.BuildTrigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
      com.google.cloudbuild.v1.BuildTrigger> getUpdateBuildTriggerMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger> getUpdateBuildTriggerMethod;
    if ((getUpdateBuildTriggerMethod = CloudBuildGrpc.getUpdateBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getUpdateBuildTriggerMethod = CloudBuildGrpc.getUpdateBuildTriggerMethod) == null) {
          CloudBuildGrpc.getUpdateBuildTriggerMethod = getUpdateBuildTriggerMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBuildTrigger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.UpdateBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("UpdateBuildTrigger"))
              .build();
        }
      }
    }
    return getUpdateBuildTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RunBuildTriggerRequest,
      com.google.longrunning.Operation> getRunBuildTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunBuildTrigger",
      requestType = com.google.cloudbuild.v1.RunBuildTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RunBuildTriggerRequest,
      com.google.longrunning.Operation> getRunBuildTriggerMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation> getRunBuildTriggerMethod;
    if ((getRunBuildTriggerMethod = CloudBuildGrpc.getRunBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getRunBuildTriggerMethod = CloudBuildGrpc.getRunBuildTriggerMethod) == null) {
          CloudBuildGrpc.getRunBuildTriggerMethod = getRunBuildTriggerMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunBuildTrigger"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.RunBuildTriggerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("RunBuildTrigger"))
              .build();
        }
      }
    }
    return getRunBuildTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest,
      com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> getReceiveTriggerWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveTriggerWebhook",
      requestType = com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest.class,
      responseType = com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest,
      com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> getReceiveTriggerWebhookMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest, com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> getReceiveTriggerWebhookMethod;
    if ((getReceiveTriggerWebhookMethod = CloudBuildGrpc.getReceiveTriggerWebhookMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getReceiveTriggerWebhookMethod = CloudBuildGrpc.getReceiveTriggerWebhookMethod) == null) {
          CloudBuildGrpc.getReceiveTriggerWebhookMethod = getReceiveTriggerWebhookMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest, com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveTriggerWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ReceiveTriggerWebhook"))
              .build();
        }
      }
    }
    return getReceiveTriggerWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateWorkerPoolRequest,
      com.google.longrunning.Operation> getCreateWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkerPool",
      requestType = com.google.cloudbuild.v1.CreateWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateWorkerPoolRequest,
      com.google.longrunning.Operation> getCreateWorkerPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.longrunning.Operation> getCreateWorkerPoolMethod;
    if ((getCreateWorkerPoolMethod = CloudBuildGrpc.getCreateWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateWorkerPoolMethod = CloudBuildGrpc.getCreateWorkerPoolMethod) == null) {
          CloudBuildGrpc.getCreateWorkerPoolMethod = getCreateWorkerPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkerPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.CreateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CreateWorkerPool"))
              .build();
        }
      }
    }
    return getCreateWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetWorkerPoolRequest,
      com.google.cloudbuild.v1.WorkerPool> getGetWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkerPool",
      requestType = com.google.cloudbuild.v1.GetWorkerPoolRequest.class,
      responseType = com.google.cloudbuild.v1.WorkerPool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetWorkerPoolRequest,
      com.google.cloudbuild.v1.WorkerPool> getGetWorkerPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool> getGetWorkerPoolMethod;
    if ((getGetWorkerPoolMethod = CloudBuildGrpc.getGetWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetWorkerPoolMethod = CloudBuildGrpc.getGetWorkerPoolMethod) == null) {
          CloudBuildGrpc.getGetWorkerPoolMethod = getGetWorkerPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkerPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.GetWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.WorkerPool.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("GetWorkerPool"))
              .build();
        }
      }
    }
    return getGetWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteWorkerPoolRequest,
      com.google.longrunning.Operation> getDeleteWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkerPool",
      requestType = com.google.cloudbuild.v1.DeleteWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteWorkerPoolRequest,
      com.google.longrunning.Operation> getDeleteWorkerPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.longrunning.Operation> getDeleteWorkerPoolMethod;
    if ((getDeleteWorkerPoolMethod = CloudBuildGrpc.getDeleteWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getDeleteWorkerPoolMethod = CloudBuildGrpc.getDeleteWorkerPoolMethod) == null) {
          CloudBuildGrpc.getDeleteWorkerPoolMethod = getDeleteWorkerPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkerPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.DeleteWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("DeleteWorkerPool"))
              .build();
        }
      }
    }
    return getDeleteWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateWorkerPoolRequest,
      com.google.longrunning.Operation> getUpdateWorkerPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkerPool",
      requestType = com.google.cloudbuild.v1.UpdateWorkerPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateWorkerPoolRequest,
      com.google.longrunning.Operation> getUpdateWorkerPoolMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.longrunning.Operation> getUpdateWorkerPoolMethod;
    if ((getUpdateWorkerPoolMethod = CloudBuildGrpc.getUpdateWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getUpdateWorkerPoolMethod = CloudBuildGrpc.getUpdateWorkerPoolMethod) == null) {
          CloudBuildGrpc.getUpdateWorkerPoolMethod = getUpdateWorkerPoolMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkerPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.UpdateWorkerPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("UpdateWorkerPool"))
              .build();
        }
      }
    }
    return getUpdateWorkerPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListWorkerPoolsRequest,
      com.google.cloudbuild.v1.ListWorkerPoolsResponse> getListWorkerPoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkerPools",
      requestType = com.google.cloudbuild.v1.ListWorkerPoolsRequest.class,
      responseType = com.google.cloudbuild.v1.ListWorkerPoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListWorkerPoolsRequest,
      com.google.cloudbuild.v1.ListWorkerPoolsResponse> getListWorkerPoolsMethod() {
    io.grpc.MethodDescriptor<com.google.cloudbuild.v1.ListWorkerPoolsRequest, com.google.cloudbuild.v1.ListWorkerPoolsResponse> getListWorkerPoolsMethod;
    if ((getListWorkerPoolsMethod = CloudBuildGrpc.getListWorkerPoolsMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListWorkerPoolsMethod = CloudBuildGrpc.getListWorkerPoolsMethod) == null) {
          CloudBuildGrpc.getListWorkerPoolsMethod = getListWorkerPoolsMethod =
              io.grpc.MethodDescriptor.<com.google.cloudbuild.v1.ListWorkerPoolsRequest, com.google.cloudbuild.v1.ListWorkerPoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkerPools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListWorkerPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloudbuild.v1.ListWorkerPoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ListWorkerPools"))
              .build();
        }
      }
    }
    return getListWorkerPoolsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudBuildStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudBuildStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudBuildStub>() {
        @java.lang.Override
        public CloudBuildStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudBuildStub(channel, callOptions);
        }
      };
    return CloudBuildStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudBuildBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudBuildBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudBuildBlockingStub>() {
        @java.lang.Override
        public CloudBuildBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudBuildBlockingStub(channel, callOptions);
        }
      };
    return CloudBuildBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudBuildFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudBuildFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudBuildFutureStub>() {
        @java.lang.Override
        public CloudBuildFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudBuildFutureStub(channel, callOptions);
        }
      };
    return CloudBuildFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static abstract class CloudBuildImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public void createBuild(com.google.cloudbuild.v1.CreateBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBuildMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public void getBuild(com.google.cloudbuild.v1.GetBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBuildMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public void listBuilds(com.google.cloudbuild.v1.ListBuildsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBuildsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public void cancelBuild(com.google.cloudbuild.v1.CancelBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelBuildMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public void retryBuild(com.google.cloudbuild.v1.RetryBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRetryBuildMethod(), responseObserver);
    }

    /**
     * <pre>
     * Approves or rejects a pending build.
     * If approved, the returned LRO will be analogous to the LRO returned from
     * a CreateBuild call.
     * If rejected, the returned LRO will be immediately done.
     * </pre>
     */
    public void approveBuild(com.google.cloudbuild.v1.ApproveBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApproveBuildMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void createBuildTrigger(com.google.cloudbuild.v1.CreateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBuildTriggerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void getBuildTrigger(com.google.cloudbuild.v1.GetBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBuildTriggerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public void listBuildTriggers(com.google.cloudbuild.v1.ListBuildTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBuildTriggersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void deleteBuildTrigger(com.google.cloudbuild.v1.DeleteBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBuildTriggerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void updateBuildTrigger(com.google.cloudbuild.v1.UpdateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateBuildTriggerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public void runBuildTrigger(com.google.cloudbuild.v1.RunBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunBuildTriggerMethod(), responseObserver);
    }

    /**
     * <pre>
     * ReceiveTriggerWebhook [Experimental] is called when the API receives a
     * webhook request targeted at a specific trigger.
     * </pre>
     */
    public void receiveTriggerWebhook(com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveTriggerWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a `WorkerPool`.
     * </pre>
     */
    public void createWorkerPool(com.google.cloudbuild.v1.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkerPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns details of a `WorkerPool`.
     * </pre>
     */
    public void getWorkerPool(com.google.cloudbuild.v1.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkerPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a `WorkerPool`.
     * </pre>
     */
    public void deleteWorkerPool(com.google.cloudbuild.v1.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWorkerPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a `WorkerPool`.
     * </pre>
     */
    public void updateWorkerPool(com.google.cloudbuild.v1.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWorkerPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists `WorkerPool`s.
     * </pre>
     */
    public void listWorkerPools(com.google.cloudbuild.v1.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkerPoolsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.CreateBuildRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_BUILD)))
          .addMethod(
            getGetBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.GetBuildRequest,
                com.google.cloudbuild.v1.Build>(
                  this, METHODID_GET_BUILD)))
          .addMethod(
            getListBuildsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.ListBuildsRequest,
                com.google.cloudbuild.v1.ListBuildsResponse>(
                  this, METHODID_LIST_BUILDS)))
          .addMethod(
            getCancelBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.CancelBuildRequest,
                com.google.cloudbuild.v1.Build>(
                  this, METHODID_CANCEL_BUILD)))
          .addMethod(
            getRetryBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.RetryBuildRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RETRY_BUILD)))
          .addMethod(
            getApproveBuildMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.ApproveBuildRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_APPROVE_BUILD)))
          .addMethod(
            getCreateBuildTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.CreateBuildTriggerRequest,
                com.google.cloudbuild.v1.BuildTrigger>(
                  this, METHODID_CREATE_BUILD_TRIGGER)))
          .addMethod(
            getGetBuildTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.GetBuildTriggerRequest,
                com.google.cloudbuild.v1.BuildTrigger>(
                  this, METHODID_GET_BUILD_TRIGGER)))
          .addMethod(
            getListBuildTriggersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.ListBuildTriggersRequest,
                com.google.cloudbuild.v1.ListBuildTriggersResponse>(
                  this, METHODID_LIST_BUILD_TRIGGERS)))
          .addMethod(
            getDeleteBuildTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.DeleteBuildTriggerRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BUILD_TRIGGER)))
          .addMethod(
            getUpdateBuildTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
                com.google.cloudbuild.v1.BuildTrigger>(
                  this, METHODID_UPDATE_BUILD_TRIGGER)))
          .addMethod(
            getRunBuildTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.RunBuildTriggerRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_BUILD_TRIGGER)))
          .addMethod(
            getReceiveTriggerWebhookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest,
                com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse>(
                  this, METHODID_RECEIVE_TRIGGER_WEBHOOK)))
          .addMethod(
            getCreateWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.CreateWorkerPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_WORKER_POOL)))
          .addMethod(
            getGetWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.GetWorkerPoolRequest,
                com.google.cloudbuild.v1.WorkerPool>(
                  this, METHODID_GET_WORKER_POOL)))
          .addMethod(
            getDeleteWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.DeleteWorkerPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_WORKER_POOL)))
          .addMethod(
            getUpdateWorkerPoolMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.UpdateWorkerPoolRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_WORKER_POOL)))
          .addMethod(
            getListWorkerPoolsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloudbuild.v1.ListWorkerPoolsRequest,
                com.google.cloudbuild.v1.ListWorkerPoolsResponse>(
                  this, METHODID_LIST_WORKER_POOLS)))
          .build();
    }
  }

  /**
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildStub extends io.grpc.stub.AbstractAsyncStub<CloudBuildStub> {
    private CloudBuildStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public void createBuild(com.google.cloudbuild.v1.CreateBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBuildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public void getBuild(com.google.cloudbuild.v1.GetBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBuildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public void listBuilds(com.google.cloudbuild.v1.ListBuildsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBuildsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public void cancelBuild(com.google.cloudbuild.v1.CancelBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelBuildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public void retryBuild(com.google.cloudbuild.v1.RetryBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRetryBuildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Approves or rejects a pending build.
     * If approved, the returned LRO will be analogous to the LRO returned from
     * a CreateBuild call.
     * If rejected, the returned LRO will be immediately done.
     * </pre>
     */
    public void approveBuild(com.google.cloudbuild.v1.ApproveBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApproveBuildMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void createBuildTrigger(com.google.cloudbuild.v1.CreateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBuildTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void getBuildTrigger(com.google.cloudbuild.v1.GetBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBuildTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public void listBuildTriggers(com.google.cloudbuild.v1.ListBuildTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBuildTriggersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void deleteBuildTrigger(com.google.cloudbuild.v1.DeleteBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBuildTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void updateBuildTrigger(com.google.cloudbuild.v1.UpdateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBuildTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public void runBuildTrigger(com.google.cloudbuild.v1.RunBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunBuildTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * ReceiveTriggerWebhook [Experimental] is called when the API receives a
     * webhook request targeted at a specific trigger.
     * </pre>
     */
    public void receiveTriggerWebhook(com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceiveTriggerWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a `WorkerPool`.
     * </pre>
     */
    public void createWorkerPool(com.google.cloudbuild.v1.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns details of a `WorkerPool`.
     * </pre>
     */
    public void getWorkerPool(com.google.cloudbuild.v1.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a `WorkerPool`.
     * </pre>
     */
    public void deleteWorkerPool(com.google.cloudbuild.v1.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a `WorkerPool`.
     * </pre>
     */
    public void updateWorkerPool(com.google.cloudbuild.v1.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists `WorkerPool`s.
     * </pre>
     */
    public void listWorkerPools(com.google.cloudbuild.v1.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildBlockingStub extends io.grpc.stub.AbstractBlockingStub<CloudBuildBlockingStub> {
    private CloudBuildBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public com.google.longrunning.Operation createBuild(com.google.cloudbuild.v1.CreateBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBuildMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public com.google.cloudbuild.v1.Build getBuild(com.google.cloudbuild.v1.GetBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBuildMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListBuildsResponse listBuilds(com.google.cloudbuild.v1.ListBuildsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBuildsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public com.google.cloudbuild.v1.Build cancelBuild(com.google.cloudbuild.v1.CancelBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelBuildMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public com.google.longrunning.Operation retryBuild(com.google.cloudbuild.v1.RetryBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRetryBuildMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Approves or rejects a pending build.
     * If approved, the returned LRO will be analogous to the LRO returned from
     * a CreateBuild call.
     * If rejected, the returned LRO will be immediately done.
     * </pre>
     */
    public com.google.longrunning.Operation approveBuild(com.google.cloudbuild.v1.ApproveBuildRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApproveBuildMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger createBuildTrigger(com.google.cloudbuild.v1.CreateBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBuildTriggerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger getBuildTrigger(com.google.cloudbuild.v1.GetBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBuildTriggerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListBuildTriggersResponse listBuildTriggers(com.google.cloudbuild.v1.ListBuildTriggersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBuildTriggersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBuildTrigger(com.google.cloudbuild.v1.DeleteBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBuildTriggerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger updateBuildTrigger(com.google.cloudbuild.v1.UpdateBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBuildTriggerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public com.google.longrunning.Operation runBuildTrigger(com.google.cloudbuild.v1.RunBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunBuildTriggerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * ReceiveTriggerWebhook [Experimental] is called when the API receives a
     * webhook request targeted at a specific trigger.
     * </pre>
     */
    public com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse receiveTriggerWebhook(com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceiveTriggerWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a `WorkerPool`.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkerPool(com.google.cloudbuild.v1.CreateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns details of a `WorkerPool`.
     * </pre>
     */
    public com.google.cloudbuild.v1.WorkerPool getWorkerPool(com.google.cloudbuild.v1.GetWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a `WorkerPool`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkerPool(com.google.cloudbuild.v1.DeleteWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a `WorkerPool`.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkerPool(com.google.cloudbuild.v1.UpdateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkerPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists `WorkerPool`s.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListWorkerPoolsResponse listWorkerPools(com.google.cloudbuild.v1.ListWorkerPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkerPoolsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildFutureStub extends io.grpc.stub.AbstractFutureStub<CloudBuildFutureStub> {
    private CloudBuildFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createBuild(
        com.google.cloudbuild.v1.CreateBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBuildMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.Build> getBuild(
        com.google.cloudbuild.v1.GetBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBuildMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.ListBuildsResponse> listBuilds(
        com.google.cloudbuild.v1.ListBuildsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBuildsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.Build> cancelBuild(
        com.google.cloudbuild.v1.CancelBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelBuildMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> retryBuild(
        com.google.cloudbuild.v1.RetryBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRetryBuildMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Approves or rejects a pending build.
     * If approved, the returned LRO will be analogous to the LRO returned from
     * a CreateBuild call.
     * If rejected, the returned LRO will be immediately done.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> approveBuild(
        com.google.cloudbuild.v1.ApproveBuildRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApproveBuildMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger> createBuildTrigger(
        com.google.cloudbuild.v1.CreateBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBuildTriggerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger> getBuildTrigger(
        com.google.cloudbuild.v1.GetBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBuildTriggerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.ListBuildTriggersResponse> listBuildTriggers(
        com.google.cloudbuild.v1.ListBuildTriggersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBuildTriggersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBuildTrigger(
        com.google.cloudbuild.v1.DeleteBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBuildTriggerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger> updateBuildTrigger(
        com.google.cloudbuild.v1.UpdateBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBuildTriggerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runBuildTrigger(
        com.google.cloudbuild.v1.RunBuildTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunBuildTriggerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * ReceiveTriggerWebhook [Experimental] is called when the API receives a
     * webhook request targeted at a specific trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse> receiveTriggerWebhook(
        com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceiveTriggerWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a `WorkerPool`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createWorkerPool(
        com.google.cloudbuild.v1.CreateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns details of a `WorkerPool`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.WorkerPool> getWorkerPool(
        com.google.cloudbuild.v1.GetWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a `WorkerPool`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteWorkerPool(
        com.google.cloudbuild.v1.DeleteWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a `WorkerPool`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateWorkerPool(
        com.google.cloudbuild.v1.UpdateWorkerPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists `WorkerPool`s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.ListWorkerPoolsResponse> listWorkerPools(
        com.google.cloudbuild.v1.ListWorkerPoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BUILD = 0;
  private static final int METHODID_GET_BUILD = 1;
  private static final int METHODID_LIST_BUILDS = 2;
  private static final int METHODID_CANCEL_BUILD = 3;
  private static final int METHODID_RETRY_BUILD = 4;
  private static final int METHODID_APPROVE_BUILD = 5;
  private static final int METHODID_CREATE_BUILD_TRIGGER = 6;
  private static final int METHODID_GET_BUILD_TRIGGER = 7;
  private static final int METHODID_LIST_BUILD_TRIGGERS = 8;
  private static final int METHODID_DELETE_BUILD_TRIGGER = 9;
  private static final int METHODID_UPDATE_BUILD_TRIGGER = 10;
  private static final int METHODID_RUN_BUILD_TRIGGER = 11;
  private static final int METHODID_RECEIVE_TRIGGER_WEBHOOK = 12;
  private static final int METHODID_CREATE_WORKER_POOL = 13;
  private static final int METHODID_GET_WORKER_POOL = 14;
  private static final int METHODID_DELETE_WORKER_POOL = 15;
  private static final int METHODID_UPDATE_WORKER_POOL = 16;
  private static final int METHODID_LIST_WORKER_POOLS = 17;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudBuildImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudBuildImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BUILD:
          serviceImpl.createBuild((com.google.cloudbuild.v1.CreateBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BUILD:
          serviceImpl.getBuild((com.google.cloudbuild.v1.GetBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build>) responseObserver);
          break;
        case METHODID_LIST_BUILDS:
          serviceImpl.listBuilds((com.google.cloudbuild.v1.ListBuildsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse>) responseObserver);
          break;
        case METHODID_CANCEL_BUILD:
          serviceImpl.cancelBuild((com.google.cloudbuild.v1.CancelBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build>) responseObserver);
          break;
        case METHODID_RETRY_BUILD:
          serviceImpl.retryBuild((com.google.cloudbuild.v1.RetryBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_APPROVE_BUILD:
          serviceImpl.approveBuild((com.google.cloudbuild.v1.ApproveBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BUILD_TRIGGER:
          serviceImpl.createBuildTrigger((com.google.cloudbuild.v1.CreateBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>) responseObserver);
          break;
        case METHODID_GET_BUILD_TRIGGER:
          serviceImpl.getBuildTrigger((com.google.cloudbuild.v1.GetBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>) responseObserver);
          break;
        case METHODID_LIST_BUILD_TRIGGERS:
          serviceImpl.listBuildTriggers((com.google.cloudbuild.v1.ListBuildTriggersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse>) responseObserver);
          break;
        case METHODID_DELETE_BUILD_TRIGGER:
          serviceImpl.deleteBuildTrigger((com.google.cloudbuild.v1.DeleteBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_BUILD_TRIGGER:
          serviceImpl.updateBuildTrigger((com.google.cloudbuild.v1.UpdateBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>) responseObserver);
          break;
        case METHODID_RUN_BUILD_TRIGGER:
          serviceImpl.runBuildTrigger((com.google.cloudbuild.v1.RunBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RECEIVE_TRIGGER_WEBHOOK:
          serviceImpl.receiveTriggerWebhook((com.google.cloudbuild.v1.ReceiveTriggerWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ReceiveTriggerWebhookResponse>) responseObserver);
          break;
        case METHODID_CREATE_WORKER_POOL:
          serviceImpl.createWorkerPool((com.google.cloudbuild.v1.CreateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_WORKER_POOL:
          serviceImpl.getWorkerPool((com.google.cloudbuild.v1.GetWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool>) responseObserver);
          break;
        case METHODID_DELETE_WORKER_POOL:
          serviceImpl.deleteWorkerPool((com.google.cloudbuild.v1.DeleteWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKER_POOL:
          serviceImpl.updateWorkerPool((com.google.cloudbuild.v1.UpdateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_WORKER_POOLS:
          serviceImpl.listWorkerPools((com.google.cloudbuild.v1.ListWorkerPoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse>) responseObserver);
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

  private static abstract class CloudBuildBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudBuildBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloudbuild.v1.Cloudbuild.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudBuild");
    }
  }

  private static final class CloudBuildFileDescriptorSupplier
      extends CloudBuildBaseDescriptorSupplier {
    CloudBuildFileDescriptorSupplier() {}
  }

  private static final class CloudBuildMethodDescriptorSupplier
      extends CloudBuildBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudBuildMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudBuildGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudBuildFileDescriptorSupplier())
              .addMethod(getCreateBuildMethod())
              .addMethod(getGetBuildMethod())
              .addMethod(getListBuildsMethod())
              .addMethod(getCancelBuildMethod())
              .addMethod(getRetryBuildMethod())
              .addMethod(getApproveBuildMethod())
              .addMethod(getCreateBuildTriggerMethod())
              .addMethod(getGetBuildTriggerMethod())
              .addMethod(getListBuildTriggersMethod())
              .addMethod(getDeleteBuildTriggerMethod())
              .addMethod(getUpdateBuildTriggerMethod())
              .addMethod(getRunBuildTriggerMethod())
              .addMethod(getReceiveTriggerWebhookMethod())
              .addMethod(getCreateWorkerPoolMethod())
              .addMethod(getGetWorkerPoolMethod())
              .addMethod(getDeleteWorkerPoolMethod())
              .addMethod(getUpdateWorkerPoolMethod())
              .addMethod(getListWorkerPoolsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
