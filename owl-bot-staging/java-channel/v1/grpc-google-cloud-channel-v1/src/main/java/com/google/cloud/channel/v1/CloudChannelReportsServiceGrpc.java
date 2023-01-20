package com.google.cloud.channel.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * CloudChannelReportsService lets Google Cloud resellers and
 * distributors retrieve and combine a variety of data in Cloud Channel for
 * multiple products (Google Cloud Platform (GCP), Google Voice, and
 * Google Workspace.)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/channel/v1/reports_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudChannelReportsServiceGrpc {

  private CloudChannelReportsServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.channel.v1.CloudChannelReportsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.channel.v1.RunReportJobRequest,
      com.google.longrunning.Operation> getRunReportJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunReportJob",
      requestType = com.google.cloud.channel.v1.RunReportJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.channel.v1.RunReportJobRequest,
      com.google.longrunning.Operation> getRunReportJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.channel.v1.RunReportJobRequest, com.google.longrunning.Operation> getRunReportJobMethod;
    if ((getRunReportJobMethod = CloudChannelReportsServiceGrpc.getRunReportJobMethod) == null) {
      synchronized (CloudChannelReportsServiceGrpc.class) {
        if ((getRunReportJobMethod = CloudChannelReportsServiceGrpc.getRunReportJobMethod) == null) {
          CloudChannelReportsServiceGrpc.getRunReportJobMethod = getRunReportJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.channel.v1.RunReportJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunReportJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.channel.v1.RunReportJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CloudChannelReportsServiceMethodDescriptorSupplier("RunReportJob"))
              .build();
        }
      }
    }
    return getRunReportJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.channel.v1.FetchReportResultsRequest,
      com.google.cloud.channel.v1.FetchReportResultsResponse> getFetchReportResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchReportResults",
      requestType = com.google.cloud.channel.v1.FetchReportResultsRequest.class,
      responseType = com.google.cloud.channel.v1.FetchReportResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.channel.v1.FetchReportResultsRequest,
      com.google.cloud.channel.v1.FetchReportResultsResponse> getFetchReportResultsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.channel.v1.FetchReportResultsRequest, com.google.cloud.channel.v1.FetchReportResultsResponse> getFetchReportResultsMethod;
    if ((getFetchReportResultsMethod = CloudChannelReportsServiceGrpc.getFetchReportResultsMethod) == null) {
      synchronized (CloudChannelReportsServiceGrpc.class) {
        if ((getFetchReportResultsMethod = CloudChannelReportsServiceGrpc.getFetchReportResultsMethod) == null) {
          CloudChannelReportsServiceGrpc.getFetchReportResultsMethod = getFetchReportResultsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.channel.v1.FetchReportResultsRequest, com.google.cloud.channel.v1.FetchReportResultsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FetchReportResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.channel.v1.FetchReportResultsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.channel.v1.FetchReportResultsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudChannelReportsServiceMethodDescriptorSupplier("FetchReportResults"))
              .build();
        }
      }
    }
    return getFetchReportResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.channel.v1.ListReportsRequest,
      com.google.cloud.channel.v1.ListReportsResponse> getListReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReports",
      requestType = com.google.cloud.channel.v1.ListReportsRequest.class,
      responseType = com.google.cloud.channel.v1.ListReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.channel.v1.ListReportsRequest,
      com.google.cloud.channel.v1.ListReportsResponse> getListReportsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.channel.v1.ListReportsRequest, com.google.cloud.channel.v1.ListReportsResponse> getListReportsMethod;
    if ((getListReportsMethod = CloudChannelReportsServiceGrpc.getListReportsMethod) == null) {
      synchronized (CloudChannelReportsServiceGrpc.class) {
        if ((getListReportsMethod = CloudChannelReportsServiceGrpc.getListReportsMethod) == null) {
          CloudChannelReportsServiceGrpc.getListReportsMethod = getListReportsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.channel.v1.ListReportsRequest, com.google.cloud.channel.v1.ListReportsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReports"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.channel.v1.ListReportsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.channel.v1.ListReportsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudChannelReportsServiceMethodDescriptorSupplier("ListReports"))
              .build();
        }
      }
    }
    return getListReportsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudChannelReportsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceStub>() {
        @java.lang.Override
        public CloudChannelReportsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudChannelReportsServiceStub(channel, callOptions);
        }
      };
    return CloudChannelReportsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudChannelReportsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceBlockingStub>() {
        @java.lang.Override
        public CloudChannelReportsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudChannelReportsServiceBlockingStub(channel, callOptions);
        }
      };
    return CloudChannelReportsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudChannelReportsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudChannelReportsServiceFutureStub>() {
        @java.lang.Override
        public CloudChannelReportsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudChannelReportsServiceFutureStub(channel, callOptions);
        }
      };
    return CloudChannelReportsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * CloudChannelReportsService lets Google Cloud resellers and
   * distributors retrieve and combine a variety of data in Cloud Channel for
   * multiple products (Google Cloud Platform (GCP), Google Voice, and
   * Google Workspace.)
   * </pre>
   */
  public static abstract class CloudChannelReportsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Begins generation of data for a given report. The report
     * identifier is a UID (for example, `613bf59q`).
     * Possible error codes:
     * * PERMISSION_DENIED: The user doesn't have access to this report.
     * * INVALID_ARGUMENT: Required request parameters are missing
     *   or invalid.
     * * NOT_FOUND: The report identifier was not found.
     * * INTERNAL: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * Return value:
     * The ID of a long-running operation.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata contains an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * To get the results of report generation, call
     * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
     * with the
     * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
     * </pre>
     */
    public void runReportJob(com.google.cloud.channel.v1.RunReportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunReportJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves data generated by
     * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
     * </pre>
     */
    public void fetchReportResults(com.google.cloud.channel.v1.FetchReportResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.FetchReportResultsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchReportResultsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the reports that RunReportJob can run. These reports include an ID,
     * a description, and the list of columns that will be in the result.
     * </pre>
     */
    public void listReports(com.google.cloud.channel.v1.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListReportsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListReportsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRunReportJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.channel.v1.RunReportJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_REPORT_JOB)))
          .addMethod(
            getFetchReportResultsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.channel.v1.FetchReportResultsRequest,
                com.google.cloud.channel.v1.FetchReportResultsResponse>(
                  this, METHODID_FETCH_REPORT_RESULTS)))
          .addMethod(
            getListReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.channel.v1.ListReportsRequest,
                com.google.cloud.channel.v1.ListReportsResponse>(
                  this, METHODID_LIST_REPORTS)))
          .build();
    }
  }

  /**
   * <pre>
   * CloudChannelReportsService lets Google Cloud resellers and
   * distributors retrieve and combine a variety of data in Cloud Channel for
   * multiple products (Google Cloud Platform (GCP), Google Voice, and
   * Google Workspace.)
   * </pre>
   */
  public static final class CloudChannelReportsServiceStub extends io.grpc.stub.AbstractAsyncStub<CloudChannelReportsServiceStub> {
    private CloudChannelReportsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelReportsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelReportsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Begins generation of data for a given report. The report
     * identifier is a UID (for example, `613bf59q`).
     * Possible error codes:
     * * PERMISSION_DENIED: The user doesn't have access to this report.
     * * INVALID_ARGUMENT: Required request parameters are missing
     *   or invalid.
     * * NOT_FOUND: The report identifier was not found.
     * * INTERNAL: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * Return value:
     * The ID of a long-running operation.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata contains an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * To get the results of report generation, call
     * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
     * with the
     * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
     * </pre>
     */
    public void runReportJob(com.google.cloud.channel.v1.RunReportJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunReportJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves data generated by
     * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
     * </pre>
     */
    public void fetchReportResults(com.google.cloud.channel.v1.FetchReportResultsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.FetchReportResultsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchReportResultsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the reports that RunReportJob can run. These reports include an ID,
     * a description, and the list of columns that will be in the result.
     * </pre>
     */
    public void listReports(com.google.cloud.channel.v1.ListReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListReportsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * CloudChannelReportsService lets Google Cloud resellers and
   * distributors retrieve and combine a variety of data in Cloud Channel for
   * multiple products (Google Cloud Platform (GCP), Google Voice, and
   * Google Workspace.)
   * </pre>
   */
  public static final class CloudChannelReportsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CloudChannelReportsServiceBlockingStub> {
    private CloudChannelReportsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelReportsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelReportsServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Begins generation of data for a given report. The report
     * identifier is a UID (for example, `613bf59q`).
     * Possible error codes:
     * * PERMISSION_DENIED: The user doesn't have access to this report.
     * * INVALID_ARGUMENT: Required request parameters are missing
     *   or invalid.
     * * NOT_FOUND: The report identifier was not found.
     * * INTERNAL: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * Return value:
     * The ID of a long-running operation.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata contains an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * To get the results of report generation, call
     * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
     * with the
     * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
     * </pre>
     */
    public com.google.longrunning.Operation runReportJob(com.google.cloud.channel.v1.RunReportJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunReportJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves data generated by
     * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
     * </pre>
     */
    public com.google.cloud.channel.v1.FetchReportResultsResponse fetchReportResults(com.google.cloud.channel.v1.FetchReportResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchReportResultsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the reports that RunReportJob can run. These reports include an ID,
     * a description, and the list of columns that will be in the result.
     * </pre>
     */
    public com.google.cloud.channel.v1.ListReportsResponse listReports(com.google.cloud.channel.v1.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReportsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * CloudChannelReportsService lets Google Cloud resellers and
   * distributors retrieve and combine a variety of data in Cloud Channel for
   * multiple products (Google Cloud Platform (GCP), Google Voice, and
   * Google Workspace.)
   * </pre>
   */
  public static final class CloudChannelReportsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CloudChannelReportsServiceFutureStub> {
    private CloudChannelReportsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudChannelReportsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudChannelReportsServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Begins generation of data for a given report. The report
     * identifier is a UID (for example, `613bf59q`).
     * Possible error codes:
     * * PERMISSION_DENIED: The user doesn't have access to this report.
     * * INVALID_ARGUMENT: Required request parameters are missing
     *   or invalid.
     * * NOT_FOUND: The report identifier was not found.
     * * INTERNAL: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * * UNKNOWN: Any non-user error related to a technical issue
     *   in the backend. Contact Cloud Channel support.
     * Return value:
     * The ID of a long-running operation.
     * To get the results of the operation, call the GetOperation method of
     * CloudChannelOperationsService. The Operation metadata contains an
     * instance of [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
     * To get the results of report generation, call
     * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
     * with the
     * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runReportJob(
        com.google.cloud.channel.v1.RunReportJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunReportJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves data generated by
     * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.channel.v1.FetchReportResultsResponse> fetchReportResults(
        com.google.cloud.channel.v1.FetchReportResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchReportResultsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the reports that RunReportJob can run. These reports include an ID,
     * a description, and the list of columns that will be in the result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.channel.v1.ListReportsResponse> listReports(
        com.google.cloud.channel.v1.ListReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RUN_REPORT_JOB = 0;
  private static final int METHODID_FETCH_REPORT_RESULTS = 1;
  private static final int METHODID_LIST_REPORTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudChannelReportsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudChannelReportsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RUN_REPORT_JOB:
          serviceImpl.runReportJob((com.google.cloud.channel.v1.RunReportJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_REPORT_RESULTS:
          serviceImpl.fetchReportResults((com.google.cloud.channel.v1.FetchReportResultsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.FetchReportResultsResponse>) responseObserver);
          break;
        case METHODID_LIST_REPORTS:
          serviceImpl.listReports((com.google.cloud.channel.v1.ListReportsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.channel.v1.ListReportsResponse>) responseObserver);
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

  private static abstract class CloudChannelReportsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudChannelReportsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.channel.v1.ReportsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudChannelReportsService");
    }
  }

  private static final class CloudChannelReportsServiceFileDescriptorSupplier
      extends CloudChannelReportsServiceBaseDescriptorSupplier {
    CloudChannelReportsServiceFileDescriptorSupplier() {}
  }

  private static final class CloudChannelReportsServiceMethodDescriptorSupplier
      extends CloudChannelReportsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudChannelReportsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudChannelReportsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudChannelReportsServiceFileDescriptorSupplier())
              .addMethod(getRunReportJobMethod())
              .addMethod(getFetchReportResultsMethod())
              .addMethod(getListReportsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
