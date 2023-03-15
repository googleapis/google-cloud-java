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
package com.google.cloud.security.publicca.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages the resources required for ACME [external account
 * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for
 * the public certificate authority service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/security/publicca/v1beta1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PublicCertificateAuthorityServiceGrpc {

  private PublicCertificateAuthorityServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.security.publicca.v1beta1.PublicCertificateAuthorityService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest,
          com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
      getCreateExternalAccountKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateExternalAccountKey",
      requestType =
          com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest.class,
      responseType = com.google.cloud.security.publicca.v1beta1.ExternalAccountKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest,
          com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
      getCreateExternalAccountKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest,
            com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
        getCreateExternalAccountKeyMethod;
    if ((getCreateExternalAccountKeyMethod =
            PublicCertificateAuthorityServiceGrpc.getCreateExternalAccountKeyMethod)
        == null) {
      synchronized (PublicCertificateAuthorityServiceGrpc.class) {
        if ((getCreateExternalAccountKeyMethod =
                PublicCertificateAuthorityServiceGrpc.getCreateExternalAccountKeyMethod)
            == null) {
          PublicCertificateAuthorityServiceGrpc.getCreateExternalAccountKeyMethod =
              getCreateExternalAccountKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest,
                          com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateExternalAccountKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.publicca.v1beta1
                                  .CreateExternalAccountKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.security.publicca.v1beta1.ExternalAccountKey
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PublicCertificateAuthorityServiceMethodDescriptorSupplier(
                              "CreateExternalAccountKey"))
                      .build();
        }
      }
    }
    return getCreateExternalAccountKeyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PublicCertificateAuthorityServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceStub>() {
          @java.lang.Override
          public PublicCertificateAuthorityServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublicCertificateAuthorityServiceStub(channel, callOptions);
          }
        };
    return PublicCertificateAuthorityServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PublicCertificateAuthorityServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceBlockingStub>() {
          @java.lang.Override
          public PublicCertificateAuthorityServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublicCertificateAuthorityServiceBlockingStub(channel, callOptions);
          }
        };
    return PublicCertificateAuthorityServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PublicCertificateAuthorityServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PublicCertificateAuthorityServiceFutureStub>() {
          @java.lang.Override
          public PublicCertificateAuthorityServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PublicCertificateAuthorityServiceFutureStub(channel, callOptions);
          }
        };
    return PublicCertificateAuthorityServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages the resources required for ACME [external account
   * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for
   * the public certificate authority service.
   * </pre>
   */
  public abstract static class PublicCertificateAuthorityServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey] bound to the project.
     * </pre>
     */
    public void createExternalAccountKey(
        com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateExternalAccountKeyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateExternalAccountKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest,
                      com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>(
                      this, METHODID_CREATE_EXTERNAL_ACCOUNT_KEY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages the resources required for ACME [external account
   * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for
   * the public certificate authority service.
   * </pre>
   */
  public static final class PublicCertificateAuthorityServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PublicCertificateAuthorityServiceStub> {
    private PublicCertificateAuthorityServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublicCertificateAuthorityServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublicCertificateAuthorityServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey] bound to the project.
     * </pre>
     */
    public void createExternalAccountKey(
        com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateExternalAccountKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages the resources required for ACME [external account
   * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for
   * the public certificate authority service.
   * </pre>
   */
  public static final class PublicCertificateAuthorityServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PublicCertificateAuthorityServiceBlockingStub> {
    private PublicCertificateAuthorityServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublicCertificateAuthorityServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublicCertificateAuthorityServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey] bound to the project.
     * </pre>
     */
    public com.google.cloud.security.publicca.v1beta1.ExternalAccountKey createExternalAccountKey(
        com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateExternalAccountKeyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages the resources required for ACME [external account
   * binding](https://tools.ietf.org/html/rfc8555#section-7.3.4) for
   * the public certificate authority service.
   * </pre>
   */
  public static final class PublicCertificateAuthorityServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PublicCertificateAuthorityServiceFutureStub> {
    private PublicCertificateAuthorityServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PublicCertificateAuthorityServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PublicCertificateAuthorityServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [ExternalAccountKey][google.cloud.security.publicca.v1beta1.ExternalAccountKey] bound to the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>
        createExternalAccountKey(
            com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateExternalAccountKeyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_EXTERNAL_ACCOUNT_KEY = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PublicCertificateAuthorityServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PublicCertificateAuthorityServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_EXTERNAL_ACCOUNT_KEY:
          serviceImpl.createExternalAccountKey(
              (com.google.cloud.security.publicca.v1beta1.CreateExternalAccountKeyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.security.publicca.v1beta1.ExternalAccountKey>)
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

  private abstract static class PublicCertificateAuthorityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PublicCertificateAuthorityServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.security.publicca.v1beta1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PublicCertificateAuthorityService");
    }
  }

  private static final class PublicCertificateAuthorityServiceFileDescriptorSupplier
      extends PublicCertificateAuthorityServiceBaseDescriptorSupplier {
    PublicCertificateAuthorityServiceFileDescriptorSupplier() {}
  }

  private static final class PublicCertificateAuthorityServiceMethodDescriptorSupplier
      extends PublicCertificateAuthorityServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PublicCertificateAuthorityServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PublicCertificateAuthorityServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new PublicCertificateAuthorityServiceFileDescriptorSupplier())
                      .addMethod(getCreateExternalAccountKeyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
