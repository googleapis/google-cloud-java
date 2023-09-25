package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Google Cloud Key Management EKM Service
 * Manages external cryptographic keys and operations using those keys.
 * Implements a REST model with the following objects:
 * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/v1/ekm_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EkmServiceGrpc {

  private EkmServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.kms.v1.EkmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListEkmConnectionsRequest,
      com.google.cloud.kms.v1.ListEkmConnectionsResponse> getListEkmConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEkmConnections",
      requestType = com.google.cloud.kms.v1.ListEkmConnectionsRequest.class,
      responseType = com.google.cloud.kms.v1.ListEkmConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListEkmConnectionsRequest,
      com.google.cloud.kms.v1.ListEkmConnectionsResponse> getListEkmConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.ListEkmConnectionsRequest, com.google.cloud.kms.v1.ListEkmConnectionsResponse> getListEkmConnectionsMethod;
    if ((getListEkmConnectionsMethod = EkmServiceGrpc.getListEkmConnectionsMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getListEkmConnectionsMethod = EkmServiceGrpc.getListEkmConnectionsMethod) == null) {
          EkmServiceGrpc.getListEkmConnectionsMethod = getListEkmConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.ListEkmConnectionsRequest, com.google.cloud.kms.v1.ListEkmConnectionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEkmConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListEkmConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.ListEkmConnectionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("ListEkmConnections"))
              .build();
        }
      }
    }
    return getListEkmConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getGetEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEkmConnection",
      requestType = com.google.cloud.kms.v1.GetEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getGetEkmConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection> getGetEkmConnectionMethod;
    if ((getGetEkmConnectionMethod = EkmServiceGrpc.getGetEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getGetEkmConnectionMethod = EkmServiceGrpc.getGetEkmConnectionMethod) == null) {
          EkmServiceGrpc.getGetEkmConnectionMethod = getGetEkmConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEkmConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("GetEkmConnection"))
              .build();
        }
      }
    }
    return getGetEkmConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getCreateEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEkmConnection",
      requestType = com.google.cloud.kms.v1.CreateEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getCreateEkmConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.CreateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection> getCreateEkmConnectionMethod;
    if ((getCreateEkmConnectionMethod = EkmServiceGrpc.getCreateEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getCreateEkmConnectionMethod = EkmServiceGrpc.getCreateEkmConnectionMethod) == null) {
          EkmServiceGrpc.getCreateEkmConnectionMethod = getCreateEkmConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.CreateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEkmConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.CreateEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("CreateEkmConnection"))
              .build();
        }
      }
    }
    return getCreateEkmConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getUpdateEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEkmConnection",
      requestType = com.google.cloud.kms.v1.UpdateEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
      com.google.cloud.kms.v1.EkmConnection> getUpdateEkmConnectionMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection> getUpdateEkmConnectionMethod;
    if ((getUpdateEkmConnectionMethod = EkmServiceGrpc.getUpdateEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getUpdateEkmConnectionMethod = EkmServiceGrpc.getUpdateEkmConnectionMethod) == null) {
          EkmServiceGrpc.getUpdateEkmConnectionMethod = getUpdateEkmConnectionMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.UpdateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEkmConnection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.UpdateEkmConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("UpdateEkmConnection"))
              .build();
        }
      }
    }
    return getUpdateEkmConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConfigRequest,
      com.google.cloud.kms.v1.EkmConfig> getGetEkmConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEkmConfig",
      requestType = com.google.cloud.kms.v1.GetEkmConfigRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConfigRequest,
      com.google.cloud.kms.v1.EkmConfig> getGetEkmConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.GetEkmConfigRequest, com.google.cloud.kms.v1.EkmConfig> getGetEkmConfigMethod;
    if ((getGetEkmConfigMethod = EkmServiceGrpc.getGetEkmConfigMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getGetEkmConfigMethod = EkmServiceGrpc.getGetEkmConfigMethod) == null) {
          EkmServiceGrpc.getGetEkmConfigMethod = getGetEkmConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.GetEkmConfigRequest, com.google.cloud.kms.v1.EkmConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEkmConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.GetEkmConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EkmConfig.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("GetEkmConfig"))
              .build();
        }
      }
    }
    return getGetEkmConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConfigRequest,
      com.google.cloud.kms.v1.EkmConfig> getUpdateEkmConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEkmConfig",
      requestType = com.google.cloud.kms.v1.UpdateEkmConfigRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConfigRequest,
      com.google.cloud.kms.v1.EkmConfig> getUpdateEkmConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.UpdateEkmConfigRequest, com.google.cloud.kms.v1.EkmConfig> getUpdateEkmConfigMethod;
    if ((getUpdateEkmConfigMethod = EkmServiceGrpc.getUpdateEkmConfigMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getUpdateEkmConfigMethod = EkmServiceGrpc.getUpdateEkmConfigMethod) == null) {
          EkmServiceGrpc.getUpdateEkmConfigMethod = getUpdateEkmConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.UpdateEkmConfigRequest, com.google.cloud.kms.v1.EkmConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEkmConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.UpdateEkmConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.EkmConfig.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("UpdateEkmConfig"))
              .build();
        }
      }
    }
    return getUpdateEkmConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.kms.v1.VerifyConnectivityRequest,
      com.google.cloud.kms.v1.VerifyConnectivityResponse> getVerifyConnectivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyConnectivity",
      requestType = com.google.cloud.kms.v1.VerifyConnectivityRequest.class,
      responseType = com.google.cloud.kms.v1.VerifyConnectivityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.kms.v1.VerifyConnectivityRequest,
      com.google.cloud.kms.v1.VerifyConnectivityResponse> getVerifyConnectivityMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.kms.v1.VerifyConnectivityRequest, com.google.cloud.kms.v1.VerifyConnectivityResponse> getVerifyConnectivityMethod;
    if ((getVerifyConnectivityMethod = EkmServiceGrpc.getVerifyConnectivityMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getVerifyConnectivityMethod = EkmServiceGrpc.getVerifyConnectivityMethod) == null) {
          EkmServiceGrpc.getVerifyConnectivityMethod = getVerifyConnectivityMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.kms.v1.VerifyConnectivityRequest, com.google.cloud.kms.v1.VerifyConnectivityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyConnectivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.VerifyConnectivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.kms.v1.VerifyConnectivityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EkmServiceMethodDescriptorSupplier("VerifyConnectivity"))
              .build();
        }
      }
    }
    return getVerifyConnectivityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EkmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EkmServiceStub>() {
        @java.lang.Override
        public EkmServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EkmServiceStub(channel, callOptions);
        }
      };
    return EkmServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EkmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EkmServiceBlockingStub>() {
        @java.lang.Override
        public EkmServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EkmServiceBlockingStub(channel, callOptions);
        }
      };
    return EkmServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EkmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EkmServiceFutureStub>() {
        @java.lang.Override
        public EkmServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EkmServiceFutureStub(channel, callOptions);
        }
      };
    return EkmServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    default void listEkmConnections(com.google.cloud.kms.v1.ListEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEkmConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    default void getEkmConnection(com.google.cloud.kms.v1.GetEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEkmConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    default void createEkmConnection(com.google.cloud.kms.v1.CreateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEkmConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    default void updateEkmConnection(com.google.cloud.kms.v1.UpdateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEkmConnectionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    default void getEkmConfig(com.google.cloud.kms.v1.GetEkmConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEkmConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    default void updateEkmConfig(com.google.cloud.kms.v1.UpdateEkmConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEkmConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Verifies that Cloud KMS can successfully connect to the external key
     * manager specified by an [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * If there is an error connecting to the EKM, this method returns a
     * FAILED_PRECONDITION status containing structured information as described
     * at https://cloud.google.com/kms/docs/reference/ekm_errors.
     * </pre>
     */
    default void verifyConnectivity(com.google.cloud.kms.v1.VerifyConnectivityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.VerifyConnectivityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyConnectivityMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EkmService.
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static abstract class EkmServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EkmServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EkmService.
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EkmServiceStub> {
    private EkmServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void listEkmConnections(com.google.cloud.kms.v1.ListEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEkmConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void getEkmConnection(com.google.cloud.kms.v1.GetEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEkmConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public void createEkmConnection(com.google.cloud.kms.v1.CreateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEkmConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public void updateEkmConnection(com.google.cloud.kms.v1.UpdateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEkmConnectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public void getEkmConfig(com.google.cloud.kms.v1.GetEkmConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEkmConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public void updateEkmConfig(com.google.cloud.kms.v1.UpdateEkmConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEkmConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Verifies that Cloud KMS can successfully connect to the external key
     * manager specified by an [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * If there is an error connecting to the EKM, this method returns a
     * FAILED_PRECONDITION status containing structured information as described
     * at https://cloud.google.com/kms/docs/reference/ekm_errors.
     * </pre>
     */
    public void verifyConnectivity(com.google.cloud.kms.v1.VerifyConnectivityRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.VerifyConnectivityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyConnectivityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EkmService.
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EkmServiceBlockingStub> {
    private EkmServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListEkmConnectionsResponse listEkmConnections(com.google.cloud.kms.v1.ListEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEkmConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection getEkmConnection(com.google.cloud.kms.v1.GetEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEkmConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection createEkmConnection(com.google.cloud.kms.v1.CreateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEkmConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection updateEkmConnection(com.google.cloud.kms.v1.UpdateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEkmConnectionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConfig getEkmConfig(com.google.cloud.kms.v1.GetEkmConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEkmConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConfig updateEkmConfig(com.google.cloud.kms.v1.UpdateEkmConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEkmConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Verifies that Cloud KMS can successfully connect to the external key
     * manager specified by an [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * If there is an error connecting to the EKM, this method returns a
     * FAILED_PRECONDITION status containing structured information as described
     * at https://cloud.google.com/kms/docs/reference/ekm_errors.
     * </pre>
     */
    public com.google.cloud.kms.v1.VerifyConnectivityResponse verifyConnectivity(com.google.cloud.kms.v1.VerifyConnectivityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyConnectivityMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EkmService.
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EkmServiceFutureStub> {
    private EkmServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.ListEkmConnectionsResponse> listEkmConnections(
        com.google.cloud.kms.v1.ListEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEkmConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection> getEkmConnection(
        com.google.cloud.kms.v1.GetEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEkmConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection> createEkmConnection(
        com.google.cloud.kms.v1.CreateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEkmConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection> updateEkmConnection(
        com.google.cloud.kms.v1.UpdateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEkmConnectionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConfig> getEkmConfig(
        com.google.cloud.kms.v1.GetEkmConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEkmConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the [EkmConfig][google.cloud.kms.v1.EkmConfig] singleton resource
     * for a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConfig> updateEkmConfig(
        com.google.cloud.kms.v1.UpdateEkmConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEkmConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Verifies that Cloud KMS can successfully connect to the external key
     * manager specified by an [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * If there is an error connecting to the EKM, this method returns a
     * FAILED_PRECONDITION status containing structured information as described
     * at https://cloud.google.com/kms/docs/reference/ekm_errors.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.VerifyConnectivityResponse> verifyConnectivity(
        com.google.cloud.kms.v1.VerifyConnectivityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyConnectivityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EKM_CONNECTIONS = 0;
  private static final int METHODID_GET_EKM_CONNECTION = 1;
  private static final int METHODID_CREATE_EKM_CONNECTION = 2;
  private static final int METHODID_UPDATE_EKM_CONNECTION = 3;
  private static final int METHODID_GET_EKM_CONFIG = 4;
  private static final int METHODID_UPDATE_EKM_CONFIG = 5;
  private static final int METHODID_VERIFY_CONNECTIVITY = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_EKM_CONNECTIONS:
          serviceImpl.listEkmConnections((com.google.cloud.kms.v1.ListEkmConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse>) responseObserver);
          break;
        case METHODID_GET_EKM_CONNECTION:
          serviceImpl.getEkmConnection((com.google.cloud.kms.v1.GetEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>) responseObserver);
          break;
        case METHODID_CREATE_EKM_CONNECTION:
          serviceImpl.createEkmConnection((com.google.cloud.kms.v1.CreateEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>) responseObserver);
          break;
        case METHODID_UPDATE_EKM_CONNECTION:
          serviceImpl.updateEkmConnection((com.google.cloud.kms.v1.UpdateEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>) responseObserver);
          break;
        case METHODID_GET_EKM_CONFIG:
          serviceImpl.getEkmConfig((com.google.cloud.kms.v1.GetEkmConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig>) responseObserver);
          break;
        case METHODID_UPDATE_EKM_CONFIG:
          serviceImpl.updateEkmConfig((com.google.cloud.kms.v1.UpdateEkmConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConfig>) responseObserver);
          break;
        case METHODID_VERIFY_CONNECTIVITY:
          serviceImpl.verifyConnectivity((com.google.cloud.kms.v1.VerifyConnectivityRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.VerifyConnectivityResponse>) responseObserver);
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
          getListEkmConnectionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.ListEkmConnectionsRequest,
              com.google.cloud.kms.v1.ListEkmConnectionsResponse>(
                service, METHODID_LIST_EKM_CONNECTIONS)))
        .addMethod(
          getGetEkmConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.GetEkmConnectionRequest,
              com.google.cloud.kms.v1.EkmConnection>(
                service, METHODID_GET_EKM_CONNECTION)))
        .addMethod(
          getCreateEkmConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.CreateEkmConnectionRequest,
              com.google.cloud.kms.v1.EkmConnection>(
                service, METHODID_CREATE_EKM_CONNECTION)))
        .addMethod(
          getUpdateEkmConnectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
              com.google.cloud.kms.v1.EkmConnection>(
                service, METHODID_UPDATE_EKM_CONNECTION)))
        .addMethod(
          getGetEkmConfigMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.GetEkmConfigRequest,
              com.google.cloud.kms.v1.EkmConfig>(
                service, METHODID_GET_EKM_CONFIG)))
        .addMethod(
          getUpdateEkmConfigMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.UpdateEkmConfigRequest,
              com.google.cloud.kms.v1.EkmConfig>(
                service, METHODID_UPDATE_EKM_CONFIG)))
        .addMethod(
          getVerifyConnectivityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.kms.v1.VerifyConnectivityRequest,
              com.google.cloud.kms.v1.VerifyConnectivityResponse>(
                service, METHODID_VERIFY_CONNECTIVITY)))
        .build();
  }

  private static abstract class EkmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EkmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.EkmServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EkmService");
    }
  }

  private static final class EkmServiceFileDescriptorSupplier
      extends EkmServiceBaseDescriptorSupplier {
    EkmServiceFileDescriptorSupplier() {}
  }

  private static final class EkmServiceMethodDescriptorSupplier
      extends EkmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EkmServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EkmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EkmServiceFileDescriptorSupplier())
              .addMethod(getListEkmConnectionsMethod())
              .addMethod(getGetEkmConnectionMethod())
              .addMethod(getCreateEkmConnectionMethod())
              .addMethod(getUpdateEkmConnectionMethod())
              .addMethod(getGetEkmConfigMethod())
              .addMethod(getUpdateEkmConfigMethod())
              .addMethod(getVerifyConnectivityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
