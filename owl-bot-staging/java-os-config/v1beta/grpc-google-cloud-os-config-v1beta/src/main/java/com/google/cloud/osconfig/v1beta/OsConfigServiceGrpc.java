package com.google.cloud.osconfig.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * OS Config API
 * The OS Config service is a server-side component that you can use to
 * manage package installations and patch jobs for virtual machine instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/osconfig/v1beta/osconfig_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OsConfigServiceGrpc {

  private OsConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.osconfig.v1beta.OsConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getExecutePatchJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecutePatchJob",
      requestType = com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getExecutePatchJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getExecutePatchJobMethod;
    if ((getExecutePatchJobMethod = OsConfigServiceGrpc.getExecutePatchJobMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getExecutePatchJobMethod = OsConfigServiceGrpc.getExecutePatchJobMethod) == null) {
          OsConfigServiceGrpc.getExecutePatchJobMethod = getExecutePatchJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecutePatchJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ExecutePatchJob"))
              .build();
        }
      }
    }
    return getExecutePatchJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getGetPatchJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatchJob",
      requestType = com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getGetPatchJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getGetPatchJobMethod;
    if ((getGetPatchJobMethod = OsConfigServiceGrpc.getGetPatchJobMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getGetPatchJobMethod = OsConfigServiceGrpc.getGetPatchJobMethod) == null) {
          OsConfigServiceGrpc.getGetPatchJobMethod = getGetPatchJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPatchJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("GetPatchJob"))
              .build();
        }
      }
    }
    return getGetPatchJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getCancelPatchJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelPatchJob",
      requestType = com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getCancelPatchJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getCancelPatchJobMethod;
    if ((getCancelPatchJobMethod = OsConfigServiceGrpc.getCancelPatchJobMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getCancelPatchJobMethod = OsConfigServiceGrpc.getCancelPatchJobMethod) == null) {
          OsConfigServiceGrpc.getCancelPatchJobMethod = getCancelPatchJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest, com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelPatchJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("CancelPatchJob"))
              .build();
        }
      }
    }
    return getCancelPatchJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> getListPatchJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPatchJobs",
      requestType = com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> getListPatchJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest, com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> getListPatchJobsMethod;
    if ((getListPatchJobsMethod = OsConfigServiceGrpc.getListPatchJobsMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getListPatchJobsMethod = OsConfigServiceGrpc.getListPatchJobsMethod) == null) {
          OsConfigServiceGrpc.getListPatchJobsMethod = getListPatchJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest, com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPatchJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ListPatchJobs"))
              .build();
        }
      }
    }
    return getListPatchJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> getListPatchJobInstanceDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPatchJobInstanceDetails",
      requestType = com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest,
      com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> getListPatchJobInstanceDetailsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest, com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> getListPatchJobInstanceDetailsMethod;
    if ((getListPatchJobInstanceDetailsMethod = OsConfigServiceGrpc.getListPatchJobInstanceDetailsMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getListPatchJobInstanceDetailsMethod = OsConfigServiceGrpc.getListPatchJobInstanceDetailsMethod) == null) {
          OsConfigServiceGrpc.getListPatchJobInstanceDetailsMethod = getListPatchJobInstanceDetailsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest, com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPatchJobInstanceDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ListPatchJobInstanceDetails"))
              .build();
        }
      }
    }
    return getListPatchJobInstanceDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getCreatePatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getCreatePatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getCreatePatchDeploymentMethod;
    if ((getCreatePatchDeploymentMethod = OsConfigServiceGrpc.getCreatePatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getCreatePatchDeploymentMethod = OsConfigServiceGrpc.getCreatePatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getCreatePatchDeploymentMethod = getCreatePatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("CreatePatchDeployment"))
              .build();
        }
      }
    }
    return getCreatePatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getGetPatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getGetPatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getGetPatchDeploymentMethod;
    if ((getGetPatchDeploymentMethod = OsConfigServiceGrpc.getGetPatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getGetPatchDeploymentMethod = OsConfigServiceGrpc.getGetPatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getGetPatchDeploymentMethod = getGetPatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("GetPatchDeployment"))
              .build();
        }
      }
    }
    return getGetPatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> getListPatchDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPatchDeployments",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> getListPatchDeploymentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> getListPatchDeploymentsMethod;
    if ((getListPatchDeploymentsMethod = OsConfigServiceGrpc.getListPatchDeploymentsMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getListPatchDeploymentsMethod = OsConfigServiceGrpc.getListPatchDeploymentsMethod) == null) {
          OsConfigServiceGrpc.getListPatchDeploymentsMethod = getListPatchDeploymentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPatchDeployments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ListPatchDeployments"))
              .build();
        }
      }
    }
    return getListPatchDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest,
      com.google.protobuf.Empty> getDeletePatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest,
      com.google.protobuf.Empty> getDeletePatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest, com.google.protobuf.Empty> getDeletePatchDeploymentMethod;
    if ((getDeletePatchDeploymentMethod = OsConfigServiceGrpc.getDeletePatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getDeletePatchDeploymentMethod = OsConfigServiceGrpc.getDeletePatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getDeletePatchDeploymentMethod = getDeletePatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("DeletePatchDeployment"))
              .build();
        }
      }
    }
    return getDeletePatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getUpdatePatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getUpdatePatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getUpdatePatchDeploymentMethod;
    if ((getUpdatePatchDeploymentMethod = OsConfigServiceGrpc.getUpdatePatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getUpdatePatchDeploymentMethod = OsConfigServiceGrpc.getUpdatePatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getUpdatePatchDeploymentMethod = getUpdatePatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("UpdatePatchDeployment"))
              .build();
        }
      }
    }
    return getUpdatePatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getPausePatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PausePatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getPausePatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getPausePatchDeploymentMethod;
    if ((getPausePatchDeploymentMethod = OsConfigServiceGrpc.getPausePatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getPausePatchDeploymentMethod = OsConfigServiceGrpc.getPausePatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getPausePatchDeploymentMethod = getPausePatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PausePatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("PausePatchDeployment"))
              .build();
        }
      }
    }
    return getPausePatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getResumePatchDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumePatchDeployment",
      requestType = com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest,
      com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getResumePatchDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getResumePatchDeploymentMethod;
    if ((getResumePatchDeploymentMethod = OsConfigServiceGrpc.getResumePatchDeploymentMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getResumePatchDeploymentMethod = OsConfigServiceGrpc.getResumePatchDeploymentMethod) == null) {
          OsConfigServiceGrpc.getResumePatchDeploymentMethod = getResumePatchDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest, com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumePatchDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ResumePatchDeployment"))
              .build();
        }
      }
    }
    return getResumePatchDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getCreateGuestPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGuestPolicy",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getCreateGuestPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getCreateGuestPolicyMethod;
    if ((getCreateGuestPolicyMethod = OsConfigServiceGrpc.getCreateGuestPolicyMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getCreateGuestPolicyMethod = OsConfigServiceGrpc.getCreateGuestPolicyMethod) == null) {
          OsConfigServiceGrpc.getCreateGuestPolicyMethod = getCreateGuestPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGuestPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("CreateGuestPolicy"))
              .build();
        }
      }
    }
    return getCreateGuestPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getGetGuestPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGuestPolicy",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getGetGuestPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getGetGuestPolicyMethod;
    if ((getGetGuestPolicyMethod = OsConfigServiceGrpc.getGetGuestPolicyMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getGetGuestPolicyMethod = OsConfigServiceGrpc.getGetGuestPolicyMethod) == null) {
          OsConfigServiceGrpc.getGetGuestPolicyMethod = getGetGuestPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGuestPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("GetGuestPolicy"))
              .build();
        }
      }
    }
    return getGetGuestPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> getListGuestPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGuestPolicies",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> getListGuestPoliciesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> getListGuestPoliciesMethod;
    if ((getListGuestPoliciesMethod = OsConfigServiceGrpc.getListGuestPoliciesMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getListGuestPoliciesMethod = OsConfigServiceGrpc.getListGuestPoliciesMethod) == null) {
          OsConfigServiceGrpc.getListGuestPoliciesMethod = getListGuestPoliciesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGuestPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("ListGuestPolicies"))
              .build();
        }
      }
    }
    return getListGuestPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getUpdateGuestPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGuestPolicy",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getUpdateGuestPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getUpdateGuestPolicyMethod;
    if ((getUpdateGuestPolicyMethod = OsConfigServiceGrpc.getUpdateGuestPolicyMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getUpdateGuestPolicyMethod = OsConfigServiceGrpc.getUpdateGuestPolicyMethod) == null) {
          OsConfigServiceGrpc.getUpdateGuestPolicyMethod = getUpdateGuestPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGuestPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("UpdateGuestPolicy"))
              .build();
        }
      }
    }
    return getUpdateGuestPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest,
      com.google.protobuf.Empty> getDeleteGuestPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGuestPolicy",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest,
      com.google.protobuf.Empty> getDeleteGuestPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest, com.google.protobuf.Empty> getDeleteGuestPolicyMethod;
    if ((getDeleteGuestPolicyMethod = OsConfigServiceGrpc.getDeleteGuestPolicyMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getDeleteGuestPolicyMethod = OsConfigServiceGrpc.getDeleteGuestPolicyMethod) == null) {
          OsConfigServiceGrpc.getDeleteGuestPolicyMethod = getDeleteGuestPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGuestPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("DeleteGuestPolicy"))
              .build();
        }
      }
    }
    return getDeleteGuestPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> getLookupEffectiveGuestPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupEffectiveGuestPolicy",
      requestType = com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest.class,
      responseType = com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest,
      com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> getLookupEffectiveGuestPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> getLookupEffectiveGuestPolicyMethod;
    if ((getLookupEffectiveGuestPolicyMethod = OsConfigServiceGrpc.getLookupEffectiveGuestPolicyMethod) == null) {
      synchronized (OsConfigServiceGrpc.class) {
        if ((getLookupEffectiveGuestPolicyMethod = OsConfigServiceGrpc.getLookupEffectiveGuestPolicyMethod) == null) {
          OsConfigServiceGrpc.getLookupEffectiveGuestPolicyMethod = getLookupEffectiveGuestPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest, com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupEffectiveGuestPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy.getDefaultInstance()))
              .setSchemaDescriptor(new OsConfigServiceMethodDescriptorSupplier("LookupEffectiveGuestPolicy"))
              .build();
        }
      }
    }
    return getLookupEffectiveGuestPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OsConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceStub>() {
        @java.lang.Override
        public OsConfigServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OsConfigServiceStub(channel, callOptions);
        }
      };
    return OsConfigServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OsConfigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceBlockingStub>() {
        @java.lang.Override
        public OsConfigServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OsConfigServiceBlockingStub(channel, callOptions);
        }
      };
    return OsConfigServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OsConfigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OsConfigServiceFutureStub>() {
        @java.lang.Override
        public OsConfigServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OsConfigServiceFutureStub(channel, callOptions);
        }
      };
    return OsConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * OS Config API
   * The OS Config service is a server-side component that you can use to
   * manage package installations and patch jobs for virtual machine instances.
   * </pre>
   */
  public static abstract class OsConfigServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Patch VM instances by creating and running a patch job.
     * </pre>
     */
    public void executePatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecutePatchJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the patch job. This can be used to track the progress of an
     * ongoing patch job or review the details of completed jobs.
     * </pre>
     */
    public void getPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPatchJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancel a patch job. The patch job must be active. Canceled patch jobs
     * cannot be restarted.
     * </pre>
     */
    public void cancelPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelPatchJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a list of patch jobs.
     * </pre>
     */
    public void listPatchJobs(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPatchJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a list of instance details for a given patch job.
     * </pre>
     */
    public void listPatchJobInstanceDetails(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPatchJobInstanceDetailsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create an OS Config patch deployment.
     * </pre>
     */
    public void createPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get an OS Config patch deployment.
     * </pre>
     */
    public void getPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a page of OS Config patch deployments.
     * </pre>
     */
    public void listPatchDeployments(com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPatchDeploymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete an OS Config patch deployment.
     * </pre>
     */
    public void deletePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update an OS Config patch deployment.
     * </pre>
     */
    public void updatePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Change state of patch deployment to "PAUSED".
     * Patch deployment in paused state doesn't generate patch jobs.
     * </pre>
     */
    public void pausePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPausePatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Change state of patch deployment back to "ACTIVE".
     * Patch deployment in active state continues to generate patch jobs.
     * </pre>
     */
    public void resumePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResumePatchDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create an OS Config guest policy.
     * </pre>
     */
    public void createGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateGuestPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get an OS Config guest policy.
     * </pre>
     */
    public void getGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGuestPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get a page of OS Config guest policies.
     * </pre>
     */
    public void listGuestPolicies(com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGuestPoliciesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update an OS Config guest policy.
     * </pre>
     */
    public void updateGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateGuestPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete an OS Config guest policy.
     * </pre>
     */
    public void deleteGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteGuestPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lookup the effective guest policy that applies to a VM instance. This
     * lookup merges all policies that are assigned to the instance ancestry.
     * </pre>
     */
    public void lookupEffectiveGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupEffectiveGuestPolicyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecutePatchJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest,
                com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>(
                  this, METHODID_EXECUTE_PATCH_JOB)))
          .addMethod(
            getGetPatchJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest,
                com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>(
                  this, METHODID_GET_PATCH_JOB)))
          .addMethod(
            getCancelPatchJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest,
                com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>(
                  this, METHODID_CANCEL_PATCH_JOB)))
          .addMethod(
            getListPatchJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest,
                com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse>(
                  this, METHODID_LIST_PATCH_JOBS)))
          .addMethod(
            getListPatchJobInstanceDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest,
                com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse>(
                  this, METHODID_LIST_PATCH_JOB_INSTANCE_DETAILS)))
          .addMethod(
            getCreatePatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>(
                  this, METHODID_CREATE_PATCH_DEPLOYMENT)))
          .addMethod(
            getGetPatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>(
                  this, METHODID_GET_PATCH_DEPLOYMENT)))
          .addMethod(
            getListPatchDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse>(
                  this, METHODID_LIST_PATCH_DEPLOYMENTS)))
          .addMethod(
            getDeletePatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_PATCH_DEPLOYMENT)))
          .addMethod(
            getUpdatePatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>(
                  this, METHODID_UPDATE_PATCH_DEPLOYMENT)))
          .addMethod(
            getPausePatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>(
                  this, METHODID_PAUSE_PATCH_DEPLOYMENT)))
          .addMethod(
            getResumePatchDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest,
                com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>(
                  this, METHODID_RESUME_PATCH_DEPLOYMENT)))
          .addMethod(
            getCreateGuestPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest,
                com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>(
                  this, METHODID_CREATE_GUEST_POLICY)))
          .addMethod(
            getGetGuestPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest,
                com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>(
                  this, METHODID_GET_GUEST_POLICY)))
          .addMethod(
            getListGuestPoliciesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest,
                com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse>(
                  this, METHODID_LIST_GUEST_POLICIES)))
          .addMethod(
            getUpdateGuestPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest,
                com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>(
                  this, METHODID_UPDATE_GUEST_POLICY)))
          .addMethod(
            getDeleteGuestPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_GUEST_POLICY)))
          .addMethod(
            getLookupEffectiveGuestPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest,
                com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy>(
                  this, METHODID_LOOKUP_EFFECTIVE_GUEST_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * OS Config API
   * The OS Config service is a server-side component that you can use to
   * manage package installations and patch jobs for virtual machine instances.
   * </pre>
   */
  public static final class OsConfigServiceStub extends io.grpc.stub.AbstractAsyncStub<OsConfigServiceStub> {
    private OsConfigServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Patch VM instances by creating and running a patch job.
     * </pre>
     */
    public void executePatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecutePatchJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the patch job. This can be used to track the progress of an
     * ongoing patch job or review the details of completed jobs.
     * </pre>
     */
    public void getPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPatchJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancel a patch job. The patch job must be active. Canceled patch jobs
     * cannot be restarted.
     * </pre>
     */
    public void cancelPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelPatchJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a list of patch jobs.
     * </pre>
     */
    public void listPatchJobs(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPatchJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a list of instance details for a given patch job.
     * </pre>
     */
    public void listPatchJobInstanceDetails(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPatchJobInstanceDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create an OS Config patch deployment.
     * </pre>
     */
    public void createPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get an OS Config patch deployment.
     * </pre>
     */
    public void getPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a page of OS Config patch deployments.
     * </pre>
     */
    public void listPatchDeployments(com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPatchDeploymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete an OS Config patch deployment.
     * </pre>
     */
    public void deletePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update an OS Config patch deployment.
     * </pre>
     */
    public void updatePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Change state of patch deployment to "PAUSED".
     * Patch deployment in paused state doesn't generate patch jobs.
     * </pre>
     */
    public void pausePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPausePatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Change state of patch deployment back to "ACTIVE".
     * Patch deployment in active state continues to generate patch jobs.
     * </pre>
     */
    public void resumePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumePatchDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create an OS Config guest policy.
     * </pre>
     */
    public void createGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGuestPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get an OS Config guest policy.
     * </pre>
     */
    public void getGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGuestPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get a page of OS Config guest policies.
     * </pre>
     */
    public void listGuestPolicies(com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGuestPoliciesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update an OS Config guest policy.
     * </pre>
     */
    public void updateGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGuestPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete an OS Config guest policy.
     * </pre>
     */
    public void deleteGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGuestPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lookup the effective guest policy that applies to a VM instance. This
     * lookup merges all policies that are assigned to the instance ancestry.
     * </pre>
     */
    public void lookupEffectiveGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupEffectiveGuestPolicyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * OS Config API
   * The OS Config service is a server-side component that you can use to
   * manage package installations and patch jobs for virtual machine instances.
   * </pre>
   */
  public static final class OsConfigServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<OsConfigServiceBlockingStub> {
    private OsConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Patch VM instances by creating and running a patch job.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob executePatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecutePatchJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the patch job. This can be used to track the progress of an
     * ongoing patch job or review the details of completed jobs.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob getPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPatchJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel a patch job. The patch job must be active. Canceled patch jobs
     * cannot be restarted.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob cancelPatchJob(com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelPatchJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a list of patch jobs.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse listPatchJobs(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPatchJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a list of instance details for a given patch job.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse listPatchJobInstanceDetails(com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPatchJobInstanceDetailsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create an OS Config patch deployment.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment createPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get an OS Config patch deployment.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment getPatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a page of OS Config patch deployments.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse listPatchDeployments(com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPatchDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete an OS Config patch deployment.
     * </pre>
     */
    public com.google.protobuf.Empty deletePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update an OS Config patch deployment.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment updatePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Change state of patch deployment to "PAUSED".
     * Patch deployment in paused state doesn't generate patch jobs.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment pausePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPausePatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Change state of patch deployment back to "ACTIVE".
     * Patch deployment in active state continues to generate patch jobs.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment resumePatchDeployment(com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumePatchDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create an OS Config guest policy.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy createGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGuestPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get an OS Config guest policy.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy getGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGuestPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get a page of OS Config guest policies.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse listGuestPolicies(com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGuestPoliciesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update an OS Config guest policy.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy updateGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGuestPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete an OS Config guest policy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGuestPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lookup the effective guest policy that applies to a VM instance. This
     * lookup merges all policies that are assigned to the instance ancestry.
     * </pre>
     */
    public com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy lookupEffectiveGuestPolicy(com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupEffectiveGuestPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * OS Config API
   * The OS Config service is a server-side component that you can use to
   * manage package installations and patch jobs for virtual machine instances.
   * </pre>
   */
  public static final class OsConfigServiceFutureStub extends io.grpc.stub.AbstractFutureStub<OsConfigServiceFutureStub> {
    private OsConfigServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Patch VM instances by creating and running a patch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> executePatchJob(
        com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecutePatchJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the patch job. This can be used to track the progress of an
     * ongoing patch job or review the details of completed jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> getPatchJob(
        com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPatchJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancel a patch job. The patch job must be active. Canceled patch jobs
     * cannot be restarted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob> cancelPatchJob(
        com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelPatchJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a list of patch jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse> listPatchJobs(
        com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPatchJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a list of instance details for a given patch job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse> listPatchJobInstanceDetails(
        com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPatchJobInstanceDetailsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create an OS Config patch deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> createPatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get an OS Config patch deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> getPatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a page of OS Config patch deployments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse> listPatchDeployments(
        com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPatchDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete an OS Config patch deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deletePatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update an OS Config patch deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> updatePatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Change state of patch deployment to "PAUSED".
     * Patch deployment in paused state doesn't generate patch jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> pausePatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPausePatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Change state of patch deployment back to "ACTIVE".
     * Patch deployment in active state continues to generate patch jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment> resumePatchDeployment(
        com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumePatchDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create an OS Config guest policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> createGuestPolicy(
        com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGuestPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get an OS Config guest policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> getGuestPolicy(
        com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGuestPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get a page of OS Config guest policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse> listGuestPolicies(
        com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGuestPoliciesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update an OS Config guest policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy> updateGuestPolicy(
        com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGuestPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete an OS Config guest policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteGuestPolicy(
        com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGuestPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lookup the effective guest policy that applies to a VM instance. This
     * lookup merges all policies that are assigned to the instance ancestry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy> lookupEffectiveGuestPolicy(
        com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupEffectiveGuestPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_EXECUTE_PATCH_JOB = 0;
  private static final int METHODID_GET_PATCH_JOB = 1;
  private static final int METHODID_CANCEL_PATCH_JOB = 2;
  private static final int METHODID_LIST_PATCH_JOBS = 3;
  private static final int METHODID_LIST_PATCH_JOB_INSTANCE_DETAILS = 4;
  private static final int METHODID_CREATE_PATCH_DEPLOYMENT = 5;
  private static final int METHODID_GET_PATCH_DEPLOYMENT = 6;
  private static final int METHODID_LIST_PATCH_DEPLOYMENTS = 7;
  private static final int METHODID_DELETE_PATCH_DEPLOYMENT = 8;
  private static final int METHODID_UPDATE_PATCH_DEPLOYMENT = 9;
  private static final int METHODID_PAUSE_PATCH_DEPLOYMENT = 10;
  private static final int METHODID_RESUME_PATCH_DEPLOYMENT = 11;
  private static final int METHODID_CREATE_GUEST_POLICY = 12;
  private static final int METHODID_GET_GUEST_POLICY = 13;
  private static final int METHODID_LIST_GUEST_POLICIES = 14;
  private static final int METHODID_UPDATE_GUEST_POLICY = 15;
  private static final int METHODID_DELETE_GUEST_POLICY = 16;
  private static final int METHODID_LOOKUP_EFFECTIVE_GUEST_POLICY = 17;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OsConfigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OsConfigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE_PATCH_JOB:
          serviceImpl.executePatchJob((com.google.cloud.osconfig.v1beta.PatchJobs.ExecutePatchJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>) responseObserver);
          break;
        case METHODID_GET_PATCH_JOB:
          serviceImpl.getPatchJob((com.google.cloud.osconfig.v1beta.PatchJobs.GetPatchJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>) responseObserver);
          break;
        case METHODID_CANCEL_PATCH_JOB:
          serviceImpl.cancelPatchJob((com.google.cloud.osconfig.v1beta.PatchJobs.CancelPatchJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.PatchJob>) responseObserver);
          break;
        case METHODID_LIST_PATCH_JOBS:
          serviceImpl.listPatchJobs((com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobsResponse>) responseObserver);
          break;
        case METHODID_LIST_PATCH_JOB_INSTANCE_DETAILS:
          serviceImpl.listPatchJobInstanceDetails((com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchJobs.ListPatchJobInstanceDetailsResponse>) responseObserver);
          break;
        case METHODID_CREATE_PATCH_DEPLOYMENT:
          serviceImpl.createPatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.CreatePatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>) responseObserver);
          break;
        case METHODID_GET_PATCH_DEPLOYMENT:
          serviceImpl.getPatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.GetPatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>) responseObserver);
          break;
        case METHODID_LIST_PATCH_DEPLOYMENTS:
          serviceImpl.listPatchDeployments((com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.ListPatchDeploymentsResponse>) responseObserver);
          break;
        case METHODID_DELETE_PATCH_DEPLOYMENT:
          serviceImpl.deletePatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.DeletePatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_PATCH_DEPLOYMENT:
          serviceImpl.updatePatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.UpdatePatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>) responseObserver);
          break;
        case METHODID_PAUSE_PATCH_DEPLOYMENT:
          serviceImpl.pausePatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.PausePatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>) responseObserver);
          break;
        case METHODID_RESUME_PATCH_DEPLOYMENT:
          serviceImpl.resumePatchDeployment((com.google.cloud.osconfig.v1beta.PatchDeployments.ResumePatchDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.PatchDeployments.PatchDeployment>) responseObserver);
          break;
        case METHODID_CREATE_GUEST_POLICY:
          serviceImpl.createGuestPolicy((com.google.cloud.osconfig.v1beta.GuestPolicies.CreateGuestPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>) responseObserver);
          break;
        case METHODID_GET_GUEST_POLICY:
          serviceImpl.getGuestPolicy((com.google.cloud.osconfig.v1beta.GuestPolicies.GetGuestPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>) responseObserver);
          break;
        case METHODID_LIST_GUEST_POLICIES:
          serviceImpl.listGuestPolicies((com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.ListGuestPoliciesResponse>) responseObserver);
          break;
        case METHODID_UPDATE_GUEST_POLICY:
          serviceImpl.updateGuestPolicy((com.google.cloud.osconfig.v1beta.GuestPolicies.UpdateGuestPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.GuestPolicy>) responseObserver);
          break;
        case METHODID_DELETE_GUEST_POLICY:
          serviceImpl.deleteGuestPolicy((com.google.cloud.osconfig.v1beta.GuestPolicies.DeleteGuestPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOOKUP_EFFECTIVE_GUEST_POLICY:
          serviceImpl.lookupEffectiveGuestPolicy((com.google.cloud.osconfig.v1beta.GuestPolicies.LookupEffectiveGuestPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1beta.GuestPolicies.EffectiveGuestPolicy>) responseObserver);
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

  private static abstract class OsConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OsConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.osconfig.v1beta.OsConfigProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OsConfigService");
    }
  }

  private static final class OsConfigServiceFileDescriptorSupplier
      extends OsConfigServiceBaseDescriptorSupplier {
    OsConfigServiceFileDescriptorSupplier() {}
  }

  private static final class OsConfigServiceMethodDescriptorSupplier
      extends OsConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OsConfigServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OsConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OsConfigServiceFileDescriptorSupplier())
              .addMethod(getExecutePatchJobMethod())
              .addMethod(getGetPatchJobMethod())
              .addMethod(getCancelPatchJobMethod())
              .addMethod(getListPatchJobsMethod())
              .addMethod(getListPatchJobInstanceDetailsMethod())
              .addMethod(getCreatePatchDeploymentMethod())
              .addMethod(getGetPatchDeploymentMethod())
              .addMethod(getListPatchDeploymentsMethod())
              .addMethod(getDeletePatchDeploymentMethod())
              .addMethod(getUpdatePatchDeploymentMethod())
              .addMethod(getPausePatchDeploymentMethod())
              .addMethod(getResumePatchDeploymentMethod())
              .addMethod(getCreateGuestPolicyMethod())
              .addMethod(getGetGuestPolicyMethod())
              .addMethod(getListGuestPoliciesMethod())
              .addMethod(getUpdateGuestPolicyMethod())
              .addMethod(getDeleteGuestPolicyMethod())
              .addMethod(getLookupEffectiveGuestPolicyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
