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
package com.google.protos.google.cloud.binaryauthorization.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * BinAuthz Attestor verification
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/binaryauthorization/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ValidationHelperV1Grpc {

  private ValidationHelperV1Grpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.binaryauthorization.v1.ValidationHelperV1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceRequest,
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceResponse>
      getValidateAttestationOccurrenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateAttestationOccurrence",
      requestType =
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceRequest.class,
      responseType =
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceRequest,
          com.google.protos.google.cloud.binaryauthorization.v1.Service
              .ValidateAttestationOccurrenceResponse>
      getValidateAttestationOccurrenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.protos.google.cloud.binaryauthorization.v1.Service
                .ValidateAttestationOccurrenceRequest,
            com.google.protos.google.cloud.binaryauthorization.v1.Service
                .ValidateAttestationOccurrenceResponse>
        getValidateAttestationOccurrenceMethod;
    if ((getValidateAttestationOccurrenceMethod =
            ValidationHelperV1Grpc.getValidateAttestationOccurrenceMethod)
        == null) {
      synchronized (ValidationHelperV1Grpc.class) {
        if ((getValidateAttestationOccurrenceMethod =
                ValidationHelperV1Grpc.getValidateAttestationOccurrenceMethod)
            == null) {
          ValidationHelperV1Grpc.getValidateAttestationOccurrenceMethod =
              getValidateAttestationOccurrenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.protos.google.cloud.binaryauthorization.v1.Service
                              .ValidateAttestationOccurrenceRequest,
                          com.google.protos.google.cloud.binaryauthorization.v1.Service
                              .ValidateAttestationOccurrenceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ValidateAttestationOccurrence"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protos.google.cloud.binaryauthorization.v1.Service
                                  .ValidateAttestationOccurrenceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protos.google.cloud.binaryauthorization.v1.Service
                                  .ValidateAttestationOccurrenceResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ValidationHelperV1MethodDescriptorSupplier(
                              "ValidateAttestationOccurrence"))
                      .build();
        }
      }
    }
    return getValidateAttestationOccurrenceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ValidationHelperV1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1Stub>() {
          @java.lang.Override
          public ValidationHelperV1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ValidationHelperV1Stub(channel, callOptions);
          }
        };
    return ValidationHelperV1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ValidationHelperV1BlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1BlockingStub>() {
          @java.lang.Override
          public ValidationHelperV1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ValidationHelperV1BlockingStub(channel, callOptions);
          }
        };
    return ValidationHelperV1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ValidationHelperV1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ValidationHelperV1FutureStub>() {
          @java.lang.Override
          public ValidationHelperV1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ValidationHelperV1FutureStub(channel, callOptions);
          }
        };
    return ValidationHelperV1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * BinAuthz Attestor verification
   * </pre>
   */
  public abstract static class ValidationHelperV1ImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Returns whether the given Attestation for the given image URI
     * was signed by the given Attestor
     * </pre>
     */
    public void validateAttestationOccurrence(
        com.google.protos.google.cloud.binaryauthorization.v1.Service
                .ValidateAttestationOccurrenceRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.protos.google.cloud.binaryauthorization.v1.Service
                    .ValidateAttestationOccurrenceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getValidateAttestationOccurrenceMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getValidateAttestationOccurrenceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.protos.google.cloud.binaryauthorization.v1.Service
                          .ValidateAttestationOccurrenceRequest,
                      com.google.protos.google.cloud.binaryauthorization.v1.Service
                          .ValidateAttestationOccurrenceResponse>(
                      this, METHODID_VALIDATE_ATTESTATION_OCCURRENCE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * BinAuthz Attestor verification
   * </pre>
   */
  public static final class ValidationHelperV1Stub
      extends io.grpc.stub.AbstractAsyncStub<ValidationHelperV1Stub> {
    private ValidationHelperV1Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationHelperV1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationHelperV1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns whether the given Attestation for the given image URI
     * was signed by the given Attestor
     * </pre>
     */
    public void validateAttestationOccurrence(
        com.google.protos.google.cloud.binaryauthorization.v1.Service
                .ValidateAttestationOccurrenceRequest
            request,
        io.grpc.stub.StreamObserver<
                com.google.protos.google.cloud.binaryauthorization.v1.Service
                    .ValidateAttestationOccurrenceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateAttestationOccurrenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * BinAuthz Attestor verification
   * </pre>
   */
  public static final class ValidationHelperV1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ValidationHelperV1BlockingStub> {
    private ValidationHelperV1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationHelperV1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationHelperV1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns whether the given Attestation for the given image URI
     * was signed by the given Attestor
     * </pre>
     */
    public com.google.protos.google.cloud.binaryauthorization.v1.Service
            .ValidateAttestationOccurrenceResponse
        validateAttestationOccurrence(
            com.google.protos.google.cloud.binaryauthorization.v1.Service
                    .ValidateAttestationOccurrenceRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateAttestationOccurrenceMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * BinAuthz Attestor verification
   * </pre>
   */
  public static final class ValidationHelperV1FutureStub
      extends io.grpc.stub.AbstractFutureStub<ValidationHelperV1FutureStub> {
    private ValidationHelperV1FutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ValidationHelperV1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ValidationHelperV1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns whether the given Attestation for the given image URI
     * was signed by the given Attestor
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.protos.google.cloud.binaryauthorization.v1.Service
                .ValidateAttestationOccurrenceResponse>
        validateAttestationOccurrence(
            com.google.protos.google.cloud.binaryauthorization.v1.Service
                    .ValidateAttestationOccurrenceRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateAttestationOccurrenceMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_VALIDATE_ATTESTATION_OCCURRENCE = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ValidationHelperV1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ValidationHelperV1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VALIDATE_ATTESTATION_OCCURRENCE:
          serviceImpl.validateAttestationOccurrence(
              (com.google.protos.google.cloud.binaryauthorization.v1.Service
                      .ValidateAttestationOccurrenceRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.protos.google.cloud.binaryauthorization.v1.Service
                          .ValidateAttestationOccurrenceResponse>)
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

  private abstract static class ValidationHelperV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ValidationHelperV1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.protos.google.cloud.binaryauthorization.v1.Service.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ValidationHelperV1");
    }
  }

  private static final class ValidationHelperV1FileDescriptorSupplier
      extends ValidationHelperV1BaseDescriptorSupplier {
    ValidationHelperV1FileDescriptorSupplier() {}
  }

  private static final class ValidationHelperV1MethodDescriptorSupplier
      extends ValidationHelperV1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ValidationHelperV1MethodDescriptorSupplier(String methodName) {
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
      synchronized (ValidationHelperV1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ValidationHelperV1FileDescriptorSupplier())
                      .addMethod(getValidateAttestationOccurrenceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
