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
package com.google.cloud.bigquery.migration.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Provides other SQL dialects to GoogleSQL translation operations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/migration/v2alpha/translation_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlTranslationServiceGrpc {

  private SqlTranslationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.bigquery.migration.v2alpha.SqlTranslationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest,
          com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
      getTranslateQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TranslateQuery",
      requestType = com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest.class,
      responseType = com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest,
          com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
      getTranslateQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest,
            com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
        getTranslateQueryMethod;
    if ((getTranslateQueryMethod = SqlTranslationServiceGrpc.getTranslateQueryMethod) == null) {
      synchronized (SqlTranslationServiceGrpc.class) {
        if ((getTranslateQueryMethod = SqlTranslationServiceGrpc.getTranslateQueryMethod) == null) {
          SqlTranslationServiceGrpc.getTranslateQueryMethod =
              getTranslateQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest,
                          com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TranslateQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlTranslationServiceMethodDescriptorSupplier("TranslateQuery"))
                      .build();
        }
      }
    }
    return getTranslateQueryMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlTranslationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceStub>() {
          @java.lang.Override
          public SqlTranslationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTranslationServiceStub(channel, callOptions);
          }
        };
    return SqlTranslationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlTranslationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceBlockingStub>() {
          @java.lang.Override
          public SqlTranslationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTranslationServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlTranslationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlTranslationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlTranslationServiceFutureStub>() {
          @java.lang.Override
          public SqlTranslationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlTranslationServiceFutureStub(channel, callOptions);
          }
        };
    return SqlTranslationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Provides other SQL dialects to GoogleSQL translation operations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Translates input queries from source dialects to GoogleSQL.
     * </pre>
     */
    default void translateQuery(
        com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTranslateQueryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlTranslationService.
   *
   * <pre>
   * Provides other SQL dialects to GoogleSQL translation operations.
   * </pre>
   */
  public abstract static class SqlTranslationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlTranslationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlTranslationService.
   *
   * <pre>
   * Provides other SQL dialects to GoogleSQL translation operations.
   * </pre>
   */
  public static final class SqlTranslationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlTranslationServiceStub> {
    private SqlTranslationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTranslationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTranslationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input queries from source dialects to GoogleSQL.
     * </pre>
     */
    public void translateQuery(
        com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTranslateQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlTranslationService.
   *
   * <pre>
   * Provides other SQL dialects to GoogleSQL translation operations.
   * </pre>
   */
  public static final class SqlTranslationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlTranslationServiceBlockingStub> {
    private SqlTranslationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTranslationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTranslationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input queries from source dialects to GoogleSQL.
     * </pre>
     */
    public com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse translateQuery(
        com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTranslateQueryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * SqlTranslationService.
   *
   * <pre>
   * Provides other SQL dialects to GoogleSQL translation operations.
   * </pre>
   */
  public static final class SqlTranslationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlTranslationServiceFutureStub> {
    private SqlTranslationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlTranslationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlTranslationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Translates input queries from source dialects to GoogleSQL.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>
        translateQuery(com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTranslateQueryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TRANSLATE_QUERY = 0;

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
        case METHODID_TRANSLATE_QUERY:
          serviceImpl.translateQuery(
              (com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>)
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
            getTranslateQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.bigquery.migration.v2alpha.TranslateQueryRequest,
                    com.google.cloud.bigquery.migration.v2alpha.TranslateQueryResponse>(
                    service, METHODID_TRANSLATE_QUERY)))
        .build();
  }

  private abstract static class SqlTranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlTranslationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.migration.v2alpha.TranslationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlTranslationService");
    }
  }

  private static final class SqlTranslationServiceFileDescriptorSupplier
      extends SqlTranslationServiceBaseDescriptorSupplier {
    SqlTranslationServiceFileDescriptorSupplier() {}
  }

  private static final class SqlTranslationServiceMethodDescriptorSupplier
      extends SqlTranslationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlTranslationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlTranslationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlTranslationServiceFileDescriptorSupplier())
                      .addMethod(getTranslateQueryMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
