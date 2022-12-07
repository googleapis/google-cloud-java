package com.google.cloud.functions.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service that application uses to manipulate triggers and functions.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/functions/v1/functions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudFunctionsServiceGrpc {

  private CloudFunctionsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.functions.v1.CloudFunctionsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.ListFunctionsRequest,
      com.google.cloud.functions.v1.ListFunctionsResponse> getListFunctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFunctions",
      requestType = com.google.cloud.functions.v1.ListFunctionsRequest.class,
      responseType = com.google.cloud.functions.v1.ListFunctionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.ListFunctionsRequest,
      com.google.cloud.functions.v1.ListFunctionsResponse> getListFunctionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.ListFunctionsRequest, com.google.cloud.functions.v1.ListFunctionsResponse> getListFunctionsMethod;
    if ((getListFunctionsMethod = CloudFunctionsServiceGrpc.getListFunctionsMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getListFunctionsMethod = CloudFunctionsServiceGrpc.getListFunctionsMethod) == null) {
          CloudFunctionsServiceGrpc.getListFunctionsMethod = getListFunctionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.ListFunctionsRequest, com.google.cloud.functions.v1.ListFunctionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFunctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.ListFunctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.ListFunctionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("ListFunctions"))
              .build();
        }
      }
    }
    return getListFunctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GetFunctionRequest,
      com.google.cloud.functions.v1.CloudFunction> getGetFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFunction",
      requestType = com.google.cloud.functions.v1.GetFunctionRequest.class,
      responseType = com.google.cloud.functions.v1.CloudFunction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GetFunctionRequest,
      com.google.cloud.functions.v1.CloudFunction> getGetFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GetFunctionRequest, com.google.cloud.functions.v1.CloudFunction> getGetFunctionMethod;
    if ((getGetFunctionMethod = CloudFunctionsServiceGrpc.getGetFunctionMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getGetFunctionMethod = CloudFunctionsServiceGrpc.getGetFunctionMethod) == null) {
          CloudFunctionsServiceGrpc.getGetFunctionMethod = getGetFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.GetFunctionRequest, com.google.cloud.functions.v1.CloudFunction>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.GetFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.CloudFunction.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("GetFunction"))
              .build();
        }
      }
    }
    return getGetFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CreateFunctionRequest,
      com.google.longrunning.Operation> getCreateFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFunction",
      requestType = com.google.cloud.functions.v1.CreateFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CreateFunctionRequest,
      com.google.longrunning.Operation> getCreateFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CreateFunctionRequest, com.google.longrunning.Operation> getCreateFunctionMethod;
    if ((getCreateFunctionMethod = CloudFunctionsServiceGrpc.getCreateFunctionMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getCreateFunctionMethod = CloudFunctionsServiceGrpc.getCreateFunctionMethod) == null) {
          CloudFunctionsServiceGrpc.getCreateFunctionMethod = getCreateFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.CreateFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.CreateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("CreateFunction"))
              .build();
        }
      }
    }
    return getCreateFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.UpdateFunctionRequest,
      com.google.longrunning.Operation> getUpdateFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFunction",
      requestType = com.google.cloud.functions.v1.UpdateFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.UpdateFunctionRequest,
      com.google.longrunning.Operation> getUpdateFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.UpdateFunctionRequest, com.google.longrunning.Operation> getUpdateFunctionMethod;
    if ((getUpdateFunctionMethod = CloudFunctionsServiceGrpc.getUpdateFunctionMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getUpdateFunctionMethod = CloudFunctionsServiceGrpc.getUpdateFunctionMethod) == null) {
          CloudFunctionsServiceGrpc.getUpdateFunctionMethod = getUpdateFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.UpdateFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.UpdateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("UpdateFunction"))
              .build();
        }
      }
    }
    return getUpdateFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.DeleteFunctionRequest,
      com.google.longrunning.Operation> getDeleteFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFunction",
      requestType = com.google.cloud.functions.v1.DeleteFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.DeleteFunctionRequest,
      com.google.longrunning.Operation> getDeleteFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.DeleteFunctionRequest, com.google.longrunning.Operation> getDeleteFunctionMethod;
    if ((getDeleteFunctionMethod = CloudFunctionsServiceGrpc.getDeleteFunctionMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getDeleteFunctionMethod = CloudFunctionsServiceGrpc.getDeleteFunctionMethod) == null) {
          CloudFunctionsServiceGrpc.getDeleteFunctionMethod = getDeleteFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.DeleteFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.DeleteFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("DeleteFunction"))
              .build();
        }
      }
    }
    return getDeleteFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CallFunctionRequest,
      com.google.cloud.functions.v1.CallFunctionResponse> getCallFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CallFunction",
      requestType = com.google.cloud.functions.v1.CallFunctionRequest.class,
      responseType = com.google.cloud.functions.v1.CallFunctionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CallFunctionRequest,
      com.google.cloud.functions.v1.CallFunctionResponse> getCallFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.CallFunctionRequest, com.google.cloud.functions.v1.CallFunctionResponse> getCallFunctionMethod;
    if ((getCallFunctionMethod = CloudFunctionsServiceGrpc.getCallFunctionMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getCallFunctionMethod = CloudFunctionsServiceGrpc.getCallFunctionMethod) == null) {
          CloudFunctionsServiceGrpc.getCallFunctionMethod = getCallFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.CallFunctionRequest, com.google.cloud.functions.v1.CallFunctionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CallFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.CallFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.CallFunctionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("CallFunction"))
              .build();
        }
      }
    }
    return getCallFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateUploadUrlRequest,
      com.google.cloud.functions.v1.GenerateUploadUrlResponse> getGenerateUploadUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateUploadUrl",
      requestType = com.google.cloud.functions.v1.GenerateUploadUrlRequest.class,
      responseType = com.google.cloud.functions.v1.GenerateUploadUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateUploadUrlRequest,
      com.google.cloud.functions.v1.GenerateUploadUrlResponse> getGenerateUploadUrlMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateUploadUrlRequest, com.google.cloud.functions.v1.GenerateUploadUrlResponse> getGenerateUploadUrlMethod;
    if ((getGenerateUploadUrlMethod = CloudFunctionsServiceGrpc.getGenerateUploadUrlMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getGenerateUploadUrlMethod = CloudFunctionsServiceGrpc.getGenerateUploadUrlMethod) == null) {
          CloudFunctionsServiceGrpc.getGenerateUploadUrlMethod = getGenerateUploadUrlMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.GenerateUploadUrlRequest, com.google.cloud.functions.v1.GenerateUploadUrlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateUploadUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.GenerateUploadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.GenerateUploadUrlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("GenerateUploadUrl"))
              .build();
        }
      }
    }
    return getGenerateUploadUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateDownloadUrlRequest,
      com.google.cloud.functions.v1.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDownloadUrl",
      requestType = com.google.cloud.functions.v1.GenerateDownloadUrlRequest.class,
      responseType = com.google.cloud.functions.v1.GenerateDownloadUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateDownloadUrlRequest,
      com.google.cloud.functions.v1.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v1.GenerateDownloadUrlRequest, com.google.cloud.functions.v1.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod;
    if ((getGenerateDownloadUrlMethod = CloudFunctionsServiceGrpc.getGenerateDownloadUrlMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getGenerateDownloadUrlMethod = CloudFunctionsServiceGrpc.getGenerateDownloadUrlMethod) == null) {
          CloudFunctionsServiceGrpc.getGenerateDownloadUrlMethod = getGenerateDownloadUrlMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v1.GenerateDownloadUrlRequest, com.google.cloud.functions.v1.GenerateDownloadUrlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateDownloadUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.GenerateDownloadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v1.GenerateDownloadUrlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("GenerateDownloadUrl"))
              .build();
        }
      }
    }
    return getGenerateDownloadUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = CloudFunctionsServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getSetIamPolicyMethod = CloudFunctionsServiceGrpc.getSetIamPolicyMethod) == null) {
          CloudFunctionsServiceGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = CloudFunctionsServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getGetIamPolicyMethod = CloudFunctionsServiceGrpc.getGetIamPolicyMethod) == null) {
          CloudFunctionsServiceGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = CloudFunctionsServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (CloudFunctionsServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = CloudFunctionsServiceGrpc.getTestIamPermissionsMethod) == null) {
          CloudFunctionsServiceGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudFunctionsServiceMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudFunctionsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceStub>() {
        @java.lang.Override
        public CloudFunctionsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudFunctionsServiceStub(channel, callOptions);
        }
      };
    return CloudFunctionsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudFunctionsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceBlockingStub>() {
        @java.lang.Override
        public CloudFunctionsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudFunctionsServiceBlockingStub(channel, callOptions);
        }
      };
    return CloudFunctionsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudFunctionsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudFunctionsServiceFutureStub>() {
        @java.lang.Override
        public CloudFunctionsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudFunctionsServiceFutureStub(channel, callOptions);
        }
      };
    return CloudFunctionsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service that application uses to manipulate triggers and functions.
   * </pre>
   */
  public static abstract class CloudFunctionsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public void listFunctions(com.google.cloud.functions.v1.ListFunctionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.ListFunctionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFunctionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public void getFunction(com.google.cloud.functions.v1.GetFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CloudFunction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public void createFunction(com.google.cloud.functions.v1.CreateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public void updateFunction(com.google.cloud.functions.v1.UpdateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a function with the given name from the specified project. If the
     * given function is used by some trigger, the trigger will be updated to
     * remove this function.
     * </pre>
     */
    public void deleteFunction(com.google.cloud.functions.v1.DeleteFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Synchronously invokes a deployed Cloud Function. To be used for testing
     * purposes as very limited traffic is allowed. For more information on
     * the actual limits, refer to
     * [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits).
     * </pre>
     */
    public void callFunction(com.google.cloud.functions.v1.CallFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CallFunctionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCallFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for uploading a function source code.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls.
     * Once the function source code upload is complete, the used signed
     * URL should be provided in CreateFunction or UpdateFunction request
     * as a reference to the function source code.
     * When uploading source code to the generated signed URL, please follow
     * these restrictions:
     * * Source file type should be a zip file.
     * * Source file size should not exceed 100MB limit.
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * * `x-goog-content-length-range: 0,104857600`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public void generateUploadUrl(com.google.cloud.functions.v1.GenerateUploadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateUploadUrlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateUploadUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * minutes after generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public void generateDownloadUrl(com.google.cloud.functions.v1.GenerateDownloadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateDownloadUrlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateDownloadUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM access control policy on the specified function.
     * Replaces any existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM access control policy for a function.
     * Returns an empty policy if the function exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Tests the specified permissions against the IAM access control policy
     * for a function.
     * If the function does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListFunctionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.ListFunctionsRequest,
                com.google.cloud.functions.v1.ListFunctionsResponse>(
                  this, METHODID_LIST_FUNCTIONS)))
          .addMethod(
            getGetFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.GetFunctionRequest,
                com.google.cloud.functions.v1.CloudFunction>(
                  this, METHODID_GET_FUNCTION)))
          .addMethod(
            getCreateFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.CreateFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_FUNCTION)))
          .addMethod(
            getUpdateFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.UpdateFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_FUNCTION)))
          .addMethod(
            getDeleteFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.DeleteFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_FUNCTION)))
          .addMethod(
            getCallFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.CallFunctionRequest,
                com.google.cloud.functions.v1.CallFunctionResponse>(
                  this, METHODID_CALL_FUNCTION)))
          .addMethod(
            getGenerateUploadUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.GenerateUploadUrlRequest,
                com.google.cloud.functions.v1.GenerateUploadUrlResponse>(
                  this, METHODID_GENERATE_UPLOAD_URL)))
          .addMethod(
            getGenerateDownloadUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v1.GenerateDownloadUrlRequest,
                com.google.cloud.functions.v1.GenerateDownloadUrlResponse>(
                  this, METHODID_GENERATE_DOWNLOAD_URL)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * A service that application uses to manipulate triggers and functions.
   * </pre>
   */
  public static final class CloudFunctionsServiceStub extends io.grpc.stub.AbstractAsyncStub<CloudFunctionsServiceStub> {
    private CloudFunctionsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudFunctionsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudFunctionsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public void listFunctions(com.google.cloud.functions.v1.ListFunctionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.ListFunctionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFunctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public void getFunction(com.google.cloud.functions.v1.GetFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CloudFunction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public void createFunction(com.google.cloud.functions.v1.CreateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public void updateFunction(com.google.cloud.functions.v1.UpdateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a function with the given name from the specified project. If the
     * given function is used by some trigger, the trigger will be updated to
     * remove this function.
     * </pre>
     */
    public void deleteFunction(com.google.cloud.functions.v1.DeleteFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Synchronously invokes a deployed Cloud Function. To be used for testing
     * purposes as very limited traffic is allowed. For more information on
     * the actual limits, refer to
     * [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits).
     * </pre>
     */
    public void callFunction(com.google.cloud.functions.v1.CallFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CallFunctionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCallFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for uploading a function source code.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls.
     * Once the function source code upload is complete, the used signed
     * URL should be provided in CreateFunction or UpdateFunction request
     * as a reference to the function source code.
     * When uploading source code to the generated signed URL, please follow
     * these restrictions:
     * * Source file type should be a zip file.
     * * Source file size should not exceed 100MB limit.
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * * `x-goog-content-length-range: 0,104857600`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public void generateUploadUrl(com.google.cloud.functions.v1.GenerateUploadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateUploadUrlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateUploadUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * minutes after generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public void generateDownloadUrl(com.google.cloud.functions.v1.GenerateDownloadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateDownloadUrlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDownloadUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the IAM access control policy on the specified function.
     * Replaces any existing policy.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the IAM access control policy for a function.
     * Returns an empty policy if the function exists and does not have a policy
     * set.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Tests the specified permissions against the IAM access control policy
     * for a function.
     * If the function does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service that application uses to manipulate triggers and functions.
   * </pre>
   */
  public static final class CloudFunctionsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CloudFunctionsServiceBlockingStub> {
    private CloudFunctionsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudFunctionsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudFunctionsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public com.google.cloud.functions.v1.ListFunctionsResponse listFunctions(com.google.cloud.functions.v1.ListFunctionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFunctionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public com.google.cloud.functions.v1.CloudFunction getFunction(com.google.cloud.functions.v1.GetFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public com.google.longrunning.Operation createFunction(com.google.cloud.functions.v1.CreateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public com.google.longrunning.Operation updateFunction(com.google.cloud.functions.v1.UpdateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a function with the given name from the specified project. If the
     * given function is used by some trigger, the trigger will be updated to
     * remove this function.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFunction(com.google.cloud.functions.v1.DeleteFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Synchronously invokes a deployed Cloud Function. To be used for testing
     * purposes as very limited traffic is allowed. For more information on
     * the actual limits, refer to
     * [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits).
     * </pre>
     */
    public com.google.cloud.functions.v1.CallFunctionResponse callFunction(com.google.cloud.functions.v1.CallFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCallFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a signed URL for uploading a function source code.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls.
     * Once the function source code upload is complete, the used signed
     * URL should be provided in CreateFunction or UpdateFunction request
     * as a reference to the function source code.
     * When uploading source code to the generated signed URL, please follow
     * these restrictions:
     * * Source file type should be a zip file.
     * * Source file size should not exceed 100MB limit.
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * * `x-goog-content-length-range: 0,104857600`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public com.google.cloud.functions.v1.GenerateUploadUrlResponse generateUploadUrl(com.google.cloud.functions.v1.GenerateUploadUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateUploadUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * minutes after generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public com.google.cloud.functions.v1.GenerateDownloadUrlResponse generateDownloadUrl(com.google.cloud.functions.v1.GenerateDownloadUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDownloadUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the IAM access control policy on the specified function.
     * Replaces any existing policy.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the IAM access control policy for a function.
     * Returns an empty policy if the function exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Tests the specified permissions against the IAM access control policy
     * for a function.
     * If the function does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service that application uses to manipulate triggers and functions.
   * </pre>
   */
  public static final class CloudFunctionsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CloudFunctionsServiceFutureStub> {
    private CloudFunctionsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudFunctionsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudFunctionsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v1.ListFunctionsResponse> listFunctions(
        com.google.cloud.functions.v1.ListFunctionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFunctionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v1.CloudFunction> getFunction(
        com.google.cloud.functions.v1.GetFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFunction(
        com.google.cloud.functions.v1.CreateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFunction(
        com.google.cloud.functions.v1.UpdateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a function with the given name from the specified project. If the
     * given function is used by some trigger, the trigger will be updated to
     * remove this function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFunction(
        com.google.cloud.functions.v1.DeleteFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Synchronously invokes a deployed Cloud Function. To be used for testing
     * purposes as very limited traffic is allowed. For more information on
     * the actual limits, refer to
     * [Rate Limits](https://cloud.google.com/functions/quotas#rate_limits).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v1.CallFunctionResponse> callFunction(
        com.google.cloud.functions.v1.CallFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCallFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a signed URL for uploading a function source code.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls.
     * Once the function source code upload is complete, the used signed
     * URL should be provided in CreateFunction or UpdateFunction request
     * as a reference to the function source code.
     * When uploading source code to the generated signed URL, please follow
     * these restrictions:
     * * Source file type should be a zip file.
     * * Source file size should not exceed 100MB limit.
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * * `x-goog-content-length-range: 0,104857600`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v1.GenerateUploadUrlResponse> generateUploadUrl(
        com.google.cloud.functions.v1.GenerateUploadUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateUploadUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * minutes after generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v1.GenerateDownloadUrlResponse> generateDownloadUrl(
        com.google.cloud.functions.v1.GenerateDownloadUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDownloadUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the IAM access control policy on the specified function.
     * Replaces any existing policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the IAM access control policy for a function.
     * Returns an empty policy if the function exists and does not have a policy
     * set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Tests the specified permissions against the IAM access control policy
     * for a function.
     * If the function does not exist, this will return an empty set of
     * permissions, not a NOT_FOUND error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_FUNCTIONS = 0;
  private static final int METHODID_GET_FUNCTION = 1;
  private static final int METHODID_CREATE_FUNCTION = 2;
  private static final int METHODID_UPDATE_FUNCTION = 3;
  private static final int METHODID_DELETE_FUNCTION = 4;
  private static final int METHODID_CALL_FUNCTION = 5;
  private static final int METHODID_GENERATE_UPLOAD_URL = 6;
  private static final int METHODID_GENERATE_DOWNLOAD_URL = 7;
  private static final int METHODID_SET_IAM_POLICY = 8;
  private static final int METHODID_GET_IAM_POLICY = 9;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 10;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudFunctionsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudFunctionsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_FUNCTIONS:
          serviceImpl.listFunctions((com.google.cloud.functions.v1.ListFunctionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.ListFunctionsResponse>) responseObserver);
          break;
        case METHODID_GET_FUNCTION:
          serviceImpl.getFunction((com.google.cloud.functions.v1.GetFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CloudFunction>) responseObserver);
          break;
        case METHODID_CREATE_FUNCTION:
          serviceImpl.createFunction((com.google.cloud.functions.v1.CreateFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FUNCTION:
          serviceImpl.updateFunction((com.google.cloud.functions.v1.UpdateFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FUNCTION:
          serviceImpl.deleteFunction((com.google.cloud.functions.v1.DeleteFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CALL_FUNCTION:
          serviceImpl.callFunction((com.google.cloud.functions.v1.CallFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.CallFunctionResponse>) responseObserver);
          break;
        case METHODID_GENERATE_UPLOAD_URL:
          serviceImpl.generateUploadUrl((com.google.cloud.functions.v1.GenerateUploadUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateUploadUrlResponse>) responseObserver);
          break;
        case METHODID_GENERATE_DOWNLOAD_URL:
          serviceImpl.generateDownloadUrl((com.google.cloud.functions.v1.GenerateDownloadUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v1.GenerateDownloadUrlResponse>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
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

  private static abstract class CloudFunctionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudFunctionsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.functions.v1.FunctionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudFunctionsService");
    }
  }

  private static final class CloudFunctionsServiceFileDescriptorSupplier
      extends CloudFunctionsServiceBaseDescriptorSupplier {
    CloudFunctionsServiceFileDescriptorSupplier() {}
  }

  private static final class CloudFunctionsServiceMethodDescriptorSupplier
      extends CloudFunctionsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudFunctionsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudFunctionsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudFunctionsServiceFileDescriptorSupplier())
              .addMethod(getListFunctionsMethod())
              .addMethod(getGetFunctionMethod())
              .addMethod(getCreateFunctionMethod())
              .addMethod(getUpdateFunctionMethod())
              .addMethod(getDeleteFunctionMethod())
              .addMethod(getCallFunctionMethod())
              .addMethod(getGenerateUploadUrlMethod())
              .addMethod(getGenerateDownloadUrlMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
