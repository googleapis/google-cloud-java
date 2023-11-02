/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.confidentialcomputing.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/confidentialcomputing/v1alpha1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfidentialComputingGrpc {

  private ConfidentialComputingGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.confidentialcomputing.v1alpha1.ConfidentialComputing";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest,
          com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
      getCreateChallengeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChallenge",
      requestType = com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest.class,
      responseType = com.google.cloud.confidentialcomputing.v1alpha1.Challenge.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest,
          com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
      getCreateChallengeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest,
            com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
        getCreateChallengeMethod;
    if ((getCreateChallengeMethod = ConfidentialComputingGrpc.getCreateChallengeMethod) == null) {
      synchronized (ConfidentialComputingGrpc.class) {
        if ((getCreateChallengeMethod = ConfidentialComputingGrpc.getCreateChallengeMethod)
            == null) {
          ConfidentialComputingGrpc.getCreateChallengeMethod =
              getCreateChallengeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest,
                          com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateChallenge"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.confidentialcomputing.v1alpha1.Challenge
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfidentialComputingMethodDescriptorSupplier("CreateChallenge"))
                      .build();
        }
      }
    }
    return getCreateChallengeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest,
          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
      getVerifyAttestationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyAttestation",
      requestType = com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest.class,
      responseType =
          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest,
          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
      getVerifyAttestationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest,
            com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
        getVerifyAttestationMethod;
    if ((getVerifyAttestationMethod = ConfidentialComputingGrpc.getVerifyAttestationMethod)
        == null) {
      synchronized (ConfidentialComputingGrpc.class) {
        if ((getVerifyAttestationMethod = ConfidentialComputingGrpc.getVerifyAttestationMethod)
            == null) {
          ConfidentialComputingGrpc.getVerifyAttestationMethod =
              getVerifyAttestationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest,
                          com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyAttestation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.confidentialcomputing.v1alpha1
                                  .VerifyAttestationRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.confidentialcomputing.v1alpha1
                                  .VerifyAttestationResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfidentialComputingMethodDescriptorSupplier("VerifyAttestation"))
                      .build();
        }
      }
    }
    return getVerifyAttestationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfidentialComputingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingStub>() {
          @java.lang.Override
          public ConfidentialComputingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfidentialComputingStub(channel, callOptions);
          }
        };
    return ConfidentialComputingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfidentialComputingBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingBlockingStub>() {
          @java.lang.Override
          public ConfidentialComputingBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfidentialComputingBlockingStub(channel, callOptions);
          }
        };
    return ConfidentialComputingBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfidentialComputingFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfidentialComputingFutureStub>() {
          @java.lang.Override
          public ConfidentialComputingFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfidentialComputingFutureStub(channel, callOptions);
          }
        };
    return ConfidentialComputingFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new Challenge in a given project and location.
     * </pre>
     */
    default void createChallenge(
        com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateChallengeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verifies the provided attestation info, returning a signed OIDC token.
     * </pre>
     */
    default void verifyAttestation(
        com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getVerifyAttestationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConfidentialComputing.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class ConfidentialComputingImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConfidentialComputingGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConfidentialComputing.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ConfidentialComputingStub
      extends io.grpc.stub.AbstractAsyncStub<ConfidentialComputingStub> {
    private ConfidentialComputingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfidentialComputingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfidentialComputingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Challenge in a given project and location.
     * </pre>
     */
    public void createChallenge(
        com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateChallengeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Verifies the provided attestation info, returning a signed OIDC token.
     * </pre>
     */
    public void verifyAttestation(
        com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyAttestationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConfidentialComputing.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ConfidentialComputingBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfidentialComputingBlockingStub> {
    private ConfidentialComputingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfidentialComputingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfidentialComputingBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Challenge in a given project and location.
     * </pre>
     */
    public com.google.cloud.confidentialcomputing.v1alpha1.Challenge createChallenge(
        com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateChallengeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Verifies the provided attestation info, returning a signed OIDC token.
     * </pre>
     */
    public com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse
        verifyAttestation(
            com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyAttestationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConfidentialComputing.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ConfidentialComputingFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfidentialComputingFutureStub> {
    private ConfidentialComputingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfidentialComputingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfidentialComputingFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Challenge in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.confidentialcomputing.v1alpha1.Challenge>
        createChallenge(
            com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateChallengeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Verifies the provided attestation info, returning a signed OIDC token.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>
        verifyAttestation(
            com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyAttestationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CHALLENGE = 0;
  private static final int METHODID_VERIFY_ATTESTATION = 1;

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
        case METHODID_CREATE_CHALLENGE:
          serviceImpl.createChallenge(
              (com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.confidentialcomputing.v1alpha1.Challenge>)
                  responseObserver);
          break;
        case METHODID_VERIFY_ATTESTATION:
          serviceImpl.verifyAttestation(
              (com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>)
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
            getCreateChallengeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.confidentialcomputing.v1alpha1.CreateChallengeRequest,
                    com.google.cloud.confidentialcomputing.v1alpha1.Challenge>(
                    service, METHODID_CREATE_CHALLENGE)))
        .addMethod(
            getVerifyAttestationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationRequest,
                    com.google.cloud.confidentialcomputing.v1alpha1.VerifyAttestationResponse>(
                    service, METHODID_VERIFY_ATTESTATION)))
        .build();
  }

  private abstract static class ConfidentialComputingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfidentialComputingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.confidentialcomputing.v1alpha1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfidentialComputing");
    }
  }

  private static final class ConfidentialComputingFileDescriptorSupplier
      extends ConfidentialComputingBaseDescriptorSupplier {
    ConfidentialComputingFileDescriptorSupplier() {}
  }

  private static final class ConfidentialComputingMethodDescriptorSupplier
      extends ConfidentialComputingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfidentialComputingMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfidentialComputingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfidentialComputingFileDescriptorSupplier())
                      .addMethod(getCreateChallengeMethod())
                      .addMethod(getVerifyAttestationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
