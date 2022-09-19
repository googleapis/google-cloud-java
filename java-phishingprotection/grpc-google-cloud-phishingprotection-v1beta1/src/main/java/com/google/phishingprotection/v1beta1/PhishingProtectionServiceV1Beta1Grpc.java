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
package com.google.phishingprotection.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to report phishing URIs.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/phishingprotection/v1beta1/phishingprotection.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PhishingProtectionServiceV1Beta1Grpc {

  private PhishingProtectionServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.phishingprotection.v1beta1.PhishingProtectionServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.phishingprotection.v1beta1.ReportPhishingRequest,
          com.google.phishingprotection.v1beta1.ReportPhishingResponse>
      getReportPhishingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportPhishing",
      requestType = com.google.phishingprotection.v1beta1.ReportPhishingRequest.class,
      responseType = com.google.phishingprotection.v1beta1.ReportPhishingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.phishingprotection.v1beta1.ReportPhishingRequest,
          com.google.phishingprotection.v1beta1.ReportPhishingResponse>
      getReportPhishingMethod() {
    io.grpc.MethodDescriptor<
            com.google.phishingprotection.v1beta1.ReportPhishingRequest,
            com.google.phishingprotection.v1beta1.ReportPhishingResponse>
        getReportPhishingMethod;
    if ((getReportPhishingMethod = PhishingProtectionServiceV1Beta1Grpc.getReportPhishingMethod)
        == null) {
      synchronized (PhishingProtectionServiceV1Beta1Grpc.class) {
        if ((getReportPhishingMethod = PhishingProtectionServiceV1Beta1Grpc.getReportPhishingMethod)
            == null) {
          PhishingProtectionServiceV1Beta1Grpc.getReportPhishingMethod =
              getReportPhishingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.phishingprotection.v1beta1.ReportPhishingRequest,
                          com.google.phishingprotection.v1beta1.ReportPhishingResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReportPhishing"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.phishingprotection.v1beta1.ReportPhishingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.phishingprotection.v1beta1.ReportPhishingResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PhishingProtectionServiceV1Beta1MethodDescriptorSupplier(
                              "ReportPhishing"))
                      .build();
        }
      }
    }
    return getReportPhishingMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PhishingProtectionServiceV1Beta1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1Stub>() {
          @java.lang.Override
          public PhishingProtectionServiceV1Beta1Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhishingProtectionServiceV1Beta1Stub(channel, callOptions);
          }
        };
    return PhishingProtectionServiceV1Beta1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PhishingProtectionServiceV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1BlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1BlockingStub>() {
          @java.lang.Override
          public PhishingProtectionServiceV1Beta1BlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhishingProtectionServiceV1Beta1BlockingStub(channel, callOptions);
          }
        };
    return PhishingProtectionServiceV1Beta1BlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PhishingProtectionServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1FutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<PhishingProtectionServiceV1Beta1FutureStub>() {
          @java.lang.Override
          public PhishingProtectionServiceV1Beta1FutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new PhishingProtectionServiceV1Beta1FutureStub(channel, callOptions);
          }
        };
    return PhishingProtectionServiceV1Beta1FutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to report phishing URIs.
   * </pre>
   */
  public abstract static class PhishingProtectionServiceV1Beta1ImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Reports a URI suspected of containing phishing content to be reviewed. Once
     * the report review is complete, its result can be found in the Cloud
     * Security Command Center findings dashboard for Phishing Protection. If the
     * result verifies the existence of malicious phishing content, the site will
     * be added the to [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future.
     * </pre>
     */
    public void reportPhishing(
        com.google.phishingprotection.v1beta1.ReportPhishingRequest request,
        io.grpc.stub.StreamObserver<com.google.phishingprotection.v1beta1.ReportPhishingResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportPhishingMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getReportPhishingMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.phishingprotection.v1beta1.ReportPhishingRequest,
                      com.google.phishingprotection.v1beta1.ReportPhishingResponse>(
                      this, METHODID_REPORT_PHISHING)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to report phishing URIs.
   * </pre>
   */
  public static final class PhishingProtectionServiceV1Beta1Stub
      extends io.grpc.stub.AbstractAsyncStub<PhishingProtectionServiceV1Beta1Stub> {
    private PhishingProtectionServiceV1Beta1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhishingProtectionServiceV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhishingProtectionServiceV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Reports a URI suspected of containing phishing content to be reviewed. Once
     * the report review is complete, its result can be found in the Cloud
     * Security Command Center findings dashboard for Phishing Protection. If the
     * result verifies the existence of malicious phishing content, the site will
     * be added the to [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future.
     * </pre>
     */
    public void reportPhishing(
        com.google.phishingprotection.v1beta1.ReportPhishingRequest request,
        io.grpc.stub.StreamObserver<com.google.phishingprotection.v1beta1.ReportPhishingResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportPhishingMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to report phishing URIs.
   * </pre>
   */
  public static final class PhishingProtectionServiceV1Beta1BlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PhishingProtectionServiceV1Beta1BlockingStub> {
    private PhishingProtectionServiceV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhishingProtectionServiceV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhishingProtectionServiceV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Reports a URI suspected of containing phishing content to be reviewed. Once
     * the report review is complete, its result can be found in the Cloud
     * Security Command Center findings dashboard for Phishing Protection. If the
     * result verifies the existence of malicious phishing content, the site will
     * be added the to [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future.
     * </pre>
     */
    public com.google.phishingprotection.v1beta1.ReportPhishingResponse reportPhishing(
        com.google.phishingprotection.v1beta1.ReportPhishingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportPhishingMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to report phishing URIs.
   * </pre>
   */
  public static final class PhishingProtectionServiceV1Beta1FutureStub
      extends io.grpc.stub.AbstractFutureStub<PhishingProtectionServiceV1Beta1FutureStub> {
    private PhishingProtectionServiceV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PhishingProtectionServiceV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PhishingProtectionServiceV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Reports a URI suspected of containing phishing content to be reviewed. Once
     * the report review is complete, its result can be found in the Cloud
     * Security Command Center findings dashboard for Phishing Protection. If the
     * result verifies the existence of malicious phishing content, the site will
     * be added the to [Google's Social Engineering
     * lists](https://support.google.com/webmasters/answer/6350487/) in order to
     * protect users that could get exposed to this threat in the future.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.phishingprotection.v1beta1.ReportPhishingResponse>
        reportPhishing(com.google.phishingprotection.v1beta1.ReportPhishingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportPhishingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_PHISHING = 0;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PhishingProtectionServiceV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PhishingProtectionServiceV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_PHISHING:
          serviceImpl.reportPhishing(
              (com.google.phishingprotection.v1beta1.ReportPhishingRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.phishingprotection.v1beta1.ReportPhishingResponse>)
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

  private abstract static class PhishingProtectionServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PhishingProtectionServiceV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.phishingprotection.v1beta1.PhishingProtectionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PhishingProtectionServiceV1Beta1");
    }
  }

  private static final class PhishingProtectionServiceV1Beta1FileDescriptorSupplier
      extends PhishingProtectionServiceV1Beta1BaseDescriptorSupplier {
    PhishingProtectionServiceV1Beta1FileDescriptorSupplier() {}
  }

  private static final class PhishingProtectionServiceV1Beta1MethodDescriptorSupplier
      extends PhishingProtectionServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PhishingProtectionServiceV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (PhishingProtectionServiceV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new PhishingProtectionServiceV1Beta1FileDescriptorSupplier())
                      .addMethod(getReportPhishingMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
