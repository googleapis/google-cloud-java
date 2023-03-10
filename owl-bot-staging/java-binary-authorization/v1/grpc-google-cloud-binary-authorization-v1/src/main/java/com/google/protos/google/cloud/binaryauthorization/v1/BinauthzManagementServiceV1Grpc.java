package com.google.protos.google.cloud.binaryauthorization.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Google Cloud Management Service for Binary Authorization admission policies
 * and attestation authorities.
 * This API implements a REST model with the following objects:
 * * [Policy][google.cloud.binaryauthorization.v1.Policy]
 * * [Attestor][google.cloud.binaryauthorization.v1.Attestor]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/binaryauthorization/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BinauthzManagementServiceV1Grpc {

  private BinauthzManagementServiceV1Grpc() {}

  public static final String SERVICE_NAME = "google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getGetPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPolicy",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getGetPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getGetPolicyMethod;
    if ((getGetPolicyMethod = BinauthzManagementServiceV1Grpc.getGetPolicyMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getGetPolicyMethod = BinauthzManagementServiceV1Grpc.getGetPolicyMethod) == null) {
          BinauthzManagementServiceV1Grpc.getGetPolicyMethod = getGetPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("GetPolicy"))
              .build();
        }
      }
    }
    return getGetPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getUpdatePolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePolicy",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getUpdatePolicyMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getUpdatePolicyMethod;
    if ((getUpdatePolicyMethod = BinauthzManagementServiceV1Grpc.getUpdatePolicyMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getUpdatePolicyMethod = BinauthzManagementServiceV1Grpc.getUpdatePolicyMethod) == null) {
          BinauthzManagementServiceV1Grpc.getUpdatePolicyMethod = getUpdatePolicyMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("UpdatePolicy"))
              .build();
        }
      }
    }
    return getUpdatePolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getCreateAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAttestor",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getCreateAttestorMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getCreateAttestorMethod;
    if ((getCreateAttestorMethod = BinauthzManagementServiceV1Grpc.getCreateAttestorMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getCreateAttestorMethod = BinauthzManagementServiceV1Grpc.getCreateAttestorMethod) == null) {
          BinauthzManagementServiceV1Grpc.getCreateAttestorMethod = getCreateAttestorMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAttestor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("CreateAttestor"))
              .build();
        }
      }
    }
    return getCreateAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getGetAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttestor",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getGetAttestorMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getGetAttestorMethod;
    if ((getGetAttestorMethod = BinauthzManagementServiceV1Grpc.getGetAttestorMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getGetAttestorMethod = BinauthzManagementServiceV1Grpc.getGetAttestorMethod) == null) {
          BinauthzManagementServiceV1Grpc.getGetAttestorMethod = getGetAttestorMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttestor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("GetAttestor"))
              .build();
        }
      }
    }
    return getGetAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getUpdateAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttestor",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getUpdateAttestorMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getUpdateAttestorMethod;
    if ((getUpdateAttestorMethod = BinauthzManagementServiceV1Grpc.getUpdateAttestorMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getUpdateAttestorMethod = BinauthzManagementServiceV1Grpc.getUpdateAttestorMethod) == null) {
          BinauthzManagementServiceV1Grpc.getUpdateAttestorMethod = getUpdateAttestorMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest, com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAttestor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("UpdateAttestor"))
              .build();
        }
      }
    }
    return getUpdateAttestorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> getListAttestorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttestors",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest.class,
      responseType = com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest,
      com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> getListAttestorsMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest, com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> getListAttestorsMethod;
    if ((getListAttestorsMethod = BinauthzManagementServiceV1Grpc.getListAttestorsMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getListAttestorsMethod = BinauthzManagementServiceV1Grpc.getListAttestorsMethod) == null) {
          BinauthzManagementServiceV1Grpc.getListAttestorsMethod = getListAttestorsMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest, com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAttestors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("ListAttestors"))
              .build();
        }
      }
    }
    return getListAttestorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest,
      com.google.protobuf.Empty> getDeleteAttestorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAttestor",
      requestType = com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest,
      com.google.protobuf.Empty> getDeleteAttestorMethod() {
    io.grpc.MethodDescriptor<com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest, com.google.protobuf.Empty> getDeleteAttestorMethod;
    if ((getDeleteAttestorMethod = BinauthzManagementServiceV1Grpc.getDeleteAttestorMethod) == null) {
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        if ((getDeleteAttestorMethod = BinauthzManagementServiceV1Grpc.getDeleteAttestorMethod) == null) {
          BinauthzManagementServiceV1Grpc.getDeleteAttestorMethod = getDeleteAttestorMethod =
              io.grpc.MethodDescriptor.<com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAttestor"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BinauthzManagementServiceV1MethodDescriptorSupplier("DeleteAttestor"))
              .build();
        }
      }
    }
    return getDeleteAttestorMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BinauthzManagementServiceV1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1Stub>() {
        @java.lang.Override
        public BinauthzManagementServiceV1Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BinauthzManagementServiceV1Stub(channel, callOptions);
        }
      };
    return BinauthzManagementServiceV1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BinauthzManagementServiceV1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1BlockingStub>() {
        @java.lang.Override
        public BinauthzManagementServiceV1BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BinauthzManagementServiceV1BlockingStub(channel, callOptions);
        }
      };
    return BinauthzManagementServiceV1BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BinauthzManagementServiceV1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BinauthzManagementServiceV1FutureStub>() {
        @java.lang.Override
        public BinauthzManagementServiceV1FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BinauthzManagementServiceV1FutureStub(channel, callOptions);
        }
      };
    return BinauthzManagementServiceV1FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1.Attestor]
   * </pre>
   */
  public static abstract class BinauthzManagementServiceV1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
     * </pre>
     */
    public void getPolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public void updatePolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
     * </pre>
     */
    public void createAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAttestorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void getAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAttestorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void updateAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAttestorMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public void listAttestors(com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAttestorsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void deleteAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAttestorMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>(
                  this, METHODID_GET_POLICY)))
          .addMethod(
            getUpdatePolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>(
                  this, METHODID_UPDATE_POLICY)))
          .addMethod(
            getCreateAttestorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>(
                  this, METHODID_CREATE_ATTESTOR)))
          .addMethod(
            getGetAttestorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>(
                  this, METHODID_GET_ATTESTOR)))
          .addMethod(
            getUpdateAttestorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>(
                  this, METHODID_UPDATE_ATTESTOR)))
          .addMethod(
            getListAttestorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest,
                com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse>(
                  this, METHODID_LIST_ATTESTORS)))
          .addMethod(
            getDeleteAttestorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ATTESTOR)))
          .build();
    }
  }

  /**
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1Stub extends io.grpc.stub.AbstractAsyncStub<BinauthzManagementServiceV1Stub> {
    private BinauthzManagementServiceV1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1Stub(channel, callOptions);
    }

    /**
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
     * </pre>
     */
    public void getPolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public void updatePolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
     * </pre>
     */
    public void createAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAttestorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void getAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttestorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void updateAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttestorMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public void listAttestors(com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest request,
        io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttestorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public void deleteAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAttestorMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1BlockingStub extends io.grpc.stub.AbstractBlockingStub<BinauthzManagementServiceV1BlockingStub> {
    private BinauthzManagementServiceV1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy getPolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy updatePolicy(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor createAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAttestorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor getAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttestorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor updateAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttestorMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse listAttestors(com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttestorsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAttestor(com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAttestorMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Google Cloud Management Service for Binary Authorization admission policies
   * and attestation authorities.
   * This API implements a REST model with the following objects:
   * * [Policy][google.cloud.binaryauthorization.v1.Policy]
   * * [Attestor][google.cloud.binaryauthorization.v1.Attestor]
   * </pre>
   */
  public static final class BinauthzManagementServiceV1FutureStub extends io.grpc.stub.AbstractFutureStub<BinauthzManagementServiceV1FutureStub> {
    private BinauthzManagementServiceV1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BinauthzManagementServiceV1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BinauthzManagementServiceV1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A [policy][google.cloud.binaryauthorization.v1.Policy] specifies the [attestors][google.cloud.binaryauthorization.v1.Attestor] that must attest to
     * a container image, before the project is allowed to deploy that
     * image. There is at most one policy per project. All image admission
     * requests are permitted if a project has no policy.
     * Gets the [policy][google.cloud.binaryauthorization.v1.Policy] for this project. Returns a default
     * [policy][google.cloud.binaryauthorization.v1.Policy] if the project does not have one.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> getPolicy(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates or updates a project's [policy][google.cloud.binaryauthorization.v1.Policy], and returns a copy of the
     * new [policy][google.cloud.binaryauthorization.v1.Policy]. A policy is always updated as a whole, to avoid race
     * conditions with concurrent policy enforcement (or management!)
     * requests. Returns NOT_FOUND if the project does not exist, INVALID_ARGUMENT
     * if the request is malformed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy> updatePolicy(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an [attestor][google.cloud.binaryauthorization.v1.Attestor], and returns a copy of the new
     * [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the project does not exist,
     * INVALID_ARGUMENT if the request is malformed, ALREADY_EXISTS if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] already exists.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> createAttestor(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAttestorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> getAttestor(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttestorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an [attestor][google.cloud.binaryauthorization.v1.Attestor].
     * Returns NOT_FOUND if the [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor> updateAttestor(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttestorMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists [attestors][google.cloud.binaryauthorization.v1.Attestor].
     * Returns INVALID_ARGUMENT if the project does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse> listAttestors(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttestorsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an [attestor][google.cloud.binaryauthorization.v1.Attestor]. Returns NOT_FOUND if the
     * [attestor][google.cloud.binaryauthorization.v1.Attestor] does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAttestor(
        com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAttestorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POLICY = 0;
  private static final int METHODID_UPDATE_POLICY = 1;
  private static final int METHODID_CREATE_ATTESTOR = 2;
  private static final int METHODID_GET_ATTESTOR = 3;
  private static final int METHODID_UPDATE_ATTESTOR = 4;
  private static final int METHODID_LIST_ATTESTORS = 5;
  private static final int METHODID_DELETE_ATTESTOR = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BinauthzManagementServiceV1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BinauthzManagementServiceV1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POLICY:
          serviceImpl.getPolicy((com.google.protos.google.cloud.binaryauthorization.v1.Service.GetPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY:
          serviceImpl.updatePolicy((com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdatePolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Policy>) responseObserver);
          break;
        case METHODID_CREATE_ATTESTOR:
          serviceImpl.createAttestor((com.google.protos.google.cloud.binaryauthorization.v1.Service.CreateAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>) responseObserver);
          break;
        case METHODID_GET_ATTESTOR:
          serviceImpl.getAttestor((com.google.protos.google.cloud.binaryauthorization.v1.Service.GetAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>) responseObserver);
          break;
        case METHODID_UPDATE_ATTESTOR:
          serviceImpl.updateAttestor((com.google.protos.google.cloud.binaryauthorization.v1.Service.UpdateAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Resources.Attestor>) responseObserver);
          break;
        case METHODID_LIST_ATTESTORS:
          serviceImpl.listAttestors((com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protos.google.cloud.binaryauthorization.v1.Service.ListAttestorsResponse>) responseObserver);
          break;
        case METHODID_DELETE_ATTESTOR:
          serviceImpl.deleteAttestor((com.google.protos.google.cloud.binaryauthorization.v1.Service.DeleteAttestorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class BinauthzManagementServiceV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BinauthzManagementServiceV1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.protos.google.cloud.binaryauthorization.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BinauthzManagementServiceV1");
    }
  }

  private static final class BinauthzManagementServiceV1FileDescriptorSupplier
      extends BinauthzManagementServiceV1BaseDescriptorSupplier {
    BinauthzManagementServiceV1FileDescriptorSupplier() {}
  }

  private static final class BinauthzManagementServiceV1MethodDescriptorSupplier
      extends BinauthzManagementServiceV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BinauthzManagementServiceV1MethodDescriptorSupplier(String methodName) {
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
      synchronized (BinauthzManagementServiceV1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BinauthzManagementServiceV1FileDescriptorSupplier())
              .addMethod(getGetPolicyMethod())
              .addMethod(getUpdatePolicyMethod())
              .addMethod(getCreateAttestorMethod())
              .addMethod(getGetAttestorMethod())
              .addMethod(getUpdateAttestorMethod())
              .addMethod(getListAttestorsMethod())
              .addMethod(getDeleteAttestorMethod())
              .build();
        }
      }
    }
    return result;
  }
}
