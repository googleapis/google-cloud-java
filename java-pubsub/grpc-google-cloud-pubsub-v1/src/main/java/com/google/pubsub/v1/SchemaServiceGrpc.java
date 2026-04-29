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
package com.google.pubsub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for doing schema-related operations.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class SchemaServiceGrpc {

  private SchemaServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.pubsub.v1.SchemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSchemaRequest, com.google.pubsub.v1.Schema>
      getCreateSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSchema",
      requestType = com.google.pubsub.v1.CreateSchemaRequest.class,
      responseType = com.google.pubsub.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CreateSchemaRequest, com.google.pubsub.v1.Schema>
      getCreateSchemaMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.CreateSchemaRequest, com.google.pubsub.v1.Schema>
        getCreateSchemaMethod;
    if ((getCreateSchemaMethod = SchemaServiceGrpc.getCreateSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getCreateSchemaMethod = SchemaServiceGrpc.getCreateSchemaMethod) == null) {
          SchemaServiceGrpc.getCreateSchemaMethod =
              getCreateSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.CreateSchemaRequest, com.google.pubsub.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.CreateSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("CreateSchema"))
                      .build();
        }
      }
    }
    return getCreateSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSchemaRequest, com.google.pubsub.v1.Schema>
      getGetSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchema",
      requestType = com.google.pubsub.v1.GetSchemaRequest.class,
      responseType = com.google.pubsub.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.GetSchemaRequest, com.google.pubsub.v1.Schema>
      getGetSchemaMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.GetSchemaRequest, com.google.pubsub.v1.Schema>
        getGetSchemaMethod;
    if ((getGetSchemaMethod = SchemaServiceGrpc.getGetSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getGetSchemaMethod = SchemaServiceGrpc.getGetSchemaMethod) == null) {
          SchemaServiceGrpc.getGetSchemaMethod =
              getGetSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.GetSchemaRequest, com.google.pubsub.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.GetSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("GetSchema"))
                      .build();
        }
      }
    }
    return getGetSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSchemasRequest, com.google.pubsub.v1.ListSchemasResponse>
      getListSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSchemas",
      requestType = com.google.pubsub.v1.ListSchemasRequest.class,
      responseType = com.google.pubsub.v1.ListSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSchemasRequest, com.google.pubsub.v1.ListSchemasResponse>
      getListSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListSchemasRequest, com.google.pubsub.v1.ListSchemasResponse>
        getListSchemasMethod;
    if ((getListSchemasMethod = SchemaServiceGrpc.getListSchemasMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getListSchemasMethod = SchemaServiceGrpc.getListSchemasMethod) == null) {
          SchemaServiceGrpc.getListSchemasMethod =
              getListSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListSchemasRequest,
                          com.google.pubsub.v1.ListSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSchemasRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSchemasResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SchemaServiceMethodDescriptorSupplier("ListSchemas"))
                      .build();
        }
      }
    }
    return getListSchemasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSchemaRevisionsRequest,
          com.google.pubsub.v1.ListSchemaRevisionsResponse>
      getListSchemaRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSchemaRevisions",
      requestType = com.google.pubsub.v1.ListSchemaRevisionsRequest.class,
      responseType = com.google.pubsub.v1.ListSchemaRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ListSchemaRevisionsRequest,
          com.google.pubsub.v1.ListSchemaRevisionsResponse>
      getListSchemaRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ListSchemaRevisionsRequest,
            com.google.pubsub.v1.ListSchemaRevisionsResponse>
        getListSchemaRevisionsMethod;
    if ((getListSchemaRevisionsMethod = SchemaServiceGrpc.getListSchemaRevisionsMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getListSchemaRevisionsMethod = SchemaServiceGrpc.getListSchemaRevisionsMethod)
            == null) {
          SchemaServiceGrpc.getListSchemaRevisionsMethod =
              getListSchemaRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ListSchemaRevisionsRequest,
                          com.google.pubsub.v1.ListSchemaRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListSchemaRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSchemaRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ListSchemaRevisionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("ListSchemaRevisions"))
                      .build();
        }
      }
    }
    return getListSchemaRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CommitSchemaRequest, com.google.pubsub.v1.Schema>
      getCommitSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CommitSchema",
      requestType = com.google.pubsub.v1.CommitSchemaRequest.class,
      responseType = com.google.pubsub.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.CommitSchemaRequest, com.google.pubsub.v1.Schema>
      getCommitSchemaMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.CommitSchemaRequest, com.google.pubsub.v1.Schema>
        getCommitSchemaMethod;
    if ((getCommitSchemaMethod = SchemaServiceGrpc.getCommitSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getCommitSchemaMethod = SchemaServiceGrpc.getCommitSchemaMethod) == null) {
          SchemaServiceGrpc.getCommitSchemaMethod =
              getCommitSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.CommitSchemaRequest, com.google.pubsub.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CommitSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.CommitSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("CommitSchema"))
                      .build();
        }
      }
    }
    return getCommitSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.RollbackSchemaRequest, com.google.pubsub.v1.Schema>
      getRollbackSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RollbackSchema",
      requestType = com.google.pubsub.v1.RollbackSchemaRequest.class,
      responseType = com.google.pubsub.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.RollbackSchemaRequest, com.google.pubsub.v1.Schema>
      getRollbackSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.RollbackSchemaRequest, com.google.pubsub.v1.Schema>
        getRollbackSchemaMethod;
    if ((getRollbackSchemaMethod = SchemaServiceGrpc.getRollbackSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getRollbackSchemaMethod = SchemaServiceGrpc.getRollbackSchemaMethod) == null) {
          SchemaServiceGrpc.getRollbackSchemaMethod =
              getRollbackSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.RollbackSchemaRequest, com.google.pubsub.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RollbackSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.RollbackSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("RollbackSchema"))
                      .build();
        }
      }
    }
    return getRollbackSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSchemaRevisionRequest, com.google.pubsub.v1.Schema>
      getDeleteSchemaRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSchemaRevision",
      requestType = com.google.pubsub.v1.DeleteSchemaRevisionRequest.class,
      responseType = com.google.pubsub.v1.Schema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSchemaRevisionRequest, com.google.pubsub.v1.Schema>
      getDeleteSchemaRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.DeleteSchemaRevisionRequest, com.google.pubsub.v1.Schema>
        getDeleteSchemaRevisionMethod;
    if ((getDeleteSchemaRevisionMethod = SchemaServiceGrpc.getDeleteSchemaRevisionMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getDeleteSchemaRevisionMethod = SchemaServiceGrpc.getDeleteSchemaRevisionMethod)
            == null) {
          SchemaServiceGrpc.getDeleteSchemaRevisionMethod =
              getDeleteSchemaRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DeleteSchemaRevisionRequest,
                          com.google.pubsub.v1.Schema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteSchemaRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DeleteSchemaRevisionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.Schema.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("DeleteSchemaRevision"))
                      .build();
        }
      }
    }
    return getDeleteSchemaRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSchemaRequest, com.google.protobuf.Empty>
      getDeleteSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSchema",
      requestType = com.google.pubsub.v1.DeleteSchemaRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.DeleteSchemaRequest, com.google.protobuf.Empty>
      getDeleteSchemaMethod() {
    io.grpc.MethodDescriptor<com.google.pubsub.v1.DeleteSchemaRequest, com.google.protobuf.Empty>
        getDeleteSchemaMethod;
    if ((getDeleteSchemaMethod = SchemaServiceGrpc.getDeleteSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getDeleteSchemaMethod = SchemaServiceGrpc.getDeleteSchemaMethod) == null) {
          SchemaServiceGrpc.getDeleteSchemaMethod =
              getDeleteSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.DeleteSchemaRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.DeleteSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("DeleteSchema"))
                      .build();
        }
      }
    }
    return getDeleteSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ValidateSchemaRequest, com.google.pubsub.v1.ValidateSchemaResponse>
      getValidateSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateSchema",
      requestType = com.google.pubsub.v1.ValidateSchemaRequest.class,
      responseType = com.google.pubsub.v1.ValidateSchemaResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ValidateSchemaRequest, com.google.pubsub.v1.ValidateSchemaResponse>
      getValidateSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ValidateSchemaRequest, com.google.pubsub.v1.ValidateSchemaResponse>
        getValidateSchemaMethod;
    if ((getValidateSchemaMethod = SchemaServiceGrpc.getValidateSchemaMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getValidateSchemaMethod = SchemaServiceGrpc.getValidateSchemaMethod) == null) {
          SchemaServiceGrpc.getValidateSchemaMethod =
              getValidateSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ValidateSchemaRequest,
                          com.google.pubsub.v1.ValidateSchemaResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ValidateSchemaRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ValidateSchemaResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("ValidateSchema"))
                      .build();
        }
      }
    }
    return getValidateSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ValidateMessageRequest, com.google.pubsub.v1.ValidateMessageResponse>
      getValidateMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateMessage",
      requestType = com.google.pubsub.v1.ValidateMessageRequest.class,
      responseType = com.google.pubsub.v1.ValidateMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.pubsub.v1.ValidateMessageRequest, com.google.pubsub.v1.ValidateMessageResponse>
      getValidateMessageMethod() {
    io.grpc.MethodDescriptor<
            com.google.pubsub.v1.ValidateMessageRequest,
            com.google.pubsub.v1.ValidateMessageResponse>
        getValidateMessageMethod;
    if ((getValidateMessageMethod = SchemaServiceGrpc.getValidateMessageMethod) == null) {
      synchronized (SchemaServiceGrpc.class) {
        if ((getValidateMessageMethod = SchemaServiceGrpc.getValidateMessageMethod) == null) {
          SchemaServiceGrpc.getValidateMessageMethod =
              getValidateMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.pubsub.v1.ValidateMessageRequest,
                          com.google.pubsub.v1.ValidateMessageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ValidateMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.pubsub.v1.ValidateMessageResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SchemaServiceMethodDescriptorSupplier("ValidateMessage"))
                      .build();
        }
      }
    }
    return getValidateMessageMethod;
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

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static SchemaServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SchemaServiceBlockingV2Stub>() {
          @java.lang.Override
          public SchemaServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SchemaServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return SchemaServiceBlockingV2Stub.newStub(factory, channel);
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
   * Service for doing schema-related operations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a schema.
     * </pre>
     */
    default void createSchema(
        com.google.pubsub.v1.CreateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a schema.
     * </pre>
     */
    default void getSchema(
        com.google.pubsub.v1.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists schemas in a project.
     * </pre>
     */
    default void listSchemas(
        com.google.pubsub.v1.ListSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemasResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSchemasMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all schema revisions for the named schema.
     * </pre>
     */
    default void listSchemaRevisions(
        com.google.pubsub.v1.ListSchemaRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemaRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSchemaRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a new schema revision to an existing schema.
     * </pre>
     */
    default void commitSchema(
        com.google.pubsub.v1.CommitSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCommitSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new schema revision that is a copy of the provided revision_id.
     * </pre>
     */
    default void rollbackSchema(
        com.google.pubsub.v1.RollbackSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRollbackSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific schema revision.
     * </pre>
     */
    default void deleteSchemaRevision(
        com.google.pubsub.v1.DeleteSchemaRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSchemaRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a schema.
     * </pre>
     */
    default void deleteSchema(
        com.google.pubsub.v1.DeleteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates a schema.
     * </pre>
     */
    default void validateSchema(
        com.google.pubsub.v1.ValidateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateSchemaResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates a message against a schema.
     * </pre>
     */
    default void validateMessage(
        com.google.pubsub.v1.ValidateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateMessageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SchemaService.
   *
   * <pre>
   * Service for doing schema-related operations.
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
   * Service for doing schema-related operations.
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
     * Creates a schema.
     * </pre>
     */
    public void createSchema(
        com.google.pubsub.v1.CreateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a schema.
     * </pre>
     */
    public void getSchema(
        com.google.pubsub.v1.GetSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists schemas in a project.
     * </pre>
     */
    public void listSchemas(
        com.google.pubsub.v1.ListSchemasRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemasResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all schema revisions for the named schema.
     * </pre>
     */
    public void listSchemaRevisions(
        com.google.pubsub.v1.ListSchemaRevisionsRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemaRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSchemaRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Commits a new schema revision to an existing schema.
     * </pre>
     */
    public void commitSchema(
        com.google.pubsub.v1.CommitSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new schema revision that is a copy of the provided revision_id.
     * </pre>
     */
    public void rollbackSchema(
        com.google.pubsub.v1.RollbackSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific schema revision.
     * </pre>
     */
    public void deleteSchemaRevision(
        com.google.pubsub.v1.DeleteSchemaRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSchemaRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a schema.
     * </pre>
     */
    public void deleteSchema(
        com.google.pubsub.v1.DeleteSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates a schema.
     * </pre>
     */
    public void validateSchema(
        com.google.pubsub.v1.ValidateSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateSchemaResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Validates a message against a schema.
     * </pre>
     */
    public void validateMessage(
        com.google.pubsub.v1.ValidateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateMessageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SchemaService.
   *
   * <pre>
   * Service for doing schema-related operations.
   * </pre>
   */
  public static final class SchemaServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<SchemaServiceBlockingV2Stub> {
    private SchemaServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SchemaServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SchemaServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema createSchema(
        com.google.pubsub.v1.CreateSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema getSchema(com.google.pubsub.v1.GetSchemaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists schemas in a project.
     * </pre>
     */
    public com.google.pubsub.v1.ListSchemasResponse listSchemas(
        com.google.pubsub.v1.ListSchemasRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all schema revisions for the named schema.
     * </pre>
     */
    public com.google.pubsub.v1.ListSchemaRevisionsResponse listSchemaRevisions(
        com.google.pubsub.v1.ListSchemaRevisionsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSchemaRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a new schema revision to an existing schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema commitSchema(
        com.google.pubsub.v1.CommitSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCommitSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new schema revision that is a copy of the provided revision_id.
     * </pre>
     */
    public com.google.pubsub.v1.Schema rollbackSchema(
        com.google.pubsub.v1.RollbackSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRollbackSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific schema revision.
     * </pre>
     */
    public com.google.pubsub.v1.Schema deleteSchemaRevision(
        com.google.pubsub.v1.DeleteSchemaRevisionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSchemaRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a schema.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSchema(com.google.pubsub.v1.DeleteSchemaRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a schema.
     * </pre>
     */
    public com.google.pubsub.v1.ValidateSchemaResponse validateSchema(
        com.google.pubsub.v1.ValidateSchemaRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getValidateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a message against a schema.
     * </pre>
     */
    public com.google.pubsub.v1.ValidateMessageResponse validateMessage(
        com.google.pubsub.v1.ValidateMessageRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getValidateMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service SchemaService.
   *
   * <pre>
   * Service for doing schema-related operations.
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
     * Creates a schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema createSchema(
        com.google.pubsub.v1.CreateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema getSchema(com.google.pubsub.v1.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists schemas in a project.
     * </pre>
     */
    public com.google.pubsub.v1.ListSchemasResponse listSchemas(
        com.google.pubsub.v1.ListSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSchemasMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all schema revisions for the named schema.
     * </pre>
     */
    public com.google.pubsub.v1.ListSchemaRevisionsResponse listSchemaRevisions(
        com.google.pubsub.v1.ListSchemaRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSchemaRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a new schema revision to an existing schema.
     * </pre>
     */
    public com.google.pubsub.v1.Schema commitSchema(
        com.google.pubsub.v1.CommitSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new schema revision that is a copy of the provided revision_id.
     * </pre>
     */
    public com.google.pubsub.v1.Schema rollbackSchema(
        com.google.pubsub.v1.RollbackSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific schema revision.
     * </pre>
     */
    public com.google.pubsub.v1.Schema deleteSchemaRevision(
        com.google.pubsub.v1.DeleteSchemaRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSchemaRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a schema.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSchema(
        com.google.pubsub.v1.DeleteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a schema.
     * </pre>
     */
    public com.google.pubsub.v1.ValidateSchemaResponse validateSchema(
        com.google.pubsub.v1.ValidateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a message against a schema.
     * </pre>
     */
    public com.google.pubsub.v1.ValidateMessageResponse validateMessage(
        com.google.pubsub.v1.ValidateMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SchemaService.
   *
   * <pre>
   * Service for doing schema-related operations.
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
     * Creates a schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Schema>
        createSchema(com.google.pubsub.v1.CreateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Schema>
        getSchema(com.google.pubsub.v1.GetSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists schemas in a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListSchemasResponse>
        listSchemas(com.google.pubsub.v1.ListSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSchemasMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all schema revisions for the named schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ListSchemaRevisionsResponse>
        listSchemaRevisions(com.google.pubsub.v1.ListSchemaRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSchemaRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Commits a new schema revision to an existing schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Schema>
        commitSchema(com.google.pubsub.v1.CommitSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new schema revision that is a copy of the provided revision_id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Schema>
        rollbackSchema(com.google.pubsub.v1.RollbackSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific schema revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.pubsub.v1.Schema>
        deleteSchemaRevision(com.google.pubsub.v1.DeleteSchemaRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSchemaRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSchema(com.google.pubsub.v1.DeleteSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ValidateSchemaResponse>
        validateSchema(com.google.pubsub.v1.ValidateSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Validates a message against a schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.pubsub.v1.ValidateMessageResponse>
        validateMessage(com.google.pubsub.v1.ValidateMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SCHEMA = 0;
  private static final int METHODID_GET_SCHEMA = 1;
  private static final int METHODID_LIST_SCHEMAS = 2;
  private static final int METHODID_LIST_SCHEMA_REVISIONS = 3;
  private static final int METHODID_COMMIT_SCHEMA = 4;
  private static final int METHODID_ROLLBACK_SCHEMA = 5;
  private static final int METHODID_DELETE_SCHEMA_REVISION = 6;
  private static final int METHODID_DELETE_SCHEMA = 7;
  private static final int METHODID_VALIDATE_SCHEMA = 8;
  private static final int METHODID_VALIDATE_MESSAGE = 9;

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
        case METHODID_CREATE_SCHEMA:
          serviceImpl.createSchema(
              (com.google.pubsub.v1.CreateSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema>) responseObserver);
          break;
        case METHODID_GET_SCHEMA:
          serviceImpl.getSchema(
              (com.google.pubsub.v1.GetSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema>) responseObserver);
          break;
        case METHODID_LIST_SCHEMAS:
          serviceImpl.listSchemas(
              (com.google.pubsub.v1.ListSchemasRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemasResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SCHEMA_REVISIONS:
          serviceImpl.listSchemaRevisions(
              (com.google.pubsub.v1.ListSchemaRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ListSchemaRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_COMMIT_SCHEMA:
          serviceImpl.commitSchema(
              (com.google.pubsub.v1.CommitSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema>) responseObserver);
          break;
        case METHODID_ROLLBACK_SCHEMA:
          serviceImpl.rollbackSchema(
              (com.google.pubsub.v1.RollbackSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema>) responseObserver);
          break;
        case METHODID_DELETE_SCHEMA_REVISION:
          serviceImpl.deleteSchemaRevision(
              (com.google.pubsub.v1.DeleteSchemaRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.Schema>) responseObserver);
          break;
        case METHODID_DELETE_SCHEMA:
          serviceImpl.deleteSchema(
              (com.google.pubsub.v1.DeleteSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_VALIDATE_SCHEMA:
          serviceImpl.validateSchema(
              (com.google.pubsub.v1.ValidateSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateSchemaResponse>)
                  responseObserver);
          break;
        case METHODID_VALIDATE_MESSAGE:
          serviceImpl.validateMessage(
              (com.google.pubsub.v1.ValidateMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.pubsub.v1.ValidateMessageResponse>)
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
            getCreateSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.CreateSchemaRequest, com.google.pubsub.v1.Schema>(
                    service, METHODID_CREATE_SCHEMA)))
        .addMethod(
            getGetSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.GetSchemaRequest, com.google.pubsub.v1.Schema>(
                    service, METHODID_GET_SCHEMA)))
        .addMethod(
            getListSchemasMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListSchemasRequest,
                    com.google.pubsub.v1.ListSchemasResponse>(service, METHODID_LIST_SCHEMAS)))
        .addMethod(
            getListSchemaRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ListSchemaRevisionsRequest,
                    com.google.pubsub.v1.ListSchemaRevisionsResponse>(
                    service, METHODID_LIST_SCHEMA_REVISIONS)))
        .addMethod(
            getCommitSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.CommitSchemaRequest, com.google.pubsub.v1.Schema>(
                    service, METHODID_COMMIT_SCHEMA)))
        .addMethod(
            getRollbackSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.RollbackSchemaRequest, com.google.pubsub.v1.Schema>(
                    service, METHODID_ROLLBACK_SCHEMA)))
        .addMethod(
            getDeleteSchemaRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DeleteSchemaRevisionRequest, com.google.pubsub.v1.Schema>(
                    service, METHODID_DELETE_SCHEMA_REVISION)))
        .addMethod(
            getDeleteSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.DeleteSchemaRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SCHEMA)))
        .addMethod(
            getValidateSchemaMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ValidateSchemaRequest,
                    com.google.pubsub.v1.ValidateSchemaResponse>(
                    service, METHODID_VALIDATE_SCHEMA)))
        .addMethod(
            getValidateMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.pubsub.v1.ValidateMessageRequest,
                    com.google.pubsub.v1.ValidateMessageResponse>(
                    service, METHODID_VALIDATE_MESSAGE)))
        .build();
  }

  private abstract static class SchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SchemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.pubsub.v1.SchemaProto.getDescriptor();
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
                      .addMethod(getCreateSchemaMethod())
                      .addMethod(getGetSchemaMethod())
                      .addMethod(getListSchemasMethod())
                      .addMethod(getListSchemaRevisionsMethod())
                      .addMethod(getCommitSchemaMethod())
                      .addMethod(getRollbackSchemaMethod())
                      .addMethod(getDeleteSchemaRevisionMethod())
                      .addMethod(getDeleteSchemaMethod())
                      .addMethod(getValidateSchemaMethod())
                      .addMethod(getValidateMessageMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
