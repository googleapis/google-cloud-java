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
package com.google.cloud.cloudcontrolspartner.v1beta;

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
    comments = "Source: google/cloud/cloudcontrolspartner/v1beta/monitoring.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudControlsPartnerMonitoringGrpc {

  private CloudControlsPartnerMonitoringGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerMonitoring";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest,
          com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
      getListViolationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListViolations",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest,
          com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
      getListViolationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest,
            com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
        getListViolationsMethod;
    if ((getListViolationsMethod = CloudControlsPartnerMonitoringGrpc.getListViolationsMethod)
        == null) {
      synchronized (CloudControlsPartnerMonitoringGrpc.class) {
        if ((getListViolationsMethod = CloudControlsPartnerMonitoringGrpc.getListViolationsMethod)
            == null) {
          CloudControlsPartnerMonitoringGrpc.getListViolationsMethod =
              getListViolationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest,
                          com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListViolations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudControlsPartnerMonitoringMethodDescriptorSupplier(
                              "ListViolations"))
                      .build();
        }
      }
    }
    return getListViolationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest,
          com.google.cloud.cloudcontrolspartner.v1beta.Violation>
      getGetViolationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetViolation",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.Violation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest,
          com.google.cloud.cloudcontrolspartner.v1beta.Violation>
      getGetViolationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest,
            com.google.cloud.cloudcontrolspartner.v1beta.Violation>
        getGetViolationMethod;
    if ((getGetViolationMethod = CloudControlsPartnerMonitoringGrpc.getGetViolationMethod)
        == null) {
      synchronized (CloudControlsPartnerMonitoringGrpc.class) {
        if ((getGetViolationMethod = CloudControlsPartnerMonitoringGrpc.getGetViolationMethod)
            == null) {
          CloudControlsPartnerMonitoringGrpc.getGetViolationMethod =
              getGetViolationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest,
                          com.google.cloud.cloudcontrolspartner.v1beta.Violation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetViolation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.cloudcontrolspartner.v1beta.Violation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudControlsPartnerMonitoringMethodDescriptorSupplier(
                              "GetViolation"))
                      .build();
        }
      }
    }
    return getGetViolationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudControlsPartnerMonitoringStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringStub>() {
          @java.lang.Override
          public CloudControlsPartnerMonitoringStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudControlsPartnerMonitoringStub(channel, callOptions);
          }
        };
    return CloudControlsPartnerMonitoringStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudControlsPartnerMonitoringBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringBlockingStub>() {
          @java.lang.Override
          public CloudControlsPartnerMonitoringBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudControlsPartnerMonitoringBlockingStub(channel, callOptions);
          }
        };
    return CloudControlsPartnerMonitoringBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudControlsPartnerMonitoringFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerMonitoringFutureStub>() {
          @java.lang.Override
          public CloudControlsPartnerMonitoringFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudControlsPartnerMonitoringFutureStub(channel, callOptions);
          }
        };
    return CloudControlsPartnerMonitoringFutureStub.newStub(factory, channel);
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
     * Lists Violations for a workload
     * Callers may also choose to read across multiple Customers or for a single
     * customer as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of {customer} &amp; {workload}.
     * Format:
     * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
     * </pre>
     */
    default void listViolations(
        com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListViolationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Violation.
     * </pre>
     */
    default void getViolation(
        com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Violation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetViolationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudControlsPartnerMonitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class CloudControlsPartnerMonitoringImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudControlsPartnerMonitoringGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudControlsPartnerMonitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerMonitoringStub
      extends io.grpc.stub.AbstractAsyncStub<CloudControlsPartnerMonitoringStub> {
    private CloudControlsPartnerMonitoringStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerMonitoringStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerMonitoringStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Violations for a workload
     * Callers may also choose to read across multiple Customers or for a single
     * customer as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of {customer} &amp; {workload}.
     * Format:
     * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
     * </pre>
     */
    public void listViolations(
        com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListViolationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Violation.
     * </pre>
     */
    public void getViolation(
        com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Violation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetViolationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudControlsPartnerMonitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerMonitoringBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudControlsPartnerMonitoringBlockingStub> {
    private CloudControlsPartnerMonitoringBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerMonitoringBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerMonitoringBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Violations for a workload
     * Callers may also choose to read across multiple Customers or for a single
     * customer as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of {customer} &amp; {workload}.
     * Format:
     * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse listViolations(
        com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViolationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Violation.
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.Violation getViolation(
        com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViolationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * CloudControlsPartnerMonitoring.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerMonitoringFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudControlsPartnerMonitoringFutureStub> {
    private CloudControlsPartnerMonitoringFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerMonitoringFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerMonitoringFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Violations for a workload
     * Callers may also choose to read across multiple Customers or for a single
     * customer as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of {customer} &amp; {workload}.
     * Format:
     * `organizations/{organization}/locations/{location}/customers/{customer}/workloads/{workload}`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>
        listViolations(com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListViolationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Violation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.cloudcontrolspartner.v1beta.Violation>
        getViolation(com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetViolationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VIOLATIONS = 0;
  private static final int METHODID_GET_VIOLATION = 1;

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
        case METHODID_LIST_VIOLATIONS:
          serviceImpl.listViolations(
              (com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VIOLATION:
          serviceImpl.getViolation(
              (com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Violation>)
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
            getListViolationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsRequest,
                    com.google.cloud.cloudcontrolspartner.v1beta.ListViolationsResponse>(
                    service, METHODID_LIST_VIOLATIONS)))
        .addMethod(
            getGetViolationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.cloudcontrolspartner.v1beta.GetViolationRequest,
                    com.google.cloud.cloudcontrolspartner.v1beta.Violation>(
                    service, METHODID_GET_VIOLATION)))
        .build();
  }

  private abstract static class CloudControlsPartnerMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudControlsPartnerMonitoringBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudcontrolspartner.v1beta.MonitoringProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudControlsPartnerMonitoring");
    }
  }

  private static final class CloudControlsPartnerMonitoringFileDescriptorSupplier
      extends CloudControlsPartnerMonitoringBaseDescriptorSupplier {
    CloudControlsPartnerMonitoringFileDescriptorSupplier() {}
  }

  private static final class CloudControlsPartnerMonitoringMethodDescriptorSupplier
      extends CloudControlsPartnerMonitoringBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudControlsPartnerMonitoringMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudControlsPartnerMonitoringGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new CloudControlsPartnerMonitoringFileDescriptorSupplier())
                      .addMethod(getListViolationsMethod())
                      .addMethod(getGetViolationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
