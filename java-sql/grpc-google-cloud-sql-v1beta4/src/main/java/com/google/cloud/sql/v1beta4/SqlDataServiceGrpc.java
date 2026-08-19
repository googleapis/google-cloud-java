/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.sql.v1beta4;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for streaming data to and from Cloud SQL instances.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SqlDataServiceGrpc {

  private SqlDataServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.sql.v1beta4.SqlDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
          com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
      getStreamSqlDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamSqlData",
      requestType = com.google.cloud.sql.v1beta4.StreamSqlDataRequest.class,
      responseType = com.google.cloud.sql.v1beta4.StreamSqlDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
          com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
      getStreamSqlDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
            com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
        getStreamSqlDataMethod;
    if ((getStreamSqlDataMethod = SqlDataServiceGrpc.getStreamSqlDataMethod) == null) {
      synchronized (SqlDataServiceGrpc.class) {
        if ((getStreamSqlDataMethod = SqlDataServiceGrpc.getStreamSqlDataMethod) == null) {
          SqlDataServiceGrpc.getStreamSqlDataMethod =
              getStreamSqlDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
                          com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamSqlData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.StreamSqlDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.sql.v1beta4.StreamSqlDataResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SqlDataServiceMethodDescriptorSupplier("StreamSqlData"))
                      .build();
        }
      }
    }
    return getStreamSqlDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SqlDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceStub>() {
          @java.lang.Override
          public SqlDataServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDataServiceStub(channel, callOptions);
          }
        };
    return SqlDataServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SqlDataServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceBlockingV2Stub>() {
          @java.lang.Override
          public SqlDataServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDataServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SqlDataServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqlDataServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceBlockingStub>() {
          @java.lang.Override
          public SqlDataServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDataServiceBlockingStub(channel, callOptions);
          }
        };
    return SqlDataServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SqlDataServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SqlDataServiceFutureStub>() {
          @java.lang.Override
          public SqlDataServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SqlDataServiceFutureStub(channel, callOptions);
          }
        };
    return SqlDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * `StreamSqlData` establishes a bidirectional stream to a Cloud SQL instance,
     * and then streams data to and from the instance.
     * The first message from the client MUST be a `StreamSqlDataRequest` request
     * with configuration settings, including required values for the
     * `connection_settings` field. Subsequent messages from the client may
     * contain the `payload` field.
     * Messages from the server may contain the `payload` field.
     * The `payload` fields of the request and response streams contain the raw
     * data of the database's native wire protocol (e.g., PostgreSQL wire
     * protocol). The database client is responsible for generating and parsing
     * this data.
     * Any errors on initial connection (e.g., connection failure, authorization
     * issues, network problems) will result in the stream being terminated with
     * an appropriate RPC status exception.
     * After a successful connection is made, if an error occurs, then the server
     * terminates connection and returns the appropriate RPC status exception.
     * Add the request params headers to the request to ensure that
     * the streaming request is routed to the correct service for your database.
     * Use this format for the request params header:
     *    `x-goog-request-params`:
     *        location_id={location_path}&amp;instance_id={instance_path}`
     *  `location_path` is `locations/{location_name}`
     *  `instance_path` is `projects/{project_name}/instances/{instance_name}`
     * for example:
     *     `x-goog-request-params`:
     *     `location_id=locations/us-central1&amp;instance_id=projects/myproject/instances/instancename`
     * </pre>
     */
    default io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.StreamSqlDataRequest>
        streamSqlData(
            io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamSqlDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqlDataService.
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public abstract static class SqlDataServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SqlDataServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqlDataService.
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public static final class SqlDataServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqlDataServiceStub> {
    private SqlDataServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDataServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDataServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * `StreamSqlData` establishes a bidirectional stream to a Cloud SQL instance,
     * and then streams data to and from the instance.
     * The first message from the client MUST be a `StreamSqlDataRequest` request
     * with configuration settings, including required values for the
     * `connection_settings` field. Subsequent messages from the client may
     * contain the `payload` field.
     * Messages from the server may contain the `payload` field.
     * The `payload` fields of the request and response streams contain the raw
     * data of the database's native wire protocol (e.g., PostgreSQL wire
     * protocol). The database client is responsible for generating and parsing
     * this data.
     * Any errors on initial connection (e.g., connection failure, authorization
     * issues, network problems) will result in the stream being terminated with
     * an appropriate RPC status exception.
     * After a successful connection is made, if an error occurs, then the server
     * terminates connection and returns the appropriate RPC status exception.
     * Add the request params headers to the request to ensure that
     * the streaming request is routed to the correct service for your database.
     * Use this format for the request params header:
     *    `x-goog-request-params`:
     *        location_id={location_path}&amp;instance_id={instance_path}`
     *  `location_path` is `locations/{location_name}`
     *  `instance_path` is `projects/{project_name}/instances/{instance_name}`
     * for example:
     *     `x-goog-request-params`:
     *     `location_id=locations/us-central1&amp;instance_id=projects/myproject/instances/instancename`
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.StreamSqlDataRequest>
        streamSqlData(
            io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamSqlDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqlDataService.
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public static final class SqlDataServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SqlDataServiceBlockingV2Stub> {
    private SqlDataServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDataServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDataServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * `StreamSqlData` establishes a bidirectional stream to a Cloud SQL instance,
     * and then streams data to and from the instance.
     * The first message from the client MUST be a `StreamSqlDataRequest` request
     * with configuration settings, including required values for the
     * `connection_settings` field. Subsequent messages from the client may
     * contain the `payload` field.
     * Messages from the server may contain the `payload` field.
     * The `payload` fields of the request and response streams contain the raw
     * data of the database's native wire protocol (e.g., PostgreSQL wire
     * protocol). The database client is responsible for generating and parsing
     * this data.
     * Any errors on initial connection (e.g., connection failure, authorization
     * issues, network problems) will result in the stream being terminated with
     * an appropriate RPC status exception.
     * After a successful connection is made, if an error occurs, then the server
     * terminates connection and returns the appropriate RPC status exception.
     * Add the request params headers to the request to ensure that
     * the streaming request is routed to the correct service for your database.
     * Use this format for the request params header:
     *    `x-goog-request-params`:
     *        location_id={location_path}&amp;instance_id={instance_path}`
     *  `location_path` is `locations/{location_name}`
     *  `instance_path` is `projects/{project_name}/instances/{instance_name}`
     * for example:
     *     `x-goog-request-params`:
     *     `location_id=locations/us-central1&amp;instance_id=projects/myproject/instances/instancename`
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<
            com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
            com.google.cloud.sql.v1beta4.StreamSqlDataResponse>
        streamSqlData() {
      return io.grpc.stub.ClientCalls.blockingBidiStreamingCall(
          getChannel(), getStreamSqlDataMethod(), getCallOptions());
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SqlDataService.
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public static final class SqlDataServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqlDataServiceBlockingStub> {
    private SqlDataServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDataServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqlDataService.
   *
   * <pre>
   * Service for streaming data to and from Cloud SQL instances.
   * </pre>
   */
  public static final class SqlDataServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqlDataServiceFutureStub> {
    private SqlDataServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqlDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqlDataServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_SQL_DATA = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_SQL_DATA:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamSqlData(
                  (io.grpc.stub.StreamObserver<com.google.cloud.sql.v1beta4.StreamSqlDataResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getStreamSqlDataMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                new MethodHandlers<
                    com.google.cloud.sql.v1beta4.StreamSqlDataRequest,
                    com.google.cloud.sql.v1beta4.StreamSqlDataResponse>(
                    service, METHODID_STREAM_SQL_DATA)))
        .build();
  }

  private abstract static class SqlDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqlDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.sql.v1beta4.CloudSqlDataProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqlDataService");
    }
  }

  private static final class SqlDataServiceFileDescriptorSupplier
      extends SqlDataServiceBaseDescriptorSupplier {
    SqlDataServiceFileDescriptorSupplier() {}
  }

  private static final class SqlDataServiceMethodDescriptorSupplier
      extends SqlDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqlDataServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqlDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SqlDataServiceFileDescriptorSupplier())
                      .addMethod(getStreamSqlDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
