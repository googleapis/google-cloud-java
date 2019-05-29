package com.google.cloud.talent.v4beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * A service that handles application management, including CRUD and
 * enumeration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/application_service.proto")
public final class ApplicationServiceGrpc {

  private ApplicationServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.ApplicationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateApplicationMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      METHOD_CREATE_APPLICATION = getCreateApplicationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getCreateApplicationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getCreateApplicationMethod() {
    return getCreateApplicationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getCreateApplicationMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateApplicationRequest,
            com.google.cloud.talent.v4beta1.Application>
        getCreateApplicationMethod;
    if ((getCreateApplicationMethod = ApplicationServiceGrpc.getCreateApplicationMethod) == null) {
      synchronized (ApplicationServiceGrpc.class) {
        if ((getCreateApplicationMethod = ApplicationServiceGrpc.getCreateApplicationMethod)
            == null) {
          ApplicationServiceGrpc.getCreateApplicationMethod =
              getCreateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateApplicationRequest,
                          com.google.cloud.talent.v4beta1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ApplicationService",
                              "CreateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApplicationServiceMethodDescriptorSupplier("CreateApplication"))
                      .build();
        }
      }
    }
    return getCreateApplicationMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetApplicationMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      METHOD_GET_APPLICATION = getGetApplicationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getGetApplicationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getGetApplicationMethod() {
    return getGetApplicationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getGetApplicationMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.GetApplicationRequest,
            com.google.cloud.talent.v4beta1.Application>
        getGetApplicationMethod;
    if ((getGetApplicationMethod = ApplicationServiceGrpc.getGetApplicationMethod) == null) {
      synchronized (ApplicationServiceGrpc.class) {
        if ((getGetApplicationMethod = ApplicationServiceGrpc.getGetApplicationMethod) == null) {
          ApplicationServiceGrpc.getGetApplicationMethod =
              getGetApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.GetApplicationRequest,
                          com.google.cloud.talent.v4beta1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ApplicationService", "GetApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.GetApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApplicationServiceMethodDescriptorSupplier("GetApplication"))
                      .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateApplicationMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      METHOD_UPDATE_APPLICATION = getUpdateApplicationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getUpdateApplicationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getUpdateApplicationMethod() {
    return getUpdateApplicationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
          com.google.cloud.talent.v4beta1.Application>
      getUpdateApplicationMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
            com.google.cloud.talent.v4beta1.Application>
        getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = ApplicationServiceGrpc.getUpdateApplicationMethod) == null) {
      synchronized (ApplicationServiceGrpc.class) {
        if ((getUpdateApplicationMethod = ApplicationServiceGrpc.getUpdateApplicationMethod)
            == null) {
          ApplicationServiceGrpc.getUpdateApplicationMethod =
              getUpdateApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
                          com.google.cloud.talent.v4beta1.Application>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ApplicationService",
                              "UpdateApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.UpdateApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Application.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApplicationServiceMethodDescriptorSupplier("UpdateApplication"))
                      .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteApplicationMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteApplicationRequest, com.google.protobuf.Empty>
      METHOD_DELETE_APPLICATION = getDeleteApplicationMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteApplicationRequest, com.google.protobuf.Empty>
      getDeleteApplicationMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteApplicationRequest, com.google.protobuf.Empty>
      getDeleteApplicationMethod() {
    return getDeleteApplicationMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteApplicationRequest, com.google.protobuf.Empty>
      getDeleteApplicationMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.DeleteApplicationRequest, com.google.protobuf.Empty>
        getDeleteApplicationMethod;
    if ((getDeleteApplicationMethod = ApplicationServiceGrpc.getDeleteApplicationMethod) == null) {
      synchronized (ApplicationServiceGrpc.class) {
        if ((getDeleteApplicationMethod = ApplicationServiceGrpc.getDeleteApplicationMethod)
            == null) {
          ApplicationServiceGrpc.getDeleteApplicationMethod =
              getDeleteApplicationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.DeleteApplicationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ApplicationService",
                              "DeleteApplication"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.DeleteApplicationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApplicationServiceMethodDescriptorSupplier("DeleteApplication"))
                      .build();
        }
      }
    }
    return getDeleteApplicationMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListApplicationsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListApplicationsRequest,
          com.google.cloud.talent.v4beta1.ListApplicationsResponse>
      METHOD_LIST_APPLICATIONS = getListApplicationsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListApplicationsRequest,
          com.google.cloud.talent.v4beta1.ListApplicationsResponse>
      getListApplicationsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListApplicationsRequest,
          com.google.cloud.talent.v4beta1.ListApplicationsResponse>
      getListApplicationsMethod() {
    return getListApplicationsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListApplicationsRequest,
          com.google.cloud.talent.v4beta1.ListApplicationsResponse>
      getListApplicationsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ListApplicationsRequest,
            com.google.cloud.talent.v4beta1.ListApplicationsResponse>
        getListApplicationsMethod;
    if ((getListApplicationsMethod = ApplicationServiceGrpc.getListApplicationsMethod) == null) {
      synchronized (ApplicationServiceGrpc.class) {
        if ((getListApplicationsMethod = ApplicationServiceGrpc.getListApplicationsMethod)
            == null) {
          ApplicationServiceGrpc.getListApplicationsMethod =
              getListApplicationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ListApplicationsRequest,
                          com.google.cloud.talent.v4beta1.ListApplicationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.ApplicationService", "ListApplications"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListApplicationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListApplicationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ApplicationServiceMethodDescriptorSupplier("ListApplications"))
                      .build();
        }
      }
    }
    return getListApplicationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ApplicationServiceStub newStub(io.grpc.Channel channel) {
    return new ApplicationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApplicationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ApplicationServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ApplicationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ApplicationServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles application management, including CRUD and
   * enumeration.
   * </pre>
   */
  public abstract static class ApplicationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new application entity.
     * </pre>
     */
    public void createApplication(
        com.google.cloud.talent.v4beta1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateApplicationMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified application.
     * </pre>
     */
    public void getApplication(
        com.google.cloud.talent.v4beta1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnimplementedUnaryCall(getGetApplicationMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified application.
     * </pre>
     */
    public void updateApplication(
        com.google.cloud.talent.v4beta1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateApplicationMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified application.
     * </pre>
     */
    public void deleteApplication(
        com.google.cloud.talent.v4beta1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteApplicationMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all applications associated with the profile.
     * </pre>
     */
    public void listApplications(
        com.google.cloud.talent.v4beta1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListApplicationsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListApplicationsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateApplicationMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateApplicationRequest,
                      com.google.cloud.talent.v4beta1.Application>(
                      this, METHODID_CREATE_APPLICATION)))
          .addMethod(
              getGetApplicationMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetApplicationRequest,
                      com.google.cloud.talent.v4beta1.Application>(this, METHODID_GET_APPLICATION)))
          .addMethod(
              getUpdateApplicationMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateApplicationRequest,
                      com.google.cloud.talent.v4beta1.Application>(
                      this, METHODID_UPDATE_APPLICATION)))
          .addMethod(
              getDeleteApplicationMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteApplicationRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_APPLICATION)))
          .addMethod(
              getListApplicationsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListApplicationsRequest,
                      com.google.cloud.talent.v4beta1.ListApplicationsResponse>(
                      this, METHODID_LIST_APPLICATIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles application management, including CRUD and
   * enumeration.
   * </pre>
   */
  public static final class ApplicationServiceStub
      extends io.grpc.stub.AbstractStub<ApplicationServiceStub> {
    private ApplicationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new application entity.
     * </pre>
     */
    public void createApplication(
        com.google.cloud.talent.v4beta1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateApplicationMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified application.
     * </pre>
     */
    public void getApplication(
        com.google.cloud.talent.v4beta1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified application.
     * </pre>
     */
    public void updateApplication(
        com.google.cloud.talent.v4beta1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified application.
     * </pre>
     */
    public void deleteApplication(
        com.google.cloud.talent.v4beta1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all applications associated with the profile.
     * </pre>
     */
    public void listApplications(
        com.google.cloud.talent.v4beta1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListApplicationsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListApplicationsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles application management, including CRUD and
   * enumeration.
   * </pre>
   */
  public static final class ApplicationServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ApplicationServiceBlockingStub> {
    private ApplicationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new application entity.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Application createApplication(
        com.google.cloud.talent.v4beta1.CreateApplicationRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateApplicationMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified application.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Application getApplication(
        com.google.cloud.talent.v4beta1.GetApplicationRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetApplicationMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified application.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Application updateApplication(
        com.google.cloud.talent.v4beta1.UpdateApplicationRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateApplicationMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified application.
     * </pre>
     */
    public com.google.protobuf.Empty deleteApplication(
        com.google.cloud.talent.v4beta1.DeleteApplicationRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteApplicationMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all applications associated with the profile.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ListApplicationsResponse listApplications(
        com.google.cloud.talent.v4beta1.ListApplicationsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListApplicationsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles application management, including CRUD and
   * enumeration.
   * </pre>
   */
  public static final class ApplicationServiceFutureStub
      extends io.grpc.stub.AbstractStub<ApplicationServiceFutureStub> {
    private ApplicationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ApplicationServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new application entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Application>
        createApplication(com.google.cloud.talent.v4beta1.CreateApplicationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateApplicationMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Application>
        getApplication(com.google.cloud.talent.v4beta1.GetApplicationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetApplicationMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Application>
        updateApplication(com.google.cloud.talent.v4beta1.UpdateApplicationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteApplication(com.google.cloud.talent.v4beta1.DeleteApplicationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteApplicationMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all applications associated with the profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ListApplicationsResponse>
        listApplications(com.google.cloud.talent.v4beta1.ListApplicationsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListApplicationsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_APPLICATION = 0;
  private static final int METHODID_GET_APPLICATION = 1;
  private static final int METHODID_UPDATE_APPLICATION = 2;
  private static final int METHODID_DELETE_APPLICATION = 3;
  private static final int METHODID_LIST_APPLICATIONS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ApplicationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ApplicationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_APPLICATION:
          serviceImpl.createApplication(
              (com.google.cloud.talent.v4beta1.CreateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application>)
                  responseObserver);
          break;
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication(
              (com.google.cloud.talent.v4beta1.GetApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application>)
                  responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication(
              (com.google.cloud.talent.v4beta1.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Application>)
                  responseObserver);
          break;
        case METHODID_DELETE_APPLICATION:
          serviceImpl.deleteApplication(
              (com.google.cloud.talent.v4beta1.DeleteApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_APPLICATIONS:
          serviceImpl.listApplications(
              (com.google.cloud.talent.v4beta1.ListApplicationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.talent.v4beta1.ListApplicationsResponse>)
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

  private abstract static class ApplicationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApplicationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.ApplicationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApplicationService");
    }
  }

  private static final class ApplicationServiceFileDescriptorSupplier
      extends ApplicationServiceBaseDescriptorSupplier {
    ApplicationServiceFileDescriptorSupplier() {}
  }

  private static final class ApplicationServiceMethodDescriptorSupplier
      extends ApplicationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ApplicationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ApplicationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ApplicationServiceFileDescriptorSupplier())
                      .addMethod(getCreateApplicationMethodHelper())
                      .addMethod(getGetApplicationMethodHelper())
                      .addMethod(getUpdateApplicationMethodHelper())
                      .addMethod(getDeleteApplicationMethodHelper())
                      .addMethod(getListApplicationsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
