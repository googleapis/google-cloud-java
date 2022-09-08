package com.google.webrisk.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Web Risk API defines an interface to detect malicious URLs on your
 * website and in client applications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/webrisk/v1/webrisk.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WebRiskServiceGrpc {

  private WebRiskServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.webrisk.v1.WebRiskService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.webrisk.v1.ComputeThreatListDiffRequest,
      com.google.webrisk.v1.ComputeThreatListDiffResponse> getComputeThreatListDiffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeThreatListDiff",
      requestType = com.google.webrisk.v1.ComputeThreatListDiffRequest.class,
      responseType = com.google.webrisk.v1.ComputeThreatListDiffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.webrisk.v1.ComputeThreatListDiffRequest,
      com.google.webrisk.v1.ComputeThreatListDiffResponse> getComputeThreatListDiffMethod() {
    io.grpc.MethodDescriptor<com.google.webrisk.v1.ComputeThreatListDiffRequest, com.google.webrisk.v1.ComputeThreatListDiffResponse> getComputeThreatListDiffMethod;
    if ((getComputeThreatListDiffMethod = WebRiskServiceGrpc.getComputeThreatListDiffMethod) == null) {
      synchronized (WebRiskServiceGrpc.class) {
        if ((getComputeThreatListDiffMethod = WebRiskServiceGrpc.getComputeThreatListDiffMethod) == null) {
          WebRiskServiceGrpc.getComputeThreatListDiffMethod = getComputeThreatListDiffMethod =
              io.grpc.MethodDescriptor.<com.google.webrisk.v1.ComputeThreatListDiffRequest, com.google.webrisk.v1.ComputeThreatListDiffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ComputeThreatListDiff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.ComputeThreatListDiffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.ComputeThreatListDiffResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebRiskServiceMethodDescriptorSupplier("ComputeThreatListDiff"))
              .build();
        }
      }
    }
    return getComputeThreatListDiffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchUrisRequest,
      com.google.webrisk.v1.SearchUrisResponse> getSearchUrisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchUris",
      requestType = com.google.webrisk.v1.SearchUrisRequest.class,
      responseType = com.google.webrisk.v1.SearchUrisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchUrisRequest,
      com.google.webrisk.v1.SearchUrisResponse> getSearchUrisMethod() {
    io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchUrisRequest, com.google.webrisk.v1.SearchUrisResponse> getSearchUrisMethod;
    if ((getSearchUrisMethod = WebRiskServiceGrpc.getSearchUrisMethod) == null) {
      synchronized (WebRiskServiceGrpc.class) {
        if ((getSearchUrisMethod = WebRiskServiceGrpc.getSearchUrisMethod) == null) {
          WebRiskServiceGrpc.getSearchUrisMethod = getSearchUrisMethod =
              io.grpc.MethodDescriptor.<com.google.webrisk.v1.SearchUrisRequest, com.google.webrisk.v1.SearchUrisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchUris"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.SearchUrisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.SearchUrisResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebRiskServiceMethodDescriptorSupplier("SearchUris"))
              .build();
        }
      }
    }
    return getSearchUrisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchHashesRequest,
      com.google.webrisk.v1.SearchHashesResponse> getSearchHashesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchHashes",
      requestType = com.google.webrisk.v1.SearchHashesRequest.class,
      responseType = com.google.webrisk.v1.SearchHashesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchHashesRequest,
      com.google.webrisk.v1.SearchHashesResponse> getSearchHashesMethod() {
    io.grpc.MethodDescriptor<com.google.webrisk.v1.SearchHashesRequest, com.google.webrisk.v1.SearchHashesResponse> getSearchHashesMethod;
    if ((getSearchHashesMethod = WebRiskServiceGrpc.getSearchHashesMethod) == null) {
      synchronized (WebRiskServiceGrpc.class) {
        if ((getSearchHashesMethod = WebRiskServiceGrpc.getSearchHashesMethod) == null) {
          WebRiskServiceGrpc.getSearchHashesMethod = getSearchHashesMethod =
              io.grpc.MethodDescriptor.<com.google.webrisk.v1.SearchHashesRequest, com.google.webrisk.v1.SearchHashesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchHashes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.SearchHashesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.SearchHashesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebRiskServiceMethodDescriptorSupplier("SearchHashes"))
              .build();
        }
      }
    }
    return getSearchHashesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.webrisk.v1.CreateSubmissionRequest,
      com.google.webrisk.v1.Submission> getCreateSubmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSubmission",
      requestType = com.google.webrisk.v1.CreateSubmissionRequest.class,
      responseType = com.google.webrisk.v1.Submission.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.webrisk.v1.CreateSubmissionRequest,
      com.google.webrisk.v1.Submission> getCreateSubmissionMethod() {
    io.grpc.MethodDescriptor<com.google.webrisk.v1.CreateSubmissionRequest, com.google.webrisk.v1.Submission> getCreateSubmissionMethod;
    if ((getCreateSubmissionMethod = WebRiskServiceGrpc.getCreateSubmissionMethod) == null) {
      synchronized (WebRiskServiceGrpc.class) {
        if ((getCreateSubmissionMethod = WebRiskServiceGrpc.getCreateSubmissionMethod) == null) {
          WebRiskServiceGrpc.getCreateSubmissionMethod = getCreateSubmissionMethod =
              io.grpc.MethodDescriptor.<com.google.webrisk.v1.CreateSubmissionRequest, com.google.webrisk.v1.Submission>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSubmission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.CreateSubmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.webrisk.v1.Submission.getDefaultInstance()))
              .setSchemaDescriptor(new WebRiskServiceMethodDescriptorSupplier("CreateSubmission"))
              .build();
        }
      }
    }
    return getCreateSubmissionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebRiskServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceStub>() {
        @java.lang.Override
        public WebRiskServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebRiskServiceStub(channel, callOptions);
        }
      };
    return WebRiskServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebRiskServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceBlockingStub>() {
        @java.lang.Override
        public WebRiskServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebRiskServiceBlockingStub(channel, callOptions);
        }
      };
    return WebRiskServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebRiskServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceFutureStub>() {
        @java.lang.Override
        public WebRiskServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebRiskServiceFutureStub(channel, callOptions);
        }
      };
    return WebRiskServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Web Risk API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static abstract class WebRiskServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets the most recent threat list diffs. These diffs should be applied to
     * a local database of hashes to keep it up-to-date. If the local database is
     * empty or excessively out-of-date, a complete snapshot of the database will
     * be returned. This Method only updates a single ThreatList at a time. To
     * update multiple ThreatList databases, this method needs to be called once
     * for each list.
     * </pre>
     */
    public void computeThreatListDiff(com.google.webrisk.v1.ComputeThreatListDiffRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.ComputeThreatListDiffResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeThreatListDiffMethod(), responseObserver);
    }

    /**
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * Multiple threatLists may be searched in a single query.
     * The response will list all requested threatLists the URI was found to
     * match. If the URI is not found on any of the requested ThreatList an
     * empty response will be returned.
     * </pre>
     */
    public void searchUris(com.google.webrisk.v1.SearchUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchUrisResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchUrisMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public void searchHashes(com.google.webrisk.v1.SearchHashesRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchHashesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchHashesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Submission of a URI suspected of containing phishing content to
     * be reviewed. If the result verifies the existence of malicious phishing
     * content, the site will be added to the [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future. Only
     * projects with CREATE_SUBMISSION_USERS visibility can use this method.
     * </pre>
     */
    public void createSubmission(com.google.webrisk.v1.CreateSubmissionRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.Submission> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSubmissionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getComputeThreatListDiffMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.webrisk.v1.ComputeThreatListDiffRequest,
                com.google.webrisk.v1.ComputeThreatListDiffResponse>(
                  this, METHODID_COMPUTE_THREAT_LIST_DIFF)))
          .addMethod(
            getSearchUrisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.webrisk.v1.SearchUrisRequest,
                com.google.webrisk.v1.SearchUrisResponse>(
                  this, METHODID_SEARCH_URIS)))
          .addMethod(
            getSearchHashesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.webrisk.v1.SearchHashesRequest,
                com.google.webrisk.v1.SearchHashesResponse>(
                  this, METHODID_SEARCH_HASHES)))
          .addMethod(
            getCreateSubmissionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.webrisk.v1.CreateSubmissionRequest,
                com.google.webrisk.v1.Submission>(
                  this, METHODID_CREATE_SUBMISSION)))
          .build();
    }
  }

  /**
   * <pre>
   * Web Risk API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceStub extends io.grpc.stub.AbstractAsyncStub<WebRiskServiceStub> {
    private WebRiskServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the most recent threat list diffs. These diffs should be applied to
     * a local database of hashes to keep it up-to-date. If the local database is
     * empty or excessively out-of-date, a complete snapshot of the database will
     * be returned. This Method only updates a single ThreatList at a time. To
     * update multiple ThreatList databases, this method needs to be called once
     * for each list.
     * </pre>
     */
    public void computeThreatListDiff(com.google.webrisk.v1.ComputeThreatListDiffRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.ComputeThreatListDiffResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * Multiple threatLists may be searched in a single query.
     * The response will list all requested threatLists the URI was found to
     * match. If the URI is not found on any of the requested ThreatList an
     * empty response will be returned.
     * </pre>
     */
    public void searchUris(com.google.webrisk.v1.SearchUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchUrisResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchUrisMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public void searchHashes(com.google.webrisk.v1.SearchHashesRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchHashesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchHashesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Submission of a URI suspected of containing phishing content to
     * be reviewed. If the result verifies the existence of malicious phishing
     * content, the site will be added to the [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future. Only
     * projects with CREATE_SUBMISSION_USERS visibility can use this method.
     * </pre>
     */
    public void createSubmission(com.google.webrisk.v1.CreateSubmissionRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1.Submission> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSubmissionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Web Risk API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<WebRiskServiceBlockingStub> {
    private WebRiskServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the most recent threat list diffs. These diffs should be applied to
     * a local database of hashes to keep it up-to-date. If the local database is
     * empty or excessively out-of-date, a complete snapshot of the database will
     * be returned. This Method only updates a single ThreatList at a time. To
     * update multiple ThreatList databases, this method needs to be called once
     * for each list.
     * </pre>
     */
    public com.google.webrisk.v1.ComputeThreatListDiffResponse computeThreatListDiff(com.google.webrisk.v1.ComputeThreatListDiffRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeThreatListDiffMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * Multiple threatLists may be searched in a single query.
     * The response will list all requested threatLists the URI was found to
     * match. If the URI is not found on any of the requested ThreatList an
     * empty response will be returned.
     * </pre>
     */
    public com.google.webrisk.v1.SearchUrisResponse searchUris(com.google.webrisk.v1.SearchUrisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchUrisMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public com.google.webrisk.v1.SearchHashesResponse searchHashes(com.google.webrisk.v1.SearchHashesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchHashesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Submission of a URI suspected of containing phishing content to
     * be reviewed. If the result verifies the existence of malicious phishing
     * content, the site will be added to the [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future. Only
     * projects with CREATE_SUBMISSION_USERS visibility can use this method.
     * </pre>
     */
    public com.google.webrisk.v1.Submission createSubmission(com.google.webrisk.v1.CreateSubmissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSubmissionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Web Risk API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceFutureStub extends io.grpc.stub.AbstractFutureStub<WebRiskServiceFutureStub> {
    private WebRiskServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the most recent threat list diffs. These diffs should be applied to
     * a local database of hashes to keep it up-to-date. If the local database is
     * empty or excessively out-of-date, a complete snapshot of the database will
     * be returned. This Method only updates a single ThreatList at a time. To
     * update multiple ThreatList databases, this method needs to be called once
     * for each list.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.webrisk.v1.ComputeThreatListDiffResponse> computeThreatListDiff(
        com.google.webrisk.v1.ComputeThreatListDiffRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * Multiple threatLists may be searched in a single query.
     * The response will list all requested threatLists the URI was found to
     * match. If the URI is not found on any of the requested ThreatList an
     * empty response will be returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.webrisk.v1.SearchUrisResponse> searchUris(
        com.google.webrisk.v1.SearchUrisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchUrisMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.webrisk.v1.SearchHashesResponse> searchHashes(
        com.google.webrisk.v1.SearchHashesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchHashesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Submission of a URI suspected of containing phishing content to
     * be reviewed. If the result verifies the existence of malicious phishing
     * content, the site will be added to the [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future. Only
     * projects with CREATE_SUBMISSION_USERS visibility can use this method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.webrisk.v1.Submission> createSubmission(
        com.google.webrisk.v1.CreateSubmissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSubmissionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_THREAT_LIST_DIFF = 0;
  private static final int METHODID_SEARCH_URIS = 1;
  private static final int METHODID_SEARCH_HASHES = 2;
  private static final int METHODID_CREATE_SUBMISSION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebRiskServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebRiskServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_THREAT_LIST_DIFF:
          serviceImpl.computeThreatListDiff((com.google.webrisk.v1.ComputeThreatListDiffRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1.ComputeThreatListDiffResponse>) responseObserver);
          break;
        case METHODID_SEARCH_URIS:
          serviceImpl.searchUris((com.google.webrisk.v1.SearchUrisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchUrisResponse>) responseObserver);
          break;
        case METHODID_SEARCH_HASHES:
          serviceImpl.searchHashes((com.google.webrisk.v1.SearchHashesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1.SearchHashesResponse>) responseObserver);
          break;
        case METHODID_CREATE_SUBMISSION:
          serviceImpl.createSubmission((com.google.webrisk.v1.CreateSubmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1.Submission>) responseObserver);
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

  private static abstract class WebRiskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebRiskServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.webrisk.v1.WebRiskProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebRiskService");
    }
  }

  private static final class WebRiskServiceFileDescriptorSupplier
      extends WebRiskServiceBaseDescriptorSupplier {
    WebRiskServiceFileDescriptorSupplier() {}
  }

  private static final class WebRiskServiceMethodDescriptorSupplier
      extends WebRiskServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebRiskServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WebRiskServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebRiskServiceFileDescriptorSupplier())
              .addMethod(getComputeThreatListDiffMethod())
              .addMethod(getSearchUrisMethod())
              .addMethod(getSearchHashesMethod())
              .addMethod(getCreateSubmissionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
