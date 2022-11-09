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
package com.google.cloud.contentwarehouse.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service lets you manage document schema.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/document_schema_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentSchemaServiceGrpc {

  private DocumentSchemaServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.contentwarehouse.v1.DocumentSchemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getCreateDocumentSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDocumentSchema",
      requestType = com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.DocumentSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getCreateDocumentSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest,
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        getCreateDocumentSchemaMethod;
    if ((getCreateDocumentSchemaMethod = DocumentSchemaServiceGrpc.getCreateDocumentSchemaMethod)
        == null) {
      synchronized (DocumentSchemaServiceGrpc.class) {
        if ((getCreateDocumentSchemaMethod =
                DocumentSchemaServiceGrpc.getCreateDocumentSchemaMethod)
            == null) {
          DocumentSchemaServiceGrpc.getCreateDocumentSchemaMethod =
              getCreateDocumentSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest,
                          com.google.cloud.contentwarehouse.v1.DocumentSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDocumentSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DocumentSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentSchemaServiceMethodDescriptorSupplier("CreateDocumentSchema"))
                      .build();
        }
      }
    }
    return getCreateDocumentSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getUpdateDocumentSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDocumentSchema",
      requestType = com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.DocumentSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getUpdateDocumentSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest,
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        getUpdateDocumentSchemaMethod;
    if ((getUpdateDocumentSchemaMethod = DocumentSchemaServiceGrpc.getUpdateDocumentSchemaMethod)
        == null) {
      synchronized (DocumentSchemaServiceGrpc.class) {
        if ((getUpdateDocumentSchemaMethod =
                DocumentSchemaServiceGrpc.getUpdateDocumentSchemaMethod)
            == null) {
          DocumentSchemaServiceGrpc.getUpdateDocumentSchemaMethod =
              getUpdateDocumentSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest,
                          com.google.cloud.contentwarehouse.v1.DocumentSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDocumentSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DocumentSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentSchemaServiceMethodDescriptorSupplier("UpdateDocumentSchema"))
                      .build();
        }
      }
    }
    return getUpdateDocumentSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getGetDocumentSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDocumentSchema",
      requestType = com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.DocumentSchema.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest,
          com.google.cloud.contentwarehouse.v1.DocumentSchema>
      getGetDocumentSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest,
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        getGetDocumentSchemaMethod;
    if ((getGetDocumentSchemaMethod = DocumentSchemaServiceGrpc.getGetDocumentSchemaMethod)
        == null) {
      synchronized (DocumentSchemaServiceGrpc.class) {
        if ((getGetDocumentSchemaMethod = DocumentSchemaServiceGrpc.getGetDocumentSchemaMethod)
            == null) {
          DocumentSchemaServiceGrpc.getGetDocumentSchemaMethod =
              getGetDocumentSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest,
                          com.google.cloud.contentwarehouse.v1.DocumentSchema>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDocumentSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DocumentSchema
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentSchemaServiceMethodDescriptorSupplier("GetDocumentSchema"))
                      .build();
        }
      }
    }
    return getGetDocumentSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest,
          com.google.protobuf.Empty>
      getDeleteDocumentSchemaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDocumentSchema",
      requestType = com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest,
          com.google.protobuf.Empty>
      getDeleteDocumentSchemaMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest,
            com.google.protobuf.Empty>
        getDeleteDocumentSchemaMethod;
    if ((getDeleteDocumentSchemaMethod = DocumentSchemaServiceGrpc.getDeleteDocumentSchemaMethod)
        == null) {
      synchronized (DocumentSchemaServiceGrpc.class) {
        if ((getDeleteDocumentSchemaMethod =
                DocumentSchemaServiceGrpc.getDeleteDocumentSchemaMethod)
            == null) {
          DocumentSchemaServiceGrpc.getDeleteDocumentSchemaMethod =
              getDeleteDocumentSchemaMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDocumentSchema"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentSchemaServiceMethodDescriptorSupplier("DeleteDocumentSchema"))
                      .build();
        }
      }
    }
    return getDeleteDocumentSchemaMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest,
          com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
      getListDocumentSchemasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDocumentSchemas",
      requestType = com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest,
          com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
      getListDocumentSchemasMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest,
            com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
        getListDocumentSchemasMethod;
    if ((getListDocumentSchemasMethod = DocumentSchemaServiceGrpc.getListDocumentSchemasMethod)
        == null) {
      synchronized (DocumentSchemaServiceGrpc.class) {
        if ((getListDocumentSchemasMethod = DocumentSchemaServiceGrpc.getListDocumentSchemasMethod)
            == null) {
          DocumentSchemaServiceGrpc.getListDocumentSchemasMethod =
              getListDocumentSchemasMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest,
                          com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDocumentSchemas"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentSchemaServiceMethodDescriptorSupplier("ListDocumentSchemas"))
                      .build();
        }
      }
    }
    return getListDocumentSchemasMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentSchemaServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceStub>() {
          @java.lang.Override
          public DocumentSchemaServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentSchemaServiceStub(channel, callOptions);
          }
        };
    return DocumentSchemaServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentSchemaServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceBlockingStub>() {
          @java.lang.Override
          public DocumentSchemaServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentSchemaServiceBlockingStub(channel, callOptions);
          }
        };
    return DocumentSchemaServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentSchemaServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentSchemaServiceFutureStub>() {
          @java.lang.Override
          public DocumentSchemaServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentSchemaServiceFutureStub(channel, callOptions);
          }
        };
    return DocumentSchemaServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage document schema.
   * </pre>
   */
  public abstract static class DocumentSchemaServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a document schema.
     * </pre>
     */
    public void createDocumentSchema(
        com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDocumentSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the
     * Document Schema is non-empty and does not equal the existing name.
     * Supports only appending new properties, adding new ENUM possible values,
     * and updating the [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled] flag for
     * ENUM possible values. Updating existing properties will result into
     * INVALID_ARGUMENT.
     * </pre>
     */
    public void updateDocumentSchema(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDocumentSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a document schema. Returns NOT_FOUND if the document schema does not
     * exist.
     * </pre>
     */
    public void getDocumentSchema(
        com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDocumentSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document schema. Returns NOT_FOUND if the document schema does
     * not exist. Returns BAD_REQUEST if the document schema has documents
     * depending on it.
     * </pre>
     */
    public void deleteDocumentSchema(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDocumentSchemaMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists document schemas.
     * </pre>
     */
    public void listDocumentSchemas(
        com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDocumentSchemasMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateDocumentSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest,
                      com.google.cloud.contentwarehouse.v1.DocumentSchema>(
                      this, METHODID_CREATE_DOCUMENT_SCHEMA)))
          .addMethod(
              getUpdateDocumentSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest,
                      com.google.cloud.contentwarehouse.v1.DocumentSchema>(
                      this, METHODID_UPDATE_DOCUMENT_SCHEMA)))
          .addMethod(
              getGetDocumentSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest,
                      com.google.cloud.contentwarehouse.v1.DocumentSchema>(
                      this, METHODID_GET_DOCUMENT_SCHEMA)))
          .addMethod(
              getDeleteDocumentSchemaMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DOCUMENT_SCHEMA)))
          .addMethod(
              getListDocumentSchemasMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest,
                      com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>(
                      this, METHODID_LIST_DOCUMENT_SCHEMAS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage document schema.
   * </pre>
   */
  public static final class DocumentSchemaServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentSchemaServiceStub> {
    private DocumentSchemaServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentSchemaServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentSchemaServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a document schema.
     * </pre>
     */
    public void createDocumentSchema(
        com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDocumentSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the
     * Document Schema is non-empty and does not equal the existing name.
     * Supports only appending new properties, adding new ENUM possible values,
     * and updating the [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled] flag for
     * ENUM possible values. Updating existing properties will result into
     * INVALID_ARGUMENT.
     * </pre>
     */
    public void updateDocumentSchema(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDocumentSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a document schema. Returns NOT_FOUND if the document schema does not
     * exist.
     * </pre>
     */
    public void getDocumentSchema(
        com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDocumentSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document schema. Returns NOT_FOUND if the document schema does
     * not exist. Returns BAD_REQUEST if the document schema has documents
     * depending on it.
     * </pre>
     */
    public void deleteDocumentSchema(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDocumentSchemaMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists document schemas.
     * </pre>
     */
    public void listDocumentSchemas(
        com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDocumentSchemasMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage document schema.
   * </pre>
   */
  public static final class DocumentSchemaServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentSchemaServiceBlockingStub> {
    private DocumentSchemaServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentSchemaServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentSchemaServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a document schema.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.DocumentSchema createDocumentSchema(
        com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDocumentSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the
     * Document Schema is non-empty and does not equal the existing name.
     * Supports only appending new properties, adding new ENUM possible values,
     * and updating the [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled] flag for
     * ENUM possible values. Updating existing properties will result into
     * INVALID_ARGUMENT.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.DocumentSchema updateDocumentSchema(
        com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDocumentSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a document schema. Returns NOT_FOUND if the document schema does not
     * exist.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.DocumentSchema getDocumentSchema(
        com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDocumentSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document schema. Returns NOT_FOUND if the document schema does
     * not exist. Returns BAD_REQUEST if the document schema has documents
     * depending on it.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDocumentSchema(
        com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDocumentSchemaMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists document schemas.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse listDocumentSchemas(
        com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDocumentSchemasMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * This service lets you manage document schema.
   * </pre>
   */
  public static final class DocumentSchemaServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentSchemaServiceFutureStub> {
    private DocumentSchemaServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentSchemaServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentSchemaServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a document schema.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        createDocumentSchema(
            com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDocumentSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Document Schema. Returns INVALID_ARGUMENT if the name of the
     * Document Schema is non-empty and does not equal the existing name.
     * Supports only appending new properties, adding new ENUM possible values,
     * and updating the [EnumTypeOptions.validation_check_disabled][google.cloud.contentwarehouse.v1.EnumTypeOptions.validation_check_disabled] flag for
     * ENUM possible values. Updating existing properties will result into
     * INVALID_ARGUMENT.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        updateDocumentSchema(
            com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDocumentSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a document schema. Returns NOT_FOUND if the document schema does not
     * exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.DocumentSchema>
        getDocumentSchema(com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDocumentSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a document schema. Returns NOT_FOUND if the document schema does
     * not exist. Returns BAD_REQUEST if the document schema has documents
     * depending on it.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDocumentSchema(
            com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDocumentSchemaMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists document schemas.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>
        listDocumentSchemas(
            com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDocumentSchemasMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DOCUMENT_SCHEMA = 0;
  private static final int METHODID_UPDATE_DOCUMENT_SCHEMA = 1;
  private static final int METHODID_GET_DOCUMENT_SCHEMA = 2;
  private static final int METHODID_DELETE_DOCUMENT_SCHEMA = 3;
  private static final int METHODID_LIST_DOCUMENT_SCHEMAS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentSchemaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentSchemaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DOCUMENT_SCHEMA:
          serviceImpl.createDocumentSchema(
              (com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DOCUMENT_SCHEMA:
          serviceImpl.updateDocumentSchema(
              (com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>)
                  responseObserver);
          break;
        case METHODID_GET_DOCUMENT_SCHEMA:
          serviceImpl.getDocumentSchema(
              (com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.DocumentSchema>)
                  responseObserver);
          break;
        case METHODID_DELETE_DOCUMENT_SCHEMA:
          serviceImpl.deleteDocumentSchema(
              (com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_DOCUMENT_SCHEMAS:
          serviceImpl.listDocumentSchemas(
              (com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse>)
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

  private abstract static class DocumentSchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentSchemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.DocumentSchemaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentSchemaService");
    }
  }

  private static final class DocumentSchemaServiceFileDescriptorSupplier
      extends DocumentSchemaServiceBaseDescriptorSupplier {
    DocumentSchemaServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentSchemaServiceMethodDescriptorSupplier
      extends DocumentSchemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentSchemaServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DocumentSchemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentSchemaServiceFileDescriptorSupplier())
                      .addMethod(getCreateDocumentSchemaMethod())
                      .addMethod(getUpdateDocumentSchemaMethod())
                      .addMethod(getGetDocumentSchemaMethod())
                      .addMethod(getDeleteDocumentSchemaMethod())
                      .addMethod(getListDocumentSchemasMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
