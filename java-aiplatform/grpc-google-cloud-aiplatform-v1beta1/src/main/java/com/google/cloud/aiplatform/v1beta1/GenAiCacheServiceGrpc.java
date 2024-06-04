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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing Vertex AI's CachedContent resource.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/gen_ai_cache_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GenAiCacheServiceGrpc {

  private GenAiCacheServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.GenAiCacheService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getCreateCachedContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCachedContent",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.CachedContent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getCreateCachedContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest,
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        getCreateCachedContentMethod;
    if ((getCreateCachedContentMethod = GenAiCacheServiceGrpc.getCreateCachedContentMethod)
        == null) {
      synchronized (GenAiCacheServiceGrpc.class) {
        if ((getCreateCachedContentMethod = GenAiCacheServiceGrpc.getCreateCachedContentMethod)
            == null) {
          GenAiCacheServiceGrpc.getCreateCachedContentMethod =
              getCreateCachedContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest,
                          com.google.cloud.aiplatform.v1beta1.CachedContent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateCachedContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CachedContent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiCacheServiceMethodDescriptorSupplier("CreateCachedContent"))
                      .build();
        }
      }
    }
    return getCreateCachedContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getGetCachedContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCachedContent",
      requestType = com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.CachedContent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getGetCachedContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest,
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        getGetCachedContentMethod;
    if ((getGetCachedContentMethod = GenAiCacheServiceGrpc.getGetCachedContentMethod) == null) {
      synchronized (GenAiCacheServiceGrpc.class) {
        if ((getGetCachedContentMethod = GenAiCacheServiceGrpc.getGetCachedContentMethod) == null) {
          GenAiCacheServiceGrpc.getGetCachedContentMethod =
              getGetCachedContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest,
                          com.google.cloud.aiplatform.v1beta1.CachedContent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCachedContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CachedContent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiCacheServiceMethodDescriptorSupplier("GetCachedContent"))
                      .build();
        }
      }
    }
    return getGetCachedContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getUpdateCachedContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCachedContent",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.CachedContent.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest,
          com.google.cloud.aiplatform.v1beta1.CachedContent>
      getUpdateCachedContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest,
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        getUpdateCachedContentMethod;
    if ((getUpdateCachedContentMethod = GenAiCacheServiceGrpc.getUpdateCachedContentMethod)
        == null) {
      synchronized (GenAiCacheServiceGrpc.class) {
        if ((getUpdateCachedContentMethod = GenAiCacheServiceGrpc.getUpdateCachedContentMethod)
            == null) {
          GenAiCacheServiceGrpc.getUpdateCachedContentMethod =
              getUpdateCachedContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest,
                          com.google.cloud.aiplatform.v1beta1.CachedContent>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateCachedContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CachedContent
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiCacheServiceMethodDescriptorSupplier("UpdateCachedContent"))
                      .build();
        }
      }
    }
    return getUpdateCachedContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest, com.google.protobuf.Empty>
      getDeleteCachedContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCachedContent",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest, com.google.protobuf.Empty>
      getDeleteCachedContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest,
            com.google.protobuf.Empty>
        getDeleteCachedContentMethod;
    if ((getDeleteCachedContentMethod = GenAiCacheServiceGrpc.getDeleteCachedContentMethod)
        == null) {
      synchronized (GenAiCacheServiceGrpc.class) {
        if ((getDeleteCachedContentMethod = GenAiCacheServiceGrpc.getDeleteCachedContentMethod)
            == null) {
          GenAiCacheServiceGrpc.getDeleteCachedContentMethod =
              getDeleteCachedContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteCachedContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiCacheServiceMethodDescriptorSupplier("DeleteCachedContent"))
                      .build();
        }
      }
    }
    return getDeleteCachedContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest,
          com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
      getListCachedContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCachedContents",
      requestType = com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest,
          com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
      getListCachedContentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest,
            com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
        getListCachedContentsMethod;
    if ((getListCachedContentsMethod = GenAiCacheServiceGrpc.getListCachedContentsMethod) == null) {
      synchronized (GenAiCacheServiceGrpc.class) {
        if ((getListCachedContentsMethod = GenAiCacheServiceGrpc.getListCachedContentsMethod)
            == null) {
          GenAiCacheServiceGrpc.getListCachedContentsMethod =
              getListCachedContentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCachedContents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new GenAiCacheServiceMethodDescriptorSupplier("ListCachedContents"))
                      .build();
        }
      }
    }
    return getListCachedContentsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static GenAiCacheServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceStub>() {
          @java.lang.Override
          public GenAiCacheServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiCacheServiceStub(channel, callOptions);
          }
        };
    return GenAiCacheServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GenAiCacheServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceBlockingStub>() {
          @java.lang.Override
          public GenAiCacheServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiCacheServiceBlockingStub(channel, callOptions);
          }
        };
    return GenAiCacheServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static GenAiCacheServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<GenAiCacheServiceFutureStub>() {
          @java.lang.Override
          public GenAiCacheServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new GenAiCacheServiceFutureStub(channel, callOptions);
          }
        };
    return GenAiCacheServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing Vertex AI's CachedContent resource.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates cached content, this call will initialize the cached content in the
     * data storage, and users need to pay for the cache data storage.
     * </pre>
     */
    default void createCachedContent(
        com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCachedContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets cached content configurations
     * </pre>
     */
    default void getCachedContent(
        com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCachedContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates cached content configurations
     * </pre>
     */
    default void updateCachedContent(
        com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCachedContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes cached content
     * </pre>
     */
    default void deleteCachedContent(
        com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCachedContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists cached contents in a project
     * </pre>
     */
    default void listCachedContents(
        com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCachedContentsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GenAiCacheService.
   *
   * <pre>
   * Service for managing Vertex AI's CachedContent resource.
   * </pre>
   */
  public abstract static class GenAiCacheServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return GenAiCacheServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GenAiCacheService.
   *
   * <pre>
   * Service for managing Vertex AI's CachedContent resource.
   * </pre>
   */
  public static final class GenAiCacheServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GenAiCacheServiceStub> {
    private GenAiCacheServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiCacheServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiCacheServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates cached content, this call will initialize the cached content in the
     * data storage, and users need to pay for the cache data storage.
     * </pre>
     */
    public void createCachedContent(
        com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCachedContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets cached content configurations
     * </pre>
     */
    public void getCachedContent(
        com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCachedContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates cached content configurations
     * </pre>
     */
    public void updateCachedContent(
        com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCachedContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes cached content
     * </pre>
     */
    public void deleteCachedContent(
        com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCachedContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists cached contents in a project
     * </pre>
     */
    public void listCachedContents(
        com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCachedContentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GenAiCacheService.
   *
   * <pre>
   * Service for managing Vertex AI's CachedContent resource.
   * </pre>
   */
  public static final class GenAiCacheServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GenAiCacheServiceBlockingStub> {
    private GenAiCacheServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiCacheServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiCacheServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates cached content, this call will initialize the cached content in the
     * data storage, and users need to pay for the cache data storage.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.CachedContent createCachedContent(
        com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCachedContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets cached content configurations
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.CachedContent getCachedContent(
        com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCachedContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates cached content configurations
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.CachedContent updateCachedContent(
        com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCachedContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes cached content
     * </pre>
     */
    public com.google.protobuf.Empty deleteCachedContent(
        com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCachedContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists cached contents in a project
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse listCachedContents(
        com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCachedContentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GenAiCacheService.
   *
   * <pre>
   * Service for managing Vertex AI's CachedContent resource.
   * </pre>
   */
  public static final class GenAiCacheServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GenAiCacheServiceFutureStub> {
    private GenAiCacheServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GenAiCacheServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GenAiCacheServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates cached content, this call will initialize the cached content in the
     * data storage, and users need to pay for the cache data storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        createCachedContent(
            com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCachedContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets cached content configurations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        getCachedContent(com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCachedContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates cached content configurations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.CachedContent>
        updateCachedContent(
            com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCachedContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes cached content
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCachedContent(
            com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCachedContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists cached contents in a project
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>
        listCachedContents(com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCachedContentsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CACHED_CONTENT = 0;
  private static final int METHODID_GET_CACHED_CONTENT = 1;
  private static final int METHODID_UPDATE_CACHED_CONTENT = 2;
  private static final int METHODID_DELETE_CACHED_CONTENT = 3;
  private static final int METHODID_LIST_CACHED_CONTENTS = 4;

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
        case METHODID_CREATE_CACHED_CONTENT:
          serviceImpl.createCachedContent(
              (com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>)
                  responseObserver);
          break;
        case METHODID_GET_CACHED_CONTENT:
          serviceImpl.getCachedContent(
              (com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CACHED_CONTENT:
          serviceImpl.updateCachedContent(
              (com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.CachedContent>)
                  responseObserver);
          break;
        case METHODID_DELETE_CACHED_CONTENT:
          serviceImpl.deleteCachedContent(
              (com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CACHED_CONTENTS:
          serviceImpl.listCachedContents(
              (com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>)
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
            getCreateCachedContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateCachedContentRequest,
                    com.google.cloud.aiplatform.v1beta1.CachedContent>(
                    service, METHODID_CREATE_CACHED_CONTENT)))
        .addMethod(
            getGetCachedContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetCachedContentRequest,
                    com.google.cloud.aiplatform.v1beta1.CachedContent>(
                    service, METHODID_GET_CACHED_CONTENT)))
        .addMethod(
            getUpdateCachedContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateCachedContentRequest,
                    com.google.cloud.aiplatform.v1beta1.CachedContent>(
                    service, METHODID_UPDATE_CACHED_CONTENT)))
        .addMethod(
            getDeleteCachedContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteCachedContentRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CACHED_CONTENT)))
        .addMethod(
            getListCachedContentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListCachedContentsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListCachedContentsResponse>(
                    service, METHODID_LIST_CACHED_CONTENTS)))
        .build();
  }

  private abstract static class GenAiCacheServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GenAiCacheServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.GenAiCacheServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GenAiCacheService");
    }
  }

  private static final class GenAiCacheServiceFileDescriptorSupplier
      extends GenAiCacheServiceBaseDescriptorSupplier {
    GenAiCacheServiceFileDescriptorSupplier() {}
  }

  private static final class GenAiCacheServiceMethodDescriptorSupplier
      extends GenAiCacheServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GenAiCacheServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GenAiCacheServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new GenAiCacheServiceFileDescriptorSupplier())
                      .addMethod(getCreateCachedContentMethod())
                      .addMethod(getGetCachedContentMethod())
                      .addMethod(getUpdateCachedContentMethod())
                      .addMethod(getDeleteCachedContentMethod())
                      .addMethod(getListCachedContentsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
