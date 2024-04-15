/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.discoveryengine.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for operations on the
 * [Project][google.cloud.discoveryengine.v1alpha.Project].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1alpha/project_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectServiceGrpc {

  private ProjectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1alpha.ProjectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetProjectRequest,
          com.google.cloud.discoveryengine.v1alpha.Project>
      getGetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProject",
      requestType = com.google.cloud.discoveryengine.v1alpha.GetProjectRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.GetProjectRequest,
          com.google.cloud.discoveryengine.v1alpha.Project>
      getGetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.GetProjectRequest,
            com.google.cloud.discoveryengine.v1alpha.Project>
        getGetProjectMethod;
    if ((getGetProjectMethod = ProjectServiceGrpc.getGetProjectMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getGetProjectMethod = ProjectServiceGrpc.getGetProjectMethod) == null) {
          ProjectServiceGrpc.getGetProjectMethod =
              getGetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.GetProjectRequest,
                          com.google.cloud.discoveryengine.v1alpha.Project>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.GetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Project
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("GetProject"))
                      .build();
        }
      }
    }
    return getGetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest,
          com.google.longrunning.Operation>
      getProvisionProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProvisionProject",
      requestType = com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest,
          com.google.longrunning.Operation>
      getProvisionProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest,
            com.google.longrunning.Operation>
        getProvisionProjectMethod;
    if ((getProvisionProjectMethod = ProjectServiceGrpc.getProvisionProjectMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getProvisionProjectMethod = ProjectServiceGrpc.getProvisionProjectMethod) == null) {
          ProjectServiceGrpc.getProvisionProjectMethod =
              getProvisionProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProvisionProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("ProvisionProject"))
                      .build();
        }
      }
    }
    return getProvisionProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest,
          com.google.cloud.discoveryengine.v1alpha.Project>
      getReportConsentChangeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportConsentChange",
      requestType = com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest.class,
      responseType = com.google.cloud.discoveryengine.v1alpha.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest,
          com.google.cloud.discoveryengine.v1alpha.Project>
      getReportConsentChangeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest,
            com.google.cloud.discoveryengine.v1alpha.Project>
        getReportConsentChangeMethod;
    if ((getReportConsentChangeMethod = ProjectServiceGrpc.getReportConsentChangeMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getReportConsentChangeMethod = ProjectServiceGrpc.getReportConsentChangeMethod)
            == null) {
          ProjectServiceGrpc.getReportConsentChangeMethod =
              getReportConsentChangeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest,
                          com.google.cloud.discoveryengine.v1alpha.Project>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReportConsentChange"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1alpha.Project
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("ReportConsentChange"))
                      .build();
        }
      }
    }
    return getReportConsentChangeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProjectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub>() {
          @java.lang.Override
          public ProjectServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceStub(channel, callOptions);
          }
        };
    return ProjectServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub>() {
          @java.lang.Override
          public ProjectServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceBlockingStub(channel, callOptions);
          }
        };
    return ProjectServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProjectServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub>() {
          @java.lang.Override
          public ProjectServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceFutureStub(channel, callOptions);
          }
        };
    return ProjectServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for operations on the
   * [Project][google.cloud.discoveryengine.v1alpha.Project].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a [Project][google.cloud.discoveryengine.v1alpha.Project].
     * Returns NOT_FOUND when the project is not yet created.
     * </pre>
     */
    default void getProject(
        com.google.cloud.discoveryengine.v1alpha.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provisions the project resource. During the
     * process, related systems will get prepared and initialized.
     * Caller must read the [Terms for data
     * use](https://cloud.google.com/retail/data-use-terms), and optionally
     * specify in request to provide consent to that service terms.
     * </pre>
     */
    default void provisionProject(
        com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProvisionProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates service terms for this project.
     * This method can be used to retroactively accept the latest terms.
     * Terms available for update:
     * * [Terms for data use](https://cloud.google.com/retail/data-use-terms)
     * </pre>
     */
    default void reportConsentChange(
        com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReportConsentChangeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProjectService.
   *
   * <pre>
   * Service for operations on the
   * [Project][google.cloud.discoveryengine.v1alpha.Project].
   * </pre>
   */
  public abstract static class ProjectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProjectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProjectService.
   *
   * <pre>
   * Service for operations on the
   * [Project][google.cloud.discoveryengine.v1alpha.Project].
   * </pre>
   */
  public static final class ProjectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProjectServiceStub> {
    private ProjectServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Project][google.cloud.discoveryengine.v1alpha.Project].
     * Returns NOT_FOUND when the project is not yet created.
     * </pre>
     */
    public void getProject(
        com.google.cloud.discoveryengine.v1alpha.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provisions the project resource. During the
     * process, related systems will get prepared and initialized.
     * Caller must read the [Terms for data
     * use](https://cloud.google.com/retail/data-use-terms), and optionally
     * specify in request to provide consent to that service terms.
     * </pre>
     */
    public void provisionProject(
        com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProvisionProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates service terms for this project.
     * This method can be used to retroactively accept the latest terms.
     * Terms available for update:
     * * [Terms for data use](https://cloud.google.com/retail/data-use-terms)
     * </pre>
     */
    public void reportConsentChange(
        com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReportConsentChangeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProjectService.
   *
   * <pre>
   * Service for operations on the
   * [Project][google.cloud.discoveryengine.v1alpha.Project].
   * </pre>
   */
  public static final class ProjectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProjectServiceBlockingStub> {
    private ProjectServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Project][google.cloud.discoveryengine.v1alpha.Project].
     * Returns NOT_FOUND when the project is not yet created.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Project getProject(
        com.google.cloud.discoveryengine.v1alpha.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Provisions the project resource. During the
     * process, related systems will get prepared and initialized.
     * Caller must read the [Terms for data
     * use](https://cloud.google.com/retail/data-use-terms), and optionally
     * specify in request to provide consent to that service terms.
     * </pre>
     */
    public com.google.longrunning.Operation provisionProject(
        com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProvisionProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates service terms for this project.
     * This method can be used to retroactively accept the latest terms.
     * Terms available for update:
     * * [Terms for data use](https://cloud.google.com/retail/data-use-terms)
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1alpha.Project reportConsentChange(
        com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReportConsentChangeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProjectService.
   *
   * <pre>
   * Service for operations on the
   * [Project][google.cloud.discoveryengine.v1alpha.Project].
   * </pre>
   */
  public static final class ProjectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProjectServiceFutureStub> {
    private ProjectServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a [Project][google.cloud.discoveryengine.v1alpha.Project].
     * Returns NOT_FOUND when the project is not yet created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Project>
        getProject(com.google.cloud.discoveryengine.v1alpha.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Provisions the project resource. During the
     * process, related systems will get prepared and initialized.
     * Caller must read the [Terms for data
     * use](https://cloud.google.com/retail/data-use-terms), and optionally
     * specify in request to provide consent to that service terms.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        provisionProject(com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProvisionProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates service terms for this project.
     * This method can be used to retroactively accept the latest terms.
     * Terms available for update:
     * * [Terms for data use](https://cloud.google.com/retail/data-use-terms)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1alpha.Project>
        reportConsentChange(
            com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReportConsentChangeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECT = 0;
  private static final int METHODID_PROVISION_PROJECT = 1;
  private static final int METHODID_REPORT_CONSENT_CHANGE = 2;

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
        case METHODID_GET_PROJECT:
          serviceImpl.getProject(
              (com.google.cloud.discoveryengine.v1alpha.GetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>)
                  responseObserver);
          break;
        case METHODID_PROVISION_PROJECT:
          serviceImpl.provisionProject(
              (com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPORT_CONSENT_CHANGE:
          serviceImpl.reportConsentChange(
              (com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1alpha.Project>)
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
            getGetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.GetProjectRequest,
                    com.google.cloud.discoveryengine.v1alpha.Project>(
                    service, METHODID_GET_PROJECT)))
        .addMethod(
            getProvisionProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ProvisionProjectRequest,
                    com.google.longrunning.Operation>(service, METHODID_PROVISION_PROJECT)))
        .addMethod(
            getReportConsentChangeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1alpha.ReportConsentChangeRequest,
                    com.google.cloud.discoveryengine.v1alpha.Project>(
                    service, METHODID_REPORT_CONSENT_CHANGE)))
        .build();
  }

  private abstract static class ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1alpha.ProjectServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectService");
    }
  }

  private static final class ProjectServiceFileDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier {
    ProjectServiceFileDescriptorSupplier() {}
  }

  private static final class ProjectServiceMethodDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProjectServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProjectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProjectServiceFileDescriptorSupplier())
                      .addMethod(getGetProjectMethod())
                      .addMethod(getProvisionProjectMethod())
                      .addMethod(getReportConsentChangeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
