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
 * A service that handles tenant management, including CRUD and enumeration.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/talent/v4beta1/tenant_service.proto")
public final class TenantServiceGrpc {

  private TenantServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.talent.v4beta1.TenantService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTenantMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      METHOD_CREATE_TENANT = getCreateTenantMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getCreateTenantMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getCreateTenantMethod() {
    return getCreateTenantMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.CreateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getCreateTenantMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.CreateTenantRequest,
            com.google.cloud.talent.v4beta1.Tenant>
        getCreateTenantMethod;
    if ((getCreateTenantMethod = TenantServiceGrpc.getCreateTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getCreateTenantMethod = TenantServiceGrpc.getCreateTenantMethod) == null) {
          TenantServiceGrpc.getCreateTenantMethod =
              getCreateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.CreateTenantRequest,
                          com.google.cloud.talent.v4beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.TenantService", "CreateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.CreateTenantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("CreateTenant"))
                      .build();
        }
      }
    }
    return getCreateTenantMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTenantMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetTenantRequest, com.google.cloud.talent.v4beta1.Tenant>
      METHOD_GET_TENANT = getGetTenantMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetTenantRequest, com.google.cloud.talent.v4beta1.Tenant>
      getGetTenantMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetTenantRequest, com.google.cloud.talent.v4beta1.Tenant>
      getGetTenantMethod() {
    return getGetTenantMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.GetTenantRequest, com.google.cloud.talent.v4beta1.Tenant>
      getGetTenantMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.GetTenantRequest,
            com.google.cloud.talent.v4beta1.Tenant>
        getGetTenantMethod;
    if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getGetTenantMethod = TenantServiceGrpc.getGetTenantMethod) == null) {
          TenantServiceGrpc.getGetTenantMethod =
              getGetTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.GetTenantRequest,
                          com.google.cloud.talent.v4beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.TenantService", "GetTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.GetTenantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("GetTenant"))
                      .build();
        }
      }
    }
    return getGetTenantMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTenantMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      METHOD_UPDATE_TENANT = getUpdateTenantMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getUpdateTenantMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getUpdateTenantMethod() {
    return getUpdateTenantMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.UpdateTenantRequest,
          com.google.cloud.talent.v4beta1.Tenant>
      getUpdateTenantMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.UpdateTenantRequest,
            com.google.cloud.talent.v4beta1.Tenant>
        getUpdateTenantMethod;
    if ((getUpdateTenantMethod = TenantServiceGrpc.getUpdateTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getUpdateTenantMethod = TenantServiceGrpc.getUpdateTenantMethod) == null) {
          TenantServiceGrpc.getUpdateTenantMethod =
              getUpdateTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.UpdateTenantRequest,
                          com.google.cloud.talent.v4beta1.Tenant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.TenantService", "UpdateTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.UpdateTenantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.Tenant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("UpdateTenant"))
                      .build();
        }
      }
    }
    return getUpdateTenantMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTenantMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteTenantRequest, com.google.protobuf.Empty>
      METHOD_DELETE_TENANT = getDeleteTenantMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteTenantRequest, com.google.protobuf.Empty>
      getDeleteTenantMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteTenantRequest, com.google.protobuf.Empty>
      getDeleteTenantMethod() {
    return getDeleteTenantMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.DeleteTenantRequest, com.google.protobuf.Empty>
      getDeleteTenantMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.DeleteTenantRequest, com.google.protobuf.Empty>
        getDeleteTenantMethod;
    if ((getDeleteTenantMethod = TenantServiceGrpc.getDeleteTenantMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getDeleteTenantMethod = TenantServiceGrpc.getDeleteTenantMethod) == null) {
          TenantServiceGrpc.getDeleteTenantMethod =
              getDeleteTenantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.DeleteTenantRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.TenantService", "DeleteTenant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.DeleteTenantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TenantServiceMethodDescriptorSupplier("DeleteTenant"))
                      .build();
        }
      }
    }
    return getDeleteTenantMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTenantsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListTenantsRequest,
          com.google.cloud.talent.v4beta1.ListTenantsResponse>
      METHOD_LIST_TENANTS = getListTenantsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListTenantsRequest,
          com.google.cloud.talent.v4beta1.ListTenantsResponse>
      getListTenantsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListTenantsRequest,
          com.google.cloud.talent.v4beta1.ListTenantsResponse>
      getListTenantsMethod() {
    return getListTenantsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.talent.v4beta1.ListTenantsRequest,
          com.google.cloud.talent.v4beta1.ListTenantsResponse>
      getListTenantsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.talent.v4beta1.ListTenantsRequest,
            com.google.cloud.talent.v4beta1.ListTenantsResponse>
        getListTenantsMethod;
    if ((getListTenantsMethod = TenantServiceGrpc.getListTenantsMethod) == null) {
      synchronized (TenantServiceGrpc.class) {
        if ((getListTenantsMethod = TenantServiceGrpc.getListTenantsMethod) == null) {
          TenantServiceGrpc.getListTenantsMethod =
              getListTenantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.talent.v4beta1.ListTenantsRequest,
                          com.google.cloud.talent.v4beta1.ListTenantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.talent.v4beta1.TenantService", "ListTenants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListTenantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.talent.v4beta1.ListTenantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TenantServiceMethodDescriptorSupplier("ListTenants"))
                      .build();
        }
      }
    }
    return getListTenantsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TenantServiceStub newStub(io.grpc.Channel channel) {
    return new TenantServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TenantServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new TenantServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TenantServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new TenantServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public abstract static class TenantServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public void createTenant(
        com.google.cloud.talent.v4beta1.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTenantMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public void getTenant(
        com.google.cloud.talent.v4beta1.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTenantMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public void updateTenant(
        com.google.cloud.talent.v4beta1.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTenantMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public void deleteTenant(
        com.google.cloud.talent.v4beta1.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTenantMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public void listTenants(
        com.google.cloud.talent.v4beta1.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListTenantsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTenantsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateTenantMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.CreateTenantRequest,
                      com.google.cloud.talent.v4beta1.Tenant>(this, METHODID_CREATE_TENANT)))
          .addMethod(
              getGetTenantMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.GetTenantRequest,
                      com.google.cloud.talent.v4beta1.Tenant>(this, METHODID_GET_TENANT)))
          .addMethod(
              getUpdateTenantMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.UpdateTenantRequest,
                      com.google.cloud.talent.v4beta1.Tenant>(this, METHODID_UPDATE_TENANT)))
          .addMethod(
              getDeleteTenantMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.DeleteTenantRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TENANT)))
          .addMethod(
              getListTenantsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.talent.v4beta1.ListTenantsRequest,
                      com.google.cloud.talent.v4beta1.ListTenantsResponse>(
                      this, METHODID_LIST_TENANTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceStub extends io.grpc.stub.AbstractStub<TenantServiceStub> {
    private TenantServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TenantServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public void createTenant(
        com.google.cloud.talent.v4beta1.CreateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTenantMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public void getTenant(
        com.google.cloud.talent.v4beta1.GetTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTenantMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public void updateTenant(
        com.google.cloud.talent.v4beta1.UpdateTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTenantMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public void deleteTenant(
        com.google.cloud.talent.v4beta1.DeleteTenantRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTenantMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public void listTenants(
        com.google.cloud.talent.v4beta1.ListTenantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListTenantsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTenantsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceBlockingStub
      extends io.grpc.stub.AbstractStub<TenantServiceBlockingStub> {
    private TenantServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TenantServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Tenant createTenant(
        com.google.cloud.talent.v4beta1.CreateTenantRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTenantMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Tenant getTenant(
        com.google.cloud.talent.v4beta1.GetTenantRequest request) {
      return blockingUnaryCall(getChannel(), getGetTenantMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.Tenant updateTenant(
        com.google.cloud.talent.v4beta1.UpdateTenantRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTenantMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTenant(
        com.google.cloud.talent.v4beta1.DeleteTenantRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTenantMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public com.google.cloud.talent.v4beta1.ListTenantsResponse listTenants(
        com.google.cloud.talent.v4beta1.ListTenantsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTenantsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * A service that handles tenant management, including CRUD and enumeration.
   * </pre>
   */
  public static final class TenantServiceFutureStub
      extends io.grpc.stub.AbstractStub<TenantServiceFutureStub> {
    private TenantServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TenantServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TenantServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TenantServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new tenant entity.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Tenant>
        createTenant(com.google.cloud.talent.v4beta1.CreateTenantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTenantMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Tenant>
        getTenant(com.google.cloud.talent.v4beta1.GetTenantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTenantMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.Tenant>
        updateTenant(com.google.cloud.talent.v4beta1.UpdateTenantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTenantMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes specified tenant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTenant(com.google.cloud.talent.v4beta1.DeleteTenantRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTenantMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all tenants associated with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.talent.v4beta1.ListTenantsResponse>
        listTenants(com.google.cloud.talent.v4beta1.ListTenantsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTenantsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TENANT = 0;
  private static final int METHODID_GET_TENANT = 1;
  private static final int METHODID_UPDATE_TENANT = 2;
  private static final int METHODID_DELETE_TENANT = 3;
  private static final int METHODID_LIST_TENANTS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TenantServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TenantServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TENANT:
          serviceImpl.createTenant(
              (com.google.cloud.talent.v4beta1.CreateTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_GET_TENANT:
          serviceImpl.getTenant(
              (com.google.cloud.talent.v4beta1.GetTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TENANT:
          serviceImpl.updateTenant(
              (com.google.cloud.talent.v4beta1.UpdateTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.Tenant>)
                  responseObserver);
          break;
        case METHODID_DELETE_TENANT:
          serviceImpl.deleteTenant(
              (com.google.cloud.talent.v4beta1.DeleteTenantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_TENANTS:
          serviceImpl.listTenants(
              (com.google.cloud.talent.v4beta1.ListTenantsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.talent.v4beta1.ListTenantsResponse>)
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

  private abstract static class TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TenantServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.talent.v4beta1.TenantServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TenantService");
    }
  }

  private static final class TenantServiceFileDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier {
    TenantServiceFileDescriptorSupplier() {}
  }

  private static final class TenantServiceMethodDescriptorSupplier
      extends TenantServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TenantServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TenantServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TenantServiceFileDescriptorSupplier())
                      .addMethod(getCreateTenantMethodHelper())
                      .addMethod(getGetTenantMethodHelper())
                      .addMethod(getUpdateTenantMethodHelper())
                      .addMethod(getDeleteTenantMethodHelper())
                      .addMethod(getListTenantsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
