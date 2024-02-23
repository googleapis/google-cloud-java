/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for search.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1beta/search_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SearchServiceGrpc {

  private SearchServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.SearchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.SearchRequest,
          com.google.cloud.discoveryengine.v1beta.SearchResponse>
      getSearchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Search",
      requestType = com.google.cloud.discoveryengine.v1beta.SearchRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.SearchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.SearchRequest,
          com.google.cloud.discoveryengine.v1beta.SearchResponse>
      getSearchMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.SearchRequest,
            com.google.cloud.discoveryengine.v1beta.SearchResponse>
        getSearchMethod;
    if ((getSearchMethod = SearchServiceGrpc.getSearchMethod) == null) {
      synchronized (SearchServiceGrpc.class) {
        if ((getSearchMethod = SearchServiceGrpc.getSearchMethod) == null) {
          SearchServiceGrpc.getSearchMethod =
              getSearchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.SearchRequest,
                          com.google.cloud.discoveryengine.v1beta.SearchResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Search"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.SearchRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.SearchResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SearchServiceMethodDescriptorSupplier("Search"))
                      .build();
        }
      }
    }
    return getSearchMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SearchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchServiceStub>() {
          @java.lang.Override
          public SearchServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchServiceStub(channel, callOptions);
          }
        };
    return SearchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SearchServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchServiceBlockingStub>() {
          @java.lang.Override
          public SearchServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchServiceBlockingStub(channel, callOptions);
          }
        };
    return SearchServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SearchServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SearchServiceFutureStub>() {
          @java.lang.Override
          public SearchServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SearchServiceFutureStub(channel, callOptions);
          }
        };
    return SearchServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for search.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Performs a search.
     * </pre>
     */
    default void search(
        com.google.cloud.discoveryengine.v1beta.SearchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SearchResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SearchService.
   *
   * <pre>
   * Service for search.
   * </pre>
   */
  public abstract static class SearchServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SearchServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SearchService.
   *
   * <pre>
   * Service for search.
   * </pre>
   */
  public static final class SearchServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SearchServiceStub> {
    private SearchServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a search.
     * </pre>
     */
    public void search(
        com.google.cloud.discoveryengine.v1beta.SearchRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SearchResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SearchService.
   *
   * <pre>
   * Service for search.
   * </pre>
   */
  public static final class SearchServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SearchServiceBlockingStub> {
    private SearchServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a search.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.SearchResponse search(
        com.google.cloud.discoveryengine.v1beta.SearchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SearchService.
   *
   * <pre>
   * Service for search.
   * </pre>
   */
  public static final class SearchServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SearchServiceFutureStub> {
    private SearchServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SearchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SearchServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Performs a search.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.SearchResponse>
        search(com.google.cloud.discoveryengine.v1beta.SearchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_SEARCH:
          serviceImpl.search(
              (com.google.cloud.discoveryengine.v1beta.SearchRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.SearchResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getSearchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.SearchRequest,
                    com.google.cloud.discoveryengine.v1beta.SearchResponse>(
                    service, METHODID_SEARCH)))
        .build();
  }

  private abstract static class SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SearchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.SearchServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SearchService");
    }
  }

  private static final class SearchServiceFileDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier {
    SearchServiceFileDescriptorSupplier() {}
  }

  private static final class SearchServiceMethodDescriptorSupplier
      extends SearchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SearchServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SearchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SearchServiceFileDescriptorSupplier())
                      .addMethod(getSearchMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
