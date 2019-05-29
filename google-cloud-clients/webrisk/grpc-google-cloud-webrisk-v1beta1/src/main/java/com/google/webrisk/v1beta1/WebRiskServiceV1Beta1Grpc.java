package com.google.webrisk.v1beta1;

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
 * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
 * website and in client applications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/webrisk/v1beta1/webrisk.proto")
public final class WebRiskServiceV1Beta1Grpc {

  private WebRiskServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME = "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getComputeThreatListDiffMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      METHOD_COMPUTE_THREAT_LIST_DIFF = getComputeThreatListDiffMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      getComputeThreatListDiffMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      getComputeThreatListDiffMethod() {
    return getComputeThreatListDiffMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      getComputeThreatListDiffMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
            com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
        getComputeThreatListDiffMethod;
    if ((getComputeThreatListDiffMethod = WebRiskServiceV1Beta1Grpc.getComputeThreatListDiffMethod)
        == null) {
      synchronized (WebRiskServiceV1Beta1Grpc.class) {
        if ((getComputeThreatListDiffMethod =
                WebRiskServiceV1Beta1Grpc.getComputeThreatListDiffMethod)
            == null) {
          WebRiskServiceV1Beta1Grpc.getComputeThreatListDiffMethod =
              getComputeThreatListDiffMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
                          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1",
                              "ComputeThreatListDiff"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.ComputeThreatListDiffRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.ComputeThreatListDiffResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebRiskServiceV1Beta1MethodDescriptorSupplier(
                              "ComputeThreatListDiff"))
                      .build();
        }
      }
    }
    return getComputeThreatListDiffMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchUrisMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      METHOD_SEARCH_URIS = getSearchUrisMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      getSearchUrisMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      getSearchUrisMethod() {
    return getSearchUrisMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      getSearchUrisMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.webrisk.v1beta1.SearchUrisRequest,
            com.google.webrisk.v1beta1.SearchUrisResponse>
        getSearchUrisMethod;
    if ((getSearchUrisMethod = WebRiskServiceV1Beta1Grpc.getSearchUrisMethod) == null) {
      synchronized (WebRiskServiceV1Beta1Grpc.class) {
        if ((getSearchUrisMethod = WebRiskServiceV1Beta1Grpc.getSearchUrisMethod) == null) {
          WebRiskServiceV1Beta1Grpc.getSearchUrisMethod =
              getSearchUrisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.webrisk.v1beta1.SearchUrisRequest,
                          com.google.webrisk.v1beta1.SearchUrisResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1", "SearchUris"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.SearchUrisRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.SearchUrisResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebRiskServiceV1Beta1MethodDescriptorSupplier("SearchUris"))
                      .build();
        }
      }
    }
    return getSearchUrisMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSearchHashesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      METHOD_SEARCH_HASHES = getSearchHashesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      getSearchHashesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      getSearchHashesMethod() {
    return getSearchHashesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      getSearchHashesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.webrisk.v1beta1.SearchHashesRequest,
            com.google.webrisk.v1beta1.SearchHashesResponse>
        getSearchHashesMethod;
    if ((getSearchHashesMethod = WebRiskServiceV1Beta1Grpc.getSearchHashesMethod) == null) {
      synchronized (WebRiskServiceV1Beta1Grpc.class) {
        if ((getSearchHashesMethod = WebRiskServiceV1Beta1Grpc.getSearchHashesMethod) == null) {
          WebRiskServiceV1Beta1Grpc.getSearchHashesMethod =
              getSearchHashesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.webrisk.v1beta1.SearchHashesRequest,
                          com.google.webrisk.v1beta1.SearchHashesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1", "SearchHashes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.SearchHashesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.webrisk.v1beta1.SearchHashesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new WebRiskServiceV1Beta1MethodDescriptorSupplier("SearchHashes"))
                      .build();
        }
      }
    }
    return getSearchHashesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static WebRiskServiceV1Beta1Stub newStub(io.grpc.Channel channel) {
    return new WebRiskServiceV1Beta1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebRiskServiceV1Beta1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new WebRiskServiceV1Beta1BlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WebRiskServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    return new WebRiskServiceV1Beta1FutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public abstract static class WebRiskServiceV1Beta1ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Gets the most recent threat list diffs.
     * </pre>
     */
    public void computeThreatListDiff(
        com.google.webrisk.v1beta1.ComputeThreatListDiffRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getComputeThreatListDiffMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * </pre>
     */
    public void searchUris(
        com.google.webrisk.v1beta1.SearchUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchUrisResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchUrisMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public void searchHashes(
        com.google.webrisk.v1beta1.SearchHashesRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchHashesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getSearchHashesMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getComputeThreatListDiffMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
                      com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>(
                      this, METHODID_COMPUTE_THREAT_LIST_DIFF)))
          .addMethod(
              getSearchUrisMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.webrisk.v1beta1.SearchUrisRequest,
                      com.google.webrisk.v1beta1.SearchUrisResponse>(this, METHODID_SEARCH_URIS)))
          .addMethod(
              getSearchHashesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.webrisk.v1beta1.SearchHashesRequest,
                      com.google.webrisk.v1beta1.SearchHashesResponse>(
                      this, METHODID_SEARCH_HASHES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceV1Beta1Stub
      extends io.grpc.stub.AbstractStub<WebRiskServiceV1Beta1Stub> {
    private WebRiskServiceV1Beta1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private WebRiskServiceV1Beta1Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the most recent threat list diffs.
     * </pre>
     */
    public void computeThreatListDiff(
        com.google.webrisk.v1beta1.ComputeThreatListDiffRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * </pre>
     */
    public void searchUris(
        com.google.webrisk.v1beta1.SearchUrisRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchUrisResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchUrisMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public void searchHashes(
        com.google.webrisk.v1beta1.SearchHashesRequest request,
        io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchHashesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchHashesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceV1Beta1BlockingStub
      extends io.grpc.stub.AbstractStub<WebRiskServiceV1Beta1BlockingStub> {
    private WebRiskServiceV1Beta1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WebRiskServiceV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the most recent threat list diffs.
     * </pre>
     */
    public com.google.webrisk.v1beta1.ComputeThreatListDiffResponse computeThreatListDiff(
        com.google.webrisk.v1beta1.ComputeThreatListDiffRequest request) {
      return blockingUnaryCall(
          getChannel(), getComputeThreatListDiffMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * </pre>
     */
    public com.google.webrisk.v1beta1.SearchUrisResponse searchUris(
        com.google.webrisk.v1beta1.SearchUrisRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchUrisMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public com.google.webrisk.v1beta1.SearchHashesResponse searchHashes(
        com.google.webrisk.v1beta1.SearchHashesRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchHashesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
   * website and in client applications.
   * </pre>
   */
  public static final class WebRiskServiceV1Beta1FutureStub
      extends io.grpc.stub.AbstractStub<WebRiskServiceV1Beta1FutureStub> {
    private WebRiskServiceV1Beta1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WebRiskServiceV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebRiskServiceV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebRiskServiceV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the most recent threat list diffs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
        computeThreatListDiff(com.google.webrisk.v1beta1.ComputeThreatListDiffRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method is used to check whether a URI is on a given threatList.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.webrisk.v1beta1.SearchUrisResponse>
        searchUris(com.google.webrisk.v1beta1.SearchUrisRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchUrisMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the full hashes that match the requested hash prefix.
     * This is used after a hash prefix is looked up in a threatList
     * and there is a match. The client side threatList only holds partial hashes
     * so the client must query this method to determine if there is a full
     * hash match of a threat.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.webrisk.v1beta1.SearchHashesResponse>
        searchHashes(com.google.webrisk.v1beta1.SearchHashesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchHashesMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COMPUTE_THREAT_LIST_DIFF = 0;
  private static final int METHODID_SEARCH_URIS = 1;
  private static final int METHODID_SEARCH_HASHES = 2;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WebRiskServiceV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WebRiskServiceV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_THREAT_LIST_DIFF:
          serviceImpl.computeThreatListDiff(
              (com.google.webrisk.v1beta1.ComputeThreatListDiffRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_URIS:
          serviceImpl.searchUris(
              (com.google.webrisk.v1beta1.SearchUrisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchUrisResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_HASHES:
          serviceImpl.searchHashes(
              (com.google.webrisk.v1beta1.SearchHashesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.webrisk.v1beta1.SearchHashesResponse>)
                  responseObserver);
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

  private abstract static class WebRiskServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebRiskServiceV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.webrisk.v1beta1.WebRiskProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebRiskServiceV1Beta1");
    }
  }

  private static final class WebRiskServiceV1Beta1FileDescriptorSupplier
      extends WebRiskServiceV1Beta1BaseDescriptorSupplier {
    WebRiskServiceV1Beta1FileDescriptorSupplier() {}
  }

  private static final class WebRiskServiceV1Beta1MethodDescriptorSupplier
      extends WebRiskServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WebRiskServiceV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (WebRiskServiceV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new WebRiskServiceV1Beta1FileDescriptorSupplier())
                      .addMethod(getComputeThreatListDiffMethodHelper())
                      .addMethod(getSearchUrisMethodHelper())
                      .addMethod(getSearchHashesMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
