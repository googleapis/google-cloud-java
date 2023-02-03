/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.webrisk.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Web Risk v1beta1 API defines an interface to detect malicious URLs on your
 * website and in client applications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/webrisk/v1beta1/webrisk.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WebRiskServiceV1Beta1Grpc {

  private WebRiskServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME = "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      getComputeThreatListDiffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeThreatListDiff",
      requestType = com.google.webrisk.v1beta1.ComputeThreatListDiffRequest.class,
      responseType = com.google.webrisk.v1beta1.ComputeThreatListDiffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
          com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>
      getComputeThreatListDiffMethod() {
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
                          generateFullMethodName(SERVICE_NAME, "ComputeThreatListDiff"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      getSearchUrisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchUris",
      requestType = com.google.webrisk.v1beta1.SearchUrisRequest.class,
      responseType = com.google.webrisk.v1beta1.SearchUrisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchUrisRequest,
          com.google.webrisk.v1beta1.SearchUrisResponse>
      getSearchUrisMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchUris"))
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      getSearchHashesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchHashes",
      requestType = com.google.webrisk.v1beta1.SearchHashesRequest.class,
      responseType = com.google.webrisk.v1beta1.SearchHashesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.webrisk.v1beta1.SearchHashesRequest,
          com.google.webrisk.v1beta1.SearchHashesResponse>
      getSearchHashesMethod() {
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
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchHashes"))
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
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1Stub>() {
          @java.lang.Override
          public WebRiskServiceV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebRiskServiceV1Beta1Stub(channel, callOptions);
          }
        };
    return WebRiskServiceV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebRiskServiceV1Beta1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1BlockingStub>() {
          @java.lang.Override
          public WebRiskServiceV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebRiskServiceV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return WebRiskServiceV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static WebRiskServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<WebRiskServiceV1Beta1FutureStub>() {
          @java.lang.Override
          public WebRiskServiceV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new WebRiskServiceV1Beta1FutureStub(channel, callOptions);
          }
        };
    return WebRiskServiceV1Beta1FutureStub.newStub(factory, channel);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeThreatListDiffMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchUrisMethod(), responseObserver);
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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchHashesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getComputeThreatListDiffMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.webrisk.v1beta1.ComputeThreatListDiffRequest,
                      com.google.webrisk.v1beta1.ComputeThreatListDiffResponse>(
                      this, METHODID_COMPUTE_THREAT_LIST_DIFF)))
          .addMethod(
              getSearchUrisMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.webrisk.v1beta1.SearchUrisRequest,
                      com.google.webrisk.v1beta1.SearchUrisResponse>(this, METHODID_SEARCH_URIS)))
          .addMethod(
              getSearchHashesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
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
      extends io.grpc.stub.AbstractAsyncStub<WebRiskServiceV1Beta1Stub> {
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethod(), getCallOptions()),
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchUrisMethod(), getCallOptions()), request, responseObserver);
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
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchHashesMethod(), getCallOptions()),
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
      extends io.grpc.stub.AbstractBlockingStub<WebRiskServiceV1Beta1BlockingStub> {
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeThreatListDiffMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchUrisMethod(), getCallOptions(), request);
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
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchHashesMethod(), getCallOptions(), request);
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
      extends io.grpc.stub.AbstractFutureStub<WebRiskServiceV1Beta1FutureStub> {
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeThreatListDiffMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchUrisMethod(), getCallOptions()), request);
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
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchHashesMethod(), getCallOptions()), request);
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
                      .addMethod(getComputeThreatListDiffMethod())
                      .addMethod(getSearchUrisMethod())
                      .addMethod(getSearchHashesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
