package com.google.cloud.cloudcontrolspartner.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/cloudcontrolspartner/v1beta/core.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudControlsPartnerCoreGrpc {

  private CloudControlsPartnerCoreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.cloudcontrolspartner.v1beta.CloudControlsPartnerCore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Workload> getGetWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkload",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Workload> getGetWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest, com.google.cloud.cloudcontrolspartner.v1beta.Workload> getGetWorkloadMethod;
    if ((getGetWorkloadMethod = CloudControlsPartnerCoreGrpc.getGetWorkloadMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getGetWorkloadMethod = CloudControlsPartnerCoreGrpc.getGetWorkloadMethod) == null) {
          CloudControlsPartnerCoreGrpc.getGetWorkloadMethod = getGetWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest, com.google.cloud.cloudcontrolspartner.v1beta.Workload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.Workload.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("GetWorkload"))
              .build();
        }
      }
    }
    return getGetWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> getListWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloads",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> getListWorkloadsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> getListWorkloadsMethod;
    if ((getListWorkloadsMethod = CloudControlsPartnerCoreGrpc.getListWorkloadsMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getListWorkloadsMethod = CloudControlsPartnerCoreGrpc.getListWorkloadsMethod) == null) {
          CloudControlsPartnerCoreGrpc.getListWorkloadsMethod = getListWorkloadsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloads"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("ListWorkloads"))
              .build();
        }
      }
    }
    return getListWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Customer> getGetCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomer",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.Customer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Customer> getGetCustomerMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest, com.google.cloud.cloudcontrolspartner.v1beta.Customer> getGetCustomerMethod;
    if ((getGetCustomerMethod = CloudControlsPartnerCoreGrpc.getGetCustomerMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getGetCustomerMethod = CloudControlsPartnerCoreGrpc.getGetCustomerMethod) == null) {
          CloudControlsPartnerCoreGrpc.getGetCustomerMethod = getGetCustomerMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest, com.google.cloud.cloudcontrolspartner.v1beta.Customer>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.Customer.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("GetCustomer"))
              .build();
        }
      }
    }
    return getGetCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> getListCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomers",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> getListCustomersMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> getListCustomersMethod;
    if ((getListCustomersMethod = CloudControlsPartnerCoreGrpc.getListCustomersMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getListCustomersMethod = CloudControlsPartnerCoreGrpc.getListCustomersMethod) == null) {
          CloudControlsPartnerCoreGrpc.getListCustomersMethod = getListCustomersMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("ListCustomers"))
              .build();
        }
      }
    }
    return getListCustomersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> getGetEkmConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEkmConnections",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> getGetEkmConnectionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest, com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> getGetEkmConnectionsMethod;
    if ((getGetEkmConnectionsMethod = CloudControlsPartnerCoreGrpc.getGetEkmConnectionsMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getGetEkmConnectionsMethod = CloudControlsPartnerCoreGrpc.getGetEkmConnectionsMethod) == null) {
          CloudControlsPartnerCoreGrpc.getGetEkmConnectionsMethod = getGetEkmConnectionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest, com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEkmConnections"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("GetEkmConnections"))
              .build();
        }
      }
    }
    return getGetEkmConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> getGetPartnerPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPartnerPermissions",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> getGetPartnerPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest, com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> getGetPartnerPermissionsMethod;
    if ((getGetPartnerPermissionsMethod = CloudControlsPartnerCoreGrpc.getGetPartnerPermissionsMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getGetPartnerPermissionsMethod = CloudControlsPartnerCoreGrpc.getGetPartnerPermissionsMethod) == null) {
          CloudControlsPartnerCoreGrpc.getGetPartnerPermissionsMethod = getGetPartnerPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest, com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPartnerPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("GetPartnerPermissions"))
              .build();
        }
      }
    }
    return getGetPartnerPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> getListAccessApprovalRequestsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAccessApprovalRequests",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> getListAccessApprovalRequestsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> getListAccessApprovalRequestsMethod;
    if ((getListAccessApprovalRequestsMethod = CloudControlsPartnerCoreGrpc.getListAccessApprovalRequestsMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getListAccessApprovalRequestsMethod = CloudControlsPartnerCoreGrpc.getListAccessApprovalRequestsMethod) == null) {
          CloudControlsPartnerCoreGrpc.getListAccessApprovalRequestsMethod = getListAccessApprovalRequestsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest, com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAccessApprovalRequests"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("ListAccessApprovalRequests"))
              .build();
        }
      }
    }
    return getListAccessApprovalRequestsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Partner> getGetPartnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPartner",
      requestType = com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest.class,
      responseType = com.google.cloud.cloudcontrolspartner.v1beta.Partner.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest,
      com.google.cloud.cloudcontrolspartner.v1beta.Partner> getGetPartnerMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest, com.google.cloud.cloudcontrolspartner.v1beta.Partner> getGetPartnerMethod;
    if ((getGetPartnerMethod = CloudControlsPartnerCoreGrpc.getGetPartnerMethod) == null) {
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        if ((getGetPartnerMethod = CloudControlsPartnerCoreGrpc.getGetPartnerMethod) == null) {
          CloudControlsPartnerCoreGrpc.getGetPartnerMethod = getGetPartnerMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest, com.google.cloud.cloudcontrolspartner.v1beta.Partner>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPartner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.cloudcontrolspartner.v1beta.Partner.getDefaultInstance()))
              .setSchemaDescriptor(new CloudControlsPartnerCoreMethodDescriptorSupplier("GetPartner"))
              .build();
        }
      }
    }
    return getGetPartnerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CloudControlsPartnerCoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreStub>() {
        @java.lang.Override
        public CloudControlsPartnerCoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudControlsPartnerCoreStub(channel, callOptions);
        }
      };
    return CloudControlsPartnerCoreStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudControlsPartnerCoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreBlockingStub>() {
        @java.lang.Override
        public CloudControlsPartnerCoreBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudControlsPartnerCoreBlockingStub(channel, callOptions);
        }
      };
    return CloudControlsPartnerCoreBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CloudControlsPartnerCoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CloudControlsPartnerCoreFutureStub>() {
        @java.lang.Override
        public CloudControlsPartnerCoreFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CloudControlsPartnerCoreFutureStub(channel, callOptions);
        }
      };
    return CloudControlsPartnerCoreFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Gets details of a single workload
     * </pre>
     */
    default void getWorkload(com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Workload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists customer workloads for a given customer org id
     * </pre>
     */
    default void listWorkloads(com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single customer
     * </pre>
     */
    default void getCustomer(com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Customer> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCustomerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists customers of a partner identified by its Google Cloud organization ID
     * </pre>
     */
    default void listCustomers(com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListCustomersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the EKM connections associated with a workload
     * </pre>
     */
    default void getEkmConnections(com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEkmConnectionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the partner permissions granted for a workload
     * </pre>
     */
    default void getPartnerPermissions(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPartnerPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists access requests associated with a workload
     * </pre>
     */
    default void listAccessApprovalRequests(com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAccessApprovalRequestsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get details of a Partner.
     * </pre>
     */
    default void getPartner(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Partner> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPartnerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudControlsPartnerCore.
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static abstract class CloudControlsPartnerCoreImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CloudControlsPartnerCoreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudControlsPartnerCore.
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerCoreStub
      extends io.grpc.stub.AbstractAsyncStub<CloudControlsPartnerCoreStub> {
    private CloudControlsPartnerCoreStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerCoreStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerCoreStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets details of a single workload
     * </pre>
     */
    public void getWorkload(com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Workload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists customer workloads for a given customer org id
     * </pre>
     */
    public void listWorkloads(com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single customer
     * </pre>
     */
    public void getCustomer(com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Customer> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists customers of a partner identified by its Google Cloud organization ID
     * </pre>
     */
    public void listCustomers(com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the EKM connections associated with a workload
     * </pre>
     */
    public void getEkmConnections(com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEkmConnectionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the partner permissions granted for a workload
     * </pre>
     */
    public void getPartnerPermissions(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPartnerPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists access requests associated with a workload
     * </pre>
     */
    public void listAccessApprovalRequests(com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAccessApprovalRequestsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get details of a Partner.
     * </pre>
     */
    public void getPartner(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Partner> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPartnerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudControlsPartnerCore.
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerCoreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudControlsPartnerCoreBlockingStub> {
    private CloudControlsPartnerCoreBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerCoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerCoreBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets details of a single workload
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.Workload getWorkload(com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists customer workloads for a given customer org id
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse listWorkloads(com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single customer
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.Customer getCustomer(com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists customers of a partner identified by its Google Cloud organization ID
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse listCustomers(com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the EKM connections associated with a workload
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections getEkmConnections(com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEkmConnectionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the partner permissions granted for a workload
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions getPartnerPermissions(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPartnerPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists access requests associated with a workload
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse listAccessApprovalRequests(com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAccessApprovalRequestsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get details of a Partner.
     * </pre>
     */
    public com.google.cloud.cloudcontrolspartner.v1beta.Partner getPartner(com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPartnerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudControlsPartnerCore.
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class CloudControlsPartnerCoreFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudControlsPartnerCoreFutureStub> {
    private CloudControlsPartnerCoreFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudControlsPartnerCoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudControlsPartnerCoreFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Gets details of a single workload
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.Workload> getWorkload(
        com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists customer workloads for a given customer org id
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse> listWorkloads(
        com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single customer
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.Customer> getCustomer(
        com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists customers of a partner identified by its Google Cloud organization ID
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse> listCustomers(
        com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the EKM connections associated with a workload
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections> getEkmConnections(
        com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEkmConnectionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the partner permissions granted for a workload
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions> getPartnerPermissions(
        com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPartnerPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists access requests associated with a workload
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse> listAccessApprovalRequests(
        com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAccessApprovalRequestsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get details of a Partner.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.cloudcontrolspartner.v1beta.Partner> getPartner(
        com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPartnerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_WORKLOAD = 0;
  private static final int METHODID_LIST_WORKLOADS = 1;
  private static final int METHODID_GET_CUSTOMER = 2;
  private static final int METHODID_LIST_CUSTOMERS = 3;
  private static final int METHODID_GET_EKM_CONNECTIONS = 4;
  private static final int METHODID_GET_PARTNER_PERMISSIONS = 5;
  private static final int METHODID_LIST_ACCESS_APPROVAL_REQUESTS = 6;
  private static final int METHODID_GET_PARTNER = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_GET_WORKLOAD:
          serviceImpl.getWorkload((com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Workload>) responseObserver);
          break;
        case METHODID_LIST_WORKLOADS:
          serviceImpl.listWorkloads((com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse>) responseObserver);
          break;
        case METHODID_GET_CUSTOMER:
          serviceImpl.getCustomer((com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Customer>) responseObserver);
          break;
        case METHODID_LIST_CUSTOMERS:
          serviceImpl.listCustomers((com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse>) responseObserver);
          break;
        case METHODID_GET_EKM_CONNECTIONS:
          serviceImpl.getEkmConnections((com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections>) responseObserver);
          break;
        case METHODID_GET_PARTNER_PERMISSIONS:
          serviceImpl.getPartnerPermissions((com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions>) responseObserver);
          break;
        case METHODID_LIST_ACCESS_APPROVAL_REQUESTS:
          serviceImpl.listAccessApprovalRequests((com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse>) responseObserver);
          break;
        case METHODID_GET_PARTNER:
          serviceImpl.getPartner((com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.cloudcontrolspartner.v1beta.Partner>) responseObserver);
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
          getGetWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.GetWorkloadRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.Workload>(
                service, METHODID_GET_WORKLOAD)))
        .addMethod(
          getListWorkloadsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.ListWorkloadsResponse>(
                service, METHODID_LIST_WORKLOADS)))
        .addMethod(
          getGetCustomerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.GetCustomerRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.Customer>(
                service, METHODID_GET_CUSTOMER)))
        .addMethod(
          getListCustomersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.ListCustomersResponse>(
                service, METHODID_LIST_CUSTOMERS)))
        .addMethod(
          getGetEkmConnectionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.GetEkmConnectionsRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.EkmConnections>(
                service, METHODID_GET_EKM_CONNECTIONS)))
        .addMethod(
          getGetPartnerPermissionsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerPermissionsRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.PartnerPermissions>(
                service, METHODID_GET_PARTNER_PERMISSIONS)))
        .addMethod(
          getListAccessApprovalRequestsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.ListAccessApprovalRequestsResponse>(
                service, METHODID_LIST_ACCESS_APPROVAL_REQUESTS)))
        .addMethod(
          getGetPartnerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.cloudcontrolspartner.v1beta.GetPartnerRequest,
              com.google.cloud.cloudcontrolspartner.v1beta.Partner>(
                service, METHODID_GET_PARTNER)))
        .build();
  }

  private static abstract class CloudControlsPartnerCoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudControlsPartnerCoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.cloudcontrolspartner.v1beta.CoreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudControlsPartnerCore");
    }
  }

  private static final class CloudControlsPartnerCoreFileDescriptorSupplier
      extends CloudControlsPartnerCoreBaseDescriptorSupplier {
    CloudControlsPartnerCoreFileDescriptorSupplier() {}
  }

  private static final class CloudControlsPartnerCoreMethodDescriptorSupplier
      extends CloudControlsPartnerCoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudControlsPartnerCoreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudControlsPartnerCoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CloudControlsPartnerCoreFileDescriptorSupplier())
              .addMethod(getGetWorkloadMethod())
              .addMethod(getListWorkloadsMethod())
              .addMethod(getGetCustomerMethod())
              .addMethod(getListCustomersMethod())
              .addMethod(getGetEkmConnectionsMethod())
              .addMethod(getGetPartnerPermissionsMethod())
              .addMethod(getListAccessApprovalRequestsMethod())
              .addMethod(getGetPartnerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
