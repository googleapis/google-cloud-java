package com.google.cloud.securityposture.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securityposture/v1/securityposture.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityPostureGrpc {

  private SecurityPostureGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.securityposture.v1.SecurityPosture";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPosturesRequest,
      com.google.cloud.securityposture.v1.ListPosturesResponse> getListPosturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPostures",
      requestType = com.google.cloud.securityposture.v1.ListPosturesRequest.class,
      responseType = com.google.cloud.securityposture.v1.ListPosturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPosturesRequest,
      com.google.cloud.securityposture.v1.ListPosturesResponse> getListPosturesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPosturesRequest, com.google.cloud.securityposture.v1.ListPosturesResponse> getListPosturesMethod;
    if ((getListPosturesMethod = SecurityPostureGrpc.getListPosturesMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getListPosturesMethod = SecurityPostureGrpc.getListPosturesMethod) == null) {
          SecurityPostureGrpc.getListPosturesMethod = getListPosturesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.ListPosturesRequest, com.google.cloud.securityposture.v1.ListPosturesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPostures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPosturesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPosturesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("ListPostures"))
              .build();
        }
      }
    }
    return getListPosturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureRevisionsRequest,
      com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> getListPostureRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPostureRevisions",
      requestType = com.google.cloud.securityposture.v1.ListPostureRevisionsRequest.class,
      responseType = com.google.cloud.securityposture.v1.ListPostureRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureRevisionsRequest,
      com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> getListPostureRevisionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureRevisionsRequest, com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> getListPostureRevisionsMethod;
    if ((getListPostureRevisionsMethod = SecurityPostureGrpc.getListPostureRevisionsMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getListPostureRevisionsMethod = SecurityPostureGrpc.getListPostureRevisionsMethod) == null) {
          SecurityPostureGrpc.getListPostureRevisionsMethod = getListPostureRevisionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.ListPostureRevisionsRequest, com.google.cloud.securityposture.v1.ListPostureRevisionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPostureRevisions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureRevisionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("ListPostureRevisions"))
              .build();
        }
      }
    }
    return getListPostureRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureRequest,
      com.google.cloud.securityposture.v1.Posture> getGetPostureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPosture",
      requestType = com.google.cloud.securityposture.v1.GetPostureRequest.class,
      responseType = com.google.cloud.securityposture.v1.Posture.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureRequest,
      com.google.cloud.securityposture.v1.Posture> getGetPostureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureRequest, com.google.cloud.securityposture.v1.Posture> getGetPostureMethod;
    if ((getGetPostureMethod = SecurityPostureGrpc.getGetPostureMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getGetPostureMethod = SecurityPostureGrpc.getGetPostureMethod) == null) {
          SecurityPostureGrpc.getGetPostureMethod = getGetPostureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.GetPostureRequest, com.google.cloud.securityposture.v1.Posture>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPosture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.GetPostureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.Posture.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("GetPosture"))
              .build();
        }
      }
    }
    return getGetPostureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureRequest,
      com.google.longrunning.Operation> getCreatePostureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePosture",
      requestType = com.google.cloud.securityposture.v1.CreatePostureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureRequest,
      com.google.longrunning.Operation> getCreatePostureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureRequest, com.google.longrunning.Operation> getCreatePostureMethod;
    if ((getCreatePostureMethod = SecurityPostureGrpc.getCreatePostureMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getCreatePostureMethod = SecurityPostureGrpc.getCreatePostureMethod) == null) {
          SecurityPostureGrpc.getCreatePostureMethod = getCreatePostureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.CreatePostureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePosture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.CreatePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("CreatePosture"))
              .build();
        }
      }
    }
    return getCreatePostureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureRequest,
      com.google.longrunning.Operation> getUpdatePostureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePosture",
      requestType = com.google.cloud.securityposture.v1.UpdatePostureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureRequest,
      com.google.longrunning.Operation> getUpdatePostureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureRequest, com.google.longrunning.Operation> getUpdatePostureMethod;
    if ((getUpdatePostureMethod = SecurityPostureGrpc.getUpdatePostureMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getUpdatePostureMethod = SecurityPostureGrpc.getUpdatePostureMethod) == null) {
          SecurityPostureGrpc.getUpdatePostureMethod = getUpdatePostureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.UpdatePostureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePosture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.UpdatePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("UpdatePosture"))
              .build();
        }
      }
    }
    return getUpdatePostureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureRequest,
      com.google.longrunning.Operation> getDeletePostureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePosture",
      requestType = com.google.cloud.securityposture.v1.DeletePostureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureRequest,
      com.google.longrunning.Operation> getDeletePostureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureRequest, com.google.longrunning.Operation> getDeletePostureMethod;
    if ((getDeletePostureMethod = SecurityPostureGrpc.getDeletePostureMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getDeletePostureMethod = SecurityPostureGrpc.getDeletePostureMethod) == null) {
          SecurityPostureGrpc.getDeletePostureMethod = getDeletePostureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.DeletePostureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePosture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.DeletePostureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("DeletePosture"))
              .build();
        }
      }
    }
    return getDeletePostureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ExtractPostureRequest,
      com.google.longrunning.Operation> getExtractPostureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExtractPosture",
      requestType = com.google.cloud.securityposture.v1.ExtractPostureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ExtractPostureRequest,
      com.google.longrunning.Operation> getExtractPostureMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ExtractPostureRequest, com.google.longrunning.Operation> getExtractPostureMethod;
    if ((getExtractPostureMethod = SecurityPostureGrpc.getExtractPostureMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getExtractPostureMethod = SecurityPostureGrpc.getExtractPostureMethod) == null) {
          SecurityPostureGrpc.getExtractPostureMethod = getExtractPostureMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.ExtractPostureRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExtractPosture"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ExtractPostureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("ExtractPosture"))
              .build();
        }
      }
    }
    return getExtractPostureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest,
      com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> getListPostureDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPostureDeployments",
      requestType = com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest.class,
      responseType = com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest,
      com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> getListPostureDeploymentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest, com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> getListPostureDeploymentsMethod;
    if ((getListPostureDeploymentsMethod = SecurityPostureGrpc.getListPostureDeploymentsMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getListPostureDeploymentsMethod = SecurityPostureGrpc.getListPostureDeploymentsMethod) == null) {
          SecurityPostureGrpc.getListPostureDeploymentsMethod = getListPostureDeploymentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest, com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPostureDeployments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("ListPostureDeployments"))
              .build();
        }
      }
    }
    return getListPostureDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureDeploymentRequest,
      com.google.cloud.securityposture.v1.PostureDeployment> getGetPostureDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPostureDeployment",
      requestType = com.google.cloud.securityposture.v1.GetPostureDeploymentRequest.class,
      responseType = com.google.cloud.securityposture.v1.PostureDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureDeploymentRequest,
      com.google.cloud.securityposture.v1.PostureDeployment> getGetPostureDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureDeploymentRequest, com.google.cloud.securityposture.v1.PostureDeployment> getGetPostureDeploymentMethod;
    if ((getGetPostureDeploymentMethod = SecurityPostureGrpc.getGetPostureDeploymentMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getGetPostureDeploymentMethod = SecurityPostureGrpc.getGetPostureDeploymentMethod) == null) {
          SecurityPostureGrpc.getGetPostureDeploymentMethod = getGetPostureDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.GetPostureDeploymentRequest, com.google.cloud.securityposture.v1.PostureDeployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPostureDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.GetPostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.PostureDeployment.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("GetPostureDeployment"))
              .build();
        }
      }
    }
    return getGetPostureDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest,
      com.google.longrunning.Operation> getCreatePostureDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePostureDeployment",
      requestType = com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest,
      com.google.longrunning.Operation> getCreatePostureDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest, com.google.longrunning.Operation> getCreatePostureDeploymentMethod;
    if ((getCreatePostureDeploymentMethod = SecurityPostureGrpc.getCreatePostureDeploymentMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getCreatePostureDeploymentMethod = SecurityPostureGrpc.getCreatePostureDeploymentMethod) == null) {
          SecurityPostureGrpc.getCreatePostureDeploymentMethod = getCreatePostureDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePostureDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("CreatePostureDeployment"))
              .build();
        }
      }
    }
    return getCreatePostureDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest,
      com.google.longrunning.Operation> getUpdatePostureDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePostureDeployment",
      requestType = com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest,
      com.google.longrunning.Operation> getUpdatePostureDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest, com.google.longrunning.Operation> getUpdatePostureDeploymentMethod;
    if ((getUpdatePostureDeploymentMethod = SecurityPostureGrpc.getUpdatePostureDeploymentMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getUpdatePostureDeploymentMethod = SecurityPostureGrpc.getUpdatePostureDeploymentMethod) == null) {
          SecurityPostureGrpc.getUpdatePostureDeploymentMethod = getUpdatePostureDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePostureDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("UpdatePostureDeployment"))
              .build();
        }
      }
    }
    return getUpdatePostureDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest,
      com.google.longrunning.Operation> getDeletePostureDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePostureDeployment",
      requestType = com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest,
      com.google.longrunning.Operation> getDeletePostureDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest, com.google.longrunning.Operation> getDeletePostureDeploymentMethod;
    if ((getDeletePostureDeploymentMethod = SecurityPostureGrpc.getDeletePostureDeploymentMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getDeletePostureDeploymentMethod = SecurityPostureGrpc.getDeletePostureDeploymentMethod) == null) {
          SecurityPostureGrpc.getDeletePostureDeploymentMethod = getDeletePostureDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePostureDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("DeletePostureDeployment"))
              .build();
        }
      }
    }
    return getDeletePostureDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureTemplatesRequest,
      com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> getListPostureTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPostureTemplates",
      requestType = com.google.cloud.securityposture.v1.ListPostureTemplatesRequest.class,
      responseType = com.google.cloud.securityposture.v1.ListPostureTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureTemplatesRequest,
      com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> getListPostureTemplatesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.ListPostureTemplatesRequest, com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> getListPostureTemplatesMethod;
    if ((getListPostureTemplatesMethod = SecurityPostureGrpc.getListPostureTemplatesMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getListPostureTemplatesMethod = SecurityPostureGrpc.getListPostureTemplatesMethod) == null) {
          SecurityPostureGrpc.getListPostureTemplatesMethod = getListPostureTemplatesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.ListPostureTemplatesRequest, com.google.cloud.securityposture.v1.ListPostureTemplatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPostureTemplates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.ListPostureTemplatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("ListPostureTemplates"))
              .build();
        }
      }
    }
    return getListPostureTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureTemplateRequest,
      com.google.cloud.securityposture.v1.PostureTemplate> getGetPostureTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPostureTemplate",
      requestType = com.google.cloud.securityposture.v1.GetPostureTemplateRequest.class,
      responseType = com.google.cloud.securityposture.v1.PostureTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureTemplateRequest,
      com.google.cloud.securityposture.v1.PostureTemplate> getGetPostureTemplateMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securityposture.v1.GetPostureTemplateRequest, com.google.cloud.securityposture.v1.PostureTemplate> getGetPostureTemplateMethod;
    if ((getGetPostureTemplateMethod = SecurityPostureGrpc.getGetPostureTemplateMethod) == null) {
      synchronized (SecurityPostureGrpc.class) {
        if ((getGetPostureTemplateMethod = SecurityPostureGrpc.getGetPostureTemplateMethod) == null) {
          SecurityPostureGrpc.getGetPostureTemplateMethod = getGetPostureTemplateMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securityposture.v1.GetPostureTemplateRequest, com.google.cloud.securityposture.v1.PostureTemplate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPostureTemplate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.GetPostureTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securityposture.v1.PostureTemplate.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityPostureMethodDescriptorSupplier("GetPostureTemplate"))
              .build();
        }
      }
    }
    return getGetPostureTemplateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecurityPostureStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityPostureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityPostureStub>() {
        @java.lang.Override
        public SecurityPostureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityPostureStub(channel, callOptions);
        }
      };
    return SecurityPostureStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityPostureBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityPostureBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityPostureBlockingStub>() {
        @java.lang.Override
        public SecurityPostureBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityPostureBlockingStub(channel, callOptions);
        }
      };
    return SecurityPostureBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecurityPostureFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityPostureFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityPostureFutureStub>() {
        @java.lang.Override
        public SecurityPostureFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityPostureFutureStub(channel, callOptions);
        }
      };
    return SecurityPostureFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * (-- This option restricts the visibility of the API to only projects that
     * will
     * (-- be labeled as `PREVIEW` or `GOOGLE_INTERNAL` by the service.
     * (-- option (google.api.api_visibility).restriction =
     * "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in a given organization
     * and location. In case a posture has multiple revisions, the latest revision
     * as per UpdateTime will be returned.
     * </pre>
     */
    default void listPostures(com.google.cloud.securityposture.v1.ListPosturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPosturesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPosturesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists revisions of a Posture in a given organization and location.
     * </pre>
     */
    default void listPostureRevisions(com.google.cloud.securityposture.v1.ListPostureRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPostureRevisionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a posture in a given organization and location.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the Posture name does not
     * exist. In case revision_id is not provided then the latest Posture revision
     * by UpdateTime is returned.
     * </pre>
     */
    default void getPosture(com.google.cloud.securityposture.v1.GetPostureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.Posture> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Posture resource.
     * If a Posture with the specified name already exists in the specified
     * organization and location, the long running operation returns a
     * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    default void createPosture(com.google.cloud.securityposture.v1.CreatePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePostureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Posture.
     * A new revision of the posture will be created if the revision to be
     * updated is currently deployed on a workload.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * Posture does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the Posture.
     * Updatable fields are state, description and policy_sets.
     * State update operation cannot be clubbed with update of description and
     * policy_sets.
     * An ACTIVE posture can be updated to both DRAFT or DEPRECATED states.
     * Postures in DRAFT or DEPRECATED states can only be updated to ACTIVE state.
     * </pre>
     */
    default void updatePosture(com.google.cloud.securityposture.v1.UpdatePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePostureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes all the revisions of a resource.
     * A posture can only be deleted when none of the revisions are deployed to
     * any workload.
     * </pre>
     */
    default void deletePosture(com.google.cloud.securityposture.v1.DeletePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePostureMethod(), responseObserver);
    }

    /**
     * <pre>
     * Extracts existing policies on a workload as a posture.
     * If a Posture on the given workload already exists, the long running
     * operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    default void extractPosture(com.google.cloud.securityposture.v1.ExtractPostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExtractPostureMethod(), responseObserver);
    }

    /**
     * <pre>
     * PostureDeployments
     * Lists PostureDeployments in a given project and location.
     * </pre>
     */
    default void listPostureDeployments(com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPostureDeploymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single PostureDeployment.
     * </pre>
     */
    default void getPostureDeployment(com.google.cloud.securityposture.v1.GetPostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureDeployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostureDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new PostureDeployment in a given project and location.
     * </pre>
     */
    default void createPostureDeployment(com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePostureDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single PostureDeployment.
     * </pre>
     */
    default void updatePostureDeployment(com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePostureDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single PostureDeployment.
     * </pre>
     */
    default void deletePostureDeployment(com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePostureDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * PostureTemplates
     * Lists all the PostureTemplates available to the user.
     * </pre>
     */
    default void listPostureTemplates(com.google.cloud.securityposture.v1.ListPostureTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPostureTemplatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a PostureTemplate.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the PostureTemplate name
     * does not exist. In case revision_id is not provided then the
     * PostureTemplate with latest revision_id is returned.
     * </pre>
     */
    default void getPostureTemplate(com.google.cloud.securityposture.v1.GetPostureTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureTemplate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostureTemplateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SecurityPosture.
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static abstract class SecurityPostureImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SecurityPostureGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SecurityPosture.
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class SecurityPostureStub
      extends io.grpc.stub.AbstractAsyncStub<SecurityPostureStub> {
    private SecurityPostureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityPostureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityPostureStub(channel, callOptions);
    }

    /**
     * <pre>
     * (-- This option restricts the visibility of the API to only projects that
     * will
     * (-- be labeled as `PREVIEW` or `GOOGLE_INTERNAL` by the service.
     * (-- option (google.api.api_visibility).restriction =
     * "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in a given organization
     * and location. In case a posture has multiple revisions, the latest revision
     * as per UpdateTime will be returned.
     * </pre>
     */
    public void listPostures(com.google.cloud.securityposture.v1.ListPosturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPosturesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPosturesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists revisions of a Posture in a given organization and location.
     * </pre>
     */
    public void listPostureRevisions(com.google.cloud.securityposture.v1.ListPostureRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPostureRevisionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a posture in a given organization and location.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the Posture name does not
     * exist. In case revision_id is not provided then the latest Posture revision
     * by UpdateTime is returned.
     * </pre>
     */
    public void getPosture(com.google.cloud.securityposture.v1.GetPostureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.Posture> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Posture resource.
     * If a Posture with the specified name already exists in the specified
     * organization and location, the long running operation returns a
     * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public void createPosture(com.google.cloud.securityposture.v1.CreatePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePostureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing Posture.
     * A new revision of the posture will be created if the revision to be
     * updated is currently deployed on a workload.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * Posture does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the Posture.
     * Updatable fields are state, description and policy_sets.
     * State update operation cannot be clubbed with update of description and
     * policy_sets.
     * An ACTIVE posture can be updated to both DRAFT or DEPRECATED states.
     * Postures in DRAFT or DEPRECATED states can only be updated to ACTIVE state.
     * </pre>
     */
    public void updatePosture(com.google.cloud.securityposture.v1.UpdatePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePostureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes all the revisions of a resource.
     * A posture can only be deleted when none of the revisions are deployed to
     * any workload.
     * </pre>
     */
    public void deletePosture(com.google.cloud.securityposture.v1.DeletePostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePostureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Extracts existing policies on a workload as a posture.
     * If a Posture on the given workload already exists, the long running
     * operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public void extractPosture(com.google.cloud.securityposture.v1.ExtractPostureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExtractPostureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PostureDeployments
     * Lists PostureDeployments in a given project and location.
     * </pre>
     */
    public void listPostureDeployments(com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPostureDeploymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single PostureDeployment.
     * </pre>
     */
    public void getPostureDeployment(com.google.cloud.securityposture.v1.GetPostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureDeployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostureDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new PostureDeployment in a given project and location.
     * </pre>
     */
    public void createPostureDeployment(com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePostureDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single PostureDeployment.
     * </pre>
     */
    public void updatePostureDeployment(com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePostureDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single PostureDeployment.
     * </pre>
     */
    public void deletePostureDeployment(com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePostureDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * PostureTemplates
     * Lists all the PostureTemplates available to the user.
     * </pre>
     */
    public void listPostureTemplates(com.google.cloud.securityposture.v1.ListPostureTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPostureTemplatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a PostureTemplate.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the PostureTemplate name
     * does not exist. In case revision_id is not provided then the
     * PostureTemplate with latest revision_id is returned.
     * </pre>
     */
    public void getPostureTemplate(com.google.cloud.securityposture.v1.GetPostureTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureTemplate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostureTemplateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SecurityPosture.
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class SecurityPostureBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SecurityPostureBlockingStub> {
    private SecurityPostureBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityPostureBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityPostureBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * (-- This option restricts the visibility of the API to only projects that
     * will
     * (-- be labeled as `PREVIEW` or `GOOGLE_INTERNAL` by the service.
     * (-- option (google.api.api_visibility).restriction =
     * "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in a given organization
     * and location. In case a posture has multiple revisions, the latest revision
     * as per UpdateTime will be returned.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.ListPosturesResponse listPostures(com.google.cloud.securityposture.v1.ListPosturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPosturesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists revisions of a Posture in a given organization and location.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.ListPostureRevisionsResponse listPostureRevisions(com.google.cloud.securityposture.v1.ListPostureRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPostureRevisionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a posture in a given organization and location.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the Posture name does not
     * exist. In case revision_id is not provided then the latest Posture revision
     * by UpdateTime is returned.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.Posture getPosture(com.google.cloud.securityposture.v1.GetPostureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Posture resource.
     * If a Posture with the specified name already exists in the specified
     * organization and location, the long running operation returns a
     * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.longrunning.Operation createPosture(com.google.cloud.securityposture.v1.CreatePostureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePostureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing Posture.
     * A new revision of the posture will be created if the revision to be
     * updated is currently deployed on a workload.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * Posture does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the Posture.
     * Updatable fields are state, description and policy_sets.
     * State update operation cannot be clubbed with update of description and
     * policy_sets.
     * An ACTIVE posture can be updated to both DRAFT or DEPRECATED states.
     * Postures in DRAFT or DEPRECATED states can only be updated to ACTIVE state.
     * </pre>
     */
    public com.google.longrunning.Operation updatePosture(com.google.cloud.securityposture.v1.UpdatePostureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePostureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes all the revisions of a resource.
     * A posture can only be deleted when none of the revisions are deployed to
     * any workload.
     * </pre>
     */
    public com.google.longrunning.Operation deletePosture(com.google.cloud.securityposture.v1.DeletePostureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePostureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extracts existing policies on a workload as a posture.
     * If a Posture on the given workload already exists, the long running
     * operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.longrunning.Operation extractPosture(com.google.cloud.securityposture.v1.ExtractPostureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtractPostureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PostureDeployments
     * Lists PostureDeployments in a given project and location.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse listPostureDeployments(com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPostureDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single PostureDeployment.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.PostureDeployment getPostureDeployment(com.google.cloud.securityposture.v1.GetPostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostureDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new PostureDeployment in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createPostureDeployment(com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePostureDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single PostureDeployment.
     * </pre>
     */
    public com.google.longrunning.Operation updatePostureDeployment(com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePostureDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single PostureDeployment.
     * </pre>
     */
    public com.google.longrunning.Operation deletePostureDeployment(com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePostureDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * PostureTemplates
     * Lists all the PostureTemplates available to the user.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.ListPostureTemplatesResponse listPostureTemplates(com.google.cloud.securityposture.v1.ListPostureTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPostureTemplatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a PostureTemplate.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the PostureTemplate name
     * does not exist. In case revision_id is not provided then the
     * PostureTemplate with latest revision_id is returned.
     * </pre>
     */
    public com.google.cloud.securityposture.v1.PostureTemplate getPostureTemplate(com.google.cloud.securityposture.v1.GetPostureTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostureTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SecurityPosture.
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class SecurityPostureFutureStub
      extends io.grpc.stub.AbstractFutureStub<SecurityPostureFutureStub> {
    private SecurityPostureFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityPostureFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityPostureFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * (-- This option restricts the visibility of the API to only projects that
     * will
     * (-- be labeled as `PREVIEW` or `GOOGLE_INTERNAL` by the service.
     * (-- option (google.api.api_visibility).restriction =
     * "PREVIEW,GOOGLE_INTERNAL"; Postures Lists Postures in a given organization
     * and location. In case a posture has multiple revisions, the latest revision
     * as per UpdateTime will be returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.ListPosturesResponse> listPostures(
        com.google.cloud.securityposture.v1.ListPosturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPosturesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists revisions of a Posture in a given organization and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.ListPostureRevisionsResponse> listPostureRevisions(
        com.google.cloud.securityposture.v1.ListPostureRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPostureRevisionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a posture in a given organization and location.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the Posture name does not
     * exist. In case revision_id is not provided then the latest Posture revision
     * by UpdateTime is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.Posture> getPosture(
        com.google.cloud.securityposture.v1.GetPostureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Posture resource.
     * If a Posture with the specified name already exists in the specified
     * organization and location, the long running operation returns a
     * [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createPosture(
        com.google.cloud.securityposture.v1.CreatePostureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePostureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing Posture.
     * A new revision of the posture will be created if the revision to be
     * updated is currently deployed on a workload.
     * Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the
     * Posture does not exist.
     * Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag
     * supplied in the request does not match the persisted etag of the Posture.
     * Updatable fields are state, description and policy_sets.
     * State update operation cannot be clubbed with update of description and
     * policy_sets.
     * An ACTIVE posture can be updated to both DRAFT or DEPRECATED states.
     * Postures in DRAFT or DEPRECATED states can only be updated to ACTIVE state.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updatePosture(
        com.google.cloud.securityposture.v1.UpdatePostureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePostureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes all the revisions of a resource.
     * A posture can only be deleted when none of the revisions are deployed to
     * any workload.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deletePosture(
        com.google.cloud.securityposture.v1.DeletePostureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePostureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Extracts existing policies on a workload as a posture.
     * If a Posture on the given workload already exists, the long running
     * operation returns a [ALREADY_EXISTS][google.rpc.Code.ALREADY_EXISTS] error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> extractPosture(
        com.google.cloud.securityposture.v1.ExtractPostureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExtractPostureMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PostureDeployments
     * Lists PostureDeployments in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse> listPostureDeployments(
        com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPostureDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single PostureDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.PostureDeployment> getPostureDeployment(
        com.google.cloud.securityposture.v1.GetPostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostureDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new PostureDeployment in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createPostureDeployment(
        com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePostureDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single PostureDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updatePostureDeployment(
        com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePostureDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single PostureDeployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deletePostureDeployment(
        com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePostureDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * PostureTemplates
     * Lists all the PostureTemplates available to the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.ListPostureTemplatesResponse> listPostureTemplates(
        com.google.cloud.securityposture.v1.ListPostureTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPostureTemplatesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a PostureTemplate.
     * User must provide revision_id to retrieve a specific revision of the
     * resource.
     * NOT_FOUND error is returned if the revision_id or the PostureTemplate name
     * does not exist. In case revision_id is not provided then the
     * PostureTemplate with latest revision_id is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securityposture.v1.PostureTemplate> getPostureTemplate(
        com.google.cloud.securityposture.v1.GetPostureTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostureTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_POSTURES = 0;
  private static final int METHODID_LIST_POSTURE_REVISIONS = 1;
  private static final int METHODID_GET_POSTURE = 2;
  private static final int METHODID_CREATE_POSTURE = 3;
  private static final int METHODID_UPDATE_POSTURE = 4;
  private static final int METHODID_DELETE_POSTURE = 5;
  private static final int METHODID_EXTRACT_POSTURE = 6;
  private static final int METHODID_LIST_POSTURE_DEPLOYMENTS = 7;
  private static final int METHODID_GET_POSTURE_DEPLOYMENT = 8;
  private static final int METHODID_CREATE_POSTURE_DEPLOYMENT = 9;
  private static final int METHODID_UPDATE_POSTURE_DEPLOYMENT = 10;
  private static final int METHODID_DELETE_POSTURE_DEPLOYMENT = 11;
  private static final int METHODID_LIST_POSTURE_TEMPLATES = 12;
  private static final int METHODID_GET_POSTURE_TEMPLATE = 13;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_POSTURES:
          serviceImpl.listPostures((com.google.cloud.securityposture.v1.ListPosturesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPosturesResponse>) responseObserver);
          break;
        case METHODID_LIST_POSTURE_REVISIONS:
          serviceImpl.listPostureRevisions((com.google.cloud.securityposture.v1.ListPostureRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureRevisionsResponse>) responseObserver);
          break;
        case METHODID_GET_POSTURE:
          serviceImpl.getPosture((com.google.cloud.securityposture.v1.GetPostureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.Posture>) responseObserver);
          break;
        case METHODID_CREATE_POSTURE:
          serviceImpl.createPosture((com.google.cloud.securityposture.v1.CreatePostureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_POSTURE:
          serviceImpl.updatePosture((com.google.cloud.securityposture.v1.UpdatePostureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_POSTURE:
          serviceImpl.deletePosture((com.google.cloud.securityposture.v1.DeletePostureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXTRACT_POSTURE:
          serviceImpl.extractPosture((com.google.cloud.securityposture.v1.ExtractPostureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_POSTURE_DEPLOYMENTS:
          serviceImpl.listPostureDeployments((com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse>) responseObserver);
          break;
        case METHODID_GET_POSTURE_DEPLOYMENT:
          serviceImpl.getPostureDeployment((com.google.cloud.securityposture.v1.GetPostureDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureDeployment>) responseObserver);
          break;
        case METHODID_CREATE_POSTURE_DEPLOYMENT:
          serviceImpl.createPostureDeployment((com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_POSTURE_DEPLOYMENT:
          serviceImpl.updatePostureDeployment((com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_POSTURE_DEPLOYMENT:
          serviceImpl.deletePostureDeployment((com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_POSTURE_TEMPLATES:
          serviceImpl.listPostureTemplates((com.google.cloud.securityposture.v1.ListPostureTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.ListPostureTemplatesResponse>) responseObserver);
          break;
        case METHODID_GET_POSTURE_TEMPLATE:
          serviceImpl.getPostureTemplate((com.google.cloud.securityposture.v1.GetPostureTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securityposture.v1.PostureTemplate>) responseObserver);
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
          getListPosturesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.ListPosturesRequest,
              com.google.cloud.securityposture.v1.ListPosturesResponse>(
                service, METHODID_LIST_POSTURES)))
        .addMethod(
          getListPostureRevisionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.ListPostureRevisionsRequest,
              com.google.cloud.securityposture.v1.ListPostureRevisionsResponse>(
                service, METHODID_LIST_POSTURE_REVISIONS)))
        .addMethod(
          getGetPostureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.GetPostureRequest,
              com.google.cloud.securityposture.v1.Posture>(
                service, METHODID_GET_POSTURE)))
        .addMethod(
          getCreatePostureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.CreatePostureRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_POSTURE)))
        .addMethod(
          getUpdatePostureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.UpdatePostureRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_POSTURE)))
        .addMethod(
          getDeletePostureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.DeletePostureRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_POSTURE)))
        .addMethod(
          getExtractPostureMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.ExtractPostureRequest,
              com.google.longrunning.Operation>(
                service, METHODID_EXTRACT_POSTURE)))
        .addMethod(
          getListPostureDeploymentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.ListPostureDeploymentsRequest,
              com.google.cloud.securityposture.v1.ListPostureDeploymentsResponse>(
                service, METHODID_LIST_POSTURE_DEPLOYMENTS)))
        .addMethod(
          getGetPostureDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.GetPostureDeploymentRequest,
              com.google.cloud.securityposture.v1.PostureDeployment>(
                service, METHODID_GET_POSTURE_DEPLOYMENT)))
        .addMethod(
          getCreatePostureDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.CreatePostureDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_POSTURE_DEPLOYMENT)))
        .addMethod(
          getUpdatePostureDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.UpdatePostureDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_POSTURE_DEPLOYMENT)))
        .addMethod(
          getDeletePostureDeploymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.DeletePostureDeploymentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_POSTURE_DEPLOYMENT)))
        .addMethod(
          getListPostureTemplatesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.ListPostureTemplatesRequest,
              com.google.cloud.securityposture.v1.ListPostureTemplatesResponse>(
                service, METHODID_LIST_POSTURE_TEMPLATES)))
        .addMethod(
          getGetPostureTemplateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.securityposture.v1.GetPostureTemplateRequest,
              com.google.cloud.securityposture.v1.PostureTemplate>(
                service, METHODID_GET_POSTURE_TEMPLATE)))
        .build();
  }

  private static abstract class SecurityPostureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityPostureBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securityposture.v1.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityPosture");
    }
  }

  private static final class SecurityPostureFileDescriptorSupplier
      extends SecurityPostureBaseDescriptorSupplier {
    SecurityPostureFileDescriptorSupplier() {}
  }

  private static final class SecurityPostureMethodDescriptorSupplier
      extends SecurityPostureBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SecurityPostureMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SecurityPostureGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecurityPostureFileDescriptorSupplier())
              .addMethod(getListPosturesMethod())
              .addMethod(getListPostureRevisionsMethod())
              .addMethod(getGetPostureMethod())
              .addMethod(getCreatePostureMethod())
              .addMethod(getUpdatePostureMethod())
              .addMethod(getDeletePostureMethod())
              .addMethod(getExtractPostureMethod())
              .addMethod(getListPostureDeploymentsMethod())
              .addMethod(getGetPostureDeploymentMethod())
              .addMethod(getCreatePostureDeploymentMethod())
              .addMethod(getUpdatePostureDeploymentMethod())
              .addMethod(getDeletePostureDeploymentMethod())
              .addMethod(getListPostureTemplatesMethod())
              .addMethod(getGetPostureTemplateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
