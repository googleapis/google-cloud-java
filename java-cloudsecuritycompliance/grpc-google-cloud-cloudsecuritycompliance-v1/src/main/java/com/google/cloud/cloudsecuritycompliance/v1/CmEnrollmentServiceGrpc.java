/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.cloudsecuritycompliance.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing CmEnrollment related RPCs for
 * complianceManager.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class CmEnrollmentServiceGrpc {

  private CmEnrollmentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudsecuritycompliance.v1.CmEnrollmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
      getUpdateCmEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCmEnrollment",
      requestType = com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest.class,
      responseType = com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
      getUpdateCmEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
        getUpdateCmEnrollmentMethod;
    if ((getUpdateCmEnrollmentMethod = CmEnrollmentServiceGrpc.getUpdateCmEnrollmentMethod)
        == null) {
      synchronized (CmEnrollmentServiceGrpc.class) {
        if ((getUpdateCmEnrollmentMethod = CmEnrollmentServiceGrpc.getUpdateCmEnrollmentMethod)
            == null) {
          CmEnrollmentServiceGrpc.getUpdateCmEnrollmentMethod =
              getUpdateCmEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest,
                          com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCmEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmEnrollmentServiceMethodDescriptorSupplier("UpdateCmEnrollment"))
                      .build();
        }
      }
    }
    return getUpdateCmEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
      getCalculateEffectiveCmEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateEffectiveCmEnrollment",
      requestType =
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest.class,
      responseType =
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest,
          com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
      getCalculateEffectiveCmEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest,
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
        getCalculateEffectiveCmEnrollmentMethod;
    if ((getCalculateEffectiveCmEnrollmentMethod =
            CmEnrollmentServiceGrpc.getCalculateEffectiveCmEnrollmentMethod)
        == null) {
      synchronized (CmEnrollmentServiceGrpc.class) {
        if ((getCalculateEffectiveCmEnrollmentMethod =
                CmEnrollmentServiceGrpc.getCalculateEffectiveCmEnrollmentMethod)
            == null) {
          CmEnrollmentServiceGrpc.getCalculateEffectiveCmEnrollmentMethod =
              getCalculateEffectiveCmEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudsecuritycompliance.v1
                              .CalculateEffectiveCmEnrollmentRequest,
                          com.google.cloud.cloudsecuritycompliance.v1
                              .CalculateEffectiveCmEnrollmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CalculateEffectiveCmEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .CalculateEffectiveCmEnrollmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudsecuritycompliance.v1
                                  .CalculateEffectiveCmEnrollmentResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmEnrollmentServiceMethodDescriptorSupplier(
                              "CalculateEffectiveCmEnrollment"))
                      .build();
        }
      }
    }
    return getCalculateEffectiveCmEnrollmentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CmEnrollmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceStub>() {
          @java.lang.Override
          public CmEnrollmentServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmEnrollmentServiceStub(channel, callOptions);
          }
        };
    return CmEnrollmentServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CmEnrollmentServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceBlockingV2Stub>() {
          @java.lang.Override
          public CmEnrollmentServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmEnrollmentServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CmEnrollmentServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CmEnrollmentServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceBlockingStub>() {
          @java.lang.Override
          public CmEnrollmentServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmEnrollmentServiceBlockingStub(channel, callOptions);
          }
        };
    return CmEnrollmentServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CmEnrollmentServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmEnrollmentServiceFutureStub>() {
          @java.lang.Override
          public CmEnrollmentServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmEnrollmentServiceFutureStub(channel, callOptions);
          }
        };
    return CmEnrollmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Updates the Compliance Manager enrollment for a resource to facilitate
     * an audit.
     * Use this method to enroll a resource in Compliance Manager or to
     * create or update feature-specific configurations.
     * </pre>
     */
    default void updateCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCmEnrollmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Calculates the effective Compliance Manager enrollment for a resource.
     * An effective enrollment is either a direct enrollment of a
     * resource (if it exists), or an enrollment of the closest parent of a
     * resource that's enrolled in Compliance Manager.
     * </pre>
     */
    default void calculateEffectiveCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateEffectiveCmEnrollmentMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CmEnrollmentService.
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public abstract static class CmEnrollmentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CmEnrollmentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CmEnrollmentService.
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public static final class CmEnrollmentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CmEnrollmentServiceStub> {
    private CmEnrollmentServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmEnrollmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmEnrollmentServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the Compliance Manager enrollment for a resource to facilitate
     * an audit.
     * Use this method to enroll a resource in Compliance Manager or to
     * create or update feature-specific configurations.
     * </pre>
     */
    public void updateCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCmEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Calculates the effective Compliance Manager enrollment for a resource.
     * An effective enrollment is either a direct enrollment of a
     * resource (if it exists), or an enrollment of the closest parent of a
     * resource that's enrolled in Compliance Manager.
     * </pre>
     */
    public void calculateEffectiveCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateEffectiveCmEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CmEnrollmentService.
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public static final class CmEnrollmentServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CmEnrollmentServiceBlockingV2Stub> {
    private CmEnrollmentServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmEnrollmentServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmEnrollmentServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the Compliance Manager enrollment for a resource to facilitate
     * an audit.
     * Use this method to enroll a resource in Compliance Manager or to
     * create or update feature-specific configurations.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment updateCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateCmEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Calculates the effective Compliance Manager enrollment for a resource.
     * An effective enrollment is either a direct enrollment of a
     * resource (if it exists), or an enrollment of the closest parent of a
     * resource that's enrolled in Compliance Manager.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse
        calculateEffectiveCmEnrollment(
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest
                request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCalculateEffectiveCmEnrollmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CmEnrollmentService.
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public static final class CmEnrollmentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CmEnrollmentServiceBlockingStub> {
    private CmEnrollmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmEnrollmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmEnrollmentServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the Compliance Manager enrollment for a resource to facilitate
     * an audit.
     * Use this method to enroll a resource in Compliance Manager or to
     * create or update feature-specific configurations.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment updateCmEnrollment(
        com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCmEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Calculates the effective Compliance Manager enrollment for a resource.
     * An effective enrollment is either a direct enrollment of a
     * resource (if it exists), or an enrollment of the closest parent of a
     * resource that's enrolled in Compliance Manager.
     * </pre>
     */
    public com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse
        calculateEffectiveCmEnrollment(
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateEffectiveCmEnrollmentMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CmEnrollmentService.
   *
   * <pre>
   * Service describing CmEnrollment related RPCs for
   * complianceManager.
   * </pre>
   */
  public static final class CmEnrollmentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CmEnrollmentServiceFutureStub> {
    private CmEnrollmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmEnrollmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmEnrollmentServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Updates the Compliance Manager enrollment for a resource to facilitate
     * an audit.
     * Use this method to enroll a resource in Compliance Manager or to
     * create or update feature-specific configurations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>
        updateCmEnrollment(
            com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCmEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Calculates the effective Compliance Manager enrollment for a resource.
     * An effective enrollment is either a direct enrollment of a
     * resource (if it exists), or an enrollment of the closest parent of a
     * resource that's enrolled in Compliance Manager.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentResponse>
        calculateEffectiveCmEnrollment(
            com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateEffectiveCmEnrollmentMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_UPDATE_CM_ENROLLMENT = 0;
  private static final int METHODID_CALCULATE_EFFECTIVE_CM_ENROLLMENT = 1;

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
        case METHODID_UPDATE_CM_ENROLLMENT:
          serviceImpl.updateCmEnrollment(
              (com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>)
                  responseObserver);
          break;
        case METHODID_CALCULATE_EFFECTIVE_CM_ENROLLMENT:
          serviceImpl.calculateEffectiveCmEnrollment(
              (com.google.cloud.cloudsecuritycompliance.v1.CalculateEffectiveCmEnrollmentRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudsecuritycompliance.v1
                          .CalculateEffectiveCmEnrollmentResponse>)
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
            getUpdateCmEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1.UpdateCmEnrollmentRequest,
                    com.google.cloud.cloudsecuritycompliance.v1.CmEnrollment>(
                    service, METHODID_UPDATE_CM_ENROLLMENT)))
        .addMethod(
            getCalculateEffectiveCmEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudsecuritycompliance.v1
                        .CalculateEffectiveCmEnrollmentRequest,
                    com.google.cloud.cloudsecuritycompliance.v1
                        .CalculateEffectiveCmEnrollmentResponse>(
                    service, METHODID_CALCULATE_EFFECTIVE_CM_ENROLLMENT)))
        .build();
  }

  private abstract static class CmEnrollmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CmEnrollmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudsecuritycompliance.v1.CmEnrollmentServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CmEnrollmentService");
    }
  }

  private static final class CmEnrollmentServiceFileDescriptorSupplier
      extends CmEnrollmentServiceBaseDescriptorSupplier {
    CmEnrollmentServiceFileDescriptorSupplier() {}
  }

  private static final class CmEnrollmentServiceMethodDescriptorSupplier
      extends CmEnrollmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CmEnrollmentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CmEnrollmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CmEnrollmentServiceFileDescriptorSupplier())
                      .addMethod(getUpdateCmEnrollmentMethod())
                      .addMethod(getCalculateEffectiveCmEnrollmentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
