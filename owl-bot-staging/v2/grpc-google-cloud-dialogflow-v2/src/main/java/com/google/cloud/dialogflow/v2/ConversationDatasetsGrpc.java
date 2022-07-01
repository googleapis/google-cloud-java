package com.google.cloud.dialogflow.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Conversation datasets.
 * Conversation datasets contain raw conversation files and their
 * customizable metadata that can be used for model training.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/conversation_dataset.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConversationDatasetsGrpc {

  private ConversationDatasetsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2.ConversationDatasets";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest,
      com.google.longrunning.Operation> getCreateConversationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversationDataset",
      requestType = com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest,
      com.google.longrunning.Operation> getCreateConversationDatasetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest, com.google.longrunning.Operation> getCreateConversationDatasetMethod;
    if ((getCreateConversationDatasetMethod = ConversationDatasetsGrpc.getCreateConversationDatasetMethod) == null) {
      synchronized (ConversationDatasetsGrpc.class) {
        if ((getCreateConversationDatasetMethod = ConversationDatasetsGrpc.getCreateConversationDatasetMethod) == null) {
          ConversationDatasetsGrpc.getCreateConversationDatasetMethod = getCreateConversationDatasetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversationDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationDatasetsMethodDescriptorSupplier("CreateConversationDataset"))
              .build();
        }
      }
    }
    return getCreateConversationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationDatasetRequest,
      com.google.cloud.dialogflow.v2.ConversationDataset> getGetConversationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversationDataset",
      requestType = com.google.cloud.dialogflow.v2.GetConversationDatasetRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ConversationDataset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationDatasetRequest,
      com.google.cloud.dialogflow.v2.ConversationDataset> getGetConversationDatasetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.GetConversationDatasetRequest, com.google.cloud.dialogflow.v2.ConversationDataset> getGetConversationDatasetMethod;
    if ((getGetConversationDatasetMethod = ConversationDatasetsGrpc.getGetConversationDatasetMethod) == null) {
      synchronized (ConversationDatasetsGrpc.class) {
        if ((getGetConversationDatasetMethod = ConversationDatasetsGrpc.getGetConversationDatasetMethod) == null) {
          ConversationDatasetsGrpc.getGetConversationDatasetMethod = getGetConversationDatasetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.GetConversationDatasetRequest, com.google.cloud.dialogflow.v2.ConversationDataset>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversationDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.GetConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ConversationDataset.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationDatasetsMethodDescriptorSupplier("GetConversationDataset"))
              .build();
        }
      }
    }
    return getGetConversationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest,
      com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> getListConversationDatasetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversationDatasets",
      requestType = com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest,
      com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> getListConversationDatasetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest, com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> getListConversationDatasetsMethod;
    if ((getListConversationDatasetsMethod = ConversationDatasetsGrpc.getListConversationDatasetsMethod) == null) {
      synchronized (ConversationDatasetsGrpc.class) {
        if ((getListConversationDatasetsMethod = ConversationDatasetsGrpc.getListConversationDatasetsMethod) == null) {
          ConversationDatasetsGrpc.getListConversationDatasetsMethod = getListConversationDatasetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest, com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversationDatasets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationDatasetsMethodDescriptorSupplier("ListConversationDatasets"))
              .build();
        }
      }
    }
    return getListConversationDatasetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest,
      com.google.longrunning.Operation> getDeleteConversationDatasetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversationDataset",
      requestType = com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest,
      com.google.longrunning.Operation> getDeleteConversationDatasetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest, com.google.longrunning.Operation> getDeleteConversationDatasetMethod;
    if ((getDeleteConversationDatasetMethod = ConversationDatasetsGrpc.getDeleteConversationDatasetMethod) == null) {
      synchronized (ConversationDatasetsGrpc.class) {
        if ((getDeleteConversationDatasetMethod = ConversationDatasetsGrpc.getDeleteConversationDatasetMethod) == null) {
          ConversationDatasetsGrpc.getDeleteConversationDatasetMethod = getDeleteConversationDatasetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversationDataset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationDatasetsMethodDescriptorSupplier("DeleteConversationDataset"))
              .build();
        }
      }
    }
    return getDeleteConversationDatasetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportConversationDataRequest,
      com.google.longrunning.Operation> getImportConversationDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportConversationData",
      requestType = com.google.cloud.dialogflow.v2.ImportConversationDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportConversationDataRequest,
      com.google.longrunning.Operation> getImportConversationDataMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dialogflow.v2.ImportConversationDataRequest, com.google.longrunning.Operation> getImportConversationDataMethod;
    if ((getImportConversationDataMethod = ConversationDatasetsGrpc.getImportConversationDataMethod) == null) {
      synchronized (ConversationDatasetsGrpc.class) {
        if ((getImportConversationDataMethod = ConversationDatasetsGrpc.getImportConversationDataMethod) == null) {
          ConversationDatasetsGrpc.getImportConversationDataMethod = getImportConversationDataMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dialogflow.v2.ImportConversationDataRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportConversationData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dialogflow.v2.ImportConversationDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ConversationDatasetsMethodDescriptorSupplier("ImportConversationData"))
              .build();
        }
      }
    }
    return getImportConversationDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConversationDatasetsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsStub>() {
        @java.lang.Override
        public ConversationDatasetsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationDatasetsStub(channel, callOptions);
        }
      };
    return ConversationDatasetsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConversationDatasetsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsBlockingStub>() {
        @java.lang.Override
        public ConversationDatasetsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationDatasetsBlockingStub(channel, callOptions);
        }
      };
    return ConversationDatasetsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConversationDatasetsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConversationDatasetsFutureStub>() {
        @java.lang.Override
        public ConversationDatasetsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConversationDatasetsFutureStub(channel, callOptions);
        }
      };
    return ConversationDatasetsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Conversation datasets.
   * Conversation datasets contain raw conversation files and their
   * customizable metadata that can be used for model training.
   * </pre>
   */
  public static abstract class ConversationDatasetsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a new conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
     * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
     * </pre>
     */
    public void createConversationDataset(com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConversationDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified conversation dataset.
     * </pre>
     */
    public void getConversationDataset(com.google.cloud.dialogflow.v2.GetConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationDataset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConversationDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the list of all conversation datasets in the specified
     * project and location.
     * </pre>
     */
    public void listConversationDatasets(com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConversationDatasetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deleteConversationDataset(com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConversationDatasetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Import data into the specified conversation dataset. Note that it
     * is not allowed to import data to a conversation dataset that
     * already has data in it.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
     * - `response`: [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
     * </pre>
     */
    public void importConversationData(com.google.cloud.dialogflow.v2.ImportConversationDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportConversationDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateConversationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONVERSATION_DATASET)))
          .addMethod(
            getGetConversationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.GetConversationDatasetRequest,
                com.google.cloud.dialogflow.v2.ConversationDataset>(
                  this, METHODID_GET_CONVERSATION_DATASET)))
          .addMethod(
            getListConversationDatasetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest,
                com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse>(
                  this, METHODID_LIST_CONVERSATION_DATASETS)))
          .addMethod(
            getDeleteConversationDatasetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONVERSATION_DATASET)))
          .addMethod(
            getImportConversationDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dialogflow.v2.ImportConversationDataRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_IMPORT_CONVERSATION_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * Conversation datasets.
   * Conversation datasets contain raw conversation files and their
   * customizable metadata that can be used for model training.
   * </pre>
   */
  public static final class ConversationDatasetsStub extends io.grpc.stub.AbstractAsyncStub<ConversationDatasetsStub> {
    private ConversationDatasetsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationDatasetsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationDatasetsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
     * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
     * </pre>
     */
    public void createConversationDataset(com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves the specified conversation dataset.
     * </pre>
     */
    public void getConversationDataset(com.google.cloud.dialogflow.v2.GetConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationDataset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the list of all conversation datasets in the specified
     * project and location.
     * </pre>
     */
    public void listConversationDatasets(com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationDatasetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the specified conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public void deleteConversationDataset(com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationDatasetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Import data into the specified conversation dataset. Note that it
     * is not allowed to import data to a conversation dataset that
     * already has data in it.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
     * - `response`: [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
     * </pre>
     */
    public void importConversationData(com.google.cloud.dialogflow.v2.ImportConversationDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportConversationDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Conversation datasets.
   * Conversation datasets contain raw conversation files and their
   * customizable metadata that can be used for model training.
   * </pre>
   */
  public static final class ConversationDatasetsBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConversationDatasetsBlockingStub> {
    private ConversationDatasetsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationDatasetsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationDatasetsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
     * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
     * </pre>
     */
    public com.google.longrunning.Operation createConversationDataset(com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves the specified conversation dataset.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ConversationDataset getConversationDataset(com.google.cloud.dialogflow.v2.GetConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the list of all conversation datasets in the specified
     * project and location.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse listConversationDatasets(com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationDatasetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the specified conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.longrunning.Operation deleteConversationDataset(com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationDatasetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Import data into the specified conversation dataset. Note that it
     * is not allowed to import data to a conversation dataset that
     * already has data in it.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
     * - `response`: [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
     * </pre>
     */
    public com.google.longrunning.Operation importConversationData(com.google.cloud.dialogflow.v2.ImportConversationDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportConversationDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Conversation datasets.
   * Conversation datasets contain raw conversation files and their
   * customizable metadata that can be used for model training.
   * </pre>
   */
  public static final class ConversationDatasetsFutureStub extends io.grpc.stub.AbstractFutureStub<ConversationDatasetsFutureStub> {
    private ConversationDatasetsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConversationDatasetsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConversationDatasetsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [CreateConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.CreateConversationDatasetOperationMetadata]
     * - `response`: [ConversationDataset][google.cloud.dialogflow.v2.ConversationDataset]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConversationDataset(
        com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves the specified conversation dataset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ConversationDataset> getConversationDataset(
        com.google.cloud.dialogflow.v2.GetConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the list of all conversation datasets in the specified
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse> listConversationDatasets(
        com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationDatasetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the specified conversation dataset.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [DeleteConversationDatasetOperationMetadata][google.cloud.dialogflow.v2.DeleteConversationDatasetOperationMetadata]
     * - `response`: An [Empty
     *   message](https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#empty)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConversationDataset(
        com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationDatasetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Import data into the specified conversation dataset. Note that it
     * is not allowed to import data to a conversation dataset that
     * already has data in it.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/es/docs/how/long-running-operations).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportConversationDataOperationMetadata][google.cloud.dialogflow.v2.ImportConversationDataOperationMetadata]
     * - `response`: [ImportConversationDataOperationResponse][google.cloud.dialogflow.v2.ImportConversationDataOperationResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> importConversationData(
        com.google.cloud.dialogflow.v2.ImportConversationDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportConversationDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSATION_DATASET = 0;
  private static final int METHODID_GET_CONVERSATION_DATASET = 1;
  private static final int METHODID_LIST_CONVERSATION_DATASETS = 2;
  private static final int METHODID_DELETE_CONVERSATION_DATASET = 3;
  private static final int METHODID_IMPORT_CONVERSATION_DATA = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConversationDatasetsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConversationDatasetsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CONVERSATION_DATASET:
          serviceImpl.createConversationDataset((com.google.cloud.dialogflow.v2.CreateConversationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CONVERSATION_DATASET:
          serviceImpl.getConversationDataset((com.google.cloud.dialogflow.v2.GetConversationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ConversationDataset>) responseObserver);
          break;
        case METHODID_LIST_CONVERSATION_DATASETS:
          serviceImpl.listConversationDatasets((com.google.cloud.dialogflow.v2.ListConversationDatasetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListConversationDatasetsResponse>) responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION_DATASET:
          serviceImpl.deleteConversationDataset((com.google.cloud.dialogflow.v2.DeleteConversationDatasetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_CONVERSATION_DATA:
          serviceImpl.importConversationData((com.google.cloud.dialogflow.v2.ImportConversationDataRequest) request,
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

  private static abstract class ConversationDatasetsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConversationDatasetsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.ConversationDatasetProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConversationDatasets");
    }
  }

  private static final class ConversationDatasetsFileDescriptorSupplier
      extends ConversationDatasetsBaseDescriptorSupplier {
    ConversationDatasetsFileDescriptorSupplier() {}
  }

  private static final class ConversationDatasetsMethodDescriptorSupplier
      extends ConversationDatasetsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConversationDatasetsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConversationDatasetsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConversationDatasetsFileDescriptorSupplier())
              .addMethod(getCreateConversationDatasetMethod())
              .addMethod(getGetConversationDatasetMethod())
              .addMethod(getListConversationDatasetsMethod())
              .addMethod(getDeleteConversationDatasetMethod())
              .addMethod(getImportConversationDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
