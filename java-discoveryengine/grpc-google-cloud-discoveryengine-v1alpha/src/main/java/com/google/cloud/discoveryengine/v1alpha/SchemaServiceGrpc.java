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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/schema_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SchemaServiceGrpc {

  private SchemaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.SchemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest,
          com.google.cloud.discoveryengine.v1alpha.Schema>
      getGetSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchema",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest,
          com.google.cloud.discoveryengine.v1alpha.Schema>
      getGetSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest,
            com.google.cloud.discoveryengine.v1alpha.Schema>
        getGetSchemaMethod;
    if ((getGetSchemaMethod = SchemaServiceGrpc.getGetSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getGetSchemaMethod = SchemaServiceGrpc.getGetSchemaMethod) == null) {
          SchemaServiceGrpc.getGetSchemaMethod =
              getGetSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest,
                          com.google.cloud.discoveryengine.v1alpha.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("GetSchema"))
                      .build();
        }
      }
    }
    return getGetSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
      getListSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSchemas",
      requestType = com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest,
          com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
      getListSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest,
            com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
        getListSchemasMethod;
    if ((getListSchemasMethod = SchemaServiceGrpc.getListSchemasMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getListSchemasMethod = SchemaServiceGrpc.getListSchemasMethod) == null) {
          SchemaServiceGrpc.getListSchemasMethod =
              getListSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest,
                          com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ListSchemas"))
                      .build();
        }
      }
    }
    return getListSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest,
          com.google.longrunning.Operation>
      getCreateSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSchema",
      requestType = com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest,
          com.google.longrunning.Operation>
      getCreateSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest,
            com.google.longrunning.Operation>
        getCreateSchemaMethod;
    if ((getCreateSchemaMethod = SchemaServiceGrpc.getCreateSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getCreateSchemaMethod = SchemaServiceGrpc.getCreateSchemaMethod) == null) {
          SchemaServiceGrpc.getCreateSchemaMethod =
              getCreateSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("CreateSchema"))
                      .build();
        }
      }
    }
    return getCreateSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest,
          com.google.longrunning.Operation>
      getUpdateSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSchema",
      requestType = com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest,
          com.google.longrunning.Operation>
      getUpdateSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest,
            com.google.longrunning.Operation>
        getUpdateSchemaMethod;
    if ((getUpdateSchemaMethod = SchemaServiceGrpc.getUpdateSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getUpdateSchemaMethod = SchemaServiceGrpc.getUpdateSchemaMethod) == null) {
          SchemaServiceGrpc.getUpdateSchemaMethod =
              getUpdateSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("UpdateSchema"))
                      .build();
        }
      }
    }
    return getUpdateSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest,
          com.google.longrunning.Operation>
      getDeleteSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSchema",
      requestType = com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest,
          com.google.longrunning.Operation>
      getDeleteSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest,
            com.google.longrunning.Operation>
        getDeleteSchemaMethod;
    if ((getDeleteSchemaMethod = SchemaServiceGrpc.getDeleteSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getDeleteSchemaMethod = SchemaServiceGrpc.getDeleteSchemaMethod) == null) {
          SchemaServiceGrpc.getDeleteSchemaMethod =
              getDeleteSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("DeleteSchema"))
                      .build();
        }
      }
    }
    return getDeleteSchemaMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SchemaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceStub>() {
          @java.lang.Override
          public SchemaServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceStub(channel, callOptions);
          }
        };
    return SchemaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SchemaServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingStub>() {
          @java.lang.Override
          public SchemaServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceBlockingStub(channel, callOptions);
          }
        };
    return SchemaServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SchemaServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceFutureStub>() {
          @java.lang.Override
          public SchemaServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceFutureStub(channel, callOptions);
          }
        };
    return SchemaServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    default void getSchema(
        com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Schema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
     * </pre>
     */
    default void listSchemas(
        com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    default void createSchema(
        com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    default void updateSchema(
        com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    default void deleteSchema(
        com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSchemaMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SchemaService.
   *
   * <pre>
   * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
   * </pre>
   */
  public abstract static class SchemaServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SchemaServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SchemaService.
   *
   * <pre>
   * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
   * </pre>
   */
  public static final class SchemaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SchemaServiceStub> {
    private SchemaServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public void getSchema(
        com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Schema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
     * </pre>
     */
    public void listSchemas(
        com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public void createSchema(
        com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public void updateSchema(
        com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public void deleteSchema(
        com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SchemaService.
   *
   * <pre>
   * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
   * </pre>
   */
  public static final class SchemaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SchemaServiceBlockingStub> {
    private SchemaServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Schema getSchema(
        com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse listSchemas(
        com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.longrunning.Operation createSchema(
        com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.longrunning.Operation updateSchema(
        com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.longrunning.Operation deleteSchema(
        com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSchemaMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SchemaService.
   *
   * <pre>
   * Service for managing [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
   * </pre>
   */
  public static final class SchemaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SchemaServiceFutureStub> {
    private SchemaServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Schema>
        getSchema(com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a list of [Schema][google.cloud.discoveryengine.v1alpha.Schema]s.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>
        listSchemas(com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSchema(com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSchema(com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a [Schema][google.cloud.discoveryengine.v1alpha.Schema].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSchema(com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSchemaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SCHEMA = 0;
  private static final int METHODID_LIST_SCHEMAS = 1;
  private static final int METHODID_CREATE_SCHEMA = 2;
  private static final int METHODID_UPDATE_SCHEMA = 3;
  private static final int METHODID_DELETE_SCHEMA = 4;

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
        case METHODID_GET_SCHEMA:
          serviceImpl.getSchema(
              (com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Schema>)
                  responseObserver);
          break;
        case METHODID_LIST_SCHEMAS:
          serviceImpl.listSchemas(
              (com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_SCHEMA:
          serviceImpl.createSchema(
              (com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SCHEMA:
          serviceImpl.updateSchema(
              (com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SCHEMA:
          serviceImpl.deleteSchema(
              (com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getGetSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.GetSchemaRequest,
                    com.google.cloud.discoveryengine.v1alpha.Schema>(service, METHODID_GET_SCHEMA)))
        .addMethod(
            getListSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ListSchemasRequest,
                    com.google.cloud.discoveryengine.v1alpha.ListSchemasResponse>(
                    service, METHODID_LIST_SCHEMAS)))
        .addMethod(
            getCreateSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.CreateSchemaRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SCHEMA)))
        .addMethod(
            getUpdateSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.UpdateSchemaRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SCHEMA)))
        .addMethod(
            getDeleteSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.DeleteSchemaRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SCHEMA)))
        .build();
  }

  private abstract static class SchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SchemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.SchemaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SchemaService");
    }
  }

  private static final class SchemaServiceFileDescriptorSupplier
      extends SchemaServiceBaseDescriptorSupplier {
    SchemaServiceFileDescriptorSupplier() {}
  }

  private static final class SchemaServiceMethodDescriptorSupplier
      extends SchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SchemaServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SchemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SchemaServiceFileDescriptorSupplier())
                      .addMethod(getGetSchemaMethod())
                      .addMethod(getListSchemasMethod())
                      .addMethod(getCreateSchemaMethod())
                      .addMethod(getUpdateSchemaMethod())
                      .addMethod(getDeleteSchemaMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
