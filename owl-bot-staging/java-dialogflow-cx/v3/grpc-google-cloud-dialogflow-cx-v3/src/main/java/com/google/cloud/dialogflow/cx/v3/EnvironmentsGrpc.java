package com.google.cloud.dialogflow.cx.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service for managing [Environments][google.cloud.dialogflow.cx.v3.Environment].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3/environment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnvironmentsGrpc {

  private EnvironmentsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3.Environments";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest,
      com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest,
      com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest, com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListEnvironmentsMethod = EnvironmentsGrpc.getListEnvironmentsMethod) == null) {
          EnvironmentsGrpc.getListEnvironmentsMethod = getListEnvironmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest, com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListEnvironments"))
              .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest,
      com.google.cloud.dialogflow.cx.v3.Environment> getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest,
      com.google.cloud.dialogflow.cx.v3.Environment> getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest, com.google.cloud.dialogflow.cx.v3.Environment> getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getGetEnvironmentMethod = EnvironmentsGrpc.getGetEnvironmentMethod) == null) {
          EnvironmentsGrpc.getGetEnvironmentMethod = getGetEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest, com.google.cloud.dialogflow.cx.v3.Environment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.Environment.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("GetEnvironment"))
              .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType = com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest, com.google.longrunning.Operation> getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getCreateEnvironmentMethod = EnvironmentsGrpc.getCreateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getCreateEnvironmentMethod = getCreateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("CreateEnvironment"))
              .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnvironment",
      requestType = com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest, com.google.longrunning.Operation> getUpdateEnvironmentMethod;
    if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getUpdateEnvironmentMethod = EnvironmentsGrpc.getUpdateEnvironmentMethod) == null) {
          EnvironmentsGrpc.getUpdateEnvironmentMethod = getUpdateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("UpdateEnvironment"))
              .build();
        }
      }
    }
    return getUpdateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest,
      com.google.protobuf.Empty> getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType = com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest,
      com.google.protobuf.Empty> getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest, com.google.protobuf.Empty> getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeleteEnvironmentMethod = EnvironmentsGrpc.getDeleteEnvironmentMethod) == null) {
          EnvironmentsGrpc.getDeleteEnvironmentMethod = getDeleteEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DeleteEnvironment"))
              .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest,
      com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> getLookupEnvironmentHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupEnvironmentHistory",
      requestType = com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest,
      com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> getLookupEnvironmentHistoryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest, com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> getLookupEnvironmentHistoryMethod;
    if ((getLookupEnvironmentHistoryMethod = EnvironmentsGrpc.getLookupEnvironmentHistoryMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getLookupEnvironmentHistoryMethod = EnvironmentsGrpc.getLookupEnvironmentHistoryMethod) == null) {
          EnvironmentsGrpc.getLookupEnvironmentHistoryMethod = getLookupEnvironmentHistoryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest, com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupEnvironmentHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("LookupEnvironmentHistory"))
              .build();
        }
      }
    }
    return getLookupEnvironmentHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest,
      com.google.longrunning.Operation> getRunContinuousTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunContinuousTest",
      requestType = com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest,
      com.google.longrunning.Operation> getRunContinuousTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest, com.google.longrunning.Operation> getRunContinuousTestMethod;
    if ((getRunContinuousTestMethod = EnvironmentsGrpc.getRunContinuousTestMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getRunContinuousTestMethod = EnvironmentsGrpc.getRunContinuousTestMethod) == null) {
          EnvironmentsGrpc.getRunContinuousTestMethod = getRunContinuousTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunContinuousTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("RunContinuousTest"))
              .build();
        }
      }
    }
    return getRunContinuousTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest,
      com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> getListContinuousTestResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListContinuousTestResults",
      requestType = com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest,
      com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> getListContinuousTestResultsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest, com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> getListContinuousTestResultsMethod;
    if ((getListContinuousTestResultsMethod = EnvironmentsGrpc.getListContinuousTestResultsMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getListContinuousTestResultsMethod = EnvironmentsGrpc.getListContinuousTestResultsMethod) == null) {
          EnvironmentsGrpc.getListContinuousTestResultsMethod = getListContinuousTestResultsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest, com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListContinuousTestResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("ListContinuousTestResults"))
              .build();
        }
      }
    }
    return getListContinuousTestResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeployFlowRequest,
      com.google.longrunning.Operation> getDeployFlowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployFlow",
      requestType = com.google.cloud.dialogflow.cx.v3.DeployFlowRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeployFlowRequest,
      com.google.longrunning.Operation> getDeployFlowMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.cx.v3.DeployFlowRequest, com.google.longrunning.Operation> getDeployFlowMethod;
    if ((getDeployFlowMethod = EnvironmentsGrpc.getDeployFlowMethod) == null) {
      synchronized (EnvironmentsGrpc.class) {
        if ((getDeployFlowMethod = EnvironmentsGrpc.getDeployFlowMethod) == null) {
          EnvironmentsGrpc.getDeployFlowMethod = getDeployFlowMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.cx.v3.DeployFlowRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployFlow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.cx.v3.DeployFlowRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new EnvironmentsMethodDescriptorSupplier("DeployFlow"))
              .build();
        }
      }
    }
    return getDeployFlowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EnvironmentsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsStub>() {
        @java.lang.Override
        public EnvironmentsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsStub(channel, callOptions);
        }
      };
    return EnvironmentsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnvironmentsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsBlockingStub>() {
        @java.lang.Override
        public EnvironmentsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsBlockingStub(channel, callOptions);
        }
      };
    return EnvironmentsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EnvironmentsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EnvironmentsFutureStub>() {
        @java.lang.Override
        public EnvironmentsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EnvironmentsFutureStub(channel, callOptions);
        }
      };
    return EnvironmentsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.cx.v3.Environment].
   * </pre>
   */
  public static abstract class EnvironmentsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Returns the list of all environments in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * </pre>
     */
    public void listEnvironments(com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEnvironmentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void getEnvironment(com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public void createEnvironment(com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public void updateEnvironment(com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void deleteEnvironment(com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void lookupEnvironmentHistory(com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupEnvironmentHistoryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Kicks off a continuous test under the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3.RunContinuousTestMetadata]
     * - `response`: [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3.RunContinuousTestResponse]
     * </pre>
     */
    public void runContinuousTest(com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunContinuousTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetches a list of continuous test results for a given environment.
     * </pre>
     */
    public void listContinuousTestResults(com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListContinuousTestResultsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3.DeployFlowMetadata]
     * - `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3.DeployFlowResponse]
     * </pre>
     */
    public void deployFlow(com.google.cloud.dialogflow.cx.v3.DeployFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeployFlowMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListEnvironmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest,
                com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse>(
                  this, METHODID_LIST_ENVIRONMENTS)))
          .addMethod(
            getGetEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest,
                com.google.cloud.dialogflow.cx.v3.Environment>(
                  this, METHODID_GET_ENVIRONMENT)))
          .addMethod(
            getCreateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ENVIRONMENT)))
          .addMethod(
            getUpdateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ENVIRONMENT)))
          .addMethod(
            getDeleteEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ENVIRONMENT)))
          .addMethod(
            getLookupEnvironmentHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest,
                com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse>(
                  this, METHODID_LOOKUP_ENVIRONMENT_HISTORY)))
          .addMethod(
            getRunContinuousTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_CONTINUOUS_TEST)))
          .addMethod(
            getListContinuousTestResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest,
                com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse>(
                  this, METHODID_LIST_CONTINUOUS_TEST_RESULTS)))
          .addMethod(
            getDeployFlowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.cx.v3.DeployFlowRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DEPLOY_FLOW)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.cx.v3.Environment].
   * </pre>
   */
  public static final class EnvironmentsStub extends io.grpc.stub.AbstractAsyncStub<EnvironmentsStub> {
    private EnvironmentsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all environments in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * </pre>
     */
    public void listEnvironments(com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void getEnvironment(com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public void createEnvironment(com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public void updateEnvironment(com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void deleteEnvironment(com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public void lookupEnvironmentHistory(com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupEnvironmentHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Kicks off a continuous test under the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3.RunContinuousTestMetadata]
     * - `response`: [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3.RunContinuousTestResponse]
     * </pre>
     */
    public void runContinuousTest(com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunContinuousTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetches a list of continuous test results for a given environment.
     * </pre>
     */
    public void listContinuousTestResults(com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListContinuousTestResultsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3.DeployFlowMetadata]
     * - `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3.DeployFlowResponse]
     * </pre>
     */
    public void deployFlow(com.google.cloud.dialogflow.cx.v3.DeployFlowRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployFlowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.cx.v3.Environment].
   * </pre>
   */
  public static final class EnvironmentsBlockingStub extends io.grpc.stub.AbstractBlockingStub<EnvironmentsBlockingStub> {
    private EnvironmentsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all environments in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse listEnvironments(com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.Environment getEnvironment(com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public com.google.longrunning.Operation createEnvironment(com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public com.google.longrunning.Operation updateEnvironment(com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.protobuf.Empty deleteEnvironment(com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse lookupEnvironmentHistory(com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupEnvironmentHistoryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Kicks off a continuous test under the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3.RunContinuousTestMetadata]
     * - `response`: [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3.RunContinuousTestResponse]
     * </pre>
     */
    public com.google.longrunning.Operation runContinuousTest(com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunContinuousTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetches a list of continuous test results for a given environment.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse listContinuousTestResults(com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListContinuousTestResultsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3.DeployFlowMetadata]
     * - `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3.DeployFlowResponse]
     * </pre>
     */
    public com.google.longrunning.Operation deployFlow(com.google.cloud.dialogflow.cx.v3.DeployFlowRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployFlowMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service for managing [Environments][google.cloud.dialogflow.cx.v3.Environment].
   * </pre>
   */
  public static final class EnvironmentsFutureStub extends io.grpc.stub.AbstractFutureStub<EnvironmentsFutureStub> {
    private EnvironmentsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnvironmentsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnvironmentsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Returns the list of all environments in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse> listEnvironments(
        com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.Environment> getEnvironment(
        com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an [Environment][google.cloud.dialogflow.cx.v3.Environment] in the specified [Agent][google.cloud.dialogflow.cx.v3.Agent].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEnvironment(
        com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: An empty [Struct
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#struct)
     * - `response`: [Environment][google.cloud.dialogflow.cx.v3.Environment]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateEnvironment(
        com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteEnvironment(
        com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Looks up the history of the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse> lookupEnvironmentHistory(
        com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupEnvironmentHistoryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Kicks off a continuous test under the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunContinuousTestMetadata][google.cloud.dialogflow.cx.v3.RunContinuousTestMetadata]
     * - `response`: [RunContinuousTestResponse][google.cloud.dialogflow.cx.v3.RunContinuousTestResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runContinuousTest(
        com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunContinuousTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetches a list of continuous test results for a given environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse> listContinuousTestResults(
        com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListContinuousTestResultsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deploys a flow to the specified [Environment][google.cloud.dialogflow.cx.v3.Environment].
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeployFlowMetadata][google.cloud.dialogflow.cx.v3.DeployFlowMetadata]
     * - `response`: [DeployFlowResponse][google.cloud.dialogflow.cx.v3.DeployFlowResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deployFlow(
        com.google.cloud.dialogflow.cx.v3.DeployFlowRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployFlowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ENVIRONMENTS = 0;
  private static final int METHODID_GET_ENVIRONMENT = 1;
  private static final int METHODID_CREATE_ENVIRONMENT = 2;
  private static final int METHODID_UPDATE_ENVIRONMENT = 3;
  private static final int METHODID_DELETE_ENVIRONMENT = 4;
  private static final int METHODID_LOOKUP_ENVIRONMENT_HISTORY = 5;
  private static final int METHODID_RUN_CONTINUOUS_TEST = 6;
  private static final int METHODID_LIST_CONTINUOUS_TEST_RESULTS = 7;
  private static final int METHODID_DEPLOY_FLOW = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnvironmentsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnvironmentsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments((com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse>) responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment((com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.Environment>) responseObserver);
          break;
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment((com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENVIRONMENT:
          serviceImpl.updateEnvironment((com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment((com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOOKUP_ENVIRONMENT_HISTORY:
          serviceImpl.lookupEnvironmentHistory((com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse>) responseObserver);
          break;
        case METHODID_RUN_CONTINUOUS_TEST:
          serviceImpl.runContinuousTest((com.google.cloud.dialogflow.cx.v3.RunContinuousTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CONTINUOUS_TEST_RESULTS:
          serviceImpl.listContinuousTestResults((com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3.ListContinuousTestResultsResponse>) responseObserver);
          break;
        case METHODID_DEPLOY_FLOW:
          serviceImpl.deployFlow((com.google.cloud.dialogflow.cx.v3.DeployFlowRequest) request,
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

  private static abstract class EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnvironmentsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3.EnvironmentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Environments");
    }
  }

  private static final class EnvironmentsFileDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier {
    EnvironmentsFileDescriptorSupplier() {}
  }

  private static final class EnvironmentsMethodDescriptorSupplier
      extends EnvironmentsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnvironmentsMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnvironmentsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EnvironmentsFileDescriptorSupplier())
              .addMethod(getListEnvironmentsMethod())
              .addMethod(getGetEnvironmentMethod())
              .addMethod(getCreateEnvironmentMethod())
              .addMethod(getUpdateEnvironmentMethod())
              .addMethod(getDeleteEnvironmentMethod())
              .addMethod(getLookupEnvironmentHistoryMethod())
              .addMethod(getRunContinuousTestMethod())
              .addMethod(getListContinuousTestResultsMethod())
              .addMethod(getDeployFlowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
