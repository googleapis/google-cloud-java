package com.google.api.apikeys.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages the API keys associated with projects.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/apikeys/v2/apikeys.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiKeysGrpc {

  private ApiKeysGrpc() {}

  public static final String SERVICE_NAME = "google.api.apikeys.v2.ApiKeys";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.CreateKeyRequest,
      com.google.longrunning.Operation> getCreateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKey",
      requestType = com.google.api.apikeys.v2.CreateKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.CreateKeyRequest,
      com.google.longrunning.Operation> getCreateKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.CreateKeyRequest, com.google.longrunning.Operation> getCreateKeyMethod;
    if ((getCreateKeyMethod = ApiKeysGrpc.getCreateKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getCreateKeyMethod = ApiKeysGrpc.getCreateKeyMethod) == null) {
          ApiKeysGrpc.getCreateKeyMethod = getCreateKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.CreateKeyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.CreateKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("CreateKey"))
              .build();
        }
      }
    }
    return getCreateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.ListKeysRequest,
      com.google.api.apikeys.v2.ListKeysResponse> getListKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeys",
      requestType = com.google.api.apikeys.v2.ListKeysRequest.class,
      responseType = com.google.api.apikeys.v2.ListKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.ListKeysRequest,
      com.google.api.apikeys.v2.ListKeysResponse> getListKeysMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.ListKeysRequest, com.google.api.apikeys.v2.ListKeysResponse> getListKeysMethod;
    if ((getListKeysMethod = ApiKeysGrpc.getListKeysMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getListKeysMethod = ApiKeysGrpc.getListKeysMethod) == null) {
          ApiKeysGrpc.getListKeysMethod = getListKeysMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.ListKeysRequest, com.google.api.apikeys.v2.ListKeysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeys"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.ListKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.ListKeysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("ListKeys"))
              .build();
        }
      }
    }
    return getListKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyRequest,
      com.google.api.apikeys.v2.Key> getGetKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKey",
      requestType = com.google.api.apikeys.v2.GetKeyRequest.class,
      responseType = com.google.api.apikeys.v2.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyRequest,
      com.google.api.apikeys.v2.Key> getGetKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyRequest, com.google.api.apikeys.v2.Key> getGetKeyMethod;
    if ((getGetKeyMethod = ApiKeysGrpc.getGetKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getGetKeyMethod = ApiKeysGrpc.getGetKeyMethod) == null) {
          ApiKeysGrpc.getGetKeyMethod = getGetKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.GetKeyRequest, com.google.api.apikeys.v2.Key>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.GetKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.Key.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("GetKey"))
              .build();
        }
      }
    }
    return getGetKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyStringRequest,
      com.google.api.apikeys.v2.GetKeyStringResponse> getGetKeyStringMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKeyString",
      requestType = com.google.api.apikeys.v2.GetKeyStringRequest.class,
      responseType = com.google.api.apikeys.v2.GetKeyStringResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyStringRequest,
      com.google.api.apikeys.v2.GetKeyStringResponse> getGetKeyStringMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.GetKeyStringRequest, com.google.api.apikeys.v2.GetKeyStringResponse> getGetKeyStringMethod;
    if ((getGetKeyStringMethod = ApiKeysGrpc.getGetKeyStringMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getGetKeyStringMethod = ApiKeysGrpc.getGetKeyStringMethod) == null) {
          ApiKeysGrpc.getGetKeyStringMethod = getGetKeyStringMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.GetKeyStringRequest, com.google.api.apikeys.v2.GetKeyStringResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKeyString"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.GetKeyStringRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.GetKeyStringResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("GetKeyString"))
              .build();
        }
      }
    }
    return getGetKeyStringMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UpdateKeyRequest,
      com.google.longrunning.Operation> getUpdateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKey",
      requestType = com.google.api.apikeys.v2.UpdateKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UpdateKeyRequest,
      com.google.longrunning.Operation> getUpdateKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UpdateKeyRequest, com.google.longrunning.Operation> getUpdateKeyMethod;
    if ((getUpdateKeyMethod = ApiKeysGrpc.getUpdateKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getUpdateKeyMethod = ApiKeysGrpc.getUpdateKeyMethod) == null) {
          ApiKeysGrpc.getUpdateKeyMethod = getUpdateKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.UpdateKeyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.UpdateKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("UpdateKey"))
              .build();
        }
      }
    }
    return getUpdateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.DeleteKeyRequest,
      com.google.longrunning.Operation> getDeleteKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKey",
      requestType = com.google.api.apikeys.v2.DeleteKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.DeleteKeyRequest,
      com.google.longrunning.Operation> getDeleteKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.DeleteKeyRequest, com.google.longrunning.Operation> getDeleteKeyMethod;
    if ((getDeleteKeyMethod = ApiKeysGrpc.getDeleteKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getDeleteKeyMethod = ApiKeysGrpc.getDeleteKeyMethod) == null) {
          ApiKeysGrpc.getDeleteKeyMethod = getDeleteKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.DeleteKeyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.DeleteKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("DeleteKey"))
              .build();
        }
      }
    }
    return getDeleteKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UndeleteKeyRequest,
      com.google.longrunning.Operation> getUndeleteKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteKey",
      requestType = com.google.api.apikeys.v2.UndeleteKeyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UndeleteKeyRequest,
      com.google.longrunning.Operation> getUndeleteKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.UndeleteKeyRequest, com.google.longrunning.Operation> getUndeleteKeyMethod;
    if ((getUndeleteKeyMethod = ApiKeysGrpc.getUndeleteKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getUndeleteKeyMethod = ApiKeysGrpc.getUndeleteKeyMethod) == null) {
          ApiKeysGrpc.getUndeleteKeyMethod = getUndeleteKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.UndeleteKeyRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.UndeleteKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("UndeleteKey"))
              .build();
        }
      }
    }
    return getUndeleteKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.apikeys.v2.LookupKeyRequest,
      com.google.api.apikeys.v2.LookupKeyResponse> getLookupKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupKey",
      requestType = com.google.api.apikeys.v2.LookupKeyRequest.class,
      responseType = com.google.api.apikeys.v2.LookupKeyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.apikeys.v2.LookupKeyRequest,
      com.google.api.apikeys.v2.LookupKeyResponse> getLookupKeyMethod() {
    io.grpc.MethodDescriptor<com.google.api.apikeys.v2.LookupKeyRequest, com.google.api.apikeys.v2.LookupKeyResponse> getLookupKeyMethod;
    if ((getLookupKeyMethod = ApiKeysGrpc.getLookupKeyMethod) == null) {
      synchronized (ApiKeysGrpc.class) {
        if ((getLookupKeyMethod = ApiKeysGrpc.getLookupKeyMethod) == null) {
          ApiKeysGrpc.getLookupKeyMethod = getLookupKeyMethod =
              io.grpc.MethodDescriptor.<com.google.api.apikeys.v2.LookupKeyRequest, com.google.api.apikeys.v2.LookupKeyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupKey"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.LookupKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.apikeys.v2.LookupKeyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiKeysMethodDescriptorSupplier("LookupKey"))
              .build();
        }
      }
    }
    return getLookupKeyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ApiKeysStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiKeysStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiKeysStub>() {
        @java.lang.Override
        public ApiKeysStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiKeysStub(channel, callOptions);
        }
      };
    return ApiKeysStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiKeysBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiKeysBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiKeysBlockingStub>() {
        @java.lang.Override
        public ApiKeysBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiKeysBlockingStub(channel, callOptions);
        }
      };
    return ApiKeysBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ApiKeysFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiKeysFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiKeysFutureStub>() {
        @java.lang.Override
        public ApiKeysFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiKeysFutureStub(channel, callOptions);
        }
      };
    return ApiKeysFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages the API keys associated with projects.
   * </pre>
   */
  public static abstract class ApiKeysImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a new API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void createKey(com.google.api.apikeys.v2.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the API keys owned by a project. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void listKeys(com.google.api.apikeys.v2.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.ListKeysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListKeysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the metadata for an API key. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void getKey(com.google.api.apikeys.v2.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.Key> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the key string for an API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void getKeyString(com.google.api.apikeys.v2.GetKeyStringRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.GetKeyStringResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetKeyStringMethod(), responseObserver);
    }

    /**
     * <pre>
     * Patches the modifiable fields of an API key.
     * The key string of the API key isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void updateKey(com.google.api.apikeys.v2.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an API key. Deleted key can be retrieved within 30 days of
     * deletion. Afterward, key will be purged from the project.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void deleteKey(com.google.api.apikeys.v2.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Undeletes an API key which was deleted within 30 days.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void undeleteKey(com.google.api.apikeys.v2.UndeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteKeyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Find the parent project and resource name of the API
     * key that matches the key string in the request. If the API key has been
     * purged, resource name will not be set.
     * The service account must have the `apikeys.keys.lookup` permission
     * on the parent project.
     * </pre>
     */
    public void lookupKey(com.google.api.apikeys.v2.LookupKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.LookupKeyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupKeyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.CreateKeyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_KEY)))
          .addMethod(
            getListKeysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.ListKeysRequest,
                com.google.api.apikeys.v2.ListKeysResponse>(
                  this, METHODID_LIST_KEYS)))
          .addMethod(
            getGetKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.GetKeyRequest,
                com.google.api.apikeys.v2.Key>(
                  this, METHODID_GET_KEY)))
          .addMethod(
            getGetKeyStringMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.GetKeyStringRequest,
                com.google.api.apikeys.v2.GetKeyStringResponse>(
                  this, METHODID_GET_KEY_STRING)))
          .addMethod(
            getUpdateKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.UpdateKeyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_KEY)))
          .addMethod(
            getDeleteKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.DeleteKeyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_KEY)))
          .addMethod(
            getUndeleteKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.UndeleteKeyRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UNDELETE_KEY)))
          .addMethod(
            getLookupKeyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.apikeys.v2.LookupKeyRequest,
                com.google.api.apikeys.v2.LookupKeyResponse>(
                  this, METHODID_LOOKUP_KEY)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages the API keys associated with projects.
   * </pre>
   */
  public static final class ApiKeysStub extends io.grpc.stub.AbstractAsyncStub<ApiKeysStub> {
    private ApiKeysStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiKeysStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiKeysStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void createKey(com.google.api.apikeys.v2.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the API keys owned by a project. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void listKeys(com.google.api.apikeys.v2.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.ListKeysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the metadata for an API key. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void getKey(com.google.api.apikeys.v2.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.Key> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the key string for an API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void getKeyString(com.google.api.apikeys.v2.GetKeyStringRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.GetKeyStringResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetKeyStringMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Patches the modifiable fields of an API key.
     * The key string of the API key isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void updateKey(com.google.api.apikeys.v2.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an API key. Deleted key can be retrieved within 30 days of
     * deletion. Afterward, key will be purged from the project.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void deleteKey(com.google.api.apikeys.v2.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Undeletes an API key which was deleted within 30 days.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public void undeleteKey(com.google.api.apikeys.v2.UndeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Find the parent project and resource name of the API
     * key that matches the key string in the request. If the API key has been
     * purged, resource name will not be set.
     * The service account must have the `apikeys.keys.lookup` permission
     * on the parent project.
     * </pre>
     */
    public void lookupKey(com.google.api.apikeys.v2.LookupKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.LookupKeyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupKeyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages the API keys associated with projects.
   * </pre>
   */
  public static final class ApiKeysBlockingStub extends io.grpc.stub.AbstractBlockingStub<ApiKeysBlockingStub> {
    private ApiKeysBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiKeysBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiKeysBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation createKey(com.google.api.apikeys.v2.CreateKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the API keys owned by a project. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.api.apikeys.v2.ListKeysResponse listKeys(com.google.api.apikeys.v2.ListKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListKeysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the metadata for an API key. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.api.apikeys.v2.Key getKey(com.google.api.apikeys.v2.GetKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the key string for an API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.api.apikeys.v2.GetKeyStringResponse getKeyString(com.google.api.apikeys.v2.GetKeyStringRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetKeyStringMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Patches the modifiable fields of an API key.
     * The key string of the API key isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation updateKey(com.google.api.apikeys.v2.UpdateKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an API key. Deleted key can be retrieved within 30 days of
     * deletion. Afterward, key will be purged from the project.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteKey(com.google.api.apikeys.v2.DeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Undeletes an API key which was deleted within 30 days.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteKey(com.google.api.apikeys.v2.UndeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteKeyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Find the parent project and resource name of the API
     * key that matches the key string in the request. If the API key has been
     * purged, resource name will not be set.
     * The service account must have the `apikeys.keys.lookup` permission
     * on the parent project.
     * </pre>
     */
    public com.google.api.apikeys.v2.LookupKeyResponse lookupKey(com.google.api.apikeys.v2.LookupKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupKeyMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages the API keys associated with projects.
   * </pre>
   */
  public static final class ApiKeysFutureStub extends io.grpc.stub.AbstractFutureStub<ApiKeysFutureStub> {
    private ApiKeysFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiKeysFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiKeysFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createKey(
        com.google.api.apikeys.v2.CreateKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the API keys owned by a project. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.apikeys.v2.ListKeysResponse> listKeys(
        com.google.api.apikeys.v2.ListKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListKeysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the metadata for an API key. The key string of the API key
     * isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.apikeys.v2.Key> getKey(
        com.google.api.apikeys.v2.GetKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the key string for an API key.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.apikeys.v2.GetKeyStringResponse> getKeyString(
        com.google.api.apikeys.v2.GetKeyStringRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetKeyStringMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Patches the modifiable fields of an API key.
     * The key string of the API key isn't included in the response.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateKey(
        com.google.api.apikeys.v2.UpdateKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an API key. Deleted key can be retrieved within 30 days of
     * deletion. Afterward, key will be purged from the project.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteKey(
        com.google.api.apikeys.v2.DeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Undeletes an API key which was deleted within 30 days.
     * NOTE: Key is a global resource; hence the only supported value for
     * location is `global`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeleteKey(
        com.google.api.apikeys.v2.UndeleteKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteKeyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Find the parent project and resource name of the API
     * key that matches the key string in the request. If the API key has been
     * purged, resource name will not be set.
     * The service account must have the `apikeys.keys.lookup` permission
     * on the parent project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.apikeys.v2.LookupKeyResponse> lookupKey(
        com.google.api.apikeys.v2.LookupKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupKeyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_KEY = 0;
  private static final int METHODID_LIST_KEYS = 1;
  private static final int METHODID_GET_KEY = 2;
  private static final int METHODID_GET_KEY_STRING = 3;
  private static final int METHODID_UPDATE_KEY = 4;
  private static final int METHODID_DELETE_KEY = 5;
  private static final int METHODID_UNDELETE_KEY = 6;
  private static final int METHODID_LOOKUP_KEY = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ApiKeysImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ApiKeysImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_KEY:
          serviceImpl.createKey((com.google.api.apikeys.v2.CreateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_KEYS:
          serviceImpl.listKeys((com.google.api.apikeys.v2.ListKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.ListKeysResponse>) responseObserver);
          break;
        case METHODID_GET_KEY:
          serviceImpl.getKey((com.google.api.apikeys.v2.GetKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.Key>) responseObserver);
          break;
        case METHODID_GET_KEY_STRING:
          serviceImpl.getKeyString((com.google.api.apikeys.v2.GetKeyStringRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.GetKeyStringResponse>) responseObserver);
          break;
        case METHODID_UPDATE_KEY:
          serviceImpl.updateKey((com.google.api.apikeys.v2.UpdateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_KEY:
          serviceImpl.deleteKey((com.google.api.apikeys.v2.DeleteKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_KEY:
          serviceImpl.undeleteKey((com.google.api.apikeys.v2.UndeleteKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LOOKUP_KEY:
          serviceImpl.lookupKey((com.google.api.apikeys.v2.LookupKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.apikeys.v2.LookupKeyResponse>) responseObserver);
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

  private static abstract class ApiKeysBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiKeysBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.apikeys.v2.ApiKeysProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiKeys");
    }
  }

  private static final class ApiKeysFileDescriptorSupplier
      extends ApiKeysBaseDescriptorSupplier {
    ApiKeysFileDescriptorSupplier() {}
  }

  private static final class ApiKeysMethodDescriptorSupplier
      extends ApiKeysBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ApiKeysMethodDescriptorSupplier(String methodName) {
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
      synchronized (ApiKeysGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ApiKeysFileDescriptorSupplier())
              .addMethod(getCreateKeyMethod())
              .addMethod(getListKeysMethod())
              .addMethod(getGetKeyMethod())
              .addMethod(getGetKeyStringMethod())
              .addMethod(getUpdateKeyMethod())
              .addMethod(getDeleteKeyMethod())
              .addMethod(getUndeleteKeyMethod())
              .addMethod(getLookupKeyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
