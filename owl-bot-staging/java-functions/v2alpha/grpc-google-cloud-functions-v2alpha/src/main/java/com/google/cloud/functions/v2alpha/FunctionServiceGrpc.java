package com.google.cloud.functions.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Google Cloud Functions is used to deploy functions that are executed by
 * Google in response to various events. Data connected with that event is
 * passed to a function as the input data.
 * A **function** is a resource which describes a function that should be
 * executed and how it is triggered.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/functions/v2alpha/functions.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FunctionServiceGrpc {

  private FunctionServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.functions.v2alpha.FunctionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GetFunctionRequest,
      com.google.cloud.functions.v2alpha.Function> getGetFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFunction",
      requestType = com.google.cloud.functions.v2alpha.GetFunctionRequest.class,
      responseType = com.google.cloud.functions.v2alpha.Function.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GetFunctionRequest,
      com.google.cloud.functions.v2alpha.Function> getGetFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GetFunctionRequest, com.google.cloud.functions.v2alpha.Function> getGetFunctionMethod;
    if ((getGetFunctionMethod = FunctionServiceGrpc.getGetFunctionMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getGetFunctionMethod = FunctionServiceGrpc.getGetFunctionMethod) == null) {
          FunctionServiceGrpc.getGetFunctionMethod = getGetFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.GetFunctionRequest, com.google.cloud.functions.v2alpha.Function>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.GetFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.Function.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("GetFunction"))
              .build();
        }
      }
    }
    return getGetFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListFunctionsRequest,
      com.google.cloud.functions.v2alpha.ListFunctionsResponse> getListFunctionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFunctions",
      requestType = com.google.cloud.functions.v2alpha.ListFunctionsRequest.class,
      responseType = com.google.cloud.functions.v2alpha.ListFunctionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListFunctionsRequest,
      com.google.cloud.functions.v2alpha.ListFunctionsResponse> getListFunctionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListFunctionsRequest, com.google.cloud.functions.v2alpha.ListFunctionsResponse> getListFunctionsMethod;
    if ((getListFunctionsMethod = FunctionServiceGrpc.getListFunctionsMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getListFunctionsMethod = FunctionServiceGrpc.getListFunctionsMethod) == null) {
          FunctionServiceGrpc.getListFunctionsMethod = getListFunctionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.ListFunctionsRequest, com.google.cloud.functions.v2alpha.ListFunctionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFunctions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.ListFunctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.ListFunctionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("ListFunctions"))
              .build();
        }
      }
    }
    return getListFunctionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.CreateFunctionRequest,
      com.google.longrunning.Operation> getCreateFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFunction",
      requestType = com.google.cloud.functions.v2alpha.CreateFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.CreateFunctionRequest,
      com.google.longrunning.Operation> getCreateFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.CreateFunctionRequest, com.google.longrunning.Operation> getCreateFunctionMethod;
    if ((getCreateFunctionMethod = FunctionServiceGrpc.getCreateFunctionMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getCreateFunctionMethod = FunctionServiceGrpc.getCreateFunctionMethod) == null) {
          FunctionServiceGrpc.getCreateFunctionMethod = getCreateFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.CreateFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.CreateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("CreateFunction"))
              .build();
        }
      }
    }
    return getCreateFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.UpdateFunctionRequest,
      com.google.longrunning.Operation> getUpdateFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFunction",
      requestType = com.google.cloud.functions.v2alpha.UpdateFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.UpdateFunctionRequest,
      com.google.longrunning.Operation> getUpdateFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.UpdateFunctionRequest, com.google.longrunning.Operation> getUpdateFunctionMethod;
    if ((getUpdateFunctionMethod = FunctionServiceGrpc.getUpdateFunctionMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getUpdateFunctionMethod = FunctionServiceGrpc.getUpdateFunctionMethod) == null) {
          FunctionServiceGrpc.getUpdateFunctionMethod = getUpdateFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.UpdateFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.UpdateFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("UpdateFunction"))
              .build();
        }
      }
    }
    return getUpdateFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.DeleteFunctionRequest,
      com.google.longrunning.Operation> getDeleteFunctionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFunction",
      requestType = com.google.cloud.functions.v2alpha.DeleteFunctionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.DeleteFunctionRequest,
      com.google.longrunning.Operation> getDeleteFunctionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.DeleteFunctionRequest, com.google.longrunning.Operation> getDeleteFunctionMethod;
    if ((getDeleteFunctionMethod = FunctionServiceGrpc.getDeleteFunctionMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getDeleteFunctionMethod = FunctionServiceGrpc.getDeleteFunctionMethod) == null) {
          FunctionServiceGrpc.getDeleteFunctionMethod = getDeleteFunctionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.DeleteFunctionRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFunction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.DeleteFunctionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("DeleteFunction"))
              .build();
        }
      }
    }
    return getDeleteFunctionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest,
      com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> getGenerateUploadUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateUploadUrl",
      requestType = com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest.class,
      responseType = com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest,
      com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> getGenerateUploadUrlMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest, com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> getGenerateUploadUrlMethod;
    if ((getGenerateUploadUrlMethod = FunctionServiceGrpc.getGenerateUploadUrlMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getGenerateUploadUrlMethod = FunctionServiceGrpc.getGenerateUploadUrlMethod) == null) {
          FunctionServiceGrpc.getGenerateUploadUrlMethod = getGenerateUploadUrlMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest, com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateUploadUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("GenerateUploadUrl"))
              .build();
        }
      }
    }
    return getGenerateUploadUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest,
      com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateDownloadUrl",
      requestType = com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest.class,
      responseType = com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest,
      com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest, com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> getGenerateDownloadUrlMethod;
    if ((getGenerateDownloadUrlMethod = FunctionServiceGrpc.getGenerateDownloadUrlMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getGenerateDownloadUrlMethod = FunctionServiceGrpc.getGenerateDownloadUrlMethod) == null) {
          FunctionServiceGrpc.getGenerateDownloadUrlMethod = getGenerateDownloadUrlMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest, com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateDownloadUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("GenerateDownloadUrl"))
              .build();
        }
      }
    }
    return getGenerateDownloadUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListRuntimesRequest,
      com.google.cloud.functions.v2alpha.ListRuntimesResponse> getListRuntimesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuntimes",
      requestType = com.google.cloud.functions.v2alpha.ListRuntimesRequest.class,
      responseType = com.google.cloud.functions.v2alpha.ListRuntimesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListRuntimesRequest,
      com.google.cloud.functions.v2alpha.ListRuntimesResponse> getListRuntimesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.functions.v2alpha.ListRuntimesRequest, com.google.cloud.functions.v2alpha.ListRuntimesResponse> getListRuntimesMethod;
    if ((getListRuntimesMethod = FunctionServiceGrpc.getListRuntimesMethod) == null) {
      synchronized (FunctionServiceGrpc.class) {
        if ((getListRuntimesMethod = FunctionServiceGrpc.getListRuntimesMethod) == null) {
          FunctionServiceGrpc.getListRuntimesMethod = getListRuntimesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.functions.v2alpha.ListRuntimesRequest, com.google.cloud.functions.v2alpha.ListRuntimesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRuntimes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.ListRuntimesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.functions.v2alpha.ListRuntimesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FunctionServiceMethodDescriptorSupplier("ListRuntimes"))
              .build();
        }
      }
    }
    return getListRuntimesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FunctionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FunctionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FunctionServiceStub>() {
        @java.lang.Override
        public FunctionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FunctionServiceStub(channel, callOptions);
        }
      };
    return FunctionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FunctionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FunctionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FunctionServiceBlockingStub>() {
        @java.lang.Override
        public FunctionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FunctionServiceBlockingStub(channel, callOptions);
        }
      };
    return FunctionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FunctionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FunctionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FunctionServiceFutureStub>() {
        @java.lang.Override
        public FunctionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FunctionServiceFutureStub(channel, callOptions);
        }
      };
    return FunctionServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Google Cloud Functions is used to deploy functions that are executed by
   * Google in response to various events. Data connected with that event is
   * passed to a function as the input data.
   * A **function** is a resource which describes a function that should be
   * executed and how it is triggered.
   * </pre>
   */
  public static abstract class FunctionServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public void getFunction(com.google.cloud.functions.v2alpha.GetFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.Function> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public void listFunctions(com.google.cloud.functions.v2alpha.ListFunctionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListFunctionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFunctionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public void createFunction(com.google.cloud.functions.v2alpha.CreateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFunctionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public void updateFunction(com.google.cloud.functions.v2alpha.UpdateFunctionRequest request,
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
    public void deleteFunction(com.google.cloud.functions.v2alpha.DeleteFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFunctionMethod(), responseObserver);
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
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public void generateUploadUrl(com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateUploadUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * 30 minutes of generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public void generateDownloadUrl(com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateDownloadUrlMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns a list of runtimes that are supported for the requested project.
     * </pre>
     */
    public void listRuntimes(com.google.cloud.functions.v2alpha.ListRuntimesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListRuntimesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRuntimesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.GetFunctionRequest,
                com.google.cloud.functions.v2alpha.Function>(
                  this, METHODID_GET_FUNCTION)))
          .addMethod(
            getListFunctionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.ListFunctionsRequest,
                com.google.cloud.functions.v2alpha.ListFunctionsResponse>(
                  this, METHODID_LIST_FUNCTIONS)))
          .addMethod(
            getCreateFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.CreateFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_FUNCTION)))
          .addMethod(
            getUpdateFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.UpdateFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_FUNCTION)))
          .addMethod(
            getDeleteFunctionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.DeleteFunctionRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_FUNCTION)))
          .addMethod(
            getGenerateUploadUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest,
                com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse>(
                  this, METHODID_GENERATE_UPLOAD_URL)))
          .addMethod(
            getGenerateDownloadUrlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest,
                com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse>(
                  this, METHODID_GENERATE_DOWNLOAD_URL)))
          .addMethod(
            getListRuntimesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.functions.v2alpha.ListRuntimesRequest,
                com.google.cloud.functions.v2alpha.ListRuntimesResponse>(
                  this, METHODID_LIST_RUNTIMES)))
          .build();
    }
  }

  /**
   * <pre>
   * Google Cloud Functions is used to deploy functions that are executed by
   * Google in response to various events. Data connected with that event is
   * passed to a function as the input data.
   * A **function** is a resource which describes a function that should be
   * executed and how it is triggered.
   * </pre>
   */
  public static final class FunctionServiceStub extends io.grpc.stub.AbstractAsyncStub<FunctionServiceStub> {
    private FunctionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FunctionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FunctionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public void getFunction(com.google.cloud.functions.v2alpha.GetFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.Function> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public void listFunctions(com.google.cloud.functions.v2alpha.ListFunctionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListFunctionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFunctionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public void createFunction(com.google.cloud.functions.v2alpha.CreateFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFunctionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public void updateFunction(com.google.cloud.functions.v2alpha.UpdateFunctionRequest request,
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
    public void deleteFunction(com.google.cloud.functions.v2alpha.DeleteFunctionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFunctionMethod(), getCallOptions()), request, responseObserver);
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
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public void generateUploadUrl(com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateUploadUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * 30 minutes of generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public void generateDownloadUrl(com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateDownloadUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns a list of runtimes that are supported for the requested project.
     * </pre>
     */
    public void listRuntimes(com.google.cloud.functions.v2alpha.ListRuntimesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListRuntimesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuntimesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google Cloud Functions is used to deploy functions that are executed by
   * Google in response to various events. Data connected with that event is
   * passed to a function as the input data.
   * A **function** is a resource which describes a function that should be
   * executed and how it is triggered.
   * </pre>
   */
  public static final class FunctionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FunctionServiceBlockingStub> {
    private FunctionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FunctionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FunctionServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public com.google.cloud.functions.v2alpha.Function getFunction(com.google.cloud.functions.v2alpha.GetFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public com.google.cloud.functions.v2alpha.ListFunctionsResponse listFunctions(com.google.cloud.functions.v2alpha.ListFunctionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFunctionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public com.google.longrunning.Operation createFunction(com.google.cloud.functions.v2alpha.CreateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFunctionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public com.google.longrunning.Operation updateFunction(com.google.cloud.functions.v2alpha.UpdateFunctionRequest request) {
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
    public com.google.longrunning.Operation deleteFunction(com.google.cloud.functions.v2alpha.DeleteFunctionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFunctionMethod(), getCallOptions(), request);
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
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse generateUploadUrl(com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateUploadUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * 30 minutes of generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse generateDownloadUrl(com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateDownloadUrlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns a list of runtimes that are supported for the requested project.
     * </pre>
     */
    public com.google.cloud.functions.v2alpha.ListRuntimesResponse listRuntimes(com.google.cloud.functions.v2alpha.ListRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuntimesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google Cloud Functions is used to deploy functions that are executed by
   * Google in response to various events. Data connected with that event is
   * passed to a function as the input data.
   * A **function** is a resource which describes a function that should be
   * executed and how it is triggered.
   * </pre>
   */
  public static final class FunctionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FunctionServiceFutureStub> {
    private FunctionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FunctionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FunctionServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns a function with the given name from the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v2alpha.Function> getFunction(
        com.google.cloud.functions.v2alpha.GetFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of functions that belong to the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v2alpha.ListFunctionsResponse> listFunctions(
        com.google.cloud.functions.v2alpha.ListFunctionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFunctionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new function. If a function with the given name already exists in
     * the specified project, the long running operation will return
     * `ALREADY_EXISTS` error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFunction(
        com.google.cloud.functions.v2alpha.CreateFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFunctionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates existing function.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFunction(
        com.google.cloud.functions.v2alpha.UpdateFunctionRequest request) {
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
        com.google.cloud.functions.v2alpha.DeleteFunctionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFunctionMethod(), getCallOptions()), request);
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
     * * No credentials should be attached - the signed URLs provide access to the
     *   target bucket using internal service identity; if credentials were
     *   attached, the identity from the credentials would be used, but that
     *   identity does not have permissions to upload files to the URL.
     * When making a HTTP PUT request, these two headers need to be specified:
     * * `content-type: application/zip`
     * And this header SHOULD NOT be specified:
     * * `Authorization: Bearer YOUR_TOKEN`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse> generateUploadUrl(
        com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateUploadUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a signed URL for downloading deployed function source code.
     * The URL is only valid for a limited period and should be used within
     * 30 minutes of generation.
     * For more information about the signed URL usage see:
     * https://cloud.google.com/storage/docs/access-control/signed-urls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse> generateDownloadUrl(
        com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateDownloadUrlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns a list of runtimes that are supported for the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.functions.v2alpha.ListRuntimesResponse> listRuntimes(
        com.google.cloud.functions.v2alpha.ListRuntimesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuntimesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FUNCTION = 0;
  private static final int METHODID_LIST_FUNCTIONS = 1;
  private static final int METHODID_CREATE_FUNCTION = 2;
  private static final int METHODID_UPDATE_FUNCTION = 3;
  private static final int METHODID_DELETE_FUNCTION = 4;
  private static final int METHODID_GENERATE_UPLOAD_URL = 5;
  private static final int METHODID_GENERATE_DOWNLOAD_URL = 6;
  private static final int METHODID_LIST_RUNTIMES = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FunctionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FunctionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FUNCTION:
          serviceImpl.getFunction((com.google.cloud.functions.v2alpha.GetFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.Function>) responseObserver);
          break;
        case METHODID_LIST_FUNCTIONS:
          serviceImpl.listFunctions((com.google.cloud.functions.v2alpha.ListFunctionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListFunctionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_FUNCTION:
          serviceImpl.createFunction((com.google.cloud.functions.v2alpha.CreateFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FUNCTION:
          serviceImpl.updateFunction((com.google.cloud.functions.v2alpha.UpdateFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FUNCTION:
          serviceImpl.deleteFunction((com.google.cloud.functions.v2alpha.DeleteFunctionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_UPLOAD_URL:
          serviceImpl.generateUploadUrl((com.google.cloud.functions.v2alpha.GenerateUploadUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateUploadUrlResponse>) responseObserver);
          break;
        case METHODID_GENERATE_DOWNLOAD_URL:
          serviceImpl.generateDownloadUrl((com.google.cloud.functions.v2alpha.GenerateDownloadUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.GenerateDownloadUrlResponse>) responseObserver);
          break;
        case METHODID_LIST_RUNTIMES:
          serviceImpl.listRuntimes((com.google.cloud.functions.v2alpha.ListRuntimesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.functions.v2alpha.ListRuntimesResponse>) responseObserver);
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

  private static abstract class FunctionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FunctionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.functions.v2alpha.FunctionsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FunctionService");
    }
  }

  private static final class FunctionServiceFileDescriptorSupplier
      extends FunctionServiceBaseDescriptorSupplier {
    FunctionServiceFileDescriptorSupplier() {}
  }

  private static final class FunctionServiceMethodDescriptorSupplier
      extends FunctionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FunctionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FunctionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FunctionServiceFileDescriptorSupplier())
              .addMethod(getGetFunctionMethod())
              .addMethod(getListFunctionsMethod())
              .addMethod(getCreateFunctionMethod())
              .addMethod(getUpdateFunctionMethod())
              .addMethod(getDeleteFunctionMethod())
              .addMethod(getGenerateUploadUrlMethod())
              .addMethod(getGenerateDownloadUrlMethod())
              .addMethod(getListRuntimesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
