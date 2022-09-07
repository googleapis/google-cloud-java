package com.google.appengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages App Engine applications.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/appengine/v1/appengine.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApplicationsGrpc {

  private ApplicationsGrpc() {}

  public static final String SERVICE_NAME = "google.appengine.v1.Applications";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.GetApplicationRequest,
      com.google.appengine.v1.Application> getGetApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplication",
      requestType = com.google.appengine.v1.GetApplicationRequest.class,
      responseType = com.google.appengine.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.GetApplicationRequest,
      com.google.appengine.v1.Application> getGetApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.GetApplicationRequest, com.google.appengine.v1.Application> getGetApplicationMethod;
    if ((getGetApplicationMethod = ApplicationsGrpc.getGetApplicationMethod) == null) {
      synchronized (ApplicationsGrpc.class) {
        if ((getGetApplicationMethod = ApplicationsGrpc.getGetApplicationMethod) == null) {
          ApplicationsGrpc.getGetApplicationMethod = getGetApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.GetApplicationRequest, com.google.appengine.v1.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.Application.getDefaultInstance()))
              .setSchemaDescriptor(new ApplicationsMethodDescriptorSupplier("GetApplication"))
              .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.CreateApplicationRequest,
      com.google.longrunning.Operation> getCreateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplication",
      requestType = com.google.appengine.v1.CreateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.CreateApplicationRequest,
      com.google.longrunning.Operation> getCreateApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.CreateApplicationRequest, com.google.longrunning.Operation> getCreateApplicationMethod;
    if ((getCreateApplicationMethod = ApplicationsGrpc.getCreateApplicationMethod) == null) {
      synchronized (ApplicationsGrpc.class) {
        if ((getCreateApplicationMethod = ApplicationsGrpc.getCreateApplicationMethod) == null) {
          ApplicationsGrpc.getCreateApplicationMethod = getCreateApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.CreateApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApplicationsMethodDescriptorSupplier("CreateApplication"))
              .build();
        }
      }
    }
    return getCreateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateApplicationRequest,
      com.google.longrunning.Operation> getUpdateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplication",
      requestType = com.google.appengine.v1.UpdateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateApplicationRequest,
      com.google.longrunning.Operation> getUpdateApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.UpdateApplicationRequest, com.google.longrunning.Operation> getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = ApplicationsGrpc.getUpdateApplicationMethod) == null) {
      synchronized (ApplicationsGrpc.class) {
        if ((getUpdateApplicationMethod = ApplicationsGrpc.getUpdateApplicationMethod) == null) {
          ApplicationsGrpc.getUpdateApplicationMethod = getUpdateApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.UpdateApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApplicationsMethodDescriptorSupplier("UpdateApplication"))
              .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.appengine.v1.RepairApplicationRequest,
      com.google.longrunning.Operation> getRepairApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepairApplication",
      requestType = com.google.appengine.v1.RepairApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.appengine.v1.RepairApplicationRequest,
      com.google.longrunning.Operation> getRepairApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.appengine.v1.RepairApplicationRequest, com.google.longrunning.Operation> getRepairApplicationMethod;
    if ((getRepairApplicationMethod = ApplicationsGrpc.getRepairApplicationMethod) == null) {
      synchronized (ApplicationsGrpc.class) {
        if ((getRepairApplicationMethod = ApplicationsGrpc.getRepairApplicationMethod) == null) {
          ApplicationsGrpc.getRepairApplicationMethod = getRepairApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.appengine.v1.RepairApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RepairApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.appengine.v1.RepairApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApplicationsMethodDescriptorSupplier("RepairApplication"))
              .build();
        }
      }
    }
    return getRepairApplicationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ApplicationsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApplicationsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApplicationsStub>() {
        @java.lang.Override
        public ApplicationsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApplicationsStub(channel, callOptions);
        }
      };
    return ApplicationsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApplicationsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApplicationsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApplicationsBlockingStub>() {
        @java.lang.Override
        public ApplicationsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApplicationsBlockingStub(channel, callOptions);
        }
      };
    return ApplicationsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ApplicationsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApplicationsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApplicationsFutureStub>() {
        @java.lang.Override
        public ApplicationsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApplicationsFutureStub(channel, callOptions);
        }
      };
    return ApplicationsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages App Engine applications.
   * </pre>
   */
  public static abstract class ApplicationsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets information about an application.
     * </pre>
     */
    public void getApplication(com.google.appengine.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an App Engine application for a Google Cloud Platform project.
     * Required fields:
     * * `id` - The ID of the target Cloud Platform project.
     * * *location* - The [region](https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.
     * For more information about App Engine applications, see [Managing Projects, Applications, and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
     * </pre>
     */
    public void createApplication(com.google.appengine.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the specified Application resource.
     * You can update the following fields:
     * * `auth_domain` - Google authentication domain for controlling user access to the application.
     * * `default_cookie_expiration` - Cookie expiration policy for the application.
     * * `iap` - Identity-Aware Proxy properties for the application.
     * </pre>
     */
    public void updateApplication(com.google.appengine.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Recreates the required App Engine features for the specified App Engine
     * application, for example a Cloud Storage bucket or App Engine service
     * account.
     * Use this method if you receive an error message about a missing feature,
     * for example, *Error retrieving the App Engine service account*.
     * If you have deleted your App Engine service account, this will
     * not be able to recreate it. Instead, you should attempt to use the
     * IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D .
     * If the deletion was recent, the numeric ID can be found in the Cloud
     * Console Activity Log.
     * </pre>
     */
    public void repairApplication(com.google.appengine.v1.RepairApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRepairApplicationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.GetApplicationRequest,
                com.google.appengine.v1.Application>(
                  this, METHODID_GET_APPLICATION)))
          .addMethod(
            getCreateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.CreateApplicationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_APPLICATION)))
          .addMethod(
            getUpdateApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.UpdateApplicationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_APPLICATION)))
          .addMethod(
            getRepairApplicationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.appengine.v1.RepairApplicationRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_REPAIR_APPLICATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Manages App Engine applications.
   * </pre>
   */
  public static final class ApplicationsStub extends io.grpc.stub.AbstractAsyncStub<ApplicationsStub> {
    private ApplicationsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about an application.
     * </pre>
     */
    public void getApplication(com.google.appengine.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.appengine.v1.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an App Engine application for a Google Cloud Platform project.
     * Required fields:
     * * `id` - The ID of the target Cloud Platform project.
     * * *location* - The [region](https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.
     * For more information about App Engine applications, see [Managing Projects, Applications, and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
     * </pre>
     */
    public void createApplication(com.google.appengine.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the specified Application resource.
     * You can update the following fields:
     * * `auth_domain` - Google authentication domain for controlling user access to the application.
     * * `default_cookie_expiration` - Cookie expiration policy for the application.
     * * `iap` - Identity-Aware Proxy properties for the application.
     * </pre>
     */
    public void updateApplication(com.google.appengine.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Recreates the required App Engine features for the specified App Engine
     * application, for example a Cloud Storage bucket or App Engine service
     * account.
     * Use this method if you receive an error message about a missing feature,
     * for example, *Error retrieving the App Engine service account*.
     * If you have deleted your App Engine service account, this will
     * not be able to recreate it. Instead, you should attempt to use the
     * IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D .
     * If the deletion was recent, the numeric ID can be found in the Cloud
     * Console Activity Log.
     * </pre>
     */
    public void repairApplication(com.google.appengine.v1.RepairApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepairApplicationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Manages App Engine applications.
   * </pre>
   */
  public static final class ApplicationsBlockingStub extends io.grpc.stub.AbstractBlockingStub<ApplicationsBlockingStub> {
    private ApplicationsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about an application.
     * </pre>
     */
    public com.google.appengine.v1.Application getApplication(com.google.appengine.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an App Engine application for a Google Cloud Platform project.
     * Required fields:
     * * `id` - The ID of the target Cloud Platform project.
     * * *location* - The [region](https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.
     * For more information about App Engine applications, see [Managing Projects, Applications, and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
     * </pre>
     */
    public com.google.longrunning.Operation createApplication(com.google.appengine.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the specified Application resource.
     * You can update the following fields:
     * * `auth_domain` - Google authentication domain for controlling user access to the application.
     * * `default_cookie_expiration` - Cookie expiration policy for the application.
     * * `iap` - Identity-Aware Proxy properties for the application.
     * </pre>
     */
    public com.google.longrunning.Operation updateApplication(com.google.appengine.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Recreates the required App Engine features for the specified App Engine
     * application, for example a Cloud Storage bucket or App Engine service
     * account.
     * Use this method if you receive an error message about a missing feature,
     * for example, *Error retrieving the App Engine service account*.
     * If you have deleted your App Engine service account, this will
     * not be able to recreate it. Instead, you should attempt to use the
     * IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D .
     * If the deletion was recent, the numeric ID can be found in the Cloud
     * Console Activity Log.
     * </pre>
     */
    public com.google.longrunning.Operation repairApplication(com.google.appengine.v1.RepairApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepairApplicationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Manages App Engine applications.
   * </pre>
   */
  public static final class ApplicationsFutureStub extends io.grpc.stub.AbstractFutureStub<ApplicationsFutureStub> {
    private ApplicationsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApplicationsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApplicationsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets information about an application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.appengine.v1.Application> getApplication(
        com.google.appengine.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an App Engine application for a Google Cloud Platform project.
     * Required fields:
     * * `id` - The ID of the target Cloud Platform project.
     * * *location* - The [region](https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.
     * For more information about App Engine applications, see [Managing Projects, Applications, and Billing](https://cloud.google.com/appengine/docs/standard/python/console/).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createApplication(
        com.google.appengine.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the specified Application resource.
     * You can update the following fields:
     * * `auth_domain` - Google authentication domain for controlling user access to the application.
     * * `default_cookie_expiration` - Cookie expiration policy for the application.
     * * `iap` - Identity-Aware Proxy properties for the application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateApplication(
        com.google.appengine.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Recreates the required App Engine features for the specified App Engine
     * application, for example a Cloud Storage bucket or App Engine service
     * account.
     * Use this method if you receive an error message about a missing feature,
     * for example, *Error retrieving the App Engine service account*.
     * If you have deleted your App Engine service account, this will
     * not be able to recreate it. Instead, you should attempt to use the
     * IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B"name"%3A"projects%2F-%2FserviceAccounts%2Funique_id"%2C"resource"%3A%7B%7D%7D .
     * If the deletion was recent, the numeric ID can be found in the Cloud
     * Console Activity Log.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> repairApplication(
        com.google.appengine.v1.RepairApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepairApplicationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_APPLICATION = 0;
  private static final int METHODID_CREATE_APPLICATION = 1;
  private static final int METHODID_UPDATE_APPLICATION = 2;
  private static final int METHODID_REPAIR_APPLICATION = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ApplicationsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ApplicationsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication((com.google.appengine.v1.GetApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.appengine.v1.Application>) responseObserver);
          break;
        case METHODID_CREATE_APPLICATION:
          serviceImpl.createApplication((com.google.appengine.v1.CreateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication((com.google.appengine.v1.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REPAIR_APPLICATION:
          serviceImpl.repairApplication((com.google.appengine.v1.RepairApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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

  private static abstract class ApplicationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApplicationsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.appengine.v1.AppengineProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Applications");
    }
  }

  private static final class ApplicationsFileDescriptorSupplier
      extends ApplicationsBaseDescriptorSupplier {
    ApplicationsFileDescriptorSupplier() {}
  }

  private static final class ApplicationsMethodDescriptorSupplier
      extends ApplicationsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ApplicationsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ApplicationsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ApplicationsFileDescriptorSupplier())
              .addMethod(getGetApplicationMethod())
              .addMethod(getCreateApplicationMethod())
              .addMethod(getUpdateApplicationMethod())
              .addMethod(getRepairApplicationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
