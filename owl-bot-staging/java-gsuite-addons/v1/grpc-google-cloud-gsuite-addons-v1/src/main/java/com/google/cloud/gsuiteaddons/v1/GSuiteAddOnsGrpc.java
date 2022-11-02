package com.google.cloud.gsuiteaddons.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for managing Google Workspace Add-ons deployments.
 * A Google Workspace Add-on is a third-party embedded component that can be
 * installed in Google Workspace Applications like Gmail, Calendar, Drive, and
 * the Google Docs, Sheets, and Slides editors. Google Workspace Add-ons can
 * display UI cards, receive contextual information from the host application,
 * and perform actions in the host application (See:
 * https://developers.google.com/gsuite/add-ons/overview for more information).
 * A Google Workspace Add-on deployment resource specifies metadata about the
 * add-on, including a specification of the entry points in the host application
 * that trigger add-on executions (see:
 * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests).
 * Add-on deployments defined via the Google Workspace Add-ons API define their
 * entrypoints using HTTPS URLs (See:
 * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
 * A Google Workspace Add-on deployment can be installed in developer mode,
 * which allows an add-on developer to test the experience an end-user would see
 * when installing and running the add-on in their G Suite applications.  When
 * running in developer mode, more detailed error messages are exposed in the
 * add-on UI to aid in debugging.
 * A Google Workspace Add-on deployment can be published to Google Workspace
 * Marketplace, which allows other Google Workspace users to discover and
 * install the add-on.  See:
 * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview
 * for details.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gsuiteaddons/v1/gsuiteaddons.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GSuiteAddOnsGrpc {

  private GSuiteAddOnsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.gsuiteaddons.v1.GSuiteAddOns";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest,
      com.google.cloud.gsuiteaddons.v1.Authorization> getGetAuthorizationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuthorization",
      requestType = com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.Authorization.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest,
      com.google.cloud.gsuiteaddons.v1.Authorization> getGetAuthorizationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest, com.google.cloud.gsuiteaddons.v1.Authorization> getGetAuthorizationMethod;
    if ((getGetAuthorizationMethod = GSuiteAddOnsGrpc.getGetAuthorizationMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getGetAuthorizationMethod = GSuiteAddOnsGrpc.getGetAuthorizationMethod) == null) {
          GSuiteAddOnsGrpc.getGetAuthorizationMethod = getGetAuthorizationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest, com.google.cloud.gsuiteaddons.v1.Authorization>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuthorization"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.Authorization.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("GetAuthorization"))
              .build();
        }
      }
    }
    return getGetAuthorizationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getCreateDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getCreateDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment> getCreateDeploymentMethod;
    if ((getCreateDeploymentMethod = GSuiteAddOnsGrpc.getCreateDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getCreateDeploymentMethod = GSuiteAddOnsGrpc.getCreateDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getCreateDeploymentMethod = getCreateDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.Deployment.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("CreateDeployment"))
              .build();
        }
      }
    }
    return getCreateDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getReplaceDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReplaceDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getReplaceDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment> getReplaceDeploymentMethod;
    if ((getReplaceDeploymentMethod = GSuiteAddOnsGrpc.getReplaceDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getReplaceDeploymentMethod = GSuiteAddOnsGrpc.getReplaceDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getReplaceDeploymentMethod = getReplaceDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReplaceDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.Deployment.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("ReplaceDeployment"))
              .build();
        }
      }
    }
    return getReplaceDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getGetDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.Deployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest,
      com.google.cloud.gsuiteaddons.v1.Deployment> getGetDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment> getGetDeploymentMethod;
    if ((getGetDeploymentMethod = GSuiteAddOnsGrpc.getGetDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getGetDeploymentMethod = GSuiteAddOnsGrpc.getGetDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getGetDeploymentMethod = getGetDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest, com.google.cloud.gsuiteaddons.v1.Deployment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.Deployment.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("GetDeployment"))
              .build();
        }
      }
    }
    return getGetDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest,
      com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> getListDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDeployments",
      requestType = com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest,
      com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> getListDeploymentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest, com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> getListDeploymentsMethod;
    if ((getListDeploymentsMethod = GSuiteAddOnsGrpc.getListDeploymentsMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getListDeploymentsMethod = GSuiteAddOnsGrpc.getListDeploymentsMethod) == null) {
          GSuiteAddOnsGrpc.getListDeploymentsMethod = getListDeploymentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest, com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDeployments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("ListDeployments"))
              .build();
        }
      }
    }
    return getListDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest,
      com.google.protobuf.Empty> getDeleteDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest,
      com.google.protobuf.Empty> getDeleteDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest, com.google.protobuf.Empty> getDeleteDeploymentMethod;
    if ((getDeleteDeploymentMethod = GSuiteAddOnsGrpc.getDeleteDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getDeleteDeploymentMethod = GSuiteAddOnsGrpc.getDeleteDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getDeleteDeploymentMethod = getDeleteDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("DeleteDeployment"))
              .build();
        }
      }
    }
    return getDeleteDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest,
      com.google.protobuf.Empty> getInstallDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InstallDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest,
      com.google.protobuf.Empty> getInstallDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest, com.google.protobuf.Empty> getInstallDeploymentMethod;
    if ((getInstallDeploymentMethod = GSuiteAddOnsGrpc.getInstallDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getInstallDeploymentMethod = GSuiteAddOnsGrpc.getInstallDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getInstallDeploymentMethod = getInstallDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "InstallDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("InstallDeployment"))
              .build();
        }
      }
    }
    return getInstallDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest,
      com.google.protobuf.Empty> getUninstallDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UninstallDeployment",
      requestType = com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest,
      com.google.protobuf.Empty> getUninstallDeploymentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest, com.google.protobuf.Empty> getUninstallDeploymentMethod;
    if ((getUninstallDeploymentMethod = GSuiteAddOnsGrpc.getUninstallDeploymentMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getUninstallDeploymentMethod = GSuiteAddOnsGrpc.getUninstallDeploymentMethod) == null) {
          GSuiteAddOnsGrpc.getUninstallDeploymentMethod = getUninstallDeploymentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UninstallDeployment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("UninstallDeployment"))
              .build();
        }
      }
    }
    return getUninstallDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest,
      com.google.cloud.gsuiteaddons.v1.InstallStatus> getGetInstallStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstallStatus",
      requestType = com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest.class,
      responseType = com.google.cloud.gsuiteaddons.v1.InstallStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest,
      com.google.cloud.gsuiteaddons.v1.InstallStatus> getGetInstallStatusMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest, com.google.cloud.gsuiteaddons.v1.InstallStatus> getGetInstallStatusMethod;
    if ((getGetInstallStatusMethod = GSuiteAddOnsGrpc.getGetInstallStatusMethod) == null) {
      synchronized (GSuiteAddOnsGrpc.class) {
        if ((getGetInstallStatusMethod = GSuiteAddOnsGrpc.getGetInstallStatusMethod) == null) {
          GSuiteAddOnsGrpc.getGetInstallStatusMethod = getGetInstallStatusMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest, com.google.cloud.gsuiteaddons.v1.InstallStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstallStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.gsuiteaddons.v1.InstallStatus.getDefaultInstance()))
              .setSchemaDescriptor(new GSuiteAddOnsMethodDescriptorSupplier("GetInstallStatus"))
              .build();
        }
      }
    }
    return getGetInstallStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GSuiteAddOnsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsStub>() {
        @java.lang.Override
        public GSuiteAddOnsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GSuiteAddOnsStub(channel, callOptions);
        }
      };
    return GSuiteAddOnsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GSuiteAddOnsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsBlockingStub>() {
        @java.lang.Override
        public GSuiteAddOnsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GSuiteAddOnsBlockingStub(channel, callOptions);
        }
      };
    return GSuiteAddOnsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GSuiteAddOnsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GSuiteAddOnsFutureStub>() {
        @java.lang.Override
        public GSuiteAddOnsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GSuiteAddOnsFutureStub(channel, callOptions);
        }
      };
    return GSuiteAddOnsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for managing Google Workspace Add-ons deployments.
   * A Google Workspace Add-on is a third-party embedded component that can be
   * installed in Google Workspace Applications like Gmail, Calendar, Drive, and
   * the Google Docs, Sheets, and Slides editors. Google Workspace Add-ons can
   * display UI cards, receive contextual information from the host application,
   * and perform actions in the host application (See:
   * https://developers.google.com/gsuite/add-ons/overview for more information).
   * A Google Workspace Add-on deployment resource specifies metadata about the
   * add-on, including a specification of the entry points in the host application
   * that trigger add-on executions (see:
   * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests).
   * Add-on deployments defined via the Google Workspace Add-ons API define their
   * entrypoints using HTTPS URLs (See:
   * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
   * A Google Workspace Add-on deployment can be installed in developer mode,
   * which allows an add-on developer to test the experience an end-user would see
   * when installing and running the add-on in their G Suite applications.  When
   * running in developer mode, more detailed error messages are exposed in the
   * add-on UI to aid in debugging.
   * A Google Workspace Add-on deployment can be published to Google Workspace
   * Marketplace, which allows other Google Workspace users to discover and
   * install the add-on.  See:
   * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview
   * for details.
   * </pre>
   */
  public static abstract class GSuiteAddOnsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Gets the authorization information for deployments in a given project.
     * </pre>
     */
    public void getAuthorization(com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Authorization> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAuthorizationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a deployment with the specified name and configuration.
     * </pre>
     */
    public void createDeployment(com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates or replaces a deployment with the specified name.
     * </pre>
     */
    public void replaceDeployment(com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReplaceDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the deployment with the specified name.
     * </pre>
     */
    public void getDeployment(com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all deployments in a particular project.
     * </pre>
     */
    public void listDeployments(com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDeploymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes the deployment with the given name.
     * </pre>
     */
    public void deleteDeployment(com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Installs a deployment in developer mode.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public void installDeployment(com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getInstallDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Uninstalls a developer mode deployment.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public void uninstallDeployment(com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUninstallDeploymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Fetches the install status of a developer mode deployment.
     * </pre>
     */
    public void getInstallStatus(com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.InstallStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInstallStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAuthorizationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest,
                com.google.cloud.gsuiteaddons.v1.Authorization>(
                  this, METHODID_GET_AUTHORIZATION)))
          .addMethod(
            getCreateDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest,
                com.google.cloud.gsuiteaddons.v1.Deployment>(
                  this, METHODID_CREATE_DEPLOYMENT)))
          .addMethod(
            getReplaceDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest,
                com.google.cloud.gsuiteaddons.v1.Deployment>(
                  this, METHODID_REPLACE_DEPLOYMENT)))
          .addMethod(
            getGetDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest,
                com.google.cloud.gsuiteaddons.v1.Deployment>(
                  this, METHODID_GET_DEPLOYMENT)))
          .addMethod(
            getListDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest,
                com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse>(
                  this, METHODID_LIST_DEPLOYMENTS)))
          .addMethod(
            getDeleteDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_DEPLOYMENT)))
          .addMethod(
            getInstallDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_INSTALL_DEPLOYMENT)))
          .addMethod(
            getUninstallDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_UNINSTALL_DEPLOYMENT)))
          .addMethod(
            getGetInstallStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest,
                com.google.cloud.gsuiteaddons.v1.InstallStatus>(
                  this, METHODID_GET_INSTALL_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * A service for managing Google Workspace Add-ons deployments.
   * A Google Workspace Add-on is a third-party embedded component that can be
   * installed in Google Workspace Applications like Gmail, Calendar, Drive, and
   * the Google Docs, Sheets, and Slides editors. Google Workspace Add-ons can
   * display UI cards, receive contextual information from the host application,
   * and perform actions in the host application (See:
   * https://developers.google.com/gsuite/add-ons/overview for more information).
   * A Google Workspace Add-on deployment resource specifies metadata about the
   * add-on, including a specification of the entry points in the host application
   * that trigger add-on executions (see:
   * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests).
   * Add-on deployments defined via the Google Workspace Add-ons API define their
   * entrypoints using HTTPS URLs (See:
   * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
   * A Google Workspace Add-on deployment can be installed in developer mode,
   * which allows an add-on developer to test the experience an end-user would see
   * when installing and running the add-on in their G Suite applications.  When
   * running in developer mode, more detailed error messages are exposed in the
   * add-on UI to aid in debugging.
   * A Google Workspace Add-on deployment can be published to Google Workspace
   * Marketplace, which allows other Google Workspace users to discover and
   * install the add-on.  See:
   * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview
   * for details.
   * </pre>
   */
  public static final class GSuiteAddOnsStub extends io.grpc.stub.AbstractAsyncStub<GSuiteAddOnsStub> {
    private GSuiteAddOnsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GSuiteAddOnsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GSuiteAddOnsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the authorization information for deployments in a given project.
     * </pre>
     */
    public void getAuthorization(com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Authorization> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuthorizationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a deployment with the specified name and configuration.
     * </pre>
     */
    public void createDeployment(com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates or replaces a deployment with the specified name.
     * </pre>
     */
    public void replaceDeployment(com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReplaceDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the deployment with the specified name.
     * </pre>
     */
    public void getDeployment(com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all deployments in a particular project.
     * </pre>
     */
    public void listDeployments(com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes the deployment with the given name.
     * </pre>
     */
    public void deleteDeployment(com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Installs a deployment in developer mode.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public void installDeployment(com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInstallDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Uninstalls a developer mode deployment.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public void uninstallDeployment(com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUninstallDeploymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Fetches the install status of a developer mode deployment.
     * </pre>
     */
    public void getInstallStatus(com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.InstallStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstallStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service for managing Google Workspace Add-ons deployments.
   * A Google Workspace Add-on is a third-party embedded component that can be
   * installed in Google Workspace Applications like Gmail, Calendar, Drive, and
   * the Google Docs, Sheets, and Slides editors. Google Workspace Add-ons can
   * display UI cards, receive contextual information from the host application,
   * and perform actions in the host application (See:
   * https://developers.google.com/gsuite/add-ons/overview for more information).
   * A Google Workspace Add-on deployment resource specifies metadata about the
   * add-on, including a specification of the entry points in the host application
   * that trigger add-on executions (see:
   * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests).
   * Add-on deployments defined via the Google Workspace Add-ons API define their
   * entrypoints using HTTPS URLs (See:
   * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
   * A Google Workspace Add-on deployment can be installed in developer mode,
   * which allows an add-on developer to test the experience an end-user would see
   * when installing and running the add-on in their G Suite applications.  When
   * running in developer mode, more detailed error messages are exposed in the
   * add-on UI to aid in debugging.
   * A Google Workspace Add-on deployment can be published to Google Workspace
   * Marketplace, which allows other Google Workspace users to discover and
   * install the add-on.  See:
   * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview
   * for details.
   * </pre>
   */
  public static final class GSuiteAddOnsBlockingStub extends io.grpc.stub.AbstractBlockingStub<GSuiteAddOnsBlockingStub> {
    private GSuiteAddOnsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GSuiteAddOnsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GSuiteAddOnsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the authorization information for deployments in a given project.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.Authorization getAuthorization(com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuthorizationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a deployment with the specified name and configuration.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.Deployment createDeployment(com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates or replaces a deployment with the specified name.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.Deployment replaceDeployment(com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReplaceDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the deployment with the specified name.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.Deployment getDeployment(com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all deployments in a particular project.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse listDeployments(com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes the deployment with the given name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDeployment(com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Installs a deployment in developer mode.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public com.google.protobuf.Empty installDeployment(com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInstallDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Uninstalls a developer mode deployment.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public com.google.protobuf.Empty uninstallDeployment(com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUninstallDeploymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Fetches the install status of a developer mode deployment.
     * </pre>
     */
    public com.google.cloud.gsuiteaddons.v1.InstallStatus getInstallStatus(com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstallStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service for managing Google Workspace Add-ons deployments.
   * A Google Workspace Add-on is a third-party embedded component that can be
   * installed in Google Workspace Applications like Gmail, Calendar, Drive, and
   * the Google Docs, Sheets, and Slides editors. Google Workspace Add-ons can
   * display UI cards, receive contextual information from the host application,
   * and perform actions in the host application (See:
   * https://developers.google.com/gsuite/add-ons/overview for more information).
   * A Google Workspace Add-on deployment resource specifies metadata about the
   * add-on, including a specification of the entry points in the host application
   * that trigger add-on executions (see:
   * https://developers.google.com/gsuite/add-ons/concepts/gsuite-manifests).
   * Add-on deployments defined via the Google Workspace Add-ons API define their
   * entrypoints using HTTPS URLs (See:
   * https://developers.google.com/gsuite/add-ons/guides/alternate-runtimes),
   * A Google Workspace Add-on deployment can be installed in developer mode,
   * which allows an add-on developer to test the experience an end-user would see
   * when installing and running the add-on in their G Suite applications.  When
   * running in developer mode, more detailed error messages are exposed in the
   * add-on UI to aid in debugging.
   * A Google Workspace Add-on deployment can be published to Google Workspace
   * Marketplace, which allows other Google Workspace users to discover and
   * install the add-on.  See:
   * https://developers.google.com/gsuite/add-ons/how-tos/publish-add-on-overview
   * for details.
   * </pre>
   */
  public static final class GSuiteAddOnsFutureStub extends io.grpc.stub.AbstractFutureStub<GSuiteAddOnsFutureStub> {
    private GSuiteAddOnsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GSuiteAddOnsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GSuiteAddOnsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets the authorization information for deployments in a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.Authorization> getAuthorization(
        com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuthorizationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a deployment with the specified name and configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.Deployment> createDeployment(
        com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates or replaces a deployment with the specified name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.Deployment> replaceDeployment(
        com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReplaceDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the deployment with the specified name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.Deployment> getDeployment(
        com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all deployments in a particular project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse> listDeployments(
        com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDeploymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes the deployment with the given name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteDeployment(
        com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Installs a deployment in developer mode.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> installDeployment(
        com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInstallDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Uninstalls a developer mode deployment.
     * See:
     * https://developers.google.com/gsuite/add-ons/how-tos/testing-gsuite-addons.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> uninstallDeployment(
        com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUninstallDeploymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Fetches the install status of a developer mode deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.gsuiteaddons.v1.InstallStatus> getInstallStatus(
        com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstallStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_AUTHORIZATION = 0;
  private static final int METHODID_CREATE_DEPLOYMENT = 1;
  private static final int METHODID_REPLACE_DEPLOYMENT = 2;
  private static final int METHODID_GET_DEPLOYMENT = 3;
  private static final int METHODID_LIST_DEPLOYMENTS = 4;
  private static final int METHODID_DELETE_DEPLOYMENT = 5;
  private static final int METHODID_INSTALL_DEPLOYMENT = 6;
  private static final int METHODID_UNINSTALL_DEPLOYMENT = 7;
  private static final int METHODID_GET_INSTALL_STATUS = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GSuiteAddOnsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GSuiteAddOnsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_AUTHORIZATION:
          serviceImpl.getAuthorization((com.google.cloud.gsuiteaddons.v1.GetAuthorizationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Authorization>) responseObserver);
          break;
        case METHODID_CREATE_DEPLOYMENT:
          serviceImpl.createDeployment((com.google.cloud.gsuiteaddons.v1.CreateDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment>) responseObserver);
          break;
        case METHODID_REPLACE_DEPLOYMENT:
          serviceImpl.replaceDeployment((com.google.cloud.gsuiteaddons.v1.ReplaceDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment>) responseObserver);
          break;
        case METHODID_GET_DEPLOYMENT:
          serviceImpl.getDeployment((com.google.cloud.gsuiteaddons.v1.GetDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.Deployment>) responseObserver);
          break;
        case METHODID_LIST_DEPLOYMENTS:
          serviceImpl.listDeployments((com.google.cloud.gsuiteaddons.v1.ListDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.ListDeploymentsResponse>) responseObserver);
          break;
        case METHODID_DELETE_DEPLOYMENT:
          serviceImpl.deleteDeployment((com.google.cloud.gsuiteaddons.v1.DeleteDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_INSTALL_DEPLOYMENT:
          serviceImpl.installDeployment((com.google.cloud.gsuiteaddons.v1.InstallDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNINSTALL_DEPLOYMENT:
          serviceImpl.uninstallDeployment((com.google.cloud.gsuiteaddons.v1.UninstallDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_INSTALL_STATUS:
          serviceImpl.getInstallStatus((com.google.cloud.gsuiteaddons.v1.GetInstallStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gsuiteaddons.v1.InstallStatus>) responseObserver);
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

  private static abstract class GSuiteAddOnsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GSuiteAddOnsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gsuiteaddons.v1.GSuiteAddOnsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GSuiteAddOns");
    }
  }

  private static final class GSuiteAddOnsFileDescriptorSupplier
      extends GSuiteAddOnsBaseDescriptorSupplier {
    GSuiteAddOnsFileDescriptorSupplier() {}
  }

  private static final class GSuiteAddOnsMethodDescriptorSupplier
      extends GSuiteAddOnsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GSuiteAddOnsMethodDescriptorSupplier(String methodName) {
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
      synchronized (GSuiteAddOnsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GSuiteAddOnsFileDescriptorSupplier())
              .addMethod(getGetAuthorizationMethod())
              .addMethod(getCreateDeploymentMethod())
              .addMethod(getReplaceDeploymentMethod())
              .addMethod(getGetDeploymentMethod())
              .addMethod(getListDeploymentsMethod())
              .addMethod(getDeleteDeploymentMethod())
              .addMethod(getInstallDeploymentMethod())
              .addMethod(getUninstallDeploymentMethod())
              .addMethod(getGetInstallStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
