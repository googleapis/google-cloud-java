package com.google.cloud.networkmanagement.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The Reachability service in the Google Cloud Network Management API provides
 * services that analyze the reachability within a single Google Virtual Private
 * Cloud (VPC) network, between peered VPC networks, between VPC and on-premises
 * networks, or between VPC networks and internet hosts. A reachability analysis
 * is based on Google Cloud network configurations.
 * You can use the analysis results to verify these configurations and
 * to troubleshoot connectivity issues.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkmanagement/v1beta1/reachability.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ReachabilityServiceGrpc {

  private ReachabilityServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.networkmanagement.v1beta1.ReachabilityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest,
      com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> getListConnectivityTestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectivityTests",
      requestType = com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest.class,
      responseType = com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest,
      com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> getListConnectivityTestsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest, com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> getListConnectivityTestsMethod;
    if ((getListConnectivityTestsMethod = ReachabilityServiceGrpc.getListConnectivityTestsMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getListConnectivityTestsMethod = ReachabilityServiceGrpc.getListConnectivityTestsMethod) == null) {
          ReachabilityServiceGrpc.getListConnectivityTestsMethod = getListConnectivityTestsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest, com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnectivityTests"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("ListConnectivityTests"))
              .build();
        }
      }
    }
    return getListConnectivityTestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest,
      com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> getGetConnectivityTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectivityTest",
      requestType = com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest.class,
      responseType = com.google.cloud.networkmanagement.v1beta1.ConnectivityTest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest,
      com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> getGetConnectivityTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest, com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> getGetConnectivityTestMethod;
    if ((getGetConnectivityTestMethod = ReachabilityServiceGrpc.getGetConnectivityTestMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getGetConnectivityTestMethod = ReachabilityServiceGrpc.getGetConnectivityTestMethod) == null) {
          ReachabilityServiceGrpc.getGetConnectivityTestMethod = getGetConnectivityTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest, com.google.cloud.networkmanagement.v1beta1.ConnectivityTest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectivityTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.ConnectivityTest.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("GetConnectivityTest"))
              .build();
        }
      }
    }
    return getGetConnectivityTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest,
      com.google.longrunning.Operation> getCreateConnectivityTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnectivityTest",
      requestType = com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest,
      com.google.longrunning.Operation> getCreateConnectivityTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest, com.google.longrunning.Operation> getCreateConnectivityTestMethod;
    if ((getCreateConnectivityTestMethod = ReachabilityServiceGrpc.getCreateConnectivityTestMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getCreateConnectivityTestMethod = ReachabilityServiceGrpc.getCreateConnectivityTestMethod) == null) {
          ReachabilityServiceGrpc.getCreateConnectivityTestMethod = getCreateConnectivityTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnectivityTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("CreateConnectivityTest"))
              .build();
        }
      }
    }
    return getCreateConnectivityTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest,
      com.google.longrunning.Operation> getUpdateConnectivityTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnectivityTest",
      requestType = com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest,
      com.google.longrunning.Operation> getUpdateConnectivityTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest, com.google.longrunning.Operation> getUpdateConnectivityTestMethod;
    if ((getUpdateConnectivityTestMethod = ReachabilityServiceGrpc.getUpdateConnectivityTestMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getUpdateConnectivityTestMethod = ReachabilityServiceGrpc.getUpdateConnectivityTestMethod) == null) {
          ReachabilityServiceGrpc.getUpdateConnectivityTestMethod = getUpdateConnectivityTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnectivityTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("UpdateConnectivityTest"))
              .build();
        }
      }
    }
    return getUpdateConnectivityTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest,
      com.google.longrunning.Operation> getRerunConnectivityTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RerunConnectivityTest",
      requestType = com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest,
      com.google.longrunning.Operation> getRerunConnectivityTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest, com.google.longrunning.Operation> getRerunConnectivityTestMethod;
    if ((getRerunConnectivityTestMethod = ReachabilityServiceGrpc.getRerunConnectivityTestMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getRerunConnectivityTestMethod = ReachabilityServiceGrpc.getRerunConnectivityTestMethod) == null) {
          ReachabilityServiceGrpc.getRerunConnectivityTestMethod = getRerunConnectivityTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RerunConnectivityTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("RerunConnectivityTest"))
              .build();
        }
      }
    }
    return getRerunConnectivityTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest,
      com.google.longrunning.Operation> getDeleteConnectivityTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnectivityTest",
      requestType = com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest,
      com.google.longrunning.Operation> getDeleteConnectivityTestMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest, com.google.longrunning.Operation> getDeleteConnectivityTestMethod;
    if ((getDeleteConnectivityTestMethod = ReachabilityServiceGrpc.getDeleteConnectivityTestMethod) == null) {
      synchronized (ReachabilityServiceGrpc.class) {
        if ((getDeleteConnectivityTestMethod = ReachabilityServiceGrpc.getDeleteConnectivityTestMethod) == null) {
          ReachabilityServiceGrpc.getDeleteConnectivityTestMethod = getDeleteConnectivityTestMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnectivityTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ReachabilityServiceMethodDescriptorSupplier("DeleteConnectivityTest"))
              .build();
        }
      }
    }
    return getDeleteConnectivityTestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReachabilityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceStub>() {
        @java.lang.Override
        public ReachabilityServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReachabilityServiceStub(channel, callOptions);
        }
      };
    return ReachabilityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReachabilityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceBlockingStub>() {
        @java.lang.Override
        public ReachabilityServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReachabilityServiceBlockingStub(channel, callOptions);
        }
      };
    return ReachabilityServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReachabilityServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReachabilityServiceFutureStub>() {
        @java.lang.Override
        public ReachabilityServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReachabilityServiceFutureStub(channel, callOptions);
        }
      };
    return ReachabilityServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The Reachability service in the Google Cloud Network Management API provides
   * services that analyze the reachability within a single Google Virtual Private
   * Cloud (VPC) network, between peered VPC networks, between VPC and on-premises
   * networks, or between VPC networks and internet hosts. A reachability analysis
   * is based on Google Cloud network configurations.
   * You can use the analysis results to verify these configurations and
   * to troubleshoot connectivity issues.
   * </pre>
   */
  public static abstract class ReachabilityServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists all Connectivity Tests owned by a project.
     * </pre>
     */
    public void listConnectivityTests(com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConnectivityTestsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific Connectivity Test.
     * </pre>
     */
    public void getConnectivityTest(com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConnectivityTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Connectivity Test.
     * After you create a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, containing non-existent resources in the network, or you
     * don't have read permissions to the network configurations of listed
     * projects), then the reachability result returns a value of `UNKNOWN`.
     * If the endpoint specifications in `ConnectivityTest` are
     * incomplete, the reachability result returns a value of
     * &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information,
     * see the Connectivity Test documentation.
     * </pre>
     */
    public void createConnectivityTest(com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConnectivityTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the configuration of an existing `ConnectivityTest`.
     * After you update a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * The Reachability state in the test resource is updated with the new result.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, they contain non-existent resources in the network, or the
     * user does not have read permissions to the network configurations of
     * listed projects), then the reachability result returns a value of
     * &lt;code&gt;UNKNOWN&lt;/code&gt;.
     * If the endpoint specifications in `ConnectivityTest` are incomplete, the
     * reachability result returns a value of `AMBIGUOUS`. See the documentation
     * in `ConnectivityTest` for for more details.
     * </pre>
     */
    public void updateConnectivityTest(com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateConnectivityTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Rerun an existing `ConnectivityTest`.
     * After the user triggers the rerun, the reachability analysis is performed
     * as part of the long running operation, which completes when the analysis
     * completes.
     * Even though the test configuration remains the same, the reachability
     * result may change due to underlying network configuration changes.
     * If the endpoint specifications in `ConnectivityTest` become invalid (for
     * example, specified resources are deleted in the network, or you lost
     * read permissions to the network configurations of listed projects), then
     * the reachability result returns a value of `UNKNOWN`.
     * </pre>
     */
    public void rerunConnectivityTest(com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRerunConnectivityTestMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific `ConnectivityTest`.
     * </pre>
     */
    public void deleteConnectivityTest(com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConnectivityTestMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListConnectivityTestsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest,
                com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse>(
                  this, METHODID_LIST_CONNECTIVITY_TESTS)))
          .addMethod(
            getGetConnectivityTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest,
                com.google.cloud.networkmanagement.v1beta1.ConnectivityTest>(
                  this, METHODID_GET_CONNECTIVITY_TEST)))
          .addMethod(
            getCreateConnectivityTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONNECTIVITY_TEST)))
          .addMethod(
            getUpdateConnectivityTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CONNECTIVITY_TEST)))
          .addMethod(
            getRerunConnectivityTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RERUN_CONNECTIVITY_TEST)))
          .addMethod(
            getDeleteConnectivityTestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONNECTIVITY_TEST)))
          .build();
    }
  }

  /**
   * <pre>
   * The Reachability service in the Google Cloud Network Management API provides
   * services that analyze the reachability within a single Google Virtual Private
   * Cloud (VPC) network, between peered VPC networks, between VPC and on-premises
   * networks, or between VPC networks and internet hosts. A reachability analysis
   * is based on Google Cloud network configurations.
   * You can use the analysis results to verify these configurations and
   * to troubleshoot connectivity issues.
   * </pre>
   */
  public static final class ReachabilityServiceStub extends io.grpc.stub.AbstractAsyncStub<ReachabilityServiceStub> {
    private ReachabilityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReachabilityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReachabilityServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Connectivity Tests owned by a project.
     * </pre>
     */
    public void listConnectivityTests(com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectivityTestsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the details of a specific Connectivity Test.
     * </pre>
     */
    public void getConnectivityTest(com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectivityTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Connectivity Test.
     * After you create a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, containing non-existent resources in the network, or you
     * don't have read permissions to the network configurations of listed
     * projects), then the reachability result returns a value of `UNKNOWN`.
     * If the endpoint specifications in `ConnectivityTest` are
     * incomplete, the reachability result returns a value of
     * &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information,
     * see the Connectivity Test documentation.
     * </pre>
     */
    public void createConnectivityTest(com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectivityTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the configuration of an existing `ConnectivityTest`.
     * After you update a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * The Reachability state in the test resource is updated with the new result.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, they contain non-existent resources in the network, or the
     * user does not have read permissions to the network configurations of
     * listed projects), then the reachability result returns a value of
     * &lt;code&gt;UNKNOWN&lt;/code&gt;.
     * If the endpoint specifications in `ConnectivityTest` are incomplete, the
     * reachability result returns a value of `AMBIGUOUS`. See the documentation
     * in `ConnectivityTest` for for more details.
     * </pre>
     */
    public void updateConnectivityTest(com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectivityTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Rerun an existing `ConnectivityTest`.
     * After the user triggers the rerun, the reachability analysis is performed
     * as part of the long running operation, which completes when the analysis
     * completes.
     * Even though the test configuration remains the same, the reachability
     * result may change due to underlying network configuration changes.
     * If the endpoint specifications in `ConnectivityTest` become invalid (for
     * example, specified resources are deleted in the network, or you lost
     * read permissions to the network configurations of listed projects), then
     * the reachability result returns a value of `UNKNOWN`.
     * </pre>
     */
    public void rerunConnectivityTest(com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRerunConnectivityTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a specific `ConnectivityTest`.
     * </pre>
     */
    public void deleteConnectivityTest(com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectivityTestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Reachability service in the Google Cloud Network Management API provides
   * services that analyze the reachability within a single Google Virtual Private
   * Cloud (VPC) network, between peered VPC networks, between VPC and on-premises
   * networks, or between VPC networks and internet hosts. A reachability analysis
   * is based on Google Cloud network configurations.
   * You can use the analysis results to verify these configurations and
   * to troubleshoot connectivity issues.
   * </pre>
   */
  public static final class ReachabilityServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ReachabilityServiceBlockingStub> {
    private ReachabilityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReachabilityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReachabilityServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Connectivity Tests owned by a project.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse listConnectivityTests(com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectivityTestsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the details of a specific Connectivity Test.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.ConnectivityTest getConnectivityTest(com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectivityTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Connectivity Test.
     * After you create a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, containing non-existent resources in the network, or you
     * don't have read permissions to the network configurations of listed
     * projects), then the reachability result returns a value of `UNKNOWN`.
     * If the endpoint specifications in `ConnectivityTest` are
     * incomplete, the reachability result returns a value of
     * &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information,
     * see the Connectivity Test documentation.
     * </pre>
     */
    public com.google.longrunning.Operation createConnectivityTest(com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectivityTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the configuration of an existing `ConnectivityTest`.
     * After you update a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * The Reachability state in the test resource is updated with the new result.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, they contain non-existent resources in the network, or the
     * user does not have read permissions to the network configurations of
     * listed projects), then the reachability result returns a value of
     * &lt;code&gt;UNKNOWN&lt;/code&gt;.
     * If the endpoint specifications in `ConnectivityTest` are incomplete, the
     * reachability result returns a value of `AMBIGUOUS`. See the documentation
     * in `ConnectivityTest` for for more details.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnectivityTest(com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectivityTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Rerun an existing `ConnectivityTest`.
     * After the user triggers the rerun, the reachability analysis is performed
     * as part of the long running operation, which completes when the analysis
     * completes.
     * Even though the test configuration remains the same, the reachability
     * result may change due to underlying network configuration changes.
     * If the endpoint specifications in `ConnectivityTest` become invalid (for
     * example, specified resources are deleted in the network, or you lost
     * read permissions to the network configurations of listed projects), then
     * the reachability result returns a value of `UNKNOWN`.
     * </pre>
     */
    public com.google.longrunning.Operation rerunConnectivityTest(com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRerunConnectivityTestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a specific `ConnectivityTest`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnectivityTest(com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectivityTestMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Reachability service in the Google Cloud Network Management API provides
   * services that analyze the reachability within a single Google Virtual Private
   * Cloud (VPC) network, between peered VPC networks, between VPC and on-premises
   * networks, or between VPC networks and internet hosts. A reachability analysis
   * is based on Google Cloud network configurations.
   * You can use the analysis results to verify these configurations and
   * to troubleshoot connectivity issues.
   * </pre>
   */
  public static final class ReachabilityServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ReachabilityServiceFutureStub> {
    private ReachabilityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReachabilityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReachabilityServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all Connectivity Tests owned by a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse> listConnectivityTests(
        com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectivityTestsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the details of a specific Connectivity Test.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.networkmanagement.v1beta1.ConnectivityTest> getConnectivityTest(
        com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectivityTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Connectivity Test.
     * After you create a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, containing non-existent resources in the network, or you
     * don't have read permissions to the network configurations of listed
     * projects), then the reachability result returns a value of `UNKNOWN`.
     * If the endpoint specifications in `ConnectivityTest` are
     * incomplete, the reachability result returns a value of
     * &lt;code&gt;AMBIGUOUS&lt;/code&gt;. For more information,
     * see the Connectivity Test documentation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConnectivityTest(
        com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectivityTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the configuration of an existing `ConnectivityTest`.
     * After you update a test, the reachability analysis is performed as part
     * of the long running operation, which completes when the analysis completes.
     * The Reachability state in the test resource is updated with the new result.
     * If the endpoint specifications in `ConnectivityTest` are invalid
     * (for example, they contain non-existent resources in the network, or the
     * user does not have read permissions to the network configurations of
     * listed projects), then the reachability result returns a value of
     * &lt;code&gt;UNKNOWN&lt;/code&gt;.
     * If the endpoint specifications in `ConnectivityTest` are incomplete, the
     * reachability result returns a value of `AMBIGUOUS`. See the documentation
     * in `ConnectivityTest` for for more details.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateConnectivityTest(
        com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectivityTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Rerun an existing `ConnectivityTest`.
     * After the user triggers the rerun, the reachability analysis is performed
     * as part of the long running operation, which completes when the analysis
     * completes.
     * Even though the test configuration remains the same, the reachability
     * result may change due to underlying network configuration changes.
     * If the endpoint specifications in `ConnectivityTest` become invalid (for
     * example, specified resources are deleted in the network, or you lost
     * read permissions to the network configurations of listed projects), then
     * the reachability result returns a value of `UNKNOWN`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> rerunConnectivityTest(
        com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRerunConnectivityTestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a specific `ConnectivityTest`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConnectivityTest(
        com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectivityTestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONNECTIVITY_TESTS = 0;
  private static final int METHODID_GET_CONNECTIVITY_TEST = 1;
  private static final int METHODID_CREATE_CONNECTIVITY_TEST = 2;
  private static final int METHODID_UPDATE_CONNECTIVITY_TEST = 3;
  private static final int METHODID_RERUN_CONNECTIVITY_TEST = 4;
  private static final int METHODID_DELETE_CONNECTIVITY_TEST = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReachabilityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReachabilityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_CONNECTIVITY_TESTS:
          serviceImpl.listConnectivityTests((com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ListConnectivityTestsResponse>) responseObserver);
          break;
        case METHODID_GET_CONNECTIVITY_TEST:
          serviceImpl.getConnectivityTest((com.google.cloud.networkmanagement.v1beta1.GetConnectivityTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.ConnectivityTest>) responseObserver);
          break;
        case METHODID_CREATE_CONNECTIVITY_TEST:
          serviceImpl.createConnectivityTest((com.google.cloud.networkmanagement.v1beta1.CreateConnectivityTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECTIVITY_TEST:
          serviceImpl.updateConnectivityTest((com.google.cloud.networkmanagement.v1beta1.UpdateConnectivityTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RERUN_CONNECTIVITY_TEST:
          serviceImpl.rerunConnectivityTest((com.google.cloud.networkmanagement.v1beta1.RerunConnectivityTestRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECTIVITY_TEST:
          serviceImpl.deleteConnectivityTest((com.google.cloud.networkmanagement.v1beta1.DeleteConnectivityTestRequest) request,
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

  private static abstract class ReachabilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReachabilityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkmanagement.v1beta1.ReachabilityServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReachabilityService");
    }
  }

  private static final class ReachabilityServiceFileDescriptorSupplier
      extends ReachabilityServiceBaseDescriptorSupplier {
    ReachabilityServiceFileDescriptorSupplier() {}
  }

  private static final class ReachabilityServiceMethodDescriptorSupplier
      extends ReachabilityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReachabilityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ReachabilityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReachabilityServiceFileDescriptorSupplier())
              .addMethod(getListConnectivityTestsMethod())
              .addMethod(getGetConnectivityTestMethod())
              .addMethod(getCreateConnectivityTestMethod())
              .addMethod(getUpdateConnectivityTestMethod())
              .addMethod(getRerunConnectivityTestMethod())
              .addMethod(getDeleteConnectivityTestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
